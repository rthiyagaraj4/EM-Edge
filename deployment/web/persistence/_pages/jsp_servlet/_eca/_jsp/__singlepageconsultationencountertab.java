package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCA.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __singlepageconsultationencountertab extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SinglePageConsultationEncounterTab.jsp", 1709116318544L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<HTML>\n\t<HEAD>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCA/js/SinglePageConsultation.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'></link>\n\t<style>\n\t\tbody{\n\t\t\tfont-family: Tahoma, Arial, Helvetica, sans-serif;\n\t\t\tfont-size: 11px;\n\t\t\tmargin: 1px 1px 10px 10px;\n\t\t\tpadding: 0 0 0 0;\n\t\t\tcolor:#000000;\n\t\t\tbackground:#ffffff;\n\t\t}\n\t</style>\n\t</HEAD>\n<TITLE>Single Page Consultation</TITLE>\n\n<body onKeyDown=\'lockKey()\' OnMouseDown=\'CodeArrest();\'>\n\t<form name=\"encounterSpecificTABform\" id=\"encounterSpecificTABform\" action=\"../../eCA/jsp/CAEncounterSpecificTAB.jsp\" method=\"post\">\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<table  cellpadding=0 cellspacing=0 border=\'0\' width=\'100%\' height=\'48px\'>\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td valign=\"top\">\n\t\t\t\t\t<style>\ndiv.menu3\n{\n    /*width:500px;margin:0 auto;*//*Uncomment this line to make the menu center-aligned.*/\n    text-align:left;\n    font-size:0;\n    height: 25px;    \n    border-bottom:1px solid #696000;\n    *position:relative;*top:1px;/*Hacks for IE6 & IE7 */    \n}\n\ndiv.menu3 a\n{\n    display: inline-block;\n    padding: 0 5px;\n    margin-right:1px; /* It specifies the distance between each tab */\n    /*background:#F7F7F7;*/\n    color:Black;\n    text-decoration:none;\n   /* font: normal 12px Arial;*/\n    line-height: 24px;\n    border:1px solid #696000;\n    border-bottom:0;\n    color:#666;\n    vertical-align:top;/*ChangeSet#2*/\n    text-decoration:none;\n    height:45px;\n    width:240px;\n    \n    -webkit-border-radius: 4px;\n\t-moz-border-radius: 4px;\n    border-radius: 4px 4px 0px 0px;\n    behavior: url(../../eCA/html/PIE.htc);\n}\n\n</style>\n\n\t\t\t\t\t<div class=\"menu3\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<a id=\'encounterTab";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'   href=\"javascript:showEncounterSpecificData(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\');\"  style=\"text-color:Red;font: ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="pt  Verdana,SansSerif,Arial; background : ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =";\" onMouseOver=\"highlightOnSelection(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\');\" onMouseOut=\"removehighlightOnSelection();\">\n\t\t\t\t\t\t\t\t\t<img src=\"../../eCA/images/";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" border=0 /> &nbsp;\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<INPUT TYPE=\'hidden\' name=\'encounter_id";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'encounter_id";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'  value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' >\n\t\t\t\t\t\t\t\t<INPUT TYPE=\'hidden\' name=\'encounterTabBgColor";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' id=\'encounterTabBgColor";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' >\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\n\t\t\t\t\t\t\t<A style=\"display: inline-block;padding: 0 5px;margin-right:1px;color:Black;text-decoration:none;line-height: 24px;border:0px;color:#666;vertical-align:middle;text-decoration:none;height:45px;width:10px;font: bold 38px Arial; background :#FFFFFF; \" href=\'javascript:onClick=showNextPreviousData(\"Previous\");\' >&#60;</A>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t<A style=\"display: inline-block;padding: 0 10px;margin-right:1px;color:Black;text-decoration:none;line-height: 24px;border:0px;color:#666;vertical-align:middle;text-decoration:none;height:45px;width:10px;font: bold 38px Arial; background :#FFFFFF; \" href=\'javascript:onClick=showNextPreviousData(\"Next\");\' >&#62;</A>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\t\n\t\t\t\t\t</div>\n\t\t\t\t</td>\t\t\t\t\n\t\t\t</tr>\n\t\t\t\t<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' name=\'totalVisits\'>\n\t\t\t\t<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' name=\'encounterIndex\'>\n\t\t\t\t<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' name=\'req_encounter_id\'>\n\t\t\t\t<input type=\'hidden\' value=\'\' name=\'encounter_id_spc\' id=\'encounter_id_spc\'>\n\t\t\t\t<input type=\'hidden\' name=\'total_tab_count\' id=\'total_tab_count\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'from_tab\' id=\'from_tab\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'to_tab\' id=\'to_tab\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'disp_mode\' id=\'disp_mode\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'location_code_spc\' id=\'location_code_spc\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t\t\t<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' name=\'query_string\'>\n\t\t\t\n\t\t\t</table>\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n</body>\n</HTML>\n<SCRIPT LANGUAGE=\"JavaScript\">\t\n\tshowEncounterSpecificData(\n\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =",\'\',\'ONLOAD\',";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =",\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\');\t\t\n\t\n\t\t</SCRIPT>\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );
	
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

int total_tab_count = 0;

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
 
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
20/05/2014    IN037701		Ramesh G				      					SKR-CRF-0036 	
17/06/2014	  IN049720		Nijitha 										SKR-CRF-0036	 	
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		webbeans.eCommon.RecordSet SubSecRecordSet = (webbeans.eCommon.RecordSet) getObjectFromBean("SubSecRecordSet", "webbeans.eCommon.RecordSet", session);
		
		
				
		Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");
		String encounter_id_spc = null;
		String patient_class_spc = null;
		String location_code_spc = "";
		String	facility_id			=	(String) session.getValue("facility_id");
		String  patient_id			=	request.getParameter("patient_id");
		String req_encounter_id= request.getParameter("encounter_id")==null?"":(String)request.getParameter("encounter_id");
		String practitioner_id = null,speciality_name=null,patient_class = null;
		practitioner_id = (String)session.getValue("ca_practitioner_id");
		if(practitioner_id == null) practitioner_id="";
		speciality_name = request.getParameter("location_code")==null?"":request.getParameter("location_code");
		patient_class = request.getParameter("patient_class")==null?"EM":request.getParameter("patient_class");
		String disp_mode = request.getParameter("disp_mode")==null?"":request.getParameter("disp_mode");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmtencounter = null;
		ResultSet rsencounter = null;
		ArrayList encounterList = new ArrayList();
		HashMap<String, String> encounterMap = null;
		HashMap<String, String> encounterMapPage = null;
		List<String> displayIconDtl = new ArrayList<String>();
		ArrayList encounterDtlList = new ArrayList();
		String result_header_icon ="";
		
		int page_tab_count = 4;
		String encounter_head_disp="";
		String queryString = "";
		int encounterIndex=0;
		int from_tab =0;
		int to_tab =0;
		int start = 0;
		int end = 0;
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String onLoadEncounterData = "";
		String onLoadPatientClassData = "";
		int onLoadEncounterIndex = 0;
		if (from == null) {
			start = 1;
		} else {
			start = Integer.parseInt(from);
		}
		if (to == null) {
			end = page_tab_count;
		} else {
			end = Integer.parseInt(to);
		}
				
		
		String encounterQuery = "select ca_encntr_header_disp(a.facility_id,a.encounteR_id,a.patient_class,a.patient_id,ATTEND_PRACTITIONER_ID) encounter_head_disp,TAB_FONT_COLOR, TAB_PREFER_IND, TAB_BG_COLOR, TAB_FONT_SIZE, TAB_FONT_BOLD_YN, IMAGE_FILE__YN, IMAGE_FILE_PATH, ALLOW_COMP_NO, a.facility_id,a.encounteR_id ,a.patient_id ,'*ALL' workflow_Comp_id,a.patient_class,a.ASSIGN_CARE_LOCN_CODE from pr_encounter_vw a, CA_ENCNTR_MR_PARAM b where a.patient_class = b.patient_class and b.PAT_CLASS_APPL_YN = 'Y' and patient_id = ? order by visit_adm_Date_time desc ";
		
		
		try{
			int encounter_spc_index = 1;
			if (disp_mode.equals("")) 
			{
				SubSecRecordSet.clearAll();
				con = ConnectionManager.getConnection(request);
				pstmtencounter = con.prepareStatement(encounterQuery);
				
				pstmtencounter.setString(1,patient_id);
				
				rsencounter = pstmtencounter.executeQuery();
				while(rsencounter.next())
				{
					/*encounterMap = new HashMap();
					encounterMap.put("ENCOUNTER_ID",rsencounter.getString("encounter_id"));
					encounterMap.put("encounter_head_disp",rsencounter.getString("encounter_head_disp"));
					encounterMap.put("tab_bg_color",rsencounter.getString("tab_bg_color"));
					encounterMap.put("tab_font_size",rsencounter.getString("tab_font_size"));
					encounterMap.put("tab_font_bold_yn",rsencounter.getString("tab_font_bold_yn"));
					encounterMap.put("image_file_path",rsencounter.getString("image_file_path"));
					encounterMap.put("TAB_FONT_COLOR",rsencounter.getString("TAB_FONT_COLOR")); */
					
					encounterList.add(rsencounter.getString("encounter_id"));
					encounterList.add(rsencounter.getString("encounter_head_disp"));
					encounterList.add(rsencounter.getString("tab_bg_color"));
					encounterList.add(rsencounter.getString("tab_font_size"));
					
					if("Y".equals(rsencounter.getString("tab_font_bold_yn"))) 
						encounterList.add("bold");
					else 
						encounterList.add("normal");
					
					encounterList.add(rsencounter.getString("image_file_path"));
					encounterList.add(rsencounter.getString("TAB_FONT_COLOR")); 
					encounterList.add(rsencounter.getString("patient_class"));
					encounterList.add(rsencounter.getString("ASSIGN_CARE_LOCN_CODE"));
					//SubSecRecordSet.putObject(encounterMap);
				}
				for (int i = 0; i < encounterList.size(); i += 9) 
				{
					System.out.println("125------------------->"+(String)encounterList.get(i));
					if(req_encounter_id.equals((String)encounterList.get(i)))
					{
						encounterMap = new HashMap(); 
						encounterMap.put("ENCOUNTER_ID",(String)encounterList.get(i));
						encounterMap.put("encounter_head_disp",(String)encounterList.get(i+1));
						encounterMap.put("tab_bg_color",(String)encounterList.get(i+2));
						encounterMap.put("tab_font_size",(String)encounterList.get(i+3));
						encounterMap.put("tab_font_bold_yn",(String)encounterList.get(i+4));
						encounterMap.put("image_file_path",(String)encounterList.get(i+5));
						encounterMap.put("TAB_FONT_COLOR",(String)encounterList.get(i+6));
						encounterMap.put("patient_class",(String)encounterList.get(i+7));
						encounterMap.put("ASSIGN_CARE_LOCN_CODE",(String)encounterList.get(i+8));
						SubSecRecordSet.putObject(encounterMap); 
					} 
				}
				for (int j = 0; j < encounterList.size(); j += 9) 
				{
					if(!req_encounter_id.equals((String)encounterList.get(j)))
					{
						encounterMap = new HashMap();
						System.out.println("145------------------->"+(String)encounterList.get(j));
						encounterMap.put("ENCOUNTER_ID",(String)encounterList.get(j));
						encounterMap.put("encounter_head_disp",(String)encounterList.get(j+1));
						encounterMap.put("tab_bg_color",(String)encounterList.get(j+2));
						encounterMap.put("tab_font_size",(String)encounterList.get(j+3));
						encounterMap.put("tab_font_bold_yn",(String)encounterList.get(j+4));
						encounterMap.put("image_file_path",(String)encounterList.get(j+5));
						encounterMap.put("TAB_FONT_COLOR",(String)encounterList.get(j+6)); 
						encounterMap.put("patient_class",(String)encounterList.get(j+7));
						encounterMap.put("ASSIGN_CARE_LOCN_CODE",(String)encounterList.get(j+8));
						SubSecRecordSet.putObject(encounterMap);
					}
				}
				
				total_tab_count = SubSecRecordSet.getSize();
				System.out.println("		total_tab_count------------------->"+total_tab_count);
				from_tab=0;
				to_tab=(page_tab_count-1);
				if (from_tab > (total_tab_count - 1))
					to_tab = (total_tab_count - 1);
	
				from = "" + (start - 1);
				to = "" + (end - 1);
			}
			else
			{
				int from_val = 0;
				int to_val = 0;

				from_val = Integer.parseInt(from);
				to_val = Integer.parseInt(to);
				if (disp_mode.equals("Next")) {
					disp_mode = "Next";
					from = "" + (start + page_tab_count);
					to = "" + (end + page_tab_count);

				} else if (disp_mode.equals("Previous")) {
					disp_mode = "Previous";
					from = "" + (start - page_tab_count);
					to = "" + (end - page_tab_count);
				}
				if (to_val > (total_tab_count - 1))
					to_val = (total_tab_count - 1);
				for (int j = from_val; j <= to_val; j++) 
				{
					encounterMapPage = (java.util.HashMap) SubSecRecordSet.getObject(j);
					SubSecRecordSet.setObject(j, encounterMapPage);
				}
				from_tab = Integer.parseInt(from);
				to_tab = Integer.parseInt(to);

				if (to_tab > (total_tab_count - 1))
					to_tab = (total_tab_count - 1);

				start = Integer.parseInt(from);
				end = Integer.parseInt(to);
			}
			
				
            _bw.write(_wl_block7Bytes, _wl_block7);
 
						for (int i = from_tab; i <= to_tab; i++) {
							encounterMap = (java.util.HashMap) SubSecRecordSet.getObject(i);
							if(null!=encounterMap && encounterMap.size() > 0)
							{
								encounterIndex++;
								encounter_id_spc = (String) encounterMap.get("ENCOUNTER_ID");
								patient_class_spc = (String) encounterMap.get("patient_class");
								location_code_spc = (String) encounterMap.get("ASSIGN_CARE_LOCN_CODE");
								if(i==from_tab){
									
									onLoadEncounterData = encounter_id_spc;
									onLoadPatientClassData = patient_class_spc;
									onLoadEncounterIndex = encounterIndex;
								}
								encounter_head_disp = (String) encounterMap.get("encounter_head_disp");
								
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(encounterIndex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(req_encounter_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id_spc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounterIndex));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_class_spc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String) encounterMap.get("tab_font_bold_yn")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((String) encounterMap.get("tab_font_size")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((String) encounterMap.get("tab_bg_color")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounterIndex));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((String) encounterMap.get("tab_bg_color")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String) encounterMap.get("image_file_path")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( encounter_head_disp));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(encounter_id_spc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(encounterIndex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(encounterIndex));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String) encounterMap.get("tab_bg_color")));
            _bw.write(_wl_block23Bytes, _wl_block23);

							}	
						}
						if ((!(start <= 1))){
						
            _bw.write(_wl_block24Bytes, _wl_block24);

						}
						if (!((start + page_tab_count) > total_tab_count)) {//IN049720 
						
            _bw.write(_wl_block25Bytes, _wl_block25);
}
						if(encounterIndex == 0){
								out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NOOPDAEENCOUNTER.label","ca_labels")+"</td></tr><table>");
						}

						
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(encounterIndex ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(onLoadEncounterIndex ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(req_encounter_id ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(total_tab_count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(from_tab));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(to_tab));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(from));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(to));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(disp_mode));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(location_code_spc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block38Bytes, _wl_block38);
		
		if(rsencounter!=null)rsencounter.close();		
		if(pstmtencounter!=null)pstmtencounter.close();
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}
		
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(onLoadEncounterData));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(onLoadEncounterIndex));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(onLoadPatientClassData));
            _bw.write(_wl_block42Bytes, _wl_block42);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
