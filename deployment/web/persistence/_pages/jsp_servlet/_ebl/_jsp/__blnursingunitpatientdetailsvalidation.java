package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;

public final class __blnursingunitpatientdetailsvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLNursingUnitPatientDetailsValidation.jsp", 1725600329555L ,"10.3.6.0","Asia/Calcutta")) return true;
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

	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt				= null;
	ResultSet rs = null;

//	String locale = (String)session.getAttribute("LOCALE");

	String nursing_unit_code="", avail_beds="", occupied_beds="";
	String expect_discharge="", discharged_pat="";

	try
	{
		con = ConnectionManager.getConnection(request);

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);
//		Properties p  = (Properties)httpSession.getValue("jdbc");	
		String facility_id = (String)httpSession.getValue("facility_id");
		if(facility_id == null) facility_id="";
//		String strLoggedUser = p.getProperty("login_user");

//		java.util.Locale loc = new java.util.Locale(locale);
		nursing_unit_code = request.getParameter("nursing_unit_code");
		if(nursing_unit_code == null) nursing_unit_code="";

//		System.err.println("nursing_unit_code in validation:"+nursing_unit_code);
		
		try
		{		
			String avail_bed_sql = "Select count(*) from ip_nursing_unit_bed where NURSING_UNIT_CODE  ='"+nursing_unit_code+"' and PSEUDO_BED_YN='N' and FACILITY_ID = '"+facility_id+"'";

			pstmt = con.prepareStatement(avail_bed_sql);
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				avail_beds = rs.getString(1);		
			}	
			if(rs!=null) rs.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of Decimal Query="+e.toString());
		}

		try
		{		
			String avail_bed_sql = "Select count(*) from ip_nursing_unit_bed where NURSING_UNIT_CODE  ='"+nursing_unit_code+"' and PSEUDO_BED_YN='N' and OCCUPYING_PATIENT_ID is not null and FACILITY_ID = '"+facility_id+"'";

			pstmt = con.prepareStatement(avail_bed_sql);
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				occupied_beds = rs.getString(1);		
			}	
			if(rs!=null) rs.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of Decimal Query="+e.toString());
		}	

		if(avail_beds == null || avail_beds.equals("")) avail_beds=" ";	
		if(occupied_beds == null || occupied_beds.equals("")) occupied_beds=" ";	
//		System.err.println("avail_beds:"+avail_beds);
//		System.err.println("occupied_beds:"+occupied_beds);

		try
		{		
//			String avail_bed_sql = "select count(*) from PR_ENCOUNTER a where ASSIGN_CARE_LOCN_CODE='"+nursing_unit_code+"' and trunc(EXP_DISCHARGE_DATE_TIME) = trunc(SYSDATE) and DISCHARGE_DATE_TIME is null and exists (select 'X' from IP_DISCHARGE_ADVICE b where b.ENCOUNTER_ID=a.ENCOUNTER_ID and b.DIS_ADV_STATUS <> '9' and trunc(b.EXPECTED_DISCHARGE_DATE)=trunc(sysdate))";
//			String avail_bed_sql = "select count(*) from PR_ENCOUNTER a,bl_episode_fin_dtls b, mp_patient c where ASSIGN_CARE_LOCN_CODE='"+nursing_unit_code+"' and trunc(a.EXP_DISCHARGE_DATE_TIME) = trunc(SYSDATE) and a.DISCHARGE_DATE_TIME is null and a.EPISODE_ID = b.EPISODE_ID and a.patient_id=b.patient_id and b.patient_id=c.patient_id and a.facility_id = b.operating_facility_id and a.facility_id='"+facility_id+"'";

			String avail_bed_sql = "select count(*) from ip_open_encounter a where NURSING_UNIT_CODE='"+nursing_unit_code+"' and trunc(a.EXP_DISCHARGE_DATE_TIME) = trunc(SYSDATE) and a.facility_id='"+facility_id+"'";

//			System.err.println("avail_bed_sql:"+avail_bed_sql);
			pstmt = con.prepareStatement(avail_bed_sql);
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				expect_discharge  =  rs.getString(1);		
			}	
			if(rs!=null) rs.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of Decimal Query="+e.toString());
		}
		if(expect_discharge == null || expect_discharge.equals("")) expect_discharge=" ";	
//		System.err.println("expect_discharge:"+expect_discharge);

		try
		{		
//			String avail_bed_sql = "select count(*) from PR_ENCOUNTER where ASSIGN_CARE_LOCN_CODE='"+nursing_unit_code+"' and trunc(DISCHARGE_DATE_TIME) = trunc(SYSDATE) and facility_id='"+facility_id+"'";

			String avail_bed_sql = "select count(*) from ip_patient_last_encounter where NURSING_UNIT_CODE='"+nursing_unit_code+"' and trunc(DISCHARGE_DATE_TIME) = trunc(SYSDATE) and facility_id='"+facility_id+"'";
//			System.err.println("avail_bed_sql:"+avail_bed_sql);
			pstmt = con.prepareStatement(avail_bed_sql);
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				discharged_pat = rs.getString(1);		
			}	
			if(rs!=null) rs.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of Decimal Query="+e.toString());
		}
		if(discharged_pat == null || discharged_pat.equals("")) discharged_pat=" ";	
//		System.err.println("discharged_pat:"+discharged_pat);		

		out.println(avail_beds+"|"+occupied_beds+"|"+expect_discharge+"|"+discharged_pat);
	}
	catch(Exception ee)
	{
		out.println("Exception in Details.jsp"+ee);
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
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
