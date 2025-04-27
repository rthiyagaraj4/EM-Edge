package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import eCommon.XSSRequestWrapper;
import java.util.*;

public final class __nursingunitquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/NursingUnitQueryCriteria.jsp", 1716545354943L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String locale			= (String)session.getAttribute("LOCALE");
StringBuffer strbuff;
Connection con	= null;
Statement stmt	= null;
ResultSet rs	= null;

try 
{
		con = ConnectionManager.getConnection(request);	
		stmt = con.createStatement();

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NursingUnitCode.label","common_labels"));	  // label
		firstItem.add("nursing_unit_code");	//name of field
		firstItem.add("4");	// SIZE
		firstItem.add("4");	//LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitDescription.label","ip_labels"));  // label
		secondItem.add("long_desc");   //name of field
		secondItem.add("20");	// SIZE
		secondItem.add("30");	//LENGTH
	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));  // label
		thirdItem.add("nursing_unit_type_code");   //name of field
		thirdItem.add("4");	// SIZE
		thirdItem.add("4");	//LENGTH
	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList thirdItem1=new ArrayList();
		thirdItem1.add("Text");  //Type of item
		thirdItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
		thirdItem1.add("nursing_unit_type_desc");   //name of field
		thirdItem1.add("15");	// SIZE
		thirdItem1.add("15");	//LENGTH
	finAr.add(thirdItem1); //add to ArrayList obj finAr

	ArrayList fifthItem1=new ArrayList();
		fifthItem1.add("Text");  //Type of item
		fifthItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));  // label
		fifthItem1.add("dept_code");   //name of field
		fifthItem1.add("10");// SIZE
		fifthItem1.add("10");//LENGTH
	finAr.add(fifthItem1); //add to ArrayList obj finAr

	ArrayList fifthItem2=new ArrayList();
		fifthItem2.add("Text");  //Type of item
		fifthItem2.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
		fifthItem2.add("dept_short_desc");   //name of field
		fifthItem2.add("15");
		fifthItem2.add("15");
	finAr.add(fifthItem2); //add to ArrayList obj finAr

	ArrayList sixthItem=new ArrayList();
		sixthItem.add("Text");  //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels"));  // label
		sixthItem.add("service_code");   //name of field
		sixthItem.add("4");
		sixthItem.add("4");
	finAr.add(sixthItem); //add to ArrayList obj finAr

	ArrayList sixthItem1=new ArrayList();
		sixthItem1.add("Text");  //Type of item
		sixthItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels"));  // label
		sixthItem1.add("service_short_desc");   //name of field
		sixthItem1.add("15");
		sixthItem1.add("15");
	finAr.add(sixthItem1); //add to ArrayList obj finAr

	/*MOIDIFIED TO LEVEL OF CARE CODE ON 25 FEB 2004 by SRIDHAR*/
	ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.levelofcare.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));  // label
		fourthItem.add("level_of_care_code");//name of field
		fourthItem.add("10");
		fourthItem.add("10");
	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList SecfourthItem=new ArrayList();
		SecfourthItem.add("Text");  //Type of item
		SecfourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.levelofcare.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
		SecfourthItem.add("level_of_care_desc");//name of field
		SecfourthItem.add("20");
		SecfourthItem.add("30");
	finAr.add(SecfourthItem); //add to ArrayList obj finAr

	ArrayList seventhItem=new ArrayList();
		seventhItem.add("List");  //Type of item
		seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.agegroup.label","common_labels"));  // label
		seventhItem.add("age_group_code");   //name of field
		seventhItem.add("select age_group_code,short_desc from am_age_group_lang_vw where language_id='"+locale+"' and eff_status = 'E' order by short_desc");
	finAr.add(seventhItem); //add to ArrayList obj finAr

	ArrayList eigthItem=new ArrayList();
		eigthItem.add("List");  //Type of item
		eigthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CheckforSameSexinRoom.label","ip_labels"));  // label
		eigthItem.add("check_same_sex_in_room_yn");   //name of field
		eigthItem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));
	finAr.add(eigthItem); //add to ArrayList obj finAr

	ArrayList ninthItem=new ArrayList();
		ninthItem.add("List");  //Type of item
		ninthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AllowPseudoBeds.label","ip_labels"));  // label
		ninthItem.add("allow_pseudo_bed_srl_yn");   //name of field
		ninthItem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));
	finAr.add(ninthItem); //add to ArrayList obj finAr

	ArrayList tenthItem=new ArrayList();
		tenthItem.add("List");  //Type of item
		tenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		tenthItem.add("eff_status");   //name of field
		tenthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
	finAr.add(tenthItem); //add to ArrayList obj finAr


	//Added BY SRIDHAR on 10 MAY 2004
	//Nursing Unit Applicable To either INPATIENT or DAY CARE 
	ArrayList ApplToDescItem=new ArrayList();
		ApplToDescItem.add("List");			
		ApplToDescItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ApplicableTo.label","common_labels"));
		ApplToDescItem.add("applicable_to");   
		ApplToDescItem.add("select patient_class,short_desc from am_patient_class_lang_vw where  language_id='"+locale+"' and patient_class in('IP','DC') order by short_desc");	
	finAr.add(ApplToDescItem);	



	ArrayList physical_loc = new ArrayList();
		physical_loc.add("Text");  //Type of item
		physical_loc.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PhysicalLocation.label","common_labels"));  // label
		physical_loc.add("physical_location");   //name of field
		physical_loc.add("10");
		physical_loc.add("40");
	finAr.add(physical_loc); //add to ArrayList obj finAr


	/* Hidden field passed to reset() function */
	/* Added on 4/02/2004 by Sridhar */
	/* Enhancement - SECTION & SUBSERVICE Select fields */

	ArrayList hiddenServiceItem=new ArrayList();
		hiddenServiceItem.add("Hidden");				//Type of item
		hiddenServiceItem.add(" ");						// label
		hiddenServiceItem.add("hidden_service_code");	//name of field 
	finAr.add(hiddenServiceItem);						//add to ArrayList obj finAr 

	String orderByCols[] = new String[11];
	String orderByColVals[] = new String[11];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NursingUnitCode.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitDescription.label","ip_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels");
	orderByCols[7] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels");
	orderByCols[8] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.levelofcare.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[9] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.levelofcare.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[10] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PhysicalLocation.label","common_labels");


	orderByColVals[0] = "nursing_unit_code";
	orderByColVals[1] = "nursing_unit_long_desc";
	orderByColVals[2] = "nursing_unit_type_code";
	orderByColVals[3] = "nursing_unit_type_short_desc";
	orderByColVals[4] = "dept_code";
	orderByColVals[5] = "dept_short_desc";
	orderByColVals[6] = "service_code";
	orderByColVals[7] = "service_short_desc";
	orderByColVals[8] = "level_of_care_code";
	orderByColVals[9] = "level_of_care_desc";
	orderByColVals[10] = "physical_location";

	strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"NursingUnit","NursingUnitQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString().replace("nowrap", ""));

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();

}catch (Exception e) 
{
	out.println(e);
}
finally
{
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
