package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmipconfirmpullinglistconfirmall extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMIPConfirmPullingListConfirmAll.jsp", 1709116854125L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t\tdocument.forms[0].fm_nursing_unit_code.add(opt);\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet pullinglistrefno= null;synchronized(session){
                pullinglistrefno=(webbeans.eCommon.RecordSet)pageContext.getAttribute("pullinglistrefno",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(pullinglistrefno==null){
                    pullinglistrefno=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("pullinglistrefno",pullinglistrefno,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.RecordSet pullinglistremarks= null;synchronized(session){
                pullinglistremarks=(webbeans.eCommon.RecordSet)pageContext.getAttribute("pullinglistremarks",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(pullinglistremarks==null){
                    pullinglistremarks=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("pullinglistremarks",pullinglistremarks,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.RecordSet pullinglistFileNo= null;synchronized(session){
                pullinglistFileNo=(webbeans.eCommon.RecordSet)pageContext.getAttribute("pullinglistFileNo",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(pullinglistFileNo==null){
                    pullinglistFileNo=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("pullinglistFileNo",pullinglistFileNo,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.RecordSet pullinglistpatientId= null;synchronized(session){
                pullinglistpatientId=(webbeans.eCommon.RecordSet)pageContext.getAttribute("pullinglistpatientId",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(pullinglistpatientId==null){
                    pullinglistpatientId=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("pullinglistpatientId",pullinglistpatientId,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.RecordSet tracer= null;synchronized(session){
                tracer=(webbeans.eCommon.RecordSet)pageContext.getAttribute("tracer",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(tracer==null){
                    tracer=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("tracer",tracer,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
		Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get("SEARCH") ;
		String facility_id=(String)session.getValue("facility_id");
		Connection con = ConnectionManager.getConnection(request);
		ResultSet rs=null;		
		PreparedStatement pstmt =null;
		
	 try{
		String confirm_yn			=(String) hash.get("confirm_yn");
		String preferred_date			=(String) hash.get("preferred_date");
		String p_fm_nursing_unit_code		=(String) hash.get("p_fm_nursing_unit_code");
		String p_to_nursing_unit_code		=(String) hash.get("p_to_nursing_unit_code");
		String p_fm_pract_id		=(String) hash.get("p_fm_pract_id");
		String p_to_pract_id		=(String) hash.get("p_to_pract_id");
		String p_gender				=(String) hash.get("p_gender");
		String pull_type			=(String) hash.get("pull_type");
		String p_fs_locn_code		=(String) hash.get("p_fs_locn_code");
		String check				=(String) hash.get("check");
		String steps				=(String) hash.get("steps");
		String where_cond="";
		if (confirm_yn==null) confirm_yn="";   
		if (steps==null) steps="";   
		if (check==null) check="";  
		if (preferred_date==null) preferred_date="";  
		if (p_fm_nursing_unit_code==null) p_fm_nursing_unit_code="";  
		if (p_to_nursing_unit_code==null) p_to_nursing_unit_code="";  
		if (p_fm_pract_id==null) p_fm_pract_id="";  
		if (p_to_pract_id==null) p_to_pract_id="";  
		if (p_gender==null) p_gender="";  
		if (pull_type==null) pull_type="";  
		if (p_fs_locn_code==null) p_fs_locn_code="";  		

		if (steps.equals("1"))
		 {
			pullinglistrefno.clearAll();
	        if (check.equals("Y"))
			{
			   String result_query="select distinct a.file_no from fm_ip_pulling_list a,ip_booking_list b where a.facility_id = b.facility_id and a.bkg_lst_ref_no = b.bkg_lst_ref_no";
			   pstmt=con.prepareStatement(result_query);
			   rs=pstmt.executeQuery();
			   while(rs!=null&&rs.next())
				{
				 tracer.putObject(rs.getString(1));
				}
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
		    }
		 }
		else if (steps.equals("2"))
		 {
			String result_query="select nursing_unit_code,long_desc short_desc from ip_nursing_unit where facility_id = ? and fs_locn_code =? ";
			pstmt=con.prepareStatement(result_query);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,p_fs_locn_code);
			rs=pstmt.executeQuery();
			String nursing_unit_code = "";
			String nursing_unit_desc = "";
			while(rs!=null&&rs.next())
				{
				  nursing_unit_code = rs.getString(1);
				  nursing_unit_desc = rs.getString(2);
				
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(nursing_unit_desc));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
	
				}
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
		 }
		 else
		 {
		StringBuffer sql = null;
		sql				 = new StringBuffer();
		sql.append("select to_char(a.preferred_date,'hh24:mi') preferred_time,a.nursing_unit_code,a.patient_id,a.practitioner_id,a.file_no,a.bkg_lst_ref_no, a.remarks from fm_curr_locn b, fm_ip_pulling_list a  where   b.facility_id=a.facility_id and b.file_no=a.file_no  and a.facility_id=?  and a.preferred_date = to_date(?,'dd/mm/yyyy') and a.nursing_unit_code = nvl(?,a.nursing_unit_code) and (a.practitioner_id is null or a.practitioner_id between nvl(?,'!') and nvl(?,'~')) and (? is null or ? is null or a.practitioner_id is not null) and a.pull_list_type=decode(?,'A',a.pull_list_type,?) and a.auto_track_yn = 'N' and fm_return_booking_status(?,?,?,?,?,a.bkg_lst_ref_no,a.patient_id) not in ('C','T','S') and (b.curr_facility_id = ? and b.perm_locn_code = b.curr_fs_locn_code) ");
		
		if (confirm_yn.equals("Y"))
			sql.append(" and a.confirm_yn = 'Y'");
        else
			sql.append(" and a.confirm_yn = 'N'");

		if (!(p_gender.equals("A")))
           sql.append(" and a.patient_id in (select patient_id from mp_patient where sex =?)");

		String remarks1="";

		where_cond=java.net.URLDecoder.decode(where_cond);
		sql.append(where_cond);
		pullinglistrefno.clearAll();
		pullinglistremarks.clearAll();
		pullinglistFileNo.clearAll();
		pullinglistpatientId.clearAll();
        if (check.equals("Y"))
		{
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,preferred_date);
			pstmt.setString(3,p_fm_nursing_unit_code);
			pstmt.setString(4,p_fm_pract_id);
			pstmt.setString(5,p_to_pract_id);
			pstmt.setString(6,p_fm_pract_id);
			pstmt.setString(7,p_to_pract_id);
			pstmt.setString(8,pull_type);
            pstmt.setString(9,pull_type);
            pstmt.setString(10,facility_id);
            pstmt.setString(11,p_fs_locn_code);
            pstmt.setString(12,preferred_date);
			pstmt.setString(13,p_fm_nursing_unit_code);
            pstmt.setString(14,p_to_nursing_unit_code);
            pstmt.setString(15,facility_id);
			if (!(p_gender.equals("A")))
			pstmt.setString(16,p_gender);
			rs=pstmt.executeQuery();
			while(rs!=null&&rs.next())
			{
              //  String bkg_lst_ref_no	   = rs.getString("bkg_lst_ref_no");
				String patient_id	   = rs.getString("patient_id");
			//	String practitioner_id = rs.getString("practitioner_id");

					pullinglistrefno.putObject(rs.getString("bkg_lst_ref_no"));
					pullinglistFileNo.putObject(rs.getString("file_no"));
					pullinglistpatientId.putObject(patient_id);
					remarks1 = rs.getString("remarks");

		  if(remarks1 == null) remarks1="";
		  pullinglistremarks.putObject(remarks1);
		 }
		 }
	}
	if(rs !=null) rs.close();
	if(pstmt !=null) pstmt.close();	
	}catch( Exception e ){
		out.println(e.toString());
	}
	finally
	{			
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
