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
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __authorize extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/Authorize.jsp", 1731574057044L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n-----------------------------------------------------------------------\nDate       \t\tEdit History     \t \t  Name        \t\tDescription\n-----------------------------------------------------------------------\n21/01/2013    \t IN037021\t\t\t Ramesh Kannnan S \t\tAlpha-CA-View Alerts-User is unable to view the recorded High  \n                                                            Risk Conditions. \n-----------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n</head>\n\n<body class=\'CONTENT\' OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name= \'f\' >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<input type=\"hidden\" name=\"res\" id=\"res\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" >\n<script>\n\nasync function show_window()\n{\n\t\tvar called_from_ip = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\tvar val1 = \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' ;\n\t\tvar val2 = \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' ;\n\t\tvar val3 = \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' ;\n\t\tvar val = val1+\'/\'+val2+\'/\'+val3;\n       \n\t\tvar retVal = \tnew String();\n\t\tvar dialogHeight= \"9\" ;\n\t\tvar dialogWidth\t= \"25\" ;\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\t\tvar arguments\t= \"\" ;\n\t\tretVal =await window.showModalDialog(\"../../eCA/jsp/AuthorizeMRAccessFrame.jsp?constr=\"+val,arguments,features);\n\n\t\tif(retVal == \"T\" )\n\t\t{\n\t\t\tif(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'==\"Ass\")\n\t\t\t{\n\t\t\t\tvar diag_code=parent.addModifyPatProblem.document.forms[0].code.value;\n\n\t\t\t\tif(parent.addModifyPatProblem.document.forms[0].diag_stage)\n\t\t\t\t\tvar diag_stage=parent.addModifyPatProblem.document.forms[0].diag_stage.value;\n\t\t\t\t\n\t\t\t\tvar diagtype=parent.addModifyPatProblem.document.forms[0].diag_type.value;\n\t\t\t\t\n\t\t\t\tparent.PatProblemQueryResult.location.href=\'../../eCA/jsp/";
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

    private final static java.lang.String  _wl_block28 ="&patient_class=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&called_from_ip=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&Sex=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&Dob=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&code_indicator=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&associate_codes=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\';\n\t\t\t\tparent.addModifyPatProblem.location.href=\"../../eCA/jsp/addModifyPatProblem.jsp?diag_code=\"+diag_code+\"&diagtype=\"+diagtype+\"&diag_stage=\"+diag_stage+\"&stage_code=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&QueryString=\" + escape(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\') + \"&Sex=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&retVal_auth=T&code_indicator=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&state=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\t\t\tparent.PatProblemQueryTools.document.forms[0].authorize.value=getLabel(\"Common.Normal.label\",\"Common\")+ \" \" + getLabel(\"Common.mode.label\",\"Common\");\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif (\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' == \"PatAlertHighRiskMainFrame.jsp\")\n\t\t\t\t{\n\t\t\t\t\tif(called_from_ip == \"Y\")\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.PatAlertQueryHighRiskResult.document.forms[0].high_risk_button.value=getLabel(\"Common.Normal.label\",\"Common\")+ \" \" + getLabel(\"Common.mode.label\",\"Common\");\n\t\t\t\t\t\tparent.PatAlertHighRiskMainFrame.location.href=\'../../eCA/jsp/";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="?Encounter_Id=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"&Sex=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\';\t\t\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\ttop.content.workAreaFrame.PatAlertQueryHighRiskResult.document.forms[0].high_risk_button.value=getLabel(\"Common.Normal.label\",\"Common\") + \" \" + getLabel(\"Common.mode.label\",\"Common\")\n\t\t\t\t\t\ttop.content.workAreaFrame.PatAlertHighRiskMainFrame.location.href=\'../../eCA/jsp/";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\';\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\ttop.content.workAreaFrame.PatAlertQueryAllergyClass.location.href=\'../../eCA/jsp/";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\';\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif (\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' == \"PatAlertHighRiskMainFrame.jsp\")\n\t\t\t{\n\t\t\t\tif(called_from_ip == \"N\")\n\t\t\t\t{\n\t\t\t\t\ttop.content.workAreaFrame.PatAlertQueryHighRiskResult.radio_high_risk.high_risk_button.checked=false;\n\t\t\t\t\twindow.location.href=\"../../eCA/jsp/blank.jsp\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.PatAlertQueryHighRiskResult.radio_high_risk.high_risk_button.checked=false;\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if (\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' == \"PatProblemQueryResult.jsp\")\n\t\t\t{\n\t\t\t\tif(called_from_ip == \"N\")\n\t\t\t\t{\n\t\t\t\t\ttop.content.workAreaFrame.PatProblemQueryResult.location.href=\'../../eCA/jsp/";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&f_authorize_yn=N&patient_class=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\';\n\t\t\t\t\ttop.content.workAreaFrame.addModifyPatProblem.document.forms[0].code.value=\"\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.PatProblemQueryResult.location.href=\'../../eCA/jsp/";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\';\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t}\n}\n\nif (document.f.res.value == 0)\n\t\twindow.setTimeout(\"show_window();\",1000);\nelse\n\talert(getMessage(\"DIAG_AUTH_REQD\",\"CA\"));\t\t\n</script>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

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

    Connection con = null;
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
//	String locale = (String) p.getProperty("LOCALE");
	String P_patient_id = request.getParameter("Patient_Id");
	String P_encounter_id = request.getParameter("Encounter_Id");
	String P_practitioner_id = request.getParameter("Practitioner_Id");
	String P_clinic_code = request.getParameter("Clinic_Code");
	String P_locn_type = request.getParameter("Location_Type");
	String P_access_type = request.getParameter("Access_Type");
	String P_access_data = request.getParameter("Access_Data");
	String P_patient_type = request.getParameter("Patient_Type");
	String patient_class    = request.getParameter("patient_class");
	String context=request.getParameter("Context");
    String func=request.getParameter("Fn_Name");
	String code_indicator = request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator");
	String stagedesc = request.getParameter("stage_desc")==null?"":request.getParameter("stage_desc");
	String stagecode = request.getParameter("stage_code")==null?"":request.getParameter("stage_code");
	String QueryString = request.getParameter("QueryString")==null?"":request.getParameter("QueryString");
	String called_from_ip = request.getParameter("called_from_ip")==null?"N":request.getParameter("called_from_ip");
	String associate_codes = request.getParameter("associate_codes")==null?"":request.getParameter("associate_codes");
	String P_radio_par = request.getParameter("radio_par");
	String P_jsp_name = request.getParameter("jsp_name");
	String P_pr =request.getParameter("pr");

	String dob   = request.getParameter("Dob");	
	String sex   = request.getParameter("Sex");	
	String state=request.getParameter("function")==null?"":request.getParameter("function");

	if(context!=null)
	{
		if(context.equals("PatientQueue")	)
			P_patient_type="O";
		else
			P_patient_type="C"; 
	}


    con = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rset=null ;

	String loginuser=p.getProperty( "login_user" ) ;
	String facilityId = (String)session.getValue("facility_id");

            _bw.write(_wl_block8Bytes, _wl_block8);

try{
	int a = 0;

	//String sql = " Select '1' from mr_user_access_rights_vw where appl_user_id = ? and access_type = 'E' and patient_type ='C' and access_scope= 'HR' and facility_id=?" ; 
	String sql = " Select '1' from mr_user_access_rights_vw where appl_user_id = ? and access_type = 'V' and patient_type ='C' and access_scope= 'HR' and facility_id=?" ; //IN037021

	pstmt=con.prepareStatement(sql);
	pstmt.setString(1,loginuser);
	pstmt.setString(2,facilityId);
	
	rset=pstmt.executeQuery();

	if(!(rset.next()))
			a=1;

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(a));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(called_from_ip));
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
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block34Bytes, _wl_block34);
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
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(QueryString));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(state));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
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
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
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
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
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
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
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
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
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
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block50Bytes, _wl_block50);

	if(rset!=null) rset.close();
	if(pstmt!=null) pstmt.close();

} //end try
catch(Exception e ){
	//out.println("Exception in Authorize.jsp"+e.toString());//COMMON-ICN-0181
	 e.printStackTrace();//COMMON-ICN-0181
}
finally{
//	if(stmt!=null) stmt.close();
	
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block51Bytes, _wl_block51);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
