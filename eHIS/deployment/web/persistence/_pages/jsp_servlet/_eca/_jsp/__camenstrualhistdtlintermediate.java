package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.*;
import eCA.Common.*;
import java.text.SimpleDateFormat;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __camenstrualhistdtlintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMenstrualHistDtlIntermediate.jsp", 1733118848116L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
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
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
29/04/2024     58928	     Krishna pranay	         30/04/204         Ramesh Goli       	ML-MMOH-CRF-1759.2
01/10/2024     68508     krishna pranay             13/10/2024  Ashwini Ragupathi  ML-MMOH-CRF-1759							

--------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

Connection con=null;
con=ConnectionManager.getConnection(request);
PreparedStatement pstmt=null;
ResultSet rs=null;
try {
		Hashtable hashObj = (Hashtable) XMLobj.parseXMLString(request);
		hashObj = (Hashtable) hashObj.get("SEARCH");
		String patient_id = (String) hashObj.get("patient_id") == null ? "": (String) hashObj.get("patient_id");
		String action = (String) hashObj.get("p_action") == null ? "": (String) hashObj.get("p_action");
		String facilityID = (String) hashObj.get("facilityID") == null ? "": (String) hashObj.get("facilityID");
		String lmpDateStr = (String) hashObj.get("lmp_date") == null ? "": (String) hashObj.get("lmp_date");
		String scanGestWeeksStr = (String) hashObj.get("scanGestationWeeks") == null ? "": (String) hashObj.get("scanGestationWeeks");
		String scanGestDaysStr = (String) hashObj.get("scanGestationDays") == null ? "": (String) hashObj.get("scanGestationDays");
		String or_bean_id 						= "@CAMenstrualHistDtlTransBean";
		String or_bean_name 					= "eCA.CAMenstrualHistDtlTransBean";
		CAMenstrualHistDtlTransBean bean		= (CAMenstrualHistDtlTransBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
		
		 int[] ageDetails = bean.getMenstrualAgeDetails(facilityID);
		  int minAge = ageDetails[0];
		  int maxAge = ageDetails[1];

		 if("CHK_PAT_VALID_YN".equals(action)){
			 int pat_count=0;
			 pstmt = con.prepareStatement( "SELECT COUNT(*) TOTAL_COUNT FROM MP_PATIENT WHERE PATIENT_ID =? " ) ;
				pstmt.setString(1,patient_id);
				rs = pstmt.executeQuery() ;
				while ( rs != null && rs.next() ) {
					pat_count =  rs.getInt("TOTAL_COUNT");
				    out.print(pat_count);
				}
    		}
		 else if("CHK_PATIENT_RANGE".equals(action))
		 {
			int pat_count=0;
			String gender="";
			String age="";
			Integer patientAge 	= 0;

			pstmt = con.prepareStatement("SELECT SEX,GET_AGE(DATE_OF_BIRTH) AGE FROM MP_PATIENT WHERE PATIENT_ID=?" ) ;
			pstmt.setString(1, patient_id);
			rs = pstmt.executeQuery() ;
			if( rs != null ) {
			if( rs.next() ) {
			gender = rs.getString("SEX")==null?"":(String)rs.getString("SEX");
			age = rs.getString("AGE")==null?"":(String)rs.getString("AGE");
			}
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				
				
				if (age != null && age.length() > 1) {
					if(age.indexOf('Y')!=-1)
						patientAge = Integer.parseInt(age.substring(0, age.indexOf('Y')));

			    }
				
				
				if(gender.equals("F") && (patientAge < minAge || patientAge > maxAge))
					out.println("N");
				else
					out.println("Y"); 
		 }
		 else if("CHK_PATIENT_GENDER".equals(action))
		 {
			int pat_count=0;
			String gender="";
			pstmt = con.prepareStatement("SELECT SEX FROM MP_PATIENT WHERE PATIENT_ID=?" ) ;
			pstmt.setString(1, patient_id);
			rs = pstmt.executeQuery() ;
			if( rs != null ) {
			if( rs.next() ) {
			gender = rs.getString("SEX")==null?"":(String)rs.getString("SEX");
			}
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				
							
				if(!gender.equals("F"))
					out.println("N");
				else
					out.println("Y"); 
		 }
		 else if ("CHK_PATIENT_AVAILABLE".equals(action)) {
			 String result = "";
			    ArrayList patientDetails = bean.getPatientAvaliable(patient_id, facilityID);
			    if (patientDetails.size() > 0) {
			        for (int i = 0; i < patientDetails.size(); i++) {
			            String[] record = (String[]) patientDetails.get(i);
			            patient_id = CommonBean.checkForNull(record[0]);
			            String encounter_id = CommonBean.checkForNull(record[1]);
			            String episode_id = CommonBean.checkForNull(record[2]);
			            result = patient_id + "," + encounter_id + "," + episode_id;
			        }
			    }
			    out.print(result);
			}else if ("CHK_LMP_DATE".equals(action) && lmpDateStr != null) {
			 String[] eddDetails = bean.getEddOfLmpDate(lmpDateStr);
	            
	            String edd = eddDetails[0];        // Estimated Delivery Date
	            String gestWeeks = eddDetails[1];  // Gestation weeks
	            String remDays = eddDetails[2];    // Remaining days

	            // Prepare and print the XML result
	            StringBuilder result = new StringBuilder();
	            result.append("<result>");
	            result.append("<edd>").append(edd).append("</edd>");
	            result.append("<gestationWeeks>").append(gestWeeks).append("</gestationWeeks>");
	            result.append("<gestationDays>").append(remDays).append("</gestationDays>");
	            result.append("</result>");

	            // Output result to JSP
	            out.print(result.toString());
	            System.out.println("Result XML: " + result.toString());
    	}
		 else if ("CHK_UNSURE_PRE_DATE".equals(action) && scanGestWeeksStr != null && scanGestDaysStr != null) {
			    // Convert input parameters to integers
			    int scanGestWeeks = Integer.parseInt(scanGestWeeksStr);
			    int scanGestDays = Integer.parseInt(scanGestDaysStr);

			    // Call the calculateUnsurePreDate method and get the results
			    String[] unsurePreDateDetails = bean.calculateUnsurePreDate(scanGestWeeks, scanGestDays);

			    String lmpDate = unsurePreDateDetails[0];       // Last Menstrual Period (LMP) Date
			    String reddDate = unsurePreDateDetails[1];      // Expected Delivery Date (REDD)
			    String pogWeeks = unsurePreDateDetails[2];      // Gestation in weeks
			    String pogDays = unsurePreDateDetails[3];       // Remaining days of gestation

			    // Prepare and print the XML result
			    StringBuilder result = new StringBuilder();
			    result.append("<result>");
			    result.append("<lmpDate>").append(lmpDate).append("</lmpDate>");
			    result.append("<reddDate>").append(reddDate).append("</reddDate>");
			    result.append("<gestationWeeks>").append(pogWeeks).append("</gestationWeeks>");
			    result.append("<gestationDays>").append(pogDays).append("</gestationDays>");
			    result.append("</result>");

			    // Output the result to JSP
			    out.print(result.toString());
			    System.out.println("Result XML: " + result.toString());
			}

		}
	catch (Exception ex) {
		ex.printStackTrace();
	}
finally
{
    if(rs != null)
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	if(pstmt != null)
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	if(con != null) 
		try {
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
}

        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
