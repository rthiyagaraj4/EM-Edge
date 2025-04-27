package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __pathighrisk extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatHighRisk.jsp", 1735057067696L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           created\t\t\t\t\t\t\t\t\t\n07/01/2013\t  IN035950\t\tNijitha\t\tCHL Hospital suggested that the presentation of the Clinician desktop be changed and \n\t\t\t\t\t\t\t\t\t\tmore appealing. Keeping the display of information more clear and visible.\n\n21/01/2013    IN037021\t\tRamesh Kannnan S \tAlpha-CA-View Alerts-User is unable to view the recorded High  \n                                                Risk Conditions. \t\t\t\t\t\t\t\t\t\t\n20/01/2012\t\tCHL-CRF [IN035950]\tRamesh G\tCHL-CRF [IN035950]\t\t\t\t\t\t\t\t\t\t\n--------------------------------------------------------------------------------------------------------------------\n-->\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t</head>\n\n\t<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<TITLE>High Risk Conditions</TITLE>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\n<form name= \'f\' >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<input type=\"hidden\" name=\"res\" id=\"res\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" >\n<script>\nasync function show_window()\n{\n\t\tvar val1 = \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' ;\n\t\tvar val2 = \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' ;\n\t\tvar val3 = \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' ;\n\t\tvar val = val1+\'/\'+val2+\'/\'+val3;\n\n\t\tvar retVal = \tnew String();\n\t\tvar dialogHeight= \"175px\" ;\n\t\tvar dialogWidth\t= \"320px\" ;\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\t\tvar arguments\t= \"\" ;\n\t\tretVal = await window.showModalDialog(\"AuthorizeMRAccessFrame.jsp?constr=\"+val,arguments,features);\n\t\tif(retVal == \"T\" ){\n\t\t\t\t\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'==\"Ass\"){\t\t\t\t\n\t\t\t\t\t\n\t\t\t\tparent.frames[0].location.href=\'../../eCA/jsp/";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="?stage_code=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&stage_desc=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&P_context=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&Encounter_Id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&Practitioner_Id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&Clinic_Code=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&Patient_Id=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&Location_Type=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&radio_par=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&pr=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&f_authorize_yn=Y&Locn_Code=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&Locn_Type=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&dob=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\';\n\n\t\t\t\tparent.frames[1].location.href=\'../../eCA/jsp/addModifyPatProblem.jsp?stage_code=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\';\n\n\t\t\t\tparent.frames[2].document.forms[0].authorize.value=\'Normal Mode\'\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif (\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' == \"PatAlertHighRiskMainFrame.jsp\")\n\t\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tself.location.href=\'../../eCA/jsp/";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="?Encounter_Id=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\t\t\n\t\t\t\t\t\t\t\t\t//top.content.workAreaFrame.document.location.href=\'../../eCA/jsp/";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\';//Commented IN035950 \n\t\t\t\t\t\t\t\t\t//IN035950 Starts\n\t\t\t\t\t\t\t\t\tif(null!=top.content && null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.document.location)\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\ttop.content.workAreaFrame.document.location.href=\'../../eCA/jsp/";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\';\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t{ \n\t\t\t\t\t\t\t\t\twindow.location.href =\'../../eCA/jsp/";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&p_called_from_widget=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\';\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t//IN035950 Ends\n\t\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t}\n\t\telse\n\t\t\t\t{\n\t\t\t\t\tif (\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' == \"PatAlertHighRiskMainFrame.jsp\")\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[2].radio_high_risk.high_risk_button.checked=false;\n\t\t\t\t\t\twindow.location.href=\"../../eCA/jsp/blank.jsp\";\n\t\t\t\t\t}\n\t\t\t\t\telse if (\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' == \"PatProblemQueryResult.jsp\")\n\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.frames[0].location.href=\'../../eCA/jsp/";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&f_authorize_yn=N&dob=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\';\n\t\t\t\t\t}\n\n\t\t\t\t}\n}\n\tif (document.f.res.value == 0){\n\t\t\twindow.setTimeout(\"show_window();\",1000);\n\t}else{\n\t\t//alert(getMessage(\"CA_HIGH_RISK_PREV\",\"CA\"));\n\t\talert(getMessage(\"CA_HIGH_RISK_PREV_RECORD\",\"CA\"));//IN037021\n\n\t\t\tif(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'==\"Ass\")\n\t\t\t{\n\t\t\t\n\t\t\t}\n\t}\n</script>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

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

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String P_patient_id			= request.getParameter("patient_id");
	String P_locn_type			= request.getParameter("location_type");
	String P_access_type		= "E";
	String P_access_data		= "HR";
	String P_patient_type		= request.getParameter("Patient_Type");
	String context					= (String)request.getParameter("PQ");
	if (context==null) context="Y";
	String P_encounter_id	= request.getParameter("episode_id");
	String P_clinic_code		= request.getParameter("location_code");
	String P_practitioner_id = (String) session.getValue("ca_practitioner_id");
    String func=request.getParameter("Fn_Name"); 
	String stagedesc = request.getParameter("stage_desc")==null?"":request.getParameter("stage_desc");
	String stagecode = request.getParameter("stage_code")==null?"":request.getParameter("stage_code");
	String option_id=request.getParameter("option_id");
	if(option_id==null) option_id="";	

	String P_radio_par = request.getParameter("radio_par");
	String P_jsp_name = request.getParameter("jsp_name");
	//CHL-CRF Start. [IN035950]
	String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":(String)request.getParameter("p_called_from_widget");//CHL-CRF [IN035950]
	if(p_called_from_widget.equals("CA_HIGH_RISK")){
	
            _bw.write(_wl_block8Bytes, _wl_block8);

	}
	//CHL-CRF End.[IN035950]
	//out.println(option_id);

	//if(option_id.equals("RECORD_HIGH_RISK")|| option_id.equals("RECORD_HIGH_RISK1"))
	//P_jsp_name = "PaintPatHighRisk.jsp";

	//if(option_id.equals("RECORD_HIGH_RISK")|| option_id.equals("RECORD_HIGH_RISK1"))//Nijitha
	if(option_id.equals("RECORD_HIGH_RISK")|| option_id.equals("RECORD_HIGH_RISK1") || option_id.equals("CHART_SUMMARY"))//Nijitha
	P_jsp_name = "PaintPatHighRisk.jsp";

	//out.println(P_jsp_name);
	String P_pr =request.getParameter("pr");
	String dob = request.getParameter("Dob");
	
	
	Connection con = null; 
	PreparedStatement stmt=null;
	ResultSet rset=null ;
	java.util.Properties p	=	(java.util.Properties) session.getValue( "jdbc" );
	String loginuser			=	p.getProperty( "login_user" ) ;
	String facilityId 				= (String) session.getValue( "facility_id" ) ;

            _bw.write(_wl_block9Bytes, _wl_block9);

try{

	con = ConnectionManager.getConnection(request);
	int a = 0;
	String sql = "Select '1' from mr_user_access_rights_vw where appl_user_id = ? and access_type = 'E' and patient_type ='C' and access_scope= 'HR' and facility_id = ? ";

	stmt=con.prepareStatement(sql);
	stmt.setString(1,loginuser);
	stmt.setString(2,facilityId);
	rset=stmt.executeQuery();
	if(!(rset.next())){
					a=1;
	}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(a));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(P_access_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(P_access_data));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(P_patient_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(func));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(stagecode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(stagedesc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(context));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(stagecode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(stagedesc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(context));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(p_called_from_widget));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(func));
            _bw.write(_wl_block42Bytes, _wl_block42);

	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
} 
catch(Exception e )
{
	//out.println("Exception @ try"+e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	
	ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block43Bytes, _wl_block43);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
