package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __encountersdetailstree extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncountersDetailsTree.jsp", 1737366501338L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------\n?             100            ?           created\n20/10/2011\t  IN032130\t\t MenakaV\t Admission notes is not coming in clinical history.\n13/12/2012\t  IN035950\t\tNijitha\t\tCHL Hospital suggested that the presentation of the Clinician desktop be changed and \n\t\t\t\t\t\t\t\t\t\tmore appealing. Keeping the display of information more clear and visible.   \n15/07/2013\tIN034514\t\tKarthi L\tIn Clinical Event History, one could see information about patient\'s visit as a \n\t\t\t\t\t\t\t\t\t\tsummary which included Patient Admission date, date of discharge, attending practitioner, etc\t\n18/12/2013\tIN042552\t\tRamesh G\tBru-HIMS-CRF-391 --- Notes Confidentiality\t\t\t\t\t\t\t\t\t\t\n--------------------------------------------------------------------------------------------------------\nDate       \tEdit History    Name        \t\tRev.Date\t\tRev.Name \t\tDescription\n--------------------------------------------------------------------------------------------------------\n10/10/2016\tIN047572\t\tKarthi L\t\t\t\t\t\t\t\t\t\t\t[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the ?View Clinical Notes? and ?Clinical Event History?\n03/11/2016\tIN054151\t\tRamya Maddena\t22/11/2016\t\tKarthi L\t\t12.X-Alpha-CA- Clinical Event History - Event Grouping\t\n22/09/2017  IN065313\t\tVijayakumar K\t\t22/09/2017\t\tGoli Ramesh\t\tICN- CEH - Tree view issue [IN:065313] \n23/10/2018\tIN068011\t\tRaja S\t\t\t\t23/10/2018\t\tRamesh G\t\tML-MMOH-CRF-1204\n18/12/2018   IN067236      \t Sivabagyam M\t18/12/2018\tRamesh G\t   ML-MMOH-CRF-1148\n03/02/2020\t\t\tIN071561\tSIVABAGYAM M\t\t03/02/2020\t\tRAMESH G\t\tGHL-CRF-0558.1\n05/01/2021\t6030\t\tSivabagyam M\t\t05/01/2021\t\tRamesh G\tML-MMOH-CRF-1491\n03/02/2020\t39052\t\t\tRamesh\t\t\t\t\t\t\t\t\t\t\tML-BRU-CRF-0634\n--------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n \t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCA/html/CAMainMenu.css\"></link> -->\n<!-- \t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t<script src=\'../../eCA/js/Encounters.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCA/js/dTree.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n</head>\n<body class=\'CA_COMMON\'  OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n\t\n\tvar obj;\n\tobj = new dTree(\'obj\');\n\tobj.add(0,-1,\'<font size=1 style=font-weight:bold style=color:#333>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</font>\');\n\tobj.config.useStatusText=true;\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<SCRIPT>\n\tdocument.write(obj);\n\tobj.openAll();\n</SCRIPT>\n<!-- ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" -->\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<script>\n\t\t\tif(top.content != null && !top.document.getElementById(\'dialog-body\'))\n\t\t\t{\n\t\t\t\ttop.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\');\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(parent.parent.parent.messageFrame != null)\n\t\t\t\t{\n\t\t\t\t\tparent.parent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\');\n\t\t\t\t}\n\t\t\t\telse if(parent.parent.messageFrame != null)\n\t\t\t\t{\t\n\t\t\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\');\n\t\t\t\t}\n\t\t\t}\n\t\t\tparent.details_f2.location.href = \'../../eCommon/html/blank.html\';\n\t\t</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<script>\n\t\t\tif(top.content != null){\n\t\t\t\ttop.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t}else{\n\t\t\t\tif(parent.parent.parent.messageFrame != null){\t\t\t\t\t\t\t\t\t\t\t\tparent.parent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\t\n\t\t\t\t}else if(parent.parent.messageFrame != null){\t\n\t\t\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\t\n\t\t\t\t}\n\t\t\t}\n\t\t\tparent.details_f2.location.href = \'../../eCA/jsp/EncountersDetailsFrame.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'\n\t\t</script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Properties p	= (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
	
	Connection con	= null;
	PreparedStatement stmt	= null;
	ResultSet rs			= null;
	
	String abnormal = request.getParameter("abnormal")==null?"N":request.getParameter("abnormal");
	String normalcy = request.getParameter("normalcy")==null?"N":request.getParameter("normalcy");
	String episodetype		= request.getParameter("episode_type")==null?"B":request.getParameter("episode_type");
	String selectedhisttype		= request.getParameter("hist_type")==null?"":request.getParameter("hist_type");
	String selectedeventclass	= request.getParameter("event_class")==null?"": request.getParameter("event_class");
	String selectedeventgroup	= request.getParameter("event_group")==null?"": request.getParameter("event_group");
	String selectedeventitem	= request.getParameter("event_item")==null?"":request.getParameter("event_item");
	String patientid		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String fromdate			= request.getParameter("from_date")==null?"": request.getParameter("from_date");
	String todate			= request.getParameter("to_date")==null?"": request.getParameter("to_date");
	
	String fromdate1		=	com.ehis.util.DateUtils.convertDate(fromdate,"DMYHM",locale,"en");
	String todate1			=	com.ehis.util.DateUtils.convertDate(todate,"DMYHM",locale,"en");

	String viewby			= request.getParameter("view_by")==null?"E":request.getParameter("view_by");
	String episodewise		= request.getParameter("episode_wise")==null?"N":request.getParameter("episode_wise");
	String facility_id		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String errorEvent = request.getParameter("errorEvent")==null?"N":request.getParameter("errorEvent");
	String encounter_id		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String enc_id		= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");
	String show_mode			= request.getParameter("show_mode")==null?"": request.getParameter("show_mode");//IN032130
	String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");//IN042552
	if(enc_id.equals("")) enc_id = "0";
	String calling_from_2T = request.getParameter("calling_from_2T")==null?"":request.getParameter("calling_from_2T");//IN068011

	String performed_by		= request.getParameter("performed_by")==null?"":request.getParameter("performed_by");
	String sortOrder		= request.getParameter("sortOrder")==null?"desc":request.getParameter("sortOrder");
	
	String resp_id = (String)session.getValue("responsibility_id");
	String login_user = (String)session.getValue("login_user");//IN071561
	String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String p_called_from		=	request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//IN035950
	String p_event_class		=	request.getParameter("p_event_class_widget")==null?"":request.getParameter("p_event_class_widget");//IN035950
	String patient_class 	=	request.getParameter("patient_class")==null?"":request.getParameter("patient_class");//IN034514
	String p_enc_details_tree		=	"tree_builder";//IN034514
	String encntr_yn 	=	request.getParameter("encntr_yn")==null?"":request.getParameter("encntr_yn");//IN034514
	String header_view 	=	request.getParameter("header_view")==null?"":request.getParameter("header_view");//IN034514
	String speciality_code		=	request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");  // MMS-QH-CRF-0177 [IN047572]	
	String attend_pract_code	= 	request.getParameter("attend_pract_code")==null?"":request.getParameter("attend_pract_code"); // MMS-QH-CRF-0177 [IN047572]	 
	String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
	boolean isClinician=false;//IN067236
	if(resp_id == null) resp_id ="";
	boolean restrict_rd	=false;	//IN071561
	
	String order_type_3T	= request.getParameter("order_type_3T")==null?"": request.getParameter("order_type_3T"); //39052
	String archivalYN= request.getParameter("archivalYN")==null?"N": request.getParameter("archivalYN");//52176
	session.removeAttribute("arrayToSort"+patientid+encounter_id);	
	ArrayList sortList = new ArrayList();
	
	StringBuffer sql=new StringBuffer();
	int nodeCounter =1;

            _bw.write(_wl_block1Bytes, _wl_block1);

	try{
	con	= ConnectionManager.getConnection(request);
	out.println("<script>");	
	boolean isViewLabRes=false;//6030
	isViewLabRes=eCommon.Common.CommonBean.isSiteSpecific(con, "CA","ORDERBY_BASEDON_LAB_SEQ");//6030
	isClinician = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","CLINICIAN_TO_THERAPIST");//IN067236
	restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");
		if(sql.length() > 0) sql.delete(0,sql.length());
		 
		sql.append("  Select ");
		
		if(episodewise.equals("Y"))
		{
			sql.append("NVL(f.EPISODE_ID,9999999999) GROUP1,F.EPISODE_DESC,");
		}

		sql.append("NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, ");

		 sql.append("b.short_desc hist_rec_type_desc, a.hist_rec_type HIST_REC_TYPE, c.long_desc event_class_desc,a.event_class EVENT_CLASS, nvl(a.event_group,'*ALL') EVENT_GROUP, nvl(e.long_desc,d.long_desc) event_group_desc, d.long_desc  event_code_desc, rtrim(a.event_code) event_code,");
		
		if(viewby.equals("D"))
		{
			sql.append("TO_CHAR(a.EVENT_DATE,'YYYYMMDD') GROUP3,");
		}

		 sql.append(" count(*) rec_count /*,hist_data_type,a.patient_id patient_id*/,a.facility_id facility_id,F.patient_class patient_class,a.encounter_id encounter_id/*,CA_GET_VISIT_DTL(a.facility_id,a.patient_class,a.encounter_id,a.patient_id) encline*/");

		if(viewby.equals("D"))
		{
			sql.append(",to_char(a.event_date,'dd/mm/yyyy') e_date ");
		}
		//39052 Start.
		/*
		if(!isViewLabRes)
			sql.append(",CA_GET_VISIT_DTL_NEW(F.FACILITY_ID,F.patient_class,F.ENCOUNTER_ID,A.PATIENT_ID,'"+locale+"') ENCLINE From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e, (SELECT FACILITY_ID,patient_class,ENCOUNTER_ID,VISIT_ADM_DATE_TIME, EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT TO_CHAR(START_DATE_TIME,'DD/MM/YYYY HH24:MI') ||'-'|| TO_CHAR(END_DATE_TIME,'DD/MM/YYYY HH24:MI') ||','||AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'2')||','||decode(EPISODE_STATUS,'01','Open','08','Close') status from  OP_EPISODE_FOR_SERVICE A,AM_SERVICE B WHERE B.SERVICE_CODE=A.SERVICE_CODE AND A.OPERATING_FACILITY_ID=PR_ENCOUNTER.FACILITY_ID AND EPISODE_ID=PR_ENCOUNTER.EPISODE_ID and rownum=1 ) EPISODE_DESC, SPECIALTY_CODE, ATTEND_PRACTITIONER_ID FROM PR_ENCOUNTER WHERE PATIENT_ID=? ) F  where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code)  and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N')='Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'"+resp_id+"','"+reln_id+"')='A')) ");// ,SPECIALTY_CODE, ATTEND_PRACTITIONER_ID added for // MMS-QH-CRF-0177 [IN047572]//6030
			else
				sql.append(",CA_GET_VISIT_DTL_NEW(F.FACILITY_ID,F.patient_class,F.ENCOUNTER_ID,A.PATIENT_ID,'"+locale+"') ENCLINE,RL_NEW_REQUEST_NUM_SEQ(a.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no  From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e, (SELECT FACILITY_ID,patient_class,ENCOUNTER_ID,VISIT_ADM_DATE_TIME, EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT TO_CHAR(START_DATE_TIME,'DD/MM/YYYY HH24:MI') ||'-'|| TO_CHAR(END_DATE_TIME,'DD/MM/YYYY HH24:MI') ||','||AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'2')||','||decode(EPISODE_STATUS,'01','Open','08','Close') status from  OP_EPISODE_FOR_SERVICE A,AM_SERVICE B WHERE B.SERVICE_CODE=A.SERVICE_CODE AND A.OPERATING_FACILITY_ID=PR_ENCOUNTER.FACILITY_ID AND EPISODE_ID=PR_ENCOUNTER.EPISODE_ID and rownum=1 ) EPISODE_DESC, SPECIALTY_CODE, ATTEND_PRACTITIONER_ID FROM PR_ENCOUNTER WHERE PATIENT_ID=? ) F  where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code)  and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N')='Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'"+resp_id+"','"+reln_id+"')='A')) ");// ,SPECIALTY_CODE, ATTEND_PRACTITIONER_ID added for // MMS-QH-CRF-0177 [IN047572]//6030
		*/
		if(!isViewLabRes)
			sql.append(",CA_GET_VISIT_DTL_NEW(F.FACILITY_ID,F.patient_class,F.ENCOUNTER_ID,A.PATIENT_ID,'"+locale+"') ENCLINE From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e, (SELECT FACILITY_ID,patient_class,ENCOUNTER_ID,VISIT_ADM_DATE_TIME, EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT TO_CHAR(START_DATE_TIME,'DD/MM/YYYY HH24:MI') ||'-'|| TO_CHAR(END_DATE_TIME,'DD/MM/YYYY HH24:MI') ||','||AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'2')||','||decode(EPISODE_STATUS,'01','Open','08','Close') status from  OP_EPISODE_FOR_SERVICE A,AM_SERVICE B WHERE B.SERVICE_CODE=A.SERVICE_CODE AND A.OPERATING_FACILITY_ID=PR_ENCOUNTER.FACILITY_ID AND EPISODE_ID=PR_ENCOUNTER.EPISODE_ID and rownum=1 ) EPISODE_DESC, SPECIALTY_CODE, ATTEND_PRACTITIONER_ID FROM PR_ENCOUNTER WHERE PATIENT_ID=? ) F ");
		else
			sql.append(",CA_GET_VISIT_DTL_NEW(F.FACILITY_ID,F.patient_class,F.ENCOUNTER_ID,A.PATIENT_ID,'"+locale+"') ENCLINE,RL_NEW_REQUEST_NUM_SEQ(a.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no  From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e, (SELECT FACILITY_ID,patient_class,ENCOUNTER_ID,VISIT_ADM_DATE_TIME, EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT TO_CHAR(START_DATE_TIME,'DD/MM/YYYY HH24:MI') ||'-'|| TO_CHAR(END_DATE_TIME,'DD/MM/YYYY HH24:MI') ||','||AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'2')||','||decode(EPISODE_STATUS,'01','Open','08','Close') status from  OP_EPISODE_FOR_SERVICE A,AM_SERVICE B WHERE B.SERVICE_CODE=A.SERVICE_CODE AND A.OPERATING_FACILITY_ID=PR_ENCOUNTER.FACILITY_ID AND EPISODE_ID=PR_ENCOUNTER.EPISODE_ID and rownum=1 ) EPISODE_DESC, SPECIALTY_CODE, ATTEND_PRACTITIONER_ID FROM PR_ENCOUNTER WHERE PATIENT_ID=? ) F ");
		if("CA01".equals(order_type_3T)){	
			sql.append(" where 'CA01'=SUBSTR(a.ACCESSION_NUM,0,4)  and b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code)  and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N')='Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'"+resp_id+"','"+reln_id+"')='A'))  ");
		}else{
			sql.append(" where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code)  and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N')='Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'"+resp_id+"','"+reln_id+"')='A'))  ");
		}
		//39052 End.
		sql.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' ");  //IN042552
		if(errorEvent.equals("N")){//dont'include error events
			sql.append(" and nvl(a.STATUS,'`') not in('S','E')");  
		}else if(errorEvent.equals("Y")){
			sql.append(" and nvl(a.STATUS,'`')!= 'S'  ");			
		}
		//If patient class is 'EM,'DC' and 'EX' then this below query is append accordingly related to IN18063. 
		if(!episodetype.equals("B")){
			if(episodetype.equals("I")){
				//sql.append(" and a.PATIENT_CLASS not in ('OP','EM')");
				sql.append(" and a.PATIENT_CLASS = 'IP' ");
			}else if(episodetype.equals("O")){
				//sql.append(" and a.PATIENT_CLASS in ('OP','EM')");
				sql.append(" and a.PATIENT_CLASS = 'OP' ");
			}else if(episodetype.equals("E")){
				sql.append(" and a.PATIENT_CLASS = 'EM' ");
			}else if(episodetype.equals("D")){
				sql.append(" and a.PATIENT_CLASS = 'DC' ");
			}else{
				sql.append(" and a.PATIENT_CLASS = 'XT' ");
			}
		}
		if(!selectedhisttype.equals("")){
			sql.append(" and a.hist_rec_type = ? ");
		}
		if(!selectedeventclass.equals("")){
			sql.append(" and a.EVENT_CLASS = ? ");
		}
		if(!selectedeventgroup.equals("")){
			sql.append(" and a.EVENT_GROUP = ? ");
		}
		if(!selectedeventitem.equals("")){
			sql.append(" and rtrim(a.EVENT_CODE) = ? ");
		}
		if(!encounter_id.equals("")){
				sql.append(" and a.ENCOUNTER_ID = ? ");
		}
		if(!performed_by.equals("")){
			sql.append(" and a.PERFORMED_BY_ID = ? ");
		}
		if(abnormal.equals("Y")){
			//Modified the following condition by Archana on 9/16/2010 related to the incident IN023804.
			 sql.append(" and nvl(a.normalcy_ind,'.')!='.' ");
		}
		if(!fromdate1.equals("")){
			sql.append(" and A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi') ");
		}

		if(!todate1.equals("")){
			sql.append(" and A.EVENT_DATE <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+0.00068287 ");//adding 59 seconds more to the todate
		}

		if(!facility_id.equals("")){
				sql.append(" and a.facility_id = ? ");
		}
		//IN071561 starts	
		if(restrict_rd)
			   sql.append( " AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,'"+login_user+"')='N' ");
			   //IN071561ends
		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(p_called_from) && "".equals(p_event_class))
		{
			System.out.println("EncounterDetailsTree.jsp:Line:167:");
			sql.append(" AND a.event_class IN ('PHY$','CLI$','NUR$') ");
		}
		else if("CA_CLINICIAN_WIDGET".equals(p_called_from) && !"".equals(p_event_class))
		{
			System.out.println("EncounterDetailsTree.jsp:Line:172:");
			sql.append(" AND a.event_class=? ");
		}
		//IN035950 End
		if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
			if(!speciality_code.equals("")){
				sql.append(" and F.SPECIALTY_CODE = ? ");
			}
		} else {
			sql.append(" and F.ATTEND_PRACTITIONER_ID = ? ");
		} // MMS-QH-CRF-0177 [IN047572] - End 
		//IN068011 starts
		if("Y".equals(calling_from_2T))
			sql.append(" and a.Added_BY_ID ='DM'");
		//IN068011 Ends
		 sql.append(" group by ");
		
		 if(episodewise.equals("Y")){
			 sql.append(" NVL(f.EPISODE_ID,9999999999),F.EPISODE_DESC, ");
		 }

		 sql.append(" NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') , ");
		
		if(viewby.equals("D")){
			sql.append(" TO_CHAR(a.EVENT_DATE,'YYYYMMDD'),to_char(a.event_date,'dd/mm/yyyy'),");
		}
		 
		if(!isViewLabRes)
			sql.append("TO_CHAR(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI'),b.short_desc ,a.hist_rec_type ,c.long_desc  ,CA_GET_VISIT_DTL_NEW(F.FACILITY_ID,F.patient_class,F.ENCOUNTER_ID,A.PATIENT_ID,'"+locale+"'),a.event_class ,nvl(a.REQUEST_NUM_SEQ,'0'),nvl(a.event_group,'*ALL') ,a.facility_id ,F.patient_class ,a.encounter_id,nvl(e.long_desc,d.long_desc) ,d.long_desc  ,rtrim(a.event_code) order by 1 ");
		else
			sql.append("TO_CHAR(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI'),b.short_desc ,a.hist_rec_type ,c.long_desc  ,CA_GET_VISIT_DTL_NEW(F.FACILITY_ID,F.patient_class,F.ENCOUNTER_ID,A.PATIENT_ID,'"+locale+"'),a.event_class ,nvl(a.REQUEST_NUM_SEQ,'0'),nvl(a.event_group,'*ALL') ,a.facility_id ,F.patient_class ,a.encounter_id,nvl(e.long_desc,d.long_desc) ,d.long_desc  ,rtrim(a.event_code),RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) order by 1 ");
		  sql.append(sortOrder);
		  //sql.append(" ,2,3,4,DECODE(A.HIST_REC_TYPE,'LBIN',nvl(a.request_num_seq,'0'),'0'),5,6,7,8 ");
		if(viewby.equals("D"))
		{	
			sql.append(" ,10 ");
			sql.append(sortOrder);
		}
		//IN054151 Start
	
		 //sql.append(" ,2,3,4,5,nvl(a.REQUEST_NUM_SEQ,'0'),7,6,8,9");
			  if(!isViewLabRes)
				  sql.append(" ,2,3,4,5,6,nvl(a.REQUEST_NUM_SEQ,'0'),7,8,9");//6030
				  else
					  sql.append(" ,2,3,4,5,6,NVL (sequence_no,0),7,8,9");//6030
		//IN054151 End
		stmt=con.prepareStatement(sql.toString());

		int count1=0;
		
			stmt.setString(++count1,locale);
			stmt.setString(++count1,patientid);
			stmt.setString(++count1,locale);
			stmt.setString(++count1,locale);
			stmt.setString(++count1,locale);
			stmt.setString(++count1,locale);
			stmt.setString(++count1,patientid);
		if(!selectedhisttype.equals("")){
			stmt.setString(++count1,selectedhisttype);
		}
		if(!selectedeventclass.equals("")){
			stmt.setString(++count1,selectedeventclass);
		}
		if(!selectedeventgroup.equals("")){
			stmt.setString(++count1,selectedeventgroup);
		}
		if(!selectedeventitem.equals("")){
			stmt.setString(++count1,selectedeventitem);
		}

		if(!encounter_id.equals("")){
			stmt.setString(++count1,encounter_id);
		}
		if(!performed_by.equals("")){
			stmt.setString(++count1,performed_by);
		}

		if(!fromdate1.equals("")){
			stmt.setString(++count1,fromdate1);			
		}
		if(!todate1.equals("")){
			stmt.setString(++count1,todate1);
		}
		if(!facility_id.equals("")){
			stmt.setString(++count1,facility_id);
		}

		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(p_called_from) && !"".equals(p_event_class))
		{
			stmt.setString(++count1,p_event_class);
		}
		//IN035950 Ends
		if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
			if(!speciality_code.equals("")){
				stmt.setString(++count1, speciality_code);
			}
		} else {
			stmt.setString(++count1, attend_pract_code);
		} // MMS-QH-CRF-0177 [IN047572] - End 
		rs = stmt.executeQuery();
		count1 = 0;
		String group1="",group2="",group3="",hist_rec_type="",event_group="";
		String event_class="",event_code="",event_date = "", event_date_th = "";
		
		String prevGroup1="*",prevGroup2="**",prevGroup3="***",prev_hist_rec_type="****",prev_event_group="*****";
		String prev_event_class="*****",prev_event_code="******";
		String query_facility_id="",query_encounter_id="";
		String hist_rec_type_desc="",event_class_desc="",event_group_desc="",event_desc="";
		String query_patient_class="",encline="";
		StringBuffer strBuffParams = null;
		strBuffParams = new StringBuffer();
		
		int group_node_id=0,group1_node_id = 0,group2_node_id = 0,group3_node_id = 0,group4_node_id = 0;
		int group5_node_id = 0,group6_node_id = 0;
		while(rs.next()){
			strBuffParams.delete(0,strBuffParams.length());
			//strBuffParams = new StringBuffer();
			strBuffParams.append("archivalYN="); //52176
			strBuffParams.append(archivalYN);  //52176
			strBuffParams.append("&patient_id=");
			strBuffParams.append(patientid);
			
			strBuffParams.append("&from_date=");
			strBuffParams.append(fromdate);
			
			strBuffParams.append("&to_date=");
			strBuffParams.append(todate);
			
			strBuffParams.append("&patient_class=");//IN034514
			strBuffParams.append(patient_class);//IN034514

			strBuffParams.append("&p_enc_details_tree=");//IN034514
			strBuffParams.append(p_enc_details_tree);//IN034514
			
			strBuffParams.append("&encntr_yn=");//IN034514
			strBuffParams.append(encntr_yn);//IN034514

			strBuffParams.append("&abnormal=");
			strBuffParams.append(abnormal);
			strBuffParams.append("&normalcy=");
			strBuffParams.append(normalcy);
			//strBuffParams.append("&viewby=");
			strBuffParams.append("&view_by=");
			strBuffParams.append(viewby);  
			
			/*strBuffParams.append("&EHR_YN=");
			strBuffParams.append(EHR_YN); */
			strBuffParams.append("&p_event_class_widget=");//IN035950
			strBuffParams.append(p_event_class);//IN035950
			strBuffParams.append("&p_called_from_widget=");//IN035950
			strBuffParams.append(p_called_from);//IN035950
			
			strBuffParams.append("&hist_type=");//IN035950
			strBuffParams.append(selectedhisttype);//IN035950
			strBuffParams.append("&p_review_rad_yn=");//IN071561
			strBuffParams.append(p_review_rad_yn);//IN071561
			
			if(!selectedeventclass.equals("")){
				strBuffParams.append("&event_class=");
				strBuffParams.append(selectedeventclass);	
			}
			if(episodewise.equals("Y")){
				group1 = rs.getString("GROUP1")==null?"":rs.getString("GROUP1");
			}
			group2 = rs.getString("GROUP2")==null?"":rs.getString("GROUP2");
			if(viewby.equals("D")){
				group3 = rs.getString("GROUP3")==null?"":rs.getString("GROUP3");
				event_date = rs.getString("e_date")==null?"":rs.getString("e_date");	
				event_date_th = com.ehis.util.DateUtils.convertDate(event_date,"DMY","en",locale);
			}
			query_facility_id = rs.getString("facility_id")==null?"":rs.getString("facility_id");
			query_encounter_id = rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
			query_patient_class = rs.getString("patient_class")==null?"":rs.getString("patient_class");
			hist_rec_type = rs.getString("HIST_REC_TYPE")==null?"":rs.getString("HIST_REC_TYPE");
			hist_rec_type_desc=rs.getString("hist_rec_type_desc")==null?"":rs.getString("hist_rec_type_desc");
			hist_rec_type_desc = hist_rec_type_desc.replace('\'',' ');
			event_class = rs.getString("EVENT_CLASS")==null?"":rs.getString("EVENT_CLASS");			
			event_class_desc = rs.getString("event_class_desc")==null?"":rs.getString("event_class_desc");
			event_class_desc = event_class_desc.replace('\'',' ');
			event_group = rs.getString("EVENT_GROUP")==null?"":rs.getString("EVENT_GROUP");
			event_group_desc=rs.getString("event_group_desc")==null?"":rs.getString("event_group_desc");

			event_group_desc = event_group_desc.replace('\'',' ');
			event_code = rs.getString("EVENT_CODE")==null?"":rs.getString("EVENT_CODE");	
			event_desc = rs.getString("event_code_desc")==null?"":rs.getString("event_code_desc");	
			event_desc = event_desc.replace('\'',' ');
			event_desc = event_desc.replace(System.getProperty("line.separator"), "");//[IN065313]

			if(isClinician&&event_class.equals("CLI$"))//IN067236
				event_class_desc="Therapist Notes";//IN067236
			if(!sortList.contains(hist_rec_type)) sortList.add(hist_rec_type);
			
			encline = rs.getString("ENCLINE")==null?"":rs.getString("ENCLINE");	
			encline = encline.replace('\'',' ');
			strBuffParams.append("&facility_id=");
			strBuffParams.append(query_facility_id);
			strBuffParams.append("&episode_type=");
			strBuffParams.append(query_patient_class);
			strBuffParams.append("&encounter_id=");
			strBuffParams.append(query_encounter_id);
			strBuffParams.append("&enc_id=");
			strBuffParams.append(enc_id);
			strBuffParams.append("&show_mode=");//IN032130
			strBuffParams.append(show_mode);//IN032130

			if(!prevGroup1.equals(group1)){	
				if(episodewise.equals("Y")){
					if(group1.equals("9999999999")){ //episode id is null
						group1_node_id = nodeCounter++;
						if(group2.equals("EXTERNAL")){
							
							out.println("obj.add('"+group1_node_id+"',0,'External','','External','details_f2')");

						}else{ 
							out.println("obj.add('"+group1_node_id+"',0,'"+encline+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+encline+"','details_f2')"); 

						}
						
						strBuffParams.append("&event_date=");
						strBuffParams.append(event_date);	
						strBuffParams.append("&hist_type=");
						strBuffParams.append(hist_rec_type);							

						if(viewby.equals("D")){
							group2_node_id =  nodeCounter++;
						out.println("obj.add('"+group2_node_id+"','"+group1_node_id+"','"+event_date_th+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_date_th+"','details_f2')");	

							group3_node_id =  nodeCounter++;					
						out.println("obj.add('"+group3_node_id+"','"+group2_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");
							
										
							
						}else{
							group3_node_id =  nodeCounter++;
						out.println("obj.add('"+group3_node_id+"','"+group1_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
						}

						strBuffParams.append("&event_class=");
						strBuffParams.append(event_class);					
						group4_node_id =  nodeCounter++;
						out.println("obj.add('"+group4_node_id+"','"+group3_node_id+"','"+event_class_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_class_desc+"','details_f2')");	
						
						strBuffParams.append("&event_group=");
						if(event_group.equals("*ALL")){
							strBuffParams.append("");		
						}else{
							strBuffParams.append(event_group);		
						}
						group5_node_id =  nodeCounter++;		
						if(!event_group.equals("*ALL")){		
						out.println("obj.add('"+group5_node_id+"','"+group4_node_id+"','"+event_group_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_group_desc+"','details_f2')");	
						}

						strBuffParams.append("&event_item=");
						strBuffParams.append(event_code);			
						group6_node_id =  nodeCounter++;			
						if(!event_group.equals("*ALL")){					
							out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
						}else{
							out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
						}				
					}else{//valid episode id 
						group_node_id = nodeCounter++;
					out.println("obj.add('"+group_node_id+"',0,'"+group1+"','','"+group1+"','details_f2')");

						group1_node_id = nodeCounter++;

						if(group2.equals("EXTERNAL")){
						out.println("obj.add('"+group1_node_id+"','"+group_node_id+"','External','','External','details_f2')");

						}else{
							
							
							
							
							
							
							out.println("obj.add('"+group1_node_id+"','"+group_node_id+"','"+encline+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"&p_menu_type=H"+"','"+encline+"','details_f2')"); // IN034514
							
							
						}
						
						strBuffParams.append("&event_date=");
						strBuffParams.append(event_date);	
						strBuffParams.append("&hist_type=");
						strBuffParams.append(hist_rec_type);						

						if(viewby.equals("D")){
							
							group2_node_id =  nodeCounter++;	out.println("obj.add('"+group2_node_id+"','"+group1_node_id+"','"+event_date_th+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_date_th+"','details_f2')");	

							group3_node_id =  nodeCounter++;					
						out.println("obj.add('"+group3_node_id+"','"+group2_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
						}else{
							group3_node_id =  nodeCounter++;
						out.println("obj.add('"+group2_node_id+"','"+group1_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
						}

						strBuffParams.append("&event_class=");
						strBuffParams.append(event_class);					
						group4_node_id =  nodeCounter++;	
					out.println("obj.add('"+group4_node_id+"','"+group3_node_id+"','"+event_class_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_class_desc+"','details_f2')");	
						
						strBuffParams.append("&event_group=");
						if(event_group.equals("*ALL")){
							strBuffParams.append("");		
						}else{
							strBuffParams.append(event_group);		
						}
						group5_node_id =  nodeCounter++;		
						if(!event_group.equals("*ALL")){		
						
						out.println("obj.add('"+group5_node_id+"','"+group4_node_id+"','"+event_group_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_group_desc+"','details_f2')");	
						}

						strBuffParams.append("&event_item=");
						strBuffParams.append(event_code);			
						group6_node_id =  nodeCounter++;			
						if(!event_group.equals("*ALL")){					
							out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
						}else{
							out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
						}				
					}//end of else block of valid episode id
				}else{//start of else block of episodewise.equals("Y")
					group1_node_id = nodeCounter++;
					if(group2.equals("EXTERNAL")){
					out.println("obj.add('"+group1_node_id+"',0,'External','','External','details_f2')");

					}else{
						
						
						
						out.println("obj.add('"+group1_node_id+"',0,'"+encline+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"&p_menu_type=H"+"','"+encline+"','details_f2')"); // IN034514
					}
					
					strBuffParams.append("&event_date=");
					strBuffParams.append(event_date);	
					strBuffParams.append("&hist_type=");
					strBuffParams.append(hist_rec_type);

					if(viewby.equals("D")){
						group2_node_id =  nodeCounter++;	
					out.println("obj.add('"+group2_node_id+"','"+group1_node_id+"','"+event_date_th+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_date_th+"','details_f2')");	

						group3_node_id =  nodeCounter++;					
					out.println("obj.add('"+group3_node_id+"','"+group2_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
					}else{
						group3_node_id =  nodeCounter++;
					out.println("obj.add('"+group3_node_id+"','"+group1_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
					}

					strBuffParams.append("&event_class=");
					strBuffParams.append(event_class);					
					group4_node_id =  nodeCounter++;	
					out.println("obj.add('"+group4_node_id+"','"+group3_node_id+"','"+event_class_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_class_desc+"','details_f2')");	
					
					strBuffParams.append("&event_group=");
					if(event_group.equals("*ALL")){
						strBuffParams.append("");		
					}else{
						strBuffParams.append(event_group);		
					}
					group5_node_id =  nodeCounter++;		
					if(!event_group.equals("*ALL")){		
						
					out.println("obj.add('"+group5_node_id+"','"+group4_node_id+"','"+event_group_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_group_desc+"','details_f2')");	
					}

					strBuffParams.append("&event_item=");
					strBuffParams.append(event_code);			
					group6_node_id =  nodeCounter++;			
					if(!event_group.equals("*ALL")){					
						
						out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
					}else{
						out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
					}					
				}//end of else block of episodewise.equals("Y")
				prevGroup1 = group1;
				prevGroup2 = group2;
				prevGroup3 = group3;
				prev_hist_rec_type=hist_rec_type;
				prev_event_class=event_class;
				prev_event_group=event_group;
				prev_event_code = event_code;
			}else if(!prevGroup2.equals(group2)){

				strBuffParams.append("&facility_id=");
				strBuffParams.append(query_facility_id);
				strBuffParams.append("&episode_type=");
				strBuffParams.append(query_patient_class);
				strBuffParams.append("&encounter_id=");
				strBuffParams.append(query_encounter_id);
				group1_node_id = nodeCounter++;
				if(episodewise.equals("Y")){
					if(group1.equals("9999999999")){
						if(group2.equals("EXTERNAL")){
						out.println("obj.add('"+group1_node_id+"','"+group_node_id+"','External','','External','details_f2')");

						}else{
					
							
					
							
							out.println("obj.add('"+group1_node_id+"','"+group_node_id+"','"+encline+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"&p_menu_type=H"+"','"+encline+"','details_f2')");// IN034514
							
						}					
					}else{
						if(group2.equals("EXTERNAL")){
							
						out.println("obj.add('"+group1_node_id+"',0,'External','','External','details_f2')");

						}else{
							
							
							
							out.println("obj.add('"+group1_node_id+"',0,'"+encline+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"&p_menu_type=H"+"','"+encline+"','details_f2')");// IN034514
							
						}					
					}
				}else{
					if(group2.equals("EXTERNAL")){
						
					out.println("obj.add('"+group1_node_id+"',0,'External','','External','details_f2')");

					}else{
					
						
						
						out.println("obj.add('"+group1_node_id+"',0,'"+encline+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"&p_menu_type=H"+"','"+encline+"','details_f2')");// IN034514
					
					}				
				}
				
				strBuffParams.append("&event_date=");
				strBuffParams.append(event_date);	
				strBuffParams.append("&hist_type=");
				strBuffParams.append(hist_rec_type);	
				

				if(viewby.equals("D")){
					group2_node_id =  nodeCounter++;	
				out.println("obj.add('"+group2_node_id+"','"+group1_node_id+"','"+event_date_th+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_date_th+"','details_f2')");	

					group3_node_id =  nodeCounter++;					
					
				out.println("obj.add('"+group3_node_id+"','"+group2_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
				}else{
					group3_node_id =  nodeCounter++;
					
				out.println("obj.add('"+group3_node_id+"','"+group1_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
				}

				strBuffParams.append("&event_class=");
				strBuffParams.append(event_class);					
				group4_node_id =  nodeCounter++;	
			out.println("obj.add('"+group4_node_id+"','"+group3_node_id+"','"+event_class_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_class_desc+"','details_f2')");	
				
				strBuffParams.append("&event_group=");
				if(event_group.equals("*ALL")){
					strBuffParams.append("");		
				}else{
					strBuffParams.append(event_group);		
				}
				group5_node_id =  nodeCounter++;		
				if(!event_group.equals("*ALL")){		
				out.println("obj.add('"+group5_node_id+"','"+group4_node_id+"','"+event_group_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_group_desc+"','details_f2')");	
				}

				strBuffParams.append("&event_item=");
				strBuffParams.append(event_code);			
				group6_node_id =  nodeCounter++;			
				if(!event_group.equals("*ALL")){					
				out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}else{
					out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}
				prevGroup2 = group2;
				prevGroup3 = group3;
				prev_hist_rec_type=hist_rec_type;
				prev_event_class=event_class;
				prev_event_group=event_group;
				prev_event_code = event_code;
			}else if(!prevGroup3.equals(group3) && viewby.equals("D")){
				strBuffParams.append("&event_date=");
				strBuffParams.append(event_date);	
				
				group2_node_id =  nodeCounter++;			

				out.println("obj.add('"+group2_node_id+"','"+group1_node_id+"','"+event_date_th+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_date_th+"','details_f2')");	

				strBuffParams.append("&hist_type=");
				strBuffParams.append(hist_rec_type);			
				group3_node_id =  nodeCounter++;			
			out.println("obj.add('"+group3_node_id+"','"+group2_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");		
				
				strBuffParams.append("&event_class=");
				strBuffParams.append(event_class);		
				group4_node_id =  nodeCounter++;		

			out.println("obj.add('"+group4_node_id+"','"+group3_node_id+"','"+event_class_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_class_desc+"','details_f2')");	
				
				strBuffParams.append("&event_group=");
				if(event_group.equals("*ALL")){
					strBuffParams.append("");		
				}else{
					strBuffParams.append(event_group);		
				}

				group5_node_id =  nodeCounter++;		
				if(!event_group.equals("*ALL")){				
				out.println("obj.add('"+group5_node_id+"','"+group4_node_id+"','"+event_group_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_group_desc+"','details_f2')");	
				}

				strBuffParams.append("&event_item=");
				strBuffParams.append(event_code);		
				
				group6_node_id =  nodeCounter++;		
	
				if(!event_group.equals("*ALL")){					
					out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				
				}else{
					out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				
				}


				prevGroup3 = group3;
				prev_hist_rec_type=hist_rec_type;
				prev_event_class=event_class;
				prev_event_group=event_group;
				prev_event_code = event_code;
			}else if(!prev_hist_rec_type.equals(hist_rec_type)){

				strBuffParams.append("&hist_type=");
				strBuffParams.append(hist_rec_type);	
				group3_node_id =  nodeCounter++;	

				if(viewby.equals("D")){
					out.println("obj.add('"+group3_node_id+"','"+group2_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
				}else{
				out.println("obj.add('"+group3_node_id+"','"+group1_node_id+"','"+hist_rec_type_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+hist_rec_type_desc+"','details_f2')");				
				}

				strBuffParams.append("&event_class=");
				strBuffParams.append(event_class);	
				
				group4_node_id =  nodeCounter++;	
				out.println("obj.add('"+group4_node_id+"','"+group3_node_id+"','"+event_class_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_class_desc+"','details_f2')");	

				strBuffParams.append("&event_group=");

				if(event_group.equals("*ALL")){
					strBuffParams.append("");		
				}else{
					strBuffParams.append(event_group);		
				}
				group5_node_id =  nodeCounter++;		
				if(!event_group.equals("*ALL")){				
				out.println("obj.add('"+group5_node_id+"','"+group4_node_id+"','"+event_group_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_group_desc+"','details_f2')");	
				}

				strBuffParams.append("&event_item=");
				strBuffParams.append(event_code);		
				group6_node_id =  nodeCounter++;			
				if(!event_group.equals("*ALL")){				
					out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}else{
					out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}

				if(viewby.equals("D")){
					prevGroup3 = group3;
				}
				prev_hist_rec_type=hist_rec_type;
				prev_event_class=event_class;
				prev_event_group=event_group;
				prev_event_code = event_code;

			}else if(!event_class.equals(prev_event_class)){
				strBuffParams.append("&hist_type=");
				strBuffParams.append(hist_rec_type);	
				strBuffParams.append("&event_class=");
				strBuffParams.append(event_class);
				//shaiju
				strBuffParams.append("&event_date=");
				strBuffParams.append(event_date);
				group4_node_id =  nodeCounter++;		
			out.println("obj.add('"+group4_node_id+"','"+group3_node_id+"','"+event_class_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_class_desc+"','details_f2')");	
				
				strBuffParams.append("&event_group=");
				if(event_group.equals("*ALL")){
					strBuffParams.append("");		
				}else{
					strBuffParams.append(event_group);		
				}		

						
				if(!event_group.equals("*ALL")){
					
				
					group5_node_id =  nodeCounter++;	
				out.println("obj.add('"+group5_node_id+"','"+group4_node_id+"','"+event_group_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_group_desc+"','details_f2')");	
				}

				strBuffParams.append("&event_item=");
				strBuffParams.append(event_code);
				

				group6_node_id =  nodeCounter++;		
				if(!event_group.equals("*ALL")){							
					out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}else{
					out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}
				prev_event_class=event_class;
				prev_event_group=event_group;
				prev_event_code = event_code;

			}else if(!event_group.equals(prev_event_group)){
				strBuffParams.append("&hist_type=");
				strBuffParams.append(hist_rec_type);	
				strBuffParams.append("&event_class=");
				strBuffParams.append(event_class);					
				strBuffParams.append("&event_group=");
				if(event_group.equals("*ALL")){
					strBuffParams.append("");		
				}else{
					strBuffParams.append(event_group);		
				}		

				group5_node_id =  nodeCounter++;
				
				//shaiju
				strBuffParams.append("&event_date=");
				strBuffParams.append(event_date);

				if(!event_group.equals("*ALL")){				
				out.println("obj.add('"+group5_node_id+"','"+group4_node_id+"','"+event_group_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_group_desc+"','details_f2')");	
				}

				strBuffParams.append("&event_item=");
				strBuffParams.append(event_code);
				
				
				
				group6_node_id =  nodeCounter++;		
				if(!event_group.equals("*ALL")){				
					out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}else{
					out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}

				prev_event_group=event_group;
				prev_event_code = event_code;

			}else if(!event_code.equals(prev_event_code)){
				strBuffParams.append("&hist_type=");
				strBuffParams.append(hist_rec_type);	
				strBuffParams.append("&event_class=");
				strBuffParams.append(event_class);					
				strBuffParams.append("&event_group=");
				if(event_group.equals("*ALL")){
					strBuffParams.append("");		
				}else{
					strBuffParams.append(event_group);		
				}		
				strBuffParams.append("&event_item=");
				strBuffParams.append(event_code);	
				
				group6_node_id =  nodeCounter++;			
			
				if(!event_group.equals("*ALL")){				
				 	out.println("obj.add('"+group6_node_id+"','"+group5_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}else{
					out.println("obj.add('"+group6_node_id+"','"+group4_node_id+"','"+event_desc+"','../../eCA/jsp/EncountersDetailsFrame.jsp?"+strBuffParams.toString()+"','"+event_desc+"','details_f2')");	
				}							
				prev_event_code = event_code;
			}


		}


	//out.println("<script>alert('buffer value"+strBuffParams+"')</script>");
	out.println("</script>");	

	session.setAttribute("arrayToSort"+patientid+encounter_id,sortList);
	}catch(Exception e){
		//out.println("Exception:"+e);//COMMON-ICN-0181
		 e.printStackTrace();//COMMON-ICN-0181
	}
	
	finally{
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(nodeCounter));
            _bw.write(_wl_block10Bytes, _wl_block10);
if(nodeCounter == 1){
            _bw.write(_wl_block11Bytes, _wl_block11);
}else{
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.History.label", java.lang.String .class,"key"));
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
}
