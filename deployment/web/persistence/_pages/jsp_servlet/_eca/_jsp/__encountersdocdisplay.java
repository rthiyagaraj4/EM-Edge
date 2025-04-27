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

public final class __encountersdocdisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncountersDocDisplay.jsp", 1741273021440L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" Details</title>\n\t ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link> \n\t<script src=\'../../eCA/js/Encounters.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<style>\n\tPRE\n\t{\n\t\tfont-size: 8pt ;\n\t\tFont-Family : Courier New;\n\t\tBACKGROUND-COLOR: #E2E3F0;\n\t\tBORDER-STYLE: none;\n\t\tfontWeight : bold;\n\t\ttext-align: left;\n\t\tWORD-WRAP: break-word\n\t}\t\t\t\t\t\t\t\n\n\t</style>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<style>\n\t\tADDRESS\t{ FONT-FAMILY: Courier ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }\n\t</style>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<style>\n\t\tADDRESS\t{ FONT-FAMILY: Arial ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }\n\t</style>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</head>\n\n<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</p>\n<form name=\"detail_form\" id=\"detail_form\">\n\t<input type=\"hidden\" name=\"qs\" id=\"qs\" value=\"hist_type=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&accession_num=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&event_desc=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&data_type=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&from=B&contr_sys_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&contr_sys_event_code=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=\"hidden\" name=\"facility_name\" id=\"facility_name\"\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=\"hidden\" name=\"specialty_name\" id=\"specialty_name\"\tvalue=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\"hidden\" name=\"patient_line\" id=\"patient_line\"\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\"hidden\" name=\"site_name\" id=\"site_name\"\tvalue=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\"hidden\" name=\"accession_num\" id=\"accession_num\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<input type=\"hidden\" name=\"location\" id=\"location\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<input type=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=\"hidden\" name=\"dischargeDateTime\" id=\"dischargeDateTime\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=\"hidden\" name=\"facility_disp_name\" id=\"facility_disp_name\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\"hidden\" name=\"authorizedBy\" id=\"authorizedBy\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<input type=\"hidden\" name=\"printDateTime\" id=\"printDateTime\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t<input type=\"hidden\" name=\"attending_practitioner\" id=\"attending_practitioner\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type=\"hidden\" name=\"nationality_legend\" id=\"nationality_legend\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t<input type=\"hidden\" name=\"nationality_id\" id=\"nationality_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t<input type=\"hidden\" name=\"discharge_summary_text\" id=\"discharge_summary_text\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t<input type=\"hidden\" name=\"referral_letter_summary\" id=\"referral_letter_summary\"\t\tvalue=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\n<!-- <div id=\'data\' style=\'position:absolute; width:0%; visibility:hidden;\' border=\'0\' width=\'0\'> -->\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\n<div id=\'data\' style=\'display:none;\' border=\'0\' width=\'0\'>\n\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\n</div>\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n</html>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	PreparedStatement pstmt = null;

	String resp_id				= (String)session.getValue("responsibility_id");

	String location					= "";
	String attending_practitioner	= "";
	String nationality_id			= "",			nationality_legend	=	"";
	String accessionnum				= "";
	String printDateTime			= "",			dischargeDateTime	=	"",			authorizedBy	=	"";
	String query_privilege_type		= "";
	String encounter_id				= "",			episode_type		=	"";
	String discharge_summary_text	= "",			referral_letter_text=	"";

	String eventdesc			= request.getParameter("event_desc")==null?"":request.getParameter("event_desc");
	String from					= request.getParameter("from")==null?"":request.getParameter("from");
	String patient_line			= request.getParameter("patient_line")==null?"":request.getParameter("patient_line");
	String facility_name		= request.getParameter("facility_name")==null?"":request.getParameter("facility_name");
	String specialty_name		= request.getParameter("specialty_name")==null?"":request.getParameter("specialty_name");
	String visit_adm_date		= request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");

	if(resp_id == null)resp_id ="";
	
	String facility_id = (request.getParameter("facility_id")==null)?"":request.getParameter("facility_id");
	String histrectype = (request.getParameter("hist_type")==null?"":request.getParameter("hist_type"));


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(eventdesc));
            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
if (histrectype.equals("LBIN")) {
            _bw.write(_wl_block9Bytes, _wl_block9);
}else{
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);

	if( from.equals("A") || from.equals("DISCHARGE_SUMMARY") )
	{
		String buttonValue	=	from.equals("A") ? com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Zoom.label","ca_labels") : com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels");
		String callFunction	=	from.equals("A") ? "showinModal()" : "modalForPrint()";
		out.println("<table cellpadding=3 cellspacing=0 border=0 width='100%' align=center>");
		out.println("<tr><td colspan =4 width = 100% align = right><input type='button' class=button onClick=\""+callFunction+"\" value=\""+buttonValue+"\"></td></tr></table>");
		out.println("<br>");
	
	}

	Connection con  = null;
	PreparedStatement pstmt1=null;
	ResultSet rs		  = null;
	
	accessionnum =  request.getParameter("accession_num");
	
	if(accessionnum!=null)
		accessionnum = java.net.URLDecoder.decode( accessionnum );
	else
		accessionnum = "";
	
	String datatype = request.getParameter("data_type")==null?"":request.getParameter("data_type");
	datatype=java.net.URLDecoder.decode(datatype);
	
	String contr_sys_id = request.getParameter("contr_sys_id")==null?"":request.getParameter("contr_sys_id");
	contr_sys_id=java.net.URLDecoder.decode(contr_sys_id);
	
	String contr_sys_event_code = request.getParameter("contr_sys_event_code")==null?"":request.getParameter("contr_sys_event_code");
	contr_sys_event_code=java.net.URLDecoder.decode(contr_sys_event_code);
	
	StringBuffer displaydata = new StringBuffer();
	StringBuffer dispdata = new StringBuffer();
	
	
	String site_name = "";
	String newLine="\n";

	if(from.equals("CN"))
		newLine="<BR>";	

	try
	{
		con  = ConnectionManager.getConnection(request);

		if(from.equals("DISCHARGE_SUMMARY"))
		{
			pstmt =	con.prepareStatement("select site_name from sm_site_param");

			try
			{
				rs	=	pstmt.executeQuery();

				if(rs.next())
					site_name	=	rs.getString("site_name")==null?"":rs.getString("site_name");

				if(pstmt!=null)	pstmt.close();
			}
			catch(Exception e)
			{
				//out.println("Exception@2: "+e);//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
			}			
		}		

		StringTokenizer strTknSysId = new StringTokenizer(contr_sys_id,"','");
		StringTokenizer strTknAccNo = new StringTokenizer(accessionnum,"','");
		StringTokenizer strTknSysEvent = new StringTokenizer(contr_sys_event_code,"','");
		
		String contr_sys_id_curr="";
		String accessionnum_curr="";
		String contr_sys_event_code_curr="";

		while(strTknAccNo.hasMoreTokens())
		{
			StringBuffer sqltxt=new StringBuffer();

			contr_sys_id_curr			= strTknSysId.nextToken();			
			accessionnum_curr			= strTknAccNo.nextToken();			
			contr_sys_event_code_curr	= strTknSysEvent.nextToken();

			if(histrectype.equals("CLNT"))
			{
				//sqltxt.append(" select null DIS_SUMM_DISCLAIMER_TXT,null  REF_LETTER_DISCLAIMER_TXT, b.hist_data,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,(select SHORT_NAME from am_practitioner where practitioner_id=a.PERFORMED_BY_ID) authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,dEcode(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,(select FACILITY_NAME from sm_facility_param where facility_id=a.facility_id) facility_name,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT  from cr_encounter_detail a,cr_encounter_detail_txt b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and a.CONTR_SYS_ID=b.CONTR_SYS_ID   and a.ACCESSION_NUM=b.ACCESSION_NUM and a.CONTR_SYS_EVENT_CODE=b.CONTR_SYS_EVENT_CODE and b.hist_rec_type = ? and a.contr_sys_id =? and b.accession_num=? and a.contr_sys_event_code =? ");

				sqltxt.append("select null DIS_SUMM_DISCLAIMER_TXT,null  REF_LETTER_DISCLAIMER_TXT, b.hist_data,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,AM_GET_DESC.AM_PRACTITIONER(A.PERFORMED_BY_ID,?,'2') authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,DECODE(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,SM_GET_DESC.SM_FACILITY_PARAM(A.FACILITY_ID,?,'1') facility_name,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT  from cr_encounter_detail a,cr_encounter_detail_txt b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and a.CONTR_SYS_ID=b.CONTR_SYS_ID   and a.ACCESSION_NUM=b.ACCESSION_NUM and a.CONTR_SYS_EVENT_CODE=b.CONTR_SYS_EVENT_CODE and b.hist_rec_type = ? and a.contr_sys_id =? and b.accession_num=? and a.contr_sys_event_code =?");
			}
			else
			{
				/*sqltxt.append(" select TO_CHAR(NULL) DIS_SUMM_DISCLAIMER_TXT ,TO_CHAR(NULL) REF_LETTER_DISCLAIMER_TXT , b.long_desc,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT , A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' '||RESULT_NUM_UOM||' '||(select decode(a.normalcy_ind,HIGH_STR,'Abnormal',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') from cr_clin_event_param)||' '||replace('('||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' - '||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||')','( - )',null) RESULT_NUM,(SELECT CA_CLOB_REPLACE(hist_data,chr(10),'"+newLine+"'");
								
				if(from.equals("CN"))
					sqltxt.append("||CHR(10)");
				
				sqltxt.append( "  ) FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,(select SHORT_NAME from am_practitioner where practitioner_id=a.PERFORMED_BY_ID) authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,dEcode(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,(select FACILITY_NAME from sm_facility_param where facility_id=a.facility_id) facility_name  from cr_encounter_detail a,cr_clin_event_mast b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and b.event_code=a.event_code and a.hist_rec_type = ? and a.contr_sys_id =? and a.accession_num=? and a.contr_sys_event_code =? ");
				*/

				sqltxt.append(" select TO_CHAR(NULL) DIS_SUMM_DISCLAIMER_TXT ,TO_CHAR(NULL) REF_LETTER_DISCLAIMER_TXT , b.long_desc,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT , A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' '||RESULT_NUM_UOM||' '||(select decode(a.normalcy_ind,HIGH_STR,'Abnormal',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') from cr_clin_event_param)||' '||replace('('||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' - '||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||')','( - )',null) RESULT_NUM,(SELECT CA_CLOB_REPLACE(hist_data,chr(10),'"+newLine+"'");

				if(from.equals("CN"))
					sqltxt.append("||CHR(10)");
				
				sqltxt.append( "  ) FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,(select SHORT_NAME from am_practitioner where practitioner_id=a.PERFORMED_BY_ID) authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,dEcode(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,(select FACILITY_NAME from sm_facility_param where facility_id=a.facility_id) facility_name  from cr_encounter_detail a,cr_clin_event_mast b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and b.event_code=a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type = ? and a.contr_sys_id =? and a.accession_num=? and a.contr_sys_event_code =?  ");
			}

			

			pstmt1 = con.prepareStatement(sqltxt.toString());
			
			if(histrectype.equals("CLNT"))
			{
				pstmt1.setString(1,locale);
				pstmt1.setString(2,locale);
				pstmt1.setString(3,histrectype);
				pstmt1.setString(4,contr_sys_id_curr);
				pstmt1.setString(5,accessionnum_curr);
				pstmt1.setString(6,contr_sys_event_code_curr);
			}
			else
			{
				pstmt1.setString(1,histrectype);
				pstmt1.setString(2,contr_sys_id_curr);
				pstmt1.setString(3,accessionnum_curr);
				pstmt1.setString(4,contr_sys_event_code_curr);
			}
			rs = pstmt1.executeQuery();			

			if(histrectype.equals("CLNT"))
			{
				while (rs.next())
				{
					Clob clb = rs.getClob("hist_data");
					facility_id = rs.getString("FACILITY_ID")==null?"":rs.getString("FACILITY_ID");
					encounter_id = rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
					printDateTime = rs.getString("print_datetime")==null?"":rs.getString("print_datetime");
					nationality_id = rs.getString("NATIONAL_ID_NO")==null?"":rs.getString("NATIONAL_ID_NO");
					nationality_legend = rs.getString("NAT_ID_PROMPT")==null?"":rs.getString("NAT_ID_PROMPT");
					authorizedBy = rs.getString("authorized_by_name")==null?"":rs.getString("authorized_by_name");

					episode_type = rs.getString("episode_type")==null?"":rs.getString("episode_type");
					facility_name = rs.getString("facility_name")==null?"":rs.getString("facility_name");
					discharge_summary_text = rs.getString("DIS_SUMM_DISCLAIMER_TXT")==null?"":rs.getString("DIS_SUMM_DISCLAIMER_TXT");
					referral_letter_text = rs.getString("REF_LETTER_DISCLAIMER_TXT")==null?"":rs.getString("REF_LETTER_DISCLAIMER_TXT");

					if(discharge_summary_text == null) 
						discharge_summary_text = "";

					if(referral_letter_text == null) 
						referral_letter_text = "";

					if( (clb!=null) && (clb.length()>0) )
						displaydata.append( clb.getSubString( 1, ((int)clb.length()) ) );						
				}
				if(rs != null)rs.close();
				if(pstmt1 != null)pstmt1.close();	 
			
			}
			else
			{
				String longDesc ="";
				String histDataType ="";
				String resutStr ="";
				String resultNum ="";

				while (rs.next())
				{
					
					longDesc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
					histDataType= rs.getString("HIST_DATA_TYPE")==null?"":rs.getString("HIST_DATA_TYPE");
					resutStr = rs.getString("RESULT_STR")==null?"":rs.getString("RESULT_STR");
					resultNum= rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM");

					Clob clb = rs.getClob("hist_data");
					nationality_id = rs.getString("NATIONAL_ID_NO")==null?"":rs.getString("NATIONAL_ID_NO");
					nationality_legend = rs.getString("NAT_ID_PROMPT")==null?"":rs.getString("NAT_ID_PROMPT");
					facility_id = rs.getString("FACILITY_ID")==null?"":rs.getString("FACILITY_ID");
					encounter_id = rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
					printDateTime = rs.getString("print_datetime")==null?"":rs.getString("print_datetime");
					authorizedBy = rs.getString("authorized_by_name")==null?"":rs.getString("authorized_by_name");
					
					episode_type = rs.getString("episode_type")==null?"":rs.getString("episode_type");
					facility_name = rs.getString("facility_name")==null?"":rs.getString("facility_name");

					
					if(!histDataType.equals("HTM"))
						displaydata.append(newLine+longDesc+":");

					if(histDataType.equals("NUM"))
					{
						displaydata.append(resultNum);
						if(!resutStr.equals(""))
						{
							displaydata.append(newLine+resutStr);
						}
					}
					else if(histDataType.equals("STR"))
					{
						displaydata.append(resutStr);
					}

					if( (clb!=null) && (clb.length()>0) )
					{
						displaydata.append(newLine);
						displaydata.append( clb.getSubString( 1, ((int)clb.length()) ) );						
					}
				}
             
			
				if(rs != null)rs.close();	 
					if(pstmt1 != null)pstmt1.close();	 
			}

		}//end of while(strTknAccNo.hasMoreTokens())		

		if(from.equals("A") || from.equals("B"))
		{
			//if(histrectype.equals("CLNT") || datatype.equals("HTM"))
			if( datatype.equals("HTM"))
				out.println(displaydata.toString());
			else
				out.println("<textarea  align='MIDDLE' readOnly style='FONT-FAMILY:Courier New;FONT-SIZE: 8pt' rows=24 cols=80>"+displaydata.toString()+"</textarea>");
			
                
			 
		}
		else
		{
			out.println(displaydata.toString());
					
			
		}

 	   if(	episode_type.equals("O") )
		{
			//query_privilege_type	=	"select to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,acc_entity_name facility_name, service_short_desc specialty_name,LOCN_NAME,(select SHORT_NAME from am_practitioner where practitioner_id=ca_op_episode_vw.PHYSICIAN_ID) attending_practitioner from ca_op_episode_vw where facility_id = ? and episode_id = ? ";
			query_privilege_type	=	"select to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(?,?,'1') facility_name,AM_GET_DESC.AM_SERVICE(service_code,?,'2')  specialty_name,OP_GET_DESC.OP_CLINIC(facility_id,LOCN_CODE,?,'1') LOCN_NAME,AM_GET_DESC.AM_PRACTITIONER(PHYSICIAN_ID,?,'2')  attending_practitioner from ca_op_episode_vw where facility_id = ? and episode_id = ? ";
		}
		else
		{
			//query_privilege_type	=	"select to_char(admission_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,facility_name, service_short_desc specialty_name,WARD_SHORT_DESC||'/'||CUR_ROOM_NUM||'/'||CUR_BED_NUM  LOCN_NAME,(select SHORT_NAME from am_practitioner where practitioner_id=ca_ip_active_episode_vw.CUR_PHYSICIAN_ID) attending_practitioner   from ca_ip_active_episode_vw where facility_id = ? and episode_id = ? ";
			query_privilege_type	=	"select to_char(admission_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(?,?,'1') facility_name, AM_GET_DESC.AM_SERVICE(SERVICE_CODE,?,'2') specialty_name,IP_GET_DESC.IP_NURSING_UNIT(?,CUR_WARD_CODE,?,'1')||'/'||CUR_ROOM_NUM||'/'||CUR_BED_NUM  LOCN_NAME,AM_GET_DESC.AM_PRACTITIONER(CUR_PHYSICIAN_ID,?,'2')  attending_practitioner   from ca_ip_active_episode_vw where facility_id = ? and episode_id = ?";
		}
			
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();




		pstmt	=	con.prepareStatement(query_privilege_type);

		pstmt.setString	(	1,	facility_id	);
		pstmt.setString	(	2,	locale	);
		pstmt.setString	(	3,	locale	);
		if(	episode_type.equals("O") )
		{
		pstmt.setString	(	4,	locale	);
		pstmt.setString	(	5,	locale	);
		pstmt.setString	(	6,	facility_id	);
		pstmt.setString	(	7,	encounter_id);
		}
		else
		{
		pstmt.setString	(	4,	facility_id	);
		pstmt.setString	(	5,	locale	);
		pstmt.setString	(	6,	locale	);
		pstmt.setString	(	7,	facility_id	);
		pstmt.setString	(	8,	encounter_id);
		}
		rs		=	pstmt.executeQuery();

		if(rs.next())
		{
			facility_name	=	rs.getString("facility_name")==null?"":rs.getString("facility_name");
			visit_adm_date	=	rs.getString("visit_adm_date")==null?"":rs.getString("visit_adm_date");
			specialty_name	=	rs.getString("specialty_name")==null?"":rs.getString("specialty_name");
			location		=	rs.getString("LOCN_NAME")==null?"":rs.getString("LOCN_NAME");
			dischargeDateTime= rs.getString("DISCHARGE_DATE_TIME")==null?"":rs.getString("DISCHARGE_DATE_TIME");
			attending_practitioner = rs.getString("attending_practitioner")==null?"":rs.getString("attending_practitioner");
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(dischargeDateTime==null){
			dischargeDateTime="";
		}
		if(nationality_id==null){
			nationality_id="";
		}
	
		if(nationality_legend==null){
			nationality_legend="";
		}
			
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(pstmt1!=null) pstmt1.close();
	
	}	catch(Exception e){
		e.printStackTrace();
		//out.println("Exception "+e);//COMMON-ICN-0181
	}
	finally {
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(histrectype));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLEncoder.encode(accessionnum)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(eventdesc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(datatype));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(contr_sys_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(contr_sys_event_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(from));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(specialty_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_line));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(site_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(accessionnum));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(location));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(dischargeDateTime));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(authorizedBy));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(printDateTime));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(attending_practitioner));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(nationality_legend));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(nationality_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(discharge_summary_text));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(referral_letter_text));
            _bw.write(_wl_block38Bytes, _wl_block38);

dispdata.append("<PRE style='word-wrap:break-word;margin-right:5%'>");
dispdata.append(displaydata.toString());
dispdata.append("</PRE>");

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(dispdata.append("<LINK href='../../eCommon/html/ "+ sStyle +" ' type=text/css rel=stylesheet></LINK>").toString()));
            _bw.write(_wl_block40Bytes, _wl_block40);


	//out.println("<h1>FROM : "+from);
	if(from.equals("CN"))
	{
		//out.println("<h1>FROM : "+from);

		out.println("<script>");
		//out.println("alert('inside returnDataa...');");
		//if(histrectype.equals("CLNT") || datatype.equals("HTM"))
		 if(datatype.equals("HTM"))
			out.println("var d = document.getElementById('data').innerHTML;");
		else
			out.println("var d = document.getElementById('data').innerText;");

		out.println("parent.window.returnValue = d;");
		out.println("parent.window.close();");
		out.println("</script>");
	}

            _bw.write(_wl_block41Bytes, _wl_block41);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
