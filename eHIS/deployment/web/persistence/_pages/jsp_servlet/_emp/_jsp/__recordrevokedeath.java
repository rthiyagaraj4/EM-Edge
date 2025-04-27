package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __recordrevokedeath extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/RecordRevokeDeath.jsp", 1738128795039L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Last Modified Date Time : 10/6/2005 12:02 PM -->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t\t\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t\t<script language=\'javascript\' src=\'../js/RecordRevokeDeath.js\'></script>\n\n\t</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t      <script>\t\t\t\n\t\t\t alert(getMessage(\'CANNOT_REVOKE_MOREG\',\'MP\'));\n\t\t     parent.f_query_add_mod.document.location.href=\"../jsp/blank.jsp?step_1=2\";\n\t\t </script>\n\t ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t      <script>\n\t\t\t alert(getMessage(\'CANNOT_REVOKE_DEATH\',\'MP\'));\n\t\t     parent.f_query_add_mod.document.location.href=\"../jsp/blank.jsp?step_1=2\";\n\t\t </script>\n\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t<Script Language=\"JavaScript\">\n\t\t\tfunction fieldFocus()\n\t\t\t{\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\tRecordRevokeDeath.Deceased_Date.focus();\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\tRecordRevokeDeath.Remarks_on_Revoking.focus();\n\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t}\n\t\t\t\n\t\t\t\n\t\t\n\t\t</Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<style>\ntextarea {\n  resize: none;\n}\n</style>\n\t<body  OnMouseDown=\"CodeArrest()\" onLoad=\'fieldFocus(); startBlink();\' onKeyDown = \'lockKey()\'>\n\t<form name=\"RecordRevokeDeath\" id=\"RecordRevokeDeath\" action=\"../../servlet/eMP.RecordRevokeDeathServlet?Patient_Id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" method=\"post\" target=\"messageFrame\">\n\t\t<input type=\'hidden\' name=\'system_date\' id=\'system_date\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t<center>\n\t\t<br>\n\t\t<!--<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"97%\">\n\t\t\t<tr>\n\t\t\t\t<td  class=\'PATIENTLINECOLOROTHLANG\' width=\'90%\' id=\'patdetails\' style=\'position:relative;\'>&nbsp;</td>\n\t\t\t\t<TD style=\'background-color:red\' align=\'center\' id=\'nam\' nowrap></TD>\n\t\t\t\t <td class=\'PATIENTLINECOLOR\' width=\'30%\' align=\'right\'><img name=\'nam\' src=\'../../eCommon/images/Status.gif\'><img name=\'nam1\' src=\'../../eCommon/images/Status.gif\'></td> \n\t\t\t</tr>\n\t\t</table>-->\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"97%\">\n\t\t\t<tr>\n\t\t\t\t<td width=\'100% \'class=\"BORDER\">\n\t\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' width=\'20%\'></td>\n\t\t\t\t\t\t\t\t<td class=\'label\' width=\'20%\'></td>\n\t\t\t\t\t\t\t\t<td class=\'label\' width=\'60%\'></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\t\t\t<td class=\'fields\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t\t   <td  class=\"label\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\t\t\t   \n\t\t\t\t\t\t\t\t\t<td class=\'fields\'><input type=\"text\" id= \'DeceasedDate\' name=\"Deceased_Date\" id=\"Deceased_Date\" size=\"16\" maxlength=\"16\"   onkeypress=\"return Valid_DT(event);\" onblur=\"ValidateDateTimesp(this);\"><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'Admissiondate\'  onClick=\"document.forms[0].Deceased_Date.select(); calender();\" tabindex=-1><img src=\'../images/mandatory.gif\' align=\'ABSMIDDLE \'></img>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t<td class=\'fields\'><input type=\"text\" name=\"Deceased_Date\" id=\"Deceased_Date\" size=\"16\" maxlength=\"16\" value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' readonly ><input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' id=\'Admissiondate\'  onClick=\"document.forms[0].visit_adm_date_time.select();calender();\" tabindex=-1 disabled>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" \t\t\t\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"label\" valign=\"center\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t\t\t\t<td class=\'fields\'><TextArea name=\"Deceased_Remarks\" rows=\"5\" cols=\"45\"></TextArea><img align=\'ABSMIDDLE \' src=\'../images/mandatory.gif\'></img></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t\t   <td  class=\"label\" valign=\"center\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t\t\t   <td class=\'fields\'><TextArea name=\"Deceased_Remarks\" rows=\"5\" cols=\"45\" readonly>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</TextArea></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\n\t\t\t\t\t\t<tr><td class=\'label\' colspan=\'3\'>&nbsp;</td></tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\t\t\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t   <td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t\t\t   <td  class=\"label\" valign=\"center\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t\t\t   <td class=\'fields\'><TextArea name=\"Remarks_on_Revoking\" rows=\"5\" cols=\"45\"></TextArea><img align=\'ABSMIDDLE \' src=\'../images/mandatory.gif\'></img></td>\n\t\t\t\t\t\t </tr>\n\t\t\t\t\t\t<tr><td class=\'label\' colspan=\'3\'>&nbsp;</td></tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t\t\t\t\t\t\n</table>\n</td>\n</tr>\n</table>\n\n</center>\n<input type=\"hidden\" name=\"Deceased_Date_Hidden\" id=\"Deceased_Date_Hidden\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<input type=\"hidden\" name=\"DOB\" id=\"DOB\" value= \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n<input type=\"hidden\" name=\"DOB_2\" id=\"DOB_2\" value= \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<input type=\"hidden\" name=\"visit_status\" id=\"visit_status\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\"hidden\" name=\"visit_adm_date_time\" id=\"visit_adm_date_time\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\"hidden\" name=\"Deceased_Yn\" id=\"Deceased_Yn\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\"hidden\" name=\"proceed\" id=\"proceed\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type=\"hidden\" name=\"regn_date\" id=\"regn_date\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type=\"hidden\" name=\"Patient_Id\" id=\"Patient_Id\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<input type=\"hidden\" name=\"isPatientEncRevokeDeathAppl\" id=\"isPatientEncRevokeDeathAppl\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"> <!--  added by mujafar for ML-MMOH-CRF-1427-->\n</form>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
	ResultSet rs=null;	
	java.sql.PreparedStatement pstmt =null;
	


	int count = 0;
	String proceed = "true";

	try
	{
		request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);
	
		Boolean isPatientEncRevokeDeathAppl = CommonBean.isSiteSpecific(con,"MP","PATIENT_ENC_REVOKE_DEATH"); // added by mujafar  for ML-MMOH-CRF-1427
		
		String Patient_Id = request.getParameter("Patient_ID");
		String Patient_Name = "";
		String Deceased_Yn = "";
		int Age = 0;
		String DOB ="";
		String DOB_2 ="";//Used for Displaying Date of birth without time in messageframe.
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
		String date=dateFormat.format( new java.util.Date() );		
		String dec_date="";
		String dec_remark="";
		
	
		String visit_status="";
		String visit_adm_date_time="";
		StringBuffer sql= new StringBuffer();
		
		String system_date="";
		String regn_date="";
		String registered_in_mo_yn=""; 
		String deceased_encounter_id=""; 
		String sqlQuery = "";
		try{
				sqlQuery = "SELECT registered_in_mo_yn, deceased_encounter_id,DECODE (?, 'en', patient_name, NVL (patient_name_loc_lang, patient_name)) patient_name,  deceased_yn,TO_CHAR (deceased_date, 'dd/mm/yyyy hh24:mi') deceased_date, TO_CHAR (regn_date, 'dd/mm/yyyy hh24:mi') regn_date,death_status_remarks,TO_CHAR (date_of_birth, 'DD/MM/RRRR hh24:mi') dob,TO_CHAR (date_of_birth, 'DD/MM/RRRR') dob_2, (SYSDATE - date_of_birth) / 365 age,TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') system_date,(SELECT TO_CHAR (MAX (visit_adm_date_time), 'dd/mm/yyyy hh24:mi') FROM pr_encounter WHERE patient_id = ? AND (visit_status >= '07' OR adt_status = '08')) visit_adm_date_time,(SELECT COUNT (1) FROM pr_encounter WHERE patient_id =? AND (visit_status < '07' OR adt_status < '08')) COUNT FROM mp_patient WHERE patient_id = ?";
				
				pstmt = con.prepareStatement(sqlQuery);
				pstmt.setString(1,localeName);
				pstmt.setString(2,Patient_Id);
				pstmt.setString(3,Patient_Id);
				pstmt.setString(4,Patient_Id);
				rs =pstmt.executeQuery();
				if(rs!=null && rs.next()) {
					registered_in_mo_yn=checkForNull(rs.getString("registered_in_mo_yn")); 
					deceased_encounter_id=checkForNull(rs.getString("deceased_encounter_id"));
					system_date=checkForNull(rs.getString("system_date"));
					count = rs.getInt("count");
					Patient_Name	= rs.getString("Patient_Name") == null ? "" : rs.getString("Patient_Name");
					Deceased_Yn	= rs.getString("Deceased_Yn") == null ? "N" : rs.getString("Deceased_Yn");
					dec_date		= checkForNull(rs.getString("DECEASED_DATE"));
					dec_remark		= rs.getString("DEATH_STATUS_REMARKS") == null ? "" : rs.getString("DEATH_STATUS_REMARKS");
					DOB				= checkForNull(rs.getString("DOB"));				
					DOB_2			= (rs.getString("DOB_2"));				
					Age				= rs.getInt("Age");
					if(Deceased_Yn.equals("N")) {
						dec_date = ""; dec_remark = "";
					}
					if(count > 0) { 
						proceed = "false";
					} else {
						visit_adm_date_time = rs.getString("visit_adm_date_time") == null ? "" : rs.getString("visit_adm_date_time");

					}
					regn_date = rs.getString("regn_date") == null ? "" : rs.getString("regn_date");
				}				
				if(!localeName.equals("en") && dec_date != null)
				{
					dec_date=DateUtils.convertDate(dec_date,"DMYHM","en",localeName);
				}
				if(!localeName.equals("en") && DOB != null)
				{
					DOB=DateUtils.convertDate(DOB,"DMYHM","en",localeName);
				}
				if(!localeName.equals("en") && DOB_2 != null)
				{
					DOB_2=DateUtils.convertDate(DOB_2,"DMY","en",localeName);
				}			

		 if(rs!=null) rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	if(registered_in_mo_yn.equals("Y")) {
            _bw.write(_wl_block8Bytes, _wl_block8);
 
	}
	else if(!deceased_encounter_id.equals("") && !isPatientEncRevokeDeathAppl) { // modified by mujafar for ML-MMOH-CRF-1427 
            _bw.write(_wl_block9Bytes, _wl_block9);

	 } else {			

            _bw.write(_wl_block10Bytes, _wl_block10);
if(Deceased_Yn.equals("N")){
            _bw.write(_wl_block11Bytes, _wl_block11);
}else { 
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(system_date));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
	
										if(Deceased_Yn.equals("Y")) 
											out.println("<input type='text' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RevokePatientDeath.label","mp_labels")+"' name='Action1' id='Action1' DISABLED> <input type='hidden' value='Revoke_Patient_Death' name='Action' id='Action' >");
										else 
											out.println("<input type='text' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RecordPatientDeath.label","mp_labels")+"' name='Action1' id='Action1' DISABLED> <input type='hidden' value='Record_Patient_Death' name='Action' id='Action' >");
										
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
 if (Deceased_Yn.equals("N")) { 
            _bw.write(_wl_block19Bytes, _wl_block19);
 } else {
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(dec_date));
            _bw.write(_wl_block21Bytes, _wl_block21);
 } 
            _bw.write(_wl_block22Bytes, _wl_block22);
 if(Deceased_Yn.equals("N")){ 
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
 } else { 
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(dec_remark));
            _bw.write(_wl_block27Bytes, _wl_block27);
} 
            _bw.write(_wl_block28Bytes, _wl_block28);
 if(Deceased_Yn.equals("Y")){ 
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
 } else out.println("<input type='hidden' value='' name='Remarks_on_Revoking' id='Remarks_on_Revoking'>");  
						
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(date));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(DOB));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(DOB_2));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(visit_status));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(visit_adm_date_time));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Deceased_Yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(proceed));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(regn_date));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(isPatientEncRevokeDeathAppl));
            _bw.write(_wl_block41Bytes, _wl_block41);

	sql.setLength(0);
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	}
}catch(Exception ee){
	out.println("Exception in main try"+ee.toString());
	ee.printStackTrace();
}finally{
if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block42Bytes, _wl_block42);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.action.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DeceasedDate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.deceasedremarks.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.deceasedremarks.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.remarksonrevoking.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
