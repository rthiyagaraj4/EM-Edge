package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orpatientorders extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ORPatientOrders.jsp", 1709119896000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/PatientOrders.js\"></SCRIPT>   \n\t<SCRIPT language=\"javascript\">\n\t\n\n\n</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n</HEAD>\n\n<BODY  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n\t<FORM name=\"frmPatientOrders\" id=\"frmPatientOrders\" ACTION=\"../../eCommon/jsp/report_options.jsp\" TARGET=\"messageFrame\">\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<br><br><br><br><br><br><br><br>\n\n\t<TABLE WIDTH=\"67%\" ALIGN=\"center\" CELLPADDING=\"0\" CELLSPACING=\"0\" BORDER=\"0\">\n\t\t<TR>\n\t\t\t<TD COLSPAN=\"2\">&nbsp</TD>\n\t\t\t<td></td>\n\t\t</TR>\t\n\t\t<TR>\n\t\t\t<TD ALIGN=\"right\" width=\"32%\"  CLASS=\"label\">Patient ID &nbsp</TD>\n\t\t\t<TD ALIGN=\"left\" >\n\t\t\t\t<input type=text name=\"p_patient_id\" id=\"p_patient_id\" maxlength=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"\n\t\t\t\tvalue=\'\' nowrap onKeyPress=\'return lockSpecialCharacters(this)\' onBlur=\'ChangeUpperCase(this)\'> <input type=button class=\"button\" value=\"?\" onclick=\"javascript:callPatientSearch()\">\n\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t</TD>\n\t\t\t<td></td>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD COLSPAN=\"2\">&nbsp</TD>\n\t\t\t<td></td>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD ALIGN=\"right\"  width=\"32%\"  CLASS=\"label\">Encounter ID &nbsp</TD>\n\t\t\t<TD ALIGN=\"left\" >\n\t\t\t\t<input type=text name=\"p_encounter_id\" id=\"p_encounter_id\" maxlength=12 size=\"12\" onKeyPress=\'return lockSpecialCharacters(this)\'> <!-- <input type=button class=\"button\" value=\"?\" onclick=\"javascript:callEncounterSearch(this)\"> -->\n\t\t\t</TD>\n\t\t\t<td></td>\n\t\t</TR>\n\t<TR>\n\t\t\t<TD COLSPAN=\"2\">&nbsp</TD>\n\t\t\t<td></td>\n\t\t</TR>\n\t\n\t<TR>\n\t\t\t<TD ALIGN=\"right\"  width=\"32%\"  CLASS=\"label\">Order Category &nbsp</TD>\n\t\t\t<TD ALIGN=\"left\" >\n\t\t\t\t<select size=\"1\" name=\"p_order_category\" id=\"p_order_category\" onchange=\"populateOrderTypes(this);\">\n\t\t\t\t<option value=\"\">All</option>\n\t\t\t\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<option value=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" \n\t\t\t\t</select>\n\t\t\t</TD>\n\t\t\t<td></td>\n\t\t<TR>\n\t\t\t<TD COLSPAN=\"2\">&nbsp</TD>\n\t\t\t<td></td>\n\t\t</TR>\n\n\t\t</TR>\n\t<!-- <tr>\n\t<TD ALIGN=\"right\" WIDTH=\"1200\" CLASS=\"label\">From </TD>\n\t<TR>\n\t\t\t<TD COLSPAN=\"2\">&nbsp</TD>\n\t\t</TR>\n\t</tr> -->\n\t<tr>\n\t\t\t\t\t<td   CLASS=\"label\"></td> \n\t\t\t\t\t<td  ALIGN=\"left\" CLASS=\"label\">From</td>\n\t\t\t\t\t<td  ALIGN=\"left\" width=\"32%\"  CLASS=\"label\">To</td>\n\t</tr>\n\t<TR>\n\t\t\t<TD ALIGN=\"right\" width=\"32%\"  CLASS=\"label\">Order Type &nbsp</TD>\n\t\t\t<TD ALIGN=\"left\" >\n\t\t\t\t<select size=\"1\" name=\"p_order_type_from\" id=\"p_order_type_from\">\n\t\t\t\t<option value=\"\">All</option>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\n\t <option value=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" </option>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t</select>\n\t\t\t </td>\n\t\t\t<td ALIGN=\"left\" >\n\t\t\t\t<select size=\"1\" name=\"p_order_type_to\" id=\"p_order_type_to\">\n\t\t\t\t<option value=\"\">All</option>\n\t\t\t  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t <option value=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" \n\t\t\t\t</select>\n\t\t\t</TD>\n\t\t\t<td></td>\n\t\t\t <TR>\n\t\t\t<TD COLSPAN=\"2\">&nbsp</TD>\n\t\t\t<td></td>\n\t\t</TR>\n\t\t</TR>\n\t<TR>\n\t\t\t<TD ALIGN=\"right\" width=\"32%\"  CLASS=\"label\">Period &nbsp</TD>\n\t\t\t<TD ALIGN=\"left\" >\n\t\t\t\t<input type=text name=\"p_period_from\" id=\"p_period_from\" size=\"10\"onkeypress=\'return Valid_DT(event)\' maxlength=10 onblur=\'datefun(this);\' >&nbsp;</td><TD ALIGN=\"left\" ><input type=text name=\"p_period_to\" id=\"p_period_to\" size=\"10\" maxlength=10 onkeypress=\'return Valid_DT(event)\' onblur=\'datefun(this);\tvar retval= doDateCheck(parent.searchResultFrame.document.frmPatientOrders.p_period_from,parent.searchResultFrame.document.frmPatientOrders.p_period_to,parent.messageFrame);if(retval==true){parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\"};\'> \n\t\t\t</TD>\n\t\t\t<td></td>\n\t\t</TR>\t\n\t\t<TR>\n\t\t\t<TD COLSPAN=\"2\">&nbsp</TD>\n\t\t\t<td></td>\n\t\t</TR>\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" value=\"OR\">\n\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" value=\"ORRPATOR\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_language_id\" id=\"p_language_id\" VALUE=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t</FORM>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	 ArrayList Category_Data = new ArrayList();
	 ArrayList print_order		= new ArrayList();
	//ArrayList print_order1		= new ArrayList();
	String bean_id		= "patient_report" ;
	String bean_name	= "eOR.PatientOrdersReportBean";

	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	//PatientOrdersReportBean bean = 	(PatientOrdersReportBean)mh.getBeanObject( bean_id, request,bean_name );  
	PatientOrdersReportBean bean = (PatientOrdersReportBean)getBeanObject( bean_id, bean_name, request ) ;

	String facility_id = (String)session.getValue("facility_id");
	
	/* Initialize Function specific end */
	int patient_id_length = bean.getPatientIdLength();

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( patient_id_length ));
            _bw.write(_wl_block9Bytes, _wl_block9);

			try{
				Category_Data = bean.getAllOrderCategory();

				for(int i=0; i<Category_Data.size(); i++){
					String[] record = (String [])Category_Data.get(i);

		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block12Bytes, _wl_block12);

				}
			}catch(Exception e){
				//out.println(e);//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
		
            _bw.write(_wl_block13Bytes, _wl_block13);

				
		String ord_cat = "";
		
		print_order=bean.getOrderTypeData(ord_cat);
		for(int i=0 ; i<print_order.size() ; i++){
		String[] record = (String []) print_order.get(i);
	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
	
            _bw.write(_wl_block17Bytes, _wl_block17);

				//print_order=bean.getPrintOrders();
		/*String ord_cat1 = "";
		print_order1=bean.getOrderTypeData1(ord_cat1);*/
		for(int i=0 ; i<print_order.size() ; i++){
		String[] record = (String []) print_order.get(i);
	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block23Bytes, _wl_block23);

	putObjectInBean(bean_id,bean,request);


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
