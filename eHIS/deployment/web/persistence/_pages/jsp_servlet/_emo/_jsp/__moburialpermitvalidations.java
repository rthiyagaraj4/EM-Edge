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

public final class __moburialpermitvalidations extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MOBurialPermitValidations.jsp", 1709118403994L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n      <script> \n\t     parent.frames[1].document.forms[0].patient_id.value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' ;\n         parent.patientLine.location.href=\'../../eCommon/jsp/pline.jsp?Patient_ID=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n         parent.result.location.href = \'../../eMO/jsp/MOBurialPermitSearch.jsp?param=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&mode=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t     parent.frames[4].location.href=\'../../eCommon/jsp/error.jsp?err_value=0\';\n     </script>\n     ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t \n\t\t\t  <script>\n                 parent.result.document.forms[0].burial_permit_no.value=\'\';\n\t\t\t     parent.result.document.forms[0].burial_permit_no.focus();\n\t\t\t </script>\n\t\t\t  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t <script>\n\t  parent.frames[4].location.href=\'../../eCommon/jsp/error.jsp?err_value=0\';\n\t  </script>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<script>\n\tparent.frames[1].document.forms[0].patient_id.value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' ;\n    parent.patientLine.location.href=\'../../eCommon/jsp/pline.jsp?Patient_ID=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n    parent.result.location.href = \'../../eMO/jsp/MOBurialPermitSearch.jsp?param=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\n\tparent.frames[4].location.href=\'../../eCommon/jsp/error.jsp?err_value=0\';\n</script>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<script>\n\tparent.frames[1].document.forms[0].patient_id.value=\'\';\n    parent.patientLine.location.href=\'../../eCommon/html/blank.html\';\n    parent.result.location.href=\'../../eCommon/html/blank.html\';\n    parent.frames[4].location.href=\'../../eCommon/jsp/error.jsp?err_value=0\';\n</script>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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

	Connection con               = null;
	java.sql.Statement stat      = null;
	ResultSet rs                 = null;

	int count1                   = 0;
	int count                    = 0;
	int countReg                 = 0;
	int countFlag                = 0;
	int countFlag1               = 0;
	int countFlag11              = 0;
	int countReg1                = 0;
	char alert_yn				 = 'Y';
    String beginHtml			 = "<html><script>";
	String endHtml			     = "</script></html>";
try
{

   	request.setCharacterEncoding("UTF-8");
	String patient_id     = request.getParameter("patient_id");
	String burial_permit_no     = request.getParameter("burial_permit_no");
	if(burial_permit_no==null || burial_permit_no.equals("null"))burial_permit_no = "";
	String mode     = request.getParameter("mode");
	if(mode==null || mode.equals("null"))mode = "";
	String BurialFlag     = request.getParameter("BurialFlag");
	if(BurialFlag==null || BurialFlag.equals("null"))BurialFlag = "";
	String	facility_id   = (String) session.getValue( "facility_id" ) ;
    con                   = ConnectionManager.getConnection(request);
    if(patient_id==null || patient_id.equals("null"))patient_id = "";
    if(mode.equals("query") ){
      
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block10Bytes, _wl_block10);

	}else{

	if(BurialFlag.equals("Y") ){
		  if(!burial_permit_no.equals("")){
		  
        stat=con.createStatement();
		
		rs=stat.executeQuery("select count(*) from  mo_mortuary_regn where facility_id='"+facility_id+"' and burial_permit_no='"+burial_permit_no+"'");
		if(rs!=null)
		{
			while(rs.next())
			{
			 countFlag=rs.getInt(1);
			}
		 }
		 if(rs!=null) rs.close();
		 if(stat!=null) stat.close();
		 stat=con.createStatement();
		 rs=stat.executeQuery("select count(*) from  mo_burial_permit where burial_permit_no='"+burial_permit_no+"'  and facility_id='"+facility_id+"'");
		 if(rs!=null)
		 {
			while(rs.next())
			{
			 countFlag11=rs.getInt(1);
			}
		 }
		 if(rs!=null) rs.close();
		 if(stat!=null) stat.close();
		 }
		
		if(!patient_id.equals("")){
		
		stat=con.createStatement();
		rs=stat.executeQuery("select count(*) from  mo_burial_permit where patient_id='"+patient_id+"'  and facility_id='"+facility_id+"'");
		if(rs!=null)
		{
			while(rs.next())
			{
			 countFlag1=rs.getInt(1);
			}
		 }
		 if(rs!=null) rs.close();
		 if(stat!=null) stat.close();
		 
		}
        if(countFlag > 0 || countFlag1 > 0 || countFlag11 > 0)
			{
			  out.println(beginHtml+"parent.result.document.forms[0].burial_permit_no.value='';alert(getMessage('BURIAL_PERMIT_NO_EXISTS','MO'))"+endHtml);
			  out.println(beginHtml+"parent.frames[1].document.forms[0].patient_id.disabled=false;"+endHtml);

			 
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
            _bw.write(_wl_block12Bytes, _wl_block12);

	}
	else{
	webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
	patdata.setFacility_id(facility_id);
	String patientIdStatus = patdata.CheckStatus(con,patient_id);
	
    if (patientIdStatus.equals("INVALID_PATIENT")) 
	{
		out.println(beginHtml+"alert(getMessage('INVALID_PATIENT','MP'))"+endHtml);
		out.println(beginHtml+"parent.frames[1].document.forms[0].patient_id.disabled=false;"+endHtml);
		alert_yn = 'N';
	}
     else
     {
		stat=con.createStatement();
		rs=stat.executeQuery("select count(*) from mp_patient where patient_id='"+patient_id+"' and deceased_yn='Y'");
		if(rs!=null)
		{
			while(rs.next())
			{
			 count1=rs.getInt(1);
			}
		 }
		 if(rs!=null) rs.close();
          if(stat!=null) stat.close(); 
		if(count1==0)
			{
			 out.println(beginHtml+"alert(getMessage('PATIENT_IS_NOT_DECEASED','MO'))"+endHtml);
			out.println(beginHtml+"parent.frames[1].document.forms[0].patient_id.disabled=false;"+endHtml);
			 alert_yn = 'N';
			}
		if(count1>0){
	
		   stat=con.createStatement();
		   rs=stat.executeQuery("select count(*) from  mo_burial_permit where patient_id='"+patient_id+"'");

			while(rs.next())
			{
			count=rs.getInt(1);
			}
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
			if(count>0)
			{
				 out.println(beginHtml+"alert(getMessage('BURIAL_PERMIT_NO_EXISTS','MO'))"+endHtml);
                out.println(beginHtml+"parent.frames[1].document.forms[0].patient_id.disabled=false;"+endHtml);
				 alert_yn = 'N';
	        
			}
          if(count==0)
          {
	       stat=con.createStatement();
		   rs=stat.executeQuery("select count(*) from MO_MORTUARY_REGN where patient_id='"+patient_id+"' and facility_id='"+facility_id+"'");

			while(rs.next())
			{
			countReg=rs.getInt(1);
			}
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
            if(countReg>0)
			{
			out.println(beginHtml+"alert(getMessage('PATIENT_ALREADY_REGISTERED','MO'))"+endHtml);
			out.println(beginHtml+"parent.frames[1].document.forms[0].patient_id.disabled=false;"+endHtml);
			alert_yn = 'N';
		    }
          }
    }//end of count1>0
    if(!patient_id.equals("") && (count==0)){
	      stat=con.createStatement();
		  rs=stat.executeQuery("select count(*) from mo_encounter_dtls_vw where  patient_id='"+patient_id+"'  and facility_id='"+facility_id+"'");

		    while(rs.next())
			{
			countReg1=rs.getInt(1);
			}
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
            if(countReg1==0)
			{
			out.println(beginHtml+"alert(getMessage('REGN_NOT_ALLOWED','MO'))"+endHtml);
			out.println(beginHtml+"parent.frames[1].document.forms[0].patient_id.disabled=false;"+endHtml);
			alert_yn = 'N';
		  
			}
	}
	if(!patient_id.equals("") && (count==0)){
	      stat=con.createStatement();
		  rs=stat.executeQuery("select count(*) from mo_encounter_dtls_vw where  patient_id='"+patient_id+"'  and facility_id='"+facility_id+"' and  MLC_YN='N' and regn_allowed_in_mo_yn='Y' and patient_id not in (select NVL(patient_id,'*') from mo_mortuary_regn) and patient_id not in (select patient_id  from mo_burial_permit) ");

		    while(rs.next())
			{
			countReg1=rs.getInt(1);
			}
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
            if(countReg1==0)
			{
			out.println(beginHtml+"alert(getMessage('BURIAL_PERMIT_NOT_ALLOWED','MO'))"+endHtml);
			out.println(beginHtml+"parent.frames[1].document.forms[0].patient_id.disabled=false;"+endHtml);
			alert_yn = 'N';
		    }
   }
}//end of else
if(!(alert_yn=='N'))
{
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{
            _bw.write(_wl_block17Bytes, _wl_block17);
}
    if(stat!=null) stat.close();
	if(rs!=null) rs.close();
	}
  }
}
catch(Exception e)
{
  out.println("Exception in File MOBurialPermitValidations"+e.toString());
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
