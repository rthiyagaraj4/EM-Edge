package jsp_servlet._emp._jsp;

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
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __newbornregistrationheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/NewbornRegistrationHeader.jsp", 1743068547143L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\t\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n    <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n    <script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n    <script src=\'../js/NewbornRegistration.js\' language=\'javascript\'></script>\n\t<script src=\'../js/NewbornRegistration1.js\' language=\'javascript\'></script>\n\t<script src=\'../js/NewbornRegistration2.js\' language=\'javascript\'></script>\n\t<Script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></Script>\n\t<script>\n\t\tfunction closeWindow(){\n\t\t\tparent.window.close();\n\t\t}\n\t\tasync function callNewbornAssessmentNote(){\n\t\t\tvar patient_id\t= document.forms[0].patient_id.value;\n\t\t\tvar accession_num\t= parent.frames[2].document.forms[0].accession_num_nb_note.value;\n\t\t\tvar q_finalized_yn\t= parent.frames[2].document.forms[0].q_finalized_yn.value;\n\t\t\tvar data_upd_allowed_aft_final_yn\t= parent.frames[2].document.forms[0].data_upd_allowed_aft_final_yn.value;\n\t\t\tvar chd_encounter_id\t= document.forms[0].chd_encounter_id.value;\n\t\t\tvar chd_patient_class\t= document.forms[0].chd_patient_class.value;\n\t\t\tvar retVal =    new String();\n\t\t\tvar features =\t\"dialogHeight:41; dialogWidth:82; dialogTop:80  ; scroll=no; status:no\";\n\t\t\tvar arguments   = \'\' ;\n\t\t\tvar isShowEditMode\t= \"Y\";\n\t\t\tif(q_finalized_yn==\"Y\" && data_upd_allowed_aft_final_yn==\"N\"){\n\t\t\t\tisShowEditMode\t= \"N\";\n\t\t\t}\n\t\t\tif(isShowEditMode==\"Y\"){\n\t\t\t\tretVal =await window.showModalDialog(\"../../eCA/jsp/RecClinicalNotesModal.jsp?function_id=BIRTH_REG_NOTES&appl_task_id=BIRTH_REG_NOTES&patient_id=\"+patient_id+\"&accession_num=\"+accession_num+\"&encounter_id=\"+chd_encounter_id+\"&patient_class=\"+chd_patient_class+\"&Field_Ref=parent.newbornheader_frame.document.forms[0].accession_num\",arguments,features);\n\t\t\t\tif(retVal !=null && retVal !=undefined){\n\t\t\t\t\tvar retValArr\t= retVal.split(\"###\");\n\t\t\t\t\tif(retValArr[1] !=\"Success\"){\n\t\t\t\t\t\tparent.frames[2].document.forms[0].accession_num_nb_note.value\t= \"\";\n\t\t\t\t\t}else{\n\t\t\t\t\t\tparent.frames[2].document.forms[0].accession_num_nb_note.value\t= retValArr[0];\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\tvar action_url = \"../../eCA/jsp/ViewMotherLinkedNotesMain.jsp?function_id=BIRTH_REG_NOTES&appl_task_id=BIRTH_REG_NOTES&patient_id=\"+patient_id+\"&accession_num=\"+accession_num+\"&encounter_id=\"+chd_encounter_id+\"&patient_class=\"+chd_patient_class;\n\t\t\t\tvar features =\t\"dialogHeight:41; dialogWidth:82; dialogTop:80  ; scroll=no; status:no\";\n\t\t\t\tvar  arguments = \"\";\n\t\t\t\tvar returnValue=window.showModalDialog(action_url,arguments,features);\n\t\t\t}\n\t\t}\n\t</script>\n</head>\n\n<body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onSelect=\"codeArrestThruSelect()\" onLoad=\"\" >\n<form name=\'NewbornRegistration_form\' id=\'NewbornRegistration_form\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\n     \n<table width=\"100%\" cellpadding=0 cellspacing=0 border=0 style=\"margin-top: 10px;\">\n    <tr>\n        <td  class=\'label\' width=\'18.9%\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<input type = \'hidden\' name = \'nb_use_mother_ser\' id = \'nb_use_mother_ser\' value = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' ></td>\t   \n        <td  class=\'FIELDS\' width=\'20%\'><select name=\"pat_ser_grp_code\" id=\"pat_ser_grp_code\" onChange=\"checkPatGenYN()\">\t\t\n\t\t\t<option value=\'\'>------";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="------\n            ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n            </select><img align=center src=\'../../eCommon/images/mandatory.gif\'></img>\n        </td>\n                ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n            ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n        ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n        <td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n        <td nowrap class=\'FIELDS\' width=\'20%\'><input class=\'upper\' type=\"text\" name=\"patient_id\" id=\"patient_id\" maxlength=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' size=\"20\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" disabled onFocus=\"loadPatSeriesManual()\" onBlur=\"makeValidString(this);checkPatientId()\"\n\t\tonKeyPress=\'return CheckForSpecChars(event)\'\n\t\tvalue=\"\"><!--<img align=center src=\'../../eCommon/images/mandatory.gif\'></img>-->\n        </td>\n\t\t<!-- img commented and disabled added by mujafar for ML-MMOH-SCF-1039 -->\n\t\t<td class=\'fields\' width = \'20%\'>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t</td>\n\t\t<td class=\'fields\' width = \'20%\'    >\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t</td>\n    </tr>\t\n</table>\n<br>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<table width=\"100%\" cellpadding=\'0\' cellspacing=\'0\'align=\'center\' border=\'0\' style=\"margin-top: 10px;\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t\t<td nowrap width=\'20%\' class=\'FIELDS\'><input type=\"hidden\" name=\"pat_ser_grp_code\" id=\"pat_ser_grp_code\"  value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"><input type=\"text\" name=\"pat_ser_grp_code_desc\" id=\"pat_ser_grp_code_desc\"  value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" maxlength=\'11\' size=\"20\" readonly> <img align=center src=\'../images/mandatory.gif\'></img></td>\n\t\t\t\t\t\t<td width=\'20%\' class=\'label\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t\t\t<td nowrap class=\'FIELDS\' width=\'20%\'><input type=\"text\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"  size=\"20\" readOnly disabled onBlur=\'makeValidString(this);\'><!--<img align=\'center\' src=\'../images/mandatory.gif\'></img>--></td>\n\t\t\t\t\t\t<!-- img commented and disabled added by mujafar for ML-MMOH-SCF-1039 -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t<td class=\'fields\' width = \'20%\'    >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t<td class=\'fields\' width = \'20%\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t</td>\n\n\t\t\t\t    </tr>\n\n\t\t\t\t</table> \n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n<input type=\'hidden\' name=\'pat_no_gen_yn\' id=\'pat_no_gen_yn\' value=\'Y\'></input>\n<input type=\'hidden\' name=\'pat_ser_prefix_reqd_yn\' id=\'pat_ser_prefix_reqd_yn\' value=\"\"></input>\n<input type=\'hidden\' name=\'function_id_mg\' id=\'function_id_mg\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<input type=\'hidden\' name=\'chd_id\' id=\'chd_id\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\'hidden\' name=\'chd_encounter_id\' id=\'chd_encounter_id\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\'hidden\' name=\'chd_patient_class\' id=\'chd_patient_class\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t<script>visibleAudit();</script>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	request.setCharacterEncoding("UTF-8");
	String locale =((String)session.getAttribute("LOCALE"));

            _bw.write(_wl_block3Bytes, _wl_block3);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rset          = null;	
    String facilityId           = (String)session.getValue("facility_id");
    String function_id = request.getParameter("function_id") ;
    if(function_id == null)function_id = "" ;
    String motherid                     = request.getParameter("mother_id")==null?"":request.getParameter("mother_id");
    String newbornpatsergrp     = request.getParameter("new_born_pat_ser_grp")==null?"":request.getParameter("new_born_pat_ser_grp");
    String nb_use_mother_ser= request.getParameter("nb_use_mother_ser")==null?"N":request.getParameter("nb_use_mother_ser");
    String patient_id_length= request.getParameter("patient_id_length")==null?"":request.
	getParameter("patient_id_length");
	String invoked_from = request.getParameter("invoked_from")==null?"":request.getParameter("invoked_from");
	String siteId = request.getParameter("siteId")==null?"":request.getParameter("siteId");
	String calling_module_id = request.getParameter("calling_module_id")==null?"":request.getParameter("calling_module_id");
	String chd_id = request.getParameter("chd_id")==null?"":request.getParameter("chd_id");
	String buttonType = request.getParameter("buttonType")==null?"R":request.getParameter("buttonType");
	String disable_button_yn = request.getParameter("disable_button_yn")==null?"N":request.getParameter("disable_button_yn");
	Boolean isNewBornChngsAppl = false;

	if(disable_button_yn.equals("Y"))
		disable_button_yn = "disabled";
	else
		disable_button_yn = "";

    String sql                  = "";
    //String site                 = "";
    String sel                  = "";

    //GregorianCalendar cal=new GregorianCalendar();
    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
    java.util.Date dt=new java.util.Date();

	String d = dateFormat.format( dt ) ;
	String sec = String.valueOf(dt.getMinutes());
	if ((sec).length()==1) sec="0"+sec; else sec = sec;
	d=d + " "+String.valueOf(dt.getHours())+":"+sec;
    String ip_install_yn = request.getParameter("ip_install_yn")==null?"N":request.getParameter("ip_install_yn");
    String mpsg ="";
    String mpsd ="";
    String gen_pat_id_yn = "";
    String patReadOnly = "";
    PreparedStatement smpsg=null;
    ResultSet rmpsg=null;
	/*
    String min_weight  = "";
	String max_weight  = "";
	String min_chest_circum = "";
	String max_chest_circum = "";
	String min_head_circum = ""; 
	String max_head_circum = ""; 
	String min_length = "";
	String max_length = "";
	String min_gestation = "";
	String max_gestation = "";
	*/
	//Added by kumar on 18/03/2003 for Malaysia Enhancements.
	//String pat_name_as_multipart_yn = "";
	String function_id_new			=""; 		

	try{
	function_id_new			= checkForNull(request.getParameter("function_id_new"));
	con = ConnectionManager.getConnection(request);
	isNewBornChngsAppl		 = CommonBean.isSiteSpecific(con,"IP","REG_NEW_BORN_FOR_IP_FLD_CHNGS");//Added by Dharma on 30th May 2018 against ML-MMOH-CRF-0898 [IN:064757]
	String chd_encounter_id	 = "";
	String chd_patient_class	 = "";
	if(isNewBornChngsAppl && "MAINTAIN_BIRTH".equals(function_id_new)){
		HashMap ResultHashMap = new HashMap();
		HashMap sqlColumns = new HashMap();
		sqlColumns.put("encounter_id","S");
		sqlColumns.put("patient_class","S");
		String wClause	= "where adt_status != '09' and discharge_date_time IS NULL and patient_class IN ('IP', 'DC') and patient_id='"+chd_id+"'";
		ResultHashMap = CommonBean.getParamDetails(sqlColumns,wClause,"PR_ENCOUNTER",con);
		chd_encounter_id				 = checkForNull((String) ResultHashMap.get("encounter_id"));
		chd_patient_class				 = checkForNull((String) ResultHashMap.get("patient_class"));
		chd_encounter_id				 = chd_encounter_id.equals("") ? "0" : chd_encounter_id;
		chd_patient_class				 = chd_patient_class.equals("") ? "XT" : chd_patient_class;
		sqlColumns.clear();
		ResultHashMap.clear();
	}

	/*
	pstmt = con.prepareStatement("select install_yn from sm_module where module_id = 'IP' ");
    rset = pstmt.executeQuery();
    if (rset!=null && rset.next())
    {
       ip_install_yn = rset.getString(1);
       if (ip_install_yn==null) ip_install_yn = "";
    }
	
	if(pstmt!=null) pstmt.close();
	if(rset!=null) rset.close();
	*/
	if(function_id_new.equals("REGISTER_NEWBORN")){
	//try
   // {
		 
		//con = ConnectionManager.getConnection(request);	
        
        if(nb_use_mother_ser.equals("Y"))
        {
            try
            {
            String sqlpg = "select m.pat_ser_grp_code, p.short_desc, gen_pat_id_yn from mp_patient m, mp_pat_ser_grp_lang_vw p where p.pat_ser_grp_code = m.pat_ser_grp_code and m.patient_id = ? and p.language_id='"+locale+"'";
            smpsg = con.prepareStatement(sqlpg);
            smpsg.setString(1,motherid) ;
            rmpsg = smpsg.executeQuery();
            if(rmpsg.next())
            {
                mpsg=rmpsg.getString(1);
                mpsd=rmpsg.getString(2);
                gen_pat_id_yn = rmpsg.getString(3);
            }
            }
            catch(Exception e)
            {
                out.println(e);
            }
            finally
            {
                if(rmpsg!=null)rmpsg.close();
                if(smpsg!=null)smpsg.close();
            }

        }
   		/*
		pstmt = con.prepareStatement("select install_yn from sm_module where module_id = 'IP' ");
        rset = pstmt.executeQuery();
        if (rset!=null && rset.next())
        {
            ip_install_yn = rset.getString(1);
            if (ip_install_yn==null) ip_install_yn = "";
        }
		*/

		/*
    }
    catch(Exception ex)
    {
        out.println(ex.toString());
    }                           
	finally
	{
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
	}
	*/

   	/*
	try{
     pstmt = con.prepareStatement("select site_id from sm_site_param ");
     rset = pstmt.executeQuery();
     if(rset.next())
     {
         site = rset.getString("site_id");
     }
    }catch(Exception e) { out.println(e.toString());}
	finally
	{
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
	}
	*/
   
	

            _bw.write(_wl_block8Bytes, _wl_block8);

	//Added by kumar on 15/09/2002 for Additional validation for min and max
	/*
	try
	{
		 //if(pstmt!=null) pstmt.close();
		 //if(rset!=null) rset.close();
		 pstmt = con.prepareStatement("select min_weight, max_weight, min_chest_circum, max_chest_circum, min_head_circum, max_head_circum, min_length, max_length, min_gestation, max_gestation, pat_name_as_multipart_yn from  mp_param where module_id=?");
		 pstmt.setString(1, "MP");
		 rset = pstmt.executeQuery();
		 if(rset.next())
		 {
			min_weight  = rset.getString("min_weight");
			max_weight  = rset.getString("max_weight");
			min_chest_circum  = rset.getString("min_chest_circum");
			max_chest_circum  = rset.getString("max_chest_circum");
			min_head_circum  = rset.getString("min_head_circum");
			max_head_circum  = rset.getString("max_head_circum");
			min_length  = rset.getString("min_length");
			max_length  = rset.getString("max_length");
			min_gestation  = rset.getString("min_gestation");
			max_gestation  = rset.getString("max_gestation");
			pat_name_as_multipart_yn = rset.getString("pat_name_as_multipart_yn");
			if (pat_name_as_multipart_yn.equals("N"))
			{
			}
			else
			{
			}

			if (min_weight==null) min_weight = "";
			if (max_weight==null) min_weight = "";
			if (min_length==null) min_length = "";
			if (max_length==null) min_length = "";
			if (min_chest_circum==null) min_chest_circum = "";
			if (max_chest_circum==null) max_chest_circum = "";
			if (min_head_circum==null) min_head_circum = "";
			if (max_head_circum==null) max_head_circum = "";
			if (min_gestation==null) min_gestation = "";
			if (max_gestation==null) max_gestation = "";
		 }
    }
	catch(Exception e) { out.println(e.toString());}
    finally
    {
        if (pstmt != null) pstmt.close();
        if (rset != null) rset.close();
    }

	*/
    out.println("<script language = 'javascript'> var PSGCodeArray = new Array(); var PSGYNArray = new Array(); var PSGPRYNArray = new Array(); var NamePrefixArray = new Array(); var PrefixSexArray = new Array();");	
    try{
        pstmt=con.prepareStatement("select pat_ser_grp_code, gen_pat_id_yn, prefix_reqd_yn from mp_pat_ser_grp where id_type not in ('R', 'X') ");
        rset = pstmt.executeQuery();
        int k =0;
        while ( rset.next() )
        {
            out.println("PSGCodeArray["+k+"]='"+rset.getString(1)+"';");
            out.println("PSGYNArray["+k+"]='"+rset.getString(2)+"';");
			out.println("PSGPRYNArray["+k+"]='"+rset.getString(3)+"';");
            k++;
        }
    }catch(Exception e) { out.println(e.toString());}
    finally
    {
        if (pstmt != null) pstmt.close();
        if (rset != null) rset.close();
    }
     out.println("</script>");

	Properties p;		
	p = (Properties) session.getValue("jdbc");
	String loginUser				= (String)session.getAttribute("login_user");
	HashMap hashMap		= new HashMap();
	hashMap = eMP.ChangePatientDetails.getSetupData(facilityId,"",con,p);
	String pat_ser_access_by_user_yn = checkForNull((String)hashMap.get("PAT_SER_ACCESS_BY_USER_YN"));
	String usedStatusSql	= " and pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM mp_pat_ser_facility WHERE used_status = 'N') ";
	String userAccessSql	= "";
	if(pat_ser_access_by_user_yn.equals("Y")){
		userAccessSql	= " and pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM MP_PAT_SER_GRP_FOR_USER WHERE APPL_USER_ID = '"+loginUser+"') ";
	}
    

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nb_use_mother_ser));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

                    try{
                        String whereClause = "";
						if(nb_use_mother_ser.equals("N"))
							whereClause="and id_type in ('B','U') ";

						sql     =   "select pat_ser_grp_code,short_desc from mp_pat_ser_grp_lang_vw where gen_pat_id_yn = 'Y' "+whereClause+" and id_type not in ('R', 'X') and language_id='"+locale+"' and (pat_ser_grp_code in (select pat_ser_grp_code from mp_pat_ser_facility where site_or_facility_id = decode(site_or_facility,'S','"+siteId+"','F','"+facilityId+"') and used_status = 'N') OR ASSOCIATED_PAT_SER_GRP_CODE IS NOT NULL) "+userAccessSql+" union select pat_ser_grp_code,short_desc from mp_pat_ser_grp_lang_vw where  language_id='"+locale+"' and gen_pat_id_yn = 'N' "+whereClause+" and id_type not in ('R', 'X') "+usedStatusSql+" "+userAccessSql+" order by 2";	
				        pstmt   = con.prepareStatement(sql);
                        rset        = pstmt.executeQuery();

                        while(rset.next()) 
                        {
                            if(nb_use_mother_ser.equals("N"))
							{
								if(rset.getString("pat_ser_grp_code").equals(newbornpatsergrp))
									sel = "selected";
								else
									sel = "";
							}
							else
							{
								if(rset.getString("pat_ser_grp_code").equals(mpsg))
									sel = "selected";
								else
									sel = "";

							}
                            out.println("<option value='"+rset.getString("pat_ser_grp_code")+"' "+sel+">" + rset.getString("short_desc")+"</option>"); 
                        }
                    }catch(Exception e) { out.println(e.toString());}
                    finally
                    {
                        if (pstmt != null) pstmt.close();
                        if (rset != null) rset.close();
						//if(con!=null) //ConnectionManager.returnConnection(con,request);
                    }

            
            _bw.write(_wl_block13Bytes, _wl_block13);
 
                
            _bw.write(_wl_block14Bytes, _wl_block14);

                
            _bw.write(_wl_block15Bytes, _wl_block15);

         if (gen_pat_id_yn.equals("Y") || mpsd.equals("")) 
            patReadOnly = "readOnly";
         
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patReadOnly));
            _bw.write(_wl_block19Bytes, _wl_block19);

			if(buttonType.equals("R")) { 
				out.println("<input type='button' class='button' name='add_records' id='add_records' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Register.label","common_labels")+"' "+disable_button_yn+" onClick='addRecords();'>");		
			} else if(buttonType.equals("F")){
				out.println("<input type='button' class='button' name='add_records' id='add_records' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Finalize.label","common_labels")+"' "+disable_button_yn+" onClick='addRecords();'>");	
			}
			if (ip_install_yn.equals("Y") && calling_module_id.equals("IP")) { 
				out.println("<input type='button' class='button' name='close_win' id='close_win' value ='" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels") +"' onClick='closeWindow();'>");
			}
				
		
            _bw.write(_wl_block20Bytes, _wl_block20);
 out.println("<input type='button' class='button'  name='auditTrial' id='auditTrial' id ='auditButton' style='visibility:hidden'   value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AuditTrail.label","common_labels")+"'  onClick='viewAuditTrail();'>"); 
            _bw.write(_wl_block21Bytes, _wl_block21);
}else{

	String pat_ser_grp_code = request.getParameter("pat_ser_grp_code")==null?"":request.getParameter("pat_ser_grp_code");
	String pat_ser_grp_desc = request.getParameter("pat_ser_grp_desc")==null?"":request.getParameter("pat_ser_grp_desc");

	/*
	HashMap hashMap=new HashMap();
	HashMap hashMap13=new HashMap();
	hashMap = eMP.NewbornDetails.getNewbornData(motherid, con, p);
	String q_pat_ser_grp_desc =  (String) hashMap.get("q_pat_ser_grp_desc") == null?"":hashMap.get("q_pat_ser_grp_desc");
	hashMap13 = eMP.NewbornDetails.getPatSerGrpCode((String) hashMap.get("q_pat_ser_grp_code"), con,p);
	*/

	
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(pat_ser_grp_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(pat_ser_grp_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block27Bytes, _wl_block27);
 
							if(invoked_from.equals("details_page")) {
								out.println("<td class='FIELDS' width='20%'>");
								if(buttonType.equals("R")) { 
									out.println("<input type='button' class='button' name='add_records' id='add_records' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Register.label","common_labels")+"' "+disable_button_yn+" onClick='addRecords();'>"); 	
								} else if(buttonType.equals("F")){
									out.println("<input type='button' class='button' name='add_records' id='add_records' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Finalize.label","common_labels")+"' "+disable_button_yn+" onClick='addRecords();'>");	
								}
								if (ip_install_yn.equals("Y") && calling_module_id.equals("IP")) { 
									out.println("<input type='button' class='button' name='close_win' id='close_win' value ='" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels") +"' onClick='closeWindow();'>");
								}
								out.println("</td>");
							} else {
								out.println("<td class='label' width='20%'></td>");
							}
						
            _bw.write(_wl_block28Bytes, _wl_block28);
if(isNewBornChngsAppl && "MAINTAIN_BIRTH".equals(function_id_new)){
            _bw.write(_wl_block29Bytes, _wl_block29);
 out.println("<input type='button' class='button' style='width:175px;' id='btnNewbornAssessmentNote' name='btnNewbornAssessmentNote' id='btnNewbornAssessmentNote'value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NewbornAssessmentNote.label","mp_labels")+"'  onClick='callNewbornAssessmentNote();'>"); 
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
 out.println("<input type='button' class='button'  name='auditTrial' id='auditTrial' id ='auditButton' style='visibility:hidden'   value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AuditTrail.label","common_labels")+"'  onClick='viewAuditTrail();'>"); 
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(function_id_new));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(chd_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(chd_encounter_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(chd_patient_class));
            _bw.write(_wl_block37Bytes, _wl_block37);

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
		{
			
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	
            _bw.write(_wl_block38Bytes, _wl_block38);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientSeries.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientSeries.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
}
