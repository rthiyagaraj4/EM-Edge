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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __flowsheeteventsquicktext extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/FlowSheetEventsQuickText.jsp", 1709115885450L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n\n<!--\n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n01/02/2012\t  IN030859\t\tMenaka V\tCA>HTML code is displayed if we view the recorded Chief complaints in\n\t\t\t\t\t\t\t\t\t\tClinical Events History and Chart Summary. \n05/04/2012\t  IN031989\t\tMenaka V\t When a patient is selected by using patient without encounter search function and when clinical\n\t\t\t\t\t\t\t\t\t\t event history is accessed the note header is incomplete for all the existing notes for that patient.\n20/06/2012\t  IN033489\t\tMenaka V\t\tReport header blank in clinical event history.\n01/08/2013 \t  IN001776\t\tChowminya G\t\tReport header blank in clinical event history for order note results\t\t\t\t\t\t\t\t\t \n--------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n\t<HEAD>\n\t\t<TITLE></TITLE>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t<!-- ****  Modified by kishor kumar n on 06/12/2008 for crf0387 applied new css grid. **** -->\n\t\n\t\n\t<script src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../../eCA/js/FlowSheet.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</HEAD>\n\t<BODY class=\'CONTENT\'  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onscroll=\'staticTitleForCommentDetails()\'>\n\t\t<form name=\'frmQuickText\' id=\'frmQuickText\'>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<div id=\'commentTitleId1\'>\n\t\t\t<B>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</B>\n\t\t\t</div>\n\t\t\t<table width=\'100%\' id=\'dataTable\' class=\'grid\'>\n\t\t\t<TR id=\'commentTitleId\'>\n<!-- \t\t\t\t<td class=\'COLUMNHEADERCENTER\'  nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n -->\t\t\t\t<td class=\'COLUMNHEADERCENTER\'  width=\'30%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADERCENTER\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t</TR>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'enc_id\' id=\'enc_id\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\t\t\n\t\t\t</TABLE>\n\n\t\t\t<input type=\'hidden\' name=\'txtHistRecTypes\' id=\'txtHistRecTypes\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t<input type=\'hidden\' name=\'txtContrSysIds\' id=\'txtContrSysIds\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t<input type=\'hidden\' name=\'txtAccessionNos\' id=\'txtAccessionNos\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t<input type=\'hidden\' name=\'txtEventCodes\' id=\'txtEventCodes\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t<input type=\'hidden\' name=\'listSize\' id=\'listSize\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t</form>\n\t</body>\n</html>\n<script>\n\tparent.commButtons.location.href = \'FlowSheetEventsQuickTextCommButtons.jsp?listSize=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\';\n</script>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);

    String patientid = request.getParameter("patient_id") == null? "" : request.getParameter("patient_id");
    String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String fac_id ="";
	String enctr_id ="";
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patientid+encounter_id,"eCA.PatientBannerGroupLine",session);

            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			ArrayList list = manageEmailBean.returnSortList();
			Collections.sort(list);
			int listSize = list.size();

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet res = null;
			StringTokenizer strTok = null;
			String listValue = "";
			int i=0;

			String tempHistRecTypes = "";
			String tempContrSysIds = "";
			String tempAccessionNos = "";
			String tempEventCodes = "";
		
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

				
				try
				{
					con  = ConnectionManager.getConnection(request);

					String sortEventDateTime = "";
					String prevHistRecType = "";
					String prevEventDate = "";
					String histRecTypeDesc = "";
					String contrSysEventCode = "";	
					String eventCode = "";
					String eventDate = "";
					String eventDesc = "";
					String histRecType = "";
					String histDataType = "";
					String resultNum = "";
					String resultStr = "";
					String listValueStr = "";
					String listKeyValueStr = "";
					String sortListValueStr = "";
					String dispValue = "";
					String contrSysId = "";
					String accNum = "";
					String enc_id = "";
					String sortEventDate = "";
					String classValue = "gridData";
					StringBuffer sql = new StringBuffer();

					for(i=0; i<listSize; i++)
					{
						listValue = (String)list.get(i);
						strTok = new StringTokenizer(listValue,"`");

						while(strTok.hasMoreTokens())
						{
							sql.setLength(0);

							enc_id = (String) strTok.nextToken();
							histRecType = (String) strTok.nextToken();
							sortEventDateTime = (String) strTok.nextToken();
							contrSysId = (String) strTok.nextToken();
							accNum = (String) strTok.nextToken();
							contrSysEventCode = (String) strTok.nextToken();
						}

						tempHistRecTypes = tempHistRecTypes + histRecType+","; 
						tempContrSysIds = tempContrSysIds + contrSysId+",";   
						tempAccessionNos = tempAccessionNos + accNum+",";
						tempEventCodes = tempEventCodes + contrSysEventCode+",";      

						if(histRecType.equals("CLNT"))
						{
							//sql.append("select null DIS_SUMM_DISCLAIMER_TXT,null  REF_LETTER_DISCLAIMER_TXT, b.hist_data,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,AM_GET_DESC.AM_PRACTITIONER(A.PERFORMED_BY_ID,?,'2') authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,DECODE(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,SM_GET_DESC.SM_FACILITY_PARAM(A.FACILITY_ID,?,'1') facility_name,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT, to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date,to_char(a.event_date,'YYYYMMDDHH24MISS') sort_event_date, CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc, A.EVENT_CODE,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,'"+locale+"','1')  event_desc,A.HIST_DATA_TYPE from cr_encounter_detail a,cr_encounter_detail_txt b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and a.CONTR_SYS_ID=b.CONTR_SYS_ID   and a.ACCESSION_NUM=b.ACCESSION_NUM and a.CONTR_SYS_EVENT_CODE=b.CONTR_SYS_EVENT_CODE and b.hist_rec_type = ? and a.contr_sys_id =? and b.accession_num=? and a.contr_sys_event_code =?");//menaka
							sql.append("select null DIS_SUMM_DISCLAIMER_TXT,null  REF_LETTER_DISCLAIMER_TXT, b.hist_data,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,AM_GET_DESC.AM_PRACTITIONER(A.PERFORMED_BY_ID,?,'2') authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,DECODE(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,SM_GET_DESC.SM_FACILITY_PARAM(A.FACILITY_ID,?,'1') facility_name,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT, to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date,to_char(a.event_date,'YYYYMMDDHH24MISS') sort_event_date, CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc, A.EVENT_CODE,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,'"+locale+"','1')  event_desc,A.HIST_DATA_TYPE, a.encounter_ID, a.FACILITY_ID from cr_encounter_detail a,cr_encounter_detail_txt b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and a.CONTR_SYS_ID=b.CONTR_SYS_ID   and a.ACCESSION_NUM=b.ACCESSION_NUM and a.CONTR_SYS_EVENT_CODE=b.CONTR_SYS_EVENT_CODE and b.hist_rec_type = ? and a.contr_sys_id =? and b.accession_num=? and a.contr_sys_event_code =?");//menaka
						}//if end of CLNT
						else
						{
							sql.append(" select TO_CHAR(NULL) DIS_SUMM_DISCLAIMER_TXT ,TO_CHAR(NULL) REF_LETTER_DISCLAIMER_TXT , b.long_desc,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT , A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' '||RESULT_NUM_UOM||' '||(select decode(a.normalcy_ind,HIGH_STR,'Abnormal',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') from cr_clin_event_param)||' '||replace('('||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' - '||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||')','( - )',null) RESULT_NUM,(SELECT CA_CLOB_REPLACE(hist_data,chr(10),'\n'");
							//sql.append( "  ) FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,(select SHORT_NAME from am_practitioner where practitioner_id=a.PERFORMED_BY_ID) authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,dEcode(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,(select FACILITY_NAME from sm_facility_param where facility_id=a.facility_id) facility_name,to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date,to_char(a.event_date,'YYYYMMDDHH24MISS') sort_event_date, CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc,A.EVENT_CODE,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,'"+locale+"','1')  event_desc   from cr_encounter_detail a,cr_clin_event_mast b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and b.event_code=a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type = ? and a.contr_sys_id =? and a.accession_num=? and a.contr_sys_event_code =?  ");//Menaka
							sql.append( "  ) FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,(select SHORT_NAME from am_practitioner where practitioner_id=a.PERFORMED_BY_ID) authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,dEcode(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,(select FACILITY_NAME from sm_facility_param where facility_id=a.facility_id) facility_name,to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date,to_char(a.event_date,'YYYYMMDDHH24MISS') sort_event_date, CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc,A.EVENT_CODE,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,'"+locale+"','1')  event_desc, a.encounter_ID, a.FACILITY_ID   from cr_encounter_detail a,cr_clin_event_mast b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and b.event_code=a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type = ? and a.contr_sys_id =? and a.accession_num=? and a.contr_sys_event_code =?  ");//Menaka
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
							while(res.next())
							{
								eventDate = res.getString("event_date") == null ? "" : res.getString("event_date");
								sortEventDate = res.getString("sort_event_date") == null ? "" : res.getString("sort_event_date");
								histRecTypeDesc = res.getString("hist_rec_type_desc") == null ? "" : res.getString("hist_rec_type_desc");
								eventCode = res.getString("EVENT_CODE") == null ? "" : res.getString("EVENT_CODE");
								eventDesc = res.getString("event_desc") == null ? "" : res.getString("event_desc");
								histDataType = res.getString("HIST_DATA_TYPE") == null ? "" : res.getString("HIST_DATA_TYPE");
								enctr_id = res.getString("encounter_ID") == null ? "" : res.getString("encounter_ID");
								fac_id = res.getString("FACILITY_ID") == null ? "" : res.getString("FACILITY_ID");
								eventDate	= com.ehis.util.DateUtils.convertDate(eventDate,"DMYHM","en",locale);

								if(!prevHistRecType.equals(histRecType))
								{
									out.println("<tr>");
									out.println("<td class='CAFLOWSHEETLEVEL1' colspan ='5'>"+histRecTypeDesc);
									out.println("</td>");
									out.println("</tr>");
								}

								if(!prevEventDate.equals(eventDate))
								{
									out.println("<tr>");
									out.println("<td class='CAFLOWSHEETLEVEL2' colspan ='5'>&nbsp;"+eventDate);
									out.println("</td>");
									out.println("</tr>");
								}

								if(histDataType.equals("HTM") || histDataType.equals("TXT"))
								{
									//dispValue = "<a href=\"javascript:getTextInModal('"+histRecType+"','"+contrSysId+"','"+accNum+"','"+contrSysEventCode+"')\"><img border=no src='../../eCA/images/flow_text.gif'></img></a>";//IN031989
									dispValue = "<a href=\"javascript:getTextInModal('"+histRecType+"','"+contrSysId+"','"+accNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"')\"><img border=no src='../../eCA/images/flow_text.gif'></img></a>";//IN031989//IN033489
								}	

								else if(histDataType.equals("STR"))
									dispValue = resultStr;
								else
									dispValue = resultNum;

								if(resultNum.equals("") || resultNum == null) resultNum = " ";
								else if(!resultNum.equals(" ")) resultNum = resultNum.trim();
								if(resultStr.equals("")) resultStr = " ";

								listValueStr = eventDate+"`"+histRecType+"`"+contrSysId+"`"+accNum+"`"+contrSysEventCode+"`"+histDataType+"`"+eventDesc+"`"+resultNum+"`"+resultStr;
								listKeyValueStr = histRecType+"`"+contrSysId+"`"+accNum+"`"+contrSysEventCode;
								sortListValueStr = histRecType+"`"+sortEventDate+"`"+contrSysId+"`"+accNum+"`"+contrSysEventCode;

								out.println("<tr>");
								out.println("<td class='"+classValue+"'>"+eventDesc+"</td>");
								out.println("<td class='"+classValue+"'>"+dispValue+"</td>");
								out.println("</tr>");

								prevHistRecType = histRecType;
								prevEventDate = eventDate;
							}
						}
						else
						{
							while (res.next())
							{
								resultNum = res.getString("RESULT_NUM") == null ? "" : res.getString("RESULT_NUM");
								resultStr = res.getString("RESULT_STR") == null ? "" : res.getString("RESULT_STR");
								histDataType = res.getString("HIST_DATA_TYPE") == null ? "" : res.getString("HIST_DATA_TYPE");
								eventDate = res.getString("event_date") == null ? "" : res.getString("event_date");
								histRecTypeDesc = res.getString("hist_rec_type_desc") == null ? "" : res.getString("hist_rec_type_desc");
								eventCode = res.getString("EVENT_CODE") == null ? "" : res.getString("EVENT_CODE");
								eventDesc = res.getString("event_desc") == null ? "" : res.getString("event_desc");
								sortEventDate = res.getString("sort_event_date") == null ? "" : res.getString("sort_event_date");
								eventDate	= com.ehis.util.DateUtils.convertDate(eventDate,"DMYHM","en",locale);
								//IN001776 - encounder id not passed
								enctr_id = res.getString("encounter_ID") == null ? "" : res.getString("encounter_ID");
								fac_id = res.getString("FACILITY_ID") == null ? "" : res.getString("FACILITY_ID");
								//IN001776	
								if(!prevHistRecType.equals(histRecType))
								{
									out.println("<tr>");
									out.println("<td class='CAFLOWSHEETLEVEL1' colspan ='5'>"+histRecTypeDesc);
									out.println("</td>");
									out.println("</tr>");
								}

								if(!prevEventDate.equals(eventDate))
								{
									out.println("<tr>");
									out.println("<td class='CAFLOWSHEETLEVEL2' colspan ='5'>&nbsp;"+eventDate);
									out.println("</td>");
									out.println("</tr>");
								}

								if(histDataType.equals("HTM") || histDataType.equals("TXT"))
								{
									//dispValue = "<a href=\"javascript:getTextInModal('"+histRecType+"','"+contrSysId+"','"+accNum+"','"+contrSysEventCode+"')\"><img border=no src='../../eCA/images/flow_text.gif'></img></a>";//IN031989
									dispValue = "<a href=\"javascript:getTextInModal('"+histRecType+"','"+contrSysId+"','"+accNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"')\"><img border=no src='../../eCA/images/flow_text.gif'></img></a>";//IN031989//IN033489
									
								}
								else if(histDataType.equals("STR"))
									dispValue = resultStr;
								else
									dispValue = resultNum;

								if(resultNum.equals("") || resultNum == null) resultNum = " ";
								else if(!resultNum.equals(" "))resultNum = resultNum.trim();
								if(resultStr.equals("")) resultStr = " ";

								listValueStr = eventDate+"`"+histRecType+"`"+contrSysId+"`"+accNum+"`"+contrSysEventCode+"`"+histDataType+"`"+eventDesc+"`"+resultNum+"`"+resultStr;
								listKeyValueStr = histRecType+"`"+contrSysId+"`"+accNum+"`"+contrSysEventCode;
								sortListValueStr = histRecType+"`"+sortEventDate+"`"+contrSysId+"`"+accNum+"`"+contrSysEventCode;

								out.println("<tr>");
								out.println("<td class='"+classValue+"'>"+eventDesc+"</td>");
								out.println("<td class='"+classValue+"'>"+dispValue+"</td>");
								out.println("</tr>");

								prevHistRecType = histRecType;
								prevEventDate = eventDate;
							}
						}
					}

				tempHistRecTypes = tempHistRecTypes.substring(0,tempHistRecTypes.lastIndexOf(','));
				tempContrSysIds = tempContrSysIds.substring(0,tempContrSysIds.lastIndexOf(','));
				tempAccessionNos = tempAccessionNos.substring(0,tempAccessionNos.lastIndexOf(','));
				tempEventCodes = tempEventCodes.substring(0,tempEventCodes.lastIndexOf(','));
				//IN030859 Starts
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block15Bytes, _wl_block15);

				//IN030859 Ends
				}//end of try
				catch(Exception ee)
				{
					
					//out.println("Exception in try of FlowSheetEventsQuickText.jsp--"+ee.toString());//COMMON-ICN-0181
					ee.printStackTrace();
				}
				finally
				{
					if(res != null) res.close();
					if(ps != null) ps.close();
					if(con!=null)ConnectionManager.returnConnection(con,request);
				}
			
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tempHistRecTypes));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(tempContrSysIds));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tempAccessionNos));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tempEventCodes));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(listSize));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(listSize));
            _bw.write(_wl_block22Bytes, _wl_block22);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AddNewComments.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.EventDate.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Event.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
}
