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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __consultationtagintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ConsultationTagIntermediate.jsp", 1741246417043L ,"10.3.6.0","Asia/Calcutta")) return true;
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
11/24/2023     32902        Twinkle Shah    	           Ramesh Goli             MMS-DM-CRF-0210			
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
		String tagPractitonerId = (String) hashObj.get("tagPractitonerId") == null ? "": (String) hashObj.get("tagPractitonerId");
		String facility_id = (String) hashObj.get("facility_id") == null ? "": (String) hashObj.get("facility_id");
		String encounter_id = (String) hashObj.get("encounter_id") == null ? "": (String) hashObj.get("encounter_id");
		String language_id = (String) hashObj.get("language_id") == null ? "": (String) hashObj.get("language_id");

		 String bean_id					= "ConsultationTaggingBean" ;
		 String bean_name				= "eCA.ConsultationTaggingBean";
		 ConsultationTaggingBean bean	= (ConsultationTaggingBean)getBeanObject( bean_id, bean_name , request) ;
	     ArrayList<ArrayList<String>> searchData=new ArrayList<ArrayList<String>>();
		 
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
		 else if("CHK_PAT_APPLI_CONSUL_TAG".equals(action))
		 {
			int pat_count=0;
			String appli_pat_consultag_dcyn="";
			String appli_pat_consultag_emyn="";
			String appli_pat_consultag_ipyn="";
			String appli_pat_consultag_opn="";
			pstmt = con.prepareStatement("SELECT APPLI_PAT_CONSULTAG_DCYN, APPLI_PAT_CONSULTAG_EMYN, APPLI_PAT_CONSULTAG_IPYN, APPLI_PAT_CONSULTAG_OPYN from CA_PARAM_BY_FACILITY where FACILITY_ID=?" ) ;
			pstmt.setString(1, facility_id);
			rs = pstmt.executeQuery() ;
			if( rs != null ) {
			if( rs.next() ) {
			appli_pat_consultag_dcyn = rs.getString("APPLI_PAT_CONSULTAG_DCYN")==null?"N":(String)rs.getString("APPLI_PAT_CONSULTAG_DCYN");
			appli_pat_consultag_emyn = rs.getString("APPLI_PAT_CONSULTAG_EMYN")==null?"N":(String)rs.getString("APPLI_PAT_CONSULTAG_EMYN");
			appli_pat_consultag_ipyn = rs.getString("APPLI_PAT_CONSULTAG_IPYN")==null?"N":(String)rs.getString("APPLI_PAT_CONSULTAG_IPYN");
			appli_pat_consultag_opn = rs.getString("APPLI_PAT_CONSULTAG_OPYN")==null?"N":(String)rs.getString("APPLI_PAT_CONSULTAG_OPYN");
			}
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(appli_pat_consultag_dcyn.equals("N") && appli_pat_consultag_emyn.equals("N") && appli_pat_consultag_ipyn.equals("N") && appli_pat_consultag_opn.equals("N"))
					out.println("N");
				else if (appli_pat_consultag_dcyn.equals("Y") || appli_pat_consultag_emyn.equals("Y") || appli_pat_consultag_ipyn.equals("Y") || appli_pat_consultag_opn.equals("Y"))
					out.println("Y"); 
		 }
		 
		 else if("CHK_PRACT_ALRDY_TAG_YN".equals(action))
		 { 
			int pat_count=0;
			int tagPractitionerYN=0;
			String appli_pat_consultag_emyn="";
			String appli_pat_consultag_ipyn="";
			String appli_pat_consultag_opn="";
		    pstmt = con.prepareStatement("SELECT COUNT(*) TAG_PRACTITIONER_ID FROM CA_CONSULTATION_TAGGING WHERE TAG_PRACTITIONER_ID=? AND FACILITY_ID =? AND PATIENT_ID =? AND ENCOUNTER_ID =?");
			pstmt.setString(1, tagPractitonerId);
			pstmt.setString(2, facility_id);
			pstmt.setString(3, patient_id);
			pstmt.setString(4, encounter_id);
			rs = pstmt.executeQuery() ;
			if( rs != null){
			if( rs.next()){
		    tagPractitionerYN = rs.getInt("TAG_PRACTITIONER_ID");
			}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(tagPractitionerYN > 0)
			out.println("N");
			else
			out.println("Y"); 
		 }
		 else if("CHK_PAT_ACTIVE_ENCOUNT_YN".equals(action))
		 { 
			searchData=bean.getPatRecordConsultationTagging(patient_id,facility_id,language_id);			
			out.println(searchData.size()); 
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
