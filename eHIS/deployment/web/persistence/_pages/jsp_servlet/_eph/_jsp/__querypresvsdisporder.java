package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __querypresvsdisporder extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/QueryPresVsDispOrder.jsp", 1709121363955L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--This file is saved on 28/10/2005-->\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t\t<title></title>\n\t\t<!-- <link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../ePH/js/QueryPresVsDispDrug.js\"></script> \n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" topmargin=\'0\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"99%\" align=\"center\" topmargin=\'0\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t\t\t\t<td width=\"20%\" class=\"white\">&nbsp;\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" topmargin=\'0\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th width=\"20%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t\t\t<th width=\"10%\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t\t\t<th width=\"20%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th> \n\t\t\t\t\t\t<th width=\"15%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t\t\t\t<th width=\"10%\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t\t\t<th width=\"23%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t\t\t\t<th width=\"2%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' style=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" onclick=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">&nbsp;";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbsp;</td>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));</script>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t</table>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		//Search Criteria's from Query Criteria page

		String	order_id		=	request.getParameter("order_id");
		String	dt_from			=	request.getParameter("dt_from");
		String  dt_to			=	request.getParameter("dt_to");
		String  order_type		=	request.getParameter("order_type");
		String  order_status	=	request.getParameter("order_status");
		String  patient_class	=	request.getParameter("patient_class");
		String  location_type	=	request.getParameter("location_type");
		String  location_code	=	request.getParameter("location_code");
		String  disp_locn_code	=	request.getParameter("disp_locn_code");
		String  patient_id		=	request.getParameter("patient_id");
		//out.println("disp_locn_code--->" +disp_locn_code+ "in order.jsp");

		String ord[]		= request.getParameterValues("orderbycolumns");
		boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
		try{

			dt_from		 = CommonBean.checkForNull( dt_from);
			dt_to		 = CommonBean.checkForNull( dt_to );
			order_type = CommonBean.checkForNull( order_type );
			order_id	 = CommonBean.checkForNull( order_id );
			order_status	 = CommonBean.checkForNull( order_status );
			location_type	 = CommonBean.checkForNull( location_type );
			location_code	 = CommonBean.checkForNull( location_code );
			disp_locn_code	 = CommonBean.checkForNull( disp_locn_code );
			patient_id		=	CommonBean.checkForNull( patient_id );
			//Common parameters.
			HashMap sqlMap = new HashMap();
			ArrayList chkFields = new ArrayList();

			//include all the common parameters.
			//String sql=PhRepository.getPhKeyValue("SQL_PH_PRESVSDISP_ORDER_SELECT");
			//	String sql="SELECT   DISTINCT A.ORDER_ID,   TO_CHAR(A.ORD_DATE_TIME,'dd/mm/yyyy hh24:mi') ORD_DATE_TIME, B.PRACTITIONER_NAME,   Ph_Order_Source(  A.SOURCE_CODE,   A.PATIENT_CLASS,   A.ORDERING_FACILITY_ID,A.SOURCE_TYPE,?) LOCATION,   A.PATIENT_ID,   C.PATIENT_NAME,   D.ORDER_STATUS_TYPE,   (SELECT SHORT_DESC FROM PH_DISP_LOCN WHERE DISP_LOCN_CODE=E.DISP_LOCN_CODE AND FACILITY_ID=E.FACILITY_ID)   DISP_LOCN FROM    OR_ORDER A,   AM_PRACTITIONER B,   MP_PATIENT C,   OR_ORDER_STATUS_CODE D ,   PH_DISP_HDR E WHERE    A.ORD_PRACT_ID=B.PRACTITIONER_ID AND   A.PATIENT_ID=C.PATIENT_ID AND   A.ORDER_ID=E.ORDER_ID(+)   AND   A.ORDER_STATUS=D.ORDER_STATUS_CODE AND   ORDER_CATEGORY='PH' AND   order_status_type IN (25,30,35,56,58,10)";  //Modified query on 23/10/09
			String sql="SELECT   DISTINCT A.ORDER_ID,   TO_CHAR(A.ORD_DATE_TIME,'dd/mm/yyyy hh24:mi') ORD_DATE_TIME, B.PRACTITIONER_NAME,   Ph_Order_Source(  A.SOURCE_CODE,   A.PATIENT_CLASS,   A.ORDERING_FACILITY_ID,A.SOURCE_TYPE,?) LOCATION,   A.PATIENT_ID,   nvl(decode(?,'en',c.patient_name,PATIENT_NAME_LOC_LANG),c.patient_name)patient_name,   D.ORDER_STATUS_TYPE,   (SELECT SHORT_DESC FROM PH_DISP_LOCN_lang_vw WHERE DISP_LOCN_CODE=E.DISP_LOCN_CODE AND FACILITY_ID=E.FACILITY_ID and language_id =?)   DISP_LOCN FROM    OR_ORDER A,   am_practitioner_lang_vw b,   MP_PATIENT C,   OR_ORDER_STATUS_CODE D ,   PH_DISP_HDR E WHERE    A.ORD_PRACT_ID=B.PRACTITIONER_ID AND   A.PATIENT_ID=C.PATIENT_ID AND   A.ORDER_ID=E.ORDER_ID(+)   AND   A.ORDER_STATUS=D.ORDER_STATUS_CODE AND   ORDER_CATEGORY='PH' AND   order_status_type IN (25,30,35,56,58,10) "; //Modified query for getting dipslocation in locale language===for 25317incident on 10/DEC/2010

			chkFields.add( locale.trim() );
			chkFields.add( locale.trim() );
			chkFields.add( locale.trim() );
			//Append query conditions here
			//Add conditions based on parameters passed

			// If order_type (priority) is specified
			if ( (!(order_type.equals("")))&&(order_type!=null)){
				sql=sql+" AND A.PRIORITY=?";
				chkFields.add( order_type.trim() );
			}
			//out.println(patient_id);
			// If patient id  is specified
			if ( (!patient_id.equals("") && !patient_id.equals("null"))){
				sql=sql+" AND A.PATIENT_ID=?";
				chkFields.add( patient_id.trim() );
			}

			// If Order_id is specified

			if ( (!(order_id.equals("")))&&(order_id!=null)){
				sql=sql+" AND UPPER(A.ORDER_ID)=UPPER(?)";
				chkFields.add( order_id.trim() );
			}
			if ( (!(order_status.equals("")))&&(order_status!=null)){
				if (order_status.equals("FD"))
					sql=sql+" AND ORDER_STATUS_TYPE=58 ";
				else if (order_status.equals("PD"))
					sql=sql+" AND ORDER_STATUS_TYPE=56 ";
				//else if (order_status.equals("PND"))
				//sql=sql+" AND ORDER_STATUS_TYPE IN (10,25,30,35) ";
				// added by gangadharan for SRR20056-SCF-7232 , incident no. 27232 on 20/5/2011 
				// less than 10 is given while checking outstanding orders, because to 
				// include pending special approval, pending consent, pending authorization also 
				// 36,94 have been added to include allocated and uncollected which was missing 
				// before while checking for inprocess orders 
				else if (order_status.equals("OUT")) 
					sql=sql+" AND ORDER_STATUS_TYPE <=10 ";
				else if (order_status.equals("INP"))
					sql=sql+" AND ORDER_STATUS_TYPE IN (25,30,35,36,94)  ";
				// added ends 
			}
			if ( (!(patient_class.equals("")))&&(patient_class!=null)){
				sql=sql+" AND A.PATIENT_CLASS=?";
				chkFields.add( patient_class.trim() );
			}
			if ( (!(location_type.equals("")))&&(location_type!=null)){
				sql=sql+" AND A.SOURCE_TYPE=?";
				chkFields.add( location_type.trim() );
			}

			if ( (!(location_code.equals("")))&&(location_code!=null)){
				sql=sql+" AND A.SOURCE_CODE=?";
				chkFields.add( location_code.trim() );
			}

			if ( (disp_locn_code!=null) && !(disp_locn_code.equals("")) && !(disp_locn_code.equals("null"))){
				out.println("entered");
				sql=sql+" AND NVL(E.DISP_LOCN_CODE,'x')=NVL(?,'x')";
				chkFields.add( disp_locn_code.trim() );
			}
			if ( (!(dt_from.equals("")))&&(dt_from!=null)){
				//if from date is specified
				if ( (!(dt_to.equals("")))&&(dt_to!=null)){
					//if to date is also  specified
					sql=sql+" AND A.ORD_DATE_TIME BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') + 0.999 ";
					chkFields.add( dt_from.trim() );
					chkFields.add( dt_to.trim() );
				}
				else{
					// if todate is not specified
					sql=sql+" AND A.ORD_DATE_TIME >= TO_DATE(?,'DD/MM/YYYY') ";
					chkFields.add( dt_from.trim() );
				}

			}
			else{
				if ( (!(dt_to.equals("")))&&(dt_to!=null)){
				//if only  to date is  specified
				sql=sql+" AND A.ORD_DATE_TIME <= TO_DATE(?,'DD/MM/YYYY') + 0.999 ";
				chkFields.add( dt_to.trim() );

				}
			}
			chkFields.add( locale.trim() );
			sql=sql+" and b.language_id = ? ORDER BY to_date(ord_date_time, 'dd/mm/yyyy hh24:mi' )DESC, A.ORDER_ID"; // added to_date(ord_date_time, 'dd/mm/yyyy hh24:mi' )DESC, for KAUH-SCF-040 [IN033356]
			//End of concatenating search conditions
			sqlMap.put( "sqlData",  sql);

			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields are going to be display
			ArrayList displayFields = new ArrayList();
			displayFields.add("ORD_DATE_TIME");
			displayFields.add("ORDER_ID");
			displayFields.add("PRACTITIONER_NAME");
			displayFields.add("LOCATION");
			displayFields.add("PATIENT_ID");
			displayFields.add("PATIENT_NAME");
			displayFields.add("ORDER_STATUS_TYPE");
			displayFields.add("DISP_LOCN");
			//displayFields.add("DISP_LOCN_CODE");


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
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

					//Retriving the records from result arraylist
					ArrayList records=new ArrayList();
					String classvalue="",colorCode="", dkVal="", orderCode="", dispStyle="", evtmthd="";
					for(int recCount=2; recCount<result.size(); recCount++) {
						if ( recCount % 2 == 0 )
							classvalue = "QRYODDSMALL" ;
						else
							classvalue = "QRYEVENSMALL" ;

            _bw.write(_wl_block18Bytes, _wl_block18);

						records=(ArrayList) result.get( recCount );
						orderCode= (String)records.get( 6 );
						for(int colCount=0; colCount<records.size(); colCount++){
							if (colCount==7)
								continue;
							dkVal = (String)records.get( colCount )==null?"":(String)records.get( colCount );
							dispStyle="";
							evtmthd="";
							if(colCount==0 ){
								dkVal	=	com.ehis.util.DateUtils.convertDate(dkVal,"DMYHM","en",locale);
							}
							else if (colCount==1){ 
								//Check if link has to be given
								if (orderCode.equals("58")||orderCode.equals("56") ){
									dispStyle = "cursor:pointer;color:blue;";
									evtmthd = "loadOrderDetails('"+dkVal+"','"+(String)records.get(7)+"');";
								}
							}
							else if (colCount==6){
								dkVal = "";
								if (orderCode.equals("58"))
									dispStyle = "background-color:#990000";
								else if(orderCode.equals("56"))
									dispStyle = "background-color:#CC9933";
								else if(orderCode.equals("10") || orderCode.equals("05")  || orderCode.equals("03") ||orderCode.equals("00")  )
									dispStyle = "background-color:#FF0000";
								else
									dispStyle = "background-color:green";
							}

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(dispStyle));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(evtmthd));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dkVal));
            _bw.write(_wl_block23Bytes, _wl_block23);

						}
					}		//end of record count
				}
				else{

            _bw.write(_wl_block24Bytes, _wl_block24);

			}

            _bw.write(_wl_block25Bytes, _wl_block25);

			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryPresVsDispOrder.jsp", searched) );
		}//end of try
		catch (Exception e){
			e.printStackTrace();
		}

            _bw.write(_wl_block26Bytes, _wl_block26);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Date/Time.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderID.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderedBy.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
