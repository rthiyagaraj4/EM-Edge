package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __closeconsultation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CloseConsultation.jsp", 1738424804440L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\'CONS_NOT_APPL\',\'CA\'));\n\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\n\t\t\t\t<script> \n\t\t\t\t\t\t\t$(document).ready(function () {\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"==\"Y\"){\n\t\t\t\t\t\t\tshowPendingOrderWindow();\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tframes[1].location.href=\'../../eOP/jsp/PatCheckoutModel.jsp?called_from=CA&module_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&ae_brought_dead_yn=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&ae_treatment_area_code=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&encounterid=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&practitionerid=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&locationcode=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&patientid=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&locationtype=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&episode_id=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&visit_id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&allow_chkout_with_bill_stmt_yn=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}); \n\t\n\tasync function showPendingOrderWindow(){\n\t\tvar arguments\t= \"\";\n\t\tvar dialogHeight= \"29\" ;\n\t\tvar dialogTop = \"125\" ;\n\t\tvar dialogWidth\t= \"50\" ;\n\t\tvar status = \"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status  + \"; dialogTop :\" + dialogTop ;\n\t\tvar url=\"../../eOR/jsp/ViewPendingOrders.jsp?patient_id=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&encounter_id=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&facility_id=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&discharge_ind=C\";\n\n\t\t if(\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" ==\"Y\"){\n\t\t\tif(\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"==\"Y\"){ \n\t\t\t\t\tvar retVal = new String();\n\t\t\t\t\tretVal = await window.showModalDialog(url,arguments,features);\n\t\t\t\t\tif(window.confirm(getMessage(\"PROCEED_CHECKOUT\",\"AE\"))) {\n\t\t\t\t\t\tframes[1].location.href=\'../../eOP/jsp/PatCheckoutModel.jsp?called_from=CA&module_id=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\';\n\t\t\t\t\t}\n\t\t\t}else{\n\t\t\t\tif(window.confirm(getMessage(\"ORDER_PENDING_CNT_PROCEED_VIEW\",\"IP\"))) {\n\t\t\t\t\tvar retVal = new String();\n\t\t\t\t\tretVal = await window.showModalDialog(url,arguments,features);\n\t\t\t\t}\n\t\t\t}\n\t\t}else{\n\t\t\tframes[1].location.href=\'../../eOP/jsp/PatCheckoutModel.jsp?called_from=CA&module_id=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\';\t\t\t\t\t\t\t\n\t\t}\n\t}\n\t\t\t\t</script>\t\t\t\t\n\t\t\t\t<form name=\"chkoutmodel\" id=\"chkoutmodel\">\n\t\t\t\t<frameset rows=\'0%,88%,0%\' framespacing=0 id=\"checkOutFrames\">\n\t\t    \t\t<frame name=\'PLINE\' id=\'PLINE\' SRC=\'../../eCommon/html/blank.html\' noresize  frameborder=no scrolling=\'no\'>\n\t\t\t\t\t<!--Modified By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start-->\n\t\t\t\t\t<!--<frame name=\'detail\' id=\'detail\' src=\'../../eOP/jsp/PatCheckoutModel.jsp?called_from=CA&module_id=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=\'no\'> -->\n\t\t\t\t\t<frame name=\'detail\' id=\'detail\' SRC=\'../../eCommon/html/blank.html\' noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=\'no\'>\n\t\t\t\t\t<!--Modified By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End-->\n\t\t\t\t\t<frame name=\'Dummy_frame\' id=\'Dummy_frame\' src=\'../../eCommon/html/blank.html\' framesetborder=0 frameborder=0 noresize scrolling=\'no\'>\n        \t\t</frameset>\n\t\t\t\t</form>\n\t\t\t\t<!--Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start-->\n\t\t\t\t\n\t\t\t\t\t<!--Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End-->\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\n\t\t\t\t</html>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String encounter_id= request.getParameter("episode_id");	
		String facility_id=(String) session.getValue("facility_id");
		String practitioner_id="";
		String location_code=request.getParameter("location_code");	
		String location_type=request.getParameter("location_type");	
		String patient_id=request.getParameter("patient_id");	

		int visit_status =0;
		String ae_episode_yn ="";
		String ae_brought_dead_yn="";
		String ae_treatment_area_code="";
		String module_id="";
		String episode_id = "";
		String visit_id   = "";
		String allow_chkout_with_bill_stmt_yn = "N";
		/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
		String chk_for_pen_orders_bfr_chkout	= "N";
		String checkout_allow_yn				= "N";
		String pend_ord_stats					= "N";
		/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/

		PreparedStatement stmt1=null;
		ResultSet rs1=null;

		PreparedStatement stmt=null;
		ResultSet rs=null;
		Connection con=null;
	
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		//String sql="Select visit_status,attend_practitioner_id,ae_episode_yn,brought_dead_yn,episode_id, op_episode_visit_num   from pr_encounter where facility_id  = '"+facility_id+"' and encounter_id = "+encounter_id+" ";//common-icn-0180
	    String sql="Select visit_status,attend_practitioner_id,ae_episode_yn,brought_dead_yn,episode_id, op_episode_visit_num   from pr_encounter where facility_id  = ? and encounter_id = ? ";//common-icn-0180
	
		String ConsOrdChartYn = request.getParameter("ConsOrdChartYn") == null ? "N" : request.getParameter("ConsOrdChartYn");//added for package billing
		if(ConsOrdChartYn.equals("N")){
		try
			{
				con=ConnectionManager.getConnection(request);
				stmt1=con.prepareStatement(sql);
				//common-icn-0180 starts
				stmt1.setString(1, facility_id);
				stmt1.setString(2, encounter_id);
				//common-icn-0180 end
				rs1=stmt1.executeQuery();

				if(rs1!=null)
				{
					while(rs1.next()){
						visit_status=rs1.getInt(1);
						practitioner_id=rs1.getString(2);
						ae_episode_yn=rs1.getString(3);
						ae_brought_dead_yn=rs1.getString(4);
						if(ae_brought_dead_yn==null) ae_brought_dead_yn="N";
						episode_id = rs1.getString("episode_id");
						if(episode_id==null) episode_id="";
						visit_id   = rs1.getString("op_episode_visit_num");
						if(visit_id==null) visit_id="";

					}
				}
				if(rs1!=null) rs1.close();
				if(stmt1!=null) stmt1.close();
/*                
				String sql_ae1="Select allow_chkout_with_bill_stmt_yn from AE_PARAM where OPERATING_FACILITY_ID='"+facility_id+"'";
					stmt=con.prepareStatement(sql_ae1);
					rs=stmt.executeQuery();

					if(rs!=null)
					{
					  if (rs.next())
				      {
						allow_chkout_with_bill_stmt_yn=rs.getString("allow_chkout_with_bill_stmt_yn");
   					    if(allow_chkout_with_bill_stmt_yn==null) allow_chkout_with_bill_stmt_yn="N";
					  }
					}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
*/

				if(ae_episode_yn.equals("Y"))
				{
					/*Modified By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
					//String sql_ae1="Select allow_chkout_with_bill_stmt_yn from AE_PARAM where OPERATING_FACILITY_ID='"+facility_id+"'";
					//String sql_ae1="Select allow_chkout_with_bill_stmt_yn,chk_for_pen_orders_bfr_chkout,checkout_allow_yn,(select Or_patient_Order_Pend('"+patient_id+"','"+facility_id+"','"+encounter_id+"','C') from dual) pend_ord_stats from AE_PARAM where OPERATING_FACILITY_ID='"+facility_id+"'";//common-icn-0180
					/*Modified By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/
					String sql_ae1="Select allow_chkout_with_bill_stmt_yn,chk_for_pen_orders_bfr_chkout,checkout_allow_yn,(select Or_patient_Order_Pend(?,?,?,'C') from dual) pend_ord_stats from AE_PARAM where OPERATING_FACILITY_ID=?";//common-icn-0180
					
					System.err.println("sql_ae1==>"+sql_ae1);
						stmt=con.prepareStatement(sql_ae1);
						//common-icn-0180 starts
						stmt.setString(1, patient_id);
						stmt.setString(2, facility_id);
						stmt.setString(3, encounter_id);
						stmt.setString(4, facility_id);
						//common-icn-0180 ends
						rs=stmt.executeQuery();

						if(rs!=null)
						{
						  if (rs.next())
						  {
							allow_chkout_with_bill_stmt_yn=rs.getString("allow_chkout_with_bill_stmt_yn");
							if(allow_chkout_with_bill_stmt_yn==null) allow_chkout_with_bill_stmt_yn="N";
							/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
							chk_for_pen_orders_bfr_chkout =rs.getString("chk_for_pen_orders_bfr_chkout");
							if(chk_for_pen_orders_bfr_chkout==null) chk_for_pen_orders_bfr_chkout="N";
							checkout_allow_yn =rs.getString("checkout_allow_yn");
							if(checkout_allow_yn==null) checkout_allow_yn="N";
							pend_ord_stats =rs.getString("pend_ord_stats");
							if(pend_ord_stats==null) pend_ord_stats="N";
							/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/
						  }
						}
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();		
					
					module_id="AE";
					/*String sql_ae1="Select brought_dead_yn from ae_pat_emergency_detail where facility_id='"+facility_id+"' and encounter_id="+encounter_id+" ";
					stmt=con.prepareStatement(sql_ae1);
					rs=stmt.executeQuery();

					if(rs!=null)
					{
						while(rs.next())
						{
							ae_brought_dead_yn=rs.getString(1);
//							if(ae_brought_dead_yn==null) ae_brought_dead_yn="N";
						}
					}*/

				//String sql_ae2="Select treatment_area_code from op_patient_queue where facility_id='"+facility_id+"' and encounter_id="+encounter_id+" ";//common-icn-0180 starts
					String sql_ae2="Select treatment_area_code from op_patient_queue where facility_id=? and encounter_id=? ";//common-icn-0180 starts
					
					stmt=con.prepareStatement(sql_ae2);
					//common-icn-0180 starts starts
					stmt.setString(1, facility_id);
					stmt.setString(2, encounter_id);
					//common-icn-0180 starts ends
					rs=stmt.executeQuery();

					if(rs!=null)
					{
						while(rs.next())
						{
							ae_treatment_area_code=rs.getString(1);
						}
					}

				}
				else
					module_id="OP";

				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();


				if(rs1==null ||  visit_status>=7)
				{
						
            _bw.write(_wl_block8Bytes, _wl_block8);
} 

				else {
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(chk_for_pen_orders_bfr_chkout));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ae_brought_dead_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ae_treatment_area_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(allow_chkout_with_bill_stmt_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pend_ord_stats));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(checkout_allow_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ae_brought_dead_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ae_treatment_area_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(allow_chkout_with_bill_stmt_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ae_brought_dead_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ae_treatment_area_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(allow_chkout_with_bill_stmt_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ae_brought_dead_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ae_treatment_area_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(allow_chkout_with_bill_stmt_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block30Bytes, _wl_block30);

				}
				
			}catch(Exception e)
			{
				//out.println("Exception::"+e);//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				if(stmt!=null) stmt.close();
				if(rs!=null) rs.close();

				if(stmt1!=null) stmt1.close();
				if(rs1!=null) rs1.close();
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}
		}else{//added for package billing
			out.println("<script>top.content.CommonToolbar.displayFunctionName('');alert(getMessage('CLOSE_CONSULT_SPLTY','OP'));parent.CommonToolbar.ShowMenu.style.display='none';parent.CommonToolbar.HideMenu.style.display='inline';parent.workArea.cols = '200px,0%,*,0%';</script>");
		}
					
            _bw.write(_wl_block31Bytes, _wl_block31);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
