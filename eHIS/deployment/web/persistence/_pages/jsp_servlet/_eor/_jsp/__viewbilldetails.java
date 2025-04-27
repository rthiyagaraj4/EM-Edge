package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.math.BigDecimal;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __viewbilldetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ViewBillDetails.jsp", 1709120058000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/ViewOrder.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" </title>\n</head>\n<body  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n<FORM METHOD=POST ACTION=\"\">\n<table class=\"grid\" cellpadding=3 cellspacing=0 border=1>\n<tr><td class=\'columnheader\' width=\'\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td><td class=\'columnheader\' width=\'\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td><td class=\'columnheader\' width=\'\'></td><td class=\'columnheader\' width=\'\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td></tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<tr><td class=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' ><B>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</B></td><td class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' align=\'left\'><B>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</B></td>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<td class=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' ><B><a class=\"gridLink\"  href=\"javascript:loadBillingDetails(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\') ;\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</B></td>\n\n</tr>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n<tr><td colspan=\'3\' class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</B></td>\n<td class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</B></td></tr>\n</table>\n</FORM>\n\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eOR.ExistingOrder beanObj= null;{
                beanObj=(eOR.ExistingOrder)pageContext.getAttribute("beanObj");
                if(beanObj==null){
                    beanObj=new eOR.ExistingOrder();
                    pageContext.setAttribute("beanObj",beanObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
String cont_order_ind			= request.getParameter("cont_order_ind");
String parent_order_id			= request.getParameter("parent_order_id");
String parent_order_line_num	= request.getParameter("parent_order_line_num");
String bean_id					= request.getParameter("bean_id");
String bean_name				= request.getParameter("bean_name");
String function_from			= request.getParameter("function_from");
String ordering_facility_id 	= request.getParameter("ordering_facility_id");
String slClassValue				= "";

if(cont_order_ind == null || cont_order_ind.equals("null"))	cont_order_ind = "";
if(parent_order_id == null || parent_order_id.equals("null"))	parent_order_id = "";
if(parent_order_line_num == null || parent_order_line_num.equals("null"))	parent_order_line_num = "";
if(bean_id == null || bean_id.equals("null"))	bean_id = "";
if(bean_name == null || bean_name.equals("null"))	bean_name = "";
if(function_from == null || function_from.equals("null"))	function_from = "";
//double tempDouble				= 1.111,
double totalAmt				= 0.0;
BigDecimal TotAmt = new BigDecimal(0.000);
TotAmt = TotAmt.setScale(3,6);

java.util.ArrayList	BillDetails = new java.util.ArrayList();
Properties properties	= (Properties) session.getValue( "jdbc" );

//if (appt_ref_num.equals("") && (!(function_from.equalsIgnoreCase("DO") || function_from.equalsIgnoreCase("CO")))) {
//	if (!(cont_order_ind.equalsIgnoreCase("DO") || cont_order_ind.equalsIgnoreCase("CO"))) {
//		if (function_from.equalsIgnoreCase("View") || function_from.equalsIgnoreCase("Cancel")) {
			//ExistingOrder beanObj = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
			//ExistingOrder beanObj = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	beanObj.setLanguageId(localeName);

			BillDetails = (java.util.ArrayList)beanObj.getBLDetails(properties, parent_order_id,parent_order_line_num);
//		} else if (function_from.equalsIgnoreCase("ReviewStatus")) {
//			ReviewStatusBean bean = (ReviewStatusBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
//			AppointmentDetails = (java.util.ArrayList)bean.getApptDetails(parent_order_id,parent_order_line_num);
//		} else if (function_from.equalsIgnoreCase("Complete")) {
//			CompleteOrderBean bean = (CompleteOrderBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
//			AppointmentDetails = (java.util.ArrayList)bean.getApptDetails(parent_order_id,parent_order_line_num);
//		}
//	}
//} else if (!appt_ref_num.equals("")){
//	String [] record 	= new String[2];
//	record[0]			= appt_ref_num;
//	record[1]			= appt_date;
//	AppointmentDetails.add(record);
//}

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            _bw.write(_wl_block1Bytes, _wl_block1);
for(int i=0;i < BillDetails.size();i++) {
	String[] records = (String [])BillDetails.get(i);
	String order_id 			= beanObj.checkForNull(records[0],"");
	String order_line_num		= beanObj.checkForNull(records[1],"");
	String start_date_time		= beanObj.checkForNull(records[2],"");
	String billed_yn			= beanObj.checkForNull(records[3],"");
	String bill_yn				= beanObj.checkForNull(records[4],"");
	String catalog_code			= beanObj.checkForNull(records[5],"");
	String catalog_desc			= beanObj.checkForNull(records[6],"");
	String order_line_status	= beanObj.checkForNull(records[7],"");
	if(!(order_line_status.trim().equals("CN") || order_line_status.trim().equals("DC") || order_line_status.trim().equals("RD") || order_line_status.trim().equals("RJ"))) {
	ArrayList BillChargeInfo	= beanObj.getBillChargeDetails(properties, order_id,order_line_num,ordering_facility_id) ; // Calling the bean method, internally will call a procedure to get the Billing Informations

    String day_type_code 			= "", day_type_desc 		= "";
    String time_type_code 			= "", time_type_desc 		= "";
    String base_qty 	  			= "", base_rate 			= "";
    String addl_factor 	  			= "", base_charge_amt 		= "";
    String gross_charge_amt 		= "", disc_amt 				= "";
    double net_charge_amt 			= 0.0;
    String pat_gross_charge_amt		= "", pat_disc_amt 			= "";
    String pat_net_charge_amt		= "", cust_gross_charge_amt	= "";
    String cust_disc_amt			= "", cust_net_charge_amt	= "";
    String split_ind				= "", curr_availed			= "";
    String credit_auth_ref			= "", error_text			= "";
    String serv_panel_ind       	= "", serv_panel_code       = "";
    String service_panel_name   	= "", disc_perc 			= "";


	if (BillChargeInfo != null && BillChargeInfo.size() > 0) {
			String[] record				= (String[])BillChargeInfo.get(0);
//			if (record[21] != null && (!record[21].equals(""))) {
//				out.println("alert('"+record[21]+"')");
//			} else {
				day_type_code   		= beanObj.checkForNull(record[0],"");
				day_type_desc   		= beanObj.checkForNull(record[1],"");
				time_type_code  		= beanObj.checkForNull(record[2],"");
				time_type_desc  		= beanObj.checkForNull(record[3],"");
				base_qty   				= beanObj.checkForNull(record[4],"");
				base_rate   			= beanObj.checkForNull(record[5],"");
				addl_factor   			= beanObj.checkForNull(record[6],"");
				base_charge_amt 		= beanObj.checkForNull(record[7],"");
				gross_charge_amt		= beanObj.checkForNull(record[8],"");
				disc_amt  	 			= beanObj.checkForNull(record[9],"");
				//net_charge_amt  		= beanObj.checkForNull(record[10],"");
				net_charge_amt			= (record[10] == null || record[10].equals("")) ? 0.0:Double.parseDouble(record[10]);

				disc_perc	    		= beanObj.checkForNull(record[11],"");
				pat_gross_charge_amt	= beanObj.checkForNull(record[12],"");
				pat_disc_amt 			= beanObj.checkForNull(record[13],"");
				pat_net_charge_amt 		= beanObj.checkForNull(record[14],"");
				cust_gross_charge_amt	= beanObj.checkForNull(record[15],"");
				cust_disc_amt			= beanObj.checkForNull(record[16],"");
				cust_net_charge_amt		= beanObj.checkForNull(record[17],"");
				split_ind				= beanObj.checkForNull(record[18],"");
				curr_availed			= beanObj.checkForNull(record[19],"");
				credit_auth_ref			= beanObj.checkForNull(record[20],"");
				error_text				= beanObj.checkForNull(record[21],"");
				serv_panel_ind			= beanObj.checkForNull(record[22],"");
				serv_panel_code			= beanObj.checkForNull(record[23],"");
				service_panel_name		= beanObj.checkForNull(record[24],"");

				//out.println( "loadBillingDetails(\""+day_type_code+"\",\"" +day_type_desc+"\" ,\""+time_type_code+"\",\""+time_type_desc+"\",\""+base_qty+"\",\"" +base_rate+"\" ,\""+addl_factor+"\",\""+base_charge_amt+"\",\"" +gross_charge_amt+"\" ,\""+disc_amt+"\",\""+net_charge_amt+"\",\""+disc_perc+"\",\""+pat_gross_charge_amt+"\",\""+pat_disc_amt+"\",\""+pat_net_charge_amt+"\",\""+cust_gross_charge_amt+"\",\""+cust_disc_amt+"\",\""+cust_net_charge_amt+"\" ,\""+split_ind+"\",\""+curr_availed+"\" ,\"" +credit_auth_ref+"\" ,\""+catalog_code+"\" ,\""+catalog_desc+"\" ,\""+serv_panel_ind+"\" ,\""+serv_panel_code+"\" ,\""+service_panel_name+"\" ,\""+error_text+"\") ; " ) ;
			//}
		}
		/*if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}*/
		slClassValue="gridData";

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(start_date_time));
            _bw.write(_wl_block17Bytes, _wl_block17);
if(bill_yn.equals("Y"))	{
//out.println("<script>alert('order_id=" +order_id+",order_line_num="+order_line_num+",ordering_facility_id="+ordering_facility_id+",loadBillingDetails(\"day_type_code="+day_type_code+"\",\"day_type_desc=" +day_type_desc+"\" ,\"time_type_code="+time_type_code+"\",\"time_type_desc="+time_type_desc+"\",\"base_qty="+base_qty+"\",\"base_rate=" +base_rate+"\" ,\"addl_factor="+addl_factor+"\",\"base_charge_amt="+base_charge_amt+"\",\"gross_charge_amt=" +gross_charge_amt+"\" ,\"disc_amt="+disc_amt+"\",\"net_charge_amt="+net_charge_amt+"\",\"disc_perc="+disc_perc+"\",\"pat_gross_charge_amt="+pat_gross_charge_amt+"\",\"pat_disc_amt="+pat_disc_amt+"\",\"pat_net_charge_amt="+pat_net_charge_amt+"\",\"cust_gross_charge_amt="+cust_gross_charge_amt+"\",\"cust_disc_amt="+cust_disc_amt+"\",\"cust_net_charge_amt="+cust_net_charge_amt+"\" ,\"split_ind="+split_ind+"\",\"curr_availed="+curr_availed+"\" ,\"credit_auth_ref=" +credit_auth_ref+"\" ,\"catalog_code="+catalog_code+"\" ,\"catalog_desc="+catalog_desc+"\" ,\"serv_panel_ind="+serv_panel_ind+"\" ,\"serv_panel_code="+serv_panel_code+"\" ,\"service_panel_name="+service_panel_name+"\" ,\"error_text="+error_text+"\") ; ')</script>");

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(day_type_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(day_type_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(time_type_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(time_type_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(base_qty));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(base_rate));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(addl_factor));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(base_charge_amt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(gross_charge_amt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disc_amt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(net_charge_amt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disc_perc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pat_gross_charge_amt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pat_disc_amt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pat_net_charge_amt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cust_gross_charge_amt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cust_disc_amt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cust_net_charge_amt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(split_ind));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(curr_availed));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(credit_auth_ref));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(catalog_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(catalog_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(serv_panel_ind));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(serv_panel_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(service_panel_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(error_text));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((billed_yn.equals("Y"))?"Billed":"Not Billed"));
            _bw.write(_wl_block17Bytes, _wl_block17);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
//net_charge_amt=net_charge_amt+tempDouble;
BigDecimal net_charge = new BigDecimal(net_charge_amt);
net_charge = net_charge.setScale(3,6);
TotAmt = TotAmt.add(net_charge);
totalAmt				= totalAmt + net_charge_amt;
//tempDouble += 1;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(net_charge));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
}
//slClassValue = (slClassValue.equals("QRYEVEN"))?"QRYODD":"QRYEVEN";
slClassValue="gridData";

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(TotAmt));
            _bw.write(_wl_block25Bytes, _wl_block25);

	//putObjectInBean(bean_id,beanObj,request);	

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderID.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startdatetime.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NetAmount.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.TotalAmount.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }
}
