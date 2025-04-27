package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.*;
import java.sql.Types;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;

public final class __dsreportsmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/DSReportsMain.jsp", 1710143938000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n\n\t<script src=\"../../eCommon/js/dchk.js\" ></script>\n\t<script src=\"../../eCommon/js/common.js\" ></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" ></script>\n</head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<script src=\"../../eDS/js/Rep_MealDistributionList.js\" ></script>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<script src=\"../../eDS/js/Rep_MasterCodeList.js\" ></script>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/CommercialFormula.js\"></Script>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/AttendMealList.js\"></Script>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/StaffMealOrderList.js\"></Script>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/CancelledOrderList.js\"></Script>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/NewAdmissionList.js\"></Script>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/DSCommercialFormulaDistribution.js\"></Script>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/DsMealList.js\"></Script>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/SpecialFoodRequire.js\"></Script>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/DsWorkList.js\"></Script>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/MenuforDietType.js\"></Script>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/BirthdayList.js\"></Script>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/MealItemRejection.js\"></Script>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/DietTypeMovement.js\"></Script>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/MealOrderList.js\"></Script>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/DailyStatistics.js\"></Script>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/RepMonthlyStatistics.js\"></Script>\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/YearlyStatistics.js\"></Script>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/MealTickets.js\"></Script>\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/SpecialFoodTickets.js\"></Script>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/OPMealOrderList.js\"></Script>\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/MealTicket_OP_EM.js\"></Script>\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/MealAcknowledgeReport.js\"></Script>\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/MealAcknowledgeReportOPAndEM.js\"></Script>\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/DSSupplementaryMealtickets.js\"></Script>\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/DocAcknowledgeReportForStaff.js\"></Script>\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/MealRejection.js\"></Script>\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/MealTicketsForStaff.js\"></Script>\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/MealProductionSummary.js\"></Script>\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/FloorFeedType.js\"></Script>\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<Script Language=\"JavaScript\" src=\"../../eDS/js/MedicalFoodOrder.js\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\n<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" frameborder=\'0\' scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t<iframe scrolling=\"no\" name=\'f_query_rep\' id=\'f_query_rep\' src=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="  frameborder=0 style=\'height:84vh;width:100vw\'></iframe>\n\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:8vh;width:100vw\'></iframe>\n\t<iframe name=\'dummy_rep_frame\' id=\'dummy_rep_frame\' src=\"../../eCommon/html/blank.html\" frameborder=0 noresize scrolling=\'no\' style=\'height:0vh;width:100vw\'></iframe>\n</html>\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

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
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String function_id = request.getParameter("function_id");
	String source = url + params ;
	String url_name = "";

	if(function_id.equals("DSR_MEAL_DISTR_LIST")){
		url_name = "Rep_MealDistributionList.jsp";
            _bw.write(_wl_block5Bytes, _wl_block5);
}

	else if(function_id.equals("DSR_MASTER_REPORT")){
		url_name = "Rep_MasterCodeList.jsp";
            _bw.write(_wl_block6Bytes, _wl_block6);
}


	else if(function_id.equals("DSR_COMM_FORMULA_LIST")){
		url_name = "CommercialFormulaReportCud.jsp"; 
            _bw.write(_wl_block7Bytes, _wl_block7);
}
	else if(function_id.equals("DSR_ATTND_MEAL_LIST")){
		url_name = "AttendMealListCud.jsp"; 
            _bw.write(_wl_block8Bytes, _wl_block8);
}
	else if(function_id.equals("DSR_STAFFORD_LIST")){
		url_name = "StaffMealOrderList.jsp"; 
            _bw.write(_wl_block9Bytes, _wl_block9);
} //PMG2013-CRF-0009.1-US003 Start
	else if(function_id.equals("DSR_CAN_ORD_LIST")){
		url_name = "CancelledOrderList.jsp"; 
            _bw.write(_wl_block10Bytes, _wl_block10);
} //PMG2013-CRF-0009.1-US003 End
	else if(function_id.equals("DSR_NEW_ADD_LIST")){
		url_name = "RepNewAdmissionListCud.jsp"; 
            _bw.write(_wl_block11Bytes, _wl_block11);
}

	else if(function_id.equals("DSR_COMM_FORMULA_DIST_LIST")){
		url_name = "DSCommercialFormulaDistribution.jsp"; 
            _bw.write(_wl_block12Bytes, _wl_block12);
}
	else if(function_id.equals("DSR_MEAL_LIST")){
		url_name = "DSMeallistReport.jsp"; 
            _bw.write(_wl_block13Bytes, _wl_block13);
}
	else if(function_id.equals("DSR_SP_FOOD_REQD")){
		url_name = "SpecialFoodRequire.jsp"; 
            _bw.write(_wl_block14Bytes, _wl_block14);
}
	else if(function_id.equals("DSR_WORKLIST")){
		url_name = "DSWorklistReport.jsp"; 
            _bw.write(_wl_block15Bytes, _wl_block15);
}
	else if(function_id.equals("DSR_MENU_FOR_DIET_TYPE")){
		url_name = "MenuforDietType.jsp"; 
            _bw.write(_wl_block16Bytes, _wl_block16);
}
	 else if(function_id.equals("DSR_BIRTHDAY_LIST")){
		url_name = "BirthdayList.jsp"; 
            _bw.write(_wl_block17Bytes, _wl_block17);
}
    else if(function_id.equals("DSR_MEAL_ITEM_REJECTIONS")){
		url_name = "MealItemRejection.jsp"; 
            _bw.write(_wl_block18Bytes, _wl_block18);
}
	 else if(function_id.equals("DSR_DIET_TYPE_MOVEMENT")){
		url_name = "DietTypeMovement.jsp"; 
            _bw.write(_wl_block19Bytes, _wl_block19);
}
	 else if(function_id.equals("DSR_MEAL_ORDER_LIST")){
		url_name = "MealOrderList.jsp"; 
            _bw.write(_wl_block20Bytes, _wl_block20);
}
	 else if(function_id.equals("DSR_DAILY_STATISTICS")){
		url_name = "DailyStatisticsCud.jsp"; 
            _bw.write(_wl_block21Bytes, _wl_block21);
}
	 else if(function_id.equals("DSR_MONTHLY_STATISTICS")){
		url_name = "RepMonthlyStatisticsCud.jsp"; 
            _bw.write(_wl_block22Bytes, _wl_block22);
}
	 else if(function_id.equals("DSR_YEARLY_STATISTICS")){
		url_name = "YearlyStatisticsCud.jsp"; 
            _bw.write(_wl_block23Bytes, _wl_block23);
}
	 else if(function_id.equals("DSR_MEAL_TICKETS")){
		url_name = "MealTicketsCud.jsp"; 
            _bw.write(_wl_block24Bytes, _wl_block24);
}//MMS-DM-CRF-0044
	 else if(function_id.equals("DSR_MEAL_TICKETS_FR_ATTENDANT")){
		url_name = "MealTicketsAttendantsCud.jsp"; 
            _bw.write(_wl_block24Bytes, _wl_block24);
}//MMS-DM-CRF-0044
	 else if(function_id.equals("DSR_SPL_FOOD_TICKET")){
		url_name = "SpecialFoodTicketsCud.jsp"; 
            _bw.write(_wl_block25Bytes, _wl_block25);
}
	 else if(function_id.equals("DSR_MEAL_ORDER_LIST_OP")){
		url_name = "OPMealOrderList.jsp"; 
            _bw.write(_wl_block26Bytes, _wl_block26);
}	//MMOH-CRF-0407
	 else if(function_id.equals("DSR_MEAL_TICKET_OP_EM_PATIENT")){
		url_name = "MealTicketForOPAndEMPatient.jsp"; 
            _bw.write(_wl_block27Bytes, _wl_block27);
}	//MMOH-CRF-0407
	//ML-MMOH-CRF-0413_US1
	 else if(function_id.equals("DSR_MEAL_ACKNOWLEDGE_REPORT")){
		url_name = "MealAcknowledgeReport.jsp"; 
            _bw.write(_wl_block28Bytes, _wl_block28);
}	//ML-MMOH-CRF-0413_US1
	//ML-MMOH-CRF-0413_US8
	 else if(function_id.equals("DSR_MEAL_ACK_REP_FOR_OP_EM_PAT")){
		url_name = "MealAcknowledgeReportOPAndEM.jsp"; 
            _bw.write(_wl_block29Bytes, _wl_block29);
}//ML-MMOH-CRF-0413_US8
	//MMS-QH-CRF- 0079_US11
	 else if(function_id.equals("DSR_SUPPLEMENTARY_MEAL_TICKET")){
		url_name = "DSSupplementaryMealtickets.jsp"; 
            _bw.write(_wl_block30Bytes, _wl_block30);
}//MMS-QH-CRF- 0079_US11
	//ML-MMOH-CRF-0730_US02
	 else if(function_id.equals("DSR_DOC_ACK_REP_FOR_STAFF")){
		url_name = "DocAcknowledgeReportForStaff.jsp"; 
            _bw.write(_wl_block31Bytes, _wl_block31);
}//ML-MMOH-CRF-0730_US02
	//ML-MMOH-CRF-0599_US01
	 else if(function_id.equals("DS_REJECTED_MEALS")){
		url_name = "MealRejection.jsp"; 
            _bw.write(_wl_block32Bytes, _wl_block32);
}//ML-MMOH-CRF-0599_US01
	
	//ML-MMOH-CRF-0675_US01
	else if(function_id.equals("DSR_MEAL_TICKET_STAFF")){
		url_name = "MealTicketForStaff.jsp"; 
            _bw.write(_wl_block33Bytes, _wl_block33);
}//ML-MMOH-CRF-0675_US01
	
	//ML-MMOH-CRF-0680
	else if(function_id.equals("DSR_MEAL_PROD_SUMM")){
		url_name = "MealProductionSummary.jsp"; 
            _bw.write(_wl_block34Bytes, _wl_block34);
}//ML-MMOH-CRF-0680	
	 //KDAH-CRF-0351
	 else if(function_id.equals("DSR_FLR_FEED_TYPE")){
		url_name = "FloorFeedType.jsp"; 
            _bw.write(_wl_block35Bytes, _wl_block35);
}//KDAH-CRF-0351
	//ML-MMOH-CRF-0598
	 else if(function_id.equals("DSR_MED_FOOD_ORD_LST")){
		url_name = "MedicalFoodOrder.jsp"; 
            _bw.write(_wl_block36Bytes, _wl_block36);
}//ML-MMOH-CRF-0598
	url_name="../../eDS/jsp/"+url_name+"?"+params;

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(source ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(url_name));
            _bw.write(_wl_block39Bytes, _wl_block39);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
