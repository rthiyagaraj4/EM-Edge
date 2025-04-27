package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.text.*;
import webbeans.eCommon.*;
import eFM.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmissuefileaddbean extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMIssueFileAddBean.jsp", 1733844064928L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\n<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eFM/js/FMIssueFiles.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head> \n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<iframe name=\'OutstanListDetail\' id=\'OutstanListDetail\' src=\'../../eFM/jsp/FMIssueFileOutstandingDetail.jsp?userSecurity=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&access_all=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&resLocnIdentities=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&file_type_yn=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&strLocn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&s_file_no=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&s_fs_locn_code=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&s_fs_narration=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&s_request_date=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&s_request_by_id=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&file_no_concat=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&s_fs_locn_identity=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&volume_no_concat=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&s_file_type=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&s_volume_no=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&issue_file_refresh_interval=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&isRefreshIntervalAvailable=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&isAutoPopulateAvailable=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&ChkIncludePreviousDayRequest=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' scrolling=auto frameborder=0 noresize style=\'height:83vh\t;width:100vw\'></iframe>\n\t<iframe name=\'OutstanListButton\' id=\'OutstanListButton\' src=\'../../eFM/jsp/FMIssueFileOutstandingButton.jsp?resLocnIdentities=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'  style=\'border-style: solid;\tborder-color:black; border-width:1; height:10vh;width:100vw\' scrolling=no frameborder=0 noresize ></iframe>\n\t\t\t\n\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<script>\n\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\t\t\t\t\t\t\n\t\t\t\n\t\t\t</script>\n\t\t\t<!-- issue_file_refresh_interval,isRefreshIntervalAvailable,ChkIncludePreviousDayRequest and isAutoPopulateAvailable Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 18th 2014 -->\n\t\t\t<frameset rows=\'83%,*\'>\n\t\t\t<frame name=\'OutstanListDetail\' id=\'OutstanListDetail\' src=\'../../eFM/jsp/FMIssueFileOutstandingDetail.jsp?userSecurity=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' scrolling=auto frameborder=0 noresize>\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<frame name=\'OutstanListButton\' id=\'OutstanListButton\' src=\'../../eFM/jsp/FMIssueFileOutstandingButton.jsp?resLocnIdentities=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' style=\"border-style: solid; border-color:black; border-width:1 ; height: 10vh; width:100vw;\" scrolling=no frameborder=0 noresize>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t<frame name=\'OutstanListButton\' id=\'OutstanListButton\' src=\'../../eCommon/html/blank.html\'   scrolling=no frameborder=0 noresize style=\"height: 10vh; width:100vw;\">\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t</frameset>\t\t\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t<script>\n\t\t\t\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n</html>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            eFM.FMIssueFileAddBean FMIssueFileAddBean= null;synchronized(session){
                FMIssueFileAddBean=(eFM.FMIssueFileAddBean)pageContext.getAttribute("FMIssueFileAddBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(FMIssueFileAddBean==null){
                    FMIssueFileAddBean=new eFM.FMIssueFileAddBean();
                    pageContext.setAttribute("FMIssueFileAddBean",FMIssueFileAddBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eFM.FMFilesIssueCart FMIssueFilesCart= null;synchronized(session){
                FMIssueFilesCart=(webbeans.eFM.FMFilesIssueCart)pageContext.getAttribute("FMIssueFilesCart",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(FMIssueFilesCart==null){
                    FMIssueFilesCart=new webbeans.eFM.FMFilesIssueCart();
                    pageContext.setAttribute("FMIssueFilesCart",FMIssueFilesCart,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
 
	 request.setCharacterEncoding("UTF-8");
	 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	
	Connection con			 = null;	
	PreparedStatement pstmt	 = null;
	ResultSet rs			 = null;
	try
	{
	con = ConnectionManager.getConnection(request);
	
    String login_facility_id	= (String) session.getValue("facility_id");
  String currfacility=(String) session.getValue("facility_id");
  String userSecurity		= checkForNull( request.getParameter("userSecurity"));
	String resLocnIdentities	= checkForNull( request.getParameter("resLocnIdentities"));
	String strLocn				= checkForNull( request.getParameter("strLocn"));
	String file_type_yn			= checkForNull( request.getParameter("file_type_yn"));
	String s_file_type			= checkForNull( request.getParameter("s_file_type"));
	String access_all  = checkForNull( request.getParameter("access_all"),"access_all");
	String file_no_concat=checkForNull( request.getParameter("file_no_concat"));
	String volume_no_concat=checkForNull( request.getParameter("volume_no_concat"));
	String NoOfDays			= request.getParameter("NoOfdays");
	if(NoOfDays==null) NoOfDays="0";
	String s_file_no				= checkForNull(request.getParameter("s_file_no"));
	String s_fs_locn_identity	= checkForNull(request.getParameter("s_fs_locn_identity"));
	String s_fs_locn_code		= checkForNull(request.getParameter("s_fs_locn_code"));
	String s_fs_narration		= checkForNull(request.getParameter("s_fs_narration"));
	String s_request_date		= checkForNull(request.getParameter("s_request_date"));
	String s_request_by_id	= checkForNull(request.getParameter("s_request_by_id"));
   String s_volume_no		=checkForNull( request.getParameter("s_volume_no"));
	s_file_type		=	((s_file_type==null) || (s_file_type.equals("null"))) ? "" : s_file_type;
	s_volume_no	=	((s_volume_no==null) || (s_volume_no.equals("null"))) ? "" : s_volume_no;
	 /*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 Start*/
	String issue_file_refresh_interval	= (request.getParameter("issue_file_refresh_interval")=="" || request.getParameter("issue_file_refresh_interval")==null)?"":request.getParameter("issue_file_refresh_interval");
	String isRefreshIntervalAvailable	= checkForNull(request.getParameter("isRefreshIntervalAvailable"),"false");
	String isAutoPopulateAvailable		= checkForNull(request.getParameter("isAutoPopulateAvailable"),"false");
	String ChkIncludePreviousDayRequest	= (request.getParameter("ChkIncludePreviousDayRequest")=="" || request.getParameter("ChkIncludePreviousDayRequest")==null)?"N":request.getParameter("ChkIncludePreviousDayRequest");
	/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 End*/
	 
	 if(file_no_concat==null) file_no_concat="";
	if(volume_no_concat==null) volume_no_concat="";
			boolean file_exist = false;
			boolean file_found = false;
  
				String From = "";
			
	      
			StringBuffer SelectSqlBuffer = null;
	       SelectSqlBuffer				 = new StringBuffer();
			
			SelectSqlBuffer.append("SELECT " );
					SelectSqlBuffer.append("  k.national_id_no");
					SelectSqlBuffer.append("  ,k.alt_id1_no");					
					SelectSqlBuffer.append("  ,a.File_No " );
					//SelectSqlBuffer.append("  , d.Curr_File_Status " );
					SelectSqlBuffer.append("  , d.Curr_File_Status File_Status " );
					SelectSqlBuffer.append("  , d.Curr_fs_Locn_Code " );
					SelectSqlBuffer.append("  , b.Short_desc Curr_fs_Locn_desc " );
					//SelectSqlBuffer.append("  , a.req_To_fs_Locn_Code" );
					SelectSqlBuffer.append("  , d.Perm_fs_Locn_Code" );
					SelectSqlBuffer.append("  , Nvl(b.mr_Locn_yn,'N') Curr_mr_Locn_yn " );
					SelectSqlBuffer.append("  , a.Patient_Id " );
					SelectSqlBuffer.append("  , Get_patient_line(a.Patient_Id,'"+localeName+"') PlIne " );
						SelectSqlBuffer.append("  , d.Remarks " );
					SelectSqlBuffer.append("  , Ltrim(Rtrim(a.Remarks)) req_Remarks " );
					SelectSqlBuffer.append("  , TO_CHAR(d.Iss_Date_Time,'DD/MM/YYYY HH:MI') Iss_Date_Time " );
					SelectSqlBuffer.append("  , a.Volume_No " );
					SelectSqlBuffer.append("  , a.File_Type_Code" );
					SelectSqlBuffer.append("  , mr_get_desc.mr_file_type(a.REQ_TO_FACILITY_ID, a.file_type_code, '"+localeName+"', 2) File_Type" );
					SelectSqlBuffer.append("  , TO_CHAR(a.File_Required_On,'DD/MM/YYYY HH24:MI') req_On " ); //this line modified for this incident [40681]
					SelectSqlBuffer.append("  , TO_CHAR(a.added_date,'DD/MM/YYYY HH24:MI') requested_On " ); //this line modified for this incident [40681]
					SelectSqlBuffer.append("  , a.req_No req_No " );
					SelectSqlBuffer.append("  , c.req_User_Id req_By " );
					SelectSqlBuffer.append("  , (" );
					SelectSqlBuffer.append("  CASE " );
					SelectSqlBuffer.append("  WHEN c.req_User_Id IS" );
					SelectSqlBuffer.append("    NOT NULL " );
					SelectSqlBuffer.append("  THEN" );
					SelectSqlBuffer.append("    (sm_get_desc.sm_appl_user(c.req_User_Id, '"+localeName+"', 1)) " );
					SelectSqlBuffer.append("  END) req_By_Name " );
					SelectSqlBuffer.append("  , c.req_Facility_Id " );
					SelectSqlBuffer.append("  , (" );
					SelectSqlBuffer.append("  CASE " );
					SelectSqlBuffer.append("  WHEN c.req_Facility_Id IS" );
					SelectSqlBuffer.append("    NOT NULL " );
					SelectSqlBuffer.append("  THEN" );
					SelectSqlBuffer.append("    (sm_get_desc.sm_facility_param(c.req_Facility_Id, '"+localeName+"', 1)) " );
					SelectSqlBuffer.append("  END) req_Facility_Name " );
					SelectSqlBuffer.append("  , c.req_fs_Locn_Code " );
					SelectSqlBuffer.append("  , (" );
					SelectSqlBuffer.append("  CASE " );
					SelectSqlBuffer.append("  WHEN c.req_fs_Locn_Code IS" );
					SelectSqlBuffer.append("    NOT NULL " );
					SelectSqlBuffer.append("  THEN" );
					SelectSqlBuffer.append("    (fm_get_desc.fm_storage_locn(c.REQ_FACILITY_ID, c.req_fs_Locn_Code, '"+localeName+"', 2)) " );
					SelectSqlBuffer.append("  END) req_fs_Locn_desc " );
					SelectSqlBuffer.append("  , c.Narration_Code " );
					SelectSqlBuffer.append("  , (" );
					SelectSqlBuffer.append("  CASE " );
					SelectSqlBuffer.append("  WHEN c.Narration_Code IS" );
					SelectSqlBuffer.append("    NOT NULL " );
					SelectSqlBuffer.append("  THEN" );
					SelectSqlBuffer.append("    (fm_get_desc.fm_narration(c.Narration_Code, '"+localeName+"', 2)) " );
					SelectSqlBuffer.append("  END) Narration_desc " );
					SelectSqlBuffer.append("  , b.Locn_Identity Locn_Identity" );
					SelectSqlBuffer.append("  , f.Locn_Identity Req_fs_locn_identity");
					SelectSqlBuffer.append("  , c.Requesting_From " );
					SelectSqlBuffer.append("  , (" );
					SelectSqlBuffer.append("  CASE " );
					SelectSqlBuffer.append("  WHEN c.Requesting_From IS" );
					SelectSqlBuffer.append("    NOT NULL " );
					SelectSqlBuffer.append("  THEN" );
					SelectSqlBuffer.append("    DECODE(f.Locn_Identity, 'N', ip_get_desc.ip_nursing_unit(c.req_Facility_Id, c.RequestIng_From, '"+localeName+"', 1), 'T', am_get_desc.am_practitioner(c.RequestIng_From, '"+localeName+"', 1), op_get_desc.op_clinic(c.req_Facility_Id, c.RequestIng_From, '"+localeName+"', 1)) " );
					SelectSqlBuffer.append("  END) Requesting_from_desc " );
					SelectSqlBuffer.append("  , (CASE WHEN (select count(*) from pr_encounter where Facility_Id = '"+login_facility_id+"' and patient_id=a.patient_id and (VISIT_STATUS < '07' or adt_status < '08') and mlc_yn='Y') > 0 THEN 'Y' ELSE 'N' END) mlc_yn,(SELECT am_get_desc.am_practitioner (attend_practitioner_id,'"+localeName+"',1) FROM pr_encounter WHERE encounter_id = a.encounter_id AND facility_id = c.req_facility_id) req_pract " );
					SelectSqlBuffer.append("FROM" );
					SelectSqlBuffer.append("  fm_req_dtl a " );
					SelectSqlBuffer.append("  , fm_req_hdr c " );
					SelectSqlBuffer.append("  , fm_Curr_Locn d " );
					SelectSqlBuffer.append("  , fm_Storage_Locn_lang_vw b " );
					SelectSqlBuffer.append("  , fm_Storage_Locn f " );					
					SelectSqlBuffer.append("  , mp_patient k " );
					//SelectSqlBuffer.append("  WHERE a.req_To_fs_Locn_Code = '"+strLocn+"' " );
					SelectSqlBuffer.append("  WHERE d.Perm_fs_Locn_Code = '"+strLocn+"' " );
					if (!(s_fs_locn_identity.equals("null") || s_fs_locn_identity.equals("")))
			        SelectSqlBuffer.append(" AND f.LOCN_IDENTITY = '"+s_fs_locn_identity+"' ");
					SelectSqlBuffer.append(" AND a.req_No = c.req_No " );
					SelectSqlBuffer.append("AND a.patient_id = k.patient_id" );
					SelectSqlBuffer.append("  AND a.req_To_Facility_Id = '"+login_facility_id+"' " );
					//SelectSqlBuffer.append("  AND a.req_To_fs_Locn_Code = '"+strLocn+"' " );
					SelectSqlBuffer.append("  AND a.Iss_yn = 'N' " );
					SelectSqlBuffer.append("  AND Nvl(a.Cancel_yn,'N') = 'N' " );
					SelectSqlBuffer.append("  AND  A.REQ_NO LIKE a.req_no " );
					SelectSqlBuffer.append("  AND a.file_no LIKE '%%' " );
					SelectSqlBuffer.append("  AND a.volume_no LIKE '%%' " );
					SelectSqlBuffer.append("  AND a.req_to_facility_id = d.facility_id(+)");
					SelectSqlBuffer.append("  AND a.File_No = d.File_No(+) " );
					SelectSqlBuffer.append("  AND a.Volume_No = d.Volume_No(+) " );
					SelectSqlBuffer.append("  AND c.req_fs_Locn_Code != d.Curr_fs_Locn_Code " );
					SelectSqlBuffer.append("  AND d.Curr_Facility_Id = b.Facility_Id " );
					SelectSqlBuffer.append("  AND d.Curr_fs_Locn_Code = b.fs_Locn_Code " );
					SelectSqlBuffer.append("  AND c.req_Facility_Id = f.Facility_Id " );
					SelectSqlBuffer.append("  AND c.req_fs_Locn_Code = f.fs_Locn_Code " );
					SelectSqlBuffer.append("  AND b.language_id = '"+localeName+"' " );
				
				
		if (!(s_file_no.equals("null") || s_file_no.equals("")))
			SelectSqlBuffer.append(" AND A.FILE_NO = '"+s_file_no+"' ");
    	if ((!s_volume_no.equals("")) && (!s_volume_no.equals("null")))
		 SelectSqlBuffer.append(" AND A.VOLUME_NO = "+s_volume_no+" ");
     	   if (!(s_fs_locn_code.equals("null") || s_fs_locn_code.equals("")))
		SelectSqlBuffer.append(" AND C.REQ_FS_LOCN_CODE = '"+s_fs_locn_code+"' ");	
			if (!(s_request_by_id.equals("null") || s_request_by_id.equals("")))
			SelectSqlBuffer.append(" AND C.REQ_USER_ID = '"+s_request_by_id+"' ");

		if (!(s_fs_narration.equals("null") || s_fs_narration.equals("")))
			SelectSqlBuffer.append(" AND C.NARRATION_CODE = '"+s_fs_narration+"' ");

	//	if (!(s_fs_locn_identity.equals("null") || s_fs_locn_identity.equals("")))
		//	SelectSqlBuffer.append(" AND f.LOCN_IDENTITY = '"+s_fs_locn_identity+"' ");
			s_request_date=DateUtils.convertDate(s_request_date,"DMY",localeName,"en");

		if (!(s_request_date.equals("null") || s_request_date.equals(""))){
			if(isAutoPopulateAvailable.equals("true") && ChkIncludePreviousDayRequest.equals("Y")){
				SelectSqlBuffer.append(" AND TRUNC (a.added_date) between TO_DATE ('"+s_request_date+"', 'dd/mm/yyyy') - 1  and TO_DATE ('"+s_request_date+"', 'dd/mm/yyyy')");
				
			
			}else{
				SelectSqlBuffer.append(" AND TO_DATE(TO_CHAR(TRUNC(A.ADDED_DATE),'dd/mm/yyyy'),'dd/mm/yyyy') = TO_DATE('"+s_request_date+"','dd/mm/yyyy') ");
			}
		}
			//SelectSqlBuffer.append(" order by A.FILE_NO ");	
			
			
				pstmt = con.prepareStatement(SelectSqlBuffer.toString());
		   rs	  = pstmt.executeQuery();
			int cnt=0;	
					while(rs != null && rs.next())		
				{
						 String FileNoValue = rs.getString("file_no");
						if(FileNoValue == null || FileNoValue.equals("null")) FileNoValue = "";
			            String      volume_no	=	checkForNull( rs.getString("volume_no"));
			         	String   file_type_code	=	checkForNull( rs.getString("File_Type_Code"));
			            String   file_type	=	checkForNull( rs.getString("file_type"));
				   String    Req_by_name = checkForNull( rs.getString("REQ_BY_NAME"));
			       String   Req_by = checkForNull( rs.getString("REQ_BY"));
			       String    Req_no = checkForNull( rs.getString("REQ_NO"));
		         String      patient_id = checkForNull(rs.getString("PATIENT_ID"));
              		String   mlc_yn = rs.getString("mlc_yn") == null?"N":rs.getString("mlc_yn");		
					String requesting_from_desc = checkForNull(rs.getString("REQUESTING_FROM_DESC"));//added for MMS-QH-CRF-0146.1 [IN:045787]
					String req_pract = checkForNull(rs.getString("REQ_PRACT"));//added for MMS-QH-CRF-0146.1 [IN:045787]
					String 	ReqOn				= checkForNull(rs.getString("REQ_ON"));
					String 	RequestedOn		= checkForNull(rs.getString("requested_On"));
					String iss_date_time=rs.getString("ISS_DATE_TIME");
					 iss_date_time=DateUtils.convertDate(iss_date_time,"DMYHM","en",localeName);
					String 	Reqfacilityid			= checkForNull(rs.getString("REQ_FACILITY_ID"));
					String 	Reqfacilityname	= checkForNull( rs.getString("REQ_FACILITY_NAME"));
					String 	Reqlocncode		= checkForNull( rs.getString("REQ_FS_LOCN_CODE"));
					String 	Reqlocndesc		= checkForNull( rs.getString("REQ_FS_LOCN_DESC"));
					String 	Reqlocnidentity	= checkForNull( rs.getString("Req_fs_locn_identity"));

      				String 	Narrationcode		= checkForNull( rs.getString("NARRATION_CODE"));
				    String 	Narrationdesc		= checkForNull( rs.getString("NARRATION_DESC"));
					String 	Reqlocnid			= checkForNull( rs.getString("REQUESTING_FROM"));
					String 	Reqlocnismrlocn = checkForNull( rs.getString("CURR_MR_LOCN_YN"));
              		String remarks  = rs.getString("REMARKS");	
					if(remarks==null) remarks="";
						String cuurIden = checkForNull( rs.getString("LOCN_IDENTITY"));
						if(cuurIden == null || cuurIden.equals("null")){
						cuurIden="";}
						String currStatus = checkForNull( rs.getString("File_Status"));
						if(currStatus == null || currStatus.equals("null")){
						currStatus="";}					
						String currlocn = checkForNull( rs.getString("CURR_FS_LOCN_CODE"));
						if(currlocn == null || currlocn.equals("null")){
						currlocn="";}
						 String currdesc=rs.getString("CURR_FS_LOCN_DESC");
						if(currdesc==null) currdesc="";
						String permLocn = checkForNull( rs.getString("Perm_fs_Locn_Code"));
						if(permLocn ==null || permLocn.equals("null")){
						permLocn="";}
					    String 	req_remarks		= checkForNull( rs.getString("REQ_REMARKS"));
						if(req_remarks ==null) req_remarks="";
					String	nat_id= rs.getString("national_id_no")==null?"":rs.getString("national_id_no");
               				String tempstr = rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6);
						StringTokenizer st = new StringTokenizer(tempstr, ",");
						st.nextToken();
						st.nextToken();
						st.nextToken();
			String pline=rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6);
			file_exist = FMIssueFileAddBean.FileNoExist(Req_no,FileNoValue,volume_no);
			file_found = FMIssueFileAddBean.CurrFacilityFileNoExist(currfacility,FileNoValue, volume_no);
					if((!file_exist))
					{
					if(login_facility_id.equals(Reqfacilityid)) From = "S";
					else From = "D";
					
					webbeans.eFM.FMFilesIssueDetail fissuebean = new webbeans.eFM.FMFilesIssueDetail();
						fissuebean.setRequest_From(From);
						fissuebean.setFile_No(FileNoValue);
						fissuebean.setFile_Type(file_type_code);
						fissuebean.setVolume_No(volume_no);
						fissuebean.setPatient_Id(patient_id);
						fissuebean.setPatient_Line(pline);
						fissuebean.setRec_Locn_Code(Reqlocncode);
						fissuebean.setIndex_Value(Reqlocndesc);
						fissuebean.setRec_Locn_Identity(Reqlocnidentity);
						fissuebean.setRec_Name(Req_by);
						fissuebean.setRec_Name_Desc(Req_by_name);
						fissuebean.setNarration_Code(Narrationcode);
						fissuebean.setMovement_Narration(Narrationdesc);
						fissuebean.setRemarks(remarks);
						fissuebean.setReq_Facility_Id(Reqfacilityid);
						fissuebean.setReq_Facility_Name(Reqfacilityname);
						fissuebean.setReq_No(Req_no);
						fissuebean.setIss_Locn_Code(currlocn);   
						fissuebean.setIss_Locn_Desc(currdesc);
						fissuebean.setIss_Locn_Identity(cuurIden);
						fissuebean.setIss_MR_Location(iss_date_time); 	
						fissuebean.setRec_MR_Location(Reqlocnismrlocn);
						fissuebean.setRet_Date_Time(ReqOn);				
						fissuebean.setRequest_Date_Time(RequestedOn);
						fissuebean.setCurr_Facility_Id(currfacility);
						fissuebean.setSrc_Facility_Id(login_facility_id);
						fissuebean.setSrc_User_Id(permLocn);
						fissuebean.setReq_Remarks(req_remarks);
						fissuebean.setMLC_Check(mlc_yn);
						fissuebean.setFile_Typedesc(file_type);
						fissuebean.setRequesting_From(Reqlocnid);
                        fissuebean.setRequesting_From_Desc(requesting_from_desc);
						fissuebean.setReq_Pract(req_pract);
						fissuebean.setThird_Party_Name(currStatus);
						fissuebean.setCarried_By(nat_id);
									
						FMIssueFileAddBean.addIssuestoCart(fissuebean);
						
						}
            cnt++;
			  }					
				
              ArrayList ArrFileCart	= (ArrayList) FMIssueFileAddBean.getPresCart();
	          int countRec	= ArrFileCart.size();
    if(cnt>0)
		{
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(userSecurity));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(access_all));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(resLocnIdentities));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(file_type_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strLocn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(s_file_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(s_fs_locn_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(s_fs_narration));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(s_request_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(s_request_by_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(file_no_concat));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(s_fs_locn_identity));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(volume_no_concat));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(s_file_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(s_volume_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(issue_file_refresh_interval));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(isRefreshIntervalAvailable));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(isAutoPopulateAvailable));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ChkIncludePreviousDayRequest));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(resLocnIdentities));
            _bw.write(_wl_block29Bytes, _wl_block29);
} if(cnt==0 )
			{
			
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(userSecurity));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(access_all));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(resLocnIdentities));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(file_type_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strLocn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(s_file_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(s_fs_locn_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(s_fs_narration));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(s_request_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(s_request_by_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(file_no_concat));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(s_fs_locn_identity));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(volume_no_concat));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(s_file_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(s_volume_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(issue_file_refresh_interval));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(isRefreshIntervalAvailable));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(isAutoPopulateAvailable));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ChkIncludePreviousDayRequest));
            _bw.write(_wl_block31Bytes, _wl_block31);
if(countRec>0) {
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(resLocnIdentities));
            _bw.write(_wl_block33Bytes, _wl_block33);
}else{
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block35Bytes, _wl_block35);

			} 
			
				
            _bw.write(_wl_block36Bytes, _wl_block36);

		  if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
				{
				SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
				}
			if(rs!=null)	rs.close();
			if(pstmt!=null) pstmt.close();
		session.putValue("FMIssueFilesBean",FMIssueFileAddBean);
	}catch(Exception e){
		e.printStackTrace();
	
	} finally {				
			ConnectionManager.returnConnection(con,request);
	}
	
	
            _bw.write(_wl_block37Bytes, _wl_block37);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
