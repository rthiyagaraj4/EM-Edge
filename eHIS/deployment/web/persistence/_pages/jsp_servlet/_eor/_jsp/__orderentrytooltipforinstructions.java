package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentrytooltipforinstructions extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryToolTipForInstructions.jsp", 1709119836000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!-- \n-----------------------------------------------------------------------\nDate       \t\tEdit History     \tName        Rev.Date  \t Rev.By\t\tDescription\n-----------------------------------------------------------------------\n17/07/2018\t  \tIN064543\t\tKamalakannan\t17/07/2018\t\tRamesh G\t\tML-MMOH-CRF-0776\n-----------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/></link>\n\t</link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<title>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="-";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</title>\n\t</head>\n\t<body  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n\t\t<form name=\"placeOrderForm\" id=\"placeOrderForm\">\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<script>\n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\t\t\twindow.close();\n\t\t\t</script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\t\t<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\" class=\"grid\">\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"CAFIRSTSELECTHORZ\" onClick=\'sendKey(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\",\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\")\' ><a class=\'gridLink\' href=\'javascript:;\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a></td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td style=\'cursor:pointer\' id=\"catPanel";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" onClick=\'toggleTabColorForPanel(\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\");sendKey(\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\")\' ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="class=\'CASECONDSELECTHORZ\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="class=\'CAFIRSTSELECTHORZ\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="); onMouseOver=\"leftpaneMouseOver(this)\" onmouseout=\"leftpaneMouseOut(this)\"><a style=\'color:white;cursor:pointer\' href=\'#\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\t\t\t<tr >\n\t\t\t\t\t\t<td id=\"cat";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" style=\'cursor:pointer\' onClick=\'toggleTabColor(\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\");\' ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t<input type=\"hidden\" name=\"totalCount\" id=\"totalCount\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\n\t\t</form>\n\t\t<script language=\'javascript\'>\t\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\tparent.InstrnFrame.location.href = \"../../eOR/jsp/OrderEntryInstruction.jsp?";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&key=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"; \n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            eOR.OrderEntryQueryBean bean= null;{
                bean=(eOR.OrderEntryQueryBean)pageContext.getAttribute("bean");
                if(bean==null){
                    bean=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("bean",bean);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bean.checkForNull(request.getParameter("catalog_desc"), "")));
            _bw.write(_wl_block11Bytes, _wl_block11);
		
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String bean_id 					= request.getParameter("bean_id");
		String bean_name 				= request.getParameter("bean_name");
		bean.setLanguageId(localeName);
		Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
		String facility_id				= (String)session.getValue("facility_id");
		String measure_id 				= bean.checkForNull(request.getParameter("measure_id"), "");
		String catalog_code 				= bean.checkForNull(request.getParameter("catalog_code"), ""); 
		String order_catalog_nature		= bean.checkForNull(request.getParameter("order_catalog_nature"), "");
		String contr_msr_panel_id		= bean.checkForNull(request.getParameter("contr_msr_panel_id"), "");
		String category					= bean.checkForNull(request.getParameter("category"), "");	
		String encounter_id				= bean.checkForNull(request.getParameter("encounter_id"), "");	
		String patient_class			= bean.checkForNull(request.getParameter("patient_class"), "");	
		String admission_date			= bean.checkForNull(request.getParameter("admission_date"), "");	
		String discharge_date_time		= bean.checkForNull(request.getParameter("discharge_date_time"), "");	
		String pract_type		        = bean.checkForNull(request.getParameter("pract_type"), "");
		/* HashMap<String,String> Instructions = new HashMap<String,String>();
		HashMap<String,HashMap<String,String>> InstructionsForOrderSet  = new HashMap<String,HashMap<String,String>>(); *///commented for checkstyle
		ArrayList Panels				= bean.getPanelItems(properties, measure_id,order_catalog_nature,contr_msr_panel_id,category, facility_id,encounter_id,patient_class,admission_date,discharge_date_time,catalog_code,pract_type);// IN042045 included pract_type
		String key = "";
		String classValue				= "";
		LinkedHashMap<String,ArrayList<String>> mapCatcodeAndMsrpanelid= new LinkedHashMap<String,ArrayList<String>>();
		LinkedHashMap<String,ArrayList<String>> mapCatcodeAndMsrId= new LinkedHashMap<String,ArrayList<String>>();
		int cnt=0;
		if("P".equals(order_catalog_nature)){
			mapCatcodeAndMsrpanelid 	= bean.getCatalogCodeForMsrpanelid(contr_msr_panel_id);
		}else if("S".equals(order_catalog_nature)){
			mapCatcodeAndMsrId 	= bean.getCatalogCodeForMsrId(measure_id);
		}
		if(Panels!=null && Panels.size() == 0){  
		
            _bw.write(_wl_block12Bytes, _wl_block12);
		}

            _bw.write(_wl_block13Bytes, _wl_block13);

	if(!order_catalog_nature.equalsIgnoreCase("P") && !order_catalog_nature.equalsIgnoreCase("S")){
			if(Panels!=null && Panels.size() != 0)
			{  
				for(int k=0; k<Panels.size(); k++)
		   		{
					classValue="gridData";
		   			String[] record = (String[])Panels.get(k);
		   			System.out.println("Panels-->"+record[0]);
		   			

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bean.checkForNull( record[0],"")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean.checkForNull( record[1],"")));
            _bw.write(_wl_block17Bytes, _wl_block17);
				}
				
				
				String[] keygetter = new String[1];
				ArrayList keyForPanel = null;
				if("P".equals(order_catalog_nature)){
					keygetter=(String[])Panels.get(0);
					keyForPanel = mapCatcodeAndMsrpanelid.get(bean.checkForNull( keygetter[0],""));
					key = (String)keyForPanel.get(0); 
				}
			}	
			if(Panels!=null) {
				Panels.clear();  Panels = null;
			}
			
	}		
	/****************************************************************************************
	******PANEL AREA START
	*****************************************************************************************/
	if("P".equalsIgnoreCase(order_catalog_nature)){		
			if(mapCatcodeAndMsrpanelid!=null && mapCatcodeAndMsrpanelid.size() == 0){  
		
            _bw.write(_wl_block12Bytes, _wl_block12);
		}

            _bw.write(_wl_block13Bytes, _wl_block13);

			if(mapCatcodeAndMsrpanelid!=null && mapCatcodeAndMsrpanelid.size() != 0)
			{  
				 			
					classValue="gridData";
		   			ArrayList record = new ArrayList();
		   			for (String keys : mapCatcodeAndMsrpanelid.keySet()) {
		   				record = mapCatcodeAndMsrpanelid.get(keys);

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.checkForNull( (String)record.get(0),"")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block21Bytes, _wl_block21);
if(cnt==0){
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{
            _bw.write(_wl_block23Bytes, _wl_block23);
} 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bean.checkForNull( (String)record.get(1),"")));
            _bw.write(_wl_block17Bytes, _wl_block17);
					cnt++;
}
				ArrayList keyForPanel = null;
				for (String keys : mapCatcodeAndMsrpanelid.keySet()) {
					keyForPanel = mapCatcodeAndMsrpanelid.get(keys);
					key = (String)keyForPanel.get(0);
					break;
				}
			}	
			if(mapCatcodeAndMsrpanelid!=null) {
				mapCatcodeAndMsrpanelid.clear();  mapCatcodeAndMsrpanelid = null;
			}
	}	
	/****************************************************************************************
	******ORDERSET AREA START
	*****************************************************************************************/
	if("S".equalsIgnoreCase(order_catalog_nature)){		
			if(mapCatcodeAndMsrId!=null && mapCatcodeAndMsrId.size() == 0){  
		
            _bw.write(_wl_block12Bytes, _wl_block12);
		}

            _bw.write(_wl_block13Bytes, _wl_block13);

			if(mapCatcodeAndMsrId!=null && mapCatcodeAndMsrId.size() != 0)
			{  
				 			
					classValue="gridData";
		   			ArrayList record = new ArrayList();
		   			for (String keys : mapCatcodeAndMsrId.keySet()) {
		   				record = mapCatcodeAndMsrId.get(keys);

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.checkForNull( keys,"")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block27Bytes, _wl_block27);
if(cnt==0){
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{
            _bw.write(_wl_block23Bytes, _wl_block23);
} 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bean.checkForNull( (String)record.get(0),"")));
            _bw.write(_wl_block17Bytes, _wl_block17);
					cnt++;


	}
				//ArrayList keyForPanel = null;//commented for checkstyle
				for (String keys : mapCatcodeAndMsrId.keySet()) {
					key = keys;
					break;
				}
			}	
			if(mapCatcodeAndMsrpanelid!=null) {
				mapCatcodeAndMsrpanelid.clear();  mapCatcodeAndMsrpanelid = null;
			}
	}		

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block32Bytes, _wl_block32);
if(!key.equals("")||key!=null){
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(key));
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Instruction.label", java.lang.String .class,"key"));
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
