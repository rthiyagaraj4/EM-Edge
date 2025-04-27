package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;

public final class __copyordersvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/CopyOrdersValidate.jsp", 1722320136000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eOR.ExistingOrder beanObj= null;{
                beanObj=(eOR.ExistingOrder)pageContext.getAttribute("beanObj");
                if(beanObj==null){
                    beanObj=new eOR.ExistingOrder();
                    pageContext.setAttribute("beanObj",beanObj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	 request.setCharacterEncoding("UTF-8");

	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	String localeName = request.getParameter("localeName");
      beanObj.setLanguageId(localeName);
	//String practitioner_id 	= (String)session.getValue("ca_practitioner_id");
	String facility_id 		= (String)session.getValue("facility_id"); //--[IN029659]
	//String resp_id 			= (String)session.getValue("responsibility_id");

	//String xmlStr			= "'";
    StringBuffer xmlStr			= new StringBuffer();
	xmlStr.append("'");
    String errorMessage		= "";

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	//ExistingOrder beanObj = (ExistingOrder)mh.getBeanObject( bean_id, request , "eOR.ExistingOrder") ;
	//ExistingOrder beanObj = (ExistingOrder)getBeanObject( bean_id,  "eOR.ExistingOrder", request ) ;
	Properties properties			= (Properties) session.getValue( "jdbc" );

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	//--[IN029659] - start
	String patientId 				= (String)hash.get("patientId");
	String encounterId 				=  (String)hash.get("encounterId");
	String patientClass 				=  (String)hash.get("patientClass");
	String Adv_date = 				(String)beanObj.getDischargeAdvDateTime(patientId, encounterId);
	String[] Dis_dtl = new String[2] ;
	Dis_dtl = 				beanObj.getDischargeDateTime(patientId, encounterId);
	
	//--[IN029659] - end
    if ( validate.equals( "patient_class" ) ) {
		out.println( "clearPatientClassList('document') ; " ) ;
        ArrayList PatientClass = new ArrayList();
		//ArrayList OrderTypeData = beanObj.getLocation(facility_id, practitioner_id, locn_type) ;
		PatientClass = beanObj.getPatientClass(properties);

		for( int i=0 ; i< PatientClass.size() ; i++ ) {
			String[] record = (String[])PatientClass.get(i);
			out.println( "addPatientClassList(\"" + record[0] + "\",\"" + record[1] +  "\") ; " ) ;
		}
	}  else if (validate.equals("order_line_num")) {
		int totCount			= 0;
		int count				= Integer.parseInt(beanObj.checkForNull((String)hash.get("count"),"0"));
		String catelogStr		= "~";
		
		for (int j = 0;j < count;j++) 
		{
			String order_id 		= (String)hash.get("order_id"+j);
			String order_category	= (String)hash.get("order_category"+j);
			String order_type_code	= (String)hash.get("order_type_code"+j);
			String ord_cat_chk      = (String)beanObj.getCategoryChk(order_category, facility_id, encounterId, patientClass, Dis_dtl[0], Dis_dtl[1], Adv_date); //--[IN029659]
			
			//String xmlStr			= "'";
			if(ord_cat_chk == "" || ord_cat_chk == null)
			{
				//errorMessage	= "CONFIRM_COPY";
			} 
			else
			{
				ArrayList orderLineData	= new ArrayList();
				orderLineData			= beanObj.getOrderLineData(properties,order_id);
				for (int i = 0; i < orderLineData.size();i++) 
				{
					String [] record 	= (String[])orderLineData.get(i);
					if (catelogStr.indexOf("~"+record[1]+"~") != -1) 
					{
						errorMessage	= "DUPLICATE_ORDERABLES";
						//errorMessage	= "APP-OR0206 Orderables cannot be Duplicate";
						break;
					}
					//catelogStr += record[1] + "~";
					catelogStr =catelogStr+record[1] + "~";
					/*xmlStr += "order_id"+(totCount+i)+"=\""+ order_id +"\" " ;
					xmlStr += "order_line_num"+(totCount+i)+"=\""+ record[0] +"\" " ;
					xmlStr += "catalog_code"+(totCount+i)+"=\""+ record[1] +"\" " ;
					xmlStr += "order_category"+(totCount+i)+"=\""+ order_category +"\" " ;
					xmlStr += "order_type_code"+(totCount+i)+"=\""+ order_type_code +"\" " ;*/
					xmlStr.append("order_id"+(totCount+i)+"=\""+ order_id +"\" ");
					xmlStr.append("order_line_num"+(totCount+i)+"=\""+ record[0] +"\" ");
					xmlStr.append("catalog_code"+(totCount+i)+"=\""+ record[1] +"\" ");
					xmlStr.append("order_category"+(totCount+i)+"=\""+ order_category +"\" ");
					xmlStr.append("order_type_code"+(totCount+i)+"=\""+ order_type_code +"\" ");
				
				}
				//totCount += orderLineData.size();
				totCount =totCount+orderLineData.size();
			}
		}
		if(totCount == 0)
			errorMessage	= "CONFIRM_COPY"; //--[IN029659]
		out.println("totCountGlobal = "+totCount+";");
		out.println("errorMessage = \"" + errorMessage + "\";");
		out.println("xmlStr = " + xmlStr.toString()+"';");
	} else if (validate.equals("diag")) {
		String patient_id = (String)hash.get("patientId");
		ArrayList diagData	= new ArrayList();
		out.println( "clearDiagList('document') ; " ) ;
		diagData			= beanObj.getDiagnosisSpecific(properties, patient_id);

		for (int i = 0; i < diagData.size();i++) {
			String [] record	= (String[])diagData.get(i);
			out.println( "addDiagList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	} else if (validate.equals("diag_desc")) {
		String diag_code= beanObj.checkForNull(request.getParameter( "diag_code" ),"") ;
		String diag_desc		= beanObj.getDiagnosisDesc(properties, diag_code) ;
		if(diag_desc!=null)
			out.println( "addCareSetDiagnosisDesc('document.copy_orders_search',\"" +diag_desc+" \") ; " ) ;
	} //--[IN029659]-Start
	else if (validate.equals("order_line"))  
	{
		int totCount			= 0;
		int count				= Integer.parseInt(beanObj.checkForNull((String)hash.get("count"),"0"));
		
		String catelogStr		= "~";
		
		for (int j = 0;j < count;j++) 
		{
			String order_id 		= (String)hash.get("order_id"+j);
			String order_category	= (String)hash.get("order_category"+j);
			String order_type_code	= (String)hash.get("order_type_code"+j);
			String order_line_num	= (String)hash.get("order_line_num"+j);
			String catalog_code		= (String)hash.get("catalog_code"+j);
			String ord_cat_chk      = (String)beanObj.getCategoryChk(order_category, facility_id, encounterId, patientClass, Dis_dtl[0], Dis_dtl[1], Adv_date);
			
			if(ord_cat_chk == "" || ord_cat_chk == null)
			{
			//	errorMessage	= "CONFIRM_COPY";
			
			}
			else
			{
				catelogStr =catelogStr+catalog_code + "~";
				xmlStr.append("order_id"+(totCount)+"=\""+ order_id +"\" ");
				xmlStr.append("order_line_num"+(totCount)+"=\""+ order_line_num +"\" ");
				xmlStr.append("catalog_code"+(totCount)+"=\""+ catalog_code +"\" ");
				xmlStr.append("order_category"+(totCount)+"=\""+ order_category +"\" ");
				xmlStr.append("order_type_code"+(totCount)+"=\""+ order_type_code +"\" ");
				totCount =totCount+1;
			}
		}
		if(totCount == 0)
			errorMessage	= "CONFIRM_COPY";
		out.println("totCountGlobal = "+totCount+";");
		out.println("errorMessage = \"" + errorMessage + "\";");
		out.println("xmlStr = " + xmlStr.toString()+"';");

	} //--[IN029659] - end

	//putObjectInBean(bean_id,beanObj,request);

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
