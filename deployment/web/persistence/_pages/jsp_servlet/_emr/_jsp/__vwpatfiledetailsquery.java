package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.sql.*;
import java.util.*;
import java.util.ResourceBundle.*;
import com.ehis.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __vwpatfiledetailsquery extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/vwPatFileDetailsquery.jsp", 1742367043815L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>\n<TITLE></TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<Script>\n\tfunction callModalVPF()\n\t{\n\t\tpatid1=document.forms[0].Patient_Id.value\n\t\tparent.frames[2].location.href=\'../../eMR/jsp/patientblank.jsp?Patient_Id=\'+patid1;\n\t}\n</Script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<tr>\n\t\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n   \t<td class=\'button\' width=\'5%\'>\n\t<input type=\"hidden\" name=\"Patient_Id\" id=\"Patient_Id\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n    <input type=\"button\" class=\"button\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" onClick=\"callModalVPF();\">\n    </td>\n\t<td  class=\'label\' width=\'90%\' align=\'right\'>&nbsp;</td>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\n\t</tr>\n\t</table>\n\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t<tr>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\n\t\t\n\t\t<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\t\n\t\t\t\n\t\t<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\n\t\t<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </td>\n\t\t\t\t\n\t\t\t\n\t\t<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\n\t</tr>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</tr>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<input type=\"hidden\" name=\"Patient_Id\" id=\"Patient_Id\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="<script>document.getElementById(\'nextval\').innerHTML=\" \";</script>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n</table>\n</form>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );
	
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


	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY OnMouseDown='CodeArrest();'  onKeyDown = 'lockKey()' class='CONTENT'><form>");
	
	String patID=request.getParameter("Patient_Id");
	String function_id=request.getParameter("function_id");
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String responsibility_id=request.getParameter("responsibility_id")==null?"":request.getParameter("responsibility_id");
	String login_user=request.getParameter("login_user")==null?"":request.getParameter("login_user");
	String client_ip_address = "";
	client_ip_address = request.getRemoteAddr();
 
String jdbc_props = "";

	if ( function_id == null )
	function_id="";
	//	String whereClause = request.getParameter("whereclause");
	String file_type_appl_yn = "";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	//String facility_id	=(String) session.getValue("facility_id");
	String facility_id	= request.getParameter("FacilityId") ;//added forBru-HIMS-CRF-380
	String locale       =(String) session.getAttribute("LOCALE"); 
    
	 if(facility_id==null || facility_id.equals(""))	
		facility_id = (String) session.getValue("facility_id");
	

	if(locale == null)
		locale = request.getParameter("locale") ;
	

	locale = (locale == null || locale.equals(""))?"en":locale;
	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
	String endOfRes="1";
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 15 ;
	else
		end = Integer.parseInt( to ) ;

Connection conn =null;
Statement stmt=null;
ResultSet rs=null;
String fm_install_yn = "";
String strsql2 = "";
PreparedStatement pstmt = null;
//int maxRecord = 0;

String single_or_multi_files_ind =	"";
String separate_file_no_yn =	"";
try
{
	conn = ConnectionManager.getConnection(request) ;

/*	stmt = conn.createStatement();
	String strsql1="select count(*) as total from mr_pat_file_index_vw";
	rs = stmt.executeQuery(strsql1);
	if(rs.next())
	{
		//maxRecord = rs.getInt("total");
	}
*/

	//String str_sql_MP = " select file_type_appl_yn, single_or_multi_files_ind, separate_file_no_yn from MP_PARAM ";
	String str_sql_MP =" select file_type_appl_yn, single_or_multi_files_ind, separate_file_no_yn from MP_PARAM where module_id='MP'";
	
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();

	pstmt = conn.prepareStatement(str_sql_MP);
	rs = pstmt.executeQuery();

	while(rs.next())
	{
		file_type_appl_yn = rs.getString(1);
		
		single_or_multi_files_ind = rs.getString(2);
		separate_file_no_yn = rs.getString(3);
		//if file_type_appl_yn is N from mp_param then file type description should not be displayed.
	}
	
	try
	{
		String str_sql_FM = "select install_yn from sm_module where module_id='FM' ";
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		pstmt = conn.prepareStatement(str_sql_FM);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			fm_install_yn = rs.getString(1);//if fm is not installed volume number,remarks and current file location should not be displayed
		}

		if(fm_install_yn==null)
			fm_install_yn = "N";

	}catch(Exception e)
	{
		//out.print(e.toString());
		e.printStackTrace();
	}

		if(fm_install_yn.equals("Y"))
		{
				
			strsql2= "SELECT a.Facility_Id,SM_GET_DESC.SM_FACILITY_PARAM(a.FACILITY_ID,'"+locale+"','1') Facility_Name,a.File_No,		a.fs_Locn_Code,FM_GET_DESC.FM_STORAGE_LOCN(a.FACILITY_ID, a.FS_LOCN_CODE,'"+locale+"','2') File_Locn_desc,			c.Curr_fs_Locn_Code,FM_GET_DESC.FM_STORAGE_LOCN(a.FACILITY_ID, c.Curr_fs_Locn_Code,'"+locale+"','2') fs_Locn_desc,	decode(c.curr_file_status, 'I', 'Inside', 'O', 'Outside', 'T', 'Issued - In Transit', 'L', 'Lost', 'A', 'Archived', 'R', 'Returned - In Transit') Remarks ,c.Remarks,a.mr_Section_Code,MR_GET_DESC.MR_SECTION(a.FACILITY_ID, a.MR_SECTION_CODE,'"+locale+"','2') Section_Name,MR_GET_DESC.MR_FILE_TYPE(a.FACILITY_ID, a.FILE_TYPE_CODE,'"+locale+"','2') File_Type_desc,c.Volume_No,a.Added_By_Id,a.Archived_yn,To_char(a.Added_Date,'dd/mm/yyyy hh24:mi') Added_Date, a.old_file_no FROM   MR_PAT_FILE_INDEX a,  FM_CURR_LOCN c WHERE  a.Facility_Id = '"+facility_id+"' AND a.Patient_Id = '"+patID+"' AND a.Facility_Id = c.Facility_Id    AND a.File_No = c.File_No AND a.Patient_Id = c.Patient_Id AND( (c.volume_status = 'A' OR c.volume_status = 'L' OR c.volume_status = 'R' OR c.volume_status = 'F' OR c.volume_status = 'NA')) order by a.file_no desc";

	
		}
		else
		{
			//strsql2 = " SELECT a.facility_id, b.facility_name, a.file_no, a.fs_locn_code, a.mr_section_code, e.short_name section_name, g.short_desc file_type_desc FROM MR_PAT_FILE_INDEX a, SM_FACILITY_PARAM b, MR_SECTION e, MR_FILE_TYPE g WHERE a.facility_id = b.facility_id AND a.facility_id = e.facility_id(+) AND a.mr_section_code = e.mr_section_code(+) AND a.file_type_code = g.file_type_code(+) AND a.patient_id = '"+patID+"' ";
			//strsql2 = " SELECT a.facility_id, b.facility_name, a.file_no, a.fs_locn_code, a.mr_section_code, e.short_name section_name, g.short_desc file_type_desc FROM MR_PAT_FILE_INDEX a, sm_Facility_Param_lAng_vw b, mr_Section_lAng_vw e, mr_File_Type_lAng_vw g WHERE a.facility_id = b.facility_id AND a.facility_id = e.facility_id(+) AND g.Language_Id = b.Language_Id AND e.Language_Id = b.Language_Id AND a.mr_section_code = e.mr_section_code(+) AND a.file_type_code = g.file_type_code(+) AND a.patient_id = '"+patID+"' AND b.Language_Id = '"+locale+"'";
			strsql2 = " select facility_id, SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,'"+locale+"','1') facility_name,Archived_yn, file_no,fs_locn_code, mr_section_code, MR_GET_DESC.MR_SECTION(FACILITY_ID, MR_SECTION_CODE,'"+locale+"','2') section_name, MR_GET_DESC.MR_FILE_TYPE(FACILITY_ID, FILE_TYPE_CODE,'"+locale+"','2') file_type_desc ,added_by_id, To_char(Added_Date,'dd/mm/yyyy hh24:mi') Added_Date , old_file_no from MR_PAT_FILE_INDEX where patient_id = '"+patID+"' and	Facility_Id = '"+facility_id+"' order by file_no desc ";
		
		}

		if(rs!=null)rs.close();	
		if(pstmt!=null)pstmt.close();
		if(stmt!=null)stmt.close();	
		stmt = conn.createStatement();

		rs = stmt.executeQuery(strsql2);
		// variables for query retrieval

		String l_section_name 	= "";
		String l_file_no	= "";
		String l_added_by_id = "";
		String l_added_date = "";
		String old_file_no = "";
		String l_added_date_display = "";
		String file_type_desc = "";
		String volumeno = "";
 		String current_file_locn="",remarks="";
		String file_created_at="";
 	    String facility_Id="";
	    String facility_name="";
	    String archived_status="";
	
	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }
	    String classValue = "" ;
	
	int k=0;
	
	while ( rs.next() && i<=end )
	{ 
		if(k==0){		
			
            _bw.write(_wl_block6Bytes, _wl_block6);

			
	if(function_id.equals("CPD")){
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patID));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.create.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
}
            _bw.write(_wl_block10Bytes, _wl_block10);

			
	if ( !(start <= 1) )
	{
		out.println("<td class='label' width='5%' align='right'><A HREF='../../eMR/jsp/vwPatFileDetailsquery.jsp?function_id=CPD&Patient_Id="+patID+"&from="+(start-15)+"&to="+(end-15)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
	}

	if (endOfRes.equals("1"))
	 {
		out.println("<td class='label' width='5%' align='right'><A  id='nextval' HREF='../../eMR/jsp/vwPatFileDetailsquery.jsp?function_id=CPD&Patient_Id="+patID+"&from="+(start+15)+"&to="+(end+15)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
		
		
	 }	
	
            _bw.write(_wl_block11Bytes, _wl_block11);
 
	if(separate_file_no_yn.equals("N") && single_or_multi_files_ind.equals("M") && file_type_appl_yn.equals("Y"))  
	{ 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(common_labels.getString("Common.filetype.label")));
            _bw.write(_wl_block13Bytes, _wl_block13);
	} 
            _bw.write(_wl_block1Bytes, _wl_block1);
	if(separate_file_no_yn.equals("Y")  &&  file_type_appl_yn.equals("N"))
	{	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(common_labels.getString("Common.fileno.label")));
            _bw.write(_wl_block13Bytes, _wl_block13);
	}	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(common_labels.getString("Common.FacilityID.label")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(common_labels.getString("Common.FacilityName.label")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(common_labels.getString("Common.MRSection.label")));
            out.print( String.valueOf(common_labels.getString("Common.name.label")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(common_labels.getString("Common.ActiveVolumeNumber.label")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(common_labels.getString("Common.FileCurrentLocation.label")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(common_labels.getString("Common.CurrentFileStatus.label")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(common_labels.getString("Common.FileCreatedAt.label")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(common_labels.getString("Common.FileCreatedDateTime.label")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(common_labels.getString("Common.FileCreatedBy.label")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(common_labels.getString("Common.Archived.label")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(common_labels.getString("Common.OldFileNo.label")));
            _bw.write(_wl_block19Bytes, _wl_block19);
}
		if(fm_install_yn.equals("Y"))
		{
			current_file_locn=rs.getString("fs_locn_desc");
			if(current_file_locn == null) 
				current_file_locn=rs.getString("file_locn_desc");

			if(rs.getString("file_locn_desc") == null)
				current_file_locn="&nbsp;";
			else
				current_file_locn=rs.getString("file_locn_desc");
		}	
		l_section_name 	= rs.getString("SECTION_NAME");
			if(l_section_name == null) l_section_name="&nbsp;";

		l_file_no	= rs.getString("file_no");
					if(l_file_no == null) l_file_no="&nbsp;";
		l_added_by_id	= rs.getString("added_by_id");
					if(l_added_by_id == null) l_added_by_id="&nbsp;";
		l_added_date	= rs.getString("added_date");

		old_file_no = rs.getString("old_file_no")==null?"&nbsp;":rs.getString("old_file_no");

			facility_id=rs.getString("Facility_Id");
			if(facility_id == null) facility_id="&nbsp;";
			facility_name=rs.getString("Facility_Name");
			if(facility_name == null) facility_name="&nbsp;";
			archived_status=rs.getString("Archived_yn");
			if(archived_status == null) archived_status="&nbsp;";
			
			if(l_added_date == null)
			{
				l_added_date = "&nbsp;";
				l_added_date_display = "&nbsp;";
			}
			else
				l_added_date_display = DateUtils.convertDate(l_added_date,"DMYHM","en",locale);

		file_type_desc = rs.getString("file_type_desc")==null?"&nbsp;":rs.getString("file_type_desc");
		//to display facility for the reference of FS102MR(270208)v1 0.doc
		file_created_at = rs.getString("Facility_Name");
		//file_created_at = rs.getString("facility_id");
		if(fm_install_yn.equals("Y"))
		{
			remarks	= rs.getString("remarks");

			if (remarks == null)
				remarks 	= "&nbsp;";
			/*
			if(remarks.equalsIgnoreCase("I"))
			{
				//remarks=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Inside.label","mr_labels");
			}
			else if(remarks.equalsIgnoreCase("O"))
			{
			//	remarks=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outside.label","common_labels");
				remarks=  common_labels.getString("Common.Outside.label") ;
			}
			else if(remarks.equalsIgnoreCase("T"))
			{
				//remarks=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.IssuedInTransit.label","mr_labels");
			}
			else if(remarks.equalsIgnoreCase("L"))
			{
				//remarks=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Lost.label","common_labels");
				remarks=  common_labels.getString("Common.Lost.label")  ;
			}
			else if(remarks.equalsIgnoreCase("A"))
			{
				//remarks=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Archived.label","common_labels");
				remarks=   common_labels.getString("Common.Archived.label");  
			}
			else if(remarks.equalsIgnoreCase("R"))
			{
				//remarks=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReturnedInTransit.label","mr_labels");
			}
			*/
		}

		if (l_file_no== null)
			l_file_no= "&nbsp;";

		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

		
		if(separate_file_no_yn.equals("N") && single_or_multi_files_ind.equals("M") && file_type_appl_yn.equals("Y")) 
		{
			out.println("<td nowrap class='" + classValue + "'>");
			out.println(file_type_desc+"</td>");
		}
		
		if(separate_file_no_yn.equals("Y")  &&  file_type_appl_yn.equals("N"))
		{
			out.println("<td nowrap class='" + classValue + "'>");
			out.println(l_file_no+"</td>");
		}

		
		
		/*if(fm_install_yn.equals("Y"))
		{
			volumeno  = rs.getString("volume_no");
		    if(volumeno == null) volumeno = "&nbsp;";

			
			out.println("<td  nowrap class='" + classValue + "'>");
			out.println(facility_id);
			out.println("<td  nowrap class='" + classValue + "'>");
			out.println(facility_name);
			out.println("<td  nowrap class='" + classValue + "'>");
			out.println(l_section_name);
			
			out.println("<td  nowrap class='" + classValue + "'>");
			out.println(volumeno);
			
			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(current_file_locn);

			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(remarks+"</td>");

			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(l_added_date_display+"</td>");

			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(l_added_by_id+"</td>");
		}*/

		if(fm_install_yn.equals("Y"))
		{
			volumeno  = rs.getString("volume_no");
		    if(volumeno == null) volumeno = "&nbsp;";
		}

			if(volumeno != null && volumeno.equals("")) volumeno = "&nbsp;";
			if(current_file_locn != null && current_file_locn.equals("")) current_file_locn = "&nbsp;";
			if(remarks != null && remarks.equals("")) remarks = "&nbsp;";
			if(l_added_date_display != null && l_added_date_display.equals("")) l_added_date_display = "&nbsp;";
			if(l_added_by_id != null && l_added_by_id.equals("")) l_added_by_id = "&nbsp;";

		
			
			out.println("<td  nowrap class='" + classValue + "'>");
			out.println(facility_id);
			out.println("<td  nowrap class='" + classValue + "'>");
			out.println(facility_name);
			out.println("<td  nowrap class='" + classValue + "'>");
			out.println(l_section_name);
			out.println("<td  nowrap class='" + classValue + "'>");
			out.println(volumeno);
			
			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(current_file_locn);
			
			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(remarks+"</td>");

			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(file_created_at);

			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(l_added_date_display+"</td>");

			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(l_added_by_id+"</td>");
		
		   out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(archived_status+"</td>");

		   out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(old_file_no+"</td>");
			
		       i++;
		       k++;
	          
            _bw.write(_wl_block20Bytes, _wl_block20);

	        }//endwhile
	     if(i == 1)
	     {
		if(!function_id.equals("CPD"))
		{	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patID));
            _bw.write(_wl_block22Bytes, _wl_block22);

				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				out.println("<script>parent.window.close();</script>");
		}
		else
		{	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patID));
            _bw.write(_wl_block23Bytes, _wl_block23);
	out.println("<script>callModalVPF();</script>");
		}
	}
		if (!rs.next() && k!=0){	
			 endOfRes = "0";	
			 
            _bw.write(_wl_block24Bytes, _wl_block24);
 
		 }
}catch(Exception e)
{
	//out.print(e.toString());
	e.printStackTrace();
}
finally   
{
	try
	{
	if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
	}
	catch(Exception e)
{
	e.printStackTrace();
}
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block25Bytes, _wl_block25);
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
