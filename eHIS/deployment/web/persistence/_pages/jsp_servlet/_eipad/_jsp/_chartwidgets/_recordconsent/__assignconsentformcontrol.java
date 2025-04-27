package jsp_servlet._eipad._jsp._chartwidgets._recordconsent;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.ConsentOrders;
import eIPAD.chartsummary.recordconsent.healthobject.RecordConsentFieldItem;
import eIPAD.chartsummary.recordconsent.response.RecordConsentFieldResponse;
import eIPAD.chartsummary.recordconsent.bc.RecordConsentBC;
import eOR.ConsentOrders;
import java.sql.*;
import java.util.*;
import java.io.*;
import eOR.Common.*;
import eOR.*;
import com.ehis.persist.PersistenceHelper;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.*;
import eOR.*;
import eOR.Common.*;

public final class __assignconsentformcontrol extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/recordconsent/AssignConsentFormControl.jsp", 1709116949176L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);

String bean_id = "Or_ConsentOrders" ;
String bean_name = "eOR.ConsentOrders";
ConsentOrders bean = (ConsentOrders)PersistenceHelper.getBeanObject( bean_id, bean_name, request ) ;

PatContext patientContext = (PatContext)session.getAttribute("PatientContext");

String practitioner_id = (String)session.getValue("ca_practitioner_id");


String getCode=request.getParameter("code");
String getDesp=request.getParameter("desc");
String order_catalog_codes=request.getParameter("currentCode");
String order_id=request.getParameter("currentOrderId");
String order_line_nums=request.getParameter("currentLineNum");
String order_currentindex=request.getParameter("currentindex");



ArrayList multiConsentListNew = new ArrayList();
String[] multiConsentDtlsNew = null;


//to clear bean

bean.clearHasp();





//call to multi list consent file

//MultiListConsentsForNew(String order_catalog_codes,String order_id,String order_line_nums, String pract_id)

//bean.multiConsentDraftValues(order_catalog_codes, order_id, order_line_nums);

String multiConsentLine[] = new String[4];

multiConsentLine=bean.MultiListConsentsLine(order_id,order_line_nums);
multiConsentDtlsNew		= bean.MultiListDtls(order_catalog_codes,practitioner_id);
	



	if(multiConsentDtlsNew[0].equals("F"))
	{
		multiConsentListNew=bean.multiConsentDraftValues(order_catalog_codes,order_id,order_line_nums);
	}
	
	//System.out.println("wals multiConsentLine super star");
	
	
	if(multiConsentListNew==null || multiConsentListNew.size()==0)
	{
		
		multiConsentListNew		= bean.MultiListConsentsForNew(order_catalog_codes,order_id,order_line_nums,practitioner_id);
	}
	
	//System.out.println("multiConsentList"+multiConsentListNew.size());

//save to modify values


//form ids
            String consent_form_ids = getCode ;
		
		
			String consent_form_stages = request.getParameter("currentstage");
			
			String order_sequences = request.getParameter("currentSeq");
			
			String default_chk = "Y" ;
			String ord_catalog_codes = order_catalog_codes ;
			
			String key=ord_catalog_codes+"!!"+order_sequences;
			String value=consent_form_ids+"!!"+consent_form_stages+"!!"+default_chk;
			//System.out.println("key="+key+"==value=="+value);
			boolean dupilcate=bean.setModifyValues(key,value);
			if (dupilcate)
			{
			//System.out.println("coming here");
			
			}

			
			
			
		
	Hashtable dataMap = new Hashtable();		
	String[] multiConsentValues = null;
	String[] multiConsent = null;
	ArrayList multiConsentHeader = new ArrayList();
    ArrayList multiConsentList = new ArrayList();
	
	multiConsentHeader=bean.MultiListConsentsHeader(order_id);
			
	
	String order_line_num;
	String order_catalog_code;
	String order_catalog_desc;
	
	String[] multiConsentDtls = null;
	String consent_req_bef_order="";
	String consent_req_bef_regn="";
	
	
	int tot_consents_avail=0;

	
		dataMap.put("order_id",order_id);
		
	for(int k=0;k<multiConsentHeader.size();k++)
		{

	        multiConsent = (String[])multiConsentHeader.get(k);
			order_line_num=multiConsent[0];
			order_catalog_code=multiConsent[1];
			order_catalog_desc=multiConsent[2];
			consent_req_bef_order=multiConsent[3];
			consent_req_bef_regn=multiConsent[4];
			multiConsentDtls= bean.MultiListDtls(order_catalog_code,practitioner_id);

			dataMap.put("ord_catalog_code",order_catalog_code);
			dataMap.put("viewBy","line");
			dataMap.put("temp_temp_consent_desc","");
			dataMap.put("index",order_currentindex);
			dataMap.put("bean_id","Or_ConsentOrders");
			dataMap.put("order_line_num",order_line_num);
			//temp_consent_form_id
			dataMap.put("temp_consent_form_id","");
			dataMap.put("default_chk","Y");		
			dataMap.put("localeName","en");	
			dataMap.put("bean_name","eOR.ConsentOrders");	
			dataMap.put("mode","1");
			dataMap.put("report_type","c");
dataMap.put("function_from","EXISTING_MULTI_CONSENT");	
dataMap.put("dupilcate","false");			
			
			
			
			if(multiConsentDtls[0].equals("F"))
			{
				multiConsentList=bean.multiConsentDraftValues(order_catalog_code,order_id,order_line_num);
			}
			
			
			if(multiConsentList==null || multiConsentList.size()==0)
		{		
			    multiConsentList		= bean.MultiListConsentsForNew(order_catalog_code,order_id,order_line_num, practitioner_id);
		}
		
	consent_req_bef_order = (String) multiConsentLine[2];//added for SRR20056-SCF-2009  Id:  3736 dated:05/06/2008
	consent_req_bef_regn = (String) multiConsentLine[3];//added for SRR20056-SCF-2009  Id:  3736 dated:05/06/2008

	int befOrder = Integer.parseInt(consent_req_bef_order);
	int befRegn = Integer.parseInt(consent_req_bef_regn);
	
	int total_consents=befOrder+befRegn;
	
	
	String consent_avaliable_befOrder = Integer.toString(befOrder);
	String consent_avaliable_befRegn = Integer.toString(befRegn);
	
	dataMap.put("befRegn",consent_avaliable_befRegn);
	dataMap.put("befOrder",consent_avaliable_befOrder);
	
	
	
				
				
	
	
			
			String total_consents_avilable = Integer.toString(total_consents);
			
			
			dataMap.put("total_consents_req",total_consents_avilable);
			if(multiConsentList.size() >0)
			{
				
				for(int i=0;i<multiConsentList.size();i++)
				{
					
					multiConsentValues = (String[])multiConsentList.get(i);
					
					
					//temp_consent_desc
					
					String temp_consent_desc="temp_consent_desc"+i;
					
					dataMap.put(temp_consent_desc,multiConsentValues[2]);
					
					String consent_desc="consent_desc"+i;
					dataMap.put(consent_desc,multiConsentValues[2]);
					
					
					dataMap.put("consent_sql",OrRepositoryExt.getOrKeyValue("SQL_OR_CATALOG_CONSENT_FORMAT_MULTI_NON_IND"));
					
					String order_sequence="order_sequence"+i;
					
					dataMap.put(order_sequence,multiConsentValues[5]);
					
					
					
					
					String consent_form_stage="consent_form_stage"+i;
					
					dataMap.put(consent_form_stage,multiConsentValues[3]);
					
					
					//consent_stage_temp
					
					String consent_stage_temp="consent_stage_temp"+i;
					
					dataMap.put(consent_stage_temp,multiConsentValues[3]);
					
					//consent_button
					
					String consent_button="consent_button"+i;
					
					dataMap.put(consent_button,"?");
					
					
					
					String consent_stage="consent_stage"+i;
					
					if(befOrder > 0 && befRegn==0)
				{
dataMap.put(consent_stage,"A");
			
				}
				else
				{
dataMap.put(consent_stage,"R");
			
				}
					//consent_form_id
					
					String consent_form_id="consent_form_id"+i;
					
					dataMap.put(consent_form_id,multiConsentValues[1]);
					
					//consent_chkon 
					
					String consent_chk="consent_chk"+i;
					
					dataMap.put(consent_chk,"");
					
					tot_consents_avail++;
					
				}
				String consent_avaliable = Integer.toString(tot_consents_avail);
				dataMap.put("total_consents_available",consent_avaliable);
				
				
			}
	
		}	
			
		
			
	Set set = dataMap.entrySet();
    // Get an iterator
    Iterator i = set.iterator();
    // Display elements
    while(i.hasNext()) {
       Map.Entry me = (Map.Entry)i.next();
    }
		
	
    
    HashMap map = null; 

       
   	request.setCharacterEncoding("UTF-8");
   	
   	
   	Hashtable hash		= dataMap;
   	//System.out.println("hash == "+hash);
   	
     //hash				= (Hashtable)hash.get( "SEARCH" );
   	String bean_ids		= (String) hash.get( "bean_id" );
   	String bean_names	= (String) hash.get( "bean_name" );
   	//System.out.println("===localeName==="+localeName+"=====");
   	//System.out.println("===localeName==hash="+hash.get( "locale" )+"=====");
   	boolean local_ejbs	= false ;
   	/*Added by Parimala*/
   		 hash.put("HttpRequest", request) ;		//Ramesh
   		 hash.put("HttpResponse", response) ;	//Ramesh
   	/*Ends Here*/
   	//	out.println("alert(\"bean name =" + bean_name+ "\");") ;   
   	//	out.println("alert(\"hash =" + hash + "\");") ; 
   	
   	//ConsentOrders bean = (ConsentOrders)PersistenceHelper.getBeanObject( bean_id, bean_name, request ) ;
   	
   	
    
   	
   	//out.println("alert(\"name =" + beanObj+ "\");") ; 
   	hash.remove( "bean_id" ) ;
   	hash.remove( "bean_name" );

   	// Set the mode for Local Ejb or Remote Ejb

    	if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
   		local_ejbs = true;
    
   	bean.setLocalEJB(local_ejbs);
   	// Set Id, Ws No, Date, Facility start 
   	bean.setLoginById( (String) session.getValue( "login_user" ) ) ;
   	bean.setLoginAtWsNo( bean.getProperties().getProperty( "client_ip_address" ) ) ;
   	bean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;
     	if((String) hash.get( "mode" )!=null)
   		bean.setMode( (String) hash.get( "mode" )) ;

   	if((String) hash.get( "locale" )!=null)
   		bean.setLanguageId( (String) hash.get( "locale" ) ) ;
   	else
   		bean.setLanguageId( (String) session.getAttribute("LOCALE") ) ;

    	bean.setAll(hash) ;
    
    	map = bean.validate() ;

   		
   	boolean validated = ((Boolean) map.get( "result" )).booleanValue() ;

//   	out.println("alert(\"validated :: =" + validated+ "\");") ; 
//   	out.println("alert(\"map :: =" + map+ "\");") ; 
   	
   	map.put( "message",bean.getMessage((String)map.get( "message" ))) ;
   	//map.put( "message",(String)map.get( "message" )) ;

   	String validationMessage = map.get("message") == null ? "" :(String)map.get("message")  ;
   	validationMessage = bean.replaceNewLineChar( validationMessage );

   	if ( validated ){
   		map = bean.apply() ;	



       //    out.println("alert(\"map inside :: =" + map+ "\");") ; 

   		boolean result = ((Boolean) map.get( "result" )).booleanValue() ;


//   		out.println("alert(\"result here> =" + result+ "\");") ; 
//   		out.println("alert(\"message here> =" + (String)map.get( "message" )+ "\");") ; 
   		map.put( "message",bean.getMessage((String)map.get( "message" ))) ;
   		//map.put( "message",(String)map.get( "message" )) ;


   		String message = bean.replaceNewLineChar(bean.checkForNull((String)map.get("message")));
   		
   		//message ="*"+message;

   		//String traceVal =	 bean.replaceNewLineChar(bean.checkForNull((String) map.get( "traceVal" )));
   		String invalidCode = "" ;
          
   		if(map.get("invalidCode") != null)
               		invalidCode = (String) map.get( "invalidCode" ) ;

   	//	out.println("alert(\"Message : " + message + "\");") ;// 6 th alert

   		String flag =bean.replaceNewLineChar(bean.checkForNull((String) map.get( "flag" )));
   	//	out.println("assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;	
   		out.println("assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" , \"" + invalidCode.trim() + "\") ; ") ;
   	} else {
   		
   		String invalidCodeVal = "" ;



//   		out.println("alert(\"map=" + map+ "\");") ; 

   		if(map.get("invalidCode") != null)
            		 invalidCodeVal = (String) map.get( "invalidCode" ) ;

   		//out.println("assignResult(" + validated + ", \"" + validationMessage + "\", \"0\" ) ; ") ;
   		String flag =bean.replaceNewLineChar(bean.checkForNull((String) map.get( "flag" )));
   		//out.println("assignResult(" + validated + ", \"" + validationMessage + "\", \"0\" ) ; ") ;
   		out.println("assignResult(" + validated + ", \"" + validationMessage + "\", \"" + flag + "\","+ "\"" + invalidCodeVal +"\" ) ; ") ;

   	}
   	//putObjectInBean(bean_ids,bean,request);
   
PersistenceHelper.putObjectInBean(bean_ids,bean,request);
    
			


		


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
