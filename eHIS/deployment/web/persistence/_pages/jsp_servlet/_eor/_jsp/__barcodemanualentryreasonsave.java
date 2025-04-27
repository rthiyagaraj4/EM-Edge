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
import ePH.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __barcodemanualentryreasonsave extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/BarCodeManualEntryReasonSave.jsp", 1709119638000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        \tDescription\n--------------------------------------------------------------------------------------------------------------\n08/07/2020     IN072994          Chandrashekar raju                 Modified for MMS-DM-CRF-0170.1\n--------------------------------------------------------------------------------------------------------------------------------\n--> \n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\n\t<script src=\'../../eOR/js/BarCodeManualEntryReason.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\t\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


	Connection con = null;
	CallableStatement cs = null;	

	String facility_id = (String)session.getValue( "facility_id" );//GHL-CRF-0458
	System.err.println("facility_id@@@@==="+facility_id);
	Properties properties			= (Properties) session.getValue( "jdbc" );
	Hashtable hash		  = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				  = (Hashtable)hash.get( "SEARCH" ) ;
		
	String bean_id       = (String)hash.get("bean_id")==null?"":(String)hash.get("bean_id");
	String bean_name     = (String)hash.get("bean_name")==null?"":(String)hash.get("bean_name");
	String patient_id    = (String)hash.get("patient_id")==null?"":(String)hash.get("patient_id");
	String encounter_id  = (String)hash.get("encounter_id")==null?"":(String)hash.get("encounter_id");
	String menu_id       = (String)hash.get("menu_id")==null?"":(String)hash.get("menu_id");
	String sub_menu_id   = (String)hash.get("sub_menu_id")==null?"":(String)hash.get("sub_menu_id");
	String module_id     = (String)hash.get("module_id")==null?"":(String)hash.get("module_id");
	String reason_code   = (String)hash.get("reason_code")==null?"":(String)hash.get("reason_code");
	String reason_desc   = (String)hash.get("reason_desc")==null?"":(String)hash.get("reason_desc");
	String entry_type    = (String)hash.get("entry_type")==null?"":(String)hash.get("entry_type");
	String order_id      = (String)hash.get("order_id")==null?"":(String)hash.get("order_id");
	String order_line_no = (String)hash.get("order_line_no")==null?"":(String)hash.get("order_line_no");
	String item_code     = (String)hash.get("item_code")==null?"":(String)hash.get("item_code");
	String batch_id      = (String)hash.get("batch_id")==null?"":(String)hash.get("batch_id");
	String login_user    = (String)session.getValue("login_user") == null ? "" : (String)session.getValue("login_user");//IN061891
	String ws_no         =  properties.getProperty("client_ip_address");
	String patient_class = (String)hash.get("patient_class")==null?"":(String)hash.get("patient_class");
	String speciality    = (String)hash.get("speciality")==null?"":(String)hash.get("speciality");
	


if(reason_desc!=null && !reason_desc.equals(""))
	reason_desc = java.net.URLDecoder.decode(reason_desc,"UTF-8");
	System.err.println("reason_desc@@@@==="+reason_desc+"entry_type=="+entry_type);

	
	try
	{
		if(bean_id.equals("")){
		con = ConnectionManager.getConnection(request);
		cs = con.prepareCall("{call PR_INS_PR_BARCODE_SCAN_DETAILS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,sysdate,?,?,?) }");
		cs.setString(1,facility_id);
		cs.setString(2,module_id);
		cs.setString(3,menu_id);
		cs.setString(4,sub_menu_id);
		cs.setString(5,patient_id);
		cs.setString(6,encounter_id);
		cs.setString(7,speciality);
		cs.setString(8,patient_class);
		cs.setString(9,"");
		cs.setString(10,"");
		cs.setString(11,"");
		cs.setString(12,"");
		cs.setString(13,"");
		cs.setString(14,"");
		cs.setString(15,entry_type);
		cs.setString(16,reason_code);
		cs.setString(17,reason_desc);
		cs.setString(18,login_user);
		cs.setString(19,ws_no);
		cs.setString(20,facility_id);
		cs.setString(21,login_user);
		cs.setString(22,ws_no);
		cs.setString(23,facility_id);
		cs.registerOutParameter(24,java.sql.Types.VARCHAR);
		cs.execute();

		String p_error_text = cs.getString(24);
		System.err.println("p_error_text@@@==="+p_error_text);
			
		if(cs!=null) cs.close();
		}
		else{
			System.err.println("bean_id@@@@@====="+bean_id);
			HashMap values	= new HashMap();
				values.put("patient_id" , patient_id);
				values.put("encounter_id" , encounter_id);							
				values.put("menu_id" , menu_id);
				values.put("sub_menu_id" , sub_menu_id);
				values.put("module_id" , module_id);
				values.put("resone_code" , reason_code);
				values.put("resone_desc" , reason_desc);
				values.put("entry_type",entry_type);
				values.put("order_id",order_id);
				values.put("order_line_no",order_line_no);
				values.put("item_code",item_code);
				values.put("batch_id",batch_id);
				values.put("patient_class",patient_class);
             if(bean_id.equals("Or_SpecimenOrder")){
	             SpecimenOrder bean = (SpecimenOrder)getBeanObject( bean_id,  bean_name, request ) ;	
                  bean.setManualBarcodeRemarks(values);
			      putObjectInBean(bean_id,bean,request);
			 }
			if(bean_id.equals("MedicationAdministrationFTBean")){
				 MedicationAdministrationFTBean bean =(MedicationAdministrationFTBean)getBeanObject( bean_id,  bean_name, request ) ;
				  bean.setManualBarcodeRemarks(values);
			      putObjectInBean(bean_id,bean,request);
			 }
			 if(bean_id.equals("DispMedicationBean")){
				 DispMedicationBean bean =(DispMedicationBean)getBeanObject( bean_id,  bean_name, request ) ;
				  bean.setManualBarcodeRemarks(values);
				  System.err.println(bean.getManualBarcodeRemarks());
			      putObjectInBean(bean_id,bean,request);
			 }

		}
	}
	catch (Exception e) 
	{
		e.printStackTrace();
		
    }
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
