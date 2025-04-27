package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.CommonBean;

public final class __pickgenpatientdtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/PickGenPatientDtl.jsp", 1709120308000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script type=\'text/javascript\' src=\'../../eOT/js/Booking.js\'></script>\n<script type=\"text/javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script language=\'javascript\'>\nfunction callPatientSearch(){\n\tvar patient_id\t=\tdocument.forms[0].patient_id;\n\tvar return_value =\t\"\";\n\treturn_value\t=\tPatientSearch();\t\n\tif(return_value!=null && return_value !=\"undefined\"){\n\t\tdocument.forms[0].patient_id.value=return_value;\n\t}else{\n\t\tdocument.forms[0].patient_id.value=\"\";\n\t}\n\tdocument.forms[0].submit();\n}\nfunction funResetAll(){\n\tvar frmObj=document.forms[0];\n\tfrmObj.oper_date.value=\"\";\n\tfrmObj.patient_id.value=\"\";\n\tfrmObj.patientName.value=\"\";\n\tfrmObj.sex.value=\"\";\n\tfrmObj.oper_num.value=\"\";\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"addlSearchCriteriaForm\" id=\"addlSearchCriteriaForm\" method=\'post\' action=\"../../eOT/jsp/PickGenPatientDtl.jsp\">\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<table cellpadding=3  cellspacing=\"0\" border=\"0\" width=\"100%\" align =\"center\" >\n<tr>\n\n<td class=\"label\" width=\"25%\" >\n\t<fmt:message key=\"eOT.OperationDate.Label\" bundle=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"/>\n</td>\n<td  class=\"fields\" width=\"25%\" >\n<input type=\'text\' name=\'oper_date\' id=\'oper_date\' size=\'11\'   value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'  maxlength=\'10\' >\t\n<image src=\"../../eCommon/images/CommonCalendar.gif\"\t\nonClick=\"return showCalendar(\'oper_date\');\">\t\t\n<img src=\'../../eCommon/images/mandatory.gif\'></img>\n</td>\n<td colspan=\'2\'></td>\n</tr>\n\n\n<tr>\n<td class=\"label\" align=\"right\" >\n\t<fmt:message key=\"Common.patientId.label\" bundle=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/>\n</td>\n<td  class=\"fields\" width=\"25%\" >\n<input type=\'text\' name=\'patient_id\' id=\'patient_id\' maxlength=\'20\' size=\'20\' value= \"\" readonly>\n<input type=\'button\' class=\'button\' value=\'?\' name=\'surButton\' id=\'surButton\' onClick=\"callPatientSearch();\">\n</td>\n<td class=\"label\" width=\"25%\" >\n<input type=\'text\' name=\'patientName\' id=\'patientName\' maxlength=\'60\' size=\'45\' value= \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" >\n</td>\n</tr>\n\n\n<tr>\n<td  class=\'label\' width=\"25%\">\n\t<fmt:message key=\"Common.gender.label\" bundle=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/>\t\n</td>\n\n<td class=\"fields\" width=\"25%\" >\n<input type=\'text\' name=\'sex\' id=\'sex\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n</td>\n\n<td  class=\'label\' width=\"25%\" >\n\t<fmt:message key=\"Common.DateofBirth.label\" bundle=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>\t\n<input type=\'text\' name=\'dob\' id=\'dob\' size=\'11\'   value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'  maxlength=\'10\' disabled>\t</td>\n<td  class=\'label\' width=\"25%\" >\n<fmt:message key=\"eOT.OperationNo.Label\" bundle=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/>\n<select name=\'oper_num\' id=\'oper_num\'>\n\t<option value=\'\'>\n\t<fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/>\n\t</option>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</select>\n\n</td>\t\t\n</tr>\n<tr>\n\t<td class=\"fields\" width=\"25%\">\n\t<input type=\"button\" class=\"button\" name=\"search\" id=\"search\" value=\'<fmt:message key=\"Common.search.label\" bundle=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>\' onClick=\"\">\n\t<input type=\"button\" class=\"button\" name=\"clear\" id=\"clear\" value=\'fmt:message key=\"Common.clear.label\" bundle=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/>\'\tonClick=\"funResetAll()\"\n\t</td>\n\t</tr>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</table>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);


String sql="";

String 	strFacilityId=(String)session.getValue("facility_id"); 	 

Connection con = ConnectionManager.getConnection(request);
PreparedStatement pstmt = null;
ResultSet rs=null;
String strPatientId="";
String strName="";
String strSex="";
String strAge="";
String strOperDate="";

try
{
strOperDate=CommonBean.checkForNull(request.getParameter("oper_date"));
strPatientId=CommonBean.checkForNull(request.getParameter("patient_id"));


  if(strPatientId!=null&&!strPatientId.equals(""))
	  {

sql=OTRepository.getOTKeyValue("SQL_OT_PICGENBYDTL_SELECT1");

/*sql="  SELECT SHORT_NAME SHORT_NAME1, DECODE(SEX,'M', 'Male', 'F', 'Female', 'Unknown') SEX1 , DATE_OF_BIRTH DATE_OF_BIRTH1  FROM MP_PATIENT_MAST  WHERE PATIENT_ID = ?";
*/

		 pstmt = con.prepareStatement(sql);
		 pstmt.setString(1,locale);
		 pstmt.setString(2,strPatientId);
		 rs=pstmt.executeQuery();
		 if(rs.next())
		  {
		 strName=CommonBean.checkForNull(rs.getString("SHORT_NAME1"));
		 strAge=CommonBean.checkForNull(rs.getString("DATE_OF_BIRTH1"));
		 strSex=CommonBean.checkForNull(rs.getString("SEX1"));
		  }
	   rs.close();	  
	  pstmt.close();
 }



            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(strOperDate));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strName));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strSex));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strAge));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);



strPatientId=CommonBean.checkForNull(request.getParameter("patient_id"));
if(strPatientId.length()>0 )
{

sql=OTRepository.getOTKeyValue("SQL_OT_PICGENBYDTL_SELECT2");

   
/*	sql="SELECT OPER_NUM  FROM OT_POST_OPER_HDR  WHERE OPERATING_FACILITY_ID = ?  AND OPER_DATE = ?  AND PATIENT_ID = NVL(?, PATIENT_ID)";
*/

pstmt=con.prepareCall(sql);
pstmt.setString(1,strFacilityId);
pstmt.setString(2,strOperDate);
pstmt.setString(3,strPatientId);
rs=pstmt.executeQuery();

String dumValue="";
while(rs.next())
	{
	dumValue=rs.getString(1);
	out.println("<option value='"+dumValue+"'>"+dumValue+"</option>");
	}
	rs.close();
	pstmt.close();
}

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
 	  
}catch(Exception ee){}
finally
{
if(rs!=null) rs.close();	
if(pstmt!=null)
pstmt.close();
ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block20Bytes, _wl_block20);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
