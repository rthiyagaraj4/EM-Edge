package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __queryreportforfacilityform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/queryReportForFacilityForm.jsp", 1709117460306L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n      <html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link></head><html>\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null;
		try{
        request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);
		String module = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Module.label","common_labels");
		String reportId = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportID.label","common_labels");
		String reportDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportDesc.label","common_labels");
		String facilityId = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
		String facilityName = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
		String reportGroupID = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ReportGroupID.label","sm_labels");
		String reportGroupDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ReportGroupDesc.label","sm_labels");
		ArrayList finAr = new ArrayList();
		ArrayList firstItem = new ArrayList();
		firstItem.add("List");  		 //Type of item
		firstItem.add(module);	  // label
		firstItem.add("Module_Id");	//name of field
		firstItem.add("Select distinct a.Module_Id module_id,a.module_name module_name from Sm_Module a,sm_report b where Install_Yn='Y' and facility_based_yn='Y' and b.module_id=a.module_id order by module_name ");	// SIZE


		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");  		 //Type of item
		secondItem.add(reportId);	  // label
		secondItem.add("Report_ID");	//name of field
		secondItem.add("30");	// SIZE
		secondItem.add("30");	//LENGTH

		finAr.add(secondItem);//add to ArrayList obj finAr

		ArrayList thirdItem = new ArrayList();

		thirdItem.add("Text");  		 //Type of item
		thirdItem.add(reportDesc);	  // label
		thirdItem.add("Report_Desc");	//name of field
		thirdItem.add("60");	// SIZE
		thirdItem.add("60");	//LENGTH

		finAr.add(thirdItem);//add to ArrayList obj finAr

		ArrayList fourthItem = new ArrayList();

		fourthItem.add("Text");  		 //Type of item
		fourthItem.add(facilityId);	  // label
		fourthItem.add("Facility_ID");	//name of field
		fourthItem.add("2");	// SIZE
		fourthItem.add("2");	//LENGTH

		finAr.add(fourthItem);//add to ArrayList obj finAr

		ArrayList fifthItem = new ArrayList();

		fifthItem.add("Text");  		 //Type of item
		fifthItem.add(facilityName);	  // label
		fifthItem.add("Facility_Name");	//name of field
		fifthItem.add("70");	// SIZE
		fifthItem.add("35");	//LENGTH

		finAr.add(fifthItem);//add to ArrayList obj finAr

		ArrayList sixthItem = new ArrayList();

		sixthItem.add("Text");  		 //Type of item
		sixthItem.add(reportGroupID);	  // label
		sixthItem.add("Report_Group_ID");	//name of field
		sixthItem.add("8");	// SIZE
		sixthItem.add("8");	//LENGTH

		finAr.add(sixthItem);//add to ArrayList obj finAr

		ArrayList seventhItem = new ArrayList();

		seventhItem.add("Text");  		 //Type of item
		seventhItem.add(reportGroupDesc);	  // label
		seventhItem.add("Report_Group_Desc");	//name of field
		seventhItem.add("15");	// SIZE
		seventhItem.add("15");	//LENGTH

		finAr.add(seventhItem);//add to ArrayList obj finAr

		String orderByCols[] = new String[7];
		String orderByColVals[] = new String[7];


		orderByCols[0] = module;
		orderByCols[1] = reportId;
		orderByCols[2] = reportDesc;
		orderByCols[3] = facilityId;
		orderByCols[4] = facilityName;
		orderByCols[5] = reportGroupID;
		orderByCols[6] = reportGroupDesc;


		orderByColVals[0] = "Module_name";
		orderByColVals[1] = "Report_Id";
		orderByColVals[2] = "Report_desc";
		orderByColVals[3] = "Facility_id";
		orderByColVals[4] = "Facility_Name";
		orderByColVals[5] = "report_group_id";
		orderByColVals[6] = "REPORT_GROUP_NAME";


		strbuff = qrypg.getQueryPage(con,finAr,"Find Facility Based Report Parameters ","../jsp/queryReportForFacilityTable.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

		out.println(strbuff.toString());

		strbuff.setLength(0);
		finAr.clear();
        firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		fifthItem.clear();
		sixthItem.clear();
		seventhItem.clear();

		}catch(Exception e){out.println(e);}

finally { 
	ConnectionManager.returnConnection(con,request);
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
