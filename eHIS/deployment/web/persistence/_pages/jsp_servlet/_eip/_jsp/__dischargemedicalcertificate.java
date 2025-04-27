package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;

public final class __dischargemedicalcertificate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/DischargeMedicalCertificate.jsp", 1742378313222L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<HTML>\n<HEAD>\n<TITLE> ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" </TITLE>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n<script src=\'../js/DischargePatient.js\' language=\'javascript\'></script>\n\n<script src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n<script>\n\nfunction apply()\n{\n\tvar fields=new Array();\t\n\tfields[0]= document.medical_certificate_form.fit_for_duty_on;\n\tfields[1]= document.medical_certificate_form.issue_pract;\t\n\tvar names = new Array (\tgetLabel(\'eIP.FitForDutyon.label\',\'IP\'),\n\t\t\t\t\t\t\tgetLabel(\'eIP.IssuingPractitioner.label\',\'IP\'));\n\tif(checkFields1( fields, names))\n\t{\n\t\tvar p_facility_id\t\t= document.forms[0].facilityId.value;\n\t\tvar p_module_id\t\t\t= \"IP\";\n\t\tvar p_report_id\t\t\t= \"OAAFAPLST\";\n\n\t\tvar HtmlVal = \"<html><head></head><body onKeyDown=\'lockKey()\'><form name=\'dummy1_form\' id=\'dummy1_form\' action=\'../../eCommon/jsp/report_options.jsp\'><input type=\'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'\"+p_facility_id+\"\'><input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\'\"+p_report_id+\"\'><input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'\"+p_module_id+\"\'></form></body></html>\"\n\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HtmlVal);\n\t\tparent.messageFrame.document.dummy1_form.submit();\n\t}\n\n}\n\nfunction checkFields1( fields, names)\n{\n\tvar errors = \"\" ;\n\tfor( var i=0; i<fields.length; i++ ) {\n\t\tif(trimCheck1(fields[i].value)) {}\n\t\telse\t\n\t\t{\n\t\t\terrors = errors + getMessage(\"CAN_NOT_BE_BLANK\",\"Common\") +\"\\n\";\n\t\t\terrors = errors.replace(\"$\",names[i]);\n\n\t\t}\n\t}\n\tif ( errors.length != 0 ) {\n\t\talert(errors) ;\n\t\treturn false ;\n\t}\n\treturn true ;\n}\n\nasync function getPractitioner(target_id,target_name)\n{\n\tvar retVal = new String();\n\tvar dialogHeight= \"28\" ;\n\tvar dialogWidth\t= \"43\" ;\n\tvar status = \"no\";\n\tvar arguments\t= \"\" ;\n\tvar sql=\"\";\n\tvar search_code=\"\";\n\tvar search_desc=\"\";\n\tvar dispDescFirst=\"dispDescFirst\";\n\tvar tit=\"\";\n\tvar tit=getLabel(\'Common.practitioner.label\',\'common\')\t\n\tvar medicalteam = document.forms[0].medicalteam.value;\n\tsql = \"select  practitioner_id,practitioner_name from am_practitioner where eff_Status = `E` and practitioner_id in (SELECT practitioner_id from am_medical_team where team_id = `\"+medicalteam+\"`) \";\n\tsearch_code=\"practitioner_id\";\n\tsearch_desc= \"practitioner_name\";\n\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\tretVal = await window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+encodeURIComponent(tit)+\"&dispDescFirst=\"+dispDescFirst,arguments,features);\n\tvar arr=new Array();\n\tif (retVal != null)\n\t{ \n\t\tif (!(unescape(retVal) == null))\n\t\t{\n\t\t\tarr=unescape(retVal).split(\"::\");\n\t\t\ttarget_name.value=arr[0];\n\t\t\ttarget_id.value=arr[1];\n\t\t}\n\t}\n\telse\n\t{\n\t\ttarget_id.value=\"\";\n\t\ttarget_name.value=\"\";\n\t}\n\n}\n\nfunction doDateTimechk(obj)\n{\n\tvar objchk = obj.value;\n\tif(obj.value != \'\')\n\t\t{\n\t\tif(!self.doDateTimeChk(obj)){\n\t\t\tvar msg = self.getMessage(\"INVALID_DATE_TIME\",\"SM\");\n\t\t\talert(msg);\n\t\t\tobj.focus();\n\t\t\treturn false;\n\t\t}\n\t}\n\n\tif(objchk != 0)\n\t{\n\t\tvar comp=obj\n\t\tobj=obj.value\n\t\tvar sysdat = document.forms[0].currdate.value;\n\t\tvar dttime = obj.split(\" \");\n\t\tvar dt\n\t\tvar time\n\t\tvar retval=true\n\t\n\t\tif(dttime.length>1)\n\t\t{\n\t\t\tdt=dttime[0]\n\t\t\ttime=dttime[1]\t\n\t\t\tif(!checkDt(dt) )\n\t\t\t{\n\t\t\t\tretval= false\n\t\t\t\tcomp.focus()\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(time==null || time==\"\")\n\t\t\t\t{\t\n\t\t\t\t\talert(getMessage(\"INVALID_DATE_TIME\",\"SM\"))\n\t\t\t\t\tretval= false;\n\t\t\t\t\tcomp.focus()\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(!chkTime(time))\n\t\t\t\t\t{\n\t\t\t\t\t\tretval= false\n\t\t\t\t\t\talert(getMessage(\"INVALID_DATE_TIME\",\"SM\"))\n\t\t\t\t\t\tcomp.focus()\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t   \t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tretval= false\n\t\t\talert(getMessage(\"INVALID_DATE_TIME\",\"SM\"))\n\t\t\tcomp.focus()\n\t\t}\n\n\t\t\n\n\t\n\tif(retval != false)\t\n\t{\n\t\tValidateAmbDateTime(obj,sysdat);\t\t\t\n\t}\t\n\n\treturn retval\n\t  }\n\t}\n\t\nfunction ValidateAmbDateTime(from,to)\n{\n\t\n\tvar a=  from.split(\" \")\n\tsplitdate=a[0];\n\tsplittime=a[1]\n\n\tvar splitdate1 =a[0].split(\"/\")\n\tvar splittime1= a[1].split(\":\")\n\n\t var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\n\t a=  to.split(\" \")\n\tsplitdate=a[0];\n\tsplittime=a[1]\n\n\t splitdate1 =a[0].split(\"/\")\n\t splittime1= a[1].split(\":\")\n\t var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\t if(Date.parse(from_date) < Date.parse(to_date))\n\t{\n\t\talert(getMessage(\"F_DUTY_TIM_LT_CURDT\",\"IP\"));\n\t\tdocument.forms[0].fit_for_duty_on.focus();\n\t\tdocument.forms[0].fit_for_duty_on.select();\t\t\n\t\treturn false\n\t}\n\telse{\t\t\n\t\tvar fromval = from;\n\t\tvar toval   = document.forms[0].dischdate.value;\t\t\n\t\tValidateDateTime12(fromval,toval)\n\t\treturn true;\n\t\t\n\t\t}\t\n\t\t\n}\n\nfunction ValidateDateTime12(from,to)\n{\t\n\t var a=  from.split(\" \")\n\t splitdate=a[0];\n\t splittime=a[1]\n\t var splitdate1 =a[0].split(\"/\")\n\t var splittime1= a[1].split(\":\")\n\t var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\t a=  to.split(\" \")\n\t splitdate=a[0];\n\t splittime=a[1]\n\t splitdate1 =a[0].split(\"/\")\n\t splittime1= a[1].split(\":\")\n\t var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\t if(Date.parse(to_date) > Date.parse(from_date))\n\t{\n\t\talert(getMessage(\"LT_DISCHG_DATE\",\"IP\"))\n\t\tdocument.forms[0].fit_for_duty_on.focus();\n\t\tdocument.forms[0].fit_for_duty_on.select();\t\t\n\t\treturn false;\n\t}\n\telse\n\t\treturn true;\n\n}\t\t\n</script>\n</HEAD>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<BODY onLoad=\'document.forms[0].fit_for_duty_on.focus();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<FORM name = \'medical_certificate_form\' action=\'../../eCommon/jsp/report_options.jsp\'>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n<TABLE cellpadding=2 cellspacing=0 width=\"100%\" align = \'center\'>\n\t<TR>\n\t\t<TD class= \' label\' colspan=\'2\'>&nbsp;</TD>\n\t\t\n\t</TR>\t\n\t<TR>\n\t\t<TD class= \' label\' colspan=\'2\'>&nbsp;</TD>\n\t\t\n\t</TR>\t\t\n\t<TR >\n\t\t<TD class= \' label\' align =\'right\' width =\'50%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </TD>\n\t\t<TD  width =\'50%\'>&nbsp;<INPUT TYPE=\"text\" name=\"fit_for_duty_on\" id=\"fit_for_duty_on\" size = \'15\' Maxlength=\'16\' onBlur=\'doDateTimechk(this)\'>&nbsp<img align=center src=\"../../eCommon/images/mandatory.gif\"></img></TD>\n\t</TR>\n\t<TR>\n\t\t<TD class= \' label\' align =\'right\' width =\'50%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</TD>\n\t\t<TD width =\'50%\'>&nbsp;<input type=text Readonly name=pract_name id=pract_name value=\"\"  size=30 maxlength=30><input type=\"button\" name=\"pract_butt\" id=\"pract_butt\" value=\"?\" class=\"button\" onClick=\"getPractitioner(issue_pract,pract_name);\" ><input type=\"hidden\" name=\"issue_pract\" id=\"issue_pract\" value=\"\">&nbsp;<img src =\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</TD>\n\t</TR>\n\t<TR>\n\t\t<TD class= \' label\' align =\'right\' width =\'50%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</TD>\n\t\t<TD width =\'50%\'>&nbsp;<INPUT TYPE=\"checkbox\" name=\"handed_over_to_patient\" id=\"handed_over_to_patient\" size = \'10\' Maxlength=\'10\'>&nbsp</TD>\n\t</TR>\n\t<TR>\n\t\t<TD class= \' label\' align =\'right\' width =\'50%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</TD>\n\t\t<TD width =\'50%\'>&nbsp;<INPUT TYPE=\"checkbox\" name=\"print_certificate\" id=\"print_certificate\" size = \'10\' Maxlength=\'10\'>&nbsp</TD>\n\t</TR>\t\n\t<TR>\n\t\t<TD class= \' label\' colspan=\'2\'>&nbsp;</TD>\n\t\t\n\t</TR>\t\n\t<TR>\n\t\t<TD class= \' label\' colspan=\'2\'>&nbsp;</TD>\n\t\t\n\t</TR>\t\t\n</TABLE>\n<br>\n\n<TABLE align=\'center\'>\n\t<TR>\n\t\t<TD align =\'right\' ><INPUT TYPE=\"button\" class=\"button\" name=\"OK\" id=\"OK\" value = \'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' onClick=\'apply()\'></TD>\n\t\t<TD align =\'left\' ><INPUT TYPE=\"button\" class=\"button\" name=\"Cancel\" id=\"Cancel\" value = \'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' onClick=\'window.close()\'></TD>\n</TR>\t\n</TABLE>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<input type =\'hidden\' name =\'dischdate\' value =\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type =\'hidden\' name =\'currdate\' value =\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type =\'hidden\' name =\'medicalteam\' value =\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type =\'hidden\' name =\'facilityId\' value =\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	request.setCharacterEncoding("UTF-8");
	Connection con 	= null;
	Statement stmt1 = null;
	ResultSet rs 	= null;
	String dischdate 	="";
	String medicalteam 	="";
	String sdate 	= "";
	String facilityId		= (String)session.getAttribute("facility_id");

            _bw.write(_wl_block10Bytes, _wl_block10);

	try{
		con = ConnectionManager.getConnection(request);
		dischdate = request.getParameter("dischdate");
		if(dischdate == null) dischdate ="";
		medicalteam = request.getParameter("medicalteam");
		if(medicalteam == null) medicalteam ="";		
		String sql="select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from dual";	
		stmt1= con.createStatement();
		rs=stmt1.executeQuery(sql);
		if(rs.next())
		{
			sdate= rs.getString("sdate");			
			if(sdate == null) sdate ="";
 			if(rs!=null)	rs.close();
			if(stmt1!= null)stmt1.close();		
		}	

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block17Bytes, _wl_block17);


}catch(Exception e){out.println("err"+e);}
finally
{
 	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dischdate));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(sdate));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(medicalteam));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block22Bytes, _wl_block22);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MedicalCertificate.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.FitForDutyon.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.IssuingPractitioner.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.HandedovertoPatient.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PrintCertificate.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
