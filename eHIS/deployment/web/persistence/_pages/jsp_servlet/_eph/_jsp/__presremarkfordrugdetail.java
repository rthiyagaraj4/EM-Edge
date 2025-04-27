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
import java.text.DecimalFormat;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __presremarkfordrugdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PresRemarkForDrugDetail.jsp", 1709121272238L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\n\t\t<head>\n\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t\t<script language=\"JavaScript\" src=\"../js/PhCommon.js\"></script>\n\t\t\t<script language=\"JavaScript\" src=\"../js/PresRemarkForDrug.js\"></script>\n\t\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t\t<script language=\"javascript\" SRC=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n\t\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t</head>\n\t\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\n\t\t\t<form name=\"PresRemarkForDrugDetailForm\" id=\"PresRemarkForDrugDetailForm\">\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\"\n\t\t\t\t\tborder=\"1\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"2\"></td>\n\t\t\t\t\t</tr>\n\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\'60%\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\'15%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\'15%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\'10%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<td class=\'QRYODD\' >&nbsp;";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' style=\'color:";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =";background-color:";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =";\'>&nbsp;";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'  ><input type=\'checkbox\' ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" name=\'DefaultRemark";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\tonClick=\"remarksDefaultCheck(this,\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\')\"></td><!--using recCount instead of remarksCnt SKR-SCF-1053[IN051947] -->\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'><input type=\'checkbox\' name=\'Remarks";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'Remarks";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" onClick=\"remarksCheck(this,\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\')\"></td>\n\t\t\t\t\t\t\t<td><input type=\"hidden\" name=\"modeOpn";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"modeOpn";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"></td>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<input type=\"hidden\" name=\"remarksCnt\" id=\"remarksCnt\" value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\"Drug_code\" id=\"Drug_code\" value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\"DrugSearch\" id=\"DrugSearch\" value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\"remarks_code\" id=\"remarks_code\" value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\"Drugcode\" id=\"Drugcode\" value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\"language_id\" id=\"language_id\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t\t</table>\n\t\t\t</form>\n\t\t</body>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n</html>\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	try{
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String bean_id	="PresRemarkForDrugBean";
		String bean_name	="ePH.PresRemarkForDrugBean";
		PresRemarkForDrugBean bean = (PresRemarkForDrugBean)getBeanObject(bean_id,bean_name ,request);	
		
		String drugSearch="";
		String drug_code=request.getParameter("drug_code");
		drugSearch=request.getParameter("drugSearch");
		
		String classValue="";
		String routeCode = request.getParameter("routecode");
		String formCode = request.getParameter("formcode");
		String params = "";
		bean.setLanguageId(locale);

		String drug_desc="";
		String drug_type_code="";
		String sel="";
		String selected="";
		String selValue="";
		
		String mode="";
		String drugdesc="";
		String drugcode="";
		String effstatus="";
		String effstatus_chk="";
		String remarks_code="";
		String default_remark_yn="";
		String default_remark_yn1="";
		String DefaultselValue="";
		String DefaultselCheck="";
		String DefaultselDis="";
		String db_action="";
		String eefault="";
		String umode="";
		String remarks_desc="";
		boolean selectall=true;
		boolean disableflag=false;
		String disabled="";

		int from = Integer.parseInt(request.getParameter("from")==null?"0":request.getParameter("from"));
		int to = Integer.parseInt(request.getParameter("to")==null?"10":request.getParameter("to"));

		String search = request.getParameter("search")==null?"":request.getParameter("search");
		mode = request.getParameter("mode")==null?"":request.getParameter("mode");
		ArrayList remarksSearchResults=new ArrayList();
		ArrayList remarksCodeList = new ArrayList();

		if(search.equals("new")){
			bean.clear();
			remarksSearchResults=bean.getRemarksResult(drug_code,drugSearch,formCode,routeCode,locale);
			disableflag=true;
		}
		remarksCodeList = bean.getRemarksCodeList();
		if(mode.equalsIgnoreCase("2")){
			remarksCodeList.clear();
			remarksSearchResults=bean.getRemarksResult(drug_code,drugSearch,formCode,routeCode,locale);
			remarksCodeList = bean.getDefaultRemark(drug_code);
		}
		int recCount=0;
		int codeCnt=0;
		int cnt1=0;
		int cntValue=0;
		String eff_status="";
		String default_value="";
		String eff_status_selected="";
		String default_value_selected="";
		String val="";
		String modeOpn="I";
		String defaultRoute="";
		String defaultRemarkRoute="";
		int maxRecord = remarksSearchResults.size();
		int codeListMaxRecord =remarksCodeList.size(); 
		bean.setMode(mode);
		bean.setLanguageId(locale);

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

					disabled = bean.getRouteCode();
					defaultRemarkRoute = bean.getDefaultRemarkRoute(drug_code);
					String route_color= "", fntColor="",backgrndColor="" ;// added for CRF RUT-CRF-0034.1[IN:037389]-start
					if((disabled.equals("%"))||(disabled.equalsIgnoreCase(defaultRemarkRoute))||(defaultRemarkRoute.equalsIgnoreCase(""))){
						disabled="";
					}
					else 
						disabled = "disabled='disabled'";
					for(int remarksCnt=0; remarksCnt < maxRecord; remarksCnt+=9){
						 if( (recCount)%2 == 0)  
							classValue="QRYODD";
						else
							classValue="QRYEVEN";

            _bw.write(_wl_block12Bytes, _wl_block12);

							remarks_code=(String)remarksSearchResults.get(remarksCnt+1) ; 
							route_color=(String)remarksSearchResults.get(remarksCnt+8); // added for CRF RUT-CRF-0034.1[IN:037389] -start
							if(route_color!= null && !route_color.equals("")){
								if(route_color.length()==12){
									fntColor= route_color.substring(0, 6);
									backgrndColor= route_color.substring(6, 12);
								}
							}// added for CRF RUT-CRF-0034.1[IN:037389]-end

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(remarksSearchResults.get(remarksCnt+2)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(backgrndColor));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(remarksSearchResults.get(remarksCnt+7)));
            _bw.write(_wl_block18Bytes, _wl_block18);

							if (remarksCodeList.contains(remarks_code))	{
								modeOpn = "U";						
								while(cnt1<codeListMaxRecord){
									fntColor= "";
									backgrndColor= "";
									if((remarksCodeList.get(cnt1++).toString().equalsIgnoreCase(remarks_code))  ){
										default_value=remarksCodeList.get(cnt1++).toString();
										eff_status=remarksCodeList.get(cnt1++).toString();
										remarksSearchResults.set(remarksCnt+4,default_value) ;
										remarksSearchResults.set(remarksCnt+5,eff_status) ;
										remarksSearchResults.set(remarksCnt+6,modeOpn) ;
										bean.setRemarksSearchList(remarksSearchResults);
										break;
									}
									else{
										cnt1+=2;//using 2 instead of 3 for SKR-SCF-1053[IN051947]
									}
								}
							}
							if(default_value.equalsIgnoreCase("Y"))
							   default_value_selected="checked";
							else
								default_value_selected="";

							if(eff_status.equalsIgnoreCase("E"))
							   eff_status_selected="checked";
							else
								eff_status_selected="";

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( disabled ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(default_value));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(default_value_selected));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(remarks_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(eff_status));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(eff_status_selected));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(remarks_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(modeOpn));
            _bw.write(_wl_block33Bytes, _wl_block33);

							recCount++;
							default_value ="N";
							eff_status= "D";
							modeOpn="I";
						    cnt1=0;//added for SKR-SCF-1053[IN051947]
						}	
						bean.setRemarksSearchList(remarksSearchResults);
						remarksCodeList.clear();

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(drugSearch));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(remarks_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugcode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block43Bytes, _wl_block43);
 
		putObjectInBean(bean_id,bean,request); 
	}
	catch(Exception e){
		e.printStackTrace();
	}

            _bw.write(_wl_block44Bytes, _wl_block44);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugPrescriptionRemarks.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Route.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DefaultRemark.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }
}
