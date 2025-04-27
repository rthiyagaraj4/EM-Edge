package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __embalmquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/EmbalmQueryCriteria.jsp", 1709118398353L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n\t\t";
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
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

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
			String function_id = request.getParameter("function_id");
			ArrayList finAr = new ArrayList();
			ArrayList firstItem = new ArrayList();
			String patintid_length="";
			rs=stmt.executeQuery("select patient_id_length from mp_param");
			 if(rs.next()){
			 patintid_length=rs.getString("patient_id_length");
			 }
         
		firstItem.add("Text");           //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels"));     // label
		firstItem.add("patientId");   //name of field
		 firstItem.add(patintid_length); // SIZE
		firstItem.add(patintid_length); //LENGTH

		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");          //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ApplicantID.label","mo_labels"));     // label
		secondItem.add("ApplicantID");    //name of field
		secondItem.add(patintid_length);   // SIZE
		secondItem.add(patintid_length);   //LENGTH

		finAr.add(secondItem);//add to ArrayList obj finAr

		//ArrayList thirdItem = new ArrayList();

		//thirdItem.add("Text");           //Type of item
		//thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialtyCode.label","common_labels"));     // label
		//thirdItem.add("speciality_code");   //name of field
		//thirdItem.add("4");
		//thirdItem.add("4");

		//finAr.add(thirdItem);//add to ArrayList obj finAr

		//ArrayList fourthItem = new ArrayList();

		//fourthItem.add("Text");   //Type of item
		//fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialtyDescription.label","common_labels"));  // label
		//fourthItem.add("short_desc");//name
		//fourthItem.add("15");
		//fourthItem.add("15");

		//finAr.add(fourthItem);  //add to ArrayList obj finAr

		//ArrayList sixthItem = new ArrayList();
		//sixthItem.add("List");  		 //Type of item
		//sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.EmbalmStatus.label","mo_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels"));	  // label
		//sixthItem.add("clinic_type");	//name of field
		//sixthItem.add("select locn_type,short_desc from am_care_locn_type where (care_locn_type_ind='C') order by 2");
		//finAr.add(sixthItem); //add to ArrayList obj finAr

		//ArrayList seventhItem = new ArrayList();
		//seventhItem.add("List");  		 //Type of item
		//seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.agegroup.label","common_labels"));	  // label
		//seventhItem.add("age_group_code");	//name of field
		//seventhItem.add("select age_group_code,short_desc from am_age_group where eff_status='E' order by 2");
		//finAr.add(seventhItem); //add to ArrayList obj finAr


		ArrayList eighthItem = new ArrayList();
		eighthItem.add("List");   //Type of item
		eighthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.EmbalmStatus.label","mo_labels"));  // label
		eighthItem.add("Embalm_Status");//name
		eighthItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",01,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Registered.label","common_labels")+",04,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels")+",09,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.Canceled.label","mo_labels"));//static values that need to be displayed as 
		finAr.add(eighthItem); //add to ArrayList obj finAr


		//ArrayList ninethItem = new ArrayList();
		//ninethItem.add("List");  		 //Type of item
		//ninethItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels"));	  // label
		//ninethItem.add("dept_code");	//name of field
		//ninethItem.add("select dept_code,short_desc from am_dept where eff_status='E' order by 2");
		//finAr.add(ninethItem); //add to ArrayList obj finAr

		
		

		ArrayList tenthItem = new ArrayList();
		tenthItem.add("Date");  		 //Type of item
		tenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.DateofApplication.label","mo_labels"));	  // label
		tenthItem.add("dateofApplication");	//name of field
		tenthItem.add("10");
		tenthItem.add("10");
		finAr.add(tenthItem); //add to ArrayList obj finAr

		//ArrayList eleventhItem = new ArrayList();
		//eleventhItem.add("List");  		 //Type of item
		//eleventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FileStorageLocation.label","common_labels"));	  // label
		//eleventhItem.add("fs_locn_code");	//name of field
		//eleventhItem.add("select fs_locn_code,short_desc from fm_storage_locn where eff_status='E' and facility_id ='"+facilityid+"' order by 2");

		
		//ArrayList twelvethItem = new ArrayList();
		//twelvethItem.add("Text");  		 //Type of item
		//twelvethItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels"));	  // label
		//twelvethItem.add("service_short_desc");	//name of field
		//twelvethItem.add("15");
       // twelvethItem.add("15");

		//finAr.add(twelvethItem); //add to ArrayList obj finAr
		//ArrayList thirteenthItem = new ArrayList();
		//thirteenthItem.add("List");   //Type of item
		//thirteenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.CheckinIdentification.label","op_labels"));  // label
		//thirteenthItem.add("ident_at_checkin");//name
		//thirteenthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+",X,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.NotIdentifiable.label","op_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
		//finAr.add(thirteenthItem); //add to ArrayList obj finAr

		//ArrayList fourteenthItem = new ArrayList();
		//fourteenthItem.add("List");  		 //Type of item
		//fourteenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.PrimaryResourceClass.label","op_labels"));	  // label
		//fourteenthItem.add("res_class");	//name of field
		//fourteenthItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels"));

		//finAr.add(fourteenthItem); 
		rs = stmt.executeQuery("select install_yn from sm_module where module_id = 'FM'");
		String fm_install_yn="";
		if (rs!=null && rs.next())
			 fm_install_yn=rs.getString(1);

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		//ArrayList fifthItem1 = new ArrayList();

		//if (fm_install_yn.equals("Y"))
		//{
		
		//fifthItem1.add("List");   //Type of item
		//fifthItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AutoFileRequest.label","common_labels"));  // label
		//fifthItem1.add("online_mr_notfn_yn");//name
		//fifthItem1.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
		//finAr.add(fifthItem1); //add to ArrayList obj finAr
		//}
		//ArrayList fifthItem = new ArrayList();
		//fifthItem.add("List");   //Type of item
		//fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		//fifthItem.add("eff_status");//name
		//fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
		//finAr.add(fifthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];


		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ApplicantID.label","mo_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.DateofApplication.label","mo_labels");

		orderByColVals[0] = "PATIENT_ID";
		orderByColVals[1] = "REQUESTOR_ID";
	    orderByColVals[2] = "EMBALM_REQ_DATE";
     
	  	strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"Find Clinic","../../eMO/jsp/EmbalmQueryResult.jsp?function=EMBALM&function_id="+function_id,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	//strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"Find Clinic","../../eOP/jsp/QueryClinicResource.jsp?function="+function+"&function_id="+function_id,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		out.println(strbuff.toString());
		 

		firstItem.clear();
		secondItem.clear();
		//thirdItem.clear(); venkat
		//fourthItem.clear();
	//	fifthItem.clear();
		//fifthItem1.clear();
		//sixthItem.clear();
		//seventhItem.clear();
		eighthItem.clear();
		//ninethItem.clear();
		tenthItem.clear();
		//eleventhItem.clear();
		//twelvethItem.clear();
		//thirteenthItem.clear();
		//fourteenthItem.clear();
		finAr.clear();
		orderByCols = null;
		orderByColVals = null;

		if(stmt!=null) stmt.close();

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
