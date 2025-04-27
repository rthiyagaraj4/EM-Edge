package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.net.URLDecoder;
import eCommon.Common.CommonBean;
import java.util.ArrayList;
import eOT.*;
import eOT.Common.*;

public final class __checkintoor extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/CheckInToOR.jsp", 1709120188000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n<script type=\'text/javascript\' src=\'../../eOT/js/CheckInToOR.js\'></script>\n<script type=\'text/javascript\' src=\'../../eOT/js/OTCommon.js\'></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script language=\'javascript\'>\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<body onLoad=\"validatePatientConsent();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'CheckInToORForm\' id=\'CheckInToORForm\'>\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t<tr>\n\t\t<td class=\'CAGROUPHEADING\' colspan=\'6\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\t\n\t</tr>\n\n\t<tr>\n\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </td>\n\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t <input type=\'text\' class=\'fields\' name=\'checked_in_date\' id=\'checked_in_date\' size=\'8\'  value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' readonly>\n\t\t\t <img class=\'fields\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'checked_in_date\');\"> \n\t\t\t<input type=\'text\' class=\'fields\' name=\'checked_in_time\' id=\'checked_in_time\' size=\'5\'  maxlength=\'5\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' onBlur=\'checkTimeFormat(this)\'><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t</tr>\n\t</table>\n\n\t<input type=\'hidden\' name=\'hold_area_check_in_time\' id=\'hold_area_check_in_time\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' >\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t<input type=\'hidden\' name=\'cur_date\' id=\'cur_date\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t<input type=\'hidden\' name=\'slate_user_id\' id=\'slate_user_id\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t<input type=\'hidden\' name=\'user_id\' id=\'user_id\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t<input type=\'hidden\' name=\'booking_num\' id=\'booking_num\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t<input type=\'hidden\' name=\"no_of_verifications\" id=\"no_of_verifications\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\'hidden\' name=\"role_id_1\" id=\"role_id_1\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\'hidden\' name=\"role_id_2\" id=\"role_id_2\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<input type=\'hidden\' name=\"role_id_3\" id=\"role_id_3\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<input type=\'hidden\' name=\"role_id_4\" id=\"role_id_4\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=\'hidden\' name=\"old_checklist_user_id\" id=\"old_checklist_user_id\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\'hidden\' name=\"checklist_completed_yn\" id=\"checklist_completed_yn\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type=\'hidden\' name=\"check_for_check_list_compl\" id=\"check_for_check_list_compl\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=\'hidden\' name=\"verify_checklist_codes\" id=\"verify_checklist_codes\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t<input type=\'hidden\' name=\'check_in_time\' id=\'check_in_time\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t<input type=\'hidden\' name=\'check_out_holding_area_time\' id=\'check_out_holding_area_time\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t<input type=\"hidden\" name=\"multi_check_in_yn\" id=\"multi_check_in_yn\" id=\"multi_check_in_yn\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

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
 request.setCharacterEncoding("UTF-8");
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String bean_id = "HoldingAreaBean";
	String bean_name = "eOT.HoldingAreaBean";
	HoldingAreaBean bean = (HoldingAreaBean) mh.getBeanObject(bean_id, request, bean_name );
	//Maheshwaran k added for the CRF CHL-CRF-0043 [IN:035927] as on 19/03/2013
	//Start
	//This Bean is used to get only the PostOperative Checklist code
	String bean_id1 = "ChkInOutRecoveryBean";
	String bean_name1 = "eOT.ChkInOutRecoveryBean";
	ChkInOutRecoveryBean bean1 = (ChkInOutRecoveryBean) mh.getBeanObject( bean_id1, request, bean_name1 );
	ArrayList verify_checklist_arr1 = new ArrayList();
	String verify_checklist_codes1="";
	//End
	String check_for_check_list_compl = bean.getCheckListReqdYNFlag("05");
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String slate_user_id = CommonBean.checkForNull(request.getParameter("slate_user_id"));	
	String getSpecialityCode = CommonBean.checkForNull(request.getParameter("speciality_code")); //Added Against ARYU-SCF-0087[IN:067241]
	String hold_area_check_in_time = "",speciality_code = "",cur_date="",cur_time="",role_id_1 = "",role_id_2 = "",role_id_3 = "",role_id_4 = "",old_checklist_user_id = "",verify_checklist_codes="";
	ArrayList hold_area_list = null;	
	ArrayList date_list = bean.getSysDateTime(); // date_time, date, time
    cur_date = (String)date_list.get(1);
	cur_time = (String)date_list.get(2);

	bean.loadHoldingAreaDtls(oper_num);
	hold_area_list = bean.getHoldingAreaDtls();
    if(hold_area_list.size()>0){
		//format of time dd/mm/yyyy HH24:MI
		hold_area_check_in_time = (String) hold_area_list.get(0);
		speciality_code = (String) hold_area_list.get(5);
	}
    // Start of Verify CheckList logic
	String booking_num	= CommonBean.checkForNull(request.getParameter("booking_num"));
	String order_id		= CommonBean.checkForNull(request.getParameter("order_id"),"");

	String no_of_verifications = "1";
	ArrayList verify_checklist_arr = new ArrayList();
	ArrayList user_info_arr = new ArrayList();
	String checklist_completed_yn = "N";

	//to compare the user who already entered the data with the current user
	//Added Against ARYU-SCF-0087[IN:067241]
	if(speciality_code.equals("") && speciality_code.length()==0){
		speciality_code = getSpecialityCode;
	}
	//Added End ARYU-SCF-0087[IN:067241]
	verify_checklist_arr = bean.getOperChecklists(booking_num,oper_num,speciality_code,order_id); 
	if(verify_checklist_arr.size()>0){
			verify_checklist_codes=(String)verify_checklist_arr.get(0);
			no_of_verifications = (String)verify_checklist_arr.get(1);
			role_id_1 = (String)verify_checklist_arr.get(2);
			role_id_2 = (String)verify_checklist_arr.get(3);
			role_id_3 = (String)verify_checklist_arr.get(4);
			role_id_4 = (String)verify_checklist_arr.get(5);
	}else{
			verify_checklist_codes="";
			no_of_verifications = "";
			role_id_1 = "";
			role_id_2 = "";
			role_id_3 = "";
			role_id_4 = "";
	}
	
	user_info_arr = (ArrayList)bean.getUserInfo(booking_num,oper_num,"1",order_id);
	if(user_info_arr.size()>0){
		old_checklist_user_id	= (String)user_info_arr.get(0);
		checklist_completed_yn	= (String)user_info_arr.get(1);
	}else{
		old_checklist_user_id = "";
		checklist_completed_yn = "N";
	}
	//till here
	//Maheshwaran k added for the CRF CHL-CRF-0043 [IN:035927] as on 19/03/2013
	//Start
	verify_checklist_arr1 = bean1.getOperChecklists(booking_num,oper_num,speciality_code,order_id); 
	if(verify_checklist_arr1.size()>0){
		verify_checklist_codes1=(String)verify_checklist_arr1.get(0);
	}else{
		verify_checklist_codes1="";
	}
		
	verify_checklist_codes=verify_checklist_codes+"##"+verify_checklist_codes1;	
	System.err.println("verify_checklist_codes in CheckInToOR.jsp===>"+verify_checklist_codes);
	//Added against AAKH-SCF-0418 [IN:071802] Starts Here
	String[] arrSplit = verify_checklist_codes.split("##");
	String checklist=arrSplit[0];
	System.err.println("checklist in CheckInToOR.jsp===>"+checklist);
	for (int i=0; i < arrSplit.length; i++)
	{
		if(!checklist.equals(arrSplit[i]))
		{
			checklist=checklist+"##"+arrSplit[i];
			System.err.println("checklist++ in CheckInToOR.jsp===>"+checklist);
		}
	}
		verify_checklist_codes=checklist; 
		System.err.println("verify_checklist_codes Final in CheckInToOR.jsp===>"+verify_checklist_codes);
	//AAKH-SCF-0418 [IN:071802] Ends Here
	// End of Verify CheckList Logic
	//PMG2016-KDAH-CRF-0001 starts
	String setup_bean_id = "SetUpParamForFacilityBean";
	String setup_bean_name = "eOT.SetUpParamForFacilityBean";
	SetUpParamForFacilityBean setup_bean = (SetUpParamForFacilityBean) mh.getBeanObject( setup_bean_id, request, setup_bean_name );
	HashMap map=new HashMap();
	String tab_id="OtherDetails";
	map = setup_bean.getQueryDtls(tab_id, facility_id);
	String multi_check_in_yn=(String)map.get("multiCheckInAllowed_YN");
	//PMG2016-KDAH-CRF-0001 ends
	String check_in_time="";
	String check_out_holding_area_time="";
	Connection con = null;
	Statement pstmt2  = null;
	ResultSet rst2 = null;
	//End
	try 
	{
		con = ConnectionManager.getConnection(request);
		
		String SQL_checkin_time ="SELECT TO_CHAR(CHECK_OUT_HOLDING_AREA_TIME,'DD/MM/YYYY HH24:MI') CHECK_OUT_HOLDING_AREA_TIME,		TO_CHAR(CHECK_IN_TIME,'DD/MM/YYYY HH24:MI') CHECK_IN_TIME 	FROM OT_POST_OPER_HDR WHERE  OPERATING_FACILITY_ID='"+facility_id+"' AND  OPER_NUM='"+oper_num+"'";
		pstmt2 = con.createStatement();
		rst2=pstmt2.executeQuery(SQL_checkin_time);
		if(rst2 !=null && rst2.next())
		{			
			check_out_holding_area_time=rst2.getString("CHECK_OUT_HOLDING_AREA_TIME");
			if(check_out_holding_area_time ==null) check_out_holding_area_time="";
			check_in_time=rst2.getString("CHECK_IN_TIME");
			if(check_in_time ==null) check_in_time="";
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
			if(rst2!=null) rst2.close();
			if(pstmt2!=null)pstmt2.close();
			if(con!=null) con.close();
	}

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(cur_date));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(cur_time));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(hold_area_check_in_time));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(cur_date));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(slate_user_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slate_user_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(request.getParameter("patient_id")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(booking_num));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(no_of_verifications));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(role_id_1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(role_id_2));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(role_id_3));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(role_id_4));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(old_checklist_user_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checklist_completed_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(check_for_check_list_compl));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(verify_checklist_codes));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(check_in_time));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(check_out_holding_area_time));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(multi_check_in_yn ));
            _bw.write(_wl_block35Bytes, _wl_block35);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckIntoOR.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckedInDateTime.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }
}
