package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import java.util.regex.*;
import java.util.*;
import com.ehis.util.*;

public final class __at_intraanaesdocstatus extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AT_IntraAnaesDocStatus.jsp", 1709120152000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n         \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="                    \n\n\n<html>\n<head>\n<!-- Commented below line and added sStyle for IN023984 on 9/29/2010 by AnithaJ -->\n\n<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></LINK>\n -->\n <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script> \n\t<script language=\"JavaScript\" src=\"../../eOT/js/AT_RecordAnesthesiaDetails.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/AT_RecordIntraAnesthesia.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n<form name=\"RecordAnesthesiaHdrForm\" id=\"RecordAnesthesiaHdrForm\" >\n<table cellpadding=3  cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\n\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" size=\'10\'  value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" disabled>\n<input type=\"hidden\" name=\"patient_name\" id=\"patient_name\" size=\'30\'  value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" disabled> \n<input type=\"hidden\"  name=\"sex\" id=\"sex\" size=\'2\' value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" disabled>\n<input type=\"hidden\"  name=\"dob\" id=\"dob\" size=\'10\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" disabled>\n<input type=\"hidden\"  name=\"surgeon_name\" id=\"surgeon_name\" size=\'27\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" disabled>\n<input type=\"hidden\" name=\"surgery_date\" id=\"surgery_date\" colspan=\"2\" size=\'8\'  value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" disabled>\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' size=\'13\' value= \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" disabled>\n<input type=\'hidden\' name=\'patient_class_desc\' id=\'patient_class_desc\' size=\'15\' value= \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" disabled>\n\n<tr>\n<td align=\'left\' class=\'COLUMNHEADER\' width=\'100%\'>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="  \n</td>\n</tr>  \n\n<tr>\n\t<td class=\'Label\'>\n\t\t<input type=\'checkbox\' name=\"intraop_done\" id=\"intraop_done\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="  onclick=\"intraAnaesCheckedYN()\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" > \n\t\t<input type=\'hidden\' name=\"intraop_done_yn\" id=\"intraop_done_yn\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" \n\t</td>\n\t<td class=\'fields\'>\n\n\t</td>\n\t<input type=\"hidden\" name=\"surgery_date\" id=\"surgery_date\" size=\'10\'  value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" disabled>\n\t<td>\n\t</td>\n\t\t<td  align=\"left\" class=\"label\" >\n\t\t</td>\n\n</tr>\n\n\n</table>\n\t<input type=\'hidden\' name=\'intra_disable_flag\' id=\'intra_disable_flag\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t<input type=\'hidden\' name=\'anesthesia_srl_no\' id=\'anesthesia_srl_no\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t<input type=\'hidden\' name=\'chart_id\' id=\'chart_id\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t<input type=\'hidden\' name=\'status\' id=\'status\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t<input type=\'hidden\' name=\'current_date\' id=\'current_date\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t<input type=\'hidden\' name=\'current_time\' id=\'current_time\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t<input type=\'hidden\' name=\'current_date_time\' id=\'current_date_time\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");	
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

  java.util.Properties prop = null;
  prop	= (java.util.Properties) session.getValue( "jdbc" ) ;
  String locale = (String)session.getAttribute("LOCALE");
  String strAnesthesiaSrlNo="",facility_id="",strPatientId="",strHeight="",strWeight="",strBSA="",strBMI="",strSourceOrderId="",strStatus="",strPatientClass="",strEncounterId="",strEpisodeId="",strSourceType="",strSourceCode="",strSurgeonCode="",strSurgeryDate="",strPatientClassDesc="",strSourceDesc="",strReferralSource="",strName="",strAge="",strSex="",strSurgeonName="",chartId="",strAnaesthesiaCode="",strAnaesthesiaDesc="",strEndDateTime="",strStartDateTime="",strBMIDesc="",strEpisodeType="",strIntraopDoneYN="N",strIntraopDone_check="",intra_disable_flag="",accession_num="",strAccessionNum="",current_date = "" ,current_time	= "" ,current_date_time	= "" ;
  Statement stmt1 = null ;
  ResultSet resultSet1     = null ;
  String[] arrStartDate = null;
  String[] arrEndDate =  null;
  int tot_rec=0;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql_curr_date="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CUR_DATE,TO_CHAR(SYSDATE,'HH24:MI') CUR_TIME,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')  CURRENT_DATE_TIME FROM DUAL";
	Statement stmt = null ;
	ResultSet resultSet			= null ;
	try{
		conn			= ConnectionManager.getConnection(request);
		stmt				= conn.createStatement() ;
		resultSet			= stmt.executeQuery(sql_curr_date);
		while(resultSet!=null && resultSet.next()){
			current_date = resultSet.getString("CUR_DATE");
			current_time = resultSet.getString("CUR_TIME");
			current_date_time = resultSet.getString("CURRENT_DATE_TIME");

	}
  String sql= "SELECT  PATIENT_ID PATIENT_ID1,REQUEST_SOURCE_TYPE REQUEST_SOURCE_TYPE1,ORDER_ID ORDER_ID1,HEIGHT HEIGHT1,WEIGHT WEIGHT1,BSA BSA1,BMI BMI1,SOURCE_ORDER_ID SOURCE_ORDER_ID1,STATUS STATUS1,ANAESTHESIA_CODE ANAESTHESIA_CODE1,ANAESTHETIST1_CODE ANAESTHETIST1_CODE1,ANAESTHETIST2_CODE ANAESTHETIST2_CODE1,TO_CHAR(END_TIME,'DD/MM/YYYY HH24:MI') END_TIME1,TO_CHAR(START_TIME,'DD/MM/YYYY HH24:MI') START_TIME1,INTRAOP_DONE_YN INTRAOP_DONE_YN1,ACCESSION_NUM ACCESSION_NUM1 FROM AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID =?  AND ANAESTHESIA_SERIAL_NUM=?";
	strAnesthesiaSrlNo=CommonBean.checkForNull(request.getParameter("anesthesia_srl_no"));
	facility_id=CommonBean.checkForNull(request.getParameter("facility_id"));
	  pstmt=conn.prepareCall(sql);
	  pstmt.setString(1,facility_id);
	  pstmt.setString(2,strAnesthesiaSrlNo);
	  rs=pstmt.executeQuery();
	  if(rs.next()){
		strPatientId=CommonBean.checkForNull(rs.getString("PATIENT_ID1"));
		strHeight=CommonBean.checkForNull(rs.getString("HEIGHT1"));
		strWeight=CommonBean.checkForNull(rs.getString("WEIGHT1"));
		strBSA=CommonBean.checkForNull(rs.getString("BSA1"));
		strBMI=CommonBean.checkForNull(rs.getString("BMI1"));
		strSourceOrderId=CommonBean.checkForNull(rs.getString("SOURCE_ORDER_ID1"));
		strStatus=CommonBean.checkForNull(rs.getString("STATUS1"));
		strAnaesthesiaCode=CommonBean.checkForNull(rs.getString("ANAESTHESIA_CODE1"));
		strEndDateTime=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("END_TIME1"),"DMYHM","en",locale));
		strStartDateTime=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("START_TIME1"),"DMYHM","en",locale));
		strIntraopDoneYN=CommonBean.checkForNull(rs.getString("INTRAOP_DONE_YN1"));
		strAccessionNum=CommonBean.checkForNull(rs.getString("ACCESSION_NUM1"));
		Pattern Regex = Pattern.compile("\\s", Pattern.MULTILINE);
		arrStartDate =   Regex.split(strStartDateTime,strStartDateTime.length());
		arrEndDate   =   Regex.split(strEndDateTime,strStartDateTime.length());
	  if(strIntraopDoneYN.equalsIgnoreCase(""))
			strIntraopDoneYN="N";

	  if(strIntraopDoneYN.equalsIgnoreCase("Y"))
	  {
			strIntraopDone_check="checked";
			intra_disable_flag="disabled";
	  }
	  else
			strIntraopDone_check="";
	sql="SELECT PATIENT_CLASS PATIENT_CLASS1,ENCOUNTER_ID ENCOUNTER_ID1,EPISODE_ID EPISODE_ID1,SOURCE_TYPE SOURCE_TYPE1,SOURCE_CODE SOURCE_CODE1,ORD_PRACT_ID ORD_PRACT_ID1,to_char(ORD_DATE_TIME,'dd/mm/yyyy') ORD_DATE_TIME1 FROM  OR_ORDER WHERE ORDER_ID=?";
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,strSourceOrderId);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strPatientClass=CommonBean.checkForNull(rs.getString("PATIENT_CLASS1"));
		strEncounterId=CommonBean.checkForNull(rs.getString("ENCOUNTER_ID1"));
		strEpisodeId=CommonBean.checkForNull(rs.getString("EPISODE_ID1"));
		strSourceType=CommonBean.checkForNull(rs.getString("SOURCE_TYPE1"));
		strSourceCode=CommonBean.checkForNull(rs.getString("SOURCE_CODE1"));
		strSurgeonCode=CommonBean.checkForNull(rs.getString("ORD_PRACT_ID1"));
		strSurgeryDate=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("ORD_DATE_TIME1"),"DMY","en",locale));
	}
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();

	sql="SELECT PATIENT_NAME SHORT_NAME1, to_char(DATE_OF_BIRTH,'dd/mm/yyyy')  DATE_OF_BIRTH1, SEX SEX1 FROM MP_PATIENT WHERE PATIENT_ID =?";
	 pstmt = conn.prepareStatement(sql);
	 pstmt.setString(1,strPatientId);
	 rs=pstmt.executeQuery();
	 if(rs.next())
	  {
		 strName=CommonBean.checkForNull(rs.getString("SHORT_NAME1"));
		 strAge=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("DATE_OF_BIRTH1"),"DMY","en",locale));
		 strSex=CommonBean.checkForNull(rs.getString("SEX1"));
	  }
	sql="SELECT SHORT_DESC SHORT_DESC1 from AM_PATIENT_CLASS_LANG_VW where LANGUAGE_ID='"+locale+"' AND PATIENT_CLASS=?";
	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,strPatientClass);
	rs=pstmt.executeQuery();

	if(rs.next())
	{
		strPatientClassDesc=CommonBean.checkForNull(rs.getString("SHORT_DESC1"));
	}
	if(rs!=null) rs.close();
	pstmt.close();
	if(!strSourceType.equals(""))
	{
		if(strSourceType.equals("W")||strSourceType.equals("N"))
		{
			sql=  "SELECT LONG_DESC SHORT_DESC1 FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND FACILITY_ID ='"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' AND  NURSING_UNIT_CODE ='"+strSourceCode+"' ";
			strReferralSource="Wards";
		}
		else if(strSourceType.equals("C"))
		{
		   sql="SELECT LONG_DESC SHORT_DESC1 FROM   OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E'    AND CLINIC_CODE='"+strSourceCode+"' ";
			strReferralSource="Clinics";
		}
		else if(strSourceType.equals("R"))
		{
		   sql="SELECT LONG_DESC  SHORT_DESC1 FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E' AND REFERRAL_CODE='"+strSourceCode+"' ";
			strReferralSource="Referral";
		}
		pstmt=conn.prepareCall(sql);

		rs=pstmt.executeQuery();
		if(rs.next())
		{
			strSourceDesc=CommonBean.checkForNull(rs.getString("SHORT_DESC1"));
		}

		if(rs!=null) rs.close();
		pstmt.close();
	}

	sql="SELECT SHORT_NAME  SHORT_NAME1 FROM AM_PRACTITIONER_LANG_VW where LANGUAGE_ID='"+locale+"' AND PRACTITIONER_ID=?";

	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,strSurgeonCode);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strSurgeonName=CommonBean.checkForNull(rs.getString("SHORT_NAME1"));
	}
	if(rs!=null) rs.close();
	pstmt.close();

	sql="SELECT EPISODE_TYPE EPISODE_TYPE1 FROM MP_EPISODE_TYPE_VW where PATIENT_CLASS=?";

	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,strPatientClass);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strEpisodeType=CommonBean.checkForNull(rs.getString("EPISODE_TYPE1"));
	}
	if(rs!=null) rs.close();
	pstmt.close();
	sql="SELECT INTRA_ANAESTHESIA_CHART_ID CHART_ID FROM AT_PARAM";
	pstmt=conn.prepareCall(sql);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		chartId=CommonBean.checkForNull(rs.getString("CHART_ID"));
	}
	if(rs!=null) rs.close();
	pstmt.close();

	if(strBMI.length()>0)
	{
		sql="SELECT STATUS_DESC  STATUS_DESC1 from AT_BMI_ANALYSIS WHERE ? BETWEEN MIN_VALUE AND MAX_VALUE";

		pstmt=conn.prepareCall(sql);
		pstmt.setString(1,strBMI);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			strBMIDesc=CommonBean.checkForNull(rs.getString("STATUS_DESC1"));
		}
		if(rs!=null) rs.close();
			pstmt.close();
	}

	if(!(strAnaesthesiaCode.equals("null")) && !(strAnaesthesiaCode.equals("")))
	{
		String sql_anaes="SELECT SHORT_DESC SHORT_DESC1  FROM AM_ANAESTHESIA_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ANAESTHESIA_CODE=? ";

		pstmt=conn.prepareCall(sql_anaes);
		pstmt.setString(1,strAnaesthesiaCode);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			strAnaesthesiaDesc=CommonBean.checkForNull(rs.getString("SHORT_DESC1"));
		}
		if(rs!=null) rs.close();
			pstmt.close();
	}

		String sql_anaes="SELECT OPER_NUM OPER_NUM1 FROM OT_POST_OPER_HDR WHERE ORDER_ID =? ";

		pstmt=conn.prepareCall(sql_anaes);
		pstmt.setString(1,strSourceOrderId);
		rs=pstmt.executeQuery();
		while(rs!=null && rs.next())
		{	tot_rec++;
			accession_num=CommonBean.checkForNull(rs.getString("OPER_NUM1"));
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	  }
}catch(Exception ee){
	ee.printStackTrace();
	//System.err.println("Exception in IntraAnaesHeader="+ee);
}
finally{
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(resultSet!=null) resultSet.close();
		if(stmt!=null) stmt.close();
		if(resultSet1!=null) resultSet1.close();
		if(stmt1!=null) stmt1.close();
		ConnectionManager.returnConnection(conn,request);
	}catch(Exception es){es.printStackTrace();}
}


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strName));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strSex));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strAge));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strSurgeryDate));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strPatientClassDesc));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strIntraopDone_check));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strIntraopDoneYN));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strSurgeryDate));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(intra_disable_flag));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strAnesthesiaSrlNo));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strPatientClass));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(chartId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strStatus));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(current_date));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(current_time));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block32Bytes, _wl_block32);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.IntraAnaesthesiaCompleted.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
