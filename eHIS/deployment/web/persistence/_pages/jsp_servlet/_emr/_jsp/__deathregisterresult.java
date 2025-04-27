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
import java.text.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __deathregisterresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DeathRegisterResult.jsp", 1743665280288L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<head>\n\t<script src=\"../../eOP/js/menu.js\" language=\"JavaScript1.2\"></script>\n\t<script src=\"../../eOA/js/QueryLocnForDay.js\"></script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\"../../eMR/js/CreatePatientFile.js\"></script>\n\t<script>\n\t\t/*function call_death_reg(encid, patid, practId, pat_class, spclty_code, sex, dob, pract_type,  pat_curr_locn_code)\n\t\t{\n\t\t\t\n\t\t\t/*var dialogHeight= \"41\";\n\t\t\tvar dialogWidth = \"65\";\n\t\t\tvar dialogTop\t= \"72\";\n\t\t\tvar center = \"1\" ;\n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tretVal = \t\n\t\t\t//window.showModalDialog(\"../../eMR/jsp/PaintDeathRegisterPatient.jsp?Patient_Id=\"+patid+\"&encounter_id=\"+encid+\"&practitioner_id=\"+practId+\"&call_from=MAINTAIN_DEATH_REGISTER\",arguments,features);\n\t\t\twindow.open(\"../../eMR/jsp/RecDiagnosis.jsp?cause_of_death=Y&modal_yn=Y&Locn_Code=\"+pat_curr_locn_code+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&speciality_code=\"+spclty_code+\"&patient_id=\"+patid+\"&encounter_id=\"+encid+\"&episode_id=\"+encid+\"&practitioner_id=\"+practId+\"&practitioner_type=\"+pract_type+\"&patient_class=\"+pat_class+\"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I\",arguments,features);\n\t\t\t*/\n\n\t\t\t/*var dialogHeight=\"41\";\n\t\t\tvar dialogWidth=\"65\";\n\t\t\tvar dialogTop=\"72\";\n\t\t\tvar center = \"1\" ;\n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar bodwidth  = window.screen.width+window.screen.width;\n\t        var\tbodheight = window.screen.height+window.screen.height;\n\n\t\t\tvar action_url=\"../../eMR/jsp/RecDiagnosis.jsp?cause_of_death=Y&modal_yn=Y&Locn_Code=\"+pat_curr_locn_code+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&speciality_code=\"+spclty_code+\"&patient_id=\"+patid+\"&encounter_id=\"+encid+\"&episode_id=\"+encid+\"&practitioner_id=\"+practId+\"&practitioner_type=\"+pract_type+\"&patient_class=\"+pat_class+\"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I\";\n\n\n\tvar title=\"\";\n\n\twindow.open(action_url,title,\"height=\"+bodheight+\",width=\"+bodwidth+\",top=0,status=0,toolbar=no,menubar=no,location=no,left=0,right=0,bottom=0,this.minimise=no\");\n\t\t\n\t\t\tparent.frames[2].location.href=\"../../eMR/jsp/DeathRegisterResult.jsp?PatientId=\"+\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'+\"&EncounterId=\"+\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'+\"&admission_from_date=\"+\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'+\"&admission_to_date=\"+\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'+\"&discharge_from_date=\"+\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'+\"&discharge_to_date=\"+\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\t\t}*/\n\t\tasync function call_death_reg(encid, patid, practId, pat_class, spclty_code, sex, dob, pract_type,  pat_curr_locn_code,finalize_yn,visit_adm_date)\n\t\t{\n\t\t\t/*var dialogHeight= \"41\";\n\t\t\tvar dialogWidth = \"65\";\n\t\t\tvar dialogTop\t= \"72\";\n\t\t\tvar center = \"1\" ;\n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tretVal = \t\n\t\t\t//window.showModalDialog(\"../../eMR/jsp/PaintDeathRegisterPatient.jsp?Patient_Id=\"+patid+\"&encounter_id=\"+encid+\"&practitioner_id=\"+practId+\"&call_from=MAINTAIN_DEATH_REGISTER\",arguments,features);\n\t\t\twindow.open(\"../../eMR/jsp/RecDiagnosis.jsp?cause_of_death=Y&modal_yn=Y&Locn_Code=\"+pat_curr_locn_code+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&speciality_code=\"+spclty_code+\"&patient_id=\"+patid+\"&encounter_id=\"+encid+\"&episode_id=\"+encid+\"&practitioner_id=\"+practId+\"&practitioner_type=\"+pract_type+\"&patient_class=\"+pat_class+\"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I\",arguments,features);\n\t\t\t*/\n\n\t\t\tvar dialogHeight=\"1000px\";\n\t\t\tvar dialogWidth=\"1650px\";\n\t\t\tvar dialogTop=\"100\";\n\t\t\tvar center = \"1\" ;\n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ;\n//\t\t\tvar bodwidth  = window.screen.width+window.screen.width;\n//\t        var\tbodheight = window.screen.height+window.screen.height;\n\n//\t\t\tvar action_url=\"../../eMR/jsp/RecDiagnosis.jsp?cause_of_death=Y&modal_yn=Y&Locn_Code=\"+pat_curr_locn_code+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&speciality_code=\"+spclty_code+\"&patient_id=\"+patid+\"&encounter_id=\"+encid+\"&episode_id=\"+encid+\"&practitioner_id=\"+practId+\"&practitioner_type=\"+pract_type+\"&patient_class=\"+pat_class+\"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I\";\n\t\t\tvar action_url=\"../../eMR/jsp/DeathRegisterFrames.jsp?cause_of_death=Y&modal_yn=Y&Locn_Code=\"+pat_curr_locn_code+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&speciality_code=\"+spclty_code+\"&patient_id=\"+patid+\"&encounter_id=\"+encid+\"&episode_id=\"+encid+\"&practitioner_id=\"+practId+\"&practitioner_type=\"+pract_type+\"&patient_class=\"+pat_class+\"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I&finalize_yn=\"+finalize_yn+\"&visit_adm_date=\"+visit_adm_date;\n\t\tvar title=\"\";\n\t\tvar retVal=await top.window.showModalDialog(action_url,title,features);\n\t\tif(retVal==undefined){\n\t\t\tvar xmlHttp \t= new XMLHttpRequest();\n\t\t\txmlHttp.open(\"POST\",\"../../eMR/jsp/DearthRegisterValidation.jsp?mode=RemoveSessionVals\",false);\n\t\t\txmlHttp.send(null);\t\t\n\t\t\tresponseText=xmlHttp.responseText;\n\t}\n\t\t\tparent.frames[2].location.reload();\n\t\t\t\t//parent.frames[2].location.href=\"../../eMR/jsp/DeathRegisterResult.jsp?PatientId=\"+\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'+\"&deceased_from_date=\"+\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'+\"&deceased_to_date=\"+\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'+\"&status=\"+\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\';\n}\n\n\t\tasync function modify_death_date(encid, patid,deceasedDate,dischargeDate,admissionDate,admission_type,pract_id,remarks)\n\t\t{\n\t\t\t\n\t\t\tvar dialogHeight= \"25vh\";\n\t\t\tvar dialogWidth = \"50vw\";\n\t\t\tvar dialogTop\t= \"center\";\n\t\t\tvar center = \"1\" ;\n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ;\n\t\t\t\n\t\t\t//alert(\"admission_type:\"+admission_type);\n\t\t\t//alert(\"pract_name:\"+pract_name)\n\t\t\tretVal = \t\n\t\t\n\t\t\t//window.showModalDialog(\"../../eMR/jsp/AddModifyDeceasedDetailsFrame.jsp?patient_id=\"+patid+\"&encounter_id=\"+encid+\"&deceaseddate=\"+deceasedDate+\"&dischargeDate=\"+dischargeDate+\"&admissionDate=\"+admissionDate+\"&admission_type=\"+unescape(admission_type)+\"&pract_id=\"+pract_id+\"&pract_name=\"+pract_name+\"&remarks=\"+remarks+\"&call_from=MODIFY_DEATH_DETAILS&episode_type=I\",arguments,features);\n\t\t\t//window.showModalDialog(\"../../eMR/jsp/AddModifyDeceasedDetailsFrame.jsp?patient_id=\"+patid+\"&encounter_id=\"+encid+\"&deceaseddate=\"+deceasedDate+\"&dischargeDate=\"+dischargeDate+\"&admissionDate=\"+admissionDate+\"&admission_type=\"+encodeURIComponent(admission_type)+\"&pract_id=\"+pract_id+\"&pract_name=\"+encodeURIComponent(pract_name)+\"&remarks=\"+encodeURIComponent(remarks)+\"&call_from=MODIFY_DEATH_DETAILS&episode_type=I\",arguments,features);\n\n\t\t\tawait window.showModalDialog(\"../../eMR/jsp/AddModifyDeceasedDetailsFrame.jsp?patient_id=\"+patid+\"&encounter_id=\"+encid+\"&deceaseddate=\"+deceasedDate+\"&dischargeDate=\"+dischargeDate+\"&admissionDate=\"+admissionDate+\"&admission_type=\"+encodeURIComponent(admission_type)+\"&pract_id=\"+pract_id+\"&remarks=\"+encodeURIComponent(remarks)+\"&call_from=MODIFY_DEATH_DETAILS&episode_type=I\",arguments,features);\n\t\t\n\t\t\tparent.frames[2].location.href=\"../../eMR/jsp/DeathRegisterResult.jsp?PatientId=\"+\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\n\t\t}\n\t</script>\n</head>\n<body OnMouseDown=\'CodeArrest();\' onKeyDown=\'lockKey()\'>\n<form name=\'DeathRegisterResult\' id=\'DeathRegisterResult\'   method=\"post\"  target =\"messageFrame\">\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<P>\n\t\t<table align=\'right\'>\n\t\t<tr>\n\t\t\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\n\t\t</tr>\n\t\t</table><br>\n\t\t</P>\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<th class=\'columnheader\' nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t<th class=\'columnheader\' nowrap>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th> \n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<!-- <a href=\"javascript:modify_death_date(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\')\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</a> -->\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<script >\n\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<script >\n\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t</table>\n\t<br><center>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</center>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);


	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String FacilityId		= (String) session.getValue( "facility_id" ) ;
	String loginUser = (String)session.getValue("login_user");
	String locale	= (String) session.getAttribute("LOCALE");
	String sql ;
	String PatientId		=	request.getParameter("PatientId") ;
	//String AdmissionDate	=	request.getParameter("AdmissionDate") ;
	String Admission_From_Date	=	request.getParameter("admission_from_date") ;
	String Admission_To_Date	=	request.getParameter("admission_to_date") ;
	String EncounterId		=	request.getParameter("EncounterId") ;
	//String DischargeDate	=	request.getParameter("DischargeDate") ;
	String Discharge_From_Date	=	request.getParameter("discharge_from_date") ;
	String Discharge_To_Date	=	request.getParameter("discharge_to_date") ;
	
	String deceased_from_date	=	request.getParameter("deceased_from_date") ;
	String deceased_to_date	=	request.getParameter("deceased_to_date") ;
	String status	=	request.getParameter("status") ;
	String discharged_yn = "";


	


	if(PatientId	== null || PatientId.equals("null"))		PatientId = "";
	if(EncounterId	== null || EncounterId.equals("null"))		EncounterId = "";
	//if(AdmissionDate == null || AdmissionDate.equals("null"))	AdmissionDate = "";
	//if(DischargeDate	== null || DischargeDate.equals("null"))DischargeDate = "";
	if(Admission_From_Date == null || Admission_From_Date.equals("null"))	Admission_From_Date = "";
	if(Admission_To_Date	== null || Admission_To_Date.equals("null"))	Admission_To_Date = "";
	if(Discharge_From_Date == null || Discharge_From_Date.equals("null"))	Discharge_From_Date = "";
	if(Discharge_To_Date	== null || Discharge_To_Date.equals("null"))	Discharge_To_Date = "";

	if(deceased_from_date == null || deceased_from_date.equals("null"))	deceased_from_date = "";
	if(deceased_to_date	== null || deceased_to_date.equals("null"))	deceased_to_date = "";
	if(status	== null || status.equals("null"))	status = "";


	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	if(whereClause	== null || whereClause.equals("null"))	whereClause = "";
	int start = 0 ;
	int end = 0 ;
    int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
		end = 20 ;
	else
		end = Integer.parseInt( to ) ;

	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	Connection conn = ConnectionManager.getConnection(request);	
try {
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Admission_From_Date));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Admission_To_Date));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Discharge_From_Date));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Discharge_To_Date));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Admission_From_Date));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Admission_To_Date));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Discharge_From_Date));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Discharge_To_Date));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(deceased_to_date));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(deceased_to_date));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(status));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Admission_From_Date));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Admission_To_Date));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Discharge_From_Date));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Discharge_To_Date));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(deceased_to_date));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(deceased_to_date));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(status));
            _bw.write(_wl_block18Bytes, _wl_block18);


		StringBuffer aesql = new StringBuffer();
		String oper_stn_id = "";
		
		aesql.append(" select oper_stn_id from am_user_for_oper_stn ");
		  aesql.append(" where appl_user_id= ? ");
		  aesql.append(" and facility_id=  ? ");
		
		  pstmt = conn.prepareStatement(aesql.toString());
		  pstmt.setString(1, loginUser);
		  pstmt.setString(2, FacilityId);

		  rs = pstmt.executeQuery();
		  if(rs.next())
			oper_stn_id=rs.getString(1);

		  if(rs!=null)rs.close();
		  if(pstmt!=null)pstmt.close();
		  if((aesql != null) && (aesql.length() > 0))
			{
				aesql.delete(0,aesql.length());
			} 


	StringBuffer Where = new StringBuffer();

	//Where.append(" where b.patient_id  = a.patient_id  and a.encounter_id = c.encounter_id  and a.facility_id = ? and a.patient_id = nvl(?,a.patient_id) and a.encounter_id = nvl(?,a.encounter_id) and trunc(visit_adm_date_time)=nvl(to_date(?,'dd/mm/yyyy'),trunc(visit_adm_date_time)) and trunc(discharge_date_time)=nvl(to_date(?,'dd/mm/yyyy'),trunc(discharge_date_time)) and nvl(c.finalize_yn,'N')='N' ");

	//Where.append(" where b.patient_id  = a.patient_id  and a.encounter_id = c.encounter_id  and a.facility_id = ? and a.facility_id =c.facility_id and d.practitioner_id = a.attend_practitioner_id and d.pract_type = e.pract_type and a.patient_id = nvl(?,a.patient_id) and a.encounter_id = nvl(?,a.encounter_id) and trunc(visit_adm_date_time)>=nvl(to_date(?,'dd/mm/yyyy'),trunc(visit_adm_date_time)) and trunc(discharge_date_time)<=nvl(to_date(?,'dd/mm/yyyy'),trunc(discharge_date_time)) and nvl(c.finalize_yn,'N')='N' ");

	Where.append(" where b.patient_id  = a.patient_id  and a.encounter_id = c.encounter_id  and a.facility_id = ? and a.facility_id =c.facility_id  ");

	//9/14/2009
	Where.append(" AND (a.facility_id,a.assign_care_locn_type,a.assign_care_locn_code) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+FacilityId+"' and oper_stn_id ='"+oper_stn_id+"' and appl_user_id = '"+loginUser+"' and MAINTAIN_DEATH_REGISTER_YN = 'Y')   ");

	if(!PatientId.equals(""))
		Where.append(" and a.patient_id like '"+PatientId+"' ");

	//and a.patient_id = nvl(?,a.patient_id) and a.encounter_id = nvl(?,a.encounter_id) ");

	if(!Admission_From_Date.equals("") && !Admission_To_Date.equals(""))		
		Where.append(" and trunc(a.visit_adm_date_time) between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') ");
	
	if(!Discharge_From_Date.equals("") && !Discharge_To_Date.equals(""))	
		Where.append(" and trunc(a.discharge_date_time) between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') ");

	if(!deceased_from_date.equals("") && !deceased_to_date.equals(""))	
		Where.append(" and trunc(c.death_date_time) between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') ");

	if(!status.equals(""))
	{
		if(status.equals("R"))
		{
			Where.append(" and c.finalize_yn = 'N' ");
		}
		else if(status.equals("F"))
		{
			Where.append(" and c.finalize_yn = 'Y' ");
		}

	}
		
	//Where.append(" and nvl(c.finalize_yn,'N')='N' ");

	int maxRecord = 0;
		
	//sql = " select a.encounter_id, to_char(a.discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date, to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') admission_date, a.patient_id, b.patient_name, b.sex, a.attend_practitioner_id from PR_ENCOUNTER a, MP_PATIENT b, MR_DEATH_REGISTER_HDR c " + Where.toString() ;

	//sql = "select a.encounter_id, to_char(a.discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date,		to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') admission_date, a.patient_id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, b.sex, a.attend_practitioner_id, a.patient_class, d.pract_type, a.specialty_code, To_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth, a.pat_curr_locn_code from PR_ENCOUNTER a, MP_PATIENT b, MR_DEATH_REGISTER_HDR c, AM_PRACTITIONER d, AM_PRACT_TYPE e " + Where.toString() ;  
	
	//sql = "select a.encounter_id, to_char(a.discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date,		to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') admission_date, a.patient_id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, b.sex, a.attend_practitioner_id, a.patient_class, d.pract_type, a.specialty_code, To_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth, a.pat_curr_locn_code,to_char(a.deceased_date_time,'dd/mm/yyyy hh24:mi') deceased_date_time, decode(a.patient_class, 'IP',IP_GET_DESC.IP_ADMISSION_TYPE(a.visit_adm_type,'"+locale+"','2'),'DC',IP_GET_DESC.IP_ADMISSION_TYPE(a.visit_adm_type,'"+locale+"','2'),OP_GET_DESC.OP_VISIT_TYPE(a.facility_id,a.visit_adm_type,'"+locale+"','2')) admission_type,c.auth_practitioner_id,AM_GET_DESC.AM_PRACTITIONER(c.auth_practitioner_id,'"+locale+"','2') auth_practitioner_name,c.remarks,c.finalize_yn from PR_ENCOUNTER a, MP_PATIENT b, MR_DEATH_REGISTER_HDR c, AM_PRACTITIONER d, AM_PRACT_TYPE e " + Where.toString() ;  

		sql = "SELECT   a.encounter_id, TO_CHAR (a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date,TO_CHAR (a.EXP_DISCHARGE_DATE_TIME, 'dd/mm/yyyy hh24:mi') exp_discharge_date,        TO_CHAR (a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') admission_date,a.patient_id,DECODE ('"+locale+"','"+locale+"', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name,b.sex, a.attend_practitioner_id, a.patient_class,a.specialty_code,TO_CHAR (b.date_of_birth, 'dd/mm/yyyy') date_of_birth,a.pat_curr_locn_code,TO_CHAR (c.death_date_time,      'dd/mm/yyyy hh24:mi') deceased_date_time,DECODE(a.patient_class,'IP', ip_get_desc.ip_admission_type (a.visit_adm_type, 'en', '2'),'DC', ip_get_desc.ip_admission_type (a.visit_adm_type, 'en', '2'),    op_get_desc.op_visit_type (a.facility_id,a.visit_adm_type,'"+locale+"','2')) admission_type,c.auth_practitioner_id, am_get_desc.am_practitioner(c.auth_practitioner_id,'"+locale+"','2') auth_practitioner_name,c.remarks, c.finalize_yn,(select pract_type from am_practitioner where practitioner_id =  c.auth_practitioner_id) pract_type FROM pr_encounter a,mp_patient b,    mr_death_register_hdr c  " + Where.toString() ;  

	
	

	sql = sql +" order by encounter_id";
	//pstmt=conn.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	pstmt=conn.prepareStatement(sql.toString());
	pstmt.setString(1,FacilityId);
	//pstmt.setString(2,PatientId);
	//pstmt.setString(3,EncounterId);
	if(!Admission_From_Date.equals("") && !Admission_To_Date.equals(""))	
	{
		/*pstmt.setString(4,Admission_From_Date);
		pstmt.setString(5,Admission_To_Date);*/
		pstmt.setString(2,Admission_From_Date);
		pstmt.setString(3,Admission_To_Date);
	}
	
	if((!Admission_From_Date.equals("") && !Admission_To_Date.equals("")) && (!Discharge_From_Date.equals("") && !Discharge_To_Date.equals("")))	
	{
		/*pstmt.setString(4,Discharge_From_Date);
		pstmt.setString(5,Discharge_To_Date);*/
		pstmt.setString(4,Discharge_From_Date);
		pstmt.setString(5,Discharge_To_Date);
	}

	if((Admission_From_Date.equals("") && Admission_To_Date.equals("")) && (!Discharge_From_Date.equals("") && !Discharge_To_Date.equals("")))	
	{
		/*pstmt.setString(4,Discharge_From_Date);
		pstmt.setString(5,Discharge_To_Date);*/
		pstmt.setString(2,Discharge_From_Date);
		pstmt.setString(3,Discharge_To_Date);
	}
	
	if(!deceased_from_date.equals("") && !deceased_to_date.equals(""))	
	{
		pstmt.setString(4,deceased_from_date);
		pstmt.setString(5,deceased_to_date);
	}

	if((!Admission_From_Date.equals("") && !Admission_To_Date.equals("")) && (!Discharge_From_Date.equals("") && !Discharge_To_Date.equals("")) && (!deceased_from_date.equals("") && !deceased_to_date.equals("")))	
	{
		/*pstmt.setString(4,Discharge_From_Date);
		pstmt.setString(5,Discharge_To_Date);*/
		pstmt.setString(6,Discharge_From_Date);
		pstmt.setString(7,Discharge_To_Date);
	}
	rs = pstmt.executeQuery();

/*	if(rs != null)
	{
		rs.last();
		maxRecord = rs.getRow();
        rs.beforeFirst();
	}
	if (maxRecord==0)		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));//document.location.href='../../eCommon/html/blank.html'</script>");
	else
	{*/
		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;

		while (i<=end &&  rs.next())
		{
			if(maxRecord==0)
			{

		
            _bw.write(_wl_block19Bytes, _wl_block19);

		if ( !(start <= 1) )
			//out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/DeathRegisterResult.jsp?PatientId="+PatientId+"&EncounterId="+EncounterId+"&AdmissionDate="+AdmissionDate+"&DischargeDate="+DischargeDate+"&from="+(start-20)+"&to="+(end-20)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
			out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/DeathRegisterResult.jsp?status="+status+"&PatientId="+PatientId+"&EncounterId="+EncounterId+"&admission_from_date="+Admission_From_Date+"&admission_to_date="+Admission_To_Date+"&discharge_from_date="+Discharge_From_Date+"&discharge_to_date="+Discharge_To_Date+"&deceased_from_date="+deceased_from_date+"&deceased_to_date="+deceased_to_date+"&from="+(start-20)+"&to="+(end-20)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		//if ( !( (start+20) > maxRecord ) )
			//out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/DeathRegisterResult.jsp?PatientId="+PatientId+"&EncounterId="+EncounterId+"&AdmissionDate="+AdmissionDate+"&DischargeDate="+DischargeDate+"&from="+(start+20)+"&to="+(end+20)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/DeathRegisterResult.jsp?status="+status+"&PatientId="+PatientId+"&EncounterId="+EncounterId+"&admission_from_date="+Admission_From_Date+"&admission_to_date="+Admission_To_Date+"&discharge_from_date="+Discharge_From_Date+"&discharge_to_date="+Discharge_To_Date+"&deceased_from_date="+deceased_from_date+"&deceased_to_date="+deceased_to_date+"&from="+(start+20)+"&to="+(end+20)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
		
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

			}
	String classValue	 = "";
	//if ( rs != null )
	//{
		/*if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
			  rs.next() ;
		*/
		//while ( rs.next() && i<=end )
		//{
			if ( i % 2 == 0 )
				classValue = "QRYEVENSMALL";
			else
				classValue = "QRYODDSMALL"; 
			String EncounterID		= rs.getString("encounter_id");				
			String Discharge_Date	= rs.getString("discharge_date");
			String VisitAdmDate		= rs.getString("admission_date");
			String PatientID		= rs.getString("patient_id");
			String PatientName		= rs.getString("patient_name");
			String Sex				= rs.getString("sex");
			String gender			= rs.getString("sex");
			String Practitioner		= rs.getString("attend_practitioner_id");
			String patient_class	= rs.getString("patient_class");
			String pract_type		= rs.getString("pract_type");
			String speciality_code	= rs.getString("specialty_code");
			String date_of_birth	= rs.getString("date_of_birth");
			String pat_curr_locn_code	= rs.getString("pat_curr_locn_code");
			String deceased_date_time	= checkForNull(rs.getString("deceased_date_time"));	
			
			if(!(Discharge_Date==null || Discharge_Date.equals("")))
				discharged_yn = "Y";
			else
				discharged_yn = "N";



			if(!(deceased_date_time==null || deceased_date_time.equals("")))
				deceased_date_time = DateUtils.convertDate(deceased_date_time,"DMYHM","en",locale);
			String Discharge_Date_display = DateUtils.convertDate(Discharge_Date,"DMYHM","en",locale);
			String VisitAdmDate_display = DateUtils.convertDate(VisitAdmDate,"DMYHM","en",locale);
			String admission_type			= rs.getString("admission_type");	
			String auth_practitioner_id	= rs.getString("auth_practitioner_id");		
			String auth_practitioner_name	= rs.getString("auth_practitioner_name");	
			String remarks					= rs.getString("remarks");	
			String finalize_yn					= rs.getString("finalize_yn");
			
			if(finalize_yn.equals("") || finalize_yn == null)
				finalize_yn="N";

			String finalize_status = "";
			

			/*out.println("<script>alert(\"admission_type:"+admission_type+"\");</script>");
			out.println("<script>alert(\"auth_practitioner_name:"+auth_practitioner_name+"\");</script>");
			out.println("<script>alert(\"auth_practitioner_name:"+auth_practitioner_id+"\");</script>");
		*/
		
			
			if(EncounterID==null	|| EncounterID.equals("null"))		EncounterID = "";
			//if(VisitAdmDate==null	|| VisitAdmDate.equals("null"))		VisitAdmDate = "";
			//if(DischargeDate==null	|| DischargeDate.equals("null"))	DischargeDate = "";
			if(PatientName==null	|| PatientName.equals("null"))		PatientName = "";
			if(Practitioner==null	|| Practitioner.equals("null"))		Practitioner = "";
			if(patient_class==null	|| patient_class.equals("null"))	patient_class = "";
			if(pract_type==null		|| pract_type.equals("null"))		pract_type = "";
			if(speciality_code==null|| speciality_code.equals("null"))	speciality_code = "";
			if(date_of_birth==null|| date_of_birth.equals("null"))	date_of_birth = "";
			if(pat_curr_locn_code==null|| pat_curr_locn_code.equals("null"))	pat_curr_locn_code = "";
			if(auth_practitioner_id==null|| auth_practitioner_id.equals("null"))	auth_practitioner_id = "";
			if(admission_type==null|| admission_type.equals("null"))	admission_type = "";
			if(auth_practitioner_name==null|| auth_practitioner_name.equals("null"))	auth_practitioner_name = "";
			if(remarks==null|| remarks.equals("null"))	remarks = "";
			if(VisitAdmDate_display==null|| VisitAdmDate_display.equals(""))VisitAdmDate_display = "&nbsp;";
			if(Discharge_Date_display==null|| Discharge_Date_display.equals(""))Discharge_Date_display = "&nbsp;";
			if(deceased_date_time==null|| deceased_date_time.equals(""))deceased_date_time = "&nbsp;";


			if(Sex == null )
				Sex="";
			else if (Sex.equals("M"))
				Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if (Sex.equals("F"))
				Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else 
				Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			if(finalize_yn.equals("Y"))
			{
				finalize_status="Finalized";				
				out.println("<tr><td class='"+classValue+"' style='font-weight:normal;background-color:white'>");
				out.println("<a href=javascript:call_death_reg('"+EncounterID+"','"+PatientID+"','"+Practitioner+"','"+patient_class+"','"+speciality_code+"','"+gender+"','"+date_of_birth+"','"+pract_type+"','"+pat_curr_locn_code+"','"+finalize_yn+"','"+java.net.URLEncoder.encode(VisitAdmDate)+"')>"+PatientID+"</a>");
				out.println("</td>");
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+PatientName+"</td>");			
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+Sex+"</td>");	
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+patient_class+"</td>");				
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+finalize_status+"</td>");				
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+EncounterID+"</td>");
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+VisitAdmDate_display+"</td>");
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>" +Discharge_Date_display+"</td>");
				out.println("<td  class='"+classValue+"' style='font-weight:normal;background-color:white;text-align:center;'>" +discharged_yn+"</td>");
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+deceased_date_time+"</td>");


			}
			else
			{
				finalize_status="Recorded";
				out.println("<tr><td class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>");
				out.println("<a href=javascript:call_death_reg('"+EncounterID+"','"+PatientID+"','"+Practitioner+"','"+patient_class+"','"+speciality_code+"','"+gender+"','"+date_of_birth+"','"+pract_type+"','"+pat_curr_locn_code+"','"+finalize_yn+"','"+java.net.URLEncoder.encode(VisitAdmDate)+"')>"+PatientID+"</a>");
				out.println("</td>");
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+PatientName+"</td>");			
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+Sex+"</td>");	
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+patient_class+"</td>");				
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+finalize_status+"</td>");				
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+EncounterID+"</td>");
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+VisitAdmDate_display+"</td>");
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>" +Discharge_Date_display+"</td>");
				out.println("<td class='"+classValue+"'  style='font-weight:normal;background-color:lightblue;text-align:center;'>" +discharged_yn+"</td>");
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+deceased_date_time+"</td>");
			}


			//out.println("<a href=javascript:modify_death_date('"+EncounterID+"','"+PatientID+"','"+java.net.URLEncoder.encode(deceased_date_time)+"','"+java.net.URLEncoder.encode(Discharge_Date_display)+"','"+java.net.URLEncoder.encode(VisitAdmDate_display)+"',\""+java.net.URLEncoder.encode(admission_type, "UTF-8")+"\",'"+java.net.URLEncoder.encode(auth_practitioner_id)+"',\""+java.net.URLEncoder.encode(auth_practitioner_name)+"\",'"+java.net.URLEncoder.encode(remarks)+"')>"+deceased_date_time+"</a>");
			//out.println("<a href=javascript:modify_death_date('"+EncounterID+"','"+PatientID+"',\""+java.net.URLEncoder.encode(deceased_date_time)+"\", \""+java.net.URLEncoder.encode(Discharge_Date_display)+"\",\""+java.net.URLEncoder.encode(VisitAdmDate_display)+"\",\""+admission_type+"\",'"+auth_practitioner_id+"',\""+auth_practitioner_name+"\",\""+remarks+"\")>"+deceased_date_time+"</a>");
			
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(EncounterID));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(PatientID));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(deceased_date_time));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Discharge_Date_display));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(VisitAdmDate_display));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(admission_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(auth_practitioner_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(deceased_date_time));
            _bw.write(_wl_block26Bytes, _wl_block26);
//out.println("</td>");
			//out.println("</font></tr>");
			out.println("</tr>");
			i++;
			maxRecord++;
		}
	//}
			
		if ( maxRecord < 20 || (!rs.next()) )
		{	
            _bw.write(_wl_block27Bytes, _wl_block27);
 	}
		else
		{	
            _bw.write(_wl_block28Bytes, _wl_block28);
	}

		if(maxRecord==0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}

            _bw.write(_wl_block29Bytes, _wl_block29);
	//}
}catch ( Exception e )
{
	//out.println("Exception @ DeathRegisterResult.jsp"+e.toString());
	e.printStackTrace();
}
finally
{
	out.println("<script>parent.frames[1].document.forms[0].search.disabled=false;</script>");
	try
	{
		if ( pstmt != null ) pstmt.close() ;
		if ( rs != null ) rs.close() ;
	}
	catch(Exception e)	{	}
		ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.dischargeYN.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DeceasedDate.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }
}
