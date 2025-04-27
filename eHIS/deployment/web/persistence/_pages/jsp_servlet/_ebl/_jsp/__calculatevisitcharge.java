package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.op.CurrencyFormat;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __calculatevisitcharge extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/CalculateVisitCharge.jsp", 1709114627523L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t\t<script>\n\t\t\tvar form=parent.frames[1].frames[1].document.forms[0];\n\t\t\tform.billing_class.value = \'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\';\n\t\t\tform.pkg_bill_doc_type.value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';\n\t\t\tform.pkg_bill_doc_num.value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n\t\t\tform.policy_type_code.value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t\t\tform.effective_date.value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\t\tform.credit_auth_ref.value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\tform.approved_days.value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\t\tform.base_qty.value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\t\t\tform.base_rate.value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\t\tform.base_charge_amt.value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\t\t/*form.gross_charge_amt.value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\n\t\t\tform.disc_amt.value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\';\n\t\t\tform.net_charge_amt.value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';*/\n\t\t\tform.gross_charge_amt.value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\';\n\t\t\tform.pat_base_qty.value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\';\n\t\t\tform.pat_base_rate.value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\';\n\t\t\tform.pat_serv_qty.value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\';\n\t\t\tform.pat_base_charge_amt.value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\';\n\t\t\tform.pat_gross_charge_amt.value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\';\n\t\t\tform.pat_disc_amt.value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\';\n\t\t\tform.pat_net_charge_amt.value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\';\n\t\t\tform.cust_base_qty.value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\';\n\t\t\tform.cust_base_rate.value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\';\n\t\t\tform.cust_serv_qty.value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\';\n\t\t\tform.cust_base_charge_amt.value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\';\n\t\t\tform.cust_gross_charge_amt.value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\';\n\t\t\tform.cust_disc_amt.value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\';\n\t\t\tform.cust_net_charge_amt.value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\';\n\t\t\tform.split_yn.value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\';\n\t\t\tform.pkg_ins_pat_ind.value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\';\n\t\t\tform.req_pkg_qty.value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\';\n\t\t\tform.req_addl_qty.value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\';\n\t\t\tform.req_std_qty.value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\';\n\t\t\tform.curr_availed.value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\';\n\t\t\tform.canadj_alert_ind.value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\';\n\t\t\tform.pkg_serv_code.value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\';\n\t\t\tform.day_type_code.value = \'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\';\n\t\t\tform.time_type_code.value = \'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\';\n\t\t\tform.disc_perc.value = \'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\';\n\t\t\tform.addl_fctr.value = \'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\';\n\t\t\t//form.visit_charge.value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\';\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
	
	Connection con			= null;
	PreparedStatement pstmt = null;
	ResultSet rs			= null;
	//ResultSet rs1			= null;
try
{
	con	=	ConnectionManager.getConnection(request);
	//con = (Connection) session.getValue("connection" );
	//String query_string=request.getQueryString();
	//out.println("query string "+query_string);
	request.setCharacterEncoding("UTF-8");
	String facilityid = (String) session.getValue("facility_id");
	if (facilityid==null) facilityid = "";

	String mode = request.getParameter("mode");
	if (mode==null) mode = "";

	String clinic_code = request.getParameter("clinic_code");
	if (clinic_code==null) clinic_code = "";
	String visit_type_code = request.getParameter("visit_type_code");
	if (visit_type_code==null) visit_type_code = "";
	String  pkg_serv_code = "";

	try
	{
		pstmt  = con.prepareStatement("select visit_chg_blng_serv_code from op_visit_type_for_clinic where clinic_code='"+clinic_code+"' and visit_type_code='"+visit_type_code+"' and facility_id = '"+facilityid+"'");
		rs = pstmt.executeQuery();
		if (rs!=null)
		{
			if (rs.next())
				pkg_serv_code= rs.getString(1);
		}	
	}
	catch(Exception e) { out.println(e.toString());}
	finally 
	{
		 if (pstmt != null) pstmt.close();
		 if (rs != null)   rs.close();
	}
	if ((pkg_serv_code==null) || (pkg_serv_code.equals("null"))) pkg_serv_code ="";	
	//out.println("pkg_serv_code "+pkg_serv_code);
	String visit_date_new = "";
	try 
	{
		pstmt  = con.prepareStatement("select to_char(sysdate, 'dd/mm/yyyy hh24:mi') from dual");
		rs = pstmt.executeQuery();
		if (rs.next())
			visit_date_new = rs.getString(1);
	}
	catch(Exception e) { out.println(e.toString());}
	finally 
	{
		 if (pstmt != null) pstmt.close();
		 if (rs != null)   rs.close();
	}

	String visit_date = request.getParameter("visit_date");
	//java.sql.Date visit_date_d=null;
	if(visit_date!=null && (!(visit_date.equals(""))))
	{
		StringTokenizer stoken = new StringTokenizer(visit_date,"/");
		String dd = stoken.nextToken();
		String mm = stoken.nextToken();
		String yyyy = stoken.nextToken();
		visit_date = yyyy+"-"+mm+"-"+dd;
	}		
	if(!(visit_date.equals("")))
	{
		//visit_date_d = java.sql.Date.valueOf(visit_date) ;
	}

	//out.println("visit date "+visit_date);
	String billing_class = request.getParameter("billing_class");
	if(billing_class==null)billing_class="";
	try
	{
		pstmt  = con.prepareStatement("select blng_class_code from op_clinic where clinic_code='"+clinic_code+"' and facility_id = '"+facilityid+"'");
		rs = pstmt.executeQuery();
		if (rs!=null)
		{
			if (rs.next())
			{
				billing_class= rs.getString(1);
			}
		}	
	}
	catch(Exception e) { out.println(e.toString());}
	finally 
	{
		 if (pstmt != null) pstmt.close();
		 if (rs != null)   rs.close();
	}
	
	//String billing_serv = "";

	String  mpi_yn = request.getParameter("mpi_yn");
	String  patient_id = request.getParameter("patient_id");
	//out.println("episode id "+request.getParameter("op_episode_id"));
	int op_episode_id = 0;
	try {
		op_episode_id = Integer.parseInt(request.getParameter("op_episode_id"));
	}
	catch(Exception e)
	{
		//out.println("episode "+request.getParameter("op_episode_id"));
	}
	String  op_episode_type = request.getParameter("op_episode_type");
	int op_episode_visit_num = 0;
	try {
		op_episode_visit_num = Integer.parseInt(request.getParameter("op_episode_visit_num"));
		}
	catch(Exception e)
	{
		//out.println("visit num"+request.getParameter("op_episode_visit_num"));
	}

	String  billing_group = request.getParameter("billing_group");
	String  trx_date = request.getParameter("trx_date");
	//java.sql.Date trx_date_d=null;
	if(trx_date!=null && (!(trx_date.equals(""))))
	{
		StringTokenizer stoken = new StringTokenizer(trx_date,"/");
		String dd = stoken.nextToken();
		String mm = stoken.nextToken();
		String yyyy = stoken.nextToken();
		trx_date = yyyy+"-"+mm+"-"+dd;
	}		
	if(!(trx_date.equals("")))
	{
		//trx_date_d = java.sql.Date.valueOf(trx_date);
	}
	
	String  cust_code = request.getParameter("cust_code");
	String  non_ins_blng_grp = request.getParameter("non_ins_blng_grp");
	//out.println("non_ins_blng_grp "+non_ins_blng_grp); 
	String  non_ins_cust_code = request.getParameter("non_ins_cust_code");
	String  pkg_bill_doc_type = request.getParameter("pkg_bill_doc_type");// In Out 
	//out.println("pkg bill "+request.getParameter("pkg_bill_doc_num"));
	int pkg_bill_doc_num = 0;
	try
	{
		pkg_bill_doc_num = Integer.parseInt(request.getParameter("pkg_bill_doc_num"));//In Out 
	}
	catch(Exception e)
	{
		//out.println("pkg_bill_doc_num "+request.getParameter("pkg_bill_doc_num"));
	}
	
	String  policy_type_code = request.getParameter("policy_type_code");// In Out 

	String  policy_expiry_date= request.getParameter("policy_expiry_date");
	java.sql.Date policy_expiry_date_d=null;
	if(policy_expiry_date!=null && (!(policy_expiry_date.equals(""))))
	{
		StringTokenizer stoken = new StringTokenizer(policy_expiry_date,"/");
		String dd = stoken.nextToken();
		String mm = stoken.nextToken();
		String yyyy = stoken.nextToken();
		policy_expiry_date = yyyy+"-"+mm+"-"+dd;
	}		
	if(!(policy_expiry_date.equals("")))
	{
		policy_expiry_date_d = java.sql.Date.valueOf(policy_expiry_date) ;
	}


	//out.println("policy_expiry_date "+policy_expiry_date);

	String  mesg_reqd = request.getParameter("mesg_reqd");
	String  effective_date = request.getParameter("effective_date");  // In Out 
	String  credit_auth_ref = request.getParameter("credit_auth_ref"); // In Out 
	float approved_days = 0;	
	try {
		approved_days = Float.parseFloat(request.getParameter("approved_days")); // In Out 
	}
	catch(Exception e)
	{
		out.println("approved_days "+request.getParameter("approved_days"));
	}
	//String  pkg_bill_type = request.getParameter("pkg_bill_doc_type");
	float serv_qty = 0;
	try {
		serv_qty = Float.parseFloat(request.getParameter("serv_qty"));
	}
	catch(Exception e)
	{
		out.println("serv_qty"+request.getParameter("serv_qty"));
	}
	//float addl_factor = 0;
	String s_addl_fctr = "";
	try {
		s_addl_fctr = request.getParameter("addl_factor");
		if ((s_addl_fctr==null) || (s_addl_fctr.equals(""))) s_addl_fctr = "0";
		//addl_factor = Float.parseFloat(s_addl_fctr);
		
	}
	catch(Exception e)
	{
		out.println("addl_factor "+request.getParameter("addl_factor "));
	}
	float pkg_price = 0;
	try {
		pkg_price = Float.parseFloat(request.getParameter("pkg_price"));
	}
	catch(Exception e)
	{
		out.println("pkg_price"+request.getParameter("pkg_price"));
	}
	float pkg_value = 0;
	try {
		pkg_value = Float.parseFloat(request.getParameter("pkg_value"));
	}
	catch(Exception e)
	{
		out.println("pkg_value"+request.getParameter("pkg_value"));
	}
	String  policy_type = request.getParameter("policy_type_code");
	float base_qty = 0;
	try {
		base_qty = Float.parseFloat(request.getParameter("base_qty")); // In Out 
	}
	catch(Exception e)
	{
		out.println("base_qty"+request.getParameter("base_qty"));
	}
	float base_rate = 0;
	try {
		base_rate = Float.parseFloat(request.getParameter("base_rate"));
	}
	catch(Exception e)
	{
		out.println("base_rate"+request.getParameter("base_rate"));
	}
	float base_charge_amt = 0;
	try {	
		base_charge_amt = Float.parseFloat(request.getParameter("base_charge_amt"));
	}
	catch(Exception e)
	{
		out.println("base_charge_amt"+request.getParameter("base_charge_amt"));
	}
	float gross_charge_amt = 0;
	try {
		gross_charge_amt = Float.parseFloat(request.getParameter("gross_charge_amt"));
	}
	catch(Exception e)
	{
		out.println("gross_charge_amt"+request.getParameter("gross_charge_amt"));
	}
	float disc_amt = 0;
	try {
		disc_amt = Float.parseFloat(request.getParameter("disc_amt"));
	}
	catch(Exception e)
	{
		out.println("disc_amt "+request.getParameter("disc_amt"));
	}
	float net_charge_amt = 0;
	try {	
		net_charge_amt = Float.parseFloat(request.getParameter("net_charge_amt"));
	}
	catch(Exception e)
	{
		out.println("net_charge_amt "+request.getParameter("net_charge_amt "));
	}
	float pat_base_qty = 0;
	try {	
		pat_base_qty = Float.parseFloat(request.getParameter("pat_base_qty"));
	}
	catch(Exception e)
	{
		out.println("pat_base_qty "+request.getParameter("pat_base_qty "));
	}
	float pat_base_rate = 0;
	try {
		pat_base_rate = Float.parseFloat(request.getParameter("pat_base_rate"));
	}
	catch(Exception e)
	{
		out.println("pat_base_rate"+request.getParameter("pat_base_rate"));
	}
	float pat_serv_qty = 0;
	try {
		pat_serv_qty = Float.parseFloat(request.getParameter("pat_serv_qty"));
	}
	catch(Exception e)
	{
		out.println("pat_serv_qty"+request.getParameter("pat_serv_qty"));
	}
	float pat_base_charge_amt = 0;
	try {
		pat_base_charge_amt = Float.parseFloat(request.getParameter("pat_base_charge_amt"));
	}
	catch(Exception e)
	{
		out.println("pat_base_charge_amt"+request.getParameter("pat_base_charge_amt"));
	}
	float pat_gross_charge_amt = 0;
	try {
		pat_gross_charge_amt = Float.parseFloat(request.getParameter("pat_gross_charge_amt"));
	}
	catch(Exception e)
	{
		out.println("pat_gross_charge_amt "+request.getParameter("pat_gross_charge_amt"));
	}
	float pat_disc_amt = 0;
	try {
		pat_disc_amt = Float.parseFloat(request.getParameter("pat_disc_amt"));
	}
	catch(Exception e)
	{
		out.println("pat_disc_amt "+request.getParameter("pat_disc_amt"));
	}
	float pat_net_charge_amt = 0;
	try {
		pat_net_charge_amt = Float.parseFloat(request.getParameter("pat_net_charge_amt"));
	}
	catch(Exception e)
	{
		out.println("pat_net_charge_amt"+request.getParameter("pat_net_charge_amt"));
	}
	float cust_base_qty = 0;
	try {
		cust_base_qty = Float.parseFloat(request.getParameter("cust_base_qty"));
	}
	catch(Exception e)
	{
		out.println("cust_base_qty"+request.getParameter("cust_base_qty"));
	}
	float cust_base_rate = 0;
	try {
		cust_base_rate = Float.parseFloat(request.getParameter("cust_base_rate"));
	}
	catch(Exception e)
	{
		out.println("cust_base_rate"+request.getParameter("cust_base_rate"));
	}
	float cust_serv_qty = 0;
	try {
		cust_serv_qty = Float.parseFloat(request.getParameter("cust_serv_qty"));
	}
	catch(Exception e)
	{
		out.println("cust_serv_qty "+request.getParameter("cust_serv_qty"));
	}
	float cust_base_charge_amt = 0;
	try {
		cust_base_charge_amt = Float.parseFloat(request.getParameter("cust_base_charge_amt"));
	}
	catch(Exception e)
	{
		out.println("cust_base_charge_amt "+request.getParameter("cust_base_charge_amt"));
	}
	float cust_gross_charge_amt = 0;
	try {
		cust_gross_charge_amt = Float.parseFloat(request.getParameter("cust_gross_charge_amt"));
	}
	catch(Exception e)
	{
		out.println("cust_gross_charge_amt "+request.getParameter("cust_gross_charge_amt"));
	}
	float cust_disc_amt = 0;
	try {
		cust_disc_amt = Float.parseFloat(request.getParameter("cust_disc_amt"));
	}
	catch(Exception e)
	{
		out.println("cust_disc_amt "+request.getParameter("cust_disc_amt"));
	}
	float cust_net_charge_amt = 0;
	try {
		cust_net_charge_amt = Float.parseFloat(request.getParameter("cust_net_charge_amt")); // In Out 
	}
	catch(Exception e)
	{
		out.println("cust_net_charge_amt "+request.getParameter("cust_net_charge_amt "));
	}
	String  split_yn = "";
	String  pkg_ins_pat_ind = "";
	float req_pkg_qty = 0;
	float req_addl_qty = 0;
	float req_std_qty = 0;
	float curr_availed = 0;
	String  canadj_alert_ind  = "";
	String day_type_code	= "";
	String time_type_code  = "";
	float disc_perc		= 0;
    int addl_fctr		= 0;
	
	String  err_code = "";
	String gross_charge_amt1 = "0";
	String disc_amt1 = "0";
	String net_charge_amt1 = "0";

   	out.println("<html><head>");
	//out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	out.println("<link rel='StyleSheet' href='../../eCommon/html/'"+sStyle+" type='text/css'/>");

	out.println("<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
	
	/*String sql = visit_date_d+","+billing_class+","+pkg_serv_code+","+mpi_yn+","+patient_id+","+op_episode_id+","+op_episode_type;
	sql += ","+op_episode_visit_num+","+billing_group+","+trx_date_d+","+pkg_serv_code;
	sql +=","+cust_code+","+non_ins_blng_grp+","+non_ins_cust_code+","+pkg_bill_doc_type+","+pkg_bill_doc_num+","+policy_type_code+","+policy_expiry_date+","+pkg_bill_type;
	//out.println("<script>alert('"+java.net.URLEncoder.encode(policy_type)+"');</script>");
	out.println(sql);*/
	int v_cnt = 0;
	String chkflag = "N";
	if ((policy_type_code != null) || (!(policy_type_code.equals(""))))
	{		
		try
		{
			pstmt = con.prepareStatement("select count(*) from bl_ins_policy_type_dtl	where policy_type_code = '"+policy_type_code+"' and 															cust_code = '"+cust_code+"' and nvl(excl_incl_ind, 'N') = 'I' and nvl(pre_approval_yn, 'N') = 'Y' and 																blng_serv_code = '"+pkg_serv_code+"'");
			
			rs = pstmt.executeQuery();
			if (rs!=null)
			{
				rs.next();
				v_cnt = rs.getInt(1);
				if (v_cnt > 0) 
					chkflag = "Y";
			}
		}
		catch(Exception e) { out.println(e.toString());}
		finally 
		{
			 if (pstmt != null) pstmt.close();
			 if (rs != null)   rs.close();
		}
	}

	if ((!pkg_serv_code.equals("")) && (chkflag.equals("N")))
    {
		//CurrencyFormat cf = new CurrencyFormat();
		//2002-02-06,OP,11D123,Y,00001781,2002130,O,7,null,2002-02-06,11D123 		
		//sql +=","+cust_code+","+non_ins_blng_grp+","+non_ins_cust_code+","+

		try {
		CallableStatement cstmt = con.prepareCall( "{call bl_mpi_calculate_charge(to_date('"+visit_date_new+"','dd/mm/yyyy hh24:mi'), ?,?,?,?,?,?,?,?,to_date('"+visit_date_new+"','dd/mm/yyyy hh24:mi'), ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		//cstmt.setDate( 1, visit_date_d); //Visit Date
		cstmt.setString( 1, billing_class);
		cstmt.setString( 2, pkg_serv_code); //p_blng_serv
		cstmt.setString(3, mpi_yn);
		cstmt.setString(4, patient_id);
		cstmt.setInt(5, op_episode_id);
		cstmt.setString(6, op_episode_type);
		cstmt.setInt(7, op_episode_visit_num);
		cstmt.setString(8, billing_group);
		//cstmt.setDate(10, trx_date_d); //Trx date
		cstmt.setString(9, pkg_serv_code); //P_PKG_SERV_CODE
		cstmt.setString(10, cust_code); //P_CUST_CODE
		cstmt.setString(11, non_ins_blng_grp); //P_NON_INS_BLNG_GRP_ID
		cstmt.setString(12, non_ins_cust_code); //P_NON_INS_CUST_CODE
		cstmt.setString( 13, pkg_bill_doc_type);//(15, pkg_bill_doc_type); //IN/OUT
		cstmt.registerOutParameter( 13, java.sql.Types.VARCHAR);//(15, pkg_bill_doc_type); //IN/OUT
		cstmt.setInt( 14, pkg_bill_doc_num);//(16, pkg_bill_doc_num); //IN/OUT
		cstmt.registerOutParameter( 14, java.sql.Types.INTEGER);//(16, pkg_bill_doc_num); //IN/OUT
		cstmt.setString( 15, policy_type);//17, policy_type_code); //P_POLICY_TYPE_CODE (IN/OUT)
		cstmt.registerOutParameter( 15, java.sql.Types.VARCHAR);//17, policy_type_code); //P_POLICY_TYPE_CODE (IN/OUT)
		cstmt.setDate(16, policy_expiry_date_d); //P_POLICY_EXPIRY_DATE
		cstmt.setString(17, mesg_reqd); //P_MESG_REQD
		cstmt.setString( 18, effective_date);//20, effective_date); // IN/OUT
		cstmt.registerOutParameter( 18, java.sql.Types.VARCHAR);//20, effective_date); // IN/OUT
		cstmt.setString( 19, credit_auth_ref);//21, credit_auth_ref); // IN/OUT
		cstmt.registerOutParameter( 19, java.sql.Types.VARCHAR);//21, credit_auth_ref); // IN/OUT
		cstmt.setFloat( 20, approved_days);//(22, approved_days); // IN/OUT
		cstmt.registerOutParameter( 20, java.sql.Types.FLOAT);//(22, approved_days); // IN/OUT
		cstmt.setString(21, pkg_bill_doc_type);
		cstmt.setFloat(22, serv_qty);	
		cstmt.setFloat(23, pkg_price);
		cstmt.setFloat(24, pkg_value);
		cstmt.setString(25, policy_type);
		cstmt.setFloat( 26, base_qty);//29, base_qty) // IN/OUT
		cstmt.registerOutParameter( 26, java.sql.Types.FLOAT);//29, base_qty) // IN/OUT
		cstmt.registerOutParameter( 27, java.sql.Types.FLOAT);//30, base_rate);             //--DO--
		cstmt.registerOutParameter( 28, java.sql.Types.FLOAT);//31, base_charge_amt);
		cstmt.registerOutParameter( 29, java.sql.Types.FLOAT);//32, gross_charge_amt);
		cstmt.registerOutParameter( 30, java.sql.Types.FLOAT);//33, disc_amt);
		cstmt.registerOutParameter( 31, java.sql.Types.FLOAT);//34, net_charge_amt);
		cstmt.registerOutParameter( 32, java.sql.Types.FLOAT);//35, pat_base_qty);
		cstmt.registerOutParameter( 33, java.sql.Types.FLOAT);//36, pat_base_rate);
		cstmt.registerOutParameter( 34, java.sql.Types.FLOAT);//37, pat_serv_qty);
		cstmt.registerOutParameter( 35, java.sql.Types.FLOAT);//38, pat_base_charge_amt);
		cstmt.registerOutParameter( 36, java.sql.Types.FLOAT);//39, pat_gross_charge_amt);
		cstmt.registerOutParameter( 37, java.sql.Types.FLOAT);//(40, pat_disc_amt);
		cstmt.registerOutParameter( 38, java.sql.Types.FLOAT);//41, pat_net_charge_amt);
		cstmt.registerOutParameter( 39, java.sql.Types.FLOAT);//42, cust_base_qty);
		cstmt.registerOutParameter( 40, java.sql.Types.FLOAT);//43, cust_base_rate);
		cstmt.registerOutParameter( 41, java.sql.Types.FLOAT);//44, cust_serv_qty);
		cstmt.registerOutParameter( 42, java.sql.Types.FLOAT);//45, cust_base_charge_amt);
		cstmt.registerOutParameter( 43, java.sql.Types.FLOAT);//46, cust_gross_charge_amt);
		cstmt.registerOutParameter( 44, java.sql.Types.FLOAT);//47, cust_disc_amt);
		cstmt.registerOutParameter( 45, java.sql.Types.FLOAT);//48, cust_net_charge_amt); // IN/OUT
		cstmt.registerOutParameter( 46, java.sql.Types.VARCHAR);//49, split_yn); // OUT 
		cstmt.registerOutParameter( 47, java.sql.Types.VARCHAR);//50, pkg_ins_pat_ind); //DO OUT
		cstmt.registerOutParameter( 48, java.sql.Types.FLOAT);//51, req_pkg_qty);
		cstmt.registerOutParameter( 49, java.sql.Types.FLOAT);//52, req_addl_qty);
		cstmt.registerOutParameter( 50, java.sql.Types.FLOAT);//53, req_std_qty);
		cstmt.registerOutParameter( 51, java.sql.Types.FLOAT);//54, curr_availed);
		cstmt.registerOutParameter( 52, java.sql.Types.VARCHAR);//55, canadj_alert_ind);	
		cstmt.registerOutParameter( 53, java.sql.Types.VARCHAR);//56, day_type_code); //OUT
		cstmt.registerOutParameter( 54, java.sql.Types.VARCHAR);//56, time_type_code); //OUT
		cstmt.registerOutParameter( 55, java.sql.Types.FLOAT);//56, DISC_PERC); //OUT
		cstmt.registerOutParameter( 56, java.sql.Types.INTEGER);//56, addl_factor); //OUT
		cstmt.registerOutParameter( 57, java.sql.Types.VARCHAR);//56, err_code); //OUT
		
		cstmt.execute() ;

		pkg_bill_doc_type = cstmt.getString(13); // In Out 
		pkg_bill_doc_num = cstmt.getInt(14); // In Out 
		policy_type_code = cstmt.getString(15); //In Out 

		effective_date = cstmt.getString(18); // In Out 
		credit_auth_ref = cstmt.getString(19);// In Out 
		approved_days = cstmt.getFloat(20); // In Out 
		base_qty = cstmt.getFloat(26);
		base_rate = cstmt.getFloat(27);	
		base_charge_amt = cstmt.getFloat(28);	
		gross_charge_amt = cstmt.getFloat(29);	
		CurrencyFormat cf = new CurrencyFormat();
		gross_charge_amt1 = cstmt.getString(29);			
		gross_charge_amt1= cf.formatCurrency(gross_charge_amt1, 2);
		disc_amt = cstmt.getFloat(30);	
		disc_amt1 = cstmt.getString(30);			
		disc_amt1= cf.formatCurrency(disc_amt1, 2);
		net_charge_amt = cstmt.getFloat(31);	
		net_charge_amt1 = cstmt.getString(31);
		net_charge_amt1= cf.formatCurrency(net_charge_amt1, 2);
		//net_charge_amt = cf.formatCurrency(net_charge_amt, 2);
		pat_base_qty = cstmt.getFloat(32);	
		pat_base_rate = cstmt.getFloat(33);	
		pat_serv_qty = cstmt.getFloat(34);	
		pat_base_charge_amt = cstmt.getFloat(35);	
		pat_gross_charge_amt = cstmt.getFloat(36);	
		pat_disc_amt = cstmt.getFloat(37);	
		pat_net_charge_amt = cstmt.getFloat(38);	
		cust_base_qty = cstmt.getFloat(39);	
		cust_base_rate = cstmt.getFloat(40);	
		cust_serv_qty = cstmt.getFloat(41);	
		cust_base_charge_amt = cstmt.getFloat(42);	
		cust_gross_charge_amt = cstmt.getFloat(43);	
		cust_disc_amt = cstmt.getFloat(44);	
		cust_net_charge_amt = cstmt.getFloat(45);	
		split_yn = cstmt.getString(46);
		pkg_ins_pat_ind = cstmt.getString(47);	
		req_pkg_qty = cstmt.getFloat(48);	
		req_addl_qty = cstmt.getFloat(49);	
		req_std_qty = cstmt.getFloat(50);	
		curr_availed = cstmt.getFloat(51);
		canadj_alert_ind  = cstmt.getString(52);	
		day_type_code	= cstmt.getString(53);
		time_type_code  = cstmt.getString(54);
		disc_perc		= cstmt.getFloat(55);
		addl_fctr		= cstmt.getInt(56);
		err_code = cstmt.getString(57);		

		cstmt.close();

		}
		
		catch (Exception e)
		{
			out.println("Exception "+e);
		}

		//Assinging the returned values to the called JSP(VisitRegistrationQuery)
		if (err_code==null) err_code = "0";
		//out.println("error code "+err_code);
		if ((err_code.equals("0")) || (err_code.equals("Eligible quantity already availed for this service")))
		{
		
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(billing_class));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(pkg_bill_doc_type));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(pkg_bill_doc_num));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(policy_type_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(effective_date));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(credit_auth_ref));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(approved_days));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(base_qty));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(base_rate));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(base_charge_amt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(gross_charge_amt));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disc_amt));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(net_charge_amt));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(gross_charge_amt1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disc_amt1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(net_charge_amt1));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pat_base_qty));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pat_base_rate));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pat_serv_qty));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pat_base_charge_amt));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(pat_gross_charge_amt));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(pat_disc_amt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pat_net_charge_amt));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(cust_base_qty));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(cust_base_rate));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(cust_serv_qty));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(cust_base_charge_amt));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(cust_gross_charge_amt));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(cust_disc_amt));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cust_net_charge_amt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(split_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(pkg_ins_pat_ind));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(req_pkg_qty));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(req_addl_qty));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(req_std_qty));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(curr_availed));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(canadj_alert_ind));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(pkg_serv_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(day_type_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(time_type_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(disc_perc));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(addl_fctr));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(net_charge_amt));
            _bw.write(_wl_block46Bytes, _wl_block46);

			//if (mode.equals("Y"))
			out.println("<script>parent.frames[1].frames[1].dispVisitCharge('"+mode+"');</script>");		
			//out.println("<script>alert(parent.frames[1].frames[1].document.forms[0].pkg_ins_pat_ind.value);</script>");
			out.println("</head><body class='message'></body></html>");
		 }
		 else 
		 {
			out.println("</head><body class='message'></body></html>");
			if (!err_code.substring(0,2).equals("**")) 
			 {
				java.util.Hashtable message = MessageManager.getMessage( con, err_code) ;
				String err_msg = (String) message.get("message")  ;
				response.sendRedirect("../../eCommon/jsp/error.jsp?err_num="+err_msg);
			 }
			 else
				response.sendRedirect("../../eCommon/jsp/error.jsp?err_num="+err_code);
		 }
   }
   else if (pkg_serv_code.equals(""))
   {
		//out.println("<script>alert('Billing Service Code is null for this Clinic');</script>");		
		out.println("</head><body class='message'></body></html>"); 
		java.util.Hashtable message = MessageManager.getMessage( con, "BL9200") ;
		String err_msg = (String) message.get("message")  ;
		response.sendRedirect("../../eCommon/jsp/error.jsp?err_num="+err_msg);
	}
	else if (chkflag.equals("Y"))
	{
		//out.println("<script>alert('Visit Charge Billing Service does not require pre-approval');</script>");
		out.println("</head><body class='message'></body></html>");
		java.util.Hashtable message = MessageManager.getMessage( con, "BL9117") ;
		String err_msg = (String) message.get("message")  ;
		response.sendRedirect("../../eCommon/jsp/error.jsp?err_num="+err_msg);		
	}
}
catch(Exception ee)
{
	out.println("Exception in main try"+ee);
}
finally
{
	if(pstmt != null)pstmt.close();
	ConnectionManager.returnConnection(con, request);
}

            _bw.write(_wl_block47Bytes, _wl_block47);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
