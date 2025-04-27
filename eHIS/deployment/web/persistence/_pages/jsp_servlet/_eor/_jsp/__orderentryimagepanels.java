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

public final class __orderentryimagepanels extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryImagePanels.jsp", 1734338282000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head><title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryToolTip.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n </head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name =\"imagePanelsForm\" id =\"imagePanelsForm\">\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n<tr>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t\t<td class=\"LABEL\"  width=\"20%\" onClick=\'parent.parent.parent.displayToolTip(escape(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"),escape(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"),\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\",\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\",\"imagePanelsForm\")\' onMouseOver=\'showToolTip(\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\",\"imagePanelsForm\")\' onMouseOut=\"hideToolTip()\"> <font size=1 color=\"BLUE\">\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\t    <td class=\"LABEL\"  width=\"20%\" onMouseOver=\'showToolTip(\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\",\"imagePanelsForm\")\' onMouseOut=\"hideToolTip()\"><font size=1>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\n\t\t\t\t   ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t   <input type=\"hidden\" name=\"catalog_desc";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"catalog_desc";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\t\n\t\t\t\t</font></td>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<td class=\"LABEL\"  width=\"5%\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<!-- IN064543 Start -->\t\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"ck";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"ck";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" value=\"Y\" onClick=\'parent.parent.parent.setCheckBoxVal(this,escape(\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"),\"imagePanelsForm\");";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="parent.parent.parent.showEditor(this,\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\");";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" > \n\t\t\t\t\t<!--IN064543 End-->\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"h1";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"h1";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"h2";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" id=\"h2";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\n\t\t\t\t\t<input type=\"hidden\" name=\"prompt_desc";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"prompt_desc";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"> ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"explanatory_text";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"explanatory_text";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"LABEL\"  width=\"3%\" nowrap>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\t\t\t\t\t<img id=\'authorization\"+i+\"\' src=\"../../eOR/images/Authorization.gif\" align=\"center\"></img>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\t\t\t\t<img id=\'special_approval\"+i+\"\' src=\"../../eOR/images/SpecialApproval.gif\" align=\"center\"></img>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t</table>\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" \t\t\tvalue=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" \t\t\tvalue=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\"hidden\" name=\"order_category\" id=\"order_category\" \t\tvalue=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\n\t<input type=\"hidden\" name=\"check_box_val\" id=\"check_box_val\" \tvalue=\"N\">\n\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\"hidden\" name=\"admission_date\" id=\"admission_date\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\"hidden\" name=\"discharge_date_time\" id=\"discharge_date_time\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\"hidden\" name=\"priv_applicability_yn\" id=\"priv_applicability_yn\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<input type=\"hidden\" name=\"function_from\" id=\"function_from\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\n </form>\n \t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:20%; visibility:hidden;\" bgcolor=\"blue\">\n \t\t<table id=\"tooltiptable\" cellpadding=3 cellspacing=0 border=\"0\"  width=\"100%\" height=\"100%\" align=\"center\">\n \t\t   \t<tr>\n \t\t \t\t<td width=\"100%\" id=\"t\"></td>\n \t\t\t</tr>\n \t\t</table>\n\t</div>\n</body>\n</html>\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );
	
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

/*
-------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
-------------------------------------------------------------------------------------------------------
17/07/2018	IN064543		Kamalakannan		 17/07/2018		Ramesh G		ML-MMOH-CRF-0776	
-------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
  
try
{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 			= request.getParameter("bean_id");
	String bean_name 		= request.getParameter("bean_name");
	/* Mandatory checks end */

	/* Initialize Function specific start */
		//OrderEntryBean bean = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		OrderEntryBean bean	  = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
                   bean.setLanguageId(localeName);
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
	/* Initialize Function specific end */
	String order_type_code 	= bean.checkForNull(request.getParameter("order_type_code"),"");
	String order_category 	= bean.checkForNull(request.getParameter("order_category"),"");
	String activity_type 	= bean.checkForNull(request.getParameter("activity_type"),"");
	String hotspot_id 		= bean.checkForNull(request.getParameter("hotspot_id"),"");
	String image_id 		= bean.checkForNull(request.getParameter("image_id"),"");
	String function_from			= bean.checkForNull(request.getParameter("function_from"),"");
	String priv_applicability_yn 		= bean.checkForNull(request.getParameter("priv_applicability_yn"),"");
	String prev_group_title	= "";
	String checkedAttribute = "";
	String disabled			= "";
	String key				= (bean.getPatientId()+bean.getEncounterId());
	if(!order_type_code.equals(""))	order_type_code = order_type_code.trim();
	if(!order_category.equals(""))	order_category 	= order_category.trim();
	if(!hotspot_id.equals(""))		hotspot_id 		= hotspot_id.trim();
	if(!image_id.equals(""))		image_id 		= image_id.trim();
	if(!activity_type.equals(""))	activity_type 	= activity_type.trim();
	if(!priv_applicability_yn.equals(""))	priv_applicability_yn 	= priv_applicability_yn.trim();
		
	int i							= 0,count = 0; // counters for loop
	String amend_key				= "";
	HashMap previousValues			= null;
	HashMap amendPreviousValues		= null;
	//ArrayList Panels 				= null;
	StringTokenizer stBillMsg		= null;
	String measure_id				= "" , contr_msr_panel_id = "";
	String category					= "";
	String[] records				= null;
	String entryValue				= "";
	String group_title="";
	Set setValues 					= null;
	Iterator iterator				= null;

            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		// Since at the maximum there will be 100 or 150 records no need for next/previous
		ArrayList ImagePanels = bean.getImagePanels(order_type_code,order_category,image_id,hotspot_id,activity_type,priv_applicability_yn);
		for(i=0; i<ImagePanels.size(); i++)
		{
			checkedAttribute = "";disabled= "";
			records = (String[])ImagePanels.get(i);
			if(records[13].equalsIgnoreCase("P"))
			{	
					group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Panel.label","common_labels");
			}else if(records[13].equalsIgnoreCase("S"))
			{
				group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderSet.label","or_labels");
			}
			else if(records[13].equalsIgnoreCase("A"))
			{
					group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Individual.label","common_labels");
			}
			if(!prev_group_title.equals(records[13]))
			{
				if( count%2 > 0)
				{
					 for (int u=0;u<2-count%2;u++)
						out.println("<td width=\"20%\"  colspan=\"3\"  align=\"left\">&nbsp;&nbsp;</td>");
						out.println("</tr>");
				}
				count =0 ;
				out.println("<tr>");
				out.println("<td colspan=\"6\" align=\"center\" class=\"CAGROUP\">"+group_title+" </td>");
				out.println("</tr><tr>");
			}
			// records[14]  -- > ordr_catalog_nature
			if(records[13].equals("P") || records[13].equals("S"))
			{
				contr_msr_panel_id 	= records[10];
				category     		= records[2];
				if(records[13].equals("P")) // Pass the discrete_measure_id & contr_msr_panel_id
				{
					measure_id = records[8]; // discrete_measure_id
				}
				else if(records[13].equals("S")) // Pass the catalog_code
				{
					measure_id = records[0]; // Catalog Code 
				}
			} // End of If
			
			if(!records[13].equals("") && (records[13].equalsIgnoreCase("P")) || records[13].equalsIgnoreCase("S"))
			{

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(measure_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(contr_msr_panel_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(records[13]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(category));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String)records[0]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((String)records[0]));
            _bw.write(_wl_block14Bytes, _wl_block14);
			}
			else
			{

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((String)records[0]));
            _bw.write(_wl_block16Bytes, _wl_block16);
			}  
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)records[0]));
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)records[0]));
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block21Bytes, _wl_block21);

				 previousValues = (HashMap)orderEntryRecordBean.getCheckedEntries(key);
				if(previousValues!=null)
				{
		   			setValues 		= previousValues.keySet();
		   			iterator 		= setValues.iterator();
		   			for(int prev_count=0;prev_count<previousValues.size();prev_count++)
		   			{
						entryValue = ((String)iterator.next()) ;
						if(entryValue.equalsIgnoreCase("ck"+(String)records[0]))
						{
							checkedAttribute = "CHECKED";
							break;
						}
						else
						   checkedAttribute = "";
					}
				}
				// From Query --> Depending upon the privilege to enable/disable the checkbox
				/*Added by Uma on 8/24/2009 for PMG20089 -CRF 641*/
				if( ((String)records[14])!=null && (((String)records[14]).equals("Y")) ) 
					disabled		 = "";
				else 
					disabled		 = "DISABLED";
				/*End Here*/
			// For Amend of Review Order
				if(bean.getAmendOrder().equalsIgnoreCase("existing_order"))
				{
					amend_key			= (bean.getPatientId()+bean.getEncounterId()+bean.getOrderId());  // Unique key (For Existing Orders) to keep the Value in the Bean
					amendPreviousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(amend_key);
					if(amendPreviousValues!=null)
					{
						setValues 		 = amendPreviousValues.keySet();
						iterator 		= setValues.iterator();
						for(int prev_count=0;prev_count<amendPreviousValues.size();prev_count++)
						{
							entryValue = ((String)iterator.next()) ;
							if(entryValue.equalsIgnoreCase("ck"+(String)records[0]))
							{
								checkedAttribute = "CHECKED";
								disabled		 = "DISABLED";
								break;
							}
						}
					}
				} 
				
 
            _bw.write(_wl_block22Bytes, _wl_block22);
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((String)records[0]));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((String)records[0]));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)records[11]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((String)records[0]));
            _bw.write(_wl_block26Bytes, _wl_block26);

							if(((String)records[13]).equalsIgnoreCase("A")&& ((String)records[16]).equals("Y"))
							{
							
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records[0]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String)records[13]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String)records[2]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String)records[17]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block28Bytes, _wl_block28);

							}
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(checkedAttribute));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((String)records[0]));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((String)records[0]));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)records[2]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf((String)records[0]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)records[0]));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)records[3]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf((String)records[0]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((String)records[0]));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.checkForNull((String)records[12],"")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf((String)records[0]));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((String)records[0]));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.checkForNull((String)records[15],"")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            _bw.write(_wl_block40Bytes, _wl_block40);
				if(((String)records[4]).equalsIgnoreCase("Y")) // For Authorization Required
				{

            _bw.write(_wl_block41Bytes, _wl_block41);
				}	
            _bw.write(_wl_block1Bytes, _wl_block1);
 				if(((String)records[6]).equalsIgnoreCase("Y")) // For Special Approval Required
				{

            _bw.write(_wl_block42Bytes, _wl_block42);
				}	
            _bw.write(_wl_block43Bytes, _wl_block43);
			count++;
			if( count%2 == 0)
				  out.println("</tr><tr>");
			prev_group_title = records[13];
		} // End of for
		if( count%2 > 0)
		{
			for (int u=0;u<2-count%2;u++)
		 		out.println("<td width=\"20%\" colspan=\"3\" align=\"left\">&nbsp;&nbsp;</td>");
			 	out.println("</tr>");
		}

		if(ImagePanels!=null && ImagePanels.size()==0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script> ");
		}
		
		// Nullifying the objects
		previousValues		= null;		amendPreviousValues = null;
		ImagePanels			= null;		//Nullifying the objects
		setValues 			= null;		iterator			= null;
		stBillMsg			= null;		records				= null;


            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bean.getEncounterId()));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean.getPatientClass()));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bean.getVisitAdmDate()));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(bean.getDischargeDateTime()));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(priv_applicability_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block54Bytes, _wl_block54);

	// set it back persistence
	//putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e)
	{e.printStackTrace();}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderEntryImagePanels.label", java.lang.String .class,"key"));
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
