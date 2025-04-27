package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;

public final class __buildperioparameters extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/buildPerioParameters.jsp", 1709117114841L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\n\t\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
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
	request.setCharacterEncoding("UTF-8");	
            _bw.write(_wl_block1Bytes, _wl_block1);

	String locale = (String)session.getAttribute("LOCALE"); 
	String params=request.getQueryString();
	String facility_id = (String)session.getValue("facility_id");
	String patient_id = request.getParameter("patient_id");
	String chart_flag = request.getParameter("chart_flag"); // to be passed from the calling place, from CA
	
	String chart_name = "";
	chart_flag=chart_flag==null?"R":chart_flag;
	chart_flag=chart_flag.equals("null")?"R":chart_flag;

	if(chart_flag.equals("R")){ // Restorative Chart
		chart_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.RestorativeChart.Label","oh_labels"); 
	}else if(chart_flag.equals("P")){ // Periodontal Chart
		chart_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.PeriodontalChart.Label","oh_labels"); 
	}

            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String func_mode = request.getParameter( "func_mode" ) ;
	try{
		con = ConnectionManager.getConnection();

		if(func_mode.equalsIgnoreCase("buildPerioParameters")){	
			String sql = "";
			String tooth_numbering_system = request.getParameter("numbering_system");
			String oh_chart_level = request.getParameter("oh_chart_level");
			
			String numbering_system_desc = "";
			int mixed_dentition_from_age_yrs = 0;
			int mixed_dentition_from_age_days = 0;
			int mixed_dentition_to_age_yrs = 0;
			int mixed_dentition_to_age_days = 0;
			int rest_chrt_validity_days = 0;
			int grace_period_days = 0;
			String dflt_mixed_dentition_chart = "";
			String deciduous_grace_period_valid = "";
			String currentAgeOfPatient = "";
			int patientAge = 0;
			int patientAgeDays = 0;

			String PD_flag = "";
			String chart_type = "";
			String MD_yn = "N";
			//String oh_chart_level = "";
			
			//Based on the chart level the parameters need to be taken.
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
			/*pstmt = con.prepareStatement("SELECT CHART_LEVEL FROM OH_PARAM");
			rs = pstmt.executeQuery();
			while (rs != null && rs.next()){
				oh_chart_level = checkForNull(rs.getString("CHART_LEVEL"));
			}*/
			

			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
			if(oh_chart_level.equals("E")){
				// Get the OH Param values and Patient Age
				sql	= "SELECT (SELECT NUMBERING_SYSTEM_DESC FROM OH_NUMBERING_SYSTEM_LANG_VW B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ?) NUMBERING_SYSTEM_DESC, NVL(MIXED_DENTITION_FROM_AGE_YRS,0) MIXED_DENTITION_FROM_AGE_YRS, NVL(MIXED_DENTITION_FROM_AGE_DAYS,0) MIXED_DENTITION_FROM_AGE_DAYS, NVL(MIXED_DENTITION_TO_AGE_YRS,0) MIXED_DENTITION_TO_AGE_YRS, NVL(MIXED_DENTITION_TO_AGE_DAYS,0) MIXED_DENTITION_TO_AGE_DAYS, NVL(REST_CHRT_VALIDITY_DAYS,0) REST_CHRT_VALIDITY_DAYS, NVL(DECIDUOUS_GRACE_PERIOD_DAYS,0) DECIDUOUS_GRACE_PERIOD_DAYS, DFLT_MIXED_DENTITION_CHART, (SELECT MP_CALCULATE_AGE_YMD(DATE_OF_BIRTH,'YD') FROM MP_PATIENT WHERE PATIENT_ID=?) PATIENT_AGE FROM OH_PARAM"; 
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,tooth_numbering_system);
				pstmt.setString(3,patient_id);
			}
			else
			{
				// Get the OH Param values and Patient Age
				sql	= "SELECT (SELECT NUMBERING_SYSTEM_DESC FROM OH_NUMBERING_SYSTEM_LANG_VW B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ?) NUMBERING_SYSTEM_DESC, NVL(MIXED_DENTITION_FROM_AGE_YRS,0) MIXED_DENTITION_FROM_AGE_YRS, NVL(MIXED_DENTITION_FROM_AGE_DAYS,0) MIXED_DENTITION_FROM_AGE_DAYS, NVL(MIXED_DENTITION_TO_AGE_YRS,0) MIXED_DENTITION_TO_AGE_YRS, NVL(MIXED_DENTITION_TO_AGE_DAYS,0) MIXED_DENTITION_TO_AGE_DAYS, NVL(REST_CHRT_VALIDITY_DAYS,0) REST_CHRT_VALIDITY_DAYS, NVL(DECIDUOUS_GRACE_PERIOD_DAYS,0) DECIDUOUS_GRACE_PERIOD_DAYS, DFLT_MIXED_DENTITION_CHART, (SELECT MP_CALCULATE_AGE_YMD(DATE_OF_BIRTH,'YD') FROM MP_PATIENT WHERE PATIENT_ID=?) PATIENT_AGE FROM OH_PARAM_FOR_FACILITY A WHERE FACILITY_ID=?"; 
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,tooth_numbering_system);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,facility_id);
			 }

			rs = pstmt.executeQuery();
			while (rs != null && rs.next()){
				numbering_system_desc			= rs.getString("NUMBERING_SYSTEM_DESC");
				mixed_dentition_from_age_yrs	= Integer.parseInt(rs.getString("MIXED_DENTITION_FROM_AGE_YRS"));
				mixed_dentition_from_age_days	= Integer.parseInt(rs.getString("MIXED_DENTITION_FROM_AGE_DAYS"));
				mixed_dentition_to_age_yrs		= Integer.parseInt(rs.getString("MIXED_DENTITION_TO_AGE_YRS"));
				mixed_dentition_to_age_days		= Integer.parseInt(rs.getString("MIXED_DENTITION_TO_AGE_DAYS"));
				rest_chrt_validity_days         = Integer.parseInt(rs.getString("REST_CHRT_VALIDITY_DAYS"));
				dflt_mixed_dentition_chart      = rs.getString("DFLT_MIXED_DENTITION_CHART");
				grace_period_days               = Integer.parseInt(rs.getString("DECIDUOUS_GRACE_PERIOD_DAYS"));
				currentAgeOfPatient				= rs.getString("PATIENT_AGE");
			}
			
			// get the age in years.
			int patientAgeAtIndex = currentAgeOfPatient.indexOf("Y");
			if(patientAgeAtIndex == -1)
			  patientAge = 0;
			else 
			  patientAge = Integer.parseInt(currentAgeOfPatient.substring(0,patientAgeAtIndex));

			if(currentAgeOfPatient.indexOf("D") != -1){
				//patientAgeDays = Integer.parseInt(currentAgeOfPatient.substring(currentAgeOfPatient.indexOf("M")+1,currentAgeOfPatient.indexOf("D")));
				//Commented by Sharon Crasta on 7/9/2009 for IN011768 and IN011782
				//patientAgeDays = Integer.parseInt(currentAgeOfPatient.substring(currentAgeOfPatient.indexOf("Y")+1,currentAgeOfPatient.indexOf("D")));
				patientAgeDays = Integer.parseInt(currentAgeOfPatient.substring(currentAgeOfPatient.indexOf("Y")+2,currentAgeOfPatient.indexOf("D")));
			}

			//Change made here to consider the Mixed Dentition Period to display chart in this period and set chart_type with corresponding values.
			
			//Commented by Sharon Crasta on 7/9/2009 for IN011768 and IN011782
			/*if(patientAge < mixed_dentition_from_age_yrs){
				PD_flag = "D"; // Deciduous
				chart_type = "RD";
			}
			
			else if(patientAge == mixed_dentition_from_age_yrs){
				if(patientAgeDays < mixed_dentition_to_age_days){
					PD_flag = "D"; // Deciduous
					chart_type = "RD";
				}
				else{
					chart_type = "RM";
				}
			}
			
			if(patientAge > mixed_dentition_to_age_yrs ){
				PD_flag = "P"; // Permament
				chart_type = "RA";
			}
			
			else if(patientAge == mixed_dentition_to_age_yrs ){
				if( patientAgeDays > mixed_dentition_to_age_days){
					PD_flag = "P"; // Permament
					chart_type = "RA";
				}
				else{
					chart_type = "RM";
				}
			}
			
			if(patientAge>=mixed_dentition_from_age_yrs && patientAge<=mixed_dentition_to_age_yrs){
				MD_yn = "Y"; // Mixed Dentition
				chart_type = "RM";
				//out.println("patientAgeDays : "+patientAge + ":"+ mixed_dentition_from_age_yrs);

				if(patientAge == mixed_dentition_from_age_yrs){
					if((grace_period_days -(patientAgeDays-mixed_dentition_to_age_days)) > 0){
						deciduous_grace_period_valid = "Y";
					}
					else{
						deciduous_grace_period_valid = "N";
					}

				}
				
				if(dflt_mixed_dentition_chart.equals("D")){
					PD_flag = "D"; // Deciduous
				}
				else{
					PD_flag = "P"; // Permament
				}
			}*/
			if(patientAge < mixed_dentition_from_age_yrs){
					PD_flag = "D"; // Deciduous
					chart_type = "RD";
			}
			else if((patientAge == mixed_dentition_from_age_yrs)&& (patientAgeDays < mixed_dentition_from_age_days)){
				PD_flag = "D"; // Deciduous
				chart_type = "RD";
			}
			else if(patientAge >= mixed_dentition_from_age_yrs && patientAge <= mixed_dentition_to_age_yrs){
				if((patientAge == mixed_dentition_from_age_yrs) && (patientAge == mixed_dentition_to_age_yrs)){
					if(patientAgeDays > mixed_dentition_to_age_days) {
						chart_type="RA";
						PD_flag="P";
					}
					else if((patientAgeDays <= (mixed_dentition_from_age_days + grace_period_days)) && ((mixed_dentition_from_age_days + grace_period_days) <= mixed_dentition_to_age_days)){
						deciduous_grace_period_valid = "Y";
						MD_yn = "Y"; // Mixed Dentition
						PD_flag = "D";
						chart_type = "RD";
					}
					else{
						deciduous_grace_period_valid = "N";
						MD_yn = "Y"; // Mixed Dentition
						chart_type = "RM";
						if(dflt_mixed_dentition_chart.equals("D")){
							PD_flag = "D"; // Deciduous
						}
						else{
							PD_flag = "P"; // Permament
						}
					}
				}
				else if((patientAge == mixed_dentition_from_age_yrs) && (patientAge < mixed_dentition_to_age_yrs)){
					if(patientAgeDays <= (mixed_dentition_from_age_days + grace_period_days)){
						deciduous_grace_period_valid = "Y";
						MD_yn = "Y"; // Mixed Dentition
						PD_flag = "D";
						chart_type = "RD";
					}
					else {
						deciduous_grace_period_valid = "N";
						MD_yn = "Y"; // Mixed Dentition
						chart_type = "RM";
						if(dflt_mixed_dentition_chart.equals("D")){
							PD_flag = "D"; // Deciduous
						}
						else{
							PD_flag = "P"; // Permament
						}
					}
				}
				else if((patientAge > mixed_dentition_from_age_yrs) && (patientAge < mixed_dentition_to_age_yrs)){
					deciduous_grace_period_valid = "N";
					MD_yn = "Y"; // Mixed Dentition
					chart_type = "RM";
					if(dflt_mixed_dentition_chart.equals("D")){
						PD_flag = "D"; // Deciduous
					}
					else{
						PD_flag = "P"; // Permament
					}
				}
				else if(patientAge == mixed_dentition_to_age_yrs){ 
						if(patientAgeDays > mixed_dentition_to_age_days) {
							chart_type="RA";
							PD_flag="P";
						}
						else{
							deciduous_grace_period_valid = "N";
							MD_yn = "Y"; // Mixed Dentition
							chart_type = "RM";
							if(dflt_mixed_dentition_chart.equals("D")){
								PD_flag = "D"; // Deciduous
							}
							else{
								PD_flag = "P"; // Permament
							}
						}
					}
				else{
					deciduous_grace_period_valid = "N";
					MD_yn = "Y"; // Mixed Dentition
					chart_type = "RM";
					if(dflt_mixed_dentition_chart.equals("D")){
						PD_flag = "D"; // Deciduous
					}
					else{
						PD_flag = "P"; // Permament
					}
				}
			}
			else if (patientAge == mixed_dentition_to_age_yrs){
				if(patientAgeDays > mixed_dentition_to_age_days){
					chart_type="RA";
					PD_flag="P";
				}
			}
			else if(patientAge > mixed_dentition_to_age_yrs){
				chart_type="RA";
				PD_flag="P";				
			}
			//End
			
			params = "&chart_name="+chart_name+"&tooth_numbering_system="+tooth_numbering_system+"&numbering_system_desc="+numbering_system_desc+"&permanent_deciduous_flag=P"+"&chart_type="+chart_type+"&dflt_mixed_dentition_chart="+dflt_mixed_dentition_chart+"&MD_yn="+MD_yn+"&oh_chart_level="+oh_chart_level;
			
			out.println(params);
			
	}
}catch(Exception e){
	System.err.println("Err Msg from buildPerioPramaeter.jsp "+e);
	System.err.println("func_mode== "+func_mode);
}
finally{
	if(rs!=null) rs.close();
	if(pstmt!=null)pstmt.close();
	if(con!=null)
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
