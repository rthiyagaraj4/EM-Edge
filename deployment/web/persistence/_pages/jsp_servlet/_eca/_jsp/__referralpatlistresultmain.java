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

public final class __referralpatlistresultmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ReferralPatListResultMain.jsp", 1736242173542L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<script>\n\ttop.content.workAreaFrame.PatCriteriaFr.PatCriteriaFrm.url.value = \'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';\n</script>\n\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t\t<title></title>\n\t</head>\n\n\t <div   id=\'resultFrameSet\'>\n\t<!-- <script>alert(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\');</script>\n\t<frameset rows=\"60%,25%,*\" framespacing=\'0\' id=\'resultFrameSet\'> -->\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<iframe name=\'LocnResultPatClass\' id=\'LocnResultPatClass\' src=\'../../eCA/jsp/ReferralPatListResult.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&allowSecondLevel=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' style=\'height:";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =";width:100vw\' frameborder=0 scrolling=\"auto\" noresize></iframe>\n\t\t\t<iframe name=\'LocnResultLocation\' id=\'LocnResultLocation\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' noresize style=\'height:";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =";width:100vw\'></iframe>\n\t\t\t<iframe name=\'LocnResult\' id=\'LocnResult\'  src=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' frameborder=0 scrolling=\'auto\' noresize style=\'height:";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =";width:100vw\'></iframe>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\t\t\t<iframe name=\'LocnResultPatClass\' id=\'LocnResultPatClass\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=no noresize style=\'height:";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =";width:100vw\'></iframe>\n\t\t\t<iframe name=\'LocnResultLocation\' id=\'LocnResultLocation\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' noresize style=\'height:";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =";width:100vw\'></iframe>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t</div>\n</html>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );
	
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
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name				Rev.Date   		Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
09/08/2016		IN064836		Krishna Gowtham		09/08/2017		Ramesh G	ML-MMOH-CRF-0566.1
-------------------------------------------------------------------------------------------------------------------------------
*/

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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	eCA.PatSearch PatSearch = (eCA.PatSearch)getObjectFromBean("PatSearch","eCA.PatSearch",session);

            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;
	
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	String  allowSecondLevel = "Y";

	String groupByLocn		= request.getParameter("groupByLocn");
	String groupByEpisode	= request.getParameter("groupByEpisode");
	String locationType		= request.getParameter("locationType");

	if(groupByLocn		== null || groupByLocn=="")groupByLocn = "N"; 
	if(groupByEpisode	== null || groupByEpisode == "") groupByEpisode = "N";  
	if(locationType		== null || locationType =="") locationType = "";

	String frameSize		= "0%,0%,*";
	String height1 = "";
	String height2 = "";
	String height3 = "";
	String URL = "ReferralPatListResult.jsp?"+request.getQueryString();
	//String urlForTitleFrame = "";
	String url_hid = "";
	String qryLoctionType	=	request.getParameter("locationType");
	String qryLoctionCode	=	request.getParameter("locationCode");
	String qryFromDate		=	request.getParameter("fromDate");
	String qryToDate		=	request.getParameter("toDate"); 
    String qryPatientId		=	request.getParameter("patientId");
    String qryGroByEpisode	=	request.getParameter("groupByEpisode");
    String qryGrpByLocn     =	request.getParameter("groupByLocn");
	String qryUnAssigned    =	request.getParameter("unAssigned");
	String qryPendingRef    =	request.getParameter("pendingRef");
	//IN064836 start
	/*String qryClosed		=	request.getParameter("closed");
	String qryOpen			=	request.getParameter("open");*/
	String refStatus		=	request.getParameter("refStatus");
	String refRegSiteYN		=	request.getParameter("refRegSiteYN");
	//IN064836 ends
	 
	 if(qryLoctionType	== null || qryLoctionType.equals(""))	qryLoctionType	= "";
	 if(qryLoctionCode	== null || qryLoctionCode.equals(""))	qryLoctionCode	= ""; 
	 if(qryFromDate		== null || qryFromDate.equals(""))		qryFromDate		= "";
	 if(qryToDate		== null || qryToDate.equals(""))		qryToDate		= "";
	 if(qryPatientId	== null || qryPatientId.equals(""))		qryPatientId	= "";	  
	 if(qryGroByEpisode	== null || qryGroByEpisode.equals(""))	qryGroByEpisode = "";
	 if(qryGrpByLocn	== null || qryGrpByLocn.equals(""))		qryGrpByLocn    = "";
	 if(qryUnAssigned	== null || qryUnAssigned.equals(""))	qryUnAssigned   = "";
	 if(qryPendingRef	== null || qryPendingRef.equals(""))	qryPendingRef   = "";
	 //IN064836 start
	 /*if(qryClosed		== null || qryClosed.equals(""))		qryClosed		= "";
	 if(qryOpen			== null || qryOpen.equals(""))			qryOpen			= "";*/
	 if(refStatus		== null || refStatus.equals(""))		refStatus		= "";
	 if(refRegSiteYN	== null || refRegSiteYN.equals(""))		refRegSiteYN	= "";
	 //IN064836 ends

     HashMap qryStrHash	= new HashMap();

     qryStrHash.put("LoctionType",qryLoctionType);
     qryStrHash.put("LoctionCode",qryLoctionCode);
	 qryStrHash.put("FromDate",qryFromDate);
	 qryStrHash.put("ToDate",qryToDate);
     qryStrHash.put("PatientId",qryPatientId); 
     qryStrHash.put("GroByEpisode",qryGroByEpisode);
     qryStrHash.put("GrpByLocn",qryGrpByLocn);
	 qryStrHash.put("unAssigned",qryUnAssigned);
	 qryStrHash.put("pendingRef",qryPendingRef);
	 //IN064836 start
	 /*qryStrHash.put("closed",qryClosed);
	 qryStrHash.put("open",qryOpen);*/
	 qryStrHash.put("refStatus",refStatus);
	 qryStrHash.put("refRegSiteYN",refRegSiteYN);
	 //IN064836 ends
	
	
	try
	{
		if(qryLoctionType.equals("Z") || qryLoctionCode.equals("*ALL"))
		{
			con = ConnectionManager.getConnection(request);

			String pract_id		= (String)session.getValue("ca_practitioner_id");
			String facility_id	= (String)session.getValue("facility_id");
			PatSearch.setLevelHeader(con, pract_id, facility_id, qryStrHash,"ReferralList",locale);
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
		if(con != null) ConnectionManager.returnConnection(con,request);
		out.println("<script>parent.PatCriteriaFr.document.getElementById('searchID').disabled = false;</script>");
	}


	if(groupByLocn.equals("Y") && groupByEpisode.equals("Y"))
	{
		if((locationType.equals("OP") || locationType.equals("IP") || locationType.equals("DC") || locationType.equals("EM") ) && 						qryLoctionCode.equals("*ALL"))
		{
			//frameSize = "4.5%,4.5%,*";(commented as result page not able to view)
			//frameSize = "100%,0%,*";
			height1 = "90vh";
			height2 = "0vh";
			height3 = "0vh";
		}
		else if(locationType.equals("Z"))
		{
			//frameSize = "100%,0%,*"; 
			height1 = "90vh";
			height2 = "0vh";
			height3 = "0vh";
		}
		else
		{
			//frameSize = "0%,0%,*";
			height1 = "0vh";
			height2 = "0vh";
			height3 = "90vh";
			//urlForTitleFrame = "../../eCA/jsp/ReferralPatListTitle.jsp?"+request.getQueryString()+"&locn_type="+qryLoctionType+"&locn_code="+qryLoctionCode+"&fromMain=Y";
		}
	}
	else if(groupByLocn.equals("N") && groupByEpisode.equals("Y"))
	{
		
		allowSecondLevel = "N"; 
		if(locationType.equals("IP") || locationType.equals("OP") || locationType.equals("DC") || locationType.equals("EM"))
		{
			//frameSize = "0%,0%,*";
			height1 = "0vh";
			height2 = "0vh";
			height3 = "90vh";
		}
		else
		{
			//frameSize = "4.5%,0%,*";
			height1 = "4.5vh";
			height2 = "0vh";
			height3 = "80vh";
		}
		URL = "ReferralPatListResult.jsp?"+request.getQueryString();
	}
	url_hid = request.getQueryString()+"&locn_type="+qryLoctionType+"&locn_code="+qryLoctionCode+"&fromMain=Y";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(url_hid));
            _bw.write(_wl_block7Bytes, _wl_block7);

			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(frameSize));
            _bw.write(_wl_block10Bytes, _wl_block10);

		if(qryLoctionType.equals("Z") || qryLoctionCode.equals("*ALL"))
		{ 

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(allowSecondLevel));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(height1));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(height2));
            _bw.write(_wl_block15Bytes, _wl_block15);
//=URL
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(height3));
            _bw.write(_wl_block17Bytes, _wl_block17);

		}
		else
		{

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(height1));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(height2));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(URL));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(height3));
            _bw.write(_wl_block20Bytes, _wl_block20);
		
		}

            _bw.write(_wl_block21Bytes, _wl_block21);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
