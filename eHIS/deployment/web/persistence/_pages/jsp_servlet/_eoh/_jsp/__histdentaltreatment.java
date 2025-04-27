package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Clob;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import java.io.*;
import eOH.*;
import eCommon.Common.CommonAdapter;
import eOH.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __histdentaltreatment extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/HistDentalTreatment.jsp", 1709119332224L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}

	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8"); 
	
	String tooth_numbering_system	= "";
	String upper_arch_desc			= request.getParameter("upper_arch_desc");
	String lower_arch_desc			= request.getParameter("lower_arch_desc");
	String Q1_id					= request.getParameter("Q1_id");
	String Q2_id					= request.getParameter("Q2_id");
	String Q3_id					= request.getParameter("Q3_id");
	String Q4_id					= request.getParameter("Q4_id");
	String Q1_desc					= request.getParameter("Q1_desc");
	String Q2_desc					= request.getParameter("Q2_desc");
	String Q3_desc					= request.getParameter("Q3_desc");
	String Q4_desc					= request.getParameter("Q4_desc");
	String permanent_deciduous_flag = request.getParameter("permanent_deciduous_flag");
	String mixed_dentition_YN        = request.getParameter("mixed_dentition_YN");
	
	String patient_id = request.getParameter( "patient_id" ) ;
	String encounter_id = request.getParameter( "encounter_id" ) ;
	String facility_id = (String)session.getValue("facility_id") ;
	String login_user = (String)session.getValue("login_user") ;
	String header_tab = request.getParameter( "header_tab" ) ;
	String chart_num =CommonAdapter.checkForNull(request.getParameter("chart_num")) ;
	String chart_line_num =CommonAdapter.checkForNull(request.getParameter("chart_line_num")) ;
	String trmt_code =CommonAdapter.checkForNull(request.getParameter("trmt_code")) ;
	String other_chart_facility_id        = request.getParameter("other_chart_facility_id");
	String thrng_nos_ref        = checkForNull(request.getParameter("thrng_nos_ref"));

	String[] thrng_nos_ref_arr = null;


	//String order_id =CommonAdapter.checkForNull(request.getParameter("order_id")) ;
	//String order_line_num =CommonAdapter.checkForNull(request.getParameter("order_line_num")) ;

	//String applyTrmts =CommonAdapter.checkForNull(request.getParameter("applyTrmts")) ;
			
	String oh_bean_id 		= "OHHistoryBean";
	String oh_bean_name 	= "eOH.OHHistoryBean";
	OHHistoryBean oh_bean	= (OHHistoryBean)getBeanObject( oh_bean_id, oh_bean_name, request );

	StringBuffer applyTrmtsBuf =oh_bean.getAllImagesForHistory_2();
	String applyTrmts = applyTrmtsBuf.toString();	
	Connection con=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt_result_entry=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rs_result_entry=null;
	String sql = "";

	String tooth_num = "";
	String tooth_name ="";
	String tooth_sn = "";
	String mapped_tooth_string = "";
	String task_desc = "";
	String site_type = "";
	String site_type_desc = "";
	String surface_name = "";
	String location = "";
	String performed_date = "";
	String practitioner_name = "";
	//String treatments_outcome = "";
	String outcome_remarks = "";
	String quadrant_sno ="";
	String arch_sno = "";
	String tooth_no = "";
	String area = "";
	
	String result_text = "";

	String discr_msr_panel_id = ""; 
	String discr_msr_desc = "";
	String result_num = "";
	String result_uom_desc = "";
	String result_str = ""; 
	String area_str = ""; 

	BufferedReader bf_content_reader = null;
	Clob clob_result_text = null;

	int mapped_tooth_no = 0;
	//int i = 0;
	//int j = 1;
	int k = 1;
	int z = 0;
	int p = 0;
	int sno_table = 0;
	//added by parul on 17/03/2010 for IN020013
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	}

	StringBuilder content									=	new StringBuilder();
	/*
	//java.sql.Clob clob_notes_content						= 	null;
	//java.sql.Clob clob_dtls							=	null;
	java.io.Writer oper_details_writer						=	null;
	java.io.Reader oper_details_reader						=	null;
	java.io.BufferedWriter	oper_details_buffered_writer	=   null;
	*/
	//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
	String oh_chart_level = "";
	//

            _bw.write(_wl_block1Bytes, _wl_block1);
	
	try{
		con = ConnectionManager.getConnection(request);

		//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
		//Based on the Chart Level the paramters need to be taken.
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	
		pstmt = con.prepareStatement("SELECT CHART_LEVEL FROM OH_PARAM");
		rs = pstmt.executeQuery();
		while (rs != null && rs.next()){
			oh_chart_level = checkForNull(rs.getString("CHART_LEVEL"));
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		//added by parul on 17/03/2010 for IN020013
		pstmt=con.prepareStatement("SELECT PREF_NUMBERING_SYSTEM FROM OH_USER_PREFERENCES  WHERE APPL_USER_ID = ?");
		pstmt.setString(1,login_user);
		rs=pstmt.executeQuery();
		while(rs.next()){
			tooth_numbering_system = CommonAdapter.checkForNull(rs.getString("PREF_NUMBERING_SYSTEM"));
		}

		if (tooth_numbering_system.equals("")||tooth_numbering_system.equals("null")||tooth_numbering_system.equals(null)){
			if(oh_chart_level.equals("E")){
				pstmt=con.prepareStatement("SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM");
			}else{//End
				pstmt=con.prepareStatement("SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?");
				pstmt.setString(1,facility_id);
			}
			rs=pstmt.executeQuery();
			while(rs.next()){
				tooth_numbering_system = CommonAdapter.checkForNull(rs.getString("TOOTH_NUMBERING_SYSTEM"));
			}
		}

		content.append("<HTML><HEAD><link rel='StyleSheet' href='../../eCommon/html/"+sStyle+"' type='text/css'/>");

		content.append("<style>TABLE{BACKGROUND-COLOR:#CACEF9;}TD{BACKGROUND-COLOR:white;border-color:#999999}TD.OTHER{	BACKGROUND-COLOR:#D7E6F9;COLOR:navy;FONT-SIZE: 8pt;TEXT-ALIGN: LEFT;}TD.ARCH{BACKGROUND-COLOR:#99ddee;COLOR:navy;FONT-SIZE: 8pt; TEXT-ALIGN: LEFT;}TD.QUADRANT{BACKGROUND-COLOR:#CCECFF;COLOR:navy;FONT-SIZE: 8pt;TEXT-ALIGN: LEFT;}</style>");
		
		//content.append("<script>var imgDisplay_arch_quad = '';var imgDisplay_tooth_thrng = '';var crown_concat = ''; var concat =''; var concat_val = '';var code_desc_arr;var concat_cond_val = '';	var concat_cond_type = '';	var cond_type = '';	var rootLineDisplayParams = new Array();var root_count = 0;	var chart_num  = formObj.chart_num.value;	var patient_id = formObj.patient_id.value;var baseline_chart_yn = 'N';var status_int = 0;var j = 0;var retVal = document.forms[0].retVal.value;if(retVal.length>1){var retVal_arr = retVal.split('~');	var show_RTDESTH_EXFOLTH_image_flag=';	var show_SUPRTH_EXFOLTH_image_flag='; var image_count=0;for(i=retVal_arr.length-2;i>=0;i--){code_desc_arr = retVal_arr[i].split('##');if(code_desc_arr[4]=='RTDESTH'){ show_RTDESTH_EXFOLTH_image_flag=code_desc_arr[1]+'RTDESTH';}else if(code_desc_arr[4]=='EXFOLTH' && show_RTDESTH_EXFOLTH_image_flag!='){show_RTDESTH_EXFOLTH_image_flag=show_RTDESTH_EXFOLTH_image_flag+'EXFOLTH';}if(code_desc_arr[2] == 'TOOTH'){if(show_RTDESTH_EXFOLTH_image_flag.indexOf(code_desc_arr[1]+'RTDESTH')<0){ show_RTDESTH_EXFOLTH_image_flag=';}}if((code_desc_arr[0]!=null && code_desc_arr[0]!='null') || (code_desc_arr[4] == 'TOOTHTM' || code_desc_arr[4] == 'EXFOLTH' || code_desc_arr[4] == 'MISSTH' || code_desc_arr[4] == 'EXTRACT'  || code_desc_arr[4] == 'DECITH' || code_desc_arr[4] == 'IMPLANT' || code_desc_arr[4] == 'RTDESTH' || code_desc_arr[4] == 'SUPRTH' || code_desc_arr[4] == 'PERIINV' || code_desc_arr[4] == 'ERUPTH' || code_desc_arr[4] == 'DENTURE')){ var imageId = ';var site_type = code_desc_arr[2];if(site_type == 'QUAD'){imageId = 'Q'+code_desc_arr[1];}else if(site_type == 'ARCH'){imageId = 'A'+code_desc_arr[1];}else{imageId = code_desc_arr[1];}status_int = parseInt(code_desc_arr[6]);if(status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){ var fill_color = 'YELLOW';}else{var fill_color = 'LIGHTGREEN';}if(site_type == 'ARCH' || site_type == 'QUAD' ){if(code_desc_arr[4] == 'TOOTHTM'){if(code_desc_arr[7] != 'null'&& code_desc_arr[7] != null){ if(site_type == 'ARCH'){var imageId = 'COLORA'+code_desc_arr[1];}else if(site_type == 'QUAD'){var imageId = 'COLORQ'+code_desc_arr[1];}document.getElementById(imageId).style.backgroundColor = fill_color;}}else{var ind = concat.indexOf(':');if(ind != -1){concat_val = concat.split(':');for(;j<concat_val.length-1;j++){if(concat_val[j] == code_desc_arr[1] && site_type == code_desc_arr[2]){ image_count++;break;}else{ image_count=1;concat = concat + code_desc_arr[1] + ':'  ;imgDisplay_arch_quad = '<img src=''+code_desc_arr[0]+''  />';document.getElementById(imageId).innerHTML = imgDisplay_arch_quad;}}}else{ image_count=1;concat = code_desc_arr[1] + ':' ;imgDisplay_arch_quad = '<img src=''+code_desc_arr[0]+''  />';document.getElementById(imageId).innerHTML = imgDisplay_arch_quad;}else if(site_type == 'TOOTH' || site_type == 'THRNG' || (site_type == 'ROOT' && code_desc_arr[4]=='PERIINV')){if(code_desc_arr[4] == 'MISSTH' || code_desc_arr[4] == 'UNERTH' || code_desc_arr[4] == 'EXFOLTH' || code_desc_arr[4] == 'DECITH' || code_desc_arr[4] == 'EXTRACT' || code_desc_arr[4] == 'DECITH' || code_desc_arr[4] == 'IMPLANT' || code_desc_arr[4] == 'PARERTH' || code_desc_arr[4] == 'RTDESTH' || code_desc_arr[4] == 'SUPRTH' || code_desc_arr[4] == 'ERUPTH' || code_desc_arr[4] == 'IMPACTN' || code_desc_arr[4] == 'BRIDGE' || code_desc_arr[4] == 'DENTURE'){ imageReplaceForHistory(code_desc_arr[4],code_desc_arr[1],code_desc_arr[6],show_RTDESTH_EXFOLTH_image_flag,show_SUPRTH_EXFOLTH_image_flag,code_desc_arr[7],code_desc_arr[8]);}if(site_type == 'ROOT' && code_desc_arr[4]=='PERIINV'){drawCircleForRootHistory(code_desc_arr[1],'ALL',formObj,code_desc_arr[4],code_desc_arr[5],code_desc_arr[1],code_desc_arr[6]);else if(code_desc_arr[4] != 'MISSTH' && code_desc_arr[4] != 'EXFOLTH' && code_desc_arr[4] != 'DECITH' && code_desc_arr[4] != 'EXTRACT' && code_desc_arr[4] != 'DECITH' && code_desc_arr[4] != 'IMPLANT' && code_desc_arr[4] != 'DENTURE' && code_desc_arr[4] != 'RTDESTH' && code_desc_arr[4] != 'ERUPTH' && code_desc_arr[7] == 'N'){var ind = concat.indexOf(':');if(ind != -1){ concat_val = concat.split(':');for(;j<concat_val.length-1;j++){if(concat_val[j] == code_desc_arr[1] && site_type == code_desc_arr[2]){image_count++; status_int = parseInt(code_desc_arr[6]);if(code_desc_arr[4] == 'TOOTHTM' && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){ code_desc_arr[0] = '../../eOH/images/TRMT_Planned.gif';imgDisplay_tooth_thrng = '<img src=''+code_desc_arr[0]+''  />' + imgDisplay_tooth_thrng;if(image_count >= 4){var imgDisplay_tooth_thrng_arr = imgDisplay_tooth_thrng.split('<img');var imgDisplay_tooth_thrng_temp = ';for(k=1;k<=3;k++){imgDisplay_tooth_thrng_temp = imgDisplay_tooth_thrng_temp+'<img'+imgDisplay_tooth_thrng_arr[k];imgDisplay_tooth_thrng = imgDisplay_tooth_thrng_temp + '...'}document.getElementById(imageId).innerHTML = '<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>'+imgDisplay_tooth_thrng+'</td></tr></table>'break;else{status_int = parseInt(code_desc_arr[6]);if(code_desc_arr[4] == 'TOOTHTM' && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){code_desc_arr[0] = '../../eOH/images/TRMT_Planned.gif';}image_count=1;concat = concat + code_desc_arr[1] + ':'  ;imgDisplay_tooth_thrng = '<img src=''+code_desc_arr[0]+'' />';document.getElementById(imageId).innerHTML = '<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >'+imgDisplay_tooth_thrng+'</td></tr></table>'; 									} 								} 							} 							else{ 								image_count=1; 								concat = code_desc_arr[1] + ':' ; 								status_int = parseInt(code_desc_arr[6]);  								if(code_desc_arr[4] == 'TOOTHTM' && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){ 									code_desc_arr[0] = '../../eOH/images/TRMT_Planned.gif'; 								} 								imgDisplay_tooth_thrng = '<img src=''+code_desc_arr[0]+''  />'; 								document.getElementById(imageId).innerHTML = '<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'><tr><td width='45'>'+imgDisplay_tooth_thrng+'</td></tr></table>'; 							}	 						} 					} 					else if(site_type == 'CROWN'){ 						var ind_crown = crown_concat.indexOf(':'); 						if(ind_crown != -1){ 							concat_val = crown_concat.split(':'); 							concat_cond_val = concat_cond_type.split(':'); 							for(m=0;m<concat_val.length-1;m++){ 								if(concat_val[m] == code_desc_arr[0]){  									if(code_desc_arr[3] != ' && concat_cond_val[m] != ' && concat_cond_val[m] == 'PULPINV' && code_desc_arr[4] != 'PULPINV'){ 										cond_type = 'PULPINV'; 									} 									else{ 										cond_type = code_desc_arr[4]; 									} 									fillCrownImagesForHistory('toothLayer'+code_desc_arr[0],code_desc_arr[3],formObj,cond_type,code_desc_arr[6]); 								} 								else{ 									crown_concat = crown_concat + code_desc_arr[0] + ':'  ; 									concat_cond_type = concat_cond_type + code_desc_arr[4] + ':'  ; 									fillCrownImagesForHistory('toothLayer'+code_desc_arr[0],code_desc_arr[3],formObj,code_desc_arr[4],code_desc_arr[6]); 								} 							} 						} 						else{ 							crown_concat = code_desc_arr[0] + ':'  ; 							concat_cond_type = code_desc_arr[4] + ':'  ; 							fillCrownImagesForHistory('toothLayer'+code_desc_arr[0],code_desc_arr[3],formObj,code_desc_arr[4],code_desc_arr[6]);					 						} 					}else if(site_type == 'ROOT' && code_desc_arr[4]!='PERIINV'){ 						root_count = parseInt(root_count); 						root_count++; 						 						rootLineDisplayParams[root_count] = 'rootLayer'+code_desc_arr[1]+'##'+code_desc_arr[8]+'##'+formObj+'##'+code_desc_arr[4]+'##'+code_desc_arr[5]+'##'+code_desc_arr[1]+'##'+code_desc_arr[6]; 					} 				} 				else{ 					var site_type = code_desc_arr[2]; 					if(site_type == 'ROOT' && code_desc_arr[4]!='PERIINV'){ 						root_count = parseInt(root_count); 						root_count++; 						rootLineDisplayParams[root_count] = 'rootLayer'+code_desc_arr[1]+'##'+code_desc_arr[8]+'##'+formObj+'##'+code_desc_arr[4]+'##'+code_desc_arr[5]+'##'+code_desc_arr[1]+'##'+code_desc_arr[6]; 					} 				} 		} 		if(root_count >0){	 			for(j=1;j<=root_count;j++){				 				var params_arr = rootLineDisplayParams[j].split('##'); 				drawLineForRootImage(params_arr[0],params_arr[1],formObj,params_arr[3],params_arr[4],params_arr[5],params_arr[6]); 			}				 		}			 	}</script>");

		content.append("<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript' ></script><script language='javascript' src='../../eOH/js/HistDentalChart.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD>");

		content.append("<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'><form name='dentalChartMainForm' id='dentalChartMainForm'><input type='hidden' name='teethClickedOn' id='teethClickedOn' value=''>");

		content.append("<table width='100%' border='0' cellspacing='1' cellpadding='0' align='center' valign='top'>");
		content.append("<tr><td>");
		content.append("<table width='99%' border='0' cellspacing='1' cellpadding='0' align='left' valign='top'>");
		content.append("<tr><td class='CAGROUPHEADING'>Sno</td><td class='CAGROUPHEADING'>Index Component</td></tr>");
		content.append("<tr><td>1</td><td><a href='#header'>Header</a></td></tr>");
		content.append("<tr><td>2</td><td><a href='#chart'>Chart</a></td></tr>");
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
		pstmt=con.prepareStatement("SELECT TASK_DESC, PERFORMED_DATE,(SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG WHERE PRACTITIONER_ID=A.PRACTITIONER_ID AND LANGUAGE_ID = ?) PRACTITIONER_NAME FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS B WHERE A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID = ? AND A.CHART_NUM =? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE=? AND A.TASK_CODE = B.TASK_CODE ORDER BY CHART_NUM, CHART_LINE_NUM");
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,patient_id);
		pstmt.setString(4,chart_num);
		pstmt.setString(5,chart_line_num);
		pstmt.setString(6,trmt_code);
		rs=pstmt.executeQuery();
		sno_table = 3;
		while(rs.next()){
			task_desc = CommonAdapter.checkForNull(rs.getString("TASK_DESC"));
			content.append("<tr><td>"+sno_table+"</td><td><a href='#"+task_desc+"'>"+task_desc+"</td></tr>");
			sno_table ++;
		}
				

		content.append("</table>");
		content.append("</td></tr>");
		content.append("</table>");

		content.append("<br><br>");

		content.append("<table width='100%' border='0' cellspacing='1' cellpadding='0' align='center' valign='top'>");
		content.append("<tr><td class='CAGROUPHEADING'><a name='header'>Header</a></td></tr>");

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
		//pstmt=con.prepareStatement("SELECT A.SITE_TYPE, A.QUADRANT_SNO, A.ARCH_SNO, A.TOOTH_NO, (SELECT SITE_DESC FROM OH_SITE_TYPE WHERE SITE_TYPE = A.SITE_TYPE) SITE_TYPE_DESC, (SELECT SURFACE_NAME FROM OH_SURFACE WHERE SURFACE_CODE = A.SURFACE_CODE) SURFACE_NAME, A.LOCATION, TO_CHAR(B.PERFORMED_DATE,'DD/MM/YYYY HH24:MI') PERFORMED_DATE, DECODE(TREATMENTS_OUTCOME,'F','Failure','S','Success') TREATMENTS_OUTCOME, A.REMARKS OUTCOME_REMARKS FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_TASKS B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_LINE_NUM=B.CHART_LINE_NUM AND A.TRMT_CODE = B.TRMT_CODE AND A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID = ? AND A.CHART_NUM =? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE=? AND NVL(B.STATUS,'V') <> 'E'");
		pstmt=con.prepareStatement("SELECT A.SITE_TYPE, A.QUADRANT_SNO, A.ARCH_SNO, A.TOOTH_NO, (SELECT SITE_DESC FROM OH_SITE_TYPE WHERE SITE_TYPE = A.SITE_TYPE) SITE_TYPE_DESC, (SELECT SURFACE_NAME FROM OH_SURFACE WHERE SURFACE_CODE = A.SURFACE_CODE) SURFACE_NAME, DECODE(NVL(A.LOCATION,'X'),'X',(SELECT FACILITY_NAME FROM SM_FACILITY_PARAM WHERE FACILITY_ID = ?),A.LOCATION) LOCATION, A.REMARKS FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_TASKS B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_LINE_NUM=B.CHART_LINE_NUM AND A.TRMT_CODE = B.TRMT_CODE AND A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID = ? AND A.CHART_NUM =? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE=? AND NVL(B.STATUS,'V') <> 'E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
		pstmt.setString(1,facility_id);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,patient_id);
		pstmt.setString(4,chart_num);
		pstmt.setString(5,chart_line_num);
		pstmt.setString(6,trmt_code);

		rs=pstmt.executeQuery();
		while(rs.next()){
			site_type = CommonAdapter.checkForNull(rs.getString("SITE_TYPE"));
			site_type_desc = CommonAdapter.checkForNull(rs.getString("SITE_TYPE_DESC"));
			surface_name = CommonAdapter.checkForNull(rs.getString("SURFACE_NAME"));
			location = CommonAdapter.checkForNull(rs.getString("LOCATION"));
			outcome_remarks = CommonAdapter.checkForNull(rs.getString("REMARKS"));
			quadrant_sno = CommonAdapter.checkForNull(rs.getString("QUADRANT_SNO"));
			arch_sno = CommonAdapter.checkForNull(rs.getString("ARCH_SNO"));
			tooth_no = CommonAdapter.checkForNull(rs.getString("TOOTH_NO"));
			
			if(site_type.equals("ARCH")){
				//commented by parul on 15/03/2010 for IN020012 (ARCH_SNO was coming as 'L','U' )
				//pstmt1=con.prepareStatement("SELECT ARCH_DESC AREA FROM OH_ARCH_LANG_VW WHERE ARCH_SNO = ? AND LANGUAGE_ID =? ");
				pstmt1=con.prepareStatement("SELECT ARCH_DESC AREA FROM OH_ARCH_LANG_VW WHERE ARCH_ID = ? AND LANGUAGE_ID =? AND NUMBERING_SYSTEM = ?");
				pstmt1.setString(1,arch_sno);
				pstmt1.setString(2,locale);
				pstmt1.setString(3,tooth_numbering_system);
				rs1=pstmt1.executeQuery();
				while(rs1.next()){
					area = CommonAdapter.checkForNull(rs1.getString("AREA"));
				}
			}
			else if(site_type.equals("QUAD")){
				//pstmt1=con.prepareStatement("SELECT QUADRANT_DESC AREA FROM OH_QUADRANT_LANG_VW WHERE QUADRANT_SNO = ? AND LANGUAGE_ID =?");
				pstmt1=con.prepareStatement("SELECT QUADRANT_DESC AREA FROM OH_QUADRANT_LANG_VW WHERE QUADRANT_SNO = ? AND LANGUAGE_ID =? AND NUMBERING_SYSTEM = ?");
				pstmt1.setString(1,quadrant_sno);
				pstmt1.setString(2,locale);
				pstmt1.setString(3,tooth_numbering_system);
				rs1=pstmt1.executeQuery();
				while(rs1.next()){
					area = CommonAdapter.checkForNull(rs1.getString("AREA"));
				}
			}
			else if(site_type.equals("THRNG")){
				thrng_nos_ref_arr = thrng_nos_ref.split(",");
				pstmt1=con.prepareStatement("SELECT NS_TOOTH_NO AREA FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO =?");
				for(p=0;p<thrng_nos_ref_arr.length;p++){
					pstmt1.setString(1,tooth_numbering_system);
					pstmt1.setString(2,thrng_nos_ref_arr[p]);
					rs1=pstmt1.executeQuery();
					while(rs1.next()){
						if(area_str.equals("")){
							area_str = CommonAdapter.checkForNull(rs1.getString("AREA"));
						}
						else{
							area_str = area_str+","+CommonAdapter.checkForNull(rs1.getString("AREA"));
						}
						
					}
				}
				area = area_str;

			}
			else{
				pstmt1=con.prepareStatement("SELECT NS_TOOTH_NO AREA FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO =?");
				pstmt1.setString(1,tooth_numbering_system);
				pstmt1.setString(2,tooth_no);
				rs1=pstmt1.executeQuery();
				while(rs1.next()){
					area = CommonAdapter.checkForNull(rs1.getString("AREA"));
				}
			}
			
			
		}

		if(surface_name.equals("")){
			surface_name = "NA";
		}
		
		content.append("<tr><td>Site:"+site_type_desc+", Area:"+area+", Surface:"+surface_name+", Location:"+location+", Remarks:"+outcome_remarks+"</td></tr>");

		content.append("</table>");

		content.append("<br><br>");
		
		content.append("<table width='100%' border='0' cellspacing='1' cellpadding='0' align='center' valign='top'>");
		content.append("<tr><td class='CAGROUPHEADING'><a name='chart'>Chart</a></td></tr>");
		content.append("<tr><td>");
	

		//Chart from here
		content.append("<table width='99%' border='0' cellspacing='1' cellpadding='0' align='left' valign='top'><tr><td><table width='100%' border='1' cellspacing='0' cellpadding='0' ><tr>");
		

		content.append("<td width='33%' class='QUADRANT' style='text-align:left' nowrap ><table border=0 width='100%'><tr><td id='COLORQ"+Q1_id+"' class='QUADRANT' style='text-align:left' nowrap >"+Q1_desc+"</td><td id='Q"+Q1_id+"' class='QUADRANT' style='text-align:left' nowrap></td></tr></table></td>");

		content.append("<td width='33%' class='ARCH' style='text-align:center' nowrap ><table border=0 width='100%'><tr><td id='COLORAU' class='ARCH' style='text-align:left' nowrap >"+upper_arch_desc+"</td><td id='AU' class='ARCH' style='text-align:left' nowrap></td></tr></table></td>");

		content.append("<td width='33%' class='QUADRANT' style='text-align:left' nowrap ><table border=0 width='100%'><tr><td id='COLORQ"+Q2_id+"' class='QUADRANT' style='text-align:left' nowrap >"+Q2_desc+"</td><td id='Q"+Q2_id+"' class='QUADRANT' style='text-align:left' nowrap></td></tr></table></td>");

		content.append("</tr></table></td></tr>");
		
		
		content.append("<tr><td valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td valign='top'><table border='0' cellpadding='1' cellspacing='1'><tr>");

		content.append("<td><table border='0' cellpadding='0' cellspacing='0'><tr>");

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
			sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW  B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY MIXED_DENT_TOOTH_ORDER";
		}else{
			sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND B.PERMANENT_DECIDUOUS = ?";
		}
		pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,	ResultSet.CONCUR_UPDATABLE);
		pstmt.setString(1,locale);
		pstmt.setString(2,tooth_numbering_system);
		pstmt.setString(3,permanent_deciduous_flag);
		rs=pstmt.executeQuery();
		k=1;
		z=32;

		while(rs.next()){
			if(k<=8){
				tooth_sn = rs.getString("TOOTH_NO");
				tooth_num = rs.getString("TOOTH_NUM");
				tooth_name = rs.getString("TOOTH_NAME");
				mapped_tooth_string = rs.getString("MAPPED_TOOTH_NO");
				if(mapped_tooth_string != null){
					mapped_tooth_no = Integer.parseInt(mapped_tooth_string);
				}
				
				if(permanent_deciduous_flag.equals("P")){
					if(mixed_dentition_YN.equals("Y")){
						if(k == 1){
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
						
						}
						else if(k!=1 && k<=3){
							content.append("<td id ='decith_table"+k+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+k+ "'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td id='T"+k+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");
						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center' background-color='red'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' /></div></td></tr>");
						
							content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1'  /></div></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");
						
							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");
						}
					}
					else if(mixed_dentition_YN.equals("N")){
					/*	content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'  /></div></td></tr>");

						
						content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1'  /></div></td></tr>");

						content.append("<tr><td id='check_num"+tooth_sn+"' align='center'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");
						
						content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'  >&nbsp;</td></tr></table></td></tr></table></td>");	*/

						if(k == 1){ //Remove Images for 3rd Molars(Extreame Teeth)
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");
						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0.85' usemap='#MapRUR" + k + "'  /></div></td></tr>");
							
							content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0.85' usemap= '#MapTUR1' /></div></td></tr>");
						}

						content.append("<tr><td id='check_num"+tooth_sn+"' align='center'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");
												
						content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0.85 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
					}
				}
				else if(permanent_deciduous_flag.equals("D")){
					
					if(mixed_dentition_YN.equals("Y")){
						if(k == 1){
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
						
						}
						else if(k!=1 && k<=3){
							content.append("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
						}
						else{
							if(k==4 || k==5){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 11/08/09
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R3.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'  /></div></td></tr>");

								content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1'  /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'  >&nbsp;</td></tr></table></td></tr></table></td>");
							}
							else{
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'  /></div></td></tr>");

								content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1'  /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'  >&nbsp;</td></tr></table></td></tr></table></td>");
							}
						}
					}else if(mixed_dentition_YN.equals("N")){
						while(mapped_tooth_no != k){
							content.append("<td><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");

							k++;
							z--;
						}
						if(k==4 || k==5){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='0'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R3.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR3'/></div></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1'/></div></td></tr>");
							
							content.append("<tr><td id='check_num"+tooth_sn+"' align='center'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'>					</td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'  /></div></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1'  /></div></td></tr>");
							
							content.append("<tr><td id='check_num"+tooth_sn+"' align='center'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");
						}
					}
				}
				k++;
			}
			else{
				rs.previous();
				break;
			}
		}

		content.append("</tr></table></td></tr></table></td>");
		content.append("<td valign='top'><table border='0' cellpadding='1' cellspacing='1' ><tr><td><table border='0' cellpadding='0' cellspacing='0'><tr>");

		while(rs.next()){
			tooth_sn = rs.getString("TOOTH_NO");
			tooth_num = rs.getString("TOOTH_NUM");
			tooth_name = rs.getString("TOOTH_NAME");
			mapped_tooth_string = rs.getString("MAPPED_TOOTH_NO");
			if(mapped_tooth_string != null){
				mapped_tooth_no = Integer.parseInt(mapped_tooth_string);
			}
			if(k<=16){
				if(permanent_deciduous_flag.equals("P")){
					if(mixed_dentition_YN.equals("Y")){
						if(k == 16){
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
						
						}
						else if(k!=16 && k>=14){
							content.append("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");
						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'  /></div></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'  /></div></td></tr>");

							content.append("<tr><td id='check_num"+tooth_sn+"' align='center' >" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'  >&nbsp;</td></tr></table></td></tr></table></td>");
						}
					}
					else if(mixed_dentition_YN.equals("N")){
						/*content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'  /></div></td></tr>");

						content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'  /></div></td></tr>");
						
						content.append("<tr><td id='check_num"+tooth_sn+"' align='center' >" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

						content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'  >&nbsp;</td></tr></table></td></tr></table></td>");	*/
						if(k == 16){ //Remove Images for 3rd Molars(Extreame Teeth)
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");
						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'/></div></td></tr>");
						}
							
						content.append("<tr><td id='check_num"+tooth_sn+"' align='center' >" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");
						
						content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=1 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
					}
				}
				else if(permanent_deciduous_flag.equals("D")){
					if(mixed_dentition_YN.equals("Y")){
						if(k == 16){
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
						
						}
						else if(k!=16 && k>=14){
							content.append("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'  >&nbsp;</td></tr></table></td></tr></table></td>");
						}
						else{
							if(k==12 || k==13){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 11/08/09
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R14.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'  /></div></td></tr>");

								content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'  /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");
								
								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");
							}
							else{
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'  /></div></td></tr>");

								content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'  /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");
								
								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");
							}
						}
					}else if(mixed_dentition_YN.equals("N")){
						if(mapped_tooth_no == k){
							/*content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'  /></div></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' /></div></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");
							
							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");	   */
							if(k==12 || k==13){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R14.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR14' /></div></td></tr>");

								content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");
								
								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
							}
							else{
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");

								content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");
								
								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
							}
						}
						else{
							content.append("<td><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");

							z--;
						}
					}
				}
				k++;
			}
			else{
				break;
			}
		}

		content.append("</tr></table></td></tr></table></td>");
		content.append("</tr></table></td></tr>");
		content.append("<tr><td valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td valign='top'><table border='0' cellpadding='1' cellspacing='1'><tr><td><table border='0' cellpadding='0' cellspacing='0'><tr>");

		//LOGIC FOR DISPLAYING LOWER RIGHT QUADRANT OF DENTAL CHART
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
			sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW  B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY MIXED_DENT_TOOTH_ORDER DESC";
		}else{
			sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW  B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND B.PERMANENT_DECIDUOUS = ? ORDER BY B.TOOTH_NO DESC";
		}
		pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,	ResultSet.CONCUR_UPDATABLE);
		pstmt.setString(1,locale);
		pstmt.setString(2,tooth_numbering_system);
		pstmt.setString(3,permanent_deciduous_flag);
		rs=pstmt.executeQuery();

		k=32;

		while(rs.next()){
			tooth_sn = rs.getString("TOOTH_NO");
			tooth_num = rs.getString("TOOTH_NUM");
			tooth_name = rs.getString("TOOTH_NAME");
			mapped_tooth_string = rs.getString("MAPPED_TOOTH_NO");
			if(mapped_tooth_string != null){
				mapped_tooth_no = Integer.parseInt(mapped_tooth_string);
			}
			if(k>=25){
				if(permanent_deciduous_flag.equals("P")){
					if(mixed_dentition_YN.equals("Y")){
						if(k == 32){
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
							
						}
						else if(k!=32 && k>=30){
							content.append("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+ "'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'  >&nbsp;</td></tr></table></td></tr></table></td>");
						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'/></div></td></tr>");
						
							content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' /></div></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
						}
					}
					else if(mixed_dentition_YN.equals("N")){
						/*content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' /></div></td></tr>");
						
						content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");

						content.append("<tr><td id='check_num"+tooth_sn+"' align='center' >" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

						content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");	*/

						if(k == 32){//Remove Images for 3rd Molars(Extreame Teeth)
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");
						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' /></div></td></tr>");
							
							content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");
						}

						content.append("<tr><td id='check_num"+tooth_sn+"' align='center' >" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

						content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
					}
				}
				else if(permanent_deciduous_flag.equals("D")){
					if(mixed_dentition_YN.equals("Y")){
						
						if(k == 32){
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
							
						}
						else if(k!=32 && k>=30){
							content.append("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+ "'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");
						}
						else{
							if(k==29 || k==28){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 11/08/09
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' /></div></td></tr>");

								content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R30.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");	
							}
							else{
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' /></div></td></tr>");

								content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");	
							}
						}
					}else if(mixed_dentition_YN.equals("N")){
						while(mapped_tooth_no != k){
							content.append("<td><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");

							k--;
							z--;
						}

						/*content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' /></div></td></tr>");

						content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' /></div></td></tr>");

						content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

						content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");	*/

						if(k==29 || k==28){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'/></div></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R30.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR30' /></div></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
						}else{
							//content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'/></div></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
						}
					}
				}
				k--;
			}
			else{
				rs.previous();
				break;
			}
		}

		content.append("</tr></table></td></tr></table></td>");

		content.append("<td valign='top'><table border='0' cellpadding='1' cellspacing='1' ><tr><td><table border='0' cellpadding='0' cellspacing='0'><tr>");

		while(rs.next()){
			tooth_sn = rs.getString("TOOTH_NO");
			tooth_num = rs.getString("TOOTH_NUM");
			tooth_name = rs.getString("TOOTH_NAME");
			mapped_tooth_string = rs.getString("MAPPED_TOOTH_NO");
			if(mapped_tooth_string != null){
				mapped_tooth_no = Integer.parseInt(mapped_tooth_string);
			}
			if(k>=17){
				if(permanent_deciduous_flag.equals("P")){
					if(mixed_dentition_YN.equals("Y")){
						if(k == 17){
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
							
						}
						else if(k!=17 && k<=19){
							content.append("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+ "'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");
						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"'  border='0' /></div></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' /></div></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");
						}
					}
					else if(mixed_dentition_YN.equals("N")){
						/*content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"'  border='0' /></div></td></tr>");

						content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' /></div></td></tr>");

						content.append("<tr><td id='check_num"+tooth_sn+"' align='center' >" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

						content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>"); */

						if(k == 17){//Remove Images for 3rd Molars(Extreame Teeth)
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"'  border='0'/></div></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");
							
						}
						content.append("<tr><td id='check_num"+tooth_sn+"' align='center' >" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

						content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
					}
				}
				else if(permanent_deciduous_flag.equals("D")){
					if(mixed_dentition_YN.equals("Y")){
						if(k == 17){
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
							
						}
						else if(k!=17 && k<=19){
							content.append("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+ "'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");


							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
						}
						else{
							if(k==20 || k==21){ //Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'/></div></td></tr>");

								content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R19.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
							}
							else{
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'/></div></td></tr>");

								content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
							}
						}
					}else if(mixed_dentition_YN.equals("N")){
						if(mapped_tooth_no == k){
							/*content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'/></div></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td 							  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");*/

							if(k==20 || k==21){ //Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' /></div></td></tr>");

								content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R19.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR19' /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
							}
							else{
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'/></div></td></tr>");

								content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
							}
						}
						else{
							content.append("<td><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
						}
					}
				}
				k--;
			}
			else{
				break;
			}
		}

		content.append("</tr></table></td></tr></table></td></tr></table></td></tr>");
		
		content.append("<tr><td><table width='100%' border='1' cellspacing='0' cellpadding='0'><tr>");
	
		content.append("<td width='33%' class='QUADRANT' style='text-align:left' nowrap ><table border=0 width='100%'><tr><td id='COLORQ"+Q4_id+"' class='QUADRANT' style='text-align:left' nowrap >"+Q4_desc+"</td><td id='Q"+Q4_id+"' class='QUADRANT' style='text-align:left' nowrap></td></tr></table></td>");

		content.append("<td width='33%' class='ARCH' style='text-align:center' nowrap ><table border=0 width='100%'><tr><td id='COLORAL' class='ARCH' style='text-align:left' nowrap >"+lower_arch_desc+"</td><td id='AL' class='ARCH' style='text-align:left' nowrap></td></tr></table></td>");

		content.append("<td width='33%' class='QUADRANT' style='text-align:left' nowrap ><table border=0 width='100%'><tr><td id='COLORQ"+Q3_id+"' class='QUADRANT' style='text-align:left' nowrap >"+Q3_desc+"</td><td id='Q"+Q3_id+"' class='QUADRANT' style='text-align:left' nowrap></td></tr></table></td>");

		content.append("</tr></table></td></tr></table></td></tr></table>");

		content.append("<br><br>");

		content.append("<table width='100%' border='0' cellspacing='0' cellpadding='0' align='center' valign='top'>");
		//content.append("<tr><td class='CAGROUPHEADING' colspan='2'>Task Description</td></tr>");
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		pstmt_result_entry=con.prepareStatement("SELECT DISCR_MSR_PANEL_ID, DISCR_MSR_ID, (SELECT D.SHORT_DESC FROM AM_DISCR_MSR D WHERE D.DISCR_MSR_ID = A.DISCR_MSR_ID) DISCR_MSR_DESC, RESULT_NUM, RESULT_NUM_UOM, (SELECT U.SHORT_DESC FROM AM_UOM U WHERE U.UOM_CODE = A.RESULT_NUM_UOM) RESULT_UOM_DESC, RESULT_STR, RESULT_DATA FROM OR_RESULT_DETAIL A WHERE ORDER_ID = ? AND LINE_SRL_NO = ? ORDER BY REPORT_SRL_NO, LINE_SRL_NO, SRL_NO");
		
		pstmt=con.prepareStatement("SELECT TASK_DESC, TO_CHAR(PERFORMED_DATE,'DD/MM/YYYY HH24:MI') PERFORMED_DATE, (SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG WHERE PRACTITIONER_ID=A.PRACTITIONER_ID AND LANGUAGE_ID = ?) PRACTITIONER_NAME, A.ORDER_ID, A.ORDER_LINE_NUM FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS B WHERE A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID = ? AND A.CHART_NUM =? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE=? AND A.TASK_CODE = B.TASK_CODE ORDER BY CHART_NUM, CHART_LINE_NUM");

		String task_order_id = "";
		String task_order_line_num = "";
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,patient_id);
		pstmt.setString(4,chart_num);
		pstmt.setString(5,chart_line_num);
		pstmt.setString(6,trmt_code);
		rs=pstmt.executeQuery();
		while(rs.next()){
			task_desc = CommonAdapter.checkForNull(rs.getString("TASK_DESC"));
			
			performed_date = CommonAdapter.checkForNull(rs.getString("PERFORMED_DATE"));
			practitioner_name = CommonAdapter.checkForNull(rs.getString("PRACTITIONER_NAME"));
			task_order_id = CommonAdapter.checkForNull(rs.getString("ORDER_ID"));
			task_order_line_num = CommonAdapter.checkForNull(rs.getString("ORDER_LINE_NUM"));

			//performed_date = com.ehis.util.DateUtils.convertDate(performed_date,"DMYHM","en",locale); //Do not convert any date in history to Thai as we are building history only for English.We are not supporting multi language History

			content.append("<tr><td class='CAGROUPHEADING' colspan='2'><a name='"+task_desc+"'>Task:"+task_desc+"</a></td></tr>");
			content.append("<tr><td>Performed Date:"+performed_date+"</td><td>Performed By:"+practitioner_name+"</td></tr>");
			content.append("<tr><td colspan='2'>&nbsp;</td></tr>");

			content.append("<tr><td class='CAGROUPHEADING' colspan='2'>Result</td></tr>");
			if(rs_result_entry != null) rs_result_entry.close();

			content.append("<tr><td colspan='2'>");
			//Get tHe Result Entry data for the task
			pstmt_result_entry.setString(1,task_order_id);
			pstmt_result_entry.setString(2,task_order_line_num);

			rs_result_entry=pstmt_result_entry.executeQuery();

			while(rs_result_entry.next()){
				discr_msr_panel_id = CommonAdapter.checkForNull(rs_result_entry.getString("DISCR_MSR_PANEL_ID"));
				discr_msr_desc = CommonAdapter.checkForNull(rs_result_entry.getString("DISCR_MSR_DESC")); 
				result_num = CommonAdapter.checkForNull(rs_result_entry.getString("RESULT_NUM")); 
				result_uom_desc = CommonAdapter.checkForNull(rs_result_entry.getString("RESULT_UOM_DESC")); 
				result_str = CommonAdapter.checkForNull(rs_result_entry.getString("RESULT_STR")); 
				clob_result_text = rs_result_entry.getClob("RESULT_DATA");

				/*System.err.println("HistDentalTreatment discr_msr_panel_id:---"+discr_msr_panel_id);
				System.err.println("HistDentalTreatment discr_msr_desc:---"+discr_msr_desc);
				System.err.println("HistDentalTreatment result_num:---"+result_num);
				System.err.println("HistDentalTreatment result_uom_desc:---"+result_uom_desc);
				System.err.println("HistDentalTreatment result_str:---"+result_str);
				System.err.println("HistDentalTreatment clob_result_text:---"+clob_result_text);*/

				if(!discr_msr_panel_id.equals("")){
					if(!discr_msr_desc.equals("")){
						content.append(discr_msr_desc+":");
					}
				}

				if(!result_num.equals("")){
					content.append(result_num);
					content.append(result_uom_desc);
				}
				else if(!result_str.equals("")){
					content.append(result_str);
				}
				else{
					if(clob_result_text!=null){
						bf_content_reader = new java.io.BufferedReader(clob_result_text.getCharacterStream());
						/*char[] arr_result_text = new char[(int)clob_result_text.length()];
						bf_content_reader.read(arr_result_text,0,(int)clob_result_text.length());
						result_text = new String(arr_result_text);
						content.append(result_text);*/
						while((result_text = bf_content_reader.readLine()) != null){//Added by Sridevi Joshi on 6/16/2010 for SRR20056-SCF-4662 [IN:021978]
							//content.append(result_text+"<br>");
							content.append(result_text);
						}
						bf_content_reader.close();
					}
				}
			}
			content.append("</td></tr>");
			content.append("<tr><td colspan='2'>&nbsp;</td></tr>");
			content.append("<tr><td colspan='2'>&nbsp;</td></tr>");
		}
		content.append("</table>");
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(pstmt_result_entry != null) pstmt_result_entry.close();

		content.append("<input type='hidden' name='locale' id='locale' value="+locale+" ><input type='hidden' name='patient_id' id='patient_id' value="+patient_id+" ><input type='hidden' name='encounter_id' id='encounter_id' value="+encounter_id+" ><input type='hidden' name='facility_id' id='facility_id' value="+facility_id+" ><input type='hidden' name='chart_num' id='chart_num' value="+chart_num+" ><input type='hidden' name='header_tab' id='header_tab' value="+header_tab+" ><input type='hidden' name='mixed_dentition_YN' id='mixed_dentition_YN' value="+mixed_dentition_YN+" ><input type='hidden' name='tooth_numbering_system' id='tooth_numbering_system' value="+tooth_numbering_system+" ><input type='hidden' name='permanent_deciduous_flag' id='permanent_deciduous_flag' value="+permanent_deciduous_flag+" ><input type='hidden' name='chart_line_num' id='chart_line_num' value="+chart_line_num+" ><input type='hidden' name='applyTrmts' id='applyTrmts' value="+applyTrmts+" ><input type='hidden' name='oh_chart_level' id='oh_chart_level' value="+oh_chart_level+" ><input type='hidden' name='other_chart_facility_id' id='other_chart_facility_id' value="+other_chart_facility_id+" >");

		content.append("</form>");
		//content.append("<script>getImageForHistory();</script>");	
		content.append("<script>getStaticImageForHistory();</script>");	
		content.append("</body></html>");

/*
		String updateSql = "UPDATE OH_RESTORATIVE_CHART_DTL SET  RESULT_TEXT = EMPTY_CLOB()  WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ?";
		pstmt = con.prepareStatement(updateSql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,patient_id);
		//pstmt.setString(3,"1");
		pstmt.executeUpdate();

		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();

		String selectSql = "SELECT RESULT_TEXT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? FOR UPDATE";
		pstmt = con.prepareStatement(selectSql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,patient_id);
		//pstmt.setString(3,"1");
		rs = pstmt.executeQuery();
		
		
		if(rs.next()){
			//out.println("here");
			clob_dtls = (oracle.sql.CLOB) rs.getClob("RESULT_TEXT");
			oper_details_writer = ((oracle.sql.CLOB)clob_dtls).getCharacterOutputStream();
			oper_details_buffered_writer = new java.io.BufferedWriter(oper_details_writer);
			oper_details_buffered_writer.write(content.toString(),0,content.length());
			oper_details_buffered_writer.flush();
			oper_details_buffered_writer.close();
		}
		*/

		StringReader reader1 = new StringReader(content.toString());
		int len = content.length();
		
		String updateSql = "UPDATE OH_RESTORATIVE_CHART_DTL SET  RESULT_TEXT = ?, TRMT_COMPLETED_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND NVL(COND_CLOSED_YN,'N') = 'N'";
		pstmt = con.prepareStatement(updateSql);
		pstmt.setCharacterStream(1,reader1,len);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,patient_id);
		pstmt.setString(4,chart_num);
		pstmt.setString(5,chart_line_num);
		pstmt.executeUpdate();
		//int clob_flag = pstmt.executeUpdate();
		con.commit();
		
		
}catch ( Exception e ) {
	e.printStackTrace() ;
	System.err.println("HistDentalTreatment, Exception at 865: qrystring="+request.getQueryString());
	System.err.println("content:=="+content.toString());
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
