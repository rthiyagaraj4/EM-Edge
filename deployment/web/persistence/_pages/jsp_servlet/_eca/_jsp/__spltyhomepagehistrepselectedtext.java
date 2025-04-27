package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __spltyhomepagehistrepselectedtext extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SpltyHomePageHistRepSelectedText.jsp", 1709116365465L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/SpltyHomePageLinkRep.js\'></script>\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onScroll=\"scrollTitle1()\">\n<script language=javascript>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\t\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<form name=\"RecClinicalNotesLinkMedSelectedTextForm\" id=\"RecClinicalNotesLinkMedSelectedTextForm\">\n\t\t<div id=\'divDataTitle\' style=\'postion:relative\'>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<table border=\"1\" id=\"finalDiv1\"  cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n\t\t\t<tr>\n\t\t\t\t<td class=\'columnheader\'  width=\"20%\" style=\"font-size:10\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t<td class=\'columnheader\' width=\"25%\" style=\"font-size:10\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t<td class=\'columnheader\'  width=\"55%\" style=\"font-size:10\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t</div>\n\t<div id=\'inhtml\'>\n\n\t<table border=\"1\" id=\"finalDiv\"  cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t\t\t\t\t\t<input type=\"hidden\" name=\"event_datetime_str";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" id=\"event_datetime_str";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"> \n\t\t\t\t\t\t<input type=\"hidden\" name=\"contr_sys_id";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" id=\"contr_sys_id";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"> \n\t\t\t\t\t\t<input type=\"hidden\" name=\"contr_sys_event_code";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"contr_sys_event_code";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"> \n\t\t\t\t\t\t<input type=\"hidden\" name=\"accession_num";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"accession_num";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"> \n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t                    <td  class=\'CAHIGHERLEVELCOLOR\' width=\"20%\">\n\t\t\t\t\t\t\t\t\t<font size=2>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</font>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td  class=CAHIGHERLEVELCOLOR width=\"25%\">&nbsp;</td>\t\n\t\t\t\t\t\t\t\t<td class=CAHIGHERLEVELCOLOR width=\"55%\" >&nbsp;</td>\t\n\t\t\t\t\t\t\t\t</tr>           \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\n\t\t\t\t\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td   class=CAGROUP>&nbsp;</td>\t\n\t\t\t\t\t\t\t<td   class=CAGROUP  >\n\t\t\t\t\t\t\t\t<font size=2>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td   class=CAGROUP>&nbsp;</td> \n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' >\n\t\t\t\t\t\t<font size=2>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</font></td><td  class=CAFOURTHLEVELCOLOR ><font size=2>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</font></td>\n\t\t\t\t\t\t<td   class=CAFOURTHLEVELCOLOR><font size=2>\n\t\t\t\t    ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t(";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="-";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =")\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&nbsp; \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" <br>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =":<br>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&nbsp;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t   </font></td>\n\t\t\t\t   </tr>\n\t\t\t\n\t\t\t\t\t ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\t\n\n</table>\n</div>\n<input type=\"hidden\" name=\"temp\" id=\"temp\" value=\"\">\n<input type=\"hidden\" name=\"count\" id=\"count\" value=\"\">\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n<input type=\"hidden\" name=\"temptext\" id=\"temptext\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"> \n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"> \n<input type=\"hidden\" name=\"hist_rec_type\" id=\"hist_rec_type\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"> \n<input type=\"hidden\" name=\"module_id\" id=\"module_id\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"> \n<input type=\"hidden\" name=\"cycle_no\" id=\"cycle_no\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"> \n<input type=\"hidden\" name=\"keyRef\" id=\"keyRef\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"> \n<input type=\"hidden\" name=\"Rcount\" id=\"Rcount\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"> \n</form>\n</body>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n<script>returnDataApprove_df();</script>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

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
            webbeans.eCommon.RecordSet PatientCareBean= null;synchronized(session){
                PatientCareBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("PatientCareBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(PatientCareBean==null){
                    PatientCareBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("PatientCareBean",PatientCareBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	String  patient_id				= "";
	String  module_id				= "";
	String  check				= "";
	String  cycle_no				= "";
	String  keyRef				= "";
    String  hist_rec_type			= "";
	String  event_date_str			= "";
    String  event_date_str_prev		= "";
    String  event_group_desc		= "";
    String  event_group_desc_prev	= "";
    String  event_time_str			= "";
    String  event_desc				= "";
    String  result_num				= "";
    String  result_num_uom			= "";
    String  normalcy_str			= "";
	String  normalcy				= "";
    String  normal_low_value_str	= "";
    String  normal_high_value_str	= "";
    String  result_str				= "";
    String  hist_data_type			= "";
    String  hist_data_exists		= "";
	String  ret_str					= "";
	String  temp					= "";
	String  flag					= "";
    String return_format			= "";
	String strsql1					= "";
	String contr_sys_id					= "";
	String event_datetime_str					= "";
	String contr_sys_event_code					= "";
	String accession_num					= "";
	int count=0;
	
	Clob  hist_data	 = null;

	StringBuffer textFormat		=	new StringBuffer("");
	StringBuffer displaydata	=	new StringBuffer();
	
	int k=0;

	return_format		=	(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");
    flag				=	(request.getParameter("flag")==null)?"":request.getParameter("flag");
	patient_id			=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");
	hist_rec_type		=	(request.getParameter("hist_rec_type")==null)	?	""	:	request.getParameter("hist_rec_type");	
	module_id		=	(request.getParameter("module_id")==null)	?	""	:	request.getParameter("module_id");	
	cycle_no		=	(request.getParameter("cycle_no")==null)	?	""	:	request.getParameter("cycle_no");	
	keyRef		=	(request.getParameter("keyRef")==null)	?	""	:	request.getParameter("keyRef");	
	check		=	(request.getParameter("check")==null)	?	""	:	request.getParameter("check");	




	
	if(!flag.equals("f"));
	    ret_str=(request.getParameter("ret_str")==null)?"":request.getParameter("ret_str"); 
    
	ret_str=ret_str.substring(1,ret_str.length());

	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	
            _bw.write(_wl_block7Bytes, _wl_block7);

		if(!ret_str.equals(""))
		{
			
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

		}
	
            _bw.write(_wl_block12Bytes, _wl_block12);

		try
		{
			if(!flag.equals("f"))
			{
			if(ret_str!=null || (!ret_str.equals(" ")))
			{
				StringTokenizer strtCodes = new StringTokenizer(ret_str,",");
				
				con =  ConnectionManager.getConnection(request);
				
				//strsql1="SELECT TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY HH24:MI') EVENT_DATETIME_STR,TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY') EVENT_DATE_STR,TO_CHAR(A.EVENT_DATE,'HH24:MI') EVENT_TIME_STR,A. EVENT_DATE EVENT_DATETIME,TRUNC(A.EVENT_DATE) EVENT_DATE,C.LONG_DESC EVENT_GROUP_DESC,C.EVENT_GROUP,B.LONG_DESC EVENT_DESC, B.EVENT_CODE, A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' ' RESULT_NUM,RESULT_NUM_UOM,(SELECT DECODE(A.NORMALCY_IND,HIGH_STR,'ABNORMAL',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') FROM CR_CLIN_EVENT_PARAM) Normalcy_Str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low_value_str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) Normal_high_value_str,(SELECT HIST_DATA FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,A.FACILITY_ID,(SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA_EXISTS,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.CONTR_SYS_ID,A.ACCESSION_NUM,A.CONTR_SYS_EVENT_CODE,A.ROWID ROW_ID FROM CR_ENCOUNTER_DETAIL A,CR_CLIN_EVENT_MAST B ,CR_CLIN_EVENT_GROUP C WHERE B.HIST_REC_TYPE=A.HIST_REC_TYPE AND B.EVENT_CODE=A.EVENT_CODE and  B.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  AND C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE AND C.EVENT_GROUP(+)=A.EVENT_GROUP AND A.PATIENT_ID=? AND A.HIST_REC_TYPE =? AND A.ROWID=? ORDER BY a.REQUEST_NUM_SEQ,5,7,6,9,8,3 ";				
				strsql1="SELECT TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY HH24:MI') EVENT_DATETIME_STR,TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY') EVENT_DATE_STR,TO_CHAR(A.EVENT_DATE,'HH24:MI') EVENT_TIME_STR,A. EVENT_DATE EVENT_DATETIME,TRUNC(A.EVENT_DATE) EVENT_DATE,CONTR_SYS_ID,CONTR_SYS_EVENT_CODE,C.LONG_DESC EVENT_GROUP_DESC,C.EVENT_GROUP,B.LONG_DESC EVENT_DESC, B.EVENT_CODE, A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' ' RESULT_NUM,RESULT_NUM_UOM,(SELECT A.NORMALCY_IND FROM CR_CLIN_EVENT_PARAM) Normalcy_Str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low_value_str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) Normal_high_value_str,(SELECT HIST_DATA FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,A.FACILITY_ID,(SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA_EXISTS,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.CONTR_SYS_ID,A.ACCESSION_NUM,A.CONTR_SYS_EVENT_CODE,A.ROWID ROW_ID FROM 	CR_ENCOUNTER_DETAIL A,CR_CLIN_EVENT_MAST B ,CR_CLIN_EVENT_GROUP C WHERE 	B.HIST_REC_TYPE=A.HIST_REC_TYPE AND 	B.EVENT_CODE=A.EVENT_CODE and B.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  AND 	C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE 	AND 	C.EVENT_GROUP(+)=A.EVENT_GROUP 	AND 	A.PATIENT_ID=? 	AND 	A.HIST_REC_TYPE =? 	AND 	A.ROWID=? 	ORDER BY a.REQUEST_NUM_SEQ,5,7,6,9,8,3";
				stmt = con.prepareStatement(strsql1);

				String formet	=	"";

				count=0;
				while(strtCodes.hasMoreTokens())
				{
					
					if(strtCodes.hasMoreElements())
						temp= (String) strtCodes.nextToken();
					count++;
			
					stmt.setString(1,patient_id);
					stmt.setString(2,hist_rec_type);
					stmt.setString(3,temp);
					rs = stmt.executeQuery();
					
					while(rs!=null && rs.next())
					{
						 event_date_str			=		rs.getString("EVENT_DATE_STR")==null?"":rs.getString("EVENT_DATE_STR");
						 event_datetime_str			=		rs.getString("EVENT_DATETIME_STR")==null?"":rs.getString("EVENT_DATETIME_STR");
						 event_group_desc		=		rs.getString("EVENT_GROUP_DESC")==null?"":rs.getString("EVENT_GROUP_DESC");
						 event_time_str			=		rs.getString("EVENT_TIME_STR")==null?"":rs.getString("EVENT_TIME_STR");
						 event_desc				=		rs.getString("EVENT_DESC")==null?"":rs.getString("EVENT_DESC");
						 result_num				=		rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM");
						 result_num_uom			=		rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM");
					     //normalcy_str			=		rs.getString("Normalcy_Str")==null?"":rs.getString("Normalcy_Str");
						 normalcy				=		rs.getString("Normalcy_Str")==null?"":rs.getString("Normalcy_Str");
						 hist_data_type			=		rs.getString("HIST_DATA_TYPE")==null?"":rs.getString("HIST_DATA_TYPE");
						 normal_low_value_str	=		rs.getString("normal_low_value_str")==null?"0":rs.getString("normal_low_value_str");
						 normal_high_value_str	=		rs.getString("normal_high_value_str")==null?"0":rs.getString("normal_high_value_str");		
						 result_str				=		rs.getString("RESULT_STR")==null?"":rs.getString("RESULT_STR");
						 hist_data				=		rs.getClob("HIST_DATA");
						 hist_data_exists		=		rs.getString("HIST_DATA_EXISTS")==null?"":rs.getString("HIST_DATA_EXISTS");

						contr_sys_id=rs.getString("CONTR_SYS_ID")==null?"":rs.getString("CONTR_SYS_ID");
						contr_sys_event_code=rs.getString("CONTR_SYS_EVENT_CODE")==null?"":rs.getString("CONTR_SYS_EVENT_CODE");
						accession_num=rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
						
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(count));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(count));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(event_datetime_str));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(count));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(count));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(contr_sys_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(count));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(count));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(contr_sys_event_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(count));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block22Bytes, _wl_block22);





						 //
							if  (normalcy.equals("HIGH_STR"))
								normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels");										
							else if(normalcy.equals("LOW_STR"))
								normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels");
							else if(normalcy.equals("ABN_STR"))
								normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels");
							else if(normalcy.equals("CRIT_STR"))
								normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticallyAbnormal.label","or_labels");
							else if(normalcy.equals("CRIT_HIGH_STR"))
								normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticallyAbnormal.label","or_labels");
							else if(normalcy.equals("CRIT_LOW_STR"))
								normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticallyAbnormal.label","or_labels");
						 //
						 int normal_low_value=(int)Float.parseFloat(normal_low_value_str);
						 normal_low_value_str=String.valueOf(normal_low_value);
						 int normal_high_value=(int)Float.parseFloat(normal_high_value_str);
						 normal_high_value_str=String.valueOf(normal_high_value);
		 
						 displaydata.setLength(0);
						
						 if(hist_data!=null)
						 {
							java.io.BufferedReader r = new java.io.BufferedReader(hist_data.getCharacterStream());
							String line = null;
					
							while((line=r.readLine()) != null) 
							{
								displaydata.append(line+"\n");
							}
						 }
			
						 formet = "";
		
						if(return_format.equals("TEXT"))
							formet="\n";
						else
							formet="<br>";
		
						textFormat.append(formet);

						if(!event_date_str_prev.equals(event_date_str))
						{
							textFormat.append(event_date_str);
							textFormat.append(formet);
							
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(event_date_str));
            _bw.write(_wl_block24Bytes, _wl_block24);

							
							event_group_desc_prev="";
						}

						if(!event_group_desc_prev.equals(event_group_desc))
						{
							if(return_format.equals("TEXT"))
						    {	
								textFormat.append("             "+event_group_desc);
								textFormat.append(formet);
							}
							else
							{	
								textFormat.append("                 "+event_group_desc);
								textFormat.append(formet);	
							}
							
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(event_group_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);

						}
						
            _bw.write(_wl_block27Bytes, _wl_block27);

							if(return_format.equals("TEXT"))
								textFormat.append("              "+event_time_str+"                 "+event_desc+" "+result_num+" "+result_num_uom+" "+ normalcy_str+" ");				                   			   		
							else
								textFormat.append("   "+event_time_str+"                           "+event_desc+" "+result_num+" "+result_num_uom+" "+ normalcy_str+" ");
						
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((hist_data_type.equals("HTM")?"OAYELLOW":"CAFOURTHLEVELCOLOR")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(event_time_str));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(event_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);


					if (hist_data_type.equals("NUM"))
					{
						
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(result_num));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(result_num_uom));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(normalcy_str));
            _bw.write(_wl_block35Bytes, _wl_block35);

						 
					    if(!normal_low_value_str.equals("0") && !normal_high_value_str.equals("0"))
						{
							textFormat.append("("+normal_low_value_str+"-"+normal_high_value_str+") ");
						 
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(normal_low_value_str));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(normal_high_value_str));
            _bw.write(_wl_block38Bytes, _wl_block38);

						}
						if (!result_str.equals(""))
						{
							
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(result_str));
            _bw.write(_wl_block39Bytes, _wl_block39);
 
								textFormat.append("   "+result_str+"  ");
						}
						
						if(hist_data_exists.equals("Y"))
						{
							   
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(displaydata.toString()));
            _bw.write(_wl_block42Bytes, _wl_block42);

						}
					 }
					 else if (hist_data_type.equals("STR") || hist_data_type.equals("HTM") )
					 {
						 
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(result_str));
            _bw.write(_wl_block44Bytes, _wl_block44);
 
							textFormat.append("   "+result_str+"  ");
							
							if(hist_data_exists.equals("Y"))
							{
								
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(displaydata.toString()));
            _bw.write(_wl_block45Bytes, _wl_block45);

							}
					 }

					 if(hist_data_exists.equals("Y"))
					 {
						if (hist_data_type.equals("TXT"))
								textFormat.append(displaydata.toString()+formet); 	
						else if(hist_data_type.equals("STR"))
						    textFormat.append(formet+"Comment:"+displaydata.toString()+formet); 
					 }
					
					 
            _bw.write(_wl_block46Bytes, _wl_block46);

					 k++;
					 event_date_str_prev=event_date_str;
					 event_group_desc_prev=event_group_desc;
				}

				if(rs!=null) rs.close();	
		}
			
	}
}

if(stmt!=null)stmt.close();		 	

}
	
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception cauight in RecClinicalNotesLinkHistRepSelectedText.jsp" + e);//COMMON-ICN-0181
}
finally 
{
	
	if(con!=null)ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block47Bytes, _wl_block47);

String cat="";
if(!return_format.equals("TEXT"))
{
	cat = "<font size=2>"+textFormat.toString()+"</font>";

}
else
{
cat = textFormat.toString();
}

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(cat));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(hist_rec_type));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(keyRef));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(count));
            _bw.write(_wl_block55Bytes, _wl_block55);
if(check.equals("xyz")){
            _bw.write(_wl_block56Bytes, _wl_block56);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Event.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Comment.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Comment.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
