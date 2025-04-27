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
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __dispmedicationallocatedrugsnonstk extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationAllocateDrugsNonStk.jsp", 1709120710364L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n  \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<HTML>\n<HEAD>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t<SCRIPT LANGUAGE=\"Javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"JavaScript\" SRC=\"../../ePH/js/PhCommon.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n</HEAD>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<!-- <body> -->\n<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n<form name=\"DispMedicationAllocateDrugsWithoutStock\" id=\"DispMedicationAllocateDrugsWithoutStock\">\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<tr>\n\t<td  width=\"24%\" class=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"><input type=\"hidden\" name=\"item_drug_code";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" id=\"item_drug_code";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"><input type=\"hidden\" name=\"item_drug_color";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" id=\"item_drug_color";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"><input type=\"text\" class=\"flat\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" name=\"batch_id";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" size=\"10\" maxlength=\"10\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" style=\"color:";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"\n\tonChange=\"\"\tonBlur=\"checkDuplicate(document.DispMedicationAllocateDrugsWithoutStock,this)\">\t</td>\n\t<td  width=\"24%\" class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" name=\"expiry_date";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" size=\"10\" maxlength=\"10\" style=\"color:";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" onBlur=\"CompareDate(this);\" onChange=\"\"></td>\n\t<td  width=\"16%\" class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" name=\"issue_qty";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" size=\"6\" style=\"color:";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =";text-align:right\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" onKeyPress=\"return allowValidNumber(this,event,6,0);\" onBlur=\"allowNumber(this);defaultUOM(this,\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\');validateQty(this);\" maxlength=\"5\" onChange=\"\"></td>\n\n\t<td  width=\"20%\" class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<input type=\"text\" class=\"flat\" size=\"8\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" name=\"qty_uom";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" readOnly>\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t</td>\n\t\t<td width=\"15%\" class=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" ><input type=\"checkbox\" name=\"select";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\"select";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"></td>\n\t</tr>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t</table>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n<input type=\"hidden\" name=\"drug_code\" id=\"drug_code\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"> \n<input type=\"hidden\" name=\"totalRecords\" id=\"totalRecords\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"> \n<input type=\"hidden\" name=\"alt_drug_code\" id=\"alt_drug_code\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"> \n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"> \n<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"> \n<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<input type=\"hidden\" name=\"uom\" id=\"uom\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n<input type=\"hidden\" name=\"qty\" id=\"qty\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n<input type=\"hidden\" name=\"order_line_no\" id=\"order_line_no\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<input type=\"hidden\" name=\"source\" id=\"source\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n</form>\n</body>\n<script>\nsetFocus(document.DispMedicationAllocateDrugsWithoutStock);\n</script>\n</html>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);



	    request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		

        String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	
	String bean_id				= "DispMedicationAllStages" ;
	String bean_name			= "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request);
	//bean.setLanguageId(locale);

	String	bean_id_1			=	"DispMedicationBean" ;
	String	bean_name_1			=	"ePH.DispMedicationBean";
	DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1,request);	
	//bean_1.setLanguageId(locale);

	String class_name			=	"";
	String drug_code			=	request.getParameter("drug_code");
	String patient_id			=	request.getParameter("patient_id");
	String order_id				=	request.getParameter("order_id");
	String order_line_no		=	request.getParameter("order_line_no");
	String drug_color			=	request.getParameter("drug_color");
	String alt_drug_code		=	request.getParameter("alt_drug_code");
	String qty					=	request.getParameter("qty");
	String uom					=	request.getParameter("qty_uom");
	String source				=	request.getParameter("source");
	String batch_id				=	"";
	String expiry_date			=	"";
	String issue_qty			=	"";
	String qty_uom				=	"";
	String item_drug_code		=	"";
	String read_only_status		=	"";
	String txt_status			=	"";	
	int	    totalRecords		=	25;	
	boolean firstTime			=	true;
	if(drug_color==null)
		drug_color				=	"";
	if(alt_drug_code==null)
		alt_drug_code			=	"";

	ArrayList	delivery_det	=	bean_1.getDeliveryDetails();

	if(delivery_det!=null && delivery_det.size() > 1) {
		txt_status			=	"disabled";
	}

	
	ArrayList	drug_detail			=	new ArrayList();
	ArrayList	all_drug_detail		=	new ArrayList();
	String		sys_date			=	bean.getCurrDate();

if(alt_drug_code.equals(""))	{
	drug_detail		=	bean.getDrugDetail(patient_id,order_id,order_line_no);	
	item_drug_code	=	drug_code;
}
else	{
	drug_detail		=	bean.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);
	all_drug_detail	=	bean.getAllAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);
	item_drug_code	=	alt_drug_code;
}
String tmp_drug_code		=	item_drug_code;
String tmp_drug_color		=	drug_color;
String item_drug_color		=	drug_color;
String module_id			=	"1";


            _bw.write(_wl_block9Bytes, _wl_block9);
 if(module_id.equals("1")) { 
            _bw.write(_wl_block10Bytes, _wl_block10);
	
	int no		=	0;
	int p		=	0;
	int q		=	0;

	for(int i=0; i<totalRecords; i++)	{

				batch_id			=	"";
				expiry_date			=	"";
				issue_qty			=	"";
				qty_uom				=	"";
				item_drug_code		=	tmp_drug_code;
				item_drug_color		=	tmp_drug_color;
				drug_color			=	item_drug_color;
				read_only_status	=	"";

			if(no < (drug_detail.size()-1))	{
				item_drug_code	=	(String)drug_detail.get(no);	
				batch_id		=	(String)drug_detail.get(++no);	
				expiry_date		=	(String)drug_detail.get(++no);	
				issue_qty		=	(String)drug_detail.get(++no);	
				qty_uom			=	(String)drug_detail.get(++no);	
				drug_color		=	(String)drug_detail.get(++no);	
				++no;
			}
			else if(p < all_drug_detail.size())	{
				ArrayList alt_drug_det	=	(ArrayList)all_drug_detail.get(p);
				if( q < (alt_drug_det.size()-1))	{
				item_drug_code		=	(String)alt_drug_det.get(q);	
				batch_id			=	(String)alt_drug_det.get(++q);	
				expiry_date			=	(String)alt_drug_det.get(++q);	
				issue_qty			=	(String)alt_drug_det.get(++q);	
				qty_uom				=	(String)alt_drug_det.get(++q);	
				drug_color			=	(String)alt_drug_det.get(++q);	
				read_only_status	=	"readOnly";
				++q;
				}
				else	{
				q	=	0;
				++p;
				continue;
				}
			}
		if(i%2==0)
			class_name	=	"QRYEVEN";
		else
			class_name	=	"QRYODD";		
			
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(item_drug_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(item_drug_color));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(txt_status));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(read_only_status));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(txt_status));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(read_only_status));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(issue_qty));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(txt_status));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(read_only_status));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
 if(qty_uom.equals("") && firstTime==true) { 
		qty_uom		=	uom;
		firstTime	=	false;
	
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
	}	else	{	
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
	}	
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
	
	
	}	
            _bw.write(_wl_block40Bytes, _wl_block40);
	}	
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(alt_drug_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(source));
            _bw.write(_wl_block53Bytes, _wl_block53);

//putObjectInBean(bean_id,bean,request);
//putObjectInBean(bean_id_1,bean_1,request);

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
