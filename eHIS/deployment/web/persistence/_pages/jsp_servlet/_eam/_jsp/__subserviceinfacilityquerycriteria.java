package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __subserviceinfacilityquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/SubserviceinfacilityQueryCriteria.jsp", 1709113924005L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link></html></head>\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );
 ArrayList  finAr;
	 ArrayList firstItem;
	 ArrayList secondItem;
	 ArrayList thirdItem;
	 ArrayList fourthItem;
	 ArrayList fifthItem;
	 ArrayList sixthItem;
	 ArrayList seventhItem ;
	 ArrayList eightItem;
	 ArrayList ninthItem;
	 ArrayList tenthItem;
	 ArrayList eleventhItem;

 

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
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;

try 
{
	con = ConnectionManager.getConnection(request) ;
	finAr = new ArrayList();

	firstItem = new ArrayList();
		firstItem.add("Text");  		//Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels") );		// label
		firstItem.add("operating_facility_id");	//name of field
		firstItem.add("2");			// SIZE
		firstItem.add("2");			//LENGTH
		finAr.add(firstItem);			//add to ArrayList obj finAr

	secondItem = new ArrayList();
		secondItem.add("Text");  		 //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels"));	 // label
		secondItem.add("facility_name");	 //name of field
		secondItem.add("70");			 // SIZE
		secondItem.add("35");	 		 //LENGTH
		finAr.add(secondItem);			 //add to ArrayList obj finAr

	thirdItem = new ArrayList();
		thirdItem.add("Text");   		//Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));  		// label
		thirdItem.add("service_code");		//name
		thirdItem.add("4");			// SIZE
		thirdItem.add("4");			//LENGTH
		//thirdItem.add("B,Both,Y,Yes,N,No");	//static values that need to be displayed as amtion.Send it along with the value that is inserted.
		finAr.add(thirdItem); 			//add to ArrayList obj finAr

	fourthItem = new ArrayList();
		fourthItem.add("Text"); 		//Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")); 	// label
		fourthItem.add("service_short_desc");	//name
		fourthItem.add("15");		 	// SIZE
		fourthItem.add("15");		 	//LENGTH

		//fourthItem.add("B,Both,Y,Yes,N,No");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
		finAr.add(fourthItem); 			//add to ArrayList obj finAr

		fifthItem = new ArrayList();
			fifthItem.add("Text");  	   	//Type of item
			fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.SubServiceCode.label","am_labels"));  		// label
			fifthItem.add("subservice_code");  	//name
			fifthItem.add("4");		   	// SIZE
			fifthItem.add("4");		   	//LENGTH
			//fifthItem.add("B,Both,E,Enabled,D,Disabled");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
			finAr.add(fifthItem); 			//add to ArrayList obj finAr


		sixthItem = new ArrayList();
			sixthItem.add("Text");  		//Type of item
			sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.subservice.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	// label
			sixthItem.add("subservice_short_desc");	//name of field
			sixthItem.add("15");			// SIZE
			sixthItem.add("15");			//LENGTH
			finAr.add(sixthItem);			//add to ArrayList obj finAr

		 seventhItem = new ArrayList();
			seventhItem.add("Text");  		//Type of item
			seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));		// label
			seventhItem.add("dept_code");		//name of field
			seventhItem.add("10");			// SIZE
			seventhItem.add("10");			//LENGTH
			finAr.add(seventhItem);			//add to ArrayList obj finAr

		eightItem = new ArrayList();
			eightItem.add("Text");  		//Type of item
			eightItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	// label
			eightItem.add("dept_short_desc");	//name of field
			eightItem.add("15");			// SIZE
			eightItem.add("15");			//LENGTH
			finAr.add(eightItem);			//add to ArrayList obj finAr


		 ninthItem = new ArrayList();
			ninthItem.add("Text");  		//Type of item
			ninthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels"));	 	// label
			ninthItem.add("section_code");	 	//name of field
			ninthItem.add("6");			// SIZE
			ninthItem.add("6");			//LENGTH
			finAr.add(ninthItem);			//add to ArrayList obj finAr

		 tenthItem = new ArrayList();
			tenthItem.add("Text");  		 //Type of item
			tenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionDescription.label","common_labels"));	  	 // label
			tenthItem.add("section_short_desc");	 //name of field
			tenthItem.add("15");			 // SIZE
			tenthItem.add("15");			 //LENGTH
			finAr.add(tenthItem);			 //add to ArrayList obj finAr

		eleventhItem = new ArrayList();
			eleventhItem.add("List");   		//Type of item
			eleventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels")); 		// label
			eleventhItem.add("eff_status");		//name
			eleventhItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
			eleventhItem.add("1");		  	//LENGTH
			finAr.add(eleventhItem); 		//add to ArrayList obj finAr

String orderByCols[] = new String[10];
String orderByColVals[] = new String[10];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
orderByCols[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels");
orderByCols[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[3]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[4] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.SubServiceCode.label","am_labels");  	
orderByCols[5]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.subservice.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[6]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[7]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[8] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels");
orderByCols[9] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionDescription.label","common_labels");

orderByColVals[0] = "operating_facility_id";
orderByColVals[1] = "facility_name";
orderByColVals[2] = "service_code";
orderByColVals[3] = "service_short_desc";
orderByColVals[4] = "subservice_code";
orderByColVals[5] = "subservice_short_desc";
orderByColVals[6] = "dept_code";
orderByColVals[7] = "dept_short_desc";
orderByColVals[8] = "section_code";
orderByColVals[9] = "section_short_desc";

strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"Find SubService","../../eAM/jsp/SubserviceinfacilityQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Execute.label","common_labels"));

out.println(strbuff.toString());

}
catch (Exception e)
{}
finally
{	
	 finAr.clear();
	 firstItem.clear();
	 secondItem.clear();
	 thirdItem.clear();
	 fourthItem.clear();
	 fifthItem.clear();
	 sixthItem.clear();
	 seventhItem.clear();
	 eightItem.clear();
	 ninthItem.clear();
	 tenthItem.clear();
	 eleventhItem.clear();

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
