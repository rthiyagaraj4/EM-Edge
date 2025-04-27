package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import eOR.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __indexticksheetdetailresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/IndexTickSheetDetailResult.jsp", 1729687828000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/OrCommon.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/IndexTickSheet.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n\t<script>\n\tfunction lockKey() {\n\t\tif(event.keyCode == 93)\n\t\t\talert(\"Welcome to eHIS\");\n\t}\n\t</script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t<script>\n\t\t\tif(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' <= 0){\n\t\t\tvar msg = getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\");\t\n\t\t\t//alert(msg);\n\t\t\tparent.parent.parent.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+msg;\n\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<body onMouseDown=\'CodeArrest()\'; onKeyDown=\'lockKey()\'>\n\t<form name=\"formIndexTickShDetailResult\" id=\"formIndexTickShDetailResult\">\n\t<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n\t<tr width=\'10%\'>\n\t<td class=\'WHITE\' align=\"right\">\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<A class=\'gridlink\' HREF=\'javascript:onClick=checkVal(\"Previous\");\' text-decoration=\'none\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</A>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<A class=\'gridlink\' HREF=\'javascript:onClick=checkVal(\"Next\");\' text-decoration=\'none\' >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t</td>\n\t</tr>\n\t</table> \n\t<table class=\'grid\' width=\'100%\'>\n\t<th class=\'columnheader\' width=\'75%\' align=\"left\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t<th class=\'columnheader\' width=\'25%\' align=\"left\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<tr id=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'><input type=\'checkbox\' name=\'select_yn";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'select_yn";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value=\'Y\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="></td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' ><b>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</b></td>\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' value=\'Y\'  ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" ></td>\n\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t</table>\n\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t<input type=\"hidden\" name=\"to\" id=\"to\" value=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =">\n\t<input type=\'hidden\' name=\'row_count\' id=\'row_count\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<input type=\'hidden\' name=\'fm_disp\' id=\'fm_disp\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<input type=\'hidden\' name=\'to_disp\' id=\'to_disp\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type=\'hidden\' name=\'SelectYNStr\' id=\'SelectYNStr\' value=\"\">\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t<input type=\"hidden\" name=\"diplayLabel\" id=\"diplayLabel\" value=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =">\n\t<input type=\"hidden\" name=\"dispMode\" id=\"dispMode\" value=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" > \n\t<input type=\"hidden\" name=\"tabVal\" id=\"tabVal\" value=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =">\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\"hidden\" name=\"source_type\" id=\"source_type\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"><!-- IN050655 -->\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );
	
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

int row_count=0;

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

/* 
------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------
?           100            	?           	?				?					created
09/10/2014	IN050655		VijayakumarK	09/10/2014							iASSIST ID : 807002 Index Tick sheet by practitioner is a 
																				good functionality to provide personalised tick sheets to practitioners.
------------------------------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	

	/* Mandatory checks start */
	int row_disp=7;
	int start = 0 ;
	int end = 0 ;
	int fm_disp=0, to_disp=0;

	String bean_id = "indexticksheet" ;
	String bean_name = "eOR.IndexTickSheet";
	//String readOnly = "", status="E", key="";
	String tblrow_id = "", checkValue="";
	String disabled = "", classValue  = "", valid="";
	String associate_yn="";

	HashMap htListRecord= new HashMap();
	String from= "", to ="" ;
	String pract_desc="", dispMode="", tabVal="";
	String diplayLabel="", pract_index="",index_type="",fac_id="";
	String order_category="", tick_sheet_id="", code="";
	//String status_db = "";
	String mode			=	request.getParameter("mode");
	pract_index			=	request.getParameter("pract_index");
	boolean stats = false;
	String update_val = "";
	//boolean alteredRecord = false, alteredDBRecord = false;
	String source_type = "";//IN050655
	
	eOR.Common.MultiRecordBean IndexSheetRecordSet		= new eOR.Common.MultiRecordBean();

	
	fac_id			=	request.getParameter("fac_id");
	tabVal			=	request.getParameter("tabVal");
	dispMode		=	request.getParameter("dispMode") ;
	from			=	request.getParameter( "from" ) ;
	to				=	request.getParameter( "to" ) ;
	
	order_category	=	request.getParameter( "order_category" ) ;
	tick_sheet_id	=	request.getParameter( "tick_sheet_id" ) ;

	diplayLabel	=	request.getParameter( "diplayLabel" ) ;

	if ( from == null || from=="null" || from.equals("null") )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp;//7 ;
	else
		end = Integer.parseInt( to ) ;

	if(dispMode == null || dispMode.equals("null")) dispMode="";
	if(fac_id == null || fac_id.equals("null"))fac_id="";
	if(mode == null || mode.equals("null"))mode="";
	if(pract_index == null || pract_index.equals("null"))pract_index="";
	if(tabVal == null || tabVal.equals("null"))tabVal="";
	if(diplayLabel == null || diplayLabel.equals("null"))diplayLabel="";
	if(order_category == null || order_category.equals("null"))order_category="";
	if(tick_sheet_id == null || tick_sheet_id.equals("null"))tick_sheet_id="";	

	mode="1";
	if ( mode == null || mode.equals("") ) 
		return;
	
	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	IndexTickSheet bean = (IndexTickSheet)getBeanObject( bean_id,  bean_name , request) ;  
	//bean.clear() ;
	//bean.setMode( mode ) ;
	/* Initialize Function specific end */
	
	//IN050655 starts
	//IN050655 - starts CRR changes updated
	String search_by 		= bean.checkForNull(request.getParameter("p_search_by"),"");
	String search_text 		= bean.checkForNull(request.getParameter("p_search_txt"),"");
	String filter_option 	= bean.checkForNull(request.getParameter("p_filter_opt"),"");
	String radioval			= bean.checkForNull(request.getParameter("p_radioval"),"");
	//IN050655 - ends CRR changes updated
	
	String param_desc = "";
	String param_code = "";
	
	if(filter_option.equals("S"))
	{
		if(radioval.equals("C"))
		{	
			param_desc = "%";
			if(search_by.equals("S"))
			{
				param_code = search_text + "%";
			}
			else if(search_by.equals("C")){
				param_code = "%"+search_text+"%";
			}
			else if(search_by.equals("E")){
				param_code = "%"+search_text;
			}
		}	
		else if(radioval.equals("D"))
		{	
			param_code = "%";
			if(search_by.equals("S"))
			{
				param_desc = search_text + "%";
			}
			else if(search_by.equals("C")){
				param_desc = "%"+search_text+"%";
			}
			else if(search_by.equals("E")){
				param_desc = "%"+search_text;
			}
		}
	}
	//IN050655 ends
	if(dispMode.equals("")){
		
		index_type   =	request.getParameter("index_type");
		source_type  =  request.getParameter("source_type");//IN050655
		if(index_type == null || index_type.equals("null"))index_type="";

		if(index_type.equals("S"))
			diplayLabel =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels");
		else if(index_type.equals("P"))
			diplayLabel =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
		//else if(index_type.equals("C"))
		else if(index_type.equals("F")){//IN050655
			if(source_type.equals("C"))//IN050655
				diplayLabel =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			//else if(index_type.equals("N"))//IN050655
			else if(source_type.equals("N"))//IN050655
				diplayLabel =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
		}
		
		//out.println("<script>alert('order_category :"+order_category+"');</script>");
		//out.println("<script>alert('tick_sheet_id :"+tick_sheet_id+"');</script>");
		//out.println("<script>alert('index_type :"+index_type+"');</script>");
		//out.println("<script>alert('fac_id :"+fac_id+"');</script>");
//out.println("<script>alert('===="+order_category+"-"+tick_sheet_id+"----"+index_type+"----"+fac_id+"')</script>");
		//IN050655 starts
			//bean.fetchDBRecords(order_category,tick_sheet_id,index_type,fac_id );
			bean.fetchDBRecords(order_category,tick_sheet_id,index_type, source_type, fac_id );
		//IN050655 ends
		//int dbRecordCount		=  bean.fetchDBRecords(order_category,tick_sheet_id,index_type,fac_id );
		
		//out.println("<script>alert('dbRecordCount :"+""+dbRecordCount+"');</script>");
		if(tabVal.equals("S")){
		//IN050655 starts
			if(!filter_option.equals("S")){
			//IndexSheetRecordSet		= (eOR.Common.MultiRecordBean)bean.getRecordSet(pract_index,index_type, fac_id, tabVal);
			IndexSheetRecordSet		= (eOR.Common.MultiRecordBean)bean.getRecordSet(pract_index, index_type, source_type, fac_id, tabVal);
			}else{
			IndexSheetRecordSet		= (eOR.Common.MultiRecordBean)bean.getSearchRecordSet(param_code,param_desc,index_type,source_type, fac_id, tabVal);
			}
		//IN050655 ends
			row_count				=	IndexSheetRecordSet.getSize("SELECT");
		}else if(tabVal.equals("A")){
			IndexSheetRecordSet		=(eOR.Common.MultiRecordBean)bean.getBean();
			row_count				= IndexSheetRecordSet.getSize("DB");
		}
		
		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		from = ""+(start - 1);
		to   = ""+(end - 1);
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block10Bytes, _wl_block10);

	}
	else
	{
		
		int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));

		if(dispMode.equals("Next")){

			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);
			diplayLabel	= diplayLabel;
			
		}else if(dispMode.equals("Previous")){

			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
			diplayLabel	= diplayLabel;
		}
		
		
		if(to_val > (row_count-1))
			to_val=(row_count-1);

		IndexSheetRecordSet	 =(eOR.Common.MultiRecordBean)bean.getBean();
	
		for(int j=from_val; j<=to_val; j++){
			update_val = request.getParameter("select_yn"+j);
			if(update_val == null || update_val.equals("null")){
				update_val = "N";
			}
			if(tabVal.equals("S")){
				IndexSheetRecordSet.setBeanValue(j,update_val);
				//alteredRecord = IndexSheetRecordSet.setBeanValue(j,update_val);
			}else if(tabVal.equals("A")){
				IndexSheetRecordSet.setDBBeanValue(j,update_val);
				//alteredDBRecord = IndexSheetRecordSet.setDBBeanValue(j,update_val);
			}
		}
			
		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);

		if(to_disp > (row_count-1))
			to_disp=(row_count-1);

		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);

	}

	
            _bw.write(_wl_block11Bytes, _wl_block11);

/*
	out.println("start :"+start);
	out.println("row_disp :"+row_disp);
	out.println("row_count :"+row_count);
*/
	if ( (!(start <= 1)) && (start < row_count)){
	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
	
	}

	if ( !( (start+row_disp) >= row_count ) ){
	
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

	}

	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(diplayLabel));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

	try{
		if(tabVal.equals("S")){	
			for(int i=fm_disp; i<=to_disp; i++){

				classValue			=	( (i%2)==0 )? "gridData" : "gridData";
				htListRecord		=	(java.util.HashMap)	IndexSheetRecordSet.getListObject(i);
										
				code				=	(String)	htListRecord.get("code");
				pract_desc			=	(String)	htListRecord.get("pract_desc");
				valid				=	(String)	htListRecord.get("valid");
				associate_yn		=	(String)	htListRecord.get("associate_yn");

				if(associate_yn == null || associate_yn.equals("null"))associate_yn="N";
				//status				=	(String)    htListRecord.get("status");
				stats  				=	IndexSheetRecordSet.containsObject(code);
				
				if(stats){
					valid = IndexSheetRecordSet.getValidKey(code);
				}

				/********************/
				if(valid.equals("Y")){
					checkValue="checked";
					disabled="disabled";
				}else{
					if(associate_yn.equals("Y")){
						checkValue="checked";
						disabled="";
					}else{
						if((stats)&&(associate_yn.equals("N"))){
							checkValue="checked";
							disabled="";
						}else{
							checkValue="";
							disabled="";
						}
					}
				}

				/**********************/
			
				//out.println("valid :"+valid);
				//out.println("associate_yn :"+associate_yn);
				//out.println("stats :"+stats);
					
				tblrow_id	=	"tblrow_id"+i;

				
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(((pract_desc.equals(""))?"&nbsp;":pract_desc)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(checkValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block26Bytes, _wl_block26);

				}
			}else if(tabVal.equals("A")){
				for(int i=fm_disp; i<=to_disp; i++){
				classValue			=	( (i%2)==0 )? "gridData" : "gridData";
				htListRecord		=	(java.util.HashMap)	IndexSheetRecordSet.getObject(i);
										
				code				=	(String)	htListRecord.get("code");
				pract_desc			=	(String)	htListRecord.get("pract_desc");
				valid				=	(String)	htListRecord.get("valid");
				associate_yn		=	(String)	htListRecord.get("associate_yn");
				//status_db			=	(String)	htListRecord.get("status");


				//out.println("valid :"+valid);
				//out.println("associate_yn :"+associate_yn);
				//out.println("status_db :"+status_db);

				tblrow_id	=	"tblrow_id"+i;

			
				if(valid.equals("N")){
					if(associate_yn.equals("Y"))
						checkValue="checked";
					else 
						checkValue="";
				}
				else{
					if(associate_yn.equals("D"))
						checkValue="";
					else 
						checkValue="checked";
				}
								
				
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
if(valid.equals("Y")){
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(((pract_desc.equals(""))?"&nbsp;":pract_desc)));
            _bw.write(_wl_block30Bytes, _wl_block30);
}else{
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(((pract_desc.equals(""))?"&nbsp;":pract_desc)));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(checkValue));
            _bw.write(_wl_block34Bytes, _wl_block34);

				}
			}
		}
		catch(Exception e){
			System.out.println("Exception@2: "+e);
		}
	
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(from));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(to));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(fm_disp));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(to_disp));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(diplayLabel));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dispMode));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(tabVal));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.getFunctionId()));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block48Bytes, _wl_block48);

		putObjectInBean(bean_id,bean,request);
 

            _bw.write(_wl_block49Bytes, _wl_block49);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }
}
