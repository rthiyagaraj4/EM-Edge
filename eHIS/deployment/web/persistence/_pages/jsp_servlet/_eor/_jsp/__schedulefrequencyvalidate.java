package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import eOR.Common.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __schedulefrequencyvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ScheduleFrequencyValidate.jsp", 1732512670000L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

try
{
	// Dynamic Jsp to populate the List Boxes in Order Entry
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	//String cat_desc="";
	String func_mode 		= request.getParameter( "func_mode" ) ;
	//String localeName=(String)session.getAttribute("LOCALE");
	ArrayList durationTypes = new ArrayList();
	ArrayList durationAppl = new ArrayList();
	ArrayList durationDesc = new ArrayList();	
	if ( func_mode == null || func_mode.equals( "" ) )
		return ;
	String or_bean_id 			= request.getParameter( "bean_id" ) ;
	String or_bean_name 		= request.getParameter( "bean_name" ) ;
	String patient_id = "";
	String encounter_id = "";

	if(or_bean_name.equalsIgnoreCase("ePH.DirectDispensingBean"))
	{
	     patient_id 		= request.getParameter( "patient_id" ) ;
		 encounter_id 		= request.getParameter( "encounter_id" ) ;
	}
	else
	{
		patient_id=(String)session.getValue("Schdpatient_id");
		encounter_id=(String)session.getValue("Schdencounter_id");
	}
	System.out.println("in schedule Frequency Validate 23 querystring"+request.getQueryString());
	//if(or_bean_name.equalsIgnoreCase("ePH.DirectDispensingBean"))
	//{
		or_bean_name = "eOR.OrderEntryBean";
		or_bean_id = "@orderentrybean"+patient_id+encounter_id;
	//}
	System.out.println("or_bean_name="+or_bean_name);
	System.out.println("or_bean_id="+or_bean_id);
	if ( or_bean_id == null || or_bean_id.equals( "" ) || or_bean_name == null || or_bean_name.equals(""))
		return ;

	OrderEntryBean orbean = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request) ;

	//Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
   	hash = (Hashtable)hash.get( "SEARCH" ) ;
   
	
	 if(func_mode.equalsIgnoreCase("REMOVE_SCHEDULE"))	// To remove the Schedule Frequency
	{
		
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean 	= (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
		
		String catalog_code		 = orbean.checkForNull(request.getParameter( "catalog_code" ),"") ;
		String row_value		 = orbean.checkForNull(request.getParameter( "row_value" ),"") ;
		// get the bean
		ArrayList arr_hash_map	 = (ArrayList)orderEntryRecordBean.getOrderFormats("Schedule"+catalog_code, "Schedule"+catalog_code+"_"+row_value); // It will return hashmap
		System.out.println("arr_hash_map 61"+arr_hash_map);
		if(arr_hash_map!= null && arr_hash_map.size() >0)
		{
			// Removing the values from the Bean
			orderEntryRecordBean.removeOrderFormats("Schedule"+catalog_code, "Schedule"+catalog_code+"_"+row_value);
		}
	}
	else if(func_mode.equalsIgnoreCase("REMOVE_FREQUENCY"))	// To remove the Schedule Frequency
	{
		String row_value		 = orbean.checkForNull(request.getParameter( "row_value" ),"") ;
		String catalog_code		 = orbean.checkForNull(request.getParameter( "catalog_code" ),"") ;
		String durn_type		 = orbean.checkForNull(request.getParameter( "durn_type" ),"") ;
		String[] record 		 = null;
		out.println( "clearSchdDurationType('document','document.scheduleFreqencyAddModHeader',\"" +row_value+"\") ; " ) ;
		out.println( "clearSchdDurationList('document','document.scheduleFreqencyAddModHeader',\"" +row_value+"\") ; " ) ;
		ArrayList PlaceOrderDuration=orbean.getPlaceOrderFrequency(catalog_code,"header",durn_type,"","","");
		
		for( int i=0 ; i< PlaceOrderDuration.size() ; i++ ) 
		{
				record 		= (String[])PlaceOrderDuration.get(i);
				out.println( "addSchdDurationTypeList('document.scheduleFreqencyAddModHeader',\""+record[0]+" \",\""+record[1]+"\",\""+row_value+"\") ; " ) ;
		}
		record				= null; // Nullifying the objects
		PlaceOrderDuration		= null; // Nullifying the objects
	}
	else if(func_mode.equalsIgnoreCase("SCHDDURATIONVALUES"))
	{
		String row_value		 = orbean.checkForNull(request.getParameter( "row_value" ),"") ;
		String hdr_duration_type		 = orbean.checkForNull(request.getParameter( "hdr_duration_type" ),"") ;
		//String[] record 		 = null;
		out.println( "clearSchdDurationList('document','document.scheduleFreqencyAddModHeader',\"" +row_value+"\") ; " ) ;
		//ArrayList PlaceOrderDuration=orbean.getPlaceOrderDuration();
	
		durationTypes.add("M");
		durationTypes.add("H");
		durationTypes.add("D");
		durationTypes.add("W");
		durationTypes.add("L");
		durationTypes.add("Y");
		
		for(int d=durationTypes.indexOf(hdr_duration_type);d<durationTypes.size();d++)
		{
			durationAppl.add(durationTypes.get(d));
			durationDesc.add(orbean.decodeLocal((String)durationTypes.get(d)));
		}
				
		for(int dt=0;dt<durationAppl.size();dt++) 
		{
				String durationcode = (String)durationAppl.get(dt);
				String durationdesc = (String)durationDesc.get(dt);
				out.println( "addSchdDurationList('document.scheduleFreqencyAddModHeader',\""+durationcode+" \",\""+durationdesc+"\",\""+row_value+"\") ; " ) ;
		}
	}
	/*else if(func_mode.equalsIgnoreCase("START_DATE"))	// To get the start date of the Schedule Frequency
	{
		System.out.println("116 here it enters");
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean 	= (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
		
		String catalog_code		 = orbean.checkForNull(request.getParameter( "catalog_code" ),"") ;
		String row_value		 = orbean.checkForNull(request.getParameter( "row_value" ),"") ;
		System.out.println("116 here catalog_code"+catalog_code+"row_value"+row_value);
		// get the bean
		ArrayList arr_hash_map	 = (ArrayList)orderEntryRecordBean.getOrderFormats("Schedule"+catalog_code, "Schedule"+catalog_code+"_"+row_value); // It will return hashmap
		System.out.println("arr_hash_map 61"+arr_hash_map);
		String start_date_param = "";
		if(arr_hash_map!= null && arr_hash_map.size() >0)
		{
			HashMap paramMap =(HashMap)arr_hash_map.get(0);
			start_date_param  =(String)paramMap.get("start_date_time");
			out.println( "changeStartDate(\""+start_date_param+" \") ; " ) ;
		}
	}*/
	/*Ends Here*/

	// set it back persistence  (When clinical comments is used ,it is used to set it)
	putObjectInBean(or_bean_id,orbean,request);
}catch(Exception e){
	System.out.println("@@@ Exception in OrderEntryValidate.jsp="+e);
	e.printStackTrace();
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
