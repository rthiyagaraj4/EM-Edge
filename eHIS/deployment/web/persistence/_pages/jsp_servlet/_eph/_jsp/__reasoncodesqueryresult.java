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
import eCommon.Common.*;
import java.util.*;

public final class __reasoncodesqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/ReasonCodesQueryResult.jsp", 1709121369111L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <!--This file is saved on 07/11/2005-->\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html> \n\t<head> \n\t\t<title></title>\n\t\t<!-- <link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" SRC=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/ReasonCodes.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t\t\t<tr>\n\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t\t<td width=\"20%\" class=\"white\">&nbsp;\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t</td></tr>\n\t\t\t</table>\n\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n\t\t\t\t<th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th><th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t<tr >\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"reason_code";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" id=\"reason_code";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" ><font class=\'HYPERLINK\' onmouseover=\"changeCursor(this);\" onClick=\"Modify(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\')\">  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font></td>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" onclick=\"disableClick(event); \" align=\"center\">\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));history.go(-1);</script>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

		public String getImage(String value){
			if(value.equalsIgnoreCase("E"))
				return "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='E'>";
			else
				return "<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='D'>";
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

/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
22/11/2019      IN059899        PRATHYUSHA                          JD-CRF-0200
08/06/2020      IN:072715       Haribabu                            MMS-DM-CRF-0165       
------------------------------------------------------------------------------------------------------------------------------- 
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

         request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		//Search Criteria's from Query Criteria page
		String appl_trn_type= request.getParameter( "appl_trn_type" ) ;
		String reason_code	= request.getParameter( "reason_code" ) ;
		String reason_desc	= request.getParameter( "reason_desc" ) ;
		String eff_status	= request.getParameter( "eff_status" ) ;

		//String ord[]			= request.getParameterValues("orderbycolumns");
		boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
		try{
			String classvalue			= "";

			appl_trn_type= CommonBean.checkForNull( appl_trn_type );
			reason_code  = CommonBean.checkForNull( reason_code );
			reason_desc	 = CommonBean.checkForNull( reason_desc );
			eff_status	 = CommonBean.checkForNull( eff_status );

			if (eff_status.equals("B")){
				eff_status="";
			}

			//Common parameters.
			HashMap sqlMap = new HashMap();
			//include all the common parameters.
			sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_REASON_CODES_SELECT2"));
			
			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields are going to be display
			ArrayList displayFields = new ArrayList();

			displayFields.add( "APPL_TRN_TYPE" );
			displayFields.add( "REASON_CODE" );
			displayFields.add( "REASON_DESC" );
			displayFields.add( "EFF_STATUS" );

			ArrayList chkFields = new ArrayList();
			chkFields.add( appl_trn_type.trim() );
			chkFields.add( reason_code.trim() + "%" );
			chkFields.add( reason_desc.trim() + "%" );
			chkFields.add( eff_status.trim() );
			chkFields.add(locale);
			
			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );

			//Calling the Result from Common Adaptor as a arraylist.
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
			
			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){

            _bw.write(_wl_block9Bytes, _wl_block9);

				// For display the previous/next link
				out.println(result.get(1));

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

					//Retriving the records from result arraylist
					ArrayList records=new ArrayList();
					for(int recCount=2; recCount<result.size(); recCount++) {
						if ( recCount % 2 == 0 )
							classvalue = "QRYODD" ;
						else
							classvalue = "QRYEVEN" ;

            _bw.write(_wl_block13Bytes, _wl_block13);

							records=(ArrayList) result.get( recCount );
							for(int colCount=0; colCount<records.size(); colCount++){
								if(colCount==1){ 

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(records.get( colCount )));
            _bw.write(_wl_block17Bytes, _wl_block17);

								}
								else if(colCount==0 || colCount==2){
									String dkVal = (String)records.get( colCount );
									
									if (dkVal.equals("R"))
										  dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MedicationReissue.label","ph_labels");
									else if (dkVal.equals("T")){
										  dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.MedicationReturn.label", "ph_labels");
									}else if (dkVal.equals("H")){
										  dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.MedicationHold.label", "ph_labels");
									}
									else if (dkVal.equals("A")){ 
										 dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Allocation.label", "ph_labels");
									}
									else if (dkVal.equals("F")){
										 dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Filling.label", "ph_labels");
									}
									else if (dkVal.equals("D")){
										 dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Delivery.label", "ph_labels");
									}
									else if (dkVal.equals("O")){
										 dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AmendOrder.label", "ph_labels");
									}
									else if (dkVal.equals("M")){
										 dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Administration.label", "ph_labels");
									}
									else if (dkVal.equals("RP")){
										 dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ReleaseBatchPatient.label", "ph_labels");
									}
									else if (dkVal.equals("RO")){
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ReleaseBatchOthers.label", "ph_labels");
									}
									else if(dkVal.equals("TD")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TDMOrder.label", "ph_labels");
									}
									else if(dkVal.equals("RR")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ReroutePrescription.label", "ph_labels");
									}
									else if(dkVal.equals("CO")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.CompleteOrder.label", "ph_labels");
									}
									else if(dkVal.equals("OB")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverRideBMS.label", "ph_labels");
									}
									else if(dkVal.equals("BR")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.BalanceMedicationRemarks.label", "ph_labels");
									}
									//Added elseif  condition for the incident number 22509 on 7/july/2010--Sandhya
									else if(dkVal.equals("E")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ADRReason.label", "ph_labels");
									}
									else if(dkVal.equals("CN")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.CancelNPBRequest.label", "ph_labels");
									} 
									else if(dkVal.equals("AI")) { //code added for HSA-CRF-0005[40601] --Start 
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ADRInErrorReason.label", "ph_labels");
									}
									else if(dkVal.equals("AC")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ADRCancelReason.label", "ph_labels");
									}//code added for HSA-CRF-0005[40601] --End
									else if(dkVal.equals("CM")) {//added for JD-CRF-0200
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.CancelMarAdminstration.label", "ph_labels");
									}
									else if(dkVal.equals("MR")) {//added for MMS-KH-CRF-0010
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.MarAdminstrationRemarks.label", "ph_labels");
									}
									//Added for IN:072715 start
									else if(dkVal.equals("AO")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AllergyOverrideReason.label", "ph_labels");
									}
									else if(dkVal.equals("BD")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.BeyondDoseLimitOverrideReason.label", "ph_labels");
									}
									else if(dkVal.equals("DP")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DuplicateDrugOverrideReason.label", "ph_labels");
									}
									else if(dkVal.equals("DD")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Drug-DrugInteractionOverrideReason.label", "ph_labels");
									}
									else if(dkVal.equals("DF")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Drug-FoodInteractionOverrideReason.label", "ph_labels");
									}
									else if(dkVal.equals("DL")) {

																				dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Drug-LabInteractionOverrideReason.label", "ph_labels");
									}else if(dkVal.equals("DI")) {//Added for MMS-DM-CRF-0229
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Drug-DiseaseOverrideReason.label", "ph_labels");
									}
									//Added for IN:072715 end
									else if(dkVal.equals("NP")) {
											dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NotPreferedItemRemarks.label","ph_labels");
									}
	                 								
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(records.get( 0 )));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(records.get( 1 )));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dkVal));
            _bw.write(_wl_block22Bytes, _wl_block22);

								}	
								else {		
									String fieldValue=((String)records.get( colCount ));
									String dkVal =fieldValue ;

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block23Bytes, _wl_block23);

									out.println(getImage(dkVal));
									out.println("</td>");
								}
							}

            _bw.write(_wl_block24Bytes, _wl_block24);

					}

            _bw.write(_wl_block25Bytes, _wl_block25);

				out.flush();
			}
			else{

            _bw.write(_wl_block26Bytes, _wl_block26);

			}
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/ReasonCodesQueryResult.jsp", searched) );
		}
		catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
		}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block27Bytes, _wl_block27);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ApplicableTransaction.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonDescription.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Nature.label", java.lang.String .class,"key"));
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
}
