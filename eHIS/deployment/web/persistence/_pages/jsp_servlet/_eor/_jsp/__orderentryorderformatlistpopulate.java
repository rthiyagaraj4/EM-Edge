package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.io.*;
import eOR.Common.*;
import eOR.*;
import eCommon.XSSRequestWrapper;

public final class __orderentryorderformatlistpopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryOrderFormatListPopulate.jsp", 1709119816000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n \n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            eOR.OrderEntryQueryBean beanQueryObj= null;{
                beanQueryObj=(eOR.OrderEntryQueryBean)pageContext.getAttribute("beanQueryObj");
                if(beanQueryObj==null){
                    beanQueryObj=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("beanQueryObj",beanQueryObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String bean_id 		= request.getParameter( "bean_id" ) ;
	//String bean_name 		= request.getParameter( "bean_name" ) ;
	String func_mode 		= request.getParameter( "func_mode" ) ;
	String localeName=request.getParameter("localeName");	
	beanQueryObj.setLanguageId(localeName);

	//if ( bean_id == null || bean_id.equals( "" ) || bean_name == null || bean_name.equals(""))
	//	return ;

	if ( func_mode == null || func_mode.equals( "" ) )
		return ;

 
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
   	hash = (Hashtable)hash.get( "SEARCH" ) ;

	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to get the Connection using the Query Bean
	String field_mnemonic 			= beanQueryObj.checkForNull((String)hash.get("field_mnemonic"),"") ;
	String order_category			= beanQueryObj.checkForNull((String)hash.get("order_category"),"") ;
 	String order_type_code 			= beanQueryObj.checkForNull((String)hash.get("order_type_code"),"") ;
	String contr_msr_panel_id 		= beanQueryObj.checkForNull((String)hash.get("contr_msr_panel_id"),"") ;
	String contr_msr_mod_id 		= beanQueryObj.checkForNull((String)hash.get("contr_msr_mod_id"),"") ;
 	String discr_msr_id 			= beanQueryObj.checkForNull((String)hash.get("discr_msr_id"),"") ;
	String performing_facility_id	= beanQueryObj.checkForNull((String)hash.get("performing_facility_id"),"");
	String login_facility_id 			= beanQueryObj.checkForNull((String)hash.get("login_facility_id"),"") ;
	String sex 			= beanQueryObj.checkForNull((String)hash.get("sex"),"") ;
	String ot_install_yn 			= beanQueryObj.checkForNull((String)hash.get("ot_install_yn"),"") ;
	String rd_install_yn 			= beanQueryObj.checkForNull((String)hash.get("rd_install_yn"),"") ;
	String catalog_code=beanQueryObj.checkForNull((String)hash.get("catalog_code"),"") ;
	//String lab_install_yn 			= beanQueryObj.checkForNull((String)hash.get("lab_install_yn"),"") ;
	String bt_install_yn 			= beanQueryObj.checkForNull((String)hash.get("bt_install_yn"),"") ;
	String oper_side_appl_yn 		= beanQueryObj.checkForNull((String)hash.get("oper_side_appl_yn"),"") ;
	String specimen_def_yn 			= beanQueryObj.checkForNull((String)hash.get("specimen_def_yn"),"") ;	
	String lab_install_yn 		="N"; 
	String labmodule="";
	ArrayList OrderFormatList;
	//lab_install_yn=beanQueryObj.checkForNull((String)hash.get("lab_install_yn"),"") ;
	//System.out.println("catalog_code44"+catalog_code);
	labmodule=beanQueryObj.checkForNull((String)beanQueryObj.getmoduleRL(catalog_code,order_category,order_type_code,login_facility_id,properties),"");
	 if(order_category.equalsIgnoreCase("LB"))
	{
			if(labmodule.equalsIgnoreCase("IBARL"))
			{
				lab_install_yn="Y";
			}
			else
			{
				lab_install_yn="N";
				//System.out.println("lab_install_yn"+lab_install_yn+catalog_code);
			}
	}
					//System.out.println("lab_install_yn"+lab_install_yn);
	String new_field_name 			= beanQueryObj.checkForNull(request.getParameter("new_field_name"),"") ;
	String dflt_value 				= beanQueryObj.checkForNull((String)hash.get("dflt_value"),"") ;

 	if(func_mode.equals("POPULATE_LIST_VALUES")) {
		out.println( "clearFormatList('document.OrderFormatForm',\""+new_field_name+"\") ; " ) ;
		if(field_mnemonic.equals("DONOR_BLOOD_GROUP"))
		{
			 OrderFormatList = beanQueryObj.getdonorblood();
		}
		else if(field_mnemonic.equals("DONOR_RHESUS"))
		{
		   OrderFormatList = beanQueryObj.getdonorrhesus();
		}
		 else
		{
		    OrderFormatList = beanQueryObj.getOrderFormatList(properties, order_category,field_mnemonic,contr_msr_panel_id,contr_msr_mod_id,order_type_code,discr_msr_id,performing_facility_id,login_facility_id, sex,  lab_install_yn, bt_install_yn, rd_install_yn, ot_install_yn,catalog_code);

		} 
		//ArrayList OrderFormatList = beanQueryObj.getOrderFormatList(properties, order_category,field_mnemonic,contr_msr_panel_id,contr_msr_mod_id,order_type_code,discr_msr_id,performing_facility_id,login_facility_id, sex,  lab_install_yn, bt_install_yn, rd_install_yn, ot_install_yn);
  		 //ArrayList OrderFormatList = beanQueryObj.getdonorblood();
		   String[] records=null;
		for(int l=0; l<OrderFormatList.size(); l++)
		{
			 records = (String[])OrderFormatList.get(l);

 			//out.println( "addFormatList('document.OrderFormatForm',\""+new_field_name+"\", \""+records[0]+"\",\""+records[1]+"\", \""+records[2]+"\",\""+dflt_value+"\", \""+order_category+"\", \""+ot_install_yn+"\", \""+oper_side_appl_yn+"\", \""+specimen_def_yn+"\" ) ; " ) ;
			 if(field_mnemonic.equals("DONOR_BLOOD_GROUP") || field_mnemonic.equals("DONOR_RHESUS"))
			{
			out.println( "addFormatList('document.OrderFormatForm',\""+new_field_name+"\", \""+records[0]+"\",\""+records[1]+"\",' ',\""+dflt_value+"\", \""+order_category+"\", \""+ot_install_yn+"\", \""+oper_side_appl_yn+"\", \""+specimen_def_yn+"\" ) ; " ) ;
			}
			else
			{
				out.println( "addFormatList('document.OrderFormatForm',\""+new_field_name+"\", \""+records[0]+"\",\""+records[1]+"\", \""+records[2]+"\",\""+dflt_value+"\", \""+order_category+"\", \""+ot_install_yn+"\", \""+oper_side_appl_yn+"\", \""+specimen_def_yn+"\" ) ; " ) ;
			}
			
			records = null;
 	 	} // End of for OrderDependencyFormat	 
		OrderFormatList.clear(); OrderFormatList = null;
	} // End of POPULATE_LIST_VALUES
	else if(func_mode.equals("POPULATE_RADIO_VALUES")) {
 		ArrayList OrderFormatRadio = beanQueryObj.getOrderFormatRadio(properties, order_category,field_mnemonic,catalog_code,lab_install_yn,contr_msr_panel_id,contr_msr_mod_id);
		StringBuffer sbTemplate = new StringBuffer();
		sbTemplate.append("<table border='1' BGCOLOR='RED'><tr><td>");
		for(int l=0; l<OrderFormatRadio.size(); l++)
		{
			String[] records = (String[])OrderFormatRadio.get(l);
			if(dflt_value.equals(records[0])) // first Item
		   		sbTemplate.append("<input type='RADIO' name='"+(new_field_name)+"' id='"+(new_field_name)+"' value='"+records[0]+"' checked>"+records[1]+"</input>");
			else 
				sbTemplate.append("<input type='RADIO' name='"+(new_field_name)+"' id='"+(new_field_name)+"' value='"+records[0]+"'>"+records[1]+"</input>");
			records = null;
		} // End of for
		if(sbTemplate.length() > 0) {
			out.println( "addRadioGroup(\""+new_field_name+"\", \""+sbTemplate.toString()+"\") ; " ) ;
		sbTemplate.setLength(0);			
		OrderFormatRadio.clear(); OrderFormatRadio	 = null;
	}
}

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
