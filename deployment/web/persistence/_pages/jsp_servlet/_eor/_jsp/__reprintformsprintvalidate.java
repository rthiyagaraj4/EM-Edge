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

public final class __reprintformsprintvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ReprintFormsPrintValidate.jsp", 1732515386000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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



String checkForNull( String inputString, String defaultValue ) {
	return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
}
String checkForNull( String inputString ) {
        return ( inputString == null )  ?   ""  :   inputString;
}


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

	request.setCharacterEncoding("UTF-8");

    Hashtable allValues = (Hashtable)XMLobj.parseXMLString( request ) ;
    allValues = (Hashtable)allValues.get( "SEARCH" ) ;
	String report_type="";
	String login_facility_id="";
	if(allValues.containsKey("report_type"))
	{
		report_type = ((String)allValues.get("report_type"));
	}
	//System.out.println("===========ReprintFormsPrintValidate===================="+report_type);
	//HashMap map = new HashMap() ;
	Hashtable tabDataPrint 	= new Hashtable();
	//OnLinePrinting online_print = new OnLinePrinting(request,response);
	OnLinePrinting online_print = new OnLinePrinting();
	//System.out.println("Before On Line Printing" + online_print);
	// one parameter is to print the order form , another paramater is to print the consent forms
	if (!report_type.equalsIgnoreCase("L")) {
		//Hashtable tabDataPrint 	= new Hashtable();
		int tot_recs	= 0;
		for (int i = 0; i < Integer.parseInt(checkForNull((String)allValues.get("total_recs"),"0"));i++) {
			String checked = checkForNull((String)allValues.get("chk"+i));
			if (checked.equalsIgnoreCase("Y")) {

				tabDataPrint.put("ord_id"+tot_recs,checkForNull((String)allValues.get("ord_id"+i)));
				tabDataPrint.put("order_id"+tot_recs,checkForNull((String)allValues.get("ord_id"+i)));
				tabDataPrint.put("order_category"+tot_recs,checkForNull((String)allValues.get("ord_cat"+i)));
				//System.out.println("order_category"+tot_recs+":="+checkForNull((String)allValues.get("ord_cat"+i)));
				tabDataPrint.put("patient_class"+tot_recs,checkForNull((String)allValues.get("pat_class"+i)));
				tabDataPrint.put("pat_id"+tot_recs,checkForNull((String)allValues.get("pat_id"+i)));
				tabDataPrint.put("patient_id"+tot_recs,checkForNull((String)allValues.get("pat_id"+i)));
				tabDataPrint.put("encounter_id"+tot_recs,checkForNull((String)allValues.get("encounter_id"+i)));
				tabDataPrint.put("order_date_time"+tot_recs,checkForNull((String)allValues.get("order_date_time"+i)));
				tabDataPrint.put("catalog_code"+tot_recs,checkForNull((String)allValues.get("catalog_code"+i)));
				tabDataPrint.put("priority"+tot_recs,checkForNull((String)allValues.get("priority"+i)));
				tabDataPrint.put("ord_typ_code"+tot_recs,checkForNull((String)allValues.get("order_type"+i)));
				tabDataPrint.put("order_type_code"+tot_recs,checkForNull((String)allValues.get("order_type"+i)));
				tabDataPrint.put("ord_typ_desc"+tot_recs,checkForNull((String)allValues.get("order_type_desc"+i)));
				tabDataPrint.put("ord_pract_id"+tot_recs,checkForNull((String)allValues.get("ord_pract_id"+i)));
				tabDataPrint.put("order_status"+tot_recs,checkForNull((String)allValues.get("order_status"+i)));
				tabDataPrint.put("order_line_num"+tot_recs,checkForNull((String)allValues.get("order_line_num"+i)));
				tabDataPrint.put("cont_order_ind"+tot_recs,checkForNull((String)allValues.get("cont_order_ind"+i)));
				tabDataPrint.put("facility_id"+tot_recs,checkForNull((String)allValues.get("facility_id"+i)));
				tabDataPrint.put("location_type"+tot_recs,checkForNull((String)allValues.get("location_type"+i)));
				tabDataPrint.put("source_type"+tot_recs,checkForNull((String)allValues.get("location_type"+i)));
				tabDataPrint.put("location_code"+tot_recs,checkForNull((String)allValues.get("location_code"+i)));
				tabDataPrint.put("source_code"+tot_recs,checkForNull((String)allValues.get("location_code"+i)));
				tabDataPrint.put("report_srl_no"+tot_recs,checkForNull((String)allValues.get("report_srl_no"+i)));
				tabDataPrint.put("srl_no"+tot_recs,checkForNull((String)allValues.get("report_srl_no"+i)));

				tabDataPrint.put("chk"+tot_recs,checkForNull((String)allValues.get("chk"+i)));
				tot_recs++;
			}
		}
		tabDataPrint.put("facility_id",login_facility_id);
		tabDataPrint.put("source_type",checkForNull((String)allValues.get("source_type1")));
		tabDataPrint.put("total_recs",""+tot_recs);
		tabDataPrint.put("total_records",""+tot_recs);
		//System.out.println("REPRINT:tot_recs:"+tot_recs);
	}
	if (report_type.equalsIgnoreCase("C")) {
		online_print.callConsentFormOnlineRePrint(tabDataPrint,request,response);
		//online_print.callConsentFormOnlinePrint(allValues); //Pass the Hashtable print_values (Stored in generateUniqueIds() )
	} else if (report_type.equalsIgnoreCase("O")) {
		//allValues.put("order_entry","OrderEntry");
		tabDataPrint.put("order_entry","ExistingOrder");
		online_print.callOnlineRePrint(tabDataPrint,request,response);
		//online_print.callOnlinePrint(allValues); //Pass the Hashtable print_values (Stored in generateUniqueIds() )
	} else if (report_type.equalsIgnoreCase("R")) {
		Hashtable repDataPrint 	= new Hashtable();
		for (int i = 0; i < Integer.parseInt(checkForNull((String)tabDataPrint.get("total_records"),"0"));i++) {
			repDataPrint.clear();
			repDataPrint.put("facility_id",checkForNull((String)tabDataPrint.get("facility_id"+i)));//IN070426
			repDataPrint.put("source_type",checkForNull((String)tabDataPrint.get("source_type1")));
			repDataPrint.put("ord_typ_code",checkForNull((String)tabDataPrint.get("ord_typ_code"+i)));
			repDataPrint.put("patient_class",checkForNull((String)tabDataPrint.get("patient_class"+i)));
			repDataPrint.put("priority",checkForNull((String)tabDataPrint.get("priority"+i)));
			repDataPrint.put("ord_id",checkForNull((String)tabDataPrint.get("ord_id"+i)));
			repDataPrint.put("location_code",checkForNull((String)tabDataPrint.get("location_code"+i)));
			repDataPrint.put("report_srl_no",checkForNull((String)tabDataPrint.get("report_srl_no"+i)));
			repDataPrint.put("location_type",checkForNull((String)tabDataPrint.get("location_type"+i)));//IN070426
			online_print.reprintResultEntryReport(repDataPrint,request,response); //Pass the Hashtable print_values (Stored in generateUniqueIds() )
		}
		//online_print.printResultEntryReport(allValues); //Pass the Hashtable print_values (Stored in generateUniqueIds() )
	} else if (report_type.equalsIgnoreCase("L")) {
		//Hashtable tabDataPrint 	= new Hashtable();

		tabDataPrint.put( "total_recs" ,"1");
		tabDataPrint.put("facility_id",login_facility_id);
		tabDataPrint.put("collection_list","");
		tabDataPrint.put("printLocationType",checkForNull((String)allValues.get("source_type1")));
		tabDataPrint.put("printLocation",checkForNull((String)allValues.get("location_code")));

		tabDataPrint.put("date_from",checkForNull((String)allValues.get("date_from")));
		tabDataPrint.put("date_to",checkForNull((String)allValues.get("date_to")));
		tabDataPrint.put("priority","A");
		tabDataPrint.put("location_type",checkForNull((String)allValues.get("location_type")));
		tabDataPrint.put("locn",checkForNull((String)allValues.get("locn2")));
		tabDataPrint.put("locn1",checkForNull((String)allValues.get("locn1")));
		tabDataPrint.put("order_type",checkForNull((String)allValues.get("order_type")));
		tabDataPrint.put("order_type1",checkForNull((String)allValues.get("order_type")));
		tabDataPrint.put("option","R");
		tabDataPrint.put("select_specific_order","A");
		tabDataPrint.put("patientId",checkForNull((String)allValues.get("patient_id")));
		tabDataPrint.put("order_id",checkForNull((String)allValues.get("order_id")));
		tabDataPrint.put("encounter_id",checkForNull((String)allValues.get("encntr_id")));
		online_print.callSpecimenCollectOnLinePrint(tabDataPrint,request,response);
	}else if (report_type.equalsIgnoreCase("X"))
	{
		online_print.callReferralFormOnlinePrint(tabDataPrint,request,response);
	}
	else if (report_type.equalsIgnoreCase("S"))
	{
		online_print.callRefusalFormOnlinePrint(tabDataPrint,request,response);
	}
	//System.out.println("==============================="+map);
   

            _bw.write(_wl_block1Bytes, _wl_block1);
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
