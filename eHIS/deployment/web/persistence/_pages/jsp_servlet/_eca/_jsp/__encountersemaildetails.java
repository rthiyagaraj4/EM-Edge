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
import eCA.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __encountersemaildetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncountersEmailDetails.jsp", 1734665630569L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCA/js/Encounters.js\' language=\'javascript\'></script>\n<Script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></Script>\n\n\n\n\t\t<title> ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n\n\t</head>\n<!--\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\'emailDtlsForm\' id=\'emailDtlsForm\'>\t\t-->\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<iframe name=\"detailFrame\" id=\"detailFrame\" SRC=\"../../eCA/jsp/EMail.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"  frameborder=\"no\" scrolling=\"no\" noresize style=\"height:100vh;width:99vw\"></iframe>\n\t\t\t\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<style>\n\tADDRESS\t{ FONT-FAMILY: Arial ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }\n\tPRE\n\t{\n\t\tfont-size: 8pt ;\n\t\tFont-Family : verdana;\n\t\tBACKGROUND-COLOR: #E2E3F0;\n\t\tBORDER-STYLE: none;\n\t\tfont-Weight : bold;\n\t\ttext-align: left;\n\t\tWORD-WRAP: break-word\n\t}\n\n\tTD.spanId1\n\t{\n\t\tBACKGROUND-COLOR: #637BBD;\n\t\tfont-size: 14pt ;\n\t\tFont-Family : Verdana;\n\t\tBORDER-STYLE: solid;\n\t\tfont-Weight: bold;\n\t\ttext-align: center;\n\t\twidth: 780;\n\t\tpadding-top: 3;\n\t\tpadding-bottom: 3;\n\t\tWORD-WRAP: break-word\n\t}\n\t\n\tTD.spanId2\n\t{\n\t\tBACKGROUND-COLOR: #B0C4DE;\n\t\tfont-size: 10pt ;\n\t\tFont-Family : Verdana;\n\t\tBORDER-STYLE: solid;\n\t\tfont-Weight: bold;\n\t\ttext-align: left;\n\t\twidth: 780;\n\t\tpadding-top: 3;\n\t\tpadding-bottom: 3;\n\t\tWORD-WRAP: break-word\n\t}\n</style>\n\t<!--\t</form>\n\t</body>-->\n</html>\n<!--<script>\n\tself.location.href = \'../../eCommon/jsp/error.jsp\'\n\tif(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' != \'0\')\n\t{\n\t\tvar title = \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\t\tvar action_url = \'../../eCA/jsp/EMail.jsp\';\n\t\taction_url +=\t\"?title=\"+encodeURIComponent(title,\"UTF-8\")+\"&module_id=CA&report_id=AHCLINREP&p_report_type=H&beanKey=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&p_file_name=EncountersEmailDetails.jsp&patient_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&encounter_id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&AuthReqdYN=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\t\n\t\tvar win = window.open(action_url,\'emailWin\',\'height=570,width=790,top=70,left=120,resizable=yes,scrollbars=yes\');\n\t}\n</script> -->\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String beanKey = "CA_EmailRepBodyTxtBean"+patient_id+encounter_id;

	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);

	eCA.EmailRepBodyTxtBean	CA_EmailRepBodyTxtBean = (eCA.EmailRepBodyTxtBean)getObjectFromBean(beanKey,"eCA.EmailRepBodyTxtBean",session);

	ArrayList keyList2 = manageEmailBean.returnList2();
	if(keyList2.size() == 0)
	{
		out.println("<script>");
		out.println("alert(getMessage(\"EVENTS_TO_EMAIL\",\"CA\"));");
		out.println("window.close();");
		out.println("</script>");
	}

	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
	String userID= (String) session.getValue("login_user") == null ? "" : (String) session.getValue("login_user");
	String UserName = "";	
	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
	java.util.ResourceBundle caLabelStr = java.util.ResourceBundle.getBundle( "eCA.resources.Labels",loc);

	String loggedUser = common_labels.getString("Common.LoggedUser.label");
	String dateTime = common_labels.getString("Common.datetime.label");
	String title = caLabelStr.getString("eCA.Email.label");

	ArrayList list = manageEmailBean.returnSortList();
	Collections.sort(list);
	int listSize = list.size();

	Connection con = null;
	PreparedStatement ps = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	ResultSet rs = null;
	Clob clb = null;	
	
	StringTokenizer strTok = null;
	String listValue = "";
	String eventDate = "";
	String histRecType = "";
	String contrSysId = "";
	String accNum = "";
	String contrSysEventCode = "";
	String histDataType = "";
	String resultNum = "";
	String resultStr = "";
	String classValue = "CAQRYEVEN";
//	String siteLogo = "";
	String facilityName = "";
	String printDateTime = "";
	String patient_name = "";
	String location = "";
	String reportDesc = "";
	String AuthReqdYN = "N";
	StringBuffer sql = new StringBuffer();
	StringBuffer displayData = new StringBuffer();
	StringBuffer displayDataTemp = new StringBuffer();


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	try
	{
		con  = ConnectionManager.getConnection(request);
		
/*		ps = con.prepareStatement("select SITE_LOGO_LOGIN_SCREEN PAGE_HEADER_IMAGE_FILE_NAME FROM SM_SITE_PARAM");
		res = ps.executeQuery();
		while(res.next())
		{
			siteLogo = res.getString("PAGE_HEADER_IMAGE_FILE_NAME") == null ? "" : res.getString("PAGE_HEADER_IMAGE_FILE_NAME");
		}
		
		if(res != null) res.close();
		if(ps != null) ps.close();*/

		ps = con.prepareStatement("select  REPORT_DESC from sm_report where MODULE_ID='CA' and REPORT_ID = 'AHCLINREP' ");
		res = ps.executeQuery();
		while(res.next())
		{
			reportDesc = res.getString("REPORT_DESC") == null ? "" : res.getString("REPORT_DESC");
		}
		
		if(res != null) res.close();
		if(ps != null) ps.close();

		ps = con.prepareStatement("SELECT FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID = ? and facility_id=?");
		ps.setString(1,locale);
		ps.setString(2,facilityId);

		res = ps.executeQuery();
		while(res.next())
		{
			facilityName = res.getString("FACILITY_NAME") == null ? "" : res.getString("FACILITY_NAME");
		}

		if(res != null) res.close();
		if(ps != null) ps.close();

		ps = con.prepareStatement("SELECT APPL_USER_NAME FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = ? and APPL_USER_ID=?");
		ps.setString(1,locale);
		ps.setString(2,userID);

		res = ps.executeQuery();
		while(res.next())
		{
			UserName = res.getString("APPL_USER_NAME") == null ? "" : res.getString("APPL_USER_NAME");
		}

		if(res != null) res.close();
		if(ps != null) ps.close();

		//ps = con.prepareStatement("SELECT to_char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time from dual");

		//ps = con.prepareStatement("select PATIENT_NAME ,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1') ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location from MP_PATIENT B,PR_ENCOUNTER A where A.PATIENT_ID=B.PATIENT_ID AND B.PATIENT_ID=? AND A.ENCOUNTER_ID=?");
		ps = con.prepareStatement("select PATIENT_NAME ,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time from MP_PATIENT B where B.PATIENT_ID=? ");
		ps.setString(1,patient_id);
		/*
		ps.setString(1,locale);
		ps.setString(2,locale);
		ps.setString(3,patient_id);
		ps.setString(4,encounter_id);
		*/

		res = ps.executeQuery();
		while(res.next())
		{
			patient_name = res.getString("PATIENT_NAME") == null ? "" : res.getString("PATIENT_NAME");
			printDateTime = res.getString("print_date_time") == null ? "" : res.getString("print_date_time");
			//location = res.getString("location") == null ? "" : res.getString("location");
		}

		if(res != null) res.close();
		if(ps != null) ps.close();

		String enc_id = "";
		String enc_id_prev = "";
		String sortEventDateTime = "";
		String prevHistRecType = "";
		String prevEventDate = "";
		String histRecTypeDesc = "";

		pstmt = con.prepareStatement(" Select CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1') ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location from PR_ENCOUNTER A where A.PATIENT_ID= ? AND A.ENCOUNTER_ID=? and a.facility_id =? ");

		for(int i=0; i<listSize; i++)
		{
			listValue = (String)list.get(i);
			strTok = new StringTokenizer(listValue,"`");

			while(strTok.hasMoreTokens())
			{
				sql.setLength(0);

				enc_id = strTok.nextToken();
				histRecType = (String) strTok.nextToken();
				sortEventDateTime = (String) strTok.nextToken();
				contrSysId = (String) strTok.nextToken();
				accNum = (String) strTok.nextToken();
				contrSysEventCode = (String) strTok.nextToken();
			}
			//if(!enc_id.equals("0")){
			if((!enc_id.equals("0"))&&(!enc_id.equals(enc_id_prev)))
			{
				
				//ps = con.prepareStatement(" Select CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1') ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location from PR_ENCOUNTER A where A.PATIENT_ID= ? AND A.ENCOUNTER_ID=? and a.facility_id =? ");
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,enc_id);
				pstmt.setString(5,facilityId);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					location = rs.getString("location") == null ? "" : rs.getString("location");
				}

				if(rs != null) rs.close();
				displayData.append("<table width='100%' cellpadding=0 cellspacing=0 border='0' ><td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"</b></td>");
				displayData.append("<td width='2%' align='center'><b>:</b></td>");
				displayData.append("<td width='24%' align='left'>"+enc_id+"</td>");
//	dispData.append("<td width='50%'><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : &nbsp;&nbsp;"+location+"</b></td>");  //location
				displayData.append("<td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b></td>");  //location
				displayData.append("<td width='2%' align='center'><b>:</b></td>");  //location
				displayData.append("<td width='24%' align='left'>"+location+"</td>");  //location

			displayData.append("</tr></table><BR>");

			}
			//}



			if(histRecType.equals("CLNT"))
			{

				sql.append("select null DIS_SUMM_DISCLAIMER_TXT,null  REF_LETTER_DISCLAIMER_TXT, b.hist_data,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,AM_GET_DESC.AM_PRACTITIONER(A.PERFORMED_BY_ID,?,'2') authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,DECODE(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,SM_GET_DESC.SM_FACILITY_PARAM(A.FACILITY_ID,?,'1') facility_name,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT, to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc, DECODE(A.PROTECTION_IND,'Z','Y','N') AuthReqdYN   from cr_encounter_detail a,cr_encounter_detail_txt b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and a.CONTR_SYS_ID=b.CONTR_SYS_ID   and a.ACCESSION_NUM=b.ACCESSION_NUM and a.CONTR_SYS_EVENT_CODE=b.CONTR_SYS_EVENT_CODE and b.hist_rec_type = ? and a.contr_sys_id =? and b.accession_num=? and a.contr_sys_event_code =?");
			}//if end of CLNT
			else
			{

				sql.append(" select TO_CHAR(NULL) DIS_SUMM_DISCLAIMER_TXT ,TO_CHAR(NULL) REF_LETTER_DISCLAIMER_TXT , b.long_desc,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT , A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' '||RESULT_NUM_UOM||' '||(select decode(a.normalcy_ind,HIGH_STR,'Abnormal',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') from cr_clin_event_param)||' '||replace('('||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' - '||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||')','( - )',null) RESULT_NUM,(SELECT CA_CLOB_REPLACE(hist_data,chr(10),'\n<br/>'");
				sql.append( "  ) FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,(select SHORT_NAME from am_practitioner where practitioner_id=a.PERFORMED_BY_ID) authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,dEcode(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,(select FACILITY_NAME from sm_facility_param where facility_id=a.facility_id) facility_name,to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc, DECODE(A.PROTECTION_IND,'Z','Y','N') AuthReqdYN   from cr_encounter_detail a,cr_clin_event_mast b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and b.event_code=a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type = ? and a.contr_sys_id =? and a.accession_num=? and a.contr_sys_event_code =?  ");


			}

			ps = con.prepareStatement(sql.toString());

			if(histRecType.equals("CLNT"))
			{
				ps.setString(1,locale);
				ps.setString(2,locale);
				ps.setString(3,histRecType);
				ps.setString(4,contrSysId);
				ps.setString(5,accNum);
				ps.setString(6,contrSysEventCode);
			}
			else
			{
				ps.setString(1,histRecType);
				ps.setString(2,contrSysId);
				ps.setString(3,accNum);
				ps.setString(4,contrSysEventCode);

			}

			res = ps.executeQuery();

			if(histRecType.equals("CLNT"))
			{

				displayData.append("<table width='100%' cellpadding=0 cellspacing=0 border='1'>");
				while(res.next())
				{
					clb = res.getClob("hist_data");
					eventDate = res.getString("event_date") == null ? "" : res.getString("event_date");
					histRecTypeDesc = res.getString("hist_rec_type_desc") == null ? "" : res.getString("hist_rec_type_desc");
					if (AuthReqdYN.equals("N"))
						AuthReqdYN= res.getString("AuthReqdYN") == null ? "N" : res.getString("AuthReqdYN");

					if(!prevHistRecType.equals(histRecType))
					{
						displayData.append("<TR><TD colspan='4' class='spanId1' align='center'><B>"+histRecTypeDesc+"</B></TD></TR>");
					}

					if(!prevEventDate.equals(eventDate))
					{
						displayData.append("<TR><TD colspan='4' class='spanId2' align='left' ><B>&nbsp;"+eventDate+"</B></TD></TR>");
					}

					//displayData.append("<TR>");
					//displayData.append("<TD class='"+classValue+"' >");

					if( (clb!=null) && (clb.length()>0) )
						displayDataTemp.append(clb.getSubString(1,((int)clb.length())));

					displayData.append("<TR><TD class='"+classValue+"' colspan='4' >"+displayDataTemp.toString()+"</TD></TR>");
					
					displayDataTemp.delete(0,displayDataTemp.length());

					displayData.append("</TABLE>");
				}
				if(res != null) res.close();
				if(ps != null) ps.close();
			}
			else
			{

				displayData.append("<table width='100%' cellpadding=0 cellspacing=0 border='1'>");
				String longDesc = "";
				clb = null;
				while (res.next())
				{					
					longDesc = res.getString("long_desc") == null ? "" : res.getString("long_desc");
					resultNum = res.getString("RESULT_NUM") == null ? "0" : res.getString("RESULT_NUM");
					resultStr = res.getString("RESULT_STR") == null ? "" : res.getString("RESULT_STR");
					//out.println("<script>alert()</script>)");
					histDataType = res.getString("HIST_DATA_TYPE") == null ? "" : res.getString("HIST_DATA_TYPE");
					eventDate = res.getString("event_date") == null ? "" : res.getString("event_date");
					histRecTypeDesc = res.getString("hist_rec_type_desc") == null ? "" : res.getString("hist_rec_type_desc");
					if (AuthReqdYN.equals("N"))
						AuthReqdYN= res.getString("AuthReqdYN") == null ? "N" : res.getString("AuthReqdYN");
					if(!prevHistRecType.equals(histRecType))
					{
						displayData.append("<TR><TD colspan='4' class='spanId1' align='center'><B>"+histRecTypeDesc+"</B></TD></TR>");
					}

					if(!prevEventDate.equals(eventDate))
					{
						displayData.append("<TR><TD colspan='4' class='spanId2' align='left' ><B>&nbsp;"+eventDate+"</B></TD></TR>");
					}

					displayData.append("<TR>");
					
					clb = res.getClob("hist_data");

					
					if(!histDataType.equals("HTM") && !histDataType.equals("TXT"))
					{
						//out.println("<script>alert('HTML and text')</script>");
						displayData.append("<TD class='"+classValue+"' width='1%'>&nbsp;</TD>");
						displayData.append("<TD class='"+classValue+"' width='15%'>");
						displayData.append(longDesc);
						displayData.append("</TD>");
						displayData.append("<TD class='"+classValue+"' width='1%'>");
						displayData.append("&nbsp;: ");
						displayData.append("</TD>");
						//out.println("<script>alert('longDesc in htm and text ---"+longDesc+"---');</script>");

					}
					if(histDataType.equals("TXT"))
					{
						//out.println("<script>alert('text')</script>");
						displayData.append("<TD class='"+classValue+"' width='1%'>&nbsp;</TD>");
						displayData.append("<TD class='"+classValue+"' width='15%'>");
						displayData.append(longDesc);
						displayData.append("</TD>");
						//out.println("<script>alert('longDesc in text ---"+longDesc+"---');</script>");
					}


					if(histDataType.equals("NUM"))
					{
						//out.println("<script>alert('num')</script>");
						displayData.append("<TD class='"+classValue+"' width='25%'>");
						displayData.append("&nbsp; "+resultNum+"</TD>");
						if(!resultStr.equals(""))
						{
							displayData.append("</TR>");
							displayData.append("<TR>");
							displayData.append("<TD class='"+classValue+"' >&nbsp;</TD>");
							displayData.append("<TD class='"+classValue+"' colspan='3'>");
							displayData.append("&nbsp;"+resultStr+"</TD>");
						}
						if((clb!=null) && (clb.length()>0))
						{
							displayData.append("</TR>");
							displayData.append("<TR>");
							displayData.append("<TD class='"+classValue+"'>&nbsp;</TD>");
							displayData.append("<TD class='"+classValue+"'  colspan='3'>");
							displayData.append(clb.getSubString(1,((int)clb.length())));
							displayData.append("</TD>");
						}
						else
						{
							//out.println("<script>alert('in else')</script>");
							displayData.append("</TR>");
							displayData.append("<TR>");
							displayData.append("<TD class='"+classValue+"' colspan='4'>&nbsp;</TD>");
						}
					}
					else if(histDataType.equals("STR"))
					{
						//out.println("<script>alert('str')</script>");
						displayData.append("<TD class='"+classValue+"' width='25%'>");
						displayData.append("&nbsp;"+resultStr);
						displayData.append("</TD>");
						if((clb!=null) && (clb.length()>0))
						{
							displayData.append("</TR>");
							displayData.append("<TR>");
							displayData.append("<TD class='"+classValue+"'>&nbsp;</TD>");
							displayData.append("<TD class='"+classValue+"'  colspan='3'>");
							displayData.append(clb.getSubString(1,((int)clb.length())));
							displayData.append("</TD>");
						}
						else
						{
							//out.println("<script>alert('in else')</script>");
							displayData.append("</TR>");
							displayData.append("<TR>");
							displayData.append("<TD class='"+classValue+"' colspan='4'>&nbsp;</TD>");
						}	
					}

					if((histDataType.equals("HTM") || histDataType.equals("TXT")))
					{
						//out.println("<script>alert('html or txt')</script>");
						if((clb!=null) && (clb.length()>0))
						{
							displayData.append("</TR>");
							displayData.append("<TR>");
							displayData.append("<TD class='"+classValue+"'>&nbsp;</TD>");
							displayData.append("<TD class='"+classValue+"'  colspan='3'>");
							displayData.append(clb.getSubString(1,((int)clb.length())));
							displayData.append("</TD>");
						}
						else
						{
							//out.println("<script>alert('in else')</script>");
							displayData.append("</TR>");
							displayData.append("<TR>");
							displayData.append("<TD class='"+classValue+"' colspan='4'>&nbsp;</TD>");
						}
					}
					displayData.append("</TR>");
				}
				displayData.append("</TABLE>");
				if(res != null) res.close();
				if(ps != null) ps.close();
			}
			prevEventDate = eventDate;
			prevHistRecType = histRecType;
			enc_id_prev = enc_id;
		}
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e)
	{
		
		//out.println("Exception in try of EncountersEmailDetails.jsp --"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		if(res != null) res.close();
		if(ps != null) ps.close();
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
	StringBuffer dispData = new StringBuffer();
	dispData.append("<table width='100%' cellpadding=0 cellspacing=0 border='0'>");
	dispData.append("<tr>");
	//dispData.append("<td><h3><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo'></h3></td>");
	dispData.append("<td align='center'><h3>"+facilityName+"</h3></td>");
	dispData.append("</tr>");
	dispData.append("<tr>");
	dispData.append("<td align='center'><h4>"+reportDesc+"</h4></td>");
	dispData.append("</tr>");
	dispData.append("</table>");
	dispData.append("<table width='100%' cellpadding=0 cellspacing=0 border='0'>");
	dispData.append("<tr>");
	dispData.append("<td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"</td><td width='2%' align='center' ><b> : </b></td><td width='24%'>"+patient_id+"</td>");
	dispData.append("<td width='24%' align='left' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"</b></td><td width='2%' align='center' ><b> :</b> </td><td width='24%'>"+patient_name+" </td>");  //
	dispData.append("</tr>");
	dispData.append("</table>");
	/*
	dispData.append("<tr>");
	dispData.append("<td width='50%'><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"&nbsp;&nbsp; : &nbsp;&nbsp;</b>"+encounter_id+"</td>");
	dispData.append("<td width='50%'><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : &nbsp;&nbsp;</b>"+location+"</td>");  //location
	dispData.append("</tr>");
	dispData.append("<tr><td colspan=2>&nbsp;</td></tr>");
	dispData.append("</table>");
	*/

//	dispData.append("<PRE style='word-wrap:break-word;margin-right:5%'>");
	dispData.append(displayData.toString());
//	dispData.append("</PRE>");
	dispData.append("<table width='100%' cellpadding=0 cellspacing=0>");
	dispData.append("<tr>");
	dispData.append("<td align='left'><b>"+loggedUser+" : "+UserName+"</b></td>");
	dispData.append("<td align='right'><b>"+dateTime+" : "+printDateTime+"</b></td>");
	dispData.append("</tr>");
	dispData.append("</table>");
	//out.println(dispData);
	CA_EmailRepBodyTxtBean.clearBean();
	CA_EmailRepBodyTxtBean.setReportText(dispData.toString());


	putObjectInBean(beanKey,CA_EmailRepBodyTxtBean,session);

	if(keyList2.size() != 0)
	{
		String action_url = "title="+title+"&module_id=CA&report_id=AHCLINREP&p_report_type=H&beanKey="+beanKey+"&p_file_name=EncountersEmailDetails.jsp&patient_id="+patient_id+"&encounter_id="+encounter_id+"&AuthReqdYN="+AuthReqdYN;

		//out.println("<script>alert('"+action_url+"');</script>");

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(action_url));
            _bw.write(_wl_block10Bytes, _wl_block10);

	}

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(keyList2.size()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(title));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(beanKey));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(AuthReqdYN));
            _bw.write(_wl_block17Bytes, _wl_block17);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Email.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
