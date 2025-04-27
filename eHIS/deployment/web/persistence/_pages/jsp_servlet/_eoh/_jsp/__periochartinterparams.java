package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __periochartinterparams extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/PerioChartInterParams.jsp", 1709119354473L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\n<script>\n\nfunction checkForActiveChart(){\n\tvar formObj\t\t\t\t\t = document.forms[0];\n\tvar patient_id               = formObj.patient_id.value;\n\tvar facility_id              = formObj.facility_id.value;\n\tvar encounter_id             = formObj.encounter_id.value;\n\tvar patient_class            = formObj.patient_class.value;\n\tvar permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;\n\tvar tooth_numbering_system = formObj.tooth_numbering_system.value;\n\tvar chart_num_param               = formObj.chart_num.value;\n\tvar chart_line_num_param               = formObj.chart_line_num.value;\n\tvar cur_chart_num            = formObj.cur_chart_num.value;\n\tvar oh_chart_level            = formObj.oh_chart_level.value;\n\tvar chart_date            = formObj.chart_date.value;\n\tvar chart_close_date            = formObj.chart_close_date.value;\n\tvar added_date            = formObj.added_date.value;\n\tvar other_chart_facility_id            = formObj.other_chart_facility_id.value;\n\tvar other_facilitychart_yn = formObj.other_facilitychart_yn.value;\n\n\tif(cur_chart_num == \"\" || cur_chart_num == \"null\" || cur_chart_num == null){\n\t\tcur_chart_num = \"1\"; \n\t}\n\tvar show_new_active_yn       = formObj.show_new_active_yn.value; // when we are loading for the first time this value will be null\n\tvar insert_new_EC_yn       = formObj.insert_new_EC_yn.value; // when we are loading for the first time this value will be null\n\n\tvar main_tab                 = formObj.main_tab.value;\n\tvar called_from_chart_tab_flag = formObj.called_from_chart_tab_flag.value;\n\tvar perio_chart = formObj.perio_chart.value;\n\tvar perio_arch = formObj.perio_arch.value;\n\tvar baseline_closed_yn = formObj.baseline_closed_yn.value;\n\tvar baseline_active_yn = formObj.baseline_active_yn.value;\n\tvar eval_active_yn = formObj.eval_active_yn.value;\n\tvar disable_record = formObj.disable_record.value;\n\t\n\tvar chart_num = chart_num_param;\n\tvar chart_line_num = chart_line_num_param;\n\n\tif(show_new_active_yn != \"Y\"){\n\t\tshow_new_active_yn = \'N\';\n\t}\n\tif(insert_new_EC_yn != \"Y\"){\n\t\tinsert_new_EC_yn = \'N\';\n\t}\n\t\n\tif((main_tab == \"BaselineChart\" && baseline_closed_yn != \"Y\" && baseline_active_yn != \"Y\") || (main_tab == \"EvaluationChart\" && eval_active_yn != \"Y\" && eval_active_yn != \"N\")){// This shud not be executed when we load chart from LHS menu\n\t\tvar closed_chart_yn = \'N\';\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\n\t\tvar params = \"patient_id=\"+patient_id+\"&perio_chart=\"+perio_chart+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id;\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr +=\" /></root>\";\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",\"PerioCommonValidation.jsp?func_mode=checkForActiveChart&\"+params,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\tif(retVal.length>1){\n\t\t\tvar retVal_arr = retVal.split(\"~\");\n\t\t\tfor(var i=0;i<retVal_arr.length-1;i++){\n\t\t\t\tvar code_desc_arr = retVal_arr[i].split(\"##\");\n\t\t\t\tif(code_desc_arr[0] == \"Y\"){ //active_chart\n\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t\n\t\t\t\t\tchart_num=code_desc_arr[2]; // This chart_num of perticular chart as we may have may active charts at a time..\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tshow_new_active_yn = \"Y\";\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse{\n\t\t\tshow_new_active_yn = \"Y\";\n\t\t}\n\t}\n\telse{\n\t\tchart_num = chart_num_param;\n\t}\n\n\tif(main_tab == \"EvaluationChart\" && eval_active_yn != \"Y\" && eval_active_yn != \"N\"){ // This shud not be executed when we load chart from LHS menu\n\n\t\t//To check the for Active Evaluation Chart and set the parameters..\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest();\n\t\tvar params = \"patient_id=\"+patient_id+\"&perio_chart=\"+perio_chart+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id;\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr +=\" /></root>\";\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",\"PerioCommonValidation.jsp?func_mode=checkForECActiveChart&\"+params,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\tif(retVal.length>1){\n\t\t\tvar retVal_arr = retVal.split(\"~\");\n\t\t\tfor(var i=0;i<retVal_arr.length-1;i++){\n\t\t\t\tvar code_desc_arr = retVal_arr[i].split(\"##\");\n\t\t\t\tif(code_desc_arr[0] == \"Y\"){ //active_chart\n\t\t\t\t\tinsert_new_EC_yn = \'N\';\n\t\t\t\t\tchart_line_num = code_desc_arr[2];\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tinsert_new_EC_yn = \'Y\';\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse{\n\t\t\tinsert_new_EC_yn = \'Y\';\n\t\t}\n\t}\n\n\tformObj.show_new_active_yn.value=show_new_active_yn;\n\tformObj.insert_new_EC_yn.value=insert_new_EC_yn;\n\n\tparams = formObj.params.value; \n\tparams = parent.parent.perioChartMainDummyFrame.document.forms[0].ca_params.value //PerioChartMain\n\n\tchart_hdr_insert_yn=show_new_active_yn;//initialize\n\n\tif(cur_chart_num==\"1\"){\n\t\tchart_hdr_insert_yn=\"Y\";\n\t}\n\n\tformObj.chart_hdr_insert_yn.value=chart_hdr_insert_yn;\n\n\tvar default_head_tab = \"\";\n\n\tif(called_from_chart_tab_flag==null || called_from_chart_tab_flag==\"\"){\n\t\tif(main_tab != \"\" && main_tab != null){ //Main_tab value is the value of the tab (Condition or Treatment) which will be in clicked position when you click on the refresh button.\n\t\t\tif(main_tab == \"EvaluationChart\"){\n\t\t\t\tcalled_from_chart_tab_flag=\"E\";\n\t\t\t}\n\t\t\telse if(main_tab == \"Compare\"){\n\t\t\t\tcalled_from_chart_tab_flag=\"C\";\n\t\t\t}\n\t\t\telse{\n\t\t\t\tcalled_from_chart_tab_flag=\"B\";\n\t\t\t}\n\t\t\tdefault_head_tab = main_tab;\n\t\t}\n\t\telse{\n\t\t\tcalled_from_chart_tab_flag=\"B\";\n\t\t\tdefault_head_tab = \"BaselineChart\";\n\t\t}\n\t\t\n\t}\n\n\tif(main_tab == \"BaselineChart\"){\n\t\tchart_line_num = \"1\";\n\t}\n\n\tparent.parent.perioChartHeaderFrame.document.forms[0].chart_line_num.value = chart_line_num;\n\tparent.parent.perioChartHeaderFrame.document.forms[0].chart_num.value = chart_num;\n\n\tvar\tcalled_from_BC_EV_yn = formObj.called_from_BC_EV_yn.value;\n\tif(called_from_chart_tab_flag==\"E\"){\n\t\tparams=params+\"&show_new_active_yn=\"+show_new_active_yn+\"&chart_num=\"+chart_num+\"&chart_hdr_insert_yn=\"+chart_hdr_insert_yn+\"&header_tab=E&cur_chart_num=\"+cur_chart_num+\"&permanent_deciduous_flag=\"+permanent_deciduous_flag+\"&tooth_numbering_system=\"+tooth_numbering_system+\"&perio_arch=\"+perio_arch+\"&perio_chart=\"+perio_chart+\"&eval_active_yn=\"+eval_active_yn+\"&insert_new_EC_yn=\"+insert_new_EC_yn+\"&chart_line_num=\"+chart_line_num+\"&disable_record=\"+disable_record+\"&called_from_BC_EV_yn=\"+called_from_BC_EV_yn+\"&oh_chart_level=\"+oh_chart_level+\"&chart_date=\"+chart_date+\"&chart_close_date=\"+chart_close_date+\"&added_date=\"+added_date+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&other_facilitychart_yn=\"+other_facilitychart_yn;\n\t\tparent.perioChartRecordFrame.location.href=\"../../eOH/jsp/PerioEvaluationChart.jsp?\"+params; //frames[1]\n\t}\n\telse if(called_from_chart_tab_flag==\"C\"){\n\t\tparams=params+\"&show_new_active_yn=\"+show_new_active_yn+\"&chart_num=\"+chart_num+\"&chart_hdr_insert_yn=\"+chart_hdr_insert_yn+\"&header_tab=C&cur_chart_num=\"+cur_chart_num+\"&permanent_deciduous_flag=\"+permanent_deciduous_flag+\"&tooth_numbering_system=\"+tooth_numbering_system+\"&perio_arch=\"+perio_arch+\"&perio_chart=\"+perio_chart+\"&baseline_closed_yn=\"+baseline_closed_yn+\"&baseline_active_yn=\"+baseline_active_yn+\"&disable_record=\"+disable_record+\"&called_from_BC_EV_yn=\"+called_from_BC_EV_yn+\"&oh_chart_level=\"+oh_chart_level+\"&chart_date=\"+chart_date+\"&chart_close_date=\"+chart_close_date+\"&added_date=\"+added_date+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&other_facilitychart_yn=\"+other_facilitychart_yn;\n\t\tparent.perioChartRecordFrame.location.href=\"../../eOH/jsp/PerioCompareChart.jsp?\"+params; //frames[1]\n\t}\n\telse{\n\t\tparams=params+\"&show_new_active_yn=\"+show_new_active_yn+\"&chart_num=\"+chart_num+\"&chart_hdr_insert_yn=\"+chart_hdr_insert_yn+\"&header_tab=B&cur_chart_num=\"+cur_chart_num+\"&permanent_deciduous_flag=\"+permanent_deciduous_flag+\"&tooth_numbering_system=\"+tooth_numbering_system+\"&perio_arch=\"+perio_arch+\"&perio_chart=\"+perio_chart+\"&baseline_closed_yn=\"+baseline_closed_yn+\"&baseline_active_yn=\"+baseline_active_yn+\"&chart_line_num=\"+chart_line_num+\"&disable_record=\"+disable_record+\"&called_from_BC_EV_yn=\"+called_from_BC_EV_yn+\"&oh_chart_level=\"+oh_chart_level+\"&chart_date=\"+chart_date+\"&chart_close_date=\"+chart_close_date+\"&added_date=\"+added_date+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&other_facilitychart_yn=\"+other_facilitychart_yn;\n\tparent.perioChartRecordFrame.location.href=\"../../eOH/jsp/PerioBaselineChart.jsp?\"+params; //frames[1]\n\t}\n\t\n\t\n}\n\n</script>\n\n<html>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n<form name=\"OHFrameForm\" id=\"OHFrameForm\">\n\t<input type = \"hidden\" name= \"params\" value = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\t<input type = \"hidden\" name= \"cur_chart_num\" value = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t<input type = \"hidden\" name= \"patient_id\" value = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t<input type = \"hidden\" name= \"facility_id\" value = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t<input type = \"hidden\" name= \"encounter_id\" value = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<input type = \"hidden\" name= \"patient_class\" value = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type = \"hidden\" name= \"permanent_deciduous_flag\" value = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type = \"hidden\" name= \"tooth_numbering_system\" value = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t<input type = \"hidden\" name= \"called_from_chart_tab_flag\" value = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t<input type = \"hidden\" name= \"show_new_active_yn\" value = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t<input type = \"hidden\" name= \"insert_new_EC_yn\" value = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t<input type = \"hidden\" name= \"chart_hdr_insert_yn\" value = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t<input type = \"hidden\" name= \"main_tab\" value = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type = \"hidden\" name= \"perio_chart\" value = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type = \"hidden\" name= \"perio_arch\" value = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type = \"hidden\" name= \"chart_num\" value = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type = \"hidden\" name= \"chart_line_num\" value = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type = \"hidden\" name= \"baseline_active_yn\" value = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type = \"hidden\" name= \"baseline_closed_yn\" value = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<input type = \"hidden\" name= \"eval_active_yn\" value = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<input type = \"hidden\" name= \"disable_record\" value = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type = \"hidden\" name= \"oh_chart_level\" value = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type = \"hidden\" name= \"chart_date\" value = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type = \"hidden\" name= \"chart_close_date\" value = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type = \"hidden\" name= \"added_date\" value = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type = \"hidden\" name= \"other_chart_facility_id\" value = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<input type = \"hidden\" name= \"other_facilitychart_yn\" value = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t<input type = \"hidden\" name= \"called_from_BC_EV_yn\" value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\n</form>\n\t<script>\n\t\tcheckForActiveChart();\t\t\n\t</script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\n\n\n\n\n\n\n\n\n\n\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
	request.setCharacterEncoding("UTF-8");	
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String params=request.getQueryString();
	
	String facility_id = (String)session.getValue("facility_id");
	String patient_id = request.getParameter("patient_id");
	String chart_flag = request.getParameter("chart_flag"); // to be passed from the calling place, from CA
	String encounter_id = request.getParameter("encounter_id"); 
	String patient_class = request.getParameter("patient_class"); 
	String main_tab = checkForNull(request.getParameter("main_tab")); 
	String chart_num = checkForNull(request.getParameter("chart_num")); 
	String chart_line_num = checkForNull(request.getParameter("chart_line_num")); 
	String baseline_closed_yn = checkForNull(request.getParameter("baseline_closed_yn")); 
	String baseline_active_yn = checkForNull(request.getParameter("baseline_active_yn")); 
	String eval_active_yn = checkForNull(request.getParameter("eval_active_yn")); 
	String disable_record = checkForNull(request.getParameter("disable_record")); 
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level")); 
	String chart_date = checkForNull(request.getParameter("chart_date"));
	String chart_close_date = checkForNull(request.getParameter("chart_close_date"));
	String added_date = checkForNull(request.getParameter("added_date"));
	String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
	String other_facilitychart_yn = checkForNull(request.getParameter("other_facilitychart_yn"));
	
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag")); 
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system")); 
	String called_from_chart_tab_flag = checkForNull(request.getParameter("called_from_chart_tab_flag")); 
	String show_new_active_yn = checkForNull(request.getParameter("show_new_active_yn"));
	String chart_hdr_insert_yn = checkForNull(request.getParameter("chart_hdr_insert_yn"));
	String insert_new_EC_yn = checkForNull(request.getParameter("insert_new_EC_yn"));
	String perio_chart = checkForNull(request.getParameter("perio_chart"));
	String perio_arch = checkForNull(request.getParameter("perio_arch"));

	String cur_chart_num = "1"; 

	chart_flag=chart_flag==null?"P":chart_flag;
	chart_flag=chart_flag.equals("null")?"P":chart_flag;

	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
	}
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

try{
	con = ConnectionManager.getConnection(request);
	if(!perio_chart.equals("")){
		//Get the Active Chart
		pstmt = con.prepareStatement("SELECT CHART_NUM CUR_CHART_NUM FROM OH_PERIODONTAL_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ?");
		pstmt.setString(1,facility_id);
		pstmt.setString(2,patient_id);
		pstmt.setString(3,perio_chart);
		rs = pstmt.executeQuery();
		while(rs.next()){
			cur_chart_num = rs.getString("CUR_CHART_NUM");
		}
	}


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(params));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(cur_chart_num));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(called_from_chart_tab_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(show_new_active_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(insert_new_EC_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(chart_hdr_insert_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(main_tab));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(perio_chart));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(perio_arch));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(baseline_active_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(baseline_closed_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(eval_active_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(disable_record));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(chart_date));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(chart_close_date));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(added_date));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(other_facilitychart_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(request.getParameter("called_from_BC_EV_yn")));
            _bw.write(_wl_block34Bytes, _wl_block34);

}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}

            _bw.write(_wl_block35Bytes, _wl_block35);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
