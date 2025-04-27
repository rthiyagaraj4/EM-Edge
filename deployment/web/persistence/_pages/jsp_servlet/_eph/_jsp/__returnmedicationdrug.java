package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.lang.*;
import java.util.*;
import java.lang.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __returnmedicationdrug extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/ReturnMedicationDrug.jsp", 1740137896034L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n\t<head>\n\t\t<title></title>\n\t\t<!-- <link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/ReturnMedication.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<!--<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">-->\n\t<!-- <body topmargin=\"0\"> -->\n\t<body topmargin=\"0\" onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\t\t<form id=\"FormReturnMedicationDrug\" name=\"FormReturnMedicationDrug\" id=\"FormReturnMedicationDrug\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));</script> \n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<script>parent.retmedicationremarksframe.location.href=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\tparent.retmedicationplineframe.location.href=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";</script>\n\t\t\t\t\t<TABLE width=\"99%\" align=\"left\" cellspacing=0 cellpadding=0 border=1>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TH width=\"15%\" align=\"right\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="<input type=checkbox name=\"SelectAll\" id=\"SelectAll\" id=\"SelectAll\"  onClick=\"selectAll(this)\"></th ><TH >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t</th>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<!-- IF else condtions are Added for GHL_CRF-413.8 US001 start -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t<TD  class=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" align=\"right\">\n\t\t\t\t\t\t\t\t<INPUT TYPE=\"Checkbox\"  name=\"DrugSelect\"  id=\"check_id";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"  onClick=\"enableProceed(this)\">\n\t\t\t\t\t\t\t\t<input type=hidden name=\"drugid\"  id=\"drug_id";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"  value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t\t\t\t\t\t<input type=hidden name=\"barcodeid\"  id=\"barcode_id";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"  value=\"\">\n\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" align=\"right\">\n\t\t\t\t\t\t\t\t<INPUT TYPE=\"Checkbox\"  name=\"DrugSelect\" id=\"DrugSelect\"  onClick=\"enableProceed(this)\">\n\t\t\t\t\t\t\t\t<input type=hidden name=\"drugid\" id=\"drugid\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t<!-- IF else condtions are Added for GHL_CRF-413.8 US001 end -->\n\t\t\t\t\t\t\t\t<TD class=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="  style=\"font-family:verdana;font-size:8pt;\" >\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"font-size:xx-small;font-weight:normal\" >(";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =")</label>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t</TR>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n                        <input type=\"hidden\" name=\"total_count\" id=\"total_count\"value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">  \n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="   <!--  Added for GHL-CRF-413.8 end  --> \n\t\t\t\t\t</TABLE>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";</script>\n\t\t\t\t\t<TABLE width=\"100%\" align=\"right\" cellspacing=0 cellpadding=0 border=1>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TH width=\"15%\" align=\"right\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t<input type=checkbox name=\"SelectAll\" id=\"SelectAll\" id=\"SelectAll\"  onClick=\"selectAll(this)\"></th ><TH >";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t\t<!-- IF else condtions are Added for GHL_CRF-413.8 US001 start -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" align=\"right\">\n\t\t\t\t\t\t\t\t<INPUT TYPE=\"Checkbox\"  name=\"DrugSelect\" id=\"DrugSelect\" id=\"check_id";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"  onClick=\"enableProceed(this)\">\n\t\t\t\t\t\t\t\t<input type=hidden name=\"drugid\" id=\"drugid\" id=\"drug_id";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t\t\t\t\t\t<input type=hidden name=\"barcodeid\" id=\"barcodeid\" id=\"barcode_id";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"font-size:xx-small;font-weight:normal\" >(";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="   <!--  Added for GHL-CRF-413.8 end  --> \n\t\n\t\t\t\t\t</TABLE>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t<INPUT TYPE=\"hidden\" name=\"dispLocn\" id=\"dispLocn\" VALUE=\"\">\n\n\t\t</form>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );
	
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
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
09/05/2017      GHL-SCF-1193  IN064097  SOFIA       RTN_MED_NO is empty when encounterID not there
07/01/2021      TFS-12069	     Prabha         SKR-SCF-1551
---------------------------------------------------------------------------------------------------------------
*/ 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);

        request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

			//Search Criteria's from Query Criteria page
			String patientid		= request.getParameter( "patientid" );
			String drugcode			= request.getParameter( "drugcode" );
			String nationalid		= "" ;
			String healthcard     	= "";
			String dispno     		= request.getParameter( "dispno" ) ;
			String cutoff     		= request.getParameter( "cutoff" ) ;
			String orderid     		= request.getParameter( "orderid" ) ;
			String displocn     	= request.getParameter( "dispLocn" ) ;
			String FormStore     	=  CommonBean.checkForNull(request.getParameter( "FormStore" ));
			String eff_status     	=  CommonBean.checkForNull(request.getParameter( "eff_status" ));
			String Ward_Date_From     	=  CommonBean.checkForNull(request.getParameter( "Ward_Date_From" ));
			String ward_Date_To     	=  CommonBean.checkForNull(request.getParameter( "ward_Date_To" ));
			String From_Location     	=  CommonBean.checkForNull(request.getParameter( "From_Location" ));
			String encounter_id		=  CommonBean.checkForNull(request.getParameter( "encounter_id" ));
			String medn_rtn_after_bill_gen	=  CommonBean.checkForNull(request.getParameter( "medn_rtn_after_bill_gen" ));
			String blDocType	=  CommonBean.checkForNull(request.getParameter( "blDocType" )); //added for MMS-DM-CRF-0039 [IN:055958]
			String blDocNo	=  CommonBean.checkForNull(request.getParameter( "blDocNo" )); //added for MMS-DM-CRF-0039 [IN:055958]
			String patcat     		= request.getParameter( "patcat" ) ;
			java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
			String bean_id		= "ReturnMedicationBean"+login_at_ws_no ;
			String bean_name	= "ePH.ReturnMedicationBean";
			int count1=1; // Added for GHL_CRF-413.8 US001
			/* Initialize Function specific start */
			ReturnMedicationBean bean = (ReturnMedicationBean)getBeanObject( bean_id,bean_name,request) ;
			String barcode_applicable=bean.getBarCodeflag((String)session.getValue("facility_id"), displocn);//"Y"; // Added for GHL_CRF-413.8 US001
			//Added for GHL-SCF-1193 Start
			bean.clearRetnMednNo();
			//Added for GHL-SCF-1193 End
			if(patientid.equals("")){
				patientid=(String)bean.getPatient_ID(dispno);
			}
			bean.clearSavedList();//added for GHL-CRF-0413.8
			bean.setFromStore(FormStore);
			bean.setEffstatus(eff_status);
			//Bru-HIMS-CRF-091 & SPIR-IN029957 -- Added Facility_Flag for MutiFacility
			String FacilityFlag=bean.getFacility_Flag();
			if(FacilityFlag.equals("")){
				FacilityFlag="N";	
			}
			if(!(FacilityFlag.equals("Y"))){ 
				ArrayList drugDetails=bean.getDrugDetails(patientid,drugcode,nationalid,healthcard,dispno,cutoff,orderid,FormStore,patcat,encounter_id,locale,medn_rtn_after_bill_gen, blDocType, blDocNo, displocn);//code medn_rtn_after_bill_gen added for FD-JD-CRF-0178[IN039208] // blDocType, blDocNo added for MMS-DM-CRF-0039 [IN:055958] //displocn added for SKR-SCF-1551
				//	out.println(drugDetails);
				// FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility
				if (drugDetails==null || drugDetails.size()==0){

            _bw.write(_wl_block10Bytes, _wl_block10);

				}
				else{	   
					/*	out.println(drugDetails.get(0));
					if (5==5){
					  return;
					}*/
					
					ArrayList patientDetails=new ArrayList();
					patientDetails=bean.getPatientDetails(patientid);
					String remarksUrl="../../ePH/jsp/ReturnMedicationRemarks.jsp?"+request.getQueryString();
					String patientUrl="../../ePH/jsp/ReturnMedicationPatientDetails.jsp?patient_id="+patientid+"&patient_name="+patientDetails.get(0)+"&sex="+patientDetails.get(1)+"&age="+patientDetails.get(2)+"&dispno="+dispno;

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(remarksUrl));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patientUrl));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

						int rowCount=0;
						String classvalue="";
						int rc=drugDetails.size();
						for (int i=0;i<drugDetails.size();i+=3){ //Incremented from 2 to 3 for AMS-SCF-0190 IN038440 . 
							if ( rowCount++ % 2 == 0 ){
								classvalue = "QRYEVEN" ;
							}
							else{
								classvalue = "QRYODD" ;
							}

            _bw.write(_wl_block16Bytes, _wl_block16);
if(barcode_applicable.equals("Y")){ 
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(drugDetails.get(i)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{ 
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drugDetails.get(i)));
            _bw.write(_wl_block24Bytes, _wl_block24);

								}
							
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(drugDetails.get(i+1)));
            _bw.write(_wl_block2Bytes, _wl_block2);

								if(bean.getTradeName_Flag().equals("Y") && (drugDetails.get(i+2)!=null && !drugDetails.get(i+2).equals(""))){ //added for AMS-SCF-0190 IN038440

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(drugDetails.get(i+2) ));
            _bw.write(_wl_block28Bytes, _wl_block28);

								}

            _bw.write(_wl_block29Bytes, _wl_block29);
                      // Added for GHL-CRF-413.8 Start
						if(barcode_applicable.equals("Y")){ 
	                        count1++; 
	                     } // Added for GHL-CRF-413.8 end
						}
						  // Added for GHL-CRF-413.8 Start
						if(barcode_applicable.equals("Y")){ 

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(count1-1));
            _bw.write(_wl_block31Bytes, _wl_block31);
}  
            _bw.write(_wl_block32Bytes, _wl_block32);

				}	// FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility - start
			}
			else if(FacilityFlag.equals("Y")){ 
				ArrayList drugDetails=bean.getDrugDetails(patientid,drugcode,nationalid,healthcard,dispno,cutoff,orderid,FormStore,patcat,encounter_id,locale,medn_rtn_after_bill_gen, blDocType, blDocNo, displocn);//code medn_rtn_after_bill_gen added for FD-JD-CRF-0178[IN039208]  // blDocType, blDocNo added for MMS-DM-CRF-0039 [IN:055958] //displocn added for SKR-SCF-1551
				//	out.println(drugDetails);
				if (drugDetails.size()==0){

            _bw.write(_wl_block10Bytes, _wl_block10);

				}
				else{	   
					/*out.println(drugDetails.get(0));
					if (5==5){
					  return;
					}*/
					
					ArrayList patientDetails=new ArrayList();
					patientDetails=bean.getPatientDetails(patientid);
					String remarksUrl="../../ePH/jsp/ReturnMedicationRemarks.jsp?"+request.getQueryString();
					String patientUrl="../../ePH/jsp/ReturnMedicationPatientDetails.jsp?patient_id="+patientid+"&patient_name="+patientDetails.get(0)+"&sex="+patientDetails.get(1)+"&age="+patientDetails.get(2)+"&dispno="+dispno;

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(remarksUrl));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patientUrl));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

						int rowCount=0;
						String classvalue="";
						for (int i=0;i<drugDetails.size();i+=3){// Incremented from 2 to 3 for AMS-SCF-0190-IN038440 .
							if ( rowCount++ % 2 == 0 ){
								classvalue = "QRYEVEN" ;
							}
							else{
								classvalue = "QRYODD" ;
							}

            _bw.write(_wl_block35Bytes, _wl_block35);
if(barcode_applicable.equals("Y")){ 
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(drugDetails.get(i)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{ 
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drugDetails.get(i)));
            _bw.write(_wl_block24Bytes, _wl_block24);

								}
							
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(drugDetails.get(i+1)));
            _bw.write(_wl_block2Bytes, _wl_block2);

									if(bean.getTradeName_Flag().equals("Y") && (drugDetails.get(i+2)!=null && drugDetails.get(i+2).equals(""))){ //AMS-SCF-0190-IN038440 Trade Name set based on flag.

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(drugDetails.get(i+2) ));
            _bw.write(_wl_block28Bytes, _wl_block28);

									}

            _bw.write(_wl_block29Bytes, _wl_block29);

//Added for GHL-CRF-413.8 Start
if(barcode_applicable.equals("Y")){ 
    count1++; 
 } // Added for GHL-CRF-413.8 end
}

	if(barcode_applicable.equals("Y")){ //If condtion added for GHL-CRF-0413.8

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(count1-1));
            _bw.write(_wl_block31Bytes, _wl_block31);
}  
            _bw.write(_wl_block40Bytes, _wl_block40);

				}
			}	// FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility - End

            _bw.write(_wl_block41Bytes, _wl_block41);
 
		putObjectInBean(bean_id,bean,request); 

            _bw.write(_wl_block42Bytes, _wl_block42);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }
}
