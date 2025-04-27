package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Date;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import eOT.Common.*;
import eOT.Common.OTRepository;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __otcommonvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OTCommonValidation.jsp", 1721888256000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	/* //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends  */

	String locale = (String)session.getAttribute("LOCALE"); 
	String func_mode = request.getParameter("func_mode")== null?"":request.getParameter("func_mode");
	//CRF-004 Authorize Slots for Booking - Rajesh V 
	String operFacilityId = (String)session.getAttribute("facility_id");
	//CRF-004 Authorize Slots for Booking - Rajesh V 

	//Added by Arthi for ML-MMOH-CRF-1936
	Boolean isTimeDtlsSurNurAppl = false;

	Connection conn = null;
	try
	{
		conn=ConnectionManager.getConnection(request);
		
		//Added by Arthi for ML-MMOH-CRF-1936
		isTimeDtlsSurNurAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OT", "TIMEDTLS_NUR_SUR_NOTE_MAND");
		String opernm = checkForNull(request.getParameter("oper_num")) ;
		String rec_yn = "";

		int timedtl_cnt = eOT.OTCommonBean.getTimeandDtlTabCnt(conn,opernm,operFacilityId);
		//End ML-MMOH-CRF-1936
		
		PreparedStatement pstmt	  = null;
		ResultSet rs		  = null;
		ResultSet rs1		  = null;
		ResultSet rs2		  = null;

		if(func_mode.equals("waitlist_remarks")){

		String strOrderid = checkForNull(request.getParameter("order_id"));

		String strRemarks="";
		String sql="SELECT ORDER_COMMENT FROM OR_ORDER_COMMENT WHERE ORDER_ID = '"+strOrderid+"'";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs!= null && rs.next()){
	   	 strRemarks= checkForNull(rs.getString(1));
			}
			out.println(strRemarks);
		}
	
	else if(func_mode.equals("getStoresRoomCode")){	
		String facility_id = checkForNull(request.getParameter("facility_id")) ;
		String store_code  = "";
		String store_desc = "";
		StringBuffer store_code__Buff = new StringBuffer();
		String sql_store_code="SELECT B.STORE_CODE,SHORT_DESC FROM MM_STORE A , ST_STORE B WHERE A.STORE_CODE = B.STORE_CODE AND A.FACILITY_ID = DECODE('"+facility_id +"','ALL',A.FACILITY_ID,'"+facility_id +"')AND A.EFF_STATUS ='E' ORDER BY 1";
		pstmt = conn.prepareStatement(sql_store_code);
		rs = pstmt.executeQuery();
		while(rs!= null && rs.next()){
			store_code = checkForNull(rs.getString(1));
			store_desc = checkForNull(rs.getString(2));
			store_code__Buff.append(store_code+"##"+store_desc);
			store_code__Buff.append("~");
			}
		out.println(store_code__Buff);

	}else if(func_mode.equals("checkBLInterfaceaFlag")){	
		String facility_id = checkForNull(request.getParameter("facility_id")) ;
		String bl_interface_flag= "";
		String sql_bl_flag="SELECT BL_INTERFACE_FLAG FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID='"+facility_id+"'";
		pstmt = conn.prepareStatement(sql_bl_flag);
		rs = pstmt.executeQuery();
		while(rs!= null && rs.next()){
			bl_interface_flag = checkForNull(rs.getString(1));
			}
		out.println(bl_interface_flag);

	}else if(func_mode.equals("HoldingAreaBillDetails")){	
		String facility_id = checkForNull(request.getParameter("facility_id")) ;
		String oper_num = checkForNull(request.getParameter("oper_num")) ;
		String visit_id  = "";
		String episode_id="";
		String episode_type="";
		String encounter_id="";
		String order_id="";
		String patient_class="";
		String bl_episode_type="";
		String oper_date="";
		String sql_pat_dtls="SELECT VISIT_ID, EPISODE_ID, EPISODE_TYPE,ENCOUNTER_ID,ORDER_ID,PATIENT_CLASS,TO_CHAR(OPER_DATE,'DD/MM/YYYY') OPER_DATE FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID='"+facility_id+"' AND OPER_NUM='"+oper_num+"' ";
		pstmt = conn.prepareStatement(sql_pat_dtls);
		rs = pstmt.executeQuery();
		while(rs.next()){
		visit_id=checkForNull(rs.getString(1));
		episode_id=checkForNull(rs.getString(2));
		episode_type=checkForNull(rs.getString(3));
		encounter_id=checkForNull(rs.getString(4));
		order_id=checkForNull(rs.getString(5));
		patient_class=checkForNull(rs.getString(6));
		oper_date=checkForNull(rs.getString(7));
		}
		
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		String sql_bl_episode_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";
		pstmt = conn.prepareStatement(sql_bl_episode_type);
		rs = pstmt.executeQuery();
		while(rs.next()){
			bl_episode_type=checkForNull(rs.getString(1));		
		}

		String concat_string=visit_id+"&&"+episode_id+"&&"+episode_type+"&&"+encounter_id+"&&"+order_id+"&&"+bl_episode_type+"&&"+oper_date;
		out.println(concat_string);
	}else if(func_mode.equals("assignDfltRecRoom")){	
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		String oper_room_code = checkForNull(request.getParameter("oper_room_code")) ;
		String rec_room_code="";
		String rec_room_desc="";
		String sql_rec_room="select A.DFLT_RECOVERY_ROOM_CODE,GET_DESC('"+locale+"','OT_RECOVERY_ROOM_LANG_VW','RECOVERY_ROOM_DESC','RECOVERY_ROOM_CODE',A.DFLT_RECOVERY_ROOM_CODE) RECOVERY_ROOM_DESC FROM OT_OPER_ROOM_LANG_VW A WHERE A.LANGUAGE_ID='"+locale+"' AND A.OPER_ROOM_CODE='"+oper_room_code+"' ";
		pstmt = conn.prepareStatement(sql_rec_room);
		rs = pstmt.executeQuery();
		while(rs.next()){
		rec_room_code=checkForNull(rs.getString(1));
		rec_room_desc=checkForNull(rs.getString(2));
		}
		String concat_string=rec_room_code+"&&"+rec_room_desc;
		out.println(concat_string);
	}else if(func_mode.equals("OPR_RM_MSTR_EXIST_APP")){	
		String room_code = checkForNull(request.getParameter("room_code")) ;
		String facility_id = checkForNull(request.getParameter("facility_id")) ;
		String exist_appt= "";
		String sql_exist_flag="SELECT 'X' FROM OT_BOOKING_HDR WHERE  OPERATING_FACILITY_ID = '"+facility_id+"' AND    OPER_ROOM_CODE  = '"+room_code+"' AND    BOOKING_STATUS   <>'9' AND    TRUNC(BOOKING_DATE) >= TRUNC(SYSDATE)";
		pstmt = conn.prepareStatement(sql_exist_flag);
		rs = pstmt.executeQuery();
		while(rs!= null && rs.next()){
			exist_appt = checkForNull(rs.getString(1));
			}
		out.println(exist_appt);

	}else if(func_mode.equals("book_oper_code"))
	{
		String oper_code = checkForNull(request.getParameter("oper_code")) ;
		String short_desc="";
		String oper_code1="";
		String side_applicable="";
		String order_catalog_code="";
		String splty_code="";
		String concat_string="";
        //Commented against CRF-0199
		//String sql_oper_code="SELECT SHORT_DESC SHORT_DESC1,OPER_CODE OPER_CODE1, NVL(APPL_RIGHT_LEFT_FLAG,'N') APPL_RIGHT_LEFT_FLAG1, ORDER_CATALOG_CODE ORDER_CATALOG_CODE1,SPECIALITY_CODE SPECIALITY_CODE1  FROM OT_OPER_MAST_LANG_VW WHERE NVL(STATUS,'E') = 'E' AND LANGUAGE_ID='"+locale+"' and oper_code='"+oper_code+"' ";
		//Modified against CRF-0199
		String sql_oper_code="SELECT Long_DESC LONG_DESC1,OPER_CODE OPER_CODE1, NVL(APPL_RIGHT_LEFT_FLAG,'N') APPL_RIGHT_LEFT_FLAG1, ORDER_CATALOG_CODE ORDER_CATALOG_CODE1,SPECIALITY_CODE SPECIALITY_CODE1  FROM OT_OPER_MAST_LANG_VW WHERE NVL(STATUS,'E') = 'E' AND LANGUAGE_ID='"+locale+"' and oper_code='"+oper_code+"'";
			pstmt = conn.prepareStatement(sql_oper_code);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next())
			{
				//short_desc= rs.getString("SHORT_DESC1");//commented against CRF-0199
				short_desc= rs.getString("LONG_DESC1");//Added against CRF-0199
				oper_code1= rs.getString("OPER_CODE1");
				side_applicable= rs.getString("APPL_RIGHT_LEFT_FLAG1");
				order_catalog_code= rs.getString("ORDER_CATALOG_CODE1");
				splty_code= rs.getString("SPECIALITY_CODE1");
			}
			concat_string=short_desc+"::"+oper_code1+"::"+side_applicable+"::"+order_catalog_code+"::"+splty_code;			
		out.println(concat_string);
	}else if(func_mode.equals("get_trfropercode_and_sourceopernum"))
	{
		String oper_num = checkForNull(request.getParameter("oper_num")) ;
		String facility_id = checkForNull(request.getParameter("facility_id")) ;
		String trfr_oper_room="";
		String source_oper_num="";
		String concat_string="";
		String sql_trfr_case="SELECT TRFR_OPER_ROOM,SOURCE_OPER_NUM FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID='"+facility_id+"' AND OPER_NUM='"+oper_num+"' ";
			pstmt = conn.prepareStatement(sql_trfr_case);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next())
			{
				trfr_oper_room =checkForNull(rs.getString("TRFR_OPER_ROOM"));
				source_oper_num=checkForNull(rs.getString("SOURCE_OPER_NUM"));
			}
			concat_string=trfr_oper_room+"::"+source_oper_num;
		    out.println(concat_string);

	}
	else if(func_mode.equals("new_operation"))	/*Added by Suma for the incident 16685 to pass the operation values to Surgical Accessories tab inorder to add the new operation realted surgical accessories. */
	{
		String status_val = checkForNull(request.getParameter("status_val")) ;
	//	String facility_id = checkForNull(request.getParameter("facility_id")) ;
	//	String oper_num = checkForNull(request.getParameter("oper_num")) ;

String oper_code="";
String chk_status="";
String db_mode="";
String next_val="";
String oper_code_final="";
int counter=0;
StringTokenizer token=new StringTokenizer(status_val,"$");
		while(token.hasMoreTokens())
		{
			next_val=token.nextToken();
		    counter=token.countTokens();
			StringTokenizer token1=new StringTokenizer(next_val,"*");
			while(token1.hasMoreTokens())
			{
				 oper_code=token1.nextToken();
				 chk_status=token1.nextToken();
				 db_mode=token1.nextToken();
				 if(db_mode.equals("I") && !chk_status.equals("99"))
				{
				if(counter >0)
				oper_code_final +="'" +oper_code+ "'" +",";
					else
					oper_code_final +="'" +oper_code+ "'" ;
					}
				 }
			}
		out.println(oper_code_final);	
	}
	else if(func_mode.equals("old_operation"))	/*Added by Suma for the incident 16685 to pass the operation values to Surgical Accessories tab inorder to add the new operation realted surgical accessories. */
	{
String status_val = checkForNull(request.getParameter("status_val")) ;
String spec_code="";
String chk_status="";
String db_mode="";
String next_val="";
String spec_code_final="";
String spec_code_chk_last="";
int counter=0;
StringTokenizer token=new StringTokenizer(status_val,"$");
		while(token.hasMoreTokens())
		{
			next_val=token.nextToken();
				 counter=token.countTokens();
			StringTokenizer token1=new StringTokenizer(next_val,"*");
			while(token1.hasMoreTokens())
			{
				 spec_code=token1.nextToken();
				 chk_status=token1.nextToken();
				 db_mode=token1.nextToken();
				 if(!chk_status.equals("99"))
				{
				if(counter >0)
				spec_code_final +="'" +spec_code+ "'" +",";
					else
					spec_code_final +="'" +spec_code+ "'" ;
					}
			}
	}
	
		if(spec_code_final != null && spec_code_final.trim().length() > 0)
	spec_code_chk_last=  spec_code_final.substring(spec_code_final.length()-1);
if(spec_code_chk_last.equals(","))
	spec_code_chk_last=  spec_code_final.substring(0,spec_code_final.length()-1);
		else
	spec_code_chk_last=  spec_code_final;
		out.println(spec_code_chk_last);
}
	else if(func_mode.equals("exist_operation_speciality"))
	{		
		String spec_code_final = checkForNull(request.getParameter("spec_code_final")) ;
		String specialty_code="";
		String specialty_desc="";
		String specialty_val="";
		String specialty_val_fin="";
		String sql_spec_all="SELECT DISTINCT SPECIALITY_CODE, SHORT_DESC SPECIALITY_DESC FROM AM_SPECIALITY_LANG_VW WHERE LANGUAGE_ID='"+locale+"'  and SPECIALITY_CODE in("+spec_code_final+")";
				pstmt = conn.prepareStatement(sql_spec_all);
			rs = pstmt.executeQuery();
			if(rs!=null )
			{
				while(rs.next())
				{
				specialty_code=checkForNull(rs.getString("SPECIALITY_CODE"));
				specialty_desc=checkForNull(rs.getString("SPECIALITY_DESC"));
				specialty_val =specialty_code+","+specialty_desc;
				specialty_val_fin +=specialty_val +"*";
				}
			}
out.println(specialty_val_fin);
	}
	else if(func_mode.equals("new_operation_speciality"))
	{
		String oper_code = checkForNull(request.getParameter("oper_code")) ;
		String oper_num = checkForNull(request.getParameter("oper_num")) ;
		String facility_id = checkForNull(request.getParameter("facility_id")) ;
		String specialty_code="";
		String specialty_desc="";
		String specialty_val="";
		String specialty_val_fin="";

		String sql_spec="SELECT DISTINCT A.SPECIALITY_CODE, B.SHORT_DESC SPECIALITY_DESC FROM OT_OPER_MAST_LANG_VW A, AM_SPECIALITY_LANG_VW B WHERE A.LANGUAGE_ID = '"+locale+"' AND B.LANGUAGE_ID = A.LANGUAGE_ID  AND  A.OPER_CODE IN ("+oper_code+") AND A.SPECIALITY_CODE = B.SPECIALITY_CODE AND NVL(B.EFF_STATUS,'E')='E' UNION SELECT DISTINCT A.SPECIALITY_CODE, B.SHORT_DESC SPECIALITY_DESC  FROM OT_OPER_MAST_LANG_VW A, AM_SPECIALITY_LANG_VW B WHERE A.LANGUAGE_ID = '"+locale+"'  AND B.LANGUAGE_ID = A.LANGUAGE_ID AND A.OPER_CODE IN (SELECT OPER_CODE  FROM OT_POST_OPER_DTLS WHERE OPERATING_FACILITY_ID = '"+facility_id+"'  AND OPER_NUM = '"+oper_num+"'  AND NVL(OPER_LINE_STATUS,'X' ) NOT IN '99' )  AND A.SPECIALITY_CODE = B.SPECIALITY_CODE AND NVL(B.EFF_STATUS,'E')='E'";
	pstmt = conn.prepareStatement(sql_spec);
			rs = pstmt.executeQuery();
			if(rs!=null )
			{
				while(rs.next())
				{
				specialty_code=checkForNull(rs.getString("SPECIALITY_CODE"));
				specialty_desc=checkForNull(rs.getString("SPECIALITY_DESC"));

				specialty_val =specialty_code+","+specialty_desc;

				specialty_val_fin +=specialty_val +"*";
				}
			}
		out.println(specialty_val_fin);

	}else if(func_mode.equals("defaultProcCodeScheme"))
	{
		String speciality_code = checkForNull(request.getParameter("speciality_code")) ;
		String diag_code="";
		String diag_desc="";
		String param_diag_code="";
		String param_diag_desc="";
		String concat_diag_code_desc="";

		String sql_spec="SELECT DIAG_CODE_SCHEME,GET_DESC('"+locale+"','MR_TERM_SET_LANG_VW','TERM_SET_DESC','TERM_SET_ID',DIAG_CODE_SCHEME) DIAG_CODE_DESC FROM OT_SPECIALITIES WHERE SPECIALITY_CODE='"+speciality_code+"'";
		pstmt = conn.prepareStatement(sql_spec);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next())
			{
				diag_code=checkForNull(rs.getString("DIAG_CODE_SCHEME"));
				diag_desc=checkForNull(rs.getString("DIAG_CODE_DESC"));
			}
			if(diag_code.equals("") || diag_code.equals(null) || diag_code.equals("null") ){
			
				String sql_ot_param="SELECT OPER_CODE_SCHEME,GET_DESC('"+locale+"','MR_TERM_SET_LANG_VW','TERM_SET_DESC','TERM_SET_ID',OPER_CODE_SCHEME) DIAG_CODE_DESC FROM OT_PARAM";
				pstmt = conn.prepareStatement(sql_ot_param);
				rs = pstmt.executeQuery();
				if(rs!=null && rs.next())
				{
					param_diag_code=checkForNull(rs.getString("OPER_CODE_SCHEME"));
					param_diag_desc=checkForNull(rs.getString("DIAG_CODE_DESC"));
				}
			}
			if(diag_code.equals("") || diag_code.equals(null) || diag_code.equals("null") ){
				concat_diag_code_desc=param_diag_code+","+param_diag_desc;
			}else{
				concat_diag_code_desc=diag_code+","+diag_desc;	
			}
		out.println(concat_diag_code_desc);
	}else if(func_mode.equals("procedure_coding_scheme_tab_yn"))
        {
                String facility_id = checkForNull(request.getParameter("facility_id")) ;
                //String oper_num = checkForNull(request.getParameter("oper_num")) ;
                String oper_code = checkForNull(request.getParameter("oper_code")) ;
                String flag_val="";
                //String sqk_val_chk="select ERR_MSG from sm_proc_msg where APP_MSG='"+oper_code+"' and FAILED_PROC_ID='"+oper_num+"' and OPERATING_FACILITY_ID='"+facility_id+"' and PROC_ID='SURG_OPER' ";
                String sql_proc="SELECT 'X' FLAG FROM   OR_ORDER_CATALOG WHERE  ORDER_CATALOG_CODE IN(SELECT ORDER_CATALOG_CODE FROM   OT_OPER_MAST B WHERE  OPER_CODE  = '"+oper_code+"' AND    ADDED_FACILITY_ID ='"+facility_id+"' AND    PROC_LINK_APPLICABLE <>'X') ";
                pstmt = conn.prepareStatement(sql_proc);
        rs = pstmt.executeQuery();
                if(rs!=null && rs.next())
                {
                flag_val= rs.getString("FLAG");

                }

                out.println(flag_val);


        }else if(func_mode.equals("chkpanelservice"))
        {
			//Included by rajesh for 17012 on 07/01/2010
                String flag_val="";
                String sql_proc="SELECT COUNT(*) FROM BL_ORDER_CATALOG WHERE ORDER_CATALOG_CODE IN (SELECT ORDER_CATALOG_CODE FROM OR_ORDER_CATALOG WHERE ORDER_CATEGORY = 'OT'  AND NVL(BILL_YN,'N')='Y') AND SERV_PANEL_IND='L'";
                pstmt = conn.prepareStatement(sql_proc);
		        rs = pstmt.executeQuery();
                if(rs!=null && rs.next())
                {
                flag_val= rs.getString(1);

                }
                out.println(flag_val);
        }else if(func_mode.equals("chk_for_pick_list"))
		{
			String facility_id	= (String) session.getValue("facility_id");

              String implant_code = checkForNull(request.getParameter("implant_code")) ;
              String booking_num = checkForNull(request.getParameter("booking_num")) ;

			  String reserved_qty="";
			  String requested_qty="";
			  String final_val="";
			  String sql_pick_list_spec="select RESERVED_QTY, REQUESTED_QTY from ot_pick_lists where OPERATING_FACILITY_ID='"+facility_id+"' AND Booking_NUM='"+booking_num+"'  and item_type='S' AND ITEM_ID='"+implant_code+"'";
				pstmt = conn.prepareStatement(sql_pick_list_spec);
		        rs = pstmt.executeQuery();
                if(rs!=null && rs.next())
                {
               reserved_qty= rs.getString(1);
			   if(reserved_qty ==null) reserved_qty="";
			   requested_qty= rs.getString(2);
			      if(requested_qty ==null) requested_qty="";
			   final_val=reserved_qty+","+requested_qty;
			   }
                out.println(final_val);

		}/*Added by Suma for checking sales finalization part added on 01/03/2010*/
else if(func_mode.equals("chk_for_sales_finalize"))
		{
			String accession_num = checkForNull(request.getParameter("accession_num")) ;
			String count_val="";
			String sql_sales="select Count(*) from st_sal_hdr where module_id = 'OT' and finalized_yn = 'N' and ref_no ='"+accession_num+"'";
			
				pstmt = conn.prepareStatement(sql_sales);
		        rs = pstmt.executeQuery();
                if(rs!=null && rs.next())
                {
					count_val=rs.getString(1);
				}
				out.println(count_val);
		}
		//added by Suma ends here
		//Added for Alpha-OT-[IN:048239] start
		else if(func_mode.equals("deleteOnSaveAnes"))
		{
				String facility_id = checkForNull(request.getParameter("facility_id"));
				String source_order_id	= checkForNull(request.getParameter("source_order_id"));
				String sql_Anes_delete = "DELETE FROM at_pending_orders WHERE operating_facility_id = '"+facility_id+"'  AND source_order_id = '"+source_order_id+"'";
				pstmt=conn.prepareCall(sql_Anes_delete);
				pstmt.execute();		
				conn.commit();
				String msg="SUCCESS";
				out.println(msg);
				
		}
		//Added for Alpha-OT-[IN:048239] End
		else if(func_mode.equals("Surgeon_notes_dispaly"))
		{	
		String contr_mod_accession_num = "";
		String facility_id		= checkForNull(request.getParameter("facility_id"));		
		String accession_num		= checkForNull(request.getParameter("accession_num"));			
		String speciality_code		= checkForNull(request.getParameter("speciality_code"));		
		String locn_type		= checkForNull(request.getParameter("locn_type"));
		String oper_num	= request.getParameter("accession_num");		
		String resp_id		=	(String)session.getValue("responsibility_id");//Changed against 43896
		//String note_type_count		= "";
		String speciality_code_1	= "";
		String note_type_code		= "";
		String note_type_desc		= "";
		String note_type_val		= "";
		String note_type_val_fin		= "";
		String update_mode			= "N";
		int notes_count = 0;
		boolean notes_entered_flag	= false; 		

		if(speciality_code.equalsIgnoreCase("*ALL")){				
			contr_mod_accession_num = facility_id+oper_num+"*ALL"+locn_type;
			}
		else{
			contr_mod_accession_num = facility_id+oper_num+speciality_code+locn_type;
		}
		//String sql_ca_note_type = "SELECT D.NOTE_TYPE, H.NOTE_TYPE_DESC, D.ACCESSION_NUM ACCESSION_NUM FROM CA_ENCNTR_NOTE D, CA_NOTE_TYPE_LANG_VW H WHERE D.CONTR_MOD_ACCESSION_NUM=? AND D.NOTE_TYPE=H.NOTE_TYPE AND H.LANGUAGE_ID='"+locale+"' ";
		String sql_ca_note_type = "SELECT D.NOTE_TYPE, H.NOTE_TYPE_DESC, D.ACCESSION_NUM ACCESSION_NUM FROM CA_ENCNTR_NOTE D, CA_NOTE_TYPE_LANG_VW H WHERE D.CONTR_MOD_ACCESSION_NUM=? AND D.NOTE_TYPE=H.NOTE_TYPE AND H.LANGUAGE_ID='"+locale+"' and D.Event_Status <> '9' ";//Modified by Sanjay for Surgeon Notes against IN34391	
		pstmt=conn.prepareStatement(sql_ca_note_type);
		pstmt.setString(1,contr_mod_accession_num);
		rs=pstmt.executeQuery();
		while(rs.next()){
			update_mode="Y";
			notes_entered_flag=true;
			accession_num  = rs.getString("ACCESSION_NUM");
			note_type_code = rs.getString("NOTE_TYPE");
			note_type_desc = rs.getString("NOTE_TYPE_DESC");
			note_type_val =note_type_code+","+note_type_desc+","+contr_mod_accession_num+","+update_mode+","+accession_num;
			note_type_val_fin += note_type_val +"~";

	}
	
	if(notes_entered_flag==false){	
			if(speciality_code.equalsIgnoreCase("*ALL"))				
				speciality_code_1="*ALL";	
			else{				
				speciality_code_1 = speciality_code; 
			}

			String	sql_note_type_2="";
			if(!speciality_code_1.equals("*ALL"))
			{		
				//sql_note_type_2="SELECT S.NOTE_TYPE, NOTE_TYPE_DESC FROM OT_NOTE_TYPE_FOR_SPECIALTIES S, CA_NOTE_TYPE_LANG_VW C WHERE SPECIALTY_CODE=? AND LOCN_TYPE=? AND S.NOTE_TYPE=C.NOTE_TYPE AND NVL(C.EFF_STATUS,'E')='E' AND C.LANGUAGE_ID='"+locale+"'";			
				//Query is changed against 43896
				sql_note_type_2="SELECT S.NOTE_TYPE, NOTE_TYPE_DESC FROM OT_NOTE_TYPE_FOR_SPECIALTIES S, CA_NOTE_TYPE_LANG_VW C, ca_note_type_for_resp a WHERE SPECIALTY_CODE= ? AND LOCN_TYPE=? AND S.NOTE_TYPE=C.NOTE_TYPE AND NVL(C.EFF_STATUS,'E')='E' AND C.LANGUAGE_ID='"+locale+"' and a.resp_id = ? AND a.note_type = c.note_type AND a.privilege_type != '5' AND NVL(EFF_STATUS,'E') = 'E' AND c.note_group_id IN (SELECT note_group FROM ca_note_group WHERE appl_task_id = 'OT_NOTES')  ORDER BY 1,2";
			}else
			{	
				//sql_note_type_2="SELECT distinct S.NOTE_TYPE, NOTE_TYPE_DESC FROM OT_NOTE_TYPE_FOR_SPECIALTIES S, CA_NOTE_TYPE_LANG_VW C WHERE LOCN_TYPE=? AND S.NOTE_TYPE=C.NOTE_TYPE AND NVL(C.EFF_STATUS,'E')='E' AND C.LANGUAGE_ID='"+locale+"'";				
				//Query is changed against 43896
				sql_note_type_2="SELECT distinct S.NOTE_TYPE, NOTE_TYPE_DESC FROM OT_NOTE_TYPE_FOR_SPECIALTIES S, CA_NOTE_TYPE_LANG_VW C, ca_note_type_for_resp a WHERE LOCN_TYPE=? AND S.NOTE_TYPE=C.NOTE_TYPE AND NVL(C.EFF_STATUS,'E')='E' AND C.LANGUAGE_ID='"+locale+"' and a.resp_id = ? AND a.note_type = c.note_type AND a.privilege_type != '5' AND NVL(EFF_STATUS,'E') = 'E' AND c.note_group_id IN (SELECT note_group FROM ca_note_group WHERE appl_task_id = 'OT_NOTES')  ORDER BY 1,2";
			}
			if(rs1!=null) rs1.close();
			if(pstmt!=null) pstmt.close();		
			pstmt=conn.prepareStatement(sql_note_type_2);
			if(!speciality_code_1.equals("*ALL"))
			{ 
			pstmt.setString(1,speciality_code_1);
			pstmt.setString(2,locn_type);
			pstmt.setString(3,resp_id);//Changed against 43896
			rs2=pstmt.executeQuery();
			
			while(rs2.next()){				
				notes_count++;
				note_type_code = rs2.getString("NOTE_TYPE");
				note_type_desc = rs2.getString("NOTE_TYPE_DESC");
				note_type_val =note_type_code+","+note_type_desc+","+contr_mod_accession_num+","+update_mode+","+accession_num;
				note_type_val_fin +=note_type_val +"~";
			}
			}else
			{
			pstmt.setString(1,locn_type);
			pstmt.setString(2,resp_id);//Changed against 43896
			rs2=pstmt.executeQuery();
			
			while(rs2.next()){
				notes_count++;
				note_type_code = rs2.getString("NOTE_TYPE");
				note_type_desc = rs2.getString("NOTE_TYPE_DESC");
				note_type_val =note_type_code+","+note_type_desc+","+contr_mod_accession_num+","+update_mode+","+accession_num;
				note_type_val_fin +=note_type_val +"~";
			}
			}
}
out.println(note_type_val_fin);
}
else if(func_mode.equals("Pre_anesthesia_notes"))
{
	String contr_mod_accession_num = checkForNull(request.getParameter("contr_mod_accession_num"));
	String accession_num		= checkForNull(request.getParameter("accession_num"));
	String called_from		= checkForNull(request.getParameter("called_from"));
	String note_type_code		= "";
	String note_type_desc		= "";
	String note_type_val		= "";
	String note_type_val_fin		= "";
	String update_mode			= "N";
	boolean notes_entered_flag	= false;
	String sql_ca_note_type = "SELECT D.NOTE_TYPE, H.NOTE_TYPE_DESC, D.ACCESSION_NUM ACCESSION_NUM FROM CA_ENCNTR_NOTE D, CA_NOTE_TYPE_LANG_VW H WHERE D.CONTR_MOD_ACCESSION_NUM=? and D.Event_Status <> '9' AND D.NOTE_TYPE=H.NOTE_TYPE AND H.LANGUAGE_ID='"+locale+"' "; //added by Sanjay for Surgeon Notes against IN34391
	pstmt=conn.prepareStatement(sql_ca_note_type);
	pstmt.setString(1, contr_mod_accession_num);
	rs=pstmt.executeQuery();
	while(rs.next())
	{
		update_mode="Y";
		notes_entered_flag=true;
		accession_num  = rs.getString("ACCESSION_NUM");
		note_type_code = rs.getString("NOTE_TYPE");
		note_type_desc = rs.getString("NOTE_TYPE_DESC");
		note_type_val =note_type_code+","+note_type_desc+","+contr_mod_accession_num+","+update_mode+","+accession_num;
		note_type_val_fin +=note_type_val +"*";
	}
	if(notes_entered_flag==false)
	{
		if(called_from.equalsIgnoreCase("PRE_ANES") || called_from.equalsIgnoreCase("INTRA_ANES") || called_from.equalsIgnoreCase("POST_ANES"))
		{
			accession_num = "";
			notes_entered_flag=true;
			//String sql_ca_note_type="";
			if(called_from.equalsIgnoreCase("PRE_ANES"))
				sql_ca_note_type = "SELECT A.PRE_ANES_NOTE_TYPE ANES_NOTE_TYPE, N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM AT_PARAM A, CA_NOTE_TYPE_LANG_VW N WHERE N.NOTE_TYPE=A.PRE_ANES_NOTE_TYPE AND N.LANGUAGE_ID='"+locale+"'"; 
			else if(called_from.equalsIgnoreCase("INTRA_ANES"))
				sql_ca_note_type = "SELECT A.INTRA_ANES_NOTE_TYPE ANES_NOTE_TYPE, N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM AT_PARAM A, CA_NOTE_TYPE_LANG_VW N WHERE N.NOTE_TYPE=A.INTRA_ANES_NOTE_TYPE AND N.LANGUAGE_ID='"+locale+"'"; 
			if(called_from.equalsIgnoreCase("POST_ANES"))
				sql_ca_note_type = "SELECT A.POST_ANES_NOTE_TYPE ANES_NOTE_TYPE, N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM AT_PARAM A, CA_NOTE_TYPE_LANG_VW N WHERE N.NOTE_TYPE=A.POST_ANES_NOTE_TYPE AND N.LANGUAGE_ID='"+locale+"'"; 
			if(pstmt!=null)
				pstmt.close();
			pstmt = conn.prepareStatement(sql_ca_note_type);
			rs2 = pstmt.executeQuery();
			if(rs2.next())
			{
				note_type_code = rs2.getString("ANES_NOTE_TYPE");
				note_type_desc = rs2.getString("NOTE_TYPE_DESC");
				note_type_val =note_type_code+","+note_type_desc+","+contr_mod_accession_num+","+update_mode+","+accession_num;
				note_type_val_fin +=note_type_val +"*";
			}
		}
	}
	out.println(note_type_val);
}
else if(func_mode.equals("Operative_notes"))
{
		
		String contr_mod_accession_num = "";
		String facility_id		= checkForNull(request.getParameter("facility_id"));
		String accession_num		= checkForNull(request.getParameter("accession_num"));
		String speciality_code		= checkForNull(request.getParameter("speciality_code"));
		String locn_type		= checkForNull(request.getParameter("locn_type"));
		String oper_num	= request.getParameter("accession_num"); 
		String note_type_code		= "";
		String note_type_desc		= "";
		String note_type_val		= "";
		String note_type_val_fin		= "";
		String update_mode			= "N";
		boolean notes_entered_flag	= false;

			if(speciality_code.equalsIgnoreCase("all"))
			contr_mod_accession_num = facility_id+oper_num+"*ALL"+speciality_code+locn_type;
		else
			contr_mod_accession_num = facility_id+oper_num+speciality_code+locn_type;


	String sql_ca_note_type = "SELECT D.NOTE_TYPE, H.NOTE_TYPE_DESC, D.ACCESSION_NUM ACCESSION_NUM FROM CA_ENCNTR_NOTE D, CA_NOTE_TYPE_LANG_VW H WHERE D.CONTR_MOD_ACCESSION_NUM=? and D.Event_Status <> '9' AND D.NOTE_TYPE=H.NOTE_TYPE AND H.LANGUAGE_ID='"+locale+"' "; //added by Sanjay for Surgeon Notes against IN34391

	pstmt=conn.prepareStatement(sql_ca_note_type);
	pstmt.setString(1,contr_mod_accession_num);
	rs=pstmt.executeQuery();
	if(rs.next()){
		update_mode="Y";
		notes_entered_flag=true;
		accession_num  = rs.getString("ACCESSION_NUM");
		note_type_code = rs.getString("NOTE_TYPE");
		note_type_desc = rs.getString("NOTE_TYPE_DESC");
		note_type_val =note_type_code+","+note_type_desc+","+contr_mod_accession_num+","+update_mode+","+accession_num;
        note_type_val_fin +=note_type_val +"*";
	}
if(notes_entered_flag==false){

		String sql_oper_note = "SELECT P.OPERATIVE_RECORDS_NOTE_TYPE OPERATIVE_RECORDS_NOTE_TYPE, N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM OT_PARAM P, CA_NOTE_TYPE_LANG_VW N WHERE N.NOTE_TYPE=P.OPERATIVE_RECORDS_NOTE_TYPE AND N.LANGUAGE_ID='"+locale+"'"; 

					
			pstmt=conn.prepareStatement(sql_oper_note);
			rs2=pstmt.executeQuery();
			while(rs2.next()){
				note_type_code = rs2.getString("OPERATIVE_RECORDS_NOTE_TYPE");
				note_type_desc = rs2.getString("NOTE_TYPE_DESC");
				note_type_val =note_type_code+","+note_type_desc+","+contr_mod_accession_num+","+update_mode+","+accession_num;
				note_type_val_fin +=note_type_val +"*";
			}
}
	out.println(note_type_val);

}else if(func_mode.equals("chk_note_exists"))
	{

		String contr_mod_accession_num = "";
		String facility_id		= checkForNull(request.getParameter("facility_id"));
		String accession_num		= checkForNull(request.getParameter("accession_num"));
		String speciality_code		= checkForNull(request.getParameter("speciality_code"));
		String locn_type		= checkForNull(request.getParameter("locn_type"));
		String oper_num	= request.getParameter("accession_num"); 
	String note_type_code		= "";
	String note_type_desc		= "";
	String note_type_val		= "";
	String note_type_val_fin		= "";
	String update_mode			= "N";
	boolean notes_entered_flag	= false;

			if(speciality_code.equalsIgnoreCase("all"))
			contr_mod_accession_num = facility_id+oper_num+"*ALL"+locn_type;
		else
			contr_mod_accession_num = facility_id+oper_num+speciality_code+locn_type;


		String sql_ca_note_type = "SELECT D.NOTE_TYPE, H.NOTE_TYPE_DESC, D.ACCESSION_NUM ACCESSION_NUM FROM CA_ENCNTR_NOTE D, CA_NOTE_TYPE_LANG_VW H WHERE D.CONTR_MOD_ACCESSION_NUM=? AND D.NOTE_TYPE=H.NOTE_TYPE and D.Event_Status <> '9' AND H.LANGUAGE_ID='"+locale+"' "; //added by Sanjay for Surgeon Notes against IN34391

	pstmt=conn.prepareStatement(sql_ca_note_type);
	pstmt.setString(1,contr_mod_accession_num);
	rs=pstmt.executeQuery();
	while(rs.next()){
		update_mode="Y";
		notes_entered_flag=true;
		accession_num  = rs.getString("ACCESSION_NUM");
		note_type_code = rs.getString("NOTE_TYPE");
		note_type_desc = rs.getString("NOTE_TYPE_DESC");
		note_type_val =note_type_code+","+note_type_desc+","+contr_mod_accession_num+","+update_mode+","+accession_num;
        note_type_val_fin +=note_type_val +"*";
	}
	out.println(note_type_val_fin);
}else if(func_mode.equals("assignDate")){

//DhanasekarV Modified against the issue IN023690  on 15/11/2010


String weekDay[]=new String[8];

String sunday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
String monday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
String tuesday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
String wednesday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
String thursday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
String friday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
String saturday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
	
weekDay[1]=sunday;
weekDay[2]=monday;
weekDay[3]=tuesday;
weekDay[4]=wednesday;
weekDay[5]= thursday;
weekDay[6]=friday;
weekDay[7]=saturday;


			String date= checkForNull(request.getParameter("date")) ;
			//String curr_day="";
			 int curr_day=1;

		//	String sql_day="select to_char(to_date('"+date+"','dd/mm/yyyy'),'Day') Day from dual";
			String sql_day="select to_char(to_date('"+date+"','dd/mm/yyyy'),'D') Day from dual";
				pstmt = conn.prepareStatement(sql_day);
		        rs = pstmt.executeQuery();
                if(rs!=null && rs.next())
                {
					curr_day=Integer.parseInt(rs.getString(1));
				}
				out.println(weekDay[curr_day]);
//end 23690

}else if(func_mode.equals("checkOverBookYN")){

			String facility_id= checkForNull(request.getParameter("facility_id")) ;
			String room_code= checkForNull(request.getParameter("room_code")) ;
			String over_bk_alwd_yn="";
			String over_book_yn="SELECT OVER_BOOKING_ALLOWED_YN FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID='"+facility_id+"'AND OPER_ROOM_CODE='"+room_code+"'";
				pstmt = conn.prepareStatement(over_book_yn);
		        rs = pstmt.executeQuery();
                if(rs!=null && rs.next())
                {
					over_bk_alwd_yn=rs.getString(1);
				}
				out.println(over_bk_alwd_yn);

}else if(func_mode.equals("checkSlotsCenerated")){

			String facility_id= checkForNull(request.getParameter("facility_id")) ;
			String room_code= checkForNull(request.getParameter("room_code")) ;
			String sch_date= checkForNull(request.getParameter("sch_date")) ;
			String surgeon_code= checkForNull(request.getParameter("surgeon_code")) ;
			String over_bk_alwd_yn="";
			//String over_book_yn="SELECT COUNT(*) SLOTS FROM OT_BOOKING_TIME_SLOTS WHERE OPERATING_FACILITY_ID= '"+facility_id+"' AND OPER_ROOM_CODE='"+room_code+"' AND BOOKING_DATE=TO_DATE('"+sch_date+"','DD/MM/YYYY')";
			String over_book_yn="SELECT COUNT(*) SLOTS FROM OT_DIARY_SCHEDULE WHERE OPERATING_FACILITY_ID= '"+facility_id+"' AND OPER_ROOM_CODE='"+room_code+"' AND BOOKING_DATE=TO_DATE('"+sch_date+"','DD/MM/YYYY') AND TEAM_DOCTOR_CODE='"+surgeon_code+"'";
				pstmt = conn.prepareStatement(over_book_yn);
		        rs = pstmt.executeQuery();
                if(rs!=null && rs.next())
                {
					over_bk_alwd_yn=rs.getString(1);
				}
				out.println(over_bk_alwd_yn);

}
else if(func_mode.equals("chkOverlapForBooking"))// 44528 - Chaitanya Start
{
			CallableStatement cstmt = null ;

			String facilityid= checkForNull(request.getParameter("facilityid"));
			String room_code= checkForNull(request.getParameter("room_code"));
			String booking_date= checkForNull(request.getParameter("booking_date"));
			//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			//Date date = formatter.parse(booking_date);
			String startTime= checkForNull(request.getParameter("startTime"));
			String endTime= checkForNull(request.getParameter("endTime"));

			cstmt=conn.prepareCall("{call OT_OVERLAP_BOOKING_CHK(?,?,?,?,?,?,?,?)}");
			cstmt.setString( 1, facilityid);
			cstmt.setString( 2, room_code);
			cstmt.setString( 3, booking_date);
			cstmt.setString( 4, startTime);
			cstmt.setString( 5, endTime);

			cstmt.registerOutParameter( 6, Types.VARCHAR );	  // ORDER_STATUS_TYPE
			cstmt.registerOutParameter( 7, Types.VARCHAR );	  // STATUS DESC
			cstmt.registerOutParameter( 8, Types.VARCHAR );	  // V_STATUS_INDICATOR			
			cstmt.execute() ;
			out.println(cstmt.getString(7));
}// 44528 - Chaitanya - end
else if(func_mode.equals("checkOverBookingSlotsYN")){

			String facility_id= checkForNull(request.getParameter("facility_id")) ;
			String room_code= checkForNull(request.getParameter("room_code")) ;
			String sch_date= checkForNull(request.getParameter("sch_date")) ;
			String remaining_slots="";
			String ovr_bk_slts_count="SELECT 'Y' L_SLOTS_AVAILABLE  FROM OT_BOOKING_TIME_SLOTS WHERE OPERATING_FACILITY_ID = '"+facility_id+"' AND   OPER_ROOM_CODE  = '"+room_code+"' AND   BOOKING_DATE  = TRUNC(to_date('"+sch_date+"','DD/MM/YYYY')) AND   TO_CHAR(BOOKING_TIME,'SSSSS') > TO_CHAR(to_date('"+sch_date+"','DD/MM/YYYY'),'SSSSS') AND   STATUS   = '10'  AND   ROWNUM   = 1";
				pstmt = conn.prepareStatement(ovr_bk_slts_count);
		        rs = pstmt.executeQuery();
                if(rs!=null && rs.next())
                {
					remaining_slots=rs.getString(1);
				}
				out.println(remaining_slots);

}else if(func_mode.equals("checkOverBookStartTime")){

			String facility_id= checkForNull(request.getParameter("facility_id")) ;
			String sch_date= checkForNull(request.getParameter("sch_date")) ;
			String sch_dt_time=sch_date+" 00:00";
			String over_bk_strt_date="";
			String over_bk_strt_time="";
			String ovr_bk_strt_time="SELECT TO_DATE('"+sch_dt_time+"','DD/MM/YYYY HH24:MI') END_DATE_TIME,TO_CHAR((TO_DATE('"+sch_dt_time+"','DD/MM/YYYY HH24:MI')- TO_CHAR(UNIT_OT_TIME,'SSSSS')/(24*60*60)),'HH24:MI') START_DATE_TIME FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID = '"+facility_id+"' ";
				pstmt = conn.prepareStatement(ovr_bk_strt_time);
		        rs = pstmt.executeQuery();
                if(rs!=null && rs.next())
                {
					over_bk_strt_date=rs.getString(1);
					over_bk_strt_time=rs.getString(2);
				}
				out.println(over_bk_strt_time);

}else if(func_mode.equals("ref_long_name")){

			String ref_src_id= checkForNull(request.getParameter("ref_src_id")) ;
			String ref_src_long_name="";
			String ref_long_name="SELECT LONG_NAME  DESCRIPTION FROM AM_REFERRAL_LANG_VW WHERE LANGUAGE_ID ='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E' AND REFERRAL_CODE='"+ref_src_id+"' ";
				pstmt = conn.prepareStatement(ref_long_name);
		        rs = pstmt.executeQuery();
                if(rs!=null && rs.next())
                {
					ref_src_long_name=rs.getString(1);
				}
				out.println(ref_src_long_name);

}else if(func_mode.equals("getOperDesc")){
			String facility_id= checkForNull(request.getParameter("facility_id")) ;
			String booking_num= checkForNull(request.getParameter("booking_num")) ;
			String waitlist_key= checkForNull(request.getParameter("waitlist_key")) ;
			StringBuffer sbf=new StringBuffer();
			String oper_proc_sql="";
			String oper_desc="";
			if(waitlist_key.equals("YES")){
				oper_proc_sql=" SELECT B.LONG_DESC DESC1  FROM  OT_WAITLISTING_DTL A, OT_OPER_MAST_LANG_VW B WHERE A.OPERATING_FACILITY_ID  = '"+facility_id+"' AND  A.WAITLIST_NUM  = '"+booking_num+"'  AND  A.OPER_CODE	= B.OPER_CODE  AND LANGUAGE_ID='"+locale+"' "; // Modified against CRF-199
			}else{
				oper_proc_sql="SELECT B.LONG_DESC LONG_DESC1  FROM  OT_BOOKING_DTLS A, OT_OPER_MAST_LANG_VW B WHERE A.OPERATING_FACILITY_ID = '"+facility_id+"' AND	 A.BOOKING_NUM 	= '"+booking_num+"'  AND  A.OPER_CODE	= B.OPER_CODE  AND LANGUAGE_ID='"+locale+"' ";
			}
				pstmt = conn.prepareStatement(oper_proc_sql);
		        rs = pstmt.executeQuery();
                while(rs.next())
                {
					oper_desc=rs.getString(1);
					sbf.append(oper_desc);
					sbf.append(",");
				}
				String oper_desc_fin=sbf.toString();
				out.println(oper_desc_fin);

}else if(func_mode.equals("slate_order_status"))
{

	String appt_ref_num= checkForNull(request.getParameter("appt_ref_num")) ;
	String facilityid= checkForNull(request.getParameter("facilityid")) ;
		CallableStatement cstmt = null ;
		String status			= "S" ;
		String order_status_type = "";
		String status_desc		= "" ;
		String status_indicator = "" ;
		String lang_error_text = "";
		String result_text = "";
		ArrayList result		= new ArrayList();

		cstmt=conn.prepareCall("{call OT_GET_SLATE_ORDER_STATUS(?,?,?,?,?,?,?,null,?,?)}");
			cstmt.setString( 1, facilityid);
			cstmt.setString( 2, appt_ref_num);

			cstmt.registerOutParameter( 3, Types.VARCHAR );	  // ORDER_STATUS_TYPE
			cstmt.registerOutParameter( 4, Types.VARCHAR );	  // STATUS DESC
			cstmt.registerOutParameter( 5, Types.VARCHAR );	  // V_STATUS_INDICATOR			
			cstmt.registerOutParameter( 6, Types.VARCHAR );	  // STATUS-> 'E' for Error and 'S' for Success
			cstmt.registerOutParameter( 7, Types.VARCHAR );  // ERROR_TEXT
			cstmt.registerOutParameter( 8, Types.VARCHAR );  // ADD FIELD
			cstmt.registerOutParameter( 9, Types.VARCHAR );  // LANG_ERROR_TEXT
			cstmt.execute() ;
			order_status_type	= cstmt.getString(3);
			if(order_status_type ==null) order_status_type="";
			status_desc			= cstmt.getString(4);
			if(status_desc ==null) status_desc="";
			status_indicator	= cstmt.getString(5);
			if(status_indicator ==null) status_indicator="";
			status				= cstmt.getString(6);
			if(status ==null) status="";
			result_text				= cstmt.getString(8);
			if(result_text ==null) result_text="";
			lang_error_text		= cstmt.getString(9);
			if(lang_error_text ==null) lang_error_text="";


			if(status.equals("E")){
				System.err.println("Caught Error in SlateBean: "+cstmt.getString(7));
				//out.println(lang_error_text);
			}
	//	result.add(status);
	//	result.add(order_status_type);
		result.add(status_desc);
//		result.add(status_indicator);
//		result.add(result_text);
		out.println(result);	
}else if(func_mode.equals("multiple_oper_display"))
{
		String appt_ref_num= checkForNull(request.getParameter("appt_ref_num")) ;
		String oper_num= checkForNull(request.getParameter("oper_num")) ;
		String call_from= checkForNull(request.getParameter("call_from")) ;
// Added by Dilip on 08/04/2011 Incident No: 27032
		String facilityid= checkForNull(request.getParameter("facilityid")) ;
		ArrayList result = new ArrayList();
		StringBuffer sb_oper_desc = new StringBuffer();
		int mult_oper_size=0;
	String operationsProcedures_value=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels");
	sb_oper_desc.append(operationsProcedures_value);
				if(call_from.equals("scheduled_cases")){
			if(oper_num.equals("")){
				pstmt		= conn.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT14")) ;
				pstmt.setString(1,locale);
				pstmt.setString(2,appt_ref_num);
// Added by Dilip on 08/04/2011 Incident No: 27032
				pstmt.setString(3,facilityid);
				rs	= pstmt.executeQuery();
				while(rs!=null && rs.next()){
					result.add(rs.getString("OPER_DESC"));
				}
			}
			else{
				pstmt		= conn.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT16")) ;
				pstmt.setString(1,locale);
				pstmt.setString(2,oper_num);
				// Added by Dilip on 08/04/2011 Incident No: 27032
				pstmt.setString(3,facilityid);
				rs	= pstmt.executeQuery();
				while(rs!=null && rs.next()){
					result.add(rs.getString("OPER_DESC"));
				}
			}
			}
			else if(call_from.equals("un_scheduled_cases")){
				pstmt		= conn.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT16")) ;
				pstmt.setString(1,locale);
				pstmt.setString(2,oper_num);
				// Added by Dilip on 08/04/2011 Incident No: 27032
				pstmt.setString(3,facilityid);
				rs	= pstmt.executeQuery();
				while(rs!=null && rs.next()){
					result.add(rs.getString("OPER_DESC"));
				}
			}
			mult_oper_size = result.size();
		for(int m=0;m<mult_oper_size;m++){
				sb_oper_desc.append(",");
			sb_oper_desc.append((String)result.get(m));
		}

			String oper_desc_disp=sb_oper_desc.toString();
out.println(oper_desc_disp);	
}else if(func_mode.equals("status_display_tooltip"))
{
		StringBuffer status_times  = new StringBuffer();
		String facilityid= checkForNull(request.getParameter("facilityid")) ;
		String oper_num= checkForNull(request.getParameter("oper_num")) ;
		String called_from= checkForNull(request.getParameter("called_from")) ;
		String case_called_time= checkForNull(request.getParameter("case_called_time")) ;
		String check_out_from_ward_time= checkForNull(request.getParameter("check_out_from_ward_time")) ;
		String rescheduled_count= checkForNull(request.getParameter("rescheduled_count")) ;
		String order_id= checkForNull(request.getParameter("order_id")) ;  // Added for ML-MMOH-SCF-0406
		if(rescheduled_count ==null) rescheduled_count="";
		String check_in_time="";
		String cancellation_date_time="";
		String cancelled_by="";
		String cancel_reason="";
		String check_into_holding_area_time="";
		String check_into_or_time="";
		String nursing_doc_comp_time="";
		String surgeon_doc_comp_time="";
		String anaesthetist_doc_comp_time="";
		String recovery_start_time="";
		String recovery_end_time="";
		String check_out_time="";
		/* Below query is commented and changed against 44019 by SelvinM */		
		//commented for ML-BRU-SCF-1184 [IN:045531] 
		//String sql_status="SELECT  TO_CHAR(A.CHECK_IN_TIME,'DD/MM/YYYY HH24:MI') CHECK_IN_TIME,CANCELLED_BY,TO_CHAR(CANCELLATION_DATE_TIME,'DD/MM/YYYY HH24:MI') CANCELLATION_DATE_TIME, NVL((SELECT reason_desc FROM ot_reasons_lang_vw WHERE language_id = ? AND reason_code = cancel_reason),       (SELECT  CAN_LINE_REASON  from OR_ORDER_LINE where ORDER_ID=A.ORDER_ID)) CANCEL_REASON, TO_CHAR(A.CHECK_INTO_HOLDING_AREA_TIME,'DD/MM/YYYY HH24:MI') CHECK_INTO_HOLDING_AREA_TIME, TO_CHAR(A.CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI') CHECK_INTO_OR_TIME,TO_CHAR(A.NURSING_DOC_COMP_TIME,'DD/MM/YYYY HH24:MI') NURSING_DOC_COMP_TIME,TO_CHAR(A.SURGEON_DOC_COMP_TIME,'DD/MM/YYYY HH24:MI') SURGEON_DOC_COMP_TIME,TO_CHAR(A.ANAESTHETIST_DOC_COMP_TIME,'DD/MM/YYYY HH24:MI') ANAESTHETIST_DOC_COMP_TIME,TO_CHAR(A.RECOVERY_START_TIME,'DD/MM/YYYY HH24:MI') RECOVERY_START_TIME,TO_CHAR(A.RECOVERY_END_TIME,'DD/MM/YYYY HH24:MI') RECOVERY_END_TIME,TO_CHAR(A.CHECK_OUT_TIME,'DD/MM/YYYY HH24:MI') CHECK_OUT_TIME FROM OT_POST_OPER_HDR A WHERE A.OPERATING_FACILITY_ID = ? AND A.OPER_NUM =?";

		String sql_status="SELECT TO_CHAR (a.check_in_time, 'DD/MM/YYYY HH24:MI') check_in_time,cancelled_by,TO_CHAR (cancellation_date_time,'DD/MM/YYYY HH24:MI') cancellation_date_time,NVL ((SELECT reason_desc FROM ot_reasons_lang_vw WHERE language_id = ? AND reason_code = cancel_reason),(SELECT can_line_reason FROM or_order_line WHERE order_id = a.order_id and ORDER_LINE_NUM =1))cancel_reason,TO_CHAR (a.check_into_holding_area_time,  'DD/MM/YYYY HH24:MI') check_into_holding_area_time,TO_CHAR (a.check_into_or_time,'DD/MM/YYYY HH24:MI') check_into_or_time,TO_CHAR (a.nursing_doc_comp_time,'DD/MM/YYYY HH24:MI') nursing_doc_comp_time,TO_CHAR (a.surgeon_doc_comp_time,'DD/MM/YYYY HH24:MI') surgeon_doc_comp_time,TO_CHAR (a.anaesthetist_doc_comp_time,      'DD/MM/YYYY HH24:MI') anaesthetist_doc_comp_time,TO_CHAR (a.recovery_start_time,'DD/MM/YYYY HH24:MI') recovery_start_time,TO_CHAR (a.recovery_end_time, 'DD/MM/YYYY HH24:MI') recovery_end_time,TO_CHAR (a.check_out_time, 'DD/MM/YYYY HH24:MI') check_out_time FROM ot_post_oper_hdr a WHERE a.operating_facility_id = ? AND a.oper_num = ?";//modified for ML-BRU-SCF-1184 [IN:045531] & 67603 (wm_concat)
		
		String sql_status_que = "SELECT TO_CHAR (a.case_called_time, 'DD/MM/YYYY HH24:MI') case_called_time,TO_CHAR (a.check_out_from_ward_time,'DD/MM/YYYY HH24:MI') check_out_from_ward_time,a.holding_area_code, b.can_pract_id cancelled_by, TO_CHAR (b.can_date_time, 'DD/MM/YYYY HH24:MI')  cancellation_date_time,(SELECT can_line_reason FROM or_order_line WHERE order_id = b.order_id AND ROWNUM = 1) cancel_reason FROM ot_queue a, or_order_line b WHERE a.order_id = b.order_id AND a.operating_facility_id = ? AND a.order_id = ? AND b.can_date_time IS NOT NULL"; // Added for ML-MMOH-SCF-0406
		if(!oper_num.equals("")){ // Added for ML-MMOH-SCF-0406
		pstmt		= conn.prepareStatement(sql_status) ;
		pstmt.setString(1,locale);
		pstmt.setString(2,facilityid);
		pstmt.setString(3,oper_num);
			rs	= pstmt.executeQuery();
			
				if(rs!=null && rs.next()){
					check_in_time=checkForNull(rs.getString("CHECK_IN_TIME"));
					cancellation_date_time=checkForNull(rs.getString("CANCELLATION_DATE_TIME"));
					cancelled_by=checkForNull(rs.getString("CANCELLED_BY"));
					cancel_reason=checkForNull(rs.getString("CANCEL_REASON"));
					check_into_holding_area_time=checkForNull(rs.getString("CHECK_INTO_HOLDING_AREA_TIME"));
					check_into_or_time=checkForNull(rs.getString("CHECK_INTO_OR_TIME"));
					nursing_doc_comp_time=checkForNull(rs.getString("NURSING_DOC_COMP_TIME"));
					surgeon_doc_comp_time=checkForNull(rs.getString("SURGEON_DOC_COMP_TIME"));
					anaesthetist_doc_comp_time=checkForNull(rs.getString("ANAESTHETIST_DOC_COMP_TIME"));
					recovery_start_time=checkForNull(rs.getString("RECOVERY_START_TIME"));
					recovery_end_time=checkForNull(rs.getString("RECOVERY_END_TIME"));
					check_out_time=checkForNull(rs.getString("CHECK_OUT_TIME"));
				}
			} // Added start for ML-MMOH-SCF-0406
			 else{
					pstmt = conn.prepareStatement(sql_status_que);
					pstmt.setString(1,facilityid);
					pstmt.setString(2,order_id);
					rs=pstmt.executeQuery();
					if(rs!=null && rs.next()){
					cancellation_date_time=checkForNull(rs.getString("CANCELLATION_DATE_TIME"));
					cancelled_by=checkForNull(rs.getString("CANCELLED_BY"));
					cancel_reason=checkForNull(rs.getString("CANCEL_REASON"));
					}
					
			}	
			// Added End for ML-MMOH-SCF-0406
		String cancelled_date_time = "";
		if(called_from.equals("SCH")){
			status_times.append("<B>");
			status_times.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.CaseCalledTime.Label","ot_labels"));
			status_times.append(":");
			status_times.append("</B>");
			status_times.append(com.ehis.util.DateUtils.convertDate(case_called_time,"DMYHM","en",locale));
			status_times.append(",");
			status_times.append("<B>");
			status_times.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.WardCheckoutTime.Label","ot_labels"));
			status_times.append(":");
			status_times.append("</B>");
			status_times.append(com.ehis.util.DateUtils.convertDate(check_out_from_ward_time,"DMYHM","en",locale));
			status_times.append(",");
		}
		status_times.append("<B>");
		status_times.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.CheckInTime.Label","ot_labels"));
		status_times.append(":");
		status_times.append("</B>");
		status_times.append(com.ehis.util.DateUtils.convertDate(check_in_time,"DMYHM","en",locale));

//DhanasekarV modified for issue  IN024152  01/10/2010
			cancelled_date_time=cancellation_date_time;
		if(!cancelled_date_time.equals("")){
		//end  IN024152


			status_times.append(",");	

			status_times.append("<B>");
			status_times.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelledby.label","common_labels"));
			status_times.append(":");
			status_times.append("</B>");
			status_times.append(cancelled_by);

			status_times.append(",");
			status_times.append("<B>");
			status_times.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelledDate/Time.label","common_labels"));
			status_times.append(":");
			status_times.append("</B>");
			status_times.append(com.ehis.util.DateUtils.convertDate(cancellation_date_time,"DMYHM","en",locale));				

			status_times.append(",");
			status_times.append("<B>");
			status_times.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.CancelledReason.Label","ot_labels"));
			status_times.append(":");
			status_times.append("</B>");
			status_times.append(cancel_reason);
		}else{
			status_times.append(",");
			status_times.append("<B>");
			status_times.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.HoldingAreaTime.Label","ot_labels"));
			status_times.append(":");
			status_times.append("</B>");
			status_times.append(com.ehis.util.DateUtils.convertDate(check_into_holding_area_time,"DMYHM","en",locale));
			status_times.append(",");
			status_times.append("<B>");
			status_times.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.CheckIntoORTime.Label","ot_labels"));
			status_times.append(":");
			status_times.append("</B>");
			status_times.append(com.ehis.util.DateUtils.convertDate(check_into_or_time,"DMYHM","en",locale));
			status_times.append(",");
			status_times.append("<B>");
			status_times.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.NursingDocCmplTime.Label","ot_labels"));
			status_times.append(":");
			status_times.append("</B>");
			status_times.append(com.ehis.util.DateUtils.convertDate(nursing_doc_comp_time,"DMYHM","en",locale));
			status_times.append(",");
			status_times.append("<B>");
			status_times.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SurgDocCmplTime.Label","ot_labels"));
			status_times.append(":");
			status_times.append("</B>");
			status_times.append(com.ehis.util.DateUtils.convertDate(surgeon_doc_comp_time,"DMYHM","en",locale));
			status_times.append(",");
			status_times.append("<B>");
			status_times.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AnaesthetistDocComTime.Label","ot_labels"));
			status_times.append(":");
			status_times.append("</B>");
			status_times.append(com.ehis.util.DateUtils.convertDate(anaesthetist_doc_comp_time,"DMYHM","en",locale));
			status_times.append(",");
			status_times.append("<B>");
			status_times.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RecoveryStartTime.Label","ot_labels"));
			status_times.append(":");
			status_times.append("</B>");
			status_times.append(com.ehis.util.DateUtils.convertDate(recovery_start_time,"DMYHM","en",locale));
			status_times.append(",");
			status_times.append("<B>");
			status_times.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RecoveryEndTime.Label","ot_labels"));
			status_times.append(":");
			status_times.append("</B>");
			status_times.append(com.ehis.util.DateUtils.convertDate(recovery_end_time,"DMYHM","en",locale));
			status_times.append(",");
			status_times.append("<B>");
			status_times.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.CheckOutTime.Label","ot_labels") );
			status_times.append(":");
		    status_times.append("</B>");
			status_times.append(com.ehis.util.DateUtils.convertDate(check_out_time,"DMYHM","en",locale));
			
			//Added by Arthi for ML-MMOH-CRF-1936
			if(isTimeDtlsSurNurAppl){
			status_times.append(",");
			status_times.append("<B>");
			status_times.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.TimeandDetails.Label","ot_labels") );
			status_times.append(":");
		    status_times.append("</B>");
			if(timedtl_cnt > 0){
				status_times.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Recorded.Label","ot_labels") );
			}else{
				status_times.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.NotyetRecorded.Label","ot_labels") );
			}
			}//End ML-MMOH-CRF-1936
			
		}
		if(called_from.equals("SCH")){
			if(!rescheduled_count.equals(""))
			{
			if(Integer.parseInt(rescheduled_count)>0)
			{
				status_times.append(",");
				status_times.append("<B>");
				status_times.append("Reschedule Count: ");
				status_times.append(":");
				status_times.append("</B>");
				status_times.append(rescheduled_count);
			}
			}
		}
	out.println(status_times.toString());	

	}else if(func_mode.equals("reschedule_display_tooltip")){
		//Added by Gaurav Against ML-MMOH-CRF-1791-US04...starts
		StringBuffer reschdl_status  = new StringBuffer();
		
		String facilityid= checkForNull(request.getParameter("facilityid"));
		String order_id= checkForNull(request.getParameter("order_id"));
		String patient_id= checkForNull(request.getParameter("patient_id"));
		String called_from= checkForNull(request.getParameter("called_from"));
		
		String can_trn_reason_code="";
		String booking_start_time="";
		String booking_end_time="";
		String frm_booking_st_time="";
		String frm_booking_end_time="";
		String record_id="";
		String reason_desc="";
		String reschd_by="";
			
		String sql_resch = "SELECT TO_CHAR (a.booking_start_time,'DD/MM/YYYY HH24:MI') booking_start_time,TO_CHAR (a.booking_end_time, 'HH24:MI') booking_end_time,TO_CHAR (a.frm_booking_st_time,'DD/MM/YYYY HH24:MI') frm_booking_st_time,a.record_id,TO_CHAR (a.frm_booking_end_time, 'HH24:MI') frm_booking_end_time,a.can_trn_reason_code, c.RESCHD_BY, b.reason_desc FROM ot_booking_del_tr a, ot_reasons b, ot_queue c WHERE a.patient_id = ? AND a.order_id = ? AND b.reason_code = a.can_trn_reason_code AND a.booking_num = C.APPT_REF_NUM ORDER BY a.record_id DESC";
		
		pstmt		= conn.prepareStatement(sql_resch) ;
		pstmt.setString(1,patient_id);
		pstmt.setString(2,order_id);
		rs	= pstmt.executeQuery();

		reschdl_status.append("<tr>" +"<th>");
		reschdl_status.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DateTimeScheduled.Label","ot_labels"));
		reschdl_status.append( "</th>" + "<th>");
		reschdl_status.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DateTimeRescheduled.Label","ot_labels"));
		reschdl_status.append( "</th>" + "<th>");
		reschdl_status.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Reasons.label","ot_labels"));
		reschdl_status.append( "</th>" + "<th>");
		reschdl_status.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PerformedBy.Label","ot_labels"));
		reschdl_status.append( "</th>");
		
		
		while(rs!=null && rs.next()){
			
			can_trn_reason_code = checkForNull(rs.getString("can_trn_reason_code"));
			booking_start_time = checkForNull(rs.getString("booking_start_time"));
			booking_end_time = checkForNull(rs.getString("booking_end_time"));
			frm_booking_st_time = checkForNull(rs.getString("frm_booking_st_time"));
			frm_booking_end_time = checkForNull(rs.getString("frm_booking_end_time"));
			record_id = checkForNull(rs.getString("record_id"));
			reason_desc = checkForNull(rs.getString("reason_desc"));
			reschd_by = checkForNull(rs.getString("RESCHD_BY"));
									
			
		reschdl_status.append("<tr><td>");
		reschdl_status.append(frm_booking_st_time+"-"+frm_booking_end_time);
		reschdl_status.append("</td><td>");
		reschdl_status.append(booking_start_time+"-"+booking_end_time);
		reschdl_status.append("</td><td style='width: 350px;'>");
		reschdl_status.append(reason_desc);
		reschdl_status.append("</td><td>");
		reschdl_status.append(reschd_by);
                reschdl_status.append("</td></tr>");
		
	
			
		}
	
	if(can_trn_reason_code.equals("")){
		out.println("SCHEDULED");
	}else{
		out.println(reschdl_status.toString());	
	}
	//Added by Gaurav Against ML-MMOH-CRF-1791-US04...starts

}else if(func_mode.equals("order_catalog_desc")){

	String order_id= checkForNull(request.getParameter("order_id")) ;
	String oper_desc="";
	String oper_desc_main="";
	StringBuffer sb_oper_desc = new StringBuffer();
	int mult_oper_size=0;
	ArrayList result = new ArrayList();
	String operationsProcedures_value=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels");
	sb_oper_desc.append(operationsProcedures_value);
	//Commented against MMS-QH-CRF-0199
	/*String order_cat_desc="SELECT B.LONG_DESC FROM OR_ORDER_LINE A, OR_ORDER_CATALOG_LANG_VW B WHERE B.LANGUAGE_ID='"+locale+"' AND   A.ORDER_ID  = '"+order_id+"' AND A.ORDER_CATALOG_CODE = B.ORDER_CATALOG_CODE ORDER BY 1";*/
	//Added against MMS-QH-CRF-0199
	String order_cat_desc="SELECT B.LONG_DESC FROM OR_ORDER_LINE A, OT_OPER_MAST_LANG_VW B WHERE B.LANGUAGE_ID='"+locale+"' AND   A.ORDER_ID  = '"+order_id+"' AND A.ORDER_CATALOG_CODE = B.ORDER_CATALOG_CODE ORDER BY 1";
	pstmt = conn.prepareStatement(order_cat_desc);
	rs = pstmt.executeQuery();
	while(rs!=null && rs.next())
	{
		oper_desc=rs.getString(1);
		oper_desc_main=oper_desc_main+oper_desc+",";
		result.add(rs.getString("LONG_DESC"));
	}
		mult_oper_size = result.size();
	for(int m=0;m<mult_oper_size;m++){
		sb_oper_desc.append(",");
		sb_oper_desc.append((String)result.get(m));
	}
	String oper_desc_disp=sb_oper_desc.toString();
	out.println(oper_desc_disp);
}
//Added by Muthu for RUT-CRF-0057
else if(func_mode.equals("check_Image_flag")){
		String equipment_code = checkForNull(request.getParameter("equipment_code"));
		String image_file = "";
		String location = "";//Added by muthuN for RUT-CRF-0091
		String sql_image_flag="SELECT image_file,LOCATION FROM OT_EQUIPMENT WHERE equipment_code='"+equipment_code+"'";
		pstmt = conn.prepareStatement(sql_image_flag);
		rs = pstmt.executeQuery();
		while(rs!= null && rs.next()){
			image_file = checkForNull(rs.getString(1));
			//Added by muthuN for RUT-CRF-0091
			location = checkForNull(rs.getString(2));//Added by muthuN for RUT-CRF-0091
			//Added by muthuN for RUT-CRF-0091
			}
		out.println(location + "~BR~" + image_file);
	}

else if(func_mode.equals("check_CSSD_Image_flag")){
		String instr_code = checkForNull(request.getParameter("instr_code"));
		String image_file = "";
		String location = "";//Added by muthuN for RUT-CRF-0091
		String sql_cssd_image_flag="SELECT image_file,location FROM OT_INSTRUMENT WHERE instr_code='"+instr_code+"'";
		pstmt = conn.prepareStatement(sql_cssd_image_flag);
		rs = pstmt.executeQuery();
		while(rs!= null && rs.next()){
			image_file = checkForNull(rs.getString(1));
			//Added by muthuN for RUT-CRF-0091
			location = checkForNull(rs.getString(2));//Added by muthuN for RUT-CRF-0091
			//Added by muthuN for RUT-CRF-0091
			}
		out.println(location + "~BR~" + image_file);
	}
//Added by Muthu for RUT-CRF-0057
//Added by Muthu for RUT-CRF-0091 Starts
else if(func_mode.equals("check_Image_flag_Admin_component")){
		String item_code = checkForNull(request.getParameter("item_code"));
		String image_file = "";
		String location = "";//Added by muthuN for RUT-CRF-0091
		String sql_image_flag="SELECT image_file,LOCATION FROM OT_SS_COMPONENTS WHERE ITEM_CODE='"+item_code+"'";
		pstmt = conn.prepareStatement(sql_image_flag);
		rs = pstmt.executeQuery();
		while(rs!= null && rs.next()){
			image_file = checkForNull(rs.getString(1));
			location = checkForNull(rs.getString(2));//Added by muthuN for RUT-CRF-0091
			}
			out.println(location + "~BR~" + image_file);
	}
//Added by Muthu for RUT-CRF-0091 Ends
//Added by Sanjay for Anaesthesia Required Checkbox against IN032063 STARTS here
    else if (func_mode.equals("anes_req_YN")){    	
    	String SPECIALITY_CODE = checkForNull(request.getParameter("SPECIALITY_CODE"));
    	String strAnesReqYN = "S";
    	
    	if(SPECIALITY_CODE.length()>0){    		
    		//Added by Sanjay for Anaesthesia Required Checkbox agaisnt IN032063 STARTS here    		 
    		String sqlAnesReq="SELECT NVL(ANAESTHESIA_REVIEW_REQD_YN,'N') FROM OT_SPECIALITIES WHERE SPECIALITY_CODE = ?";
    		 pstmt = conn.prepareStatement(sqlAnesReq);
    		 pstmt.setString(1,SPECIALITY_CODE);    		 
    		 rs=pstmt.executeQuery();		 
    		 if(rs.next()==true){			 
    			 strAnesReqYN=rs.getString(1);			 
    		  }
    		 if(rs!=null)	rs.close();
    		 pstmt.close();
    		 //Added by Sanjay for Anaesthesia Required Checkbox agaisnt IN032063 ENDS here    		 
    	}
    	out.println(strAnesReqYN);
    }

//Added by Sanjay for Anaesthesia Required Checkbox against IN032063 ENDS here



//Added by lakshmi against MO-CRF-20058 starts here
	else if(func_mode.equals("overbooking_slots_display")){
		StringBuffer overbook_details  = new StringBuffer();
		String oper_room_code = checkForNull(request.getParameter("oper_room_code"));		
		String facility_id = checkForNull(request.getParameter("facility_id"));		
		String booking_date = checkForNull(request.getParameter("booking_date"));
		//String test[] = booking_date.split("/");
		//int test_1 = Integer.parseInt(test[1])-1;

		//String booking_date_final = test[0]+"/"+"0"+test_1+"/"+test[2];		
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");   
		SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");  
		Date date = format1.parse(booking_date); 
		String bookingDate= format2.format(date);
		
		String available_slots = "";
		String booked_slots = "";
		String sql_overbooking="SELECT TOTAL_SLOTS, BOOKED_SLOTS FROM OT_OVER_BOOKING_SCHDULE  WHERE OPER_ROOM_CODE = '"+oper_room_code+"' AND OPERATING_FACILITY_ID = '"+facility_id+"' AND SCHDULE_DATE = '"+bookingDate+"'";
		//String sql_overbooking="SELECT AVAILABLE_SLOTS, BOOKED_SLOTS FROM OT_THEATRE_SCHEDULE WHERE OPER_ROOM_CODE = '"+oper_room_code+"' AND OPERATING_FACILITY_ID = '"+facility_id+"'";
		pstmt = conn.prepareStatement(sql_overbooking);
		rs = pstmt.executeQuery();
		while(rs!= null && rs.next()){
			available_slots = checkForNull(rs.getString(1));				
			booked_slots = checkForNull(rs.getString(2));				
			}
			
			overbook_details.append(",");
			
			overbook_details.append("<B>");
			overbook_details.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.total.label","common_labels"));
			overbook_details.append(":");
			overbook_details.append("</B>");
			overbook_details.append(available_slots);

			overbook_details.append(",");	

			overbook_details.append("<B>");
			overbook_details.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booked.label","common_labels"));
			overbook_details.append(":");
			overbook_details.append("</B>");
			overbook_details.append(booked_slots);
	
	String result = overbook_details.toString();
		out.println(result);
		
	}
	//Added by lakshmi against MO-CRF-20058 ends here
	//Added by Rajesh - 10-Sep-2012
	else if(func_mode.equals("check_for_speciality")){
		String facility_val = "";
		String sql_facility = "SELECT CUSTOMER_ID FROM SM_SITE_PARAM where rownum=1";
		pstmt = conn.prepareStatement(sql_facility);
		rs = pstmt.executeQuery();
		while(rs.next()){
			facility_val = rs.getString("CUSTOMER_ID");
		}
		
		out.println(facility_val);
	}
	//Added by Rajesh - 10-Sep-2012
	//Checking Discharge Advice - Rajesh V 10/11/2012
	else if(func_mode.equals("discharge_check")){
		String dis_encounter_id = checkForNull(request.getParameter("dis_encounter_id"));	
		String dis_patient_class = checkForNull(request.getParameter("dis_patient_class"));	
		String dis_facility_id = checkForNull(request.getParameter("dis_facility_id"));	
		String sqlDischargeCheck = "SELECT count(*) total from ip_discharge_advice where facility_id= ? AND ENCOUNTER_ID=? AND DIS_ADV_STATUS IN ('0','1')";
		int encounter = 0;
		if("IP".equals(dis_patient_class)){
			pstmt = conn.prepareStatement(sqlDischargeCheck);
			pstmt.setString(1, dis_facility_id);
			pstmt.setString(2, dis_encounter_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				encounter = rs.getInt("total");
			}
		}
		
		
		
		out.println(encounter);
	}
	//Checking Discharge Advice - Rajesh V 10/11/2012
	//Checking Patient Gender IN34756 - Rajesh V 12/10/2012
	else if(func_mode.equals("pat_gender_check")){
		String patient_id = checkForNull(request.getParameter("patient_id"));	
		String sqlPatientGender = "SELECT sex from mp_patient where patient_id= ?";
		String sex = "";

		pstmt = conn.prepareStatement(sqlPatientGender);
		pstmt.setString(1, patient_id);
		rs = pstmt.executeQuery();
					
		while(rs.next()){
			sex = rs.getString("sex");
		}
		out.println(sex);
	}
	//Checking Patient Gender IN34756 - Rajesh V 12/10/2012
	//CRF-004 Authorize Slots for Booking - Rajesh V  
	else if(func_mode.equals("chkPermSlots")){
		String bookingDate = checkForNull(request.getParameter("booking_date"));
		String doctorCode = checkForNull(request.getParameter("doctor_code"));
		String operRoom = checkForNull(request.getParameter("oper_room"));
		//String specialityCode = checkForNull(request.getParameter("speciality_code"));
		int totalDuration = Integer.parseInt(checkForNull(request.getParameter("total_dur"),"0"));//55916
		String sqlBookedSlots = "";
		if(!doctorCode.equals("*ALL"))
		{
			//modified for ML-BRU-SCF-1167 [IN:045346] and ML-BRU-SCF-1640 [IN 056671]
			 sqlBookedSlots 	=   "select nvl(sum(no_of_slots),0) no_of_slots "+
				                    "from ot_booking_hdr where booking_date = to_date(?,'dd/mm/yyyy') "+ 
				                    "and (team_doctor_code = ? OR  team_doctor_code IS NULL ) " +
								 // "and (? = '*ALL' or team_doctor_code is null) "+"
								  "and oper_room_code = ? and operating_facility_id = ? and booking_status != '9'";	
		}
		else
		{
			//modified for ML-BRU-SCF-1167 [IN:045346] and ML-BRU-SCF-1640 [IN 056671]
			 sqlBookedSlots ="select nvl(sum(no_of_slots),0) no_of_slots from ot_booking_hdr where booking_date = to_date(?,'dd/mm/yyyy')"+ 
				                    "and (? = '*ALL' OR team_doctor_code is null) "+
									// "and team_doctor_code = ? "+
									"and oper_room_code = ? "+
									"and operating_facility_id = ? and booking_status != '9'"; 								
		}
		//String sqlAlowableSlots = 	"select nvl(permissible_slots,0) permissible_slots from OT_DIARY_TIMETABLE "+"where oper_room_code= ? and resource_id = ? and "+ "operating_facility_id = ?"; // and speciality_code = ?";
		String sqlForUnitTime	=	"SELECT TO_CHAR(unit_ot_time, 'hh24:mi') unit_ot_time "+
									"FROM   ot_param_for_facility  WHERE  operating_facility_id = ?"; 
		int bookedSlots = 0;
		int allowableSlots = 0;
		int intAllowable = 0;
		String strAllowable = "";
		String unitTime = "";
		String retVal = "";		
		
		pstmt = conn.prepareStatement(sqlBookedSlots);
	
		pstmt.setString(1, bookingDate);
		pstmt.setString(2, doctorCode);
		pstmt.setString(3, operRoom);
		pstmt.setString(4, operFacilityId);
		
		rs = pstmt.executeQuery();
					
		if(rs.next()){
			bookedSlots = rs.getInt("no_of_slots");
		}
		pstmt = null;
		rs = null;
				
		CallableStatement cstmt = null;
		cstmt = conn.prepareCall("{call OT_PERMISSABLE_SLOTS(?,?,?,?,?)}");
		cstmt.setString(1, operFacilityId);
		cstmt.setString(2, operRoom);
		cstmt.setString(3, doctorCode);
		cstmt.setString(4, bookingDate);
		cstmt.registerOutParameter(5, Types.VARCHAR);
		cstmt.execute();
		strAllowable = cstmt.getString(5);
		if(strAllowable.length() > 0)
		{
			allowableSlots = Integer.parseInt(strAllowable);
			intAllowable = 0;
		}
		else
			intAllowable = 1; //Random Number 1 is to make sure Allowable Slot is null in DB and to restrict validation
		cstmt = null;

		if(intAllowable == 0)
		{
			pstmt = conn.prepareStatement(sqlForUnitTime);
			pstmt.setString(1, operFacilityId);
			rs = pstmt.executeQuery();
			while(rs.next())
				unitTime = rs.getString("unit_ot_time");
			
			String unitTimeArr[] = unitTime.split(":");
			int unitTimeMin = (Integer.parseInt(unitTimeArr[0])*60) + (Integer.parseInt(unitTimeArr[1]));
			if(totalDuration > 0)
			{
				int totQuo = totalDuration / unitTimeMin;
				int totRem = totalDuration % unitTimeMin;
				if(totRem>0){
					totQuo = totQuo+1;
				}
			
				bookedSlots = bookedSlots + totQuo;
				if(bookedSlots>allowableSlots)
					retVal = "NO";
				else
					retVal = "YES";
				}
			else
			{
				if(bookedSlots>=allowableSlots)
					retVal = "NO";
				else
					retVal = "YES";
				}
			}
		else
			retVal = "YES";

		out.println(retVal);
	}
	//43811 added by Chaitanya on 10/19/2013
	else if(func_mode.equals("chkOverBookingAvailable"))
	{
		String SqlQuery = "";
		String RoomQuery = "";
		int over_booking_count = 0;
		int over_booking_count_room = 0;
		String check_count = "N";
		String roomCode = checkForNull(request.getParameter("roomCode"));
		String strBookingDate = checkForNull(request.getParameter("strBookingDate"));
		String facility_id = checkForNull(request.getParameter("facility_id"));
		SqlQuery = " select count(*) over_book_count from OT_BOOKING_HDR a, ot_booking_dtls b, mp_patient_mast c, OT_NATURE_OF_SURGERY d, ot_oper_mast_lang_vw e, Am_practitioner_lang_vw f where b.booking_num = a.booking_num and c.patient_id = a.patient_id and e.oper_code =  b.oper_code and e.language_id = ? and a.oper_room_code = ? and d.nature_code = a.nature_code and f.language_id(+) = ? and a.TEAM_DOCTOR_CODE = f.practitioner_id(+) and to_char(a.booking_date,'dd/mm/yyyy') = ? and a.OVER_BOOKED_YN=? and BOOKING_STATUS <> '9'";
		pstmt = conn.prepareStatement(SqlQuery);
		pstmt.setString(1,locale);
		pstmt.setString(2,roomCode);
		pstmt.setString(3,locale);    
		pstmt.setString(4,strBookingDate);
		pstmt.setString(5,"Y"); 
		rs = pstmt.executeQuery();	
		if(rs!=null && rs.next())
			over_booking_count = rs.getInt("over_book_count");
		if(pstmt!=null)
			pstmt.close(); 
		if(rs!=null)
			rs.close();
		RoomQuery=" select NVL(OVER_BOOK_COUNT,0) over_book_roomcount from OT_OPER_ROOM where oper_room_code = ? and OPERATING_FACILITY_ID = ? ";
		pstmt = conn.prepareStatement(RoomQuery);	
		pstmt.setString(1,roomCode);
		pstmt.setString(2,facility_id);
		rs = pstmt.executeQuery();	
		if(rs!=null && rs.next())
			over_booking_count_room = rs.getInt("over_book_roomcount");
		if(pstmt!=null)
			pstmt.close(); 
		if(rs!=null)
			rs.close();
		if(over_booking_count < over_booking_count_room) 
			check_count = "Y";
		out.println(check_count);
	}
	//43811 added by Chaitanya on 10/19/2013
	else if(func_mode.equals("validateUserPwd")){
		String userId = checkForNull(request.getParameter("user_id"));	
		String userPwd = checkForNull(request.getParameter("user_pwd"));	
		//String sqlRoleType = OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT10");
		String sqlRoleType = "SELECT UPPER(APP_PASSWORD.DECRYPT(APPL_USER_PASSWORD)) PWD FROM SM_APPL_USER WHERE UPPER(FUNC_ROLE_ID)=UPPER(?)  AND NVL(EFF_STATUS,'E')='E'";
		String pwd = "";

		pstmt = conn.prepareStatement(sqlRoleType);
		pstmt.setString(1, userId);
		rs = pstmt.executeQuery();
					
		while(rs.next()){
			pwd = rs.getString("PWD");
		}
		String retVal = "";
		if(pwd.equals(userPwd.toUpperCase())){
			retVal = "Y";
		}
		else{
			retVal = "N";
		}
		out.println(retVal);
	}
	else if(func_mode.equals("getDurnForPendOrder")){
		String orderId = checkForNull(request.getParameter("order_id"));	
		String sqlDuration = "SELECT NVL(TO_CHAR(OPER_DURN,'hh24:mi'),(SELECT TO_CHAR(unit_ot_time, 'hh24:mi') FROM ot_param_for_facility WHERE operating_facility_id = ?)) OPRN_DURN FROM OT_PENDING_ORDERS_DTL_VW WHERE ORDER_ID = ? ORDER BY ORDER_LINE_NO";
		String dur = "";
		int totalDuration = 0;
		pstmt = conn.prepareStatement(sqlDuration);
		pstmt.setString(1, operFacilityId);
		pstmt.setString(2, orderId);
		rs = pstmt.executeQuery();
					
		while(rs.next()){
			dur = rs.getString("OPRN_DURN");
			String durArr[] = dur.split(":");
			totalDuration = totalDuration+(Integer.parseInt(durArr[0])*60)+Integer.parseInt(durArr[1]);
		}
		out.println(totalDuration);
	}
	//CRF-004 Authorize Slots for Booking - Rajesh V 
	//CRF-268 Instrument Count - Rajesh V
	else if(func_mode.equals("getQOH")){
		String instrCode = checkForNull(request.getParameter("instrument_code"));	
		String sqlOTparam = "Select CSSD_STORE_RET from ot_param_for_facility where operating_facility_id = '"+operFacilityId+"'";
		String retStore = "";
		pstmt = conn.prepareStatement(sqlOTparam);
		rs = pstmt.executeQuery();
		while(rs.next()){
			retStore = rs.getString("CSSD_STORE_RET");
		}
		pstmt = null;
		rs  = null;

		String sqlQOH = "SELECT  COUNT (*) qoh "+
						"FROM ss_tray_dtls st,mm_store_lang_vw ms,mm_store_lang_vw ms1,ss_group_lang_vw sg "+
						"WHERE st.status <> 'W' AND st.owner_store_code = ms.store_code AND NVL (curr_store_code, owner_store_code) = ms1.store_code "+
						" AND st.group_code = sg.group_code AND st.owner_store_code LIKE ('"+retStore+"') AND NVL (curr_store_code, owner_store_code) LIKE ('"+retStore+"') "+
						" AND sg.group_type LIKE ('%') AND st.group_code LIKE ('%') AND ms.language_id = ms1.language_id AND ms.language_id = sg.language_id "+
						" AND ms.language_id = ? "+
						" and st.group_code = (select ss_group_code from OT_INSTRUMENT_LANG_VW where language_id = ? and instr_code = ?) ";
		int qoh = 0;
		pstmt = conn.prepareStatement(sqlQOH);
		pstmt.setString(1, locale);
		pstmt.setString(2, locale);
		pstmt.setString(3, instrCode);
		rs = pstmt.executeQuery();
					
		while(rs.next()){
			qoh = rs.getInt("qoh");
		}
		out.println(qoh);
	}
	//CRF-268 Instrument Count - Rajesh V
	//CRF-004 Authorize Slots for Booking - Rajesh V 
	else if(func_mode.equals("populateToStatus")){
		String fromvalue = checkForNull(request.getParameter("from_value"));	
		String sqlToVal = "select status_code code,status_desc description from ot_status where status_code <> 99 and status_code > ? ";
		String statusCode = "", description = "";
		String retVal = "";
		pstmt = conn.prepareStatement(sqlToVal);
		pstmt.setString(1, fromvalue);
		rs = pstmt.executeQuery();
					
		while(rs.next()){
			statusCode = rs.getString("code");
			description = rs.getString("description");
			retVal += statusCode+":::"+description+"###";
		}
		if(retVal.length()>1){
			retVal = retVal.substring(0, retVal.length()-3);
		}
		out.println(retVal);
	}
	//CRF-004 Authorize Slots for Booking - Rajesh V 

	//Added Newly by MuthuN on 11/27/2012 CRF - 268
	/*Below func_mode is for generating the item list in OT Slate PickList Finalized*/
	else if(func_mode.equals("pick_list_slate_status"))
	{
		String facilityid = checkForNull(request.getParameter("facilityid"));		
		String patient_id = checkForNull(request.getParameter("patient_id"));
		String appt_date = checkForNull(request.getParameter("appt_date"));
		String appt_ref_num = checkForNull(request.getParameter("appt_ref_num"));
		String item_id ="";
		String sqlPickListSlate = "SELECT item_id FROM ot_pick_lists WHERE patient_id = '"+patient_id+"' and booking_num ='"+appt_ref_num+"' AND operating_facility_id = '"+facilityid+"' AND surgery_date = TO_DATE (?, 'dd/mm/yyyy') and (item_type='I' or item_type='P') and (nvl(cssd_status,'X') <>'F')";

		pstmt = conn.prepareStatement(sqlPickListSlate);
		pstmt.setString(1, appt_date);
		rs = pstmt.executeQuery();
		ArrayList arrList = new ArrayList();			
		while(rs.next()){
			item_id = rs.getString(1);
			arrList.add(item_id);
		}					
		out.println(arrList);
		}
		/*Below func_mode is for generating the item list in PickList Finalized*/
		else if(func_mode.equals("pick_list_complete_status")){
		String facilityid = checkForNull(request.getParameter("facilityid"));	
		String booking_num = checkForNull(request.getParameter("booking_num"));		
		String surgeryDate = checkForNull(request.getParameter("surgeryDate"));
		String oper_code = checkForNull(request.getParameter("oper_code"));		
		String item_id ="";
		String sqlPickListComplete = "SELECT item_id FROM ot_pick_lists WHERE booking_num = '"+booking_num+"' AND OPER_CODE = '"+oper_code+"' AND operating_facility_id = '"+facilityid+"' AND surgery_date = TO_DATE (?, 'dd/mm/yyyy') and (item_type='I' or item_type='P') and (nvl(cssd_status,'X') <>'F')";
		  
		pstmt = conn.prepareStatement(sqlPickListComplete);
		pstmt.setString(1, surgeryDate);
		rs = pstmt.executeQuery();
		ArrayList arrList = new ArrayList();			
		while(rs.next()){
			item_id = rs.getString(1);
			arrList.add(item_id);
		}					
		out.println(arrList);
		}
/* Below func_mode is for generating the quantity available - Combined with OT as well CSSD for INSTRUMENT */
		else if(func_mode.equals("pick_list_item_select")){
		String facilityid = checkForNull(request.getParameter("facilityid"));	
		//String booking_num = checkForNull(request.getParameter("booking_num"));
		String surgeryDate = checkForNull(request.getParameter("surgeryDate"));	
		String strItemId =checkForNull(request.getParameter("item_id"));
		String cssd_store_req = checkForNull(request.getParameter("cssd_store_req"));		
		String cssd_store_ret = checkForNull(request.getParameter("cssd_store_ret"));
		int strquantityAvail=0;
		int cssd_quantity=0;
		int no_of_units =0;
		//String group_type ="";
		String group_code ="";
		
		//To find the group_code in instrument for the specified Instrument Code(item_id)x
		String sql_group_code ="select SS_GROUP_CODE from ot_instrument where status ='E' and INSTR_CODE ='"+strItemId+"'"; 

		pstmt = conn.prepareStatement(sql_group_code);
		rs1 = pstmt.executeQuery();
		while(rs1!=null && rs1.next()){
			group_code=rs1.getString(1);
		}

		//To find the sum of units in picklist for the day
		String sql_no_of_units_pick = "SELECT SUM(no_of_units) FROM ot_pick_lists WHERE operating_facility_id = '"+facilityid+"' AND item_type = 'I' AND surgery_date = TO_DATE (?, 'dd/mm/yyyy') and item_id = '"+strItemId+"' and CSSD_STATUS ='F'";
		
		pstmt = conn.prepareStatement(sql_no_of_units_pick);
		pstmt.setString(1,surgeryDate);
		rs1 = pstmt.executeQuery();
		while(rs1!=null && rs1.next()){
			no_of_units=rs1.getInt(1);
		}
		//To find the count of QOH in CSSD
		String sql_qoh_cssd = "SELECT COUNT (*) qoh FROM ss_tray_dtls st, mm_store_lang_vw ms, mm_store_lang_vw ms1, ss_group_lang_vw sg WHERE st.status <> 'W' AND st.owner_store_code = ms.store_code AND NVL (curr_store_code, owner_store_code) = ms1.store_code AND st.group_code = sg.group_code AND st.owner_store_code LIKE ('"+cssd_store_ret+"') AND NVL (curr_store_code, owner_store_code) LIKE ('"+cssd_store_req+"') AND sg.group_type LIKE ('%') AND st.group_code LIKE ('"+group_code+"') AND ms.language_id = ms1.language_id AND ms.language_id = sg.language_id AND ms.language_id = ? and st.group_code = (select ss_group_code from OT_INSTRUMENT_LANG_VW where language_id = ? and instr_code = ?)";		

		pstmt = conn.prepareStatement(sql_qoh_cssd);
		pstmt.setString(1, locale);
		pstmt.setString(2, locale);
		pstmt.setString(3, strItemId);//instru_code
		rs2 = pstmt.executeQuery();
		while(rs2!=null && rs2.next()){
			cssd_quantity=rs2.getInt(1);
		}
		strquantityAvail = cssd_quantity - no_of_units;
		out.println(strquantityAvail);
		}
//Added Newly by MuthuN on 11/27/2012 CRF - 268
/* Below func_mode is for generating the quantity available - Combined with OT as well CSSD for PACKAGE */
		else if(func_mode.equals("pick_list_package_select")){
		String facilityid = checkForNull(request.getParameter("facilityid"));	
		//String booking_num = checkForNull(request.getParameter("booking_num"));
		String surgeryDate = checkForNull(request.getParameter("surgeryDate"));	
		String strPackageId =checkForNull(request.getParameter("item_id"));
		String cssd_store_req = checkForNull(request.getParameter("cssd_store_req"));
		String cssd_store_ret = checkForNull(request.getParameter("cssd_store_ret"));		
		int strquantityAvail=0;
		int cssd_quantity=0;
		int no_of_units =0;
		//String group_type ="";
		String group_code ="";
		
		//To find the group_code in instrument for the specified Instrument Code(item_id)
		String sql_group_code ="select SS_GROUP_CODE from ot_package_hdr where status ='E' and PACKAGE_CODE ='"+strPackageId+"'";
		pstmt = conn.prepareStatement(sql_group_code);
		rs1 = pstmt.executeQuery();
		while(rs1!=null && rs1.next()){
			group_code=rs1.getString(1);
		}

		//To find the sum of units in picklist for the day
		String sql_no_of_units_pick = "SELECT SUM(no_of_units) FROM ot_pick_lists WHERE operating_facility_id = '"+facilityid+"' AND item_type = 'P' AND surgery_date = TO_DATE (?, 'dd/mm/yyyy') and item_id = '"+strPackageId+"' and CSSD_STATUS ='F'";		
		pstmt = conn.prepareStatement(sql_no_of_units_pick);
		pstmt.setString(1,surgeryDate);
		rs1 = pstmt.executeQuery();
		while(rs1!=null && rs1.next()){
			no_of_units=rs1.getInt(1);
		}
		//To find the count of QOH in CSSD
		String sql_qoh_cssd = "SELECT COUNT (*) qoh FROM ss_tray_dtls st, mm_store_lang_vw ms, mm_store_lang_vw ms1, ss_group_lang_vw sg WHERE st.status <> 'W' AND st.owner_store_code = ms.store_code AND NVL (curr_store_code, owner_store_code) = ms1.store_code AND st.group_code = sg.group_code AND st.owner_store_code LIKE ('"+cssd_store_ret+"') AND NVL (curr_store_code, owner_store_code) LIKE ('"+cssd_store_req+"') AND sg.group_type LIKE ('%') AND st.group_code LIKE ('"+group_code+"') AND ms.language_id = ms1.language_id AND ms.language_id = sg.language_id AND ms.language_id = ? and st.group_code = (select ss_group_code from ot_package_hdr where PACKAGE_CODE = ?)";
		pstmt = conn.prepareStatement(sql_qoh_cssd);
		pstmt.setString(1, locale);
		pstmt.setString(2,strPackageId);//package_code
		rs2 = pstmt.executeQuery();
		while(rs2!=null && rs2.next()){
			cssd_quantity=rs2.getInt(1);
		}
		strquantityAvail = cssd_quantity - no_of_units;
		out.println(strquantityAvail);
		}/* Below Function is to find the requestID for Instrument */
		else if(func_mode.equals("pick_list_item_request_id")){
		String facilityid = checkForNull(request.getParameter("facilityid"));	
		String booking_num = checkForNull(request.getParameter("booking_num"));
		String surgeryDate = checkForNull(request.getParameter("surgeryDate"));	
		String strItemId =checkForNull(request.getParameter("item_id"));		
		String item_request_id ="";
		String sqlItem_RequestID = "SELECT cssd_request_no FROM ot_pick_lists WHERE operating_facility_id = '"+facilityid+"'   AND item_id = '"+strItemId+"'  AND item_type = 'I'   AND booking_num ='"+booking_num+"' AND surgery_date = TO_DATE (?, 'dd/mm/yyyy')";
		pstmt = conn.prepareStatement(sqlItem_RequestID);
		pstmt.setString(1, surgeryDate);
		rs = pstmt.executeQuery();
		while(rs.next()){
			item_request_id = rs.getString(1);
		}					
		out.println(item_request_id);
		}
		/* Below Function is to find the requestID for Package */
		else if(func_mode.equals("pick_list_package_request_id")){
		String facilityid = checkForNull(request.getParameter("facilityid"));	
		String booking_num = checkForNull(request.getParameter("booking_num"));
		String surgeryDate = checkForNull(request.getParameter("surgeryDate"));	
		String strPackageId =checkForNull(request.getParameter("item_id"));
		String package_request_id ="";
		String sqlPackage_RequestID = "SELECT cssd_request_no FROM ot_pick_lists WHERE operating_facility_id = '"+facilityid+"'   AND item_id = '"+strPackageId+"'  AND item_type = 'P'   AND booking_num ='"+booking_num+"' AND surgery_date = TO_DATE (?, 'dd/mm/yyyy')";
		pstmt = conn.prepareStatement(sqlPackage_RequestID);
		pstmt.setString(1, surgeryDate);
		rs = pstmt.executeQuery();
		while(rs.next()){
			package_request_id = rs.getString(1);
		}					
		out.println(package_request_id);
		}		
//Added Newly by MuthuN on 11/27/2012 CRF - 268
//Added by MuthuN against CRF - 011  on 2/7/2013
else if(func_mode.equals("diag_code_scheme")){
		String practitioner_id = checkForNull(request.getParameter("practitioner_id"));
		String diag_code_sheme ="";
		String pract_type ="";
		String sql_diag_code = "SELECT (SELECT DIAG_CODE_SCHEME FROM OT_PARAM) DIAG_CODE_SCHEME, PRACT_TYPE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?";
		pstmt = conn.prepareStatement(sql_diag_code);
		pstmt.setString(1, practitioner_id);
		rs = pstmt.executeQuery();
		while(rs.next()){
			diag_code_sheme = rs.getString(1);
			pract_type = rs.getString(2);
		}					
		out.println(diag_code_sheme+":::"+pract_type);
		}
//Added by MuthuN against CRF - 011  on 2/7/2013
//Added by MuthuN against  [IN:048375]
else if(func_mode.equals("booking_verifi_stage")){
		String stage_code ="";
		String Stage_user_id ="";
		String req_stage_code = checkForNull(request.getParameter("req_stage_code"));
		String serial_no = checkForNull(request.getParameter("serial_no"));
		String sql_verification_stage = "SELECT STAGE_CODE STAGE_CODE1,(SELECT specific_ind FROM ot_booking_fin_stages_lang_vw WHERE language_id = '"+locale+"' AND serial_no IN (SELECT serial_no FROM ot_booking_fin_stages WHERE STAGE_CODE = ?))  SPECIFIC_IND1,ACTION_IF_NOT_DONE ACTION_IF_NOT_DONE1, POST_STAGE_DESC POST_STAGE_DESC1 FROM OT_BOOKING_FIN_STAGES_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND SERIAL_NO = (SELECT MIN(SERIAL_NO)FROM OT_BOOKING_FIN_STAGES WHERE SERIAL_NO > ?) ORDER BY SERIAL_NO";
		String sql_stage = "SELECT A.STAGE_CODE, A.FACILITY_ID, A.APPL_USER_ID, B.APPL_USER_NAME FROM OT_BOOKING_FIN_STAGES_DTL A, SM_APPL_USER B WHERE A.APPL_USER_ID = B.APPL_USER_ID AND A.STAGE_CODE =? ORDER BY 1";
		pstmt = conn.prepareStatement(sql_verification_stage);
		pstmt.setString(1,req_stage_code);
		pstmt.setString(2,serial_no);
		rs = pstmt.executeQuery();
		while(rs.next()){
			stage_code = rs.getString(2);			
		}		
		if(rs != null)rs.close();	
		if(pstmt != null)pstmt.close();	
		pstmt = conn.prepareStatement(sql_stage);
		pstmt.setString(1,req_stage_code);
		rs = pstmt.executeQuery();
		while(rs.next()){
			Stage_user_id = rs.getString(3);			
		}		
		if(rs != null)rs.close();	
		if(pstmt != null)pstmt.close();	
		out.println(stage_code+"::"+Stage_user_id);
		}
//Added by MuthuN against  [IN:048375]
//Added by selvin for CRF - 0021
	else if(func_mode.equals("check_asa")){
		String asa = checkForNull(request.getParameter("asa"));			
		String asa_display ="";
		String sqlasa_code = "select PATIENT_PHYSICAL_STATUS from  MR_ASA_SCORE where asa_score_code ='"+asa+"'";
		pstmt = conn.prepareStatement(sqlasa_code);		
		rs = pstmt.executeQuery();
		while(rs.next()){
			asa_display = rs.getString(1);
		}					
		out.println(asa_display);
		}	
	else if(func_mode.equals("validateChkInDate")){
		String facility_id = checkForNull(request.getParameter("facility_id"));
		String order_id = checkForNull(request.getParameter("order_id"));
		
				String appt_date ="";
				String sql_appt_date = "SELECT TO_CHAR(APPT_DATE,'DD/MM/YYYY')appt_date FROM OT_QUEUE where order_id='"+order_id+"' AND operating_facility_id ='"+facility_id+"'";
				pstmt = conn.prepareStatement(sql_appt_date);		
				rs = pstmt.executeQuery();
				while(rs.next()){
					appt_date = checkForNull(rs.getString("appt_date"));
				}					
		out.println(appt_date);
	}
	//End for CRF - 0021
//Added newly 29-05-2013 - 091
	else if(func_mode.equals("call_item_code"))
	{
		String item_code = checkForNull(request.getParameter("item_code"));
		String st_location ="";
		String sql_item_code = "select location from ot_ss_components where item_code ='"+item_code+"'";		
		pstmt = conn.prepareStatement(sql_item_code);		
		rs = pstmt.executeQuery();
		while(rs.next()){
			st_location = checkForNull(rs.getString(1));
		}					
		out.println(st_location);
		}
	else if(func_mode.equals("call_eq_code"))
	{
		String equip_code = checkForNull(request.getParameter("equip_code"));
		String st_location ="";
		String sql_equip_code = "select location from ot_equipment where EQUIPMENT_CODE ='"+equip_code+"'";
		pstmt = conn.prepareStatement(sql_equip_code);		
		rs = pstmt.executeQuery();
		while(rs.next()){
			st_location = checkForNull(rs.getString(1));
		}					
		out.println(st_location);
		}
//Added newly 29-05-2013 -091
//186

	else if(func_mode.equals("chkPatidBookings"))
	{
		int setIndex = 0;
		String facilityId = checkForNull(request.getParameter("facilityId"));
		int chkBookingExistDays = Integer.parseInt(request.getParameter("chkBookingExistDays") == null ? "0" : request.getParameter("chkBookingExistDays"));
		String patientId = checkForNull(request.getParameter("patientId"));

		int patidBookingCount = 0;
		StringBuffer chkPatidBookingsBuffer = new StringBuffer();
				
		chkPatidBookingsBuffer.append("	SELECT COUNT (*) booking_cnt	");
		chkPatidBookingsBuffer.append("	FROM ot_booking_hdr a	");
		chkPatidBookingsBuffer.append("	WHERE patient_id = ?	");
		
		chkPatidBookingsBuffer.append("	AND operating_facility_id = ?	");
		chkPatidBookingsBuffer.append("	AND booking_start_time >= SYSDATE	");
		chkPatidBookingsBuffer.append("	AND booking_start_time <= SYSDATE + ?	");
		chkPatidBookingsBuffer.append("	AND a.booking_status != '9'	");
		chkPatidBookingsBuffer.append("	AND EXISTS (	");
		chkPatidBookingsBuffer.append("	SELECT 1 AS booking_final	");
		chkPatidBookingsBuffer.append("	FROM ot_queue b	");
		chkPatidBookingsBuffer.append("	WHERE b.appt_ref_num = a.booking_num	");
		
		//vikash added on 27-Sept-2015 starts
		chkPatidBookingsBuffer.append("	AND b.booking_stage <	");
		chkPatidBookingsBuffer.append("	(SELECT stage_code	");
		chkPatidBookingsBuffer.append("	FROM ot_booking_fin_stages	");
		chkPatidBookingsBuffer.append("	WHERE serial_no = (SELECT MAX (serial_no)	");
		chkPatidBookingsBuffer.append("	FROM ot_booking_fin_stages)))	");
		//vikash added on 27-Sept-2015 ends
	
		pstmt = conn.prepareStatement(chkPatidBookingsBuffer.toString());
		pstmt.setString(++setIndex, patientId);
		pstmt.setString(++setIndex, facilityId);
		pstmt.setInt(++setIndex, chkBookingExistDays);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			patidBookingCount = Integer.parseInt(rs.getString("booking_cnt") == null ? "0" : rs.getString("booking_cnt"));
		}					
		out.println(patidBookingCount);

	}//186
	//337 starts
	else if(func_mode.equals("BlockedSlotDetails")){
	
		String facilityId=request.getParameter("facilityId");
		locale=request.getParameter("locale");
		String Oper_Room_Code=request.getParameter("operRoomCode");
		String SelectedDate=request.getParameter("operRoomDate");
		String BlockedSlotReasons="";
		int setIndex = 0;
			
		StringBuffer BlockedSlotDetailsQuery=new StringBuffer();
		/*
		BlockedSlotDetailsQuery.append("	SELECT   TO_CHAR (from_time, 'HH24:MI') from_time1,	");
		BlockedSlotDetailsQuery.append("	TO_CHAR (to_time, 'HH24:MI') to_time1, tool_tip_msg tool_tip_msg1	");
		BlockedSlotDetailsQuery.append("	FROM ot_booking_time_slots_vw a	");
		BlockedSlotDetailsQuery.append("	WHERE operating_facility_id = ?	");
		BlockedSlotDetailsQuery.append("	AND oper_room_code = ?	");
		BlockedSlotDetailsQuery.append("	AND NVL (language_id, ?) = ?	");
		BlockedSlotDetailsQuery.append("	AND (SELECT COUNT (*) slots	");
		BlockedSlotDetailsQuery.append("	FROM ot_diary_schedule	");
		BlockedSlotDetailsQuery.append("	WHERE operating_facility_id = ?	");
		BlockedSlotDetailsQuery.append("	AND oper_room_code = ?	");
		BlockedSlotDetailsQuery.append("	AND booking_date = TO_DATE (?, 'DD/MM/YYYY')	");
		BlockedSlotDetailsQuery.append("	) > 0	");
		BlockedSlotDetailsQuery.append("	AND booking_date = TO_DATE (?, 'DD/MM/YYYY')	");
		BlockedSlotDetailsQuery.append("	AND tool_tip_msg IS NOT NULL	");
		BlockedSlotDetailsQuery.append("	and PATIENT_ID IS NULL	");
		BlockedSlotDetailsQuery.append("	ORDER BY TO_DATE (TO_CHAR (from_time, 'HH24:MI'), 'HH24:MI')	");
		
		*/
				
		BlockedSlotDetailsQuery.append("	SELECT   TO_CHAR (fr_slot_time, 'HH24:MI')||' -' from_time1,	");
		BlockedSlotDetailsQuery.append("	TO_CHAR (to_slot_time, 'HH24:MI') to_time1,	");
		BlockedSlotDetailsQuery.append("	block_reason tool_tip_msg1	");
		BlockedSlotDetailsQuery.append("	FROM ot_block_oper_room	");
		BlockedSlotDetailsQuery.append("	WHERE oper_room_code = ?	");
		BlockedSlotDetailsQuery.append("	AND operating_facility_id = ?	");
		BlockedSlotDetailsQuery.append("	AND block_date = TO_DATE (?, 'DD/MM/YYYY')	");
		BlockedSlotDetailsQuery.append("	ORDER BY block_date, fr_slot_time	");
				
		pstmt = conn.prepareStatement(BlockedSlotDetailsQuery.toString());
		
		//pstmt.setString(++setIndex, facilityId);
		pstmt.setString(++setIndex, Oper_Room_Code);
		//pstmt.setString(++setIndex, locale);
		//pstmt.setString(++setIndex, locale);
		pstmt.setString(++setIndex, facilityId);
		//pstmt.setString(++setIndex, Oper_Room_Code);
		//pstmt.setString(++setIndex, SelectedDate);
		pstmt.setString(++setIndex, SelectedDate);
		rs = pstmt.executeQuery();
		String tempString="";
	while(rs.next())
	{
		tempString="";
		tempString=rs.getString("from_time1")+"	"+rs.getString("to_time1")+"	"+rs.getString("tool_tip_msg1")+",";
		BlockedSlotReasons+=tempString;		
	}					
		out.println(BlockedSlotReasons);	
	}	
	//337 ends
	//Added Against ML-MMOH-CRF-1939-US4...starts
	else if(func_mode.equals("getFppList")){
		String SQL = "SELECT NVL (fpp_yn, 'N'), FPP_CATEGORY FROM or_order_catalog WHERE order_catalog_code=?";
		String fpp_yn="";
		String fpp_category="";
		String oper_code = checkForNull(request.getParameter("oper_code"));
		String fppList = "";
		pstmt=conn.prepareStatement(SQL);
		pstmt.setString(1,oper_code);
		rs = pstmt.executeQuery();
		while(rs.next()){
			fpp_yn = rs.getString(1);
			fpp_category = rs.getString(2);
		}
		fppList = fpp_yn+"::"+fpp_category;	
	out.println(fppList);
	}
	//Added Against ML-MMOH-CRF-1939-US4...ends
	
	//Added Against ML-MMOH-CRF-1936..starts
	else if(func_mode.equals("getNurSurYn")){
		String facility_id = checkForNull(request.getParameter("facility_id")) ;
		String SQL = "SELECT NVL (RECORD_NURSING_NOTES_YN, 'N'),NVL (RECORD_SURGEON_NOTES_YN, 'N')  FROM ot_param_for_facility WHERE OPERATING_FACILITY_ID='"+facility_id+"'";
		String record_nursing_notes_yn="";
		String record_surgeon_notes_yn="";
		String paramyn = "";
		pstmt=conn.prepareStatement(SQL);
		rs = pstmt.executeQuery();
		while(rs.next()){
			record_nursing_notes_yn = rs.getString(1);
			record_surgeon_notes_yn = rs.getString(2);
		}
		paramyn = record_nursing_notes_yn+"::"+record_surgeon_notes_yn;	
	out.println(paramyn);
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(conn != null)
		ConnectionManager.returnConnection(conn,request);
	}

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
