package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __stbillingvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/STBillingValidation.jsp", 1709117286000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String locale = (String)session.getAttribute("LOCALE"); 
	String reason_code = request.getParameter("reason_code")== null?"":request.getParameter("reason_code");
	String include_exclude_val = request.getParameter("include_exclude_val")== null?"":request.getParameter("include_exclude_val");

	String patient_id = request.getParameter("patient_id")== null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")== null?"":request.getParameter("encounter_id");
	String mm_item_code = request.getParameter("mm_item_code")== null?"":request.getParameter("mm_item_code");
	String req_store_code = request.getParameter("req_store_code")== null?"":request.getParameter("req_store_code");
	String quantity = request.getParameter("quantity")== null?"":request.getParameter("quantity");
	String patient_class = request.getParameter("quantity")== null?"":request.getParameter("patient_class");
	String facility_id = request.getParameter("facility_id");
	String sale_doc_no = request.getParameter("sale_doc_no")== null?"":request.getParameter("sale_doc_no");
	String sale_doc_type = request.getParameter("sale_doc_type")== null?"":request.getParameter("sale_doc_type");
	String sql			= "";		
	String sep	= "##";
	Connection conn = null;
	CallableStatement statement =null;
	try{
		conn=ConnectionManager.getConnection(request);
		PreparedStatement pstmt	  = null;
		ResultSet rs		  = null;
		//Maheshwaran K modified for  SKR-SCF-0788 [IN:039522] as on 24/09/2013
		statement=conn.prepareCall("{call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
				String sal_trn_type="";
								if(patient_class.equals("IP"))
									{
										sal_trn_type="I";
									}else if(patient_class.equals("OP"))
									{
									sal_trn_type="O";
									}else if(patient_class.equals("EM"))
									{
									sal_trn_type="E";
									}else if(patient_class.equals("DC"))
									{
									sal_trn_type="D";
									}else if(patient_class.equals("XT"))
									{
									sal_trn_type="R";
									}
		
			statement.setString(1, facility_id);
			statement.setString(2, patient_id);
			statement.setString(3, "ST");
			statement.setString(4, encounter_id);
			statement.setString(5, sal_trn_type);
			statement.setString(6, com.ehis.util.DateUtils.getCurrentDate("DMY","en"));
			statement.setString(7, mm_item_code);
			statement.setString(8, req_store_code);
			statement.setInt(9, Integer.parseInt(quantity));
			statement.setString(10, ";");

			statement.registerOutParameter(11, Types.VARCHAR);
			statement.registerOutParameter(12, Types.VARCHAR);
			statement.registerOutParameter(13, Types.VARCHAR);
			statement.registerOutParameter(14, Types.VARCHAR);
			statement.registerOutParameter(15, Types.FLOAT);
			statement.registerOutParameter(16, Types.FLOAT);
			statement.registerOutParameter(17, Types.FLOAT);
			statement.registerOutParameter(18, Types.FLOAT);
			statement.registerOutParameter(19, Types.FLOAT);
			statement.registerOutParameter(20, Types.FLOAT);
			statement.registerOutParameter(21, Types.FLOAT);
			statement.registerOutParameter(22, Types.FLOAT);
			statement.registerOutParameter(23, Types.FLOAT);
			statement.registerOutParameter(24, Types.FLOAT);
			statement.registerOutParameter(25, Types.FLOAT);
			statement.registerOutParameter(26, Types.FLOAT);
			statement.registerOutParameter(27, Types.FLOAT);
			statement.registerOutParameter(28, Types.FLOAT);
			statement.registerOutParameter(29, Types.VARCHAR);
			statement.registerOutParameter(30, Types.FLOAT);
			statement.registerOutParameter(31, Types.VARCHAR);
			statement.registerOutParameter(32, Types.VARCHAR);
			statement.registerOutParameter(33, Types.VARCHAR);
			statement.registerOutParameter(34, Types.VARCHAR);
			statement.registerOutParameter(35, Types.VARCHAR);
			statement.registerOutParameter(36, Types.VARCHAR);
			statement.registerOutParameter(37, Types.VARCHAR);
			statement.registerOutParameter(38, Types.VARCHAR);
			statement.setString(39, include_exclude_val);
			statement.setString(40, reason_code);
			statement.setString(41, "N"); //Internal Adjestment
           statement.setString(42,sale_doc_type );//sale_document_type
		   statement.setString(43, sale_doc_no);//sale_document_no
		   statement.setString(44, "1");
			//Maheshwaran K added for the  SKR-SCF-0788 [IN:039522] as on 24/09/2013
			//Start
			statement.setString(45, "N");//p_discharge_ind
			statement.registerOutParameter(46, Types.VARCHAR);//p_drug_penalty_str
			//End
		

			statement.execute();

String totoal_paid=statement.getString(21);
String pat_payable=statement.getString(25);
String pat_paid=statement.getString(38);
String new_val=statement.getString(36);

out.println(reason_code+"*"+include_exclude_val+"*"+totoal_paid+"*"+pat_payable+"*"+pat_paid);



}catch(Exception e)
	{
		System.out.println("Exception in main room working="+e);
		e.printStackTrace();
	}
	finally{
		if(conn != null)
				ConnectionManager.returnConnection(conn,request);
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
