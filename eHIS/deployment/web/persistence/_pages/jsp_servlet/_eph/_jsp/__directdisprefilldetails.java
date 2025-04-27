package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __directdisprefilldetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DirectDispRefillDetails.jsp", 1709120678611L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n <html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<head>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DirectDispensing.js\"></script>\n\t\t<!-- Added for IN:069886 start-->\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<!-- Added for IN:069886 end-->\n\t<!-- \t<script language=\"JavaScript\" src=\"../js/PhMessages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n -->\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"refill_form\" id=\"refill_form\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n\t\t<tr>\n\t\t\t<td class=\"label\" align=\"right\" colspan=\"2\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" </td>\n\t\t\t<td align=\"left\" ><input type=\"text\" name=\"no_refill\" id=\"no_refill\" size=\"2\"  maxlength=\"2\" onblur=\"validateNoRefill(this);\" class=\"NUMBER\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"></td>\n\t\t</tr>\n\t\t<th width=\"5%\">#</th>\n\t\t<th width=\"45%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t<th width=\"50%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="<!-- Modified for IN:069886 -->\n\t\t<input type=\"hidden\" name=\"refill_start_date_tmp\" id=\"refill_start_date_tmp\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t<tr><td class=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td><td class=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" > <input type=\"text\" name=\"refill_end_date_tmp\" id=\"refill_end_date_tmp\" size=\"14\"  maxlength=\"16\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" onblur=\"validateRefillEndDate(this,\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');\"  ><img SRC=\"../../eCommon/images/CommonCalendar.gif\"  name=\'endDateImg\'  onclick=\"showCalendar(\'refill_end_date_tmp\',null,\'hh:mm\');\"></td></tr>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<tr><td class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td></tr>\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</table>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n</body>\n<input type=\"hidden\" name=\"max_refills_for_pres\" id=\"max_refills_for_pres\"\t\tvalue=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\"hidden\" name=\"durn_value\" id=\"durn_value\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\"hidden\" name=\"max_durn_for_refill_pres\" id=\"max_durn_for_refill_pres\"\tvalue=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\"hidden\" name=\"end_date\" id=\"end_date\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=\"hidden\" name=\"repeat_durn_type\" id=\"repeat_durn_type\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<input type=\"hidden\" name=\"srl_no\" id=\"srl_no\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\t\t\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\t\t\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\t\n<input type=\"hidden\" name=\"mode\" id=\"mode\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\"hidden\" name=\"refill_start_date\" id=\"refill_start_date\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\"hidden\" name=\"refill_end_date\" id=\"refill_end_date\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<!-- Added for IN:069886 start, Modified for IN:06886 Start-->\n<input type=\"hidden\" name=\"date_range_in_muliples\" id=\"date_range_in_muliples\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type=\"hidden\" name=\"last_refill_durn_value\" id=\"last_refill_durn_value\" value=\"\">\n<input type=\"hidden\" name=\"last_refill_freq_chnage_durn_value\" id=\"last_refill_freq_chnage_durn_value\" value=\"\">\n<input type=\"hidden\" name=\"interval_value\" id=\"interval_value\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type=\"hidden\" name=\"freq_durn_type\" id=\"freq_durn_type\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n <input type=\"hidden\" name=\"change_last_refill_end_date_appl_yn\" id=\"change_last_refill_end_date_appl_yn\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<!-- Added for IN:069886 end,  Modified for IN:06886 end -->\n</form>\n\n\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n</html>\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );
	
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
 
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------

20/10/2020      IN:069886         Haribabu                       Manickam            MO-CRF-20151
--------------------------------------------------------------------------------------------------------------
*/
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	    request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    //ends
	String locale			= (String)session.getAttribute("LOCALE");
	

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

//String params					=   request.getQueryString() ;
String mode						=   CommonRepository.getCommonKeyValue( "MODE_INSERT" );
String end_date					=	request.getParameter("end_date");
String srl_no					=	request.getParameter("srl_no");
String repeat_durn_type			=	request.getParameter("repeat_durn_type");
String durn_value				=	request.getParameter("durn_value");
String refill_no				=	request.getParameter("refill_no");
String max_refills_for_pres		=	request.getParameter("max_refills");
String max_durn_for_refill_pres	=	request.getParameter("max_durn_for_refill_pres");
String bean_id					=	request.getParameter("dir_bean_id");
String bean_name				=	request.getParameter("dir_bean_name");
String date_range_in_muliples	=	request.getParameter("date_range_in_muliples")==null?"1":request.getParameter("date_range_in_muliples");//Added for IN:069886
//String tmp_durn_value			=	request.getParameter("tmp_durn_value");//Added for IN:069886 //Commented for IN:069886
String freq_durn_type	=	request.getParameter("freq_durn_type")==null?"":request.getParameter("freq_durn_type");//Added for IN:069886
String interval_value	=	request.getParameter("interval_value")==null?"1":request.getParameter("interval_value");//Added for IN:069886
String classvalue				=	"";
DirectDispensingBean bean		= (DirectDispensingBean)getBeanObject(bean_id,bean_name,request) ;
//HashMap RefillDetail			= (HashMap) bean.populateRefillDetail(end_date,durn_value, repeat_durn_type,refill_no);// commentted for for IN:069886
String refill_st_date			=	"";
String refill_en_date			=	"";
HashMap refill_dates			=(HashMap) bean.populateRefillDates(end_date,durn_value,repeat_durn_type,refill_no);
//Added for IN:069886 start
boolean change_last_refill_end_date_appl =bean.isSiteSpecific("PH","CHANGE_LAST_REFILL_END_DATE");//added for MO-CRF-20151
String change_last_refill_end_date_appl_yn="N";
if(change_last_refill_end_date_appl){
	change_last_refill_end_date_appl_yn="Y";
}
HashMap RefillDetail= (HashMap) bean.getRefillDetail(srl_no);//Modified for IN:069886
if(RefillDetail!=null){
	if(!(((String)RefillDetail.get("end_date")!=null && ((String)RefillDetail.get("end_date")).equals(end_date)) && ((String)RefillDetail.get("durn_value")!=null &&((String)RefillDetail.get("durn_value")).equals(durn_value)) && ((String)RefillDetail.get("repeat_durn_type")!=null && ((String)RefillDetail.get("repeat_durn_type")).equals(repeat_durn_type)) && ((String)RefillDetail.get("refill_no")!=null && ((String)RefillDetail.get("refill_no")).equals(refill_no)))){
		 RefillDetail			= (HashMap) bean.populateRefillDetail(end_date,durn_value, repeat_durn_type,refill_no);
	}
}
else{
 RefillDetail			= (HashMap) bean.populateRefillDetail(end_date,durn_value, repeat_durn_type,refill_no);
}
//Added for IN:069886 end
if(RefillDetail.size()>0){
		
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(refill_no));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

		ArrayList refill_start_date=(ArrayList) RefillDetail.get("refill_start_date");
		ArrayList refill_end_date=(ArrayList) RefillDetail.get("refill_end_date");
	//Modified for IN:069886 start
		if(refill_start_date != null && refill_start_date.size()>0){
			refill_st_date	=	(String) refill_start_date.get(0);
		}
		
		if(refill_end_date != null && refill_end_date.size()>0){
			refill_en_date	=	(String) refill_end_date.get(refill_end_date.size()-1);
		}
		for(int i=0;i<refill_start_date.size();i++){
			if ( i % 2 == 0 ) classvalue = "QRYODD" ;
			else classvalue = "QRYEVEN" ;
			String refill_end_date_tmp=(String) refill_end_date.get(i);
			String refill_start_date_tmp=(String) refill_start_date.get(i);
		if(i==(refill_start_date.size()-1) && change_last_refill_end_date_appl){
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(refill_start_date_tmp));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String) refill_start_date.get(i)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(refill_end_date_tmp));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(refill_st_date));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(max_durn_for_refill_pres));
            _bw.write(_wl_block21Bytes, _wl_block21);
}else{ 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String) refill_start_date.get(i)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((String) refill_end_date.get(i)));
            _bw.write(_wl_block24Bytes, _wl_block24);

		}}
		//Modified for IN:069886 end
	
            _bw.write(_wl_block25Bytes, _wl_block25);

//Modified for IN:069886 code moved to top
	//	refill_st_date	=	(String) refill_dates.get("refill_st_date");
		//refill_en_date	=	(String) refill_dates.get("refill_en_date");
//Modified for IN:069886 end
	}

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(max_refills_for_pres));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(durn_value));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(max_durn_for_refill_pres));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(repeat_durn_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(refill_st_date));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(refill_en_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(date_range_in_muliples));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(interval_value));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(freq_durn_type));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(change_last_refill_end_date_appl_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);
 putObjectInBean(bean_id,bean,request); 
            _bw.write(_wl_block42Bytes, _wl_block42);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NoofRefill.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
