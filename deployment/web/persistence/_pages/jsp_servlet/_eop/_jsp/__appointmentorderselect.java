package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eOR.*;
import eOR.Common.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __appointmentorderselect extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/AppointmentOrderSelect.jsp", 1709293420768L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\t\n\t<script src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\"JavaScript\" src=\"../js/Orderable.js\"></script>\n\t<Script src=\"../../eOP/js/VisitRegistration1.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\t<script>\n\tfunction getDescriptionOrder(obj,key,count)\n\t{  \n\t\tvar rowno=rowno-1; \n\t\tvar bean_id=document.getElementById(\"bean_id\").value;\n\t\tvar bean_name=document.getElementById(\"bean_name\").value;\n\t\t/*var value=eval(\"document.getElementById(\"short_desc\")\"+count).value;\n\t\tvar order_type_code=eval(\"document.getElementById(\"order_type_code1\")\"+count).value; \n\t\tvar order_category=eval(\"document.getElementById(\"order_category1\")\"+count).value; */\n\t\t\n\t\tvar value=document.getElementById(\'short_desc\'+count).value;\n\t\tvar order_type_code=document.getElementById(\'order_type_code1\'+count).value;\n\t\tvar order_category=document.getElementById(\'order_category1\'+count).value;\n\t\t/*value=document.getElementById(\"short_desc\")+count+.value;\n\t\torder_type_code=document.getElementById(\"order_type_code1\")+count+.value; \n\t\torder_category=document.getElementById(\"order_category1\")+count+.value; */\t\t\t\n\t\t/*alert(\"value==>\"+value);\n\t\talert(\"order_type_code===>\"+order_type_code);\n\t\talert(\"order_category===>\"+order_category);\t*/\n\t\t\n\t\t\n\t\tif(obj.checked)\n\t\t{\t\n\t\t\t\n\t\t\tvar functional_mode=\"Add_Temp_Order_Catalog\";\n\t\t\tvar order=\"validate=\"+functional_mode+\"&key=\"+key+\"&value=\"+encodeURIComponent(value)+\"&bean_id=\"+bean_id+\"&bean_name=\"+bean_name+\"&order_type_code=\"+order_type_code+\"&order_category=\"+order_category;\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\n\t\t\txmlStr =\"<root><SEARCH \" ;\n\t\t\txmlStr +=\" /></root>\" ;\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\t\t\t\n\t\t\t\n\t\t\txmlHttp.open( \"POST\", \"../../eOR/jsp/OrderableValidate.jsp?\"+order,false ) ;\n\t\t\txmlHttp.send( xmlDoc ) ;\n\t\t\tresponseText=xmlHttp.responseText ; \n\t\t\tvar responseTxt = eval(responseText); \n\t\t\tif(responseTxt==\"ORDER_SET_SELECTED\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"ORDER_SET_SELECTED\",\"OR\"));\n\t\t\t\tobj.checked = false;\n\t\t\t\treturn; // Don\'t allow the user to select more than one\n\t\t\t}\n\t\t\n\t\t}\n\t\telse \n\t\t{ \n\t\t\t\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\n\t\t\tvar functional_mode=\"Remove_Temp_Order_Catalog\";\n\t\t\txmlStr =\"<root><SEARCH \" ;\n\t\t\txmlStr +=\" /></root>\" ;\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\n\t\t\txmlHttp.open( \"POST\", \"../../eOR/jsp/OrderableValidate.jsp?validate=\"+functional_mode+\"&key=\"+key+\"&value=\"+encodeURIComponent(value)+\"&bean_id=\"+bean_id+\"&bean_name=\"+bean_name+\"&order_type_code=\"+order_type_code+\"&order_category=\"+order_category,false ) ;\n\t\t\txmlHttp.send( xmlDoc ) ;\n\t\t\tresponseText=xmlHttp.responseText ;\n\t\t\teval(responseText );\n\t\t}\n\t\t\n}\n\tfunction addCatalog(orderSet)\n\t{ \n\t\treturn orderSet;\n\t}\n\t\n\t</script>\n\t\n</head>\n<body class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onunload=\"SelectOrderUnload()\">\n<!-- <form name=\'AppointmentOrderResult\' id=\'AppointmentOrderResult\' action=\"AppointmentOrderSelect.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  method=\'post\'>-->\n\t\t <form name=\'AppointmentOrderResult\' id=\'AppointmentOrderResult\' action=\"AppointmentOrderSelect.jsp\"  method=\'post\'>\n\t\t\t<input type=hidden name=\'bean_id\' id=\'bean_id\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t<input type=hidden name=\'bean_name\' id=\'bean_name\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\n<table>\t \n \t<tr><td clospan=\'3\'><div style=\"position:relative;height:8vh0px;width:780px;vertical-align:top;overflow:auto\"> \n\t  <table border=\'10\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n           \n\t\t\t<tr>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' align=\'left\'><input type=\'checkbox\' name=\"chk";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" id=\"chk";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="$$";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"  >\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\"option_id";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"option_id";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\t\t\t\n\t\t\t<input type=\"hidden\" name=\"short_desc";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"short_desc";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_type_code1";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"order_type_code1";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_category1";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"order_category1";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\n            \n\t\t\t</td></tr>\t\n\t\t\t<script>document.AppointmentOrderResult.chk";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =".checked=true;getDescriptionOrder(document.AppointmentOrderResult.chk";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =",decodeURIComponent(document.AppointmentOrderResult.option_id";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =".value,\'UTF-8\'),\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\");document.AppointmentOrderResult.chk";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =".disabled=true;</script>\n\t\t\t\t\n          ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\n\t</table></div></td></tr>\t\n\t<tr><td clospan=\'3\'>&nbsp;</td></tr>\n\t<tr><td clospan=\'3\' align=\'center\' class=\'button\'><input type=\'button\' name=\"clicksubmit\" id=\"clicksubmit\"  value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'  onclick=\'submitOrderable()\' class=\'BUTTON\'>&nbsp;&nbsp;&nbsp;</td></tr>\n\t</table>\t\t\t\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\n<script>\n\n/*setTimeout(\"SelectOrder()\",500);\nfunction SelectOrder(){\ndocument.AppointmentOrderResult.clicksubmit.onclick();\n}*/\nvar call_count=1;\nfunction SelectOrderUnload(){\n if(call_count==\"1\")submitOrderable();\n}\nfunction submitOrderable()\n{  \n    call_count=call_count+1;  \n\t\n\tvar bean_id=document.getElementById(\"bean_id\").value;\n\tvar bean_name=document.getElementById(\"bean_name\").value;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\t\n\tvar functional_mode=\"Submit_Order_Catalog\";\n\txmlStr =\"<root><SEARCH \" ;\n\txmlStr +=\" /></root>\" ;  \n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\n\txmlHttp.open( \"POST\", \"../../eOR/jsp/OrderableValidate.jsp?validate=\"+functional_mode+\"&bean_id=\"+bean_id+\"&bean_name=\"+bean_name,false ) ;\n\txmlHttp.send( xmlDoc ) ;\n\tresponseText=xmlHttp.responseText ; \n\teval(responseText ); \n\t//window.close();\t\n\tsetTimeout(\"Winclose()\",350);\n\t\n}\nfunction Winclose(){\nwindow.close();\n}\n</script>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

	
	request.setCharacterEncoding("UTF-8");
	String bean_id ="refusalOrdersBean";
	String bean_name = "eOR.RefusalOrdersBean";		
    localeName=(String)session.getAttribute("LOCALE");	
	RefusalOrdersBean beanObj = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;	
	beanObj.setLanguageId(localeName);

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block11Bytes, _wl_block11);

	String appt_ref_no= (request.getParameter("appt_ref_no")==null||request.getParameter("appt_ref_no").equals("null"))?"":request.getParameter("appt_ref_no");
	String appt_order= (request.getParameter("appt_order")==null||request.getParameter("appt_order").equals("null"))?"":request.getParameter("appt_order");
	String facility_id = (String)session.getValue("facility_id");
				
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = null;	
	int maxRecord = 0;
	int counts=0;
	String order_category1 = "",order_type_code1="";
	String option_id	= "";
	String short_desc	= "";
	int ilCkeckedYN = 0;		
	String checkProp = "";	
	String classValue="";			
	String validateIDFn="";
	StringBuffer sql = new StringBuffer();
	
	//putObjectInBean("refusalOrdersBean",beanObj,request);	

	try
	{
		con = ConnectionManager.getConnection(request);
		
		sql.append("SELECT   a.order_catalog_code, or_get_desc.or_order_catalog (a.order_catalog_code, '"+localeName+"','2') long_desc, order_catalog_nature order_catalog_nature, order_category, order_type_code FROM  or_order_catalog a, OR_APPT_REF_CATALOG b where APPT_REF_NO='"+appt_ref_no+"' and FACILITY_ID ='"+facility_id+"' and a.ORDER_CATALOG_CODE =b.ORDER_CATALOG_CODE");
	   
		pstmt = con.prepareStatement(sql.toString());
		rs = pstmt.executeQuery();
		//maxRecord = rs.getRow();
		//int tot_records=rs.getRow();
		
		
	

            _bw.write(_wl_block12Bytes, _wl_block12);
	while(rs.next())	
		{  
			
			counts++;
			option_id = rs.getString("order_catalog_code")==null?"":rs.getString("order_catalog_code");
			short_desc = rs.getString("long_desc")==null?"":rs.getString("long_desc");
			order_category1 = rs.getString("order_category")==null?"":rs.getString("order_category");
			order_type_code1 = rs.getString("order_type_code")==null?"":rs.getString("order_type_code");
		    
			//checkProp = " CHECKED "; 
						
			classValue="gridData";
			
			option_id=java.net.URLEncoder.encode(option_id,"UTF-8");  
			
			//validateIDFn ="onclick='getDescription(this,"+option_id+","+counts+")'";
			//validateIDFn ="onclick='getDescriptionOrder(this,"+option_id+","+counts+")'";
			//System.out.println("validateIDFn==>"+validateIDFn);
            
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(order_type_code1));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(order_category1));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_type_code1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_category1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block33Bytes, _wl_block33);
ilCkeckedYN = ilCkeckedYN + 1;		
			//i=i+1;			
				
		}	
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block35Bytes, _wl_block35);

		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(con != null)ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block36Bytes, _wl_block36);
putObjectInBean("refusalOrdersBean",beanObj,request);	
            _bw.write(_wl_block37Bytes, _wl_block37);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
