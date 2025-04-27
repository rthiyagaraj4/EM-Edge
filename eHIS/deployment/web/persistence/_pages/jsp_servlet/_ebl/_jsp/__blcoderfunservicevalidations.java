package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.util.*;
import java.util.*;
import java.sql.*;
import java.lang.*;
import java.net.*;
import java.text.*;
import eCommon.Common.*;
import org.json.simple.*;
import java.util.Map.Entry;
import java.util.Set;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eBL.*;
import eBL.resources.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.text.SimpleDateFormat;
import eCA.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blcoderfunservicevalidations extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLCoderFunServiceValidations.jsp", 1709114095443L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!--eCA.* Added by Kamatchi S for TH-KW-CRF-0143-->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
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
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
17/06/2020 	  		       Ram kumar S											AAKH-CRF-0122
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
/*
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
 1			 V211020											    Mohanapriya K
 2                                         TH-KW-CRF-0143            Kamatchi S
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);

	Connection con = null;
	/*Connection conDateTime = null;
	Connection conServCode = null;
	Connection conServQty = null;
	Connection conGenBill = null;
	Connection conCheckBill = null;
	Connection conTotalCnt = null;
	Connection conVisitAdmDate = null;
	Connection conOrderClinician = null;
	Connection conBillCnt = null;
	Connection conUpBillCnt = null;
	Connection conMsg = null;
	Connection conDesc = null;
	Connection conCpt = null;
	Connection conBillPrint = null;*/
	PreparedStatement pstmtService = null ;
	ResultSet rsService = null;
	PreparedStatement pstmtOrderClinician = null ;
	ResultSet rsOrderClinician = null;
	PreparedStatement pstmtMsg = null ;
	PreparedStatement pstmtDesc = null ;
	PreparedStatement pstmtCpt = null ;
	PreparedStatement pstmtCheckBill = null ;
	ResultSet rsMsg = null;
	ResultSet rsDesc = null;
	ResultSet rsCpt = null;
	ResultSet rsCheckBill = null;
	HashMap updateBLCoderPatSearchValues= new HashMap();
	BLCoderPatService  patUpdateServ;
	BLCoderPatServiceBean blCoderPatService = new BLCoderPatServiceBean();
	try{ //V211020
	 String CalledFor = request.getParameter("CalledFor");
	 String SessionSaveId = request.getParameter("SessionId");
	 con = ConnectionManager.getConnection(request); //V211020
	 if(CalledFor.equals("DateValidation")){
		String DateTime	 = request.getParameter("dateTime");
		String ServFacilityId = request.getParameter("FacilityId");
		String ServEncounterId = request.getParameter("EncounterId");
		System.err.println("DateTime  "+DateTime);
		System.err.println("ServEncounterId  "+ServEncounterId);
		System.err.println("ServFacilityId  "+ServFacilityId);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		java.util.Date servdateTime = sdf.parse(DateTime);
		System.err.println("output servdateTime  "+servdateTime);
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String outputString = outputFormat.format(servdateTime);
		System.err.println("output Date String  "+outputString);
		String Message_Text="";
		String sessioStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String localeLang			= (String)session.getAttribute("LOCALE");
		System.err.println("Locale Language ID  "+localeLang);
		try	{
				//con = ConnectionManager.getConnection(request); //V211020
				String Query_Vaidating_DateTime = "{ call bl_coders.validate_service_date('"+ServFacilityId+"','"+ServEncounterId+"',to_date('"+outputString+"','dd-mm-rrrr hh24:mi:ss') ,?) }";
				System.err.println("Query validating date Time  "+Query_Vaidating_DateTime);
				CallableStatement callDateTime = con.prepareCall(Query_Vaidating_DateTime);			
				callDateTime.registerOutParameter(1,java.sql.Types.VARCHAR);
				callDateTime.execute();
				Message_Text = callDateTime.getString(1) == null ? "" : callDateTime.getString(1);
				System.err.println("Response Message_Text  "+Message_Text);
				out.println("~"+Message_Text);				
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("~Exception Occured in calling DateTime validation Procedure  "+e);
		}
	}
	else if(CalledFor.equals("SaveData")){
		try{
		SimpleDateFormat serviceSdfIP = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat serviceSdfOP = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Random rand = new Random(); 
		System.err.println("Inside called for SaveData");
		String[] SaveData=request.getParameterValues("serviceJSON");
		String [] NewSaveData=Arrays.toString(SaveData).split(",");
		String siteSpecPatPayable=request.getParameter("siteSpecPatPayable");//V230222
		String siteSpecSearch=request.getParameter("siteSpecSearch");//V230529
		String indexVal="";
		String AddRowYN="";
		System.err.println("NewSaveData Length "+NewSaveData.length);
		System.err.println("SaveData  "+SaveData);
		for (int n = 0; n < NewSaveData.length; n++) {
			patUpdateServ = new BLCoderPatService();
			if(n==0){
				NewSaveData[n]=NewSaveData[n].replace("[","").replace("]","");
			}
			if(n==NewSaveData.length-1){
				NewSaveData[n]=NewSaveData[n].replace("[","").replace("]","");
			}
			String str[] = NewSaveData[n].split("~");
				List<String> al = new ArrayList<String>();
				al = Arrays.asList(str);
				System.err.println("ArrayList Size "+al.size());
				//Service Date Time
				String ServiceDateTime = al.get(0);
				System.err.println("ServiceDateTime  "+ServiceDateTime);
				if(!ServiceDateTime.equals("")){
					java.util.Date servdateTime1 = serviceSdfIP.parse(ServiceDateTime);
					ServiceDateTime = serviceSdfOP.format(servdateTime1);
					System.err.println("output Service Date String  "+ServiceDateTime);
				}
				patUpdateServ.setServiceDate(ServiceDateTime);	
				//Service Type Indicator
				String ServiceTypeInd = al.get(1);
				System.err.println("ServiceTypeInd  "+ServiceTypeInd);
				patUpdateServ.setServTypeInd(ServiceTypeInd);
				//Service Type Desc
				String ServiceTypeDesc = al.get(2);
				System.err.println("ServiceTypeDesc  "+ServiceTypeDesc);
				patUpdateServ.setServTypeDesc(ServiceTypeDesc);
				//Service Code
				String ServiceCode = al.get(3);
				System.err.println("ServiceCode  "+ServiceCode);
				patUpdateServ.setServItemCode(ServiceCode);
				//Service Description
				String Servicedesc = al.get(4);
				System.err.println("Servicedesc  "+Servicedesc);
				patUpdateServ.setServItemDesc(Servicedesc);
				//Ordering Clinician
				String OrderClinic = al.get(5);
				System.err.println("OrderClinic  "+OrderClinic);
				patUpdateServ.setPhysicianId(OrderClinic);
				//Performing Clinician
				String PerformClinic = al.get(6);
				System.err.println("PerformClinic  "+PerformClinic);
				patUpdateServ.setPerformPhysicianId(PerformClinic);
				//Quantity
				String ServQuantity = al.get(7);
				System.err.println("ServQuantity  "+ServQuantity);
				patUpdateServ.setServQty(ServQuantity);
				//Mod_Adjuster
				String ModAdjust = al.get(8);
				System.err.println("ModAdjust  "+ModAdjust);
				patUpdateServ.setModifierAdjusterId(ModAdjust);
				//ZeroPrice
				String ZeroPrice = al.get(9);
				System.err.println("ZeroPrice  "+ZeroPrice);
				patUpdateServ.setZeroPriceYN(ZeroPrice);
				//Approval Number
				String AppNo = al.get(10);
				System.err.println("AppNo  "+AppNo);
				patUpdateServ.setCDRApprovalNo(AppNo);
				//Approval Date
				String AppDate = al.get(11);
				System.err.println("AppDate  "+AppDate);
				if(!AppDate.equals("")){
					java.util.Date servdateTime2 = serviceSdfIP.parse(AppDate);
					AppDate = serviceSdfOP.format(servdateTime2);
					System.err.println("output AppDate String  "+AppDate);
				}
				if(AppNo.equals("")){
					patUpdateServ.setCDRApprovalDate("");
				}else{
					patUpdateServ.setCDRApprovalDate(AppDate);
				}
				//Service Price
				String Service_Price = al.get(12);
				System.err.println("Service_Price  "+Service_Price);
				//Service_Price = Service_Price.substring( 0, Service_Price.indexOf("."));
				patUpdateServ.setServiceAmount(Service_Price);
				//Insurance Price
				String Ins_Price = al.get(13);
				System.err.println("Ins_Price  "+Ins_Price);
				patUpdateServ.setInsuranceAmount(Ins_Price);
				//Billable YN
				//V230222-AAKH-CRF-0172
				if(siteSpecPatPayable.equals("true")){
					String pat_pay = al.get(14);
					System.err.println("pat_pay  "+pat_pay);
					patUpdateServ.setPatientPayable(pat_pay);
					//Billable YN
					String BillableYN = al.get(15);
					System.err.println("BillableYN  "+BillableYN);
					patUpdateServ.setBillableYN(BillableYN);
					//AddRowYN
					AddRowYN = al.get(16);
					System.err.println("AddRowYN  "+AddRowYN);
					patUpdateServ.setAddRowYN(AddRowYN);
					//CancelRowYN
					String CancelRowYN = al.get(17);
					System.err.println("CancelRowYN  "+CancelRowYN);
					patUpdateServ.setCancelRowYN(CancelRowYN);
					System.err.println("Get CancelRowYN  "+patUpdateServ.getCancelRowYN());
					//BillDocTypeCode
					String BillDocTypeCode = al.get(18);
					System.err.println("BillDocTypeCode  "+BillDocTypeCode);
					patUpdateServ.setBillDocTypeCode(BillDocTypeCode);
					//BillDocNo
					String BillDocNo = al.get(19);
					System.err.println("BillDocNo  "+BillDocNo);
					patUpdateServ.setBillDocNum(BillDocNo);
					//CustGrpCode
					String CustGrpCode = al.get(20);
					System.err.println("CustGrpCode  "+CustGrpCode);
					patUpdateServ.setCustGroupCode(CustGrpCode);
					//CustCode
					String CustCode = al.get(21);
					System.err.println("CustCode  "+CustCode);
					patUpdateServ.setCustCode(CustCode);
					//TrxDocRef
					String TrxDocRef = al.get(22);
					System.err.println("TrxDocRef  "+TrxDocRef);
					patUpdateServ.setTrxDocRef(TrxDocRef);
					//TrxDocRefLineNo
					String TrxDocRefLineNo = al.get(23);
					System.err.println("TrxDocRefLineNo  "+TrxDocRefLineNo);
					patUpdateServ.setTrxDocRefLineNum(TrxDocRefLineNo);
					//TrxDocRefSeqNo
					String TrxDocRefSeqNo = al.get(24);
					System.err.println("TrxDocRefSeqNo  "+TrxDocRefSeqNo);
					patUpdateServ.setTrxDocRefSeqNum(TrxDocRefSeqNo);		
					//TrxDate
					String TrxDate = al.get(25);
					System.err.println("TrxDate  "+TrxDate);
					if(!TrxDate.equals("")){
						TrxDate=TrxDate+" 00:00:00";
						java.util.Date servdateTime3 = serviceSdfIP.parse(TrxDate);
						TrxDate = serviceSdfOP.format(servdateTime3);
						System.err.println("output TrxDate String  "+TrxDate);
					}
					patUpdateServ.setTrxDate(TrxDate);
					//SettlementInd
					String SettlementInd = al.get(26);
					System.err.println("SettlementInd  "+SettlementInd);
					patUpdateServ.setSettlementInd(SettlementInd);
					//PatientAmt
					String PatientAmt = al.get(27);
					System.err.println("PatientAmt  "+PatientAmt);
					patUpdateServ.setPatientAmount(PatientAmt);
					
					System.err.println("al.get(27)  "+al.get(25));
					System.err.println("al.get(27)  "+al.get(26));
					System.err.println("al.get(27)  "+al.get(27));
					System.err.println("al.get(27)  "+al.get(28));
					//FacilityId
					String FacilityId = al.get(31);
					System.err.println("FacilityId  "+FacilityId);
					patUpdateServ.setOperatingFacilityId(FacilityId);
					//ServEncounterId
					String ServEncounterId = al.get(32);
					System.err.println("ServEncounterId  "+ServEncounterId);
					patUpdateServ.setEncounterId(ServEncounterId);
					//EpisodeId
					String EpisodeId = al.get(33);
					System.err.println("EpisodeId  "+EpisodeId);
					patUpdateServ.setEpisodeId(EpisodeId);
					//EpisodeType
					String EpisodeType = al.get(34);
					System.err.println("EpisodeType  "+EpisodeType);
					patUpdateServ.setEpisodeType(EpisodeType);
					//PatientID
					String PatientID = al.get(35);
					System.err.println("PatientID  "+PatientID);
					patUpdateServ.setPatientId(PatientID);
					//VisitID
					String VisitID = al.get(36);
					System.err.println("VisitID  "+VisitID);
					patUpdateServ.setPatientId(VisitID);
					//Session Id
					patUpdateServ.setSessionId(SessionSaveId);
					System.err.println("SessionSaveId  "+SessionSaveId);
					//Modified Flag
					String UpdateServFlag=al.get(37);
					System.err.println("Modified Flag  "+UpdateServFlag);
					patUpdateServ.setCdrApprovalNoModifyYN(UpdateServFlag);
					//WS No
					String logWSNo=al.get(38);
					System.err.println("logWSNo Flag  "+logWSNo);
					patUpdateServ.setlogInWSNo(logWSNo);
					//Login User
					String logIdUser=al.get(39);
					System.err.println("logIdUser Flag  "+logIdUser);
					patUpdateServ.setlogInID(logIdUser);
					//CPT Code
					String cptCode=al.get(40);
					System.err.println("cptCode Flag  "+cptCode);
					patUpdateServ.setcptCode(cptCode);
					//Modify Flag
					String modifyYN=al.get(41);
					System.err.println("modifyYN Flag  "+modifyYN);
					patUpdateServ.setModifyYN(modifyYN);
					//Update in HasMap
					indexVal=al.get(28);
				}else{
					String BillableYN = al.get(14);
					System.err.println("BillableYN  "+BillableYN);
					patUpdateServ.setBillableYN(BillableYN);
					//AddRowYN
					AddRowYN = al.get(15);
					System.err.println("AddRowYN  "+AddRowYN);
					patUpdateServ.setAddRowYN(AddRowYN);
					//CancelRowYN
					String CancelRowYN = al.get(16);
					System.err.println("CancelRowYN  "+CancelRowYN);
					patUpdateServ.setCancelRowYN(CancelRowYN);
					System.err.println("Get CancelRowYN  "+patUpdateServ.getCancelRowYN());
					//BillDocTypeCode
					String BillDocTypeCode = al.get(17);
					System.err.println("BillDocTypeCode  "+BillDocTypeCode);
					patUpdateServ.setBillDocTypeCode(BillDocTypeCode);
					//BillDocNo
					String BillDocNo = al.get(18);
					System.err.println("BillDocNo  "+BillDocNo);
					patUpdateServ.setBillDocNum(BillDocNo);
					//CustGrpCode
					String CustGrpCode = al.get(19);
					System.err.println("CustGrpCode  "+CustGrpCode);
					patUpdateServ.setCustGroupCode(CustGrpCode);
					//CustCode
					String CustCode = al.get(20);
					System.err.println("CustCode  "+CustCode);
					patUpdateServ.setCustCode(CustCode);
					//TrxDocRef
					String TrxDocRef = al.get(21);
					System.err.println("TrxDocRef  "+TrxDocRef);
					patUpdateServ.setTrxDocRef(TrxDocRef);
					//TrxDocRefLineNo
					String TrxDocRefLineNo = al.get(22);
					System.err.println("TrxDocRefLineNo  "+TrxDocRefLineNo);
					patUpdateServ.setTrxDocRefLineNum(TrxDocRefLineNo);
					//TrxDocRefSeqNo
					String TrxDocRefSeqNo = al.get(23);
					System.err.println("TrxDocRefSeqNo  "+TrxDocRefSeqNo);
					patUpdateServ.setTrxDocRefSeqNum(TrxDocRefSeqNo);		
					//TrxDate
					String TrxDate = al.get(24);
					System.err.println("TrxDate  "+TrxDate);
					if(!TrxDate.equals("")){
						TrxDate=TrxDate+" 00:00:00";
						java.util.Date servdateTime3 = serviceSdfIP.parse(TrxDate);
						TrxDate = serviceSdfOP.format(servdateTime3);
						System.err.println("output TrxDate String  "+TrxDate);
					}
					patUpdateServ.setTrxDate(TrxDate);
					//SettlementInd
					String SettlementInd = al.get(25);
					System.err.println("SettlementInd  "+SettlementInd);
					patUpdateServ.setSettlementInd(SettlementInd);
					//PatientAmt
					String PatientAmt = al.get(26);
					System.err.println("PatientAmt  "+PatientAmt);
					patUpdateServ.setPatientAmount(PatientAmt);
					
					System.err.println("al.get(27)  "+al.get(25));
					System.err.println("al.get(27)  "+al.get(26));
					System.err.println("al.get(27)  "+al.get(27));
					System.err.println("al.get(27)  "+al.get(28));
					//FacilityId
					if(siteSpecSearch.equals("true")){
						String FacilityId = al.get(30);
						System.err.println("FacilityId  "+FacilityId);
						patUpdateServ.setOperatingFacilityId(FacilityId);
						//ServEncounterId
						String ServEncounterId = al.get(31);
						System.err.println("ServEncounterId  "+ServEncounterId);
						patUpdateServ.setEncounterId(ServEncounterId);
						//EpisodeId
						String EpisodeId = al.get(32);
						System.err.println("EpisodeId  "+EpisodeId);
						patUpdateServ.setEpisodeId(EpisodeId);
						//EpisodeType
						String EpisodeType = al.get(33);
						System.err.println("EpisodeType  "+EpisodeType);
						patUpdateServ.setEpisodeType(EpisodeType);
						//PatientID
						String PatientID = al.get(34);
						System.err.println("PatientID  "+PatientID);
						patUpdateServ.setPatientId(PatientID);
						//VisitID
						String VisitID = al.get(35);
						System.err.println("VisitID  "+VisitID);
						patUpdateServ.setPatientId(VisitID);
						//Session Id
						patUpdateServ.setSessionId(SessionSaveId);
						System.err.println("SessionSaveId  "+SessionSaveId);
						//Modified Flag
						String UpdateServFlag=al.get(36);
						System.err.println("Modified Flag  "+UpdateServFlag);
						patUpdateServ.setCdrApprovalNoModifyYN(UpdateServFlag);
						//WS No
						String logWSNo=al.get(37);
						System.err.println("logWSNo Flag  "+logWSNo);
						patUpdateServ.setlogInWSNo(logWSNo);
						//Login User
						String logIdUser=al.get(38);
						System.err.println("logIdUser Flag  "+logIdUser);
						patUpdateServ.setlogInID(logIdUser);
						//CPT Code
						String cptCode=al.get(39);
						System.err.println("cptCode Flag  "+cptCode);
						patUpdateServ.setcptCode(cptCode);
						//Modify Flag
						String modifyYN=al.get(40);
						System.err.println("modifyYN Flag  "+modifyYN);
						patUpdateServ.setModifyYN(modifyYN);
						
					}else{
						String FacilityId = al.get(28);
						System.err.println("FacilityId  "+FacilityId);
						patUpdateServ.setOperatingFacilityId(FacilityId);
						//ServEncounterId
						String ServEncounterId = al.get(29);
						System.err.println("ServEncounterId  "+ServEncounterId);
						patUpdateServ.setEncounterId(ServEncounterId);
						//EpisodeId
						String EpisodeId = al.get(30);
						System.err.println("EpisodeId  "+EpisodeId);
						patUpdateServ.setEpisodeId(EpisodeId);
						//EpisodeType
						String EpisodeType = al.get(31);
						System.err.println("EpisodeType  "+EpisodeType);
						patUpdateServ.setEpisodeType(EpisodeType);
						//PatientID
						String PatientID = al.get(32);
						System.err.println("PatientID  "+PatientID);
						patUpdateServ.setPatientId(PatientID);
						//VisitID
						String VisitID = al.get(33);
						System.err.println("VisitID  "+VisitID);
						patUpdateServ.setPatientId(VisitID);
						//Session Id
						patUpdateServ.setSessionId(SessionSaveId);
						System.err.println("SessionSaveId  "+SessionSaveId);
						//Modified Flag
						String UpdateServFlag=al.get(34);
						System.err.println("Modified Flag  "+UpdateServFlag);
						patUpdateServ.setCdrApprovalNoModifyYN(UpdateServFlag);
						//WS No
						String logWSNo=al.get(35);
						System.err.println("logWSNo Flag  "+logWSNo);
						patUpdateServ.setlogInWSNo(logWSNo);
						//Login User
						String logIdUser=al.get(36);
						System.err.println("logIdUser Flag  "+logIdUser);
						patUpdateServ.setlogInID(logIdUser);
						//CPT Code
						String cptCode=al.get(37);
						System.err.println("cptCode Flag  "+cptCode);
						patUpdateServ.setcptCode(cptCode);
						//Modify Flag
						String modifyYN=al.get(38);
						System.err.println("modifyYN Flag  "+modifyYN);
						patUpdateServ.setModifyYN(modifyYN);
					}
					//Update in HasMap
					indexVal=al.get(27);
				}
				System.err.println("indexVal  "+indexVal);
				if(AddRowYN.equals("Y") && indexVal.equals("")){
					int rand_int1 = rand.nextInt(1000); 
					indexVal=Integer.toString(rand_int1);
					System.err.println("indexVal for Addrow "+indexVal);
				}
				updateBLCoderPatSearchValues.put(""+indexVal,patUpdateServ);
			
		}
		//Calling AddModify Service
		String retVal=blCoderPatService.addModifyService(updateBLCoderPatSearchValues);
				System.err.println("RetVal From Add Modify  "+retVal);
				out.println(retVal);
		}
	catch(Exception e){
		e.printStackTrace();
		System.err.println("Exception Occured in calling Save validation Procedure  "+e);
	}
	}
	else if(CalledFor.equals("ServiceCode")){
		try{		
			String ServFacilityId = request.getParameter("FacilityId");
			String serviceCode = request.getParameter("serviceCode");
			String LangId = request.getParameter("LangId");
			String loginUser = request.getParameter("loginUser");
			String Serv_Desc="";
			String Rate_Charge_Flag="";
			String Serv_Qty="";
			String Message_Text="";
			String OutPut_Text="";
			//con = ConnectionManager.getConnection(request); //V211020
				String Query_Populate_Services = "{ call bl_coders.validate_billing_service ('"+ServFacilityId+"','"+LangId+"','"+loginUser+"','"+serviceCode+"',?,?,?,?) }";
				System.err.println("Query populating service type and Desc  "+Query_Populate_Services);
				CallableStatement callServCode = con.prepareCall(Query_Populate_Services);		
				callServCode.registerOutParameter(1,java.sql.Types.VARCHAR);		
				callServCode.registerOutParameter(2,java.sql.Types.VARCHAR);		
				callServCode.registerOutParameter(3,java.sql.Types.VARCHAR);		
				callServCode.registerOutParameter(4,java.sql.Types.VARCHAR);
				callServCode.execute();
				Serv_Desc = callServCode.getString(1) == null ? "" : callServCode.getString(1);	
				Rate_Charge_Flag = callServCode.getString(2) == null ? "" : callServCode.getString(2);	
				Serv_Qty = callServCode.getString(3) == null ? "" : callServCode.getString(3);	
				Message_Text = callServCode.getString(4) == null ? "" : callServCode.getString(4);	
				System.err.println("Response Serv_Desc  "+Serv_Desc);
				System.err.println("Response Rate_Charge_Flag  "+Rate_Charge_Flag);
				System.err.println("Response Serv_Qty  "+Serv_Qty);
				System.err.println("Response Message_Text  "+Message_Text);
				if(Message_Text.equals("")){
					OutPut_Text="~"+Serv_Desc+"~"+Rate_Charge_Flag+"~"+Serv_Qty+"~";
					System.err.println("Response Final  "+OutPut_Text);
					out.println(OutPut_Text);
				}else{
					OutPut_Text="~Error~"+Message_Text;
					out.println(OutPut_Text);
				}
				
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception Occured in calling Service Code validation Procedure  "+e);
			out.println("~Error~"+e);
		}
	}
	else if(CalledFor.equals("servQtyCheck")){
		try{
		String FacId=request.getParameter("FacId");
		String LangId=request.getParameter("LangId");
		String loginUser=request.getParameter("loginUser");
		String ServEncounterId = request.getParameter("ServEncounterId");
		String ServDate = request.getParameter("ServDate");
		String ServTypeInd = request.getParameter("ServTypeInd");
		String serviceCode = request.getParameter("serviceCode");
		String serviceQty = request.getParameter("serviceQty");
		String serviceRateCharge = request.getParameter("serviceRateCharge");
		String cptCode=request.getParameter("cptCode");
		String siteSpecPatPayable=request.getParameter("siteSpecPatPayable");//V230222 -AAKH
		System.err.println("FacId  "+FacId);
		System.err.println("LangId  "+LangId);
		System.err.println("loginUser  "+loginUser);
		System.err.println("ServEncounterId  "+ServEncounterId);
		System.err.println("ServiceDateTime  "+ServDate);
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		java.util.Date servdateTime2 = sdf2.parse(ServDate);
		SimpleDateFormat outputFormat2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    String outputString2 = outputFormat2.format(servdateTime2);
		System.out.println("output Service Date String for service Qantity  "+outputString2);
		System.err.println("ServTypeInd  "+ServTypeInd);
		System.err.println("serviceCode  "+serviceCode);
		System.err.println("serviceQty  "+serviceQty);
		System.err.println("siteSpecPatPayable  "+siteSpecPatPayable);
		System.err.println("serviceRateCharge  "+serviceRateCharge);
		double Serv_amt=0.0d;
		double Ins_amt=0.0d;
		double Pat_amt=0.0d; //V230222
		String Msg_Txt="";
		String preAppReqFlag="";
		String OutPut_Text="";
		//con = ConnectionManager.getConnection(request); //V211020
		String Query_Quantity_Services="";
		ServTypeInd="S"; //V230222 -to load drug data 
		if(siteSpecPatPayable.equals("true") ){//V230222
			Query_Quantity_Services = "{ call bl_coders.validate_serv_qty ('"+FacId+"','"+LangId+"','"+loginUser+"','"+ServEncounterId+"',to_date('"+outputString2+" ','dd-mm-rrrr hh24:mi:ss'),'"+ServTypeInd+"','"+serviceCode+"','"+Double.parseDouble(serviceQty)+"','"+serviceRateCharge+"',?,?,?,?,'"+cptCode+"',?) }";
		}else{
			Query_Quantity_Services = "{ call bl_coders.validate_serv_qty ('"+FacId+"','"+LangId+"','"+loginUser+"','"+ServEncounterId+"',to_date('"+outputString2+" ','dd-mm-rrrr hh24:mi:ss'),'"+ServTypeInd+"','"+serviceCode+"','"+Double.parseDouble(serviceQty)+"','"+serviceRateCharge+"',?,?,?,?,'"+cptCode+"') }";
		}
				System.err.println("Query service Quantity and Desc  ");
				CallableStatement callServQty = con.prepareCall(Query_Quantity_Services);		
				callServQty.registerOutParameter(1,java.sql.Types.DOUBLE);		
				callServQty.registerOutParameter(2,java.sql.Types.DOUBLE);		
				callServQty.registerOutParameter(3,java.sql.Types.VARCHAR);		
				callServQty.registerOutParameter(4,java.sql.Types.VARCHAR);	
				if(siteSpecPatPayable.equals("true") ){
					callServQty.registerOutParameter(5,java.sql.Types.VARCHAR);	 //new
				}//V230222
				callServQty.execute();
				Serv_amt = callServQty.getDouble(1);	
				Ins_amt = callServQty.getDouble(2);
				preAppReqFlag = callServQty.getString(3) == null ? "" : callServQty.getString(3);		
				if(siteSpecPatPayable.equals("true") ){
					Pat_amt = callServQty.getDouble(5); //V230222
					System.err.println("Response Pat_amt  "+Pat_amt); //new
				}//V230222
				
				
				Msg_Txt = callServQty.getString(4) == null ? "" : callServQty.getString(4);		
				System.err.println("Response Serv_amt  "+Serv_amt);
				System.err.println("Response Ins_amt  "+Ins_amt);
				System.err.println("Response preAppReqFlag  "+preAppReqFlag);
				System.err.println("Response Msg_Txt  "+Msg_Txt);
				if(Msg_Txt.equals("")){
					OutPut_Text="~"+Serv_amt+"~"+Ins_amt+"~"+preAppReqFlag+"~";
					System.err.print("Msg_Txt 4");
					if(siteSpecPatPayable.equals("true") ){
						System.err.print("Msg_Txt 3");
						OutPut_Text+=Pat_amt+"~";				 
					}//V230222	
					System.err.println("OutPut_Text "+OutPut_Text);
					out.println(OutPut_Text);
				}
				else{
					OutPut_Text="~Error~"+Msg_Txt;
					out.println(OutPut_Text);
				}
				}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception Occured inService quantity validation Procedure  "+e);
			out.println("~Error~"+e);
		}
	}else if(CalledFor.equals("GenBill")){
		try{
			String patientId=request.getParameter("patientId");
			String facilityId=request.getParameter("facilityId");
			String encounter_id=request.getParameter("encounter_id");
			String ServiceSessionId=request.getParameter("ServiceSessionId");
			String loginUser=request.getParameter("loginUser");
			String localeLang = request.getParameter("localeLang");
			String WS_NO = request.getParameter("WS_NO");
			String EpisodeType = request.getParameter("EpisodeType");
			String retBillFlag="";
			String query="select CA_CODER_COMPLITION_STATUS(?,?,?) from dual";
			//con = ConnectionManager.getConnection(request);		//V211020
			pstmtCheckBill = con.prepareStatement(query);
			pstmtCheckBill.setString(1,facilityId);
			pstmtCheckBill.setString(2,patientId);
			pstmtCheckBill.setString(3,encounter_id);
			rsCheckBill = pstmtCheckBill.executeQuery();
			if(rsCheckBill!=null && rsCheckBill.next())
			{
				retBillFlag = rsCheckBill.getString(1);  
			}
			if ( retBillFlag == null ){
				retBillFlag = "";
			}
			if(rsCheckBill !=null) rsCheckBill.close();
				pstmtCheckBill.close();	
			
		if(retBillFlag.equals("N")){
			out.println("~E~BL0918");
		}else{				
			String genBillNo="";
			String unCofrmServ="";
			String transactionStatus="";
			String messageId="";
			String messageText="";
			String billPartialComplete = "";
			//Getting Count
			String totCount="";
			String billableCount="";
			String totQuery = "SELECT count(*) totCount FROM bl_cdr_pat_charges_folio_temp WHERE session_id ='"+ServiceSessionId+"' AND operating_facility_id ='"+facilityId+"' AND encounter_id ='"+encounter_id+"' AND NVL (settlement_ind, 'N') = 'X'";			
			String billableQuery = "SELECT count(*) billableCount FROM bl_cdr_pat_charges_folio_temp WHERE session_id ='"+ServiceSessionId+"' AND operating_facility_id ='"+facilityId+"' AND encounter_id = '"+encounter_id+"' AND NVL (settlement_ind, 'N') = 'X' AND BILLABLE_YN='Y'";
			//Getting Total Count
			try
			{	
				PreparedStatement pstmtTotalCnt = null ;
				ResultSet rsTotalCnt = null;
				//con = ConnectionManager.getConnection(request); //V211020
				pstmtTotalCnt = con.prepareStatement(totQuery);
				rsTotalCnt=pstmtTotalCnt.executeQuery();
				if( rsTotalCnt != null ) 
				{
				while(rsTotalCnt.next())
				{
					totCount= rsTotalCnt.getString(1);
				}
				}else
				{ 
					rsTotalCnt.close();
				}
			pstmtTotalCnt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception while Retriving Total Count Id :"+e);
			}
	
			//Billable Count	
			try
			{	
				PreparedStatement pstmtBillCnt = null ;
				ResultSet rsBillCnt = null;
				//con = ConnectionManager.getConnection(request);//V211020
				pstmtBillCnt = con.prepareStatement(billableQuery);
				rsBillCnt=pstmtBillCnt.executeQuery();
				if( rsBillCnt != null ) 
				{
					while(rsBillCnt.next())
					{
						billableCount= rsBillCnt.getString(1);
					}
				}
				else
					{ 
						rsBillCnt.close();
					}
			pstmtBillCnt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception while Retriving Total Count Id :"+e);
			}
			
			if(EpisodeType.equals("I") || EpisodeType.equals("D")){
			if(!billableCount.equals(totCount)){
				//Update billable flag
				try
					{	
						String upBillQuery="update bl_cdr_pat_charges_folio_temp set BILLABLE_YN='Y' WHERE session_id ='"+ServiceSessionId+"' AND operating_facility_id ='"+facilityId+"' AND encounter_id ='"+encounter_id+"' AND BILLABLE_YN='N'";
						PreparedStatement pstmtUpBillCnt = null ;
					//	con = ConnectionManager.getConnection(request);//V211020
						pstmtUpBillCnt = con.prepareStatement(upBillQuery);
						int rsUpBillCnt=pstmtUpBillCnt.executeUpdate();
						if( rsUpBillCnt != 0 ) 
						{
						billPartialComplete="C";
						}
					pstmtUpBillCnt.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Exception while Retriving Total Count Id :"+e);
					}
			}
			else{
				billPartialComplete="C";
			}
			}
			else if(EpisodeType.equals("O") || EpisodeType.equals("E") || EpisodeType.equals("R")){
				if(!billableCount.equals(totCount)){
					billPartialComplete="P";
				}
				else{
					billPartialComplete="C";
				}
			}
		//	con = ConnectionManager.getConnection(request); //V211020
			String Query_GenBill = "{ call bl_coders.generate_bill (?,?,?,?,?,?,?,?,?,?,?,?) }";
			CallableStatement callGenBill = con.prepareCall(Query_GenBill);
			callGenBill.setString(1,facilityId);
			callGenBill.setString(2,ServiceSessionId);
			callGenBill.setString(3,encounter_id);
			callGenBill.setString(4,loginUser);
			callGenBill.setString(5,WS_NO);
			callGenBill.setString(6,localeLang);
			callGenBill.setString(7,billPartialComplete);
			callGenBill.registerOutParameter(8,java.sql.Types.VARCHAR);
			callGenBill.registerOutParameter(9,java.sql.Types.VARCHAR);
			callGenBill.registerOutParameter(10,java.sql.Types.VARCHAR);
			callGenBill.registerOutParameter(11,java.sql.Types.VARCHAR);
			callGenBill.registerOutParameter(12,java.sql.Types.VARCHAR);
			callGenBill.execute();
			unCofrmServ=callGenBill.getString(8);
			genBillNo=callGenBill.getString(9);
			transactionStatus=callGenBill.getString(10);
			messageText=callGenBill.getString(11);
			messageId=callGenBill.getString(12);
			if(transactionStatus==null) transactionStatus="";
			if(messageId==null) messageId="";
			if(messageText==null) messageText="";
				if(transactionStatus.equals("S")){
					if(unCofrmServ==null){
						out.println("~S~Bill Generated Succesfully ");
					}else{
						out.println("~S~"+unCofrmServ+"~Bill Generated Succesfully ");
					}
				}				
				if (transactionStatus.equals("E")){
					if(!messageId.equals("")){
						out.println("~E~"+messageId);
					}else{
						out.println("~Err~"+messageText);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception Occured Generate Bill Procedure  "+e);
			out.println("~Error~"+e);
		}
	}
	else if(CalledFor.equals("visitAdmDate")){
		try{
			System.err.println("Inside Called For  "+CalledFor);
			String VisitAdmDate="";
			String ServEncounterId=request.getParameter("ServEncounterId");
			String PatientID=request.getParameter("PatientID");
			System.err.println("ServEncounterId  "+ServEncounterId);
			System.err.println("PatientID  "+PatientID);
			PreparedStatement pstmtVisitAdmDate = null ;
			SimpleDateFormat visitAdmSdfIP = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat visitAdmSdfOP = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			ResultSet rsVisitAdmDate = null;
			String visitAdmDateQuery = "SELECT min(visit_adm_date_time) FROM pr_encounter WHERE   encounter_id ='"+ServEncounterId+"' AND  patient_id ='"+PatientID+"' AND patient_class  in ('IP','DC','OP','EM')";			
			System.err.println("visitAdmDateQuery  "+visitAdmDateQuery);
		//	con = ConnectionManager.getConnection(request); //V211020
			pstmtVisitAdmDate = con.prepareStatement(visitAdmDateQuery);
			rsVisitAdmDate=pstmtVisitAdmDate.executeQuery();
			if( rsVisitAdmDate != null ) 
			{
			while(rsVisitAdmDate.next())
			{
				VisitAdmDate= rsVisitAdmDate.getString(1);
				if(!VisitAdmDate.equals("")){
				java.util.Date visitAdmdateTime = visitAdmSdfIP.parse(VisitAdmDate);
				VisitAdmDate = visitAdmSdfOP.format(visitAdmdateTime);
				System.err.println("VisitAdmDate "+VisitAdmDate);
				out.println("~"+VisitAdmDate);
				}else{
					out.println("");
				}
			}
			}else
				{ 
					System.err.println("rsVisitAdmDate is Empty "+rsVisitAdmDate.toString());
					out.println("");
					rsVisitAdmDate.close();
				}
		pstmtVisitAdmDate.close();
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception Occured Getting Visit/Admission Date  "+e);
			out.println("Error"+e);
		}	
	}
	else if(CalledFor.equals("appDateVal")){
		try{
			String Approval_Date=request.getParameter("AppDate");
			//System.err.println("Approval_Date  "+Approval_Date);
			SimpleDateFormat comdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			java.util.Date curDate = new java.util.Date();  
			java.util.Date servAppDate = comdateFormat.parse(Approval_Date);
			int val1= curDate.compareTo(servAppDate);
			//System.err.println("val1  "+val1);
				if(val1< 0){
					out.println("~Date cannot be greater than the System date");
				}
				else{
					out.println("");
				}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception Occured Validatin Approval Date  "+e);
			out.println("");
		}
	}
	else if(CalledFor.equals("orderClinician")){
		try{
			String FacilityId=request.getParameter("FacilityId");
			String EpisodeType=request.getParameter("EpisodeType");
			String EncounterId=request.getParameter("EncounterId");
			String VisitID=request.getParameter("VisitID");
			String LangId=request.getParameter("LangId");
			String clinicianQry="";
			String physicianID="";
			String pracName="";
		if(EpisodeType.equals("O") || EpisodeType.equals("E")){
			clinicianQry="SELECT b.PHYSICIAN_ID, a.practitioner_name FROM BL_VISIT_FIN_DTLS b, am_practitioner_lang_vw a WHERE b.operating_facility_id ='"+FacilityId+"'  and b.EPISODE_TYPE ='"+EpisodeType+"'  AND b.encounter_ID ='"+EncounterId+"' AND a.practitioner_id = b.physician_id AND a.language_id = NVL ('"+LangId+"', 'en')";
		}
		else if(EpisodeType.equals("I") || EpisodeType.equals("D")){
			clinicianQry="SELECT b.to_physician_id, a.practitioner_name FROM bl_ip_adt_trn_vw b, am_practitioner_lang_vw a WHERE b.facility_id ='"+FacilityId+"' AND b.episode_id ='"+EncounterId+"' AND a.practitioner_id = b.to_physician_id AND a.language_id = NVL ('"+LangId+"', 'en') AND b.trn_srl_num IN (SELECT MAX (c.trn_srl_num) FROM bl_ip_adt_trn_vw c WHERE c.facility_id ='"+FacilityId+"' AND c.episode_id ='"+EncounterId+"' AND NVL (c.trn_code, 'X') IN ('A', 'T') AND NVL (c.adt_trn_status, 'X') != '9')";
		}  
			System.err.println("clinicianQry  "+clinicianQry);
		//	con = ConnectionManager.getConnection(request);//V211020
			pstmtOrderClinician = con.prepareStatement(clinicianQry);
			rsOrderClinician=pstmtOrderClinician.executeQuery();
			if( rsOrderClinician != null ) 
			{
			while(rsOrderClinician.next())
			{
				physicianID= rsOrderClinician.getString(1);
				pracName= rsOrderClinician.getString(2);
				System.err.println("physicianID  "+physicianID);
				System.err.println("pracName  "+pracName);
				out.println("~"+physicianID+"~"+pracName);
			}
			}else
				{ 
					System.err.println("rsOrderClinician is Empty "+rsOrderClinician.toString());
					out.println("");
					rsOrderClinician.close();
				}
		pstmtOrderClinician.close();
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception Occured Ordering Clinician  "+e);
			out.println("");
		}
	}else if(CalledFor.equals("getMsgFromDB")){
		try{  
			String msgId=request.getParameter("msgId");
			String msgQuery="select MESSAGE_TEXT_SYSDEF from sm_message where message_id='"+msgId+"'";
			String msgText="";
			System.err.println("msgQuery  "+msgQuery);
			//con = ConnectionManager.getConnection(request);//V211020
			pstmtMsg = con.prepareStatement(msgQuery);
			rsMsg=pstmtMsg.executeQuery();
			if( rsMsg != null ) {
				while(rsMsg.next()){
					msgText= rsMsg.getString(1);
					System.err.println("msgText  "+msgText);
					out.println("~"+msgText);
				}
			}else{ 
				System.err.println("rsMsg is Empty "+rsMsg.toString());
				out.println("~ ");
				rsMsg.close();
			}
			pstmtMsg.close();
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception Occured get Mesage From DB  "+e);
			out.println("~ ");
		}
	}else if(CalledFor.equals("cptCode")){
		try{  
			String FacilityId=request.getParameter("FacilityId");
			String loginUser=request.getParameter("loginUser");
			String LangId=request.getParameter("LangId");
			String cptCode=request.getParameter("cptCode");
			String serviceCode=request.getParameter("servCode");
			String serTypeInd=request.getParameter("serTypeInd");
			String servCode="";
			String servDesc="";
			String servType="";
			String MsgTxt="";
			System.err.println("FacilityId  "+FacilityId);
			System.err.println("loginUser  "+loginUser);
			System.err.println("cptCode  "+cptCode);
			System.err.println("LangId  "+LangId);
			String cptQuery="{ call bl_coders.get_cpt_service_info (?,?,?,?,?,?,?,?,?,?)}";
			System.err.println("cptQuery  "+cptQuery);
			//con = ConnectionManager.getConnection(request);//V211020
			CallableStatement callCPT= con.prepareCall(cptQuery);
			callCPT.setString(1,FacilityId);
			callCPT.setString(2,LangId);
			callCPT.setString(3,loginUser);
			callCPT.setString(4,cptCode);
			callCPT.setString(5,serviceCode);
			callCPT.setString(6,serTypeInd);
			callCPT.registerOutParameter(7,java.sql.Types.VARCHAR);
			callCPT.registerOutParameter(8,java.sql.Types.VARCHAR);
			callCPT.registerOutParameter(9,java.sql.Types.VARCHAR);
			callCPT.registerOutParameter(10,java.sql.Types.VARCHAR);
			callCPT.execute();
			servCode=callCPT.getString(7);
			servDesc=callCPT.getString(8);
			servType=callCPT.getString(9);
			MsgTxt=callCPT.getString(10);
			System.err.println("servCode  "+servCode);
			System.err.println("servDesc  "+servDesc);
			System.err.println("servType  "+servType);
			System.err.println("MsgTxt  "+MsgTxt);
			if( MsgTxt == null && servCode!=null){
				out.println("~S~"+servCode+"~"+servDesc);
			}
			else if(MsgTxt == null && servCode==null){
				out.println("~M");//open LOV
			}else{
				out.println("~E~"+MsgTxt);
			}		
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception Occured get Service Code Population on CPT  "+e);
			out.println("~E");
		}
	}else if(CalledFor.equals("servCode")){
		try{
			String servTypeDesc="";
			String serviceCode=request.getParameter("servCode");
			String servTypeDescQuery="select b.long_desc from bl_blng_serv a,BL_BLNG_SERV_GRP b where a.BLNG_SERV_CODE = '"+serviceCode+"' and b.SERV_GRP_CODE =a.SERV_GRP_CODE";
			System.err.println("serviceCode  "+serviceCode);
			System.err.println("servTypeDescQuery  "+servTypeDescQuery);
		//	con = ConnectionManager.getConnection(request);//V211020
			pstmtDesc = con.prepareStatement(servTypeDescQuery);
			rsDesc=pstmtDesc.executeQuery();
			if( rsDesc != null ) {
				while(rsDesc.next()){
					servTypeDesc= rsDesc.getString(1);
					System.err.println("servTypeDesc  "+servTypeDesc);
					out.println("~"+servTypeDesc);
				}
			}else{ 
				System.err.println("rsDesc is Empty "+rsDesc.toString());
				out.println("~ ");
				rsDesc.close();
			}
			pstmtDesc.close();
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception Occured get Service Type Decription Population on Service Code  "+e);
			out.println("~E");
		}
	}else if(CalledFor.equals("printgenBill")){
		try{
			String facilityId=request.getParameter("facility_id");
			String encounter_id=request.getParameter("encounter_id");
			String pgm_id=request.getParameter("pgm_id");
			String wsNo=request.getParameter("wsNo");
			String sessionId="";
			String pgmdate="";
			String msgTxt="";
			String printBillQuery="{ call bl_coders.bill_print(?,?,?,?,?,?,?)}";
			// con = ConnectionManager.getConnection(request);
			CallableStatement callBillPrint= con.prepareCall(printBillQuery);
			callBillPrint.setString(1,facilityId);
			callBillPrint.setString(2,encounter_id);
			callBillPrint.setString(3,pgm_id);
			callBillPrint.setString(4,wsNo);
			callBillPrint.registerOutParameter(5,java.sql.Types.VARCHAR);
			callBillPrint.registerOutParameter(6,java.sql.Types.VARCHAR);
			callBillPrint.registerOutParameter(7,java.sql.Types.VARCHAR);
			callBillPrint.execute();
			sessionId=callBillPrint.getString(5);
			pgmdate=callBillPrint.getString(6);
			msgTxt=callBillPrint.getString(7);
			if(sessionId!=null && pgmdate!=null){
				callBillPrint = null;
				con.commit();
				out.println("~"+sessionId+":::"+pgmdate);
			}			
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception Occured in getting Reports  "+e);
			con.rollback();
		}
	}
	else if(CalledFor.equals("generateCoder")){//Added by Kamatchi S for TH-KW-CRF-0143 Start
		try{
			String facilityId=request.getParameter("facility_id");
			String patientId=request.getParameter("patient_id");
			String episodeId=request.getParameter("episode_id");
			String episodeType=request.getParameter("episode_type");
			String visitId=request.getParameter("visit_Id");
			String userId=request.getParameter("user_id");
			String patientClass=request.getParameter("patient_class");
			String encounter_id=request.getParameter("encounter_id");
			String bean_id				= "CACoderFunction" ;
			String bean_name			= "eCA.CACoderFunction";
			String coderClearanceStatus = "";
			CACoderFunction bean	= (CACoderFunction)getBeanObject( bean_id, bean_name , request) ; 
		
			String transactionStatus="";
			String msgTxt="";
			String output="";

			String generateQuery="{ call bl_coders.generate_coder_clearance(?,?,?,?,?,?,?,?)}";
		
			CallableStatement callGenerateCode= con.prepareCall(generateQuery);
			callGenerateCode.setString(1,facilityId);
			callGenerateCode.setString(2,episodeType);
			callGenerateCode.setString(3,patientId);
			callGenerateCode.setString(4,episodeId);
			callGenerateCode.setString(5,visitId);
			callGenerateCode.setString(6,userId);
			callGenerateCode.registerOutParameter(7,java.sql.Types.VARCHAR);
			callGenerateCode.registerOutParameter(8,java.sql.Types.VARCHAR);
			callGenerateCode.execute();
			transactionStatus=callGenerateCode.getString(7);
			msgTxt=callGenerateCode.getString(8);
	
			con.commit();
			coderClearanceStatus = bean.getCoderClearanceStatus(facilityId,patientId,episodeType,episodeId,visitId);

			output="~"+transactionStatus+"~"+msgTxt+"~"+coderClearanceStatus;
			out.println(output);
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception Occured in Generating Coder Clearance  "+e);
			con.rollback();
		}
	}
	else if(CalledFor.equals("cancelCoder")){
		try{
			String facilityId=request.getParameter("facility_id");
			String patientId=request.getParameter("patient_id");
			String episodeId=request.getParameter("episode_id");
			String episodeType=request.getParameter("episode_type");
			String visitId=request.getParameter("visit_Id");
			String patientClass=request.getParameter("patient_class");
			String coderClearanceStatus = "";
			String bean_id				= "CACoderFunction" ;
			String bean_name			= "eCA.CACoderFunction";
			CACoderFunction bean	= (CACoderFunction)getBeanObject( bean_id, bean_name , request) ; 

			String transactionStatus="";
			String msgTxt="";
			String output="";

			String generateQuery="{ call bl_coders.cancel_coder_clearance(?,?,?,?,?,?,?)}";

			CallableStatement callCancelCode= con.prepareCall(generateQuery);
			callCancelCode.setString(1,facilityId);
			callCancelCode.setString(2,episodeType);
			callCancelCode.setString(3,patientId);
			callCancelCode.setString(4,episodeId);
			callCancelCode.setString(5,visitId);
			callCancelCode.registerOutParameter(6,java.sql.Types.VARCHAR);
			callCancelCode.registerOutParameter(7,java.sql.Types.VARCHAR);
			callCancelCode.execute();
			transactionStatus=callCancelCode.getString(6);
			msgTxt=callCancelCode.getString(7);

			con.commit();
			coderClearanceStatus = bean.getCoderClearanceStatus(facilityId,patientId,episodeType,episodeId,visitId);
	
			output="~"+transactionStatus+"~"+msgTxt+"~"+coderClearanceStatus;
			out.println(output);		
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception Occured in Cancel Coder Clearance  "+e);
			con.rollback();
		}
	}
	else if(CalledFor.equals("ipIndicator")){
		try{
			System.err.println("ipIndicator");
			String facilityId=request.getParameter("facility_id");
			String patientId=request.getParameter("patient_id");
			String episodeId=request.getParameter("episode_id");
			String episodeType=request.getParameter("episode_type");
			String transactionStatus="";
			String msgTxt="";
			String output="";
			
			String ipIndicator="{ ? = call bl_get_bill_gen_dtls.get_bill_ip_indicator(?,?,?,?)}";
			CallableStatement callIpIndicator= con.prepareCall(ipIndicator);
			callIpIndicator.registerOutParameter(1, java.sql.Types.VARCHAR);
			callIpIndicator.setString(2,facilityId);
			callIpIndicator.setString(3,patientId);
			callIpIndicator.setString(4,episodeType);
			callIpIndicator.setString(5,episodeId);
			
			callIpIndicator.execute();
			transactionStatus=callIpIndicator.getString(1);
			con.commit();
			output="~"+transactionStatus;
			out.println(output);
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception Occured in IP Indicator"+e);
			con.rollback();
		}
	}//Added by Kamatchi S for TH-KW-CRF-0143 End
	}catch(Exception ex){
			ex.printStackTrace();
			System.err.println("~Exception Occured in blcoderfunctservvalidation.jsp:  "+ex);
		}finally{
			if(con!=null) {
			ConnectionManager.returnConnection(con, request);
		}
		} //V211020

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
