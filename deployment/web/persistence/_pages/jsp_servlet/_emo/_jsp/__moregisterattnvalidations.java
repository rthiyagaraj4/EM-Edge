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
import org.json.simple.*;
import java.util.*;
import com.ehis.util.*;

public final class __moregisterattnvalidations extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MORegisterAttnValidations.jsp", 1726636256565L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<script>alert(getMessage(\'INVALID_PATIENT\',\'MP\'));parent.frames[1].document.forms[0].patientid.value=\"\";parent.frames[1].document.forms[0].patbtn.disabled=false;\nparent.frames[1].document.forms[0].patientid.disabled=false;</script>\n\t  \n\t  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n <script> parent.frames[3].document.location.href = \'../../eMO/jsp/MORegisterBodyPartResult.jsp?function_id=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&patientid=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&obt_from=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'\n parent.frames[2].location.href = \"../../eCommon/jsp/pline.jsp?Patient_ID=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" ;  \t\n </script>\n\t\n\t\t  \n\t\t  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<script>alert(getMessage(\'INVALID_PATIENT\',\'MP\'));parent.frames[1].document.forms[0].patientid.value=\"\";parent.frames[1].document.forms[0].patbtn.disabled=false;\nparent.frames[1].document.forms[0].patientid.disabled=false;</script>\n\t  ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<script>alert(getMessage(\'INVALID_PATIENT\',\'MP\'));parent.frames[1].document.forms[0].patientid.value=\"\";parent.frames[1].document.forms[0].patbtn.disabled=false;\nparent.frames[1].document.forms[0].patientid.disabled=false;\n</script>\n\t  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" ;  \n </script>\n\t\n\t\t  \n\t\t  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<script>parent.frames[0].document.forms[0].patient_id.value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'\n   parent.frames[0].document.forms[0].BURIAL_PERMIT_NO.disabled=true;\n\tparent.frames[0].document.forms[0].burialno_search.disabled=true;\n\t</script>\n    ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n   <script>alert(getMessage(\'BURIAL_PERMIT_NOT_EXIST\',\'MO\'));\n  parent.frames[0].document.location.href = \'../../eMO/jsp/MORegisterAttnSearch.jsp\'\n  \n  </script>\n\n\t\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<script>\n\n\t   parent.frames[0].document.forms[0].BURIAL_PERMIT_NO.value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'\n\t   parent.frames[0].document.forms[0].BURIAL_PERMIT_NO.disabled=true;\n\t   parent.frames[0].document.forms[0].burialno_search.disabled=true;\n\t   \n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t <script>\n\t\t parent.frames[0].document.forms[0].patient_id.value=\'\';\n\t\t alert(getMessage(\'INVALID_PATIENT\',\'MP\'));\n\t\t parent.frames[0].document.forms[0].patient_id.focus();</script>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<script>parent.frames[0].document.forms[0].patient_id.value=\'\';alert(getMessage(\'PATIENT_IS_NOT_DECEASED\',\'MO\'));parent.frames[0].document.forms[0].patient_id.focus();</script>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<script>\n\t\t\t\n\t\t\tparent.frames[0].document.forms[0].patient_id.value=\'\';\n\t\t\talert(getMessage(\'NOT_EXT_PAT\',\'MO\'));\t\t\t\n\t\t\ttop.content.location.href=\'../../eMO/jsp/MODeceasedDtlsFrameset.jsp?menu_id=MO_MENU&module_id=MO&function_id=MO_REGISTER_DECEASED&function_name=Deceased Registration&function_type=F&access=NNNNN&desktopFlag=N\' ;\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<script>\n\t\t\t\t\n\t\t\t\tparent.frames[0].document.forms[0].patient_id.value=\'\';\n\t\t\t\talert(getMessage(\'PATIENT_ALREADY_REGISTERED\',\'MO\'));\n\t\t\t\tparent.frames[0].document.forms[0].patient_id.focus();\n\t\t\t\t\n\t\t\t\t</script>\n\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar patient_id = \'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'\n\t\t\t\t\t//var function_id = \'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'\n\t\t\t\t\tvar function_id=parent.parent.commontoolbarFrame.document.forms[0].function_id.value;\n\t\t\t\t\tparent.frames[0].document.forms[0].patient_id.disabled=true;\n\t\t\t\t\tparent.frames[0].document.forms[0].patient_search.disabled=true;\n\t\t\t\t\tvar external = \'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'\t;\n\t\t\t\t\tparent.parent.frames[0].document.forms[0].apply.disabled=false;\n\t\t\t\t\t//self.location.href=\'../../eMO/jsp/MORegisterAttnResult.jsp?patient_id=\'+patient_id+\'&function_id=\'+function_id\n\t\t\t\t\t\n\t\t\t\t\tself.location.href=\'../../eMO/jsp/MORegisterAttnResult.jsp?patient_id=\'+patient_id+\'&function_id=\'+function_id+\'&external=\'+external;</script>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t<script>\n\t\t\n\t\tvar patient_id = \'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'\n\t\t//var function_id = \'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'\n\t\tvar function_id=parent.parent.document.forms[0].function_id.value;\n\t\tparent.frames[0].document.forms[0].patient_id.disabled=true;\n\t\tparent.frames[0].document.forms[0].patient_search.disabled=true;\n\t\tvar external = \'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'\t;\n\t\t//self.location.href=\'../../eMO/jsp/MORegisterAttnResult.jsp?patient_id=\'+patient_id+\'&function_id=\'+function_id\n\t\tparent.parent.frames[0].document.forms[0].apply.disabled=false;\n\t\tself.location.href=\'../../eMO/jsp/MORegisterAttnResult.jsp?patient_id=\'+patient_id+\'&function_id=\'+function_id+\'&external=\'+external;\n\t\t</script>\n\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<script>\n\t\t\t\tparent.frames[0].document.forms[0].patient_id.value=\'\';\n\t\t\t\talert(getMessage(\'PATIENT_ALREADY_REGISTERED\',\'MO\'));\n\t\t\t\tparent.frames[0].document.forms[0].patient_id.focus();\n\t\t\t\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<script>\t\t\n\t\t\tparent.frames[0].document.forms[0].patient_id.value=\'\';\n\t\t\talert(getMessage(\'PATIENT_ALREADY_REGISTERED\',\'MO\'));\n\t\t\tparent.frames[0].document.forms[0].patient_id.focus();\t\t\t\n\t\t</script>\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t<script>\n\t\t\tvar patient_id\t= \'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'\n\t\t\tvar calledFrom\t= \'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\';\n\t\t\tvar function_id\t= parent.parent.document.forms[0].function_id.value;\n\t\t\tparent.frames[0].document.forms[0].patient_id.disabled\t\t= true;\n\t\t\tparent.frames[0].document.forms[0].patient_search.disabled\t= true;\n\t\t\tvar external = \'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'\t;\n\t\t\tparent.parent.frames[0].document.forms[0].apply.disabled\t= false;\n\n\t\t\tself.location.href=\'../../eMO/jsp/MORegisterAttnResult.jsp?patient_id=\'+patient_id+\'&function_id=\'+function_id+\'&calledFrom=\'+calledFrom+\'&externalBidYn=Y&external=\'+external;\n\t\t</script>\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

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

	Connection con          = null;
	java.sql.Statement stat = null;
	ResultSet rs            = null;

	int dflag               = 0;
	int count               = 0;

    boolean status=false;
    
try
{
request.setCharacterEncoding("UTF-8");
String	facility_id   = (String) session.getValue( "facility_id" ) ;
 con                   = ConnectionManager.getConnection(request);
	String patient_id     =request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String objName     = request.getParameter("objName")==null?"":request.getParameter("objName");
	String function_id=request.getParameter("function_id")==null ?"":request.getParameter("function_id");	
	String external=request.getParameter("external")==null?"N":request.getParameter("external");
	/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
	String calledFrom  = "";
	JSONObject json		= new JSONObject();
	json				= eMO.MOCommonBean.chkForExtBidBodyPartPatient(con, patient_id, facility_id);
	count				= (Integer)json.get("bidCount");
	if(count == 1)
		calledFrom	= "MO_BID_REGN";
	/*End*/
	
	if(objName.equals("bodyprt"))
	{
       String obtainedfrom = request.getParameter("obtainedfrom")==null?"":request.getParameter("obtainedfrom"); 
	   
      if(obtainedfrom.equals("A"))
	  {
	   int cntdec=0;
	   stat=con.createStatement();  
	   rs=stat.executeQuery("  select count(*) cnt from mp_patient a, mp_param b where patient_id='"+patient_id+"' and deceased_yn='N' and suspend_yn='N' and active_yn='Y' ");
	   if(rs.next())
       {
	      cntdec =rs.getInt("cnt");
	    
	   }
	   if(rs!=null)rs.close();
	   if(stat!=null)stat.close();
		
	   if(cntdec==0&&(!patient_id.equals("")))
	   {
            _bw.write(_wl_block6Bytes, _wl_block6);
}else{
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(obtainedfrom));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
}

	  }else if(obtainedfrom.equals("D"))
	  { int cntdec=0;
		  stat=con.createStatement();  
	   rs=stat.executeQuery("  select count(*) cnt from mp_patient a, mp_param b where patient_id='"+patient_id+"' and sex='F' and deceased_yn='N' and suspend_yn='N' and active_yn='Y' and (sysdate-a.date_of_birth)/365 >=b.NB_MOTHER_MIN_AGE");
	   if(rs.next())
       {
	      cntdec =rs.getInt("cnt");
	    
	   }
	   if(rs!=null)rs.close();
	   if(stat!=null)stat.close();
	   if(cntdec==0&&(!patient_id.equals("")))
	   {
            _bw.write(_wl_block12Bytes, _wl_block12);
}else {
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(obtainedfrom));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
}

	  
	  
	  
	  }else if(obtainedfrom.equals("U"))
	  {
	  
	   int cntdec=0;
	   stat=con.createStatement();  
//	   rs=stat.executeQuery("select count(*) cnt from mp_patient a,mp_param b where patient_id='"+patient_id+"' and deceased_yn='Y' and a.PAT_DTLS_UNKNOWN_YN='Y' and patient_id not in (select patient_id from mo_mortuary_regn where NVL(BODY_PART_OBTAINED_FROM,'*') not in ('A','D'))");
	   rs=stat.executeQuery("select count(*) cnt from mp_patient a,mp_param b where patient_id='"+patient_id+"' and a.PAT_DTLS_UNKNOWN_YN='Y' and patient_id not in (select patient_id from mo_mortuary_regn where NVL(BODY_PART_OBTAINED_FROM,'*') not in ('A','D'))");
	   if(rs.next())
       {
	      cntdec =rs.getInt("cnt");
	    
	   }
	   if(rs!=null)rs.close();
	   if(stat!=null)stat.close();
	   if(cntdec==0&&(!patient_id.equals("")))
	   {
            _bw.write(_wl_block13Bytes, _wl_block13);
}else
		  {
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(obtainedfrom));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
	  
	  
	  
	  
	  }
		
     
		
	}else
	{
	
   

    if(patient_id==null || patient_id.equals("null")) patient_id = "";
	if(objName.equals("BURIAL_PERMIT_NO"))
{
   stat=con.createStatement();
   rs=stat.executeQuery("select BURIAL_PERMIT_NO,PATIENT_ID  from MO_BURIAL_PERMIT_VW where  facility_id='"+facility_id+"' and PATIENT_ID not in (select NVL(PATIENT_ID,'*') from mo_mortuary_regn  where NVL(BODY_PART_OBTAINED_FROM,'*') not in ('A','D')) and patient_id in (select patient_id from mo_encounter_dtls_vw where REGN_ALLOWED_IN_MO_YN='Y') and BURIAL_PERMIT_NO='"+patient_id+"' order by 2");
  
   if(rs.next())
   {
	patient_id=rs.getString("PATIENT_ID")==null?"":rs.getString("PATIENT_ID");
	   
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString("PATIENT_ID")));
            _bw.write(_wl_block16Bytes, _wl_block16);
}else
	{
            _bw.write(_wl_block17Bytes, _wl_block17);
status=true;}


}else
{ 
	if(!calledFrom.equals("MO_BID_REGN")){//Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689

	  stat=con.createStatement();
	  rs=stat.executeQuery("select BURIAL_PERMIT_NO,PATIENT_ID from MO_BURIAL_PERMIT_VW where  facility_id='"+facility_id+"' and PATIENT_ID not in (select PATIENT_ID from mo_mortuary_regn where NVL(BODY_PART_OBTAINED_FROM,'*') not in ('A','D')) and patient_id in (select patient_id from mo_encounter_dtls_vw where REGN_ALLOWED_IN_MO_YN='Y') and patient_id='"+patient_id+"'");

	  if(rs.next())
	   {
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rs.getString("BURIAL_PERMIT_NO")));
            _bw.write(_wl_block19Bytes, _wl_block19);
}
	}
}
	
	if(rs!=null) rs.close();
	if(stat!=null)stat.close();
	webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
	patdata.setFacility_id(facility_id);
	String patientIdStatus = patdata.CheckStatus(con,patient_id);
	
if(status!=true)
	{

if ( patientIdStatus.equals("INVALID_PATIENT"))
	{
	
            _bw.write(_wl_block20Bytes, _wl_block20);

	if(external.equals("Y")){					
			//out.println("<script>top.content.location.href='../../eMO/jsp/MODeceasedDtlsFrameset.jsp?menu_id=MO_MENU&module_id=MO&function_id=MO_REGISTER_DECEASED&function_name=Deceased Registration&function_type=F&access=NNNNN&desktopFlag=N' ;</script>");
	}	
	}
else
{
    stat=con.createStatement();
    rs=stat.executeQuery("select count(*) from mp_patient where patient_id='"+patient_id+"' and deceased_yn='Y'");
if(rs!=null)
{
	while(rs.next())
		{
		dflag=rs.getInt(1);
		}
}
 if(rs!=null) rs.close();
 if(stat!=null)stat.close();
 /*Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689 Start*/
 if(calledFrom.equals("MO_BID_REGN"))
	 dflag = 2;
 /*End*/
if(dflag==0)
	{
	
	
            _bw.write(_wl_block21Bytes, _wl_block21);

		
		if(external.equals("Y")){					
			//out.println("<script>top.content.location.href='../../eMO/jsp/MODeceasedDtlsFrameset.jsp?menu_id=MO_MENU&module_id=MO&function_id=MO_REGISTER_DECEASED&function_name=Deceased Registration&function_type=F&access=NNNNN&desktopFlag=N' ;</script>");
		}
	}
if(dflag==1){
	
   stat=con.createStatement();
   rs=stat.executeQuery("select count(*) from mo_encounter_dtls_vw where patient_id not in (select NVL(patient_id,'*') from mo_mortuary_regn_vw where NVL(BODY_PART_OBTAINED_FROM,'*') not in ('A','D')) and patient_id='"+patient_id+"'");
   

while(rs.next())
	{
	count=rs.getInt(1);
	}
	if(rs!=null) rs.close();
	if(stat!=null)stat.close();


	if(external.equals("Y")){
		

		 stat=con.createStatement();
		 rs=stat.executeQuery("select count(*)  from mp_patient where patient_id='"+patient_id+"' and DECEASED_DATE is not null and DECEASED_FACILITY_ID='"+facility_id+"' and DECEASED_ENCOUNTER_ID is not null");
   
		int counter=0;
		while(rs.next()){
			counter=rs.getInt(1);
		}
		if(rs!=null) rs.close();
		if(stat!=null)stat.close();
		
		if(count==1 && counter==1){
			
            _bw.write(_wl_block22Bytes, _wl_block22);

		}
			
		//if( counter==0)	{
			
			stat=con.createStatement();
			rs=stat.executeQuery("select count(*)  from MO_MORTUARY_REGN where PATIENT_ID='"+patient_id+"' and facility_id = '"+facility_id+"'");
	   
			int counter_1=0;
			while(rs.next()){
				counter_1=rs.getInt(1);
			}
			if(rs!=null) rs.close();
			if(stat!=null)stat.close();

			if(counter_1>0){
            _bw.write(_wl_block23Bytes, _wl_block23);
}else{
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(external));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
		
		//}

	
	}else{
	if(count==1)
	{
		
		
	
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(external));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
	if(count==0){
		
		
		
			
            _bw.write(_wl_block32Bytes, _wl_block32);

		
	}
}
}
/*Added by Thamizh selvi on 1st Aug 2017 for ML-MMOH-CRF-689 Start*/
if(dflag == 2){ 
	
	stat=con.createStatement();
	rs=stat.executeQuery("select count(*)  from MO_MORTUARY_REGN where PATIENT_ID='"+patient_id+"' and facility_id = '"+facility_id+"'");
	   
	int counter_1=0;
	while(rs.next()){
		counter_1=rs.getInt(1);
	}
	if(rs!=null) rs.close();
	if(stat!=null)stat.close();

	if(counter_1>0){
            _bw.write(_wl_block33Bytes, _wl_block33);
}else{
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(external));
            _bw.write(_wl_block37Bytes, _wl_block37);
}
}/*End*/
}
     if(stat!=null) stat.close();
	if(rs!=null) rs.close();
	}	}
 
}
catch(Exception e){
  out.println("Exception in File MORegisterAttnValidations"+e.toString());
  e.printStackTrace();
  }
finally
{
	ConnectionManager.returnConnection(con,request);

}

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
