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
import java.util.*;
import java.net.*;
import com.ehis.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;

public final class __vwactiveproblemsquery extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/vwActiveProblemsquery.jsp", 1743671828122L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="<!--,oracle.jdbc.driver.*-->\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n\t<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\n<Script language=\'javascript\' src=\'../../eCommon/js/common.js\'></Script>\n<script language=\'javascript\'src=\'../../eMR/js/vwActiveProblems.js\' ></script>\n<script>\nasync function showEncounter(enc,patid,Patient_Class)\n{\n\t\n\tvar call_function = \"VIEW_ENCOUNTER_DTLS\";\n\tvar jsp_name=\"CurrentEncounterMain.jsp\";\n\tvar win_height = \"98vh\";\n\tvar win_width= \"75vw\";\n\tvar retVal = \tnew String();\n\tvar dialogHeight= win_height ;\n\tvar dialogWidth\t= win_width ;\n\tvar dialogTop = \"58\" ;\n\tvar center = \"1\" ;\n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \";\" ;\n\tvar arguments\t= \"\" ;\n\tretVal = await window.showModalDialog(\"../../eMR/jsp/\"+jsp_name+\"?encounterId=\"+enc+\"&call_function=\"+call_function+\"&patientId=\"+patid+\"&Patient_Class=\"+Patient_Class,arguments,features);\n}\n\nasync function authorizeFn(obj)\n{\n\tvar pat_id = document.forms[0].patID.value;\n\n\tif(obj.id==\"Sensitive\")\n\t{\n\t\tvar val1 = \'V\' ;\n\t\tvar val2 = \'Ass\' ;\n\t\tvar val3=\'C\'\n\t\tif(\'Y\'==\"PatientQueue\")\n\t\t\tval3=\"O\";\n\t\tvar val = val1+\'/\'+val2+\'/\'+val3+\'/\';\n\n\t\tvar retVal = \tnew String();\n\t\tvar dialogHeight= \"9vh\" ;\n\t\tvar dialogWidth\t= \"25vw\" ;\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\t\tvar arguments\t= \"\" ;\n\t\tretVal = await window.showModalDialog(\"../../eMR/jsp/AuthorizeMRAccess.jsp?constr=\"+val,arguments,features);\n\t\tif(retVal==\"T\")\n\t\t{\n\t\t\twindow.location.href=\'../../eMR/jsp/vwActiveProblemsquery.jsp?sensitive_disp=Y&Patient_Id=\'+pat_id;\n\t\t\tdocument.getElementById(\"authorize\").value = getLabel(\"Common.Normal.label\",\"Common\");//\"Normal\";\n\t\t}\n\t\t/*else\n\t\t{\t\t\t\n\t\t\twindow.location.href=\'../../eMR/jsp/vwActiveProblemsquery.jsp?sensitive_disp=Y&Patient_Id=\'+pat_id;\n\t\t}*/\t\t\n\t}\n\telse\n\t{\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\twindow.location.href=\'../../eMR/jsp/vwActiveProblemsquery.jsp?sensitive_disp=N&Patient_Id=\'+pat_id\n\t\tdocument.getElementById(\"authorize\").value = getLabel(\"Common.Sensitive.label\",\"Common\");//\"Sensitive\";\n\t}\n}\n\n</script>\n</head>\n<body OnMouseDown=\'CodeArrest();\'  onKeyDown = \'lockKey()\' class=\'CONTENT\'>      \n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name = \"qryform\" action=\"../../eMR/jsp/vwActiveProblemsquery.jsp\" method =\'post\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\n\t<tr>\n\t\t\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\n\t</tr>\n</table>\n<table width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</table>\n\n\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n<th nowrap>+</th>\n<th nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n<th nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n<!-- <th nowrap>Status</th> -->\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<a href=\"javascript:showEncounter(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\">+</a>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<script >\n\t\tif (document.getElementById(\"next\"))\n\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<script >\n\t\tif (document.getElementById(\"next\"))\n\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n<!--Below line commented for ML-MMOH-CRF-0868-->\n<!--</td></tr>-->\n</table>\n<center>\n</center>\n<input type=\"hidden\" name=\"patID\" id=\"patID\"       value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n</form>\n\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale	= (String)session.getAttribute("LOCALE");
	String userid	= p.getProperty( "login_user" ) ;

	String patID=request.getParameter("Patient_Id");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String facility_id = (String) session.getValue("facility_id");


            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;
Connection conn =null;

Statement stmt=null;
ResultSet rset=null;
ResultSet rs=null;
int maxRecord = 0;
int sensitive_cnt = 0;
String diag_code_scheme="";
String onset_date = "";
String onset_date_display = "";
String diag_desc = "";
String diag_code = "";
String diag_code_scheme_desc = "";
String primary_diag = "";
String problem_status = "";
String sensitive_disp = "";
String sensitive_auth = "";
String sensitive_yn ="";
String visit_adm_date_time="";
String visit_adm_date_time_display="";
String patient_class="";
String discharge_date_time="";
String discharge_date_time_display="";
String onset_facility_id="";
String encounter_id="";
String patient_id="";
// 01 Oct 2010 IN024038 for Principl daignosis check mark
String diag_class_type="";

//Added for this CRF ML-MMOH-CRF-0868 
boolean isSupportingDiag = false ; 
String supporting_code="", supporting_desc="";


            _bw.write(_wl_block9Bytes, _wl_block9);

try{
	conn = ConnectionManager.getConnection(request) ;
	stmt = conn.createStatement();
	
	//Below line added for this CRF ML-MMOH-CRF-0868 
	isSupportingDiag=CommonBean.isSiteSpecific(conn, "MR","ACTIVE_PROB_LIST_EXT_CAUSES");
	
	sensitive_disp = request.getParameter("sensitive_disp");
	if (sensitive_disp==null) sensitive_disp = "";

	String strsql1="select diag_code_scheme from mr_parameter";
	rs = stmt.executeQuery(strsql1);
	if (rs.next())
		diag_code_scheme=  rs.getString(1);

	/*strsql1="select count(*) as total from pr_problem_vw where patient_id = '"+patID+"' and nvl(problem_status,'O')!='C' and nvl(sensitive_yn,'N') != 'Y' and diag_code_scheme= '"+diag_code_scheme+"'";
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	stmt = conn.createStatement();
	rs = stmt.executeQuery(strsql1);
    
	if (rs.next())
	{
//		maxRecord = rs.getInt("total");
	}
	*/
	strsql1="select '1' from mr_user_access_rights_vw where appl_user_id = '"+userid+"' and access_type = 'V' and facility_id = '"+facility_id+"' and access_scope= 'SD'";

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	stmt = conn.createStatement();

	rs = stmt.executeQuery(strsql1);
	if (rs.next())
		sensitive_auth = "Y";	
	

	strsql1="select count(*) as total from pr_problem where patient_id = '"+patID+"' and nvl(problem_status,'O')!='C' and nvl(sensitive_yn,'N') = 'Y' and diag_code_scheme= '"+diag_code_scheme+"'";

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	stmt = conn.createStatement();

	rs = stmt.executeQuery(strsql1);    
	if (rs.next())
		sensitive_cnt = rs.getInt("total");
   
	//String strsql2="select a.patient_id,a.onset_encounter_id,a.onset_facility_id,a.srl_no,decode(b.patient_class,'IP','Inpatient','OP','Outpatient','EM','Emergency','DC','DayCare') patient_class,to_char(b.visit_adm_date_time,'dd/mm/yyyy') visit_adm_date_time,to_char(b.discharge_date_time,'dd/mm/yyyy') discharge_date_time,to_char(a.onset_date,'dd/mm/yyyy') onset_date, a.sensitive_yn, a.diag_desc,a.diag_code,a.diag_code_scheme_desc, a.significant_yn,	decode(a.diag_type,'P','Provisional','D','Differential','F','Final','') diagtype,nvl(a.PRIMARY_YN,'N') primary_diag, decode(a.problem_status, 'C', 'Closed', 'A','Active', 'B', 'Better', 'W', 'Worse', 'S', 'Same') problem_status, nvl(a.sensitive_yn,'N') sensitive_yn from pr_problem_vw a,pr_encounter b where a.onset_facility_id = b.facility_id and a.onset_encounter_id = b.encounter_id and a.patient_Id='"+patID+"' and  nvl(a.problem_status,'O')!='C' and a.diag_code_scheme= '"+diag_code_scheme+"' order by diagtype,onset_date desc ";

	// String strsql2="select a.patient_id, a.onset_encounter_id,a.onset_facility_id,a.srl_no,		 AM_GET_DESC.AM_PATIENT_CLASS(b.patient_class,'"+locale+"','2') patient_class,to_char(b.visit_adm_date_time,'dd/mm/yyyy') 		 visit_adm_date_time, to_char(b.discharge_date_time,'dd/mm/yyyy') discharge_date_time,to_char(a.onset_date,'dd/mm/yyyy') onset_date, a.sensitive_yn, a.diag_desc,a.diag_code, DECODE(A.DIAG_CODE_SCHEME,'1', 'ICD10','2', 'ICD9-CM','5','READ') diag_code_scheme_desc,  a.significant_yn, a.diag_type diagtype, nvl(a.PRIMARY_YN,'N') primary_diag, a.problem_status problem_status,		 nvl(a.sensitive_yn,'N') sensitive_yn from pr_problem a, pr_encounter b where a.onset_facility_id = b.facility_id and a.onset_encounter_id = b.encounter_id and a.patient_Id='"+patID+"' and  nvl(a.problem_status,'O')!='C' and 	 a.diag_code_scheme= '"+diag_code_scheme+"' order by diagtype, onset_date DESC";
	//Maheshwaran k commented as on 17/09/2013
	//String strsql2="SELECT   a.patient_id, a.onset_encounter_id, a.onset_facility_id, a.occur_srl_no,am_get_desc.am_patient_class (b.patient_class, 'en','2') patient_class, TO_CHAR (b.visit_adm_date_time, 'dd/mm/yyyy') visit_adm_date_time, TO_CHAR (b.discharge_date_time, 'dd/mm/yyyy') discharge_date_time,TO_CHAR (a.onset_date, 'dd/mm/yyyy') onset_date,a.term_code_short_desc diag_desc, a.term_code diag_code, a.term_set_id, a.curr_status,c.DIAG_CLASS_TYPE diag_class_type FROM pr_diagnosis a, pr_encounter b,MR_DIAG_CLASS c  WHERE a.onset_facility_id = b.facility_id AND a.onset_encounter_id = b.encounter_id AND a.patient_id = '"+patID+"' AND a.curr_status != 'E' AND a.DIAG_CLASS_CODE=c.DIAG_CLASS_CODE(+) /*AND a.term_set_id = 'ICD10'*/ ORDER BY onset_date DESC";
	String strsql2="SELECT   a.patient_id, a.encounter_id onset_encounter_id, a.facility_id onset_facility_id, a.occur_srl_no,am_get_desc.am_patient_class (b.patient_class, 'en','2') patient_class, TO_CHAR (b.visit_adm_date_time, 'dd/mm/yyyy') visit_adm_date_time, TO_CHAR (b.discharge_date_time, 'dd/mm/yyyy') discharge_date_time,TO_CHAR (a.recorded_date_time, 'dd/mm/yyyy') onset_date,a.term_code_short_desc diag_desc, a.term_code diag_code, a.term_set_id, a.status curr_status,c.DIAG_CLASS_TYPE diag_class_type FROM pr_diagnosis_enc_dtl a, pr_encounter b,MR_DIAG_CLASS c  WHERE a.facility_id = b.facility_id AND a.encounter_id = b.encounter_id AND a.patient_id = '"+patID+"' AND a.status != 'E' AND a.DIAG_CLASS_CODE=c.DIAG_CLASS_CODE(+) /*AND a.term_set_id = 'ICD10'*/ ORDER BY onset_date DESC";

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	stmt = conn.createStatement();

	rs = stmt.executeQuery(strsql2);
	
	if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
			{
				rs.next() ;
			 }

	 
	 if(rs !=null) 
	{
	while ( i<=end && rs.next() )
	{
		if(maxRecord==0)
		{


            _bw.write(_wl_block10Bytes, _wl_block10);

	if(!(start <= 1))
	{
		out.println("<td align='right' id='prev' width='100%'><a href='../../eMR/jsp/vwActiveProblemsquery.jsp?from="+(start-14)+"&to="+(end-14)+"&Patient_Id="+patID+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
	
	}
	else{
	out.println("<td align='right' id='next' style='visibility:hidden'><a id = 'nextval' href='../../eMR/jsp/vwActiveProblemsquery.jsp?from="+(start+14)+"&to="+(end+14)+"&Patient_Id="+patID+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
	}

            _bw.write(_wl_block11Bytes, _wl_block11);
 	
		
		if (!sensitive_disp.equals("Y"))
		{
			
			if (sensitive_auth.equals("Y") && sensitive_cnt > 0)
				out.println("<tr><td class='button'><input type='button' name='authorize' id='authorize' id='Sensitive'  value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sensitive.label","common_labels")+"' class='button' onclick='authorizeFn(this);'></td></tr>");
		}
		else
		{
			
			out.println("<tr><td class='button'><input type='button' name='authorize' id='authorize'  id='Normal'  value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+"' class='button' onclick='authorizeFn(this);'></td></tr>");
		}
	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

 	
		}
		String classValue = "" ;
		visit_adm_date_time =rs.getString("visit_adm_date_time");
		if(visit_adm_date_time == null) 
		{
			visit_adm_date_time="&nbsp;";
			visit_adm_date_time_display="&nbsp;";
		}
		else
			visit_adm_date_time_display = DateUtils.convertDate(visit_adm_date_time,"DMY","en",locale);
		
		patient_class =rs.getString("patient_class");
		if(patient_class == null) patient_class="&nbsp;";
		discharge_date_time =rs.getString("discharge_date_time");
		if(discharge_date_time == null)
		{
			discharge_date_time="&nbsp;";
			discharge_date_time_display="&nbsp;";
		}
		else
			discharge_date_time_display = DateUtils.convertDate(discharge_date_time,"DMY","en",locale);
		encounter_id=rs.getString("onset_encounter_id");
		onset_facility_id=rs.getString("onset_facility_id");
		patient_id=rs.getString("patient_id");
		onset_date =rs.getString("onset_date");
		if(onset_date == null) 
		{
			onset_date="&nbsp;";
			onset_date_display="&nbsp;";
		}
		else
			onset_date_display = DateUtils.convertDate(onset_date,"DMY","en",locale);
		diag_desc 	= rs.getString("diag_desc");
		if(diag_desc == null) diag_desc="&nbsp;";
		diag_code	= rs.getString("diag_code");
		if(diag_code == null) diag_code="&nbsp;";
		diag_code_scheme_desc =rs.getString("term_set_id"); 
		
		
		//Below line added for this CRF ML-MMOH-CRF-0868
		supporting_code="";supporting_desc="";
		if(isSupportingDiag){
		String externalDiagCode[]  = eMR.MRCommonBean.getExternalCauseDiagCode(conn,patID,diag_code_scheme_desc,diag_code);			    
		    if(externalDiagCode.length==2){
				supporting_code=" > "+externalDiagCode[0];				 
				supporting_desc=" > "+externalDiagCode[1];				 
			}
        System.err.println("vwActiveProblemsquery.jsp externalDiagCode.length=====>"+externalDiagCode.length);			
        }  
        		
	   //End this CRF ML-MMOH-CRF-0868
		
		if(diag_code_scheme_desc == null) diag_code_scheme_desc ="&nbsp;";
		/*
		primary_diag =rs.getString("primary_diag");
		if(primary_diag == null) primary_diag = "&nbsp;";
		problem_status =rs.getString("problem_status");
		if(problem_status == null) problem_status="&nbsp;";
		sensitive_yn = rs.getString("sensitive_yn");
		if(sensitive_yn == null) sensitive_yn="";
		*/
		//if (!sensitive_yn.equals("Y") || (sensitive_disp.equals("Y") && sensitive_yn.equals("Y")))
		//{

			// 01 Oct 2010 IN024038 for Principl daignosis check mark
			diag_class_type=rs.getString("diag_class_type");			
			if(diag_class_type == null) diag_class_type="&nbsp;";
			
			

			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			if (sensitive_disp.equals("Y") && sensitive_yn.equals("Y"))
				classValue = "PATQRED" ;
				out.println("<tr><td nowrap class='" + classValue + "'>");
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block17Bytes, _wl_block17);

			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(patient_class);

			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(visit_adm_date_time_display);

			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(discharge_date_time_display);

			out.println("</td><td nowrap class='" + classValue + "'>");
//			String code = rs.getString("onset_date");

			out.println(onset_date_display+"</a></td><td style='WORD-BREAK:BREAK-ALL;' class='" + classValue + "'>");
			out.println(rs.getString("diag_desc")+supporting_desc); //Modified for this CRF ML-MMOH-CRF-0868
			out.println("</a></td><td style='WORD-BREAK:BREAK-ALL;' class='" + classValue + "'>");
			out.println(rs.getString("diag_code")+supporting_code); //Modified for this CRF ML-MMOH-CRF-0868
			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(rs.getString("term_set_id"));
			out.println("</td><td align='center' nowrap class='" + classValue + "'>");
			// 01 Oct 2010 IN024038 for Principl daignosis check mark
			if (diag_class_type.equals("PD")) 
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("&nbsp;");
			//Below line commented for ML-MMOH-CRF-0868		
			//out.println("</td><td nowrap align='center' class='" + classValue + "'>");
			
			out.println("</td></tr>");
			
		//}
		i++;
		maxRecord++;
	  }//endwhile
}
	  if(i == 1)
	{
  		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}

	if ( maxRecord < 14 || (!rs.next()) ) {
	
            _bw.write(_wl_block18Bytes, _wl_block18);
 
			} else {
            _bw.write(_wl_block19Bytes, _wl_block19);
}
  	
}catch(Exception e){
		//out.print(e.toString());
		e.printStackTrace();

}
	finally   {
		try
		{

	if(rs!=null)	rs.close();
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
		}
		catch(Exception e){

}

	ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( patID ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(start));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(end));
            _bw.write(_wl_block23Bytes, _wl_block23);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdate.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ICDCode.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.scheme.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.primary.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
