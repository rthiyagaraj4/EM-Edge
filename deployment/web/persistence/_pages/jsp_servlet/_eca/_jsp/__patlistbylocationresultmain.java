package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __patlistbylocationresultmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatListByLocationResultMain.jsp", 1736516946597L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n-----------------------------------------------------------------------------------------------\nDate      \t Edit History   Name        \tDescription\n-----------------------------------------------------------------------------------------------\n?             \t100         \t?           \tcreated\n18/11/2011    \tIN29412     \tDinesh T    \tAMS CRF\n06/04/2015\tIN048704    \tNijitha S\tHSA-CRF-0175\t\n14/11/2023\t51215\t\tRamesh\t\tML-MMOH-CRF-1930.2\n-----------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\nif (\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"==\"Summary\")\n{\n\t\n\tparent.PatCriteriaFr.PatCriteriaFrm.url.value =\' ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \';\n}else{\n\t\n\ttop.content.workAreaFrame.PatCriteriaFr.PatCriteriaFrm.url.value =\' ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \';\n}\n</script>\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'></link>\n\t\t<title></title>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t</head>\n\t ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t\t\t\t<iframe name=\'LocnResultPatClass\' id=\'LocnResultPatClass\' src=\'../../eCA/jsp/PatListByLocationPatClass.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&allowSecondLevel=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' frameborder=0 scrolling=no noresize style=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'></iframe>\n\t\t\t\t<iframe name=\'LocnResultLocation\' id=\'LocnResultLocation\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' noresize style=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'></iframe>\n\t\t\t\t<iframe name=\'LocnResultTitle\' id=\'LocnResultTitle\' src=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'  frameborder=0 marginheight=0 marginwidth=0  scrolling=\'no\' noresize style=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'> </iframe>\n\t\t\t\t<iframe name=\'LocnResult\' id=\'LocnResult\'  src=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' frameborder=0 scrolling=\'auto\' noresize style=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'></iframe>\n\t\t\t\t\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\n\t\t\t<iframe name=\'LocnResultPatClass\' id=\'LocnResultPatClass\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=no noresize style=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'></iframe>\n\t\t\t<iframe name=\'LocnResultLocation\' id=\'LocnResultLocation\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' noresize style=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'></iframe>\n\t\t\t<iframe name=\'LocnResultTitle\' id=\'LocnResultTitle\' src=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'> </iframe>\n\t\t\t<iframe name=\'LocnResult\' id=\'LocnResult\'  src=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'></iframe>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t<!-- </frameset> -->\n</html>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

	eCA.PatSearch PatSearch = (eCA.PatSearch)getObjectFromBean("PatSearch","eCA.PatSearch",session);

            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;
	
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	String  allowSecondLevel="Y";
	String tab_menu_yn  = (request.getParameter("tab_menu_yn")==null)?"":request.getParameter("tab_menu_yn");
	String groupByLocn	= request.getParameter("groupByLocn");
	String groupByEpisode	= request.getParameter("groupByEpisode");
	String locationType			= request.getParameter("locationType");
	String Summary=request.getParameter("Summary")==null?"":request.getParameter("Summary");
		
	
	if(groupByLocn			== null || groupByLocn=="")groupByLocn="N"; 
	if(groupByEpisode	== null || groupByEpisode == "") groupByEpisode ="N";  
	if(locationType			== null || locationType =="") locationType="";

	String frameSize		= "0,0,0,*";
	
	String urlForTitleFrame="";
	String URL="";
	String url_hid="";
	String qryLoctionType		=   request.getParameter("locationType");
	String qryLoctionCode	=   request.getParameter("locationCode");
    String qryViewList			=   request.getParameter("viewList");
	String qryadm_fromdate =  request.getParameter("adm_fromdate");
	String qryadm_todate		=   request.getParameter("adm_todate"); 
    String qryPatientId			=	 request.getParameter("patientId");
    String qryQueueId			=	 request.getParameter("queueId");
	String nationID					=	 request.getParameter("nationID");
    String qryQueueStatus   =	 request.getParameter("queueStatus");
	String qryUnSheduled    =	 request.getParameter("unscheduled_yn");
    String qryPastVisit		    =	 request.getParameter("past");
    String qryFromDate1		=	 request.getParameter("from_visit_date");
	String qryToDate1	=	 request.getParameter("to_visit_date");
    String qryDischarge    =	 request.getParameter("discharged");
    String qryFromDate2	=	 request.getParameter("from_discharge_date");
    String qryToDate2	=	 request.getParameter("to_discharge_date");
	String qrySortOrder			 =	 request.getParameter("sortOrder");
    String qryGroByEpisode =	 request.getParameter("groupByEpisode");
    String qryGrpByLocn       =	 request.getParameter("groupByLocn");
	String qryCheckedOut     =	 request.getParameter("checked_out");
	String attend_practId     =	 request.getParameter("attend_practId");
	String speciality     =	 request.getParameter("speciality");
	String relnreqyn     =	 request.getParameter("reln_req_yn");
	String visitType     =	 request.getParameter("visitType");
	String bedNo = (String)request.getParameter("bedNo")==""?"%":request.getParameter("bedNo");//IN29412
	String assign_confirm_referral_yn     =	 request.getParameter("assign_confirm_referral_yn");//IN048704
	String virtualConsultation_yn=	 request.getParameter("virtualConsultation_yn"); //51215
	
	String iFrameSize0 = "", iFrameSize1 = "", iFrameSize2 = "", iFrameSize3 = "";

	/*String RP_chk     =	 request.getParameter("RP_chk")==null?"N":request.getParameter("RP_chk");
	String OVR_chk     =	 request.getParameter("OVR_chk")==null?"N":request.getParameter("OVR_chk");
	String OCIP_chk     =	 request.getParameter("OCIP_chk")==null?"N":request.getParameter("OCIP_chk");
	String CBSR_chk     =	 request.getParameter("CBSR_chk")==null?"N":request.getParameter("CBSR_chk");
	String UCBSR_chk     =	 request.getParameter("UCBSR_chk")==null?"N":request.getParameter("UCBSR_chk");
	String OA_chk     =	 request.getParameter("OA_chk")==null?"N":request.getParameter("OA_chk");
	String OAP_chk     =	 request.getParameter("OAP_chk")==null?"N":request.getParameter("OAP_chk");*/
	
	 if(qryLoctionType		  == null || qryLoctionType.equals(""))	qryLoctionType	="";
	 if(qryLoctionCode	  == null || qryLoctionCode.equals(""))	qryLoctionCode	=""; 
	 if(qryViewList			  == null || qryViewList.equals(""))			qryViewList		="";	 
	 if (qryadm_fromdate ==null || qryadm_fromdate.equals("")) qryadm_fromdate="";
	 if (qryadm_todate		  ==null || qryadm_todate.equals("")) qryadm_todate="";
	 if(qryPatientId			== null || qryPatientId.equals(""))			qryPatientId	="";	  
	 if(qryQueueId			== null || qryQueueId.equals(""))			qryQueueId	 	="";	 
	 if(nationID==null || nationID.equals("")) nationID="";
	 if(qryQueueStatus	== null || qryQueueStatus.equals(""))	qryQueueStatus  ="";	 
	 if(qryUnSheduled	== null || qryUnSheduled.equals(""))	qryUnSheduled   ="";	 
	 if(qryPastVisit			== null || qryPastVisit.equals(""))			qryPastVisit	="";	  
	 if(qryFromDate1		== null || qryFromDate1.equals(""))		qryFromDate1	="";	  
	 if(qryToDate1		== null || qryToDate1.equals(""))		qryToDate1	="";	  
	 if(qryDischarge		== null || qryDischarge.equals(""))		qryDischarge    ="";	 
	 if(qryFromDate2		== null || qryFromDate2.equals(""))		qryFromDate2	="";	  
	 if(qryToDate2		== null || qryToDate2.equals(""))		qryToDate2	="";	  
	 if(qrySortOrder			== null || qrySortOrder.equals(""))			qrySortOrder	="";
	 if(qryGroByEpisode== null || qryGroByEpisode.equals(""))	qryGroByEpisode ="";
	 if(qryGrpByLocn		== null || qryGrpByLocn.equals(""))		qryGrpByLocn    ="";
	 if(qryCheckedOut	== null || qryCheckedOut.equals(""))	qryCheckedOut    ="";
	 if(attend_practId	== null || attend_practId.equals(""))	attend_practId    ="";
	 if(speciality	== null || speciality.equals(""))	speciality    ="";
	 if(relnreqyn	== null || relnreqyn.equals(""))
         if(visitType	== null || visitType.equals(""))	relnreqyn    ="";

     HashMap qryStrHash			 =	 new HashMap();
     qryStrHash.put("LoctionType",qryLoctionType);
     qryStrHash.put("LoctionCode",qryLoctionCode);
     qryStrHash.put("ViewList",qryViewList); 
	 qryStrHash.put("adm_fromdate",qryadm_fromdate);
	 qryStrHash.put("adm_todate",qryadm_todate);
     qryStrHash.put("PatientId"	,	qryPatientId); 
     qryStrHash.put("QueueId"   ,	qryQueueId);
	 qryStrHash.put("nationID",nationID);
     qryStrHash.put("QueueStatus"	,	qryQueueStatus);
     qryStrHash.put("UnSheduled"	,	qryUnSheduled);
     qryStrHash.put("PastVisit"		,	qryPastVisit); 
     qryStrHash.put("FromDate1"		,	qryFromDate1); 
	 qryStrHash.put("ToDate1"		,	qryToDate1); 
     qryStrHash.put("Discharge"     ,	qryDischarge);
     qryStrHash.put("FromDate2"     ,	qryFromDate2); 
     qryStrHash.put("ToDate2"		,	qryToDate2); 
     qryStrHash.put("SortOrder"     ,	qrySortOrder); 
     qryStrHash.put("GroByEpisode"  ,	qryGroByEpisode);
     qryStrHash.put("GrpByLocn"     ,	qryGrpByLocn);
	 qryStrHash.put("checked_out"   ,	qryCheckedOut);
	 qryStrHash.put("attend_practId"   ,	attend_practId);
	 qryStrHash.put("speciality"   ,	speciality);
     qryStrHash.put("visitType"   ,	visitType);
	 qryStrHash.put("relnreqyn"    ,	relnreqyn);
	 qryStrHash.put("bedNo"    ,	bedNo);//IN29412
	 qryStrHash.put("assign_confirm_referral_yn"    ,	assign_confirm_referral_yn);//IN048704
	 qryStrHash.put("virtualConsultation_yn"    ,	virtualConsultation_yn);//51215
	 
	// added for CRF 464 by Shaiju 
	 /*qryStrHash.put("RP_chk"   ,	RP_chk);
	 qryStrHash.put("OVR_chk"   ,	OVR_chk);
	 qryStrHash.put("OCIP_chk"   ,	OCIP_chk);
	 qryStrHash.put("CBSR_chk"   ,	CBSR_chk);
	 qryStrHash.put("UCBSR_chk"   ,	UCBSR_chk);
	 qryStrHash.put("OA_chk"   ,	OA_chk);
	 qryStrHash.put("OAP_chk"   ,	OAP_chk);*/
	
	try
	{
		if(qryLoctionType.equals("Z") || qryLoctionCode.equals("*ALL"))
		{
			con = ConnectionManager.getConnection(request);

			String pract_id		= (String)session.getValue("ca_practitioner_id");
			String facility_id	= (String)session.getValue("facility_id");
			PatSearch.setLevelHeader(con, pract_id, facility_id, qryStrHash,"ByLocation",locale);
		}
		else
		{
			session.removeAttribute("PatSearch");
			allowSecondLevel = "N";
		}

		putObjectInBean("PatSearch",PatSearch,session);
	}
	catch(Exception e)
	{
		out.println("<script>alert("+e+");</script>");		
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
		out.println("<script>parent.PatCriteriaFr.document.getElementById('searchID').disabled = false;</script>");
	}

	if(groupByLocn.equals("Y") && groupByEpisode.equals("Y")){
			if((locationType.equals("OP") || locationType.equals("IP") || locationType.equals("DC") || locationType.equals("EM") ) && 						qryLoctionCode.equals("*ALL")){
				if(tab_menu_yn.equals("Y")) 
				{	
					//frameSize = "0%,8%,4.5%,*";
					frameSize = "0%,5.5%,4.5%,*";
					//frameSize = "0%,6%,10%,*";					
					//ameSize = "0%,8%,5.5%,*";
					
					iFrameSize0		= "height:0vh;width:100vw";
					iFrameSize1		= "height:7vh;width:100vw";
					iFrameSize2		= "height:7vh;width:100vw";
					iFrameSize3		= "height:75vh;width:100vw";
					

				}
				else 
				{
					/*if(RP_chk.equals("Y"))
					{
						frameSize = "4.5%,4.5%,5.5%,*";
					}
					else
					{*/
						frameSize = "0%,5.6%,6%,*";		
					iFrameSize0		= "height:0vh;width:100vw";
					iFrameSize1		= "height:7vh;width:100vw";
					iFrameSize2		= "height:7vh;width:100vw";
					iFrameSize3		= "height:75vh;width:100vw";
					//}
				}
			}else if(locationType.equals("Z")){
				
				if(tab_menu_yn.equals("Y")) {
					//frameSize = "10%,8%,4.5%,*";
									frameSize = "5.5%,5.5%,5.5%,*";		
									iFrameSize0		= "height:7vh;width:100vw";
									iFrameSize1		= "height:7vh;width:100vw";
									iFrameSize2		= "height:7vh;width:100vw";
									iFrameSize3		= "height:75vh;width:100vw";
				}

				else{ 
					//frameSize ="4.5%,4.5%,5.5%,*";

				frameSize ="4.5%,5.75%,6.15%,*"; //6.8%,6.8%,9.5%,*
				iFrameSize0		= "height:7vh;width:100vw;display:none";
				iFrameSize1		= "height:7vh;width:100vw";
				iFrameSize2		= "height:7vh;width:100vw";
				iFrameSize3		= "height:75vh;width:100vw";
				}
				//URL = "../../eCommon/html/blank.html";
			}else{
				if(tab_menu_yn.equals("Y")) {
					//frameSize = "10%,8%,4.5%,*";
				frameSize = "0%,0%,5.5%,*";
				iFrameSize0		= "height:0vh;width:100vw";
				iFrameSize1		= "height:0vh;width:100vw";
				iFrameSize2		= "height:7vh;width:100vw";
				iFrameSize3		= "height:91vh;width:100vw";
				
				}
				else
				{
						frameSize ="0%,0%,4.5%,*";
						iFrameSize0		= "height:0vh;width:100vw";
						iFrameSize1		= "height:0vh;width:100vw";
						iFrameSize2		= "height:7vh;width:100vw";
						iFrameSize3		= "height:91vh;width:100vw";
						
				}
					
					urlForTitleFrame = "../../eCA/jsp/PatListByLocationTitle.jsp?"+request.getQueryString()+"&locn_type="+qryLoctionType+"&locn_code="+qryLoctionCode+"&fromMain=Y";
				

			}
	}else if(groupByLocn.equals("N") && groupByEpisode.equals("Y")){
			allowSecondLevel = "N"; 
			 if(locationType.equals("IP") || locationType.equals("OP") || locationType.equals("DC") || locationType.equals("EM")){
					/*if(RP_chk.equals("Y"))
					{
						frameSize = "4.5%,0%,0%,*";
					}
					else
					{*/
						frameSize = "0%,0%,0%,*";
					iFrameSize0		= "display:none";
					iFrameSize1		= "display:none";
					iFrameSize2		= "display:none";
					iFrameSize3		= "height:88vh;width:100vw";
					//}
					
			}else{
					if(tab_menu_yn.equals("Y")) {
						frameSize = "5.5%,0%,0%,*";
						iFrameSize0		= "height:7vh;width:100vw";
						iFrameSize1		= "display:none";
						iFrameSize2		= "display:none";
						iFrameSize3		= "height:91vh;width:100vw";
					}
					else{ 
						frameSize ="4.5%,0%,0%,*";
						iFrameSize0		= "height:7vh;width:100vw";
						iFrameSize1		= "display:none";
						iFrameSize2		= "display:none";
						iFrameSize3		= "height:91vh;width:100vw";
						}


			}
			URL = "PatListByLocationResult.jsp?"+request.getQueryString();
			url_hid=request.getQueryString()+"&locn_type="+qryLoctionType+"&locn_code="+qryLoctionCode+"&fromMain=Y";					
	}
	else
	{
		iFrameSize0		= "display:none";
		iFrameSize1		= "display:none";
		iFrameSize2		= "display:none";
		iFrameSize3		= "height:98vh;width:100vw";
	}
		


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(Summary));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(url_hid));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(url_hid));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block2Bytes, _wl_block2);
if(qryLoctionType.equals("Z") || qryLoctionCode.equals("*ALL")){ 
	System.out.println(" Inside PatListByLocationResultMain JSP 317 iFrameSize0 : "+iFrameSize0+" iFrameSize1 : "+iFrameSize1+" iFrameSize2 : "+iFrameSize2+" iFrameSize3 : "+iFrameSize3);
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(allowSecondLevel));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(iFrameSize0));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(iFrameSize1));
            _bw.write(_wl_block16Bytes, _wl_block16);
//=urlForTitleFrame
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(iFrameSize2));
            _bw.write(_wl_block18Bytes, _wl_block18);
//=URL
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(iFrameSize3));
            _bw.write(_wl_block20Bytes, _wl_block20);
}else{
	System.out.println(" Inside PatListByLocationResultMain JSP 330 iFrameSize0 : "+iFrameSize0+" iFrameSize1 : "+iFrameSize1+" iFrameSize2 : "+iFrameSize2+" iFrameSize3 : "+iFrameSize3);

            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(iFrameSize0));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(iFrameSize1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(urlForTitleFrame));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(iFrameSize2));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(URL));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(iFrameSize3));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
