package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __moburialpermitsearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MOBurialPermitSearch.jsp", 1709118403869L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script language=\'javascript\' src=\'../../eMO/js/MOBurialPermit.js\' ></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script>\n<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\' > </script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onload=\'document.forms[0].burial_permit_no.focus();\'>\n\t<form name=\"bury_form\" id=\"bury_form\" action=\"../../servlet/eMO.MOBurialPermitServlet\" method=\"post\" target=\"messageFrame\">\n\t<input type=hidden name =\"facilityId\" value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t<input type=hidden name =\"patient_id\" value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t<input type=hidden name =\"sydate\" value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t<input type=hidden name =\"ssdate\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t<input type=hidden name =\"mode\" value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t<br><br>\n\t <table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" align=\'center\' width=\'90%\'>\n\t <tr>\n\t     <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;&nbsp;</td>\n\t\t <td class=\'field\' width=\'25%\'><input type=\'checkbox\' name=\"gen_burial_permit\" id=\"gen_burial_permit\"  onClick=\'genBurialPerNo(this);\' value=\'N\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" >\n\t\t </td> \n\t\t <td class=\'label\'  width=\'25%\' colspan=\'2\'></td>\n\t </tr>\n\t <tr>\t\n\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<!--maxlength=\"16\" canged to max_size_burial_permit_no, Added by santhosh for ML-MMOH-CRF-1947-->\n\t\t\t\t<td class=\'field\' width=\'25%\'><input type=\'text\' size=\"16\" maxlength=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" tabindex=\'1\' name=\'burial_permit_no\'  onKeyPress=\"return CheckForSpecChars(event);\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'  ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" ><img id=\'mand2\' tabindex=\'2\' src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t  </td> \n\t      ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="<!--maxlength=\"16\" canged to max_size_burial_permit_no, Added by santhosh for ML-MMOH-CRF-1947-->\n\t\t\t\t<td class=\'field\' width=\'25%\'><input type=\'text\' size=\"16\" tabindex=\'1\' maxlength=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" name=\'burial_permit_no\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'  onKeyPress=\"return CheckForSpecCharsLocal(event);\" onblur=\'burialNoValid(this);\' ><img id=\'mand2\' tabindex=\'2\' src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t\t</td>\n\t\t  ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t  <td class=\'label\' width=\'25%\' colspan=\'2\'></td>\n\n\t  </tr>\t\n\t  <tr>\t\n\t      <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t  <td class=\'field\' width=\'25%\'>\n\t\t  <!-- isRemoveMandBPermitAppBy condition Added by Dharma on 2oth July against ML-MMOH-CRF-0692 [IN:062311]-->\n\t\t ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t  <input type=\"text\" name=\"burial_permit_app_desc\" id=\"burial_permit_app_desc\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" size=\"30\" maxlength=\"30\" onBlur=\'beforeGetPractitioner(document.forms[0].pract_id,burial_permit_app_desc);\'><input type=\'button\' name=\'pract_id\' id=\'pract_id\' value=\'?\' class=\'button\' onclick=\'searchCode(this, burial_permit_app_by)\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n         <input type=\'hidden\' name=\'burial_permit_app_by\' id=\'burial_permit_app_by\' value =\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<!--Modified by Ashwini on 01-Jul-2019 for ML-MMOH-CRF-0990-->\n\t\t\t<input type=\'text\' name=\'burial_permit_app_by\' id=\'burial_permit_app_by\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" size=\"60\" maxlength=\"60\"/>\n\t\t\t<input type=\'hidden\' name=\"burial_permit_app_desc\" id=\"burial_permit_app_desc\" value=\"\"/>\n\t\t\t<input type=\'hidden\' name=\'pract_id\' id=\'pract_id\' value=\"\"/>\n\n\t\t  ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t</td>\n\t   \t<td class=\'label\' width=\'25%\' colspan=\'2\'></td>\n  \t\n\t </tr>\n\t   ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\t\t  \n\t   <tr>\t\t      \n\t      <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t      <td class=\'field\' width=\'25%\'><input type=\'text\' size=\"16\" maxlength=\"16\" name=\'bpadate\' id=\'bpadate\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" onblur=\'dtchk2(this);\'><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].bpadate.select();return showCalendar(\'bpadate\', null, \'hh:mm\' );\"><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t  </td> \t\n\t\t  <td class=\'label\' width=\'25%\' colspan=\'2\'></td>\n\t   </tr>\n       ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\n         <tr>\t\t      \n\t      <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" onblur=\'dtchk2(this);\'><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].bpadate.select();return showCalendar(\'bpadate\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\"><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t  </td> \n\t\t  <td class=\'label\' width=\'25%\' colspan=\'2\'></td>\n\t   </tr>\n       ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t</table>\n\t<input type=\'hidden\' name=\'deceased_date\' id=\'deceased_date\' value =\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t<input type=\'hidden\' name=\'isRemoveMandBPermitAppBy\' id=\'isRemoveMandBPermitAppBy\' value =\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'> <!--Added by Dharma on 2oth July against ML-MMOH-CRF-0692 [IN:062311]-->\n </form>\n </body>\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n</html>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

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
	 request.setCharacterEncoding("UTF-8");


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
 Connection con 					  = null;
 java.sql.Statement stmt1					  = null; 
 ResultSet rset					      = null;
 StringBuffer sql					  = new StringBuffer();
 String locale		                    = (String)session.getAttribute("LOCALE");
 String	facility_id 				  = (String) session.getValue( "facility_id" ) ;
 String patientid = request.getParameter("param");
 if(patientid==null) patientid = "";
 String mode = request.getParameter("mode");
 if(mode==null) mode = "";
 
 String modePro ="";
 String burial_permit_no          ="";
 String burial_permit_approved_by_name ="";
 String burial_permit_approved_by = "";
 String burial_permit_approved_date ="";
 
 String genBurialPermitNo = "";
 if(mode.equals("query") ){
	 modePro ="readonly";
	 genBurialPermitNo = "disabled";
 }
 try
  {
     con			=	ConnectionManager.getConnection(request);

     String sydate	=	"";
	 String deceased_date = "";
	 String ssdate	=	"";
	 Boolean isRemoveMandBPermitAppBy = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","BURIAL_PERMIT_MANDATORY");//Added by Dharma on 2oth July against ML-MMOH-CRF-0692 [IN:062311]
     if(!(patientid.equals("")))
	 {
		 sql.append("select to_char(DECEASED_DATE,'dd/mm/yyyy hh24:mi') DECEASED_DATE from mp_patient where patient_id='"+patientid+"' and DECEASED_YN ='Y' ");
		 stmt1	= con.createStatement();
		 rset	= stmt1.executeQuery(sql.toString());
		 while(rset!=null  && rset.next())
		 {
			   deceased_date = rset.getString("DECEASED_DATE");
		 }
	  }	  
	  sql.setLength(0);
	  if(deceased_date==null || deceased_date.equals("null")) deceased_date = "";
	  if(rset!=null) rset.close();
	  if(stmt1!=null) stmt1.close();

	  if(!(patientid.equals("")))
		{
			stmt1 = con.createStatement();
			rset = stmt1.executeQuery("select to_char(sysdate,'dd/mm/yyyy hh24:mi') ot_date_time,to_char(sysdate,'dd/mm/yyyy')ssdate from dual");
			while(rset.next())
			{
			   sydate = rset.getString("ot_date_time");
			   ssdate = rset.getString("ssdate");
			}
			if(rset!=null) rset.close();
	        if(stmt1!=null) stmt1.close();
		

		    stmt1 = con.createStatement();
			rset = stmt1.executeQuery("select DISCH_PRACTITIONER_ID, DISCH_PRACT_NAME from mo_encounter_dtls_vw where  facility_id='"+facility_id+"' and patient_id='"+patientid+"'");
			while(rset.next())
			{
			   burial_permit_approved_by = rset.getString("DISCH_PRACTITIONER_ID")==null?"":rset.getString("DISCH_PRACTITIONER_ID");
			   burial_permit_approved_by_name = rset.getString("DISCH_PRACT_NAME")==null?"":rset.getString("DISCH_PRACT_NAME");
			}
			if(rset!=null) rset.close();
	        if(stmt1!=null) stmt1.close();
		
		
		}
    /*   if(mode.equals("query")){
	
		strsql2="select patient_id,burial_permit_no, burial_permit_approved_by_name,burial_permit_approved_by,burial_permit_approved_date from mo_burial_permit_vw where  facility_id='"+facility_id+"' and patient_id='"+patientid+"'"; 
		stmt1 = con.createStatement();
		rset = stmt1.executeQuery(strsql2);
		while(rset.next())
		{
          patient_id                     = rset.getString("patient_id");
	      burial_permit_no               = rset.getString("burial_permit_no");
	      burial_permit_approved_by_name = rset.getString("burial_permit_approved_by_name");
		  burial_permit_approved_by      = rset.getString("burial_permit_approved_by");
	      burial_permit_approved_date= rset.getString("burial_permit_approved_date");
        }
		patient_id	= (patient_id== null) ? "" :patient_id;
	    burial_permit_no	= (burial_permit_no== null) ? "" :burial_permit_no;
	    burial_permit_approved_by_name	= (burial_permit_approved_by_name== null) ? "" :burial_permit_approved_by_name;
		burial_permit_approved_by	= (burial_permit_approved_by== null) ? "" :burial_permit_approved_by;
	    burial_permit_approved_date	= (burial_permit_approved_date== null) ? "" :burial_permit_approved_date;
	 }*/
	 
	 
	 /*Added by santhosh for ML-MMOH-CRF-1947 Start*/
	 Boolean maxSizeBurialPermitAppl = false;
	 maxSizeBurialPermitAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MO","MAX_SIZE_BURIAL_PERMIT");
	 String max_size_burial_permit_no = "";
	 stmt1 = con.createStatement();
		rset = stmt1.executeQuery("select NVL(MAX_SIZE_BURIAL_PERMIT_NO,0) MAX_SIZE_BURIAL_PERMIT_NO, DATETIME_CLAIM_MAND from mo_parameter a where  a.facility_id='"+facility_id+"' ");
		while(rset.next())
		{
		   max_size_burial_permit_no = (maxSizeBurialPermitAppl)?rset.getString("MAX_SIZE_BURIAL_PERMIT_NO"):"16";
		}
		if(rset!=null) rset.close();
		if(stmt1!=null) stmt1.close();
		
	/*END*/

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sydate));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ssdate));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(genBurialPermitNo));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
if(mode.equals("query")){
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(max_size_burial_permit_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(burial_permit_no));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(modePro));
            _bw.write(_wl_block20Bytes, _wl_block20);
}else{
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(max_size_burial_permit_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(burial_permit_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
 if(!isRemoveMandBPermitAppBy){
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(burial_permit_approved_by_name));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(burial_permit_approved_by));
            _bw.write(_wl_block28Bytes, _wl_block28);
}else{
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(burial_permit_approved_by_name));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
if(mode.equals("query")){
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(DateUtils.convertDate(burial_permit_approved_date,"DMYHM","en",locale)));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(DateUtils.convertDate(sydate,"DMYHM","en",locale)));
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(deceased_date));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(isRemoveMandBPermitAppBy));
            _bw.write(_wl_block39Bytes, _wl_block39);
 
	        if(rset!=null) rset.close();
	        if(stmt1!=null) stmt1.close();
   } 
   catch(Exception e){ out.println("Main "+e);}
   finally
    {
		    ConnectionManager.returnConnection(con,request);
    }

            _bw.write(_wl_block40Bytes, _wl_block40);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.GenerateBurialPermit.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermitNumber.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermitApprovedBy.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermitApprovalDate.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermitApprovalDate.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }
}
