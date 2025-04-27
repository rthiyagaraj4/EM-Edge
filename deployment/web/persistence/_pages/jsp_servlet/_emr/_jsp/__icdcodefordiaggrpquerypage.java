package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __icdcodefordiaggrpquerypage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/ICDCodeForDiagGrpQueryPage.jsp", 1709117053311L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="<!--oracle.jdbc.driver.*,-->\n   ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	con=ConnectionManager.getConnection(request);


ArrayList finAr = new ArrayList();

ArrayList firstItem =new ArrayList();

firstItem.add("Text");  //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagGrpCode.label","mr_labels"));  // label
firstItem.add("diag_group_code");   //name of field
firstItem.add("4");	// SIZE
firstItem.add("4");	//LENGTH

finAr.add(firstItem); //add to ArrayList obj finAr



ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagGrpDesc.label","mr_labels"));	  // label
secondItem.add("diag_group_desc");	//name of field
secondItem.add("15");	// SIZE
secondItem.add("15");	//LENGTH 

finAr.add(secondItem);//add to ArrayList obj finAr


ArrayList thirdItem=new ArrayList();

thirdItem.add("Text");  //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ICDCode.label","common_labels"));  // label
thirdItem.add("diag_code");   //name of field
thirdItem.add("5");	// SIZE
thirdItem.add("5");	//LENGTH

finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();

fourthItem.add("Text");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TITLE.label","common_labels"));  // label
fourthItem.add("title_desc");   //name of field
fourthItem.add("30");
fourthItem.add("250");	//LENGTH

finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList fifthItem=new ArrayList();

fifthItem.add("Text");  //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialityCode.label","common_labels"));  // label
fifthItem.add("speciality_code");   //name of field
fifthItem.add("4");
fifthItem.add("4");	//LENGTH

finAr.add(fifthItem); //add to ArrayList obj finAr

ArrayList sixthItem=new ArrayList();

sixthItem.add("Text");  //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SpecialityDesc.label","mp_labels"));  // label
sixthItem.add("speciality_desc");   //name of field
sixthItem.add("15");
sixthItem.add("15");	//LENGTH

finAr.add(sixthItem); //add to ArrayList obj finAr


ArrayList seventhItem=new ArrayList();

seventhItem.add("Text");  //Type of item
seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));  // label
seventhItem.add("facility_id");   //name of field
seventhItem.add("2");
seventhItem.add("2");	//LENGTH

finAr.add(seventhItem); //add to ArrayList obj finAr

ArrayList eightItem=new ArrayList();

eightItem.add("Text");  //Type of item
eightItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));  // label
eightItem.add("facility_name");   //name of field
eightItem.add("30");
eightItem.add("30");	//LENGTH

finAr.add(eightItem); //add to ArrayList obj finAr

ArrayList ninethItem=new ArrayList();

ninethItem.add("Text");  //Type of item
ninethItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels"));  // label
ninethItem.add("practitioner_id");   //name of field
ninethItem.add("15");
ninethItem.add("15");	//LENGTH

finAr.add(ninethItem); //add to ArrayList obj finAr

ArrayList tenthItem=new ArrayList();

tenthItem.add("Text");  //Type of item
tenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels"));  // label
tenthItem.add("practitioner_name");   //name of field
tenthItem.add("30");
tenthItem.add("30");	//LENGTH

finAr.add(tenthItem); //add to ArrayList obj finAr



String orderByCols[] = new String[10];
String orderByColVals[] = new String[10];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagGrpCode.label","mr_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagGrpDesc.label","mr_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ICDCode.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TITLE.label","common_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialityCode.label","common_labels");
orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SpecialityDesc.label","mp_labels");
orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
orderByCols[7] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
orderByCols[8] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels");
orderByCols[9] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels");


orderByColVals[0] = "b.diag_group_code";
orderByColVals[1] = "b.diag_group_desc";
orderByColVals[2] = "c.diag_code";
orderByColVals[3] = "c.short_desc";
orderByColVals[4] = "b.speciality_code";
orderByColVals[5] = "e.short_desc";
orderByColVals[6] = "b.facility_id";
orderByColVals[7] = "f.facility_name";
orderByColVals[8] = "b.practitioner_id";
orderByColVals[9] = "g.practitioner_name";




strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"ICD Code For Tabulation List","../jsp/ICDCodeForDiagGroupQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());

	if ( firstItem != null )  firstItem.clear();
	if ( secondItem != null )  secondItem.clear();
	if ( thirdItem != null )  thirdItem.clear();
	if ( fourthItem != null )  fourthItem.clear();
	if ( fifthItem != null )  fifthItem.clear();
	if ( sixthItem != null )  sixthItem.clear();
	if ( seventhItem != null )  seventhItem.clear();
	if ( eightItem != null )  eightItem.clear();
	if ( ninethItem != null )  ninethItem.clear();
	if ( tenthItem != null )  tenthItem.clear();
	if ( finAr != null )  finAr.clear();


} catch (Exception e) {
		//out.println("Exception "+e.toString());
		e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
