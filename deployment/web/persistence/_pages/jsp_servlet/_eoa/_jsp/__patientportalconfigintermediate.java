package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import webbeans.eCommon.*;
import eDS.Common.JSONObject;
import eDS.Common.JSONArray;

public final class __patientportalconfigintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/patientPortalConfigIntermediate.jsp", 1715753442202L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="          \n            \n            \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

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

	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);
	JSONObject json = new JSONObject();
try{
	String locale					= (String)session.getAttribute("LOCALE");
	String facility_id				= (String) session.getValue( "facility_id" ) ;
	String action					= request.getParameter("action")==null?"":request.getParameter("action");
	String specialityCode			= request.getParameter("specialityCode")==null?"":request.getParameter("specialityCode");
	String pratitionerListsJsonArr	= "";
	String daysOfWeekJsonArr		= "";
	String availablePratitionerListsJsonArr		= "";
	String breakTimeListJsonArr		= "";
	int srlNo;
	int breakCnt					= 0;

	if(action.equals("getPratitionerList") && !specialityCode.equals("")){




		/*Displaying availble practioner list Start*/
		pratitionerListsJsonArr				= eOA.PatientPortalBean.getPratitionerList(conn,specialityCode,locale,facility_id);	
		JSONObject pratitionerListsObj		= new JSONObject(pratitionerListsJsonArr);
		JSONArray pratitionerListArray 		= pratitionerListsObj.getJSONArray("PratitionerList");
		int rowCnt							= pratitionerListsObj.getInt("PratitionerListCnt");
		/*Displaying availble practioner list Start*/

		/*Displaying Days list Start*/
		daysOfWeekJsonArr					= eOA.PatientPortalBean.getDaysOfWeek(conn);	
		JSONObject daysOfWeekObj			= new JSONObject(daysOfWeekJsonArr);
		JSONArray daysOfWeekArray 			= daysOfWeekObj.getJSONArray("daysList");
		/*Displaying Days list End*/

		/*Displaying Stored Practioner list Start*/
		availablePratitionerListsJsonArr				= eOA.PatientPortalBean.getAvailablePratitionerList(conn,specialityCode,locale,facility_id);	
		JSONObject availablePratitionerListsObj			= new JSONObject(availablePratitionerListsJsonArr);
		JSONArray availablePratitionerListArray 		= availablePratitionerListsObj.getJSONArray("AvailablePratitionerList");
		int  availableRowCnt							= availablePratitionerListsObj.getInt("AvailablePratitionerListCnt");
		String eff_status								= availablePratitionerListsObj.getString("eff_status");

	
		if(rowCnt > 0){

			String[] arrayClinciCode = new String[pratitionerListArray.length()];
			for(int i = 0 ; i < pratitionerListArray.length() ; i++){
				arrayClinciCode[i]		= pratitionerListArray.getJSONObject(i).getString("clinic_code");
			}

			Set<String> set = new HashSet<String>();
			String clinioc_codes	= "";
			Collections.addAll(set, arrayClinciCode);
			for (String c_code : set) {
				clinioc_codes	+= "'"+c_code+"',";
			}
			clinioc_codes = clinioc_codes.substring(0, clinioc_codes.length()-1);
			breakTimeListJsonArr				= eOA.PatientPortalBean.getBreakTiming(conn,clinioc_codes,locale,facility_id);	
			JSONObject breakTimeListsObj		= new JSONObject(breakTimeListJsonArr);
			JSONArray breakTimeListtArray 		= breakTimeListsObj.getJSONArray("BreakTimeList");
			breakCnt							= breakTimeListsObj.getInt("BreakTimeCount");

			if(breakCnt > 0){

				
				json.put("breakTimeLists", breakTimeListtArray.toString());
			}else{
				json.put("breakTimeLists", "");
			}
		}
		/*Displaying Stored Practioner list End*/
		if(rowCnt > 0){
			json.put("PratitionerList", pratitionerListArray.toString());
		}else{
			json.put("PratitionerList", "");
		}

		if(availableRowCnt > 0){
			json.put("StoredPratitionerList", availablePratitionerListArray.toString());
		}else{
			json.put("StoredPratitionerList", "");
		}

		

		json.put("rowCnt", rowCnt);
		json.put("availableRowCnt", availableRowCnt);
		json.put("eff_status", eff_status);
		json.put("breakTimeListCnt", breakCnt);
		json.put("daysList", daysOfWeekArray.toString());
		json.put("error","");
		out.print(json);

	}
	
}catch(Exception e) { 
	json.put("error", e);
	//out.print(json);
	e.printStackTrace();
}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
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
