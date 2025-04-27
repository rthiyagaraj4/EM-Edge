package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;
import ePH.Common.*;
import eOR.Common.*;
import ePH.*;
import eOR.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __prescriptionvalidation_2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionValidation_2.jsp", 1729077118602L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
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


	private String getOrderQty(HashMap ext_drugData,String qty_value,String dup_repeat,String durn,String dosage,String conv_factor) {
	String fract_dose				=	(String)ext_drugData.get("FRACT_DOSE_ROUND_UP_YN");
	String dosage_type				=	(String)ext_drugData.get("DOSAGE_TYPE");
	dosage_type						=	dosage;
	String durn_value				=	(String)ext_drugData.get("DURN_VALUE");
	durn_value						=	durn;
	String repeat_value				=	(String)ext_drugData.get("REPEAT_VALUE");
	repeat_value					=	dup_repeat;
	String content_in_pres_base_uom	=	(String)ext_drugData.get("CONTENT_IN_PRES_BASE_UOM");
	String strength_per_value_per_pres_uom	= (String)ext_drugData.get("STRENGTH_PER_VALUE_PRES_UOM");
	String strength_per_pres_uom			= (String)ext_drugData.get("STRENGTH_PER_PRES_UOM");
	String interval_value					= (String)ext_drugData.get("INTERVAL_VALUE");
	String freq_nature						= (String)ext_drugData.get("FREQ_NATURE");

	String ord_qty					=	"";
	String	tmp_qty					=	"";
	try {
		if(dosage_type!=null && dosage_type.equals("A")){
			ord_qty	=	qty_value;
		} 
		else if(dosage_type!=null && dosage_type.equals("Q")){

			if(!fract_dose.equals("Y")) {
				ord_qty		=  (Float.parseFloat(qty_value)*Float.parseFloat(durn_value)*Float.parseFloat(repeat_value) * Float.parseFloat(conv_factor))+"";
				ord_qty		=	Math.ceil(Float.parseFloat(ord_qty)/(Float.parseFloat(content_in_pres_base_uom)))+"";
			}
			else {
				if( (Float.parseFloat(qty_value)*Float.parseFloat(conv_factor)) < Float.parseFloat(content_in_pres_base_uom)) {
					tmp_qty	=	1+"";
				}
				else {
					tmp_qty	=  Math.ceil((Float.parseFloat(qty_value)*Float.parseFloat(conv_factor))/Float.parseFloat(content_in_pres_base_uom))+"";
				}
				 ord_qty	=  (Float.parseFloat(tmp_qty) *Float.parseFloat(durn_value)*Float.parseFloat(repeat_value))+"";
			}
			ord_qty	=	String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
			if(freq_nature.equals("F")) {
				ord_qty	=	String.valueOf(Math.ceil(Float.parseFloat(ord_qty) / Integer.parseInt(interval_value)));
			}
		}
		else if(dosage_type!=null && dosage_type.equals("S")){
			if(!fract_dose.equals("Y")) {	
				//Calculating final order quantity-Multiply by strength_per_pres_value 
				ord_qty		=((Float.parseFloat(qty_value)*Float.parseFloat(durn_value)*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))/(Float.parseFloat(strength_per_pres_uom)))+"";
				ord_qty		=	String.valueOf(Math.ceil(new Double(Float.parseFloat(ord_qty)/Float.parseFloat(content_in_pres_base_uom)).doubleValue()));
			}
			else {
				double unit_qty	= Double.parseDouble(qty_value)*(Double.parseDouble(strength_per_value_per_pres_uom));			
				tmp_qty			=  (unit_qty* Float.parseFloat(durn_value)*Float.parseFloat(repeat_value) +"");
				ord_qty			=  Math.ceil(Float.parseFloat(tmp_qty) /(Double.parseDouble(strength_per_pres_uom)*Float.parseFloat(content_in_pres_base_uom)))+"";	
			}
			ord_qty=String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));

			if(freq_nature.equals("F")) {
				ord_qty	=	String.valueOf(Math.ceil(Float.parseFloat(ord_qty) / Integer.parseInt(interval_value)));
			}
		}
	}
	catch(Exception e) { 
		e.printStackTrace();
	}
	return ord_qty;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
 
/*  

--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
26/07/2019      IN070451		    B Haribabu  26/07/2019       Manickam               ML-MMOH-CRF-1408
13/09/2019      IN071370		    B Haribabu  13/09/2019                              ML-MMOH-CRF-1408
10/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
22/1/2020		IN072172			Shazana		22/1/2020		Manickam				SKR-SCF-1307
28/04/2020  	IN:071537        	B Haribabu                                     	    GHL-CRF-0614
1/7/2020		IN073202			Shazana												SKR-SCF-1343
28/07/2020      IN:073485                   Haribabu                                PH-MMS-DM-CRF-0165/01-Normal rx-Amend order
08/10/2020  	IN073623        	Manickavasagam J                                    ML-BRU-SCF-2042 
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
18/11/2020      IN:8027              Manickavasagam J                             ML-MMOH-CRF-1531
29/11/2020  	IN:7980	        	Manickavasagam J                                    ML-BRU-SCF-2069
13/05/2021  	TFS id:-16701	     Manickavasagam J                                    RBU-GHL-CRF-0004
--------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

	try {
		String func_mode			= request.getParameter("func_mode");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		PrescriptionBean_1 bean		= (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request);
		String locale = bean.getLanguageId();
		String presBean_id			= (String) hash.get( "presBean_id" )==null?"PrescriptionBean":(String) hash.get( "presBean_id" );
		String presBean_name		=  (String) hash.get( "presBean_name" )==null?"ePH.PrescriptionBean":(String) hash.get( "presBean_name" );
		PrescriptionBean presBean 	= (PrescriptionBean)getBeanObject(presBean_id,presBean_name,request);
		//Added for IN:070451 start
		presBean.setPresBean_1(bean);
		bean.setPresBean(presBean);
		//Added for IN:070451 end

		if(func_mode!= null && func_mode.equals("validateDosageLimit")){
			String drug_code	= (String) hash.get( "drug_code" );
			String srl_no					= (String)hash.get("srl_no");
			String qty_value	= (String) hash.get( "qty_value" );
			String repeat_value	= (String) hash.get( "repeat_value" );
			String patient_id	= (String) hash.get( "patient_id" );
			String dosage_type  = (String) hash.get( "dosage_type" );
			String weight	= (String) hash.get( "weight" );//Added for IN:071370
			String height		= (String) hash.get( "height" ); //Added for ML-MMOH-SCF-2514
			String bsa	= (String) hash.get( "bsa" );//Added for IN:071370
			String absol_qty = (String) hash.get( "absol_qty" );//Added for ML-MMOH-SCF-2514
			String freq_nature		= (String) hash.get( "freq_nature")==null?"":(String) hash.get( "freq_nature");
			String display_alert="true";
			String ext_srl_no				= null;
			String ext_drug_code            = null;
			HashMap ext_drugData            = null;  
			ArrayList prescriptionDetails 	=(ArrayList)bean.getpresDetails();
			boolean drugDosageLimitAppl = presBean.isSiteSpecific("PH", "PH_BEY_DOSE_PENCIL_ICON_PRN"); // added for ML-MMOH-CRF-1914
			if(!drugDosageLimitAppl && (freq_nature.equals("P") || freq_nature.equals("O"))&& prescriptionDetails!=null ){ // && prescriptionDetails!=null Added for ML-MMOH-SCF-2514

				for(int j=0;j<prescriptionDetails.size();j++){
				  ext_drugData				=(HashMap) prescriptionDetails.get(j);
				  ext_drug_code				=(String) ext_drugData.get("DRUG_CODE");
				  ext_srl_no				=(String) ext_drugData.get("SRL_NO");
					if( drug_code.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
						ext_drugData.put("LIMIT_IND","Y");
						ext_drugData.put("DOSE_REMARKS","");
						ext_drugData.put("DOSE_REMARKS_CODE","");//Added for IN:073485 
						out.println("disableDosageLimit('"+srl_no+"')");
						return;
					 }
				}
			}

			if(hash.get( "display_alert" )!=null){
				display_alert =(String)hash.get( "display_alert" );
			}
			if(weight!=null && height!=null){ //Added for ML-MMOH-SCF-2514
				presBean.setWeight(weight);//Added for IN:071370
				presBean.setBsa(Float.parseFloat(bsa));//Added for IN:071370
			}
			
			HashMap dosageDetails= (HashMap) presBean.chkMaxDosageLimit(drug_code,patient_id,qty_value,dosage_type,repeat_value);
			String daily_dose	= "";
			String unit_dose	= "";
			String limit_ind	= "";
			String mono_graph	= "";

			limit_ind= (String) dosageDetails.get("LIMIT_IND");
			if(limit_ind == null)
				limit_ind = "";
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData				=(HashMap) prescriptionDetails.get(j);
				ext_drug_code				=(String) ext_drugData.get("DRUG_CODE");
				ext_srl_no				=(String) ext_drugData.get("SRL_NO");
				if( drug_code.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
					//limit_ind=(String) hash.get("limit_ind");
					ext_drugData.put("LIMIT_IND",limit_ind);
					if(limit_ind.equals("Y")){
						ext_drugData.put("DOSE_REMARKS","");
						ext_drugData.put("DOSE_REMARKS_CODE","");//Added for IN:073485 
					}
					break; //Added for ML-MMOH-SCF-2514
				 }
			}
				//Added for IN:070451 end
				//Added for ML-MMOH-SCF-2514 start
					if(drugDosageLimitAppl && freq_nature.equals("P") ){ //added for ml-mmoh-crf-1914
						repeat_value=absol_qty;
		}
					String min_daily_dose	= "";
					String min_unit_dose	= "";
					String max_daily_ceeling_dose	    =   "";
					String min_daily_ceeling_dose	    =   "";
					String max_unit_ceeling_dose	    =   "";
					String min_unit_ceeling_dose	    =   "";
					String dose_unit	= "";
					
				if(limit_ind != null && limit_ind.equals("N")){
					daily_dose = (String) dosageDetails.get("DAILY_DOSE");
					unit_dose = (String) dosageDetails.get("UNIT_DOSE");
					mono_graph = (String) dosageDetails.get("MONO_GRAPH");
					min_daily_dose= (String) dosageDetails.get("MIN_DAILY_DOSE");
					min_unit_dose= (String) dosageDetails.get("MIN_UNIT_DOSE");
					dose_unit= (String) dosageDetails.get("DOSAGE_UNIT");
					//Added for IN:070451 start
					max_daily_ceeling_dose = (String) dosageDetails.get("MAX_DAILY_CEELING_DOSE");
					min_daily_ceeling_dose = (String) dosageDetails.get("MIN_DAILY_CEELING_DOSE");
					max_unit_ceeling_dose = (String) dosageDetails.get("MAX_UNIT_CEELING_DOSE");
					min_unit_ceeling_dose = (String) dosageDetails.get("MIN_UNIT_CEELING_DOSE");
					//Added for IN:070451 end
					ext_drugData.put("LIMIT_IND",limit_ind);
					ext_drugData.put("DAILY_DOSE",daily_dose);
					ext_drugData.put("UNIT_DOSE", unit_dose);
					ext_drugData.put("MONO_GRAPH", mono_graph);
					ext_drugData.put("MIN_DAILY_DOSE", min_daily_dose);
					ext_drugData.put("MIN_UNIT_DOSE", min_unit_dose);
					ext_drugData.put("DOSAGE_UNIT",(String) dosageDetails.get("DOSAGE_UNIT"));
					mono_graph=mono_graph.replaceAll(" ","%20");
					mono_graph = java.net.URLEncoder.encode(mono_graph,"UTF-8");
					mono_graph=mono_graph.replaceAll("%2520","%20");
					String overide_symbol="N";
					String override_remarks=((String) ext_drugData.get("DOSE_REMARKS"))==null?"":((String) ext_drugData.get("DOSE_REMARKS"));
					if(override_remarks.equals("")){
						overide_symbol="Y";
					}
					//Added for ML-MMOH-SCF-2514 end 				
						//mono_graph=mono_graph.replaceAll(" ","%20");
						mono_graph = java.net.URLEncoder.encode(mono_graph,"UTF-8");
						//mono_graph=mono_graph.replaceAll("%2520","%20");
						out.println("enableDosageLimit(\""+display_alert+"\",\""+limit_ind+"\",\""+daily_dose+"\",\""+unit_dose+"\",\""+mono_graph+"\")");
				}
				else{
					out.println("disableDosageLimit('"+srl_no+"')");
					}		
		}
		else if(func_mode!= null && func_mode.equals("saveRemarks")){
			String remarks		= (String) hash.get( "remarks" );
			String page_mode	= (String) hash.get( "page_mode" );
			String srl_no		= (String) hash.get( "srl_no" );
			
			if(remarks.equals("")){
				out.println("alertForOverrideReason()");
				return;
			}
			if(page_mode!=null && (page_mode.equals("curr_rx"))){
				bean.setAmendRxRemarks(srl_no,remarks);	
			}
			else if(page_mode!=null && (page_mode.equals("allergy"))){
				bean.setAmendAllergyRemarks(srl_no,remarks);	
			}
			else if(page_mode!=null && (page_mode.equals("over_dose"))){
				bean.setAmendDoseRemarks(srl_no,remarks);			
			}
			else{	
				bean.setAmendOrderRemarks(remarks);
			}
			out.println("callClose('OK')");
		}
		else if(func_mode!= null && func_mode.equals("storeSchedule")){
			String freq_code		= (String) hash.get( "freq_code" );
			String freq_desc		= (String)hash.get( "freq_desc");
			freq_desc=(String) hash.get("freq_desc");
			freq_desc = java.net.URLDecoder.decode(freq_desc,"UTF-8");
			String freq_nature		= (String)hash.get( "freq_nature");
			String start_date		= (String) hash.get( "start_date" );
			String split_dose_yn	= (String) hash.get( "split_dose_yn" );
			String qty_value		= (String) hash.get( "qty_value" );
			String drug_code		= (String) hash.get( "drug_code" );
			String srl_no			= (String) hash.get( "srl_no" );
			String rowVal			= (String) hash.get( "rowVal" );
			String scheduled_yn		= (String) hash.get( "scheduled_yn" );
			String sch_bean_id		= "OrScheduleFreq" ;
			String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
			Hashtable sch_output	=	null;
			Hashtable schedule_val	=	null; 
			String temp_drug_code	=	""; 
			String temp_srl_no	=	""; 
			//if(schedule.size()==0 && scheduled_yn.equals("Y") ) {
			if( scheduled_yn.equals("Y") ) {
				schedule_val	=	new Hashtable();
				ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name,request);
				schedule_val.put("facility_id", (String)session.getValue("facility_id"));
				schedule_val.put("start_time_day_param", start_date);
				schedule_val.put("module_id", "PH"); 
				schedule_val.put("split_dose_yn", split_dose_yn); 
				schedule_val.put("split_qty",qty_value);
				schedule_val.put("freq_code",  freq_code );
				schedule_val.put("code",drug_code+srl_no);
				sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
				sch_output.put("code",drug_code+srl_no);
				sch_output.put("row_value",rowVal);
				sch_output.put("start_date_time",start_date);
				bean.setScheduleFrequencyStr(sch_output);
				putObjectInBean(sch_bean_id,schedule_bean,request);
			}
			ArrayList presDetails  = (ArrayList) bean.getpresDetails();
			HashMap drugDetails    = null;
			for(int i=0;i<presDetails.size();i++){
				drugDetails    = (HashMap)presDetails.get(i);
				temp_drug_code =(String)drugDetails.get("DRUG_CODE");
				temp_srl_no		=(String) drugDetails.get("SRL_NO");
				if( drug_code.equals(temp_drug_code) && srl_no.equals(temp_srl_no) ){
					drugDetails.put("FREQ_NATURE",freq_nature);
					drugDetails.put("FREQ_CODE",freq_code);
					drugDetails.put("FREQ_DESC",freq_desc);
					drugDetails.put("SCHEDULED_YN",scheduled_yn);
					break;
				}
			}
		}
		else if(func_mode!= null && func_mode.equals("makeScheduleLink")){
			String drug_code	= (String) hash.get( "drug_code" );
			String admin_time	= "";
			String admin_qty    = "";
			float total_qty		= 0.0f;
			String final_qty	= "";
			String freq_durn_type	= "";
			HashMap chkValuescheduleFrequency=bean.getscheduleFrequency();
			ArrayList frequencyValues = new ArrayList();
			if(chkValuescheduleFrequency.size()>0){
				frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code);
			}
			//HashMap data	=	null;
			if(frequencyValues!=null && frequencyValues.size()>0){
				/*admin_time = admin_time + "<tr>";
				for(int i=0;i<frequencyValues.size();i++){
					data=new HashMap();
					data=(HashMap)frequencyValues.get(i);
					String att="class=TIPS";
					admin_time = admin_time + "<td "+att+">&nbsp;"+data.get("admin_time")+"&nbsp;</td>";
				}
				admin_time = admin_time + "</tr>";
				admin_qty = admin_qty + "<tr>";
				for(int i=0;i<frequencyValues.size();i++){
					data	=	new HashMap();
					String att=" class=TIPS";
					data=(HashMap)frequencyValues.get(i);
					admin_qty = admin_qty + "<td "+att+">&nbsp;"+data.get("admin_qty")+"&nbsp;</td>";
					total_qty = total_qty + Float.parseFloat((String) data.get("admin_qty"));

					final_qty	=	(String) data.get("admin_qty");
				}
				admin_qty = admin_qty + "</tr>";*/				
				HashMap freq_char_list = new HashMap();
				ArrayList day_list = new ArrayList();
				//day_list.add("1");	day_list.add("3"); day_list.add("5");
				ArrayList day_names = new ArrayList();
				//day_names.add("Mon");	day_names.add("Wed"); day_names.add("Fri");
				ArrayList time_list = new ArrayList();
				//time_list.add("08:00");	time_list.add("08:00"); time_list.add("08:00");
				ArrayList dose_list = new ArrayList();
				//dose_list.add("500");	dose_list.add("500"); dose_list.add("300");
				//	ArrayList freqCharctValues = new ArrayList();
				/*if(chkValuescheduleFrequency.size()>0){
				frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code);
				}*/
				//	freqCharctValues = frequencyValues;
				admin_time = "";
				admin_qty = "";
					
				if(frequencyValues != null && frequencyValues.size() > 0){
					freq_char_list	= (HashMap)frequencyValues.get(0);
					dose_list	= (ArrayList)frequencyValues.get(4);
					total_qty	= 0.0f;
					for(int tqI=0;tqI<dose_list.size();tqI++){
						total_qty=total_qty+Float.parseFloat((String)dose_list.get(tqI));
						final_qty	=	(String)dose_list.get(tqI);
					}
					String tooltiptable = (String)bean.getTooltipStringFrFreq(frequencyValues,"toolTip");
					admin_time = tooltiptable;	
					freq_durn_type = (String)freq_char_list.get("durationType");
				}
				boolean split_chk	=	bean.checkSplit(frequencyValues);	
				if(split_chk) {
					final_qty		=	String.valueOf(total_qty);
				} 
				out.println("makeScheduleLink('"+admin_time+"','"+admin_qty+"','"+final_qty+"','"+frequencyValues.size()+"','"+split_chk+"','Modify')");
				out.println("setFreqDurnType('"+freq_durn_type+"');");
			}
			else{
				out.println("hideScheduleLink()");
			}
			//variables nullified after usage	
			//data	=	null;
			chkValuescheduleFrequency	=	null;
			frequencyValues	=	null;
		}
		else if(func_mode!= null && func_mode.equals("maxDurnValidation")){
			String drug_code		= (String) hash.get( "drug_code" );
			String patient_class	= (String) hash.get( "patient_class" );
			String duration_value   = (String) hash.get("duration_value");
			String qty_value			=	(String) hash.get("qty_value");
			String abs_qty_value			=	(String) hash.get("abs_qty_value");//Added for BRU-HIMS-CRF-400
			String dosage_type		=	(String) hash.get("dosage_type");
			String repeat_value			=	(String) hash.get("repeat_value");
			String qty_desc		=	(String) hash.get("qty_desc");
			String pres_base_uom			=	(String) hash.get("pres_base_uom");
			String freq_nature		= (String)hash.get("freq_nature")==null?"":(String)hash.get("freq_nature");
			String conv_factor		=	"";
		//added for ML-BRU-SCF-2069 - start
			String called_from		=	(String) hash.get("called_from")==null?"":(String) hash.get("called_from");
			String durationChange   = 	(String) hash.get("durationChange")==null?"":(String) hash.get("durationChange");
			String durn_type        = (String) hash.get("durn_type")==null?"":(String) hash.get("durn_type");
			String freq_durn_type = (String) hash.get("repeat_durn_type")==null?"":(String) hash.get("repeat_durn_type");
		//added for ML-BRU-SCF-2069 - end
			float new_qty=1;
			int total_durn=0;
			if(dosage_type.equals("Q"))
				conv_factor = (String) bean.getConvFactor(qty_desc,pres_base_uom);

			if(conv_factor==null || conv_factor.equals(""))
				conv_factor	=	"1";
			HashMap durnValues = presBean.maxDurnValidation(drug_code,patient_class);
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			if(!freq_nature.equals("P")){
				new_qty=0;
				for(int j=0;j<prescriptionDetails.size();j++){
					HashMap ext_drugData=(HashMap) prescriptionDetails.get(j);
					String ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
					if(!ext_drug_code.equals(drug_code))
						continue;
					String ext_total_durn_value=(String) ext_drugData.get("DURN_VALUE");
					if(qty_value.equals("")||(qty_value==null))
						qty_value=(String) ext_drugData.get("QTY_VALUE");
					if(drug_code.equals(ext_drug_code)){
						total_durn = total_durn + Integer.parseInt(ext_total_durn_value);
					}
					if(dosage_type.equals("A") ) { //added for ML-BRU-SCF-2042
						qty_value	=	abs_qty_value;
					}

			//added for ML-BRU-SCF-2069 - start
			if(called_from!=null && called_from.equals("RENEW_ORDER") && durationChange.equals("Y")){
				if(!durn_type.equals(freq_durn_type)){
					duration_value = (String)bean.getFreqDurnConvValue(freq_durn_type,duration_value,durn_type);
				}
			}
			//added for ML-BRU-SCF-2069 - end

						new_qty=Float.parseFloat(getOrderQty(ext_drugData,qty_value,repeat_value,duration_value,dosage_type,conv_factor));
				}
			}
			else if(freq_nature.equals("P")){//Added for BRU-HIMS-CRF-400
				new_qty = Float.parseFloat(abs_qty_value);
			}
			//added for ML-BRU-SCF-2069 - start
			if(called_from!=null && called_from.equals("RENEW_ORDER") && !durationChange.equals("Y"))
				new_qty = Float.parseFloat(abs_qty_value);
			//added for ML-BRU-SCF-2069 - end

			if(durnValues.size()>0){
				String max_durn_value = (String)durnValues.get("MAX_DURN_VALUE")==null?"":(String)durnValues.get("MAX_DURN_VALUE");
				String chk_for_max_durn_action = (String)durnValues.get("CHK_FOR_MAX_DURN_ACTION")==null?"":(String)durnValues.get("CHK_FOR_MAX_DURN_ACTION");
				String prompt_msg = (String)durnValues.get("PROMPT_MSG")==null?"":(String)durnValues.get("PROMPT_MSG");
				String max_durn_type =(String)durnValues.get("MAX_DURN_TYPE")==null?"":(String)durnValues.get("MAX_DURN_TYPE");
				out.println("assignDurnvalueAmend('"+duration_value+"','"+max_durn_value+"','"+chk_for_max_durn_action+"','"+java.net.URLEncoder.encode(prompt_msg, "UTF-8")+"','"+(int)new_qty+"','"+max_durn_type+"');");
			}	
		}
		else if(func_mode!= null && func_mode.equals("populateStartDate")){

			String sys_date		= (String) hash.get( "start_date" );
			String source		= (String) hash.get( "source" );
			String future_date	= "";
			String back_date    = "";

			HashMap dateParams=(HashMap) presBean.populateDateParams(sys_date);
			if(dateParams.size()>0){
				future_date=(String) dateParams.get("future_date");
				back_date=(String) dateParams.get("back_date");
			}
			out.println("assignAmendStartDate('"+source+"','"+sys_date+"','"+future_date+"','"+back_date+"')");
		}
		else if(func_mode!= null && func_mode.equals("populateEndDate")){
			String start_date			= (String) hash.get( "start_date" );
			String durn_value			= (String) hash.get( "durn_value" );
			String repeat_durn_type		= (String) hash.get( "repeat_durn_type" );
			String freq_nature			= (String) hash.get( "freq_nature" );
			String end_date=(String)bean.populateEndDate(freq_nature,start_date,durn_value,repeat_durn_type);
			out.println("assignAmendEndDate(\""+end_date+"\")");
		}
		else if(func_mode!= null && func_mode.equals("populateDurationDesc")){
			String freq_code			= (String) hash.get( "freq_code" );
			String durn_desc			= "";
			String repeat_durn_type		= "";
			String freq_value			= "";
			String freq_nature			= "";
			String interval_value		= "";
			String repeat_value			= "";
			String schedule_yn			= "";
			HashMap freqNature			=(HashMap)presBean.freqValidate(freq_code);
			if(freqNature.size()>0){
				freq_nature		= (String)freqNature.get("freq_nature");
				freq_value		= (String)freqNature.get("freq_value");
				interval_value	= (String)freqNature.get("interval_value");
				repeat_value	= (String)freqNature.get("repeat_value");
				schedule_yn		= (String)freqNature.get("schedule_yn");
				repeat_durn_type= (String)freqNature.get("repeat_durn_type");
			}
			if(!freq_nature.equals("O")){
				out.println("dfltDurnDesc(\""+repeat_durn_type+"\")");			
				out.println("assignDurnDesc(\""+repeat_value+"\",\""+repeat_durn_type+"\",\""+freq_nature+"\",\""+interval_value+"\",\""+durn_desc+"\",\""+freq_value+"\",\""+schedule_yn+"\")");
			}
			else{
				durn_desc	="";
				freq_value	="";			
				out.println("assignDurnDesc(\""+repeat_value+"\",\""+repeat_durn_type+"\",\""+freq_nature+"\",\""+interval_value+"\",\""+durn_desc+"\",\""+freq_value+"\",\""+schedule_yn+"\")");
			}
			freqNature	=	null;
		} 
		else if(func_mode!= null && func_mode.equals("setDurationAction")){
			ArrayList prescriptionDetails	=	(ArrayList)bean.getpresDetails();
			HashMap drugDetail	=	null;
			String curr_drug_code = "";
			String curr_srl_no = "";
			String drugCode = (String)hash.get("drug_code");
			String srlNo =  (String)hash.get("srl_no");
			String ord_authorized_prev_yn = (String) hash.get("ord_authorized_prev_yn")==null?"":(String)hash.get("ord_authorized_prev_yn");
			String ord_authorized_yn = (String) hash.get("ord_authorized_yn")==null?"":(String)hash.get("ord_authorized_yn");
			String ord_auth_reqd_yn = (String) hash.get("ord_auth_reqd_yn")==null?"":(String)hash.get("ord_auth_reqd_yn");
			for(int j=0;j<prescriptionDetails.size();j++){
				drugDetail	=(HashMap) prescriptionDetails.get(j);
				curr_drug_code	=(String) drugDetail.get("DRUG_CODE");
				curr_srl_no		=(String) drugDetail.get("SRL_NO");
				if( drugCode.equals(curr_drug_code) && srlNo.equals(curr_srl_no) ){
					drugDetail.put("ORD_AUTH_REQD_YN",ord_auth_reqd_yn);
					drugDetail.put("ORD_AUTHORIZED_PREV_YN",ord_authorized_prev_yn);
					drugDetail.put("ORD_AUTHORIZED_YN",ord_authorized_yn);
				}
			}
		}
		else if(func_mode!= null && func_mode.equals("disableScheduleLink1")){
			String drug_code	= (String) hash.get( "drug_code" );
			bean.getclearscheduleFrequency(drug_code);
			out.println("deleteScheduleLink()");
		}
		else if(func_mode != null && func_mode.equals("disableScheduleLink")){
			HashMap ext_drugData		=	null;
			ArrayList prescriptionDetails=null;
			String drug_code	= (String) hash.get( "drug_code" );
			String amend_yn     ="N";
			String ext_drug_code=null;
			prescriptionDetails=(ArrayList)bean.getpresDetails();
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData	=	(HashMap) prescriptionDetails.get(j);
				ext_drug_code	=	(String) ext_drugData.get("DRUG_CODE");
				amend_yn		=	(String) ext_drugData.get("AMENDED_YN");	
				if(drug_code.equals(ext_drug_code)&&amend_yn.equals("N")){
					bean.getclearscheduleFrequency(drug_code);
				  out.println("deleteScheduleLink()");
				}
			}
		}
		else if(func_mode!= null && func_mode.equals("renewEndDate")){
			String start_date		= (String) hash.get( "start_date" );
			String durn_value		= (String) hash.get( "durn_value" );
			String repeat_durn_type	= (String) hash.get( "repeat_durn_type" );
			String dup_start_date	= (String) hash.get( "dup_start_date" );
			String dup_end_date		= (String) hash.get( "dup_end_date" );
			String new_qty			= (String) hash.get( "new_qty" );
			String drug_code =(String)hash.get("drug_code");
			String dup_drug			=	"";
			String end_date			= (String)presBean.renewEndDate(start_date,durn_value,repeat_durn_type);
			boolean result			=  presBean.duplicateRecord(dup_start_date,dup_end_date,start_date,end_date);
			if(result)
				dup_drug			=	"duplicate_found";
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			for(int j=0;j<prescriptionDetails.size();j++){
				HashMap ext_drugData=(HashMap) prescriptionDetails.get(j);
				String ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
				if(drug_code.equals(ext_drug_code)){
					ext_drugData.put("DURN_VALUE",durn_value);
				}
			}
			out.println("assignRenewalDate('"+end_date+"','"+dup_drug+"','"+new_qty+"')");
		}
		else if(func_mode!= null && func_mode.equals("deleteDrug")){
			String drugCode		= (String)hash.get("drug_code");
			String srlNo		= (String)hash.get("srl_no");
			int remove_pos			=	0;
			HashMap ext_drugData	=	null;
			String ext_drug_code	=	null;
			String ext_srl_no		=	null;
			boolean can_delete		=	false;
			ArrayList prescriptionDetails	=	(ArrayList)bean.getpresDetails();		
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData	= (HashMap) prescriptionDetails.get(j);
				ext_drug_code	= (String) ext_drugData.get("DRUG_CODE");
				ext_srl_no		= (String) ext_drugData.get("SRL_NO");
				if(drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no)){
					can_delete	=	true;
					remove_pos	=	j;
					break;
				}
			}
			if(can_delete){
				prescriptionDetails.remove((remove_pos));
				bean.getclearscheduleFrequency(drugCode);
			}
			// objects nullified after usage
			//prescriptionDetails	=	null;
		 }
		 else if(func_mode!= null && func_mode.equals("groupRemarks")){
			String patient_id		= (String) hash.get( "patient_id" );
			String encounter_id		= (String) hash.get( "encounter_id" );
			String order_id			= (String) hash.get( "order_id" );
			
			String disp_locn_code	= "";//added for ml-mmoh-crf-0863
			String home_leave_yn= (String) hash.get( "home_leave_yn_val" );//code added for ML-BRU-SCF-1407[IN:050482] 		
			ArrayList DrugRemarks	= new ArrayList();
			String or_bean_name		="eOR.OrderEntryBean";
			String or_bean_id		="@orderentrybean"+patient_id+encounter_id;
			OrderEntryBean orbean	= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request) ;
			eOR.Common.OrderEntryRecordBean orderEntryRecordBean 	= (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
			String pre_bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
			String pre_bean_name				= "ePH.PrescriptionBean_1";
			PrescriptionBean_1 pre_bean			= (PrescriptionBean_1)getBeanObject( bean_id, bean_name, request );
			String called_amend_from=pre_bean.getCalledFromAmend();
			System.out.println("prescription validation 2 called_amend_from"+called_amend_from);
			HashMap ext_drugData			= null;
			String ext_drug_code			= "";
			ArrayList prescriptionDetails	= (ArrayList)bean.getpresDetails();		
			String ext_srl_no				= "";
			HashMap orderFormatHash			= new HashMap(); // To store it in the HashMap
			ArrayList arrSeq_num			= new ArrayList(); // get the seq in ArrayList
			Hashtable template				= new Hashtable(); // get the template values in the HashTable
			int seq_num 					= 0;
			String order_format_values		= "";
			String auth_reqd_yn				= "";
			String apprvl_reqd_yn			= "";
			String temp_apprvl_rqd_yn		= "";
			String auth_yn_val				= "";
			String temp_auth_rqd_yn			= "";
			String order_status				= "";
			String order_status_orig		= "";
			String approval_yn_val			= "";
			String narcotic_yn				= "N";
			String drug_class				= "";
			String bl_override_excl_incl_ind = "";
			String freq_nature1 = "";
			String freq_nature2 = "";
			String prev_ord_line_status = "";//Added for ML-BRU-SCF-1325
			String prev_ord_line_status_code = "";//Added for ML-BRU-SCF-1325
			String auth_amend_pres_yn="";//added for ml-mmoh-crf-0863
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData	    = (HashMap) prescriptionDetails.get(j);
				 disp_locn_code	= (String) ext_drugData.get("DISP_LOCN_CODE");//added for ml-mmoh-crf-0863
				ext_drug_code	    = (String) ext_drugData.get("DRUG_CODE");
				ext_srl_no		    = (String) ext_drugData.get("SRL_NO");
				drug_class		    = (String) ext_drugData.get("DRUG_CLASS");
				order_status_orig	= (String) ext_drugData.get("ORDER_STATUS");
				prev_ord_line_status = (String) ext_drugData.get("PREV_ORDER_STATUS");//Added for ML-BRU-SCF-1325
				if(ext_drugData.get("BUILDMAR_YN")!=null && ((String)ext_drugData.get("BUILDMAR_YN")).equals("Y")) //added for MMS-QH-CRF-0080 [IN:038064]
					out.println("assignBuildMAR('Y')");
				if(drug_class.equals("N"))
					narcotic_yn = "Y";
				// This code disallows same drug with same frequency nature for PRN and Stat frequencies 
				// Code added for IN24061 --06/10/2010-- priya
				freq_nature1 = (String) ext_drugData.get("FREQ_NATURE");
				for(int k=(j+1);k<prescriptionDetails.size();k++){
					HashMap ext_drugData1 = (HashMap) prescriptionDetails.get(k);
					String ext_drug_code2 = (String) ext_drugData1.get("DRUG_CODE");
					freq_nature2 = (String)ext_drugData1.get("FREQ_NATURE");
					if(ext_drug_code.equals(ext_drug_code2)){
						if((freq_nature1.equals("P") || freq_nature1.equals("O")) && (freq_nature2.equals("P") || freq_nature2.equals("O")) && (freq_nature1.equals(freq_nature2))){
							out.println("alert(getMessage('PH_FREQ_NO_CHANGE','PH'));");
							return;
						}
					}
				}
				if(ext_drugData.containsKey("BL_OVERRIDE_EXCL_INCL_IND")){
					bl_override_excl_incl_ind = (String)ext_drugData.get("BL_OVERRIDE_EXCL_INCL_IND");
					if(bl_override_excl_incl_ind.equals("SEL")){
						 ext_drugData.put("BL_OVERRIDE_EXCL_INCL_IND","");
					}
				 }
				orderFormatHash			= new HashMap();
				arrSeq_num				= new ArrayList();
				template				= new Hashtable();
				seq_num 				= 0;
				String row_value		="0";
				order_format_values		= "";
				arrSeq_num				= (java.util.ArrayList) orderEntryRecordBean.getOrderFormats((ext_drug_code+ext_srl_no), (ext_drug_code+ext_srl_no)+"_"+row_value);
				if(arrSeq_num!= null && arrSeq_num.size() >0){
					int i=0;
					for(i=0;i<arrSeq_num.size();i++){
						//seq_num		= ((Integer)arrSeq_num.get(i)).intValue(); // get the seq_num
						seq_num		=((Integer.parseInt((String)arrSeq_num.get(i))) );
						template	= (java.util.Hashtable)	orderEntryRecordBean.getOrderFormats ( (ext_drug_code+ext_srl_no), ((ext_drug_code+ext_srl_no)+seq_num) );
						orderFormatHash.put("seq_num"+i,String.valueOf(seq_num));
						orderFormatHash.put("field_mnemonic"+i,(String) template.get("field_mnemonic"));
						orderFormatHash.put("label_text"+i,(String) template.get("label_text"));
						orderFormatHash.put("accept_option"+i,(String) template.get("accept_option"));
						orderFormatHash.put("field_type"+i,(String) template.get("field_type"));
						orderFormatHash.put("field_values"+i,(String) template.get("field_values"));
						order_format_values = order_format_values + ((String) template.get("label_text")+" : "+(String) template.get("field_values")) +",";
					}
					orderFormatHash.put("order_format_count",(String.valueOf(i)));
					orderFormatHash.put("order_id",order_id);
					orderFormatHash.put("order_format_values",order_format_values);
					orderFormatHash.put("ext_srl_no",ext_srl_no);
				}
				else{
					orderFormatHash.put("order_id",order_id);
					orderFormatHash.put("order_format_count","0");
					orderFormatHash.put("order_format_values","");
					orderFormatHash.put("ext_srl_no",ext_srl_no);
				}
				if((((String)ext_drugData.get("CURRENT_RX")).equals("Y") && ((String)ext_drugData.get("CURRENTRX_OVERRIDE")) != null && ((String)ext_drugData.get("CURRENTRX_OVERRIDE")).equals("N")&& ext_drugData.get("CURRENTRX_REMARKS") != null && ((String)ext_drugData.get("CURRENTRX_REMARKS")).equals("")) || (((String)ext_drugData.get("ALLERGY_YN")).equals("Y") && ((String)ext_drugData.get("ALLERGY_OVERRIDE")) != null && ((String)ext_drugData.get("ALLERGY_OVERRIDE")).equals("N")&& ext_drugData.get("ALLERGY_REMARKS") != null && ((String)ext_drugData.get("ALLERGY_REMARKS")).equals("")) || (((String)ext_drugData.get("INTERACTION_EXISTS")).equals("Y") && ((String)ext_drugData.get("INTERACTION_REMARKS")).equals("") && ((String)ext_drugData.get("LAB_INTERACTION_REMARKS")).equals("") && ((String)ext_drugData.get("FOOD_INTERACTION_REMARKS")).equals("") && ((String)ext_drugData.get("DISEASE_INTERACTION_REMARKS")).equals(""))){// Modified for IN:073485//Added DISEASE_INTERACTION_REMARKS for MMS-DM-CRF-0229
					out.println("alert(getMessage('OVERRIDE_REASON_NOT_BLANK','PH'));");
					return;
				}
				auth_amend_pres_yn = presBean.getAuthAmendPres(disp_locn_code);//added for ml-mmoh-crf-0863
				if(((String)ext_drugData.get("INTERACTION_EXISTS")).equals("Y"))
					ext_drugData.put("INTERACTION_OVERRIDE_REASON",(String)ext_drugData.get("INTERACTION_REMARKS"));
				auth_reqd_yn = (String)ext_drugData.get("ORD_AUTH_REQD_YN")==null?"":(String)ext_drugData.get("ORD_AUTH_REQD_YN");
				apprvl_reqd_yn	=	(String) ext_drugData.get("ORD_SPL_APPR_REQD_YN")==null?"":(String) ext_drugData.get("ORD_SPL_APPR_REQD_YN");
				approval_yn_val		=(String) ext_drugData.get("ORD_APPROVED_YN")==null?"":(String) ext_drugData.get("ORD_APPROVED_YN");
				auth_yn_val			=(String) ext_drugData.get("ORD_AUTHORIZED_YN")==null?"":(String) ext_drugData.get("ORD_AUTHORIZED_YN");
				if(auth_reqd_yn.equals("Y")){
					if(apprvl_reqd_yn.equals("Y")){
						if(approval_yn_val.equals("Y")){
							temp_apprvl_rqd_yn = "N";
							temp_auth_rqd_yn = "N";  
							order_status	=	"10"; //OS - Ordered
						}
						else{
							if(auth_yn_val.equals("Y")){
								temp_apprvl_rqd_yn = "Y";
								temp_auth_rqd_yn = "N";  
								order_status	=	"05"; //PS - Pending Spl Approval
							}
							else{
								temp_apprvl_rqd_yn = "N";
								temp_auth_rqd_yn = "Y";  
								order_status	=	"03"; //PO - Pending Authorization
							}
						}
					}
					else{
						if(auth_yn_val.equals("Y")){
							temp_apprvl_rqd_yn = "N";
							temp_auth_rqd_yn = "N";  
							order_status	=	"10"; //OS - Ordered
						}
						else{
							temp_apprvl_rqd_yn = "N";
							temp_auth_rqd_yn = "Y";  
							if(auth_amend_pres_yn.equalsIgnoreCase("Y") && called_amend_from.equalsIgnoreCase("PH"))//if condtion added for ml-mmoh-crf-0863
								order_status	=	"10";
							
							else
								order_status	=	"03"; //PO - Pending Authorization//need to modify here
						}
					}
				}
				else{
					if(apprvl_reqd_yn.equals("Y")){
						if(approval_yn_val.equals("Y")){
							temp_apprvl_rqd_yn = "N";
							temp_auth_rqd_yn = "N";  
							order_status	=	"10"; //OS - Ordered
						}
						else{
							temp_apprvl_rqd_yn = "Y";
							temp_auth_rqd_yn = "N";  
							order_status	=	"05"; //PS - Pending Spl Approva
						}
					}
					else{
						temp_apprvl_rqd_yn = "N";
						temp_auth_rqd_yn = "N";  
						order_status	=	"10"; //OS - Ordered
					}
				}
				if(ext_drugData.get("CONSENT_REQD_YN")==null)
					ext_drugData.put("CONSENT_REQD_YN","N");

				if(prev_ord_line_status.equalsIgnoreCase("VF"))//Added for ML-BRU-SCF-1325
					prev_ord_line_status_code = "30";
				else
					prev_ord_line_status_code = "10";
				if(ext_drugData.get("CONSENT_REQD_YN").equals("Y") && ext_drugData.get("CONSENT_STAGE").equals("A"))
					order_status = "00"; //PC - Pending consent
//issue no.16076 - if condition and order_status_orig var introduced
				if(order_status_orig.equals("RG"))
					ext_drugData.put("ORDER_STATUS", "25");
				
				// else if condtions modified for ml-mmoh-crf-0863
				else if(order_status_orig.equals("VF") ) {
					if(auth_yn_val.equals("Y")){
						ext_drugData.put("ORDER_STATUS", "30");
					}
					else{
						if(auth_reqd_yn.equals("Y")   && auth_amend_pres_yn.equalsIgnoreCase("Y") && called_amend_from.equalsIgnoreCase("PH")){
							ext_drugData.put("ORDER_STATUS", "30");
						}
						else if(auth_reqd_yn.equals("Y") ){
							ext_drugData.put("ORDER_STATUS", "03");
						}
						else{
							ext_drugData.put("ORDER_STATUS", "30");
						}
					}
				}
				
			/* 	else if(order_status_orig.equals("VF") ) 
					{//if else  condtion added for ml-mmoh-crf-0863
					//ext_drugData.put("ORDER_STATUS", "30");
							if((auth_reqd_yn.equals("Y")   && auth_amend_pres_yn.equalsIgnoreCase("Y") && called_amend_from.equalsIgnoreCase("PH"))|| !auth_reqd_yn.equals("Y") ){
						
						
								ext_drugData.put("ORDER_STATUS", "30");
						}
						else
						{
						ext_drugData.put("ORDER_STATUS", "03");
						}
					} */
				else if(order_status_orig.equals("UC"))//Added for ML-BRU-SCF-1325
					ext_drugData.put("ORDER_STATUS", prev_ord_line_status_code);
				else
					ext_drugData.put("ORDER_STATUS", order_status);
				DrugRemarks.add(orderFormatHash);
				bean.genDrugRemarks(DrugRemarks);
			}	
			bean.setHome_leave_checked(home_leave_yn);	//code added for ML-BRU-SCF-1407[IN:050482]			   
			out.println("releaseMedicalOrder('"+narcotic_yn+"')");
			putObjectInBean(or_bean_id,orbean,request);	
			putObjectInBean(pre_bean_id,pre_bean,request);
		}
		else if(func_mode!= null && func_mode.equals("normal_amend")){
			String srl_no			= (String)hash.get("srl_no");
			String drug_code		= (String)hash.get("drug_code");
			String durn_value		= (String)hash.get("durn_value");
			String durn_desc		= (String) hash.get("durn_desc");
			String durn_type		= (String) hash.get("durn_type");
			String qty_value		= (String)hash.get("qty_value");
			String dosage_type		= (String)hash.get("dosage");
			String qty_desc			= (String)hash.get("qty_desc");
			String qty_desc_code	= (String)hash.get("qty_desc_code");
			String pres_base_uom	= (String)hash.get("pres_base_uom");
			String freq_code		= (String) hash.get("freq_code");
			String freq_desc		= (String) hash.get("freq_desc");
			freq_desc=(String) hash.get("freq_desc");
			freq_desc = java.net.URLDecoder.decode(freq_desc,"UTF-8");
			String start_date		= (String) hash.get("start_date");
			String limit_ind		= (String) hash.get("limit_ind");//Added for IN:070451
			String end_date			= (String) hash.get("end_date");
			String repeat_value		= (String) hash.get("repeat_value");
			String absol_qty		= (String) hash.get("absol_qty");	
			String freq_nature		= (String) hash.get("freq_nature");
			String disp_locn_code	= (String) hash.get("disp_locn_code");
			String interval_value	= (String) hash.get("interval_value");
			String patient_id		= (String) hash.get("patient_id");
			String split_dose		= (String) hash.get("split_dose_yn");
			String override_remarks		= (String) hash.get("override_remarks");
			String strength_value		= (String) hash.get("strength_value")==null?"1":(String) hash.get("strength_value"); 
			String tmp_durn_value		= (String) hash.get("tmp_durn_value")==null?"":(String) hash.get("tmp_durn_value");
			String buildMAR_yn		= (String)hash.get("buildMAR_yn")==null?"":(String)hash.get("buildMAR_yn"); //added for SRR20056-SCF-7882 -29157
			String DrugRemarksEntered		= (String)hash.get("DrugRemarksEntered")==null?"":(String)hash.get("DrugRemarksEntered"); //Added for Antibiotic Screen using Order Entry Format ICN 29904
			String DrugIndicationRemarks            = (String) hash.get("DrugIndicationRemarks")==null?"":(String)hash.get("DrugIndicationRemarks");
			String preg_remarks            = (String) hash.get("preg_remarks")==null?"":(String)hash.get("preg_remarks");
			String totalTaperQtyDisplay = bean.getTotalTaperQtyDisplay(); //added for 43600 - RUT-CRF-0088 
			String tapered_yn            = hash.get("TAPERED_YN")==null?"":(String)hash.get("TAPERED_YN");//added for 43600 - RUT-CRF-0088 
			String validate_overide_on_confirm_yn            = hash.get("validate_overide_on_confirm_yn")==null?"N":(String)hash.get("validate_overide_on_confirm_yn"); //added for IN069887		
			if(!DrugIndicationRemarks.equals(""))
				DrugIndicationRemarks = java.net.URLDecoder.decode(DrugIndicationRemarks,"UTF-8");
			if(!preg_remarks.equals(""))
				preg_remarks = java.net.URLDecoder.decode(preg_remarks,"UTF-8"); 
			
			//String drug_db_interface_yn = (String)hash.get("drug_db_interface_yn")==null?"":(String)hash.get("drug_db_interface_yn");
			String trade_code = (String)hash.get("trade_code")==null?"": (String)hash.get("trade_code");
			String route_code = (String)hash.get("route_code")==null?"": (String)hash.get("route_code");
			String route_desc = (String)hash.get("route_desc")==null?"": (String)hash.get("route_desc");
			String bl_incl_excl_override_reason_code =(String) hash.get("bl_incl_excl_override_reason_code")==null?"":(String)hash.get("bl_incl_excl_override_reason_code");
			String bl_incl_excl_override_reason_desc = (String) hash.get("bl_incl_excl_override_reason_desc")==null?"":(String)hash.get("bl_incl_excl_override_reason_desc");
			String bl_def_override_excl_incl_ind = (String) hash.get("bl_def_override_excl_incl_ind")==null?"":(String)hash.get("bl_def_override_excl_incl_ind");
			String bl_override_excl_incl_ind = (String) hash.get("bl_override_excl_incl_ind")==null?"":(String)hash.get("bl_override_excl_incl_ind");
			String bl_override_allowed_yn = (String) hash.get("bl_override_allowed_yn")==null?"":(String)hash.get("bl_override_allowed_yn");
			String ext_prod_id					= (String)hash.get("ext_prod_id")==null?"":(String) hash.get( "ext_prod_id" );
			String drug_db_dosecheck_yn	  = (String) hash.get("drug_db_dosecheck_yn")==null?"":(String) hash.get("drug_db_dosecheck_yn");
			String drug_db_interface_yn = (String)hash.get("drug_db_interface_yn")==null?"":(String)hash.get("drug_db_interface_yn");
			String drug_db_duptherapy_yn = (String)hash.get("drug_db_duptherapy_yn")==null?"":(String)hash.get("drug_db_duptherapy_yn");

			String freq_durn_type = (String) hash.get("freq_durn_type");
			//String tmp_durn_value =  durn_value;
			if(!durn_type.equals(freq_durn_type)){
				tmp_durn_value = (String)bean.getFreqDurnConvValue(freq_durn_type,durn_value,durn_type);
			}
			else // else condition added for IN22859 --27/07/2010-- priya
				tmp_durn_value = durn_value;
			boolean split_dose_yn = false;
			if(split_dose.equals("Y"))
				split_dose_yn = true;

			String consider_stock_for_pres_yn	= (String) hash.get( "consider_stock_for_pres_yn" );
			String allow_pres_without_stock_yn	= (String) hash.get( "allow_pres_without_stock_yn" );
			ArrayList prescriptionDetails	=	(ArrayList)bean.getpresDetails();
			ArrayList	schedule			=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
			HashMap freq_char_list	= new HashMap();
			ArrayList day_list		= new ArrayList();
			ArrayList day_names		= new ArrayList();
			ArrayList time_list		= new ArrayList();
			ArrayList dose_list		= new ArrayList();
			String sch_size				=	"";
			String conv_factor			=	"";
			HashMap data				=	null;
			String split_dose_preview	=	"";
			String split_qty_value		=	qty_value;
			String admin_qty1			=	qty_value;
			float dose_qty =0;
			if(!bean.checkSplit(schedule) && schedule.size() > 0) {
				dose_list	= (ArrayList)schedule.get(4);
				if(dose_list.size() > 0)
					qty_value	= (String)dose_list.get(0);
				sch_size	=  ""+dose_list.size();
			}
			else{
				sch_size		=	repeat_value;
			}
			//forming split dose preview
			if((schedule.size()>0)&&(!freq_nature.equals("O"))){
				split_qty_value="0";
				if(schedule.size()>0){
					freq_char_list	= (HashMap)schedule.get(0);
					day_list		= (ArrayList)schedule.get(1);
					day_names		= (ArrayList)schedule.get(2);
					time_list		= (ArrayList)schedule.get(3);
					dose_list		= (ArrayList)schedule.get(4);

					for(int frStr = 0;frStr<day_list.size();frStr++){
						if(!freq_char_list.get("durationType").equals("D")){
							split_dose_preview = split_dose_preview + "Day "+day_list.get(frStr);
							split_dose_preview = split_dose_preview + " - ";
							if(freq_char_list.get("durationType").equals("W")){
								split_dose_preview = split_dose_preview + day_names.get(frStr);
								split_dose_preview = split_dose_preview + " - ";
							}
						}
						split_dose_preview = split_dose_preview + time_list.get(frStr);
						split_dose_preview = split_dose_preview + " - ";
						split_dose_preview = split_dose_preview + dose_list.get(frStr);
						split_dose_preview = split_dose_preview + " "+bean.getUomDisplay((String)session.getValue("facility_id"),qty_desc_code);
						split_dose_preview = split_dose_preview + "; ";

						if(dosage_type.equals("S")&&split_dose_yn){
							float unit_qty=(float)Math.ceil(Double.parseDouble((String)dose_list.get(frStr))/Double.parseDouble(strength_value))*Float.parseFloat(strength_value);
							split_qty_value	=	(Float.parseFloat(split_qty_value)+unit_qty)+"";
							dose_qty = dose_qty+Float.parseFloat((String)dose_list.get(frStr));

						}
					}
				}
			}
			if(split_dose_preview.length()>1499 ){
				split_dose_preview	=	split_dose_preview.substring(0,1499);
			}
			else{
				split_dose_preview	=	split_dose_preview;
			}// split dose preview ends 
			if(dosage_type.equals("Q"))
				conv_factor = (String) bean.getConvFactor(qty_desc_code,pres_base_uom);

			if(conv_factor==null || conv_factor.equals(""))
				conv_factor	=	"1";

			HashMap ext_drugData			=	null;
			String ext_drug_code			=	"";
			String ext_srl_no				=	"";
			String order_qty				=	"";
			String order_uom				=	"";
			String act_qty_value            =   "0";

			if(absol_qty == null)
				absol_qty		=	"1";
			if( freq_nature.equals("O")){
				sch_size="1";
				durn_value="1";
			}
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData		= (HashMap) prescriptionDetails.get(j);
				ext_drug_code		= (String) ext_drugData.get("DRUG_CODE");
				ext_srl_no			= (String) ext_drugData.get("SRL_NO");

				if(srl_no.equals(ext_srl_no)  && drug_code.equals(ext_drug_code)){
					String fract_dose	=	(String)ext_drugData.get("FRACT_DOSE_ROUND_UP_YN");
					if(fract_dose.equals("Y") && split_dose_yn && dosage_type.equals("S") ){ //dosage_type.equals("S") added for IN21601reopen --03/06/2010 -- priya
						qty_value = split_qty_value;
					}
			if(bean.checkSplit(schedule) && schedule.size() > 0 && dosage_type.equals("Q") ) {//if block for IN22579 reopen --13/07/2010 -- priya 
				dose_list	= (ArrayList)schedule.get(4);
				qty_value = "0";
				for(int d=0; d<dose_list.size(); d++)
					if(!((String)dose_list.get(d)).equals("")){
						if(fract_dose.equals("N"))
							qty_value = (Float.parseFloat(qty_value) + Float.parseFloat((String)dose_list.get(d)))+"";
						else if(fract_dose.equals("Y"))
							qty_value = (Float.parseFloat(qty_value) + Math.ceil(Float.parseFloat((String)dose_list.get(d))))+"";

						act_qty_value = (Float.parseFloat(act_qty_value) + Float.parseFloat((String)dose_list.get(d)))+""; //added on 20/07/2010 for 2nd reopen
					}
				} //if block for IN22579 reopen --13/07/2010 -- priya -end
				//	if(bean.nationalityCheck(patient_id)) {
						if(consider_stock_for_pres_yn.equals("Y")){
							if(allow_pres_without_stock_yn.equals("N")){
								HashMap stockValues			=(HashMap) bean.chkStockAvail(drug_code,disp_locn_code,qty_value,end_date, trade_code);
								String available_stock		=(String) stockValues.get("AVAILABLE_STOCK");
						// if(Float.parseFloat(bean.getOrderQty(ext_drugData,qty_value,sch_size,durn_value,"",dosage_type,conv_factor,split_dose_yn)) > Float.parseFloat(available_stock)) {
						if(Float.parseFloat(bean.getOrderQty(ext_drugData,qty_value,sch_size,tmp_durn_value,"",dosage_type,conv_factor,split_dose_yn)) > Float.parseFloat(available_stock)) {
									out.println("alertNoAvailStock('"+available_stock+"','"+(String)hash.get("stock_uom")+"')") ;
									return;												
								}
							}
						}
						// Modified for IN:069887 start
					String dose_remarks_yn="N";
					String dup_remarks_yn="N";
					if(validate_overide_on_confirm_yn.equals("Y")){		
					if((limit_ind.equals("N")) && (((String)ext_drugData.get("DOSE_REMARKS"))==null ||( (String)ext_drugData.get("DOSE_REMARKS")).equals(""))){//Added for IN:070451
						//out.println("alert(getMessage('OVERRIDE_REASON_NOT_BLANK','PH'));");
						dose_remarks_yn="Y";
					}
					if((((String)ext_drugData.get("CURRENT_RX")).equals("Y") && ((String)ext_drugData.get("CURRENTRX_OVERRIDE")) != null && ((String)ext_drugData.get("CURRENTRX_OVERRIDE")).equals("N")&& ext_drugData.get("CURRENTRX_REMARKS") != null && ((String)ext_drugData.get("CURRENTRX_REMARKS")).equals("")) || (((String)ext_drugData.get("ALLERGY_YN")).equals("Y") && ((String)ext_drugData.get("ALLERGY_OVERRIDE")) != null && ((String)ext_drugData.get("ALLERGY_OVERRIDE")).equals("N")&& ext_drugData.get("ALLERGY_REMARKS") != null && ((String)ext_drugData.get("ALLERGY_REMARKS")).equals(""))){
						//out.println("alert(getMessage('OVERRIDE_REASON_NOT_BLANK','PH'));");
						dup_remarks_yn="Y";
					}
					if(dose_remarks_yn.equals("Y") || dup_remarks_yn.equals("Y")){
					out.println("showOverideMandAlert('N','"+dup_remarks_yn+"','"+dose_remarks_yn+"','N','N','N')");
					return;
					}
					}
					else{
						if((limit_ind.equals("N")) && (((String)ext_drugData.get("DOSE_REMARKS"))==null ||( (String)ext_drugData.get("DOSE_REMARKS")).equals(""))){//Added for IN:070451
							out.println("alert(getMessage('OVERRIDE_REASON_NOT_BLANK','PH'));");
							return;
						}
						if((((String)ext_drugData.get("CURRENT_RX")).equals("Y") && ((String)ext_drugData.get("CURRENTRX_OVERRIDE")) != null && ((String)ext_drugData.get("CURRENTRX_OVERRIDE")).equals("N")&& ext_drugData.get("CURRENTRX_REMARKS") != null && ((String)ext_drugData.get("CURRENTRX_REMARKS")).equals("")) || (((String)ext_drugData.get("ALLERGY_YN")).equals("Y") && ((String)ext_drugData.get("ALLERGY_OVERRIDE")) != null && ((String)ext_drugData.get("ALLERGY_OVERRIDE")).equals("N")&& ext_drugData.get("ALLERGY_REMARKS") != null && ((String)ext_drugData.get("ALLERGY_REMARKS")).equals(""))){
							out.println("alert(getMessage('OVERRIDE_REASON_NOT_BLANK','PH'));");
							return;
						}
						// Modified for IN:069887 end
					}
					if(!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("") || drug_db_duptherapy_yn.equals("N")){
						if( presBean.checkDuplicateDrug(patient_id, (String) ext_drugData.get("GENERIC_ID"), start_date,end_date,(String) hash.get("freq_code"), (String) ext_drugData.get("TRN_GROUP_REF"))) {
							ext_drugData.put("CURRENT_RX","Y");
						}
					}
				//	}
					ext_drugData.put("DOSAGE_TYPE",dosage_type);
//during amend the dosage qty value is cming as 0.0 after confirming and then reloading the drug detail.
//&& dosage_type.equals("S")&&split_dose_yn is added to sove that.
					if((schedule.size()>0)&&(!freq_nature.equals("O")) && dosage_type.equals("S") && split_dose_yn) 
						ext_drugData.put("QTY_VALUE",dose_qty+"");
					else if(dosage_type.equals("Q") && split_dose_yn && fract_dose.equals("Y"))  //else if condition added for IN22579 2nd reopen --20/07/2010 -- priya // added fract_dose condition for SKR-SCF-1307
						ext_drugData.put("QTY_VALUE",act_qty_value);
					else
						ext_drugData.put("QTY_VALUE",qty_value);
					ext_drugData.put("QTY_UNIT",qty_desc_code);
					ext_drugData.put("QTY_DESC",qty_desc);
					ext_drugData.put("QTY_DESC_CODE",qty_desc_code);
					ext_drugData.put("OR_QTY_DESC",qty_desc);
					ext_drugData.put("FREQ_CODE",freq_code);
					ext_drugData.put("FREQ_DESC",freq_desc);
					ext_drugData.put("FREQ_NATURE",freq_nature);
					ext_drugData.put("DURN_VALUE",durn_value);
					ext_drugData.put("INTERVAL_VALUE",interval_value);
					ext_drugData.put("DURN_TYPE",durn_type);
					ext_drugData.put("DURN_DESC",durn_desc);
					ext_drugData.put("START_DATE_TIME",start_date);
					ext_drugData.put("END_DATE_TIME",end_date);
					ext_drugData.put("AMENDED_YN","Y");
					ext_drugData.put("REPEAT_VALUE",repeat_value);
					ext_drugData.put("SPLIT_DOSE_YN",split_dose);
					ext_drugData.put("FREQ_DURN_VALUE",tmp_durn_value);
					ext_drugData.put("FREQ_DURN_TYPE",freq_durn_type); //added for IN20564 re reopen --20/07/2010-- priya
					ext_drugData.put("BUILDMAR_YN",buildMAR_yn); //added for SRR20056-SCF-7882 -29157
					ext_drugData.put("DrugRemarksEntered",DrugRemarksEntered); //Added for Antibiotic Screen using Order Entry Format ICN 29904
					ext_drugData.put("DRUG_INDICATION",DrugIndicationRemarks); //Added for Antibiotic Screen using Order Entry Format ICN 29904
					ext_drugData.put("PREG_REMARKS",preg_remarks);

					if(!route_code.equals("")){
						ext_drugData.put("ROUTE_CODE",route_code);
						ext_drugData.put("ROUTE_DESC",route_desc);
					}
					ext_drugData.put("BL_INCL_EXCL_OVERRIDE_REASON_CODE",bl_incl_excl_override_reason_code);
					ext_drugData.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC",java.net.URLDecoder.decode(bl_incl_excl_override_reason_desc,"UTF-8"));
					//ext_drugData.put("BL_DEF_OVERRIDE_EXCL_INCL_IND",bl_override_excl_incl_ind);
					//if(bl_override_excl_incl_ind.equals("SEL"))
						//bl_override_excl_incl_ind ="";
					ext_drugData.put("BL_OVERRIDE_EXCL_INCL_IND",bl_override_excl_incl_ind); //priya 09/03/2010
					
					if(dosage_type.equals("A")|| freq_nature.equals("P")) {
						qty_value		=	absol_qty;
						dosage_type		=	"A";
					}
					//order_qty	=	bean.getOrderQty(ext_drugData,qty_value,sch_size,durn_value,"",dosage_type,conv_factor,split_dose_yn);
					if(totalTaperQtyDisplay.equals("Y") && tapered_yn.equals("Y")){
						order_qty = absol_qty;
					}
					else{
						order_qty	=	bean.getOrderQty(ext_drugData,qty_value,sch_size,tmp_durn_value,"",dosage_type,conv_factor,split_dose_yn);
					}
					ext_drugData.put("ORDER_QTY",order_qty);
				
					order_uom	=	presBean.getOrderUnitCode(dosage_type, order_qty, drug_code);
					ext_drugData.put("ORDER_UOM",order_uom);
					ext_drugData.put("SPLIT_DOSE_PREVIEW",split_dose_preview);					

					break;				
				}
			}
			out.println("refreshFrames()");
		}
		else if(func_mode!= null && func_mode.equals("amendValues")){
			String srl_no		= (String) hash.get( "srl_no" );
			String drug_code	= (String) hash.get( "drug_code" );
			String consider_stock_for_pres_yn	= (String) hash.get( "consider_stock_for_pres_yn" );
			String allow_pres_without_stock_yn	= (String) hash.get( "allow_pres_without_stock_yn" );
			//String patient_id	=	(String) hash.get( "patient_id" );

			String bl_incl_excl_override_reason_code =(String) hash.get("bl_incl_excl_override_reason_code")==null?"":(String)hash.get("bl_incl_excl_override_reason_code");
			String bl_incl_excl_override_reason_desc = (String) hash.get("bl_incl_excl_override_reason_desc")==null?"":(String)hash.get("bl_incl_excl_override_reason_desc");
			String bl_def_override_excl_incl_ind = (String) hash.get("bl_def_override_excl_incl_ind")==null?"":(String)hash.get("bl_def_override_excl_incl_ind");
			String bl_override_excl_incl_ind = (String) hash.get("bl_override_excl_incl_ind")==null?"":(String)hash.get("bl_override_excl_incl_ind");
			String bl_override_allowed_yn = (String) hash.get("bl_override_allowed_yn")==null?"":(String)hash.get("bl_override_allowed_yn");
		//added for ML-BRU-SCF-2069 - start
			String durn_value = (String) hash.get("durn_value");
			String durn_type = (String) hash.get("durn_type")==null?"D":(String) hash.get("durn_type");
			String freq_durn_type = (String) hash.get("repeat_durn_type")==null?"D":(String) hash.get("repeat_durn_type");
			if(!durn_type.equals(freq_durn_type)){
				durn_value = (String)bean.getFreqDurnConvValue(freq_durn_type,durn_value,durn_type);
			}
		//added for ML-BRU-SCF-2069 - end	

		/*	if(!bl_def_override_excl_incl_ind.equals("") && bl_override_allowed_yn.equals("Y")){
				if(bl_def_override_excl_incl_ind.equals("I") && bl_override_excl_incl_ind.equals("Y"))
					bl_override_excl_incl_ind = "E";
				else if (bl_def_override_excl_incl_ind.equals("E") && bl_override_excl_incl_ind.equals("Y"))
					bl_override_excl_incl_ind = "I";
				else
					bl_override_excl_incl_ind="";
			}
			else
				bl_override_excl_incl_ind = "";
*/
			if(bl_override_excl_incl_ind.equals("Y")){
				if(bl_def_override_excl_incl_ind.equals("I") && bl_override_excl_incl_ind.equals("Y"))
					bl_override_excl_incl_ind = "E";
				else if (bl_def_override_excl_incl_ind.equals("E") && bl_override_excl_incl_ind.equals("Y"))
					bl_override_excl_incl_ind = "I";
			}
			else 
				bl_override_excl_incl_ind="";

			ArrayList prescriptionDetails	=	(ArrayList)bean.getpresDetails();
			int new_qty			=	0;		
			String dosage		=	"";
			String absol_qty	=	"";
			for(int j=0;j<prescriptionDetails.size();j++){
				HashMap ext_drugData		=(HashMap) prescriptionDetails.get(j);
				String ext_drug_code		=(String) ext_drugData.get("DRUG_CODE");
				String ext_srl_no			=(String) ext_drugData.get("SRL_NO");

				if(srl_no.equals(ext_srl_no)  && drug_code.equals(ext_drug_code)){

					absol_qty	=	(String) hash.get("absol_qty");
					dosage		=	(String) hash.get("dosage");

					//if(bean.nationalityCheck(patient_id)) {
						if(consider_stock_for_pres_yn.equals("Y")){
							if(allow_pres_without_stock_yn.equals("N")){
								if( new_qty > Integer.parseInt((String) ext_drugData.get("AVAILABLE_STOCK"))){
									out.println("StockWarning('"+((String) ext_drugData.get("AVAILABLE_STOCK"))+"','"+(String)ext_drugData.get("STOCK_UOM_DESC")+"')");
									return;
								}
							}
						}
				//	}
					ext_drugData.put("QTY_VALUE",(String) hash.get("qty_value"));
					ext_drugData.put("ABSOL_QTY",(String) hash.get("absol_qty"));
					ext_drugData.put("ORDER_QTY",(String) hash.get("absol_qty"));			
					ext_drugData.put("DURN_VALUE",(String) hash.get("durn_value"));
					ext_drugData.put("freq_chng_durn_value",durn_value); //added for ML-BRU-SCF-2069 - 
					ext_drugData.put("freq_chng_durn_desc",(String) hash.get("durn_desc"));//Added for ML-BRU-SCF-1843
					ext_drugData.put("START_DATE",(String) hash.get("start_date"));//Added for Bru-HIMS-CRF-400
					ext_drugData.put("START_DATE_TIME",(String) hash.get("start_date"));
					ext_drugData.put("END_DATE_TIME",(String) hash.get("end_date"));
					ext_drugData.put("AMENDED_YN","Y");
					ext_drugData.put("BL_INCL_EXCL_OVERRIDE_REASON_CODE",bl_incl_excl_override_reason_code);					ext_drugData.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC",java.net.URLDecoder.decode(bl_incl_excl_override_reason_desc,"UTF-8"));
					ext_drugData.put("BL_DEF_OVERRIDE_EXCL_INCL_IND",bl_def_override_excl_incl_ind);
					//if(bl_override_excl_incl_ind.equals("SEL"))
					//	bl_override_excl_incl_ind ="";
					ext_drugData.put("BL_OVERRIDE_EXCL_INCL_IND",bl_override_excl_incl_ind);

					break;				
				}
			}
			out.println("refreshFrames()");
		} 
		else if(func_mode!= null && func_mode.equals("confirmSlidingScale")){
			String qty_value		= (String)hash.get( "absol_qty");
			String qty_unit			= (String)hash.get( "qty_unit");
			String frequency		= (String)hash.get( "frequency");
			String durn_value		= (String)hash.get( "durn_value");
			String durn_unit		= (String)hash.get( "durn_unit");
			String start_date		= (String)hash.get( "start_date");
			String end_date			= (String)hash.get( "end_date");
			String drug_code			= (String)hash.get( "drug_code");
			String remarks			= (String)hash.get( "remarks");
			String remarks_codes	= (String)hash.get( "remarks_codes");	
			String sliding_scale_yn	= (String)hash.get( "sliding_scale_yn");
			String freq_desc		= (String)hash.get( "freq_desc");
			String tmplDtlString	= (String)hash.get("tmplDtlString")==null?"":(String)hash.get("tmplDtlString");
			String rangeUom	= (String)hash.get("rangeUom")==null?"":(String)hash.get("rangeUom");
			String adminUom	= (String)hash.get("adminUom")==null?"":(String)hash.get("adminUom");
			String template_id	= (String)hash.get("template_id")==null?"":(String)hash.get("template_id");
			String buildMAR_yn	= (String)hash.get("buildMAR_yn")==null?"":(String)hash.get("buildMAR_yn"); //added for SRR20056-SCF-7882 -29157
			String DrugRemarksEntered	= (String)hash.get("DrugRemarksEntered")==null?"":(String)hash.get("DrugRemarksEntered"); //Added for Antibiotic Screen using Order Entry Format ICN 29904
			String DrugIndicationRemarks            = (String) hash.get("DrugIndicationRemarks")==null?"":(String)hash.get("DrugIndicationRemarks");
			if(!DrugIndicationRemarks.equals(""))
				DrugIndicationRemarks = java.net.URLDecoder.decode(DrugIndicationRemarks,"UTF-8"); ;
			String temp = "" ;
			StringTokenizer stTmplDtl = new StringTokenizer(tmplDtlString,"~");
			ArrayList sldScaleTmplDtl = new ArrayList();
			
			//Commented bellow while loop and added bellow one for 10.X-CRF-SRR20056-CRF-0675-PH-SL-2 -- start
			/*while(stTmplDtl.hasMoreTokens()){
				temp = stTmplDtl.nextToken();
				sldScaleTmplDtl.add(temp);
			}*/

			int temp_count = 0;
			while(stTmplDtl.hasMoreTokens()){
				temp_count++;
				temp = stTmplDtl.nextToken();
				if((temp_count % 5 == 0) && temp!=null && !temp.equals(""))  
					temp = java.net.URLDecoder.decode(temp,"UTF-8");

				sldScaleTmplDtl.add(temp);
			}
			//10.X-CRF-SRR20056-CRF-0675-PH-SL-2 -- End

	/*		freq_desc=freq_desc.replaceAll(" ","%20");
			freq_desc = java.net.URLEncoder.encode(freq_desc,"UTF-8");
			freq_desc=freq_desc.replaceAll("%2520","%20");*/
			freq_desc = java.net.URLDecoder.decode(freq_desc,"UTF-8");
			String freq_nature		= (String)hash.get( "freq_nature");
			String absol_qty		= (String)hash.get( "absol_qty");
			String repeat_value		= (String)hash.get( "repeat_value");
			String override_check	= (String) hash.get("override_remarks")==null?"":(String) hash.get("override_remarks");
			String checkEnabled		= (String) hash.get("checkEnabled")==null?"":(String) hash.get("checkEnabled");
			String pract_name		= (String) hash.get("pract_name")==null?"":(String) hash.get("pract_name");
			String interval_value		= (String) hash.get("interval_value")==null?"":(String) hash.get("interval_value");
/*===============================================================================================================*/
//added while fixing IN26429_reopen --15/02/2011-- priya
			String bl_incl_excl_override_reason_code = (String) hash.get("bl_incl_excl_override_reason_code")==null?"":(String)hash.get("bl_incl_excl_override_reason_code");
			String bl_incl_excl_override_reason_desc = (String) hash.get("bl_incl_excl_override_reason_desc")==null?"":(String)hash.get("bl_incl_excl_override_reason_desc");
			String bl_def_override_excl_incl_ind     = (String) hash.get("bl_def_override_excl_incl_ind")==null?"":(String)hash.get("bl_def_override_excl_incl_ind");
			String bl_override_excl_incl_ind         = (String) hash.get("bl_override_excl_incl_ind")==null?"":(String)hash.get("bl_override_excl_incl_ind");
/*===============================================================================================================*/
			String temp_drug_code="";
			//code added for patient counselling req
			if(absol_qty==null)
				absol_qty	=	"";

			ArrayList presDetails  = (ArrayList) bean.getpresDetails();
			HashMap drugDetails    = null;
			for(int i=0;i<presDetails.size();i++){
				drugDetails    = (HashMap)presDetails.get(i);
				temp_drug_code =(String)drugDetails.get("DRUG_CODE");
				if(drug_code.equals(temp_drug_code)){
					break;
				}
			}
			if(frequency==null || (frequency!=null && frequency.equals(""))){
				frequency = bean.getSlidingScalePRNFreq();
			}
			drugDetails.put("ABSOL_QTY",absol_qty);	
			drugDetails.put("ORDER_QTY",absol_qty);
/*===================================================================================================*/
			//added for  for IN21609 --07/06/2010 -- priya
			String freq_durn_type = (String) hash.get("repeat_durn_type");
			String tmp_durn_value =  durn_value;
			if(!durn_unit.equals(freq_durn_type))
				{
					tmp_durn_value = (String)bean.getFreqDurnConvValue(freq_durn_type,durn_value,durn_unit);
				}		
			drugDetails.put("FREQ_DURN_VALUE",tmp_durn_value);	
/*===================================================================================================*/
			
			drugDetails.put("REPEAT_VALUE",repeat_value);	
			drugDetails.put("FREQ_NATURE",freq_nature);
			drugDetails.put("FREQ_CODE",frequency);
			drugDetails.put("FREQ_DESC",freq_desc);
			drugDetails.put("DURN_VALUE",durn_value);
			drugDetails.put("START_DATE",start_date);
			drugDetails.put("END_DATE",end_date);
			drugDetails.put("PRES_QTY_VALUE",qty_value);
			drugDetails.put("DURN_TYPE",durn_unit);
			drugDetails.put("SLIDING_SCALE_YN",sliding_scale_yn);
			drugDetails.put("AMEND_YN","Y");
			drugDetails.put("QTY_VALUE",qty_value);
			drugDetails.put("QTY_DESC",qty_unit);
			drugDetails.put("QTY_DESC_CODE",qty_unit);
			//drugDetails.put("OR_QTY_DESC",qty_unit);
			drugDetails.put("OR_QTY_DESC",bean.getUomDisplay((String)session.getValue("facility_id"),qty_unit));

			drugDetails.put("INTERVAL_VALUE",interval_value);
			drugDetails.put("TEMPLATE_ID",template_id);
			drugDetails.put("SLDSCALE_TMPL_DTL",sldScaleTmplDtl);
			drugDetails.put("RANGEUOM",rangeUom);
			drugDetails.put("ADMINUOM",adminUom);
			drugDetails.put("SLIDING_SCALE_REMARKS",remarks);
			drugDetails.put("SLIDING_SCALE_REMARKS_CODES",remarks_codes);
			drugDetails.put("AMENDED_YN","Y");
			drugDetails.put("BUILDMAR_YN",buildMAR_yn); //added for SRR20056-SCF-7882 -29157
			drugDetails.put("DrugRemarksEntered",DrugRemarksEntered); //Added for Antibiotic Screen using Order Entry Format ICN 29904
			drugDetails.put("DRUG_INDICATION",DrugIndicationRemarks); //Added for Antibiotic Screen using Order Entry Format ICN 29904
/*================================================================================================================*/
//added while fixing IN26429_reopen --15/02/2011-- priya
			drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON_CODE",bl_incl_excl_override_reason_code);
			drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC",bl_incl_excl_override_reason_desc);
			drugDetails.put("BL_DEF_OVERRIDE_EXCL_INCL_IND",bl_def_override_excl_incl_ind);					drugDetails.put("BL_OVERRIDE_EXCL_INCL_IND",bl_override_excl_incl_ind); 

/*================================================================================================================*/

			String allergy_yn  =(String) drugDetails.get("ALLERGY_YN")==null?"N":(String) drugDetails.get("ALLERGY_YN");
			String limit_ind  =(String) drugDetails.get("LIMIT_IND")==null?"N":(String) drugDetails.get("LIMIT_IND");
			String current_rx		= (String) drugDetails.get("CURRENT_RX")==null?"":(String) drugDetails.get("CURRENT_RX");
			String currentrx_remarks		= (String) drugDetails.get("CURRENTRX_REMARKS")==null?"":(String) drugDetails.get("CURRENTRX_REMARKS");
			String dose_remarks		= (String) drugDetails.get("DOSE_REMARKS")==null?"":(String) drugDetails.get("DOSE_REMARKS");
			String allergy_remarks		= (String) drugDetails.get("ALLERGY_REMARKS")==null?"":(String) drugDetails.get("ALLERGY_REMARKS");
			String abuse_override=(String)drugDetails.get("ABUSE_OVERRIDE")==null?"":(String)drugDetails.get("ABUSE_OVERRIDE");
			String abuse_override_remarks=(String)drugDetails.get("abuse_drug_override_reason")==null?"":(String)drugDetails.get("abuse_drug_override_reason");
			String abuse_action=(String)drugDetails.get("ABUSE_ACTION")==null?"":(String)drugDetails.get("ABUSE_ACTION");
			String abuse_exists=(String)drugDetails.get("ABUSE_EXISTS")==null?"":(String)drugDetails.get("ABUSE_EXISTS");
			
			if(override_check.equals("Y") && !checkEnabled.equals("disabled")){
				if(current_rx.equals("Y")){
					if(currentrx_remarks==null || currentrx_remarks.equals(""))
						currentrx_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
					drugDetails.put("CURRENTRX_OVERRIDE","Y");
					drugDetails.put("CURRENTRX_REMARKS",currentrx_remarks);
					drugDetails.put("OVERRIDED_YN","Y");
				}
				if(limit_ind.equals("N")){
					if(dose_remarks==null || dose_remarks.equals(""))
						dose_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
						
					drugDetails.put("DOSE_OVERRIDE","Y");
					drugDetails.put("DOSE_REMARKS",dose_remarks);
					drugDetails.put("OVERRIDED_YN","Y");
				}
				if( allergy_yn.equals("Y")){
					if(allergy_remarks==null || allergy_remarks.equals(""))
						allergy_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
					
					drugDetails.put("ALLERGY_OVERRIDE","Y");
					drugDetails.put("ALLERGY_REMARKS",allergy_remarks);
					drugDetails.put("OVERRIDED_YN","Y");
					
				}
				if( abuse_exists.equals("Y")&& abuse_action.equals("B")){
					if(abuse_override_remarks==null || abuse_override_remarks.equals(""))
						abuse_override_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
					
					drugDetails.put("ABUSE_OVERRIDE","Y"); 
					drugDetails.put("abuse_override_remarks",abuse_override_remarks);
					drugDetails.put("OVERRIDED_YN","Y");
					
				}
				System.out.println(abuse_exists+"abuse_existsvalidation1"+abuse_action);
				if(abuse_exists.equals("Y")&& abuse_action.equals("B") && abuse_override_remarks!=null) {//added for aakh-crf-0140
					
					drugDetails.put("abuse_override_remarks",abuse_override_remarks);
					drugDetails.put("ABUSE_OVERRIDE","Y");
					
				}
				drugDetails.put("Override_Check",override_check);
			}
			else{

				String overrided_yn = (String)drugDetails.get("OVERRIDED_YN")==null?"":(String)drugDetails.get("OVERRIDED_YN");
		/*		String overrided_yn ="";
					if(drugDetails.containsKey("CURRENTRX_REMARKS"))
					{
						if(((String)drugDetails.get("CURRENTRX_REMARKS"))!=null && ((String)drugDetails.get("CURRENTRX_REMARKS"))!="")
						{
							overrided_yn ="Y";
							
						}
						else
						{
							overrided_yn ="N";
						}
					}*/
				if((current_rx.equals("Y") || limit_ind.equals("N") || allergy_yn.equals("Y")) && overrided_yn.equals("")){
					out.println("alert(getMessage('OVERRIDE_REASON_NOT_BLANK','PH'));");
					//return;
				}
			}
//			out.println("refreshSlidingScaleFrame()");
			out.println("refreshFrames()");

		}
		else if(func_mode!= null && func_mode.equals("getFormatId")){
			String patient_id	=	(String) hash.get( "patient_id" );
			String encounter_id	=	(String) hash.get( "encounter_id" );
			String or_bean_name	="eOR.OrderEntryBean";
			String or_bean_id	="@orderentrybean"+patient_id+encounter_id;
			OrderEntryBean orbean = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request) ;
			eOR.Common.OrderEntryRecordBean orderEntryRecordBean 	= (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();

			String order_catalog_code	=	(String) hash.get( "drug_code" );
			String order_type			=	(String) hash.get( "order_type" );
			String form_code			=	(String) hash.get( "form_code" );
			String route_code			=	(String) hash.get( "route_code" );
			String called_frm			=	(String) hash.get( "called_frm" );

			String order_category		=	"PH";
			if(called_frm.equals("route")) {
				if(orderEntryRecordBean.getOrderFormats(order_catalog_code, order_catalog_code+"_0")!=null) {
					orderEntryRecordBean.removeOrderFormats(order_catalog_code, order_catalog_code+"_0");
				}
			}
			if(order_catalog_code.length() > 0) //if block moved before bean.getFormatId call for SKR-SCF-0140
				order_catalog_code=  order_catalog_code.substring(0,(order_catalog_code.length())-1); 
			String format_id		=	presBean.getFormatId(order_category,order_type,order_catalog_code);
			ArrayList	pres_values	=	presBean.getPresValues(form_code,route_code,order_catalog_code);
			for(int i=0; i<pres_values.size(); i++)	{
				out.println("prescriptionValuesAmend(\""+(String)pres_values.get(i)+"\")");
			}
			out.println("validateRemarksAmend('"+format_id+"')");
			putObjectInBean(or_bean_id,orbean,request);
		}
		else if(func_mode!= null && func_mode.equals("populateQtyDesc")){
			String form_code		= (String) hash.get("form_code");
			String default_qty_desc_code		= (String) hash.get("default_qty_desc_code")==null?"":(String) hash.get("default_qty_desc_code");
			String qty_desc_dis = (String) hash.get("qty_desc_dis")==null?"":(String) hash.get("qty_desc_dis"); //added for IN21601reopen --03/06/2010 -- priya
			ArrayList QtyDescDetails		= (ArrayList)presBean.loadQtyDetails(form_code);
			String	uom_code	= "";
			String	uom_desc	= "";
			String  dflt_yn		= "";
			boolean default_set = false;
			out.println("clearQtyDescList()");
			for(int i=0; i<QtyDescDetails.size(); i+=3) {
				uom_code	= (String)QtyDescDetails.get(i);
				uom_desc	= (String)QtyDescDetails.get(i+1);
				dflt_yn		= (String)QtyDescDetails.get(i+2);
			//	out.println("addQtyDescList(\""+uom_code+"\",\""+uom_desc+"\")"); //commented for IN21601reopen --03/06/2010 -- priya
				if(default_qty_desc_code.equals(uom_code)){
					out.println("addQtyDescList(\""+uom_code+"\",\""+uom_desc+"\")"); //added for IN21601reopen --03/06/2010 -- priya
					out.println("setdfltQtyUom('"+uom_code+"','Y')");
					default_set = true;
				}
				else if(dflt_yn.equals("Y") && !default_set) {
					out.println("addQtyDescList(\""+default_qty_desc_code+"\",\""+qty_desc_dis+"\")"); //replaced uom_code with default_qty_desc_code for IN21601reopen --03/06/2010 -- priya
					out.println("setdfltQtyUom('"+default_qty_desc_code+"','N')");//replaced uom_code with default_qty_desc_code for IN21601reopen --03/06/2010 -- priya
				}
			}
			out.println("dfltQtyDesc()");
		}
		else if(func_mode!= null && func_mode.equals("changeoverridevalue")){
			String drugCode					= (String)hash.get("drug_code");
			String srl_no					= (String)hash.get("srl_no");
			String ext_srl_no				= null;
			String ext_drug_code            = null;
			HashMap ext_drugData            = null;  
			String  limit_ind               = null;
		//added to get the limit_ind value from teh bean
			String qty_value	= (String) hash.get( "qty_value" );
			String repeat_value	= (String) hash.get( "repeat_value" );
			String patient_id	= (String) hash.get( "patient_id" );
			String dosage_type  = (String) hash.get( "dosage_type" );
			String freq_nature		= (String) hash.get( "freq_nature")==null?"":(String) hash.get( "freq_nature");
			String calc_def_dosage_yn  = (String) hash.get( "calc_def_dosage_yn" )==null?"":(String) hash.get( "calc_def_dosage_yn" );//Added for ML-MMOH-SCF-2514
			
			ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
			ArrayList	schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drugCode+srl_no,"0");
			boolean drugDosageLimitAppl = presBean.isSiteSpecific("PH", "PH_BEY_DOSE_PENCIL_ICON_PRN");
		if(!(drugDosageLimitAppl) && (freq_nature.equals("P") || freq_nature.equals("O"))){ //!(drugDosageLimitAppl) Added for ML-MMOH-SCF-2514
				for(int j=0;j<prescriptionDetails.size();j++){
				  ext_drugData				=(HashMap) prescriptionDetails.get(j);
				  ext_drug_code				=(String) ext_drugData.get("DRUG_CODE");
				  ext_srl_no				=(String) ext_drugData.get("SRL_NO");
					if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
						ext_drugData.put("LIMIT_IND","Y");
						ext_drugData.put("DOSE_REMARKS","");
						out.println("disableoverride('Y')");
						return;
					 }
				}
			}
			if(schedule.size() > 0){
				/* HashMap detail	=	(HashMap)schedule.get(0);
				 qty_value		=	(String)detail.get("admin_qty");*/
				 ArrayList dose_list	= (ArrayList)schedule.get(4);
				 qty_value	= (String)dose_list.get(0);
			}

			HashMap dosageDetails= (HashMap) presBean.chkMaxDosageLimit(drugCode,patient_id,qty_value,dosage_type,repeat_value);
			limit_ind= (String) dosageDetails.get("LIMIT_IND");
			if(limit_ind == null)
				limit_ind = "";
			//added to get the limit_ind value from teh bean
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData				=(HashMap) prescriptionDetails.get(j);
				ext_drug_code				=(String) ext_drugData.get("DRUG_CODE");
				ext_srl_no				=(String) ext_drugData.get("SRL_NO");
				if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
				//	limit_ind=(String) hash.get("limit_ind");
					ext_drugData.put("LIMIT_IND",limit_ind);
					if(limit_ind.equals("Y"))
						ext_drugData.put("DOSE_REMARKS","");
				 }
			}
			out.println("disableoverride(\""+limit_ind+"\")");
		}
		else if (func_mode!= null && func_mode.equals("extDosageCheck")){
			String patient_id					= (String)hash.get("patient_id")==null?"":(String) hash.get( "patient_id" );
			String encounter_id					= (String)hash.get("encounter_id")==null?"":(String) hash.get( "encounter_id" );
			String drugCode					= (String)hash.get("drug_code")==null?"":(String) hash.get( "drug_code" );
			String srl_no					= (String)hash.get("srl_no")==null?"":(String) hash.get( "srl_no" );
			String ext_prod_id					= (String)hash.get("ext_prod_id")==null?"":(String) hash.get( "ext_prod_id" );
			String drug_db_dosecheck_yn	  = (String) hash.get("drug_db_dosecheck_yn")==null?"":(String) hash.get("drug_db_dosecheck_yn");
			//String drug_db_duptherapy_yn      = (String) hash.get("drug_db_duptherapy_yn")==null?"":(String) hash.get("drug_db_duptherapy_yn");
			//String drug_db_interact_check_yn  = (String) hash.get("drug_db_interact_check_yn")==null?"":(String) hash.get("drug_db_interact_check_yn");
			//String drug_db_contraind_check_yn = (String) hash.get("drug_db_contraind_check_yn")==null?"":(String) hash.get("drug_db_contraind_check_yn");
			//String drug_db_allergy_check_yn   = (String) hash.get("drug_db_allergy_check_yn")==null?"":(String) hash.get("drug_db_allergy_check_yn");
			//String ext_override_reason	= (String) hash.get( "ext_override_reason" )==null?"":(String) hash.get( "ext_override_reason" );
			String pract_name	= (String) hash.get( "pract_name" )==null?"":(String) hash.get( "pract_name" );
			String dsg_reason	= (String) hash.get( "dsg_reason" )==null?"":(String) hash.get( "dsg_reason" );
			String dup_reason	= (String) hash.get( "dup_reason" )==null?"":(String) hash.get( "dup_reason" );
			String con_reason	= (String) hash.get( "con_reason" )==null?"":(String) hash.get( "con_reason" );
			String int_reason	= (String) hash.get( "int_reason" )==null?"":(String) hash.get( "int_reason" );
			String alg_reason	= (String) hash.get( "alg_reason" )==null?"":(String) hash.get( "alg_reason" );
			String callfrom	= (String) hash.get( "callfrom" )==null?"":(String) hash.get( "callfrom" );
			String ext_drug_code="";
			String ext_srl_no="";
			String drug_db_dosage_check_flag      =dsg_reason.equals("")?"N":"Y"; 
			String drug_db_duptherapy_flag		=dup_reason.equals("")?"N":"Y";
			String drug_db_contraind_check_flag	=con_reason.equals("")?"N":"Y";
			String drug_db_interact_check_flag	=int_reason.equals("")?"N":"Y";
			String drug_db_allergy_flag = alg_reason.equals("")?"N":"Y";

			String ext_beanid = "@ExternalProductLinkBean";
			String ext_beanname = "ePH.ExternalProductLinkBean";
			ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);

			if(drug_db_dosecheck_yn.equals("Y")){
				String weight	= (String) hash.get( "weight" )==null?"0":(String) hash.get( "weight" );
				String bsa	= (String) hash.get( "bsa" )==null?"0":(String) hash.get( "bsa" );
				String dosage  = (String) hash.get( "dosage" )==null?"0":(String) hash.get( "dosage" );
				String dose_uom  = (String) hash.get( "dose_uom" )==null?"":(String) hash.get( "dose_uom" );
				String repeat_value	= (String) hash.get( "repeat_value" )==null?"0":(String) hash.get( "repeat_value" );
				String interval_value	= (String)hash.get("interval_value")==null?"1":(String) hash.get( "interval_value" );
				String duration	= (String) hash.get( "duration" )==null?"":(String) hash.get( "duration" );
				String dosage_by	= (String) hash.get( "dosage_by" )==null?"":(String) hash.get( "dosage_by" );
				String split_dose_yn	= (String) hash.get( "split_dose_yn" )==null?"":(String) hash.get( "split_dose_yn" );
				String fract_dose_round_up_yn	=	(String) hash.get( "fract_dose_round_up_yn" )==null?"":(String) hash.get( "fract_dose_round_up_yn" );
				String strength_per_value_pres_uom	= (String) hash.get( "strength_per_value_pres_uom" )==null?"1":(String) hash.get( "strength_per_value_pres_uom" );
				String strength_per_pres_uom			= (String) hash.get( "strength_per_pres_uom" )==null?"1":(String) hash.get( "strength_per_pres_uom" );
				String repeat_durn_type	= hash.get("repeat_durn_type")==null?"":(String) hash.get( "repeat_durn_type" );// Code added for IN23562 --08/09/2010-- priya
				String durn_type	= hash.get( "durn_type" )==null?"":(String) hash.get( "durn_type" );
				String freq_nature	= hash.get( "freq_nature" )==null?"":(String) hash.get( "freq_nature" );
				String tmp_durn_value	= hash.get( "tmp_durn_value" )==null?"1":(String) hash.get( "tmp_durn_value" );
				String route_code		= (String)hash.get("route_code")==null?"":(String) hash.get( "route_code" );// Added in January 2014 for CIMS dosage check
				String qty_desc_code	= (String)hash.get("qty_desc_code")==null?"":(String) hash.get( "qty_desc_code" );// Added in January 2014 for CIMS dosage check
				String freq_nature_pas = "I";	  //Added in January 2014, CIMS Dosage Check

				if(tmp_durn_value.equals(""))
					tmp_durn_value = "1";
				String frequency = "";
				double num =1.0;
				double day_num =1.0;
				if(interval_value.equals("0"))
					interval_value = "1";
				if(freq_nature.equals("I")){
					 frequency = ( Float.parseFloat(tmp_durn_value) /Float.parseFloat(interval_value))+""; // removed Math.ceil and (int) for IN23562 reopen --30/09/2010-- priya
					if(durn_type.equals("M")){
						num = new Float(Math.ceil( (60*24)/Float.parseFloat(tmp_durn_value))).intValue();
						day_num = new Float(Math.ceil( Float.parseFloat(tmp_durn_value)/(60*24))).intValue();
						frequency = new Float(Math.ceil((Float.parseFloat(frequency)*((int)num))/(int)day_num) ).intValue() + "";
					}
					else if(durn_type.equals("H")){
						num =new Float(/*Math.ceil( */(24)/ Float.parseFloat(tmp_durn_value)); //ceil commented for IN23562 reopen --23/09/2010-- priya //.intValue()
						day_num =new Float(Math.ceil( Float.parseFloat(tmp_durn_value)/(24))); //.intValue()
						day_num = Float.parseFloat(tmp_durn_value)/(24);
						//	 frequency = new Float(Math.ceil((Float.parseFloat(frequency)*((int)num)))/(int)day_num ).intValue() + "";
						//	  if(Float.parseFloat(frequency) < 1.0)
						//		 frequency = new Float(Math.ceil((Float.parseFloat(frequency)*(num)))/day_num ).intValue() + "";
						//	 else
						frequency = new Float(Math.ceil((Float.parseFloat(frequency))/day_num) ).intValue() + "";
					}
					else if(durn_type.equals("W")){ //will not enter
						num = new Float(Math.ceil( Float.parseFloat(tmp_durn_value)*7)).intValue();
						day_num = new Float(Math.ceil( Float.parseFloat(tmp_durn_value)*7)).intValue();
						frequency = new Float(Math.ceil(Float.parseFloat(frequency)*(int)day_num) ).intValue() + "";
					}
					else{
						frequency = new Float(Math.ceil(Float.parseFloat(frequency)*(int)num) ).intValue() + "";
					}
				}
				else {  //	if(!(freq_nature.equals("I")))
					 frequency = (int)Math.ceil( Float.parseFloat(repeat_value) /Float.parseFloat(interval_value))+"";
				}
				if(dosage_by != null && dosage_by.equals("S")){
					if(fract_dose_round_up_yn.equals("Y")){
						float unit_qty	=(float) Math.ceil(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom));	
						dosage			=   unit_qty * Float.parseFloat(strength_per_value_pres_uom)+"";
					}
					else{
						dosage		=(Float.parseFloat(dosage)*Float.parseFloat(strength_per_value_pres_uom))+"";
						dosage		=	(float)(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom))+"";
					}
					DecimalFormat dfTest = new DecimalFormat("##.####");
					dosage = dfTest.format(Double.parseDouble(dosage));
					dosage		=	Math.ceil(Float.parseFloat(dosage))+"";
				}
				if(split_dose_yn.equals("Y")){
					frequency="1";
				}
				HashMap drugDosageResult = new HashMap();
				ArrayList dosageCheckParams = new ArrayList();
				dosageCheckParams.add(patient_id);
				dosageCheckParams.add(ext_prod_id);
				dosageCheckParams.add(weight);
				dosageCheckParams.add(bsa);
				//Modified for TFS id:-16701 start
				dosageCheckParams.add(dosage);
				if(ext_beanObj!=null && (ext_beanObj.getProdID()).equals("CIMS"))  // Added in January 2014 - DOSAGE Checks Added
					dosageCheckParams.add(qty_desc_code);	// Added in January 2014 - DOSAGE Checks Added
				else
					dosageCheckParams.add(dose_uom);
				//dosageCheckParams.add(dose_uom);
				//Modified for TFS id:-16701 end
				dosageCheckParams.add(frequency);
				if(freq_nature.equals("I")){   //added if-else condition IN23562 --08/09/2010-- priya
					dosageCheckParams.add((new Float(day_num).intValue())+""); 
				}
				else{
					//replaced duration with tmp_durn_value for IN24020 --06/10/2010-- priya
					if(tmp_durn_value.equals(""))
						dosageCheckParams.add(duration);  
					else
						dosageCheckParams.add(tmp_durn_value);  
				}
				dosageCheckParams.add(route_code);	 // Added in January 2014 for CIMS-Dosage Checks -start
				dosageCheckParams.add(repeat_durn_type);	 
				if(freq_nature!=null && !freq_nature.equals(""))
					 freq_nature_pas =  freq_nature;
				dosageCheckParams.add(freq_nature_pas);	
				dosageCheckParams.add(interval_value);	 // Added in January 2014 for CIMS-Dosage Checks -end
				/* //commented for FDB Tuning -Start
				drugDosageResult = ext_beanObj.getDrugDosageCheck(dosageCheckParams);
				if(drugDosageResult != null && drugDosageResult.size() > 0){
					ext_beanObj.setDosageCheck(ext_prod_id, srl_no,drugDosageResult);
					drug_db_dosage_check_flag = "Y";
				}
				else{
					drug_db_dosage_check_flag = "N";
					dsg_reason = "";
				}*/ //commented for FDB Tuning -end
				ArrayList reqChecks = new ArrayList();
				reqChecks.add("Y"); //Dosage Check 
				reqChecks.add("N"); //Duplicate Check
				reqChecks.add("N"); //DrugInteraction
				reqChecks.add("N"); //Contra Indication
				reqChecks.add("N"); //AllergyCheck
				HashMap drugDBCheckResult = ext_beanObj.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", null ,null, dosageCheckParams, "N","",""); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
				drug_db_dosage_check_flag = "N";

				if(drugDBCheckResult != null && drugDBCheckResult.size() > 0){
					drugDosageResult = (HashMap)drugDBCheckResult.get("DOSECHECK");
					if(drugDosageResult != null && drugDosageResult.size() > 0){
						ext_beanObj.setDosageCheck(ext_prod_id, srl_no,drugDosageResult);
						drug_db_dosage_check_flag = "Y";
					}
				}
				if(drug_db_dosage_check_flag.equals("N"))
					dsg_reason = "";
				//drug_detail.put("DRUG_DB_DOSAGE_CHECK_FLAG",drug_db_dosage_check_flag);
			}

			if(drug_db_dosage_check_flag.equals("Y")){
				out.println("displayDosageCheckResult('"+patient_id+"','"+java.net.URLEncoder.encode(pract_name,"UTF-8")+"','"+encounter_id+"','"+ext_prod_id+"','"+drugCode+"','"+srl_no+"','"+drug_db_dosage_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_interact_check_flag+"','"+drug_db_allergy_flag+"','"+java.net.URLEncoder.encode(dsg_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(dup_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(con_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(int_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(alg_reason,"UTF-8")+"','"+callfrom+"');");
			}
			else{
				if(dsg_reason.equals("") && dup_reason.equals("") && con_reason.equals("") && int_reason.equals("") && alg_reason.equals("")) {
					HashMap drug_detail= null;
					ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
					for(int j=0;j<prescriptionDetails.size();j++){
						drug_detail				=(HashMap) prescriptionDetails.get(j);
						ext_drug_code				=(String) drug_detail.get("DRUG_CODE");
						ext_srl_no				=(String) drug_detail.get("SRL_NO");
						if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
							drug_detail.put("DOSE_REMARKS","");
							drug_detail.put("DRUG_DB_DOSAGE_CHECK_FLAG",drug_db_dosage_check_flag);
							break;
						 }
					}
					out.println("hideDosageCheckIcon('"+drugCode+"','"+srl_no+"');");
				}
			}
			putObjectInBean(ext_beanid,ext_beanObj,request);

		}
	else if (func_mode!= null && func_mode.equals("extDosageCheckFromPad")){
		String patient_id					= (String)hash.get("patient_id")==null?"":(String) hash.get( "patient_id" );
		String encounter_id					= (String)hash.get("encounter_id")==null?"":(String) hash.get( "encounter_id" );
		String drugCode					= (String)hash.get("drug_code")==null?"":(String) hash.get( "drug_code" );
		String srl_no					= (String)hash.get("srl_no")==null?"":(String) hash.get( "srl_no" );
		String ext_prod_id					= (String)hash.get("ext_prod_id")==null?"":(String) hash.get( "ext_prod_id" );
		String weight	= (String) hash.get( "weight" )==null?"0":(String) hash.get( "weight" );
		String bsa	= (String) hash.get( "bsa" )==null?"0":(String) hash.get( "bsa" );
		String callfrom	= (String) hash.get( "callfrom" )==null?"":(String) hash.get( "callfrom" );
		String drug_db_product_id =  (String) hash.get("drug_db_product_id")==null?"":(String) hash.get("drug_db_product_id");
		String drug_db_dosecheck_yn	  = (String) hash.get("drug_db_dosecheck_yn")==null?"":(String) hash.get("drug_db_dosecheck_yn");
		String drug_db_duptherapy_yn      = (String) hash.get("drug_db_duptherapy_yn")==null?"":(String) hash.get("drug_db_duptherapy_yn");
		String drug_db_interact_check_yn  = (String) hash.get("drug_db_interact_check_yn")==null?"":(String) hash.get("drug_db_interact_check_yn");
		String drug_db_contraind_check_yn = (String) hash.get("drug_db_contraind_check_yn")==null?"":(String) hash.get("drug_db_contraind_check_yn");
		String drug_db_allergy_check_yn   = (String) hash.get("drug_db_allergy_check_yn")==null?"":(String) hash.get("drug_db_allergy_check_yn");
		String pract_name	= (String) hash.get( "pract_name" )==null?"":(String) hash.get( "pract_name" );

		String dsg_reason	= "";
		String dup_reason	= "";
		String con_reason	= "";
		String int_reason	= "";
		String alg_reason	= "";

		String ext_drug_code="";
		String ext_srl_no="";
		String drug_db_contraind_check_flag	="N";
		String drug_db_interact_check_flag	="N";
		String drug_db_duptherapy_flag		="N";
		String drug_db_dosage_check_flag      ="N"; 
		String drug_db_allergy_flag		="N";
		String startdate="", enddate=""; // Added for ML-BRU-SCF-0811 [IN:039394]
		String ext_beanid = "@ExternalProductLinkBean";
		String ext_beanname = "ePH.ExternalProductLinkBean";
		ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);
		ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
		HashMap drug_detail= null;
		String route_code = ""; //Added in January 2014, CIMS Dosage Check
		String qty_desc_code  = ""; //Added in January 2014, CIMS Dosage Check
		for(int j=0;j<prescriptionDetails.size();j++){
			drug_detail				=(HashMap) prescriptionDetails.get(j);
			ext_drug_code				=(String) drug_detail.get("DRUG_CODE");
			ext_srl_no				=(String) drug_detail.get("SRL_NO");

			if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
				dsg_reason	= (String) drug_detail.get( "DOSE_REMARKS" )==null?"":(String) drug_detail.get( "DOSE_REMARKS" );    
				dup_reason	= (String) drug_detail.get( "CURRENTRX_REMARKS" )==null?"":(String) drug_detail.get( "CURRENTRX_REMARKS" );  
				con_reason	= (String) drug_detail.get( "CONTRAIND_OVERRIDE_REASON" )==null?"":(String) drug_detail.get( "CONTRAIND_OVERRIDE_REASON" );  
				int_reason	= (String) drug_detail.get( "INTERACTION_OVERRIDE_REASON" )==null?"":(String) drug_detail.get( "INTERACTION_OVERRIDE_REASON" );      
				alg_reason	= (String) drug_detail.get( "ALLERGY_REMARKS" )==null?"":(String) drug_detail.get( "ALLERGY_REMARKS" );      
				startdate	= (String) drug_detail.get( "START_DATE_TIME" )==null?"":(String) drug_detail.get( "START_DATE_TIME" );// Added for ML-BRU-SCF-0811 [IN:039394],Modified for TFS id:-16701
				enddate		= (String) drug_detail.get( "END_DATE_TIME" )==null?"":(String) drug_detail.get( "END_DATE_TIME" );// Added for ML-BRU-SCF-0811 [IN:039394],Modified for TFS id:-16701
				break;
			}
		}

		if(drug_db_dosecheck_yn.equals("Y") && (!dsg_reason.equals("")))
			drug_db_dosage_check_flag	= "Y"; 
		else
			drug_db_dosage_check_flag	= "N"; 

		if(drug_db_duptherapy_yn.equals("Y") && (!dup_reason.equals("")))
			drug_db_duptherapy_flag	= "Y"; 
		else
			drug_db_duptherapy_flag	= "N"; 

		if(drug_db_contraind_check_yn.equals("Y") && (!con_reason.equals("")))
			drug_db_contraind_check_flag	= "Y"; 
		else
			drug_db_contraind_check_flag	= "N"; 

		if(drug_db_interact_check_yn.equals("Y") && (!int_reason.equals("")))
			drug_db_interact_check_flag	= "Y"; 
		else
			drug_db_interact_check_flag	= "N"; 

		if(drug_db_allergy_check_yn.equals("Y") && (!alg_reason.equals("")))
			drug_db_allergy_flag	= "Y"; 
		else
			drug_db_allergy_flag	= "N"; 

		ArrayList ext_prod_ids = new ArrayList();
		ArrayList ext_drug_desc = new ArrayList();
		
		//remove this for loop code, after checking, this is not req, aswell removed code from loadamenddetails in bean where these valudes r selected
		//if(drug_detail.get("EXT_PROD_IDS") != null && ((ArrayList)drug_detail.get("EXT_PROD_IDS")).size() > 0){
		ArrayList ext_prod_details = (ArrayList)drug_detail.get("EXT_PROD_IDS");
		if(ext_prod_details!=null){
			for(int k=0; k < ext_prod_details.size(); k+=2){
				if(ext_prod_id!=null ){ //if condition added for not use removeSelectedDrugonAmend -FDB Tuning,Modified for IN:071537
					ext_drug_desc.add((String)ext_prod_details.get(k));
					ext_prod_ids.add((String)ext_prod_details.get(k+1));
				}
			}
		}
		//	}
		/*if(ext_drug_desc!= null && ext_prod_ids!= null && ext_prod_ids.size() > 0)
			ext_beanObj.storeDrugIds(patient_id,"",ext_prod_ids,ext_drug_desc);//Store Drug ids

		ext_beanObj.removeSelectedDrugonAmend(ext_prod_id);

		if(drug_db_interact_check_yn.equals("Y")){
			   ext_beanObj.getDDInteractions(ext_prod_id);//Store interactions
				   HashMap drug_Interactions		= ext_beanObj.getInteractions();//get Interactions
				if(drug_Interactions.size()>0){							
					drug_db_interact_check_flag="Y";
				}else{
					drug_db_interact_check_flag="N";
				}
		}
		if(drug_db_contraind_check_yn.equals("Y")){
				  ArrayList ex_prod_ids =new ArrayList();
				  ex_prod_ids.add(ext_prod_id);
				  boolean flag = ext_beanObj.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
				  HashMap contra_indications =(HashMap)ext_beanObj.getContraIndications();
				  if(contra_indications.containsKey(ext_prod_id)){
					 drug_db_contraind_check_flag="Y";
				  }	else{
					 drug_db_contraind_check_flag="N";
				  }
		}
		if(drug_db_allergy_check_yn.equals("Y")){
				ArrayList ex_prod_ids =new ArrayList();
				ex_prod_ids.add(ext_prod_id);
				ext_beanObj.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result
				HashMap drug_alergies =(HashMap)ext_beanObj.getDrugAlergies();
				if(drug_alergies.containsKey(ext_prod_id)){
					drug_db_allergy_flag="Y";
				}else{
					drug_db_allergy_flag="N";
				}
		}
		if(drug_db_duptherapy_yn.equals("Y")){ 
			   String dup_drug_det			= ext_beanObj.isDuplicateTherapy(ext_prod_id);//get dupluicate theraphy result
			   if(!dup_drug_det.equals("")&&dup_drug_det!=null){
					drug_db_duptherapy_flag="Y";
					drug_detail.put("CURRENT_RX","N");
			   }
			   else
					drug_db_duptherapy_flag="N";

		}*/
		if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") ){
			String storeIDs = "N";
			if(ext_drug_desc!= null && ext_prod_ids!= null && ext_prod_ids.size() > 0)
				storeIDs = "Y";
				
			HashMap tempDetails= null;
			HashMap tempDetailList = null;   /* Added in JUNE 2012 - New changes - Health Care Interaction */
			String ext_prod_id_without_delim       =    "";		 /* Added in JUNE 2012 - New changes - Health Care Interaction */
			ArrayList reqChecks = new ArrayList();
			reqChecks.add("N"); //Dosage Check 
			reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
			reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
			reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
			reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
			HashMap drugDBResult = (HashMap)ext_beanObj.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", ext_prod_ids,ext_drug_desc, null, storeIDs,startdate,enddate); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
			if(drugDBResult!=null)
				ext_beanObj.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBResult);
			if(drug_db_allergy_check_yn.equals("Y")){
				/*tempDetails =(HashMap)drugDBResult.get("ALLERGYCHECK");
				if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
					drug_db_allergy_flag="Y";
				}	
				else									
					drug_db_allergy_flag="N";*/
				/* Condition added in June 2012 */
				drug_db_allergy_flag="N";
				if(ext_beanObj!=null && ext_beanObj.getProdID()!=null && (ext_beanObj.getProdID()).equals("CIMS")){ // for CIMS)
					String allergy_alert			= (String)drugDBResult.get("ALLERGYCHECK");
					if(allergy_alert!=null && !allergy_alert.equals(""))
						drug_db_allergy_flag="Y";
				} 
				else {  
					tempDetails =(HashMap)drugDBResult.get("ALLERGYCHECK");
					if(tempDetails!=null && tempDetails.size()>0){
						 drug_db_allergy_flag="Y";
					}
				} 
			}

			if(drug_db_interact_check_yn.equals("Y")){
				tempDetails =(HashMap)drugDBResult.get("INTRACHECK");
				if(tempDetails!=null && tempDetails.size()>0){
					 drug_db_interact_check_flag="Y";
				}
				else									
					 drug_db_interact_check_flag="N";
			}

			if(drug_db_duptherapy_yn.equals("Y")){ 
			  String dup_drug_det			= (String)drugDBResult.get("DUPCHECK");
			   if(dup_drug_det!=null && !dup_drug_det.equals(""))
					drug_db_duptherapy_flag="Y";
			   else{
					drug_db_duptherapy_flag="N";
			   }
			}
			if(drug_db_contraind_check_yn.equals("Y")){
				if(ext_beanObj!=null && ext_beanObj.getProdID()!=null && (ext_beanObj.getProdID()).equals("CIMS")){ // for CIMS
					tempDetailList = (HashMap)drugDBResult.get("HEALTHINTRACHECK");	 /* Added in JUNE 2012 - New changes - Health Care Interaction */
					/*if(ext_prod_id.indexOf("::")!=-1) commenting start for IN066787- Performance
						ext_prod_id_without_delim = ext_prod_id.substring(ext_prod_id.indexOf("::")+2);
					else
						ext_prod_id_without_delim  = ext_prod_id;

					if( (tempDetails!=null && tempDetails.containsKey(ext_prod_id)) || (tempDetailList!=null && tempDetailList.size()>0 && tempDetailList.containsKey(ext_prod_id_without_delim))){   /* Added in JUNE 2012 - New changes - Health Care Interaction 
						drug_db_contraind_check_flag="Y";commenting end for IN066787- Performance*/
						if(tempDetailList!=null && tempDetailList.size()>0){ //adding start for IN066787- Performance
							 drug_db_contraind_check_flag="Y";
						}//Addign end for IN066787- Performance
				}
				else{
					tempDetails =(HashMap)drugDBResult.get("CONTRACHECK");
					if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
						drug_db_contraind_check_flag="Y";
					}		
					else
						drug_db_contraind_check_flag="N";
				}
			}
		}

		drug_detail.put("DRUG_DB_DOSAGE_CHECK_FLAG",drug_db_dosage_check_flag);
		drug_detail.put("DRUG_DB_CONTRAIND_CHECK_FLAG",drug_db_contraind_check_flag);
		drug_detail.put("DRUG_DB_INTERACT_CHECK_FLAG",drug_db_interact_check_flag);
		drug_detail.put("DRUG_DB_DUPTHERAPY_FLAG",drug_db_duptherapy_flag);
		drug_detail.put("DRUG_DB_ALLERGY_FLAG",drug_db_allergy_flag);

		if(drug_db_dosecheck_yn.equals("Y")){

			String dosage  = "";
			String dose_uom  = "";
			String repeat_value	=	"";
			String interval_value		= "";
			String duration	= "";
			String dosage_by	= "";
			String split_dose_yn	= "";
			String fract_dose_round_up_yn	=	"";
			String strength_per_value_pres_uom	="";
			String strength_per_pres_uom			="";

			String repeat_durn_type = "";
			String durn_type = "";
			String freq_nature = "";
			String tmp_durn_value = "";
			String frequency = "";
			double num =1.0;
			double day_num =1.0;
			String freq_nature_pas = "I"; //Added in January 2014, CIMS Dosage Check
			for(int j=0;j<prescriptionDetails.size();j++){
				drug_detail			=(HashMap) prescriptionDetails.get(j);
				ext_drug_code		=(String) drug_detail.get("DRUG_CODE");
				ext_srl_no			=(String) drug_detail.get("SRL_NO");
				if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
					dosage  = (String) drug_detail.get("QTY_VALUE");
					dose_uom  = (String) drug_detail.get("PRES_BASE_UOM");
					repeat_value	=	(String) drug_detail.get("REPEAT_VALUE")==null?"1":(String) drug_detail.get("REPEAT_VALUE");
					interval_value					= (String) drug_detail.get("INTERVAL_VALUE")==null?"1":(String) drug_detail.get("INTERVAL_VALUE");
					duration	= (String) drug_detail.get("DURN_VALUE");
					dosage_by	= (String) drug_detail.get("DOSAGE_TYPE");
					split_dose_yn	= (String) drug_detail.get("SPLIT_DOSE_YN");
					fract_dose_round_up_yn	=	(String) drug_detail.get("FRACT_DOSE_ROUND_UP_YN");
					strength_per_value_pres_uom	= (String) drug_detail.get("STRENGTH_PER_VALUE_PRES_UOM");
					strength_per_pres_uom			= (String) drug_detail.get("STRENGTH_PER_PRES_UOM");
					repeat_durn_type	= drug_detail.get("REPEAT_DURN_TYPE")==null?"":(String) drug_detail.get( "REPEAT_DURN_TYPE" );// Code added for IN23562 --08/09/2010-- priya -start
					durn_type	= drug_detail.get( "FREQ_DURN_TYPE" )==null?"":(String) drug_detail.get( "FREQ_DURN_TYPE" );
					freq_nature	= drug_detail.get( "FREQ_NATURE" )==null?"":(String) drug_detail.get( "FREQ_NATURE" );
					tmp_durn_value	= drug_detail.get( "FREQ_DURN_VALUE" )==null?"1":(String) drug_detail.get( "FREQ_DURN_VALUE" );
					route_code		= drug_detail.get("ROUTE_CODE" )==null?"":(String) drug_detail.get("ROUTE_CODE" );	//Added in January 2014, CIMS Dosage Check
					qty_desc_code	= drug_detail.get("QTY_DESC_CODE" )==null?"":(String) drug_detail.get("QTY_DESC_CODE" );	//Added in January 2014, CIMS Dosage Check
					freq_nature_pas = "I";	  //Added in January 2014, CIMS Dosage Check
					if(tmp_durn_value.equals(""))
						tmp_durn_value = "1";
					frequency = "";
					num =1.0;
					day_num =1.0;
					if(interval_value.equals("0"))
						interval_value = "1";
					if(freq_nature.equals("I")){
						frequency = ( Float.parseFloat(tmp_durn_value) /Float.parseFloat(interval_value))+"";  //  removed Math.ceil and (int) for IN23562 reopen --30/09/2010-- priya
						if(durn_type.equals("M")){
							num = new Float(Math.ceil( (60*24)/Float.parseFloat(tmp_durn_value))).intValue();
							day_num = new Float(Math.ceil( Float.parseFloat(tmp_durn_value)/(60*24))).intValue();
							frequency = new Float(Math.ceil((Float.parseFloat(frequency)*((int)num))/(int)day_num) ).intValue() + "";
						}
						else if(durn_type.equals("H")){
							num =new Float(/*Math.ceil( */(24)/ Float.parseFloat(tmp_durn_value)); //ceil commented for IN23562 reopen --23/09/2010-- priya //.intValue()
							//	 day_num =new Float(Math.ceil( Float.parseFloat(tmp_durn_value)/(24))); //.intValue()
							day_num = Float.parseFloat(tmp_durn_value)/(24);
							// 	 frequency = new Float(Math.ceil((Float.parseFloat(frequency)*((int)num)))/(int)day_num ).intValue() + "";
							//	 if(Float.parseFloat(frequency) < 1.0)
							//		 frequency = new Float(Math.ceil((Float.parseFloat(frequency)*(num)))/day_num   ).intValue() + "";
							//	else
							frequency = new Float(Math.ceil((Float.parseFloat(frequency))/day_num)   ).intValue() + "";
						}
						else if(durn_type.equals("W")){ //will not enter
							 num = new Float(Math.ceil( Float.parseFloat(tmp_durn_value)*7)).intValue();
							 day_num = new Float(Math.ceil( Float.parseFloat(tmp_durn_value)*7)).intValue();
							 frequency = new Float(Math.ceil(Float.parseFloat(frequency)*(int)day_num) ).intValue() + "";
						}
						else{
							frequency = new Float(Math.ceil(Float.parseFloat(frequency)*(int)num) ).intValue() + "";
						}
					}
					else{
						 frequency = (int)Math.ceil(Float.parseFloat(repeat_value) /Float.parseFloat(interval_value))+"";
					}   // Code added for IN23562 --08/09/2010-- priya -end
					break;
				}
			}
			//String frequency =(int)Math.ceil( Integer.parseInt(repeat_value) / Integer.parseInt(interval_value))+"";
			if(dosage_by != null && dosage_by.equals("S")){
				if(fract_dose_round_up_yn.equals("Y")){
					float unit_qty	=(float) Math.ceil(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom));	
					dosage			=   unit_qty * Float.parseFloat(strength_per_value_pres_uom)+"";
				}
				else{
					dosage		=(Float.parseFloat(dosage)*Float.parseFloat(strength_per_value_pres_uom))+"";
					dosage		=	(float)(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom))+"";
				}
				DecimalFormat dfTest = new DecimalFormat("##.####");
				dosage = dfTest.format(Double.parseDouble(dosage));
				dosage		=	Math.ceil(Float.parseFloat(dosage))+"";
			}
			if(split_dose_yn.equals("Y")){
				frequency="1";
			}

			HashMap drugDosageResult = new HashMap();
			ArrayList dosageCheckParams = new ArrayList();
			dosageCheckParams.add(patient_id);
			dosageCheckParams.add(ext_prod_id);
			dosageCheckParams.add(weight);
			dosageCheckParams.add(bsa);
			if(ext_beanObj!=null && (ext_beanObj.getProdID()).equals("CIMS"))  // Added in January 2014 - DOSAGE Checks Added
				dosageCheckParams.add(qty_desc_code);	// Added in January 2014 - DOSAGE Checks Added
			else
				dosageCheckParams.add(dosage);
			dosageCheckParams.add(dose_uom);
			dosageCheckParams.add(frequency);
			if(freq_nature.equals("I")){  //if-else condition added for IN23562 --08/09/2010-- priya
				dosageCheckParams.add((new Float(day_num).intValue())+""); 
			}
			else{
				//replaced duration with tmp_durn_value for IN24020 --06/10/2010-- priya
				if(tmp_durn_value.equals(""))
					dosageCheckParams.add(duration);  
				else
					dosageCheckParams.add(tmp_durn_value);  
			}
			dosageCheckParams.add(route_code);	 // Added in January 2014 for CIMS-Dosage Checks -start
			dosageCheckParams.add(repeat_durn_type);	 
			 if(freq_nature!=null && !freq_nature.equals(""))
				 freq_nature_pas =  freq_nature;
			 dosageCheckParams.add(freq_nature_pas);	
			 dosageCheckParams.add(interval_value);	 // Added in January 2014 for CIMS-Dosage Checks -end
			//Store Drug ids
			/* //commented for FDB Tuning - start
			drugDosageResult = ext_beanObj.getDrugDosageCheck(dosageCheckParams);

			if(drugDosageResult != null && drugDosageResult.size() > 0){
				ext_beanObj.setDosageCheck(ext_prod_id, srl_no,drugDosageResult);
				drug_db_dosage_check_flag = "Y";
			}
			else
				drug_db_dosage_check_flag = "N";
			*/ //commented for FDB Tuning -End
			ArrayList reqChecks = new ArrayList();
			reqChecks.add("Y"); //Dosage Check 
			reqChecks.add("N"); //Duplicate Check
			reqChecks.add("N"); //DrugInteraction
			reqChecks.add("N"); //Contra Indication
			reqChecks.add("N"); //AllergyCheck
			HashMap drugDBCheckResult = ext_beanObj.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", null ,null, dosageCheckParams, "N","",""); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
			drug_db_dosage_check_flag = "N";

			if(drugDBCheckResult != null && drugDBCheckResult.size() > 0){
				drugDosageResult = (HashMap)drugDBCheckResult.get("DOSECHECK");
				if(drugDosageResult != null && drugDosageResult.size() > 0){
					ext_beanObj.setDosageCheck(ext_prod_id, srl_no,drugDosageResult);
					drug_db_dosage_check_flag = "Y";
				}
			}

			drug_detail.put("DRUG_DB_DOSAGE_CHECK_FLAG",drug_db_dosage_check_flag);
		}
		
		if((drug_db_dosage_check_flag.equals("Y"))||drug_db_interact_check_flag.equals("Y")||drug_db_duptherapy_flag.equals("Y")||drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_flag.equals("Y")){		
			out.println("displayDosageCheckResult('"+patient_id+"','"+java.net.URLEncoder.encode(pract_name,"UTF-8")+"','"+encounter_id+"','"+ext_prod_id+"','"+drugCode+"','"+srl_no+"','"+drug_db_dosage_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_interact_check_flag+"','"+drug_db_allergy_flag+"','"+java.net.URLEncoder.encode(dsg_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(dup_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(con_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(int_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(alg_reason,"UTF-8")+"','"+callfrom+"');");
				
		}
		//else{
			//out.println("hideDosageCheckIcon('"+drugCode+"','"+srl_no+"');");
		//}
		putObjectInBean(ext_beanid,ext_beanObj,request);

	}
	else if (func_mode!= null && func_mode.equals("extDosageCheckResult")){
		String drugCode					= (String)hash.get("drug_code")==null?"":(String) hash.get( "drug_code" );
		String srl_no					= (String)hash.get("srl_no")==null?"":(String) hash.get( "srl_no" );
		String dsg_reason	= (String) hash.get( "dsg_reason" )==null?"":(String) hash.get( "dsg_reason" );
		String dup_reason	= (String) hash.get( "dsg_reason" )==null?"":(String) hash.get( "dup_reason" );
		String con_reason	= (String) hash.get( "dsg_reason" )==null?"":(String) hash.get( "con_reason" );
		String int_reason	= (String) hash.get( "dsg_reason" )==null?"":(String) hash.get( "int_reason" );
		String alg_reason	= (String) hash.get( "dsg_reason" )==null?"":(String) hash.get( "alg_reason" );

		String ext_drug_code="";
		String ext_srl_no="";
		HashMap drug_detail= null;
		ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
		for(int j=0;j<prescriptionDetails.size();j++){
		  drug_detail				=(HashMap) prescriptionDetails.get(j);
		  ext_drug_code				=(String) drug_detail.get("DRUG_CODE");
		  ext_srl_no				=(String) drug_detail.get("SRL_NO");
			if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
				drug_detail.put("DOSE_REMARKS", java.net.URLDecoder.decode(dsg_reason,"UTF-8"));
				drug_detail.put("EXT_DDB_DSG_REASON",java.net.URLDecoder.decode(dsg_reason,"UTF-8"));
				drug_detail.put("EXT_DDB_DUP_REASON",java.net.URLDecoder.decode(dup_reason,"UTF-8"));
				drug_detail.put("EXT_DDB_CON_REASON",java.net.URLDecoder.decode(con_reason,"UTF-8"));
				drug_detail.put("EXT_DDB_INT_REASON",java.net.URLDecoder.decode(int_reason,"UTF-8"));
				drug_detail.put("EXT_DDB_ALG_REASON",java.net.URLDecoder.decode(alg_reason,"UTF-8"));
				drug_detail.put("CURRENTRX_REMARKS",java.net.URLDecoder.decode(dup_reason,"UTF-8"));
				drug_detail.put("CONTRAIND_OVERRIDE_REASON",java.net.URLDecoder.decode(con_reason,"UTF-8"));
				drug_detail.put("INTERACTION_OVERRIDE_REASON",java.net.URLDecoder.decode(int_reason,"UTF-8"));
				drug_detail.put("ALLERGY_REMARKS",java.net.URLDecoder.decode(alg_reason,"UTF-8"));
				break;
			 }
		}
	}
	else if (func_mode!= null && func_mode.equals("getChargeDetails")){

		String drug_code	= (String) hash.get("drug_code")==null?"":(String) hash.get("drug_code");
		String srl_no		= (String) hash.get("srl_no")==null?"":(String) hash.get("srl_no");
		String qty_value	= (String) hash.get("qty_value")==null?"":(String) hash.get("qty_value");
		String repeat_value	= (String) hash.get("repeat_value")==null?"":(String) hash.get("repeat_value");
		String dosage_type  = (String) hash.get("dosage_type")==null?"":(String) hash.get("dosage_type");
		String patient_id	= (String) hash.get("patient_id")==null?"":(String) hash.get("patient_id");
		String encounter_id	= (String) hash.get("encounter_id")==null?"":(String) hash.get("encounter_id");
		String episode_type	= (String) hash.get("episode_type")==null?"":(String) hash.get("episode_type");
		String durn_value	= (String) hash.get("durn_value")==null?"":(String) hash.get("durn_value");
		String qty_desc_code	= (String) hash.get( "qty_desc_code" )==null?"":(String) hash.get("qty_desc_code");
		String interval_value	= (String) hash.get( "interval_value" )==null?"":(String) hash.get("interval_value");
		String bl_override_excl_incl_ind  = (String) hash.get("bl_override_excl_incl_ind")==null?"":(String) hash.get("bl_override_excl_incl_ind");
		String bl_overriden_action_reason = (String) hash.get("bl_overriden_action_reason")==null?"":(String) hash.get("bl_overriden_action_reason");
		String order_Date		= (String) hash.get("order_Date")==null?"":(String) hash.get("order_Date");
		String called_from		= (String) hash.get("called_from")==null?"":(String) hash.get("called_from");
		String billable_item_yn	= (String) hash.get("billable_item_yn")==null?"":(String) hash.get("billable_item_yn");
		String bl_override_excl_incl_ind_DB	= (String) hash.get("bl_override_excl_incl_ind_DB")==null?"":(String) hash.get("bl_override_excl_incl_ind_DB");
		String drug_desc = "";
		String fract_dose_round_up_yn = "";
		String take_home_medication		= (String) hash.get("take_home_medication");
		if(!locale.equals("en"));
			order_Date  = DateUtils.convertDate(order_Date, "DMYHM",locale,"en");
		//added for ML-MMOH-CRF-1531 - start
			String freq_durn_type = (String) hash.get("freq_durn_type")==null?"D":(String) hash.get("freq_durn_type");
			String durn_type = (String) hash.get("durn_type")==null?"D":(String) hash.get("durn_type");

			if(!durn_type.equals(freq_durn_type)){
				durn_value = (String)bean.getFreqDurnConvValue(freq_durn_type,durn_value,durn_type);
			}
		//added for ML-MMOH-CRF-1531 - end
		String ext_srl_no				= null;
		String ext_drug_code            = null;
		HashMap drug_detail            = null;  
		ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();

		for(int j=0;j<prescriptionDetails.size();j++){
		  drug_detail				=(HashMap) prescriptionDetails.get(j);
		  ext_drug_code				=(String) drug_detail.get("DRUG_CODE");
		  ext_srl_no				=(String) drug_detail.get("SRL_NO");
			if( drug_code.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
				drug_desc = (String)drug_detail.get("DRUG_DESC");
				break;
			 }
		}
/*=============================================================================================================*/
//Code added for IN22611 to calculate correct quantity value for split dose and fract_dose_round_up 'Y' --13/07/2010-- priya
			fract_dose_round_up_yn = (String) drug_detail.get("FRACT_DOSE_ROUND_UP_YN")==null?"":(String) drug_detail.get("FRACT_DOSE_ROUND_UP_YN");
			ArrayList	schedule	=	(ArrayList)bean.getScheduleFrequencyStr(ext_drug_code+ext_srl_no,"0");
			ArrayList dose_list = null;
			if(schedule.size() > 0){
				 dose_list	=	(ArrayList)schedule.get(4);
				 if(!dosage_type.equals("A") && dose_list.size() > 0)
					qty_value		=	(String)dose_list.get(0);
			}
			boolean split_chk	=	bean.checkSplit(schedule);
			if(split_chk){
				qty_value = "0";
				for(int d=0; d<dose_list.size(); d++){
					if(!((String)dose_list.get(d)).equals("")){
						if(fract_dose_round_up_yn.equals("N"))
							qty_value = (Float.parseFloat(qty_value) + Float.parseFloat((String)dose_list.get(d)))+"";
						else if(fract_dose_round_up_yn.equals("Y"))
							qty_value = (Float.parseFloat(qty_value) + Math.ceil(Float.parseFloat((String)dose_list.get(d))))+"";
					}
				}
			}

/*=============================================================================================================*/
		if(drug_detail != null){
			String pat_brought_medn = ""; //priya 14-05-2010
			if(billable_item_yn.equals("Y")){
				if(bl_override_excl_incl_ind.equals("SEL")){
					bean.setBillingDetail(drug_detail,dosage_type, qty_value, qty_desc_code, repeat_value,durn_value,interval_value, patient_id, encounter_id, episode_type, order_Date,"", bl_overriden_action_reason,"",take_home_medication);//,pat_brought_medn
				}
				else{
					bean.setBillingDetail(drug_detail,dosage_type, qty_value, qty_desc_code, repeat_value,durn_value,interval_value, patient_id, encounter_id, episode_type, order_Date,bl_override_excl_incl_ind, bl_overriden_action_reason,"",take_home_medication);//,pat_brought_medn
				}
			}
			String bl_total_charge_amt		= (String)drug_detail.get("BL_TOTAL_CHARGE_AMT")==null?"0.0":(String)drug_detail.get("BL_TOTAL_CHARGE_AMT");
			String gross_charge_amt		= (String)drug_detail.get("BL_GROSS_CHARGE_AMT")==null?"0.0":(String)drug_detail.get("BL_GROSS_CHARGE_AMT");//ADDED FOR ML-BRU-CRF-0469
			String bl_patient_payable_amt	= (String)drug_detail.get("BL_PATIENT_PAYABLE_AMT")==null?"0.0":(String)drug_detail.get("BL_PATIENT_PAYABLE_AMT");
			String bl_approval_reqd_yn		= (String)drug_detail.get("BL_APPROVAL_REQD_YN")==null?"N":(String)drug_detail.get("BL_APPROVAL_REQD_YN");
			String bl_override_allowed_yn	= (String)drug_detail.get("BL_OVERRIDE_ALLOWED_YN")==null?"N":(String)drug_detail.get("BL_OVERRIDE_ALLOWED_YN");
			bl_override_excl_incl_ind		= (String)drug_detail.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"E":(String)drug_detail.get("BL_DEF_OVERRIDE_EXCL_INCL_IND");
			String bl_error_code			= (String)drug_detail.get("BL_ERROR_CODE")==null?"":(String)drug_detail.get("BL_ERROR_CODE"); 
			String bl_sys_message_id		= (String)drug_detail.get("BL_SYS_MESSAGE_ID")==null?"":(String)drug_detail.get("BL_SYS_MESSAGE_ID");
			String bl_error_text			= (String)drug_detail.get("BL_ERROR_TEXT")==null?"":(String)drug_detail.get("BL_ERROR_TEXT");
			
			if(!(bl_error_code.equals("") && bl_sys_message_id.equals("") && bl_error_text.equals(""))){
				ArrayList blErrorDrugs = new ArrayList();
				if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
					blErrorDrugs.add(drug_code.trim());
					blErrorDrugs.add(srl_no.trim());
					blErrorDrugs.add(drug_desc);
					blErrorDrugs.add(bl_error_code);
					blErrorDrugs.add(bl_sys_message_id);
					blErrorDrugs.add(bl_error_text);
				}
				if(blErrorDrugs.size()>0){
					out.println("alertBLErrorDrugs('"+blErrorDrugs+"');");
				}
			}
			else
				out.println("assignChargeDetails('"+gross_charge_amt+"','"+bl_total_charge_amt+"','"+bl_patient_payable_amt+"','"+bl_override_excl_incl_ind+"','"+bl_approval_reqd_yn+"','"+bl_override_allowed_yn+"','"+bl_error_code+"','"+bl_sys_message_id+"','"+bl_error_text+"','"+bl_override_excl_incl_ind+"','"+called_from+"','"+bl_override_excl_incl_ind_DB+"');");//ADDED FOR ML-BRU-CRF-0469
			return;
		}
		else{
			out.println("clearDrugdetails();");
		}
	}
	else if (func_mode!= null && func_mode.equals("getBLErrorDrugs")){
		String bl_error_code = "";
		String bl_sys_message_id = "";
		String bl_error_text = "";
		String drug_code = "";
		String drug_desc = "";
		String srl_no = "";
		String mode="";
		String item_code="";

		String patient_id	= (String) hash.get("patient_id")==null?"":(String) hash.get("patient_id");
		String encounter_id	= (String) hash.get("encounter_id")==null?"":(String) hash.get("encounter_id");
		String episode_type	= (String) hash.get("episode_type")==null?"":(String) hash.get("episode_type");
		String order_Date		= (String) hash.get("order_Date")==null?"":(String) hash.get("order_Date");

		if(!locale.equals("en"));
			order_Date  = DateUtils.convertDate(order_Date, "DMYHM",locale,"en");

		String qty_value	= "";
		String repeat_value	= "";
		String interval_value	= "";
		String dosage_type  = "";
		String durn_value	= "";
		String qty_desc_code	= "";
		String bl_override_excl_incl_ind = "";
		String bl_overriden_action_reason = "";
		String freq_nature = "";

		ArrayList blErrorDrugs = new ArrayList();
		HashMap drug_detail = null;
		ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();

		for(int i=0;i<prescriptionDetails.size();i++){			
		//	item_code	= (String)drug_detail.get("ITEM_CODE");
		//	if(item_code!=null && !item_code.equals("")){
				drug_detail=(HashMap) prescriptionDetails.get(i);
				drug_code = (String)drug_detail.get("DRUG_CODE");
				drug_desc = (String)drug_detail.get("DRUG_DESC");
				srl_no = (String)drug_detail.get("SRL_NO");
				qty_value	= (String)drug_detail.get("QTY_VALUE"); 
			
				repeat_value	= (String)drug_detail.get("REPEAT_VALUE");            
				dosage_type  = (String)drug_detail.get("DOSAGE_TYPE");   
				freq_nature  = (String)drug_detail.get("FREQ_NATURE");   
				interval_value  = (String)drug_detail.get("INTERVAL_VALUE")==null?"1":(String)drug_detail.get("INTERVAL_VALUE");   
				if(dosage_type.equals("A") || freq_nature.equals("P")) {
					qty_value		=	(String)drug_detail.get("ORDER_QTY");
					dosage_type		=	"A";
				}
				durn_value	= (String)drug_detail.get("DURN_VALUE");              
				qty_desc_code	= (String)drug_detail.get("QTY_DESC_CODE");          
				bl_override_excl_incl_ind = (String)drug_detail.get("BL_OVERRIDE_EXCL_INCL_IND")==null?"":(String)drug_detail.get("BL_OVERRIDE_EXCL_INCL_IND"); 
				//commented for IN 19200 priya -- 23/02/2010 to update charge details in preview
			//	bean.setBillingDetail(drug_detail,dosage_type, qty_value, qty_desc_code, repeat_value,durn_value,interval_value, patient_id, encounter_id, episode_type, order_Date,bl_override_excl_incl_ind, bl_overriden_action_reason);

				bl_error_code = (String)drug_detail.get("BL_ERROR_CODE")==null?"":(String)drug_detail.get("BL_ERROR_CODE");     
				bl_sys_message_id = (String)drug_detail.get("BL_SYS_MESSAGE_ID")==null?"":(String)drug_detail.get("BL_SYS_MESSAGE_ID"); 
				bl_error_text = (String)drug_detail.get("BL_ERROR_TEXT")==null?"":(String)drug_detail.get("BL_ERROR_TEXT");   

				if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
					blErrorDrugs.add(drug_code.trim());
					blErrorDrugs.add(srl_no.trim());
					blErrorDrugs.add(drug_desc);
					blErrorDrugs.add(bl_error_code);
					blErrorDrugs.add(bl_sys_message_id);
					blErrorDrugs.add(bl_error_text);
				}
		//	}
			}
			if(blErrorDrugs.size()>0){
				if(prescriptionDetails.size() == (blErrorDrugs.size()/6))
					mode="blank";
				else 
					mode = "modify";
				out.println("alertBLErrorDrugs('"+blErrorDrugs+"','"+mode+"');");
			}
		}
		else if(func_mode != null && func_mode.equals("getActiontext" ) ){ //Add this condition for SKR-CRF-0006[IN029561]			
			String form_code		= (String) hash.get( "form_code" );
			String route_code		= (String) hash.get( "route_code" );		
			String actionText = presBean.getActionText(form_code,route_code);		
			out.println("assignActionText('"+actionText+"');"); 
		}
		else if(func_mode != null && func_mode.equals("getTotalTaperQty" ) ){ //Add this condition for RUT-CRF-0069 [IN029607]		
			String drug_code			= (String) hash.get("drug_code")==null?"":(String) hash.get("drug_code");
			String srl_no				= (String) hash.get("srl_no")==null?"":(String) hash.get("srl_no");
			String called_from				= (String) hash.get("called_from")==null?"ONCHANGE":(String) hash.get("called_from");
			float qty_value			= Float.parseFloat( hash.get("qty_value")==null?"1":(String) hash.get("qty_value"));
			float repeat_value			= Float.parseFloat( hash.get("repeat_value")==null?"1":(String) hash.get("repeat_value"));
			float durn_value			= Float.parseFloat(hash.get("durn_value")==null?"1":(String) hash.get("durn_value"));
			float interval_value			= Float.parseFloat( hash.get("interval_value")==null?"1":(String) hash.get("interval_value"));
			float tap_lvl_qty			= Float.parseFloat( hash.get("tap_lvl_qty")==null?"1":(String) hash.get("tap_lvl_qty"));
			//String qty_desc_code			= (String) hash.get("qty_desc_code")==null?"":(String) hash.get("qty_desc_code");
			float totTapperQty = bean.getTotalTaperQty(drug_code, srl_no,called_from,qty_value,durn_value,repeat_value,interval_value);
			out.println("assignTotalTaperQty('"+(int)totTapperQty+"','"+(int)tap_lvl_qty+"');"); 
		} //Commented for RUT-CRF-0088
		else if (func_mode!= null && func_mode.equals("checkHomeLeaveValues")){//added for Bru-HIMS-CRF-093[29960] -->
			String start_date    = (String)hash.get("start_date")==null?"":(String) hash.get( "start_date" );
			String end_date      = (String)hash.get("end_date")==null?"":(String) hash.get( "end_date" );
			if(!locale.equals("en")){//Added for Bru-HIMS-CRF-093-DD1[IN047223]
				start_date  = DateUtils.convertDate(start_date, "DMYHM",locale,"en");
				end_date  = DateUtils.convertDate(end_date, "DMYHM",locale,"en");
			}
			String home_leave_fm = (String)hash.get("home_leave_fm")==null?"":(String) hash.get( "home_leave_fm" );
			String home_leave_to = (String)hash.get("home_leave_to")==null?"":(String) hash.get( "home_leave_to" );
			boolean count =true;
			count =presBean.compareLeaveDates(start_date,end_date,home_leave_fm,home_leave_to);
			out.println(count);
		}//adding end for Bru-HIMS-CRF-093[29960] -->
		else if(func_mode != null && func_mode.equals("updateRoute" ) ){ //this block added for SKR-SCF-0586 IN[034375] Reopened						
			String drug_code		= (String) hash.get("drug_code")==null?"":(String) hash.get("drug_code");
			String srlNo			= (String) hash.get("srlNo")==null?"":(String) hash.get("srlNo");
			String route_code		= (String) hash.get("route_code")==null?"":(String) hash.get("route_code");
			String ext_drug_code	= "";
			String ext_srl_no			=	"";
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap Drug_Details =null;
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
					Drug_Details=(HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) Drug_Details.get("DRUG_CODE");
					ext_srl_no=(String) Drug_Details.get("SRL_NO");
					if( drug_code.equals(ext_drug_code) && srlNo.equals(ext_srl_no) ){
						Drug_Details.put("ROUTE_CODE", route_code);						
						break;
					}
				}
			}
		}
		else if (func_mode!= null && func_mode.equals("discCancelDrug")){ //added for Bru-HIMS-CRF-265 [IN:032315] --begin
			String patient_id	= (String)hash.get("patient_id")==null?"":(String) hash.get( "patient_id" );
			String generic_id	= (String)hash.get("generic_id")==null?"":(String) hash.get( "generic_id" );
			String start_date	= (String)hash.get( "start_date" )==null?"":(String) hash.get( "start_date" );
			String freq_code	= (String)hash.get( "freq_code" )==null?"":(String) hash.get( "freq_code" );
			String drug_code	= (String)hash.get( "drug_code" )==null?"":(String) hash.get( "drug_code" );
			String srlNo	= (String)hash.get( "srlNo" )==null?"":(String) hash.get( "srlNo" );
			String drug_db_interface_yn	= (String)hash.get( "drug_db_interface_yn" )==null?"N":(String) hash.get( "drug_db_interface_yn" );
			String drug_db_duptherapy_yn	= (String)hash.get( "drug_db_duptherapy_yn" )==null?"N":(String) hash.get( "drug_db_duptherapy_yn" );
			String ext_prod_id	= (String)hash.get( "ext_prod_id" )==null?"":(String) hash.get( "ext_prod_id" );
			String drug_db_product_id	= (String)hash.get( "drug_db_product_id" )==null?"":(String) hash.get( "drug_db_product_id" );
			boolean duplicateDrugYN = false;
			String temp_drug_code	= "";
			String current_rx		= "N";
			String dup_drug_det		= "";
			String ext_drug_code = "", ext_srl_no="", tappered_over="";

			if(drug_db_interface_yn.equals("Y") && drug_db_duptherapy_yn.equals("Y") && !ext_prod_id.equals("")){ //Conditions changed (added && drug_db_duptherapy_yn.equals("Y") && !ext_prod_id.equals("")) for  ML-BRU-SCF-1283 [IN:047786]
				String ext_beanid = "@ExternalProductLinkBean";
				String ext_beanname = "ePH.ExternalProductLinkBean";
				ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);
				HashMap ext_drugData= null;
				ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
				String drug_db_duptherapy_flag	= "N";
				String ext_db_drug_code = "";
				ArrayList exProd				= new ArrayList();
				ArrayList drugDesc				= new ArrayList();
				HashMap drug_detail = null;
				String startdate="",enddate="";// Added for ML-BRU-SCF-0811 [IN:039394]
				for(int i=0;i<prescriptionDetails.size();i++){
					drug_detail				=(HashMap) prescriptionDetails.get(i);
					ext_db_drug_code				=(String) drug_detail.get("EXTERNAL_PRODUCT_ID");
					ext_drug_code	= (String) drug_detail.get("DRUG_CODE");
					ext_srl_no				=(String) drug_detail.get("SRL_NO");
					tappered_over	= drug_detail.get( "TAPPERED_OVER" )==null?"":(String) drug_detail.get( "TAPPERED_OVER" );
					if(!ext_db_drug_code.equals("")  && !(tappered_over.equals("Y"))){
						exProd.add((String)drug_detail.get("EXTERNAL_PRODUCT_ID"));
						drugDesc.add((String)drug_detail.get("DRUG_DESC")); 
					}
					if( drug_code.equals(ext_drug_code) && (String.valueOf(srlNo)).equals(ext_srl_no) ){
						drug_detail.put("DRUG_DB_PRODUCT_ID",drug_db_product_id);
						startdate	= (String) drug_detail.get( "START_DATE" )==null?"":(String) drug_detail.get( "START_DATE" );// Added for ML-BRU-SCF-0811 [IN:039394]
						enddate		= (String) drug_detail.get( "END_DATE" )==null?"":(String) drug_detail.get( "END_DATE" );// Added for ML-BRU-SCF-0811 [IN:039394]
					}
					String storeIDs = "N";
					if(exProd.size()>0 && !(tappered_over.equals("Y")))
						storeIDs = "Y";
					HashMap tempDetails= null;
					HashMap tempDetailList = null;   /* Added in JUNE 2012 - New changes - Health Care Interaction */
					String ext_prod_id_without_delim       =    "";	  /* Added in JUNE 2012 - New changes - Health Care Interaction */
					ArrayList reqChecks = new ArrayList();
					reqChecks.add("N"); //Dosage Check 
					reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
					reqChecks.add("N"); //DrugInteraction
					reqChecks.add("N"); //Contra Indication
					reqChecks.add("N"); //AllergyCheck
					//Modified for TFS id:-16701 start
					//HashMap drugDBCheckResult = (HashMap)ext_beanObj.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,drugDesc, null, storeIDs, startdate, enddate); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
					HashMap drugDBCheckResult = null;
					if(ext_beanObj!=null && (ext_beanObj.getProdID()).equals("CIMS") && bean.getCalExtDBYN().equals("N") && storeIDs.equals("Y")){
						drugDBCheckResult = (HashMap)ext_beanObj.getExternalDBChecksNew( reqChecks, ext_prod_id);
					}
					else{
						bean.setCalExtDBYN("N");
						drugDBCheckResult = (HashMap)ext_beanObj.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,drugDesc, null, storeIDs,startdate,enddate); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean
					}
					//Modified for TFS id:-16701 end
					if(drugDBCheckResult!=null)
						ext_beanObj.setExternalDBCheckResult(ext_prod_id,srlNo,drugDBCheckResult);
					if(drug_db_duptherapy_yn.equals("Y")){ 
					   dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
					   if(dup_drug_det!=null && !dup_drug_det.equals(""))
							drug_db_duptherapy_flag="Y";
					}
				   for(int j=0;j<prescriptionDetails.size();j++){
						ext_drugData	=(HashMap) prescriptionDetails.get(j);
						ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");
						ext_srl_no				=(String) drug_detail.get("SRL_NO");
						if( drug_code.equals(ext_drug_code) && (String.valueOf(srlNo)).equals(ext_srl_no) ){
							ext_drugData.put("DRUG_DB_DUPTHERAPY_FLAG",drug_db_duptherapy_flag);
							ext_drugData.put("CURRENT_RX",drug_db_duptherapy_flag);
							ext_drugData.put("ORIG_CURRENT_RX",drug_db_duptherapy_flag);
							break;
						}
					}
				}
			}
			else {
				ArrayList presDetails  = (ArrayList) bean.getpresDetails();
				HashMap drugDetails    = null;
				for(int i=0;i<presDetails.size();i++){
					drugDetails    = (HashMap)presDetails.get(i);
					ext_drug_code	=(String) drugDetails.get("DRUG_CODE");
					ext_srl_no				=(String) drugDetails.get("SRL_NO");
					if( drug_code.equals(ext_drug_code) && (String.valueOf(srlNo)).equals(ext_srl_no) ){
						duplicateDrugYN = presBean.checkDuplicateDrug(patient_id,(String)drugDetails.get("GENERIC_ID"),(String)drugDetails.get("START_DATE"),(String)drugDetails.get("END_DATE"),(String)drugDetails.get("FREQ_CODE"), (String) drugDetails.get("TRN_GROUP_REF"));
						if(duplicateDrugYN)
							current_rx		= "Y";
						else
							current_rx		= "N";
						drugDetails.put("CURRENT_RX",current_rx);
						drugDetails.put("ORIG_CURRENT_RX",current_rx);
					}
				}
			}
		} 
		else if (func_mode!= null && func_mode.equals("recordDiscCanc")){
			String bean_id1="@CancelOrder";
			String bean_name1="eOR.CancelOrder";
			String pract_id=(String)hash.get("pract_id")==null?"":(String)hash.get( "pract_id" );
			HashMap discDup=new HashMap();
			ArrayList selDisc = new ArrayList();
			String disc_vals=hash.get("disc_vals")==null?"":(String)hash.get( "disc_vals" );
			String disc_reason=hash.get("disc_reason")==null?"":(String)hash.get( "disc_reason" );
			String disc_reason_desc=hash.get("disc_reason_desc")==null?"":(String)hash.get( "disc_reason_desc" );
			String cancel_vals=hash.get("cancel_vals")==null?"":(String)hash.get( "cancel_vals" );
			String cancel_reason=hash.get("cancel_reason")==null?"":(String)hash.get( "cancel_reason" );
			String cancel_reason_desc=hash.get("cancel_reason_desc")==null?"":(String)hash.get( "cancel_reason_desc" );
			StringTokenizer st = null;
			StringTokenizer st1 = null;
			String order_id="", pract_id1="", drug_code="", order_line_no="", pres_drug_code="", pres_generic_id="", temp_generic_id="";
			HashMap hmDiscCancelledOrders = bean.getDiscCancelledOrders(); //Added for HSA-CRF-0138 [IN:048414]
			if(hmDiscCancelledOrders == null)
				hmDiscCancelledOrders = new HashMap();
			ArrayList alDisCancelledOrdDtls = null; //Added for HSA-CRF-0138 [IN:048414]
			Hashtable discHT= null;
			boolean local_ejbs = false, disc_valsYN=false , result=false, validated=false;
			OrAdapter beanObj = (OrAdapter)getBeanObject( bean_id1, bean_name1,  request) ; 
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
			beanObj.setLocalEJB(local_ejbs);
			beanObj.setLoginById( (String) session.getValue( "login_user" ) ) ;
			beanObj.setLoginAtWsNo( beanObj.getProperties().getProperty( "client_ip_address" ) ) ;
			beanObj.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;
			if((String) hash.get( "mode" )!=null)
				beanObj.setMode( (String) hash.get( "mode" )) ;
			if((String) hash.get( "locale" )!=null)
				beanObj.setLanguageId( (String) hash.get( "locale" ) ) ;
			else
				beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
			HashMap map = new HashMap();
			int successCount=0, errorCount=0;
			String invalidCode="",invalidCodeVal="", message="", flag="", validationMessage="";
			ArrayList disc_cancel_vals = new ArrayList();
			if(!disc_vals.equals("")){
				disc_cancel_vals.add(disc_vals);
				disc_valsYN = true;
			}
			if(!cancel_vals.equals(""))
				disc_cancel_vals.add(cancel_vals);
			for(int i=0; i<disc_cancel_vals.size(); i++){
				st = new StringTokenizer((String)disc_cancel_vals.get(i),"^");
				while(st.hasMoreTokens()){
					st1 = new StringTokenizer(st.nextToken(),"~");
					if(st1.hasMoreTokens()){
						discHT= new Hashtable();
						order_id=st1.nextToken();
						pract_id1=st1.nextToken();
						drug_code=st1.nextToken();
						order_line_no=st1.nextToken();
						pres_drug_code=st1.nextToken(); //Added for HSA-CRF-0138 [IN:048414]
						pres_generic_id=st1.nextToken(); //Added for HSA-CRF-0138 [IN:048414] added for 54058 
						if(disc_valsYN && i==0){
							discHT.put("from","line");
							discHT.put("which_place","discontinue_line_rec");
							discHT.put("reason_desc",java.net.URLDecoder.decode(disc_reason_desc,"UTF-8")); 
						}
						else{
							discHT.put("which_place","cancel_line_rec");
							discHT.put("reason_desc",java.net.URLDecoder.decode(cancel_reason_desc,"UTF-8")); 
						}
						discHT.put("mode","1");
						discHT.put("pract_id",pract_id);
						discHT.put("orderId",order_id);
						discHT.put("catalog_code",drug_code);
						discHT.put("order_type_code","");
						discHT.put("order_line_num",order_line_no);
						discHT.put("cont_order_ind","");
						discHT.put("ord_cat_id","PH");
						discHT.put("iv_prep_yn","");
						beanObj.setAll(discHT);
						map = beanObj.validate() ;
						validated = ((Boolean) map.get( "result" )).booleanValue() ;
						map.put( "message",beanObj.getMessage((String)map.get( "message" ))) ;
						validationMessage = map.get("message") == null ? "" :(String)map.get("message")  ;
						validationMessage = beanObj.replaceNewLineChar( validationMessage );
						if ( validated ){
							map = beanObj.apply() ;	
							result = ((Boolean) map.get( "result" )).booleanValue() ;
							map.put( "message",beanObj.getMessage((String)map.get( "message" ))) ;
							message = beanObj.replaceNewLineChar(beanObj.checkForNull((String)map.get("message")));
							if(map.get("invalidCode") != null)
								invalidCode = (String) map.get( "invalidCode" ) ;
							flag =beanObj.replaceNewLineChar(beanObj.checkForNull((String) map.get( "flag" )));
							successCount++;
						} 
						else {
							if(map.get("invalidCode") != null)
								invalidCodeVal = (String) map.get( "invalidCode" ) ;
							flag =beanObj.replaceNewLineChar(beanObj.checkForNull((String) map.get( "flag" )));
							errorCount++;
						}	
						putObjectInBean(bean_id1,beanObj,request);
						ArrayList prescriptionDetails	=	(ArrayList)bean.getpresDetails(); //added for 54058 start
						HashMap drugDetail	=	null;
						for(int j=0;j<prescriptionDetails.size();j++){
							drugDetail=(HashMap) prescriptionDetails.get(j);
							pres_drug_code=(String) drugDetail.get("DRUG_CODE");
							temp_generic_id=(String) drugDetail.get("GENERIC_ID");
							if(temp_generic_id.equals(pres_generic_id)){ //added for 54058  -end
								if(hmDiscCancelledOrders!=null && hmDiscCancelledOrders.containsKey(pres_drug_code)){//Added for HSA-CRF-0138 [IN:048414] -Start
									alDisCancelledOrdDtls = (ArrayList)hmDiscCancelledOrders.get(pres_drug_code); 
								}
								else
									alDisCancelledOrdDtls = new ArrayList();
								alDisCancelledOrdDtls.add(order_id);
								alDisCancelledOrdDtls.add(order_line_no);
								hmDiscCancelledOrders.put(pres_drug_code, alDisCancelledOrdDtls);
							}
						}
						bean.setDiscCancelledOrders(hmDiscCancelledOrders);//Added for HSA-CRF-0138 [IN:048414] -End
						if(bean.getAmend_alternate_yn().equals("Y")){//added for  JD-CRF-0198 [IN:058599]
							String	bean_id_1					=	"DispMedicationBean" ;
							String	bean_name_1					=	"ePH.DispMedicationBean";
							DispMedicationBean bean_1			= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
							bean_1.setAlternateAmendReason(java.net.URLDecoder.decode(disc_reason_desc,"UTF-8"));
							message  =  "Discontinue";
						}
					}
				}
			}
			if(errorCount==0 ){
				out.println("getResult(" + result + ", \"" + message + "\", \"" + flag + "\" , \"" + invalidCode.trim() + "\") ; ") ;
			}
			else{
				out.println("getResult(" + validated + ", \"" + validationMessage + "\", \"0\" ) ; ") ;
			}
		}//Added for Bru-HIMS-CRF-265 [IN:032315] --end
		else if(func_mode != null && func_mode.equals("settrimester" ) ){ //added for CRF RUT-CRF-0063[29601]		
			String lmp_date		= (String) hash.get( "lmp_date" );
			String start_date	= (String) hash.get( "start_date" );
			String drug_code	= (String) hash.get( "drug_code" );
			String trimster_default	= (String) hash.get( "trimster_default" );
			double preg_week = presBean.getCalPregStage(start_date,lmp_date);		
			 preg_week=Math.ceil(preg_week);
			 String trimester                =presBean.getTrimster(preg_week);
			 ArrayList prescriptionDetails	=	(ArrayList)bean.getpresDetails();
			 HashMap drugDetail	=	null;
			 for(int j=0;j<prescriptionDetails.size();j++){
				 drugDetail=(HashMap) prescriptionDetails.get(j);
				String curr_drug_code=(String) drugDetail.get("DRUG_CODE");
				if(drug_code.equals(curr_drug_code)){
					drugDetail.put("trimester",trimester);
				}
			}
			 HashMap pregDrugDetails=new HashMap();
			 if(drug_code!=null && !drug_code.equals("") && !trimster_default.equals(trimester)){
			 pregDrugDetails=presBean.getPregDrugDetails(drug_code,trimester);
			 String preg_effect=(String) pregDrugDetails.get("PREG_EFFECT");
			 String preg_warn_req_yn=(String) pregDrugDetails.get("PREG_WARN_REQ_YN");
			 String preg_category_code=(String) pregDrugDetails.get("PREG_CATEGORY_CODE");
			 out.println("assignpregdrug('"+preg_effect+"','"+preg_warn_req_yn+"','"+preg_category_code+"','"+trimester+"');");
			 }
		}//added for CRF RUT-CRF-0063[29601]-end
		else if(func_mode != null && func_mode.equals("getTotalTaperQty_LVL" ) ){ //Add this condition for RUT-CRF-0069 [IN029607]	
			String called_from				= (String) hash.get("called_from")==null?"ONCHANGE":(String) hash.get("called_from");
			float qty_value			= Float.parseFloat( hash.get("qty_value")==null?"1":(String) hash.get("qty_value"));
			float totTapperQty = Float.parseFloat( hash.get("totTapperQty")==null?"1":(String) hash.get("totTapperQty"));
			String drug_code			= (String) hash.get("drug_code")==null?"":(String) hash.get("drug_code");
			String srl_no				= (String) hash.get("srl_no")==null?"":(String) hash.get("srl_no");
			float repeat_value			= Float.parseFloat( hash.get("repeat_value")==null?"1":(String) hash.get("repeat_value"));
			float durn_value			= Float.parseFloat(hash.get("durn_value")==null?"1":(String) hash.get("durn_value"));
			float interval_value			= Float.parseFloat( hash.get("interval_value")==null?"1":(String) hash.get("interval_value"));
			float tap_lvl_qty=Float.parseFloat( hash.get("tap_lvl_qty")==null?"0":(String) hash.get("tap_lvl_qty"));;  //Added for RUT-CRF-0088 [IN036978]
			String repeat_durn_type = (String) hash.get("repeat_durn_type")==null?"D":(String) hash.get("repeat_durn_type");
			String durn_desc_code = (String) hash.get("durn_desc")==null?"D":(String) hash.get("durn_desc");
			String calc_dosg_by_freq_durn_yn = (String) hash.get("calc_dosg_by_freq_durn_yn")==null?"":(String) hash.get("calc_dosg_by_freq_durn_yn"); //added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595]
			String dosage_type = (String) hash.get("dosage_type")==null?"":(String) hash.get("dosage_type");
			durn_value =	Float.parseFloat(bean.getFreqDurnConvValue(repeat_durn_type,(int)durn_value+"",durn_desc_code));
			String tap_lvl_qty_tmp = "";
			ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
			HashMap ext_drugData = null;
			String ext_drug_code ="", ext_srl_no="", qty_desc_code="", pres_base_uom="",conv_factor="" , tappered_over="", drug_tapered="", freq_chng_durn_value="", absol_qty="", freq_chng_durn_desc="";
			boolean split_chk = false;
			ArrayList schedule = null;
			if(dosage_type.equals("A")){
				qty_value =tap_lvl_qty;
			}
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData				=(HashMap) prescriptionDetails.get(j);
				ext_drug_code				=(String) ext_drugData.get("DRUG_CODE");
				ext_srl_no				=(String) ext_drugData.get("SRL_NO");
				if( drug_code.equals(ext_drug_code) ){
					if(ext_srl_no.equals(srl_no)){  //Added for RUT-CRF-0088 [IN036978]
						if(called_from.equals("TAP_LVL_QTY")){
							schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
							if(schedule!=null)
								split_chk	=	bean.checkSplit(schedule);
							if(dosage_type.equals("Q")){
								qty_desc_code	= (String) ext_drugData.get("QTY_DESC_CODE");
								pres_base_uom	= (String) ext_drugData.get("PRES_BASE_UOM");
								conv_factor =  bean.getConvFactor(qty_desc_code,pres_base_uom);	
							}
							else if(dosage_type.equals("A")){
								qty_value =tap_lvl_qty;
							}
							tap_lvl_qty= Float.parseFloat(bean.getOrderQty(ext_drugData,qty_value+"","",durn_value+"","",dosage_type,conv_factor,split_chk));
						}
						if(dosage_type.equals("A"))
							ext_drugData.put("ABSOL_QTY",tap_lvl_qty+"");
						ext_drugData.put("TAP_LVL_QTY",tap_lvl_qty+"");
						break;
					}
				}
			}
			putObjectInBean(bean_id,bean,request);
			totTapperQty=bean.getTotalTaperQty(drug_code, srl_no,called_from,qty_value,repeat_value,durn_value,interval_value);
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData				=(HashMap) prescriptionDetails.get(j);
				ext_drug_code				=(String) ext_drugData.get("DRUG_CODE");
				ext_srl_no				=(String) ext_drugData.get("SRL_NO");
				if( drug_code.equals(ext_drug_code) ){
					if(ext_drugData.get("FREQ_NATURE")!=null && !((ext_drugData.get("FREQ_NATURE")).equals("O")) && !((ext_drugData.get("FREQ_NATURE")).equals("P"))){
						drug_tapered	= ext_drugData.get("DRUG_TAPERED_YN")==null?"":(String)ext_drugData.get("DRUG_TAPERED_YN");;
						tappered_over	= ext_drugData.get("TAPPERED_OVER")==null?"":(String)ext_drugData.get("TAPPERED_OVER");
						tap_lvl_qty_tmp	= ext_drugData.get("TAP_LVL_QTY")==null?"":(String)ext_drugData.get("TAP_LVL_QTY");
						if(tappered_over.equals("N") && drug_tapered.equals("Y") && tap_lvl_qty_tmp.equals("") ){
							schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
							qty_value	= Float.parseFloat(ext_drugData.get("QTY_VALUE")==null?"1":(String)ext_drugData.get("QTY_VALUE"));
							absol_qty	= ext_drugData.get("ABSOL_QTY")==null?"1":(String)ext_drugData.get("ABSOL_QTY");
							durn_value	= Float.parseFloat(ext_drugData.get("DURN_VALUE")==null?"":(String)ext_drugData.get("DURN_VALUE"));
							dosage_type	= ext_drugData.get("DOSAGE_TYPE")==null?"":(String)ext_drugData.get("DOSAGE_TYPE");
							repeat_durn_type	= (String)ext_drugData.get("REPEAT_DURN_TYPE")==null?"":(String)ext_drugData.get("REPEAT_DURN_TYPE");	
							freq_chng_durn_value = durn_value+"";
							freq_chng_durn_desc	= (String)ext_drugData.get("freq_chng_durn_desc")==null?"":(String)ext_drugData.get("freq_chng_durn_desc");	
							if(!freq_chng_durn_desc.equals(repeat_durn_type)){
								freq_chng_durn_value = (String)bean.getFreqDurnConvValue(repeat_durn_type,durn_value+"",freq_chng_durn_desc);
							}
							if(schedule!=null)
								split_chk	=	bean.checkSplit(schedule);
							if(dosage_type.equals("Q")){
								qty_desc_code	= (String) ext_drugData.get("QTY_DESC_CODE");
								pres_base_uom	= (String) ext_drugData.get("PRES_BASE_UOM");
								conv_factor =  bean.getConvFactor(qty_desc_code,pres_base_uom);	
							}
							else if(dosage_type.equals("A")){
								qty_value = Float.parseFloat(absol_qty);
							}
							tap_lvl_qty_tmp= bean.getOrderQty(ext_drugData,qty_value+"","",durn_value+"","",dosage_type,conv_factor,split_chk);
							ext_drugData.put("TAP_LVL_QTY",tap_lvl_qty_tmp);
						}
						ext_drugData.put("TOTTAPPERQTY",totTapperQty+""); 
					}
				}
			}
			out.println("assignTotalTaperQty('"+(int)totTapperQty+"','"+(int)tap_lvl_qty+"');"); 
		}
		else if(func_mode!=null && func_mode.equals("updateTapLvlQty")){   //Added for RUT-CRF-0088 [IN036978] --  begin
			String drug_code	= (String) hash.get("drug_code")==null?"":(String)hash.get("drug_code"); 
			int tot_qty=Integer.parseInt( hash.get("tot_qty")==null?"1":(String) hash.get("tot_qty"));
			String dft_tap_lvl_qty	= (String) hash.get("tap_lvl_qty")==null?"":(String)hash.get("tap_lvl_qty");
			String order_type_code	= (String) hash.get("order_type_code")==null?"":(String)hash.get("order_type_code");//Added for  RUT-SCF-0321 [IN044816]
			String tap_lvl_qty= null;//Added for  RUT-SCF-0321[IN044816]
			String totTapper=null;//Added for  RUT-SCF-0321[IN044816]
			Float tapqty=Float.parseFloat( hash.get("tapqty")==null?"0":(String) hash.get("tapqty"));//Added for  RUT-SCF-0321[IN044816]
			int totTapperQty = hash.get("totTapperQty")==null?0:Integer.parseInt((String)hash.get("totTapperQty"));
			String srl_no				= (String) hash.get("srl_no")==null?"":(String) hash.get("srl_no");
			ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
			String ext_drug_code ="", ext_srl_no="";
			HashMap ext_drugData = null;
			//ext_drugData	=(HashMap) prescriptionDetails.get(Integer.parseInt(srl_no)-1);//commented for  RUT-SCF-0320[IN044815]
			for(int j=0;j<prescriptionDetails.size();j++){	//Added for RUT-SCF-0320[IN044815]--start
				ext_drugData = (HashMap) prescriptionDetails.get(j);
				if(drug_code.equalsIgnoreCase((String) ext_drugData.get("DRUG_CODE"))){
					totTapper =(String) ext_drugData.get("TOTTAPPERQTY");
				}
			}//Added for RUT-SCF-0320[IN044815]--end
			//totTapper =(String) ext_drugData.get("TOTTAPPERQTY");//commented for  RUT-SCF-0320[IN044816]
			/*for(int j=0;j<prescriptionDetails.size();j++){                           //commeneted for RUT-SCF-321[IN044816]--begin
				ext_drug_code				=(String) ext_drugData.get("DRUG_CODE");
				ext_srl_no				=(String) ext_drugData.get("SRL_NO");
				
			}*/ //commeneted for RUT-SCF-321[IN044816]--end
			
			Float calc = tapqty-Float.parseFloat(totTapper);//Added for  RUT-SCF-0321 [IN044816]
			Float taplvl = 0.0f;//Added for  RUT-SCF-0321[IN044816]
			if(calc!=0.0f){//Added for  RUT-SCF-0321 [IN044816]--begin
				for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData = (HashMap) prescriptionDetails.get(j);
					ext_drug_code = (String) ext_drugData.get("DRUG_CODE");
					ext_srl_no = (String) ext_drugData.get("SRL_NO");
					tap_lvl_qty =(String) ext_drugData.get("TAP_LVL_QTY");
				
					if(tap_lvl_qty == null || tap_lvl_qty.trim().length()==0)
						tap_lvl_qty= dft_tap_lvl_qty;
					if(drug_code.equals(ext_drug_code)){
						if(calc <= 0){
							
							taplvl = Float.parseFloat(tap_lvl_qty) + calc;
							calc = taplvl;
							if(taplvl < 0.0f)
								taplvl = 0.0f;
							ext_drugData.put("TAP_LVL_QTY", taplvl.toString());
							if(srl_no.equalsIgnoreCase(ext_srl_no))
								out.println(taplvl.toString());
							if(calc >= 0)
								break;
						}
						else{
							if(srl_no.equalsIgnoreCase(ext_srl_no) ){
								taplvl = Float.parseFloat(tap_lvl_qty) + calc;
								ext_drugData.put("TAP_LVL_QTY", taplvl.toString());
								out.println(taplvl.toString());
							}
							else{
								ext_drugData.put("TAP_LVL_QTY", tap_lvl_qty);
							}
						}
					}
				 }
				
				for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData = (HashMap) prescriptionDetails.get(j);
					ext_drug_code = (String) ext_drugData.get("DRUG_CODE");
				if(order_type_code.equals((String) ext_drugData.get("ORDER_TYPE_CODE"))){
					if( drug_code.equals(ext_drug_code) ){
						if(ext_drugData.get("FREQ_NATURE")!=null && !((ext_drugData.get("FREQ_NATURE")).equals("O")) && !((ext_drugData.get("FREQ_NATURE")).equals("P")))
							ext_drugData.put("TOTTAPPERQTY",tapqty+""); 
					}
				}
			}
			
			}//Added for  RUT-SCF-0321 [IN044816]--end
		}
		else if (func_mode!= null && func_mode.equals("GET_TRNGROUPREF")){
			String tokens_generated_yn = bean.getTokensGeneratedYN();
			String trn_group_ref = "";
			if(tokens_generated_yn.equals("Y")){
				trn_group_ref = bean.getTrnGroupRef();
			}
			out.println(trn_group_ref);
		}
		else if(func_mode!= null && func_mode.equals("ExternalPrescription_PatDtls")){// Moved here for Code limit in PrescriptionValidation_1  -start
			String patient_id			= (String) hash.get("patient_id");
			bean.setLanguageId((String) hash.get("locale"));
			ArrayList patient_dtls		= bean.getPatientDetailsTre(patient_id);
			String patient_name="";
			if(patient_dtls!=null && patient_dtls.size()>0){
				HashMap pat_details = (HashMap)patient_dtls.get(0); // patient_dtls.get(0) assigned for ML-BRU-SCF-0675 [IN:037568]
				if(patient_dtls.size() > 0){
					patient_name = pat_details.get("patient_name")==null?"":(String)pat_details.get("patient_name");
					patient_name=patient_name.replaceAll(" ","%20");
					patient_name = java.net.URLEncoder.encode(patient_name,"UTF-8");
					patient_name=patient_name.replaceAll("%2520","%20");
					out.println("assignPatientDetails('"+patient_name+"','"+(String)pat_details.get("age")+"','"+(String)pat_details.get("sex")+"')");
				}
				else
					out.println("assignPatientDetails('','','')");
			}
		}
		else if(func_mode != null && func_mode.equals("PRNRemarks")){
			String prnRemarks = (String)hash.get( "remarks");
			String drug_code = (String)hash.get( "drug_code");
			String remarks_code = (String)hash.get( "remarks_code")==null?"": (String)hash.get( "remarks_code");
			prnRemarks = java.net.URLDecoder.decode(prnRemarks,"UTF-8");
			HashMap remarks = new HashMap();
			remarks.put("prn_remarks_code",remarks_code);
			remarks.put("prn_remarks_dtl",prnRemarks);
			bean.addPRNRemarks(drug_code,remarks);
		}
		else if(func_mode != null && func_mode.equals("ChkPRNRemarks")){
			String drug_code = (String)hash.get( "drug_code");
			if( ((HashMap)bean.getPRNRemarks(drug_code)) == null ) {
				out.println("alert(getMessage('PRN_REMARKS_CANNOT_BE_BLANK','PH'));") ;
			}
		}
		else if(func_mode != null && func_mode.equals("ExternalPrescription")){
			String patient_id			= (String) hash.get("patient_id");
			bean.setExternalpatient_id(patient_id);
			String ref_facility			= "";
			if(hash.containsKey("ref_facility"))
				ref_facility			= (String) hash.get("ref_facility");
			else if(hash.containsKey("other_facility"))
				ref_facility = (String)hash.get("other_facility") ;//assigning other_facility to ref_facility
			ref_facility			= ref_facility.trim();
			bean.setExternalreffacility(ref_facility);
			bean.setExternalRefpractitioner((String) hash.get("ref_practitioner"));
			bean.setExternalDateref((String) hash.get("dt_ref"));
			bean.setExternalRemarks(java.net.URLDecoder.decode((String) hash.get("remarks"),"UTF-8")); // Decode added for ML-BRU-SCF-0234 [IN:033164]
		} // Moved here for Code limit in PrescriptionValidation_1  -End
		else if(func_mode != null && func_mode.equals("copied_drugs")){
			ArrayList orders	=  null ; 
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			String drugs	 =  "";
			String iv_prep_yn=(String)hash.get("iv_prep_yn");
			String order_id = (String)hash.get("order_id");
			String called_from = (String)hash.get("called_from"); //Navigate
			String call_from = (String)hash.get("call_from"); //Navigate
			if(call_from!=null && call_from.equalsIgnoreCase("disc")){
				ArrayList selectedDetails=(ArrayList)bean.getCurrentSelectedDrugs();
				LinkedHashMap copydrugs = new LinkedHashMap();
				ArrayList selecteddrugs = new ArrayList();
				String order_date_from=(String)hash.get("order_date_from");
				String order_date_to=(String)hash.get("order_date_to");
				String dupOverRideReason=(String)hash.get("dupOverRideReason");
				String durn_value=(String)hash.get("durn_value");
				String durn_desc=(String)hash.get("durn_desc");
				for(int i=0; i<selectedDetails.size(); i+=21){
					if(!copydrugs.containsKey((String)selectedDetails.get(i+3))){
						selecteddrugs=new ArrayList();
						selecteddrugs.add(order_date_from);
						selecteddrugs.add(order_date_to);
						selecteddrugs.add(java.net.URLDecoder.decode(dupOverRideReason,"UTF-8"));
						selecteddrugs.add(durn_value);
						selecteddrugs.add(selectedDetails.get(i+20));
						selecteddrugs.add(durn_desc);
						copydrugs.put((String)selectedDetails.get(i+3), selecteddrugs);
					}
				}
				bean.setselectedCopyDrugs(copydrugs);
				orders 	=  bean.getdiscPrescriptions();
			}
			else
				orders 	=  bean.getPrescriptions();
			String order_ids = "";
			boolean found	 =  false; 
			int k = 1;
			for(int i=0; i<orders.size(); i++){
				found	=	false;
				if(((String)orders.get(i)).indexOf(",")==-1){
					for(int j=0;j<prescriptionDetails.size();j++){
						if( ((String)((HashMap) prescriptionDetails.get(j)).get("DRUG_CODE")).equals((String)orders.get(i)) ) {
							found	=	true;
							break;
						}
					}
					if(!found){
						drugs=drugs+ ((String)orders.get(i))+",";
						//order_ids = order_ids + ((String)orders.get(i-1))+",";
						//order_ids = order_ids.substring(0,order_ids.indexOf(","));
					}
				}
				if(k==1)
					order_ids = order_ids + "!" + (String)orders.get(i);
				else
					order_ids = order_ids + "$" + (String)orders.get(i);
				if(k<2)
					k = k+1;
				else if(k==2)
					k=1;				
			}
			if(called_from.equals("Copy")){
				if(iv_prep_yn.equals("")){
					out.println("returnDrugs(\"" + drugs + "\",\""+order_ids+"\",\""+func_mode+"\");") ;
				}
				else{
					String answer = (String)hash.get("answer"); //passed answer for IN24251 --16/12/2010-- priya
					out.println("returnOrder(\"" + order_id + "\",\""+answer+"\");") ;
				}
			}
		}
		else if(func_mode!= null && func_mode.equals("loadDispLocnForFreq")){ //Added for MMS_BETA_0043 [IN:046240]
			String in_formulary_yn		= (String) hash.get("in_formulary_yn")==null?"":(String) hash.get("in_formulary_yn");
			String act_patient_class		= (String) hash.get("act_patient_class")==null?"":(String) hash.get("act_patient_class");
			String priority		= (String) hash.get("priority")==null?"":(String) hash.get("priority");
			String drug_code		= (String) hash.get("drug_code")==null?"":(String) hash.get("drug_code");
			String locn_code	= (String)hash.get( "source_code" )==null?"":(String) hash.get("source_code");
			String take_home_medication		= (String) hash.get("take_home_medication")==null?"":(String) hash.get("take_home_medication");
			String order_type_code		= (String) hash.get("order_type_code")==null?"":(String) hash.get("order_type_code");
			String drug_class		= (String) hash.get("drug_class")==null?"":(String) hash.get("drug_class");
			String home_leave_yn_val=(String)hash.get( "home_leave_yn_val" );
			String patient_id=(String)hash.get( "patient_id" );
			String encounter_id=(String)hash.get( "encounter_id" );
			String srlNo		= (String) hash.get("srlNo")==null?"":(String) hash.get("srlNo");
			String locn_type	= "";
			String disp_locn="";
			String disp_locn_code="";
			String disp_locn_desc="",performing_facility_id ="";
			if( bean.getExternalpatient_id()==null ||  ((String)bean.getExternalpatient_id()).equals("") )
				locn_type	= (String)hash.get( "source_type" );	
			else
				locn_type	= "P";	
			disp_locn			= bean.getDispLocn(in_formulary_yn, act_patient_class, priority, drug_code, locn_type, locn_code, take_home_medication, order_type_code,drug_class,home_leave_yn_val,patient_id,encounter_id);//added home_leave_yn_val,patient_id,encounter_id  for Bru-HIMS-CRF-093[29960]
			if(disp_locn!=null && !disp_locn.equals("")){
				disp_locn_code = disp_locn.substring(0,disp_locn.indexOf("|"));
				disp_locn_desc = disp_locn.substring(disp_locn.indexOf("|")+1,disp_locn.lastIndexOf("|"));
				performing_facility_id = disp_locn.substring(disp_locn.lastIndexOf("|")+1);
			}
			String ext_drug_code	= "", ext_srl_no="";
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap Drug_Details =null;
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
					Drug_Details=(HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) Drug_Details.get("DRUG_CODE");
					ext_srl_no=(String) Drug_Details.get("SRL_NO");
					if( drug_code.equals(ext_drug_code) && (String.valueOf(srlNo)).equals(ext_srl_no) ){
						Drug_Details.put("DISP_LOCN_CODE", disp_locn_code);
						Drug_Details.put("DISP_LOCN_DESC",disp_locn_desc);
						Drug_Details.put("PERFORMING_FACILITY_ID",performing_facility_id);
						break;
					}
				}
			}
			out.println("assignDispLocn('"+disp_locn_code+"','"+disp_locn_desc+"');");
		}
		else if(func_mode != null && func_mode.equals("dates_populate")){
			ArrayList al  = new ArrayList();
			String dur_val=(String)hash.get("dur_val");
			String durn_desc=(String)hash.get("durn_desc");
			String qry_dur_desc = null; //Added for IN047995 -start
			if(durn_desc.equalsIgnoreCase("M"))
				qry_dur_desc="L";
			else
				qry_dur_desc = durn_desc;//Added for IN047995 -end
			String start_date=(String)hash.get("start_date");
			String end_date=(String)hash.get("end_date");
			al.add(dur_val);
			al.add(durn_desc);
			al.add(start_date);
			String changedDate = (String)bean.populateEndDate("",start_date,dur_val,qry_dur_desc.toUpperCase());//Added for IN047995
			//com.ehis.util.DateUtils.plusDate(start_date, "DMYHM",locale,Integer.parseInt(dur_val),durn_desc);//Commented for IN047995
			al.add(changedDate);
			bean.setSelecteddrugs(al);
			out.println("returnChangedDate('"+changedDate+"')");
		}
		else if(func_mode != null && func_mode.equals("empty_values")){
			bean.copyDiscPresClear();
			//bean.copyPresClear();
		}
			
		else if(func_mode != null && func_mode.equals("copy_disc_orders")){
			ArrayList discorders =  bean.getdiscPrescriptions();
			if(((String)hash.get("chk_status")).equals("Y")) { 
				if(!discorders.contains((String)hash.get( "order_id") +","+ (String)hash.get( "order_line"))){
					discorders.add((String)hash.get( "order_id") +","+(String)hash.get( "order_line"));
					discorders.add((String)hash.get( "drug_code") );
				}
			} 
			else {
				if(discorders.contains((String)hash.get( "order_id") +","+ (String)hash.get( "order_line"))){
					discorders.remove(((String)hash.get( "order_id") +","+ (String)hash.get( "order_line")));
					discorders.remove((String)hash.get( "drug_code") );
				}
			}
		}
		else if(func_mode != null && func_mode.equals("copy_selected_drugs")){
			ArrayList orders     = bean.getPrescriptions();
			ArrayList discorders =bean.getdiscPrescriptions();
			for(int i=0;i<orders.size();i++){
				discorders.add(orders.get(i));
			}
		}
		/*else if(func_mode != null && func_mode.equals("copy_selected_drugs_refresh")){//Commented for IN048127
			ArrayList orders     = bean.getPrescriptions();
			ArrayList discorders =bean.getdiscPrescriptions();
			discorders.clear();
			for(int i=0;i<orders.size();i++){
				discorders.add(orders.get(i));
			}
		}*/
		else if(func_mode != null && func_mode.equals("setDefaultDuration")){
			ArrayList defaultDuration  = bean.getDefaultDuration();
			defaultDuration = new ArrayList();
			String dur_val=(String)hash.get("durn_value");
			String durn_desc=(String)hash.get("durn_desc");
			defaultDuration.add(dur_val);
			defaultDuration.add(durn_desc);
			bean.setDefaultDuration(defaultDuration);
		}
		else if(func_mode != null && func_mode.equals("dur_populate")){
			ArrayList al  = new ArrayList();
			String dur_val=(String)hash.get("dur_val");
			String durn_desc=(String)hash.get("durn_desc");
			String start_date=(String)hash.get("start_date");
			String end_date=(String)hash.get("end_date");
			al.add(dur_val);
			al.add(durn_desc);
			al.add(start_date);
			al.add(end_date);
			bean.setSelecteddrugs(al);
		}
		else if(func_mode != null && func_mode.equals("setDuration")){
			ArrayList al  = new ArrayList();
			String durn_value=(String)hash.get("durn_value");
			String durn_desc=(String)hash.get("durn_desc");
			String hdr_durn_value=(String)hash.get("hdr_durn_value");
			String hdr_durn_desc=(String)hash.get("hdr_durn_desc");
			ArrayList calc_dur = bean.caluculateDuaration(durn_value,durn_desc,hdr_durn_value,hdr_durn_desc);
			String decimalStringFormat = "#.#";
			DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);	
			String newdur = dfToInteger.format(Double.parseDouble((String)calc_dur.get(0)));
			String newdurdesc = (String)calc_dur.get(1);
			out.println("returnheaderdur('"+newdur+"','"+newdurdesc+"')");
		}//Added for BRU-HIMS-CRF-403 --end
		else if(func_mode.equals("setDate")){
			String order_date = (String)hash.get("order_date");
			bean.setOrderDate(order_date);
		}
		else if(func_mode!= null && func_mode.equals("loadFreqsForPriority")){
			String priority		= (String) hash.get("priority")==null?"":(String) hash.get("priority");
			String patient_class		= (String) hash.get("patient_class")==null?"":(String) hash.get("patient_class");
			String act_patient_class		= (String) hash.get("act_patient_class")==null?"":(String) hash.get("act_patient_class");
			String calling_mode		= (String) hash.get("calling_mode")==null?"":(String) hash.get("calling_mode");
			String drug_code		= (String) hash.get("drug_code")==null?"":(String) hash.get("drug_code");
			String freq_code		= (String) hash.get("freq_code")==null?"":(String) hash.get("freq_code");
			String dup_found		= (String) hash.get("dup_found")==null?"":(String) hash.get("dup_found");
			String in_formulary_yn		= (String) hash.get("in_formulary_yn")==null?"":(String) hash.get("in_formulary_yn");
			String take_home_medication		= (String) hash.get("take_home_medication")==null?"":(String) hash.get("take_home_medication");
			String drug_class		= (String) hash.get("drug_class")==null?"":(String) hash.get("drug_class");
			String order_type_code		= (String) hash.get("order_type_code")==null?"":(String) hash.get("order_type_code");
			String srlNo		= (String) hash.get("srlNo")==null?"":(String) hash.get("srlNo");
			String def_freq_YN		= (String) hash.get("def_freq_YN")==null?"":(String) hash.get("def_freq_YN");
			String callFrom		= (String) hash.get("callFrom")==null?"":(String) hash.get("callFrom");// added for MO-GN-5490 [IN:054620] - [IN:055921] -start
			String callFreqChange = "Y";
			if(callFrom.equals("DATECHANGE"))
				callFreqChange ="N"; // added for MO-GN-5490 [IN:054620] - [IN:055921] -end
			String locn_code	= (String)hash.get( "source_code" );
			String locn_type	= "";
			String disp_locn="";
			String disp_locn_code="";
			String disp_locn_desc="";
			String performing_facility_id="";
			String home_leave_yn_val=(String)hash.get( "home_leave_yn_val" );//added  for Bru-HIMS-CRF-093[29960]-start 
			String patient_id=(String)hash.get( "patient_id" );
			String encounter_id=(String)hash.get( "encounter_id" );//added  for Bru-HIMS-CRF-093[29960]-end
			String freq_codeTmp="";
			int freq_count=0;
			boolean statFeqFound = false, priority_appl_for_freq=true;
			if( bean.getExternalpatient_id()==null ||  ((String)bean.getExternalpatient_id()).equals("") )
				locn_type	= (String)hash.get( "source_type" );	
			else
				locn_type	= "P";	
			String freqCode = "";
			String freqDesc = "";
			HashMap freqValues = (HashMap)bean.populateFrequencyValues(drug_code,freq_code,calling_mode,patient_class);
			ArrayList	freqCodes	= (ArrayList) freqValues.get("FreqCode");
			ArrayList   freqDescs	= (ArrayList) freqValues.get("FreqDesc");
			ArrayList   FreqNature	= (ArrayList) freqValues.get("FreqNature");
			if(freqCodes!=null && freqCodes.size()>0){
				//if(priority.equals("U") || dup_found.equals("true")){ //Commented for ML-BRU-SCF-1046 [IN:043889]
				if( dup_found.equals("true")){
					out.println("clearFrequencyList()");
					for(int i=0;i<freqCodes.size();i++){
						if(((String) FreqNature.get(i)).equals("O")) {// (bean.getFreqNature(((String) freqCodes.get(i))))
							freqCode=(String) freqCodes.get(i);
							freqDesc=(String) freqDescs.get(i);
							freqDesc=freqDesc.replaceAll(" ","%20");
							freqDesc = java.net.URLEncoder.encode(freqDesc,"UTF-8");
							freqDesc=freqDesc.replaceAll("%2520","%20");
							out.println("addFrequencyList('"+freqCode+"','"+freqDesc+"','"+freq_code.trim()+"')");
							freq_count++;
						}
					}
					if(freq_count == 0){ //added for ML-BRU-SCF-1046 [IN:043889]
						out.println("addFrequencyList('','-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Select.label", "ph_labels")+"--------')");
						out.println("alertNoApplicaFreq('"+priority+"')");
						priority_appl_for_freq=false;
					}
				}
				else{ //if(priority.equals("R")){ //Commented for ML-BRU-SCF-1046 [IN:043889]
					if(callFrom.equals("DATECHANGE")){ // if block added for MO-GN-5490 [IN:054620] - [IN:055921]
						out.println("clearFrequencyList()");
						for(int i=0;i<freqCodes.size();i++){
							freqCode=(String) freqCodes.get(i);
							freqDesc=(String) freqDescs.get(i);
							freqDesc=freqDesc.replaceAll(" ","%20");
							freqDesc = java.net.URLEncoder.encode(freqDesc,"UTF-8");
							freqDesc=freqDesc.replaceAll("%2520","%20");
							out.println("addFrequencyList('"+freqCode+"','"+freqDesc+"','"+freq_code.trim()+"')");
							freq_count++;
						}
						if(freq_count == 0){
							out.println("addFrequencyList('','-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Select.label", "ph_labels")+"--------')");
							priority_appl_for_freq=false;
						}
					}

					if(priority.equals("U")){
						ArrayList stat_freqs	=	presBean.loadStatFreqs();
						if(stat_freqs.size()>0){
							for(int i=0;i<stat_freqs.size();i+=2){
								freq_codeTmp=(String) stat_freqs.get(i);
								for(int j=0;j<freqCodes.size();j++){
									freqCode=(String) freqCodes.get(j);
									if(freq_codeTmp.equals(freqCode) ){
										out.println("dfltFreq('"+freqCode+"','"+callFreqChange+"')"); // 'Y' -> callFreqChange for MO-GN-5490 [IN:054620] - [IN:055921]
										statFeqFound = true;
										break;
									}
								}
							}
						}
						if(!statFeqFound){ //Added for ML-BRU-SCF-1046 [IN:043889]
							out.println("alertNoApplicaFreq('"+priority+"')");
							out.println("dfltFreq('"+freq_code.trim()+"','"+callFreqChange+"')"); // 'Y' -> callFreqChange for MO-GN-5490 [IN:054620] - [IN:055921]
							priority_appl_for_freq = false;
						}
					}
					else{
						if(bean.getFreqNature(freq_code).equals("O")){//((String) FreqNature.get(i))
							for(int i=0;i<freqCodes.size();i++){
								freqCode=(String) freqCodes.get(i);
								if(!((String) FreqNature.get(i)).equals("O")){//bean.getFreqNature(freqCode)
									freq_code = freqCode;
									freq_count++;
									break;
								}
							}
						}
						else
							freq_count++;
						if(freq_count == 0){ //if block and else condition added for ML-BRU-SCF-1046 [IN:043889]
							out.println("alertNoApplicaFreq('"+priority+"')");
							priority_appl_for_freq = false;
						}
						else
							out.println("dfltFreq('"+freq_code.trim()+"','"+callFreqChange+"')"); // 'Y' -> callFreqChange for MO-GN-5490 [IN:054620] - [IN:055921]
					}
				}
			}
			else{
				out.println("addFrequencyList('','-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Select.label", "ph_labels")+"--------','"+freq_code.trim()+"')");
				out.println("alertNoApplicaFreq('"+priority+"')");
				priority_appl_for_freq = false;
			}
			if(!priority_appl_for_freq){
				if(priority.equals("U"))
					priority = "R";
				else
					priority="U";
			}
			else{
				out.println("getOrderCatalogAuthRule()");
			}
			disp_locn			= bean.getDispLocn(in_formulary_yn, act_patient_class, priority, drug_code, locn_type, locn_code, take_home_medication, order_type_code,drug_class,home_leave_yn_val,patient_id,encounter_id);//added home_leave_yn_val,patient_id,encounter_id  for Bru-HIMS-CRF-093[29960]
			if(disp_locn!=null && !disp_locn.equals("")){
				disp_locn_code = disp_locn.substring(0,disp_locn.indexOf("|"));
				disp_locn_desc = disp_locn.substring(disp_locn.indexOf("|")+1,disp_locn.lastIndexOf("|"));
				performing_facility_id = disp_locn.substring(disp_locn.lastIndexOf("|")+1);
			}
			String ext_drug_code	= "", ext_srl_no="";
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap Drug_Details =null;
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
					Drug_Details=(HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) Drug_Details.get("DRUG_CODE");
					ext_srl_no=(String) Drug_Details.get("SRL_NO");
					if( drug_code.equals(ext_drug_code) && (String.valueOf(srlNo)).equals(ext_srl_no) ){
						Drug_Details.put("DISP_LOCN_CODE", disp_locn_code);
						Drug_Details.put("DISP_LOCN_DESC",disp_locn_desc);
						Drug_Details.put("PERFORMING_FACILITY_ID",performing_facility_id);
						break;
					}
				}
			}
			out.println("assignDispLocn('"+disp_locn_code+"','"+disp_locn_desc+"');");
		}			
		else if(func_mode != null && func_mode.equals("setHomeMedDuration")){//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start
			String durn=(String)hash.get("durn");
			String drug_code=(String)hash.get("drug_code");
			String patient_class = (String)hash.get("pat_class");
			String sliding_scale_yn = (String)hash.get("sliding_scale_yn");
			String ext_drug_code	= "";
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap durnValues=  (HashMap)presBean.validateDuration(drug_code,patient_class);
			if(durnValues.size()>0){
				String max_durn_value = (String)durnValues.get("max_durn_value")==null?"":(String)durnValues.get("max_durn_value");
				String chk_for_max_durn_action = (String)durnValues.get("chk_for_max_durn_action")==null?"":(String)durnValues.get("chk_for_max_durn_action");
				String prompt_msg = (String)durnValues.get("prompt_msg")==null?"":(String)durnValues.get("prompt_msg");
				String max_durn_type = (String)durnValues.get("max_durn_type")==null?"":(String)durnValues.get("max_durn_type");
				out.println("assignDurnvalue('"+""+"','"+max_durn_value+"','"+chk_for_max_durn_action+"','"+java.net.URLEncoder.encode(prompt_msg,"UTF-8")+"','"+max_durn_type+"','"+sliding_scale_yn+"')");
			}
			HashMap Drug_Details =null;
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
					Drug_Details=(HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) Drug_Details.get("DRUG_CODE");
					if( drug_code.equals(ext_drug_code)){
						Drug_Details.put("DURN_VALUE", durn);
						Drug_Details.put("freq_chng_durn_value",durn);
						break;
					}
				}
			}
		}//Added for Bru-HIMS-CRF-093-DD1[IN047223]--end
		else if(func_mode != null && func_mode.equals("checkDiagnosis")){//Added for HSA-CRF-0152 [IN:048469] --start
			String patient_id=(String)hash.get("patient_id");
			String encounter_id=(String)hash.get("encounter_id");
			String diag_for_medn_order_by=(String)hash.get("diag_for_medn_order_by");
			String params=(String)hash.get("params");
			ArrayList diagnosis	=	bean.checkDiagnosis(patient_id, encounter_id, diag_for_medn_order_by);
			int diag_size	=	(diagnosis).size();
			if(diag_size>0){
				out.println("callLoadOtherFrames('"+diag_size+"', '"+params+"');");
			}
		}//Added for HSA-CRF-0152 [IN:048469] --end
		else if(func_mode != null && func_mode.equals("calcHomeMedDurationAmend")){
			String take_home_start=(String)hash.get("take_home_start");
			String currstart_date=(String)hash.get("currstart_date");
			String take_home_end = (String)hash.get("take_home_end");
			String currend_date = (String)hash.get("currend_date");
			boolean flag=  DateUtils.isBetween(take_home_start,take_home_end,currstart_date,"DMYHM","en");
			boolean flag1 = DateUtils.isBetween(take_home_start,take_home_end,currend_date,"DMYHM","en");
			if(!flag || !flag1){
				out.println("alert(getMessage('PH_HOME_LEAVE_NOT_FALL_IN_DATE','PH'));");
				return;
			}
		}
		else if(func_mode != null && func_mode.equals("setHomeleavecheck")){
			String checked_yn=(String)hash.get("checked_yn");
			bean.setHome_leave_checked(checked_yn);
		}//Added for Bru-HIMS-CRF-093-DD1[IN047223]--end
		else if(func_mode != null && func_mode.equals("UPDATE_CURR_RX")){
			String generic_id_vals	= (String) hash.get("generic_id_vals")==null?"":(String) hash.get("generic_id_vals");
			String tmp_generic_id	= "", curr_rx="", generic_id="";
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			StringTokenizer st = new StringTokenizer((String)generic_id_vals,"~");
			HashMap Drug_Details =null;
			if(prescriptionDetails!=null){
				while(st.hasMoreTokens()){
					generic_id=st.nextToken();
					for(int j=0;j<prescriptionDetails.size();j++){
						Drug_Details=(HashMap) prescriptionDetails.get(j);
						tmp_generic_id= Drug_Details.get("GENERIC_ID")==null?"":(String) Drug_Details.get("GENERIC_ID");
						curr_rx= Drug_Details.get("CURRENT_RX")==null?"":(String) Drug_Details.get("CURRENT_RX");
						if( generic_id.equals(tmp_generic_id) && curr_rx.equals("Y") ){
							Drug_Details.put("CURRENT_RX", "N");
							break;
						}
					}
				}
			}
		}
	   	else if(func_mode != null && func_mode.equals("Get_PrintOrderInd")){	//Code added for HSA-SCF-0036[IN050011] --end	
			String print_ord_sht_rule_ind=bean.getPrintOrdShtRuleInd();
			out.println(print_ord_sht_rule_ind);
		}//Code Added for HSA-SCF-0036[IN050011] --end	
		else if(func_mode != null && func_mode.equals("getOrderCatalogAuthRule")){//Added for HSA-CRF-0150 [IN:048467]
			String priority		= (String) hash.get("priority")==null?"":(String) hash.get("priority");
			String act_patient_class		= (String) hash.get("act_patient_class")==null?"":(String) hash.get("act_patient_class");
			String resp_id		= (String) hash.get("resp_id")==null?"":(String) hash.get("resp_id");
			String pract_id		= (String) hash.get("pract_id")==null?"":(String) hash.get("pract_id");
			String drug_code		= (String) hash.get("drug_code")==null?"":(String) hash.get("drug_code");
			String take_home_medication		= (String) hash.get("take_home_medication")==null?"":(String) hash.get("take_home_medication");
			String srlNo		= (String) hash.get("srlNo")==null?"":(String) hash.get("srlNo");
			String patient_id=(String)hash.get( "patient_id" );
			String ext_drug_code	= "", ext_srl_no="";
			String ord_auth_reqd_yn="",  ord_authorized_yn=""; 
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap Drug_Details =null;
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
					Drug_Details=(HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) Drug_Details.get("DRUG_CODE");
					ext_srl_no=(String) Drug_Details.get("SRL_NO");
					if( drug_code.equals(ext_drug_code) && (String.valueOf(srlNo)).equals(ext_srl_no) ){
						if(act_patient_class.toUpperCase().equals("IP") && (take_home_medication.toUpperCase().equals("Y") || take_home_medication.toUpperCase().equals("D"))){
							 act_patient_class = "OP";
						}
						bean.getOrderCatalogAuthRule(Drug_Details, act_patient_class, resp_id, pract_id, patient_id, priority); //added for HSA-CRF-0150 [IN:048467] -start
						ord_auth_reqd_yn = (String)Drug_Details.get("ORD_AUTH_REQD_YN");
						ord_authorized_yn = (String)Drug_Details.get("ORD_AUTHORIZED_YN");
						Drug_Details.put("ORD_AUTH_REQD_YN", ord_auth_reqd_yn);
						Drug_Details.put("ORD_AUTHORIZED_YN",ord_authorized_yn);
						out.println("UpdateOrderCatalogAuthRule('"+ord_auth_reqd_yn+"','"+ord_authorized_yn+"');");//added for HSA-CRF-0150 [IN:048467] -End
						break;
					}
				}
			}
		}
		else if(func_mode!= null && func_mode.equals("checkDuplicateDrug")){//Added for ML-BRU-SCF-1423 [IN:050857] -start
			String start_date			= (String) hash.get( "start_date" );
			String durn_value			= (String) hash.get( "durn_value" );
			String end_date			= (String) hash.get( "end_date" );
			String drugCode	= (String)hash.get( "drug_code");
			String srlNo	= (String)hash.get( "srlNo");
			String ext_prod_id ="", ext_drug_code="", ext_srl_no="";
			String drug_db_interface_yn = (String)hash.get("drug_db_interface_yn")==null?"":(String)hash.get("drug_db_interface_yn");
			String drug_db_duptherapy_yn = (String)hash.get("drug_db_duptherapy_yn")==null?"":(String)hash.get("drug_db_duptherapy_yn");
			String allow_duplicate = (String)hash.get("allow_duplicate")==null?"":(String)hash.get("allow_duplicate"); //added for MO-GN-5490 [IN:054620]
			String freq_code = (String)hash.get("freq_code")==null?"":(String)hash.get("freq_code"); //added for MO-GN-5490 [IN:054620]
			String calledFrom = (String)hash.get("calledFrom")==null?"":(String)hash.get("calledFrom"); //added for MO-GN-5490 [IN:054620]
			String patient_id = (String)hash.get("patient_id");
			boolean dupCheck = false;
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap Drug_Details =null;
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
					Drug_Details=(HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) Drug_Details.get("DRUG_CODE");
					ext_srl_no=(String) Drug_Details.get("SRL_NO");
					if( drugCode.equals(ext_drug_code) && (String.valueOf(srlNo)).equals(ext_srl_no) ){
						Drug_Details.put("END_DATE", end_date); 
						Drug_Details.put("DURN_VALUE", durn_value); 
						Drug_Details.put("DATECHANGED","Y");
						if(freq_code==null || freq_code.equals("")) //added forMO-GN-5490 [IN:054620]
							freq_code = (String) Drug_Details.get("FREQ_CODE");
						ext_prod_id=  (String) Drug_Details.get("EXTERNAL_PRODUCT_ID")==null?"":(String) Drug_Details.get("EXTERNAL_PRODUCT_ID");
						if(!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("") || drug_db_duptherapy_yn.equals("N")){
							dupCheck =presBean.checkDuplicateDrug(patient_id, (String) Drug_Details.get("GENERIC_ID"), DateUtils.convertDate(start_date, "DMYHM",locale,"en"),DateUtils.convertDate(end_date, "DMYHM",locale,"en"),freq_code, (String) Drug_Details.get("TRN_GROUP_REF"));//modified for SKR-SCF-1343
							if(!dupCheck && Drug_Details.get("ALERT_YN")==null){
								Drug_Details.put("CURRENT_RX","N");
								Drug_Details.put("CURRENTRX_REMARKS","");  
								Drug_Details.put("CURRENTRX_REMARKS_CODE",""); //Added for IN:073485
								Drug_Details.put("CURRENTRX_OVERRIDE","N");
								out.println("showDuplicateInd('"+srlNo+"','N','"+(String)Drug_Details.get("SLIDING_SCALE_YN")+"','"+drugCode+"','"+calledFrom+"','"+allow_duplicate+"');"); // allow_duplicate added for MO-GN-5490 [IN:054620]
							}
							else if(dupCheck){
								Drug_Details.put("CURRENT_RX","Y");
								Drug_Details.put("ORIG_CURRENT_RX","Y");
								if(presBean.checkForNull((String)Drug_Details.get("CURRENTRX_REMARKS")).equals(""))
									Drug_Details.put("CURRENTRX_OVERRIDE","N");
								out.println("showDuplicateInd('"+srlNo+"','R','"+ (String)Drug_Details.get("SLIDING_SCALE_YN")+"','"+drugCode+"','"+calledFrom+"','"+allow_duplicate+"');"); // allow_duplicate added for MO-GN-5490 [IN:054620]
							}
						}
						break;
					}
				}
			}
		}//Added for ML-BRU-SCF-1423 [IN:050857] -End
		else if(func_mode!= null && func_mode.equals("RecExternal")){ // added for MMS-KH-CRF-0016 - Start
			    ArrayList extdrugslist =  bean.getExternal_drugs(); 
		     	        ArrayList extdrugslist_tmp = bean.getExternal_drugs_tmp(); // Added for Inc#70652 - Start
				if(extdrugslist_tmp!=null){
					for(int i=0;i<extdrugslist_tmp.size();i=i+2){//modified for IN070786
						if(!extdrugslist.contains(extdrugslist_tmp.get(i)))
							extdrugslist.add(extdrugslist_tmp.get(i));
						extdrugslist.add(extdrugslist_tmp.get(i+1));//added for IN070786
					}
					//extdrugslist.addAll(extdrugslist_tmp);
				} // Added for Inc#70652 - End
				bean.setExternal_drugs(extdrugslist); // Added for Inc#70652
				String  extdrugs    = "";
				for(int i=0;i<extdrugslist_tmp.size();i=i+2){ // extdrugslist changed to extdrugslist_tmp for Inc#70652 modified for IN070786
					extdrugs = extdrugs+extdrugslist_tmp.get(i)+","; // extdrugslist changed to extdrugslist_tmp for Inc#70652
				}
				String order_ids = "";
			
				out.println("returnDrugs(\"" + extdrugs + "\",\""+order_ids+"\",\""+func_mode+"\");") ;
				
			
		} // added for MMS-KH-CRF-0016 - End
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(presBean_id,presBean,request);
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
