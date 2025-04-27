package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __flowsheet extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/FlowSheet.jsp", 1742386690599L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<html>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&nbsp; ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script src=\"../../eCommon/js/common.js\"\t\t\tlanguage=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCA/js/FlowSheet.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<script>\n\t\t\t\t\twindow.document.title=getLabel(\"eCA.FlowSheet.label\",\"CA\")+\' - \'+(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\");\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<div id=\"myFrameSet\" style=\"border-style: solid; border-color: black; border-width: 2px;\">\n        ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n            <iframe src=\"../../eCA/jsp/FlowSheetCriteria.jsp?event_called=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" name=\"criteria_f1\" id=\"criteria_f1\" style=\"width: 98vw; height: 24vh; border: none;\" scrolling=\"no\"></iframe>\n        ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n        ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n            <iframe src=\"../../eCA/jsp/FlowSheetDetails.jsp?";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&p_review_rad_yn=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" name=\"details\" id=\"details\" style=\"width: 98vw; height: 75vh; border: none;\" scrolling=\"no\"></iframe>\n            <iframe src=\"../../eCommon/jsp/error.jsp\" name=\"messageFrame1\" id=\"messageFrame1\" style=\"width: 99vw; height: 10vh; border: none;\" scrolling=\"yes\"></iframe>\n        ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n            <iframe src=\"../../eCommon/html/blank.html\" name=\"details\" id=\"details\" style=\"width: 98vw; height: 65vh; border: none;\" scrolling=\"no\"></iframe>\n        ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n            <iframe src=\"../../eCommon/jsp/error.jsp\" name=\"messageFrame1\" id=\"messageFrame1\" style=\"width: 99vw; height: 10vh; border: none;\" scrolling=\"yes\"></iframe>\n        ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n        <iframe src=\"../../eCommon/html/blank.html\" name=\"addToGroupsFrame\" id=\"addToGroupsFrame\" style=\"width: 99vw; height: 0vh; border: none;\" scrolling=\"no\"></iframe>\n    </div>\n</html>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );
	
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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History   	Name        		Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           									created
13/12/2012		IN035950		Nijitha											CHL Hospital suggested that the presentation of the Clinician desktop 
																				be changed and more appealing. Keeping the display of information more clear and visible. 
19/01/2018  IN066218  		PRATHYUSHA P		28/1/2018		Ramesh G		ML-MMOH-CRF-0985.1												
03/02/2020			IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
12/04/2023		IN039052	Ramesh Goli											ML-BRU-CRF-0634
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
	
		
	String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

	String EHR_YN = request.getParameter("EHR_YN")==null?"N":request.getParameter("EHR_YN");
	String event_called = request.getParameter("event_called")==null?"":request.getParameter("event_called");
	//out.println("<script>alert('here"+event_called+"');</script>");

	String p_called_from		=	request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//IN035950
	String p_event_class		=	request.getParameter("p_event_class_widget")==null?"":request.getParameter("p_event_class_widget");//IN035950
	String hist_type = request.getParameter("hist_type")==null?"":request.getParameter("hist_type");//CHL_CRF_0044
	String title		=	request.getParameter("title");
	String encBeanKey = "";
	if(encounterid.equals("")) encBeanKey = "0";
	else encBeanKey = encounterid;

	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patientid+encBeanKey,"eCA.PatientBannerGroupLine",session);
	manageEmailBean.clearBean();
	

            _bw.write(_wl_block4Bytes, _wl_block4);

	if(EHR_YN.equals("N")){
		//CHL_CRF_0044 Start
	if("CA_RESULTS_WIDGET".equals(p_called_from)){
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(title));
            _bw.write(_wl_block6Bytes, _wl_block6);

	}else{
//CHL_CRF_0044 End

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	}//CHL_CRF_0044
}
else{

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block8Bytes, _wl_block8);

}

            _bw.write(_wl_block10Bytes, _wl_block10);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String episode_id = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
		String from_date = request.getParameter("from_date")==null?"":request.getParameter("from_date");
		String facilityId = request.getParameter("facilityId")==null?"":request.getParameter("facilityId");
		String flowsheet_id = request.getParameter("flowsheet_id")==null?"":request.getParameter("flowsheet_id");
		String enc_called_from = request.getParameter("enc_called_from")==null?"":request.getParameter("enc_called_from");
		String ql_ref = request.getParameter("ql_ref")==null?"":request.getParameter("ql_ref");
		String default_yn = request.getParameter("default_yn")==null?"":request.getParameter("default_yn");

		String practitioner_id = (String)session.getValue("ca_practitioner_id") == null ? "" : (String)session.getValue("ca_practitioner_id");
		String 	login_user_id		=	(String) session.getValue("login_user");
		String relationship_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
		//IN066218 Start.
		String che_default_mode=request.getParameter("che_default_mode")==null?"T":request.getParameter("che_default_mode"); 
		String calling_from_2T=request.getParameter("calling_from_2T")==null?"N":request.getParameter("calling_from_2T");
		String history_type_2T=request.getParameter("history_type")==null?"":request.getParameter("history_type");
		String event_class_2T=request.getParameter("event_class")==null?"":request.getParameter("event_class");
		String from_date_2T=request.getParameter("from_date")==null?"":request.getParameter("from_date");
		String to_date_2T=request.getParameter("to_date")==null?"":request.getParameter("to_date");
		String event_item_2T=request.getParameter("event_item")==null?"":request.getParameter("event_item");
		String order_type_3T=request.getParameter("order_type_3T")==null?"":request.getParameter("order_type_3T"); //39052
		String event_class_3T=request.getParameter("event_class_3T")==null?"":request.getParameter("event_class_3T");//39052
		
		String archivalYN	= request.getParameter("archivalYN")==null?"": request.getParameter("archivalYN"); //52176
		
		//IN066218 End.
		if(encounterid.equals(""))
		{
			encounterid = episode_id;
		}

		String pat_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
		//String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&facilityId="+facilityId+"&patient_class="+pat_class+"&flowsheet_id="+flowsheet_id+"&called_from="+enc_called_from+"&ql_ref="+ql_ref+"&EHR_YN="+EHR_YN+"&default_yn="+default_yn+"&relationship_id="+relationship_id;//IN035950
		//IN066218 Start.
		//  String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&facilityId="+facilityId+"&patient_class="+pat_class+"&flowsheet_id="+flowsheet_id+"&called_from="+enc_called_from+"&ql_ref="+ql_ref+"&EHR_YN="+EHR_YN+"&default_yn="+default_yn+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&hist_type="+hist_type;//IN035950
		//String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&facilityId="+facilityId+"&patient_class="+pat_class+"&flowsheet_id="+flowsheet_id+"&called_from="+enc_called_from+"&ql_ref="+ql_ref+"&EHR_YN="+EHR_YN+"&default_yn="+default_yn+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&hist_type="+hist_type+"&calling_from_2T="+calling_from_2T+"&history_type="+history_type_2T+"&event_class="+event_class_2T+"&from_date="+from_date_2T+"&to_date="+to_date_2T+"&event_item="+event_item_2T+"&che_default_mode="+che_default_mode;//IN066218//IN071561
		//39052 Start.
		//String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&facilityId="+facilityId+"&patient_class="+pat_class+"&flowsheet_id="+flowsheet_id+"&called_from="+enc_called_from+"&ql_ref="+ql_ref+"&EHR_YN="+EHR_YN+"&default_yn="+default_yn+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&hist_type="+hist_type+"&calling_from_2T="+calling_from_2T+"&history_type="+history_type_2T+"&event_class="+event_class_2T+"&from_date="+from_date_2T+"&to_date="+to_date_2T+"&event_item="+event_item_2T+"&che_default_mode="+che_default_mode+"&p_review_rad_yn="+p_review_rad_yn;//IN066218//IN071561
		String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&facilityId="+facilityId+"&patient_class="+pat_class+"&flowsheet_id="+flowsheet_id+"&called_from="+enc_called_from+"&ql_ref="+ql_ref+"&EHR_YN="+EHR_YN+"&default_yn="+default_yn+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&hist_type="+hist_type+"&calling_from_2T="+calling_from_2T+"&history_type="+history_type_2T+"&event_class="+event_class_2T+"&from_date="+from_date_2T+"&to_date="+to_date_2T+"&event_item="+event_item_2T+"&che_default_mode="+che_default_mode+"&p_review_rad_yn="+p_review_rad_yn+"&order_type_3T="+order_type_3T+"&event_class_3T="+event_class_3T+"&archivalYN="+archivalYN;
		//39052
		//IN066218 End.

		String called_from = request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
		String rows="";
		String patient_details ="";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			con = ConnectionManager.getConnection(request);
			if(practitioner_id.equals(""))
			{
				pstmt = con.prepareStatement("select func_role_id from sm_appl_user where appl_user_id = ?");
				pstmt.setString(1,login_user_id);
				rs = pstmt.executeQuery();

				if(rs.next())
				{
					practitioner_id = rs.getString("func_role_id");
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();

				session.putValue("ca_practitioner_id",practitioner_id);
			}
		}
		catch(Exception e)
		{
			//out.println("Exception @ try:"+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			try{
					
				if(con != null) ConnectionManager.returnConnection(con,request);
			}catch(Exception e){
			
			out.println("Exception @ FlowSheet.jsp"+e.toString());
			}
		}

		if(called_from.equals("OR")){
			patientid = request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
			rows="*,6%,0%";
			
			try{
				con = ConnectionManager.getConnection(request);
				
				pstmt = con.prepareStatement("select get_patient.get_line_detail(?,?) Pline FROM dual");
				pstmt.setString(1,patientid);
				pstmt.setString(2,locale);

				rs = pstmt.executeQuery();

				while(rs.next()){
					patient_details = rs.getString("Pline");
				}
				
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_details));
            _bw.write(_wl_block12Bytes, _wl_block12);

			
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch(Exception e){
				//out.println("Exception @ try:"+e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}

			finally{
				try{
					
					if(con != null) ConnectionManager.returnConnection(con,request);
				}catch(Exception e){
				
				out.println("Exception @ FlowSheet.jsp"+e.toString());
				}
			}
		}else{
			// Modified by kishore kumar N on 19-12-2008 for CRF 0387 after css changes.
			//CHL-CRF Start [Ramesh]
			if("CA_RESULTS_WIDGET".equals(p_called_from)){ 
				rows="24%,*,6%,0%"; // modified from 22 to 24 for IN058886
			}else{
			//CHL-CRF End[Ramesh]
				rows="24%,*,0%"; // modified from 22 to 24 for IN058886
			} //CHL-CRF [Ramesh]
		}
		

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block13Bytes, _wl_block13);
 if(!called_from.equals("OR")) { 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(event_called));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(params));
            _bw.write(_wl_block16Bytes, _wl_block16);
 } 
            _bw.write(_wl_block17Bytes, _wl_block17);
 if(called_from.equals("OR")) { 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_review_rad_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
 } else { 
            _bw.write(_wl_block21Bytes, _wl_block21);
 } 
            _bw.write(_wl_block17Bytes, _wl_block17);
 if("CA_RESULTS_WIDGET".equals(p_called_from)) { 
            _bw.write(_wl_block22Bytes, _wl_block22);
 } 
            _bw.write(_wl_block23Bytes, _wl_block23);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.FlowSheet.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ClinicalEventsCentralRepFor.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
