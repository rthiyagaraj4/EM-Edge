package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __recordpatientadverseevent2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecordPatientAdverseEvent2.jsp", 1744006311359L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n\t<head>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"></link>\n\t\t<script src=\"../../eCommon/js/messages.js\"></script>\n\t   <script src=\"../../eMR/js/RecordPatientAdverseEvent.js\"></script>\n\t</head>\n<style>\ntextarea {\n  resize: none;\n}\n</style>\t\n\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<title>";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</title>\n<!-- <body onLoad=\"clear_session()\" OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' >   -->\n\n<!--<frameset id =\'allergy_recording\' rows=\'18%,30%,45%,25%,5%,0%,5%\' >-->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="<frameset id =\'allergy_recording\' rows=\'8%,6%,1%,11%,5%,0%,5%\' >\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<!--<frameset id =\'allergy_recording\' rows=\'8%,8%,1%,8%,5%,0%,5%,2%\' >-->\n<frameset id =\'allergy_recording\' rows=\'15%,6%,1%,11%,5%,0%,5%,2%\' >  \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<frame scrolling=\'no\' name=\'resultpage\' src=\'../../eMR/jsp/RecordPatientAdverseEventsearch.jsp?CA=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&PatientId=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&Encounter_Id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&Pract_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&practitioner_type=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&patient_class=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&allergy_conf_reqd_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&sPhInstalled_YN=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' noresize frameborder=0 >\n\t<frame scrolling=\'auto\' name=\'resultpage\' src=\'../../eMR/jsp/RecordPatientAdverseEvent4.jsp?norecord=noreords&status_val=A&modeResult=result&PatientId=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' noresize frameborder=0 >\n\t<frame scrolling=\'no\' name=\'staticcolorpage\' src=\'../../eMR/jsp/RecordPatientAdverseEvent7.jsp?PatientId=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' noresize frameborder=0 > \n\t<!-- Below lines scrolling added by venkatesh.S against ML-MMOH-CRF-0366 -->\n\t<frame scrolling=\'auto\' name=\'Headerpage\' src=\'../../eMR/jsp/RecordPatientAdverseEvent5.jsp?PatientId=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&Dob=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&Locn_Code=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&location_type=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&speciality_code=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&disable_event_type=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&disable_known_allergy=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&isPatientEncMovement=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&Sydate=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&p_queue_date=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&p_queue_status=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'  noresize frameborder=0 >\n\t<frame  id=\'reaction_details_page\' scrolling=\"auto\" name=\'reaction_view\'  src=\'../../eMR/jsp/RecordPatientAdverseEvent13.jsp?PatientId=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'  noresize frameborder=0> \n\t<frame scrolling=\"no\" name=\'detail_view\' src=\'../../eMR/jsp/RecordPatientAdverseEvent6.jsp?PatientId=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'  noresize frameborder=0> \n\t<frame name=\'submitframe\'  src=\'../../eMR/jsp/RecordPatientAdverseEvent9.jsp?p_called_from_widget=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'  frameborder=0 noresize scrolling=\'no\'> <!-- CHL-CRF- 0008 - IN:001472 -- >\n\t<!--Above line modified for this CRF Bru-HIMs-CRF-133 -->\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t<frame name=\'messageFrame\'\tsrc=\'../../eCommon/jsp/MstCodeError.jsp\' frameborder=0 noresize scrolling=\'no\'>\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t</frameset>\n\n</body>\t\n</html> \n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	String sPhInstalled_YN = "N";
	String PatientId=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String Encounter_Id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

	String Pract_id=request.getParameter("Pract_id")==null?"":request.getParameter("Pract_id");
	String practitioner_type=request.getParameter("practitioner_type")==null?"":request.getParameter("practitioner_type");
	String patient_class=request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String Dob=request.getParameter("Dob")==null?"":request.getParameter("Dob");
	String CA=request.getParameter("CA")==null?"":request.getParameter("CA");
	String Locn_Code=request.getParameter("Locn_Code")==null?"":request.getParameter("Locn_Code");
	if(Locn_Code.equals(""))
		Locn_Code				= checkForNull(request.getParameter("location_code"));
	String location_type			= checkForNull(request.getParameter("location_type"));   
		if(location_type.equals("")) location_type="C";
	String speciality_code		= checkForNull(request.getParameter("speciality_code"));
	String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":(String)request.getParameter("p_called_from_widget"); //CHL-CRF- 0008 - IN:001472 
     /*Below line added for this CRF Bru-HIMS-CRF-133*/	
      String isPatientEncMovement=request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
      String Sydate=request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
      String p_queue_date=request.getParameter("p_queue_date")==null?"":request.getParameter("p_queue_date");
      String p_queue_status=request.getParameter("p_queue_status")==null?"":request.getParameter("p_queue_status");
	  //End this CRF Bru-HIMS-CRF-133
	//10/23/2008 codenaddded by anjaneya reddy  10:03 AM
	session.removeAttribute("DETAILS_CODE");
	
	Connection con = ConnectionManager.getConnection(request);
	  ResultSet rs = null;
	  Statement stmt = con.createStatement();
	  PreparedStatement pstmt = null;
	  String allergy_conf_reqd_yn="";
	  try{
		  String sql="SELECT allergy_conf_reqd_yn FROM mr_parameter";
		  
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				allergy_conf_reqd_yn=checkForNull(rs.getString("allergy_conf_reqd_yn"),"N");
			}
			
			//Added against TTM-SCF-0107 - start
			String facility_id = (String)session.getAttribute("facility_id");
			String sql_phExists = "select decode(count(*),0,'N','Y') PH_INSTALLED_YN from SM_MODULES_FACILITY where module_id='PH' and facility_id='"+facility_id+"' and OPERATIONAL_YN='Y'";
			
			pstmt=con.prepareStatement(sql_phExists); 
			rs=pstmt.executeQuery();
			while(rs.next())
			{			
				sPhInstalled_YN=rs.getString("PH_INSTALLED_YN");
			}System.err.println("sPhInstalled_YN..."+sPhInstalled_YN);
			//passing this parameter -sPhInstalled_YN in the below frames - RecordPatientAdverseEventsearch.jsp and RecordPatientAdverseEvent5.jsp
			//Added against TTM-SCF-0107 - end
			
	  }catch(Exception e){
		  e.printStackTrace();
	  }finally{
		  if (stmt != null) stmt.close();
			if (rs != null) rs.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
	  }
	
	String disable_event_type="";
	String disable_known_allergy="";
	if(allergy_conf_reqd_yn.equals("Y")){
		disable_event_type="disabled";
		disable_known_allergy="disabled";
	}

	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(checkForNull(request.getParameter("title"))));
            _bw.write(_wl_block5Bytes, _wl_block5);
if(CA.equals("Y") && "".equals(p_called_from_widget)) //CHL-CRF- 0008 - IN:001472
{
            _bw.write(_wl_block6Bytes, _wl_block6);
}else{
            _bw.write(_wl_block7Bytes, _wl_block7);
}
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(CA));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Pract_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(allergy_conf_reqd_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sPhInstalled_YN));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Pract_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sPhInstalled_YN));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Pract_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Pract_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disable_event_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(allergy_conf_reqd_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disable_known_allergy));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_queue_status));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sPhInstalled_YN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Pract_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(allergy_conf_reqd_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_queue_status));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Pract_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(p_called_from_widget));
            _bw.write(_wl_block32Bytes, _wl_block32);
if(!(CA.equals("Y")) || !"".equals(p_called_from_widget)){ //CHL-CRF- 0008 - IN:001472
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
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
