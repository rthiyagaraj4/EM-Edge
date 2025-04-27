package jsp_servlet._ebt._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.util.*;
import com.ehis.util.*;

public final class __managelisspecimenimageuploadlinkforms extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebt/jsp/ManageLISSpecimenImageUploadLinkForms.jsp", 1709115156603L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\t\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="eCommon/html/IeStyle.css\' type=\'text/css\' />\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\' />\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script src=\"../../eBT/js/ManageLISSpecimenImage.js\" language=\"javascript\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t</head>\n\t<body>\n\t<!-- Below Line added by Sanjay for automatic refresh of this jsp, so that page gets refreshed after Delete -->\n\t<!-- <meta http-equiv=\"REFRESH\" content=\"3\" url=\"../../eBT/jsp/ManageLISSpecimenImageIntermediate.jsp\"> ManageLISSpecimenImageUploadLinkForms.jsp -->\n\t<!-- <meta http-equiv=\"REFRESH\" content=\"3\" url=\"../../eBT/jsp/ManageLISSpecimenImageUploadLinkForms.jsp\"> -->\n\n\t<form name=\'uploadLinkForm\' id=\'uploadLinkForm\'>\n\t<table border=\'1\' width=\'100%\' cellpadding=\'1\' cellspacing=\'0\' align=\'center\'>\n\t<tr>\n\t<td class=\'CAGROUP\' colspan=\'7\'>SpecimenNo ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t</tr>\t\t\t\t\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<tr>\n\t\t<th align=\'left\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\t\t\t\t\t\n\t\t<th align=\'left\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t<th align=\'left\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t<!-- Added by Sanjay on 13-04-2016 against IN059924 STARTS -->\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<th align=\'left\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t\t<th align=\'left\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\t\n\t\t\t<th align=\'left\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<tr>\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t<tr>\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</table>\n<input type=\'hidden\' name=\'p_resp_id\' id=\'p_resp_id\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<!--added calledFromForms by Sanjay for removing Delete Option when viewed from Review -->\n<input type=\'hidden\' name=\'calledFromForms\' id=\'calledFromForms\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block6Bytes, _wl_block6);


//System.out.println ("eBT ManageLISImageSpecimen  2 ");
Connection con = null;
PreparedStatement pstmtImgView = null;
PreparedStatement pstmtImgViewOthers = null;
PreparedStatement pstmt = null;
ResultSet res = null;
ResultSet resImgView = null;

//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016 STARTS
PreparedStatement pstmtSampleCount = null;
ResultSet resSampleCount = null;
int iSampleCount = 0;
//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016 ENDS

//Added by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
PreparedStatement pstmtIntervalTest = null;
ResultSet resIntervalTest = null;
PreparedStatement pstmtTestMasters = null;
ResultSet resTestMasters = null;
int recCountTestMasters = 0;

String test = "";
String testCode = "";
String sampleId = "";
String anatomy = "";
String anatomyCode = "";
String tissueDesc = "";
String anatomyInd = "";
String section_ind = "";
String oper_facilityId="";//Added by Nandhini against GHL-SCF-1354 on 26/June/2018
String specNum = "";//Added by Nandhini against GHL-SCF-1354 on 26/June/2018
int count = 0;
int recCount = 0;
String classValue = "QRYEVEN";

String calledFrom = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
String accessionNum = request.getParameter("Accessionnum") == null ? "" : request.getParameter("Accessionnum");
String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
String p_resp_id = request.getParameter("p_resp_id") == null ? "RL_MANAGER" : request.getParameter("p_resp_id");
String p_test_code = request.getParameter("p_test_code") == null ? "" : request.getParameter("p_test_code");
String test_code = request.getParameter("test") == null ? "" : request.getParameter("test"); //Added against ML-MMOH-SCF-1797 on 08/nov/2021 Starts
String colSpan = "1";
String applServerURL = "";
System.out.println("p_test_code ::"+p_test_code);
System.out.println("test_code ::"+test_code);

if(facilityId.equals(""))
facilityId = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");

if(!p_resp_id.equals("RL_MANAGER"))
	con = ConnectionManager.getConnection(request);
else if(p_resp_id.equals("RL_MANAGER"))
	con = ConnectionManager.getConnection();	
	
	

if(accessionNum.equals(""))
	specNum = request.getParameter("specNum") == null ? "0" : request.getParameter("specNum");

//Added by Nandhini against GHL-SCF-1354 on 26/June/2018 

			try
			{
			
			pstmt = con.prepareStatement("SELECT OPERATING_FACILITY_ID FROM rl_request_header where SPECIMEN_NO=? and ORDERED_FACILITY_ID=?");
			pstmt.setString(1,specNum);
			pstmt.setString(2,facilityId);
			res = pstmt.executeQuery();	
			System.out.println("res::"+res);	

			if(res.next()  )
			{
				oper_facilityId = res.getString("OPERATING_FACILITY_ID") == null ? "" : res.getString("OPERATING_FACILITY_ID");
				facilityId=oper_facilityId;
				System.out.println("ManageLISSpecimenImageServlet.java facilityId:" +facilityId);
			}
			
			}
			catch(Exception e1)
		{
			System.out.println("Ex1:"+e1);
			if(res != null) res.close();
			if(pstmt != null) pstmt.close();
//Added by Nandhini against GHL-SCF-1354 on 26/June/2018 
		}


//Added by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800) STARTS here
if(p_test_code.length()>0)
{
	String sqlTestMasters = "select count(*) from rl_test_code where test_code = ?";	
	pstmtTestMasters = con.prepareStatement(sqlTestMasters);	
	pstmtTestMasters.setString(1,p_test_code);
	resTestMasters = pstmtTestMasters.executeQuery();	
	recCountTestMasters = 0;
	while(resTestMasters.next())
	{
		recCountTestMasters = resTestMasters.getInt(1);		
	}	
	if(resTestMasters != null) resTestMasters.close();
	if(pstmtTestMasters != null) pstmtTestMasters.close();
	if(recCountTestMasters == 0)
		p_test_code = p_test_code.substring(0, p_test_code.length()-4);
}
//Added by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800) ENDS here

//String sqlSecInd = "SELECT section_ind, NVL(use_sample_anatomy_ind, '!!') anatomy_ind FROM RL_SECTION_CODE WHERE section_code = ?";
String sqlSecInd = "SELECT section_ind, NVL(use_sample_anatomy_ind, '!!') anatomy_ind FROM RL_SECTION_CODE_LANG_VW WHERE section_code = ? AND LANGUAGE_ID = ?";

//commented by Sanjay for ML-MMOH-CRF-0494[IN059242] on 31-03-2016
//String sql = "SELECT A.specimen_no, A.test_code, NULL sample_id, A.anatomy_site_code, A.tissue_desc_code, 		B.short_desc test_desc, C.short_desc anatomy_desc, D.short_desc tissue_desc FROM RL_SPECIMEN_ANATOMY_DTLS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE_LANG_VW C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ?   AND NVL(?, '!!') = 'AT'  AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code  AND C.LANGUAGE_ID = ? AND A.tissue_desc_code = D.tissue_desc_code(+) UNION SELECT A.specimen_no, A.test_code, A.sample_id, A.anatomy_site_code, A.tissue_desc_code, B.short_desc test_desc, C.short_desc anatomy_desc, D.short_desc tissue_desc FROM RL_SAMPLE_DETAILS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE_LANG_VW C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ? AND NVL(?, '!!') = 'SA' AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code AND C.LANGUAGE_ID = ? AND A.tissue_desc_code = D.tissue_desc_code(+)";

//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 31-03-2016
//removed two conditions (NVL(?, '!!') = 'SA') (NVL(?, '!!') = 'AT')
String sql = "SELECT A.specimen_no, A.test_code, NULL sample_id, A.anatomy_site_code, A.tissue_desc_code, 		B.short_desc test_desc, C.short_desc anatomy_desc, D.short_desc tissue_desc FROM RL_SPECIMEN_ANATOMY_DTLS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE_LANG_VW C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ? AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code  AND C.LANGUAGE_ID = ? AND A.tissue_desc_code = D.tissue_desc_code(+) UNION SELECT A.specimen_no, A.test_code, A.sample_id, A.anatomy_site_code, A.tissue_desc_code, B.short_desc test_desc, C.short_desc anatomy_desc, D.short_desc tissue_desc FROM RL_SAMPLE_DETAILS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE_LANG_VW C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ? AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code AND C.LANGUAGE_ID = ? AND A.tissue_desc_code = D.tissue_desc_code(+)";

if(p_test_code.length()>0)		sql= sql+" and  A.test_code = '"+p_test_code+"'";

sql= sql+" ORDER BY 3, 4";
//System.out.println("ManageLISSpecimenImageUploadLinkForms.jsp HI and CY sql:"+sql);//Sanjay
//System.out.println("ManageLISSpecimenImageUploadLinkForms.jsp test_code.length():"+test_code.length());

//Modified by Manoj S for ML-MMOH-SCF-1078 //

String sqlO = "SELECT DISTINCT a.specimen_no, c.test_code, b.short_desc test_desc FROM rl_request_detail a, rl_test_code_lang_vw b, rl_test_result c WHERE a.specimen_no = c.specimen_no AND a.operating_facility_id = c.operating_facility_id AND a.test_code = c.group_test_code AND c.test_code = b.test_code AND a.specimen_no = ? AND a.operating_facility_id = ? AND b.language_id = ?";

//Added by Mohanapriya against ML-MMOH-SCF-1797 on 08/nov/2021  & 19/nov/2021 & V220327 Starts
/* 
if(calledFrom.equalsIgnoreCase("RL_REVIEW") ){
	sqlO= sqlO+" order by 2";  
}else{
	if(test_code.length()>0) { sqlO= sqlO+"  and ( c.test_code = '"+test_code+"') order by 2";  } 
	else if(test_code.length()==0) { sqlO= sqlO+" and ( nvl(c.STATUS,'O') = 'O' or nvl(c.STATUS,'A') = 'A')  order by 2"; } 
}
*/
if(calledFrom.equalsIgnoreCase("RL_REVIEW") && (p_test_code.length()==0)){
	sqlO= sqlO+" order by 2";  
}
if(!(calledFrom.equalsIgnoreCase("RL_REVIEW"))){
	if(test_code.length()>0) { sqlO= sqlO+"  and ( c.test_code = '"+test_code+"') order by 2";  } 
	else if(test_code.length()==0) { sqlO= sqlO+" and ( nvl(c.STATUS,'O') = 'O' or nvl(c.STATUS,'A') = 'A')  order by 2"; } 
}

//Added by Mohanapriya against ML-MMOH-SCF-1797 on 08/nov/2021  & 19/nov/2021 & V220327 Ends 
if(p_test_code.length()>0)		sqlO= sqlO+" and  c.test_code = '"+p_test_code+"'order by 2";
System.out.println("ManageLISSpecimenImageUploadLinkForms.jsp Others sqlO:"+sqlO);//Sanjay
System.out.println("ManageLISSpecimenImageUploadLinkForms.jsp Others specNum:"+specNum);//Sanjay
System.out.println("ManageLISSpecimenImageUploadLinkForms.jsp Others calledFrom:"+calledFrom);//Sanjay

//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016 STARTS
String sqlSampleCount="SELECT SUM(CNT_1) FROM (SELECT COUNT(1) AS CNT_1 FROM RL_SPECIMEN_ANATOMY_DTLS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE_LANG_VW C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ? AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code  AND C.LANGUAGE_ID = ? AND A.tissue_desc_code = D.tissue_desc_code(+) UNION SELECT COUNT(1) AS CNT_1 FROM RL_SAMPLE_DETAILS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE_LANG_VW C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ? AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code AND C.LANGUAGE_ID = ? AND A.tissue_desc_code = D.tissue_desc_code(+)";

if(p_test_code.length()>0)		sqlSampleCount= sqlSampleCount+" and  A.test_code = '"+p_test_code+"'";

sqlSampleCount= sqlSampleCount+ ")";
//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016 ENDS

try
{
	pstmt = con.prepareStatement("SELECT APP_SERVER_URL FROM CA_EXT_INT_PARAM ");
	res = pstmt.executeQuery();
	while(res.next())
	{
		applServerURL = res.getString("APP_SERVER_URL") == null ? "" : res.getString("APP_SERVER_URL");
	}

	if(res != null) res.close();
	if(pstmt != null) pstmt.close();

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	//String specNum = "";////Commented by Nandhini against GHL-SCF-1354 on 26/June/2018 
	String eventCode = "";
	String contrSysEventCode = "";
	String secCode = "";

	if(accessionNum.equals(""))
	{
		specNum = request.getParameter("specNum") == null ? "0" : request.getParameter("specNum");
		secCode = request.getParameter("secCode") == null ? "" : request.getParameter("secCode");
		
		//if(secCode.length()==0) //commented by Sanjay against ML-BRU-SCF-1502(52800) on 02-Mar-15 to handle flow from CA module
		{
			pstmt = con.prepareStatement("select section_code from rl_request_header where specimen_no =?  and operating_facility_id = ?");
			pstmt.setString(1,specNum);
			pstmt.setString(2,facilityId);
			res = pstmt.executeQuery();

			while(res.next())
			{
				secCode = res.getString(1);
				secCode = secCode == null?"":secCode;

			}

		}

	}
	else
	{
		String sqlAccessionNum = "select event_code, CONTR_SYS_EVENT_CODE, SUBSTR (?, (INSTR (?, '#') + 1), ( (INSTR (?, '@') - 1) - INSTR (?, '#'))) spec_num from cr_encounter_detail where ACCESSION_NUM = ? ";

		if(p_test_code.length()>0)		sqlAccessionNum= sqlAccessionNum+" and  event_code = '"+p_test_code+"'";


		String sqlTestCode = "select test_code from rl_test_code where ORDER_CATALOG_CODE = ? ";

		if(p_test_code.length()>0)		sqlTestCode= sqlTestCode+" and  test_code = '"+p_test_code+"'";

		pstmt = con.prepareStatement(sqlAccessionNum);
		pstmt.setString(1,accessionNum);
		pstmt.setString(2,accessionNum);
		pstmt.setString(3,accessionNum);
		pstmt.setString(4,accessionNum);
		pstmt.setString(5,accessionNum);
		res = pstmt.executeQuery();

		while(res.next())
		{
			eventCode = res.getString("event_code") == null ? "" : res.getString("event_code");
			contrSysEventCode = res.getString("CONTR_SYS_EVENT_CODE") == null ? "" : res.getString("CONTR_SYS_EVENT_CODE");
			specNum = res.getString("spec_num") == null ? "" : res.getString("spec_num");
		}

		if(res != null) res.close();
		if(pstmt != null) pstmt.close();
		pstmt = con.prepareStatement(sqlTestCode);
		pstmt.setString(1,eventCode);
		res = pstmt.executeQuery();

		while(res.next())
		{
			test = res.getString("test_code") == null ? "" : res.getString("test_code");
		}

		if(res != null) res.close();
		if(pstmt != null) pstmt.close();
		if(!accessionNum.equals(""))
		{	
			pstmt = con.prepareStatement("select section_code from rl_test_code where TEST_CODE = ?");
			pstmt.setString(1,contrSysEventCode);
			res = pstmt.executeQuery();

			while(res.next())
			{
				secCode = res.getString("section_code") == null ? "" : res.getString("section_code");
			}

			if(res != null) res.close();
			if(pstmt != null) pstmt.close();
		}
	}

	if(p_resp_id.equals("RL_MANAGER"))
	{
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(applServerURL));
            _bw.write(_wl_block8Bytes, _wl_block8);

	}
	else
	{
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	}
	pstmt = con.prepareStatement(sqlSecInd);
	pstmt.setString(1,secCode);
	pstmt.setString(2,locale);
	res = pstmt.executeQuery();
	while(res.next())
	{
		anatomyInd = res.getString("anatomy_ind") == null ? "" : res.getString("anatomy_ind");
		section_ind = res.getString("section_ind") == null ? "" : res.getString("section_ind");
	}


	if(res != null) res.close();
	if(pstmt != null) pstmt.close();
	//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016 STARTS
	if (section_ind.equals("HI") || section_ind.equals("CY"))
	{
		try
		{
			pstmtSampleCount = con.prepareStatement(sqlSampleCount);
			pstmtSampleCount.setString(1,specNum);			
			pstmtSampleCount.setString(2,locale);
			pstmtSampleCount.setString(3,specNum);
			pstmtSampleCount.setString(4,locale);
			resSampleCount = pstmtSampleCount.executeQuery();
			while(resSampleCount.next())
			{
				iSampleCount = resSampleCount.getInt(1);		
			}
		}
		catch(Exception e1)
		{
			System.out.println("Ex1:"+e1);
			iSampleCount = 0;
		}
		finally
		{
			if(resSampleCount != null) resSampleCount.close();
			if(pstmtSampleCount != null) pstmtSampleCount.close();
		}
	}
	//System.out.println("iSampleCount:"+iSampleCount);
	//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016 ENDS

	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(specNum));
            _bw.write(_wl_block12Bytes, _wl_block12);

	//if (section_ind.equals("HI") || section_ind.equals("CY"))
	//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016
	if ((section_ind.equals("HI") || section_ind.equals("CY"))&& iSampleCount>0)
	{					
		
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

		if (!calledFrom.equalsIgnoreCase("RL_REVIEW")) {
		
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

		} else {
		
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

		}
		/* Added by Sanjay on 13-04-2016 against IN059924 ENDS */
	}
	else 
	{
		anatomyInd = "";//Sanjay
		sampleId = "";//Sanjay
		
            _bw.write(_wl_block22Bytes, _wl_block22);

		if (!calledFrom.equalsIgnoreCase("RL_REVIEW")) {
			
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

		} else {
			
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

		}
	}
	
            _bw.write(_wl_block24Bytes, _wl_block24);
			
	
	

	pstmtImgView = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ? and SAMPLE_ID = ? and ANATOMY_SITE_CODE = ?");

	pstmtImgViewOthers = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ? and SAMPLE_ID is null and ANATOMY_SITE_CODE is null");
	//System.out.println("anatomyInd:"+anatomyInd+":");	
	//if (section_ind.equals("HI") || section_ind.equals("CY"))
	//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016
	if ((section_ind.equals("HI") || section_ind.equals("CY"))&& iSampleCount>0)
	{
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,specNum);		
		pstmt.setString(2,locale);
		pstmt.setString(3,specNum);
		pstmt.setString(4,locale);
	}
	else {
		pstmt = con.prepareStatement(sqlO);
		pstmt.setString(1,specNum);
		pstmt.setString(2,facilityId);
		pstmt.setString(3,locale);				
	}

	res = pstmt.executeQuery();	
	while(res.next())
	{		
		//if (section_ind.equals("HI") || section_ind.equals("CY"))
		//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016
		if ((section_ind.equals("HI") || section_ind.equals("CY"))&& iSampleCount>0)
		{
			test = res.getString("test_desc") == null ? "" : res.getString("test_desc");
			testCode = res.getString("test_code") == null ? "" : res.getString("test_code");
			anatomy = res.getString("anatomy_desc") == null ? "" : res.getString("anatomy_desc");
			anatomyCode = res.getString("anatomy_site_code") == null ? "" : res.getString("anatomy_site_code");			
			sampleId = res.getString("sample_id") == null ? "" : res.getString("sample_id");
			tissueDesc = res.getString("tissue_desc") == null ? "&nbsp;" : res.getString("tissue_desc");

			if(count % 2 == 0) classValue = "QRYEVEN";
			else classValue = "QRYODD";	
			
			if(p_resp_id.equals("RL_MANAGER"))
			{
				colSpan = "2";
			}
			else
			{
				colSpan = "1";				
			}
			
			out.println("<td class='"+classValue+"'>"+test+"</td>");
			out.println("<td class='"+classValue+"'>"+sampleId+"</td>");
			out.println("<td class='"+classValue+"'>"+anatomy+"</td>");
			//commented by Sanjay on 13-04-2016 against IN059924
			//out.println("<td class='"+classValue+"' colspan='"+colSpan+"'>"+tissueDesc+"</td>");
			out.println("<td class='"+classValue+"'>"+tissueDesc+"</td>");
			
		} else
		{
			if(count % 2 == 0) classValue = "QRYEVEN";
			else classValue = "QRYODD";	
			
			if(p_resp_id.equals("RL_REVIEW"))
			{
				colSpan = "2";
			}
			else
			{
				colSpan = "1";				
			}

			test = res.getString("test_desc") == null ? "" : res.getString("test_desc");
			testCode = res.getString("test_code") == null ? "" : res.getString("test_code");	
			out.println("<td class='"+classValue+"'>"+test+"</td>");				
		}
		
		//Added by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800) STARTS		
		String sqlIntervalTest = "SELECT test_code || '_' || SUBSTR ('000', 1, 3 - LENGTH (TO_CHAR (seq_no))) || to_char(seq_no) FROM rl_interval_test_specimens WHERE specimen_no = ? AND test_code = ? AND operating_facility_id = ?";
		pstmtIntervalTest = con.prepareStatement(sqlIntervalTest);
		pstmtIntervalTest.setString(1,specNum);
		pstmtIntervalTest.setString(2,testCode);
		pstmtIntervalTest.setString(3,facilityId);		
		resIntervalTest = pstmtIntervalTest.executeQuery();
		//System.out.println("sqlIntervalTest ::"+sqlIntervalTest);
		while(resIntervalTest.next())
		{			
			testCode = resIntervalTest.getString(1);
		}
		
		if(resIntervalTest != null) resIntervalTest.close();
		if(pstmtIntervalTest != null) pstmtIntervalTest.close();		
		//Added by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800) ENDS

		if (!calledFrom.equalsIgnoreCase("RL_REVIEW"))
		{
			if(accessionNum.equals(""))
			{
				//Modified by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
				out.println("<td class='"+classValue+"'><a href=\"javascript:showUploadPage('"+specNum+"','"+testCode+"','"+sampleId+"','"+secCode+"','"+anatomyCode+"')\">UpLoadFile</a></td>");
			}
		}

		//if (section_ind.equals("HI") || section_ind.equals("CY"))
		//added by Sanjay for ML-MMOH-CRF-0494[IN059242] on 23-03-2016
		if ((section_ind.equals("HI") || section_ind.equals("CY"))&& iSampleCount>0)
		{
			pstmtImgView.setString(1,facilityId);
			pstmtImgView.setString(2,specNum);
			pstmtImgView.setString(3,testCode);
			pstmtImgView.setString(4,sampleId);
			pstmtImgView.setString(5,anatomyCode);
			resImgView = pstmtImgView.executeQuery();
		}
		else
		{
			pstmtImgViewOthers.setString(1,facilityId);
			pstmtImgViewOthers.setString(2,specNum);
			pstmtImgViewOthers.setString(3,testCode);
			resImgView = pstmtImgViewOthers.executeQuery();
		}				
		while(resImgView.next())
		{
			recCount = resImgView.getInt(1);
		}

		if(resImgView != null) resImgView.close();
		
		if(recCount > 0 )
		{
			//Modified by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
			out.println("<td class='"+classValue+"'><a href=\"javascript:viewUploadedImg('"+specNum+"','"+testCode+"','"+sampleId+"','"+secCode+"','"+anatomyCode+"','"+recCount+"','"+facilityId+"')\">View</a></td>");
		}
		else
		{
			out.println("<td class='"+classValue+"'>&nbsp;</td>");
		}
		
		out.println("</tr>");
		count++;
	}

	if(res != null) res.close();
	if(pstmt != null) pstmt.close();
	if(pstmtImgView != null) pstmtImgView.close();
}
catch(Exception e)
{
	//out.println("Exception in try of ManageLISSpecimenImageUploadLinks.jsp --"+e.toString());
	//System.out.println("Exception in try of ManageLISSpecimenImageUploadLinks.jsp --"+e.toString());
	e.printStackTrace(System.err);
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_resp_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block28Bytes, _wl_block28);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Test.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.SampleID.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.Anatomy.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.TissueDescription.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UploadFile.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Test.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UploadFile.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Test.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }
}
