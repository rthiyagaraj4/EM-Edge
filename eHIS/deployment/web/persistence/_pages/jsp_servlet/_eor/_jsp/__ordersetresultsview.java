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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __ordersetresultsview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderSetResultsView.jsp", 1709119856000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- \t<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n --> \t<script language=\"JavaScript\" src=\"../js/ResultOrder.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n \t<STYLE TYPE=\"text/css\"></style>\n</head>\n<body  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n<form name=\"view_order\" id=\"view_order\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t<textarea rows=\"4\" cols=\"80\"  CLASS = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" READONLY>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</textarea>\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<textarea rows=\"5\" cols=\"80\"  CLASS = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" READONLY title = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" ondblclick=\"viewClobData(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</textarea>\n \t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t<textarea rows=\"4\" cols=\"80\"   CLASS = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" READONLY >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</textarea>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t    <textarea rows=\"5\" cols=\"80\"  CLASS = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t<textarea rows=\"4\" cols=\"80\"  CLASS = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</textarea>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t\t<textarea rows=\"5\" cols=\"80\"  CLASS = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</textarea> \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n  \t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n \t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t<a class=\"gridLink\" href=\"javascript:viewResultComment(escape(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'))\">C</a>\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t<IMG SRC=\'../images/Xray.gif\' WIDTH=\'16\' HEIGHT=\'16\' BORDER=0>\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n                    </td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n\t\t<Input name=\"ord_typ_code\" id=\"ord_typ_code\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t<Input name=\"patient_class\" id=\"patient_class\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t<Input name=\"priority\" id=\"priority\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t<Input name=\"ord_id\" id=\"ord_id\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t<Input name=\"source_type\" id=\"source_type\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t<Input name=\"location_code\" id=\"location_code\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t<Input name=\"order_status\" id=\"order_status\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t<Input name=\"report_srl_no\" id=\"report_srl_no\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t<Input name=\"bean_id\" id=\"bean_id\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t<Input type=\'hidden\' name=\'querystring\' id=\'querystring\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t</table>\n \t\t\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );
	
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

/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
18/12/2013	IN042552		Ramesh G	Bru-HIMS-CRF-391 --- Notes Confidentiality							
---------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	/* Mandatory checks start */
	
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ViewOrder" ;
	String bean_name = "eOR.ViewOrder";

	String careSetOrderId = request.getParameter("orderId");
	String line_order_id = request.getParameter("line_order_id");
	String order_line_num = request.getParameter("order_line_num");
	String cont_order_ind = request.getParameter("cont_order_ind");
	String patient_id = request.getParameter("patient_id");
	String ord_cat = request.getParameter("order_cat");
	if(ord_cat==null)ord_cat = "";
	String order_cat_desc = request.getParameter("order_cat_desc");
	if(order_cat_desc==null)order_cat_desc = "";
 	String order_status = request.getParameter("order_status");
 	String facility_id = (String)session.getValue("facility_id");
	String resp_id		= (String)session.getValue("responsibility_id");
	String toolTipTextArea = "Double Click to Zoom";
	if(resp_id== null)	resp_id = "";
	if(careSetOrderId == null || careSetOrderId.equals("") || careSetOrderId.equals("null"))
		careSetOrderId = "";
	if(order_line_num == null || order_line_num.equals("") || order_line_num.equals("null"))
		order_line_num = "";
	if(line_order_id == null || line_order_id.equals("") || line_order_id.equals("null"))
		line_order_id = "";
	// ORDER_SET_ID passed here........ depending upon if line_order_id is null
    if(line_order_id.equals("")) // then for the order_set so pass the order_set_id
	   line_order_id = careSetOrderId;
 	if ( order_status == null) order_status = "";
	ArrayList allValues = new ArrayList();
	ArrayList allOrderId = new ArrayList();
	String orderArray[]	= new String[3];
	int row_count		= 0;
/* Mandatory checks end */

	/* Initialize Function specific start */
	//ViewOrder bean = (ViewOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	 ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setLanguageId(localeName);

	bean.setMode( mode ) ;

	if(!careSetOrderId.equals("") && !line_order_id.equals("") && careSetOrderId.equals(line_order_id)) {
 		allOrderId	= bean.getOrderIds(careSetOrderId);
		row_count	= allOrderId.size();
	} else {
		row_count	= 1;
	}
	String result_data[] = (String[])bean.getAbnormalCondition();
	//String high_str			= result_data[0];
	//String low_str			= result_data[1];
	//String abn_str			= result_data[2];

	String crit_str			= result_data[3];
	String crit_high_str	= result_data[4];
	String crit_low_str		= result_data[5];
	String slClassValue		= "", textClassValue= "";
	String normalcy_ind			= null; 
	String normalcy_ind_disp	= null; String  result_str =  null;
	//String dcsr_msr_val		= "";
	//String time_key			= "";
	//String tmp_discr_msr_id ="";
	//String tmp_dscr_panel_id = "";
	String report_srl_no	= "";		//String tmp_date = "";
   	String reporting_date			= "";
   	String reporting_practitioner 	= "";
  	String ext_image_obj_id			= "";
  	String ext_image_appl_id		= ""; String hdr_time = "";
	String order_id					= "";
	String color					= "", toolTipText	= "";
	String key_value				= "";
	String tmp_order_cat_desc		= "";

 	TreeMap first_map		 = null;
	TreeMap time_val_map	 = null;
 
	ArrayList 	 panels		= 	null;
	ArrayList 	 discrete	=	null;

	if(row_count == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); window.close()</script>");
	}
	else
	{
		for(int k=0;k<row_count; k++) 
		{
 
  			if(!careSetOrderId.equals("") && !line_order_id.equals("") && careSetOrderId.equals(line_order_id)) 
			{
 				orderArray		= (String[])allOrderId.get(k);
				order_id		= orderArray[0];
  				ord_cat			= orderArray[1];
				order_cat_desc  = orderArray[2];
			}
			else order_id = line_order_id;
			//11g Conversion Start.
			String encntr_id		= request.getParameter( "encntr_id" ) ;
			String practitioner_id = (String)session.getValue("ca_practitioner_id");
			String pract_Rel_id = bean.getPractRelId(patient_id,facility_id,practitioner_id,encntr_id);
			//11g Conversion End.
			//IN042552 Start.
			String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");
			//allValues		= bean.viewResultDetail(order_id,order_line_num,cont_order_ind,patient_id,ord_cat,facility_id,resp_id,order_status,pract_Rel_id);
			allValues		= bean.viewResultDetail(order_id,order_line_num,cont_order_ind,patient_id,ord_cat,facility_id,resp_id,order_status,pract_Rel_id,clinician_id,"","");
			//IN042552 End.
			if(allValues.size()==0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); window.close()</script>");
			}
			else
			{
				discrete		= bean.discrete ;
				panels			= bean.panels ;
		 
				String [] print_details = {"","","","","","",""};
				print_details = (String[])bean.getOrderDetails(order_id);
				
				first_map = (TreeMap)bean.traverseList(1,allValues,first_map);

				TreeMap second_map = (TreeMap)bean.traverseList(2,allValues,first_map);

				TreeMap third_map = (TreeMap)bean.traverseList(9,allValues,second_map);
				TreeMap all_times = (TreeMap)bean.getAllTimes(9,allValues);
		 
		 
				HashMap key_value_map1 = (HashMap)bean.getKeyValueData1();
				HashMap key_value_map2 = (HashMap)bean.getKeyValueData2();

				//TreeMap dscr_msr_panel = null;
			//	TreeMap dscr_vals = null;
				Set all_times_set = (Set)all_times.keySet();
				Iterator itr_times = (Iterator)all_times_set.iterator() ;
				//Iterator itr        = (Iterator)all_times_set.iterator() ; // For the Hdg loop
			
				//TreeMap time_panel = null;
				if(panels.size()>0)
				{
					out.println("<table cellpadding=0 cellspacing=0 border=1 width='100%' align=center class='grid'>");
					if(!tmp_order_cat_desc.equals(order_cat_desc) && !order_cat_desc.equals("")){
						out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan='2' width='100%'><b>"+order_cat_desc+"</b></td></tr>");
						tmp_order_cat_desc = order_cat_desc;
				}
			}
		
			int i=1;
			//Set panel_set = (Set)third_map.keySet();
			//Iterator panel_itr = (Iterator)panel_set.iterator() ;
			String panel_key="";
			TreeMap dscr_map=null;
			String dscr_key="";
			Object obj=null;

			for(int K = 0 ; K < panels.size() ; K++)
			{// panel Iteration
		
			panel_key 				= (String)panels.get(K);
			dscr_map 				= (TreeMap)third_map.get(panel_key);


			//Set dscr_msr_set 				= null;
			//Iterator dscr_itr 				= null;
			//if(dscr_map!=null)
			//	dscr_msr_set				= (Set)dscr_map.keySet();
			/*if(dscr_msr_set!=null)
				dscr_itr					= (Iterator)dscr_msr_set.iterator() ;*/
 			if(dscr_map!=null && key_value_map1!=null && dscr_map.size() > 1) // this is in the case of existance of more than one descr msr panel id's {
  			out.println("<tr><td colspan='"+(all_times.size()+1)+"'><b>"+(String)key_value_map1.get(panel_key)+"</b></td></tr>");
			out.println("<tr><td colspan='"+(all_times.size()+1)+"' class='OR_QRYEVENBORDER'></td></tr>");
			//			while(dscr_itr.hasNext())
  			for(int l = 0; l < discrete.size(); l++)
			{ // descr iteration
				//Added by Siva Kumar on 10/9/2003
				color					= ""; toolTipText	= "";
				//End of Addition
 				if(i % 2 == 0)
				{
					//slClassValue	= "QRYEVEN";
					slClassValue="gridData";
					textClassValue	= "RESULTTEXTAREAEVEN";
				}
				else
				{
					//slClassValue = "QRYODD";
					slClassValue="gridData";
					textClassValue = "RESULTTEXTAREAODD";
				}
				dscr_key =  (String)discrete.get(l);
  				if(dscr_key!=null && dscr_map!=null && !dscr_map.containsKey(dscr_key.trim()))
					continue ;

				 //Added by Siva Kumar on 10/9/2003
				 if(dscr_key!=null && dscr_map!=null)
	                 time_val_map = (TreeMap)dscr_map.get(dscr_key);
				 if(all_times_set!=null)
				  itr_times			 = (Iterator)all_times_set.iterator() ;
				if (itr_times!=null && itr_times.hasNext()) 
				{
					hdr_time	= (String)itr_times.next();
					obj  = time_val_map.get(hdr_time);
					if(obj != null)
					{
 						String value_arr[] = (String[]) obj;

						key_value =	order_id+value_arr[21];

            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block1Bytes, _wl_block1);

						if (value_arr.length == 26) 
						{
							if (value_arr[22] != null && (!(value_arr[22]).equals(""))) 
							{
								if (value_arr[22].equals("*LB_REFLEX_REG*")) 
								{
									color = "LIGHTYELLOW";
									textClassValue = "RESULTTEXTAREAYELLOW";
									toolTipText = "This test is ordered at the time of Registration";
								}	else if (value_arr[22].equals("*LB_REFLEX_RES*")) 
								{
									color = "TAN";
									textClassValue = "RESULTTEXTAREATAN";
									toolTipText = "This test is ordered at the time of Resulting based on Reflex Test";
								}	else if (!value_arr[22].equals(request.getParameter("practitioner_id"))) 
								{
									color = "Gray";
									textClassValue = "RESULTTEXTAREAGRAY";
									toolTipText = "ordered by : " + value_arr[22];
								}
							}
							ext_image_obj_id	= (value_arr[23]==null)?"":value_arr[23];
							ext_image_appl_id	= (value_arr[24]==null)?"":value_arr[24];
							reporting_practitioner = value_arr[25];
						} 
						else if (value_arr.length == 25) 
						{
							ext_image_obj_id	= (value_arr[22]==null)?"":value_arr[22];
							ext_image_appl_id	= (value_arr[23]==null)?"":value_arr[23];
							reporting_practitioner = value_arr[24];
						}
						reporting_date 	= value_arr[9];
						report_srl_no	= value_arr[0];
                    }
				}
				if (!color.equals(""))
					slClassValue = color;
				//End of Addition
				if(dscr_map!=null)
				{
  	 				if(dscr_map.size()>1)
					{
						out.println("<tr VALIGN='TOP'><td width='30%'  title = '"+toolTipText+"' class = '"+slClassValue+"'>"+(String)key_value_map2.get(dscr_key)+"</td>");
		 				//out.println("<tr VALIGN='TOP'><td width='30%'  title = '"+toolTipText+"' class = '"+slClassValue+"'><a href='javascript:auditValues(\""+order_id+"\",\""+order_line_num+"\",\""+reporting_date+"\",\""+reporting_practitioner+"\")' title='Tracking Info.'>"+(String)key_value_map2.get(dscr_key)+"</a></td>");
     					i++;
					}
					else
					{
						out.println("<tr VALIGN='TOP'><td width='30%'  title = '"+toolTipText+"'  class = '"+slClassValue+"'><b>"+(String)key_value_map2.get(dscr_key)+"</b></td>");
						//out.println("<tr VALIGN='TOP'><td width='30%'  title = '"+toolTipText+"'  class = '"+slClassValue+"'><b><a href='javascript:auditValues(\""+order_id+"\",\""+order_line_num+"\",\""+reporting_date+"\",\""+reporting_practitioner+"\")' title='Tracking Info.'>"+(String)key_value_map2.get(dscr_key)+"</a></b></td>");
						i++;
					}
				} 
 				itr_times = (Iterator)all_times_set.iterator() ;
 				if(itr_times!=null)
				{
					while(itr_times.hasNext())
					{//Iterate Time values of header
						hdr_time = (String)itr_times.next();
						obj = time_val_map.get(hdr_time);
						if(obj != null)
						{//this has values in the array
							String value_arr[] = (String[]) obj;
							normalcy_ind_disp	= "";
							normalcy_ind 		= value_arr[15];
							if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(crit_str) || normalcy_ind.equalsIgnoreCase(crit_high_str) || normalcy_ind.equalsIgnoreCase(crit_low_str) ))
								normalcy_ind_disp = "<FONT COLOR='MAGENTA'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalAbnormal.label","or_labels")+"</FONT>";
							else if(normalcy_ind != null)
								normalcy_ind_disp = "<FONT COLOR='RED' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"</b></FONT>";
							result_str = value_arr[7]; 
							if(result_str == null) result_str = "";

							if((value_arr[20].trim()).equals("NUM"))
							{
								out.println("<td title = '"+toolTipText+"' width='70%' class = '"+slClassValue+"'> <font size=1> ");
								out.println(CommonBean.checkForNull(value_arr[5]));
								if(!CommonBean.checkForNull(value_arr[6]).equals(""))
								   out.println(""+value_arr[6]);
								out.println(""+normalcy_ind_disp);
								if(!((CommonBean.checkForNull(value_arr[11]).trim()).equals("") || (CommonBean.checkForNull(value_arr[12]).trim()).equals("") ))
								{
									out.println("("+CommonBean.checkForNull(value_arr[11])+" - "+ CommonBean.checkForNull(value_arr[12])+")");
								}
 
 						   if(result_str!=null && !result_str.equals(""))
						   {
						   
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(result_str));
            _bw.write(_wl_block12Bytes, _wl_block12);

							}
 							if( value_arr[8] != null && (!(value_arr[8].equals(""))) )
							{
								bean.setClobData(value_arr[8], key_value);
								out.println("<br><br>");
						
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(toolTipTextArea));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(key_value));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(CommonBean.checkForNull(value_arr[8])));
            _bw.write(_wl_block17Bytes, _wl_block17);

							}
						}
						else if((value_arr[20].trim()).equals("TXT"))
						{
 							out.println("<td title = '"+toolTipText+"' width='70%' class = '"+slClassValue+"'> <font size=1>");
 							if(value_arr[7] != null && (!(value_arr[7].equals(""))) )
							{
						
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(CommonBean.checkForNull(value_arr[7])));
            _bw.write(_wl_block20Bytes, _wl_block20);
 }
 
						  if(  value_arr[8] != null && (!(value_arr[8].equals(""))))
						  {
								bean.setClobData(value_arr[8], key_value);
						
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(toolTipTextArea));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(key_value));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(value_arr[8]));
            _bw.write(_wl_block20Bytes, _wl_block20);
 } 
						}
						else
						{
								out.println("<td title = '"+toolTipText+"' width='70%' class = '"+slClassValue+"' > <font size=1>");
								if( value_arr[7] != null && (!(value_arr[7].equals(""))) )
								{
							
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(CommonBean.checkForNull(value_arr[7])));
            _bw.write(_wl_block23Bytes, _wl_block23);

								}
								if((!(value_arr[8].equals(""))) && value_arr[8] != null )
								{
										bean.setClobData(value_arr[8], key_value);
							
									if(!(value_arr[20].trim()).equals("HTM"))
									{
									
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(toolTipTextArea));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(key_value));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(CommonBean.checkForNull(value_arr[8])));
            _bw.write(_wl_block25Bytes, _wl_block25);

									}
									else
									{
										
										String txt= CommonBean.checkForNull(value_arr[8]);
									//if(txt.indexOf("</ADDRESS></table>") != -1)
									//	txt = txt.replaceAll("</ADDRESS></table>","</ADDRESS>");
										if(txt.indexOf("</TD></TR><tr><td></td></tr></table>") != -1)
											txt = txt.replaceAll("</TD></TR><tr><td></td></tr></table>","");
											
											out.println(txt);

											//out.println(CommonBean.checkForNull(value_arr[8]));
										
									}
									
            _bw.write(_wl_block26Bytes, _wl_block26);
  } 
            _bw.write(_wl_block27Bytes, _wl_block27);
	}
 					if(!(value_arr[20].trim()).equals("NUM")) 
					{
 					  
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(normalcy_ind_disp));
            _bw.write(_wl_block9Bytes, _wl_block9);
	
					} 	
					if(value_arr[16] != null)
					{
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(value_arr[16]));
            _bw.write(_wl_block30Bytes, _wl_block30);
	
					}
					if ((ext_image_obj_id != null && (!ext_image_obj_id.equals(""))) && (ext_image_appl_id != null && (!ext_image_appl_id.equals("")))) 
					{
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
}
					else
					{
						out.println("<td title = '"+toolTipText+"' width='70%' class = '"+slClassValue+"'></td>");
					}
				}//end of itr_times.hasNext()
			 } //End of if  itr_times
			}//end of dscr_itr.hasNext()
		//}//end of if dscr_map.size() > 1
		}
		//out.println("<tr><td colspan='"+(panels.size()+1)+"' class='OR_QRYEVENBORDER'></td></tr>");
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(print_details[0]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(print_details[1]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(print_details[2]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(print_details[3]));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(print_details[4]));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(print_details[5]));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(print_details[6]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(report_srl_no));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block44Bytes, _wl_block44);
	} } }
            _bw.write(_wl_block45Bytes, _wl_block45);

		putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
