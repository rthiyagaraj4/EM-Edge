package jsp_servlet._eam._jsp;

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
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __medicalteamquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/MedicalTeamQueryCriteria.jsp", 1709113912255L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n\t<html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link></html></head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

ArrayList finAr;
ArrayList firstItem1;
ArrayList firstItem2;
ArrayList firstItem;
ArrayList secondItem;
ArrayList thirdItemaddl;
ArrayList fourthItemaddl;
ArrayList fourthItem;
ArrayList thirdItem;
	


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
            _bw.write(_wl_block1Bytes, _wl_block1);

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
request.setCharacterEncoding("UTF-8"); //Added by Shaik Mujafar for ML-MMOH-CRF-0716
//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
StringBuffer strbuff;
Boolean isMedicalTeamApplicable = false; //Added by Shaik Mujafar for ML-MMOH-CRF-0716
Connection con=null ; //Added by Shaik Mujafar for ML-MMOH-CRF-0716
try
{
	

con = ConnectionManager.getConnection(request); //Added by Shaik Mujafar for ML-MMOH-CRF-0716
isMedicalTeamApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MEDICAL_TEAM_APPLICABLE"); //Added by Shaik Mujafar for ML-MMOH-CRF-0716

finAr = new ArrayList();

firstItem1 = new ArrayList();
	firstItem1.add("Text");  	 	//Type of item
	firstItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));	 	// label
	firstItem1.add("facility_id");	 	//name of field
	firstItem1.add("2");		 	// SIZE
	firstItem1.add("2");		 	//LENGTH
	finAr.add(firstItem1);//add to ArrayList obj finAr

firstItem2 = new ArrayList();
	firstItem2.add("Text");  	 	//Type of item
	firstItem2.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));	 	// label
	firstItem2.add("facility_name");	 	//name of field
	firstItem2.add("70");		 	// SIZE
	firstItem2.add("35");		 	//LENGTH

	finAr.add(firstItem2);//add to ArrayList obj finAr


firstItem = new ArrayList();
	firstItem.add("Text");  	 	//Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TeamID.label","common_labels"));	 	// label
	firstItem.add("team_id");	 	//name of field
	firstItem.add("6");		 	// SIZE
	firstItem.add("6");		 	//LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

 secondItem = new ArrayList();
	secondItem.add("Text");  	 	//Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Team.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	 	// label
	secondItem.add("long_desc");	 	//name of field
	secondItem.add("30");		 	// SIZE
	secondItem.add("30");		 	//LENGTH
finAr.add(secondItem);//add to ArrayList obj finAr

thirdItemaddl=new ArrayList();
	thirdItemaddl.add("Text");  	 	//Type of item
	thirdItemaddl.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	 	// label
	thirdItemaddl.add("speciality_code");	 	//name of field
	thirdItemaddl.add("4");		 	// SIZE
	thirdItemaddl.add("4");		 	//LENGTH

	finAr.add(thirdItemaddl); //add to ArrayList obj finAr

fourthItemaddl=new ArrayList();
	fourthItemaddl.add("Text");  	 	//Type of item
	fourthItemaddl.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	 	// label
	fourthItemaddl.add("speciality_desc");	 	//name of field
	fourthItemaddl.add("15");		 	// SIZE
	fourthItemaddl.add("15");		 	//LENGTH

	finAr.add(fourthItemaddl); //add to ArrayList obj finAr


 fourthItem=new ArrayList();
	fourthItem.add("List");  //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Applicable.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.for.label","common_labels"));  // label
	fourthItem.add("applicable_for"); 	//name of field
	if(isMedicalTeamApplicable) //Added by Shaik Mujafar for ML-MMOH-CRF-0716
	fourthItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatients.label","common_labels")+",I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inpatients.label","common_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MedicalReport.label","mr_labels")+" ");
	else
	fourthItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatients.label","common_labels")+",I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inpatients.label","common_labels")+"");
	
	finAr.add(fourthItem); //add to ArrayList obj finAr


thirdItem=new ArrayList();
	thirdItem.add("List");  //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	thirdItem.add("eff_status");   //name of field
thirdItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");

	finAr.add(thirdItem); //add to ArrayList obj finAr

String orderByCols[] = new String[6];
String orderByColVals[] = new String[6];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TeamID.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Team.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

orderByColVals[0] = "facility_id";
orderByColVals[1] = "facility_name";
orderByColVals[2] = "team_id";
orderByColVals[3] = "long_desc";
orderByColVals[4] = "speciality_code";
orderByColVals[5] = "speciality_desc";


strbuff = qrypg.getQueryPage(con,finAr,"Facility Team","../jsp/MedicalTeamQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
 finAr.clear();
firstItem1.clear();
firstItem2.clear();
firstItem.clear();
secondItem.clear();
thirdItemaddl.clear();
fourthItemaddl.clear();
fourthItem.clear();
thirdItem.clear();
ConnectionManager.returnConnection(con,request); //Added by Shaik Mujafar for ML-MMOH-CRF-0716
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
