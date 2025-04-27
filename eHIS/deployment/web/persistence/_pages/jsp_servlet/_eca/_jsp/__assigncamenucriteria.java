package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __assigncamenucriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/AssignCAMenuCriteria.jsp", 1709115455186L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
06/08/2013		IN036733		Nijitha			Bru-HIMS-CRF-328
-------------------------------------------------------------------------------------------------------------------------------------
*/

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
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	Connection con=null ;

try 
{
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	
	//IN036733 Starts
	ArrayList facilityItem = new ArrayList();
	
	facilityItem.add("List");
	facilityItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels"));		 // label
	facilityItem.add("facility_id");		 // name of field
	facilityItem.add("SELECT '*A' FACILITY_ID,'ALL' FACILITY_NAME FROM dual union all SELECT FACILITY_ID,FACILITY_NAME from SM_FACILITY_PARAM WHERE STATUS='E'");			
	finAr.add(facilityItem);   
	//IN036733 Ends
	ArrayList firstItem = new ArrayList();

	firstItem.add("List");           // Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels"));		 // label
	firstItem.add("patient_class");		 // name of field
	firstItem.add("Select '*A' PATIENT_CLASS,'ALL' SHORT_DESC from dual union all SELECT patient_class,short_desc FROM am_patient_class order by short_desc");			
	finAr.add(firstItem);            // add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("List");           // Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels"));			  // label
	secondItem.add("pract_type");	  // name of field
	secondItem.add("Select '*A' PATIENT_CLASS,'ALL' SHORT_DESC from dual union all select PRACT_TYPE, nvl(DESC_USERDEF, DESC_SYSDEF) pract_type_desc from am_pract_type where  EFF_STATUS ='E' order by 2");			  
	finAr.add(secondItem);            // add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");           // Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"));		  // label
	thirdItem.add("practitioner_name");	  // name of field
	thirdItem.add("20");			  // SIZE
	thirdItem.add("20");             // LENGTH
	finAr.add(thirdItem);			//	add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("List");			//	Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.menu.label","common_labels"));		//	label
	fourthItem.add("menu_id");	//	name
	fourthItem.add("select menu_id,short_desc from ca_menu_header order by  short_desc");        
	finAr.add(fourthItem);			//	add to ArrayList obj finAr


	String[] orderByCols = null;
	String[] orderByColVals = null;

	//IN036733 Starts 
	//orderByCols = new String[4];
	//orderByColVals = new String[4];
	orderByCols = new String[5];
	orderByColVals = new String[5];
	//IN036733 Ends

	//IN036733 Starts
	/*orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.menu.label","common_labels");*/
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels");//
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.menu.label","common_labels");
	//IN036733 Ends

	//IN036733 Starts
	/*orderByColVals[0] = "patient_class_name";
	orderByColVals[1] = "pract_type_name";
	orderByColVals[2] = "pract_name";
	orderByColVals[3] = "menu_desc ";*/
	
	orderByColVals[0] = "facility_name";
	orderByColVals[1] = "patient_class_name";
	orderByColVals[2] = "pract_type_name";
	orderByColVals[3] = "pract_name";
	orderByColVals[4] = "menu_desc ";
	//IN036733 Ends

	strbuff = qrypg.getQueryPage(con,finAr,"AssignCA Menu","../../eCA/jsp/AssignCAMenuResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());

	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
}//end of try
catch (Exception e) 
{
	e.printStackTrace();
}
finally	
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
