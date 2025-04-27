package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __invokepatienthistorywrapper extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/InvokePatientHistoryWrapper.jsp", 1742453949040L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>\n<TITLE></TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\tfunction openHistory(){\n\t\t/*window.opener = null;\n\t\tself.close();\t\t*/\n\n\t\t/**\n\t\t\tmodified by Deepa on 7/8/2010 at 2:15 PM for IN021079\n\t\t\tthis code prevents the alert that comes in IE8.\n\t\t**/\n\t\t var ie7 = (document.all && !window.opera && window.XMLHttpRequest) ? true : false;  \n\t     if (ie7) \n\t\t {\n\t\t\t   //This method is required to close a window without any prompt for IE7/IE8\n\t\t\t   window.open(\'\',\'_parent\',\'\');\n\t\t\t   window.close();\n           }\n\t\t   else \n           {\n\t\t\t   //This method is required to close a window without any prompt for IE6\n\t\t\t   this.focus();\n\t\t\t   self.opener = this;\n\t\t\t   self.close();\n           }\n\n\n\t\t//window.open(\'http://dsg10:8887/eHIS/eCA/jsp/InvokePatientHistory.jsp?patient_id=UN00000000000008&episode_id=&login_user=NAREN&resp_id=CA&facility_id=GH\',\'eHIS\',\'height=570,width=790,top=0,left=0,resizable=yes,toolbar=no,menubar=no\');\n\t\t\n\t\t//IN066218 Start.\n\t\t//window.open(\'../../eCA/jsp/InvokePatientHistory.jsp?patient_id=";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="&mode=";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="&facility_id=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&responsibility_id=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&login_user=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&login_pwd=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&accession_num=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&accession_type=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&episode_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&encounter_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&limit_function_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&locale=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&note_type=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&contr_mod_accession_num=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&function_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&show_others_unsinged_yn=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&senior_radiologist_yn=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'eHIS\',\'location=0,height=700,width=1015,top=0,left=0,resizable=yes\');\t// added \'show_others_unsinged_yn\', \'senior_radiologist_yn\' for ML-BRU-SCF-1588 [IN054952]\n\t\t//window.open(\'../../eCA/jsp/InvokePatientHistory.jsp?patient_id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'eHIS\',\'location=0,height=700,width=1015,top=0,left=0,resizable=yes\');\tPrakash\n// 28843 \tStart\t\n\t\tvar  screenHeight=screen.height;\n\t\tvar  screenWidth=screen.width;\n\t\tvar features =\"location=0,height=\"+screenHeight+\",width=\"+screenWidth+\",top=0,left=0,resizable=yes\";\n\t\t//window.open(\'../../eCA/jsp/InvokePatientHistory.jsp?patient_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&p_review_rad_yn=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&request_num=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&request_line_num=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&updateRDExamViewRequest=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'eHIS\',\'location=0,height=700,width=1015,top=0,left=0,resizable=yes\');//IN071561\t\n\t\twindow.open(\'../../eCA/jsp/InvokePatientHistory.jsp?patient_id=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&archivalYN=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',\'eHIS\',features);\t\n// 28843  End.\t\n\t\t//IN066218 End.\n\t}\n\n</script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script><Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n</HEAD>\n<BODY onload=\'openHistory();\' onKeyDown=\'lockKey()\'>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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

/*
----------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------
19/08/2015	IN054952		Karthi L											ML-BRU-SCF-1588
19/01/2018  IN066218  		PRATHYUSHA P	28/1/2018		Ramesh G			ML-MMOH-CRF-0985.1
03/02/2020			IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
08/06/2020	IN073001		Ramesh Goli		08/06/2020		Ramesh G			PMG2019-GHL-CRF-0003.2
03/05/2022	28843			Ramesh Goli		03/05/2022		Ramesh GH			NMC-JD-CRF-0155
----------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

System.out.println("1----------------->InvokePatientHistoryWrapper.jsp");
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String limit_function_id = request.getParameter("limit_function_id") == null ? "" : request.getParameter("limit_function_id");

	//String queryString = request.getQueryString()== null?"":request.getQueryString();
	String login_id = request.getParameter("p_login_user") == null ? "" : request.getParameter("p_login_user");
	String login_pwd = request.getParameter("p_user_password") == null ? "" : request.getParameter("p_user_password");
	String mode = request.getParameter("mode") == null ? "V" : request.getParameter("mode");
	
	String facility_id = request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
	String resp_id = request.getParameter("p_resp_id") == null ? "" : request.getParameter("p_resp_id");
	String patient_id = request.getParameter("p_patient_id") == null ? "" : request.getParameter("p_patient_id");

	//String episode_id = request.getParameter("p_episode_id") == null ? "" : request.getParameter("p_episode_id");
	String encounter_id = request.getParameter("p_encounter_id") == null ? "" : request.getParameter("p_encounter_id");
	String accession_number = request.getParameter("accession_number") == null ? "" : request.getParameter("accession_number");
	String accession_type = request.getParameter("accession_type") == null ? "" : request.getParameter("accession_type");
	String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");
	
//Start : Added by Sridhar Reddy On 05/11/2008
	String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");
	String contr_mod_accession_num = request.getParameter("contr_mod_accession_num") == null ? "" : request.getParameter("contr_mod_accession_num");
	String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
// END : Sridhar Reddy On 05/11/2008

	//IN066218 START
	String che_default_mode=request.getParameter("che_default_mode")==null?"T":request.getParameter("che_default_mode"); 
	String calling_from_2T=request.getParameter("calling_from_2T")==null?"N":request.getParameter("calling_from_2T");
	String history_type=request.getParameter("history_type")==null?"":request.getParameter("history_type");
	String event_class=request.getParameter("event_class")==null?"":request.getParameter("event_class");
	String from_date=request.getParameter("from_date")==null?"":request.getParameter("from_date");
	String to_date=request.getParameter("to_date")==null?"":request.getParameter("to_date");
	String event_item=request.getParameter("event_item")==null?"":request.getParameter("event_item");
	String newPrameters="&che_default_mode="+che_default_mode+"&calling_from_2T="+calling_from_2T+"&history_type="+history_type+"&event_class="+event_class+"&from_date="+from_date+"&to_date="+to_date+"&event_item="+event_item;
	//IN066218 END.
	
		String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
	String show_others_unsinged_yn = request.getParameter("SHOW_OTHERS_UNSINGED_YN") == null ? "N" : request.getParameter("SHOW_OTHERS_UNSINGED_YN"); // added for ML-BRU-SCF-1588 [IN054952]
	String senior_radiologist_yn = request.getParameter("senior_radiologist_yn") == null ? "N" : request.getParameter("senior_radiologist_yn"); // added for ML-BRU-SCF-1588 [IN054952]
	//IN073001 Start
	String updateRDExamViewRequest = request.getParameter("updateRDExamViewRequest") == null ? "N" : request.getParameter("updateRDExamViewRequest");
	String request_num = request.getParameter("p_request_num") == null ? "" : request.getParameter("p_request_num");
	String request_line_num = request.getParameter("p_request_line_num") == null ? "" : request.getParameter("p_request_line_num");
	System.out.println("InvokePatientHistoryWrapper.jsp-----------updateRDExamViewRequest-------------->"+updateRDExamViewRequest+"<-----");
	System.out.println("InvokePatientHistoryWrapper.jsp-----------request_num-------------->"+request_num+"<-----");
	System.out.println("InvokePatientHistoryWrapper.jsp-----------request_line_num-------------->"+request_line_num+"<-----");
	System.out.println("InvokePatientHistoryWrapper.jsp-----------facility_id-------------->"+facility_id+"<-----");
	String archivalYN = request.getParameter("archivalYN") == null ? "" : request.getParameter("archivalYN"); //52176
	//IN073001 End.
	if(locale.equals(""))
	{
		System.out.println("locale value is comming as empty in InvokePatientHistoryWrapper.jsp");
	}

	session.putValue("LOCALE",locale);
	
	

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(login_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(login_pwd));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(accession_number));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(accession_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(limit_function_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(contr_mod_accession_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(show_others_unsinged_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(senior_radiologist_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(login_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(login_pwd));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(accession_number));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(accession_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(limit_function_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(contr_mod_accession_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(show_others_unsinged_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(senior_radiologist_yn));
            out.print( String.valueOf(newPrameters));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(login_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(login_pwd));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(accession_number));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(accession_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(limit_function_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(contr_mod_accession_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(show_others_unsinged_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(senior_radiologist_yn));
            out.print( String.valueOf(newPrameters));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_review_rad_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(request_num));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(request_line_num));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(updateRDExamViewRequest));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(login_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(login_pwd));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(accession_number));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(accession_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(limit_function_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(contr_mod_accession_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(show_others_unsinged_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(senior_radiologist_yn));
            out.print( String.valueOf(newPrameters));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_review_rad_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(request_num));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(request_line_num));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(updateRDExamViewRequest));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(archivalYN));
            _bw.write(_wl_block27Bytes, _wl_block27);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
