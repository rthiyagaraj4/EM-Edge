package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCA.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __geneticmarkersdisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/GeneticMarkersDisplay.jsp", 1742453840801L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n<head>\n\t ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCA/js/ResearchPatient.js\" language=\"javascript\"></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/CACommon.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n <!-- 37866 -->\n<script>\n\tasync function ImmunizationDetails(){\n\t\tvar queryString = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";//document.refForm.queryString.value;\n\t\tvar dialogHeight= \"60vh\" ;\n\t\tvar dialogWidth\t= \"60vw\" ;\n\t\tvar status = \"no\";\n\t\tvar arguments\t= \"\" ;\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=auto;  status:\" + status;\n\tawait\twindow.showModalDialog(\"../../eCA/jsp/Immunization.jsp?\"+queryString,arguments,features);\n\t\treturn false;\n\t}\n\n\tasync function researchPatient(){\n\t\tvar queryString = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";//document.refForm.queryString.value;\n\t\tvar dialogHeight= \"60vh\" ;\n\t\tvar dialogWidth\t= \"60vw\" ;\n\t\tvar status = \"no\";\n\t\tvar arguments\t= \"\" ;\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=yes;  status:\" + status;\n\t\tawait window.showModalDialog(\"../../eCA/jsp/ResearchPatient.jsp?\"+queryString,arguments,features);\n\t\treturn false;\n\t}\n\n\tasync function growthChart(chart_id,P_patient_id,sex){\n\t\tvar queryString = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";//document.refForm.queryString.value;\n\t\tvar dialogHeight= \"80vh\" ;\n\t\tvar dialogWidth\t= \"80vw\" ;\n\t\tvar status = \"no\";\n\t\tvar arguments\t= \"\" ;\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=yes;  status:\" + status;\n\tawait \twindow.showModalDialog(\"../../eCA/jsp/ChartRecordingGroupGraphMain.jsp?splChartType=GR&chart_id=\"+chart_id+\"&patient_id=\"+P_patient_id+\"&Sex=\"+sex,arguments,features);\n\t\treturn false;\n\t}\n/*\tasync function TriageDetail(){\n\t\tvar queryString = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\tvar dialogHeight= \"60vh\" ;\n\t\tvar dialogWidth\t= \"60vw\" ;\n\t\tvar status = \"no\";\n\t\tvar arguments\t= \"\" ;\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no;  status:\" + status;\n\t\tawait window.showModalDialog(\"../../eCA/jsp/TriageDetail.jsp?\"+queryString,arguments,features);\n\t\treturn false;\n\t}*/\n\tasync function TriageDetail(patient_id,encounter_id,visit_adm_date_time)\n\t{\n\t\t\n\t     var retVal = \"\";\n\t\t\tvar function_id =\"query\";\n\t\t\tvar dialogHeight= \"95vh\" ;\n\t\t\tvar dialogWidth\t= \"95vw\" ;\n\t\t\tvar dialogTop =\"\";\n\t\t\tvar status = \"no\";\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ;dialogTop:\" + dialogTop + \";scroll=no; status:\" + status;\n\t\t\tvar action_url\t\t=\t\"../../eAE/jsp/AESecondaryTriageHistoryMain.jsp?patient_id=\"+patient_id+\"&episode_id=\"+encounter_id+\"&rec_date_time=\"+visit_adm_date_time+\"&function_id=\"+function_id;//IN054712 Changed key visit_adm_date_time to rec_date_time\n\t\t\tretVal = await top.window.showModalDialog(action_url,arguments,features);\n\t}\n\t//IN063885 start\n\tfunction displayMRReports(p_patient_id,p_encounter_id,p_facility_id,p_note_type)\n\t{\t\n\t\tvar queryString = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\tvar retVal=\"\";\n\t\tvar p_report_id=\"CABMEDRPT\";\n\t\tvar p_module_id=\"CA\";\n\t\tvar dialogHeight\t= \"10\" ;\n\t\tvar dialogWidth\t= \"30\" ;\n\t\tvar status = \"no\";\n\t\tvar scroll = \"yes\";\n\t\tvar dialogTop = \"140\";\n\t\tvar arguments\t= \"\" ;\n\t\t\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\"+ dialogTop + \"; status:\"+ status + \"; scroll:\"+ scroll;\t\n\t\t\n\t\tvar params = \"&p_report_id=\"+p_report_id+\"&p_module_id=\"+p_module_id+\"&p_facility_id=\"+p_facility_id;\n\t\t\n\t\tdocument.GenMarkersDispForm.action = \"../../eCommon/jsp/report_options.jsp?p_note_type=\"+p_note_type+\"&p_patient_id=\"+p_patient_id+\"&p_encounter_id=\"+p_encounter_id+params;\n\t\tdocument.GenMarkersDispForm.submit();\n\n\t}\n\t//IN063885 end \n\t//28906 starts\n\tasync function PhenotypeDetails(){\n\t\tvar queryString = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\tvar dialogHeight= \"18\" ;\n\t\tvar dialogWidth\t= \"45\" ;\n\t\tvar status = \"no\";\n\t\tvar arguments\t= \"\" ;\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=auto;  status:\" + status;\n\t\tawait window.showModalDialog(\"../../eCA/jsp/PhenotypeDetails.jsp?\"+queryString,arguments,features);\n\t}\n\t//28906 ends\n</script>\t\n</head>\n\n<body class=\'CONTENT\'  OnMouseDown=\"CodeArrest()\" onLoad=\"\" onKeyDown=\"lockKey()\">\n<!--IN063885 start-->\n<!--<form name=\'\' id=\'\' method=post target=\"messageFrame\">-->\n<form name=\'GenMarkersDispForm\' id=\'GenMarkersDispForm\' method=post target=\"messageFrame\">\n<!--IN063885 end-->\n</form>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t<table  width=\'100%\' style=\"\" border=0 valign=\'top\' CELLSPACING=0 CELLPADDING=3 align=\'center\'>\n     <tr>\n        <td  width=\'30%\' style=\'CAENCOUNTERLINE\'><font size=\'-1\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td><!-- IN057106_changed -->\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<td  width=\'20%\' style=\'CAENCOUNTERLINE\'  ><a class=\'gridLink\' href=\"javascript:getAntibodyResults(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\"><font size=\'2\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</font></a></td>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<td  width=\'20%\' style=\'CAENCOUNTERLINE\'  >&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<td  width=\'10%\' style=\'CAENCOUNTERLINE\'  ><a class=\'gridLink\' href=\'#\' onClick=\'return ImmunizationDetails()\'><font size=\'2\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</font></a></td>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<td width=\'10%\' style=\'CAENCOUNTERLINE\' style=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"><a class=\'gridLink\' href=\'#\' onClick=\'return researchPatient()\'><font size=\'2\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</font></a></td>\n\t\t<td  width=\'10%\' style=\'CAENCOUNTERLINE\' ALIGN=\'right\' style=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"><a class=\'gridLink\' href=\'#\' onClick=\"return growthChart(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</font>&nbsp;&nbsp;</font></a></td>\n\t\t\n\t\t<td  width=\'10%\' style=\'CAENCOUNTERLINE\'  style=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"><a class=\'gridLink\' href=\'#\' onClick=\"return TriageDetail(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font></a></td><!--IN054712 Chnaged visit_date_time to recorded_date_time-->\n\n\t\t<!-- Bru-HIMS-0154 starts -->\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<td  width=\'17%\' style=\'CAENCOUNTERLINE\' nowrap ><a class=\'gridLink\' href=\'#\' onClick=\"return showFutureAppointments(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</font></a></td>\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t<!-- Bru-HIMS-0154 Ends -->\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t<td  width = \'10%\' style=\'CAENCOUNTERLINE\' >\n\t\t\t<img  src=\"../../eCA/images/virtualConsultation.png\" title=\"Virtual Consultation\" onClick=\"virtualConsultation(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\');\"/>\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" <!-- 70705 Start\t -->\t\n\t\t<td  width=\'10%\' style=\'CAENCOUNTERLINE\' nowrap ><a class=\'gridLink\' href=\'#\' onClick=\"return menstHistDtl(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\', \'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="<!-- 70705 End -->\n\t\t<td  width = \'10%\' style=\'CAENCOUNTERLINE\' >\n\t\t<a class=\'gridLink\' href=\'javascript:refresh();\'><font size=\'2\'><U>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</U></font></a></td>\n\t\t<!-- IN045536 - Start -->\n\t\t<!--IN063885  start-->\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t<td  width = \'10%\' style=\'CAENCOUNTERLINE\'style = \'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t\t<a class=\'gridLink\' href=\"javascript:displayMRReports(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\')\"><font size=\'2\'><U>MR Reports</U></font></a>\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t<!--IN063885 end-->\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t<td  width=\'10%\' style=\'CAENCOUNTERLINE\' ><font size = \"2\"  color=red>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</font> </td> <!-- IN050593 -->\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\t\t\t\n\t\t\t\t<td  width=\'10%\' style=\'CAENCOUNTERLINE\'  nowrap><a class=\'gridLink\' href= # onClick=\"return MDSCompliance(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\')\" name=\'mindata\'><font size = \"2\" color=red><U> ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" </U></font></a></td> <!-- IN050593 -->\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t<!-- IN045536 - End -->\t\n      </tr>\n     </table>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );
	
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

/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	created
19/03/2012	  Bru-HIMS-0154	 Menaka V	 	The View Future Bookings/Appointments hyperlink will be visible for the patient in Chart summary
											only if the patient has got any future bookings/Appointments.		
24/12/2012	  ML-BRU-SCF-0373	Karthi L	The View Future Bookings/Appointments hyperlink will be visible for the patient in Chart summary
											only if the patients has got any future bookings/Appointments. Currently past
											appointments also display this hyperlink for radiology appointment patients..
-----------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------
27/06/2014	  IN045536		Karthi L	27/06/2014		Akbar				To provide a visual indication for the clinician to indicate the minimum data set is met/not met and the ability for the clinician to check what is pending (similar to the check already provided).											
19/08/2014	  IN050593		Karthi L	19/08/2014		Akbar				 The Label should be ?MDS Criteria Met? and ?MDS Criteria Not Met?.
26/03/2014    IN054712		Nijitha S	 									 System displays the priority zone inconsistently.
09/01/2016	IN057106		Vijayakumar K	09/01/2016		Ramesh Goli		ML-MMOH-CRF-0328 [IN:057106]
14/01/2016	IN058872		Vijayakumar K	14/01/2016		Ramesh goli	 	ML-MMOH-CRF-0328/01 - System doesn't display a 
																			new Field ?Antibody? in Patient Chart Screen beside Rh Factor field with no value [IN:058872]
20/01/2016	IN058921		Vijayakumar K	20/01/2016		Ramesh Goli		ML-MMOH-CRF-0328/02 - System doesn't display 
																			Antibody values in Bold, Antibody description is wrong. [IN:058921]
29/02/2016	IN057106_changed Vijayakumar K	29/02/2016		Ramesh Goli		ML-MMOH-CRF-0328
06/08/2018  IN063885         Ramya Maddena  07/08/2018      Ramesh Goli     MMS-DM-CRF-0103
15/04/2023		37866			Ramesh G									MMS-DM-CRF-0226
22/09/2023	28906	   Ranjith P R		25/07/2023		RAMESH G		ML-MMOH-CRF-1846.1
04/11/2024	70705	   Gunasekar R		05/11/2024		 Ashwini Ragupathi  ML-MMOH-CRF-1759
---------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block4Bytes, _wl_block4);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block12Bytes, _wl_block12);

	
	String P_patient_id = request.getParameter("patient_id");
	String sex = request.getParameter("Sex");
	String encounter_id = request.getParameter("encounter_id");
	if (encounter_id==null) encounter_id="";
	//37866 Start.
	String episode_type = request.getParameter("episode_type");
	String clinicianId =(String)session.getValue("ca_practitioner_id");
	if(clinicianId == null) clinicianId="";
	//37866 End.
	String visit_adm_date = request.getParameter("visit_adm_date");
	if (visit_adm_date==null) visit_adm_date="";
	String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	StringBuffer strBuff_display = new StringBuffer();
	strBuff_display.append("&nbsp;");
	//String display = "&nbsp;"; 
	String blood_grp ="";
	String rh_factor ="";

	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	String facilityId = (String)session.getValue("facility_id"); //IN045536 
	int mds_chk_cnt = 0; // IN045536 
	String mr_mds_recorded_yn = "";	 // IN045536 
	int iTotalNoOfAntibody = 0; //IN057106_changed

	String research_pat_sql ="";
	String display_mode = "";
	String triage_display_mode = "display:none";
	int count = 0 ;

	String grChSql ="";
	String chart_id ="";
	String grChart_display_mode = "display:none";

	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rset=null ;


	PreparedStatement res_pstmt=null;
	ResultSet res_rset=null ;
	if (patient_class.equals("EM") )
			triage_display_mode ="display";
    String recorded_date_time = "";	//IN054712	
	//IN057106 starts
	String AbMarkerSQL = "";
	PreparedStatement ab_pstmt=null;
	ResultSet ab_rsltset=null ;
	//IN057106 ends
	//IN063885 start
	String p_facility_id = (String)session.getValue("facility_id");			
	String sql_note_type = "";
	String p_note_type = "";
	String MRReportHypLnkYNSql = "";
	String mr_rpt_hyp_yn = "";
	String mr_rpt_hyp_yn_style = "";
	Boolean isMRReportappl = false; //IN063885
	PreparedStatement pstmt_note_type = null;
	PreparedStatement mr_rpt_hyp_yn_pstmt = null;
	ResultSet rs_note_type = null ;
	ResultSet mr_rpt_hyp_yn_rsltset = null;
	//IN063885 ends
try
{
		//IN063885 Start.
		ArrayList<String> functionIds = new ArrayList<String>();
		functionIds.add("PAT_MED_REPT");
		String bean_id = "CA_ca_patListbylocationresult" ;
		String bean_name = "eCA.PatListByLocationResult";
		PatListByLocationResult bean = (PatListByLocationResult)getObjectFromBean( bean_id, bean_name, session ) ;
		bean.setSiteSpecific(functionIds,"CA");
		isMRReportappl = bean.isSiteSpecific("PAT_MED_REPT");
		//IN063885 End.
        con=ConnectionManager.getConnection(request);
		boolean isVirtualConsSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION"); //37866
		boolean isPhenotypeSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","PHENOTYPE_DETAILS"); //28906
		//IN054712 Starts
		String rec_dt_time_qry = "select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI:SS')  recorded_date_time from ae_pat_emergency_detail a where a.FACILITY_ID=? and a.ENCOUNTER_ID=?";
		res_pstmt=con.prepareStatement(rec_dt_time_qry);
		res_pstmt.setString(1,facilityId );
		res_pstmt.setString(2,encounter_id );
		res_rset=res_pstmt.executeQuery();
		while(res_rset.next())
		{
			recorded_date_time = res_rset.getString("recorded_date_time");
		}
		if(res_rset != null)res_rset.close();
		if(res_pstmt != null)res_pstmt.close();	
		//IN054712 Ends
		
		grChSql = "select CHART_ID from CA_SPL_CHART_PAT_REC_DTL where patient_id=? and rownum=1";
		res_pstmt=con.prepareStatement(grChSql);
		res_pstmt.setString(1,P_patient_id );

		res_rset=res_pstmt.executeQuery();

		while(res_rset.next())
		{
			chart_id = res_rset.getString("CHART_ID");
			grChart_display_mode = "display";
		}
		if(res_rset != null)res_rset.close();
		if(res_pstmt != null)res_pstmt.close();	
		
		String virtualApptYN="N";
		if(patient_class.equals("OP")){
			res_pstmt=con.prepareStatement("SELECT oa_appt_virtual_status(?,?,?,?) virtualApptYN FROM DUAL");
			res_pstmt.setString(1,facilityId );
			res_pstmt.setString(2,P_patient_id );
			res_pstmt.setString(3,encounter_id );
			res_pstmt.setString(4,patient_class );
			
			res_rset=res_pstmt.executeQuery();

			while(res_rset.next())
			{
				virtualApptYN = res_rset.getString("virtualApptYN");
			}
			if(res_rset != null)res_rset.close();
			if(res_pstmt != null)res_pstmt.close();
		}

		research_pat_sql = "SELECT COUNT(*) as total FROM CA_RESEARCH_PATIENT_DETAIL WHERE  PATIENT_ID=?";
		res_pstmt=con.prepareStatement(research_pat_sql);
		res_pstmt.setString(1,P_patient_id );

		res_rset=res_pstmt.executeQuery();

		while(res_rset.next())
		{
			count = res_rset.getInt("total");
		}
		if(res_rset != null)res_rset.close();
		if(res_pstmt != null)res_pstmt.close();
		
		if(count>0)
		  {
			display_mode="display";
		  }
		  else
			{
			  display_mode="display:none";
		  }

		
		//String sql = "SELECT C.SHORT_DESC blood_grp, b.short_desc    rh_factor,a.g6pd_marker g6pd, a.sicc_marker sicc FROM MP_PAT_OTH_DTLS A,     MR_RHESUS_FACTOR B, MR_BLOOD_GRP C WHERE PATIENT_ID = ? and a.rh_factor = b.RHESUS_FACTOR_CODE(+) and a.blood_grp = c.blood_grp(+)" ;

		String sql = "SELECT C.SHORT_DESC blood_grp, b.short_desc    rh_factor,a.g6pd_marker g6pd, a.sicc_marker sicc FROM MP_PAT_OTH_DTLS A,     MR_RHESUS_FACTOR B, MR_BLOOD_GRP_LANG_VW C WHERE PATIENT_ID = ? and a.rh_factor = b.RHESUS_FACTOR_CODE(+) and a.blood_grp = c.blood_grp(+) AND C.LANGUAGE_ID = ?" ;

		

		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, P_patient_id );
		pstmt.setString(2, locale );

		rset=pstmt.executeQuery();

		while(rset.next())
		{
			blood_grp = rset.getString("blood_grp")	;
			rh_factor = rset.getString("rh_factor")	;
			
			
		}

		String space =  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" ;
		
		if(blood_grp != null )
		{	
			strBuff_display.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels")+": <b>");
			strBuff_display.append(blood_grp);
			strBuff_display.append("</b>");
			
		}
		else
		{
			strBuff_display.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels")+": ");
			strBuff_display.append(space);
			
		}

		if(rh_factor != null )
		{
			strBuff_display.append("&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RhFactor.label","common_labels")+": <b>");
			strBuff_display.append(rh_factor);
			strBuff_display.append("</b>");
			
		}
		else
		{
			strBuff_display.append("&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RhFactor.label","common_labels")+": ");
			strBuff_display.append(space);
			
		}
		//28906 starts
		
		String sql2="";
		int TotalRecord = 0;
		PreparedStatement pstmt2=null;
		ResultSet rs1=null ;

			try
			{
				sql2		=	"SELECT SUM (rec) totalrec FROM (SELECT COUNT (*) rec FROM bt_patient_blgrp_rh_ant a, rl_result_comment_code b WHERE a.rh_pheno_type_code = b.result_comment_code AND a.patient_id = ? UNION SELECT COUNT (*) rec FROM bt_patient_rbc_phenotype a, bt_rbc_phenotype_code b WHERE a.rbc_phenotype_code = b.rbc_phenotype_code AND a.patient_id = ?)";
				pstmt2		=	con.prepareStatement(sql2);
				pstmt2.setString	(	1,	P_patient_id	);
				pstmt2.setString	(	2,	P_patient_id	);
				rs1			=	pstmt2.executeQuery();

				while(rs1.next())
				{
					TotalRecord=rs1.getInt("TOTALREC");
					
				}

			
				
			}
			catch(Exception e)
			{		
					//out.println("Error in GeneticMarketDisplay"+e.toString());//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
					if(rs1!=null) rs1.close();
					if(pstmt2!=null) pstmt2.close();
			}
		
			if(isPhenotypeSiteSpec)
			{
			if(TotalRecord > 0){
				strBuff_display.append("&nbsp;&nbsp;&nbsp;&nbsp;<a class='gridLink' href='javascript:PhenotypeDetails();'><font size='2'>Phenotype</font></a>");
				
			} 
			else {
				strBuff_display.append("&nbsp;&nbsp;&nbsp;&nbsp;<a class='gridLink' disabled title ='Phenotype Details Not Available.'><font size='2'>Phenotype</font></a>");
					
			}
			}
			
			//28906 ends
		
		//strBuff_display=null;
		String strsql2="";
		PreparedStatement pstmt1=null;
		ResultSet rs=null ;
		int count1=0;

			try
			{
				strsql2		=	" select  count(*) noofRecords from CA_IM_PAT_VAC_SCH_HDR a, CA_IM_PAT_VAC_SCH_DTL b where a.patient_id = ? and b.OUTCOME_CODE='C' and a.VAC_SCH_REF = b.VAC_SCH_REF   ";
				pstmt1		=	con.prepareStatement(strsql2);
				pstmt1.setString	(	1,	P_patient_id	);
				rs			=	pstmt1.executeQuery();

				while(rs.next())
				{
						count1=rs.getInt("noofRecords");
				}

			
				
			}
			catch(Exception e)
			{		
					//out.println("Error in GeneticMarketDisplay"+e.toString());//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
					if(rs!=null) rs.close();
					if(pstmt1!=null) pstmt1.close();
			}
			//Bru-HIMS-0154 Starts
			int opCount=0;
			int ipCount=0;
			int radCount=0;
			//String rad_installed_yn="";
			boolean show_appt_btn_yn=false;
			String strsql3="";
			String strsql4="";
			String strsql5="";
			try
			{
				strsql3		=	" select count(1) as total from oa_appt where patient_id=? and trunc(Appt_date)>=trunc(sysdate) and nvl(appt_status,1)!='A' order by appt_date,appt_slab_from_time  ";
				pstmt1		=	con.prepareStatement(strsql3);
				pstmt1.setString	(	1,	P_patient_id	);
				rs			=	pstmt1.executeQuery();

				while(rs.next())
				{
					opCount = rs.getInt("total");
				}
			}
			catch(Exception e)
			{		
					//out.println("Error in GeneticMarketDisplay"+e.toString());//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
					if(rs!=null) rs.close();
					if(pstmt1!=null) pstmt1.close();
			}
			try
			{
				//strsql4		=	" SELECT count(1) as total FROM RD_APPT where patient_id=?"; // Commented for ML-BRU-SCF-0373[IN034783]
				
				strsql4		=	" SELECT count(1) as total FROM RD_APPT where patient_id=?  and trunc(Appt_date)>=trunc(sysdate) and nvl(appt_status,1)!='A' order by appt_date, appt_start_time"; // modified for ML-BRU-SCF-0373[IN034783]
				
				pstmt1		=	con.prepareStatement(strsql4);
				pstmt1.setString	(	1,	P_patient_id	);
				rs			=	pstmt1.executeQuery();

				while(rs.next())
				{
					radCount = rs.getInt("total");
				}
			}
			catch(Exception e)
			{		
					//out.println("Error in GeneticMarketDisplay"+e.toString());//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
					if(rs!=null) rs.close();
					if(pstmt1!=null) pstmt1.close();
			}
			try
			{
				strsql5		=	" select count(1) as total from ip_booking_list where  patient_id=? and trunc(preferred_date)>=trunc(sysdate) and nvl(booking_status,1)=1  ";
				pstmt1		=	con.prepareStatement(strsql5);
				pstmt1.setString	(	1,	P_patient_id	);
				rs			=	pstmt1.executeQuery();

				while(rs.next())
				{
					ipCount = rs.getInt("total");
				}
			}
			catch(Exception e)
			{		
					//out.println("Error in GeneticMarketDisplay"+e.toString());//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
					if(rs!=null) rs.close();
					if(pstmt1!=null) pstmt1.close();
			}
			if (opCount != 0 || ipCount != 0 || radCount != 0)
			{
				show_appt_btn_yn=true;
			}
			//Bru-HIMS-0154 Ends
			// IN045536 - Start
			try
			{
				String strsql6		= "";
				if(patient_class.equals("IP") || patient_class.equals("DC")) {
					strsql6		=	" select mr_mds_recorded_yn ('"+facilityId+"','"+encounter_id+"','"+patient_class+"',null,'DA',null) mr_mds_recorded from dual ";
					pstmt1		=	con.prepareStatement(strsql6);
					rs			=	pstmt1.executeQuery();

					while(rs.next())
					{
						mr_mds_recorded_yn = rs.getString("mr_mds_recorded");
						System.err.println(" 430. GenericMarkersDisplay.jsp " + mr_mds_recorded_yn);
					}
				}
				else if(patient_class.equals("OP") || patient_class.equals("EM")){
				
					strsql6		=	" select mr_mds_recorded_yn ('"+facilityId+"','"+encounter_id+"','"+patient_class+"',null,'OC',null) mr_mds_recorded from dual ";
					pstmt1		=	con.prepareStatement(strsql6);
					rs			=	pstmt1.executeQuery();

					while(rs.next()) 
					{
						mr_mds_recorded_yn = rs.getString("mr_mds_recorded");
						System.err.println(" 442. GenericMarkersDisplay.jsp " + mr_mds_recorded_yn);
					}
				}
			}
			catch(Exception e)
			{		
					System.err.println("Error in GeneticMarketDisplay"+e.toString());
			}
			finally
			{
					if(rs!=null) rs.close();
					if(pstmt1!=null) pstmt1.close();
			}
			try
			{
				String strsql7	= "";
				if(patient_class.equals("IP") || patient_class.equals("DC")) {
					strsql7		=	" select count(*) as mds_chk from mr_mds_for_patient_class where MANDATORY_FOR_"+patient_class+"_YN='Y' and  ("+patient_class+"_STAGE='ALL' or "+patient_class+"_STAGE='DA') ";
					pstmt1		=	con.prepareStatement(strsql7);
					rs			=	pstmt1.executeQuery();

					while(rs.next())
					{
						mds_chk_cnt = rs.getInt("mds_chk");
					}
				}
				else if(patient_class.equals("OP") || patient_class.equals("EM")){
					strsql7		= "select count(*) as mds_chk from mr_mds_for_patient_class where MANDATORY_FOR_"+patient_class+"_YN='Y'";
					pstmt1		=	con.prepareStatement(strsql7);
					rs			=	pstmt1.executeQuery();

					while(rs.next())
					{
						mds_chk_cnt = rs.getInt("mds_chk");
					}
				}	
			}
			catch(Exception e)
			{		
					System.err.println("Error in GeneticMarketDisplay"+e.toString());
			}
			finally
			{
					if(rs!=null) rs.close();
					if(pstmt1!=null) pstmt1.close();
			}
			// IN045536 - End
			//IN057106 starts
			try
			{
				//IN057106_changed starts
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				String bt_install_yn = "";
				pstmt = con.prepareStatement("select install_yn from sm_module where module_id='BT' ");
				rset	= pstmt.executeQuery();
				if(rset!=null  && rset.next())
				{
						bt_install_yn		= rset.getString(1);
				}
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				//String ab_marker_desc="";//commented for checkstyle
				if("Y".equals(bt_install_yn))
				{
				
					AbMarkerSQL = "SELECT count(*) TOTAL_NO_OF_ANTIBODY FROM (SELECT A.ANTIBODY_CODE ANTIBODY_CODE,A.PATIENT_ID PATIENT_ID, A.LAST_REPORTED_DATE FROM BT_PATIENT_ANTIBODY A UNION SELECT DISTINCT C.ANTIBODY_CODE ANTIBODY_CODE,B.PATIENT_ID PATIENT_ID, C.LAST_REPORTED_DATE FROM BD_DONOR_MAST_DTLS B, BT_DONOR_ANTIBODY C  WHERE B.DONOR_ID = C.DONOR_ID ) a,BT_ANTIBODY_CODE_MAST_LANG_VW b  WHERE a.ANTIBODY_CODE = b.ANTIBODY_CODE AND b.language_id = ? AND PATIENT_ID = ? ";
					ab_pstmt		=	con.prepareStatement(AbMarkerSQL);
					ab_pstmt.setString	(	1,	locale	);
					ab_pstmt.setString	(	2,	P_patient_id	);
				
					ab_rsltset			=	ab_pstmt.executeQuery();
				

					while(ab_rsltset.next())
					{
					
						iTotalNoOfAntibody = ab_rsltset.getInt("TOTAL_NO_OF_ANTIBODY");
					
					}
					
				}
				//IN057106_changed	 ends
					
			}
			catch(Exception e)
			{		
					System.err.println("Error in GeneticMarkerDisplay - Antibody marker section"+e.toString());
			}
			finally
			{
					if(ab_rsltset!=null) ab_rsltset.close();
					if(ab_pstmt!=null) ab_pstmt.close();
			}
			//IN057106 ends
			//IN063885 start
			if(isMRReportappl){
				try
				{
					sql_note_type		= "select  MED_RPT_NOTE_TYPE from ca_note_param";
					pstmt_note_type		= con.prepareStatement(sql_note_type);
					rs_note_type		= pstmt_note_type.executeQuery();

					while(rs_note_type.next())
					{
						p_note_type = rs_note_type.getString("MED_RPT_NOTE_TYPE");
					}
		

					MRReportHypLnkYNSql	= "select CA_PAT_MED_RPT_YN(?,?,?,?) MR_RPT_HYP_YN from dual";
					mr_rpt_hyp_yn_pstmt	= con.prepareStatement(MRReportHypLnkYNSql);
					mr_rpt_hyp_yn_pstmt.setString(	1,	p_facility_id	);
					mr_rpt_hyp_yn_pstmt.setString(	2,	P_patient_id);
					mr_rpt_hyp_yn_pstmt.setString(	3,	encounter_id);
					mr_rpt_hyp_yn_pstmt.setString(	4,	p_note_type);
					
					mr_rpt_hyp_yn_rsltset			=	mr_rpt_hyp_yn_pstmt.executeQuery();
					
					while(mr_rpt_hyp_yn_rsltset.next())
					{
						mr_rpt_hyp_yn = mr_rpt_hyp_yn_rsltset.getString("MR_RPT_HYP_YN")==null?"":mr_rpt_hyp_yn_rsltset.getString("MR_RPT_HYP_YN");
					}

					if("Y".equals(mr_rpt_hyp_yn))
					{
						mr_rpt_hyp_yn_style = "visibility: visible";
					}
					else
					{
						mr_rpt_hyp_yn_style = "visibility: hidden";
					}
				}
				catch(Exception e)
				{		
					System.err.println("Error in GeneticMarkerDisplay - Antibody marker section"+e.toString());
				}
				finally
				{
					if(rs_note_type!=null) rs_note_type.close();
					if(mr_rpt_hyp_yn_rsltset!=null) mr_rpt_hyp_yn_rsltset.close();
					if(pstmt_note_type!=null) pstmt_note_type.close();
					if(mr_rpt_hyp_yn_pstmt!=null) mr_rpt_hyp_yn_pstmt.close();
				}
			}
			//IN063885 ends
          
			int p_count = bean.getMenstPatCount(con, P_patient_id);//70705 

		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strBuff_display.toString()));
            _bw.write(_wl_block14Bytes, _wl_block14);

		//IN057106_changed starts
		if(iTotalNoOfAntibody > 0)
		{
		
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

		}
		else
		{
		
            _bw.write(_wl_block18Bytes, _wl_block18);

		}
		//IN057106_changed ends
		
            _bw.write(_wl_block0Bytes, _wl_block0);
 	if (count1>0){
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(display_mode));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(grChart_display_mode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(chart_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(triage_display_mode));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(recorded_date_time));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
if (show_appt_btn_yn == true){
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);

		//37866 Start.
		if(isVirtualConsSiteSpec && "OP".equals(patient_class) && "Y".equals(virtualApptYN)){
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(clinicianId));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
		//37866 End.
		if(p_count!=0){
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
} 
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
 if(isMRReportappl){ 
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(mr_rpt_hyp_yn_style));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_note_type));
            _bw.write(_wl_block40Bytes, _wl_block40);
 } 
            _bw.write(_wl_block41Bytes, _wl_block41);
	if(mds_chk_cnt>0){
			if(mr_mds_recorded_yn.equals("Y")) {
	
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
		}
			else {
	
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(mr_mds_recorded_yn ));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

			}
		}
	 
            _bw.write(_wl_block47Bytes, _wl_block47);
 
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
		//out.println(e.getMessage());//COMMON-ICN-0181
	      e.printStackTrace();//COMMON-ICN-0181
}
finally
{
		if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block48Bytes, _wl_block48);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Antibody.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Immunization.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ResearchInfo.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.GrowthChart.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.TriageDetail.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.FutureAppointments.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MenstrualHistoryDetails.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Refresh.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.mdscriteriamet.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.mdscriterianotmet.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }
}
