package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __queryprocunitpage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/queryProcUnitPage.jsp", 1715319923392L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n    <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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

	request.setCharacterEncoding("UTF-8");

request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);

    //String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
    //String params = request.getQueryString() ;
    //String source = url + params ;
	String function_id = request.getParameter("function_id");
	

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;

	Connection con=null ;
	Statement stmt=null; 
	ResultSet	rs = null;
	try {
		con  =  ConnectionManager.getConnection(request);
		stmt = con.createStatement();

	String facilityid=(String)session.getValue("facility_id");
	String function = request.getParameter("function");

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");           //Type of item

	if(function.equals("DaycareUnit"))
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycareunitcode.label","common_labels"));     // label
	else	
	   firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ProcedureUnitCode.label","op_labels"));

	firstItem.add("clinic_code");   //name of field
	firstItem.add("4"); // SIZE
	firstItem.add("4"); //LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");          //Type of item

	if(function.equals("DaycareUnit"))
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycareunitdesc.label","common_labels"));
	else
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ProcedureUnitDescription.label","op_labels"));     // label

	secondItem.add("long_desc");    //name of field
	secondItem.add("30");   // SIZE
	secondItem.add("30");   //LENGTH

	finAr.add(secondItem);//add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");           //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialtyCode.label","common_labels"));     // label
	thirdItem.add("speciality_code");   //name of field
	thirdItem.add("4");
	thirdItem.add("4");

	finAr.add(thirdItem);//add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");   //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialtyDescription.label","common_labels"));  // label
	fourthItem.add("short_desc");//name
	fourthItem.add("15");
	fourthItem.add("15");

	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList sixthItem = new ArrayList();
	sixthItem.add("List");  		 //Type of item

	if(function.equals("DaycareUnit"))
		{ 
	   sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels"));	  // label
	sixthItem.add("proc_type");	//name of field
	sixthItem.add("select locn_type,short_desc from am_care_locn_type where (care_locn_type_ind='D') order by 2");
		}
	else
		{
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ProcedureUnitType.label","op_labels"));
	sixthItem.add("proc_type");	//name of field
	sixthItem.add("select locn_type,short_desc from am_care_locn_type where (care_locn_type_ind='E') order by 2");
		}
	finAr.add(sixthItem); //add to ArrayList obj finAr

	ArrayList seventhItem = new ArrayList();
	seventhItem.add("List");  		 //Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.agegroup.label","common_labels"));	  // label
	seventhItem.add("age_group_code");	//name of field
	seventhItem.add("select age_group_code,short_desc from am_age_group where eff_status='E' order by 2");
	finAr.add(seventhItem); //add to ArrayList obj finAr


	ArrayList eighthItem = new ArrayList();
	eighthItem.add("List");   //Type of item
	eighthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.levelofcare.label","common_labels"));  // label
	eighthItem.add("level_of_care_ind");//name
	eighthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ambulatory.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels"));//static values that need to be displayed as 
	finAr.add(eighthItem); //add to ArrayList obj finAr


	ArrayList ninethItem = new ArrayList();
	ninethItem.add("List");  		 //Type of item
	ninethItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels"));	  // label
	ninethItem.add("dept_code");	//name of field
	ninethItem.add("select dept_code,short_desc from am_dept where eff_status='E' order by 2");
	finAr.add(ninethItem); //add to ArrayList obj finAr

	ArrayList tenthItem = new ArrayList();
	tenthItem.add("Text");  		 //Type of item
	tenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels"));	  // label
	tenthItem.add("service_code");	//name of field
	tenthItem.add("4");
	tenthItem.add("4");
		
	finAr.add(tenthItem); //add to ArrayList obj finAr

	ArrayList eleventhItem = new ArrayList();
	eleventhItem.add("List");  		 //Type of item
	eleventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FileStorageLocation.label","common_labels"));	  // label
	eleventhItem.add("fs_locn_code");	//name of field
	eleventhItem.add("select fs_locn_code,short_desc from fm_storage_locn where eff_status='E' and facility_id ='"+facilityid+"' order by 2");

	ArrayList itemserviceshortdesc = new ArrayList();
	itemserviceshortdesc.add("Text");  		 //Type of item
	itemserviceshortdesc.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels"));	  // label
	itemserviceshortdesc.add("service_short_desc");	//name of field
	itemserviceshortdesc.add("15");
    itemserviceshortdesc.add("15");
    finAr.add(itemserviceshortdesc);
	
	ArrayList twelvethItem = new ArrayList();
	twelvethItem.add("List");  		 //Type of item
	twelvethItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.PrimaryResourceClass.label","op_labels"));	  // label
	twelvethItem.add("res_class");	//name of field
	if(function.equals("DaycareUnit"))
	twelvethItem.add("R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels")+",,");
	else
		twelvethItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels"));

	finAr.add(twelvethItem); //add to ArrayList obj finAr
	ArrayList thirteenthItem = new ArrayList();
	thirteenthItem.add("List");   //Type of item
	thirteenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.CheckinIdentification.label","op_labels"));  // label
	thirteenthItem.add("ident_at_checkin");//name
	if(function.equals("DaycareUnit"))
		thirteenthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",X,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.NotIdentifiable.label","op_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
	else
		thirteenthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",X,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.NotIdentifiable.label","op_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resource.label","common_labels"));
	finAr.add(thirteenthItem); //add to ArrayList obj finAr


	rs = stmt.executeQuery("select install_yn from sm_module where module_id = 'FM'");
	String fm_install_yn="";
	if (rs!=null && rs.next())
		 fm_install_yn=rs.getString(1);

	if(rs != null) rs.close();

	ArrayList fifthItem1 = new ArrayList();

	if (fm_install_yn.equals("Y")){
			
			fifthItem1.add("List");   //Type of item
			fifthItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AutoFileRequest.label","common_labels"));  // label
			fifthItem1.add("online_mr_notfn_yn");//name
			fifthItem1.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
			finAr.add(fifthItem1); //add to ArrayList obj finAr
	}
	ArrayList fifthItem = new ArrayList();
	fifthItem.add("List");   //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	fifthItem.add("eff_status");//name
	fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(fifthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];

	if(function.equals("DaycareUnit"))
		{
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycareunitcode.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycareunitdesc.label","common_labels");
		}else
		{
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ProcedureUnitCode.label","op_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ProcedureUnitDescription.label","op_labels");

		}
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialtyCode.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialtyDescription.label","common_labels");


	orderByColVals[0] = "clinic_code";
	orderByColVals[1] = "a.long_desc";
	orderByColVals[2] = "b.speciality_code";
	orderByColVals[3] = "b.short_desc";

	strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"Find Procedure Unit","../../eOP/jsp/queryProcUnit.jsp?function_id="+function_id+"&function="+function,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString().replaceAll("nowrap",""));

	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	fifthItem1.clear();
	sixthItem.clear();
	seventhItem.clear();
	eighthItem.clear();
	ninethItem.clear();
	tenthItem.clear();
	eleventhItem.clear();
	twelvethItem.clear();
	thirteenthItem.clear();
	itemserviceshortdesc.clear();
	finAr.clear();




	if(stmt!=null)stmt.close();

	}
	catch(Exception e ){
		e.printStackTrace();
		}
	finally
	{
		// Added by Raj when dealing with unclosed connections, statements and resultsets on 10/17/2003
		if(con!=null) ConnectionManager.returnConnection(con,request); 
	}

	
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
