package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eOR.*;
import eCA.Common.*;
import eOR.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __ormainprocedureintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eOR/jsp/ORMainProcedureIntermediate.jsp", 1721708035533L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1669269240919L ,"10.3.6.0","Asia/Calcutta")) return true;
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
12/06/2024  50627    Twinkle Shah    12/06/2024		Ramesh Goli        ML-MMOH-CRF-2106
--------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
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
		String p_facility_id = (String) hashObj.get("p_facility_id") == null ? "": (String) hashObj.get("p_facility_id");
		String p_patient_id = (String) hashObj.get("p_patient_id") == null ? "": (String) hashObj.get("p_patient_id");
		String p_encounter_id = (String) hashObj.get("p_encounter_id") == null ? "": (String) hashObj.get("p_encounter_id");

		String action = (String) hashObj.get("p_action") == null ? "": (String) hashObj.get("p_action");
		
		 if("POPUP_ENCOUNTER".equals(action))
		 {
			String patientcls="";
			String encounterId="";
			StringBuffer dataQuery =new StringBuffer(); 
			dataQuery.append("SELECT A.PATIENT_CLASS,A.ENCOUNTER_ID ENCOUNTER_ID FROM PR_ENCOUNTER A, MP_PATIENT B WHERE A.PATIENT_ID = B.PATIENT_ID AND A.PATIENT_ID = ? AND ( ( A.PATIENT_CLASS IN ('IP', 'DC') AND A.ADT_STATUS NOT IN ('00', '09') ) OR ( A.PATIENT_CLASS IN('OP', 'EM') AND A.VISIT_STATUS NOT IN('01', '02', '99') ) ) AND A.FACILITY_ID = ? AND DISCHARGE_DATE_TIME IS NULL ORDER BY A.ADDED_DATE DESC");
            pstmt = con.prepareStatement(dataQuery.toString());
			pstmt.setString(1,p_patient_id);
		    pstmt.setString(2,p_facility_id);
				out.println( "clearEncounterList();");
				rs = pstmt.executeQuery() ;
				while ( rs != null && rs.next()){
				patientcls =  rs.getString("PATIENT_CLASS");
				encounterId =  rs.getString("ENCOUNTER_ID");
				out.println( "addEncounterList(\"" + encounterId + "\",\"" + encounterId + "\") ; " ) ;	
          }
		 }
		 else if("CHK_PAT_VALID_YN".equals(action)){
			 int pat_count=0;
			 pstmt = con.prepareStatement( "SELECT COUNT(*) TOTAL_COUNT FROM MP_PATIENT WHERE PATIENT_ID =? " ) ;
				pstmt.setString(1,p_patient_id);
				rs = pstmt.executeQuery() ;
				while ( rs != null && rs.next() ) {
					pat_count =  rs.getInt("TOTAL_COUNT");
				    out.print(pat_count);
				}
    		}
		 else if("ENCOUNTER_EXIST_YN".equals(action)){
			 int enctr_count=0;
			 pstmt = con.prepareStatement( "SELECT COUNT(A.ENCOUNTER_ID) ENCRT_COUNT FROM PR_ENCOUNTER A, MP_PATIENT B WHERE A.PATIENT_ID = B.PATIENT_ID AND A.PATIENT_ID = ? AND ( ( A.PATIENT_CLASS IN ('IP', 'DC') AND A.ADT_STATUS NOT IN ('00', '09') ) OR ( A.PATIENT_CLASS IN ('OP', 'EM') AND A.VISIT_STATUS NOT IN ('01', '02', '99') ) ) AND A.FACILITY_ID = ? AND DISCHARGE_DATE_TIME IS NULL" ) ;
				pstmt.setString(1,p_patient_id);
				pstmt.setString(2,p_facility_id);
				rs = pstmt.executeQuery() ;
				while ( rs != null && rs.next() ) {
					enctr_count =  rs.getInt("ENCRT_COUNT");
				    out.print(enctr_count);
				}
    		}
		 else if("IS_MAIN_PROCEDURE_EXIST_YN".equals(action)){
			 int existMainPro=0;
			 pstmt = con.prepareStatement("SELECT COUNT(*) existMainPro FROM OR_ORDER_MAIN_PROCE WHERE MAIN_PROC_TYPE='Y' and PATIENT_ID= ? and ENCOUNTER_ID= ?");
				pstmt.setString(1,p_patient_id);
				pstmt.setString(2,p_encounter_id);
				rs = pstmt.executeQuery() ;
				while ( rs != null && rs.next() ) {
					existMainPro =  rs.getInt("existMainPro");
				    out.print(existMainPro);
				}
    		}
		 else if("IS_OTHER_PROCEDURE_EXIST".equals(action)){
			 int existOthersPro=0;
			 pstmt = con.prepareStatement("SELECT COUNT(*) existOthersPro FROM OR_ORDER_MAIN_PROCE WHERE OTHER_PROC_TYPE='Y'and PATIENT_ID=? and ENCOUNTER_ID=?");
				pstmt.setString(1,p_patient_id);
				pstmt.setString(2,p_encounter_id);
				rs = pstmt.executeQuery() ;
				while ( rs != null && rs.next() ) {
					existOthersPro =  rs.getInt("existOthersPro");
				    out.print(existOthersPro);
				}
    		}
		 if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
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
