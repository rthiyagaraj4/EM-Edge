package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __picklistfinaldtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/PickListFinalDtl.jsp", 1709120308000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n \t<script src=\"../../eOT/js/PickList.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body onLoad=\'\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'PickListFinalDtl\' id=\'PickListFinalDtl\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</form>\n</body>\n</html>\n\n";
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)
session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


//Added by MuthuN for CRF-268 PicklistBean for CSSD Transaction 
	String pick_bean_id 			=	"OTPickListBean";
	String pick_bean_name 			=	"eOT.OTPickListBean";
	OTPickListBean picklist_bean	=	(OTPickListBean)getBeanObject( pick_bean_id, pick_bean_name, request );

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String from_val="";
	from_val=request.getParameter("from_val");
	String patient_id	= request.getParameter("patient_id");
	String mode=request.getParameter("mode");
	if(mode ==null) mode="I";
	if(from_val ==null) from_val="PI";

	String surgeryDate = CommonBean.checkForNull(request.getParameter("surgeryDate"));
	String booking_num = CommonBean.checkForNull(request.getParameter("booking_num"));
	String facilityid	= (String)session.getValue("facility_id");	
	String req_on_store_code = CommonBean.checkForNull(request.getParameter("req_on_store_code"));
	String req_by_store_code = CommonBean.checkForNull(request.getParameter("req_by_store_code"));
	String strItemId =CommonBean.checkForNull(request.getParameter("item_id"));
	String item_type =CommonBean.checkForNull(request.getParameter("item_type"));
	String noofunits = CommonBean.checkForNull(request.getParameter("noofunits"));
	String quantity_available_cssd = CommonBean.checkForNull(request.getParameter("qtyavail"));
	//Condition Below for requesting the quantity from the CSSD 
	int request_qty = (Integer.parseInt(noofunits)-Integer.parseInt(quantity_available_cssd));	
	String group_type ="";
	String req_group_code="";
	String description="";
	String available_qty="";
	String group_code ="";	
	String ot_Param="";
	
	Connection conn   = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt_count = null;
	PreparedStatement pstmt_count_pick = null;
	PreparedStatement pstmt_group = null;
	ResultSet rs = null;
	ResultSet rst_count = null;
	ResultSet  rst_count_pick = null;
	ResultSet  rst_group = null;
	ArrayList picklist_array	= null;
	try{
		conn	= ConnectionManager.getConnection(request);
		String sqlOtParam = "select NVL(cssd_interface_yn,'N') facility from ot_param_for_facility where operating_facility_id = ?";
		pstmt = conn.prepareStatement(sqlOtParam);
		pstmt.setString(1,facilityid);
		rs=pstmt.executeQuery();
		if(rs !=null && rs.next())
		{
			ot_Param=rs.getString("facility");
		}
		pstmt = null;
		rs = null;

	//To find the group_code in instrument for the specified Instrument Code(item_id) as well as Package Code 
	/* Based on the Item_type the query will execute and generate the ArrayList of HashMap values */
	if(item_type.equalsIgnoreCase("I")){
		String sql_group_code ="select SS_GROUP_CODE from ot_instrument where status ='E' and INSTR_CODE ='"+strItemId+"'";
		pstmt_group = conn.prepareStatement(sql_group_code);
		rst_group = pstmt_group.executeQuery();
		while(rst_group!=null && rst_group.next()){
			group_code=rst_group.getString(1);
		}


		/* Below Query is to get the Group Related values */
		String sql_group_pick = "SELECT  sg.group_type, st.group_code, sg.short_desc group_desc, SUM (CASE WHEN status = 'S' THEN 1 ELSE 0 END) sterlized FROM ss_tray_dtls st, mm_store_lang_vw ms, mm_store_lang_vw ms1, ss_group_lang_vw sg WHERE st.status <> 'W' AND st.owner_store_code = ms.store_code AND NVL (curr_store_code, owner_store_code) = ms1.store_code AND st.group_code = sg.group_code   AND st.owner_store_code LIKE ('"+req_on_store_code+"') AND NVL (curr_store_code, owner_store_code) LIKE ('"+req_on_store_code+"') AND sg.group_type LIKE ('%') AND st.group_code LIKE ('"+group_code+"') AND ms.language_id = ms1.language_id AND ms.language_id = sg.language_id AND ms.language_id = '"+locale+"' GROUP BY st.group_code, ms.short_desc, sg.group_type, sg.short_desc";

		pstmt_count_pick = conn.prepareStatement(sql_group_pick) ;
		rst_count_pick = pstmt_count_pick.executeQuery();
		if(picklist_bean.getPickList() != null) picklist_array=picklist_bean.getPickList();
		else picklist_array = new ArrayList();		

		while(rst_count_pick!=null && rst_count_pick.next()){
			group_type=rst_count_pick.getString(1);
			req_group_code=rst_count_pick.getString(2);
			description=rst_count_pick.getString(3);
			available_qty=rst_count_pick.getString(4);		
			
		//HashMap for passing the request to the RequestGroup Page
			HashMap hash = new HashMap(); 
			hash.put("group_type", group_type);
			hash.put("req_group_code", req_group_code);
			hash.put("auth_group_code", req_group_code);
			hash.put("request_qty", request_qty);
			hash.put("description", description);
			hash.put("auth_group_desc", description);
			hash.put("available_qty", available_qty);
			hash.put("mode", 1);
			picklist_array.add(hash);
		}
		picklist_bean.setPickList(picklist_array);
	}else if(item_type.equalsIgnoreCase("P")){
		String sql_group_code ="select SS_GROUP_CODE from ot_package_hdr where status ='E' and PACKAGE_CODE ='"+strItemId+"'";
		pstmt_group = conn.prepareStatement(sql_group_code);
		rst_group = pstmt_group.executeQuery();
		while(rst_group!=null && rst_group.next()){
			group_code=rst_group.getString(1);
		}


		/* Below Query is to get the Group Related values */
		String sql_group_pick = "SELECT  sg.group_type, st.group_code, sg.short_desc group_desc, SUM (CASE WHEN status = 'S' THEN 1 ELSE 0 END) sterlized FROM ss_tray_dtls st, mm_store_lang_vw ms, mm_store_lang_vw ms1, ss_group_lang_vw sg WHERE st.status <> 'W' AND st.owner_store_code = ms.store_code AND NVL (curr_store_code, owner_store_code) = ms1.store_code AND st.group_code = sg.group_code   AND st.owner_store_code LIKE ('"+req_on_store_code+"') AND NVL (curr_store_code, owner_store_code) LIKE ('"+req_on_store_code+"') AND sg.group_type LIKE ('%') AND st.group_code LIKE ('"+group_code+"') AND ms.language_id = ms1.language_id AND ms.language_id = sg.language_id AND ms.language_id = '"+locale+"' GROUP BY st.group_code, ms.short_desc, sg.group_type, sg.short_desc";

		pstmt_count_pick = conn.prepareStatement(sql_group_pick) ;
		rst_count_pick = pstmt_count_pick.executeQuery();
		if(picklist_bean.getPickList() != null) picklist_array=picklist_bean.getPickList();
		else picklist_array = new ArrayList();

		while(rst_count_pick!=null && rst_count_pick.next()){
			group_type=rst_count_pick.getString(1);
			req_group_code=rst_count_pick.getString(2);
			description=rst_count_pick.getString(3);
			available_qty=rst_count_pick.getString(4);		
			
		//HashMap for passing the request to the RequestGroup Page
			HashMap hash = new HashMap(); 
			hash.put("group_type", group_type);
			hash.put("req_group_code", req_group_code);
			hash.put("auth_group_code", req_group_code);
			hash.put("request_qty", request_qty);
			hash.put("description", description);
			hash.put("auth_group_desc", description);
			hash.put("available_qty", available_qty);
			hash.put("mode", 1);
			picklist_array.add(hash);
		}
		picklist_bean.setPickList(picklist_array);
	}


            _bw.write(_wl_block8Bytes, _wl_block8);

  String flag=CommonBean.checkForNull(request.getParameter("flag"));
  if(flag.length()==0)
  flag="0";
	
            _bw.write(_wl_block2Bytes, _wl_block2);

	}catch ( Exception e ) {
		System.err.println("Caught Exception error in InstrumentCountCreateSet: "+e);
		e.printStackTrace() ;
	}finally {
		try{			
			if(rs!=null) rs.close();   
			if(rst_count!=null) rst_count.close();
			if(rst_count_pick!=null) rst_count_pick.close();
			if(rst_group!=null) rst_group.close();
			if(pstmt!=null) pstmt.close();     
			if(pstmt_count!=null) pstmt_count.close();
			if(pstmt_count_pick!=null) pstmt_count_pick.close();
			if(pstmt_group!=null) pstmt_group.close();
			if(conn!=null) ConnectionManager.returnConnection(conn,request);
		}catch(Exception es){}
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
