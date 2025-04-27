package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.sql.*;
import webbeans.eCommon.*;

public final class __ambulancemanagementsystemcode extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AmbulanceManagementSystemCode.jsp", 1709113772488L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

java.util.Properties props = new java.util.Properties();

public void jspInit(){
	try{
				java.net.URL url=getServletConfig().getServletContext().getResource("/WEB-INF/classes/AmbTblColumnDef.properties");
				java.io.FileInputStream pin = new java.io.FileInputStream(url.getFile());
				
				if (pin!=null)props.load(pin);

		}catch(Exception ex){
			ex.printStackTrace();
		}
}

private synchronized void createDrggableObject(String divMv,int no,javax.servlet.jsp.JspWriter out1){
	try{
		int psNo=no;
		switch(no%6){
			case 0 :
				psNo=6;
			break;
			case 1 :
				psNo=1;
			break;
			case 2 :
				psNo=2;
			break;
			case 3 :
				psNo=3;
			break;
			case 4 :
				psNo=4;
			break;
			case 5 :
				psNo=5;
			break;
		}
		out1.println("<script>");
		out1.println("(function() {var clickRadius = 70, Event=YAHOO.util.Event, Dom=YAHOO.util.Dom;");
		out1.println("YAHOO.util.Event.onDOMReady(function() {");
		out1.println("var el"+no+" = Dom.get("+divMv+");    dd"+no+" = new YAHOO.util.DDProxy(el"+no+");");
		out1.println("dd"+no+".clickValidator = function(e) {if(!getSelctedAmbId()) return false;  return true;}; ");
		out1.println("dd"+no+".onDragDrop = function(e, id) {startPos"+no+" = Dom.getXY(Dom.get(el"+no+"));new YAHOO.util.Motion( this.id, {points: {to: startPos"+no+"}},0.3,YAHOO.util.Easing.easeOut).animate();setSelctedAmbId(this.getEl().id);populateReqstdAmb(this.getEl().name);}");
		out1.println("dd"+no+".onInvalidDrop = function(e) {startPos"+no+" = Dom.getXY(Dom.get(el"+no+"));new YAHOO.util.Motion( this.id, {points: {to: startPos"+no+"}},0.3,YAHOO.util.Easing.easeOut).animate();FnPosition();}");
		
		out1.println("dt = new YAHOO.util.DDTarget('bottomRight');});})(); ");
		out1.println("</script>");

		//var t=setTimeout(\"alert(eval('startPos'+"+no+"))\",1000);
		
	}catch(java.io.IOException e){
		e.printStackTrace();
	}
}

private String manipulateCheckBox(String chk,String code){
	return chk.equals(code)?"checked":"";
}
private String checkNull(String inputString){
		return (inputString==null)	?	""	:	inputString;
}

private String validateString(String str){
	if(str==null) return "";
	
	StringBuffer sb		=	new StringBuffer();
    int j=0;
	for(int i=0;i<str.length();i++){
		j=(int)str.charAt(i);
		if(j!=10 && j!=13) sb.append(str.charAt(i));
	}
	return sb.toString();
}

public static String truncate(String value, int length){
  if (value != null && value.length() > length){
    value = value.substring(0, length);
    value = value+"...";
  }
  return value;
}



    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    //String qString=request.getQueryString() ;	
	//String bean_id				 = "AmbulanceManagementSystemBean";
 	//String bean_name			 = "eAE.AmbulanceManagementSystemBean";
	//AmbulanceManagementSystemBean bean	 =	(AmbulanceManagementSystemBean)getBeanObject(bean_id,bean_name, request ) ;	

	String cellData					=	"\"Response\" : { \"Results\" : [ ";
	String cellData1				=	"";
	String cellData2				=	"\"Response\" : { \"Results\" : [ ";
	String patient_name				=	""; 
	String reqtDate					=	""; 
	String status					=	""; 
	String pickup					=	""; 
	String drop						=	"";
	String age						=	""; 
	String sex						=	""; 
	String pickupAddr				=	""; 
	String dropAddr					=	""; 
	String ambNatureCallCode		=	"";
	String ambCaseNum				=	""; 
	String ambVehicleID				=	""; 
	String ambVehicleName			=	""; 
	String ambRegnNo				=	""; 
	String ambModelNo				=	""; 
	String ambDateManf				=	""; 
	String ambLastMileage			=	""; 
	String ambRemarks				=	""; 
	String ambStatus				=	""; 
	String chartClass				=	"";
	String ambContName              =	"";
	String ambContPhone             =	"";
	String ambType					=	"";
	String ambCaseNo				=	"";
	String ambPatDet				=	"";

	String to_date					=	"";
	String from_date				=	"";
	String aChecked					=	"";
	String bChecked					=	"";
	String mChecked					=	"";

	String reqChecked				=	"";
	String asnChecked				=	"";
	String comChecked				=	"";
	String canChecked				=	"";

	String  ambCaseStartDate		=	"";
	String	ambCaseEndDate			=	"";
	String	patientName				=	"";
	String	ambCallerName			=	"";
	String	ambCallerContNo			=	"";
	String	ambCallerRmrks			=	"";
	String	natureCallDesc			=	"";
	String	ambPriorityInd			=	"";
	String	ambStartMileage			=	"";
	String	ambEndMileage			=	"";
	String  ambDispRemarks			=	"";
	String	currentLocation			=	"";

	String mFlag					=	request.getParameter("mFlag")==null?"M":request.getParameter("mFlag");
	String aFlag					=	request.getParameter("aFlag")==null?"A":request.getParameter("aFlag");
	String bFlag					=	request.getParameter("bFlag")==null?"B":request.getParameter("bFlag");
	String reqFlag					=	request.getParameter("reqFlag")==null?"R":request.getParameter("reqFlag");
	String asnFlag					=	request.getParameter("asnFlag")==null?"A":request.getParameter("asnFlag");
	String comFlag					=	request.getParameter("comFlag")==null?"X":request.getParameter("comFlag");
	String canFlag					=	request.getParameter("canFlag")==null?"N":request.getParameter("canFlag");
	String selOrder					=	request.getParameter("selOrder")==null?"":request.getParameter("selOrder");
	String findText					=	request.getParameter("findText")==null?"":request.getParameter("findText").trim();
	String findTextTemp="";
	if(!findText.equals(""))
	findTextTemp="%"+findText+"%";


	/*int queStart					=	request.getParameter("queStart")==null?1:Integer.parseInt(request.getParameter("queStart"));
	int queEnd						=	request.getParameter("queEnd")==null?6:Integer.parseInt(request.getParameter("queEnd"));
	int chartStart					=	request.getParameter("chartStart")==null?1:Integer.parseInt(request.getParameter("chartStart"));
	int chartEnd					=	request.getParameter("chartEnd")==null?6:Integer.parseInt(request.getParameter("chartEnd"));*/

	String pageString				=	request.getParameter("pageString")==null?"":request.getParameter("pageString");
	String wStatus					=	request.getParameter("wStatus")==null?"":request.getParameter("wStatus");

	String err_msg					=	request.getParameter("err_msg")==null?"":request.getParameter("err_msg");

	from_date						=	request.getParameter("from_date");
	to_date							=	request.getParameter("to_date");

	int queTotal					=	0;
	int chartTotal					=	0;

	String ambDiv					=	"";

	
	
	    
	String facility_id				=	(String)session.getValue("facility_id");
	String user						=	(String)session.getValue("login_user");
	String ChkHiddenCols				=	"";
	String defaultOrder				=	"";
	String selOrderDesc				=	"";
	String selOrderId				=	"";
	StringBuffer clDef=new StringBuffer();
	StringBuffer clDef1=new StringBuffer();
	StringBuffer fields1=new StringBuffer();
	StringBuffer clmnOrdrs=new StringBuffer();

	PreparedStatement pstmt 	= null,pstmt1=null;
	Connection con				= null;
	ResultSet rs                = null,rs1=null;
	ArrayList list				= new ArrayList();
	ArrayList AmbChartDetList   = new ArrayList();

	ArrayList orderList			= new ArrayList();
	
	String query="";
	if(!findTextTemp.equals("")){
		query="SELECT A.FACILITY_ID FACILITY_ID,A.AMB_CASE_NO AMB_CASE_NO,to_char(A.AMB_CASE_BOOKED_DATE,'dd/mm/yyyy hh24:mi') AMB_CASE_BOOKED_DATE,A.AMB_VEHICLE_ID	AMB_VEHICLE_ID,	To_char(A.AMB_CASE_START_DATE,'dd/mm/yyyy hh24:mi')	AMB_CASE_START_DATE,to_char(A.AMB_CASE_END_DATE,'dd/mm/yyyy hh24:mi') AMB_CASE_END_DATE,A.PATIENT_ID PATIENT_ID ,nvl((select patient_name  || '/' ||  (case when sex='F' then 'F' when sex='M' then 'M' else 'U' end)  || '/' || get_age(date_of_birth)    from mp_patient where patient_id  =a.patient_id),patient_name  || '/' ||  (case when a.sex='F' then 'F' when a.sex='M' then 'M' else 'U' end)  || '/' || get_age(a.date_of_birth)  ) PATIENT_NAME , A.DATE_OF_BIRTH	DATE_OF_BIRTH,A.AGE AGE,A.SEX SEX,A.PICKUP_FROM_HOSP_YN PICKUP_FROM_HOSP_YN,A.PICKUP_LOCN_CODE PICKUP_LOCN_CODE,NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = A.PICKUP_LOCN_CODE and rownum <=1),PICKUP_LOCN_DESC) PICKUP_LOCN_DESC,A.PICKUP_ADDRESS	PICKUP_ADDRESS,	A.DESTN_LOCN_CODE DESTN_LOCN_CODE ,	NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = A.DESTN_LOCN_CODE and rownum <=1),A.DESTN_LOCN_DESC) DESTN_LOCN_DESC,A.DESTN_ADDRESS DESTN_ADDRESS ,	A.AMB_CALLER_NAME AMB_CALLER_NAME , A.AMB_CALLER_CONTACT_NO AMB_CALLER_CONTACT_NO, A.AMB_CALLER_REMARKS AMB_CALLER_REMARKS,	A.AMB_NATURE_CALL_CODE AMB_NATURE_CALL_CODE ,(SELECT LONG_DESC FROM AE_AMB_NATURE WHERE AMB_NATURE_CODE = A.AMB_NATURE_CALL_CODE) NATURE_CALL_DESC,	decode(A.AMB_PRIORITY_IND,'L','Low','H','High','M','Medium')  AMB_PRIORITY_IND,A.AMB_CASE_STATUS AMB_CASE_STATUS,A.AMB_START_MILEAGE AMB_START_MILEAGE,	A.AMB_END_MILEAGE AMB_END_MILEAGE,A.AMB_DISP_REMARKS AMB_DISP_REMARKS ,	C.AMB_CURRENT_LOCATION CURRENT_LOCATION ,B.AMB_VEHICLE_NAME AMB_VEHICLE_NAME,B.AMB_REGN_NO AMB_REGN_NO,	B.AMB_MODEL_NO AMB_MODEL_NO,B.AMB_DATE_MANUFCT AMB_DATE_MANUFCT,B.AMB_LAST_MILEAGE AMB_LAST_MILEAGE,B.AMB_REMARKS AMB_REMARKS FROM	AE_AMB_CASE_REQUEST A , AE_AMB_VEHICLE B,AE_AMB_OPEN_REQUEST C WHERE	A.FACILITY_ID = ? AND	TRUNC(A.AMB_CASE_BOOKED_DATE) between to_Date(?,'dd/mm/yyyy')  and to_Date(?,'dd/mm/yyyy')AND	A.AMB_CASE_STATUS IN ('A','R','C','X') AND	((? = 'R' and A.AMB_CASE_STATUS = 'R') OR (? = 'A' and A.AMB_CASE_STATUS = 'A' ) OR (? = 'C' and A.AMB_CASE_STATUS = 'C' ) OR (? = 'X' and A.AMB_CASE_STATUS = 'X' )) AND	A.FACILITY_ID = B.FACILITY_ID (+) AND	A.AMB_VEHICLE_ID = B.AMB_VEHICLE_ID (+)	AND	A.FACILITY_ID = C.FACILITY_ID (+) AND	A.AMB_CASE_NO = C.AMB_CASE_NO (+) and (upper(nvl((select patient_name  || '/' ||  (case when sex='F' then 'F' when sex='M' then 'M' else 'U' end)  || '/' || get_age(date_of_birth)    from mp_patient where patient_id  =a.patient_id),patient_name  || '/' ||  (case when a.sex='F' then 'F' when a.sex='M' then 'M' else 'U' end)  || '/' || get_age(a.date_of_birth)  )) like upper(?) OR upper(to_char(A.AMB_CASE_BOOKED_DATE,'dd/mm/yyyy hh24:mi')) like upper(?)  OR upper(A.AMB_CASE_STATUS) like upper(?) OR upper(NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = A.PICKUP_LOCN_CODE and rownum <=1),PICKUP_LOCN_DESC)) like upper(?) OR upper(NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = A.DESTN_LOCN_CODE and rownum <=1),A.DESTN_LOCN_DESC)) like upper(?) OR upper(A.PICKUP_ADDRESS) like upper(?) OR upper(A.DESTN_ADDRESS) like upper(?) OR upper(A.AMB_CASE_NO) like upper(?) OR upper(To_char(A.AMB_CASE_START_DATE,'dd/mm/yyyy hh24:mi')) like upper(?) OR upper(to_char(A.AMB_CASE_END_DATE,'dd/mm/yyyy hh24:mi')) like upper(?) OR upper(A.AMB_CALLER_NAME) like upper(?) OR upper(A.AMB_CALLER_CONTACT_NO ) like upper(?) OR upper(A.AMB_CALLER_REMARKS) like upper(?) OR upper((SELECT LONG_DESC FROM AE_AMB_NATURE WHERE AMB_NATURE_CODE = A.AMB_NATURE_CALL_CODE)) like upper(?) OR upper(decode(A.AMB_PRIORITY_IND,'L','Low','H','High','M','Medium') ) like upper(?) OR upper(A.AMB_START_MILEAGE) like upper(?) OR upper(A.AMB_END_MILEAGE) like upper(?) OR  upper(A.AMB_DISP_REMARKS) like upper(?) OR  upper(C.AMB_CURRENT_LOCATION) like upper(?) OR upper(B.AMB_VEHICLE_NAME) like upper(?) OR upper(B.AMB_REGN_NO) like upper(?) OR upper(B.AMB_LAST_MILEAGE) like upper(?)) order by AMB_PRIORITY_IND, AMB_CASE_BOOKED_DATE,ROWNUM";
}else{
	query="SELECT A.FACILITY_ID FACILITY_ID,A.AMB_CASE_NO AMB_CASE_NO,to_char(A.AMB_CASE_BOOKED_DATE,'dd/mm/yyyy hh24:mi') AMB_CASE_BOOKED_DATE,A.AMB_VEHICLE_ID	AMB_VEHICLE_ID,	To_char(A.AMB_CASE_START_DATE,'dd/mm/yyyy hh24:mi')	AMB_CASE_START_DATE,to_char(A.AMB_CASE_END_DATE,'dd/mm/yyyy hh24:mi') AMB_CASE_END_DATE,A.PATIENT_ID PATIENT_ID ,nvl((select patient_name  || '/' ||  (case when sex='F' then 'F' when sex='M' then 'M' else 'U' end)  || '/' || get_age(date_of_birth)    from mp_patient where patient_id  =a.patient_id),patient_name  || '/' ||  (case when a.sex='F' then 'F' when a.sex='M' then 'M' else 'U' end)  || '/' || get_age(a.date_of_birth)  ) PATIENT_NAME , A.DATE_OF_BIRTH	DATE_OF_BIRTH,A.AGE AGE,A.SEX SEX,A.PICKUP_FROM_HOSP_YN PICKUP_FROM_HOSP_YN,A.PICKUP_LOCN_CODE PICKUP_LOCN_CODE,NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = A.PICKUP_LOCN_CODE and rownum <=1),PICKUP_LOCN_DESC) PICKUP_LOCN_DESC,A.PICKUP_ADDRESS	PICKUP_ADDRESS,	A.DESTN_LOCN_CODE DESTN_LOCN_CODE ,	NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = A.DESTN_LOCN_CODE and rownum <=1),A.DESTN_LOCN_DESC) DESTN_LOCN_DESC,A.DESTN_ADDRESS DESTN_ADDRESS ,	A.AMB_CALLER_NAME AMB_CALLER_NAME , A.AMB_CALLER_CONTACT_NO AMB_CALLER_CONTACT_NO, A.AMB_CALLER_REMARKS AMB_CALLER_REMARKS,	A.AMB_NATURE_CALL_CODE AMB_NATURE_CALL_CODE ,(SELECT LONG_DESC FROM AE_AMB_NATURE WHERE AMB_NATURE_CODE = A.AMB_NATURE_CALL_CODE) NATURE_CALL_DESC,	decode(A.AMB_PRIORITY_IND,'L','Low','H','High','M','Medium')  AMB_PRIORITY_IND,A.AMB_CASE_STATUS AMB_CASE_STATUS,A.AMB_START_MILEAGE AMB_START_MILEAGE,	A.AMB_END_MILEAGE AMB_END_MILEAGE,A.AMB_DISP_REMARKS AMB_DISP_REMARKS ,	C.AMB_CURRENT_LOCATION CURRENT_LOCATION ,B.AMB_VEHICLE_NAME AMB_VEHICLE_NAME,B.AMB_REGN_NO AMB_REGN_NO,	B.AMB_MODEL_NO AMB_MODEL_NO,B.AMB_DATE_MANUFCT AMB_DATE_MANUFCT,B.AMB_LAST_MILEAGE AMB_LAST_MILEAGE,B.AMB_REMARKS AMB_REMARKS FROM	AE_AMB_CASE_REQUEST A , AE_AMB_VEHICLE B,AE_AMB_OPEN_REQUEST C WHERE	A.FACILITY_ID = ? AND	TRUNC(A.AMB_CASE_BOOKED_DATE) between to_Date(?,'dd/mm/yyyy')  and to_Date(?,'dd/mm/yyyy') AND	A.AMB_CASE_STATUS IN ('A','R','C','X') AND	((? = 'R' and A.AMB_CASE_STATUS = 'R') OR (? = 'A' and A.AMB_CASE_STATUS = 'A' ) OR (? = 'C' and A.AMB_CASE_STATUS = 'C' ) OR (? = 'X' and A.AMB_CASE_STATUS = 'X' )) AND	A.FACILITY_ID = B.FACILITY_ID (+) AND	A.AMB_VEHICLE_ID = B.AMB_VEHICLE_ID (+)	AND	A.FACILITY_ID = C.FACILITY_ID (+) AND	A.AMB_CASE_NO = C.AMB_CASE_NO (+) order by AMB_PRIORITY_IND, AMB_CASE_BOOKED_DATE,ROWNUM";
}

	String query3="select Count(*) FROM	AE_AMB_CASE_REQUEST A , AE_AMB_VEHICLE B,AE_AMB_OPEN_REQUEST C WHERE	A.FACILITY_ID = ? AND	TRUNC(A.AMB_CASE_BOOKED_DATE) between to_Date(?,'dd/mm/yyyy')  and to_Date(?,'dd/mm/yyyy')AND	A.AMB_CASE_STATUS IN ('A','R','C','X') AND	((? = 'R' and A.AMB_CASE_STATUS = 'R') OR (? = 'A' and A.AMB_CASE_STATUS = 'A' ) OR (? = 'C' and A.AMB_CASE_STATUS = 'C' ) OR (? = 'X' and A.AMB_CASE_STATUS = 'X' )) AND	A.FACILITY_ID = B.FACILITY_ID (+) AND	A.AMB_VEHICLE_ID = B.AMB_VEHICLE_ID (+)	AND	A.FACILITY_ID = C.FACILITY_ID (+) AND	A.AMB_CASE_NO = C.AMB_CASE_NO (+) order by A.AMB_PRIORITY_IND, A.AMB_CASE_BOOKED_DATE";
	
	String query1="SELECT A.AMB_VEHICLE_ID AMB_VEHICLE_ID, A.AMB_VEHICLE_NAME AMB_VEHICLE_NAME,A.AMB_REGN_NO AMB_REGN_NO,	A.AMB_MODEL_NO AMB_MODEL_NO,A.AMB_DATE_MANUFCT AMB_DATE_MANUFCT,A.AMB_LAST_MILEAGE AMB_LAST_MILEAGE,A.AMB_REMARKS AMB_REMARKS ,(CASE WHEN A.SUSPEND_MAINT_YN = 'Y' THEN 'M' ELSE   CASE WHEN A.SUSPEND_MAINT_YN = 'N' AND EXISTS (SELECT 'Y' FROM AE_AMB_OPEN_REQUEST WHERE FACILITY_ID = A.FACILITY_ID and AMB_VEHICLE_ID = A.AMB_VEHICLE_ID) THEN 'A' ELSE   CASE WHEN A.SUSPEND_MAINT_YN = 'N' AND NOT EXISTS (SELECT 'Y' FROM AE_AMB_OPEN_REQUEST WHERE FACILITY_ID = A.FACILITY_ID and AMB_VEHICLE_ID = A.AMB_VEHICLE_ID) THEN 'B' END END END)  AMB_STATUS, b.AMB_CASE_NO amb_Case_no ,(select PATIENT_NAME || '/' || sex  || '/'  || GET_AGE(DATE_OF_BIRTH)  from AE_AMB_CASE_REQUEST where facility_id = b.facility_id and  AMB_CASE_NO = b.AMB_CASE_NO )  Patient_dtls , A.AMB_LOCATION AMB_PARK_LOCATION , (select (select practitioner_name  from AM_PRACT_FOR_AMB_VW where practitioner_id = AMB_RESOURCE_ID and pract_source = AMB_RESOURCE_TYPE)  FROM  AE_AMB_VEHICLE_RESOURCE where facility_id = a.facility_id and AMB_VEHICLE_ID = a.AMB_VEHICLE_ID and CONTACT_DISPLY_YN = 'Y'  ) AMB_CONT_NAME, (select (select CONTACT_NO  from AM_PRACT_FOR_AMB_VW where practitioner_id = AMB_RESOURCE_ID and pract_source = AMB_RESOURCE_TYPE)  FROM  AE_AMB_VEHICLE_RESOURCE where facility_id = a.facility_id and AMB_VEHICLE_ID = a.AMB_VEHICLE_ID and CONTACT_DISPLY_YN = 'Y'  ) AMB_CONT_PHONE,AMB_VEHICLE_TYPE,(CASE WHEN  'Y' = (SELECT 'Y' FROM AE_AMB_OPEN_REQUEST WHERE FACILITY_ID = A.FACILITY_ID and AMB_VEHICLE_ID = A.AMB_VEHICLE_ID) THEN b.AMB_CURRENT_LOCATION  ELSE  a.AMB_LOCATION END) AMB_LOCATION  from	AE_AMB_VEHICLE A, AE_AMB_OPEN_REQUEST B WHERE	a.FACILITY_ID = ? and A.EFF_STATUS = 'E' and a.FACILITY_ID = b.FACILITY_ID (+) and a.AMB_VEHICLE_ID = b.AMB_VEHICLE_ID (+) and ( (? = 'M'  AND  'Y' = A.SUSPEND_MAINT_YN) OR  (? = 'A' and 'N' =  A.SUSPEND_MAINT_YN AND EXISTS (SELECT 'Y' FROM AE_AMB_OPEN_REQUEST WHERE FACILITY_ID = A.FACILITY_ID and AMB_VEHICLE_ID = A.AMB_VEHICLE_ID)  ) OR (? = 'B' and ('N' = A.SUSPEND_MAINT_YN AND NOT EXISTS (SELECT 'Y' FROM AE_AMB_OPEN_REQUEST WHERE FACILITY_ID = A.FACILITY_ID and AMB_VEHICLE_ID = A.AMB_VEHICLE_ID) ))) order by 1";

	String query2="select USER_DEFN_PAGE_ID,USER_DEFN_PAGE_DESC,DEFAULT_YN,USER_DEFN_MAIN_PAGE from AE_AMB_USER_DEFN_PAGE where APPL_USER_ID=? order by lower(USER_DEFN_PAGE_DESC) ";

	String query4="select count(*) from	AE_AMB_VEHICLE A, AE_AMB_OPEN_REQUEST B WHERE	a.FACILITY_ID = ? and A.EFF_STATUS = 'E' and a.FACILITY_ID = b.FACILITY_ID (+) and a.AMB_VEHICLE_ID = b.AMB_VEHICLE_ID (+) and ( (? = 'M'  AND  'Y' = A.SUSPEND_MAINT_YN) OR  (? = 'A' and 'N' =  A.SUSPEND_MAINT_YN AND EXISTS (SELECT 'Y' FROM AE_AMB_OPEN_REQUEST WHERE FACILITY_ID = A.FACILITY_ID and AMB_VEHICLE_ID = A.AMB_VEHICLE_ID)  ) OR (? = 'B' and ('N' = A.SUSPEND_MAINT_YN AND NOT EXISTS (SELECT 'Y' FROM AE_AMB_OPEN_REQUEST WHERE FACILITY_ID = A.FACILITY_ID and AMB_VEHICLE_ID = A.AMB_VEHICLE_ID) ))) order by 1";

	try{
        con = ConnectionManager.getConnection(request);

		/*pstmt = con.prepareStatement(query3); 
		pstmt.setString(1,facility_id);
		pstmt.setString(2,from_date);
		pstmt.setString(3,to_date);
		pstmt.setString(4,reqFlag);
		pstmt.setString(5,asnFlag);
		pstmt.setString(6,comFlag);
		pstmt.setString(7,canFlag);
		rs=pstmt.executeQuery();

		if(rs.next()){
			queTotal=rs.getInt(1);
		}*/

		/*pstmt = con.prepareStatement(query4); 
		pstmt.setString(1,facility_id);
		pstmt.setString(2,mFlag);
		pstmt.setString(3,aFlag);
		pstmt.setString(4,bFlag);

		rs=pstmt.executeQuery();

		if(rs.next()){
			chartTotal=rs.getInt(1);
		}*/

		
		/*if(pageString.equals("queNext")){
			queStart=queStart+6;
			if((queEnd+6)<queTotal)queEnd+=6; else queEnd=queTotal;
		}else if (pageString.equals("quePrev")){
			queStart=queStart-6;
			if(queEnd==queTotal)
				queEnd=(queTotal%6==0)?queEnd-6:queEnd-(queTotal%6);
			else
				queEnd-=6;
		}if(pageString.equals("chartNext")){
			chartStart=chartStart+6;
			if((chartEnd+6)<chartTotal)chartEnd+=6; else chartEnd=chartTotal;
		}else if (pageString.equals("chartPrev")){
			chartStart=chartStart-6;
			if(chartEnd==chartTotal) 
				chartEnd=(chartTotal%6==0)?chartEnd-6:chartEnd-(chartTotal%6);
			else
				chartEnd-=6;
		}else if(pageString.equals("")){
			/*if(queTotal<6)
				queEnd=queTotal;
			if(chartTotal<6)
				chartEnd=chartTotal;
		}*/

	
		pstmt = con.prepareStatement(query); 
		pstmt.setString(1,facility_id);
		pstmt.setString(2,from_date);
		pstmt.setString(3,to_date);
		pstmt.setString(4,reqFlag);
		pstmt.setString(5,asnFlag);
		pstmt.setString(6,comFlag);
		pstmt.setString(7,canFlag);
		if(!findTextTemp.equals("")){
			pstmt.setString(8,findTextTemp);
			pstmt.setString(9,findTextTemp);
			pstmt.setString(10,findTextTemp);
			pstmt.setString(11,findTextTemp);
			pstmt.setString(12,findTextTemp);
			pstmt.setString(13,findTextTemp);
			pstmt.setString(14,findTextTemp);
			pstmt.setString(15,findTextTemp);
			pstmt.setString(16,findTextTemp);
			pstmt.setString(17,findTextTemp);
			pstmt.setString(18,findTextTemp);
			pstmt.setString(19,findTextTemp);
			pstmt.setString(20,findTextTemp);
			pstmt.setString(21,findTextTemp);
			pstmt.setString(22,findTextTemp);
			pstmt.setString(23,findTextTemp);
			pstmt.setString(24,findTextTemp);
			pstmt.setString(25,findTextTemp);
			pstmt.setString(26,findTextTemp);
			pstmt.setString(27,findTextTemp);
			pstmt.setString(28,findTextTemp);
			pstmt.setString(29,findTextTemp);
		}
		//pstmt.setInt(8,queEnd);
		//pstmt.setInt(9,queStart);
		rs=pstmt.executeQuery();
		while(rs.next()){
			list.add(rs.getString("PATIENT_NAME"));	//-------------------------1
			list.add(rs.getString("AMB_CASE_BOOKED_DATE"));//------------------2       
			list.add(rs.getString("AMB_CASE_STATUS"));//-----------------------3
			list.add(rs.getString("PICKUP_LOCN_DESC"));//----------------------4
			list.add(rs.getString("destn_locn_desc"));//-----------------------5
			list.add(rs.getString("age"));//-----------------------------------6
			list.add(rs.getString("sex"));//-----------------------------------7
			list.add(rs.getString("pickup_address"));//------------------------8
			list.add(rs.getString("destn_address"));//-------------------------9
			list.add(rs.getString("amb_nature_call_code"));//------------------10
			list.add(rs.getString("amb_case_no"));//---------------------------11
			list.add(rs.getString("AMB_CASE_START_DATE"));//-------------------12
			list.add(rs.getString("AMB_CASE_END_DATE"));//---------------------13

			list.add(rs.getString("AMB_CALLER_NAME"));//-----------------------14
			list.add(rs.getString("AMB_CALLER_CONTACT_NO"));//-----------------15
			list.add(rs.getString("AMB_CALLER_REMARKS"));//--------------------16
			
			list.add(rs.getString("NATURE_CALL_DESC"));//-----------------------17
			list.add(rs.getString("AMB_PRIORITY_IND"));//-----------------------18
			list.add(rs.getString("AMB_START_MILEAGE"));//----------------------19
			list.add(rs.getString("AMB_END_MILEAGE"));//------------------------20
			list.add(rs.getString("AMB_DISP_REMARKS"));//-----------------------21

			list.add(rs.getString("CURRENT_LOCATION"));//-----------------------22
			list.add(rs.getString("AMB_VEHICLE_NAME"));//-----------------------23
			list.add(rs.getString("AMB_REGN_NO"));//----------------------------24
			list.add(rs.getString("AMB_LAST_MILEAGE"));//-----------------------25		
			
		}

		pstmt1=con.prepareStatement(query1);
		pstmt1.setString(1,facility_id);
		pstmt1.setString(2,mFlag);
		pstmt1.setString(3,aFlag);
		pstmt1.setString(4,bFlag);
		//pstmt1.setInt(5,chartEnd);
		//pstmt1.setInt(6,chartStart);
		rs1=pstmt1.executeQuery();
	
		while(rs1.next()){
			AmbChartDetList.add(rs1.getString("AMB_VEHICLE_ID"));
			AmbChartDetList.add(rs1.getString("AMB_VEHICLE_NAME"));
			AmbChartDetList.add(rs1.getString("AMB_REGN_NO"));
			AmbChartDetList.add(rs1.getString("AMB_MODEL_NO"));
			AmbChartDetList.add(rs1.getString("AMB_DATE_MANUFCT"));
			AmbChartDetList.add(rs1.getString("AMB_LAST_MILEAGE"));
			AmbChartDetList.add(rs1.getString("AMB_REMARKS"));
			AmbChartDetList.add(rs1.getString("AMB_STATUS"));
			AmbChartDetList.add(rs1.getString("AMB_CONT_NAME")==null?"":rs1.getString("AMB_CONT_NAME"));
			AmbChartDetList.add(rs1.getString("AMB_CONT_PHONE")==null?"":rs1.getString("AMB_CONT_PHONE"));
			AmbChartDetList.add(rs1.getString("AMB_VEHICLE_TYPE"));
			AmbChartDetList.add(rs1.getString("amb_Case_no"));
			AmbChartDetList.add(rs1.getString("Patient_dtls"));
			AmbChartDetList.add(rs1.getString("AMB_LOCATION")==null?"":rs1.getString("AMB_LOCATION"));
		}

		pstmt1=con.prepareStatement(query2);
		pstmt1.setString(1,user);
		rs1=pstmt1.executeQuery();

		boolean commaFlag=false;

		while(rs1.next() && rs1!=null){
			//defaultOrder=rs1.getString(4);
			if(!selOrder.equals("")){
				if(selOrder.equals(rs1.getString(1))){
					defaultOrder=rs1.getString(4);
					selOrderDesc=rs1.getString(2);
					selOrderId=selOrder;
				}
			}else{
				if((rs1.getString(3)==null?"":rs1.getString(3)).equals("Y")){
					defaultOrder=rs1.getString(4);
					selOrderDesc=rs1.getString(2);
					selOrderId=rs1.getString(1);
				}
			}

			if(commaFlag) clmnOrdrs.append(",");

			clmnOrdrs.append("{ text: '"+rs1.getString(2)+"', value: '"+rs1.getString(1)+"', onclick: { fn: onMenuItemClick } }");

			commaFlag=true;
			
		}
		ChkHiddenCols=props.getProperty("SystemDefault");
		if(defaultOrder==null) defaultOrder="";
		if(defaultOrder.equals("")){
			//clmnOrdrs.append("{ text: 'SystemDefault', value: 'SystemDefault', onclick: { fn: onMenuItemClick } }");
			selOrderDesc="System Defined";
			defaultOrder=ChkHiddenCols;
		
		}
	StringTokenizer stHdnCols=new StringTokenizer(ChkHiddenCols,",");
	StringTokenizer st=new StringTokenizer(defaultOrder,",");	
    int cNo=0;
	String strHdnCols="",strHdnColsVal="",str="",str1="",strAmbRequst="";
	ArrayList dbList=new ArrayList();

	while(st.hasMoreTokens()){	
		str=st.nextToken();
		dbList.add(str);
		str1=props.getProperty(str);
		//strAmbRequst=props.getProperty("AmbRequst_"+str);
		strAmbRequst=props.getProperty(str);
		if(cNo!=0) clDef.append(",");
		clDef.append(str1);
		if(cNo<4){
            if(cNo!=0) {fields1.append(",");clDef1.append(",");}
		
			if(str.equals("Status1"))
				fields1.append("{key:\""+str+"\",parser:\"myCustom\"}");
			else if(str.equals("RequestedDate") || str.equals("ambCaseStartDate") || str.equals("ambCaseEndDate"))
				fields1.append("{key:\""+str+"\",parser:\"YAHOO.widget.DataTable.formatDate\"}");
			else if(str.equals("ambStartMileage") || str.equals("ambEndMileage") ||  str.equals("ambLastMileage"))
				fields1.append("{key:\""+str+"\",parser:\"number\"}");
			else
				fields1.append("{key:\""+str+"\",parser:\"string\"}");
		
			//fields1.append("{key:\""+str+"\"}");
			clDef1.append(strAmbRequst);
		}
        cNo++;
	}
		
	if(cNo<22){
	while(stHdnCols.hasMoreTokens()){
		strHdnCols=stHdnCols.nextToken();
		if(!dbList.contains(strHdnCols)){	
			strHdnColsVal=props.getProperty("hidden_"+strHdnCols);	
			if(cNo!=0 && cNo!=22) clDef.append(",");					
			clDef.append(strHdnColsVal);				
			
			cNo++;
			}
			
		}
	}
	
	


	}catch(Exception e){
		//err_msg=java.net.URLEncoder.encode(e.toString());
		System.out.println("Exception in AmbulanceManagementSystemCode.jsp");
		e.printStackTrace();
		throw e;
	}
	finally {
		try{
			if(rs!=null) rs.close();
			if(rs1!=null) rs1.close();
			if( pstmt!=null ) pstmt.close(); 
			if( pstmt1!=null ) pstmt1.close(); 
			if( con!=null )
				ConnectionManager.returnConnection(con, request);
			rs=null;
			pstmt=null;
			rs1=null;
			pstmt1=null;
			con=null;
		}catch(Exception e){
			e.printStackTrace();			
		}
	}


	/*SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
	java.util.Calendar cal = java.util.Calendar.getInstance();
	to_date =sf.format(cal.getTime());
	cal.add(Calendar.DATE,-7);
	from_date=sf.format(cal.getTime());*/
	
	//ArrayList list=bean.getAmbulanceRequestDet();
	//ArrayList AmbChartDetList=bean.getAmbulanceChartDet(facility_id);

	
	
	for(int i=0;i<list.size();i+=25){

		patient_name		=	(String)list.get(i);
		reqtDate			=	(String)list.get(i+1);
		status				=	(String)list.get(i+2);
		pickup				=	list.get(i+3)==null?"":(String)list.get(i+3);
		drop				=	list.get(i+4)==null?"":(String)list.get(i+4);
		age					=	list.get(i+5)==null?"":(String)list.get(i+5);
		sex					=	list.get(i+6)==null?"":(String)list.get(i+6);
		pickupAddr			=	list.get(i+7)==null?"":(String)list.get(i+7);
		dropAddr			=	list.get(i+8)==null?"":(String)list.get(i+8);
		ambNatureCallCode	=	list.get(i+9)==null?"":(String)list.get(i+9);
		ambCaseNum			=	list.get(i+10)==null?"":(String)list.get(i+10);

		ambCaseStartDate	=	list.get(i+11)==null?"":(String)list.get(i+11);
		ambCaseEndDate		=	list.get(i+12)==null?"":(String)list.get(i+12);
		ambCallerName		=	list.get(i+13)==null?"":(String)list.get(i+13);
		ambCallerContNo		=	list.get(i+14)==null?"":(String)list.get(i+14);
		ambCallerRmrks		=	list.get(i+15)==null?"":(String)list.get(i+15);
		natureCallDesc		=	list.get(i+16)==null?"":(String)list.get(i+16);
		ambPriorityInd		=	list.get(i+17)==null?"":(String)list.get(i+17);
		ambStartMileage		=	list.get(i+18)==null?"":(String)list.get(i+18);
		ambEndMileage		=	list.get(i+19)==null?"":(String)list.get(i+19);
		ambDispRemarks		=	list.get(i+20)==null?"":(String)list.get(i+20);
		currentLocation		=	list.get(i+21)==null?"":(String)list.get(i+21);
		ambVehicleName		=	list.get(i+22)==null?"":(String)list.get(i+22);
		ambRegnNo			=	list.get(i+23)==null?"":(String)list.get(i+23);
		ambLastMileage		=	list.get(i+24)==null?"":(String)list.get(i+24);

		ambCallerRmrks=validateString(ambCallerRmrks);
		pickupAddr=validateString(pickupAddr);
		dropAddr=validateString(dropAddr);
		ambDispRemarks=validateString(ambDispRemarks);
		

		//cellData			=	cellData+"{Name:\""+patient_name+"\",RequestedDate:\""+reqtDate+"\",Status1:\""+status+"\",Pickup:\""+pickup+"\",Drop:\""+drop+"\",PickupAddress:\""+pickupAddr+"\",DropAddress:\""+dropAddr+"\",AmbNo:\""+ambCaseNum+"\",ambCaseStartDate:\""+ambCaseStartDate+"\",ambCaseEndDate:\""+ambCaseEndDate+"\",ambCallerName:\""+ambCallerName+"\",ambCallerContNo:\""+ambCallerContNo+"\",ambCallerRmrks:\""+ambCallerRmrks+"\",natureCallDesc:\""+natureCallDesc+"\",ambPriorityInd:\""+ambPriorityInd+"\",ambStartMileage:\""+ambStartMileage+"\",ambEndMileage:\""+ambEndMileage+"\",ambDispRemarks:\""+ambDispRemarks+"\",currentLocation:\""+currentLocation+"\",ambVehicleName:\""+ambVehicleName+"\",ambRegnNo:\""+ambRegnNo+"\",ambLastMileage:\""+ambLastMileage+"\"},";
		cellData			=	cellData+"{\"Name\":\""+truncate(patient_name,10)+"\",\"RequestedDate\":\""+reqtDate+"\",\"Status1\":\""+status+"\",\"Pickup\":\""+truncate(pickup,10)+"\",\"Drop\":\""+truncate(drop,10)+"\",\"PickupAddress\":\""+truncate(pickupAddr,11)+"\",\"DropAddress\":\""+truncate(dropAddr,14)+"\",\"AmbNo\":\""+ambCaseNum+"\",\"ambCaseStartDate\":\""+ambCaseStartDate+"\",\"ambCaseEndDate\":\""+ambCaseEndDate+"\",\"ambCallerName\":\""+truncate(ambCallerName,12)+"\",\"ambCallerContNo\":\""+truncate(ambCallerContNo,20)+"\",\"ambCallerRmrks\":\""+truncate(ambCallerRmrks,20)+"\",\"natureCallDesc\":\""+truncate(natureCallDesc,12)+"\",\"ambPriorityInd\":\""+ambPriorityInd+"\",\"ambStartMileage\":\""+truncate(ambStartMileage,15)+"\",\"ambEndMileage\":\""+truncate(ambEndMileage,15)+"\",\"ambDispRemarks\":\""+truncate(ambDispRemarks,20)+"\",\"currentLocation\":\""+currentLocation+"\",\"ambVehicleName\":\""+truncate(ambVehicleName,12)+"\",\"ambRegnNo\":\""+truncate(ambRegnNo,20)+"\",\"ambLastMileage\":\""+ambLastMileage+"\"},";

		

		//cellData1			=	cellData1+"{Name:\""+patient_name+"\",RequestedDate:\""+reqtDate+"\",Status2:\""+status+"\",Pickup:\""+pickup+"\",Drop:\""+drop+"\"},";
	}

	


	for(int i=0;i<AmbChartDetList.size();i+=14){
		ambVehicleID			=	(String)AmbChartDetList.get(i);
		ambVehicleName			=	(String)AmbChartDetList.get(i+1);
		ambRegnNo				=	AmbChartDetList.get(i+2)==null?"":(String)AmbChartDetList.get(i+2);
		ambModelNo				=	AmbChartDetList.get(i+3)==null?"":(String)AmbChartDetList.get(i+3);
		ambDateManf				=	AmbChartDetList.get(i+4)==null?"":(String)AmbChartDetList.get(i+4);
		ambLastMileage			=	AmbChartDetList.get(i+5)==null?"":(String)AmbChartDetList.get(i+5);
		ambRemarks				=	AmbChartDetList.get(i+6)==null?"":validateString((String)AmbChartDetList.get(i+6));
		ambStatus				=	(String)AmbChartDetList.get(i+7);
		ambContName				=   AmbChartDetList.get(i+8)==null?"":(String)AmbChartDetList.get(i+8);
		ambContPhone			=   AmbChartDetList.get(i+9)==null?"":(String)AmbChartDetList.get(i+9);
		ambType					=   AmbChartDetList.get(i+10)==null?"":(String)AmbChartDetList.get(i+10);

		 ambCaseNo=AmbChartDetList.get(i+11)==null?"":(String)AmbChartDetList.get(i+11);
		 ambPatDet=AmbChartDetList.get(i+12)==null?"&nbsp;":(String)AmbChartDetList.get(i+12);

		if(!ambContPhone.equals("")) ambContName=ambContName+"("+ambContPhone+")";
        
		ambDiv					=	ambStatus+"~"+ambType+"~"+AmbChartDetList.get(i+2)+"~"+AmbChartDetList.get(i)+"~"+AmbChartDetList.get(i+1)+"~"+AmbChartDetList.get(i+8)+"~"+AmbChartDetList.get(i+9)+"~"+ambCaseNo+"~"+ambPatDet+"~"+AmbChartDetList.get(i+13);
		
		
		cellData2			=cellData2+"{\"vehicleid\":\""+ambVehicleID+"\",\"vehiclename\":\""+truncate(ambVehicleName,30)+"\",\"regnno\":\""+truncate(ambRegnNo,20)+"\",\"modelno\":\""+truncate(ambModelNo,20)+"\",\"ambContname\":\""+truncate(ambContName,18)+"\",\"lastmileage\":\""+truncate(ambLastMileage,17)+"\",\"Status3\":\""+ambStatus+"\",\"ambtype\":\""+ambType+"\",\"ambDiv\":\""+ambDiv+"\"},";
	}
 


	cellData=(cellData.length()>0)?cellData.substring(0,cellData.length()-1):cellData;
	//cellData1=(cellData1.length()>0)?cellData1.substring(0,cellData1.length()-1):cellData1;
	cellData2=(cellData2.length()>0)?cellData2.substring(0,cellData2.length()-1):cellData2;
	cellData=cellData+"]}";
	cellData2=cellData2+"]}";
	

			

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
