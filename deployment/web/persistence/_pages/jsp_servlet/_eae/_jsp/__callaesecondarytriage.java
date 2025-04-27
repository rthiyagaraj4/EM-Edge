package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __callaesecondarytriage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/CallAESecondaryTriage.jsp", 1709113873334L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>  \n  <script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n  <script language=\'javascript\' src=\'../../eAE/js/AESecondaryTriage.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>  \n<body onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );
  
//Conversion
public String specialCharacter(String single){
				int i=0;
				
				
		if(( single.indexOf('\'', i)!=-1)){
			single=(String)single.replace('\'',' ');
		}
	

		return single ;
			
			}


	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals("null"))) ? "" : inputString );
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String functionid	 = request.getParameter("functionid");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);

    	Connection con				=	null;
		PreparedStatement pstmt		=	null;
		ResultSet rs				=	null;

		String patient_id=""; 
		String encounter_id="";
		String facility_id	 =(String)session.getValue("facility_id");
		String priority_zone="";
		String practitioner_name="";
		String open_to_all_pract_yn="";
		String patient_gender="";
		String assign_tmt_area_time="";
		String queue_status="";
		String triage_area="";
		String trauma_yn="";
		String clinic_code="";
		String clinic_type="";
		String queue_date="";
		String brought_dead="";
		String orig_tmt_area_code="";
		String treatment_area_code="";
		String practitioner_id="";
		String clinic_desc="";
		String treatment_area_desc="";
		String check_in_date_time="";
		String open_to_all_prac_for_clinic_yn="";
 //      String min_age_for_lmp="";
       String year_value="";
       String disaster_yn="";
       String speciality_code="";
//       String referral_id="";
		
		String sys_date_time="";
		String sys_date_time1="";
		String selection_mode="triage";
		String queryval="";
		String function_id ="";
		int queue_status1 =0;

		try{
			    request.setCharacterEncoding("UTF-8");
				request= new XSSRequestWrapper(request);
				response.addHeader("X-XSS-Protection", "1; mode=block");
				response.addHeader("X-Content-Type-Options", "nosniff");
				
				String locale			= (String)session.getAttribute("LOCALE");
  				con = ConnectionManager.getConnection(request);
				patient_id	 = request.getParameter("patient_id");				
				encounter_id	 = request.getParameter("episode_id");
				function_id	   = request.getParameter("function_id");
				String rec_date_time		= request.getParameter("rec_date_time");//IN050047
				if((function_id==null) || (function_id.equals("null")) || (function_id=="") || (function_id.equals("")))
	            function_id= ""; 
				StringBuffer sqlTri = new StringBuffer();
				
				String page_name=request.getParameter("page_name");	//Added by santhosh for ML-MMOH-SCF-2384

				/*Added by Thamizh selvi on 3rd July 2018 against MMS-DM-CRF-0115.1 Start*/
				String called_from = checkForNull(request.getParameter("called_from"));
				String RepDb	   = checkForNull(request.getParameter("RepDb"));
				String clob_data   = checkForNull(request.getParameter("clob_data"));
				if(called_from.equals("CDR"))
					facility_id	= checkForNull(request.getParameter("facility_id"));
				/*End*/
				
				sqlTri.append("SELECT ASSIGN_CARE_LOCN_CODE clinic_code,OP_GET_DESC.OP_CLINIC ##REPDB##(facility_id,ASSIGN_CARE_LOCN_CODE,'"+locale+"','1')  clinic_desc,ASSIGN_CARE_LOCN_TYPE clinic_type, treatment_area_code treatment_area_code,  AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC ##REPDB##(facility_id, ASSIGN_CARE_LOCN_CODE,treatment_area_code,'"+locale+"','2') treatment_area_desc,  triage_area ,open_to_all_pract_yn,attend_practitioner_id practitioner_id,  AM_GET_DESC.AM_PRACTITIONER ##REPDB##(attend_practitioner_id,'"+locale+"','2') practitioner_name , TO_CHAR(queue_date,'dd/mm/yyyy hh24:mi') queue_date_time,  TO_CHAR(check_in_date_time,'dd/mm/yyyy hh24:mi') check_in_date_time,  TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time,  TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi') sys_date_time1,   TO_CHAR(assign_tmt_area_time,'dd/mm/yyyy hh24:mi') assign_date,   queue_status,  trauma_yn, brought_dead_yn  brought_dead,  open_to_all_prac_for_clinic_yn  open_to_all_prac_for_clinic_yn, sex patient_gender, date_of_birth Year, priority_zone,referral_id, disaster_yn,speciality_code  FROM  ae_pr_encounter_vw ##REPDB## WHERE  facility_id = ? AND  encounter_id=? and patient_id=? ");

				/*Added by Thamizh selvi on 3rd July 2018 against MMS-DM-CRF-0115.1 Start*/
				String sqlFinal = sqlTri.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
				pstmt =con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 3rd July 2018 against MMS-DM-CRF-0115.1
				pstmt.setString(1,facility_id);
				pstmt.setString(2,encounter_id);
				pstmt.setString(3,patient_id);
				rs=pstmt.executeQuery();
				if(rs != null && rs.next())
				{

					disaster_yn = rs.getString("disaster_yn") == null ? "" : rs.getString("disaster_yn") ;
					speciality_code = rs.getString("speciality_code") == null ? "" : rs.getString("speciality_code") ;
					clinic_code = rs.getString("clinic_code") == null ? "" : rs.getString("clinic_code") ;
					clinic_desc = rs.getString("clinic_desc") == null ?"" :rs.getString("clinic_desc") ;
					clinic_type = rs.getString("clinic_type") == null ? "" :rs.getString("clinic_type");
					//referral_id = rs.getString("referral_id") == null ? "" :rs.getString("referral_id");
					year_value = rs.getString("Year") == null ? "" :rs.getString("Year");
                    year_value	= year_value.substring(0,2);
					
					queue_status= rs.getString("queue_status") == null? "" :rs.getString("queue_status");

					triage_area=rs.getString("triage_area") == null? "" :rs.getString("triage_area");

					trauma_yn=rs.getString("trauma_yn") == null ? "" :rs.getString("trauma_yn");

					open_to_all_pract_yn=rs.getString("open_to_all_pract_yn") == null ?"" :rs.getString("open_to_all_pract_yn");

					queue_date=rs.getString("queue_date_time") == null ? "" :rs.getString("queue_date_time");

					assign_tmt_area_time=rs.getString("assign_date") == null ? "" :rs.getString("assign_date");

					brought_dead=rs.getString("brought_dead") == null ? "" :rs.getString("brought_dead");

					orig_tmt_area_code=rs.getString("treatment_area_code") == null ? "" :rs.getString("treatment_area_code");

					treatment_area_code=rs.getString("treatment_area_code") == null ? "" :rs.getString("treatment_area_code");

					treatment_area_desc=rs.getString("treatment_area_desc")== null ? "" :rs.getString("treatment_area_desc");

					practitioner_id=rs.getString("practitioner_id") == null ?"" :rs.getString("practitioner_id");

					practitioner_name=rs.getString("practitioner_name");

					open_to_all_prac_for_clinic_yn=rs.getString("open_to_all_prac_for_clinic_yn") == null ? "" :rs.getString("open_to_all_prac_for_clinic_yn");

					check_in_date_time=rs.getString("check_in_date_time") == null ? "" :rs.getString("check_in_date_time");

					sys_date_time=rs.getString("sys_date_time");
					sys_date_time1=rs.getString("sys_date_time1");

					patient_gender=rs.getString("patient_gender") == null ? "" :rs.getString("patient_gender");

					priority_zone=rs.getString("priority_zone") == null ? "" :rs.getString("priority_zone");	 			

				}	
/*
        pstmt			=	con.prepareStatement("select min_age_for_lmp from ae_param where operating_facility_id = ? ");
		pstmt.setString	(	1,	facility_id		);
		rs = pstmt.executeQuery();

		if(rs!= null &&  rs.next() )
		{
			min_age_for_lmp=rs.getString("min_age_for_lmp")==null?"":rs.getString("min_age_for_lmp");
		} 
		
  pstmt=	con.prepareStatement("select referral_id  from op_patient_queue where facility_id = ? and encounter_id= ? ");
		pstmt.setString	(	1,	encounter_id		);
		pstmt.setString	(	2,	facility_id		);
		rs = pstmt.executeQuery();

		if(rs!= null &&  rs.next() )
		{
			referral_id=rs.getString("referral_id")==null?"":rs.getString("referral_id");
		} 
		
*/



       if((practitioner_name==null) || (practitioner_name.equals("null")) || (practitioner_name=="") || (practitioner_name.equals("")))
	            practitioner_name= ""; 
queryval="selection_mode="+selection_mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&queue_status="+queue_status+"&triage_area="+triage_area+"&trauma_yn="+trauma_yn+"&open_to_all_pract_yn="+open_to_all_pract_yn+"&clinic_code="+clinic_code+"&clinic_type="+clinic_type+"&queue_date="+queue_date+"&assign_tmt_area_time="+java.net.URLEncoder.encode(assign_tmt_area_time)+"&brought_dead="+brought_dead+"&orig_tmt_area_code="+orig_tmt_area_code+"&treatment_area_code="+treatment_area_code+"&practitioner_id="+practitioner_id+"&clinic_desc="+specialCharacter(clinic_desc)+"&treatment_area_desc="+specialCharacter(treatment_area_desc)+"&open_to_all_prac_for_clinic_yn="+open_to_all_prac_for_clinic_yn+"&check_in_date_time="+java.net.URLEncoder.encode(check_in_date_time)+"&sys_date_time="+java.net.URLEncoder.encode(sys_date_time)+"&sys_date_time1="+java.net.URLEncoder.encode(sys_date_time1)+"&patient_gender="+patient_gender+"&year_value="+year_value+"&disaster_yn="+disaster_yn+"&practitioner_name="+specialCharacter(practitioner_name)+"&priority_zone="+priority_zone+"&called_from_ca=Y&function_id="+function_id+"&functionid="+functionid+"&speciality_code="+speciality_code+"&rec_date_time="+rec_date_time+"&clob_data="+clob_data+"&facility_id="+facility_id+"&called_from="+called_from+"&RepDb="+RepDb+"&page_name="+page_name;//IN050047 Added recorded date time



        if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		if((sqlTri != null) && (sqlTri.length() > 0))
		{
			sqlTri.delete(0,sqlTri.length());
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
	ConnectionManager.returnConnection(con,request);
	}
	if (!queue_status.equals(""))
    queue_status1 = Integer.parseInt( queue_status ) ;
   if ((queue_status1>=07) && (!function_id.equals("query")))
	{
		out.println("<script>alert(getMessage('AE_CHECKED_OUT','AE'));");
		out.println("location.href='../../eCommon/html/blank.html';</script>");
	}else
	{
		out.println("<script>");
		out.println("location.href='../../eAE/jsp/AETriageFrameset.jsp?"+queryval+" ' ");		
		out.println("</script>");
	}

out.println("</body>");
out.println("</html>");


            _bw.write(_wl_block1Bytes, _wl_block1);
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
