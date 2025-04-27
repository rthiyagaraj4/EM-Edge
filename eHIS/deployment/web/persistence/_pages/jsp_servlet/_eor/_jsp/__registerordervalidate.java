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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __registerordervalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/RegisterOrderValidate.jsp", 1731409644000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 /*
--------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name		Rev.Date	Rev.Name	Description
--------------------------------------------------------------------------------------------------------------------------------
?             100            ?           created
06/09/2011    IN31901        NijithaS    Incident No: IN31901 - Bru-HIMS-CRF-263		 
15/12/2017	IN065942		Dinesh T	15/12/2017	Ramesh G	In Nuclear medicine  department we required the 																				barcode functionality at the time of 																							Registration of order,required patient 																							Id,patient name,age,sex,register date and name 																					of study.
23/04/2020	  IN071618	   Nijitha S	 					PMG2019-MMS-CRF-0004
--------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

try
{
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	String flag		= request.getParameter("flag");
	String login_value		= request.getParameter("login_value");
	String facility_id 		= (String)session.getValue("facility_id")==null?"":(String)session.getValue("facility_id");
	String value="";

	String practitioner_id	 =(String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");
	
	String resp_id 			=(String)session.getValue("responsibility_id")==null?"":(String)session.getValue("responsibility_id");


	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	RegisterOrder beanObj = (RegisterOrder)getBeanObject( bean_id, "eOR.RegisterOrder" , request) ;
	beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	OnLinePrinting online_print = new OnLinePrinting();//IN065942
    if (flag == null || flag.equals("")) {
		if ( validate.equals( "location" ) ) {
			String locn_type = (String)hash.get("location_type") ;
			out.println( "clearList('document') ; " ) ;

			ArrayList OrderTypeData = beanObj.getLocation(locn_type) ;
			
			for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
				String[] record = (String[])OrderTypeData.get(i);
				out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
			}
		}
	} else if (flag.equalsIgnoreCase("true")) {
		if ( validate.equals( "ord_cat" ) ) {
			
			out.println( "clearCategoryList('document') ; " ) ;
            ArrayList OrderTypeData = new ArrayList();
			if (practitioner_id != null && !practitioner_id.equals("")){
				
				OrderTypeData = beanObj.getOrderCategoryByPract(practitioner_id);
				value="pract";
				}
			if ((OrderTypeData.size() == 0) && ((resp_id != null) && (!resp_id.equals(""))) ) {
				OrderTypeData = beanObj.getOrderCategoryByResp(resp_id);
				value="resp";
				
			}

			for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
				String[] record = (String[])OrderTypeData.get(i);
				String selected = "false";
				
				if (OrderTypeData.size() == 1 && i == 0) {
					
					selected = "true";
				}
				out.println( "addCategoryList(\"" + record[0] + "\",\"" + record[1] + "\",\"" + selected + "\") ; " ) ;
				out.println( "setvalue(\"" + value+ "\") ; " ) ;

				if (OrderTypeData.size() == 1) {
					out.println("populateLocnOrdType('ord_type');");
				} else {
					out.println("formObj.ord_cat.value='';");
				}
			}
		
		} else if ( validate.equals( "ord_type" ) ) {
			String orderCategory = (String)hash.get("ord_cat") ;
			String isRDInstalled_yn="";
			String isOTInstalled_yn="";

			out.println( "clearTypeList('document') ; " ) ;
			
			if(orderCategory!="")
				{
					if(orderCategory.equalsIgnoreCase("RD"))
					{
						isRDInstalled_yn = (String) beanObj.isModuleInstalled(facility_id,"RD");
						out.println( "setRDvalue(\"" + isRDInstalled_yn+ "\") ; " ) ;
						if(isRDInstalled_yn.equalsIgnoreCase("Y"))
						{
							orderCategory="";
						}
					}
					
					/* else if(orderCategory.equalsIgnoreCase("OT"))
					{
						isOTInstalled_yn = (String) beanObj.isModuleInstalled(facility_id,"OT");
						out.println( "setOTvalue(\"" + isOTInstalled_yn+ "\") ; " ) ;
						if(isOTInstalled_yn.equalsIgnoreCase("Y"))
						{
							orderCategory="";
						}
					} */
				}
				if(orderCategory!="")
				{
					ArrayList OrderTypeData = new ArrayList();
					if(login_value.equalsIgnoreCase("pract"))
					{
						if (practitioner_id != null && !practitioner_id.equals(""))
						{	
							OrderTypeData = beanObj.getOrderTypeByPract(orderCategory, practitioner_id);
						}
					}
					else if(login_value.equalsIgnoreCase("resp"))
					{
						if ((OrderTypeData.size() == 0) && ((resp_id != null) && (!resp_id.equals(""))) ) {
							OrderTypeData = beanObj.getOrderTypeByResp(orderCategory,resp_id);
					}
				}

				for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
					String[] record = (String[])OrderTypeData.get(i);
					out.println( "addTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				}
				//String order_type = "" ;
				
            		//out.println( "clearPerformingLocnList('document') ; " ) ;
					//ArrayList PerformingLocn = new ArrayList();
					
	            	//PerformingLocn = beanObj.getPerformingLocn(orderCategory);
				

					//for( int i=0 ; i< PerformingLocn.size() ; i++ ) {
						//String[] record = (String[])PerformingLocn.get(i);
						//out.println( "addPerformingLocnList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
					//}
							
		}
		} else if ( validate.equals( "PERFORM_LOCN_INT_OR_EXT" ) ) {
		 
		} else if ( validate.equals( "CHANGE_PERFORM_LOCN" ) ) {
		     
		      String performing_facility = (String)hash.get("performing_facility") ;
		      String order_category = (String)hash.get("order_category") ;
		      String order_catalog_code = (String)hash.get("order_catalog_code") ;
		      out.println( "clearChangePerformLocnList('document') ; " ) ;
	            ArrayList PerformingLocn = new ArrayList();

				PerformingLocn = beanObj.getPerformingLocationDetails(performing_facility,order_category,order_catalog_code);

				for( int i=0 ; i< PerformingLocn.size() ; i++ ) {
					String[] record = (String[])PerformingLocn.get(i);
					out.println( "addChangePerformLocnList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				}
		} else if ( validate.equals( "CHECK_INT_OR_EXT" ) ) {
		    String int_or_ext = "";
		    String order_id = (String)hash.get("order_id") ;
			
			int_or_ext = beanObj.getIntOrExt(order_id);
			out.println( "formObj.int_or_ext.value='" + int_or_ext + "';" ) ;
		}else if ( validate.equals( "SET_REF_CONTENT" ) ) {
		    String ref_form_text = "";
		    String ref_form_id = (String)hash.get("ref_form_id") ;
			ref_form_text = (String ) beanObj.getRefFormContent(ref_form_id);
			beanObj.setRefFormContent(ref_form_text);
			
		}else if ( validate.equals( "activity_type" ) ) {
			//String order_category = request.getParameter("order_category");
			//String order_type = request.getParameter("order_type") ;
	
            	//out.println( "clearPerformingLocnList('document') ; " ) ;
	            //ArrayList PerformingLocn = new ArrayList();
           		//PerformingLocn = beanObj.getPerformingLocn(order_category);
			
				//for( int i=0 ; i< PerformingLocn.size() ; i++ ) {
					//String[] record = (String[])PerformingLocn.get(i);
					//out.println( "addPerformingLocnList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				//}
						
		}
		else if ( validate.equals( "PRINT_REG_ORDER_LABEL" ) ) //IN065942, starts
		{
			Hashtable print_reg_order_lbls = beanObj.getPrintLabelValues();
			
			if(print_reg_order_lbls.size()>0)
			{
				online_print.printRegOrdLabel(print_reg_order_lbls, request, response);
				beanObj.clearPrintLabelValues();
			}
		}//IN065942, ends
		else if(validate.equals("CHECK_BILLSETTLEMENT"))//IN071618 Starts
		{
			String order_id = (String)hash.get("order_id");
			String ordering_facility = (String)hash.get("ordering_facility");
			String patient_class = (String)hash.get("patient_class");
			String patient_id = (String)hash.get("patient_id");
			String encounter_id = (String)hash.get("encounter_id");
			String rec_num = (String)hash.get("rec_num");
			
			
				ArrayList BillDetails = beanObj.getBillSettlementYN(ordering_facility, order_id);
				String message = "";	
				String details = "";
				if (BillDetails.size() > 0) 
				{
					for( int i=0 ; i< BillDetails.size() ; i++ ) 
					{	
						String[] record = (String[])BillDetails.get(i);	
						message = record[0];
						details = record[1];
					}
					out.println("settlementPendingMsg(\""+message+ "\",\""+details+"\",\""+patient_id+"\",\""+encounter_id+"\",\""+ordering_facility+"\",\""+rec_num+"\");");
				}
			
		}//IN071618 Ends
	}

	putObjectInBean(bean_id,beanObj,request);
}
catch(Exception e)
{
	e.printStackTrace();
}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
