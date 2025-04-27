package jsp_servlet._eop._jsp;

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
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __qmgmtre_assignpract extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/QmgmtRe_AssignPract.jsp", 1709119467147L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/jquery.js\' language=\'javascript\'></script><!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 21st Nov 2013-->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n    <script language=\"javascript\" src=\"../js/QmgmtRe_AssignPract.js\"></script>\n    <script language=\"javascript\" src=\"../../eOP/js/Checkblockscheduleforpract.js\"></script><!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013-->\n\t<script language=\"javascript\" src=\"../js/OPPractitionerComponent.js\"></script>\n       <script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onload=\"setTimeout(\'FocusFirstElement()\',300)\" onKeyDown =\'lockKey()\'  onMouseDown=\"CodeArrest();\" onKeyDown =\'lockKey()\' onSelect=\"codeArrestThruSelect()\">\n<form name=\"Qmgmt\" id=\"Qmgmt\" method=\'post\' action=\'../../servlet/eOP.QmgmtRe_AssignPractServlet\'><br>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tif(document.getElementById(\"prevsubservice\") != null) { \t\t   \n\t\t\t\t\t\tdocument.getElementById(\"prevsubservice\").innerHTML=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\t\t\t\t\t\t\n\t\t\t          }\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<td  align=\'left\'><input type=\'text\' name=\'pract_name\' id=\'pract_name\' maxlength=\'30\' onChange=\"onBlurCallPractitionerSearch(document.forms[0].preact_butt,pract_name);\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" onkeypress=\"return(Chkval(this,event,0))\"><input type=\'button\' name=\'preact_butt\' id=\'preact_butt\' ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" value=\'?\' class=\'button\' onClick=\"callPractSearch(this,pract_name);\"><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<input type=\'hidden\' name=\'pract_id\' id=\'pract_id\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<input type=\'hidden\' name=\'pract_id\' id=\'pract_id\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\t\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'ASSIGN_PRACTITIONER_FOR_OP\'></td> \n\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<td  align=\'left\' class=\'QUERYDATA\' id=\'practtype\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<tr>\n\t<td  id=\'queue_div\' style=\'visibility:hidden;display:none\' class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t<td id=\'queue_no_div\' style=\'visibility:hidden;display:none\' ><input type=\'text\' name=\'queue_no\' id=\'queue_no\' value = \'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' size=\'15\' onKeyPress=\'return Check_SpecCharsValidationOP(event);\' onPaste=\'return checkspecialandalphanumericOP(event);\' onblur = \'chkValue(this);\' maxlength=\'15\' ><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t<tr>\n\t\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t</td>\n\t<td>\n\t</td>\n\t<td>\n\t<input type=\'button\' class=\'button\' name=\'sec_res_btn\' id=\'sec_res_btn\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' onClick=\"callSecondaryResource(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\',\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'\',\'SecRes\');\">\n\t<input type=\'hidden\' name=\'sec_res_lst\' id=\'sec_res_lst\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'/>\n\t</td>\n\t</tr>\n\n\t\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n<div id=\'sec_res_lbl\' >\n</div>\n<script>\ncallSecondaryResource(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\');\n</script>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n    <table width=\"100%\" >\n    <tr>\n    <td class=\"white\" width=\"100%\">\n    <table cellpadding=\'0\' cellspacing=\'0\' border=0 width=\'95%\' >\n        <tr class=\"white\">\n            <td  class=\'white\' align=\'right\'>\n\t\t\t   <input type=\'button\'  class=\'button\' name=\'ok\' id=\'ok\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' onClick=\'apply()\'><input type=\'button\' align=\'left\' class=\'button\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' onClick=\'exitContact()\'>\n            </td>\n        </tr>\n    </table>\n    </td>\n    <td class=\"white\"></td>\n    </tr>\n    </table>\n\t\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t   apply();\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t<!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 21st Nov 2013 Start-->\t\t\n\t\t<input type=\'hidden\' name=\'Sysdate\' id=\'Sysdate\' id=\'Sysdate\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'\t />\n\t\t<input type=\'hidden\' name=\'Systime\' id=\'Systime\' id=\'Systime\'\t />\n\t\t<input type=\'hidden\' name=\'is_prac_blocked\' id=\'is_prac_blocked\' id=\'is_prac_blocked\' \t /> \n\t\t<input type=\'hidden\' name=\'exist_pract_id\' id=\'exist_pract_id\' id=\'exist_pract_id\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'\t /> \n\t\t<input type=\'hidden\' name=\'action_on_pract_schedule\' id=\'action_on_pract_schedule\' id=\'action_on_pract_schedule\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' \t />\n\t\t<!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 21st Nov 2013 End-->\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
 
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String rval		="";
	/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
     String  room_desc="";
	 String room_desc1="";
	/*CRF end SS-CRF-0010 [IN034516]*/
	ResultSet rs1           = null;
    ResultSet rs2           = null;    
    ResultSet rsc	= null;
    ResultSet rs_pract = null;
   
	ResultSet rs= null;
	
	ResultSet rspr=null;
	
    PreparedStatement pstmt=null;
    PreparedStatement pstmt1=null;
    PreparedStatement pstpr=null;

	int tot=0;
	
	String ALLOW_WALK_IN_YN="N";
	
	String IDENT_AT_CHECKIN="P";
	String locale=(String)session.getAttribute("LOCALE");
    String p_encounter_id       = request.getParameter("encounter_id");
    String p_mode           = request.getParameter("mode");
	
	String PreviousDay = request.getParameter("PreviousDay");
	if(PreviousDay.equals(" 0") || PreviousDay.equals("0"))  PreviousDay = "+0";
    String fac_id           = (String) session.getValue( "facility_id" ) ;
	String p_care_locn_id = request.getParameter("care_locn_id");

	String bl_install_yn= (String) session.getValue( "bl_operational" ) ;
	if(bl_install_yn == null) bl_install_yn="";
 
	String p_clinic_code        = "";
    String p_clinic_desc        = "";
    String p_clinic_type ="";    
    
	String p_open_to_all_pract_yn="";
	String p_ppract_type = "";
	String p_queue_date = "";
    String constr = "";
	String p_team_id = "";
	String p_team_desc = "";
	String appt_ref_no="";
	String roomno="";
	String p_service_code="";
	String p_subservice_code="";
	String cur_pract="";
	String p_speciality_code="";
	String p_cur_vis_type_ind="";
	String practList="";//Added for the CRF Bru-HIMS-CRF-0198
    String pract="";
	boolean isVirtualConsultationVisit=false; // added by Ajay Hatwate for ML-MMOH-CRF-1930 US010
	String isVirtConsVisType = ""; // added by Ajay Hatwate for ML-MMOH-CRF-1930 US010
	boolean isQMSapplicable=false;
    Connection conn =null;
	/*Below line added for this CRF Bru-HIMS-CRF-133*/			
	  String isPatientEncMovement	= request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");	   
	  String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
	  String p_queue_status= request.getParameter("p_queue_status")==null?"":request.getParameter("p_queue_status"); 
	//End Bru-HIMS-CRF-133  	

try {
	
     conn = ConnectionManager.getConnection(request);
     isVirtualConsultationVisit=eCommon.Common.CommonBean.isSiteSpecific(conn,"OP","VIRTUAL_CONSULTATION"); //Added by Ajay for ML-MMOH-CRF-1930 US010
	isQMSapplicable=eCommon.Common.CommonBean.isSiteSpecific(conn,"OP","EXT_QUEUE_NO"); //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 15-06-2023 Started-->

            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

    String p_patient_id="";
    String p_locn_code="";
    String p_locn_type="";
    String p_pract_id="";
	String caresql="";
	String amsql="";
	String pract_desc="";
	String oth_res_desc="";

    String module_id=request.getParameter("module_id");
	if(module_id== null || module_id.equals("null")) module_id="";
	
	String p_gender=request.getParameter("sex");
	String p_dob =request.getParameter("dob");

	String p_status=request.getParameter("p_status");
	String dtime=request.getParameter("dtime");
	p_queue_date  =request.getParameter("p_queue_date");

	rval=request.getParameter("room_num");
	String appt_id=request.getParameter("appt_id")==null?"":request.getParameter("appt_id");
	String VITAL_SIGNS_DATE_TIME=request.getParameter("VITAL_SIGNS_DATE_TIME");
	String ARRIVE_DATE_TIME=request.getParameter("ARRIVE_DATE_TIME");
	String oper_id=request.getParameter("oper_id")==null?"":request.getParameter("oper_id");
	String other_res_class=request.getParameter("other_res_class");
	if(other_res_class == null) other_res_class="";
	String other_res_code=request.getParameter("other_res_code");
	if(other_res_code == null) other_res_code="";
	String queue_num=request.getParameter("queue_num");
	if(queue_num == null) queue_num="0";
	String appt_walk_ind=request.getParameter("appt_walk_ind");
	if(appt_walk_ind == null) appt_walk_ind="";
	
	String queue_id=request.getParameter("queue_id");
	if(queue_id == null) queue_id="";
	
	String assign_q_num_by=request.getParameter("assign_q_num_by")==null?"":request.getParameter("assign_q_num_by");
	String qms_interfaced_yn="N";
	String referral_id="";
	String other_res_class_desc="";
	String res_tot="";
	String multi_speciality_yn="N";//Added for the Bru-HIMS-CRF-0198
	String disable_pract="";//Added for the Bru-HIMS-CRF-0198
	int secResPractCount=0;//Added for the Bru-HIMS-CRF-0198
	
	

	if(other_res_class.equals("E"))
	other_res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
	else if(other_res_class.equals("O"))
	other_res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
	if(module_id.equals("CA"))
	{
		 p_locn_type=request.getParameter("locn_type");
		 p_locn_code=request.getParameter("locn_code");
		 p_pract_id=request.getParameter("practitioner_id");  
		 p_patient_id=request.getParameter("patient_id");
		 p_queue_date=request.getParameter("visit_adm_date").substring(0,10);
		 PreviousDay="+0";  	  		 
		try{
			  amsql="SELECT PRACTITIONER_NAME description FROM AM_PRACTITIONER_LANG_VW where language_id='"+locale+"' and practitioner_id='"+p_pract_id+"'";
			  pstmt=conn.prepareStatement(amsql);
			  rs=pstmt.executeQuery();
			  if(rs != null)  {
				   if(rs.next())
					 {
					   pract_desc=rs.getString(1);
					 }
				 }

				if(rs != null)rs.close();
				if(pstmt != null ) pstmt.close();		
		  }catch(Exception e){
			  e.printStackTrace();
			  }		   
	 } else {
		 p_patient_id=request.getParameter("patientID");
		 p_locn_type=request.getParameter("location_type");
		 p_locn_code=request.getParameter("location_code");
		 p_pract_id=request.getParameter("attend_practitioner_id");
	}

		try
		 { 
		   caresql="select care_locn_type_ind,ident_at_checkin,allow_walk_in_yn,qms_interfaced_yn,multi_speciality_yn  from op_clinic where clinic_code='"+p_locn_code+"' and facility_id='"+fac_id+"'";								
		   pstmt=conn.prepareStatement(caresql);
		   rs=pstmt.executeQuery();
		   if(rs != null)  {
			   if(rs.next()) {
				   p_care_locn_id=rs.getString(1);
				   IDENT_AT_CHECKIN = rs.getString(2);
				   ALLOW_WALK_IN_YN = rs.getString(3);
				   qms_interfaced_yn=rs.getString("QMS_INTERFACED_YN");
				   multi_speciality_yn=rs.getString("multi_speciality_yn")==null?"N":rs.getString("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF-0198
				   if(multi_speciality_yn.equals("Y")){
					   disable_pract="disabled";
				   }
				   
			    }
			}
			if(rs != null)rs.close();
			if(pstmt != null ) pstmt.close();
		 }catch(Exception e) {
            e.printStackTrace();		
			}   
	   if (p_pract_id == null)p_pract_id = "";
        StringBuffer op_pat_q_sql = new StringBuffer(); 
        try { 	
				out.println("<table width='95%' cellpadding=0 border=0 cellspacing=0 align='center'>");        
				if (dtime == null || dtime.equals("null")) {
					out.println("<tr><td  width='215pt' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</td>");
					out.print("<td align='left' class='QUERYDATA'><b>" + p_status + "</b></td>");
				  } else { 
					String dtime_display=DateUtils.convertDate(dtime,"DMYHM","en",locale);
					out.println("<tr><td  width='215pt' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</td>");
					out.print("<td align='left' class='QUERYDATA'><b>" + p_status + "/ " + dtime_display +"</b></td>");
				  }
				  out.println("</tr></table><br>");    
				  op_pat_q_sql.setLength(0);
				  out.println("<table width='95%' cellpadding=0 cellspacing=0 align='center'>");
			 } catch(Exception e){
				 out.println("<script>alert(\"error=\""+e+")</script>");
				 e.printStackTrace();
				 }
			finally{        
				 op_pat_q_sql.setLength(0);
			 }
	
    
    String p_cur_open_to_all_pract_yn="";
    String p_cur_pract_type="";
	String p_cur_pract_type_desc="";
	String p_cur_locn_type="";
    String p_cur_locn_code="";
    String p_cur_practitioner_id="";
    String p_cur_visit_type_code="";
    String visit_type_desc="";
    String visitcase = "";
    String p_clinic_type_code = "";
    String room_no="";
	String temp_pract="";
	int total_rec=0;

	String episode_id="";
	String episode_visit_num="";
	String userid         = (String) session.getValue("login_user");
	String Sysdate		  = "";//Added for JD-CRF-0183 [IN:041353] By Dharma on 21st Nov 2013
   	String action_on_pract_schedule	= "";//Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013
	StringBuffer pr_en_op_cl_am_sql = new StringBuffer();
	StringBuffer sm_day_sql = new StringBuffer();
	StringBuffer psql=new StringBuffer();
	psql.setLength(0);

try{
	/* Below line query modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	//pr_en_op_cl_am_sql.append("SELECT A.LOCN_TYPE clinic_type  ,OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.LOCN_CODE,'"+locale+"','1') locn_desc   ,am_get_desc.AM_CARE_LOCN_TYPE(a.locn_type ,'"+locale+"',2)locn_type_desc   ,am_get_desc.AM_SERVICE(a.service_code,'"+locale+"',2) service_desc   ,am_get_desc.am_practitioner(A.practitioner_id,'"+locale+"',1) pract_name   ,op_get_desc.OP_VISIT_TYPE(a.facility_id,a.visit_type_code,'"+locale+"',2) visit_type_desc ,(select count(*) from op_resource_type_for_appt where visit_type_code=a.visit_type_code and facility_id=a.facility_id and resource_class='P') vstcount,am_get_desc.am_facility_room (a.facility_id,a.ROOM_NUM,'"+locale+"', 2) room_desc, a.speciality_code cur_speciality_code , NULL team_id , NULL team_desc   ,a.locn_code cur_locn_code   ,a.locn_type cur_locn_type  ,a.service_code cur_service_code ,a.subservice_code cur_subservice_code ,a.Practitioner_id cur_practitioner_id, nvl(f.pract_type,'?') cur_pract_type, 'A' cur_level_of_care_ind ,(SELECT open_to_all_pract_yn FROM OP_CLINIC WHERE FACILITY_ID = A.FACILITY_ID AND CLINIC_CODE = A.LOCN_CODE) cur_open_to_all_pract_yn  ,a.visit_type_CODE cur_visit_type_code ,a.queue_num queue_num, a.APPT_OR_WALK_IN_IND  case_type, a.referral_id referral_id, a.VISIT_TYPE_IND cur_vis_type_ind , DECODE(a.APPT_OR_WALK_IN_IND,'A','Y','N') visit_case ,a.appt_id appt_ref_no ,a.VISIT_TYPE_IND cur_visit_type_ind ,a.ROOM_NUM room_num ,a.OTHER_RES_CLASS OTHER_RES_CLASS ,a.OTHER_RESOURCE_ID OTHER_RESOURCE_ID ,a.episode_id episode_id ,a.OP_EPISODE_VISIT_NUM episode_visit_num FROM OP_CURRENT_PATIENT a , AM_PRACTITIONER f WHERE a.facility_id = '"+fac_id+"' AND a.encounter_id = '"+p_encounter_id+"' AND a.practitioner_id = f.practitioner_id(+)");
	/*ACTION_ON_PRACT_SCHEDULE and TO_CHAR(SYSDATE,'dd/mm/yyyy') Sys_date  Added for JD-CRF-0183 [IN:041353] By Dharma on 21st Nov 2013*/ 
	pr_en_op_cl_am_sql.append("SELECT (select action_on_pract_schedule from op_param where OPERATING_FACILITY_ID='"+fac_id+"' ) action_on_pract_schedule,TO_CHAR(SYSDATE,'dd/mm/yyyy') Sys_date,A.LOCN_TYPE clinic_type  ,OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.LOCN_CODE,'"+locale+"','1') locn_desc   ,am_get_desc.AM_CARE_LOCN_TYPE(a.locn_type ,'"+locale+"',2)locn_type_desc   ,am_get_desc.AM_SERVICE(a.service_code,'"+locale+"',2) service_desc   ,am_get_desc.am_practitioner(A.practitioner_id,'"+locale+"',1) pract_name   ,op_get_desc.OP_VISIT_TYPE(a.facility_id,a.visit_type_code,'"+locale+"',2) visit_type_desc ,(select count(*) from op_resource_type_for_appt where visit_type_code=a.visit_type_code and facility_id=a.facility_id and resource_class='P') vstcount,am_get_desc.am_facility_room (a.facility_id,a.ROOM_NUM,'"+locale+"', 2) room_desc, a.speciality_code cur_speciality_code , NULL team_id , NULL team_desc   ,a.locn_code cur_locn_code   ,a.locn_type cur_locn_type  ,a.service_code cur_service_code ,a.subservice_code cur_subservice_code ,a.Practitioner_id cur_practitioner_id, nvl(f.pract_type,'?') cur_pract_type, 'A' cur_level_of_care_ind ,(SELECT open_to_all_pract_yn FROM OP_CLINIC WHERE FACILITY_ID = A.FACILITY_ID AND CLINIC_CODE = A.LOCN_CODE) cur_open_to_all_pract_yn  ,a.visit_type_CODE cur_visit_type_code ,a.queue_num queue_num, a.APPT_OR_WALK_IN_IND  case_type, a.referral_id referral_id, a.VISIT_TYPE_IND cur_vis_type_ind , DECODE(a.APPT_OR_WALK_IN_IND,'A','Y','N') visit_case ,a.appt_id appt_ref_no ,a.VISIT_TYPE_IND cur_visit_type_ind ,a.ROOM_NUM room_num ,a.OTHER_RES_CLASS OTHER_RES_CLASS ,a.OTHER_RESOURCE_ID OTHER_RESOURCE_ID ,a.episode_id episode_id ,a.OP_EPISODE_VISIT_NUM episode_visit_num FROM OP_CURRENT_PATIENT a , AM_PRACTITIONER f WHERE a.facility_id = '"+fac_id+"' AND a.encounter_id = '"+p_encounter_id+"' AND a.practitioner_id = f.practitioner_id(+)");
	
	
	/*CRF end SS-CRF-0010 [IN034516]*/
	
	try {
		
		pstmt=conn.prepareStatement(pr_en_op_cl_am_sql.toString());
		rs = pstmt.executeQuery();
	} catch(Exception e) {
		e.printStackTrace();
	}
  
    if (rs != null)
    {
        if(rs.next())
        {
        	action_on_pract_schedule	= rs.getString("action_on_pract_schedule");//Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013
        	Sysdate		 			= rs.getString("Sys_date");//Added for JD-CRF-0183 [IN:041353] By Dharma on 21st Nov 2013
        	p_service_code          =   rs.getString("cur_service_code");
			if (p_service_code == null || p_service_code.equals("null"))	p_service_code="";
			p_subservice_code		=	rs.getString("cur_subservice_code");
			 if (p_subservice_code == null || p_subservice_code.equals("null"))p_subservice_code="";
             p_cur_open_to_all_pract_yn  =   rs.getString("cur_open_to_all_pract_yn");            
            p_cur_pract_type        =   rs.getString("cur_pract_type");			
			if(p_cur_pract_type == null || p_cur_pract_type.equals("null"))p_cur_pract_type=" ";			
			p_cur_locn_type         =   rs.getString("cur_locn_type");
            p_cur_locn_code         =   rs.getString("cur_locn_code");
			p_cur_practitioner_id   =   rs.getString("cur_practitioner_id");
            p_cur_visit_type_code   =   rs.getString("cur_visit_type_code");
            p_cur_vis_type_ind		=   rs.getString("cur_vis_type_ind");
			p_team_id				=	rs.getString("team_id");
			p_team_desc				=	rs.getString("team_desc");
            visit_type_desc         =   rs.getString("visit_type_desc");
            visitcase = rs.getString("visit_case");
			appt_ref_no=(rs.getString("appt_ref_no") == null)?"":rs.getString("appt_ref_no");
            if (p_cur_practitioner_id == null)p_cur_practitioner_id="";				
			queue_num=(rs.getString("queue_num") == null)?"":rs.getString("queue_num");
			appt_walk_ind=(rs.getString("case_type") == null)?"":rs.getString("case_type");
			referral_id=(rs.getString("referral_id") == null)?"":rs.getString("referral_id");
            if (p_team_id == null || p_team_id.equals("null"))	p_team_id="";
            if (p_team_desc == null || p_team_desc.equals("null"))	p_team_desc="";
            secResPractCount=rs.getInt("vstcount");
			
			
			//Below line modified for this incident [60902]
			if(module_id.equals("")) {
				if(!appt_ref_no.equals("")){
						appt_walk_ind="A";
				}else if(!referral_id.equals("")){
						appt_walk_ind="R";
				}		
			}			
			
			 
			if(module_id.equals("CA")) {
			   //Below line commented and  modified for this incident [60902]
				/*if(!(appt_ref_no.equals("") && referral_id.equals("")))
						appt_walk_ind="A";
				else if(!referral_id.equals(""))
						appt_walk_ind="R";
			      */
				if(!appt_ref_no.equals("")){
						appt_walk_ind="A";
				}else if(!referral_id.equals("")){
						appt_walk_ind="R";	
                 }	
               //End this incident [60902]				 
						
				other_res_code=rs.getString("OTHER_RESOURCE_ID");
				if(other_res_code == null)other_res_code="";			
				other_res_class=rs.getString("OTHER_RES_CLASS");
				if(other_res_class == null) other_res_class="";
			}
			rval=rs.getString("room_num");
			 /* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
			  room_desc=rs.getString("room_desc");
			  if(room_desc == null) room_desc="";
			 /*CRF end SS-CRF-0010 [IN034516]*/
			episode_id=rs.getString("episode_id");
			if(episode_id == null) episode_id="";
			episode_visit_num=rs.getString("episode_visit_num");
			if(episode_visit_num == null) episode_visit_num="";
			
            out.println("<center><table width='95%' cellpadding='0' cellspacing='0' BORDER='0' align='center'><tr><td class='BORDER'>");

            out.println("<table width='100%' cellpadding='1' cellspacing='0' BORDER='0' >");
            out.print("<td class='COLUMNHEADER'></td><td class='COLUMNHEADER' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.current.label","common_labels")+"</tD><tD class='COLUMNHEADER'  >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.AssignReAssign.label","op_labels")+"</tD><tD class='COLUMNHEADER'>&nbsp;</tD>");
            
			out.println("<tr>");
			out.println("<td   class='label' width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</td>");
            out.println("<td  class='QUERYDATA'  width='25%'>"+"" +rs.getString("locn_desc") + "/" + rs.getString("locn_type_desc") + "</td>");
		    			
			if (p_mode.equals("R")) {
				sm_day_sql.append("SELECT  a.clinic_code ass_clinic_code  , a.clinic_type  , c.short_desc ass_clinic_type , a.long_desc short_desc  , a.speciality_code speciality_code  , a.open_to_all_pract_yn open_to_all_pract_yn , a.pract_type pract_type FROM  OP_CLINIC_lang_vw a , (  SELECT day_no FROM SM_DAY_OF_WEEK WHERE day_of_week = RTRIM(TO_CHAR(SYSDATE,'DAY'))) b   ,AM_CARE_LOCN_TYPE_lang_vw c WHERE a.facility_id='"+fac_id+"' AND a.language_id='"+locale+"'  AND a.language_id = c.language_id AND");
				if(!visitcase.equals("Y") && appt_ref_no.equals("")) {
				sm_day_sql.append("  DECODE(b.day_no,'1',working_day_1,'2',working_day_2,'3',working_day_3,'4', working_day_4,'5',working_day_5,'6',working_day_6,'7',working_day_7)='Y' AND");
				}
				sm_day_sql.append(" a.level_of_care_ind = 'A' AND a.allow_visit_regn_yn='Y' AND a.eff_status='E'   AND ((a.age_group_code IS NULL) OR (a.age_group_code IS NOT NULL) AND EXISTS (SELECT      age_group_code FROM AM_AGE_GROUP WHERE age_group_code=a.age_group_code AND NVL(gender,'"+p_gender+"')='"+p_gender+"' AND TO_DATE(TO_CHAR(SYSDATE,'dd/mm/yyyy'),'dd/mm/yyyy') - TO_DATE('"+p_dob+"','dd/mm/yyyy') BETWEEN DECODE(age_unit,'Y',365,'M',30,1)*min_age AND DECODE(age_unit,'Y',365,'M',30,1)*max_age AND eff_status='E')) AND a.CLINIC_CODE IN ( SELECT    CLINIC_CODE FROM OP_CLINIC WHERE FACILITY_ID='"+fac_id+"' AND SERVICE_CODE ='"+p_service_code+"'   UNION SELECT CLINIC_CODE FROM OP_CLINIC_FOR_SERVICE WHERE FACILITY_ID = '"+fac_id+"' AND SERVICE_CODE = '"+p_service_code+"') AND c.locn_type = a.clinic_type AND c.care_locn_type_ind = '"+p_care_locn_id+"' AND EXISTS(SELECT LOCN_CODE FROM AM_OS_USER_LOCN_ACCESS_VW WHERE FACILITY_ID = A.FACILITY_ID AND LOCN_CODE = A.CLINIC_CODE AND locn_type=a.clinic_type and OPER_STN_ID = '"+oper_id+"' AND APPL_USER_ID = '"+userid+"' AND revise_visit_yn = 'Y') ORDER BY  short_desc");                
				try {
					pstmt1=conn.prepareStatement(sm_day_sql.toString());
					rs1 = pstmt1.executeQuery();
				} catch(Exception e) {
					e.printStackTrace();
				}                
                String c="";
                out.println("<td  class='FIELDS' width='25%'>" + "<select name='LAssign1' id='LAssign1' onChange='Changeobj(this);PopulatePractList();' "+disable_pract+">");
				if (rs1 != null) {
				    try{
						while (rs1.next()) {
							p_clinic_code   = rs1.getString("ass_clinic_code");						
							p_clinic_type = rs1.getString("ass_clinic_type");
							p_clinic_type_code = rs1.getString("clinic_type");
							p_clinic_desc   = rs1.getString("short_desc");
							p_speciality_code=rs1.getString("speciality_code");
							p_open_to_all_pract_yn=rs1.getString("open_to_all_pract_yn");
							p_ppract_type=rs1.getString("pract_type");
							if(p_ppract_type == null) p_ppract_type="?";
							constr = p_clinic_code +"|"+p_clinic_type+"|"+p_clinic_type_code+"|"+p_speciality_code+"|"+p_open_to_all_pract_yn+"|"+p_ppract_type;			
							 if (p_clinic_code.equals(p_cur_locn_code)) {
							  out.println("<option value='"+constr+"' selected>"+p_clinic_desc);
								c = p_clinic_type;
							 } else {							
								out.println("<option value='"+constr+"'>"+p_clinic_desc);
							  }
						  }
						}catch(Exception e) {
							e.printStackTrace();
						}
						out.println("</select><img src='../../eCommon/images/mandatory.gif'></td>");
						out.println("<td   class='QUERYDATA' id='LAssign2'>"+c+"</td>");
                   }
					if(rs1 != null) rs1.close();
					if(pstmt1 != null) pstmt1.close();                
			} else {   
				out.println("<td  ></td>"); 		
                p_clinic_code = rs.getString("cur_locn_code");
                p_clinic_type = rs.getString("cur_locn_type");
                p_clinic_type_code = rs.getString("clinic_type");
				p_speciality_code=rs.getString("cur_speciality_code");
                out.println("<input type='hidden' name='LAssign1' id='LAssign1' value= '"+p_clinic_code+"|"+p_clinic_type+"|"+p_clinic_type_code+"|"+p_speciality_code+"|"+p_cur_open_to_all_pract_yn+"|"+p_cur_pract_type+"'>"); 			
			}           
			out.println("<input type='hidden' name='locndesc' id='locndesc' value= '"+p_clinic_code+"|"+p_clinic_type+"|"+p_clinic_type_code+"|"+p_speciality_code+"|"+p_open_to_all_pract_yn+"|"+p_ppract_type+"' >");
			out.println("</tr><tr>");
            /* Below line query modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
			out.println("<td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels")+ "</td>");	
            /*CRF end SS-CRF-0010 [IN034516]*/			
			sm_day_sql.setLength(0);

			//commented by venkat
			//String sqlc="select practitioner_id ROOM_NO from op_pract_for_clinic where facility_id='"+fac_id+"' and clinic_code='"+p_cur_locn_code+"' and eff_status='E' and resource_class='R' order by practitioner_id"; 
			/* Below line query modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
			 /*Below query was modified by Venkatesh.S (36094) on 07-Nov-2012 aganist 36094 */
			String sqlc="SELECT   a.practitioner_id room_no,am_get_desc.am_facility_room (a.facility_id, a.practitioner_id,'"+locale+"', 2) room_desc FROM op_pract_for_clinic a  WHERE facility_id = '"+fac_id+"' AND clinic_code = '"+p_locn_code+"' AND eff_status = 'E' AND resource_class = 'R' ORDER BY practitioner_id";
			/* end 36094 */
			/*CRF end SS-CRF-0010 [IN034516]*/
			pstmt1=conn.prepareStatement(sqlc);
			rsc=pstmt1.executeQuery();
		
			if(rval != null) {
				if(rval.equals("*ALL"))
				 rval = "";
			}			
			if(rval == null || rval.equals("null"))rval = "";			
	       /* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */	
			out.println("<td  align='left'class='QUERYDATA' >"+rval+" "+room_desc+"</td>");
			/*CRF end SS-CRF-0010 [IN034516]*/
			out.println("<td   id='room_value' ><select name='room_numsel' id='room_numsel' onChange='chgvalue(this);'>");
			out.println("<option value=''>------------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------------------</option>");			
						 boolean flagVal=false;
						  total_rec=0;
						 while(rsc.next()) {
							 total_rec++;
							 flagVal=true;
							 room_no=rsc.getString("room_no");
							 /* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
							 room_desc1=rsc.getString("room_desc");
							 if(room_no.equals(rval) && room_desc1.equals(room_desc) &&(rval != null) && (room_desc1 !=null) ) {
								out.println("<option value='"+room_no+"' selected>"+room_no+" "+room_desc1+"</option>");
								roomno=rval;
							 } else {
								out.println("<option value='"+room_no+"'>"+room_no+" "+room_desc1+"</option>");
							  }
							  /*CRF end SS-CRF-0010 [IN034516]*/
						   }			
					if(rsc != null) rsc.close();
					if(pstmt1 != null) pstmt1.close();

			if(flagVal==true) {
				out.println("</select><img src='../../eCommon/images/mandatory.gif'>");			 
			} else {
				roomno="NoRoom";
				out.println("</select>");
			}
            out.println("</td></tr>");
            out.println("<tr>");			
            out.println("<td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+ "</td>");
            out.println("<td   class='QUERYDATA'>"+"" + rs.getString("service_desc") + "</td>");
			out.println("<td  align='left' class='QUERYDATA' >"+ rs.getString("service_desc") + "</td>");    			
			out.println("</tr><tr>");			
			out.println("<td   class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.subservice.label","common_labels")+"</td>");
			String p_subservice_desc="";	
			out.println("<td  align='left' id = 'prevsubservice' class='QUERYDATA' >"+p_subservice_desc+"</td>");
			out.println("<td  align='left' class='QUERYDATA'><select name='sub_service_code' id='sub_service_code' onChange='chgvalue(this)'><option value=''>--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---");

			pstmt1=conn.prepareStatement("select subservice_code,short_desc from am_subservice_lang_vw where service_code='"+p_service_code+"' and language_id='"+locale+"'");
			try{
				rs1=pstmt1.executeQuery();
			 } catch(Exception e) 
			{e.printStackTrace();}

			if(rs1 != null) {				
			  while(rs1.next()) {
					String subserv_code=rs1.getString("subservice_code");
					String subserv_desc=rs1.getString("short_desc");
					if(subserv_code.equals(p_subservice_code)) {
						out.println("<option value='"+subserv_code+"' selected>"+subserv_desc);		
						p_subservice_desc = subserv_desc;							
					} else {
						out.println("<option value='"+subserv_code+"'>"+subserv_desc);			
					}
			   }				
			}			
			 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_subservice_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);

			if(rs1 != null) rs1.close();
			if(pstmt1 != null) pstmt1.close();
			out.println("</select></td>");			
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</td>");
			String pract_name = rs.getString("pract_name")==null?"":rs.getString("pract_name");
			
          if(!module_id.equals("CA")) { 				 
				if (!p_cur_pract_type.equals("?")) {
					pstmt1 = conn.prepareStatement("select nvl(desc_userdef,desc_sysdef) pract_type_desc from am_pract_type_lang_vw where pract_type = '"+p_cur_pract_type+"' and language_id='"+locale+"'");
					rs_pract = pstmt1.executeQuery();
					
					if (rs_pract.next()) {     
						out.println("<td align='left' class='QUERYDATA' >"+"" + pract_name + "/" + rs_pract.getString("pract_type_desc") + "</td>");
					 } else {   
						pract=pract_name;
						if(pract==null)pract="";
						out.println("<td align='left'class='QUERYDATA' >"+"" + pract + "</td>");
					  }
					 if(rs_pract != null) rs_pract.close();
					 if(pstmt1 != null) pstmt1.close();               
				 } else {			
						out.println("<td  align='left' class='QUERYDATA' >"+"" + pract_name + "</td>");					
                 }
               if (p_cur_pract_type.equals("?"))
                    p_cur_pract_type="";
			       cur_pract = p_cur_pract_type;
                   temp_pract=pract_name;
                 if(temp_pract!=null) {
			        if(temp_pract.equals(" ")) {
				         temp_pract="";
			         }
		           }else{
			            temp_pract="";
		           }
			} else {       
				
				out.println("<td  align='left' class='QUERYDATA' >"+"" + pract_desc + "</td>");
				//starts here
				if (p_cur_pract_type.equals("?")) 
                    p_cur_pract_type="";
				if(p_cur_open_to_all_pract_yn.equals("Y")) {															//to be checked
					psql.append("SELECT count(*) total FROM op_register_visit_pract_vw d,am_practitioner a,am_pract_type b,am_speciality c,op_clinic e WHERE a.pract_type = b.pract_type AND d.facility_id = e.facility_id AND d.clinic_code = e.clinic_code AND c.speciality_code = e.speciality_code AND d.practitioner_id = a.practitioner_id AND e.speciality_code = '"+p_speciality_code+"' AND d.facility_id = '"+fac_id+"' AND d.clinic_code = '"+p_cur_locn_code+"' AND a.practitioner_id='"+p_pract_id+"'");
				 } else {
					psql.append("SELECT count(*) total FROM am_practitioner a, am_pract_type b,am_speciality c, op_pract_for_clinic e,op_clinic f WHERE a.pract_type=b.pract_type AND f.speciality_code=c.speciality_code and e.clinic_code=f.clinic_code AND f.speciality_code='"+p_speciality_code+"' AND e.practitioner_id = a.practitioner_id AND e.clinic_code = '"+p_cur_locn_code+"' AND e.facility_id = '"+fac_id+"' and a.practitioner_id='"+p_pract_id+"' ");
				if(p_cur_pract_type != "R") {
					psql.append("AND NVL(a.pract_type,'X') = NVL('"+p_cur_pract_type+"',NVL(a.pract_type,'X'))");
				  }
				}				
				pstmt1=conn.prepareStatement(psql.toString());
				rs1=pstmt1.executeQuery();
				if(rs1 != null)
				{
					if(rs1.next())
					{
						tot=rs1.getInt(1);
					}
				}
				if(rs1 != null) rs1.close();
				if(pstmt1 != null) pstmt1.close();
				psql.setLength(0);
				//ends here
				if(tot==0)
				   temp_pract="";
				else
				temp_pract=pract_desc;
			}
 

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(temp_pract));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disable_pract));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable_pract));
            _bw.write(_wl_block14Bytes, _wl_block14);

				if(!module_id.equals("CA"))
			{
				
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_cur_practitioner_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
}else
			{
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_pract_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } 
            _bw.write(_wl_block19Bytes, _wl_block19);

					if(!p_cur_pract_type.equals("?"))
				{
					//pstpr=conn.prepareStatement("select pract_type,desc_sysdef from am_pract_type where pract_type='"+p_cur_pract_type+"'");

					pstpr=conn.prepareStatement("select pract_type,desc_sysdef from am_pract_type_lang_vw where language_id='"+locale+"' and pract_type='"+p_cur_pract_type+"'");

					rspr=pstpr.executeQuery();
					if(rspr != null)
				{
						while(rspr.next())
					{
							p_cur_pract_type_desc=rspr.getString(2);
								
					}
				}
				if(rspr != null) rspr.close();
				if(pstpr != null) pstpr.close();
				

			}
			else
			{
				p_cur_pract_type_desc="";
			}

			  p_cur_pract_type = "";

			
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_cur_pract_type_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
			
            out.println("</tr>");
        }
    }
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();

	//Added by Ajay Hatwate for ML-MMOH-CRF-1930 US10
	if(isVirtualConsultationVisit){
	pstmt = conn.prepareStatement("select virtual_consultation from op_visit_type where visit_type_code  = '" + p_cur_visit_type_code+"' ");
	rs = pstmt.executeQuery();
	rs.next();
	isVirtConsVisType = rs.getString("virtual_consultation");
	}
    pr_en_op_cl_am_sql.setLength(0);

    out.println("<tr>");
    out.println("<td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.visittype.label","common_labels")+"</td>");
    out.println("<td  class='QUERYDATA'>"+""+visit_type_desc+"</td>");

    out.println("<td   class='label'>");
    // populate visit Type
	}
	catch(Exception e){
		e.printStackTrace();
		}
	finally{
		if(pstmt != null) pstmt.close();
		if(pstmt1 != null) pstmt1.close();
		if (rs_pract != null) rs_pract.close();
		pr_en_op_cl_am_sql.setLength(0);
		sm_day_sql.setLength(0);
	}    
	out.println("</td><td ></td>");
    out.println("</tr>");
    out.println("<tr>");
	

	if(!(other_res_code.equals("")))
		{
		pstmt = conn.prepareStatement("SELECT DECODE(RESOURCE_CLASS, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','2'),	               'R', AM_GET_DESC.AM_FACILITY_ROOM(facility_id, practitioner_id,'"+locale+"','2'), 'E', AM_GET_DESC.AM_RESOURCE(facility_id,practitioner_id,'"+locale+"','2'),  'O', AM_GET_DESC.AM_RESOURCE(facility_id,practitioner_id,'"+locale+"','2'))PRACTITIONER_SHORT_NAME, practitioner_id description,clinic_code FROM op_pract_for_clinic WHERE facility_id='"+fac_id+"'  AND resource_class='"+other_res_class+"' AND clinic_code='"+p_cur_locn_code+"' AND practitioner_id='"+other_res_code+"'");
		
		rs = pstmt.executeQuery();
		if(rs != null)
		{
			if(rs.next())
			{
				oth_res_desc=rs.getString(1);
			}
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(oth_res_desc == null) oth_res_desc="";
		}
		if(!other_res_code.equals(""))			
			res_tot=other_res_class_desc+"/"+oth_res_desc;		
		else {
			
			res_tot=other_res_class_desc;
		}
		
	out.println("<td   class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.OtherResource.label","op_labels")+ "</td>");
    out.println("<td  align='left' class='QUERYDATA'>"+""+res_tot+"</td>");

    out.println("<td  align='left' class='QUERYDATA'>");
	try{

		
	out.println("<select name='other_res_type' id='other_res_type' onChange='clearResourceVal(this);'><option value=''>--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---</option>");
	if(other_res_class.equals("E"))
	{
	out.println("<option value='"+other_res_class+"' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels")+"</option><option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels")+"</option>");	
	}else if(other_res_class.equals("O"))
	{
	out.println("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels")+"</option><option value='"+other_res_class+"' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels")+"</option>");	
	}else
	{
	out.println("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels")+"</option><option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels")+"</option>");	
	}
	out.println("</select>/");

	out.println("<input type='text' name='other_res_txt' id='other_res_txt' maxlength='12' size='10' value='"+oth_res_desc+"'><input type='button' class='button' name='other_res_butt' id='other_res_butt' value='?'  onClick='otherResourceLookUp(this,other_res_txt);' >");

	out.println("<input type='hidden' name='other_res_code' id='other_res_code' value='"+other_res_code+"'>");
	
	}catch(Exception ee)
	{
		ee.printStackTrace();
	}
	out.println("</td>");
	out.println("<td ></td>");
	out.println("</tr>");
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block24Bytes, _wl_block24);
if(multi_speciality_yn.equals("Y") && secResPractCount>0 ){
		try{
			String secResSql="select practitioner_id from PR_ENCOUNTER_JOINT_CONSULT where facility_id='"+fac_id+"' and linked_yn='Y' and encounter_id= "+p_encounter_id+" and PRACTITIONER_ID not in ('"+p_cur_practitioner_id+"')";
			PreparedStatement pstmtSecRes=conn.prepareStatement(secResSql);
			ResultSet rsSecRes=pstmtSecRes.executeQuery();
			while(rsSecRes.next()){
				practList=practList+rsSecRes.getString("practitioner_id")+"$";
			}			
		}catch(Exception e){
		}
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_cur_locn_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(practList));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
	
	out.println("</table>");

    out.println("</center></td></tr></table>");

    out.println("</center></td></tr></table>");
	if(multi_speciality_yn.equals("Y") ){
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(p_cur_locn_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(practList));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
	
   out.println("<input type='hidden' name='patientid' id='patientid' value='"+p_patient_id+"'>");
    out.println("<input type='hidden' name='locntype' id='locntype' value='"+p_locn_type+"'>");
    out.println("<input type='hidden' name='locncode' id='locncode' value='"+p_locn_code+"'>");
    out.println("<input type='hidden' name='encounterid' id='encounterid' value='"+p_encounter_id+"'>");
    out.println("<input type='hidden' name='practid' id='practid' value='"+p_pract_id+"'>");
    out.println("<input type='hidden' name='pmode' id='pmode' value='"+p_mode+"'>");
    out.println("<input type='hidden' name='curlocncode' id='curlocncode' value='"+p_cur_locn_code+"'>");
    out.println("<input type='hidden' name='curlocntype' id='curlocntype' value='"+p_cur_locn_type+"'>");
    out.println("<input type='hidden' name='curpractid' id='curpractid' value='"+p_cur_practitioner_id+"'>");
	
    out.println("<input type='hidden' name='curpracttype' id='curpracttype' value='"+p_cur_pract_type+"'>");
	out.println("<input type='hidden' name='curpracttype1' id='curpracttype1' value='"+cur_pract+"'>");
    out.println("<input type='hidden' name='curvisittypecode' id='curvisittypecode' value='"+p_cur_visit_type_code+"'>");
    out.println("<input type='hidden' name='cur_vis_type_ind' id='cur_vis_type_ind' value='"+p_cur_vis_type_ind+"'>");
    out.println("<input type='hidden' name='visitcase' id='visitcase' value='"+visitcase+"'>");
    out.println("<input type='hidden' name='unlinkapptcaseyn' id='unlinkapptcaseyn' value='N'>");
	out.println("<input type='hidden' name='p_queue_date' id='p_queue_date' value='"+p_queue_date+"'>");
	out.print("<input type='hidden' name='team_id' id='team_id' value='"+p_team_id+"'>");
	out.print("<input type='hidden' name='room_num' id='room_num' value='"+roomno+"'>");
	out.print("<input type='hidden' name='room_change' id='room_change' value=''>");
	out.println("<input type='hidden' name='room_cur' id='room_cur' value='"+rval+"'>");
	out.println("<input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='"+p_cur_open_to_all_pract_yn+"'>");

	out.print("<input type='hidden' name='ALLOW_WALK_IN_YN' id='ALLOW_WALK_IN_YN' value='"+ALLOW_WALK_IN_YN+"'>");
	out.print("<input type='hidden' name='IDENT_AT_CHECKIN' id='IDENT_AT_CHECKIN' value='"+IDENT_AT_CHECKIN+"'>");
	out.print("<input type='hidden' name='service_code_h' id='service_code_h' value='"+p_service_code+"'>");
	out.print("<input type='hidden' name='service_code_h_new' id='service_code_h_new' value='"+p_service_code+"'>");

	out.print("<input type='hidden' name='locale' id='locale' value='"+locale+"'>");
	out.print("<input type='hidden' name='sub_service_code_h' id='sub_service_code_h' value='"+p_subservice_code+"'>");
	out.print("<input type='hidden' name='chg_flag' id='chg_flag' value=''>");
	out.print("<input type='hidden' name='bl_install_yn' id='bl_install_yn' value='"+bl_install_yn+"'>");
	
	out.print("<input type='hidden' name='appt_ref_no' id='appt_ref_no' value='"+appt_ref_no+"'>");
    out.print("<input type='hidden' name='fac_id' id='fac_id' value='"+fac_id+"'>");
	out.print("<input type='hidden' name='appt_id' id='appt_id' value='"+appt_id+"'>");
	out.print("<input type='hidden' name='VITAL_SIGNS_DATE_TIME' id='VITAL_SIGNS_DATE_TIME' value='"+VITAL_SIGNS_DATE_TIME+"'>");
	out.print("<input type='hidden' name='ARRIVE_DATE_TIME' id='ARRIVE_DATE_TIME' value='"+ARRIVE_DATE_TIME+"'>");
	out.print("<input type='hidden' name='appt_walk_ind' id='appt_walk_ind' value='"+appt_walk_ind+"'>");
	out.print("<input type='hidden' name='queue_num' id='queue_num' value='"+queue_num+"'>");
	out.print("<input type='hidden' name='module_id' id='module_id' value='"+module_id+"'>");
	out.print("<input type='hidden' name='userid' id='userid' value='"+userid+"'>");
	out.print("<input type='hidden' name='queue_id' id='queue_id' value='"+queue_id+"'>");
	out.print("<input type='hidden' name='episode_id' id='episode_id' value='"+episode_id+"'>");
	out.print("<input type='hidden' name='episode_visit_num' id='episode_visit_num' value='"+episode_visit_num+"'>");
	out.print("<input type='hidden' name='assign_q_num_by' id='assign_q_num_by' value='"+assign_q_num_by+"'>");
	out.print("<input type='hidden' name='cur_qms_interfaced_yn' id='cur_qms_interfaced_yn' value='"+qms_interfaced_yn+"'>");
	out.print("<input type='hidden' name='qms_interfaced_yn' id='qms_interfaced_yn' value='N'>");
	out.print("<input type='hidden' name='qms_exception' id='qms_exception' value='N'>");
	out.print("<input type='hidden' name='multi_speciality_yn' id='multi_speciality_yn' value='"+multi_speciality_yn+"'>");//Added for the crf - Bru-HIMS-CRF-0198
	out.print("<input type='hidden' name='practList' id='practList' value='"+practList+"'>");//Added for the crf - Bru-HIMS-CRF-0198
	out.print("<input type='hidden' name='isPatientEncMovement' id='isPatientEncMovement' value='"+isPatientEncMovement+"'>");//Added for this CRF Bru-HIMS-CRF-133
	out.print("<input type='hidden' name='Sydate' id='Sydate' value='"+Sydate+"'>");//Added for this CRF Bru-HIMS-CRF-133
	out.print("<input type='hidden' name='p_queue_status' id='p_queue_status' value='"+p_queue_status+"'>");//Added for this CRF Bru-HIMS-CRF-133
	out.print("<input type='hidden' name='virtualConsultEnable' id='virtualConsultEnable' value='"+isVirtConsVisType+"'>");//Added by Ajay Hatwate for ML-MMOH-CRF-1930 US10
	out.print("<input type='hidden' name='isVirtualConsultationVisit' id='isVirtualConsultationVisit' value='"+isVirtualConsultationVisit+"'>");//Added by Ajay Hatwate for ML-MMOH-CRF-1930 US10
	out.print("<input type='hidden' name='functionId' id='functionId' value='ASSIGN_PRACTITIONER_FOR_OP'>");//Added by Ajay Hatwate for ML-MMOH-CRF-1930 US10
	out.print("<input type='hidden' name='visit_adm_type' id='visit_adm_type' value='"+p_cur_visit_type_code+"'>");//Added by Ajay Hatwate for ML-MMOH-CRF-1930 US10
	
	out.print("<input type='hidden' name='isQMSapplicable' id='isQMSapplicable' value='"+isQMSapplicable+"'>");//Added by Himanshu for ML-BRU-CRF-0628.11




	

            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

		if(module_id.equals("CA"))
		{
		     if(total_rec == 0 ||!rval.equals(""))
			 {
				if(tot !=0 )
				 {
                   
            _bw.write(_wl_block37Bytes, _wl_block37);

				 }
			 }
		}
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(Sysdate));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(p_pract_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(action_on_pract_schedule ));
            _bw.write(_wl_block41Bytes, _wl_block41);

}
catch ( Exception e ){try{out.println("error="+e);}
catch(Exception c){
	c.printStackTrace();
}}

finally{

    try{    
    if ( rs1 != null ) rs1.close() ;   
    if ( rs2 != null ) rs2.close() ;	
	
    if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}catch(Exception e){
		e.printStackTrace();
	}

    }

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueNo.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SecondaryResources.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Additional.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SecondaryResources.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.record.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
}
