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
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;

public final class __practitionerquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/PractitionerQueryCriteria.jsp", 1720596984612L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link></html></head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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

//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;
String function_id="";
String nat_id_prompt="";//Added for MOHE-CRF-0019 by Kamatchi S 12-JUN-2020
try {
	//con = (Connection) session.getValue( "connection" );
	con = ConnectionManager.getConnection(request);	
function_id =request.getParameter("function_id");
if(function_id == null) function_id="";

//Below line added for ML-MMOH-CRF-0862
boolean isCernerpractitioner=CommonBean.isSiteSpecific(con, "AM","CERNER_PRACTITIONER_ID");
	
boolean isFPPPractApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","FULL_PAYING_PATIENT_PRACT");//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184

//Added for MOHE-CRF-0019 by Kamatchi S 12-JUN-2020
boolean isPractOtherStaff = isPractOtherStaff = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","PRACT_OTHER_STAFF");
nat_id_prompt=eAM.AMCommonBean.getNationalIDPrompt(con); 
if(nat_id_prompt.equals("")) nat_id_prompt=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.NationalIDNo.label","am_labels");


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
firstItem.add("Text");  		 //Type of item

//Below line added for ML-MMOH-CRF-0862

if(isCernerpractitioner){
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EmId.label","common_labels"));	  // label
}else{
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels"));	  // label
}
firstItem.add("practitioner_id");	//name of field
firstItem.add("15");	// SIZE
firstItem.add("15");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels"));	  // label
secondItem.add("practitioner_name");	//name of field
secondItem.add("28");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();
fifthItem.add("Text");  		 //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.primaryspeciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
fifthItem.add("primary_speciality_code");	//name of field
fifthItem.add("4");	// SIZE
fifthItem.add("4");	//LENGTH

finAr.add(fifthItem);//add to ArrayList obj finAr

ArrayList sixthItem = new ArrayList();
sixthItem.add("Text");  		 //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.primaryspeciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
sixthItem.add("primary_speciality_desc");	//name of field
sixthItem.add("15");	// SIZE
sixthItem.add("15");	//LENGTH

finAr.add(sixthItem);//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("List");  		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels"));	  // label
thirdItem.add("pract_type");	//name of field
thirdItem.add("select 'All' pract_type,'All' Desc_Userdef from dual union select pract_type,Desc_Userdef from am_pract_type where eff_status='E' and (trunc(sysdate)) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and (nvl(trunc(eff_date_to), to_date('31/12/5000','dd/mm/rrrr'))) order by Desc_Userdef");
finAr.add(thirdItem);//add to ArrayList obj finAr

ArrayList fourthItem1 = new ArrayList();
fourthItem1.add("List");   //Type of item
fourthItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Position.label","common_labels"));  // label
fourthItem1.add("POSITION_CODE");//name
fourthItem1.add("select POSITION_CODE,POSITION_DESC from am_position where role_type = 'P' and eff_status='E' order by 2");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fourthItem1); //add to ArrayList obj finAr

ArrayList fourthItem2 = new ArrayList();
fourthItem2.add("List");   //Type of item
fourthItem2.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EmplStatus.label","common_labels"));  // label
fourthItem2.add("empl_status");//name
fourthItem2.add("'',-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----,S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels")+",V,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.VisitingSpecialist.label","am_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fourthItem2); 
//add to ArrayList obj finAr
ArrayList fourthItem3=null;
ArrayList fourthItem4=null;
/*Added for MOHE-CRF-0019 by Kamatchi S 12-JUN-2020*/
ArrayList eighthItem= new ArrayList();
ArrayList eighthItem1= new ArrayList();

if(isPractOtherStaff)
	{
if(function_id.equals("PRACTITIONER"))
{
 fourthItem3 = new ArrayList();
fourthItem3.add("List");   //Type of item
fourthItem3.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels"));  // label
fourthItem3.add("all_facilities_yn");//name
fourthItem3.add("'',---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fourthItem3); //add to ArrayList obj finAr

 fourthItem4 = new ArrayList();
fourthItem4.add("List");   //Type of item
fourthItem4.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.RepFacility.label","am_labels"));  // label
fourthItem4.add("reporting_facility_id");//name
fourthItem4.add("select facility_id,facility_name from sm_facility_param where facility_type='F' and STATUS ='E' order by facility_name");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fourthItem4); //add to ArrayList obj finAr
	}

/*Added for MOHE-CRF-0019 by Kamatchi S 12-JUN-2020*/

eighthItem.add("Text");  		 //Type of item
eighthItem.add(nat_id_prompt);	  // label
eighthItem.add("National_ID");	//name of field
eighthItem.add("15");	// SIZE
eighthItem.add("20");  //LENGTH
finAr.add(eighthItem);


eighthItem1.add("Text");  		 //Type of item
eighthItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","common_labels"));	  // label
eighthItem1.add("OTHER_ALT_NO");	//name of field
eighthItem1.add("15");	// SIZE
eighthItem1.add("20");  //LENGTH
finAr.add(eighthItem1);

/*End of MOHE-CRF-0019*/
	}

ArrayList fourthItem = new ArrayList();
//ArrayList valItem=new ArrayList();
fourthItem.add("List");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fourthItem.add("eff_status");//name
fourthItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList fifth1Item = new ArrayList();
//ArrayList valItem=new ArrayList();
fifth1Item.add("List");   //Type of item
fifth1Item.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExternalPractitioner.label","common_labels"));  // label
fifth1Item.add("function_id");//name
fifth1Item.add("PRACTITIONER,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+",EXT_PRACT,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fifth1Item); //add to ArrayList obj finAr
 //Added by N Munisekhar on 25-July-2013 against MMS-QH-CRF-0104 [IN:039242]
boolean isSiteSpecific=eOP.QMSInterface.isSiteSpecific(con,"AM","AM_PRACT_EMP");
if (isSiteSpecific){
ArrayList sixth = new ArrayList();
sixth.add("Text");  		 //Type of item
sixth.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EmployeeID.label","common_labels"));	  // label
sixth.add("Employee_Id");	//name of field
sixth.add("30");	// SIZE
sixth.add("30");	//LENGTH
finAr.add(sixth);
}

/*Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184 Start*/
ArrayList seventh = new ArrayList();
if(isFPPPractApplicable){
	seventh.add("List");
	seventh.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FPP.label","common_labels"));
	seventh.add("FPP_Pract");
	seventh.add("'',--" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--,Y," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));
	finAr.add(seventh);
}
/*End*/

//End of MMS-QH-CRF-0104 [IN:039242]
String orderByCols[] = new String[5];
String orderByColVals[] = new String[5];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels");
orderByCols[2] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.primaryspeciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.primaryspeciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels");



orderByColVals[0] = "a.practitioner_id";
orderByColVals[1] = "a.practitioner_name";
orderByColVals[2] = "c.speciality_code";
orderByColVals[3] = "c.long_desc";
orderByColVals[4] = "b.desc_sysdef";

strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"Find Practitioner","../../eAM/jsp/PractitionerQueryResult.jsp?function_id1="+function_id,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString().replace("nowrap",""));
if(firstItem!=null)
firstItem.clear();
if(secondItem!=null)
secondItem.clear();
if(thirdItem!=null)
thirdItem.clear();
if(finAr!=null)
finAr.clear();
if(fifthItem!=null)
fifthItem.clear();
if(fourthItem!=null)
fourthItem.clear();
if(fourthItem1!=null)
fourthItem1.clear();
if(fourthItem2!=null)
fourthItem2.clear();
if(fourthItem3!=null)
fourthItem3.clear();
if(fourthItem4!=null)
fourthItem4.clear();
if(sixthItem!=null)
sixthItem.clear();
if(seventh!=null)
seventh.clear();
if(eighthItem!=null)
eighthItem.clear();
if(eighthItem1!=null)
eighthItem1.clear();
} catch (Exception e) {
	
	out.println("Excepiton in function "+e);
	



}

finally{
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
