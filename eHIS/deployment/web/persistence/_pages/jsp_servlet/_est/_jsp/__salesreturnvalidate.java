package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.SalesReturnBean;
import eST.SalesBean;
import eST.Common.StRepository;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __salesreturnvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/SalesReturnValidate.jsp", 1719900171164L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n \n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );
	
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

/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
09/02/2017		IN061112			Badmavathi B					        GHL-CRF-0413 - Barcode search
13/06/2018		8109			Shazana					        		GHL-SCF-1337  - modified sales_doc_date as suggested by Balaraman
03/09/2020      IN073899            Haribabu                                MMS-DM-CRF-0174.2
30/12/2020      TFSid:11896      B Haribabu          30/12/2020          ST-MMS-DM-CRF-0174.2/03(TF) - Request Issue
---------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

		
	java.util.Properties prop   = (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		= prop.getProperty( "client_ip_address" );
	String bean_id				= "salesReturnBean"+login_at_ws_no;
	String bean_name			= "eST.SalesReturnBean";

	SalesReturnBean bean = (SalesReturnBean)getBeanObject( bean_id, bean_name , request) ;  
	//System.out.println("bean_id"+bean_id);

	eST.SalesBean bean_sales = (eST.SalesBean)getBeanObject( "salesBean", "eST.SalesBean",request  );
	bean_sales.setLanguageId(locale);
	bean.setLanguageId(locale);
	String validate		=	request.getParameter("validate");
	String item_desc	=	request.getParameter("item_desc");
	String grosschargeamt = 	"";
	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");

	String message			=	"";
	String flag				=	"";
	String facility_id	=	(String)session.getValue("facility_id");

	HashMap hashmapDtl				=	new HashMap();

	String item_code				=	request.getParameter("item_code");
	String store_code				=	request.getParameter("store_code");
	
	String item_qty					=	request.getParameter("item_qty");
	String uom_desc					=	request.getParameter("uom_desc");
	String uom_code					=	request.getParameter("uom_code");
	String stock_available			=	request.getParameter("stock_available");
	String remarks					=	request.getParameter("remarks");
	String patient_id				=	request.getParameter("patient_id");
	String encounter_id				=	request.getParameter("encounter_id");
	String doc_srl_no				=	request.getParameter("doc_srl_no");
	String item_unit_cost			=	request.getParameter("item_unit_cost");
	String item_cost_value			=	request.getParameter("item_cost_value");
	String expiry_yn				=	request.getParameter("expiry_yn");
	String stock_item_yn			=	"" ; //request.getParameter("stock_item_yn");
	String index					=	request.getParameter("index");
	String pat_net_amt				=	request.getParameter("pat_net_amt");
	String batch_records			=	request.getParameter("batch_records");
	String Inpatient_yn				=	request.getParameter("Inpatient_yn");
	String outpatient_yn			=	request.getParameter("outpatient_yn");
	String referral_yn				=	request.getParameter("referral_yn");
	String daycare_yn				=	request.getParameter("daycare_yn");
	String emergency_yn				=	request.getParameter("emergency_yn");
	String directsale_yn			=	request.getParameter("directsale_yn");
	String sal_doc_srl_no			=	request.getParameter("sal_doc_srl_no");
	String sales_doc_type_code		=	request.getParameter("sales_doc_type_code");
	String sales_doc_no_new				=	request.getParameter("sales_doc_no");
	String return_allowed_yn		=	request.getParameter("return_allowed_yn");
	int no_of_decimals				=	Integer.parseInt((String)request.getParameter("no_of_decimals")==null?"0":(String)request.getParameter("no_of_decimals"));
	String decimal_allowedYN		=	request.getParameter("decimal_allowedYN");
	String billable_item_yn		=	bean.checkForNull(request.getParameter("billable_item_yn"),"N");
	String remarks_code		     =	bean.checkForNull(request.getParameter("remarks_code"),"");//20/06/12
	
	HashMap hmrecord				=	null;		
	HashMap msg						=	new HashMap();
	grosschargeamt					= 	pat_net_amt;
	//String error_msg="";
	boolean	result					=	false;
	HashMap dflt_sal_type	=	null;  // Added by Padmapriya
	
		//int no_of_decimals_yn=bean.getNoOfDecimals();
	try {

	//	String operation							=	request.getParameter("operation");
		if (validate.equals("ADD_TO_LIST")) {
/*Code added for SRR walk-thru on 3/3/2010*/
			bean.setRecords_to_delete(bean.checkForNull((String)request.getParameter("records_to_delete")));
/*Code ended*/
 	  //Added against GHL-CRF-0413.5 starts
			String doc_srl_no_forbean = (String) request.getParameter("doc_srl_no_forbean");
			String site = (String) request.getParameter("site");
	  //Added against GHL-CRF-0413.5 ends
			ArrayList alBatchList = new ArrayList();
			alBatchList=bean.getBatchDetails(item_code,store_code);
		    stock_item_yn = bean.checkForNull((String)(alBatchList.get(5)),"");
			
			flag="";

			hashmapDtl.put("doc_srl_no",		doc_srl_no		);
			hashmapDtl.put("item_code",			item_code		);
			hashmapDtl.put("store_code",		store_code		);
			hashmapDtl.put("stock_item_yn",		stock_item_yn	);
			hashmapDtl.put("item_desc",			item_desc		);
			hashmapDtl.put("expiry_yn",			expiry_yn		);
			hashmapDtl.put("uom_desc",			uom_desc		);
			hashmapDtl.put("uom_code",			uom_code		);
/**
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - 15496
 * @Desc -  Decimal handling in item based.dec_allowed_yn 
 */
			//if(bean.getAllowDecimalsYN( item_code).equals("Y")){
			if(decimal_allowedYN.equals("Y")){
			hashmapDtl.put("item_qty",		bean.setNumber(	""+item_qty,no_of_decimals)	);
			}else{
			hashmapDtl.put("item_qty",			bean.setNumber(	""+item_qty,0));
			}
			//hashmapDtl.put("item_qty",			item_qty		);
			hashmapDtl.put("item_unit_cost",	item_unit_cost	);
			hashmapDtl.put("item_cost_value",	item_cost_value	);
			hashmapDtl.put("stock_available",	stock_available	);
			hashmapDtl.put("remarks",			remarks			);
			hashmapDtl.put("gross_charge_amt",	grosschargeamt	);
			hashmapDtl.put("pat_net_amt",		pat_net_amt	);
			hashmapDtl.put("batch_records",		batch_records	);
			hashmapDtl.put("sales_doc_type_code",		sales_doc_type_code	);
			hashmapDtl.put("sal_doc_srl_no",	sal_doc_srl_no	);
			hashmapDtl.put("sales_doc_no",	sales_doc_no_new	);
			hashmapDtl.put("no_of_decimals",	""+no_of_decimals	);
			hashmapDtl.put("decimal_allowedYN",	decimal_allowedYN	);
			hashmapDtl.put("return_allowed_yn",	bean.checkForNull(return_allowed_yn));
			hashmapDtl.put("billable_item_yn",	billable_item_yn);
			hashmapDtl.put("remarks_code",	remarks_code); //20/06/12
			//System.out.println("hashmapDtl====>" +hashmapDtl);
		
			String[] stNames={"item_code"};
			String[] stValues={item_code};
			//Added against GHL-CRF-0413.5 starts
			if(site.equals("true")){
				int doc_srl_no1 = Integer.parseInt(doc_srl_no_forbean);
				doc_srl_no1++;
				String doc_srl_no2 = ""+doc_srl_no1;
				hashmapDtl.put("doc_srl_no",	doc_srl_no2);
				bean.updateDtlRecord(Integer.parseInt(doc_srl_no_forbean), hashmapDtl);
				bean.updateExpRecords(Integer.parseInt(doc_srl_no_forbean), htFormValues);
			}
			else{
			//Added against GHL-CRF-0413.5 ends
			if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");

			bean.updateDtlRecord(Integer.parseInt(index), hashmapDtl);
            bean.updateExpRecords(Integer.parseInt(index), htFormValues);
			}
			result			=	true;

		}
		
//Commented by Padmapriya
		/* 
  else if (validate.equals("SALES_TYPE")){
			String list1	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
			String list2	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
			String list3	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
			String list4	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.DirectSales.label","st_labels");
			String list5 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
			String list6 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
			hmrecord	=		bean.getSalesType(store_code);

			outpatient_yn		=		(String)hmrecord.get("OUTPATIENT_YN");
			Inpatient_yn		=		(String)hmrecord.get("INPATIENT_YN");
			referral_yn			=		(String)hmrecord.get("REFERRAL_YN");
			daycare_yn			=		(String)hmrecord.get("DAYCARE_YN");
			emergency_yn		=		(String)hmrecord.get("EMERGENCY_YN");
			directsale_yn		=		(String)hmrecord.get("DIRECTSALE_YN");
			
			out.println("clearListItems('document.formSalesReturnHeader.sal_trn_type'); ");
			if(Inpatient_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesReturnHeader.sal_trn_type\", \"" +"I"+ "\",\"" +list2+ "\"); ");
			if(daycare_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesReturnHeader.sal_trn_type\", \"" +"D"+ "\",\"" +list6+ "\"); ");
			if(outpatient_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesReturnHeader.sal_trn_type\", \"" +"O"+ "\",\"" +list1+ "\"); ");
			if(emergency_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesReturnHeader.sal_trn_type\", \"" +"E"+ "\",\"" +list5+ "\"); ");
			if(referral_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesReturnHeader.sal_trn_type\", \"" +"R"+ "\",\"" +list3+ "\"); ");
			if(directsale_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesReturnHeader.sal_trn_type\", \"" +"X"+ "\",\"" +list4+ "\"); ");
		} */
		
	//Added by Padmapriya	
		else if (validate.equals("SALES_TYPE")){
			String list1	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
			String list2	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
			String list3	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
			String list4	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.DirectSales.label","st_labels");
			String list5 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
			String list6 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
			hmrecord	=		bean.getSalesType(store_code);
			
			String user_id = bean_sales.getLoginById()	;
			dflt_sal_type	 = bean_sales.getDfltSalesType(store_code,user_id);
			String dflt_sal_type_yn = (String)dflt_sal_type.get("DFLT_SAL_TRN_TYPE");

			outpatient_yn		=		(String)hmrecord.get("OUTPATIENT_YN");
			Inpatient_yn		=		(String)hmrecord.get("INPATIENT_YN");
			referral_yn			=		(String)hmrecord.get("REFERRAL_YN");
			daycare_yn			=		(String)hmrecord.get("DAYCARE_YN");
			emergency_yn		=		(String)hmrecord.get("EMERGENCY_YN");
			directsale_yn		=		(String)hmrecord.get("DIRECTSALE_YN");
			
			out.println("clearListItems('document.formSalesReturnHeader.sal_trn_type'); ");
			if(Inpatient_yn.equals("Y"))
	out.println("addListItem(\"document.formSalesReturnHeader.sal_trn_type\", \"" +"I"+ "\",\"" +list2+ "\" ,\"" +dflt_sal_type_yn+ "\"); ");
			if(daycare_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesReturnHeader.sal_trn_type\", \"" +"D"+ "\",\"" +list6+ "\",\"" +dflt_sal_type_yn+ "\"); ");
			if(outpatient_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesReturnHeader.sal_trn_type\", \"" +"O"+ "\",\"" +list1+ "\",\"" +dflt_sal_type_yn+ "\"); ");
			if(emergency_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesReturnHeader.sal_trn_type\", \"" +"E"+ "\",\"" +list5+ "\",\"" +dflt_sal_type_yn+ "\"); ");
			if(referral_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesReturnHeader.sal_trn_type\", \"" +"R"+ "\",\"" +list3+ "\",\"" +dflt_sal_type_yn+ "\"); ");
			if(directsale_yn.equals("Y"))
				out.println("addListItem(\"document.formSalesReturnHeader.sal_trn_type\", \"" +"X"+ "\",\"" +list4+ "\",\"" +dflt_sal_type_yn+ "\"); ");
		}		

		else if (validate.equals("PATIENT_NAME")){
			String trn_type = (String)request.getParameter("trn_type");
			//System.out.println("trn_type = > "+trn_type);
			String siteId = (String) request.getParameter("site_id");
			//System.out.println("SalesReturnValidate,siteId = > "+siteId);			
			out.println("clearListItems('document.formSalesReturnHeader.encounter_id'); ");
			if(siteId.equals("MC"))
			//out.println("clearListItems('document.formSalesReturnHeader.sales_doc_no'); ");
			out.println("document.formSalesReturnHeader.sales_doc_no.value='';");

			if (patient_id.trim().equals("")) {
				out.println("setPatientName('');");
				result			=	true;
				return;
			}
			try{

				/* the below line is commented by sakti sankar due to the patient name is not displaying for direct sale*/
			/*	if(trn_type.equals("X")){
					//out.println("document.formSalesReturnHeader.patient_name.disabled = false;");
					out.println("document.formSalesReturnHeader.patient_id.value = '"+bean.checkForNull(bean.getPatientId(patient_id))+"';");
					out.println("setPatientName('');");
					out.println("loadDocNo();");
				}
				else{  */
					out.println("setPatientName(\""+bean.checkForNull(bean.getPatientName(patient_id))+"\");");
					ArrayList alEncounterList = bean.getEncounterArrayList(patient_id,trn_type,siteId);
					HashMap record	=	null;
					for(int i=0; i< alEncounterList.size(); i++) {
						record	=	(HashMap)alEncounterList.get(i);
						String listRecord	=	(String)record.get("ENCOUNTER_ID");
						out.println("addListItem(\"document.formSalesReturnHeader.encounter_id\", \"" +listRecord+ "\",\"" +listRecord+ "\"); ");
					}
					out.println("defaultEncounter();");
					//Added by suresh.r 08-11-2013  against JD-CRF-156 beg
					if(alEncounterList.size()==0 && bean.getBLModuleInstalled().equals("Y")){
						out.println("document.getElementById('id_polexp').style.visibility = 'hidden';");
						out.println("document.getElementById('id_fin_dtl').style.visibility = 'hidden';");
					}
					//Added by suresh.r 08-11-2013  against JD-CRF-156 end
			//	}
				result			=	true;
			}
			catch(Exception exception){
				flag			=	"INVALID_PATIENT";
				result			=	false;
			}
			result = true ;
		}

		else if(validate.equals("GET_STATUS")) {

		//	String[] stParameters = {item_code, store_code, "0", "N", "", "N", "" };
			String[] stNames={"item_code"};
			String[] stValues={item_code};

			if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,-1))
				throw new Exception("RECORD_ALREADY_EXISTS");

			try { 
					result = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,"");
				if(result)
				{
					throw new Exception("PHY_INV_PROCESS_INITIATED");
				}
					ArrayList alBatchList=new ArrayList();
					alBatchList=bean.getBatchDetails(item_code,store_code);
				//	alBatchList.get(2)
					ArrayList alPendingQty=new ArrayList();
					alPendingQty=bean.calculatePendingQuantity(facility_id,patient_id,encounter_id,item_code);
					String stPendingQty=(String)alPendingQty.get(0) ;
					if(stPendingQty==null)
					{
					  out.println( "noPendingQty();" ) ;      
					}
					else
					{
					  out.println( "showPendingQty(\"" + stPendingQty + "\",\""+alBatchList.get(2)+"\" );" ) ;      
					}
			}
			catch (Exception exception) {
				exception.printStackTrace();
				if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
					throw exception;
				}
				throw new Exception("ITEM_STORE_NOT_FOUND");
			}
			if(((String)bean.getAccessCostDetails()).equals("Y")){
				out.println("document.getElementById('id_char_amt').style.visibility = 'visible';");
				out.println("document.getElementById('id_charge_amt').style.visibility = 'visible';");
				out.println("document.getElementById('id_pay_amt').style.visibility = 'visible';");
				out.println("document.getElementById('id_payable_amt').style.visibility = 'visible';");
			}
			result=true;
		}

		else if(validate.equals("CHECK_FINALIZE_ALLOWED")) {
			String stFinalize_allowed	=	bean.getFinalize_allowed_yn(store_code);
			out.println("setFinalize_allowed('"+stFinalize_allowed+"');");
			result=true;
		}
		else if(validate.equals("HEADER_PROCEDURE")){
			try{
		//	String patient = request.getParameter("patient_id");
			String encounter_id_RT = bean.checkForNull(encounter_id);
			String sal_trn_type = request.getParameter("sal_trn_type");
			if(sal_trn_type.equals("X"))
				sal_trn_type = "R";
			msg = bean_sales.callBillingHdrProcedure(patient_id,encounter_id_RT,sal_trn_type);
			//msg = "Insurance Policy Is Expired. Proceed?";
			//code added for the Heade  Level chk For the Insurence  
			if(msg.size() > 0){
				message = (String)msg.get("warning_msg");
			}
			result=true;
			if(msg.size() > 0){
				String error_msg = bean.checkForNull((String)msg.get("error_msg"));
			if(error_msg.length() > 0){
					
					message = (String)msg.get("error_id") + "  " + (String)msg.get("error_msg"); 
					result = false;
					throw new Exception(message);
			}
			}

			}
			catch (Exception exception) {
				
				exception.printStackTrace();
				
			}
			
		}
		else if(validate.equals("ITEMCHARGE_DTLS")){
			try{
				String patient = request.getParameter("patient_id");
				String encounter_id_IT = bean.checkForNull(request.getParameter("encounter_id"));
				String sal_trn = request.getParameter("sal_trn_type");
				//added for GHL-CRF-557
				String sales_doc_no = request.getParameter("sales_doc_no");
				String sales_doc_srl_no = request.getParameter("sales_doc_srl_no");
				String sales_doc_typeCode = request.getParameter("sales_doc_type_code");
				//added for GHL-CRF-557
				if(sal_trn.equals("X"))
					sal_trn = "R";
				String item_dtls   = request.getParameter("item_code");
				String item_qty_dtl		= request.getParameter("item_qty");
				String albatch_data		= request.getParameter("batch_data");
				//msg =bean.callItemChargeDtls(patient,encounter_id_IT,sal_trn,item_dtls,item_qty_dtl,"");
               			 msg =bean.callItemChargeDtls(patient,encounter_id_IT,sal_trn,item_dtls,item_qty_dtl,albatch_data,bean.getSales_doc_date(),sales_doc_no,sales_doc_srl_no,sales_doc_typeCode);//added for ghl-scf-1337, modified for GHL-CRF-557
				
				//msg = "Insurance Policy Is Expired. Proceed?";
						
				if(msg.size() > 0){
					
				if((bean.checkForNull((String)msg.get("error_msg"))) !=""){
						message = (String)msg.get("error_id") + "  " + (String)msg.get("error_msg"); 
						result = false;
						throw new Exception(message);
				}
				else{
						message = (String)msg.get("insind")+","+(String)msg.get("baseqty")+","+(String)msg.get("baserate")+","+(String)msg.get("basechargeamt")+","+(String)msg.get("grosschargeamt")+","+(String)msg.get("discountper")+","+(String)msg.get("discountamt")+","+(String)msg.get("daytypecode")+","+(String)msg.get("daytypedesc")+","+(String)msg.get("timetypecode")+","+(String)msg.get("timetypedesc")+","+(String)msg.get("addlfactor")+","+item_dtls+","+""+","+""+","+""+","+(String)msg.get("netchargeamt")+","+(String)msg.get("patgrosschargeamt")+","+(String)msg.get("patdiscamt")+","+(String)msg.get("patnetamt")+","+(String)msg.get("custgrosschargeamt")+","+(String)msg.get("custdiscamt")+","+(String)msg.get("custnewamt");
						grosschargeamt = (String)msg.get("grosschargeamt");
						result = true;
				    }
				}

			

			}
			catch (Exception exception) {
				
				exception.printStackTrace();
			}
			
		}
//  Added for online printing on 9/28/2004

		else if (validate.equals("printOnlineDoc")){
			try{
			//String pdocno=bean.getPrintDocNo();
			//bean.doOnlineReportPrinting(pdocno);	
			ArrayList doc_no=bean.getPrintDocNo();
			String pdocno = "";
			for(int i=0;i<doc_no.size();i++){
				pdocno=(String)doc_no.get(i);
				//bean.doOnlineReportPrinting(pdocno);	
				bean.doOnlineReportPrinting(pdocno,request,response);//Added By Sakti Sankar on 06/03/2013 against Inc#
			}
			}catch(Exception e){
					e.printStackTrace();
			}
			result =  true;
			message = request.getParameter("msg");
		}
// End of Online printing on 9/28/2004
		else if(validate.equals("Bill_data")){
			HashMap bill_data=new HashMap(); 
			bill_data= bean.getbill_data();
			String msg1="";
		if(bill_data.size()>0){
		ArrayList doc_no = (ArrayList)bill_data.get("doc_no");
		String doc_n01="";
		if(doc_no.size()>1){
		for(int i=0;i<doc_no.size();i++){
		doc_n01=doc_n01+(String)doc_no.get(i);
		if (i==0)
			doc_n01=doc_n01+ " to ";
		}
		}else{
		doc_n01=(String)doc_no.get(0);
		}
		
		msg1=(String)bill_data.get("l_slmt_reqd_yn")+","+(String) bill_data.get("l_bill_doc_num")+","+(String) bill_data.get("l_bill_doc_type")+","+""+ doc_n01+","+(String) bill_data.get("v_blng_group_id")+","+""+(String)bill_data.get("message")+","+""+(String)bill_data.get("p_call_disc_function_yn")  ;
		 message=msg1;
		 flag = (String) bill_data.get("flag");
		}
		if((bean.checkForNull((String)bill_data.get("error_msg"))) !=""){
			message = (String)bill_data.get("message"); 
			result = false;
			throw new Exception(message);
		}else
		   result = true;
		}
	else if(validate.equals("LOAD_DETAILS")){
		try{
			String sales_doc_no = request.getParameter("sales_doc_no");
			String sales_doc_type= request.getParameter("sales_doc_type");
			//String trn_type = request.getParameter("trn_ype");
			bean.loadDocNoData(sales_doc_no,sales_doc_type);
			ArrayList alDetailData=(ArrayList)bean.getDtlRecords();
			HashMap data = new HashMap();
			HashMap data1 = new HashMap();
			Boolean result1 = false;
			for(int i=0;i<alDetailData.size();i++){
				data1 = (HashMap)alDetailData.get(i);
				result1 = bean.isPhysicalInventoryProcessStartedForStore((String)data1.get("item_code"),(String)data1.get("store_code"),"");
				if(result1){
						String phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{(String)data1.get("item_code"),(String)data1.get("store_code")}).get("PHY_INV_ID");
					out.println("parent.frames[2].frameSalesReturnListHeader.document.formSalesReturnListHeader.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
					throw new Exception("PHY_INV_PROCESS_INITIATED");
				}
			}
			data = (HashMap)alDetailData.get(0);
			String store_code1 = (String)data.get("store_code");
			out.println("setStoreCode('"+store_code1+"');");
			String patien_name=(bean.checkForNull((String)data.get("patient_name"),""));
				
			out.println("setPatientName(\""+patien_name.replaceAll("\"","''")+"\");");
			result = true;
		}catch(Exception e){
			if (e.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
				result = false;
				throw e;
			}
			result = false;
			throw new Exception("ST_BL_DETAILS_NOT_SET");
		}
	}

	else if(validate.equals("LOAD_DETAILS_NEW")){

		try{
			String sales_doc_no   = request.getParameter("doc_no");
			String sales_doc_type = request.getParameter("doc_type_code");
			//String batch_string = request.getParameter("batch_string");
			String sal_trn_type = request.getParameter("sal_trn_type");	
			
			String batch_string = (String)htFormValues.get("loc_batch_string");

			batch_string = batch_string.substring(2,batch_string.length());

			//System.out.println("batch_string from validate jsp ==>"+batch_string);

			StringTokenizer stListItems=new StringTokenizer(batch_string,"||");

		   ArrayList aldummy = new ArrayList();
	       HashMap hmExpRecords	= new HashMap();  
	       HashMap hmExpRecords1	= new HashMap();  
		   HashMap val_map =new HashMap() ;
		   String item_code_temp="";

		   ArrayList aldummy2 = new ArrayList();

		   int item_qty_total =0; 

		   while (stListItems.hasMoreTokens()) {

			   StringTokenizer stListValueText=new StringTokenizer(stListItems.nextToken(),";");
			  
			   String trade_id =  stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String batch_id = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String expiry_date = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String bin_loc_code = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String item_qty_temp = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   item_code_temp = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String sal_item_qty = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			  
			    String item_name  ="";
				uom_code="";
				uom_desc="";
				doc_srl_no="";
				String trade_name ="";
				String bin_location_desc ="";
				String refund_allow_yn ="";

			   /*String item_name  = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   uom_code = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   uom_desc = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   doc_srl_no = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String trade_name = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String bin_location_desc = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String refund_allow_yn = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";*/
				
			   
			   val_map  = new HashMap();
			
			   val_map.put("BATCH_ID",batch_id);
			   val_map.put("ITEM_QTY",item_qty_temp);
			   val_map.put("BIN_LOCATION_CODE",bin_loc_code);
			   val_map.put("BIN_DESC",bin_location_desc);
			   val_map.put("EXPIRY_RECEIPT_DT",expiry_date);
			   val_map.put("TRADE_ID",trade_id);
			   val_map.put("TRADE_NAME",trade_name);
			   val_map.put("ITEM_CODE",item_code_temp);
			   val_map.put("ITEM_DESC",item_name);			   
			   val_map.put("SAL_ITEM_QTY",sal_item_qty);
			   val_map.put("AVAIL_QTY",sal_item_qty);
			   val_map.put("SAL_DOC_SRL_NO",doc_srl_no);
			   val_map.put("DOC_SRL_NO",doc_srl_no);
			   val_map.put("SAL_DOC_TYPE_CODE",sales_doc_type);
			   val_map.put("QTY",item_qty_temp);
			   val_map.put("NEW_BIN_LOCATION_CODE",bin_loc_code);
			   val_map.put("STORE_CODE",store_code);
			   val_map.put("SAL_DOC_NO",sales_doc_no);
			   val_map.put("UOM_CODE",uom_code);
			   val_map.put("UOM_DESC",uom_desc);
			   val_map.put("REFUND_ALLOW_YN",refund_allow_yn);


			   aldummy.add(""+item_code_temp);
			   aldummy2.add(val_map);
		   }

		   for(int i=0;i<aldummy2.size();i++){			
			  hmExpRecords1.put(""+i,aldummy2.get(i));
			  //System.out.println("hmExp1==> "+hmExpRecords1);
			}	   
		   
			 //System.out.println("sales_doc_no==> "+sales_doc_no);
			 //System.out.println("sales_doc_type==> "+sales_doc_type);

		     bean.loadDocNoDataNew(sales_doc_no,sales_doc_type,hmExpRecords1);



			//existing logic
			ArrayList alDetailData=(ArrayList)bean.getDtlRecords();
			HashMap data = new HashMap();
			HashMap data1 = new HashMap();
			Boolean result1 = false;
			for(int i=0;i<alDetailData.size();i++){
				data1 = (HashMap)alDetailData.get(i);
				result1 = bean.isPhysicalInventoryProcessStartedForStore((String)data1.get("item_code"),(String)data1.get("store_code"),"");
				//System.out.println("result1==> "+result1);
				if(result1){
						String phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{(String)data1.get("item_code"),(String)data1.get("store_code")}).get("PHY_INV_ID");
					//out.println("parent.frames[2].frameSalesReturnListHeader.document.formSalesReturnListHeader.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");//Commented against GHL-CRF-0413.5 starts
					throw new Exception("PHY_INV_PROCESS_INITIATED");
				}
			}
			result = true;
		}
		catch(Exception e){
			if (e.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
				result = false;
				throw e;
			}
			result = false;
			throw new Exception("ST_BL_DETAILS_NOT_SET");
		}
	}

	else if(validate.equals("SALES_DOC_NO")){
		result = false;
		String trn_type = request.getParameter("trn_type")==null?"I":request.getParameter("trn_type");
		String sales_doc_type = request.getParameter("sales_doc_type")==null?"":request.getParameter("sales_doc_type");
		/*The variable itemToFilter was added by Dinesh T on 1/7/2011 for the CRF 110*/
		String itemToFilter = (request.getParameter("itemToFilter")==null||request.getParameter("itemToFilter").equals(""))?"%":request.getParameter("itemToFilter");
		patient_id = request.getParameter("patient_id");
		encounter_id = bean.checkForNull(request.getParameter("encounter_id"),"");
		//System.out.println("trn_type..."+trn_type+"..sales_doc_type.."+sales_doc_type);
		ArrayList alSalesDocNoList = bean.getSalesDocNoArrayList(patient_id,encounter_id,trn_type,sales_doc_type,itemToFilter);
		HashMap record	=	null;
		//out.println("clearListItems('document.formSalesReturnHeader.sales_doc_no'); ");
		out.println("document.formSalesReturnHeader.sales_doc_no.value = '';");
		for(int i=0; i< alSalesDocNoList.size(); i++) {
			result = true;
			record	=	(HashMap)alSalesDocNoList.get(i);
			String listRecord	=	(String)record.get("SALES_DOC_NO");
			//out.println("addListItem(\"document.formSalesReturnHeader.sales_doc_no\", \"" +listRecord+ "\",\"" +listRecord+ "\"); ");
			out.println("document.formSalesReturnHeader.sales_doc_no.value = '" +listRecord+ "';");
		}
	}
	else if(validate.equals("LOADDOCTYPE")){
		result = true;
		patient_id = request.getParameter("patient_id");
		String itemCode = request.getParameter("itemCode")==null||request.getParameter("itemCode").equals("")?"%":(String)request.getParameter("itemCode");
		String salTrnType = request.getParameter("salTrnType")==null||request.getParameter("salTrnType").equals("")?"":(String)request.getParameter("salTrnType");
		String siteId  = request.getParameter("siteId")==null||request.getParameter("siteId").equals("")?"":(String)request.getParameter("siteId");
		//String alSalesDocNoList = bean.getSalesDocType(patient_id);
		String[] stParameters= new String[6];
		stParameters[0] = patient_id;
		stParameters[1] = facility_id;
		stParameters[2] = salTrnType;
		stParameters[3] = store_code;
		stParameters[4] = itemCode;
		stParameters[5] = locale;
		//System.out.println("patient_id = > "+patient_id+" itemCode = > "+itemCode+" salTrnType = >"+salTrnType+" facility_id = > "+facility_id+" store_code = > "+store_code+" sales_doc_type_code = > "+sales_doc_type_code+" itemCode = > "+itemCode);
		out.println("document.formSalesReturnHeader.sales_doc_type.value = '';");
		/*ArrayList alSalesTypeList = bean.getSalesDocTypeArrayList(stParameters);
		HashMap record	=	null;
		if(siteId.equals("MC"))
		out.println("clearListItems('document.formSalesReturnHeader.sales_doc_type'); ");		
		for(int i=0; i< alSalesTypeList.size(); i++) {
			result = true;
			record	=	(HashMap)alSalesTypeList.get(i);
			String listRecord	=	(String)record.get("DOC_TYPE");
			String list[] = listRecord.split("!~!");
			if(siteId.equals("MC"))
			out.println("addListItem(\"document.formSalesReturnHeader.sales_doc_type\", \"" +list[0]+ "\",\"" +list[1]+ "\"); ");
			out.println("document.formSalesReturnHeader.sales_doc_type.value = '" +list[0]+ "';");
			
		}*/
	}
	else if (validate.equals("CHECK_STORE_SALESTYPE")){

	String sal_trn_type			=		request.getParameter("sal_trn_type")==null?"I":request.getParameter("sal_trn_type");
	store_code					=		request.getParameter("store_code")==null?"":request.getParameter("store_code");
	String  result_bean			=		bean.CheckStoreSalesType(store_code,sal_trn_type);
	String result1				=		"";

	
	if(result_bean.equals("N")){
				result			=	false;
			//	message			=	"done";
				 result1		=	"Y";
				
				out.println("alert(getMessage('INVALID_SALES_TYPE_FOR_STORE','ST'));");
				out.println("addList();");
				   
				 }

			else{
				 result1		=	"y";
				 result			=	false;
				
			}
					

	}else if(validate.equals("TOTAL_QTY")){
		double tmp_conv=bean.getConvFactTemp(item_code,store_code);
			result=true;
			String tot_item_qty = 	""+(tmp_conv * Double.parseDouble((String)item_qty));
/**
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - 15496
 * @Desc -  Decimal handling in item based.dec_allowed_yn 
 */
			//int no_of_decimals1=bean.getNoOfDecimals();
			
			if(bean.getAllowDecimalsYN( item_code).equals("Y")){
			//tot_item_qty=bean.setNumber(tot_item_qty,no_of_decimals1);
				tot_item_qty=bean.setNumber(""+tot_item_qty,no_of_decimals);
			}else{
				tot_item_qty=bean.setNumber(""+tot_item_qty,0);
			}
			out.println("document.formSalesReturnListHeader.tot_item_qty.value = '"+tot_item_qty+"';");
			result = true;
	}else if(validate.equals("DISP_DETAILS")){
			encounter_id = bean.checkForNull(request.getParameter("encounter_id"));
			if(!encounter_id.equals("")){//Added by suresh.r 08-11-2013 against JD-CRF-156 
			String alParameters[]={locale,bean.getLoginFacilityId(),encounter_id,patient_id,locale};
			HashMap nuOrClinic = new HashMap();
			HashMap hmRecord = (HashMap)bean.fetchRecord(StRepository.getStKeyValue("SQL_ST_PATIENT_CLASS_SELECT"),alParameters);
			out.println("document.getElementById('pat_class').innerText='"+bean.checkForNull((String)hmRecord.get("PATIENT_CLASS"))+"'");
			out.println("document.getElementById('room_no').innerText='"+bean.checkForNull((String)hmRecord.get("ASSIGN_ROOM_NUM"))+"'");
			out.println("document.getElementById('bed_no').innerText='"+bean.checkForNull((String)hmRecord.get("ASSIGN_BED_NUM"))+"'");
			out.println("document.getElementById('NU_Clinic_code').innerText='"+bean.checkForNull((String)hmRecord.get("ASSIGN_CARE_LOCN_CODE"))+"'");
			out.println("document.getElementById('patient_classcode').value='"+bean.checkForNull((String)hmRecord.get("PATIENT_CLASS_CODE"))+"'");//Added by suresh r  04-12-2013 against JD-CRF-156
	
			if(((String)hmRecord.get("ASSIGN_CARE_LOCN_TYPE")).equals("N")){
				String alParameters1[]={bean.getLoginFacilityId(),bean.checkForNull((String)hmRecord.get("ASSIGN_CARE_LOCN_CODE")),locale};
				nuOrClinic = (HashMap)bean.fetchRecord(StRepository.getStKeyValue("SQL_ST_NURSING_UINIT_SELECT"),alParameters1);
			}else{
				String alParameters1[]={bean.getLoginFacilityId(),bean.checkForNull((String)hmRecord.get("ASSIGN_CARE_LOCN_CODE")),locale};
				nuOrClinic = (HashMap)bean.fetchRecord(StRepository.getStKeyValue("SQL_ST_CLINIC_SELECT"),alParameters1);
			}
			String desc = java.net.URLEncoder.encode((String)nuOrClinic.get("SHORT_DESC"));
			out.println("diss('"+desc+"');");
						//out.println("document.getElementById("NU_Clinic").innerText='"+bean.checkForNull((String)nuOrClinic.get("SHORT_DESC"))+"'");
			}else{//Added by suresh.r 08-11-2013 against JD-CRF-156 beg
				if(bean.getBLModuleInstalled().equals("Y")){
					out.println("document.getElementById('id_polexp').style.visibility = 'hidden';");
					out.println("document.getElementById('id_fin_dtl').style.visibility = 'hidden';");
				}
			}//Added by suresh.r 08-11-2013 against JD-CRF-156  end

		}
		else if (validate.equals("ENCOUNTER_NEW_LIST"))
			{
			//System.out.println("ENCOUNTER_NEW_LIST");
			String trn_type = (String)request.getParameter("trn_type");
			String siteId = (String)request.getParameter("siteId");
			String encounter_id1 = (String)request.getParameter("encounter_id");				
			try{
			    	ArrayList alEncounterList = bean.getEncounterNewArrayList(patient_id,encounter_id1,trn_type,siteId);
					HashMap record	=	null;
					for(int i=0; i< alEncounterList.size(); i++) {
						record	=	(HashMap)alEncounterList.get(i);
						String listRecord	=	(String)record.get("ENCOUNTER_ID");
						if ( listRecord.equals(encounter_id1)){
							//System.out.println("encounter_idif");
							result			=	true;
						}
						else{
							//System.out.println("encounter_idelse");
							result			=	false;
						}
					}				
			}
			catch(Exception exception){
				exception.printStackTrace();
				flag			=	"INVALID_ENCOUNTER";
				result			=	false;
			}
		}
	else if(validate.equals("NURSING_UNIT_LIST")) {			
			out.println("clearListItems('formSalesReturnQueryCriteria.nursing_unit_code'); ");
			String fromdate = bean.checkForNull(request.getParameter("fromdate"),com.ehis.util.DateUtils.getCurrentDate("DMY",locale));
			String todate = bean.checkForNull(request.getParameter("todate"),com.ehis.util.DateUtils.getCurrentDate("DMY",locale));
			ArrayList nursingunit = bean.getNursingUnitCodeListNewArr(fromdate, todate);			
			HashMap record = null;
			for(int i=0; i< nursingunit.size(); i++) {
				record = (HashMap)nursingunit.get(i);
				out.println("addListItem(\"formSalesReturnQueryCriteria.nursing_unit_code\", \"" + record.get("CLINIC_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}
		//Added by suresh r  14-11-2013 against JD-CRF-156 beg(For Display Encounter Financial Details valaidation)
	else if(validate.equals("VAL_DISPFINDTL")){
		encounter_id = bean.checkForNull(request.getParameter("encounter_id"),"");
		if(bean.getBLModuleInstalled().equals("Y")){
			String pat_class = bean.checkForNull(request.getParameter("pat_class"));
			String encntr_fin_dtl_yn=  bean.getUserAccCurrEncntrFinDdtlYN(store_code,bean.getLoginById());
			if(encntr_fin_dtl_yn.equals("Y")){
				if(encounter_id!=""){
					out.println("document.getElementById('id_fin_dtl').style.visibility = 'visible';");
					String param[]={bean.getLoginFacilityId(),encounter_id,pat_class,patient_id};
					if(!bean.getPolicyExp(param)){
						out.println("document.getElementById('id_polexp').style.visibility = 'visible';");
					}else{
						out.println("document.getElementById('id_polexp').style.visibility = 'hidden';");
					}
				}else{
					out.println("document.getElementById('id_fin_dtl').style.visibility = 'hidden';");
					out.println("document.getElementById('id_polexp').style.visibility = 'hidden';");
				}
			}
		}
	}//Added by suresh r  14-11-2013 against JD-CRF-156 end
	//Added against GHL-CRF-0413.5 starts
	else if(validate.equals("HEADER_DETAILS")){
		String hdr_barcode = request.getParameter("bar_code");
		String hdr_itemcode = request.getParameter("item_code");
		result = false;
		try{
			ArrayList alDtlBarcode = bean.getDtlRecords();
			for(int y =0;y< alDtlBarcode.size();y++){
				HashMap hmPerRecord = new HashMap();
				hmPerRecord = bean.getDtlRecord(y);
				  if(hmPerRecord.containsValue(hdr_itemcode)){
					  String hdr_available_qty = bean.checkForNull( (String)hmPerRecord.get("available_qty"), (String)hmPerRecord.get("stock_available"));
					  String hdr_stock_available = (String)hmPerRecord.get("stock_available");
					 String  hdr_uom_desc = (String)hmPerRecord.get("uom_desc");
					 String  hdr_item_desc = (String)hmPerRecord.get("item_desc");
					//Added for IN:073899 start
					 if(!hdr_item_desc.equals("")&&hdr_item_desc!=null){
						 hdr_item_desc=hdr_item_desc.replaceAll(" ","%20");
						 hdr_item_desc=	java.net.URLEncoder.encode(hdr_item_desc,"UTF-8");
						 hdr_item_desc=hdr_item_desc.replaceAll("%2520","%20");
						}
					//Added for IN:073899 start
					out.println("document.getElementById('id_pending_qty').innerHTML = '<B>"+hdr_available_qty+"</B>';");
					out.println("document.getElementById('item_desc').value = decodeURIComponent('"+hdr_item_desc+"');");//Modified for IN:073899
					out.println("document.getElementById('item_code').value = '"+hdr_itemcode+"';");
					out.println("document.getElementById('item_desc').disabled=true");
					out.println("document.getElementById('id_uom').innerHTML = '<B>"+hdr_uom_desc+"</B>';");
					out.println("document.getElementById('id_uom_base').innerHTML = '<B>"+hdr_uom_desc+"</B>';");
					out.println("document.getElementById('max_returnable_qty').value = '"+hdr_stock_available+"';");
					out.println("document.getElementById('id_item_sal_value').value = '"+(String)hmPerRecord.get("item_cost_value")+"';");
					out.println("document.getElementById('store_item_unit_cost').value = '"+(String)hmPerRecord.get("item_unit_cost")+"';");
					out.println("document.getElementById('uom_code').value = '"+(String)hmPerRecord.get("uom_code")+"';");
					out.println("document.getElementById('sal_doc_srl_no').value = '"+(String)hmPerRecord.get("sal_doc_srl_no")+"';");
					out.println("document.getElementById('sales_doc_type_code').value = '"+(String)hmPerRecord.get("sales_doc_type_code")+"';");
					out.println("document.getElementById('sales_doc_no').value = '"+(String)hmPerRecord.get("sales_doc_no")+"';");
				String billable_item_yn1 =  	(String)bean.fetchRecord("select BILLABLE_ITEM_YN  from mm_item where ITEM_CODE = ?",new String[]{hdr_itemcode}).get("BILLABLE_ITEM_YN");
				out.println("document.getElementById('billable_item_yn').value = '"+billable_item_yn1+"';");	
				String billmodule_yn = (String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_SAL_CHARGEABLE_YN")).get("BL_INTERFACE_YN");
				out.println("document.getElementById('billmodule_yn').value = '"+billmodule_yn+"';");	
				if(billmodule_yn.equals("Y") && billable_item_yn1.equals("Y")){
				out.println("document.getElementById('id_charge_amt').style.visibility ='visible'"); //id_char_amt
				out.println("document.getElementById('id_char_amt').style.visibility ='visible'"); //id_char_amt
				out.println("document.getElementById('id_charge_amt').innerText = '0.00';"); 
				}
					result = true;
				  }
			}
		} catch(Exception exception){
			exception.printStackTrace();
			flag			=	"HEADER_DETAILS";
			result			=	false;
		}
	}else if(validate.equals("clearTmpBean"))  { 
		 try{
			 bean.getTempBatchRecords().clear();
			 bean.getAlTempExpRecords().clear();
		   }
		   catch(Exception exception){
				exception.printStackTrace();
				flag			=	"clearTmpBean";
				result			=	false;
			}
	}
	else if(validate.equals("SET_IN_BEAN_SRT"))  { 
		String doc_srl_no_forbean = request.getParameter("doc_srl_no_forbean");
		String bar_code = request.getParameter("barcode");
		String item_code1 = request.getParameter("item_code");
		int srl_no = Integer.parseInt(doc_srl_no_forbean);
		try{
				ArrayList OldExpRecords = new ArrayList();
				ArrayList alBatchRecords_tmp = new ArrayList();
				ArrayList alBatchRecords_tmp1 = new ArrayList(bean.getTempBatchRecords());
				bean.setExpRecords(srl_no, alBatchRecords_tmp1);
		   }
		   catch(Exception exception){
				exception.printStackTrace();
				flag			=	"SET_IN_BEAN_SRT";
				result			=	false;
			}
	}
	else if(validate.equals("VALIDATE_STORE"))  { 
		System.err.println("VALIDATE_STORE starts");
		String valid_barcode = request.getParameter("barcode");
		String valid_store_code = request.getParameter("store_code");
		try{
		String valid_item_code ="";
		 String barcode_2d_applicable_yn = bean.barcode2DApplicable();//Added for MMS-DM-CRF-0174.6
				 if(barcode_2d_applicable_yn.equals("Y")){//Added if else condition for MMS-DM-CRF-0174.6
                       valid_item_code =bean.get2DBarcodeItem(valid_store_code,valid_barcode);
				 }else{
		               valid_item_code	=bean.checkForNull((String)	bean.fetchRecord("select item_code from st_item_batch where barcode_id = ? and store_code = ?",new String[]{valid_barcode,valid_store_code}).get("ITEM_CODE"),"");
				 }
		int item_store_exists = 0;
		item_store_exists=Integer.parseInt((String)	bean.fetchRecord("select count(*) COUNT from ST_ITEM_STORE where store_code = ? and item_code =? and eff_status = 'E'",new String[]{valid_store_code,valid_item_code}).get("COUNT"));
		System.err.println("item_store_exists"+item_store_exists);
		 if(item_store_exists>0)
	   	  result = true;
		else
	   	  result = false;
		}
		catch(Exception exception){
			exception.printStackTrace();
			flag			=	"VALIDATE_STORE";
			result			=	false;
		}
	}
	else if(validate.equals("VALIDATE_SRT"))  { 
		String valid_barcode = request.getParameter("barcode");
		String valid_store_code = request.getParameter("store_code");
		result = false;
		try{
		 HashMap salDocDtl = null;
		 salDocDtl=	(HashMap)bean.fetchRecord("select PATIENT_ID,  ENCOUNTER_ID, SAL_TRN_TYPE  from st_sal_hdr where FACILITY_ID = ? and DOC_TYPE_CODE  = ? and DOC_NO =?",new String[]{bean.getLoginFacilityId(),bean.getSalesDocTypeCode(),bean.getSalesDocNo()});
		 String valid_pat_id = (String)salDocDtl.get("PATIENT_ID");
		 String valid_enc_id = bean.checkForNull((String)salDocDtl.get("ENCOUNTER_ID"),"");
		 String sal_trn_type = (String)salDocDtl.get("SAL_TRN_TYPE");
		 ArrayList alDtlRecords = new ArrayList();
		 HashMap hmExpRecords = null;
		 alDtlRecords = bean.getDtlRecords();
		 String valid_item_code = bean.checkForNull((String) bean.fetchRecord("select ITEM_CODE from st_sal_dtl_exp where FACILITY_ID=? and DOC_TYPE_CODE=? and doc_no = ? and STORE_CODE =? and BARCODE_ID = ?",new String[]{bean.getLoginFacilityId(),bean.getSalesDocTypeCode(),bean.getSalesDocNo(),valid_store_code,valid_barcode}).get("ITEM_CODE"),"");
		 //Added for TFS id: 11896 start
		 double tmp_conv=bean.getConvFactTemp(valid_item_code,valid_store_code);

			out.println("setConvFactor(\""+tmp_conv+"\");");
			//Added for TFS id: 11896 end
		 for(int i=0;i<alDtlRecords.size();i++){
			 HashMap hmDtlRecords = (HashMap)alDtlRecords.get(i);
			 if(hmDtlRecords.containsValue(valid_item_code)){
		  ArrayList alExpList = bean.getBatchExpRecords(valid_pat_id,valid_enc_id,valid_item_code,valid_store_code,sal_trn_type);
			for(int j=0;j<alExpList.size();j++){
				hmExpRecords = (HashMap)alExpList.get(j);
				if(hmExpRecords.containsValue(valid_barcode)){
					result = true;
					out.println("calHeaderDetails(\""+valid_barcode+"\",\""+valid_item_code+"\");");
						}
					}
				}
			}
		 }
			catch(Exception exception){
			exception.printStackTrace();
			flag			=	"VALIDATE_SRT";
			result			=	false;
		}
	}
	//Added against GHL-CRF-0413.5 ends
	}catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		if(!validate.equals("LoadDocType"))
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}

            _bw.write(_wl_block3Bytes, _wl_block3);

putObjectInBean( bean_id,bean,request);

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
