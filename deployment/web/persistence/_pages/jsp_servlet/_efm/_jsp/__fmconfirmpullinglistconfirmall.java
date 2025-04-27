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

public final class __fmconfirmpullinglistconfirmall extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMConfirmPullingListConfirmAll.jsp", 1726057678258L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\t\tdocument.forms[0].fm_clinic_code.add(opt);\n\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\talert(f_query_add_mod.getMessage(\'ATLEAST_ONE_SELECTED\',\'Common\'));\n\t\t\tvar result=false;\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\tvar result=confirm(f_query_add_mod.getMessage(\'DELETE_RECORD\',\'Common\'));\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\tvar flag=0;\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t     flag=1;\n\t\t   ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t     flag=0;\n\t\t   ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet pullinglistremarks= null;synchronized(session){
                pullinglistremarks=(webbeans.eCommon.RecordSet)pageContext.getAttribute("pullinglistremarks",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(pullinglistremarks==null){
                    pullinglistremarks=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("pullinglistremarks",pullinglistremarks,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet pullinglistFileNo= null;synchronized(session){
                pullinglistFileNo=(webbeans.eCommon.RecordSet)pageContext.getAttribute("pullinglistFileNo",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(pullinglistFileNo==null){
                    pullinglistFileNo=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("pullinglistFileNo",pullinglistFileNo,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet pullinglistpatientId= null;synchronized(session){
                pullinglistpatientId=(webbeans.eCommon.RecordSet)pageContext.getAttribute("pullinglistpatientId",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(pullinglistpatientId==null){
                    pullinglistpatientId=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("pullinglistpatientId",pullinglistpatientId,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet tracer= null;synchronized(session){
                tracer=(webbeans.eCommon.RecordSet)pageContext.getAttribute("tracer",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(tracer==null){
                    tracer=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("tracer",tracer,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
 
		Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get("SEARCH") ;
		String localeName =((String)session.getAttribute("LOCALE"));
		String facility_id=(String)session.getValue("facility_id");
		Connection con = ConnectionManager.getConnection(request);
		ResultSet rs=null;
		ResultSet rs1=null;
		PreparedStatement pstmt =null;
		PreparedStatement pstmt1 =null;
	 try{
		
		String confirm_yn			=(String) hash.get("confirm_yn");
		String appt_date			=(String) hash.get("appt_date");
		String p_fm_clinic_code	=(String) hash.get("p_fm_clinic_code");
 		String p_to_clinic_code	=(String) hash.get("p_to_clinic_code");
		String p_fm_pract_id		=(String) hash.get("p_fm_pract_id");
		String p_to_pract_id		=(String) hash.get("p_to_pract_id");
		String p_gender			=(String) hash.get("p_gender");
		String pull_type				=(String) hash.get("pull_type");
		String p_fs_locn_code		=(String) hash.get("p_fs_locn_code");
		String check					=(String) hash.get("check");
		String steps					=(String) hash.get("steps");  
		if (confirm_yn==null) confirm_yn="";   
		if (steps==null) steps="";   
		if (check==null) check="";  
		if (appt_date==null) appt_date="";  
		if (p_fm_clinic_code==null) p_fm_clinic_code="";  
		if (p_to_clinic_code==null) p_to_clinic_code="";  
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
			   String result_query="select distinct a.file_no from fm_pulling_list a,oa_appt b where a.facility_id = b.facility_id and a.appt_ref_no = b.appt_ref_no";
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
			//String result_query="select clinic_code,short_desc from op_clinic where facility_id = ? and mr_location_code =? ";
			String result_query="SELECT Clinic_Code, long_desc FROM   op_clinic_lang_vw WHERE  Facility_Id = ?  AND mr_Location_Code =  ? AND LANGUAGE_ID=? ";
			pstmt=con.prepareStatement(result_query);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,p_fs_locn_code);
			pstmt.setString(3,localeName);
			rs=pstmt.executeQuery();
			String clinic_code = "";
			String clinic_desc = "";
			while(rs!=null&&rs.next())
				{
				  clinic_code = rs.getString(1);
				  clinic_desc = rs.getString(2);
				
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(clinic_desc));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block5Bytes, _wl_block5);
	
				}
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
		 }else if (steps.equals("FMHoliday")){
		 String currSelHolidays= (String) hash.get("currSelHolidays");
		
		ArrayList selectedHolidays= new ArrayList();
		int currPage=0;	
		selectedHolidays.add(currPage,currSelHolidays);

		int count=0;
		
		for(int i=0;i< selectedHolidays.size();i++){
			String temp=(String)selectedHolidays.get(i);
			if (temp.equals("")) count++;

		}

		if (selectedHolidays.size()==count){
            _bw.write(_wl_block6Bytes, _wl_block6);
}else{
            _bw.write(_wl_block7Bytes, _wl_block7);
}
selectedHolidays.clear();
	}else if (steps.equals("Holiday_Date_Check")){ 
            _bw.write(_wl_block8Bytes, _wl_block8);

		//Added for HSA-CRF-0306.1
		String facilityid= (String) hash.get("facility_id");
		String fileno= (String) hash.get("fileno");
		String volume_no= (String) hash.get("volume_no");
		String Patient_Id= (String) hash.get("Patient_Id");
		String strLocn= (String) hash.get("strLocn");
		String retdate= (String) hash.get("retdate");
		int ret=0; String returnflag="FALSE";
		
		    String holidayQuery="select FM_VALIDATE_RETURN_DATE('"+facilityid+"','"+fileno+"','"+volume_no+"','"+Patient_Id+"','"+strLocn+"','"+retdate+"') retvalue from dual";	
           		
		    pstmt=con.prepareStatement(holidayQuery);			
			rs=pstmt.executeQuery();			
			if(rs!=null&&rs.next())
			{
			returnflag=rs.getString(1);				
			}			
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
	       if(returnflag.equals("TRUE")){
            _bw.write(_wl_block9Bytes, _wl_block9);
}else{ 
            _bw.write(_wl_block10Bytes, _wl_block10);
}	
	   //End HSA-CRF-0306.1
	} else{
		 StringBuffer sql = null;
		 sql			  = new StringBuffer();
		 sql.append("select to_char(a.appt_time,'hh24:mi') appt_time,a.clinic_code,a.patient_id,a.practitioner_id,a.file_no,a.appt_ref_no, a.remarks  from fm_curr_locn b, fm_pulling_list a  where  b.facility_id=a.facility_id and b.file_no=a.file_no  and a.facility_id=?  and a.appt_date = to_date(?,'dd/mm/yyyy') and a.clinic_code = nvl(?,a.clinic_code) and (a.practitioner_id is null or a.practitioner_id between nvl(?,'!') and nvl(?,'~')) and (? is null or ? is null or a.practitioner_id is not null) and a.pull_list_type=decode(?,'A',a.pull_list_type,?) and a.auto_track_yn = 'N' and fm_return_appt_status(?,?,?,?,?,a.appt_ref_no,a.patient_id) not in ('C','T','S') and (b.curr_facility_id = ? and b.perm_fs_locn_code = b.curr_fs_locn_code) ");
		
		if (confirm_yn.equals("Y"))
			sql.append(" and a.confirm_yn = 'Y'");
        else
			sql.append(" and a.confirm_yn = 'N'");

		if (!(p_gender.equals("A")))
           sql.append(" and a.patient_id in (select patient_id from mp_patient where sex =?)");

		String remarks1="";

		pullinglistrefno.clearAll();
		pullinglistremarks.clearAll();
		pullinglistFileNo.clearAll();
		pullinglistpatientId.clearAll();
        if (check.equals("Y"))
		{
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,appt_date);
			pstmt.setString(3,p_fm_clinic_code);
			pstmt.setString(4,p_fm_pract_id);
			pstmt.setString(5,p_to_pract_id);
			pstmt.setString(6,p_fm_pract_id);
			pstmt.setString(7,p_to_pract_id);
			pstmt.setString(8,pull_type);
            pstmt.setString(9,pull_type);
            pstmt.setString(10,facility_id);
            pstmt.setString(11,p_fs_locn_code);
            pstmt.setString(12,appt_date);
			pstmt.setString(13,p_fm_clinic_code);
            pstmt.setString(14,p_to_clinic_code);
            pstmt.setString(15,facility_id);
			if (!(p_gender.equals("A")))
			pstmt.setString(16,p_gender);
			rs=pstmt.executeQuery();
			while(rs!=null&&rs.next())
			{
                String appt_time	   = rs.getString("appt_time");
                String appt_ref_no	   = rs.getString("appt_ref_no");
                String patient_id	   = rs.getString("patient_id");
                //String practitioner_id = rs.getString("practitioner_id");
				String sql_other_appt ="select sign(a.appt_time-to_date(?,'hh24:mi')) diff from oa_appt a  where a.facility_id=? and appt_date= to_date(?,'dd/mm/yyyy') and a.patient_id = ? and a.appt_ref_no != ?";
				boolean dis_oth_flag=false;
				pstmt1=con.prepareStatement(sql_other_appt);
				pstmt1.setString(1,appt_time);
				pstmt1.setString(2,facility_id);
				pstmt1.setString(3,appt_date);
				pstmt1.setString(4,patient_id);
				pstmt1.setString(5,appt_ref_no);
				rs1 = pstmt1.executeQuery();
				int diff=0;
				while(rs1!=null&&rs1.next())
				 {		 
					  diff = rs1.getInt(1);
					  if ((diff<0) && (!dis_oth_flag))
						dis_oth_flag = true;
				}
				if(rs1 !=null) rs1.close();
				if(pstmt1 !=null) pstmt1.close();
				if (dis_oth_flag)
				{
					pullinglistrefno.putObject(rs.getString("appt_ref_no"));
					pullinglistFileNo.putObject(rs.getString("file_no"));
					pullinglistpatientId.putObject(patient_id);
					remarks1 = rs.getString("remarks");
				}

		  if(remarks1 == null) remarks1="";
		  pullinglistremarks.putObject(remarks1);
		 }
		 }
	 }
	  if(rs !=null) rs.close();
	  if(pstmt !=null) pstmt.close();
	  if(rs1 !=null) rs1.close();
	  if(pstmt1 !=null) pstmt1.close();
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
