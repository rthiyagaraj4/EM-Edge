package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.apache.commons.lang.*;
import java.sql.*;
import org.apache.commons.lang.StringUtils;
import java.util.*;
import eXH.*;
import java.lang.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import com.ehis.util.*;
import eBL.Common.*;
import eBL.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import org.json.simple.JSONObject;

public final class __blinterfacevalidations extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLInterfaceValidations.jsp", 1727679615481L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="\n\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block4Bytes, _wl_block4);
	
	//Added by Niveditha NMC-JD-CRF-0054.1
	
	String protocol_Link_Id="";
	String mpmastermodule ="MP";
	List<String> oHistTypeList= new ArrayList<String>();
	List<String> types= new ArrayList<String>();
	String DebugYNProtocolLinkId = StringUtils.EMPTY;	
		

	String cg_patdet_patient_id=StringUtils.EMPTY, cg_patdet_national_id=StringUtils.EMPTY, cg_patdet_alt_id1_type=StringUtils.EMPTY, cg_patdet_alt_id1_no=StringUtils.EMPTY, cg_patdet_alt_id2_type=StringUtils.EMPTY, 
	cg_patdet_alt_id2_no=StringUtils.EMPTY, cg_patdet_alt_id3_type=StringUtils.EMPTY, cg_patdet_alt_id3_no=StringUtils.EMPTY, cg_patdet_alt_id4_type=StringUtils.EMPTY, cg_patdet_alt_id4_no=StringUtils.EMPTY, cg_patdet_oth_altid_type=StringUtils.EMPTY, cg_patdet_oth_altid_no=StringUtils.EMPTY; 

	String method = request.getParameter("method");
	String patient_id = request.getParameter("patientid");

	String citizen_flag=StringUtils.EMPTY;
	
	
	try {

			if (method.equals("PatientDetails"))
			{
				protocol_Link_Id="HSWITCHPL";

				XHUtil ProtocolLinkID = new XHUtil();
				XHCustomerGroup custGroupDetails = new XHCustomerGroup(); 
				XHPatientDetailsBean CustomerGroupPatDetails = custGroupDetails.getPatientDetails(patient_id);
			 
				DebugYNProtocolLinkId = ProtocolLinkID.FetchProtocollinkMethod(protocol_Link_Id);	
				
				cg_patdet_patient_id = CustomerGroupPatDetails.getPatientId();
				cg_patdet_national_id = CustomerGroupPatDetails.getNationalId();
				cg_patdet_alt_id1_type = CustomerGroupPatDetails.getAltId1Type();
				cg_patdet_alt_id1_no = CustomerGroupPatDetails.getAltId1No();
				cg_patdet_alt_id2_type = CustomerGroupPatDetails.getAltId2Type();
				cg_patdet_alt_id2_no = CustomerGroupPatDetails.getAltId2No();
				cg_patdet_alt_id3_type = CustomerGroupPatDetails.getAltId3Type();
				cg_patdet_alt_id3_no = CustomerGroupPatDetails.getAltId3No();
				cg_patdet_alt_id4_type = CustomerGroupPatDetails.getAltId4Type();
				cg_patdet_alt_id4_no = CustomerGroupPatDetails.getAltId4No();
				cg_patdet_oth_altid_type = CustomerGroupPatDetails.getOthAltIdType();
				cg_patdet_oth_altid_no = CustomerGroupPatDetails.getOthAltIdNo();

				if("Y".equals(DebugYNProtocolLinkId)){
					System.out.println("BL Interface Validation :::: Patient ID ::::"+cg_patdet_patient_id);
					System.out.println("BL Interface Validation :::: Nationality ID ::::"+cg_patdet_national_id);
					System.out.println("BL Interface Validation :::: Alternative ID One Type ::::"+cg_patdet_alt_id1_type);
					System.out.println("BL Interface Validation :::: Alternative ID One No ::::"+cg_patdet_alt_id1_no);
					System.out.println("BL Interface Validation :::: Alternative ID Two Type ::::"+cg_patdet_alt_id2_type);
					System.out.println("BL Interface Validation :::: Alternative ID Two No ::::"+cg_patdet_alt_id2_no);
					System.out.println("BL Interface Validation :::: Alternative ID Three Type ::::"+cg_patdet_alt_id3_type);
					System.out.println("BL Interface Validation :::: Alternative ID Three No ::::"+cg_patdet_alt_id3_no);
					System.out.println("BL Interface Validation :::: Alternative ID Four Type ::::"+cg_patdet_alt_id4_type);
					System.out.println("BL Interface Validation :::: Alternative ID Four No ::::"+cg_patdet_alt_id4_no);
					System.out.println("BL Interface Validation :::: Alternative ID Five No ::::"+cg_patdet_oth_altid_type);
					System.out.println("BL Interface Validation :::: Alternative ID Five No ::::"+cg_patdet_oth_altid_no);
				}

				JSONObject ob = new JSONObject();
				ob.put("patient_id", cg_patdet_patient_id);
				ob.put("nationality_id", cg_patdet_national_id);
				ob.put("alt_id1_type", cg_patdet_alt_id1_type);
				ob.put("alt_id1_no", cg_patdet_alt_id1_no);
				ob.put("alt_id2_type", cg_patdet_alt_id2_type);
				ob.put("alt_id2_no", cg_patdet_alt_id2_no);
				ob.put("alt_id3_type", cg_patdet_alt_id3_type);
				ob.put("alt_id3_no", cg_patdet_alt_id3_no);
				ob.put("alt_id4_type", cg_patdet_alt_id4_type);
				ob.put("alt_id4_no", cg_patdet_alt_id4_no);
				ob.put("alt_oth_id_type", cg_patdet_oth_altid_type);
				ob.put("alt_oth_id_no", cg_patdet_oth_altid_no);

				citizen_flag = custGroupDetails.getCitizen(patient_id);
			
				if("Y".equals(DebugYNProtocolLinkId)){
					System.out.println("BL Interface Validation :::: Patient Citizen Flag ::::"+citizen_flag);
				}
				
				ob.put("citizen_flag", citizen_flag);

				out.println(ob.toString());
				out.flush();

			}			
		
		}
		catch(Exception e){
			e.printStackTrace();
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
