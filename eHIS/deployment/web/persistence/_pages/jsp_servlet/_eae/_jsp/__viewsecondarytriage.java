package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __viewsecondarytriage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/ViewSecondaryTriage.jsp", 1709113891928L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script language=\'javascript\' src=\'../../eAE/js/AESecondaryTriage.js\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script> \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<form>\n<div name=\'msg\' id=\'msg\' style=\"position:absolute;width: 0; height: 0; left: 150; top: 62\">\n</div>\n\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n<tr><th align=\'left\'>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</th></tr>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<tr ><td class=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' id=tddata";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =">\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n </tr>\n</table>\n\t    <input type=hidden name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t    <input type=hidden name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t<input type=hidden name=\'treatment_area_code\' id=\'treatment_area_code\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t<input type=hidden name=\'treatment_area_desc\' id=\'treatment_area_desc\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t    <input type=hidden name=\'clinic_type\' id=\'clinic_type\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t<input type=hidden name=\'clinic_code\' id=\'clinic_code\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t<input type=hidden name=\'clinic_desc\' id=\'clinic_desc\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t<input type=hidden name=\'priority_zone\' id=\'priority_zone\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t    <input type=hidden name=\'bed_no\' id=\'bed_no\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t    <input type=hidden name=\'called_from_ca\' id=\'called_from_ca\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t    <input type=hidden name=\'queue_date\' id=\'queue_date\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t    <input type=hidden name=\'brought_dead\' id=\'brought_dead\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t<input type=hidden name=\'queue_status\' id=\'queue_status\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t<input type=hidden name=\'open_to_all_pract_yn\' id=\'open_to_all_pract_yn\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t<input type=hidden name=\'fbc_yn\' id=\'fbc_yn\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t<input type=hidden name=\'open_to_all_prac_for_clinic_yn\' id=\'open_to_all_prac_for_clinic_yn\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t<input type=\'hidden\' name=\'queryString\' id=\'queryString\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t<input type=\'hidden\' name=\'page_name\' id=\'page_name\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\n</form>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</BODY>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}


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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

 

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='CONTENT' onKeyDown = 'lockKey()'>");
	  Connection con = null;

      PreparedStatement pstmt1=null;
      ResultSet rs=null;
      int i=0;
		String open_to_all_pract_yn = "";
		String open_to_all_prac_for_clinic_yn = "";
		String clinic_code = "";
		String clinic_type = ""; 
		String clinic_desc = "";
		String treatment_area_code = "";
		String treatment_area_desc = "";
		String queue_status = "";	
		String queue_date	=	"";
		String rec_date_time="";
		String modified_by_id = "";
		String treatment_area_desc1 ="";
		String fbc_yn ="";

       	request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
	    String locale			= (String)session.getAttribute("LOCALE");


		String patient_id	 = checkForNull(request.getParameter("patient_id"));
		String facility_id	 =(String)session.getValue("facility_id");
		String encounter_id	 = checkForNull(request.getParameter("encounter_id"));
		String priority_zone = checkForNull(request.getParameter("priority_zone"));
		String brought_dead	 = request.getParameter("brought_dead")==null?"N":request.getParameter("brought_dead");
		String bed_no= checkForNull(request.getParameter("bed_no"));
		String called_from_ca  =    request.getParameter("called_from_ca");
    	queue_date			   =	checkForNull(request.getParameter("queue_date"));	
	//	disaster_yn			   =    checkForNull(request.getParameter("disaster_yn"));
		open_to_all_pract_yn   =    checkForNull(request.getParameter("open_to_all_pract_yn"));
        open_to_all_prac_for_clinic_yn = checkForNull(request.getParameter("open_to_all_prac_for_clinic_yn"));
		clinic_code          = checkForNull(request.getParameter("clinic_code"));
        clinic_type          = checkForNull(request.getParameter("clinic_type"));
		clinic_desc          = checkForNull(request.getParameter("clinic_desc"));
		treatment_area_code  = checkForNull(request.getParameter("treatment_area_code"));
		treatment_area_desc  = checkForNull(request.getParameter("treatment_area_desc"));
        treatment_area_desc1 = checkForNull(request.getParameter("treatment_area_desc"));
		queue_status         = checkForNull(request.getParameter("queue_status"));
		bed_no				 = checkForNull(request.getParameter("bed_no"));
		/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		String called_from	= checkForNull(request.getParameter("called_from"));
		String RepDb		= checkForNull(request.getParameter("RepDb"));
		String page_name = checkForNull(request.getParameter("page_name"));//Added by santhosh for ML-MMOH-SCF-2384
		if(called_from.equals("CDR"))
			facility_id	= checkForNull(request.getParameter("facility_id"));
		/*End*/

		try
		{
	       	 con = webbeans.eCommon.ConnectionManager.getConnection(request);
  
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
 
String classValue = "" ;
int countRec =0;
StringBuffer strsql = new StringBuffer();

strsql.append("SELECT   to_char(RECORDED_DATE,'dd/mm/yyyy hh24:mi:ss')  recorded_date,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC ##REPDB##( facility_id,CLINIC_CODE,TREATMENT_AREA_CODE,'"+locale+"','2') TREATMENT_AREA_DESC,FBC_YN, MODIFIED_BY_ID FROM AE_PAT_EMERGENCY_DETAIL ##REPDB## where  facility_id = ? AND  encounter_id=? order by RECORDED_DATE DESC");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1

/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
String sqlFinal = strsql.toString();
sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
/*End*/

pstmt1 = con.prepareStatement(sqlFinal,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
pstmt1.setString	(1,	facility_id);
pstmt1.setLong		(2,	Long.parseLong(encounter_id));

rs = pstmt1.executeQuery();
if(rs != null)
	    {
	          rs.last();
	          countRec = rs.getRow();
              rs.beforeFirst();
	    }
while ( rs.next()  )
{
	if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
	else
		classValue = "QRYODD" ;
 
  	rec_date_time = checkForNull(rs.getString("RECORDED_DATE"));
	treatment_area_desc = checkForNull(rs.getString("TREATMENT_AREA_DESC"));
	String record_date=rs.getString("RECORDED_DATE")==null?"": rs.getString("RECORDED_DATE");
	record_date=DateUtils.convertDate(record_date,"DMYHMS","en",locale);

	if (treatment_area_desc.equals("")){
		treatment_area_desc= treatment_area_desc1;
	}
	modified_by_id = checkForNull(rs.getString("MODIFIED_BY_ID"));
	fbc_yn = checkForNull(rs.getString("FBC_YN"));
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(i));
            _bw.write(_wl_block10Bytes, _wl_block10);

	out.println("<a  onMouseover='javascript:onMMove(msg,event,\""+java.net.URLEncoder.encode(treatment_area_desc)+"\",\""+java.net.URLEncoder.encode(modified_by_id)+"\");'  onMouseout='javascript:onMOut(msg);' href='javascript:loadJsp(\""+java.net.URLEncoder.encode(encounter_id)+"\",\""+java.net.URLEncoder.encode(rec_date_time)+"\",\""+i+"\",\""+countRec+"\",\""+called_from+"\");'>");
	out.println(record_date);
	out.println("</a></td></tr>");
	i++;
}
if (rs != null)	rs.close();
if (pstmt1 != null)	pstmt1.close();
if((strsql != null) && (strsql.length() > 0))
{
	strsql.delete(0,strsql.length());
}

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(treatment_area_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(clinic_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(called_from_ca));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(queue_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(brought_dead));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(fbc_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(open_to_all_prac_for_clinic_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(page_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
 
  }catch(Exception e) {e.printStackTrace();}
  finally
  {
     webbeans.eCommon.ConnectionManager.returnConnection(con,request);
  }

            _bw.write(_wl_block30Bytes, _wl_block30);
            _bw.write(_wl_block31Bytes, _wl_block31);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.RecordedDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
