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

public final class __orderentryvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryValidate.jsp", 1721997598000L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            eOR.OrderEntryQueryBean beanQueryObj= null;{
                beanQueryObj=(eOR.OrderEntryQueryBean)pageContext.getAttribute("beanQueryObj");
                if(beanQueryObj==null){
                    beanQueryObj=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("beanQueryObj",beanQueryObj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            eOR.ScheduleFrequencyCompBean OrScheduleFreq= null;{
                OrScheduleFreq=(eOR.ScheduleFrequencyCompBean)pageContext.getAttribute("OrScheduleFreq");
                if(OrScheduleFreq==null){
                    OrScheduleFreq=new eOR.ScheduleFrequencyCompBean();
                    pageContext.setAttribute("OrScheduleFreq",OrScheduleFreq);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            eBL.BLReportIdMapper blBeanObj= null;{
                blBeanObj=(eBL.BLReportIdMapper)pageContext.getAttribute("blBeanObj");
                if(blBeanObj==null){
                    blBeanObj=new eBL.BLReportIdMapper();
                    pageContext.setAttribute("blBeanObj",blBeanObj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
22/6/2011     101            Chowminya      Incident No: IN027797 - <Clinical comments, order format not shown in 
																	the view mode> 
13/08/2013	  IN042045		 Chowminya G	System should not allow to copy for the drugs for which Verbal Order Applicable is not selected	
28/11/2013    IN045080       Chowminya      Placing order same service with multiple times - price not changed from single to multiple
06/01/2014	  IN044014		 Chowminya		System is not defaulting the Department if users selecting the performing location
24/01/2014	  IN046592		 Ramesh G		Manage Specimen is taking more than 40 seconds to complete after clicking on Record 
								     		when multiple records are selected. The response time is very slow.
22/04/2014    IN042962		 Chowminya      CRF:Print Order Sheet From Existing Orders		
06/05/2014    IN048942		 Chowminya      Performing Location and wing code defaulting issue				
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
30/11/2016	  	IN062319	     	Karthi L 											ML-MMOH-CRF-0508.1 [IN062319] 
27/06/2017  	IN064614	Vijayakumar K		27/06/2017		Ramesh G		CRF-OR-GHL-CRF-0445.1/03 - Unable to place order if report server is down / having issue. [IN:064614]
10/11/2017	IN061906	Kamalakannan G	 	10/11/2017		Ramesh G			ML-MMOH-CRF-0548
15/12/2017	IN065942		Dinesh T			15/12/2017		Ramesh G		In Nuclear medicine  department we required the 																				barcode functionality at the time of 																						Registration of order,required patient 																						Id,patient name,age,sex,register date and name 																				of study.
05/02/2020	IN068314	Nijitha S	05/02/2020	Ramesh G	ML-MMOH-CRF-1229
25/06/2020	IN073309	Nijitha S     		25/06/2020		Ramesh G		ML-MMOH-CRF-1229.2/02
29/10/2020	IN073712		Nijitha S     	29/10/2020		Ramesh G		ML-MMOH-CRF-1229.3
22/12/2020	10503		Nijitha S	22/12/2020	Ramesh G	ML-MMOH-CRF1229.4
--------------------------------------------------------------------------------------------------------------
*/
try{
	// Dynamic Jsp to populate the List Boxes in Order Entry
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String cat_desc="";
	String bean_id 			= request.getParameter( "bean_id" ) ;
	String bean_name 		= request.getParameter( "bean_name" ) ;
	String func_mode 		= request.getParameter( "func_mode" ) ;
	String term_code 		= request.getParameter( "term_code" ) ;
	String localeName=(String)session.getAttribute("LOCALE");
	ArrayList durationTypes = new ArrayList();
	ArrayList durationAppl = new ArrayList();
	ArrayList durationDesc = new ArrayList();
	
	if ( bean_id == null || bean_id.equals( "" ) || bean_name == null || bean_name.equals(""))
		return ;

	if ( func_mode == null || func_mode.equals( "" ) )
		return ;

	/* Initialize Function specific start */
	//OrderEntryBean beanObj = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);
	OrScheduleFreq.setLanguageId(localeName);
	OrderEntryBean beanObj = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	beanObj.setLanguageId(localeName);
	/* Initialize Function specific end */

	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
   	String pract_type 	 = beanObj.checkForNull((String)hash.get("practitioner_type"),"") ;//IN042045
	String order_category_yn= beanObj.checkForNull(request.getParameter( "order_category_yn" ),"") ;
	String p_catalog_code  	 = beanObj.checkForNull((String)hash.get("p_catalog_code"),"") ;//IN042045
   	//String order_type_yn= beanObj.checkForNull(request.getParameter( "order_type_yn" ),"") ;
	// This is called from the Additional Search Screens func_mode.equals("ORDER_TYPE_POPULATE")
   	// This is called from the Tick Sheet Screens func_mode.equals("TICK_SHEET_ORDER_TYPE_POPULATE")
   	// Also called from the Care Set Search Screens func_mode.equals("CARE_SET_ORDER_TYPE_POPULATE")
   	// It can also be called from the Image Screen to populate the order_type
	// When changed the order_type in the additional_search or tick_sheet or care-set or in image,  
	// the func_mode will be ACTIVITY_TYPE_POPULATE

	if ( func_mode.equals("ORDER_TYPE_POPULATE") || func_mode.equals("TICK_SHEET_ORDER_TYPE_POPULATE") || func_mode.equalsIgnoreCase("IMAGE_ORDER_TYPE_POPULATE") || func_mode.equalsIgnoreCase("CARE_SET_ORDER_TYPE_POPULATE") || func_mode.equals("TICK_SHEET_POPULATE"))  //To populate the Order_type list box & tick sheet
	{
		String order_category 	 = beanObj.checkForNull((String)hash.get("order_category"),"") ;
		//String order_type_code 	 = beanObj.checkForNull((String)hash.get("order_type_code"),"") ;
 		String activity_type 	 = beanObj.checkForNull((String)hash.get("activity_type"),"") ;
		String pre_sel_order_type_yn = "N";
		//String pop_tick_sheet    = beanObj.checkForNull(request.getParameter("pop_tick_sheet"),"") ;
		String[] record 		 = null;
		
		   pre_sel_order_type_yn = beanObj.getPreOrderType(order_category) ;
		
		// Set the order_type_yn
		beanObj.setOrderTypeCodeYn(pre_sel_order_type_yn);
		if ( func_mode.equals("ORDER_TYPE_POPULATE"))
		{
			out.println( "setOrderType('addlSearchCriteriaForm',\"" + pre_sel_order_type_yn + "\") ; " ) ;
		}
		else if ( func_mode.equals("TICK_SHEET_ORDER_TYPE_POPULATE"))
		{
			out.println( "setOrderType('tickSheetForm',\"" + pre_sel_order_type_yn + "\") ; " ) ;
		}
		else if ( func_mode.equals("IMAGE_ORDER_TYPE_POPULATE"))
		{
			out.println( "setOrderType('imageSearchForm',\"" + pre_sel_order_type_yn + "\") ; " ) ;
		}
		else if ( func_mode.equals("CARE_SET_ORDER_TYPE_POPULATE"))
		{
			out.println( "setOrderType('careSetSearchForm',\"" + pre_sel_order_type_yn + "\") ; " ) ;
			out.println( "clearCareSetList('document','document.careSetSearchForm') ; " ) ;
		}
		// If it is coming from the Care Sets Search Screen
		if ( func_mode.equals("CARE_SET_ORDER_TYPE_POPULATE"))	// When from the Care Set Search Screen
		{
			String order_type_code 	 = beanObj.checkForNull((String)hash.get("order_type_code"),"") ;
			ArrayList CareSets = beanObj.getCareSets(order_category,"","",activity_type,order_type_code) ; // Calling the bean method, pass the diagnosis as '' and pass the activity type as ""
			for( int i=0 ; i< CareSets.size() ; i++ ) 
			{
				record = (String[])CareSets.get(i);
				out.println( "addCareSetList('document.careSetSearchForm',\""+record[0]+"::"+record[2]+" \",\"" +record[1]+"\") ; " ) ;
			} // End of For
			out.println( "DefaultCareSetList('document.careSetSearchForm') ; " ) ;
			record				= null; // Nullifying the objects
		}

		if ( func_mode.equals("TICK_SHEET_ORDER_TYPE_POPULATE") || func_mode.equals("TICK_SHEET_POPULATE"))
		{
		    String display_ticksheet = "Y";
			out.println( "clearList('document') ; " ) ;
			if(order_category.equals(""))
			{
				if(order_category_yn.equals("Y"))
					display_ticksheet = "N";
			}
			if(display_ticksheet.equals("Y"))
			{
				ArrayList TickSheet = beanObj.getTickSheet(order_category) ; // Calling the bean method to populate the tick sheets
				for( int i=0 ; i< TickSheet.size() ; i++ ) {
						record = (String[])TickSheet.get(i);
						out.println( "addList(\"" +record[0]+" \",\"" +record[1]+"\") ; " ) ;
				}
				if(TickSheet.size() > 0)
				{
					//out.println( "storeValues('','tickSheetItemsForm') ; " ) ;					
				}else
				{
					out.println( "clearList('document') ; " ) ;
				}
				out.println( "popTickSheetValues(document.tickSheetForm.tick_sheet_id) ; " ) ;
				record				= null; // Nullifying the objects
				TickSheet			= null; // Nullifying the objects
			}
		}
 	}
	else if (func_mode.equalsIgnoreCase("CARE_SET_POPULATE"))  // From the Care Set tab on change of the diagnosis to populate the care sets
	{
			String order_category 	= beanObj.checkForNull((String)hash.get("order_category"),"") ;
			String diagnosis 		= beanObj.checkForNull((String)hash.get("orderable_text_id"),"") ; // For Diagnosis
			String activity_type 	= beanObj.checkForNull((String)hash.get("activity_type"),"") ; 
			String diag_code_scheme 	= beanObj.checkForNull((String)hash.get("diag_code_scheme"),"") ; 
			String order_type_code 	= beanObj.checkForNull((String)hash.get("order_type_code"),"") ; 
			ArrayList CareSets 		= beanObj.getCareSets(order_category,diagnosis,diag_code_scheme,activity_type,order_type_code) ; // Calling the bean method, pass the order_category and diagnosis
			String[] record 		= null;
			for( int i=0 ; i< CareSets.size() ; i++ ) {
				record = (String[])CareSets.get(i);
				out.println( "addCareSetList('document.careSetSearchForm',\"" +record[0]+"::"+record[2]+" \",\"" +record[1]+"\") ; " ) ;
			} // End of For
			out.println( "DefaultCareSetList('document.careSetSearchForm') ; " ) ;

			record				= null;		// Nullifying the objects
 			CareSets			= null;		// Nullifying the objects
	}
	 else if(func_mode.equalsIgnoreCase("DIAGNOSIS_TEXT_POPULATE")) // For Care Sets Diagnosis text Population
	{
		// Only one record will be there
			String orderable_text_id= beanObj.checkForNull(request.getParameter( "orderable_text_id" ),"") ;
			String diag_desc		= beanObj.getDiagnosisDesc(orderable_text_id) ;
			if(diag_desc!=null)
				out.println( "addCareSetDiagnosisDesc('document.careSetSearchForm',\"" +diag_desc+" \") ; " ) ;
	}
	else if ( func_mode.equalsIgnoreCase("Amend_Clinical_Comments"))  // For Setting the value in the bean for Amend Clincial Comments
	{
		//---[101]/Modified start---
		String order_category			= beanObj.checkForNull(request.getParameter( "order_category" ),"") ;
		String field_name				= beanObj.checkForNull(request.getParameter( "field_name" ),"") ;
		// Method called in the bean to set the Clob value inthe bean
		StringBuffer clinical_comments = new StringBuffer();
		String cmts						= (String)hash.get(field_name);
		//---[101]/Modified end---
		if(cmts.indexOf("\"")!=-1)
		 cmts							= cmts.replace('"','\n');

		clinical_comments.append(cmts);
		beanObj.setAmendClinicalComments(clinical_comments);
		// get the bean
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) beanObj.getOrderEntryRecordBean();
		// If it is a new patient set it, other wise get the patient id
		//orderEntryRecordBean.getPatient(beanObj.getPatientId());
   		/* Initialize Function specific start */
		// Setting the Clinical comments for Amend and New Order, even if it is null
		if(clinical_comments!=null){
		orderEntryRecordBean.setOrderFormats(order_category+"_CLINICALCOMMENTS", (order_category+"_CLINICALCOMMENTS_0"),clinical_comments);
		}
		
	}
	else if ( func_mode.equalsIgnoreCase("Clinical_Comments"))  // For Setting the value in the bean for Clincial Comments, just to display it back
	{
		String order_category			= beanObj.checkForNull(request.getParameter( "order_category" ),"") ;
		String field_name				= beanObj.checkForNull(request.getParameter( "field_name" ),"") ;
		String combined_order_category	= beanObj.checkForNull(request.getParameter( "order_cat" ),"") ; // For Preview Only
		StringBuffer comments		 	= new StringBuffer();
		if(!combined_order_category.equals("")){ // Only for Preview
			combined_order_category		=  beanObj.checkForNull(combined_order_category.substring(0, combined_order_category.length()-1),""); // Remove the last (,) comma
		} // End of !combined_order_category  (Only for Preview)

		StringBuffer clin_comments 	= new StringBuffer();
		String cmts					= (String)hash.get(field_name);
		if(cmts.indexOf("\"")!=-1)
			 cmts					= cmts.replace('"','\n');
		clin_comments.append(cmts);

		// get the bean
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) beanObj.getOrderEntryRecordBean();
	  	// If it is a new patient set it, other wise get the patient id
		//orderEntryRecordBean.getPatient(beanObj.getPatientId());
   		/* Initialize Function specific start */
		// Setting the Clinical comments for New order and Care sets into the bean

		if(clin_comments!=null)
			orderEntryRecordBean.setOrderFormats(order_category+"_CLINICALCOMMENTS", (order_category+"_CLINICALCOMMENTS_0"),clin_comments);
		//Only for Preview
		if(!combined_order_category.equals("") && clin_comments!=null ) {
			StringTokenizer  stArr	= new StringTokenizer(combined_order_category,",");
			while(stArr.hasMoreTokens())
			{
				order_category = stArr.nextToken();
				comments	   = (StringBuffer)orderEntryRecordBean.getOrderFormats(order_category+"_CLINICALCOMMENTS",order_category+"_CLINICALCOMMENTS_0"); // Get from the bean, if it is not ther copy, otherwise no need
				if(comments==null || comments.length()==0 )
					orderEntryRecordBean.setOrderFormats(order_category+"_CLINICALCOMMENTS", (order_category+"_CLINICALCOMMENTS_0"),clin_comments); // Set for each category(copying for other categories)
			}


         //if(clin_comments!=null)
			//orderEntryRecordBean.setOrderFormats(order_category+"_CLINICALCOMMENTS", (order_category+"_CLINICALCOMMENTS_0"),clin_comments);

		}	// End of if //Only for Preview
		
	} // End of else Clinical_comments
	else if(func_mode.equalsIgnoreCase("REMOVE_SCHEDULE"))	// To remove the Schedule Frequency
	{
		String catalog_code		 = beanQueryObj.checkForNull(request.getParameter( "catalog_code" ),"") ;
		String row_value		 = beanQueryObj.checkForNull(request.getParameter( "row_value" ),"") ;
		// get the bean
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) beanObj.getOrderEntryRecordBean();
	  	// If it is a new patient set it, other wise get the patient id
		//orderEntryRecordBean.getPatient(beanObj.getPatientId());
   		/* Initialize Function specific start */
		ArrayList arr_hash_map	 = (ArrayList)orderEntryRecordBean.getOrderFormats("Schedule"+catalog_code, "Schedule"+catalog_code+"_"+row_value); // It will return hashmap
		if(arr_hash_map!= null && arr_hash_map.size() >0)
		{
			// Removing the values from the Bean
			orderEntryRecordBean.removeOrderFormats("Schedule"+catalog_code, "Schedule"+catalog_code+"_"+row_value);
		}
	}
	else if(func_mode.equalsIgnoreCase("REMOVE_FREQUENCY"))	// To remove the Schedule Frequency
	{
		String row_value		 = beanObj.checkForNull(request.getParameter( "row_value" ),"") ;
		String catalog_code		 = beanObj.checkForNull(request.getParameter( "catalog_code" ),"") ;
		String durn_type		 = beanObj.checkForNull(request.getParameter( "durn_type" ),"") ;
		String[] record 		 = null;
		out.println( "clearSchdDurationType('document','document.scheduleFreqencyAddModHeader',\"" +row_value+"\") ; " ) ;
		out.println( "clearSchdDurationList('document','document.scheduleFreqencyAddModHeader',\"" +row_value+"\") ; " ) ;
		ArrayList PlaceOrderDuration=beanObj.getPlaceOrderFrequency(catalog_code,"header",durn_type,"","","");
		
		for( int i=0 ; i< PlaceOrderDuration.size() ; i++ ) 
		{
				record 		= (String[])PlaceOrderDuration.get(i);
				out.println( "addSchdDurationTypeList('document.scheduleFreqencyAddModHeader',\""+record[0]+" \",\""+record[1]+"\",\""+row_value+"\") ; " ) ;
		}
		record				= null; // Nullifying the objects
		PlaceOrderDuration		= null; // Nullifying the objects
	}
	else if(func_mode.equalsIgnoreCase("LOAD_PH_TAB"))	// To Load PH Tabs
	{
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) beanObj.getOrderEntryRecordBean();
		// If it is a new patient set it, other wise get the patient id
		//orderEntryRecordBean.getPatient(beanObj.getPatientId());
		/* Initialize Function specific end */
		String key						= (beanObj.getPatientId()+beanObj.getEncounterId());  // Unique key to keep the Value in the Bean
   		HashMap previousValues= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
   		if(previousValues!=null)
			beanObj.getOrderCatalogCode(previousValues,"PH",pract_type);   //To get the catalog_codes in the bean and to set it for Cyto/Prescription //IN042045
		String ph_query_string			= beanObj.checkForNull(request.getQueryString(),"") ;
		String ph_default_tab		 	= beanObj.getPHDefaultTab(); // Get whether it is Cyto or Prescription (For the tabs -- Pharmacy)
		out.println( "LoadPhTabs(\""+ph_query_string+"\",\"" +ph_default_tab+" \") ; " ) ;
	}
	else if(func_mode.equalsIgnoreCase("LOAD_TABS"))	// To Load Other Tabs like Laboratory, Radialogy, Treatment, etc.
	{
		String query_string		 = beanObj.checkForNull(request.getQueryString(),"") ;
		out.println( "LoadTabs(\""+query_string+"\") ; " ) ;
	}
	else if(func_mode.equalsIgnoreCase("PRINT_VALUES"))	// To Print the values
	{
		// Call a method to print a report for the order_id generated
		//, beanObj.getStorePrintValues()
		beanObj.callOnLinePrinting(beanObj.getPrintValues(), beanObj.getStoreSpecimenPrintValues(), request, response); // Call the Printing Method to print
		//IN046592 Start.
			Hashtable specLabDataPrint = beanObj.getPrintSpecimenLables(); //IN046592
			OnLinePrinting online_print = new OnLinePrinting();		
			if (specLabDataPrint.size() > 0) 
			{
				online_print.callSpecimenOnLinePrintReport(specLabDataPrint,request,response);
			}
	   //IN046592 End.
		   beanObj.onlinePrintingForBarcode(beanObj.getBarcodePrintValues(),request,response);//IN064614
			//IN065942, starts
			if(beanObj.getPrnLblvalues().size() > 0)
			{
				online_print.printRegOrdLabel(beanObj.getPrnLblvalues(),request,response);
			}
			//IN065942, ends
		//Clear the bean values set for printing
		beanObj.clearPrintingValues();
	}
	else if(func_mode.equalsIgnoreCase("NEW_GROUPING"))	// To check the grouping and if not same, give an alert
	{
		int row_count 			= Integer.parseInt(beanObj.checkForNull((String)hash.get(
		"row_amend_count"),"0") ) ;
		String amend_grouping =   beanObj.checkForNull((String)hash.get(
		"amend_grouping"),"0") ;
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) beanObj.getOrderEntryRecordBean();
		// If it is a new patient set it, other wise get the patient id
		//orderEntryRecordBean.getPatient(beanObj.getPatientId());
		String new_grouping		= "";
		String specimen_type	= "", nurse_collect_yn = "N";
		String amend_result		= "N";
		// Same how it is set it in the bean, reference apply,...
		ArrayList	arrSeq_num 	= new ArrayList();
		Hashtable template    	= new Hashtable();
		int seq_num     		= 0;
		int j 					= 0;
		String catalog_code 	= null;
		for(int i=0;i<row_count;i++)
		{
			catalog_code = beanObj.checkForNull(((String)hash.get("catalog_code"+i)),"");
			arrSeq_num = (ArrayList) orderEntryRecordBean.getOrderFormats(catalog_code, catalog_code+"_0"); //row_value
			if(arrSeq_num!= null && arrSeq_num.size() >0)
			{
			   j = 0;
    	 	   specimen_type = ""; nurse_collect_yn = "N";
			   for(j=0;j<arrSeq_num.size();j++)
			   {
			      seq_num    = Integer.parseInt((String)arrSeq_num.get(j));//((Integer)arrSeq_num.get(j)).intValue(); // get the seq_num
			      template  = (Hashtable)  orderEntryRecordBean.getOrderFormats ( catalog_code, (catalog_code+seq_num) );
			      if(template!=null)
			      {
			     	  if(((String) template.get("field_mnemonic")).equalsIgnoreCase("SPECIMEN_TYPE")) // System Defined cannot be changed
			         	 specimen_type 	= beanObj.checkForNull((String) template.get("field_values"),"");
	       			 else if(((String) template.get("field_mnemonic")).equalsIgnoreCase(	"NURSE_COLLECT_YN")) // System Defined cannot be changed
		       			  nurse_collect_yn  = beanObj.checkForNull((String) template.get("field_values"),"N");
		       	  } // End of if template
       		   } // End of for j
			} // End of arrSeq_num
			new_grouping = beanObj.checkForNull(((String)hash.get("performing_facility_id"+i)),"") + beanObj.checkForNull(((String)hash.get("order_type"+i)),"") + beanObj.checkForNull(((String)hash.get("priority"+i)),"") + beanObj.checkForNull(((String)hash.get("ord_spl_appr_reqd_yn"+i)),"") + beanObj.checkForNull(specimen_type,"") + beanObj.checkForNull(nurse_collect_yn,"N") + beanObj.checkForNull(((String)hash.get("start_date_time"+i)),"") + beanObj.checkForNull(((String)hash.get("frequency_val"+i)),"") + beanObj.checkForNull(((String)hash.get("duration_value"+i)),"") + beanObj.checkForNull(((String)hash.get("performing_dept_loc_code"+i)),"");
 
			if(!amend_grouping.equals(new_grouping) )
			{
				amend_result = "Y";  //New Order;
				break;
			}
		} // End of for i
		//Call a JS method to set the value as 'New order' or 'old order' (i.e) Y / N for Amend
		out.println( "setNewOrder(\""+amend_result+"\") ; " ) ;
	}
	else if (func_mode.equalsIgnoreCase("CALCULATE_PRE_OP_DAYS"))  // Calculation of the pre-op_days In (order format header), when pref_surg-date - admission_date
	{
  			String pref_surg_date_value 	= beanObj.checkForNull((String)hash.get("pref_surg_date_value"),"") ;
			String admission_date_value 	= beanObj.checkForNull((String)hash.get("admission_date_value"),"") ; 
			String pre_op_days_name		= beanObj.checkForNull((String)hash.get("pre_op_days_name"),"") ; 
 			int pre_op_days = beanQueryObj.getPreOpDays(properties,pref_surg_date_value,admission_date_value) ; // Calling the bean method, pass the order_category and diagnosis
			out.println( "preOPDays(\""+pre_op_days+"\",\""+pre_op_days_name+"\") ; " ) ;
 	}
	else if (func_mode.equalsIgnoreCase("BLOOD_TRANS_EXP_DATE"))  // Calculation of the pre-op_days In (order format header), when pref_surg-date - admission_date
	{
		  
  			String start_date_value 	= beanObj.checkForNull((String)hash.get("start_date"),"") ;
			//objname--Added by Ambiga.M for 18043
  			String objname 	= beanObj.checkForNull((String)hash.get("objname"),"") ;
			String expected__transfuse_date_value 	= beanObj.checkForNull((String)hash.get("obj"),"") ; 
 			String valid_days= beanQueryObj.getvalidDays(properties,start_date_value,expected__transfuse_date_value) ; 
			//objname second parameter--Added by Ambiga.M for 18043
			out.println( "validBTDays(\""+valid_days+"\",\""+objname+"\") ; " ) ;
 	}
	else if (func_mode.equalsIgnoreCase("APPT_REQN_YN"))  // Calculation of the pre-op_days In (order format header), when pref_surg-date - admission_date
	{
  			String order_catalog_code 	= beanObj.checkForNull((String)hash.get("order_catalog_code"),"") ;
			String perf_dept_loc_code 	= beanObj.checkForNull((String)hash.get("perf_dept_loc_code"),"") ; 
			String row_value 	= beanObj.checkForNull((String)hash.get("row_value"),"") ; 
 			String ApptReqdYN= beanObj.checkForNull(beanQueryObj.getApptReqdYN(properties,order_catalog_code,perf_dept_loc_code),""); 
			out.println( "apptReqYN(\""+ApptReqdYN+"\",\""+row_value+"\") ; " ) ;
 	}
	else if(func_mode.equalsIgnoreCase("GETBILLINGDETAILS"))	// For Retrieving Billing Informations
	{
		String quantity					= beanObj.checkForNull(request.getParameter( "quantity" ),"0") ;
		String catalog_code				= beanObj.checkForNull(request.getParameter( "catalog_code" ),"") ;
		String start_date_time			= beanObj.checkForNull(request.getParameter( "start_date_time" ),"") ;
		 cat_desc					= beanObj.checkForNull(request.getParameter( "cat_desc" ),"") ;
		ArrayList BillChargeInfo		= null;
		beanObj.getBillChargeDetails(quantity,catalog_code,start_date_time) ; // Calling the bean method, internally will call a procedure to get the Billing Informations

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
 	 	String[] record 				= null;

		if(BillChargeInfo!=null)
		{
			for( int i=0 ; i< BillChargeInfo.size() ; i++ ) {
				record 					= (String[])BillChargeInfo.get(i);
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
			} // End of For
			out.println( "loadBillingDetails(\""+day_type_code+"\",\"" +day_type_desc+"\" ,\""+time_type_code+"\",\""+time_type_desc+"\",\""+base_qty+"\",\"" +base_rate+"\" ,\""+addl_factor+"\",\""+base_charge_amt+"\",\"" +gross_charge_amt+"\" ,\""+disc_amt+"\",\""+net_charge_amt+"\",\""+disc_perc+"\",\""+pat_gross_charge_amt+"\",\""+pat_disc_amt+"\",\""+pat_net_charge_amt+"\",\""+cust_gross_charge_amt+"\",\""+cust_disc_amt+"\",\""+cust_net_charge_amt+"\" ,\""+split_ind+"\",\""+curr_availed+"\" ,\"" +credit_auth_ref+"\" ,\""+catalog_code+"\" ,\""+cat_desc+"\" ,\""+serv_panel_ind+"\" ,\""+serv_panel_code+"\" ,\""+service_panel_name+"\" ,\""+error_text+"\") ; " ) ;
		} // End of func_mode --> GETBILLINGDETAILS
	}	
	else if(func_mode.equalsIgnoreCase("MULTICONSENT_DTLS"))
	{//For Storing Multi Consent Details added by Hari on 03/05/07
	
		String index			 = (String)hash.get("index");
		String ord_catalog_code  = (String)hash.get("ord_catalog_code");
		String order_category	 = (String)hash.get("order_category");
		String count			 = (String)hash.get("count");
		int count_records		 = Integer.parseInt(count);
		if(count_records>0){
			HashMap consent = new HashMap();
			//HashMap consentDtl = new HashMap();
			for(int i=0;i<count_records;i++){
				//if(!((String)hash.get("consent_form_id"+i)).equals("")){	
					consent.put("consent_chk"+i,	 (String)hash.get("consent_chk"+i));
					consent.put("consent_form_id"+i, (String)hash.get("consent_form_id"+i));
					consent.put("consent_stage"+i,	 (String)hash.get("consent_stage"+i));
					if(hash.containsKey("consent_form_desc"+i))
						consent.put("consent_form_desc"+i,	 (String)hash.get("consent_form_desc"+i));

				//}
			}
			consent.put("count",	 count);
			beanObj.setConsentFormDtl((index+ord_catalog_code+order_category),consent);
		}
	}
	else if(func_mode.equalsIgnoreCase("GETREVISEDBILLINGDETAILS"))	// For Retrieving Billing Informations on Quantity change in the "Place order screen"
	{		
		//IN045080 - commented start
		/*String quantity					= beanObj.checkForNull(request.getParameter( "quantity" ),"0") ;
		String catalog_code				= beanObj.checkForNull(request.getParameter( "catalog_code" ),"") ;
		String start_date_time			= beanObj.checkForNull(request.getParameter( "start_date_time" ),"") ;
		// cat_desc					= beanObj.checkForNull(request.getParameter( "cat_desc" ),"") ;
		String order_id					= beanObj.checkForNull(request.getParameter( "order_id" ),"") ;
		String order_line_no			= beanObj.checkForNull(request.getParameter( "order_line_no" ),"") ;
		String row_value				= beanObj.checkForNull(request.getParameter( "row_value" ),"") ;
		String called_from				= beanObj.checkForNull(request.getParameter( "called_from" ),"") ;*/
		//IN045080 - Commented end
		// IN045080 - Start
		String quantity					= beanObj.checkForNull((String)hash.get( "quantity" ),"0") ;
		String catalog_code				= beanObj.checkForNull((String)hash.get( "catalog_code" ),"") ;
		String start_date_time			= beanObj.checkForNull((String)hash.get( "start_date_time" ),"") ;
		String order_id					= beanObj.checkForNull((String)hash.get( "order_id" ),"") ;
		String order_line_no			= beanObj.checkForNull((String)hash.get( "order_line_no" ),"") ;
		String row_value				= beanObj.checkForNull((String)hash.get( "row_value" ),"") ;
		String called_from				= beanObj.checkForNull((String)hash.get( "called_from" ),"") ;
		String fpp_category				= beanObj.checkForNull((String)hash.get( "fpp_category" ),"") ;//IN068314
		String function_name				= beanObj.checkForNull((String)hash.get( "function_name" ),"") ;//IN073309
		String fpp_yn =beanObj.checkForNull((String)hash.get( "fpp_yn" ),"") ;//IN068314
		// IN045080 - End
		//HashMap bill_dtls			= null;
		HashMap setBills_dtls		= null;
		String[] billing_details 	= null;
		ArrayList BillChargeInfo	= null;
		OrderEntryBillingQueryBean bean_qryobj	= (OrderEntryBillingQueryBean)getBeanObject( "Or_BillingQry", "eOR.OrderEntryBillingQueryBean", request ) ;
		//IN068314 Starts
		//BillChargeInfo		= bean_qryobj.getBillChargeDetails(quantity,catalog_code,com.ehis.util.DateUtils.convertDate(start_date_time,"DMYHM","en",localeName), localeName, order_id, order_line_no,beanObj.getPatientId(),beanObj.getEncounterId(),beanObj.getPatientClass(),beanObj.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
		if("Y".equals(fpp_yn)){
			BillChargeInfo		= bean_qryobj.getBillChargeDetailsfpp(quantity,catalog_code,com.ehis.util.DateUtils.convertDate(start_date_time,"DMYHM","en",localeName), localeName, order_id, order_line_no,beanObj.getPatientId(),beanObj.getEncounterId(),beanObj.getPatientClass(),beanObj.getPractitionerId(),fpp_yn,fpp_category) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
		}
		else{
			BillChargeInfo		= bean_qryobj.getBillChargeDetails(quantity,catalog_code,com.ehis.util.DateUtils.convertDate(start_date_time,"DMYHM","en",localeName), localeName, order_id, order_line_no,beanObj.getPatientId(),beanObj.getEncounterId(),beanObj.getPatientClass(),beanObj.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
		}
		//IN068314 Ends			
		if(BillChargeInfo!=null)
		{
			eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) beanObj.getOrderEntryBillBean();
			
			for( int k=0 ; k< BillChargeInfo.size() ; k++ ) {
				billing_details 	= (String[])BillChargeInfo.get(k);
				setBills_dtls		= new HashMap();

				setBills_dtls.put("charged_yn"       , billing_details[1]);
				setBills_dtls.put("total_payable"    , billing_details[2]);
				setBills_dtls.put("patient_payable"  , billing_details[3]);
				setBills_dtls.put("quantity"         , quantity);
				setBills_dtls.put("incl_excl_action" , billing_details[4]);
				setBills_dtls.put("preapp_yn"        , billing_details[5]);
				setBills_dtls.put("patient_paid_amt" , billing_details[6]);
				setBills_dtls.put("bl_panel_str"     , billing_details[0]);
				setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
				setBills_dtls.put("serv_panel_code"  , billing_details[11]);
				setBills_dtls.put("p_episode_type"	 , billing_details[13]);
				setBills_dtls.put("p_episode_id"	 , billing_details[14]);
				setBills_dtls.put("p_visit_id"		 , billing_details[15]);
				setBills_dtls.put("excl_incl_ind_for_screen"		 , billing_details[4]);
				setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
				//IN068314 Starts
				setBills_dtls.put("error_text"		 , billing_details[9]);
				setBills_dtls.put("fpp_yn"		 , fpp_yn);//Nijithas
				setBills_dtls.put("fpp_category"		 , fpp_category);
				//IN068314 Ends
				if(order_id.equals("") && order_line_no.equals(""))
					orderEntryBillBean.setOrderBillDtls(beanObj.getPatientId()+beanObj.getEncounterId()+catalog_code, setBills_dtls); 
				else
					orderEntryBillBean.setOrderBillDtls(order_id+order_line_no, setBills_dtls); 

			
				//out.println( "loadRevisedBillDtls(\""+row_value+"\",\""+called_from+"\",\""+billing_details[2]+"\",\""+billing_details[3]+"\",\""+billing_details[6]+"\",\""+billing_details[4]+"\",\""+catalog_code+"\") ; " ) ;//IN068314
				out.println( "loadRevisedBillDtls(\""+row_value+"\",\""+called_from+"\",\""+billing_details[2]+"\",\""+billing_details[3]+"\",\""+billing_details[6]+"\",\""+billing_details[4]+"\",\""+catalog_code+"\",\""+billing_details[9]+"\") ; " ) ;//IN068314
				//IN068314 Starts
				if("Y".equals(fpp_yn) && "".equals(billing_details[9])){
					beanObj.setTempValues("fpp_category"+catalog_code,fpp_category);//IN068314
					
					out.println( "dispvieweditbilldtls(\""+row_value+"\",\""+beanObj.getPatientId()+"\",\""+beanObj.getEncounterId()+"\",\""+billing_details[10]+"\",\""+billing_details[11]+"\",\""+billing_details[13]+"\",\""+billing_details[14]+"\",\""+billing_details[15]+"\",\""+function_name+"\",\""+called_from+"\",\""+order_id+"\",\""+order_line_no+"\") ; " ) ;//IN068314////IN073309//IN073712////10503
				}
				//IN068314 Ends
			}
		}
	}
	else if(func_mode.equalsIgnoreCase("Tempvalues"))	
	{
		
		String key = (String)hash.get("key");
		String value = (String)hash.get("value");
		beanObj.setTempValues(key,value);
	}else if(func_mode.equalsIgnoreCase("TERMDESC"))
	{
		String termdesc="";
		termdesc=beanObj.getTermDesc(term_code);
		out.println( "clearCategoryList('document.careSetSearchForm') ; " ) ;//IN061906 starts
		out.println( "termdesc(\"" + termdesc+ "\") ; " ) ;
	}
	else if(func_mode.equalsIgnoreCase("DURATIONVALUES"))
	{
		String row_value		 = beanObj.checkForNull(request.getParameter( "row_value" ),"") ;
		String[] record 		 = null;
		out.println( "clearDurationList('document','document.placeOrderForm',\"" +row_value+"\") ; " ) ;
		ArrayList PlaceOrderDuration=beanObj.getPlaceOrderDuration();
		
		for( int i=0 ; i< PlaceOrderDuration.size() ; i++ ) {
				record 		= (String[])PlaceOrderDuration.get(i);
				out.println( "addDurationList('document.placeOrderForm',\""+record[0]+" \",\""+record[1]+"\",\""+row_value+"\") ; " ) ;
		}
		record				= null; // Nullifying the objects
		PlaceOrderDuration		= null; // Nullifying the objects
	}
	else if(func_mode.equalsIgnoreCase("AMENDDURATIONVALUES"))
	{
		String row_value		 = beanObj.checkForNull(request.getParameter( "row_value" ),"") ;
		String[] record 		 = null;
		out.println( "clearAmendDurationList('document','document.placeOrderForm',\"" +row_value+"\") ; " ) ;
		ArrayList AmendPlaceOrderDuration=beanObj.getPlaceOrderDuration();
		
		for( int i=0 ; i< AmendPlaceOrderDuration.size() ; i++ ) {
				record 		= (String[])AmendPlaceOrderDuration.get(i);
				out.println( "addAmendDurationList('document.placeOrderForm',\""+record[0]+" \",\""+record[1]+"\",\""+row_value+"\") ; " ) ;
		}
		record				= null; // Nullifying the objects
		AmendPlaceOrderDuration		= null; // Nullifying the objects
	}
	else if(func_mode.equalsIgnoreCase("BILL_SETTLEMENT_DISCOUNT"))
	{
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) beanObj.getOrderEntryRecordBean();
		HashMap hashMap	 = new HashMap();
		int categorySize = 0;
		//Modified by Ambiga.M for 19623 added checkForNull & key.equals("") conditions
		String pat_id = beanObj.checkForNull(beanObj.getPatientId());
		String enc_id = beanObj.checkForNull(beanObj.getEncounterId());		
		//String key = (beanObj.getPatientId()+beanObj.getEncounterId());  // Unique key to keep the Value in the Bean
		String key=pat_id+enc_id;
		if(!key.equals(""))
		{
			HashMap previousValues= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
			if(previousValues!=null)
			{
				hashMap = beanObj.getOrderCategories(previousValues);
				 if(hashMap!=null)
				{
					 categorySize = hashMap.size();
				}
			}
		}
		else
		{
			categorySize = 0;
		}
		if(categorySize==0)
		{
			String billing_interface = beanObj.checkForNull(beanObj.getBillingInterfaceYn());
			String patientClass = beanObj.checkForNull(beanObj.getPatientClass());

			if(billing_interface.equalsIgnoreCase("Y") && ((patientClass.equalsIgnoreCase("XT"))||(patientClass.equalsIgnoreCase("OP"))||(patientClass.equalsIgnoreCase("EM"))))
			{
				String discount_allowed_yn=beanObj.checkForNull(beanObj.getDiscountAllowedYN());
				String patient_id=beanObj.checkForNull(beanObj.getPatientId());
				String[] InvStlmtScrOrdYN=(String[])beanObj.getInvStlmtScrExtOrdYN();
				String ValidUser=beanObj.checkForNull(beanObj.getValidUser());
				String settlement_scope = InvStlmtScrOrdYN[3].toString();
				boolean invoke_settlement = false;
				if((settlement_scope.equalsIgnoreCase("B"))||((settlement_scope.equalsIgnoreCase("O"))&&(beanObj.getInvokeFunction().toString().equalsIgnoreCase("PLACE_ORDER")))||((settlement_scope.equalsIgnoreCase("I"))&&(!(beanObj.getInvokeFunction().toString().equalsIgnoreCase("PLACE_ORDER")))))
				{
					invoke_settlement = true;
				}
				else
				{
					invoke_settlement = false;
				}
				//if(((InvStlmtScrOrdYN[0].equalsIgnoreCase("Y"))&&(patientClass.equalsIgnoreCase("XT")))||((InvStlmtScrOrdYN[1].equalsIgnoreCase("Y"))&&(patientClass.equalsIgnoreCase("OP"))&&(invoke_settlement))||(((InvStlmtScrOrdYN[2].equalsIgnoreCase("Y"))&&(patientClass.equalsIgnoreCase("EM")))&&(invoke_settlement))&&(!(ValidUser.equalsIgnoreCase("BL1023"))))//IN033250
				if(((InvStlmtScrOrdYN[0].equalsIgnoreCase("Y"))&&(patientClass.equalsIgnoreCase("XT")))||(((InvStlmtScrOrdYN[1].equalsIgnoreCase("Y"))&&(patientClass.equalsIgnoreCase("OP"))&&(invoke_settlement))&&(!(ValidUser.equalsIgnoreCase("BL1023"))))||(((InvStlmtScrOrdYN[2].equalsIgnoreCase("Y"))&&(patientClass.equalsIgnoreCase("EM")))&&(invoke_settlement))&&(!(ValidUser.equalsIgnoreCase("BL1023"))))//IN033250
				{

					if(discount_allowed_yn.equalsIgnoreCase("Y"))
					{
						out.println( "discountAllowed(\""+discount_allowed_yn+"\",\""+patient_id+"\",'','','','DISCNT',\""+beanObj.getPatientClass()+"\",\""+beanObj.getEpisodeID()+"\",\""+beanObj.getEpisodeVisitNum()+"\",\""+beanObj.getEncounterId()+"\") ; " ) ;
					}
					else if(discount_allowed_yn.equalsIgnoreCase("N"))
					{
					
						Hashtable hashExtOrderBlStlmt	= null;
						hashExtOrderBlStlmt=beanObj.getExternalOrderBillSettlementDetails();
						if(hashExtOrderBlStlmt!=null && hashExtOrderBlStlmt.size() > 0)
						{
							String bill_doc_type=(String)hashExtOrderBlStlmt.get("l_bill_doc_type");
							String bill_doc_num=(String)hashExtOrderBlStlmt.get("l_bill_doc_num");
							String bill_group_id=(String)hashExtOrderBlStlmt.get("v_blng_group_id");
							if(bill_doc_type==null)bill_doc_type="";
							if(bill_doc_num==null)bill_doc_num="";
							if(bill_group_id==null)bill_group_id="";
							out.println( "discountAllowed(\""+discount_allowed_yn+ "\",\""+patient_id+"\",\""+bill_doc_type+"\",\""+bill_doc_num+"\",\""+bill_group_id+"\",'STLMT',\""+beanObj.getPatientClass()+"\",\""+beanObj.getEpisodeID()+"\",\""+beanObj.getEpisodeVisitNum()+"\",\""+beanObj.getEncounterId()+"\") ; " ) ;
						}
					}
				}
			}
		}		
	}
	else if(func_mode.equalsIgnoreCase("deptlocation"))
	{
		String order_catalog_code = (String)hash.get("order_catalog_code");
		String order_category = (String)hash.get("order_category");
		String order_type_code = (String)hash.get("order_type_code");
		String rd_install = (String)hash.get("rd_install");
		String performing_location = (String)hash.get("performing_location");
		String index = (String)hash.get("index");
		String sel	= ""; //IN044014
		//String locn_appt_reqd_yn="";
		ArrayList DeptLocationCode=new ArrayList();
		String[] deptLocation		   = null;
		DeptLocationCode = beanObj.getPerformingDeptLocation(performing_location,order_catalog_code,order_category,order_type_code,rd_install);
		for(int j=0; j<DeptLocationCode.size(); j++)
		{
			deptLocation	= (String[]) DeptLocationCode.get(j);	
			//IN044014 - Start
			if(deptLocation[2]!=null && deptLocation[2].equals("Y"))
			{
				sel = "Selected"; //IN044014 included sel in js funtion to select default
				out.println("addPerformingLocnList(\"" +deptLocation[0] + "\",\"" + deptLocation[1] + "\",\"" + index + "\",\"" + sel + "\");");	
			}
			else
			{
				out.println("addPerformingLocnList(\"" +deptLocation[0] + "\",\"" + deptLocation[1] + "\",\"" + index + "\");");	
			}	
			//IN044014 - End	
		}
	}
	else if(func_mode.equalsIgnoreCase("getTempvalues"))	
	{
		String temp="";		
		temp=beanObj.getTempvalue("OrderSetChecked");		
		out.println(temp);
	}
	else if(func_mode.equalsIgnoreCase("clearTempvalues"))	
	{		
		beanObj.clearTempOrderSet("OrderSetChecked");	
	
	}
	else if(func_mode.equalsIgnoreCase("clearPlacedOrderClinicalComments"))	
	{
		String order_category 	 = beanObj.checkForNull((String)hash.get("order_category"),"") ;
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) beanObj.getOrderEntryRecordBean();
	  	// If it is a new patient set it, other wise get the patient id
		//orderEntryRecordBean.getPatient(beanObj.getPatientId());
   		/* Initialize Function specific start */
		// Setting the Clinical comments for Amend and New Order, even if it is null
		orderEntryRecordBean.removeOrderFormats(order_category+"_CLINICALCOMMENTS", (order_category+"_CLINICALCOMMENTS_0"));	
		
	}
	/*  
		Billing Refund Report On Line Printing(Line)	
		Added By Uma on 10/14/2009 for SRR20056-CRF-195
	*/
	 else if(func_mode.equalsIgnoreCase("PRINT_REPORT_VALUES"))	// To Print the values
	{
		// Call a method to print a report for the order_id generated
		//, beanObj.getStorePrintValues()
 		//beanObj.callOnLineCancelPrinting(beanObj.getPrintValues(), beanObj.getStoreSpecimenPrintValues(), request, response); // Call the Printing Method to print

		//Clear the bean values set for printing
		//beanObj.clearPrintingValues();
		Hashtable tabDataPrint = new Hashtable();
		tabDataPrint=(Hashtable)beanObj.getStoreReportPrintValues();
		if(tabDataPrint!=null)
		{
			if (tabDataPrint.size() > 0) 
			{
				tabDataPrint.put("p_language_id","en");
				tabDataPrint.put("p_module_id","OR");
			}
			if (tabDataPrint.size() > 0) 
			{
				beanObj.callOnLineCancelPrinting(tabDataPrint, request, response);
			}
		}
	}
	else if(func_mode.equalsIgnoreCase("SCHDDURATIONVALUES"))
	{
		String row_value		 = beanObj.checkForNull(request.getParameter( "row_value" ),"") ;
		String hdr_duration_type		 = beanObj.checkForNull(request.getParameter( "hdr_duration_type" ),"") ;
		//String[] record 		 = null;
		out.println( "clearSchdDurationList('document','document.scheduleFreqencyAddModHeader',\"" +row_value+"\") ; " ) ;
		//ArrayList PlaceOrderDuration=OrScheduleFreq.getPlaceOrderDuration();
	
		durationTypes.add("M");
		durationTypes.add("H");
		durationTypes.add("D");
		durationTypes.add("W");
		durationTypes.add("L");
		durationTypes.add("Y");
		
		for(int d=durationTypes.indexOf(hdr_duration_type);d<durationTypes.size();d++)
		{
			durationAppl.add(durationTypes.get(d));
			durationDesc.add(OrScheduleFreq.decodeLocal((String)durationTypes.get(d)));
		}
				
		for(int dt=0;dt<durationAppl.size();dt++) 
		{
				String durationcode = (String)durationAppl.get(dt);
				String durationdesc = (String)durationDesc.get(dt);
				out.println( "addSchdDurationList('document.scheduleFreqencyAddModHeader',\""+durationcode+" \",\""+durationdesc+"\",\""+row_value+"\") ; " ) ;
		}
	}
	/*Ends Here*/
	/*Added by Uma on 1/11/2010 for IN017231 PMG20089-CRF-0830*/
	else if(func_mode.equalsIgnoreCase("UNLOAD_PATIENTS"))
	{
		String patientString		 = beanObj.checkForNull(request.getParameter("patientString"),"");
		String[] patient_ids = patientString.split("!~!");
		ArrayList multi_patient = (ArrayList)beanObj.getMultiPatientDetails();
		if(multi_patient!=null && multi_patient.size()>0)
		{
			for(int pat=0;pat<patient_ids.length;pat++)
			{
				String patient_id = patient_ids[pat];
				for(int m=0;m<multi_patient.size();m++)
				{
					String[] record = (String[])multi_patient.get(m);
					if(record[0].equalsIgnoreCase(patient_id))
					{
						multi_patient.remove(m);
						beanObj.setMultiPatientDetails(multi_patient);
						out.println("continuePatSize(\"" +beanObj.getMultiPatientDetails().size() + "\");");		
					}
				}
			}
		}
	}
	/*Added by Uma on 2/12/2010 for IN019033*/
    else if(func_mode.equalsIgnoreCase("NEXT_CATEGORY"))
	{
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) beanObj.getOrderEntryRecordBean();
		HashMap hashMap	 = new HashMap();
		int categorySize = 0;
		//Modified by Ambiga.M for 19623 added checkForNull & key.equals("") conditions
		String pat_id = beanObj.checkForNull(beanObj.getPatientId());
		String enc_id = beanObj.checkForNull(beanObj.getEncounterId());		
		//String key = (beanObj.getPatientId()+beanObj.getEncounterId());  // Unique key to keep the Value in the Bean
		String key=pat_id+enc_id;
		if(!key.equals(""))
		{
			HashMap previousValues= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
			if(previousValues!=null)
			{
				hashMap = beanObj.getOrderCategories(previousValues);
				 if(hashMap!=null)
				{
					 categorySize = hashMap.size();
				}
			}
		}
		else
		{
			categorySize = 0;
		}		
			out.println("categoryCount(\"" +categorySize + "\");");	
	}
	else if (func_mode.equalsIgnoreCase("VALIDATE_MOTHER_PATIENT_ID"))  // Validate Mother PatientID
	{
		String mother_patient_id 	= beanObj.checkForNull((String)hash.get("mother_patient_id"),"") ;
		String field_mnemonic 	= beanObj.checkForNull((String)hash.get("field_mnemonic"),"") ;
		//String obj 	= beanObj.checkForNull((String)hash.get("obj"),"") ;
		//String obj_name 	= beanObj.checkForNull((String)hash.get("obj_name"),"") ;
		String mother_patient_name			= beanObj.checkForNull((String)beanQueryObj.getMotherPatientName(properties,mother_patient_id)) ;
		if ((mother_patient_name!=null)&&(mother_patient_name.length()>0))
		{
			out.println("displayPatientName(\""+mother_patient_id+"\",\""+mother_patient_name+"\",\""+field_mnemonic+"\");") ;
		}
		else
		{
			out.println("InvalidPatient();");
		}
 	}	
	else if(func_mode.equalsIgnoreCase("PRINT_CONFIRM"))	// IN042962 Confirmation for print
	{
		String confirm_reqd_YN ="N";		
		Hashtable confirm = new Hashtable(); 
		confirm = beanObj.getPrintValues();
		confirm_reqd_YN = (String)confirm.get("confirm_reqd_YN");
		if("Y".equals(confirm_reqd_YN))
		{
			out.println( "confirmPrint();") ;
		}
	}
	else if(func_mode.equalsIgnoreCase("PRINT_CONFIRM_VALUES"))	// IN042962 Confirmation for print from window
	{
		String chk_yn 	= beanObj.checkForNull((String)hash.get("chk_yn"),"N") ;	
		String confirm_reqd_YN ="N";		
		Hashtable confirm = new Hashtable(); 
		confirm = beanObj.getPrintValues();
		confirm.put("confirm_reqd_YN",chk_yn);
	}
	else if(func_mode.equalsIgnoreCase("deptlocation_preview")) //IN048942 - for preview screen performing location issue - Start
	{
		String order_catalog_code = (String)hash.get("order_catalog_code");
		String order_category = (String)hash.get("order_category");
		String order_type_code = (String)hash.get("order_type_code");
		String rd_install = (String)hash.get("rd_install");
		String performing_location = (String)hash.get("performing_location");
		String index = (String)hash.get("index");
		String sel	= ""; 
		ArrayList DeptLocationCode=new ArrayList();
		String[] deptLocation		   = null;
		DeptLocationCode = beanObj.getPerformingDeptLocation(performing_location,order_catalog_code,order_category,order_type_code,rd_install);
		for(int j=0; j<DeptLocationCode.size(); j++)
		{
			deptLocation	= (String[]) DeptLocationCode.get(j);	
			if(deptLocation[2]!=null && deptLocation[2].equals("Y"))
			{
				sel = "Selected"; 
				out.println("setpreviewdeptloc(\"" + sel + "\",\"" + index + "\",\"" + performing_location + "\",\"" + rd_install + "\",\"" + order_type_code + "\",\"" + order_category + "\",\"" + order_catalog_code + "\",\"" +deptLocation[0] + "\",\"" + deptLocation[1] + "\");");	
			}	
		}
		if(!"Selected".equals(sel))
			out.println("setpreviewdeptloc(\"" + sel + "\",\"" + index + "\",\"" + performing_location + "\",\"" + rd_install + "\",\"" + order_type_code + "\",\"" + order_category + "\",\"" + order_catalog_code + "\");");
	}//IN048942 - for preview screen performing location issue - End
	 //ML-MMOH-CRF-0508.1 [IN062319] - Start
	 else if(func_mode.equalsIgnoreCase("ADD_LISTFLD_MNEMONIC")){
		String field_mnemonic_comp 	= (String)hash.get("field_mnemonic_comp");
		String order_catalog_code 	= (String)hash.get("order_catalog_code");
		String field_mnemonic		= (String)hash.get("field_mnemonic");
		
		// new block added by LK @ 21/12/2016 - Start
		
		List lSelectedList 		=	beanObj.getValidateMnemonicList(); 
		List lAllMnemonicList	=	beanObj.getValidateAllMnemonicList();
	    Map lSelectedCompMap	= 	beanObj.getValidateMnemonicMap();
		List tempSelectedList = new ArrayList();
		List tempAllMnemList  = new ArrayList();
		Map tempSelectedMap   = new HashMap();
		if(lSelectedList != null) {
			Iterator iterator = lSelectedList.iterator();
			String tempValue = "";
			while(iterator.hasNext()){
				tempValue = 	(String)iterator.next();
				if(lSelectedList.contains(tempValue)){
					tempSelectedList.add(tempValue);
				}	
			}
		}
		if(lAllMnemonicList != null) {
			Iterator iterator = lAllMnemonicList.iterator();
			String tempValue = "";
			while(iterator.hasNext()){
				tempValue = 	(String)iterator.next();
				if(lAllMnemonicList.contains(tempValue)){
					tempAllMnemList.add(tempValue);
				}	
			}
		}	
		if(lSelectedCompMap != null) {
			
			Set entries = lSelectedCompMap.entrySet();
			for(Iterator i = entries.iterator();i.hasNext();){
				java.util.Map.Entry entry =(java.util.Map.Entry)i.next();
				tempSelectedMap.put(entry.getKey(), entry.getValue());
			}
		}
		
		// new block added by LK @ 21/12/2016 - End
		
		Map	listCompMap = null;
		ArrayList multiCompList = new ArrayList();
		//Map selectedMnemonicCompMap = new HashMap();
		Map existSelectedMnemonicMap = beanObj.getMultiListCompMnemonicMapClone();
		List existSelectedMnemonicList = beanObj.getMultiCheckCompMnemonicList();
		Map selectedMnemonicCompMap = new HashMap();
		List selectedCompList = new ArrayList();
		String fileMnemonicListName = "";
		listCompMap = beanObj.getMultiListCompMnemonicMap();
		if(listCompMap.containsKey(order_catalog_code+field_mnemonic)){
			
			if(existSelectedMnemonicMap == null) {
				existSelectedMnemonicMap = new HashMap();
			}
			if(existSelectedMnemonicList == null){
				existSelectedMnemonicList = new ArrayList();
			}
			multiCompList = (ArrayList)listCompMap.get(order_catalog_code+field_mnemonic);
			if(multiCompList != null){
				if(!multiCompList.contains(field_mnemonic_comp)) {
					multiCompList.add(field_mnemonic_comp);
				}
			}
			
			selectedCompList = (ArrayList)existSelectedMnemonicMap.get(order_catalog_code+field_mnemonic);
			if( existSelectedMnemonicList != null && multiCompList != null){
				Iterator iterator = multiCompList.iterator();
				while(iterator.hasNext()){
					fileMnemonicListName = 	(String)iterator.next();
					if(!existSelectedMnemonicList.contains(fileMnemonicListName)){
						existSelectedMnemonicList.add(fileMnemonicListName);
					}	
				}
					
			} 
			if(selectedCompList == null) {
				selectedCompList = new ArrayList();
				selectedCompList.add(field_mnemonic_comp);
			} else if( !selectedCompList.contains(field_mnemonic_comp)){
				selectedCompList.add(field_mnemonic_comp);
			}
			existSelectedMnemonicMap.put(order_catalog_code+field_mnemonic, selectedCompList);
		
			//List tempList = new ArrayList();
			//Map tempMap = new HashMap();
			
			beanObj.setMultiListCompMnemonicMapClone(existSelectedMnemonicMap);
			beanObj.setMultiCheckCompMnemonicList(existSelectedMnemonicList);
			beanObj.setDupeMultiCompMnemonicMapClone(existSelectedMnemonicMap);
			beanObj.setDupeAllMultiCompMnemonicList(existSelectedMnemonicList);
			beanObj.setCompleteMultiCheckCompList(existSelectedMnemonicList);
			//beanObj.setValidateMnemonicList(tempList); // commented by LK 21/12/2016
			//beanObj.setValidateMnemonicMap(tempMap); // commented by LK 21/12/2016
			//beanObj.setValidateAllMnemonicList(tempList); // commented by LK 21/12/2016
			
			// new block added by LK @ 21/12/2016 - Start
			beanObj.setValidateMnemonicList(tempSelectedList);
			beanObj.setValidateMnemonicMap(tempSelectedMap); 
			beanObj.setValidateAllMnemonicList(tempAllMnemList); 
			// new block added by LK @ 21/12/2016 - End
			
			
		}

	} else if(func_mode.equalsIgnoreCase("REMOVE_LISTFLD_MNEMONIC")){
		String field_mnemonic_comp 	= (String)hash.get("field_mnemonic_comp");
		String order_catalog_code 	= (String)hash.get("order_catalog_code");
		String field_mnemonic		= (String)hash.get("field_mnemonic");
		ArrayList allCompInList = new ArrayList();
		//beanObj.removeFieldMnemonicCmpntList(order_catalog_code+field_mnemonic);
		List selectedCompList 		=	beanObj.getMultiCheckCompMnemonicList();
		Map selectedMnemonicCompMap	=	beanObj.getMultiListCompMnemonicMapClone();
		Map allCompMap 			= 	beanObj.getMultiListCompMnemonicMap();
		List compsInCloneMapList			= new ArrayList();
		List dupeSelectedMnemonicList = new ArrayList();
		
		Map dupeSelectedMnemonicMap  =  beanObj.getDupeMultiCompMnemonicMapClone();
		List dupeSelectedAllMnemList =  beanObj.getDupeAllMultiCompMnemonicList();
		List lDupeSelectedAllMnemList = new ArrayList();
		List tempSelectedAllList = new ArrayList();
		HashMap lSelectedMnemonicCompMap = new HashMap();
		List tempSelectedList = new ArrayList();
		List validateSelList = new ArrayList();
		List validateAllSelList = new ArrayList();
		if(selectedCompList != null){
			String lFieldMnemonic = "";
			Iterator iterator = selectedCompList.iterator();
			while(iterator.hasNext()){
				lFieldMnemonic = (String)iterator.next();
				validateSelList.add(lFieldMnemonic);
			}
			beanObj.setValidateMnemonicList(tempSelectedList);
		}
		if(dupeSelectedAllMnemList != null){
			String lFieldMnemonic = "";
			Iterator iterator = dupeSelectedAllMnemList.iterator();
			while(iterator.hasNext()){
				lFieldMnemonic = (String)iterator.next();
				validateAllSelList.add(lFieldMnemonic);
			}
			beanObj.setValidateAllMnemonicList(validateAllSelList);
		}
		if(dupeSelectedAllMnemList != null){
			String lFldComponent = "";
			Iterator iterator = dupeSelectedAllMnemList.iterator();
			while(iterator.hasNext()){
				lFldComponent = (String)iterator.next();
				tempSelectedList.add(lFldComponent);
			}	
		}
		//selectedCompList 			= 	(ArrayList)selectedMnemonicCompMap.get(order_catalog_code+field_mnemonic);
		if(selectedMnemonicCompMap != null){
			lSelectedMnemonicCompMap.putAll(selectedMnemonicCompMap);
			compsInCloneMapList = (ArrayList)selectedMnemonicCompMap.get(order_catalog_code+field_mnemonic);
			if(dupeSelectedMnemonicMap != null){
				lDupeSelectedAllMnemList = (ArrayList)dupeSelectedMnemonicMap.get(order_catalog_code+field_mnemonic);
				if(lDupeSelectedAllMnemList != null){
					String fldComponent = "";
					Iterator dupeIterator = lDupeSelectedAllMnemList.iterator();
					while(dupeIterator.hasNext()){
						fldComponent = (String)dupeIterator.next();
						if(!tempSelectedAllList.contains(fldComponent)) {
							tempSelectedAllList.add(fldComponent);
						}
					}
				}
			} 
			if(compsInCloneMapList != null && compsInCloneMapList.size()>0){
				compsInCloneMapList.remove(field_mnemonic_comp);
				//ArrayList lCompsInCloneMapList = new ArrayList();
				//lCompsInCloneMapList.add(compsInCloneMapList);
				lSelectedMnemonicCompMap.put(order_catalog_code+field_mnemonic, compsInCloneMapList);
				//selectedMnemonicCompMap.put(order_catalog_code+field_mnemonic, lCompsInCloneMapList);
			}	
				
			if(compsInCloneMapList != null && compsInCloneMapList.size() == 0) {
				if(allCompMap != null){
					allCompInList = (ArrayList)allCompMap.get(order_catalog_code+field_mnemonic);
					if(allCompInList != null){
						String fldComponent = "";
						Iterator dupeIterator = allCompInList.iterator();
						while(dupeIterator.hasNext()){
							fldComponent = (String)dupeIterator.next();
							if(!dupeSelectedAllMnemList.contains(fldComponent)) {
								dupeSelectedAllMnemList.add(fldComponent);
							}	
						}
						Iterator iterator = allCompInList.iterator();
						fldComponent = "";
						while(iterator.hasNext()){
							fldComponent = (String)iterator.next();
							selectedCompList.remove(fldComponent);
							
						}
					}
				}
			}	
			dupeSelectedMnemonicMap.put(order_catalog_code+field_mnemonic, tempSelectedAllList);
			beanObj.setMultiCheckCompMnemonicList(selectedCompList);
			beanObj.setMultiListCompMnemonicMapClone(lSelectedMnemonicCompMap); // modified by LK
			beanObj.setDupeMultiCompMnemonicMapClone(dupeSelectedMnemonicMap);
			beanObj.setDupeAllMultiCompMnemonicList(tempSelectedList); //
			beanObj.setCompleteMultiCheckCompList(tempSelectedList);
			
		}
		
	} else if(func_mode.equalsIgnoreCase("CHECK_LISTFLD_MNEMONIC_MANDATE")){
		String field_mnemonic_comp 	= (String)hash.get("field_mnemonic_comp");
		List multiChkCompoMnemonicList = beanObj.getCompleteMultiCheckCompList();
		List selectedCompList 		=	beanObj.getMultiCheckCompMnemonicList();
		Map selectedCompMap		= 	beanObj.getMultiListCompMnemonicMapClone();
		String isCompPresent = "Y";
		if(multiChkCompoMnemonicList != null){
			if(multiChkCompoMnemonicList.contains(field_mnemonic_comp)){
				if(selectedCompList != null){	
					if(selectedCompList.contains(field_mnemonic_comp)){
						isCompPresent = "Y";
					} else {
						isCompPresent = "N";
					}
				}else {
					isCompPresent = "N";
				}
			} else {
				isCompPresent ="";
			}
		}
		out.println(isCompPresent);
	}
	//ML-MMOH-CRF-0508.1 [IN062319] - End
	/*Ends Here*/
	// set it back persistence  (When clinical comments is used ,it is used to set it)
	putObjectInBean(bean_id,beanObj,request);
}
catch(Exception e)
{
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
