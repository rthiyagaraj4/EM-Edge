package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import org.json.simple.*;

public final class __opintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/OPIntermediate.jsp", 1728387908919L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	con = ConnectionManager.getConnection(request);

try{
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String action = (String) hash.get("action")==null?"":(String) hash.get("action");

	if(action.equals("getSystemDateTime")){
		String sysDateTime = eCommon.Common.CommonBean.getSystemDateTime(con);
		out.println(sysDateTime);
	}
	
	/*Added by Arthi on 30-May-2022 for MOHE-CRF-0134*/
	if(action.equals("getFacilityValue")){

		String p_user_name = (String) hash.get("p_user_name");
		String locale = (String) hash.get("locale");
		String p_resp_id = (String) hash.get("p_resp_id");
		String p_gov_code = (String) hash.get("p_gov_code");

		JSONArray FacilityValueJsonArr = new JSONArray();
		FacilityValueJsonArr = eOP.OPCommonBean.getFacilityValue(con,p_user_name,locale,p_resp_id,p_gov_code);
		String FacilityCodeDesc = "";

		for(int i = 0 ; i < FacilityValueJsonArr.size() ; i++) 
		{
			JSONObject json	= (JSONObject)FacilityValueJsonArr.get(i);
			String facility_id = (String) json.get("facility_id");
			String facility_name = (String) json.get("facility_name");

			if(FacilityCodeDesc != ""){
				FacilityCodeDesc = FacilityCodeDesc+"##"+facility_id+"~~"+facility_name;
			}else{
				FacilityCodeDesc = facility_id+"~~"+facility_name;
			}
		}

		out.println(FacilityCodeDesc);
	} else if(action.equals("visit_clinic")){
		String locn_code    = (String) hash.get("assign_care_locn_code");
		String locn_type = (String) hash.get("locn_type");
		String patient_id = (String) hash.get("patient_id");
		String speciality_code = (String) hash.get("speciality_code");
		String service_code = (String) hash.get("service_code");
		String facility_id = (String) hash.get("facility_id");
		String CATEGORY="";
		String REFERRAL_ID="";
		
		String sqlClinic="select category from op_clinic  where facility_id='"+facility_id+"' and clinic_code='"+locn_code+"'and clinic_type='"+locn_type+"'" ;
		
		PreparedStatement pstmt=null;
		ResultSet rs    = null; 
		pstmt   = con.prepareStatement(sqlClinic);
		rs = pstmt.executeQuery();
		if( rs != null ) {
			if( rs.next() ) {
				CATEGORY = rs.getString( "category" );
			}
		}	
		System.err.println("CATEGORY==="+CATEGORY);
		String sqlClinic1="SELECT REFERRAL_ID FROM PR_ENCOUNTER WHERE PATIENT_ID='"+patient_id+"' AND VISIT_ADM_TYPE_IND='F' AND SPECIALTY_CODE='"+speciality_code+"' AND SERVICE_CODE='"+service_code+"' AND ASSIGN_CARE_LOCN_TYPE='"+locn_type+"' AND ASSIGN_CARE_LOCN_CODE='"+locn_code+"'";
		System.err.println("sqlClinic1==="+sqlClinic1);
		pstmt   = con.prepareStatement(sqlClinic1);
		rs = pstmt.executeQuery();
		if( rs != null ) {
			if( rs.next() ) {
				REFERRAL_ID = rs.getString( "REFERRAL_ID" );
			}
		}
		System.err.println("REFERRAL_ID=="+REFERRAL_ID);
		out.println(CATEGORY+","+REFERRAL_ID);
	} else if(action.equals("visit_clinic_referalId")){
		String referal_id    = (String) hash.get("referal_id");
		String locale = (String) hash.get("locale");
		String ref_dtls="";
		PreparedStatement pstmt=null;
		ResultSet rs    = null; 
				
		pstmt  = con.prepareStatement("select get_referral_detail_line('"+referal_id+"','FROM','"+locale+"') from dual");
		rs = pstmt.executeQuery() ;
		if( rs != null ) {
			if( rs.next() ) {
				ref_dtls = checkForNull(rs.getString(1));
				if(!ref_dtls.equals(""))
					ref_dtls = ref_dtls.substring(2);
				out.println(ref_dtls);
			}
		}
	}/*End MOHE-CRF-0134*/
//Added by Kamatchi S for MMS-DM-CRF-0223 START
else if(action.equals("Speciality")){
		String selected_loc_code    = (String) hash.get("selected_loc_code");
		String locale = (String) hash.get("locale");
		String spec="";
		PreparedStatement pstmt=null;
		ResultSet rs    = null; 
				
		pstmt  = con.prepareStatement("select SPECIALITY_CODE from op_clinic where clinic_code = '"+selected_loc_code+"' ");
		rs = pstmt.executeQuery() ;
		if( rs != null ) {
			if( rs.next() ) {
				spec = checkForNull(rs.getString(1));
				out.println(spec);
			}
		}
	} //Added by Kamatchi S for MMS-DM-CRF-0223 END
 else if(action.equals("isVirtualVisit")){ //Added by Ajay Hatwate for ML-MMOH-CRF-1930
	String visit_type_code = (String) hash.get("visit_type_code");
	String facility_id = (String) hash.get("facility_id");
	String isVC="";
	PreparedStatement pstmt=null;
	ResultSet rs    = null; 
	pstmt  = con.prepareStatement("select virtual_consultation from op_visit_type where visit_type_code = '"+visit_type_code+"' and facility_id = '"+facility_id+"' and eff_status = 'E' ");
	rs = pstmt.executeQuery() ;
	if( rs != null ) {
		if( rs.next() ) {
			isVC = checkForNull(rs.getString(1));
			out.println(isVC);
		}
	}	
	
}
else if(action.equals("checkQueueNoExists")){//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 08-05-2023 Started-->
		String Patient_id = (String) hash.get("Patient_id");
		String QUEUE_NUM = (String) hash.get("QUEUE_NUM");
		String encntrid = (String) hash.get("encntrid");
		String clinic_code = (String) hash.get("clinic_code");
		String isVC="";
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		ResultSet rs    = null; 
		ResultSet rst    = null; 
		int count=0;
		boolean iscount=false;
		String Sql="select count(QUEUE_NUM) as cnt from op_patient_queue where Locn_code='"+clinic_code+"' and UPPER(QUEUE_NUM)=UPPER('"+QUEUE_NUM+"') and QUEUE_NUM!='0' and TO_CHAR(ARRIVE_DATE_TIME, 'DD-MON-YYYY') =TO_CHAR(SYSDATE, 'DD-MON-YYYY') and LOCN_TYPE='C' ";  
		pstmt  = con.prepareStatement(Sql);
		rs = pstmt.executeQuery() ;
		if( rs != null ){
			if( rs.next()) {
				isVC = checkForNull(rs.getString(1));
					if(isVC!=""){
						count=Integer.parseInt(isVC);
					}else{
						count=0;
					}
				 if(count>0){
					iscount=true;
					Sql="select count(QUEUE_NUM) as cnt from op_patient_queue where  ENCOUNTER_ID='"+encntrid+"'  and Patient_id='"+Patient_id+"' and Locn_code='"+clinic_code+"' and UPPER(QUEUE_NUM)=UPPER('"+QUEUE_NUM+"') and QUEUE_NUM!='0' and TO_CHAR(ARRIVE_DATE_TIME, 'DD-MON-YYYY') =TO_CHAR(SYSDATE, 'DD-MON-YYYY') and LOCN_TYPE='C' "; 
					pstmt1  = con.prepareStatement(Sql);
					rst = pstmt1.executeQuery() ;
					if( rst != null ) {
						if( rst.next() ) {
							isVC = checkForNull(rst.getString(1));
							
							if(isVC!=""){
								count=Integer.parseInt(isVC);
							}else{
								count=0;
							}
							if(count==1){
								iscount=false;
							}
						}
					}
				 }
				
				out.println(iscount);
			}
		}	
		
	}	//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 08-05-2023 Ended-->
	//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 08-05-2023 Started-->
/* else if(action.equals("updateQueueNo"))
		{
		String Patient_id = (String) hash.get("Patient_id");
		String QUEUE_NUM = (String) hash.get("QUEUE_NUM");
		String encntrid = (String) hash.get("encntrid");
		PreparedStatement pstmt=null;
		ResultSet rs    = null; 
		int count=0;
		boolean iscount=false;
		try
			{
			con		= ConnectionManager.getConnection(request);	
			String sql	= "update op_patient_queue set queue_num='"+QUEUE_NUM+"' where patient_id='"+Patient_id+"' and Encounter_id='"+encntrid+"'";
			pstmt = con.prepareStatement(sql.toString());
			count=pstmt.executeUpdate();
			if(count>0)
			{
				out.println("ok");
				con.commit();
			}else
			{
				out.println("Failed");
			}
			}
		catch(Exception e)
			{
			e.printStackTrace();
			}
		finally
			{
			con.close();
			}
		
	}//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 08-05-2023 Ended-->
	*/

}catch(Exception e){ 
	e.printStackTrace();	
}finally{ 
	if(con != null){
		ConnectionManager.returnConnection(con,request);
	}	
}                           

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
