package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.CommonBean;
import eOR.OrderEntryBillingQueryBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import eCommon.XSSRequestWrapper;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __recordsurgeon extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/RecordSurgeon.jsp", 1709117278000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n<head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eOT/js/RecordSurgeon.js\"></script>\n\t<script language=\"javascript\" src=\"../../eOT/js/Hashtable.js\"></script>\n\t<script language=\"javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n</head>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<FRAMESET rows=\"42,12%,11%,8%,*,8%,10%,0%\" border=\'0\'>\n    <frame name=\"commontoolbarFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<frame name=\'OtPatientLineFrame\' SRC=\'../../eOT/jsp/OTPatLineFrame.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'  scrolling=\'yes\' noresize>\n\t<frame name=\'common_patient_hdr_frame\' SRC=\'../../eOT/jsp/CommonOperDtlsHdr.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'  scrolling=\'yes\' noresize></frame>\n\t<FRAMESET rows=\'0,*\' border=\'0\'>\n\t<FRAME NAME=\'ObjectCollect\'scrolling=\'no\' noresize=\'no\' SRC=\'../../eOT/jsp/OperCollectObject.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'  ></FRAME>\n\t <frame name=\"tab_frame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eOT/jsp/RecordSurgeonTab.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"></frame>    \t    \n\t</FRAMESET>\n\t<frame name=\"RecordFrame\" src=\"../../eCommon/html/blank.html\" frameborder=\"0\" noresize scrolling=\"auto\"></frame>\n\t<frame name=\'doc_status_frame\' SRC=\"../../eCommon/html/blank.html\" frameborder=\"0\" noresize scrolling=\"auto\"></frame>\n\t<frame name=\"messageFrame\" src=\"../../eCommon/jsp/error.jsp\" frameborder=\"0\" noresize scrolling=\"auto\"></frame>\n\t<frame name=\"content\" frameborder=\"0\" scrolling=\"no\" src=\"../../eOT/jsp/ContentMessageFrame.jsp\" noresize>\n<!--Chaitanya\n\t<FRAME NAME=\'RecordFrame\' SRC=\'../../eOT/jsp/ProcedureFrames.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'  scrolling=\'no\' noresize=\'no\'></FRAME> \n\t<frame name=\'doc_status_frame\' src=\"../../eOT/jsp/SurgeonDocStatus.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" frameborder=\"0\" nowrap noresize scrolling=\'yes\' >\n\t<frame name=\"messageFrame\" src=\"../../eCommon/jsp/error.jsp\" frameborder=\"0\" noresize scrolling=\"auto\"></frame>\n\t<frame name=\"content\" frameborder=\"0\" scrolling=\"no\" src=\"../../eOT/jsp/ContentMessageFrame.jsp\" noresize>\n-->\n</FRAMESET>\n<body  onKeyDown = \'lockKey();\'>\n<form name=\"OTCheckinForm\" >\n\t<input type=\'hidden\' name=\'params\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' >\n\t<input type=\'hidden\' name=\'check_in_time\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' >\n\t<input type=\"hidden\" name=\"Link_Operation_And_Notes_in_Record_Surgeon_Notes\" id=\"Link_Operation_And_Notes_in_Record_Surgeon_Notes\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/

 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facility_id = (String) session.getAttribute("facility_id");

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String bill_interface_flag_yn="",bill_sub_services_yn="",params="",source="",rec_implants_in_nurs_notes_yn="",rec_implants_in_surg_notes_yn="",rec_equp_in_nurs_notes_yn="",rec_instr_in_nurs_notes_yn="",rec_packs_in_nurs_notes_yn="",finalize_implants_in="",finalize_equp_in="",finalize_instr_in="",finalize_packs_in="",oper_finalization_stage="",storeCode="",st_interface_flag="",operation_sub_services_yn="",surgeon_doc_comp_yn="",nursing_doc_comp_yn="",implant_entry_cmp_yn="",consumable_entry_cmp_yn="",equipment_entry_cmp_yn="",instrument_entry_cmp_yn="",proc_chrg_cmp_yn="",check_into_or_time="",oper_room_code="", encounter_id="",episode_type="",patient_class="",Link_Operation_And_Notes_in_Record_Surgeon_Notes="";//PMG MOD-0005
	String check_in_time = "";
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	 params = request.getQueryString();
	/*
	Commented by DhanasekarV against incident IN029391 billing subservices
		params=params+"&bill_interface_flag_yn="+bill_interface_flag_yn+"&bill_sub_services_yn="+bill_sub_services_yn;
	*/

	String tab_name = CommonBean.checkForNull(request.getParameter("tab_name"));//Added Against ML-MMOH-CRF-1939-US4
	String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String booking_num = CommonBean.checkForNull(request.getParameter("booking_num")); // 04000112
	String slate_user_id = CommonBean.checkForNull(request.getParameter("slate_user_id")); // logged in user from Slate
	if(called_from==null) called_from="OT_MENU";
	if(called_from!=null && called_from.equals("null")) called_from="OT_MENU";
	if(called_from!=null && called_from.equals("")) called_from="OT_MENU";
	String modified_date = "";

	try
	{
		con=ConnectionManager.getConnection(request);
		stmt=con.prepareStatement("SELECT BL_INTERFACE_FLAG,OPERATION_SUB_SERVICES_YN,DEF_ST_STORE,NVL(ST_INTERFACE_FLAG,'N') ST_INTERFACE_FLAG, NVL(REC_PACKS_IN_NURS_NOTES_YN, 'N') REC_PACKS_IN_NURS_NOTES_YN , nvl(OPERATION_SUB_SERVICES_YN,'N') OPERATION_SUB_SERVICES_YN,NVL(REC_IMPLANTS_IN_NURS_NOTES_YN,'N') REC_IMPLANTS_IN_NURS_NOTES_YN,NVL(REC_IMPLANTS_IN_SURG_NOTES_YN,'N') REC_IMPLANTS_IN_SURG_NOTES_YN, NVL(REC_EQUP_IN_NURS_NOTES_YN,'N') REC_EQUP_IN_NURS_NOTES_YN, NVL(REC_INSTR_IN_NURS_NOTES_YN,'N') REC_INSTR_IN_NURS_NOTES_YN,  NVL(FINALIZE_IMPLANTS_IN,'N') FINALIZE_IMPLANTS_IN,  NVL(FINALIZE_EQUP_IN,'N') FINALIZE_EQUP_IN,  NVL(FINALIZE_INSTR_IN,'N') FINALIZE_INSTR_IN,  NVL(FINALIZE_PACKS_IN,'N') FINALIZE_PACKS_IN, NVL(OPER_FINALIZATION_STAGE,'N') OPER_FINALIZATION_STAGE,LINK_OPER_RECORD_NOTES_YN  FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=?");//PMG MOD-0005
		stmt.setString(1,facility_id);
		rs=stmt.executeQuery();
		if(rs !=null && rs.next()){
			bill_interface_flag_yn=checkForNull(rs.getString(1),"N");
			bill_sub_services_yn=checkForNull(rs.getString(2),"N");
			storeCode=(rs.getString("DEF_ST_STORE"));
			st_interface_flag=(rs.getString("ST_INTERFACE_FLAG"));
			rec_packs_in_nurs_notes_yn=(rs.getString("REC_PACKS_IN_NURS_NOTES_YN"));
			operation_sub_services_yn=(rs.getString("OPERATION_SUB_SERVICES_YN"));
			rec_implants_in_nurs_notes_yn=rs.getString("REC_IMPLANTS_IN_NURS_NOTES_YN");
			rec_implants_in_surg_notes_yn=checkForNull(rs.getString("REC_IMPLANTS_IN_SURG_NOTES_YN"));
			rec_equp_in_nurs_notes_yn=checkForNull(rs.getString("REC_EQUP_IN_NURS_NOTES_YN"));
			rec_instr_in_nurs_notes_yn=checkForNull(rs.getString("REC_INSTR_IN_NURS_NOTES_YN"));
			finalize_implants_in=checkForNull(rs.getString("FINALIZE_IMPLANTS_IN"));
			finalize_equp_in=checkForNull(rs.getString("FINALIZE_EQUP_IN"));
			finalize_instr_in=checkForNull(rs.getString("FINALIZE_INSTR_IN"));
			finalize_packs_in=checkForNull(rs.getString("FINALIZE_PACKS_IN"));
			oper_finalization_stage=checkForNull(rs.getString("OPER_FINALIZATION_STAGE"));
			Link_Operation_And_Notes_in_Record_Surgeon_Notes=checkForNull(rs.getString("LINK_OPER_RECORD_NOTES_YN"));//PMG MOD-0005
		}
//Added modified_date by Anitha on modified_date
		stmt=con.prepareStatement("SELECT  TO_CHAR (check_in_time, 'DD/MM/YYYY HH24:MI') check_in_time, OPER_ROOM_CODE, ENCOUNTER_ID,NVL(NURSING_DOC_COMP_YN, 'N') NURSING_DOC_COMP_YN,NVL(SURGEON_DOC_COMP_YN, 'N') SURGEON_DOC_COMP_YN,NVL(IMPLANT_ENTRY_CMP_YN,'N')IMPLANT_ENTRY_CMP_YN,nvl(CONSUMABLE_ENTRY_CMP_YN,'N') CONSUMABLE_ENTRY_CMP_YN,nvl(EQUIPMENT_ENTRY_CMP_YN,'N')EQUIPMENT_ENTRY_CMP_YN,nvl(INSTRUMENT_ENTRY_CMP_YN,'N') INSTRUMENT_ENTRY_CMP_YN,nvl(PROC_CHRG_CMP_YN,'N')PROC_CHRG_CMP_YN,TO_CHAR(CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI') CHECK_INTO_OR_TIME,EPISODE_TYPE,PATIENT_CLASS,to_char(MODIFIED_DATE,'DD/MM/YYYY HH24:MI:SS') MODIFIED_DATE FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID=?");
		stmt.setString(1,facility_id);
		rs=stmt.executeQuery();

		if(rs !=null && rs.next())
		{
			 surgeon_doc_comp_yn = checkForNull(rs.getString("SURGEON_DOC_COMP_YN"));
			 if(surgeon_doc_comp_yn =="")
			 	surgeon_doc_comp_yn="N";
			 nursing_doc_comp_yn = checkForNull(rs.getString("NURSING_DOC_COMP_YN"));
			 if(nursing_doc_comp_yn =="")
			 	nursing_doc_comp_yn="N";
			 implant_entry_cmp_yn = checkForNull(rs.getString("IMPLANT_ENTRY_CMP_YN"));
			 if(implant_entry_cmp_yn =="")
			 implant_entry_cmp_yn="N";
			 consumable_entry_cmp_yn = checkForNull(rs.getString("CONSUMABLE_ENTRY_CMP_YN"));
			 if(consumable_entry_cmp_yn =="")
			 consumable_entry_cmp_yn="N";
			 equipment_entry_cmp_yn = checkForNull(rs.getString("EQUIPMENT_ENTRY_CMP_YN"));
			 if(equipment_entry_cmp_yn =="")
			 	equipment_entry_cmp_yn="N";
			 instrument_entry_cmp_yn = checkForNull(rs.getString("INSTRUMENT_ENTRY_CMP_YN"));
			 if(instrument_entry_cmp_yn =="")
			 	instrument_entry_cmp_yn="N";
			   proc_chrg_cmp_yn = checkForNull(rs.getString("PROC_CHRG_CMP_YN"));
			 if(proc_chrg_cmp_yn =="")
			 	proc_chrg_cmp_yn="N";
			  check_into_or_time= checkForNull(rs.getString("CHECK_INTO_OR_TIME"));
			  oper_room_code= checkForNull(rs.getString("OPER_ROOM_CODE"));
			  encounter_id= checkForNull(rs.getString("ENCOUNTER_ID"));
			  episode_type = checkForNull(rs.getString("EPISODE_TYPE"));
			 if(episode_type =="")
			 	episode_type="";
			  patient_class = checkForNull(rs.getString("PATIENT_CLASS"));
			 if(patient_class =="")
			 	patient_class=""; 
			  modified_date = checkForNull(rs.getString("MODIFIED_DATE"));
			 if(modified_date =="")
			 	modified_date="";
			 check_in_time = checkForNull(rs.getString("check_in_time"));
			 if(check_in_time == null || check_in_time.trim().length() == 0)
			 	check_in_time = "";
		}		
	String recordSurgeonNotes_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RecordSurgeonNotes.Label","ot_labels");

	

//Added bill_interface_flag_yn by DhanasekarV against incident IN029391 billing subservices
params=params+"&bill_interface_flag_yn="+bill_interface_flag_yn+"&bill_sub_services_yn="+bill_sub_services_yn;
//Added modified_date in params by Anitha on 2/3/2011
	params = params+"&function_name="+recordSurgeonNotes_title+""+"&called_from="+called_from+"&check_in_time="+check_in_time+"&booking_num="+booking_num+"&slate_user_id="+slate_user_id+"&facility_id="+facility_id+"&storeCode="+storeCode+"&st_interface_flag="+st_interface_flag+"&rec_packs_in_nurs_notes_yn="+rec_packs_in_nurs_notes_yn+"&operation_sub_services_yn="+operation_sub_services_yn+"&rec_implants_in_nurs_notes_yn="+rec_implants_in_nurs_notes_yn+"&rec_implants_in_surg_notes_yn="+rec_implants_in_surg_notes_yn+"&rec_equp_in_nurs_notes_yn="+rec_equp_in_nurs_notes_yn+"&rec_instr_in_nurs_notes_yn="+rec_instr_in_nurs_notes_yn+"&finalize_implants_in="+finalize_implants_in+"&finalize_equp_in="+finalize_equp_in+"&finalize_instr_in="+finalize_instr_in+"&finalize_packs_in="+finalize_packs_in+"&oper_finalization_stage="+oper_finalization_stage+"&surgeon_doc_comp_yn="+surgeon_doc_comp_yn+"&nursing_doc_comp_yn="+nursing_doc_comp_yn+"&implant_entry_cmp_yn="+implant_entry_cmp_yn+"&consumable_entry_cmp_yn="+consumable_entry_cmp_yn+"&equipment_entry_cmp_yn="+equipment_entry_cmp_yn+"&instrument_entry_cmp_yn="+instrument_entry_cmp_yn+"&proc_chrg_cmp_yn="+proc_chrg_cmp_yn+"&check_into_or_time="+check_into_or_time+"&encounter_id="+encounter_id+"&oper_room_code="+oper_room_code+"&episode_type="+episode_type+"&patient_class="+patient_class+"&modified_date="+modified_date+"&document_level_yn=Y&tab=record_surgeon&Link_Operation_And_Notes_in_Record_Surgeon_Notes="+Link_Operation_And_Notes_in_Record_Surgeon_Notes+"&tab_name="+tab_name;//PMG MOD-0005 Modified Against ML-MMOH-CRF-1939-US4
	 source = url + params ;
	String bean_id 						= "OrderEntryBillingQueryBean";
	String bean_name 					= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean		= (OrderEntryBillingQueryBean)getBeanObject( bean_id, bean_name, request ) ;
	or_bean.clearBean();
	cleanAll(session);
	}catch(Exception e){
	System.err.println("Exception in RecordSurgeon.jsp : "+e);
	e.printStackTrace();
	}finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){
		e.printStackTrace();
		}
	}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(source));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(params));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(params));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(params));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(params));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(params));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(params));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(params));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(check_in_time));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Link_Operation_And_Notes_in_Record_Surgeon_Notes));
            _bw.write(_wl_block20Bytes, _wl_block20);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RecordSurgeonNotes.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
