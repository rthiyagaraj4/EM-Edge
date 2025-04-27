package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fminternalreportrecordexists extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMInternalReportRecordExists.jsp", 1709116852110L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'message\' onKeyDown = \'lockKey()\'>\n<form>\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\t<script>\n\t\t\tvar errors = getMessage(\'NO_RECORDS_FOUND\',\'FM\');\n\t\t\tvar repreq_id=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\tif(repreq_id==\"RE\")\n\t\t\t{\tparent.parent.frames[2].frames[3].document.location.href=\'../../eFM/jsp/FMRequesteeFileIntRepDetails.jsp\' ;\t\n\t\t\t\t}else{\n\t\t\tparent.parent.frames[2].frames[3].document.location.href=\'../../eCommon/html/blank.html\' ;\t\n\t\t\t}\t\n\t\tparent.parent.frames[2].frames[4].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t</script>\t\t\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\n\t<script>\t\n\t\tvar repreq_id=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\tif(repreq_id==\"RE\")\n\t\t\t{\t\n\n\t\t\t}else{\n\t\t\t\n\t\t\tparent.parent.frames[2].frames[3].document.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t//parent.parent.frames[2].frames[3].document.location.href=\'../../eFM/jsp/FMRequesteeFileIntRepDetails.jsp\' ;\t\n\t\t}\n\t\t//parent.parent.frames[2].frames[3].document.location.href=\'../../eCommon/html/blank.html\';\n       parent.parent.frames[2].frames[2].document.forms[0].req_no.value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n       parent.parent.frames[2].frames[2].document.forms[0].curr_fs_locn_code.value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";  \n\t   parent.parent.frames[2].frames[2].document.forms[0].submit();\t\t\t\t\t\t\t\t\n\t</script>\n\t\t\t\t\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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

	


	String locale=(String)session.getAttribute("LOCALE");
	//String   user_id		=	(String)session.getValue("login_user");
	request.setCharacterEncoding("UTF-8");
	Connection con = ConnectionManager.getConnection(request);
	Statement stmt = null;
	ResultSet rs   = null;

try
{
	String sql		= "";
	String sql1		= "";
	String wherecond = "";

	String found	= "N";	
//	String file_no	= "";		
	String confirm	= "";
	String pat_id = "";

	String facility_id = (String) session.getValue("facility_id");	
//	String Facility = request.getParameter("Facility");
	String report_id = request.getParameter("report_id");
	String issue_date = request.getParameter("issue_date");
	String file_location = request.getParameter("file_location");
	String fileno = request.getParameter("fileno");
	String repreq_id = request.getParameter("repreq_id");
	String req_user_id=request.getParameter("req_user_id");
	String requesting_from =request.getParameter("requesting_from");
	String patid =request.getParameter("patid");
	String file_type =request.getParameter("fileno");
	String volno =request.getParameter("volno");
	String Req_to_facid=request.getParameter("Req_to_facid");
	String logged_fcy  =request.getParameter("logged_fcy");
	String req_no="";
	String curr_fs_locn_code="";
	String curr_fs_locn_code1="";
	String encounter_id=request.getParameter("encounter_id");
    String fr_pract=request.getParameter("fr_pract");
    String to_pract=request.getParameter("to_pract");
   String pull_list_type=request.getParameter("pull_list_type");
   String fr_clcode=request.getParameter("fr_clcode");
   String to_clcode=request.getParameter("to_clcode");
  String fr_nurcode=request.getParameter("fr_nurcode");
  String to_nurcode=request.getParameter("to_nurcode"); 
  issue_date=DateUtils.convertDate(issue_date,"DMY",locale,"en");

	
	if(pull_list_type==null || pull_list_type.equals("null")) pull_list_type="";
	
	if(pull_list_type.equals("A"))
	{
      pull_list_type="";
	}
	
	if(fr_pract== null || fr_pract.equals("null")) fr_pract="";
	if(to_pract == null || to_pract.equals("null")) to_pract="";
	if(fr_clcode == null || fr_clcode.equals("null")) fr_clcode="";
	if(to_clcode == null || to_clcode.equals("null")) to_clcode="";
	if(fr_nurcode == null || fr_nurcode.equals("null")) fr_nurcode="";
	if(to_nurcode == null || to_nurcode.equals("null")) to_nurcode="";
	if(file_location == null || file_location.equals("null")) to_nurcode="";
	
	if(requesting_from == null || requesting_from.equals("null")) requesting_from="";
	if(repreq_id == null || repreq_id.equals("null")) repreq_id="";
	if(encounter_id == null || encounter_id.equals("null"))encounter_id="";
	if(req_user_id == null || req_user_id.equals("null")) req_user_id="";
	 if(fileno == null || fileno.equals("null")) fileno="";
     if(patid == null || patid.equals("null")) patid="";
	   if(file_type == null || file_type.equals("null")) file_type="";
	   if(volno == null || volno.equals("null")) volno="";
	if(Req_to_facid == null || Req_to_facid.equals("null")) Req_to_facid="";
   if(logged_fcy == null || logged_fcy.equals("null")) logged_fcy="";
	if(logged_fcy.equals("L"))
	{ 
       Req_to_facid=facility_id;
	}
	if(fileno.equals(""))
	{
		wherecond= "";
	}
	else 
	{
		wherecond = "and file_no='"+fileno+"'";
	}
	if ((report_id.equals("FMBMRPLA"))||(report_id.equals("FMBMRPLI")) || (repreq_id.equals("OP")) || (repreq_id.equals("IP")) || (repreq_id.equals("RE")))
	{
		confirm="N";
	}
	else if ((report_id.equals("FMBPULST")) || (report_id.equals("FMBIPLST"))||(report_id.equals("FMBPULS1")))
	{
		confirm="Y";
	}
	
		stmt = con.createStatement();
	
		
		if (report_id.equals("FMBATRCD"))
	{
		sql = "Select distinct A.FILE_NO, A.PATIENT_ID, A.FILE_TYPE_CODE from FM_AUTO_TRACK_LOG A where A.FACILITY_ID='"+facility_id+"' AND TO_CHAR(A.APPT_DATE,'DD/MM/YYYY') = '"+issue_date+"' and A.SRC_FS_LOCN_CODE='"+file_location+"'";
	}
	else if (report_id.equals("FMBATRCI"))
	{
		
		sql = "Select distinct A.FILE_NO, A.PATIENT_ID, A.FILE_TYPE_CODE from FM_IP_AUTO_TRACK_LOG A where A.FACILITY_ID='"+facility_id+"' AND TO_CHAR(A.PREFERRED_DATE,'DD/MM/YYYY') = '"+issue_date+"' and A.SRC_FS_LOCN_CODE='"+file_location+"'";
	
	}
	else if ((report_id.equals("FMBMRPLA"))||(report_id.equals("FMBPULST") && repreq_id.equals("FMBPULST")) )
	{
		//sql = "Select distinct A.FILE_NO, A.PATIENT_ID, A.FILE_TYPE_CODE  from FM_PULLING_LIST A where A.FACILITY_ID='"+facility_id+"' AND TO_CHAR(A.APPT_DATE,'DD/MM/YYYY') = '"+issue_date+"' and A.SRC_FS_LOCN_CODE='"+file_location+"' AND AUTO_TRACK_YN='N' AND CONFIRM_YN ='"+confirm+"'";
		
		sql = "Select distinct A.FILE_NO, A.PATIENT_ID, A.FILE_TYPE_CODE  from FM_PULLING_LIST A where A.FACILITY_ID='"+facility_id+"' AND TO_CHAR(A.APPT_DATE,'DD/MM/YYYY') = '"+issue_date+"' and A.SRC_FS_LOCN_CODE='"+file_location+"' AND pull_list_type=nvl( '"+pull_list_type+"', pull_list_type) and nvl(a.practitioner_id, 'X') between nvl('"+fr_pract+"','!') and nvl('"+to_pract+"','~')    and nvl(a.clinic_code, 'X') between nvl('"+fr_clcode+"','!') and nvl('"+to_clcode+"','~') AND CONFIRM_YN ='"+confirm+"'" ;		
	}
	else if ((report_id.equals("FMBMRPLI"))||(repreq_id.equals("FMBPULST1")))
	{
		//sql = "Select distinct A.FILE_NO, A.PATIENT_ID, A.FILE_TYPE_CODE from FM_IP_PULLING_LIST A where A.FACILITY_ID='"+facility_id+"' AND TO_CHAR(A.PREFERRED_DATE,'DD/MM/YYYY') = '"+issue_date+"' and A.SRC_FS_LOCN_CODE='"+file_location+"' AND AUTO_TRACK_YN='N' AND CONFIRM_YN ='"+confirm+"'";

		sql = "Select distinct A.FILE_NO, A.PATIENT_ID, A.FILE_TYPE_CODE from FM_IP_PULLING_LIST A where A.FACILITY_ID='"+facility_id+"' AND TO_CHAR(A.PREFERRED_DATE,'DD/MM/YYYY') = '"+issue_date+"' and A.SRC_FS_LOCN_CODE='"+file_location+"'  AND pull_list_type=nvl( '"+pull_list_type+"', pull_list_type) and nvl(a.practitioner_id, 'X') between nvl('"+fr_pract+"','!') and nvl('"+to_pract+"','~')    and nvl(a.nursing_unit_code, 'X') between nvl('"+fr_nurcode+"','!')  and nvl('"+to_nurcode+"','~') AND CONFIRM_YN ='"+confirm+"'";
		}
else if(repreq_id.equals("OP")){
  
  sql = "Select distinct A.FILE_NO, A.PATIENT_ID, A.FILE_TYPE_CODE  from FM_PULLING_LIST A where A.FACILITY_ID='"+facility_id+"' AND TO_CHAR(A.APPT_DATE,'DD/MM/YYYY') = '"+issue_date+"' and A.SRC_FS_LOCN_CODE='"+file_location+"' AND   A.SRC_FS_LOCN_CODE='"+file_location+"' AND  a.patient_id = nvl( '"+patid+"', a.patient_id)  and a.file_no = nvl('"+file_type+"', a.file_no)    and a.volume_no = nvl('"+volno+"', a.volume_no) and CONFIRM_YN ='"+confirm+"' and nvl(a.practitioner_id, 'X') between nvl('"+fr_pract+"','!') and nvl('"+to_pract+"','~')    and nvl(a.clinic_code, 'X') between nvl('"+fr_clcode+"','!') and nvl('"+to_clcode+"','~') and a.pull_list_type=nvl( '"+pull_list_type+"', a.pull_list_type) ";	

}
else if(repreq_id.equals("IP")){

sql = "Select distinct A.FILE_NO, A.PATIENT_ID, A.FILE_TYPE_CODE from FM_IP_PULLING_LIST A where A.FACILITY_ID='"+facility_id+"' AND TO_CHAR(A.PREFERRED_DATE,'DD/MM/YYYY') = '"+issue_date+"' and A.SRC_FS_LOCN_CODE='"+file_location+"' AND a.patient_id = nvl( '"+patid+"', a.patient_id)  and a.file_no = nvl('"+file_type+"', a.file_no)    and a.volume_no = nvl('"+volno+"', a.volume_no) and CONFIRM_YN ='"+confirm+"' and nvl(a.practitioner_id, 'X') between nvl('"+fr_pract+"','!') and nvl('"+to_pract+"','~')    and nvl(a.nursing_unit_code, 'X') between nvl('"+fr_nurcode+"','!')  and nvl('"+to_nurcode+"','~') and a.pull_list_type=nvl( '"+pull_list_type+"', a.pull_list_type)";
}

else if(repreq_id.equals("RE"))
	{
// Cancel_yn is added in the below queries for SRR20056-SCF-7274.1 [IN:027717] by Suresh M on 18.07.2011
 sql="SELECT b.patient_id, b.req_no, b.file_no  FROM fm_req_hdr a, fm_req_dtl b  WHERE a.req_no = b.req_no  AND b.patient_id = '"+patid+"'  AND b.curr_facility_id = '"+Req_to_facid+"'   AND b.file_required_on BETWEEN TO_DATE ('"+issue_date+"' , 'dd/mm/yyyy')    AND TO_DATE ('"+issue_date+"' , 'dd/mm/yyyy') + 0.99999  AND nvl(a.req_fs_locn_code, 'X') = nvl(nvl('"+file_location+"', a.req_fs_locn_code), 'X')  AND nvl(a.requesting_from, 'X')  = nvl(nvl('"+requesting_from+"', a.requesting_from), 'X')  AND nvl(b.encounter_id, 0)     = nvl(nvl('"+encounter_id+"', b.encounter_id), 0)  AND nvl(b.file_no, 'X')   = nvl(nvl('"+file_type+"', b.file_no), 'X')  AND b.volume_no = nvl('"+volno+"', b.volume_no) AND a.req_user_id = nvl('"+req_user_id+"',a.req_user_id) and b.cancel_yn = 'N' ";

  sql1="SELECT distinct b.CURR_FS_LOCN_CODE  FROM fm_req_hdr a, fm_req_dtl b  WHERE a.req_no = b.req_no  AND b.patient_id = '"+patid+"'  AND b.curr_facility_id = '"+Req_to_facid+"'   AND b.file_required_on BETWEEN TO_DATE ('"+issue_date+"' , 'dd/mm/yyyy')    AND TO_DATE ('"+issue_date+"' , 'dd/mm/yyyy') + 0.99999  AND nvl(a.req_fs_locn_code, 'X') = nvl(nvl('"+file_location+"', a.req_fs_locn_code), 'X')  AND nvl(a.requesting_from, 'X')  = nvl(nvl('"+requesting_from+"', a.requesting_from), 'X')  AND nvl(b.encounter_id, 0)     = nvl(nvl('"+encounter_id+"', b.encounter_id), 0)  AND nvl(b.file_no, 'X')   = nvl(nvl('"+file_type+"', b.file_no), 'X')  AND b.volume_no = nvl('"+volno+"', b.volume_no) AND a.req_user_id = nvl('"+req_user_id+"',a.req_user_id) and b.cancel_yn = 'N' ";


//sql="select b.patient_id, b.req_no, b.file_no   from fm_req_hdr a,fm_req_dtl b where a.requesting_from ='"+requesting_from+"'  and a.narration_code ='"+narration_code+"' and a.req_fs_locn_code ='"+file_location+"'  and  b.patient_id='"+patid+"' and  b.file_no='"+file_type+"' and  b.volume_no='"+volno+"' and b.added_date between to_date( '"+issue_date+"', 'dd/mm/yyyy') and to_date( '"+issue_date+"', 'dd/mm/yyyy') + 0.99999" ;

	}
	else if (report_id.equals("FMBISSCD"))
	{
		sql = "Select distinct A.FILE_NO, A.PATIENT_ID, A.FILE_TYPE_CODE from FM_MOVEMENT_LOG A where A.FACILITY_ID='"+facility_id+"' AND TO_CHAR(A.SENT_DATE_TIME,'DD/MM/YYYY') = '"+issue_date+"' and A.DEST_FS_LOCN_CODE='"+file_location+"'";
		sql = sql + wherecond;
	}

	rs = stmt.executeQuery(sql);		
		
		if(rs != null)
		{				
			while (rs.next())
			{
				found = "Y"; 
				pat_id = (rs.getString("PATIENT_ID")==null)?"":rs.getString("PATIENT_ID");									
				if(repreq_id.equals("RE"))
				{
				req_no=(rs.getString("req_no")==null)?"":rs.getString("req_no");	
				}
				}
			
		}
if (stmt!=null) stmt.close();
if (rs!=null) rs.close();


if(found.equals("Y") && repreq_id.equals("RE")){
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql1);
	if(rs != null){
		while(rs.next()) {
			if(curr_fs_locn_code.equals(""))
				curr_fs_locn_code=(rs.getString("CURR_FS_LOCN_CODE")==null)?"":rs.getString("CURR_FS_LOCN_CODE");					
			else{
				curr_fs_locn_code=curr_fs_locn_code+"|";
				curr_fs_locn_code1=(rs.getString("CURR_FS_LOCN_CODE")==null)?"":rs.getString("CURR_FS_LOCN_CODE");				
				curr_fs_locn_code=curr_fs_locn_code+curr_fs_locn_code1;
				
			}			
		}
	}
}


		if(found.equals("N"))
		{			
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(repreq_id));
            _bw.write(_wl_block7Bytes, _wl_block7);

		}
		else
		{				

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(repreq_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(req_no));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_fs_locn_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
				
		}
	}
catch(Exception e)
{ out.println("In ExceptionTemp :"+e.toString());
   e.printStackTrace();
}
finally
{
	if (stmt!=null) stmt.close();
	if (rs!=null) rs.close();

	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
