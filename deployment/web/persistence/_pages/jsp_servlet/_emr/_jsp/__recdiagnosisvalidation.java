package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.io.BufferedReader;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import org.json.simple.*;

public final class __recdiagnosisvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecDiagnosisValidation.jsp", 1742301296588L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n \n<html>\n<head>\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\'../js/RecDiagnosis.js\' language=\'javascript\'></script>\n\t<script src=\'../js/RecDiagnosisMain.js\' language=\'javascript\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n</head>\n<body onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t<script>\n\t\t\n\t\tparent.RecDiagnosisAddModify.document.getElementById(\'other_disp1\').style.visibility=\'visible\';\n\t\tparent.RecDiagnosisAddModify.document.getElementById(\'other_disp2\').style.visibility=\'visible\';\n\t\t\n\t\t\n\t\tvar select = parent.RecDiagnosisAddModify.document.forms[0].term_oth_desc;\n\t\t\t\t\t\t\n\t\t\t\t\t\t if (select.type!=\'hidden\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\twhile (select.options.length > 0 )\n\t\t\t\t\t\t\tselect.remove(select.options[0]);\n\t\t\t\t\t\t\tvar element =parent.RecDiagnosisAddModify.document.createElement(\'OPTION\');\n\t\t\t\t\t\t\telement.text = \'-----\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'----- \';\n\t\t\t\t\t\t\telement.value= \'\';\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].term_oth_desc.add(element);\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\t\n\t\t\t\t\t\t\tvar element =parent.RecDiagnosisAddModify.document.createElement(\'OPTION\');\n\t\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\t\t\t\t\tif(element.value!=\'\')\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].term_oth_desc.add(element);\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\telement.selected=true;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t   \n\t\t\t\t\t\n\t\t\t\t\t     }\t\n\t\t\n\t\t\n\t\t\n\t\t\t\n\t\t</script>\n\t\t\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>\n\t\tvar build_diag_class_type\t =\"\";// Added For SRR-CRF-303.2\n\t\tvar obj_type = parent.RecDiagnosisAddModify.document.forms[0].diag_classfication;\n\t\tvar length1  = obj_type.length;\n\t\tfor(i=0;i<length1;i++) {\n\t\tobj_type.remove(1);\n\t\t}\n</script>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar obj=parent.RecDiagnosisAddModify.document.forms[0].diag_classfication;\n\t\t\t\t\t\t\t\topt=parent.RecDiagnosisAddModify.document.createElement(\'OPTION\');\n\t\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\t\t\t\tobj.add(opt);\n\t\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t\t\t</script>\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar obj=parent.RecDiagnosisAddModify.document.forms[0].diag_classf_desc;\n\t\t\t\t\t\t\t\topt=parent.RecDiagnosisAddModify.document.createElement(\'OPTION\');\n\t\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t\t\t\t\tobj.add(opt);\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\tbuild_diag_class_type\t=\tbuild_diag_class_type+\"<input type=\'hidden\' name=\'diag_class_type_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\";\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar obj=parent.RecDiagnosisAddModify.document.forms[0].diag_classfication;\n\t\t\t\t\t\t\t\t\topt=parent.RecDiagnosisAddModify.document.createElement(\'OPTION\');\n\t\t\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\t\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\t\t\t\t\t\t\tobj.add(opt);\n\t\t\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t\t\t\t</script>\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar obj=parent.RecDiagnosisAddModify.document.forms[0].diag_classf_desc;\n\t\t\t\t\t\t\t\t\topt=parent.RecDiagnosisAddModify.document.createElement(\'OPTION\');\n\t\t\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\t\t\t\t\t\tobj.add(opt);\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\tbuild_diag_class_type\t=\tbuild_diag_class_type+\"<input type=\'hidden\' name=\'diag_class_type_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\";\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar obj=parent.RecDiagnosisAddModify.document.forms[0].diag_classfication;\n\t\t\t\t\t\t\topt=parent.RecDiagnosisAddModify.document.createElement(\'OPTION\');\n\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\t\t\t\t\tobj.add(opt);\n\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t\t</script>\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar obj=parent.RecDiagnosisAddModify.document.forms[0].diag_classf_desc;\n\t\t\t\t\t\t\topt=parent.RecDiagnosisAddModify.document.createElement(\'OPTION\');\n\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t\t\t\t\t\tobj.add(opt);\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\tbuild_diag_class_type\t=\tbuild_diag_class_type+\"<input type=\'hidden\' name=\'diag_class_type_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\";\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="<script>onDefltDiagCls(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\', \'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\')</script>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t<!--\n\t\t\t\t \n\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\"id_diag_class_type\").innerHTML=build_diag_class_type;\n\t\t\t//-->\n\t\t\t</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t\n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t<script>\n\t\n\tvar obj_type = parent.RecDiagnosisAddModify.document.forms[0].anatomical_oral_sites;\n\tvar length1  = obj_type.length;\n\n\tfor(i=0;i<length1;i++) \n\t{\n\tobj_type.remove(1);\n\t}\n\t</script>\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="<script>\n\t\t\tvar obj=parent.RecDiagnosisAddModify.document.forms[0].anatomical_oral_sites;\n\t\t\t//var opt=\"\";\n\t\t\topt=parent.RecDiagnosisAddModify.document.createElement(\'OPTION\');\n\t\t\topt.value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\topt.text=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\t\t\tobj.add(opt);\n\t\t\t</script>\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n<input type=\"hidden\" name=\"diagcode\" id=\"diagcode\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

public static String checkForNull(String inputString){ // Added by mujafar for ML-MMOH-CRF-1281 US3
return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue){
return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}


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
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue 
	Connection con = null; 
	PreparedStatement stmt_appln_yn=null;
	ResultSet rs_appln_yn = null;
	//Statement stmt_one=null;
	PreparedStatement stmt_one=null;
	Statement stmtOral=null;
	ResultSet rset = null;
	PreparedStatement stmt=null;
	ResultSet rs = null;
	PreparedStatement stmt1=null;
	ResultSet rs1 = null;
	ResultSet rs_free = null;
	ResultSet oralRS = null;
	PreparedStatement pstmtpat = null;
	ResultSet rsetpat = null;

	ResultSet rsset				= null;
	PreparedStatement prepstmt	= null;
	
	String diagcode="";

		
	String b_age = request.getParameter("b_age")==null?"":request.getParameter("b_age");
	String b_months = request.getParameter("b_months")==null?"":request.getParameter("b_months");
	String b_days = request.getParameter("b_days")==null?"":request.getParameter("b_days");
	String b_hours = request.getParameter("b_hours")==null?"":request.getParameter("b_hours");
	String onset_date = request.getParameter("onset_date")==null?"":request.getParameter("onset_date");

	
	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	
	

	String term_set_code = request.getParameter("term_set_code")==null?"":request.getParameter("term_set_code");
	String term_sht_desc = request.getParameter("term_sht_desc")==null?"":request.getParameter("term_sht_desc"); // Added by mujafar for ML-MMOH-CRF-1281 US3
	term_sht_desc = java.net.URLDecoder.decode(term_sht_desc);
	String isMultiDescAppl = request.getParameter("isMultiDescAppl")==null?"":request.getParameter("isMultiDescAppl");
	int descCount = 0;

	String sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");

	String dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");

	String code_indicator = request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator");

	term_set_code = term_set_code.toUpperCase();

	String modal_yn = request.getParameter("modal_yn")==null?"":request.getParameter("modal_yn"); 

	String step = request.getParameter("step")==null?"":request.getParameter("step"); 
	String mode = request.getParameter("mode")==null?"R":request.getParameter("mode"); 
	String anatomical_site_val = request.getParameter("anatomical_site_val")==null?"":request.getParameter("anatomical_site_val"); 
	String diag_class = request.getParameter("diag_class")==null?"":request.getParameter("diag_class"); 

	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

	String locale			= (String)session.getAttribute("LOCALE");


	String short_desc = "";
	String long_desc = "";
	String link_Complaint = "";
	/*Added by Maheshwaran K for the SKR-CRF-0020 as on 03/05/2012*/
	/*Start*/
	String default_status="";
	/*End*/

	String age_spec_ind_val = "";
	String age_group_appl_yn = "";
	//String sensitivity_appl_yn = "";
	//String term_set_desc = "";
	//String notification_appl_yn = "";
	String notifiable_yn = "";

	int recordcnt = 0;
	int maxrecord = 0;
	StringBuffer sql = new StringBuffer();
	String sql_appln_yn = "";
	String sql_cnt = "";
	String free_text_applicable_yn = "";
	String oralSites			="";
	String anatomical_site_code	="";
	String anatomical_short_desc="";
	
	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	Boolean isDeceasedDiagClassDeathRegAppl = false;
	String deceased_yn = "N";
	String primary_diag_class = "";
	String secondary_diag_class = "";

	try
	{
		con = ConnectionManager.getConnection(request);

		isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DECEASED_DIAG_CLASS_DEATH_REG");//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742

		String mr_param_sql = "SELECT primary_diag_class, secondary_diag_class FROM mr_parameter";
		
		prepstmt = con.prepareStatement(mr_param_sql);
		rsset = prepstmt.executeQuery();

		if(rsset!=null && rsset.next()){
			primary_diag_class = (rsset.getString("primary_diag_class")==null || rsset.getString("primary_diag_class")=="")?"" : rsset.getString("primary_diag_class");
			secondary_diag_class = (rsset.getString("secondary_diag_class")==null || rsset.getString("secondary_diag_class")=="")?"" : rsset.getString("secondary_diag_class");
		}

		if(prepstmt!=null) prepstmt.close();
		if(rsset!=null) rsset.close();

		//stmt_one=con.createStatement();
		/**/

	  //if( !step.equals("4") && !step.equals("5")){  // modified for PE
	  if( step.equals("1") ){

		if(!mode.equals("modify") )
		{
			String free_text = "Select FREE_text_applicable_yn from mr_term_set where term_set_id =? and eff_status = 'E' ";
			stmt_one=con.prepareStatement(free_text);
			stmt_one.setString(1,term_set_id);
			rs_free=stmt_one.executeQuery();

			if(rs_free != null && rs_free.next())
			{
				free_text_applicable_yn = rs_free.getString("free_text_applicable_yn");

			}
			if(free_text_applicable_yn.equals("Y"))
			{
				out.println("<script>if(parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc)				parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.disabled=false;</script>");
				
				
			}else
			{
				out.println("<script>parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.disabled=true;</script>");
				
			}
		if (rs_free != null) rs_free.close();
		}
		else
			out.println("<script>parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.disabled=true;</script>");

	  }
		/**/
if(step.equals("2")){
		sql_cnt="select short_desc ,long_desc,code_indicator,notifiable_yn from MR_D_"+term_set_id+"_VW where term_code = ? " ; 
		stmt1 = con.prepareStatement(sql_cnt);
		stmt1.setString(1,term_set_code);
		rs1 =  stmt1.executeQuery();
		while(rs1.next())
		{
				short_desc = rs1.getString("short_desc");
				long_desc = rs1.getString("long_desc");
				code_indicator = rs1.getString("code_indicator");
				notifiable_yn = rs1.getString("notifiable_yn");
				maxrecord++;

		}
		
		if(maxrecord == 0){
				out.println("<script>alert(getMessage('INVALID_DIAGCODE'));parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value='';parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.select();parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.focus();</script>");
		}else{
			sql_appln_yn = "select AGE_GROUP_APPL_YN,SENSITIVITY_APPL_YN,TERM_SET_DESC,NOTIFICATION_APPL_YN from mr_term_set where TERM_SET_ID = ?";
			stmt_appln_yn = con.prepareStatement(sql_appln_yn);
			stmt_appln_yn.setString(1,term_set_id);
			rs_appln_yn = stmt_appln_yn.executeQuery();
			while(rs_appln_yn.next()){
				age_group_appl_yn = rs_appln_yn.getString("AGE_GROUP_APPL_YN");
				//sensitivity_appl_yn = rs_appln_yn.getString("SENSITIVITY_APPL_YN");
				//term_set_desc = rs_appln_yn.getString("TERM_SET_DESC");
				//notification_appl_yn = rs_appln_yn.getString("NOTIFICATION_APPL_YN");
			}
			if(rs_appln_yn!=null)  rs_appln_yn.close();
			if(stmt_appln_yn!=null)  stmt_appln_yn.close();
			if(age_group_appl_yn.equals("Y")){
				String sql_age_spec_ind = " select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'N'  END FROM MR_PARAMETER ";
				stmt_appln_yn = con.prepareStatement(sql_age_spec_ind);
				stmt_appln_yn.setString(1,dob);
				stmt_appln_yn.setString(2,dob);
				stmt_appln_yn.setString(3,dob);
				rs_appln_yn = stmt_appln_yn.executeQuery();
				while(rs_appln_yn.next())
					age_spec_ind_val = rs_appln_yn.getString(1)==null?"":rs_appln_yn.getString(1);	
//			}	
			
			if(rs_appln_yn!=null)  rs_appln_yn.close();
			if(stmt_appln_yn!=null)  stmt_appln_yn.close();
			int j = 0;
			j++;
			sql.append("select short_desc,long_desc,code_indicator,notifiable_yn from MR_D_"+term_set_id+"_VW where term_code = ? " ); 
			if(!sex.equals("")){
				sql.append(" and ( gender_spec_ind = ? OR gender_spec_ind IS NULL) ");
			}
			if(age_group_appl_yn.equals("Y") && (!age_spec_ind_val.equals(""))){
				//sql.append(" and (age_spec_ind is null or age_spec_ind =?)");
				sql.append(" and (nvl(age_spec_ind,'O') NOT IN ('A','P','N') or age_spec_ind =?)");
			}
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(j++,term_set_code);
			
			if(!sex.equals("")){
				stmt.setString(j++,sex);
			}
			if( age_group_appl_yn.equals("Y") && (!age_spec_ind_val.equals(""))){
				stmt.setString(j++,age_spec_ind_val);
			}
			rs = stmt.executeQuery();
			while(rs.next()){
				short_desc = rs.getString("short_desc");
				long_desc = rs.getString("long_desc");
				code_indicator = rs.getString("code_indicator");
				notifiable_yn = rs.getString("notifiable_yn");
				recordcnt++;
			}

			if(recordcnt == 0){
				out.println("<script>alert(getMessage('MR_INVALID_DIAG_CODE_FOR_PATIENT','MR'));parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value='';parent.RecDiagnosisAddModify.document.RecDaignosis_form.LongDescription.value='';parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_yn.value='';parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.select();parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.focus();</script>");
			}else{
				if(modal_yn.equals("Y")){
					out.println("<script>parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value=\""+short_desc+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.LongDescription.value=\""+long_desc+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value=\""+term_set_code+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator.value=\""+code_indicator+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_yn.value=\""+notifiable_yn+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.onblur();"); 	
				}else{	
					out.println("<script>parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value=\""+short_desc+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.LongDescription.value=\""+long_desc+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value=\""+term_set_code+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator.value=\""+code_indicator+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_yn.value=\""+notifiable_yn+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.onblur();"); 
			}
		if(long_desc!=null )
					{
					if(modal_yn.equals("Y"))
						{
						out.println("parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.exclamation.style.visibility='visible';");
						}
					else
						{
						out.println("parent.RecDiagnosisAddModify.document.RecDaignosis_form.exclamation.style.visibility='visible';");
						}
					}
			else
					{
						if(modal_yn.equals("Y"))
						{
						out.println("parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.exclamation.style.visibility='hidden';");
						}
					else
						{
						out.println("parent.RecDiagnosisAddModify.document.RecDaignosis_form.exclamation.style.visibility='hidden';");
						}
						
					}
			}
			 out.println("</script>");
		  }
		 else
		{
			
		if(modal_yn.equals("Y")){
			out.println("<script>parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value=\""+short_desc+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value=\""+term_set_code+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator.value=\""+code_indicator+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_yn.value=\""+notifiable_yn+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.onblur();"); 
		}else{
			out.println("<script>parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value=\""+short_desc+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value=\""+term_set_code+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator.value=\""+code_indicator+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_yn.value=\""+notifiable_yn+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.onblur();"); 
		}
			if(long_desc!=null )
					{
						
					if(modal_yn.equals("Y"))
						{
						out.println("parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.exclamation.style.visibility='visible';");
						}
					else
						{
						out.println("parent.RecDiagnosisAddModify.document.RecDaignosis_form.exclamation.style.visibility='visible';");
						}
					}
			else
					{
						if(modal_yn.equals("Y"))
						{
						out.println("parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.exclamation.style.visibility='hidden';");
						}
					else
						{
						out.println("parent.RecDiagnosisAddModify.document.RecDaignosis_form.exclamation.style.visibility='hidden';");
						}
						
					}
			 out.println("</script>");
		}
		}
	}else if(step.equals("1"))
	{
	
	
	if(isMultiDescAppl.equals("true") && term_set_id.equals("ICD10"))
	{  // Added by mujafar for ML-MMOH-CRF-1281 US3
		
			JSONObject DescriptionJsonObj		= new JSONObject();
		DescriptionJsonObj = eMR.MRCommonBean.getTermCodeDescription(con,term_set_id,term_set_code);
		JSONArray DescriptionJsonArray 		= (JSONArray)DescriptionJsonObj.get("results");
		JSONObject termCodeCountObj = new JSONObject();
		JSONObject multi_desc_ynObj = new JSONObject();
		Integer termCodeCount =0;
		String multi_desc_yn = "N";
		if(DescriptionJsonArray.size() > 0)
		{
		termCodeCountObj	= (JSONObject)DescriptionJsonArray.get(0);
		

		termCodeCount = (Integer)termCodeCountObj.get("termCodeCount");
		multi_desc_yn = checkForNull((String)termCodeCountObj.get("multi_desc_yn"));
		if(isMultiDescAppl.equals("true") && termCodeCount == 1 && multi_desc_yn.equals("Y")) 
			descCount = 1;
		}
		
		
		if(descCount == 1)
		{
			
			
            _bw.write(_wl_block3Bytes, _wl_block3);

							JSONObject temCodeDescListObj = new JSONObject();
							if(DescriptionJsonArray.size() > 0)
							temCodeDescListObj	= (JSONObject)DescriptionJsonArray.get(0);

							String descriptions="";
							for(int i=1;i<=10;i++)
							{
								descriptions = checkForNull((String)temCodeDescListObj.get("description"+i));
								
							
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(descriptions));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(descriptions));
            _bw.write(_wl_block6Bytes, _wl_block6);

							
							if(term_sht_desc.equals(descriptions))
							{
								
            _bw.write(_wl_block7Bytes, _wl_block7);

							}
								
							}	
							
            _bw.write(_wl_block8Bytes, _wl_block8);

			
		}
	
	}	
		

//out.println("<script>alert(\"@@@inter term_set_id :"+term_set_id+"\");</script>");			
/*
Anjaneya Added fore the code if list values are added if we selected diffrent set
Clearing the prevous values
*/
            _bw.write(_wl_block9Bytes, _wl_block9);


//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
if(isDeceasedDiagClassDeathRegAppl){

String sqlpatid = " SELECT deceased_yn FROM mp_patient WHERE patient_id = ? ";

pstmtpat = con.prepareStatement(sqlpatid);
pstmtpat.setString(1,patient_id);
rsetpat = pstmtpat.executeQuery();

if(rsetpat!=null && rsetpat.next()){
	deceased_yn	= rsetpat.getString("deceased_yn")==null?"N":rsetpat.getString("deceased_yn");
}

}

// Logic end here.
String shortdesc="";
			/*Default_status column was added in the query by Maheshwaran K for the SKR-CRF-0020 as on 03/05/2012*/
			String sql_diag="SELECT A.DIAG_CLASS_CODE, mr_get_desc.mr_diag_class(a.diag_class_code,?,'2')SHORT_DESC,DIAG_CLASS_TYPE,B.DEFAULT_STATUS FROM MR_DIAG_CLASS A, MR_DIAG_CLASS_DTL B WHERE A.DIAG_CLASS_CODE = B.DIAG_CLASS_CODE AND B.TERM_SET_ID=? AND A.EFF_STATUS='E' ORDER BY SHORT_DESC ";
			//String sql_diag="SELECT A.DIAG_CLASS_CODE, mr_get_desc.mr_diag_class(a.diag_class_code,'"+locale+"','2')SHORT_DESC,DIAG_CLASS_TYPE FROM MR_DIAG_CLASS A, MR_DIAG_CLASS_DTL B WHERE A.DIAG_CLASS_CODE = B.DIAG_CLASS_CODE AND B.TERM_SET_ID='"+term_set_id+"' AND A.EFF_STATUS='E' ORDER BY SHORT_DESC ";
			int  i=1;
			String diag_class_type="";
			String defSelDiagClsCode = ""; //Added by Ajay H. for TH-KW-CRF-165.1
			String defSelDiagClsType = "";
			stmt_one=con.prepareStatement(sql_diag);
			stmt_one.setString(1,locale);
			stmt_one.setString(2,term_set_id);
			rset=stmt_one.executeQuery();

			while( rset.next() ){
					 diagcode				= rset.getString( "DIAG_CLASS_CODE" ) ;
					 shortdesc				=rset.getString("SHORT_DESC");
					 diag_class_type	=rset.getString("DIAG_CLASS_TYPE");
					 /*Added by Maheshwaran K for the SKR-CRF-0020 as on 03/05/2012*/
					/*Start*/
					default_status	=rset.getString("DEFAULT_STATUS");
					 /*End*/
					
					//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
					if(isDeceasedDiagClassDeathRegAppl){
						if(deceased_yn.equals("Y") || function_id.equals("RECORD_DIAGNOSIS_FROM_POPUP")){
							if(diag_class.equals(diagcode)){
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(diagcode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(shortdesc));
            _bw.write(_wl_block12Bytes, _wl_block12);
 
							}else{
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(diagcode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(shortdesc));
            _bw.write(_wl_block14Bytes, _wl_block14);
if((default_status.equals("Y"))&&(diag_class.equals(""))){
            _bw.write(_wl_block15Bytes, _wl_block15);

									defSelDiagClsCode = diagcode;
									defSelDiagClsType = diag_class_type;
								}
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(diag_class_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
}
						}else{
							if(!diagcode.equals(primary_diag_class) && !diagcode.equals(secondary_diag_class)){
								if(diag_class.equals(diagcode)){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(diagcode));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(shortdesc));
            _bw.write(_wl_block21Bytes, _wl_block21);
 
								}else{
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(diagcode));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(shortdesc));
            _bw.write(_wl_block23Bytes, _wl_block23);
if((default_status.equals("Y"))&&(diag_class.equals(""))){
            _bw.write(_wl_block24Bytes, _wl_block24);

										defSelDiagClsCode = diagcode;
										defSelDiagClsType = diag_class_type;
									}
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(diag_class_type));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
							}
						}
					}else{
						if(diag_class.equals(diagcode)){
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(diagcode));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(shortdesc));
            _bw.write(_wl_block29Bytes, _wl_block29);
 
						}else{
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(diagcode));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(shortdesc));
            _bw.write(_wl_block31Bytes, _wl_block31);

							/*Added by Maheshwaran K for the SKR-CRF-0020 as on 03/05/2012*/
							/*Start*/
							if((default_status.equals("Y"))&&(diag_class.equals("")))
								{
								
            _bw.write(_wl_block32Bytes, _wl_block32);

								defSelDiagClsCode = diagcode; //Added by Ajay H. for TH-KW-CRF-165.1
								defSelDiagClsType = diag_class_type;
								}
							/*End*/	
							
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(diag_class_type));
            _bw.write(_wl_block34Bytes, _wl_block34);
 
						}
					}
						i++;
				}
				//Added by Ajay H. for TH-KW-CRF-165.1
				if(!defSelDiagClsCode.equals("")){
					
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(defSelDiagClsCode));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(defSelDiagClsType));
            _bw.write(_wl_block37Bytes, _wl_block37);

				
				}
            _bw.write(_wl_block38Bytes, _wl_block38);
}
	/**/
	else if(step.equals("3"))	{
	
            _bw.write(_wl_block39Bytes, _wl_block39);

		if(anatomical_site_val.equals("C"))	
		{
			oralSites = "select anatomical_site_code,am_get_desc.am_anatomical_site(anatomical_site_code,'"+locale+"',2)short_desc from am_anatomical_site where oral_cavity_yn = 'Y' and eff_status = 'E' order by short_desc";
		}else
		{
			oralSites = "select anatomical_site_code,am_get_desc.am_anatomical_site(anatomical_site_code,'"+locale+"',2)short_desc from am_anatomical_site where oral_cavity_yn = 'N' and eff_status = 'E' order by short_desc"; //Newly added  by Name :Selvin M  Date :31 May 2011 INCIDENT NO: 27497 Changes:newly added order by	
		}
	    //out.println("oralSites.."+oralSites);
			stmtOral=con.createStatement();
			oralRS = stmtOral.executeQuery(oralSites);
			while( oralRS.next() )
			{
					 anatomical_site_code = oralRS.getString( "ANATOMICAL_SITE_CODE" ) ;
					 anatomical_short_desc= oralRS.getString("SHORT_DESC");
		
			
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(anatomical_site_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(anatomical_short_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
 
			}	
	}
	else if(step.equals("4"))
	{	
		int n_days = 0;
		int n_months = 0;
		int n_age = 0;
		int n_hours = 0;

		
			if ( !b_days.equals("")) 
				n_days = Integer.parseInt(b_days);
			if ( !b_months.equals("")) 
				n_months = Integer.parseInt(b_months);
	        if (! b_age.equals("")) 
				n_age = Integer.parseInt(b_age);
	        if ( !b_hours.equals(""))
				n_hours = Integer.parseInt(b_hours);
			


			String DOB = "";
		    //String sql_dob = "select calculate_date_of_birth_hours ("+b_age+","+b_months+","+b_days+","+b_hours+") from dual";
		    String sql_dob = "select To_Char(To_Date( CALCULATE_DATE_OF_BIRTH_YMDH ("+n_age+","+n_months+","+n_days+","+n_hours+"),'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi') from dual";
		
			stmt = con.prepareStatement(sql_dob);
			rs = stmt.executeQuery();
			if (rs != null){
				rs.next();
		        DOB = rs.getString(1);
			}
			if ( DOB !=null && !DOB.equals("") ){
				if (!locale.equals("en")){
					DOB = DateUtils.convertDate(DOB,"DMYHM","en",locale);
				}
			}

			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		

			out.println("<script>parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.onset_date.value=\""+DOB+"\";parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';</script>"); 
		
			


			if(stmt != null) stmt.close();
	}
	else if(step.equals("5"))
	{

			String age_value = "";
			String year_value = "";
			String month_value = "";
			String day_value = "";
			String hours_value = "";
			
			if (!locale.equals("en")) {	
			onset_date = DateUtils.convertDate(onset_date,"DMYHM",locale,"en");				
			}

		    String sql_dmy = "select MP_CALCULATE_AGE_YMD(to_date(?,'dd/mm/yyyy hh24:mi'),'YMDH',sysdate) from dual";
			stmt = con.prepareStatement(sql_dmy);
			stmt.setString(1,onset_date);
			rs = stmt.executeQuery();

			
			if (rs != null){

				rs.next();
			   age_value = rs.getString(1);	
			}
			StringTokenizer st = new StringTokenizer(age_value," ");

			while ( st.hasMoreTokens() ) {

			String date_elmnt = st.nextToken();			

			char ymdh_char = date_elmnt.charAt(date_elmnt.length()-1);			

			String ymdh_elmnt = date_elmnt.substring(0,(date_elmnt.length()-1));			

			if(ymdh_char=='Y') {
				year_value = ymdh_elmnt;
			} else if (ymdh_char=='M') {
				month_value	= ymdh_elmnt;
			} else if (ymdh_char=='D') {
				day_value	= ymdh_elmnt;
			} else if (ymdh_char=='H') {
				hours_value	= ymdh_elmnt;
			}
		}
		

			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		

			out.println("<script>parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.b_days.value=\""+day_value+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.b_months.value=\""+month_value+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.b_age.value=\""+year_value+"\";parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';</script>"); 
		

	
	
	}
	/**/
	if (rset != null) rset.close();
	if(rs1!=null) rs1.close();

	if(stmt1!=null) stmt1.close();

	if(rs!=null) rs.close();
	if(oralRS!=null) oralRS.close();
	if(stmt!=null) stmt.close();
	if(stmtOral!=null) stmtOral.close();
	if(stmt_one!=null) stmt_one.close();
	if(pstmtpat!=null) pstmtpat.close();
	if(rsetpat!=null) rsetpat.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	


            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(diagcode));
            _bw.write(_wl_block44Bytes, _wl_block44);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
