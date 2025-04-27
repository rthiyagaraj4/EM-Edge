package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.*;
import java.sql.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.net.*;
import java.lang.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __bladdlsurgerysubmit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLAddlSurgerySubmit.jsp", 1709114388838L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<html>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form>\n\n\n\t\n\t\t<input type=\'hidden\' name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t<input type=\'hidden\' name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" >\n\t\t<input type=\'hidden\' name=\"episode_type\" id=\"episode_type\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" >\n\t\t<input type=\'hidden\' name=\"episode_id\" id=\"episode_id\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" >\n\t\t<input type=\'hidden\' name=\"visit_id\" id=\"visit_id\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" >\n\t\t<input type=\'hidden\' name=\"str_order_cat_code\" id=\"str_order_cat_code\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" >\n\t\t<input type=\'hidden\' name=\"str_serv_panel_ind\" id=\"str_serv_panel_ind\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n\t\t<input type=\'hidden\' name=\"str_blng_serv_code\" id=\"str_blng_serv_code\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n\t\t<input type=\'hidden\' name=\"str_trx_date_time\" id=\"str_trx_date_time\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n\t\t<input type=\'hidden\' name=\"str_serv_qty\" id=\"str_serv_qty\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\n\t\t<input type=\'hidden\' name=\"charging_stage\" id=\"charging_stage\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >\n\t\t<input type=\'hidden\' name=\"str_charge_based_amt\" id=\"str_charge_based_amt\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n\t\t<input type=\'hidden\' name=\"str_pract_id\" id=\"str_pract_id\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >\n\t\t<input type=\'hidden\' name=\"str_overridden_excl_incl_ind\" id=\"str_overridden_excl_incl_ind\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n\t\t<input type=\'hidden\' name=\"strloggeduser\" id=\"strloggeduser\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" >\n\t\t<input type=\'hidden\' name=\"strclientip\" id=\"strclientip\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" >\n\t\t<input type=\'hidden\' name=\"str_dep_blng_serv_code\" id=\"str_dep_blng_serv_code\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" >\n\t\t<input type=\'hidden\' name=\"str_dep_serv_charge_eff_perc\" id=\"str_dep_serv_charge_eff_perc\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n\t\t<input type=\'hidden\' name=\"str_disc_seq_num\" id=\"str_disc_seq_num\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >\n\t\t<input type=\'hidden\' name=\"str_multi_surg_disc_eff_perc\" id=\"str_multi_surg_disc_eff_perc\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t\t<input type=\'hidden\' name=\"str_ref_sec_module_id\" id=\"str_ref_sec_module_id\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" >\n\t\t<input type=\'hidden\' name=\"str_ref_sec_key_main\" id=\"str_ref_sec_key_main\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n\t\t<input type=\'hidden\' name=\"str_ref_sec_key_line_num\" id=\"str_ref_sec_key_line_num\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >\n\t\t\n</form>\t \n\t\t\t<script>\n\t\tvar facility_id = document.forms[0].facility_id.value; \n\t\tvar patient_id = document.forms[0].patient_id.value; \n\t\tvar episode_type = document.forms[0].episode_type.value; \n\t\tvar episode_id = document.forms[0].episode_id.value; \n\t\tvar visit_id = document.forms[0].visit_id.value; \n\t\tvar str_order_cat_code = document.forms[0].str_order_cat_code.value; \n\t\tvar str_serv_panel_ind = document.forms[0].str_serv_panel_ind.value; \n\t\tvar str_blng_serv_code = document.forms[0].str_blng_serv_code.value; \n\t\tvar str_trx_date_time = document.forms[0].str_trx_date_time.value; \n\t\tvar str_serv_qty = document.forms[0].str_serv_qty.value; \n\t\tvar charging_stage = document.forms[0].charging_stage.value; \n\t\tvar str_charge_based_amt = document.forms[0].str_charge_based_amt.value; \n\t\tvar str_pract_id = document.forms[0].str_pract_id.value;\n\t\tvar str_overridden_excl_incl_ind = document.forms[0].str_overridden_excl_incl_ind.value; \n\t\tvar strloggeduser = document.forms[0].strloggeduser.value; \n\t\tvar strclientip = document.forms[0].strclientip.value; \n\t\tvar str_dep_blng_serv_code = document.forms[0].str_dep_blng_serv_code.value; \n\t\tvar str_dep_serv_charge_eff_perc = document.forms[0].str_dep_serv_charge_eff_perc.value; \n\t\tvar str_disc_seq_num = document.forms[0].str_disc_seq_num.value; \n\t\tvar str_multi_surg_disc_eff_perc = document.forms[0].str_multi_surg_disc_eff_perc.value; \t\t\n\t\tvar str_ref_sec_module_id = document.forms[0].str_ref_sec_module_id.value; \n\t\tvar str_ref_sec_key_main = document.forms[0].str_ref_sec_key_main.value; \n\t\tvar str_ref_sec_key_line_num = document.forms[0].str_ref_sec_key_line_num.value; \n\t\t\n\n\tparent.window.returnValue=\"success\";\n\tparent.window.close();\n\t</script>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n\t\t\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
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

            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs=null;ResultSet rst2=null;
	//CallableStatement call = null;
	String str_blng_serv_code="",str_order_cat_code="";
	String order_serv_cnt="";String str_serv_panel_ind="";	String str_trx_date_time="";String str_serv_qty="";
	String str_overridden_excl_incl_ind="";
	String str_dep_blng_serv_code="",str_dep_serv_charge_eff_perc="",str_mult_surg_disc_seq="",str_multi_surg_disc_eff_perc="",str_ref_sec_module_id="",str_ref_sec_key_main="",str_ref_sec_key_line_num="",str_charge_based_amt="",str_disc_seq_num="",str_pract_id="",			str_ref_oper_num="",str_ref_module_id="";

try{
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	con	=	ConnectionManager.getConnection(request);	

	String strclientip = p.getProperty("client_ip_address");
	if (strclientip==null) strclientip = "";
//	System.out.println("strclientip  dtl proc :"+strclientip);

	String locale	= (String)session.getAttribute("LOCALE");
//	System.out.println("locale  dtl proc :"+locale);

	String facility_id = (String) session.getValue("facility_id");
	if (facility_id==null) facility_id = "";
//	System.out.println("facility_id  dtl proc :"+facility_id);

	String	strloggeduser	=  (String) session.getValue("login_user");	
	if (strloggeduser==null) strloggeduser = "";
//	System.out.println("strloggeduser  dtl proc :"+strloggeduser);

	String	patient_id  = request.getParameter("patient_id");	
	if (patient_id==null) patient_id = "";
//	System.out.println("patient_id  dtl proc :"+patient_id);

	String	episode_type = request.getParameter("episode_type");	
	if (episode_type==null) episode_type = "";
//	System.out.println("episode_type  dtl proc :"+episode_type);

	String	episode_id = request.getParameter("episode_id");
	if (episode_id==null) episode_id = "";
//	System.out.println("episode_id  dtl proc :"+episode_id);

	String	visit_id = request.getParameter("visit_id");	
	if (visit_id==null) visit_id = "";
//	System.out.println("visit_id  dtl proc :"+visit_id);

	String  total_records=request.getParameter("totalRecords");	
	if (total_records==null) total_records = "";

	
	String  ord_tot_rec=request.getParameter("ord_tot_rec");	
	if (ord_tot_rec==null) ord_tot_rec = "";

//	System.out.println("ord_tot_rec submit @@"+ord_tot_rec);
	int int_ord_tot_rec=Integer.parseInt(ord_tot_rec);	
//	System.out.println("ord_tot_rec INT submit @@"+ord_tot_rec);

//	System.out.println("total_records submit @@"+total_records);
	if ( total_records == null ) total_records = "";
	int int_total_records=Integer.parseInt(total_records);	
//	System.out.println("int_total_records submit @@"+int_total_records);
	

	String bean_id = "Bl_BLAddlSurgeryReturnValuesBean" ;
	String bean_name = "eBL.BLAddlSurgeryReturnValuesBean";

	BLAddlSurgeryReturnValuesBean bean			= (BLAddlSurgeryReturnValuesBean)getBeanObject( bean_id, bean_name, request ) ;
	putObjectInBean(bean_id,bean,request);
//	beansetvalues.clearBean();			
	String currdate="",str_ws_by_ip_name="",strclientname="";;
	String blng_serv_code="", dep_blng_serv_code="", order_cat_code="", serv_panel_ind="", serv_qty="",  charging_stage="", charge_based_amt="",pract_id="", overridden_excl_incl_ind="",  dep_serv_charge_eff_perc="", mult_surg_disc_seq="", ref_sec_module_id="",ref_sec_key_main="",ref_sec_key_line_num="",multi_surg_disc_eff_perc="",disc_seq_num="",ref_module_id="",ref_oper_num="";
	serv_panel_ind="S";
	serv_qty="1";
	 try{		
		String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
		pstmt=con.prepareStatement(query_date);
		rst2 = pstmt.executeQuery();
		if (rst2!=null)
		{
		   if (rst2.next())
		   {
				 currdate = rst2.getString(1);
		   }
		}

		if (rst2 != null)   rst2.close();
		if (pstmt != null)   pstmt.close();
	

	}catch(Exception e)
	{
		System.out.println("error in date");
	}
//	System.out.println("currdate :" +currdate); 
	try
	{
	
		String sqlst1="select ws_by_ip_name from sm_facility_param_vw where facility_id = '"+facility_id+"'";
		 pstmt=con.prepareStatement(sqlst1);
		rs = pstmt.executeQuery();
		if (rs!=null)
		{
		   if (rs.next())
		   {
				 str_ws_by_ip_name = rs.getString("ws_by_ip_name");
		   }
		}

		if (rs != null)   rs.close();
		if (pstmt != null)   pstmt.close();

		if ( str_ws_by_ip_name == null ) str_ws_by_ip_name ="";		
		if (str_ws_by_ip_name.equals("I"))
		{
			strclientname = InetAddress.getByName((String) strclientip).getHostName().toUpperCase();
		}
		else
		{	
			strclientname = strclientip; 
		}		
//System.out.println("strclientname  dtl proc :"+strclientname);
	//HashMap hm_StringDtls =(HashMap) bean.getServiceString("service_string"); 
				
	//FOR DEATAILS

int int_order_serv_cnt=0;
		for(int ord=0;ord<int_ord_tot_rec;ord++)
		{
			order_serv_cnt = request.getParameter("order_serv_cnt_"+ord);
			int_order_serv_cnt = Integer.parseInt(order_serv_cnt);	
			int_order_serv_cnt=int_order_serv_cnt+1;
			for(int i=0;i<int_order_serv_cnt;i++)
			{
				String selected_row = request.getParameter("selected_row_"+ord+"_"+i);
				if(selected_row == null) selected_row="";

			if(selected_row.equals("Y")){
				order_cat_code = request.getParameter("order_cat_code"+ord+"_"+i);
				if ( order_cat_code == null )  order_cat_code = "";
				str_order_cat_code = str_order_cat_code + order_cat_code+"|";

				blng_serv_code = request.getParameter("blng_serv_code_"+ord+"_"+i);
				if ( blng_serv_code == null )  blng_serv_code = "";
				str_blng_serv_code = str_blng_serv_code + blng_serv_code+"|";

				str_serv_panel_ind=str_serv_panel_ind + serv_panel_ind +"|";
				
				str_trx_date_time = str_trx_date_time + currdate+"|";

				str_serv_qty = str_serv_qty + serv_qty+"|";

				str_charge_based_amt = str_charge_based_amt + charge_based_amt+"|";

				str_overridden_excl_incl_ind = str_overridden_excl_incl_ind + overridden_excl_incl_ind+"|";

				dep_blng_serv_code = request.getParameter("dep_blng_serv_code_"+ord+"_"+i);				
				if ( dep_blng_serv_code == null )  dep_blng_serv_code = "";
				str_dep_blng_serv_code = str_dep_blng_serv_code + dep_blng_serv_code+"|";


				dep_serv_charge_eff_perc = request.getParameter("charge_perc"+ord+"_"+i);				
				if ( dep_blng_serv_code == null )  dep_blng_serv_code = "";
				str_dep_serv_charge_eff_perc = str_dep_serv_charge_eff_perc + dep_serv_charge_eff_perc+"|";
				
				str_mult_surg_disc_seq=str_mult_surg_disc_seq+mult_surg_disc_seq+"|";

				//str_multi_surg_disc_eff_perc=str_multi_surg_disc_eff_perc+mult_surg_disc_seq+"|";

				multi_surg_disc_eff_perc = request.getParameter("multi_surg_disc_eff_perc_"+ord+"_"+i);				
				if ( multi_surg_disc_eff_perc == null )  multi_surg_disc_eff_perc = "";
				str_multi_surg_disc_eff_perc = str_multi_surg_disc_eff_perc + multi_surg_disc_eff_perc+"|";

				ref_sec_module_id = request.getParameter("sec_key_module_id_"+ord+"_"+i);				
				if ( ref_sec_module_id == null )  ref_sec_module_id = "";
				str_ref_sec_module_id = str_ref_sec_module_id + ref_sec_module_id+"|";

				ref_sec_key_main = request.getParameter("sec_key_main_"+ord+"_"+i);				
				if ( ref_sec_key_main == null )  ref_sec_key_main = "";
				str_ref_sec_key_main = str_ref_sec_key_main + ref_sec_key_main+"|";

				ref_sec_key_line_num = request.getParameter("sec_key_line_no_"+ord+"_"+i);				
				if ( ref_sec_key_line_num == null )  ref_sec_key_line_num = "";
				str_ref_sec_key_line_num = str_ref_sec_key_line_num + ref_sec_key_line_num+"|";
				

				disc_seq_num = request.getParameter("disc_seq_num_"+ord+"_"+i);				
				if ( disc_seq_num == null )  disc_seq_num = "";
				str_disc_seq_num = str_disc_seq_num + disc_seq_num+"|";
				
				pract_id = request.getParameter("pract_name_"+ord+"_"+i);				
				if ( pract_id == null )  pract_id = "";
				str_pract_id = str_pract_id + pract_id+"|";


				ref_oper_num = request.getParameter("ref_oper_num_"+ord+"_"+i);				
				if ( ref_oper_num == null )  ref_oper_num = "";
				str_ref_oper_num = str_ref_oper_num + ref_oper_num+"|";

				ref_module_id = request.getParameter("ref_module_id_"+ord+"_"+i);				
				if ( ref_oper_num == null )  ref_oper_num = "";
				str_ref_module_id = str_ref_module_id + ref_module_id+"|";

				
				}
			}
		}

		BLAddlSurgeryReturnValuesBean beansetvalues = (BLAddlSurgeryReturnValuesBean)getBeanObject(bean_id, bean_name, request);
		beansetvalues.clearBean();	
		String addl_services_yn = request.getParameter("addl_services_yn");
		if(addl_services_yn.equals("Y"))
		{
		beansetvalues.setAddSurgeryValues(facility_id,patient_id,episode_type,episode_id,visit_id,str_order_cat_code,str_serv_panel_ind,str_blng_serv_code,str_trx_date_time,str_serv_qty,charging_stage,str_charge_based_amt,str_pract_id,str_overridden_excl_incl_ind,strloggeduser,strclientip,str_dep_blng_serv_code,str_dep_serv_charge_eff_perc,str_disc_seq_num,str_multi_surg_disc_eff_perc,str_ref_sec_module_id,str_ref_sec_key_main,str_ref_sec_key_line_num,str_ref_oper_num,str_ref_module_id);
		}

		
		HashMap hm =new HashMap();
		
		BLAddlSurgeryReturnValuesBean beangetvalues = (BLAddlSurgeryReturnValuesBean)getBeanObject(bean_id, bean_name, request);
		hm=beangetvalues.getAddSurgeryValues();
		
		
		
			

	}catch(Exception e)
	{
		System.out.println("Exception main :"+ e);
	}



			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(str_order_cat_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(str_serv_panel_ind));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(str_blng_serv_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(str_trx_date_time));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(str_serv_qty));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(charging_stage));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(str_charge_based_amt));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(str_pract_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(str_overridden_excl_incl_ind));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strloggeduser));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strclientip));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(str_dep_blng_serv_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(str_dep_serv_charge_eff_perc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(str_disc_seq_num));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(str_multi_surg_disc_eff_perc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(str_ref_sec_module_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(str_ref_sec_key_main));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(str_ref_sec_key_line_num));
            _bw.write(_wl_block32Bytes, _wl_block32);


}catch(Exception e)
{
	System.out.println("Exception main :"+ e);
}
finally
	{

		if(pstmt != null)pstmt.close();
		// call.close();	
		ConnectionManager.returnConnection(con, request);
	}	

            _bw.write(_wl_block33Bytes, _wl_block33);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
