package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;

public final class __existingordervalidate1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ExistingOrderValidate1.jsp", 1732512890000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eOR.ExistingOrder beanObj= null;{
                beanObj=(eOR.ExistingOrder)pageContext.getAttribute("beanObj");
                if(beanObj==null){
                    beanObj=new eOR.ExistingOrder();
                    pageContext.setAttribute("beanObj",beanObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
 
    	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	String localeName=request.getParameter("localeName");
	//System.out.println("==localeName==="+localeName+"==========");    
		beanObj.setLanguageId(localeName);


	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;


	Properties properties	= (Properties) session.getValue( "jdbc" );
 	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	/*if ( validate.equals( "ord_cat" ) ) {
		String order_category = (String)hash.get("order_category") ;
		out.println( "clearList('document') ; " ) ;
		
		ArrayList OrderTypeData = beanObj.getOrderTypeData(properties, order_category) ;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			String[] record = (String[])OrderTypeData.get(i);
			out.println( "addOrderTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}

		out.println( "clearActivityList('document') ; " ) ;

		ArrayList ActivityTypeData = beanObj.getActivityType(properties, order_category, "") ;
		for( int i=0 ; i< ActivityTypeData.size() ; i++ ) {
			String[] record = (String[])ActivityTypeData.get(i);
			out.println( "addActivityTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}

	}   else*/ if (validate.equals("viewBill")) {
		String parent_order_id 			= request.getParameter("parent_order_id");
		String parent_order_line_num 	= request.getParameter("parent_order_line_num");
		String ordering_facility_id 	= request.getParameter("ordering_facility_id");
		//String function_from 			= request.getParameter("function_from");
		String catalog_code				= request.getParameter("catalog_code");
		String catalog_desc				= request.getParameter("catalog_desc");

		ArrayList BillChargeInfo		= beanObj.getBillChargeDetails(properties, parent_order_id,parent_order_line_num,ordering_facility_id) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
		//out.println("load"+BillChargeInfo.size());
		if (BillChargeInfo != null && BillChargeInfo.size() > 0) {
			String[] record				= (String[])BillChargeInfo.get(0);
			if (record[21] != null && (!record[21].equals(""))) {
				out.println("alert('"+record[21]+"')");
			} else {
				String day_type_code 			= "", day_type_desc 		= "";
				String time_type_code 			= "", time_type_desc 		= "";
				String base_qty 	  			= "", base_rate 			= "";
				String addl_factor 	  			= "", base_charge_amt 		= "";
				String gross_charge_amt 		= "", disc_amt 				= "";
				String net_charge_amt 			= "", disc_perc 			= "";
				String pat_gross_charge_amt		= "", pat_disc_amt 			= "";
				String pat_net_charge_amt		= "", cust_gross_charge_amt	= "";
				String cust_disc_amt			= "", cust_net_charge_amt	= "";
				String split_ind				= "", curr_availed			= "";
				String credit_auth_ref			= "", error_text			= "";
				String serv_panel_ind       	= "", serv_panel_code       = "";
		 	 	String service_panel_name   	= "";

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
				net_charge_amt  		= beanObj.checkForNull(record[10],"");
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
				//out.println("alert('parent_order_id="+parent_order_id+",parent_order_line_num="+parent_order_line_num+",ordering_facility_id="+ordering_facility_id+",loadBillingDetails(\""+day_type_code+"\",\"" +day_type_desc+"\" ,\""+time_type_code+"\",\""+time_type_desc+"\",\""+base_qty+"\",\"" +base_rate+"\" ,\""+addl_factor+"\",\""+base_charge_amt+"\",\"" +gross_charge_amt+"\" ,\""+disc_amt+"\",\""+net_charge_amt+"\",\""+disc_perc+"\",\""+pat_gross_charge_amt+"\",\""+pat_disc_amt+"\",\""+pat_net_charge_amt+"\",\""+cust_gross_charge_amt+"\",\""+cust_disc_amt+"\",\""+cust_net_charge_amt+"\" ,\""+split_ind+"\",\""+curr_availed+"\" ,\"" +credit_auth_ref+"\" ,\""+catalog_code+"\" ,\""+catalog_desc+"\" ,\""+serv_panel_ind+"\" ,\""+serv_panel_code+"\" ,\""+service_panel_name+"\" ,\""+error_text+"\") ; ')");
				out.println( "loadBillingDetails(\""+day_type_code+"\",\"" +day_type_desc+"\" ,\""+time_type_code+"\",\""+time_type_desc+"\",\""+base_qty+"\",\"" +base_rate+"\" ,\""+addl_factor+"\",\""+base_charge_amt+"\",\"" +gross_charge_amt+"\" ,\""+disc_amt+"\",\""+net_charge_amt+"\",\""+disc_perc+"\",\""+pat_gross_charge_amt+"\",\""+pat_disc_amt+"\",\""+pat_net_charge_amt+"\",\""+cust_gross_charge_amt+"\",\""+cust_disc_amt+"\",\""+cust_net_charge_amt+"\" ,\""+split_ind+"\",\""+curr_availed+"\" ,\"" +credit_auth_ref+"\" ,\""+catalog_code+"\" ,\""+catalog_desc+"\" ,\""+serv_panel_ind+"\" ,\""+serv_panel_code+"\" ,\""+service_panel_name+"\" ,\""+error_text+"\") ; " ) ;
			}
		}
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
