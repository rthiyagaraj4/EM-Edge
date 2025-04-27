package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import eOR.*;
import webbeans.eCommon.*;
import eCA.CommonCollectionUtils;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __manageconsultorderdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ManageConsultOrderDetail.jsp", 1709119732000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/OrCommon.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n\t<script language=\'javascript\' src=\'../../eOR/js/OROrderEntryRepGrp.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body>\n<form name=\'OROrderentryreportgrp1\' id=\'OROrderentryreportgrp1\'>\n<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'50%\' align=\'center\'>\n\t<tr>\n\t <td class=\'white\' width=\'100%\'></td> \n\t<td class=\'label\' width=\'16%\' align=\'right\' nowrap>\n\t\t</td>\n\t</tr>\n</table>\t\n<table border=\'0\' class=\"grid\" cellpadding=\'3\' cellspacing=\'0\' width=\"50%\" align=\'center\'>\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\'  width=\"30%\" height=\"20\" nowrap>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" \n\t\t</td>\n\t</tr>\t\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"gridHeader\">Package Ref</td>\n\t\t\t\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"gridHeader\">Valid Period</td>\n\t\t\t\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"gridHeader\">\n\t\t\t\t\t\t\t\t\t\tOrder ID\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"gridHeader\">\n\t\t\t\t\t\t\t\t\t\tDescription\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"gridHeader\">\n\t\t\t\t\t\t\t\t\t\tSpeciality\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"gridHeader\">\n\t\t\t\t\t\t\t\t\t\tPractitioner\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"gridHeader\">\n\t\t\t\t\t\t\t\t\t\tLocation\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"gridHeader\">\n\t\t\t\t\t\t\t\t\t\tConsult Date\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"gridHeader\">\n\t\t\t\t\t\t\t\t\t\tStatus\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\"gridData\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"gridData\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t<input type = \"hidden\" name=\"catalog_code";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" id=\"catalog_code";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" value =\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"gridData\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t<input type = \"hidden\" name=\"SPECILITY_CODE";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"SPECILITY_CODE";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"gridData\">\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t<input type = \"hidden\" name=\"PRACITIONER_ID";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"PRACITIONER_ID";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<input type = \"hidden\" name=\"LOCATION_CODE";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"LOCATION_CODE";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n</table>\n<!-- Next, Prev --> \n<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >\n<input type=\"hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n<!-- Next, Prev Till here--> \n</form>\n</body>\n</html>\n\n\t\n\n\n\t\n\n\n\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	java.util.Properties props = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) props.getProperty("LOCALE");
	String bean_id = "Or_ManageConsOrders" ;
	String bean_name = "eOR.ManageConsultOrders";
	ManageConsultOrders ConsultOrdersBean = (ManageConsultOrders)getObjectFromBean(bean_id,bean_name,session);	
	ConsultOrdersBean.setLanguageId(localeName);

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
	//String sql="";
	//String ordertypes="";
	//String ordertypecode="";
	//String order_category=request.getParameter("order_category")==null?"RX":request.getParameter("order_category");
	//String cust_rep_grp_code=request.getParameter("cust_rep_grp_code")==null?"1":request.getParameter("cust_rep_grp_code");
	//String mode = request.getParameter("mode")==null ? "" : request.getParameter("mode");
	String from	 = ConsultOrdersBean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = ConsultOrdersBean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start = Integer.parseInt(from);
	int end   = Integer.parseInt(to);
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String facility_id = (String)session.getValue("facility_id");
	//int rowCount = 0;
	//int maxRecord = 0;
	String error_msg = "";	
	end = Integer.parseInt(to);
	start = Integer.parseInt(from);	
	//CommonCollectionUtils<String, String> orderTypeMap = null;
	List<String[]> Consultlst = null;	
	try 
	{		
		Consultlst = ConsultOrdersBean.loadConsultOrders(facility_id,encounter_id,""); 

	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

			//String slClassValue="gridData";
			String temp_billing_package_ref = "";
			try{ 		
					if(Consultlst != null && Consultlst.size() > 0)
					{
						for( int k=0 ; k< Consultlst.size() ; k++ ) 
						{
							String[] record = (String[])Consultlst.get(k);
							String BILLING_PACKAGE_REF = record[0]==null?"":record[0];
							//String PACK_START_DATE = record[1]==null?"":record[1];
							//String PACK_END_DATE = record[2]==null?"":record[2];
							String ORDER_ID = record[3]==null?"":record[3];
							String CATATLOG_CODE = record[4]==null?"":record[4];
							String CATALOG_DESC = record[5]==null?"":record[5];
							String SPECILITY_CODE = record[6]==null?"":record[6];
							String SPECIALITY_DESC = record[7]==null?"":record[7];
							String PRACITIONER_ID = record[8]==null?"":record[8];
							String PRACT_NAME = record[9]==null?"":record[9];
							String LOCATION_CODE = record[10]==null?"":record[10];
							String CLINIC_DESC = record[11]==null?"":record[11];
							String CONSULT_DATE_STR = record[12]==null?"":record[12];
							//String ORDER_STATUS_DESC = record[13]==null?"":record[13];
							String CURRENT_STATUS = record[14]==null?"":record[14];
							if(!temp_billing_package_ref.equalsIgnoreCase(BILLING_PACKAGE_REF))
							{
								temp_billing_package_ref = BILLING_PACKAGE_REF;
								
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(BILLING_PACKAGE_REF));
            _bw.write(_wl_block12Bytes, _wl_block12);

							}
							
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ORDER_ID));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(CATALOG_DESC));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(k));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(CATATLOG_CODE));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(SPECIALITY_DESC));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(k));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(SPECILITY_CODE));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(PRACT_NAME));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(k));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(k));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(PRACITIONER_ID));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(CLINIC_DESC));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(k));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(k));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(LOCATION_CODE));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(CONSULT_DATE_STR));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(CURRENT_STATUS));
            _bw.write(_wl_block26Bytes, _wl_block26);

						}							
					}
					else
					{
						error_msg ="NO_RECORD_FOUND_FOR_CRITERIA";
						out.println("<script>alert(getMessage('"+error_msg+"','Common'));</script>");						
						out.println("<script>document.URL='../../eCommon/html/blank.html'</script>");
					}
					
			}catch(Exception e)
			{
				System.out.println("Exception in OROrderEntryRepGrpDetail.jsp---"+e.toString());
				e.printStackTrace(System.err);
			}
			
		
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(from));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(to));
            _bw.write(_wl_block29Bytes, _wl_block29);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ApplicableOrderType.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Applicable.label", java.lang.String .class,"key"));
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
}
