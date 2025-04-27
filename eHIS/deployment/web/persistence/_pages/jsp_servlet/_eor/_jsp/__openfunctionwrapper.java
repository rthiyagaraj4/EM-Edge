package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCA.CAOpenChartServlet;
import eCommon.XSSRequestWrapper;

public final class __openfunctionwrapper extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OpenFunctionWrapper.jsp", 1734415780000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\n\t<!-- <frameset frameborder=0 framespacing=0 rows=\'9%,*,5%,0%\' scrolling=\'auto\' id=\"mainFrameSet\"> -->\t\n\t\t<iframe name=\'CommonToolbar\' id=\'CommonToolbar\' src=\'../../eCommon/jsp/pline.jsp?Patient_ID=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&Facility_Id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&EncounterId=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' noresize  frameborder=no marginheight=0 marginwidth=0 SCROLLING=\'no\' noresize style=\'height:9vh;width:99vw\'></iframe>\n\t\t<!-- <frameset frameborder=0 framespacing=0 cols=\"0%,*,0%\" scrolling=\'auto\' id=\'workArea\'> -->\n\t\t\t\t<iframe name=\'menuFrame\' id=\'menuFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0  marginheight=0 marginwidth=0 SCROLLING=\'yes\' BORDERCOLOR=\'red\' style=\'height:0vh;width:99vw\'></iframe>\n\t\t\t\t<iframe name=\'workAreaFrame\' id=\'workAreaFrame\' src=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'   frameborder=0  marginheight=0 marginwidth=0 SCROLLING=\'no\' BORDERCOLOR=\'green\' style=\'height:75vh;width:99vw;margin-top:-24px\'></iframe>\n\t\t\t\t<iframe name=\'lookupMenuFrame\' id=\'lookupMenuFrame\' src=\'../../eCommon/html/blank.html\'   frameborder=0  marginheight=0 marginwidth=0 SCROLLING=\'auto\' BORDERCOLOR=\'red\' style=\'height:0vh;width:97vw\'></iframe>\n\t\t<!-- </frameset> -->\n        <iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' noresize  frameborder=0  marginheight=0 marginwidth=0 SCROLLING=\'no\' noresize style=\'height:9vh;width:99vw\'></iframe> \n\t<!-- </frameset> -->\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<html>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 
/*
-----------------------------------------------------------------------
Date       	Edit History   Name        Description
-----------------------------------------------------------------------
  ?             100            ?           created

28/01/2012	IN030566	Ramesh G	When we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.								  
22/05/2014	IN049213	Chowminya	Alpha-PH-External Patient
21/10/2015		IN057196		Ramesh G		Recording Of Consent Form						  
-----------------------------------------------------------------------
*/

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
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection  con = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;
	
	String function_id = "OR";
	String fileName = "../../eOR/jsp/EnterOrder.jsp";
	String patient_id = checkForNull(request.getParameter("patient_id")) ;
	String patient_class = checkForNull(request.getParameter("patient_class"));
	String from_service_yn = checkForNull(request.getParameter("from_service_yn"));
	String from_module = checkForNull(request.getParameter("from_module"));
	String invoke_function_id = checkForNull(request.getParameter("invoke_function_id"));
	if(invoke_function_id.equals("ORDER_ENTRY") ) function_id = "OP"; 
	String cnsnt_with_order_yn=request.getParameter("cnsnt_with_order_yn")==null?"N":request.getParameter("cnsnt_with_order_yn"); //IN057196
	fileName = "../../eOR/jsp/EnterOrder.jsp";
	//[IN030566] Starts
	try{			
		if((session.getAttribute("TEMP_PASS")!=null) && (session.getAttribute("TEMP_PASS")!="")){
			HashMap mHash = new HashMap();
			mHash = (HashMap) session.getAttribute("TEMP_PASS");
			if(mHash.containsKey(patient_id)){
				mHash.remove(patient_id);
			}
			session.setAttribute("TEMP_PASS",mHash);
		}
	}catch(Exception ee)
	{	
		out.println("Exception in OpenChartWrapper.jsp for TEMP_PASS Session-- "+ee.toString()+"--");
		ee.printStackTrace();
	}
	//[IN030566] Ends

	if (patient_class.equals("") && from_module.equals("AE") )
		 patient_class = "EM";

	StringBuffer queryString = new StringBuffer();

	String episode_id = checkForNull(request.getParameter("encounter_id"));
	String facility_id = checkForNull((String)session.getValue("facility_id"));
	
	String login_user = checkForNull((String)session.getValue("login_user"));
	String practitioner_name = checkForNull((String)session.getValue("practitioner_name"));
	String ca_practitioner_id = checkForNull((String)session.getValue("ca_practitioner_id"));

	String query = "";
	
	if((!episode_id.equals("") && !patient_class.equals(""))||(patient_class.equals("XT")))
	{

		try
		{
			con = ConnectionManager.getConnection(request);

			if(!patient_id.equals("") && episode_id.equals(""))
			{
				query =  " select sex, get_age(date_of_birth) age, TO_CHAR(date_of_birth,'DD/MM/YYYY') date_of_birth  from mp_patient where patient_id=? ";
				stmt = con.prepareStatement(query);
				stmt.setString(1, patient_id);
				try
				{
					rs = stmt.executeQuery();
					if (rs.next())
					{
						queryString.append("Sex="+checkForNull(rs.getString("sex"))+"&Age="+checkForNull(rs.getString("age"))+"&Dob="+checkForNull(rs.getString("date_of_birth"))+"&patient_class="+patient_class+"&from_service_yn="+from_service_yn+"&function_id="+function_id);
						
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			else
			{
				// Query modified from above one which is commented part
				query =  "SELECT A.PATIENT_ID PATIENT_ID, A.ENCOUNTER_ID ENCOUNTER_ID,A.ASSIGN_CARE_LOCN_CODE LOCN_CODE,A.ASSIGN_CARE_LOCN_TYPE LOCN_TYPE,A.ASSIGN_ROOM_NUM ROOM_NUM,A.ASSIGN_BED_NUM BED_NUM ,TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME, TO_CHAR(A.DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI') DISCHARGE_DATE_TIME ,DECODE(A.PATIENT_CLASS, 'IP',ADT_STATUS,'DC',ADT_STATUS, VISIT_STATUS) ADT_STATUS,B.SEX SEX,TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH FROM PR_ENCOUNTER A, MP_PATIENT B WHERE A.FACILITY_ID=? AND A.ENCOUNTER_ID = ? AND B.PATIENT_ID=A.PATIENT_ID ";

				stmt = con.prepareStatement(query);
				stmt.setString(1, facility_id);
				stmt.setString(2, episode_id);

				try
				{
					rs = stmt.executeQuery();
					if (rs.next())
					{
						queryString.append("patient_id="+checkForNull(rs.getString("PATIENT_ID"))+"&episode_id="+checkForNull(rs.getString("ENCOUNTER_ID"))+"&encounter_id="+checkForNull(rs.getString("ENCOUNTER_ID"))+"&location_code="+checkForNull(rs.getString("LOCN_CODE"))+"&location_type="+checkForNull(rs.getString("LOCN_TYPE"))+"&bed_num="+checkForNull(rs.getString("BED_NUM"))+"&room_num="+checkForNull(rs.getString("ROOM_NUM"))+"&discharge_date="+checkForNull(rs.getString("DISCHARGE_DATE_TIME"))+"&visit_adm_date="+checkForNull(rs.getString("VISIT_ADM_DATE_TIME"))+"&Sex="+checkForNull(rs.getString("SEX"))+"&Dob="+checkForNull(rs.getString("DATE_OF_BIRTH"))+"&episode_Status="+checkForNull(rs.getString("ADT_STATUS"))+"&patient_class="+patient_class+"&function_id="+function_id);
						
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();

			}
			
			if(practitioner_name==null || practitioner_name.equals(""))
			{
				query = "SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID = ?";
				stmt = con.prepareStatement(query);
				stmt.setString(1, login_user);

				rs = stmt.executeQuery();
				if (rs.next())
				{
					ca_practitioner_id = rs.getString("FUNC_ROLE_ID")==null?"":rs.getString("FUNC_ROLE_ID");
				}

				if(rs != null) rs.close();
				if(stmt != null) stmt.close();

				query = "SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER WHERE PRACTITIONER_ID = ?";
				stmt = con.prepareStatement(query);
				stmt.setString(1, ca_practitioner_id);

				rs = stmt.executeQuery();
				if (rs.next())
				{
					practitioner_name = rs.getString("PRACTITIONER_NAME")==null?"":rs.getString("PRACTITIONER_NAME");
				}

				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			session.setAttribute("ca_practitioner_id",ca_practitioner_id.toUpperCase()) ;
			session.setAttribute("practitioner_name",practitioner_name.toUpperCase()) ;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}

	}
	else
	{
		out.println("<script>alert(getMessage('PAT_CLASS_ENC_ID_NOT_PASSED','OR'));");
		out.println("window.close();</script>");
	}
	queryString.append("&invoke_function=PLACE_ORDER");
	queryString.append("&cnsnt_with_order_yn="+cnsnt_with_order_yn); //IN057196
	if(patient_class.equals("XT"))
		queryString.append("&patient_id="+patient_id);
		queryString.append("&episode_id=");//IN049213

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fileName));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(queryString.toString()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            _bw.write(_wl_block13Bytes, _wl_block13);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderEntry.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
