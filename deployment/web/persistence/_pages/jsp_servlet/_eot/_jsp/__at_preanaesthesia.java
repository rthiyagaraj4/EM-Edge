package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Types;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __at_preanaesthesia extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AT_PreAnaesthesia.jsp", 1735807294000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="               \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/AT_RecordAnesthesiaDetails.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script>\n\t\tfunction reset(){\n\t\t\tvar formObj=parent.parent.frames[2].document.forms[0];\n\t\t\tif(formObj.weight.disabled==false ||formObj.height.disabled==false||formObj.bsa.disabled==false||formObj.bmi.disabled==false){\n\t\t\tformObj.weight.value=\"\";\n\t\t\tformObj.height.value=\"\";\n\t\t\tformObj.bsa.value=\"\";\n\t\t\tformObj.bmi.value=\"\";\n\t\t\tformObj.status_desc.value=\"\";\n\t\t\t// Added newly for crf-0021\n\t\t\tif(parent.parent.frames[8].document.forms[0].preop_asse_done.checked==false){\n\t\t\tformObj.stages1.value=\"\";\t\n\t\t\tformObj.document.getElementById(\'asa_score_code\').innerHTML=\"\"; \n\t\t\treturn;\n\t\t\t }\n\t\t\t else {\n\t\t\t  return;\n\t\t\t }\n\t\t\t // End crf - 0021\n\t\t\tif(parent.parent.frames[5].document.forms[0].remarks_tab.value==\"Assessment\"){\n\t\t\t\tparent.parent.frames[5].frames[1].frames[1].document.forms[0].pre_morbid_desc.value=\"\";\n\t\t\t\tparent.parent.frames[5].frames[1].frames[1].document.forms[0].remarks.value=\"\";\n\t\t\t}\n\t\n\t\t\t if(parent.parent.frames[8].document.forms[0].preop_asse_done.checked==true){\n\t\t\t\t parent.parent.frames[8].document.forms[0].preop_asse_done.checked=false;\n\t\t\t }\n\t\t}\n\t\t}\n\t</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<TITLE>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</TITLE>\n <!-- \t<frameset rows=\'5%,22%,5%,12,0%,0%,12%\'>  -->\n\t\t<frameset rows=\'3%,15%,18%,6%,38%,0%,0%,10%,10%\'>\n\n\t<frame name=\"commontoolbarFrame\" frameborder=\"0\" src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" nowrap noresize scrolling=\'no\'>\n\t<frame name=\'OtPatientLineFrame\' src=\"../../eOT/jsp/OTPatLineFrame.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" frameborder=\"0\" nowrap noresize scrolling=\'no\'>\n\t<frame name=\'pre_anesth_header_frame\' src=\"../../eOT/jsp/AT_PreAnaesHeader.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" frameborder=\"0\" nowrap noresize scrolling=\'no\'>\n <frameset rows=\'0, *\'>  \n\t\t<frame name=\'pre_anesthesia_objectcollect_frame\' src=\'../../eOT/jsp/AT_PreAnaesObjectCollect.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' frameborder=\"0\"  nowrap noresize scrolling=\'no\'>\n\t\t<frame name=\'pre_anesth_header_tabs_frame\' \tsrc=\"../../eOT/jsp/AT_PreAnaesthesiaTabs.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" frameborder=\"0\" nowrap noresize scrolling=\'no\' >\n\t</frameset>\n\t<frame name=\'pre_anesth_tab_details_frame\'\t src=\'../../eOT/jsp/AT_PreAnaesTabFrames.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' frameborder=\"0\" nowrap noresize scrolling=\'yes\' > \n\t<frame name=\'dummy_frame\' src=\'../../eCommon/html/blank.html\' frameborder=\"0\" nowrap noresize scrolling=\'no\' >\n\t<frame name=\'dummy_frames\' src=\'../../eCommon/html/blank.html\' frameborder=\"0\" nowrap noresize scrolling=\'no\' >\n\t<frame name=\'doc_status_frame\' src=\"../../eOT/jsp/AT_PreAnaesDocStatus.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" frameborder=\"0\" nowrap noresize scrolling=\'auto\' >\n\t<frame name=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=\"0\" nowrap noresize scrolling=\'no\' >\n</frameset>\n</html>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );
 
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);
  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

	request.setCharacterEncoding("UTF-8");
	String source="";
	
	String title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,
	"eOT.PreAnaesthesiaForm.Label","ot_labels");
	String param=request.getQueryString();
	java.util.Properties prop = null;
	prop	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String tab_name				=request.getParameter("tab_name");
	String login_user				= prop.getProperty( "login_user" );
	String client_ip_address		= prop.getProperty( "client_ip_address" );
	String facility_id				=request.getParameter("facility_id");
	String patient_id				=request.getParameter("patient_id");
	String request_source_type		=request.getParameter("request_source_type");
	String source_id				=request.getParameter("source_id");
	String parent_source_id			=request.getParameter("parent_source_id");
	System.err.println("55,source_id======="+source_id);
	System.err.println("56,parent_source_id======="+parent_source_id);
	String anathestist_code			=request.getParameter("anathestist_code");
	String anaesthesia_srl_no1		=request.getParameter("anesthesia_srl_no");
	String source_order_id = "";
	String getOrderId="";//AAKH-SCF-0345
	String patient_class = "",encounter_id  = "",anaesthesia_srl_no="",status="",error_text="",lang_error_text="",preop_asse_done_yn="";
	if(anathestist_code==null || anathestist_code.equals("null")) anathestist_code="";
	Connection connection   = null ;
	CallableStatement cstmt= null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql_anaesthetist="SELECT ANAESTHETIST_CODE FROM  OT_PENDING_ORDER WHERE ORDER_ID=?";
	try{
		connection	= ConnectionManager.getConnection(request);		
		if(tab_name.equalsIgnoreCase("PendingOrders")) {	
				pstmt=connection.prepareStatement(sql_anaesthetist);
				System.err.println("70,sql_anaesthetist==="+sql_anaesthetist);
				pstmt.setString(1,parent_source_id);
				System.err.println("72,parent_source_id==="+parent_source_id);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					anathestist_code = rs.getString(1);
					System.err.println("76,anathestist_code==="+anathestist_code);
					if(anathestist_code ==null) anathestist_code="";
				}
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				cstmt=connection.prepareCall("{call At_Ins_Anaesthesia_Record(?,?,?,?,?,?,'OT','OT','P',?,?,?,?,?,?)}");
				cstmt.setString(1, facility_id);		 
				cstmt.setString(2, patient_id);
				cstmt.setString(3, request_source_type);
				cstmt.setString(4, parent_source_id);		
				cstmt.setString(5, source_id);
				cstmt.setString(6, anathestist_code);
				cstmt.setString(7, login_user);
				cstmt.setString(8, client_ip_address);
				cstmt.registerOutParameter( 9, Types.VARCHAR );
				cstmt.registerOutParameter( 10, Types.VARCHAR );
				cstmt.registerOutParameter( 11, Types.VARCHAR );
				cstmt.registerOutParameter( 12, Types.VARCHAR ); // for V_LANG_ERR_MSG_ID
				cstmt.execute() ;
				anaesthesia_srl_no = cstmt.getString(9);
				status = checkForNull(cstmt.getString(10));
				error_text = cstmt.getString(11);
				lang_error_text = cstmt.getString(12);		
				System.err.println("99,anaesthesia_srl_no==="+anaesthesia_srl_no+"==status=="+status+"==error_text=="+error_text+"==lang_error_text=="+lang_error_text);
				if(status.equalsIgnoreCase("E")){
					error_text = lang_error_text;
					out.println("<script>alert('"+error_text+"');</script>");
					out.println("<script>window.close();</script>");
					connection.rollback();
					return;
				}else	
				{
					connection.commit();
				}
					param=param+"&generated_anesthesia_srl_no="+anaesthesia_srl_no;
  }	

	  String sql_preop= "SELECT PREOP_ASSE_DONE_YN PREOP_ASSE_DONE_YN1,SOURCE_ORDER_ID FROM  AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID =?  AND ANAESTHESIA_SERIAL_NUM=?";
	  pstmt=connection.prepareStatement(sql_preop);
	  System.err.println("116,sql_preop==="+sql_preop);
	  pstmt.setString(1,facility_id);
	  if(anaesthesia_srl_no.equals("")){
  		pstmt.setString(2,anaesthesia_srl_no1);
		System.err.println("120,anaesthesia_srl_no1==="+anaesthesia_srl_no1);
		}
	  else{
  		pstmt.setString(2,anaesthesia_srl_no);
		System.err.println("124,anaesthesia_srl_no==="+anaesthesia_srl_no);
		}
	    rs=pstmt.executeQuery();
	    while(rs.next())
	   {
		 preop_asse_done_yn=checkForNull(rs.getString("PREOP_ASSE_DONE_YN1"));
		 source_order_id = checkForNull(rs.getString("SOURCE_ORDER_ID"));
		 System.err.println("131,preop_asse_done_yn==="+preop_asse_done_yn+"==source_order_id=="+source_order_id);
	   }

	   
  	//Get the Encounter ID and Patient Class
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

	//AAKH-SCF-0345 starts	
	//String str_query1 = "select ORDER_ID from ot_queue where PATIENT_ID = '"+patient_id+"' and rownum=1 order by added_date desc";
	
	String str_query1 = "select SOURCE_ORDER_ID from AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID = '"+facility_id+"' and SOURCE_ORDER_ID = '"+parent_source_id+"'";

	pstmt=connection.prepareStatement(str_query1);
	System.err.println("146,str_query1======="+str_query1);
	rs = pstmt.executeQuery();

	if(rs !=null && rs.next())
	{
		getOrderId= rs.getString(1);
		System.err.println("getOrderId======="+getOrderId);
	}
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close(); 
			
	if(getOrderId==null || getOrderId.equals("")){//Added Newly
		String str_update="UPDATE AT_ANAESTHESIA_RECORD_HDR SET SOURCE_ORDER_ID = '"+parent_source_id+"' WHERE OPERATING_FACILITY_ID = '"+facility_id+"' and ORDER_ID = '"+source_id+"'";
		pstmt=connection.prepareStatement(str_update);
		int result=	pstmt.executeUpdate();
		
		if(result>0)
		{
			connection.commit();
		}else{
			connection.rollback();
		}
	}//Added Newly
	//AAKH-SCF-0345 End

	String sql="SELECT PATIENT_ID, PATIENT_CLASS, ENCOUNTER_ID, EPISODE_ID, SOURCE_TYPE, SOURCE_CODE, ORD_PRACT_ID ORD_PRACT_ID1,to_char(ORD_DATE_TIME,'dd/mm/yyyy') ORD_DATE_TIME1 FROM  OR_ORDER WHERE ORDER_ID=?";

	pstmt=connection.prepareStatement(sql);
	pstmt.setString(1,source_order_id);
	rs=pstmt.executeQuery();
	while(rs.next())
	{
		patient_id=checkForNull(rs.getString("PATIENT_ID"));
		patient_class=checkForNull(rs.getString("PATIENT_CLASS"));
		encounter_id=checkForNull(rs.getString("ENCOUNTER_ID"));
	}
	  // end of retreiving encounter_ID and Patient Class
    }catch(Exception ee){
	System.err.println("Exception=="+ee);
	connection.rollback();
  }
finally{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(cstmt!=null) cstmt.close();
	if(connection!=null) ConnectionManager.returnConnection(connection,request);
}

	param=param+"&preop_asse_done_yn="+preop_asse_done_yn;
	if(preop_asse_done_yn.equals("Y")){	source="../../eCommon/jsp/commonToolbar.jsp?module_id=AT&function_type=F&menu_id=AT_JAVA_DFLT&access=NNNNY&home_required_yn=N";
	}else if(preop_asse_done_yn.equals("N") || preop_asse_done_yn.equals("")) {
	source="../../eCommon/jsp/commonToolbar.jsp?module_id=AT&function_type=F&menu_id=AT_JAVA_DFLT&access=NYNNY&home_required_yn=N";
	}
	param=param+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&source_order_id="+source_order_id;

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(title));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(param));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(param));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(param));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(param));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(param));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(param));
            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
