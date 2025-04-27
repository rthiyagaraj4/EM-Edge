package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import ePH.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.lang.*;
import java.util.*;
import java.lang.*;
import java.util.*;
import com.ehis.util.*;

public final class __drugschedulequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DrugScheduleQueryCriteria.jsp", 1742369484588L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\t<!--\nFine Tuning\n-->\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'type=\'text/css\'></link>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
 
        request.setCharacterEncoding("UTF-8");
	    //String locale			= (String)session.getAttribute("LOCALE");
	    
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String licenceRights = PhLicenceRights.getKey();
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	try {

		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		String DrugScheduleID = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugScheduleID.label","ph_labels");
		firstItem.add("Text");  		 //Type of item
		firstItem.add(DrugScheduleID);// label
		firstItem.add("schedule_id");//name of field
		firstItem.add("1");	// SIZE
		firstItem.add("2");	//LENGTH
		
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();

		String DrugScheduleDescription = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugScheduleDescription.label","ph_labels");

		secondItem.add("Text");  //Type of item
		secondItem.add(DrugScheduleDescription);  // label
		secondItem.add("schedule_desc");   //name of field
		secondItem.add("22");	// SIZE
		secondItem.add("20");	//LENGTH
		
		finAr.add(secondItem); //add to ArrayList obj finAr

		//==============================================
		ArrayList thirdItem=new ArrayList();
	String AuthorizationRequiredForOrdering = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AuthorizationRequiredForOrdering.label","ph_labels");

		  String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String yes = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
		String No = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
		String tpn_item_list_values="B,"+Both_legend+",Y,"+yes+",N,"+No;
		String Nature_list_values="B,"+Both_legend+",E,"+yes+",D,"+No;
 
		thirdItem.add("List");  //Type of item
		thirdItem.add(AuthorizationRequiredForOrdering);  // label
		thirdItem.add("order_auth_reqd_yn");   //name of field
		thirdItem.add(tpn_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		thirdItem.add("7");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr
		
		//===================================================
		ArrayList fourthItem=new ArrayList();

	 String CosignRequiredForOrdering = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CosignRequiredForOrdering.label","ph_labels");
		fourthItem.add("List");  //Type of item
		fourthItem.add(CosignRequiredForOrdering);  // label
		fourthItem.add("order_cosign_reqd_yn");   //name of field
		fourthItem.add(tpn_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		fourthItem.add("7");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr
		//===================================================
		ArrayList fifthItem=new ArrayList();
        String SpecialApprovalRequired = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialApprovalRequired.label","common_labels");
		fifthItem.add("List");  //Type of item
		fifthItem.add(SpecialApprovalRequired);  // label
		fifthItem.add("spl_appr_reqd_yn");   //name of field
		fifthItem.add(tpn_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		fifthItem.add("7");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr
		//===================================================
		ArrayList sixthItem=new ArrayList();

	   String AllowRefill = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AllowRefill.label","ph_labels");
		sixthItem.add("List");  //Type of item
		sixthItem.add(AllowRefill);  // label
		sixthItem.add("repeat_single_cont_order_yn");   //name of field
		sixthItem.add(tpn_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		sixthItem.add("7");	//LENGTH
		finAr.add(sixthItem); //add to ArrayList obj finAr
		//===================================================
		
		if (!licenceRights.equals("PHBASIC")){
			String AuthorizationRequiredForDispensing = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AuthorizationRequiredForDispensing.label","ph_labels");
			ArrayList seventhItem=new ArrayList();
			seventhItem.add("List");  //Type of item
			seventhItem.add(AuthorizationRequiredForDispensing);  // label
			seventhItem.add("disp_auth_reqd_yn");   //name of field
			seventhItem.add(tpn_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
			seventhItem.add("7");	//LENGTH
			finAr.add(seventhItem); //add to ArrayList obj finAr
		}
		//===================================================
		ArrayList eigthItem=new ArrayList();

        String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		eigthItem.add("List");  //Type of item
		eigthItem.add(Nature);  // label
		eigthItem.add("eff_status");   //name of field
		eigthItem.add(Nature_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		eigthItem.add("7");	//LENGTH
		finAr.add(eigthItem); //add to ArrayList obj finAr
		
		
		//=====================================================================
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = DrugScheduleID;
		orderByCols[1] = DrugScheduleDescription;
				
		
		orderByColVals[0] = "SCHEDULE_ID";
		orderByColVals[1] = "SCHEDULE_DESC";
			
		
 String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String DrugCategory=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugCategory.label","ph_labels");
    
  strbuff = qrypg.getQueryPage(null, finAr, DrugCategory, "DrugScheduleQueryResult.jsp", Sort_order,QueryCriteria,defaultSelect,orderBy, orderByCols, orderByColVals,ExecuteQuery );

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
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
