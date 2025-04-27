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
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __patlistbyrelnprovresultmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatListByRelnProvResultMain.jsp", 1730973941792L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script>\ntop.content.workAreaFrame.PatCriteriaFr.PatCriteriaFrm.url.value =\' ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \';\n</script>\n\t\t<html>\n\t\t\t<head>\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n\t\t\t\t\t<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n\t\t\t</head>\n\t\t\n\t\t\t <frameset rows=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" framespacing=\'0\' id=\'resultFrameSet\' >\n\t\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<frame name=\'RelnResultPatClass\' id=\'RelnResultPatClass\' src=\'PatListByRelnProvClass.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&allowSecondLevel=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' frameborder=0 scrolling=no noresize></frame>\n\t\t\t\t\t<frame name=\'RelnResultLocation\' id=\'RelnResultLocation\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' noresize></frame>\n\t\t\t\t\t<frame name=\'RelnResultTitle\' id=\'RelnResultTitle\' src=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'  frameborder=0 marginheight=0 marginwidth=0  scrolling=\'no\' noresize></frame>\n\t\t\t\t\t<frame name=\'LocnResult\' id=\'LocnResult\'  src=\'\' frameborder=0 scrolling=\'auto\' noresize></frame> \n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<frame name=\'RelnResultPatClass\' id=\'RelnResultPatClass\'  src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=no  noresize></frame>\n\t\t\t\t\t<frame name=\'RelnResultLocation\' id=\'RelnResultLocation\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\'  noresize></frame>\n\t\t\t\t\t<frame name=\'RelnResultTitle\' id=\'RelnResultTitle\' src=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'  frameborder=0 marginheight=0 marginwidth=0  scrolling=\'no\'  noresize>\n\t\t\t\t\t<frame name=\'LocnResult\' id=\'LocnResult\' src=\'\' frameborder=0 scrolling=\'auto\'  noresize></frame>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t</frameset>\n</html>\n\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCA.PatSearch PatSearch = (eCA.PatSearch)getObjectFromBean("PatSearch","eCA.PatSearch",session);


	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	String allowSecondLevel="Y" ;
	String groupByReln		= request.getParameter("groupByReln");
	String groupByEpisode	= request.getParameter("groupByEpisode");
	String locationType		= request.getParameter("locationType");
	if(groupByReln			== null || groupByReln=="")groupByReln="N"; 
	if(groupByEpisode		== null || groupByEpisode == "") groupByEpisode ="N";  
	if(locationType			== null || locationType =="") locationType="";
	String frameSize		= "0,0,0,*";
	String url_hid="";
	//String URL				= "";

	String urlForTitleFrame="";
	//out.println("<script>alert('main URL : "+request.getQueryString()+"');</script>");
	/** To Pass the QueryString
	 *  Values to the Bean.
	 */ 
	 String qryLoctionType  =    request.getParameter("locationType");
	 String relationshipCode  =    request.getParameter("relationshipCode");
	 String qryPatientId	=	 request.getParameter("patientId");
     String qryQueueId	    =	 request.getParameter("queueId");
     String qryFromDate		=	 request.getParameter("fromDate");
	 String qryToDate		=	 request.getParameter("toDate");
     String qrySortOrder	=	 request.getParameter("sortOrder");
     String qryGroByEpisode =	 request.getParameter("groupByEpisode");
     String qryGrpByReln    =	 request.getParameter("groupByReln");
     String qrycheckedOut    =	 request.getParameter("checkedOut");
     String qrydischarged    =	 request.getParameter("discharged");
     String qrynonencspec    =	 request.getParameter("nonencspec");
	 String attend_practId     =	 request.getParameter("attend_practId");
	 String speciality     =	 request.getParameter("speciality");
	 String visitType		=	 request.getParameter("visitType");

	 if(qryLoctionType		== null || qryLoctionType.equals(""))	qryLoctionType	="";
	 if(relationshipCode	== null || relationshipCode.equals(""))	relationshipCode	="";	    	  
	 if(qryPatientId		== null || qryPatientId.equals(""))		qryPatientId	="";	  
	 if(qryQueueId			== null || qryQueueId.equals(""))		qryQueueId	 	="";	 
	 if(qryFromDate			== null || qryFromDate.equals(""))		qryFromDate	="";	  
	 if(qryToDate			== null || qryToDate.equals(""))		qryToDate	="";	  
	 if(qrySortOrder		== null || qrySortOrder.equals(""))		qrySortOrder	="";
	 if(qryGroByEpisode		== null || qryGroByEpisode.equals(""))	qryGroByEpisode ="";
	 if(qryGrpByReln		== null || qryGrpByReln.equals(""))		qryGrpByReln    ="";
	 if(qrycheckedOut		== null || qrycheckedOut.equals(""))	qrycheckedOut    ="";
	 if(qrydischarged		== null || qrydischarged.equals(""))	qrydischarged    ="";
	 if(qrynonencspec		== null || qrynonencspec.equals(""))	qrynonencspec    ="";
	 if(attend_practId	== null || attend_practId.equals(""))	attend_practId    ="";
	 if(speciality	== null || speciality.equals(""))	speciality    ="";
	 if(visitType	== null || visitType.equals(""))	visitType    ="";

     HashMap qryStrHash			 =	 new HashMap();
     qryStrHash.put("LoctionType"  ,    qryLoctionType  );
     qryStrHash.put("RelationshipCode"  ,    relationshipCode  );
     qryStrHash.put("PatientId"    ,	qryPatientId	); 
     qryStrHash.put("QueueId"      ,	qryQueueId	 	);
     qryStrHash.put("FromDate"    ,	qryFromDate 	); 
     qryStrHash.put("ToDate"       ,    qryToDate		); 
     qryStrHash.put("SortOrder"    ,	qrySortOrder	); 
     qryStrHash.put("GroByEpisode" ,	qryGroByEpisode );
     qryStrHash.put("GrpByReln"    ,	qryGrpByReln    );
     qryStrHash.put("checkedOut"    ,	qrycheckedOut    );
     qryStrHash.put("discharged"    ,	qrydischarged    );
     qryStrHash.put("nonencspec"    ,	qrynonencspec    );
	 qryStrHash.put("attend_practId"   ,	attend_practId);
	 qryStrHash.put("speciality"   ,	speciality);
	 qryStrHash.put("visitType"   ,	visitType);
	 	   
	try{

			if(qryLoctionType.equals("Z") || relationshipCode.equals("ALL")){

				con = ConnectionManager.getConnection(request);
				String pract_id		= (String)session.getValue("ca_practitioner_id");
				String facility_id	= (String)session.getValue("facility_id");
				//String resp_id = (String)session.getValue("responsibility_id");
			    //String user_id = (String)session.getValue("login_user");
				 PatSearch.setLevelHeader(con, pract_id, facility_id, qryStrHash, "ByPPRelation",locale);
// 				 PatSearch.setLevelHeader(con, pract_id, facility_id, qryStrHash, "ByPPRelation");

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
			out.println("<script>parent.PatCriteriaFr.document.getElementById(\"search\").disabled = false;</script>");
	}

if(groupByReln.equals("Y") && groupByEpisode.equals("Y")){
			if((locationType.equals("OP") || locationType.equals("IP") || locationType.equals("DC") || locationType.equals("EM") ) && (relationshipCode.equals("ALL"))){
				frameSize = "0%,9%,10%,*";
			}else if(locationType.equals("Z")){
				frameSize ="9%,9%,12%,*";
				//URL = "../../eCommon/html/blank.html";
			}else{
					frameSize ="0%,0%,10%,*";
			//		out.println(qryLoctionType+"   "+relationshipCode);
					urlForTitleFrame = "PatListByRelnProvTitle.jsp?"+request.getQueryString()+"&locn_type="+qryLoctionType+"&locn_code="+relationshipCode+"&fromMain=Y";
			}
	}else if(groupByReln.equals("N") && groupByEpisode.equals("Y")){
			allowSecondLevel = "N";
			 if(locationType.equals("IP") || locationType.equals("OP") || locationType.equals("DC") || locationType.equals("EM")){
		//		 	allowSecondLevel = "Y";
					frameSize = "0%,0%,0%,*";
			}else{
					frameSize ="9%,0%,0%,*";
			}
			//URL = "PatListByLocationResult.jsp?"+request.getQueryString();
			//url_hid=request.getQueryString()+"&locn_type="+qryLoctionType+"&locn_code="+relationshipCode+"&fromMain=Y";
			
	}
	url_hid=request.getQueryString()+"&locn_type="+qryLoctionType+"&locn_code="+relationshipCode+"&fromMain=Y";
			

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(url_hid));
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(frameSize));
            _bw.write(_wl_block10Bytes, _wl_block10);
	if(qryLoctionType.equals("Z") || relationshipCode.equals("ALL")){  
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(allowSecondLevel));
            _bw.write(_wl_block13Bytes, _wl_block13);
//=urlForTitleFrame
            _bw.write(_wl_block14Bytes, _wl_block14);
		}else { 		
						
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(urlForTitleFrame));
            _bw.write(_wl_block16Bytes, _wl_block16);
		}	
            _bw.write(_wl_block17Bytes, _wl_block17);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ViewPatientListbyMedServiceResultMain.label", java.lang.String .class,"key"));
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
}
