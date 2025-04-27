package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __terminologycodetermset extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TerminologyCodeTermSet.jsp", 1740455814285L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\"></link>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script language=\"JavaScript\" src=\"../js/TerminologyCode.js\"></script>\n<SCRIPT LANGUAGE=\"JavaScript\">\n// This function is written for getting values dynamically for classification levels\n// Legend in 2nd frame and drawing table in the third frame.\nfunction getdefnlevels()\n{\n\tvar termsetid = document.frm_terminology_code.terminology_set.value;\n\tvar isMultiDescAppl = parent.f_term_add_modify.document.term_code_addmodify.isMultiDescAppl.value; // added by mujafar for ML-MMOH-CRF-1281\n\t\n\tvar icd_termset = termsetid.substring(0,3);\n\tparent.f_term_result_header.document.term_code_result_header.search_text.value=\"\";\n\tparent.f_term_result_header.document.term_code_result_header.search_criteria.value=\"C\";\n\tparent.f_term_result_header.document.term_code_result_header.termcode.value=\"\";\n\tparent.f_term_result_header.document.term_code_result_header.codelevel.value=\"\";\n\tparent.f_term_add_modify.document.term_code_addmodify.term_code.value=\"\";\n\tparent.f_term_add_modify.document.term_code_addmodify.term_code.disabled=false;\n\tparent.f_term_add_modify.document.term_code_addmodify.short_desc.value=\"\";\n\tparent.f_term_add_modify.document.term_code_addmodify.long_desc.disabled=false;\n\tparent.f_term_add_modify.document.term_code_addmodify.long_desc.value=\"\";\n\tparent.f_term_add_modify.document.term_code_addmodify.short_desc.disabled=false;\n\tparent.f_term_add_modify.document.term_code_addmodify.eff_status.checked=true;\n\tparent.f_term_add_modify.document.term_code_addmodify.proc_diag.value=\"\";\n\n\tparent.f_term_add_modify.document.term_code_addmodify.proc_diag.disabled=false;\n\tparent.f_term_add_modify.document.term_code_addmodify.term_code.readOnly=false;\n\tparent.f_term_add_modify.document.term_code_addmodify.selectable.checked=false;\n\n\tparent.f_term_add_modify.document.term_code_addmodify.selectable.disabled=false;\n\tparent.f_term_add_modify.document.term_code_addmodify.eff_status.disabled=false;\n\n\tparent.f_term_add_modify.document.term_code_addmodify.active.checked=false;\n\tparent.f_term_add_modify.document.term_code_addmodify.active.disabled=false;\n\n\tparent.f_term_add_modify.document.term_code_addmodify.potential.checked=false;\n\tparent.f_term_add_modify.document.term_code_addmodify.potential.disabled=false;\n\n\tparent.f_term_add_modify.document.term_code_addmodify.wellness.checked=false;\n\tparent.f_term_add_modify.document.term_code_addmodify.wellness.disabled=false;\n\t\n\t// added by mujafar for ML-MMOH-CRF-1281 START\n\tif(isMultiDescAppl == \"true\" && termsetid == \"ICD10\")\n\t{ \n\t\t\n\tparent.f_term_add_modify.document.getElementById(\'show_multi_desc\').style.visibility=\'visible\'; \n\tparent.f_term_add_modify.document.getElementById(\'show_desc\').style.visibility=\'visible\';\n\tif(parent.f_term_add_modify.document.getElementById(\'cmulti_desc\'))\n\t{\n\tparent.f_term_add_modify.document.getElementById(\'multi_desc\').checked=false;\n\tparent.f_term_add_modify.document.getElementById(\'multi_desc\').disabled=false;\n\n\t}\n\t}\n\telse if(isMultiDescAppl == \"true\" && termsetid != \"ICD10\")\n\t{\n\t\t\n\t parent.f_term_add_modify.document.getElementById(\'show_multi_desc\').style.visibility=\'hidden\'; \n\t parent.f_term_add_modify.document.getElementById(\'show_desc\').style.visibility=\'hidden\';\n\t if(parent.f_term_add_modify.document.getElementById(\'multi_desc\'))\n\t{\n\tparent.f_term_add_modify.document.getElementById(\'multi_desc\').checked=false;\n\tparent.f_term_add_modify.document.getElementById(\'multi_desc\').disabled=false;\n\n\t}\n\n\t}\n\t// added by mujafar for ML-MMOH-CRF-1281 END\n\n\n\tparent.f_term_add_modify.document.term_code_addmodify.sensitive.checked=false;\n\tparent.f_term_add_modify.document.term_code_addmodify.notifiable.checked=false;\n\n\tparent.f_term_add_modify.document.term_code_addmodify.code_indicator.value=\"\";\n\tif(parent.f_term_add_modify.document.term_code_addmodify.High_risk_cndn_code){\n\t\tparent.f_term_add_modify.document.term_code_addmodify.High_risk_cndn_code.value=\"\"; // Newly Added for this CRF[BRU-HIMS-CRF-19.1]\n\t\tparent.f_term_add_modify.document.term_code_addmodify.High_risk_cndn_code.disabled=true;\n\t}\n\t\n\t/* implemneting gettin the sensitivity and notifiable form */\n\tvar param=\"termsetid=\"+document.frm_terminology_code.terminology_set.value+\"&callfunction=sensvity/notifiable\";\n\t\n\t\n\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\tvar temp_jsp=\"../../eMR/jsp/MR_validation.jsp?\"+param;\n\t\t\t\n\t\t\t// var xmlDoc = new ActiveXObject( \"Microsoft.XMLDom\" ) ;\n\t\t\t// var xmlHttp = new ActiveXObject( \"Microsoft.XMLHTTP\" ) ;\n\t\t\t// xmlDoc.loadXML(xmlStr);\n\t\t\t\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\n\t\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tresponseText=trimString(xmlHttp.responseText);\n\t\t\t\n\t\t\tvar retVal = responseText.split(\"&^&\");\n\t\t\t\n\t\t\tvar x=retVal[0];\n\t\t\tvar z=retVal[1];\n\t\t\t/*Monday, January 25, 2010 18498*/\n\t\t\tvar d=retVal[2];\n\t\t\tvar p=retVal[3];\n\t\t\tvar p = p.split(\"\");\n\t\t\tvar proc= p[0];\n\t\t\t/**/\n\t\n\t\t\t\n\t\t\tif(x==\"Y\"){\n              \n\t\t\tparent.f_term_add_modify.document.term_code_addmodify.sensitive.disabled=false;\n\t\t\t}\n\t\t\telse{\n\t\t\t\tparent.f_term_add_modify.document.term_code_addmodify.sensitive.disabled=true;\n\t\t\t\tif(parent.f_term_add_modify.document.term_code_addmodify.High_risk_cndn_code)\n\t\t\t\t\tparent.f_term_add_modify.document.term_code_addmodify.High_risk_cndn_code.disabled=true; // Newly Added for this CRF[BRU-HIMS-CRF-19.1]\n\n\t\t\t}\n\n\t\t\tif(z==\"Y\"){\n\t\t\t\t \n\t\t\tparent.f_term_add_modify.document.term_code_addmodify.notifiable.disabled=false;\n\t\t\t}\n\t\t\telse{\n\t\t\t\t\n\t\t\tparent.f_term_add_modify.document.term_code_addmodify.notifiable.disabled=true;\n\t\t\t}\n\t\t\t\n\t\t\t/*Monday, January 25, 2010 18498*/\n\t\t\t\tvar obj =parent.f_term_add_modify.document.term_code_addmodify.proc_diag;\n\t\t\t\tvar diagDesc = getLabel(\"Common.diagnosis.label\",\"Common\");\n\t\t\t\tvar procDesc = getLabel(\"Common.Procedure.label\",\"Common\");\n\t\t\t\tvar length  = obj.length;\n\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t{\n\t\t\t\t\tobj.remove(1);\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t\n\t\t\t\tif(d == \"Y\" && proc == \"N\")\n\t\t\t\t{\n\t\t\t\t\tvar opt= parent.f_term_add_modify.document.createElement(\'Option\');\n\t\t\t\t\topt.text=diagDesc; \n\t\t\t\t\topt.value=\'D\';\n\t\t\t\t\tobj.add(opt);\n\t\t\t\t\tparent.f_term_add_modify.document.createElement(\'Option\');\n\t\t\t\t}\n\t\t\t\telse if(proc == \"Y\" && d == \"N\")\n\t\t\t\t{\n\t\t\t\t\tvar opt= parent.f_term_add_modify.document.createElement(\'Option\');\n\t\t\t\t\topt.text=procDesc; \n\t\t\t\t\topt.value=\'P\';\n\t\t\t\t\tobj.add(opt);\n\t\t\t\t\tparent.f_term_add_modify.document.createElement(\'Option\');\n\t\t\t\t}\n\t\t\t\telse if(d==\"Y\" && proc == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tvar opt1= parent.f_term_add_modify.document.createElement(\'Option\');\n\t\t\t\t\tvar opt2= parent.f_term_add_modify.document.createElement(\'Option\');\n\t\t\t\t\topt1.text = diagDesc;\n\t\t\t\t\topt1.value=\'D\';\n\t\t\t\t\topt2.text = procDesc;\n\t\t\t\t\topt2.value=\'P\';\n\t\t\t\t\tobj.add(opt1);\n\t\t\t\t\tobj.add(opt2);\n\t\t\t\t\tparent.f_term_add_modify.document.createElement(\'Option\');\n\t\t\t\t}\n\t\t\t\t/**/\n\t\t\t\n\t\tdocument.forms[0].diag_spec_yn.value = d;\t\t\n\t\tdocument.forms[0].proc_spec_yn.value = proc;\t\n\t\t\n\t\tparent.f_term_add_modify.document.term_code_addmodify.proc.value = document.forms[0].proc_spec_yn.value\n\t\tparent.f_term_add_modify.document.term_code_addmodify.diag.value = document.forms[0].diag_spec_yn.value\n\t\t\t\n\t/*Monday, January 25, 2010 18499*/\t\t\n\t//parent.f_term_add_modify.document.term_code_addmodify.code_indicator.disabled=false;\nif(d==\"Y\")\n\tparent.f_term_add_modify.document.term_code_addmodify.code_indicator.disabled=false;\nelse\n\tparent.f_term_add_modify.document.term_code_addmodify.code_indicator.disabled=true;\n/**/\n\t\n\t\n\tparent.f_term_add_modify.document.term_code_addmodify.mode.value=\"\";\n\tif(termsetid!=\"\")\n\t{\n\t\t\n\t\tparent.f_term_add_modify.document.term_code_addmodify.termcode.value = termsetid;\n\t\tparent.f_term_result_header.document.term_code_result_header.termsetid.value= termsetid;\n\t\tparent.f_term_add_modify.document.term_code_addmodify.termsetid.value = termsetid;\n\t\tparent.f_term_add_modify.document.term_code_addmodify.codelevel.value = \"1\";\n\t\t// This part is for getting LEVEL value of the selected text in the list box and \n\t\t//display as legend in 2nd frame\n\t\tvar htmlvalue = \"<html><body onKeyDown=\'lockKey()\'><form name=\'dynamic_value\' method=\'post\' action=\'../../eMR/jsp/TerminologyCodeDynamicValues.jsp\'><input type=\'hidden\' name=\'termsetid\' value=\'\"+termsetid+\"\'><input type=\'hidden\' name=\'icd_termset\' value=\'\"+icd_termset+\"\'></form></body></html>\"\n\t\tparent.blankFrame.document.write(htmlvalue);\n\t\tparent.blankFrame.document.dynamic_value.submit();\n\t\t// End of getting values.\n\t\t// This part is for drawing table dynamically in the third frame according to the\n\t\t// selected value in the list box.\n\t\tvar htmlresvalue = \"<html><body onKeyDown=\'lockKey()\'><form name=\'dynamic_result\' id=\'dynamic_result\' method=\'post\' action=\'../../eMR/jsp/TerminologyCodeResult.jsp\'><input type=\'hidden\' name=\'termsetid\' id=\'termsetid\' value=\'\"+termsetid+\"\'><input type=\'hidden\' name=\'diag_spec_yn\' id=\'diag_spec_yn\' value=\'\"+d+\"\'><input type=\'hidden\' name=\'proc_spec_yn\' id=\'proc_spec_yn\' value=\'\"+proc+\"\'></html>\"\n\t\tparent.f_term_code_result.document.write(htmlresvalue);\n\t\tparent.f_term_code_result.document.dynamic_result.submit();\n\t\t\n\t\t\n\t\t// End of drawing table.\n\t\t// This part is for drawing table dynamically in the third frame according to the\n\t\t// selected value in the list box for classification level description.\n\t\tvar htmlclassvalue = \"<html><body onKeyDown=\'lockKey()\'><form name=\'class_level\' id=\'class_level\' method=\'post\' action=\'../../eMR/jsp/TerminologyCodeDisplayLevels.jsp\'><input type=\'hidden\' name=\'codelevel\' id=\'codelevel\' value=\'1\'><input type=\'hidden\' name=\'termsetid\' id=\'termsetid\' value=\'\"+termsetid+\"\'><input type=\'hidden\' name=\'termcode\' id=\'termcode\' value=\'\"+termsetid+\"\'></html>\"\n\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.write(htmlclassvalue);\n\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.class_level.submit();\n\t\t// End of drawing table for classification level.\n\t\tparent.f_term_selected_frms.f_term_selected_values.document.location.href=\"../../eMR/jsp/TerminologyCodeSelectedValues.jsp\";\n\t\tparent.messageFrame.document.location.href = \"../../eCommon/jsp/MstCodeError.jsp\";\n\t}\n\telse\n\t{\t\t\n\t\tparent.f_term_result_header.document.term_code_result_header.termsetid.value=\"\";\n\t\t//document.getElementById(\"dynlevel\").innerText=\"\";\n\t\tparent.f_term_result_header.document.getElementById(\"dynlevel\").innerText=\"\";\t\tparent.f_term_code_result.document.location.href=\"../../eCommon/html/blank.html\";\n\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.location.href=\"../../eCommon/html/blank.html\";\n\t";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="\t//parent.f_term_selected_frms.f_term_selected_values.document.location.href=\"../../eMR/jsp/TerminologyCodeSelectedValues.jsp\";\n\t\tparent.f_term_add_modify.document.location.href=\"../../eMR/jsp/TerminologyCodeAddModify.jsp\";\n\t\tparent.f_term_selected_frms.f_term_selected_values.document.location.href=\"../../eCommon/html/blank.html\";\n\t}\n}\n</SCRIPT>\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n<FORM METHOD=POST ACTION=\"\" target=\"messageFrame\" name=\"frm_terminology_code\" id=\"frm_terminology_code\">\n<TABLE border=\"0\" cellpadding=\"5\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n<TR>\n\t<TD class=\'label\' width=\'35%\' >";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block9 ="</TD>\n\t<TD class=\'fields\' width=\'35%\'><SELECT name=\"terminology_set\" id=\"terminology_set\"  onchange=\"getdefnlevels()\">\n\t\t<OPTION value=\"\">--------------";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="--------------</OPTION>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\n\t\t</SELECT><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</TD>\n\t<TD  class=\"label\" width=\"20%\" ></TD>\n\t<TD  class=\"label\" width=\'10%\' ></TD>\n</TR>\n</TABLE>\n<INPUT TYPE=\"hidden\" name=\'dyanmic_level\' id=\'dyanmic_level\' value=\"\">  \n<INPUT TYPE=\"hidden\" name=\"diag_spec_yn\" id=\"diag_spec_yn\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"proc_spec_yn\" id=\"proc_spec_yn\" value=\"\">\n</FORM>\n</body>\n</html>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8");
String locale					= (String)session.getAttribute("LOCALE");
Connection con					= null;
ResultSet termcodeRs			= null;
PreparedStatement termcodeStmt	= null;
String termcodeSql				= "";
String termsetid				= "";
String termsetdesc				= "";
//String defnlevel = "";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

		try
		{
			con = ConnectionManager.getConnection(request);
			termcodeSql = "select term_set_id,mr_get_desc.mr_term_set(term_set_id,'"+locale+"',1)term_set_desc from MR_TERM_SET where eff_status='E' order by term_set_desc";
			termcodeStmt = con.prepareStatement(termcodeSql);
			termcodeRs = termcodeStmt.executeQuery();
			if(termcodeRs!=null)
			{
				while(termcodeRs.next())
				{
					termsetid = termcodeRs.getString("term_set_id");
					termsetdesc = termcodeRs.getString("term_set_desc");
					out.println("<option value='"+termsetid+"'>"+termsetdesc+"</option>");
				}
				if(termcodeRs!=null) termcodeRs.close();
				if(termcodeStmt!=null) termcodeStmt.close();
			}

		}
		catch (Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(termcodeRs!=null) termcodeRs.close();
			if(termcodeStmt!=null) termcodeStmt.close();
			ConnectionManager.returnConnection(con,request);
		}
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TerminologySet.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }
}
