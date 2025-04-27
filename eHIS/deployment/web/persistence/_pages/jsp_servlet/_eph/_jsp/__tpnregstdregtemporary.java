package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.Common.*;
import ePH.*;
import eOR.*;
import java.io.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __tpnregstdregtemporary extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/TPNRegStdRegTemporary.jsp", 1742369994215L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t";
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

	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");

            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	//String params	= request.getQueryString();
	String bean_id				= request.getParameter( "bean_id" ) ;
	String bean_name			= request.getParameter( "bean_name" ) ;
	
	String accession_num="";
	String patient_id			= request.getParameter( "patient_id" );
	String encounter_id			= request.getParameter( "encounter_id" ) ;
	if(request.getParameter("Mode")!=null && request.getParameter("Mode").equals("ClearBean")){
		TPNStandardRegimenBean bean	= (TPNStandardRegimenBean)getBeanObject(bean_id,bean_name,request) ;
		TPNRegimenBean oRegimenBean	= (TPNRegimenBean)getBeanObject( "@TPNRegimenBean"+patient_id+encounter_id, "ePH.TPNRegimenBean", request);
		TPNNonStandardRegimenBean oNonStandardRegimenBean = (TPNNonStandardRegimenBean)getBeanObject("@TPNNonStandardRegimenBean"+patient_id+encounter_id,"ePH.TPNNonStandardRegimenBean", request);
		bean.clear();
		oRegimenBean.clear();
		oNonStandardRegimenBean.clear();
	}
	else{
		String orderdate			= request.getParameter( "orderdate" ) ; 
		String facility_id          = (String)session.getValue( "facility_id" );
		String login_user	        = (String)session.getValue("login_user");
		if ( bean_id == null || bean_id.equals( "" ) )
			return ;

		String regcode							=request.getParameter("regcode");
		String action							=request.getParameter("action");
		String tpn_std_reg_freq	 =request.getParameter("tpn_std_reg_freq")==null?"":request.getParameter("tpn_std_reg_freq"); //added for Ml-MMOH-CRF-1126
		String act_patient_class = request.getParameter("act_patient_class")==null?"":request.getParameter("act_patient_class");//added for Ml-MMOH-CRF-1126 
		String weight=request.getParameter("weight");
		String fluidValuesStd = "";
		String t_volume="";
		ArrayList fluidReq			= new ArrayList(); 
		if(weight == null)
			weight="";
		
		TPNStandardRegimenBean bean	= (TPNStandardRegimenBean)getBeanObject(bean_id,bean_name,request) ;
		bean.setLanguageId(locale);
		//String AccessionNumber							=request.getParameter("validate");
		if(action.equals("ACCESSIONNUMBER")){
		
			HashMap record2=new HashMap(); 
			String tpn_screening_type="";
			String note_type="";
		
			record2=bean.ChkAdMixture();
			tpn_screening_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_TYPE"));
			note_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_FORM_ID"));
		   
			if(!tpn_screening_type.equals("")){
				HashMap record3=new HashMap();
				record3=bean.ChkScreeningDetails(facility_id,encounter_id,note_type);
				accession_num=CommonBean.checkForNull((String)record3.get("ACCESSION_NUM"));
			 }
			 //out.println("document.tpnStandardRegimen.accession_num.value='"+accession_num+"';"); 
			 out.println("CheckAccessionNumber(\""+ accession_num + "\",\""+ tpn_screening_type + "\");");
		}
		if (action.equals("DISCRETE1")) {
			HashMap record2=new HashMap(); 
			String tpn_screening_type="";
			String note_type="";
			String test_observ_dt_tm="";
			
			record2=bean.ChkAdMixture();
			tpn_screening_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_TYPE"));
			note_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_FORM_ID"));
				   
			if(tpn_screening_type.equals("D")){
				HashMap record3=new HashMap();
				record3=bean.ChkDiscrete(facility_id,encounter_id,note_type);
				test_observ_dt_tm=CommonBean.checkForNull((String)record3.get("TEST_OBSERV_DT_TM"));
			}
			out.println("beforDiscrete1(\""+ test_observ_dt_tm + "\",\""+ tpn_screening_type + "\");");
		}
		if(!locale.equals("en")); //added for [IN:031523] to avoid leap year issue 
		orderdate  = com.ehis.util.DateUtils.convertDate(orderdate, "DMYHM",locale,"en"); //added for [IN:031523] to avoid leap year issue 
		ArrayList regDetails					= new ArrayList();
		regDetails							= bean.getRegimenDetails(regcode,orderdate);
		fluidReq							    = bean.getFluidRequired(patient_id); 
	   	if(fluidReq != null)
			fluidValuesStd			= (String)fluidReq.get(3);

		t_volume=bean.getVolueme(regcode);
		if(t_volume == null)
			t_volume="";
		try{
			if (action.equals("REGIMENSELECT")){
				if (regDetails.size()>0){
					String infroute			="";
					//String totalvolume		="";
					String volunit				="";
					String infuseover		="";
					//String infusedurn		="";
					String authreqd			="";
					String cosignreqd		="";
					String splappreqd		="";
					//String freqcode			="";
					String durnvalue	 		="";
					String durnexcdaction	="";
					String promptmsg		="";
					String maxdurn			="";
					String consentreqd		="";
					String enddate			="";
					try{
					infroute			=(String)regDetails.get(0);
					//	totalvolume			=(String)regDetails.get(1);
					volunit				=(String)regDetails.get(2);
					infuseover			=(String)regDetails.get(3);
					//infusedurn			=(String)regDetails.get(4);	
					authreqd			=(String)regDetails.get(5);	
					cosignreqd			=(String)regDetails.get(6);	
					splappreqd			=(String)regDetails.get(7);	
					//	freqcode			=(String)regDetails.get(8);	
					durnvalue	 		=(String)regDetails.get(9);	
					durnexcdaction		=(String)regDetails.get(10);	
					promptmsg			=(String)regDetails.get(11);	
					maxdurn				=(String)regDetails.get(12);	
					consentreqd			=(String)regDetails.get(13);	
					//enddate				=(String)regDetails.get(14); // commented for [IN:031523] to avoid leap year issue
					enddate	 = com.ehis.util.DateUtils.convertDate((String)regDetails.get(14),"DMYHM","en",locale); // added for [IN:031523] to avaoid leap year issue
					String order_type	= bean.getOrderType(regcode);//Added for Bru-HIMS-CRF-393_1.0
					bean.setOrderType(order_type);//Added for Bru-HIMS-CRF-393_1.0
				}
				catch(Exception e){
					out.println("alert(getMessage('PH_ORDER_CATALOG','PH'));");
					out.println("callCancel();");
					return;
				}
				if(!weight.equals("") && !fluidValuesStd.equals("")){
				//totalvolume=new Float(Math.ceil(Float.parseFloat(weight)*Float.parseFloat(fluidValuesStd))).intValue()+""; 
				}
				//totalvolume=volume;
				out.println("document.tpnStandardRegimen.volume.value='"+t_volume+"';");   
				out.println("document.getElementById('volumeunit').innerText='"+CommonBean.checkForNull(bean.getUomDisplay(facility_id,volunit))+"';");
				out.println("document.tpnStandardRegimen.infuseover.value='"+infuseover+"';"); 
				out.println("document.tpnStandardRegimen.unitofvolume.value='"+volunit+"';");
				if (infroute.equals("C")){
					out.println("document.tpnStandardRegimen.infroute.selectedIndex=0;");
					out.println("document.tpnStandardRegimen.infroute.disabled=true;");
				}
				else{
					out.println("document.tpnStandardRegimen.infroute.selectedIndex=1;");
					out.println("document.tpnStandardRegimen.infroute.disabled=false;");
				}
			/*	if (infusedurn.equals("H"))
				{
						out.println("document.tpnStandardRegimen.infuseoverdrn.selectedIndex=0;");
				}
				else
				{
						out.println("document.tpnStandardRegimen.infuseoverdrn.selectedIndex=1;");
				} */
				//write the order catalog information
				out.println("document.tpnStandardRegimen.max_duration.value="+maxdurn+";");
				out.println("document.tpnStandardRegimen.action_type.value='"+durnexcdaction+"';");
				out.println("document.tpnStandardRegimen.action_msg.value='"+promptmsg+"';");
				out.println("document.tpnStandardRegimen.duration.value="+durnvalue+";");
				out.println("document.tpnStandardRegimen.enddate.value='"+enddate+"';");
				if(tpn_std_reg_freq.equals("true")){ //added for Ml-MMOH-CRF-1126 - start
				String freq_code = "";	
				HashMap tpnFreq = bean.getTPNContFreq(regcode,act_patient_class);

					if(tpnFreq!=null){
						freq_code = (String)tpnFreq.get("defTpnFreqCode");
						ArrayList contFreq = (ArrayList)tpnFreq.get("conTpnFreqList");
							for(int i=0;i<contFreq.size();i+=2){
								out.println("addFrequencyList('"+((String) contFreq.get(i))+"','"+((String) contFreq.get(i+1))+"','"+freq_code+"')");
							}	
					  }
				}//added for Ml-MMOH-CRF-1126 - end

				//Hide or show Cosign, Authorization and Special Approval links
				out.println("hideAllLinks();");
				if (authreqd.equals("Y")){
					out.println("showLink('AuthReqd');");
					out.println("document.tpnStandardRegimen.authreqdYN.value='Y'");
				}
				if (cosignreqd.equals("Y")){
					out.println("showLink('CosignReqd');");
					out.println("document.tpnStandardRegimen.cosignreqdYN.value='Y'");
				}
				if (splappreqd.equals("Y")){
					out.println("showLink('SplAppReqd');");
					out.println("document.tpnStandardRegimen.splappreqdYN.value='Y'");
				}
				if (consentreqd.equals("Y")){
					out.println("showLink('ConsentReqd');");
					out.println("document.tpnStandardRegimen.consentreqdYN.value='Y'");
				}
				//out.println("defaultFrequency('"+freqcode+"')");
			}//end of regDetails.size()>0
		}
		else if (action.equals("REMARKS")){

			String or_bean_name	= "eOR.OrderEntryBean";
			String or_bean_id	= "@orderentrybean"+patient_id+encounter_id;

			OrderEntryBean orbean = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
			orbean.setLanguageId(locale);
			eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();

			String order_catalog_code	= request.getParameter("drug_code");
			String order_type				= bean.getOrderType(order_catalog_code);
			String click_yn				=  request.getParameter("click_yn");// click_yn added for [IN:039576]
			//String form_code				= request.getParameter("form_code");
			//String route_code				= request.getParameter("route_code");
			String order_category			= "PH";

			String format_id					= bean.getFormatId(order_category, order_type, order_catalog_code);
			out.println("validateRemarks('" + format_id + "','" + click_yn + "');");// click_yn added for [IN:039576]
			putObjectInBean(or_bean_id,orbean,request);	

		}
		else if (action.equals("SUBMIT")){
			String drugcode				= request.getParameter("drug_code");
			String buildMAR_yn				= request.getParameter("buildMAR_yn")==null?"":request.getParameter("buildMAR_yn");
			String or_bean_name			= "eOR.OrderEntryBean";
			String or_bean_id			= "@orderentrybean"+patient_id+encounter_id;
			OrderEntryBean orbean		= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
			orbean.setLanguageId(locale);
			eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean)orbean.getOrderEntryRecordBean();

			//ArrayList	Remarks	= new ArrayList();

			HashMap orderFormatHash	= new HashMap();	// To store it in the HashMap
			ArrayList arrSeq_num			= new ArrayList();	// get the seq in ArrayList
			Hashtable template				= new Hashtable();	// get the template values in the HashTable
//			int seq_num 						= 0;
			String seq_num 						= "";

			String order_format_values	= "";
			String row_value				= (drugcode+"_"+"0");
			String catalog_code			=drugcode;
			arrSeq_num						= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(catalog_code, row_value);

			if(arrSeq_num != null && arrSeq_num.size() >0){
				int k	=0;
				for(k=0;k<arrSeq_num.size();k++){
					//seq_num		= ((Integer)arrSeq_num.get(k)).intValue();	// get the seq_num
					seq_num		= (String)arrSeq_num.get(k);	// get the seq_num
					template	= (java.util.Hashtable)orderEntryRecordBean.getOrderFormats(catalog_code, (catalog_code+seq_num));
					
					orderFormatHash.put("seq_num"+k,String.valueOf(seq_num));
					orderFormatHash.put("field_mnemonic"+k,(String) template.get("field_mnemonic"));
					orderFormatHash.put("label_text"+k,(String) template.get("label_text"));
					orderFormatHash.put("accept_option"+k,(String) template.get("accept_option"));
					orderFormatHash.put("field_type"+k,(String) template.get("field_type"));
					orderFormatHash.put("field_values"+k,(String) template.get("field_values"));
					order_format_values += ((String) template.get("label_text") + " : " + (String) template.get("field_values")) +",";
				}
				orderFormatHash.put("order_format_count", (String.valueOf(k)));
				orderFormatHash.put("order_format_values", order_format_values);
			}
			bean.setRegimenRemarks(orderFormatHash);
			bean.setBuildMAR_yn(buildMAR_yn);
			//bean.setRegimenRemarks(buildMAR_yn);
			putObjectInBean(or_bean_id,orbean,request);
		}
		else if (action.equals("NPCVal")){
			String reg_code=request.getParameter("regcode");
			ArrayList record=new ArrayList();
			String volume="";
			String npcval="";
			record=bean.getNPCValue(reg_code);
			if(record.size()!=0){
				npcval=(String)record.get(0);
				volume=(String)record.get(1);
				if(npcval == null)
					npcval="";
				if(volume == null)
					volume="";
				out.println("document.getElementById('npc_val').innerHTML='<B>NPC:N Ratio "+npcval+" :1</B>';");
				out.println("document.tpnStandardRegimen.volume.value='"+volume+"';");
			}
		 }
		 else if(action.equals("OnlineReport")){
			String patient_class=request.getParameter("patient_class"); 
			String order_id=request.getParameter("order_id"); 
			if(order_id == null){
				order_id="";
			} 
			String report_id = "PHBOPPTPN";
			String ReportOutput		=	"";
			if(order_id.equals("")){ 
				order_id=bean.getOrderID(); 
			}
			ecis.utils.OnlineReports onlineReports		=	null;
			ecis.utils.OnlineReport report1				=	null;
			onlineReports 		= new ecis.utils.OnlineReports() ;
			report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
			report1.addParameter("p_order_id",order_id);
			report1.addParameter("p_patclass",patient_class);
			report1.addParameter("p_locncode","");
			report1.addParameter("p_iv_prep_yn","7");
			report1.addParameter("p_report_id",report_id) ;  
			report1.addParameter("p_user_name",login_user) ;
			report1.addParameter("p_facility_id",facility_id) ;  
			report1.addParameter("p_module_id", "PH") ;
			report1.addParameter("p_language_id", bean.getLanguageId());
			report1.addParameter("p_patient_id", patient_id);//code added for SKR-SCF-0915[IN046734]
			onlineReports.add( report1) ; 
			ReportOutput = onlineReports.execute( request, response );  
		}
		else if (action.equals("CALCULATEENDDATE")){
			String sdate			= request.getParameter("sdate");
			if(!locale.equals("en")); //
			sdate  = com.ehis.util.DateUtils.convertDate(sdate, "DMYHM",locale,"en"); //added for [IN:031523] to avoid leap year issue 
			String durn			= request.getParameter("duration");
			String  enddate		= "";
			enddate				= bean.getEndDate(sdate,durn);
			enddate             = com.ehis.util.DateUtils.convertDate(enddate, "DMYHM","en",locale); //added for [IN:031523] to avoid leap year issue
			out.println("document.tpnStandardRegimen.enddate.value='"+enddate+"';");
		}
		//added for ml-mmoh-crf-1290 start
		else if (action.equals("PROMTALERT")){
			
			String drug_code	= request.getParameter("drug_code") ;
			System.out.println("drug_code in tem file"+drug_code);
			String  promptalertmsg=bean.getAlert_YN(drug_code);
			promptalertmsg=promptalertmsg.replaceAll(" ","%20");
			promptalertmsg = java.net.URLEncoder.encode(promptalertmsg,"UTF-8");
			promptalertmsg=promptalertmsg.replaceAll("%2520","%20");
			if(! promptalertmsg.equals("") && !( promptalertmsg==null )){
			  out.println("returncheckforpromptalertmsg('"+promptalertmsg+"')");
			}
			
		}
			//added for ml-mmoh-crf-1290 end
		out.println("enableAll()");
	}
	catch (Exception e){
			out.println(e);
		}
		putObjectInBean(bean_id,bean,request);
	}

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
