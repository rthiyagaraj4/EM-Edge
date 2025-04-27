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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __existingordervalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ExistingOrderValidate.jsp", 1732009550000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        	Rev.Date	Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
?             	100            		?           created
13/08/2014		IN049419		Ramesh G			?			?			An Audit Trail for Additional Information Amendment of Order
14/10/2019    	IN071315	    Nijitha S   	14/10/2019  Ramesh G		GHL-CRF-0607
06/07/2020	  	IN072654		Nijitha S	06/07/2020	Ramesh G	MMS-KH-CRF-0029.4
04/08/2020		IN073562		Nijitha S	04/08/2020	Remesh G	MMS-KH-CRF-0029.4/01
---------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
  

    	request.setCharacterEncoding("UTF-8");

	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
    String localeName=request.getParameter("localeName");
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	//ExistingOrder beanObj = (ExistingOrder)mh.getBeanObject( bean_id, request , "eOR.ExistingOrder") ;
	ExistingOrder beanObj = (ExistingOrder)getBeanObject( bean_id, "eOR.ExistingOrder", request ) ;
    beanObj.setLanguageId(localeName);
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	/*if ( validate.equals( "ord_cat" ) ) {
		String order_category = (String)hash.get("order_category") ;
		out.println( "clearList('document') ; " ) ;

		ArrayList OrderTypeData = beanObj.getOrderTypeData(order_category) ;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			String[] record = (String[])OrderTypeData.get(i);
			out.println( "addOrderTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}

		out.println( "clearActivityList('document') ; " ) ;

		ArrayList ActivityTypeData = beanObj.getActivityType(order_category, "") ;
		for( int i=0 ; i< ActivityTypeData.size() ; i++ ) {
			String[] record = (String[])ActivityTypeData.get(i);
			out.println( "addActivityTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}

	} else if ( validate.equals( "order_type" ) ) {
		String order_category = (String)hash.get("order_category") ;
		String order_type	 = (String)hash.get("order_type") ;
		out.println( "clearActivityList('document') ; " ) ;

		ArrayList ActivityTypeData = beanObj.getActivityType(order_category, order_type) ;
		for( int i=0 ; i< ActivityTypeData.size() ; i++ ) {
			String[] record = (String[])ActivityTypeData.get(i);
			out.println( "addActivityTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	} else if (validate.equals("viewBill")) {
		String parent_order_id 			= request.getParameter("parent_order_id");
		String parent_order_line_num 	= request.getParameter("parent_order_line_num");
		String ordering_facility_id 	= request.getParameter("ordering_facility_id");
		//String function_from 			= request.getParameter("function_from");
		String catalog_code				= request.getParameter("catalog_code");
		String catalog_desc				= request.getParameter("catalog_desc");

		ArrayList BillChargeInfo		= beanObj.getBillChargeDetails(parent_order_id,parent_order_line_num,ordering_facility_id) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
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
	} else 
	*/	if (validate.equals("ACTIVATE_ORDER")) {
		//boolean flagContinue	= true;
		String flagContinue		= "Y";
		String[] encounterValues = new String[2];
		String error		= "";
		int count				= Integer.parseInt(beanObj.checkForNull((String)hash.get("count"),"0"));
		String encounter_id			= (String)hash.get("encounter_id");
		String p_called_from_ca = (String)hash.get("p_called_from_ca");//IN071315
		String order_id				= "", order_line_num	= "";
		String old_encounter_id	= "";
		String old_episode_id	= "";
		String old_visit_num	= "";
		String old_source_type	= "";
		String old_source_code	= "";
		ArrayList encounterDetails = null;

		for (int j = 0;j < count;j++) {
			 order_id 		= (String)hash.get("order_id"+j);
			//String order_category	= (String)hash.get("order_category"+j);
			//String order_type_code	= (String)hash.get("order_type_code"+j);
			//String catalog_code		= (String)(beanObj.checkForNull((String)hash.get("catalog_code"+j),"0"));
			order_line_num	= (String)(beanObj.checkForNull((String)hash.get("order_line_num"+j),"1"));

			 old_encounter_id	= "";
			 old_episode_id	= "";
			 old_visit_num	= "";
			 old_source_type	= "";
			 old_source_code	= "";

			 encounterDetails = beanObj.getEncounterDetails(order_id);

			if (encounterDetails != null && encounterDetails.size() > 0) {
				for (int index = 0;index < encounterDetails.size(); index++) {
					String[] record		= (String[])encounterDetails.get(index);

					if (encounter_id.equals(record[0])) {
						//flagContinue = false;
						flagContinue = "N";
						break;
					}
					old_encounter_id	= beanObj.checkForNull(record[0],"");
					old_episode_id		= beanObj.checkForNull(record[1],"");
					old_visit_num		= beanObj.checkForNull(record[2],"");
					old_source_type		= beanObj.checkForNull(record[3],"");
					old_source_code		= beanObj.checkForNull(record[4],"");
					//error = (old_encounter_id+","+old_episode_id+","+old_visit_num+","+old_source_type+","+old_source_code);
				}

				//if (!flagContinue) {
				if (!flagContinue.equals("Y")) {
					error=("APP-OR0265 Orders cannot be Activated to the Current Encounter");
					//out.println("alert('"+error+"')");
					break;
				} else {
					//flagContinue = beanObj.updateEncounterDetails(encounter_id,old_encounter_id,old_episode_id,old_visit_num,old_source_type,old_source_code,order_id,order_line_num);
					//encounterValues = beanObj.updateEncounterDetails(encounter_id,old_encounter_id,old_episode_id,old_visit_num,old_source_type,old_source_code,order_id,order_line_num);
					encounterValues = beanObj.updateEncounterDetails(encounter_id,old_encounter_id,old_episode_id,old_visit_num,old_source_type,old_source_code,order_id,order_line_num,p_called_from_ca);//IN071315
					flagContinue	 = encounterValues[0];
					error			 = encounterValues[1];
  					if(error==null) error="";
					if(flagContinue==null) flagContinue="N";
					//out.println("alert('"+flagContinue+"')");
				}
			}
		}
		if (flagContinue.equals("Y") && (error.equals(""))) {
			error = ("APP-OR0264 Orders have been Activated to the Current Encounter");
		}
		out.println("alert('"+error+"')");
	}
	else if ((validate.equalsIgnoreCase("ViewReplacedOrder"))||(validate.equalsIgnoreCase("ViewOriginalOrder"))) 
	{
		String orderId = "";
		orderId = (String)hash.get("orderId");
		orderId = (String)beanObj.getOrderID(orderId,validate);
		out.println(orderId);
	}
	//IN049419 Start.
	else if("AMMEND".equals(validate)){
		String suditTrailsDtls =(String)beanObj.getOrderFormatAuditTrailDtls();
		out.println(suditTrailsDtls);
	}
	else if("InteractionDtls".equals(validate)){
		//IN072654 Starts
		HashMap<String,String> tempMap = new HashMap<String,String>();
		HashMap<String, ArrayList<OrderDrugInteractionVO>> dtlsTemp = new HashMap<String, ArrayList<OrderDrugInteractionVO>>();
		beanObj.setDruginteractionYN(tempMap);
		beanObj.setDruginteractionDtl(dtlsTemp);
		//IN072654 Ends
		String orderId = "";
		orderId = (String)hash.get("orderId");
		String catalogCode = (String)hash.get("catalog_code");
		String order_line_num = (String)hash.get("order_line_num");
		//IN073562 Starts
		String patient_id = (String)hash.get("patient_id");
		String encounter_id = (String)hash.get("encounter_id");
		beanObj.setPatientId(patient_id);
		beanObj.setEncntrId(encounter_id);
		//IN073562 Ends
		if(null==order_line_num || "".equals(order_line_num))
			beanObj.getDrugInteractionDtls(catalogCode,orderId,"H","");
		else
			beanObj.getDrugInteractionDtls(catalogCode,orderId,"L",order_line_num);
		out.println("");
	}
	// IN049419 End.
	 putObjectInBean(bean_id,beanObj,request);

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
