package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import java.sql.Types;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import webbeans.eCommon.ConnectionManager;
import java.net.URLDecoder;
import eCommon.Common.CommonBean;
import java.util.ArrayList;
import eOT.*;
import eOT.Common.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __surgeryhistorypreoperchklist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SurgeryHistoryPreOperChkList.jsp", 1723027298000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\t<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/SurgeryHistory.js\"></script>\n\t<!-- <script src=\"../../eCommon/js/messages.js\" language=\"javascript\"></script>\n\t<script src=\"../../eOT/js/OTMessages.js\" language=\"javascript\"></script> -->\n<script language=\"JavaScript\">\n\tfunction callVerifyCheckList(checklists){\n\t\tvar formObj = document.forms[0]; \n\t\tvar tab_id = formObj.tab_id.value;\n\t\tif(tab_id==\"pre_oper_checklist_tab\"){\n\t\t\tvar pre_or_post=\"P\";\n\t\t//Modified By DhanasekarV against IN024357 on date 18/10/2010\n\t\t//\tvar checklist_stage = \"C20\";\n\t\t\n\t\tvar checklist_stage = \"C40\";\n\t\t}\n\t\t//Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 22/02/2013\n\t\t//Start\n\t\telse if(tab_id==\"intra_oper_checklist_tab\"){\n\t\tif((formObj.role_id_3.value==\"null\")&&(formObj.no_of_verifications.value<=2))\n\t\t\t{\n\t\t\talert(getMessage(\"APP-OT0210\",\"OT\"));\n\t\t\treturn false;\n\t\t\t}\n\t\telse\n\t\t\t{\n\t\t\tvar pre_or_post=\"I\";\n\t\t\tvar checklist_stage = \"C40\";\n\t\t\t}\n\t\t}\n\t\t//End\n\t\telse{\n\t\t\tvar pre_or_post=\"O\";\n\t//Modified By DhanasekarV against on date 22/11/2010  IN025161  \n\t\tvar checklist_stage = \"C60\";\n\t\t\n\t\t}\n\t\tvar order_id = formObj.order_id.value;\n\t\tvar checklist_arr = checklists.split(\"##\");\n\t\tvar verify_checklist_codes = \"&verify_checklist_code_1=\"+checklist_arr[0];\n\t\tvar count=1;\n\t\tfor(i=1;i<checklist_arr.length;i++){\n\t\t   count++;\n\t\t   //verify_checklist_codes+=verify_checklist_codes+\"&verify_checklist_code_\"+count+\"=\"+checklist_arr[i];\n\t\t   verify_checklist_codes=verify_checklist_codes+\"&verify_checklist_code_\"+count+\"=\"+checklist_arr[i]; //Modified Against AAKH-SCF-0478\n\t\t}\n\t\tvar booking_or_oper_flag = \"B\";\n\t\tif(order_id!=null && order_id!=\"null\" && order_id!=\"\")\n\t\tbooking_or_oper_flag = \"ORD\";\n\t\tdisable_checklist_fields = \"disabled\"\n\t\taccess=\"NNNNY\";\n\t\tvar booking_num = formObj.booking_no.value;\n\t\tif(booking_num!=null && booking_num!=\"null\" && booking_num!=\"\" && booking_num!=\"NULL\"){\n\t\torder_id = \"\";\n\t\t}else if(order_id!=null && order_id!=\"null\" && order_id!=\"\" && order_id!=\"NULL\"){\n\t\t\tbooking_num = \"\";\n\t\t}\n\t\tslate_user_id = (formObj.login_user_id.value).toUpperCase();\n\t\tvar db_param_1=\"module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access=\"+access+\"&home_required_yn=N\";\n\t\t//var verifyCheckList_value=getLabel(\"eOT.VerifyCheckList.Label\",\"OT\");\n\t\tvar function_string = \"&function_id=OT_CHECK_LIST&function_name=Verify Checklist\";\n\t\tvar db_param = db_param_1 + function_string;\n\t\tvar url_desc = \"VerifyCheckListMain.jsp\";\n\t\tvar url = url_desc+\"?\"+db_param+\"&patient_id=\"+formObj.patient_id.value+\"&slate_user_id=\"+slate_user_id+verify_checklist_codes+\"&checklist_codes_count=\"+count+\"&checklist_stage=\"+checklist_stage+\"&pre_or_post=\"+pre_or_post+\"&booking_or_oper_flag=\"+booking_or_oper_flag+\"&no_of_verifications=\"+formObj.no_of_verifications.value+\"&user_id=\"+slate_user_id+\"&role_id_1=\"+formObj.role_id_1.value+\"&role_id_2=\"+formObj.role_id_2.value+\"&role_id_3=\"+formObj.role_id_3.value+\"&role_id_4=\"+formObj.role_id_4.value+\"&order_id=\"+order_id+\"&booking_num=\"+booking_num+\"&oper_num=\"+formObj.oper_num.value+\"&disable_checklist_fields=\"+disable_checklist_fields+\"&query_flag_yn=Y&called_from=\"+formObj.called_from.value;\n\t\tdocument.location.href=url;\n\t}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<Script src=\"../../eXH/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"SurgeryHistoryPreOperChkListForm\" id=\"SurgeryHistoryPreOperChkListForm\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<input type=\'hidden\' name=\"login_user_id\" id=\"login_user_id\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n<input type=\'hidden\' name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n<input type=\'hidden\' name=\"booking_no\" id=\"booking_no\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n<input type=\'hidden\' name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n<input type=\'hidden\' name=\"no_of_verifications\" id=\"no_of_verifications\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n<input type=\'hidden\' name=\"role_id_1\" id=\"role_id_1\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n<input type=\'hidden\' name=\"role_id_2\" id=\"role_id_2\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<input type=\'hidden\' name=\"role_id_3\" id=\"role_id_3\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<input type=\'hidden\' name=\"role_id_4\" id=\"role_id_4\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<input type=\'hidden\' name=\"tab_id\" id=\"tab_id\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<input type=\'hidden\' name=\"called_from\" id=\"called_from\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<input type=\'hidden\' name=\"oper_num\" id=\"oper_num\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\n </form>\n </html>\n\n \n\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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

//"java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*,webbeans.eCommon.*,java.sql.*" 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	

	String booking_num = CommonBean.checkForNull(request.getParameter("booking_num"));
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String login_user = CommonBean.checkForNull(request.getParameter("login_user"));
	String sta = CommonBean.checkForNull(request.getParameter("status"));
	int status =(sta.intern()!="")?Integer.parseInt(sta):Integer.parseInt("40");
	String speciality_code = CommonBean.checkForNull(request.getParameter("speciality_code"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String order_id = CommonBean.checkForNull(request.getParameter("order_id"));
	String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
	String tab_id = CommonBean.checkForNull(request.getParameter("parent_tab_id"));
	String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
	String verify_checklist_codes="";
	String no_of_verifications = "";	
	String role_id_1="";
	String role_id_2="";
	String role_id_3="";
	String role_id_4="";
	Connection con = null;
	CallableStatement cstmt = null;
	//Maheshwaran k added for the CRF CHL-CRF-0043 [IN:035927] as on 19/03/2013
	Statement stmt= null;
	ResultSet rset=null;
	//This Bean is used to get only the PostOperative Checklist code
	String bean_id1 = "ChkInOutRecoveryBean";
	String bean_name1 = "eOT.ChkInOutRecoveryBean";
	ChkInOutRecoveryBean bean1 = (ChkInOutRecoveryBean) mh.getBeanObject( bean_id1, request, bean_name1 );
	ArrayList verify_checklist_arr1 = new ArrayList();
	String verify_checklist_codes1="";
	//End
	try{	
		 con = ConnectionManager.getConnection(request);
		 cstmt=con.prepareCall("{call OT_OPER_CHECKLISTS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,null,null,?)}");
		 cstmt.setString(1,facility_id);
		 //Maheshwaran K added "intra_oper_checklist_tab" condition for the CHL-CRF-0043 [IN:035927] as on 27/02/2013
		 if(( tab_id.equals("pre_oper_checklist_tab") )||( tab_id.equals("intra_oper_checklist_tab") )){
			 cstmt.setString(2,"P");// V_PRE_OR_POST ="Pre" for checkin,checkoutfromward & holdingarea
		 }else
			cstmt.setString(2,"S");
		 //after documentation completed checklist is not popultated we are passing only oper_num 
		//cstmt.setString(3,order_id); after documentation completed checklist is not popultated 
		//cstmt.setString(4,booking_num);
		cstmt.setString(3,"");
		if(status<=35){
			cstmt.setString(4,booking_num);
			cstmt.setString(5,"");
		}else{
			cstmt.setString(4,"");
			cstmt.setString(5,oper_num);
		}
		 cstmt.setString(6,speciality_code);
		 cstmt.registerOutParameter(7,Types.VARCHAR); // concatenated Checklist String
		 cstmt.registerOutParameter(8,Types.VARCHAR); // V_NO_OF_VERIFICATIONS
		 cstmt.registerOutParameter(9,Types.VARCHAR); // role_1
		 cstmt.registerOutParameter(10,Types.VARCHAR); // role_2
		 cstmt.registerOutParameter(11,Types.VARCHAR); // role_3
		 cstmt.registerOutParameter(12,Types.VARCHAR); // role_4
		 cstmt.registerOutParameter(13,Types.VARCHAR); //STATUS
		 cstmt.registerOutParameter(14,Types.VARCHAR); // Error text
		 cstmt.registerOutParameter(15,Types.VARCHAR); // lANGUAGE ERROR TEXT
		 cstmt.execute();
		 verify_checklist_codes= cstmt.getString(7); 
		 no_of_verifications = cstmt.getString(8); 
		 role_id_1=cstmt.getString(9); 
		 role_id_2=cstmt.getString(10);
		 role_id_3=cstmt.getString(11);
		 role_id_4=cstmt.getString(12);
		 //Maheshwaran k added for the CRF CHL-CRF-0043 [IN:035927] as on 19/03/2013
		 //Start
		 if(tab_id.equals("intra_oper_checklist_tab"))
			{
			//Maheshwaran k added for the CRF CHL-CRF-0043 [IN:035927] as on 19/03/2013
			//Start
			verify_checklist_arr1 = bean1.getOperChecklists(booking_num,oper_num,speciality_code,order_id); 
			if(verify_checklist_arr1.size()>0){
			verify_checklist_codes1=(String)verify_checklist_arr1.get(0); 
			}
			else{
			verify_checklist_codes1="";
			}
			verify_checklist_codes=verify_checklist_codes+"##"+verify_checklist_codes1;
			//End
			}
		//End	
	}catch(Exception e){
		e.printStackTrace();
		//System.err.println("Err Msg in SurgeryHistoryPreOperChkList.jsp"+e.getMessage());
	}finally{
		try{
			if(cstmt!=null)cstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){e.printStackTrace();}
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(booking_num));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(no_of_verifications));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(role_id_1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(role_id_2));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(role_id_3));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(role_id_4));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tab_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block21Bytes, _wl_block21);
 out.println("<script>callVerifyCheckList('"+verify_checklist_codes+"')</script>"); 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
