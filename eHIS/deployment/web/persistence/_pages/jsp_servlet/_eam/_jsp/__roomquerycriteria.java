package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __roomquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/RoomQueryCriteria.jsp", 1716957316234L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link></html></head>\n";
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ; 

request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
try
	{
String function_id=request.getParameter("function_id");

con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem1 = new ArrayList();

firstItem1.add("Text");  	//Type of item
firstItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));	// label
firstItem1.add("operating_facility_id");//name of field
firstItem1.add("2");				// SIZE
firstItem1.add("2");				//LENGTH
finAr.add(firstItem1);			//add to ArrayList obj finAr

ArrayList firstItem2 = new ArrayList();

firstItem2.add("Text");  	//Type of item
firstItem2.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));	// label
firstItem2.add("facility_name");//name of field
firstItem2.add("70");				// SIZE
firstItem2.add("35");				//LENGTH
finAr.add(firstItem2);			//add to ArrayList obj finAr

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  	//Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomcubicleno.label","common_labels"));	// label
firstItem.add("room_num");//name of field
firstItem.add("10");				// SIZE
firstItem.add("10");				//LENGTH
finAr.add(firstItem);			//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  	 		//Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoomCubicle.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));// label
secondItem.add("long_desc");	//name of field
secondItem.add("30");					// SIZE
secondItem.add("30");					//LENGTH
finAr.add(secondItem);				//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("List");   		//Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels"));  		// label
thirdItem.add("locn_type");	//name
thirdItem.add("select locn_type,short_desc from am_care_locn_type where care_locn_type_ind in ('R')  order by short_desc");
finAr.add(thirdItem); 			//add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("Text"); 	  			//Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.building.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));  // label
fourthItem.add("bldng_code");			//name
fourthItem.add("6");		 					// SIZE
fourthItem.add("6");		 					//LENGTH

//fourthItem.add("B,Both,Y,Yes,N,No");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(fourthItem); 						//add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("Text");  	   						//Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.building.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
fifthItem.add("bldng_short_desc");  		//name
fifthItem.add("15");		   							// SIZE
fifthItem.add("15");		   							//LENGTH
//fifthItem.add("B,Both,E,Enabled,D,Disabled");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(fifthItem); 									//add to ArrayList obj finAr


ArrayList sixthItem = new ArrayList();

sixthItem.add("Text");  			//Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FloorCode.label","common_labels"));	// label
sixthItem.add("floor_code");	//name of field
sixthItem.add("6");						// SIZE
sixthItem.add("6");						//LENGTH
finAr.add(sixthItem);					//add to ArrayList obj finAr


ArrayList seventhItem = new ArrayList();

seventhItem.add("Text");  		 				//Type of item
seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.FloorDescription.label","am_labels"));	// label
seventhItem.add("floor_short_desc");	//name of field
seventhItem.add("15");			 					// SIZE
seventhItem.add("15");			 					//LENGTH
finAr.add(seventhItem);								//add to ArrayList obj finAr


ArrayList eightItem = new ArrayList();

eightItem.add("List");   				//Type of item
eightItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels")); 				// label
eightItem.add("eff_status");		//name
eightItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
eightItem.add("1");		  				//LENGTH
finAr.add(eightItem); 					//add to ArrayList obj finAr

/*
 The below hidden field is being sent so as to pass function id to the query result page
 which is required for displaying online help .since the same jsp is used in IP ROOM/CUBICLE and AM ROOM both we need function id to distinguish. -Vinod 3/6/2009
*/
ArrayList ninthItem = new ArrayList();

ninthItem.add("Hidden");   		//Type of item
ninthItem.add("function_id"); 	// Name
ninthItem.add(function_id);		//value
finAr.add(ninthItem); 	

String orderByCols[] = new String[9];
String orderByColVals[] = new String[9];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomcubicleno.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoomCubicle.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels");
orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.building.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.building.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[7] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FloorCode.label","common_labels");
orderByCols[8] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.FloorDescription.label","am_labels");

orderByColVals[0] = "a.operating_facility_id";
orderByColVals[1] = "b.facility_name";
orderByColVals[2] = "a.room_num";
//orderByColVals[3] = "a.short_desc"; //Commented on 3/5/2005
orderByColVals[3] = "a.long_desc";
orderByColVals[4] = "a.room_type_desc";
orderByColVals[5] = "a.bldng_code";
orderByColVals[6] = "a.bldng_short_desc";
orderByColVals[7] = "a.floor_code";
orderByColVals[8] = "a.floor_short_desc";

strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"Find Room/Cubicle","../../eAM/jsp/RoomQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString().replace("nowrap",""));
finAr.clear();
	firstItem1.clear();
	firstItem2.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	sixthItem.clear();
	seventhItem.clear();
	eightItem.clear();
}catch(Exception es){
//out.println(es.toString());
es.printStackTrace(System.out);
}
finally { 
	

ConnectionManager.returnConnection(con,request);
}		

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
