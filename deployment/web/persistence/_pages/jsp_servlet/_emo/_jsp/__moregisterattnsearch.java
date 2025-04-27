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

public final class __moregisterattnsearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MORegisterAttnSearch.jsp", 1742812937387L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<PRE></PRE>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n      <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n  <script language=\'javascript\' src=\'../../eMO/js/MORegisterAttn.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t <body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\"\t onLoad=\"setFocus();clearing()\">\n\t <form name=\"ae_patient_form\" id=\"ae_patient_form\">\n\t  \t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>\n\t\t\t\talert(getMessage(\"PARAMETER_TO_BE_SETUP\",\"MO\"))\n\t\t\t\tparent.parent.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t    </script>\n\t\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<script>\n\t\t\t\talert(getMessage(\"REGN_NO_CTRL_TO_BE_SETUP\",\"MO\"))\n\t\t\t   \thistory.go(-1);\n\t\t\t    </script>\n\t\t\t ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\t\t\t\n\t      <tr>\n\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n            <td class=\'fields\' width=\'25%\' >\n\t\t   ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<input type=\'text\' name=\'BURIAL_PERMIT_NO\' id=\'BURIAL_PERMIT_NO\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" disabled maxLength=\'16\' size=\'20\' onKeyPress=\"return CheckForSpecChars(event)\" ><input type=\"button\" name=\"burialno_search\" id=\"burialno_search\" disabled class=BUTTON value=\"?\" onClick=\"callpatientsearch(this,\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',BURIAL_PERMIT_NO)\" ></td>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"  disabled maxLength=\'16\' size=\'20\' onKeyPress=\"return CheckForSpecChars(event)\"  onBlur=\"searchPatient(this,\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');ChangeCase(this)\"><input type=\"button\" name=\"burialno_search\" id=\"burialno_search\" disabled class=BUTTON value=\"?\" onClick=\"callpatientsearch(this,\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\n\t\t    <td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n  \t\t    <td class=\'fields\' width=\'30%\' ><input type=\'text\' name=\'patient_id\' id=\'patient_id\'  value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" maxLength=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' size=\'20\' onKeyPress=\"return CheckForSpecChars(event)\"   onBlur=\"searchPatient(this,\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\');ChangeCase(this)\" ><input type=\"button\" name=\"patient_search\" id=\"patient_search\" class=BUTTON value=\"?\" onClick=\"callpatientsearch(this,\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',patient_id)\" ><img name=\'mandatory\' src=\'../../eCommon/images/mandatory.gif\'></img></td> \t\n\t\t\n\t    </tr>\t\n   \t   </table> \n       ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="  \n\t<input type=hidden name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t<input type=hidden name=\'menudis\' id=\'menudis\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'> \n\t\t\t<input type=hidden name=\'error\' id=\'error\' value=\'\'> \n\t<input type=hidden name=\'external\' id=\'external\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"> \n\t<input type=hidden name=\'register_no\' id=\'register_no\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"> <!--Added for this CRF Bru-HIMS-CRF-407 [IN:045167] -->\n\t</form>\n\t </body>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</html>\n\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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


        Connection con               = null;
    	PreparedStatement pstmt		 = null;
        ResultSet rset               = null ;
        String  disabledyn="";
		
		con                  = ConnectionManager.getConnection(request);
		
		String patient_id_length	 = "";
		String facilityId			 = (String)session.getValue("facility_id");
        String patientID=request.getParameter("patientID")==null?"":request.getParameter("patientID"); 
		String mode=request.getParameter("mode")==null?"":request.getParameter("mode"); 		
	    String menudis=request.getParameter("menudis")==null?"":request.getParameter("menudis"); 
		String external=request.getParameter("external")==null?"N":request.getParameter("external"); 
		String register_no=request.getParameter("register_no")==null ?"":request.getParameter("register_no"); //Added for this CRF Bru-HIMS-CRF-407 [IN:045167]
	    String burial_permit_no="";
		 if(mode.equals("modify")||menudis.equals("Y")||mode.equals("viewdata"))
		 {
		    pstmt = con.prepareStatement("select BURIAL_PERMIT_NO from MO_mortuary_regn where facility_id='"+facilityId+"' and patient_id='"+patientID+"'");
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
				burial_permit_no = rset.getString("BURIAL_PERMIT_NO")==null?"":rset.getString("BURIAL_PERMIT_NO");
				
			}
		  
		   if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();		 
			 
			 disabledyn="readOnly";
          //disablebtn="disabled";
		 }
		int flag=0;
		int flag1=0;
		try{
             
			   
				    String patLength = "select PATIENT_ID_LENGTH, to_char(sysdate,'dd/mm/yyyy') from MP_PARAM";
					pstmt   = con.prepareStatement(patLength);
					rset = pstmt.executeQuery();
					if(rset!=null)
			         {
						while(rset!=null && rset.next())
				    	{   
						patient_id_length = rset.getString(1);
						
					    } 
					 }
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
                

            _bw.write(_wl_block8Bytes, _wl_block8);

            pstmt = con.prepareStatement("select count(*) from MO_Parameter where facility_id='"+facilityId+"'");
			rset = pstmt.executeQuery();
			if(rset!=null)
		   {
			while(rset.next())
			{
				flag1 = rset.getInt(1);
				
			}
		   }
		   if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();	
			if(flag1==0)
			{
			
            _bw.write(_wl_block9Bytes, _wl_block9);
}

             pstmt = con.prepareStatement("select count(*) from MO_REGN_NUM_CONTROL where facility_id='"+facilityId+"'");
			rset = pstmt.executeQuery();
			if(rset!=null)
		   {
				while(rset.next())
				{
					flag = rset.getInt(1);
				}
		   }if(rset!=null) rset.close();
			
			if(flag==0)
			{
			
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
	
				if(mode.equals("modify")||mode.equals("viewdata"))
				{
		   
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(burial_permit_no));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block15Bytes, _wl_block15);

				}
				else
				{
		   
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(burial_permit_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patientID));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disabledyn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(menudis));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(external));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(register_no));
            _bw.write(_wl_block29Bytes, _wl_block29);

        if(pstmt!=null)  pstmt.close();
		if(rset!=null)  rset.close(); 
	 }
    catch(Exception e)
    {
        out.print(e.toString());
    }
    finally
    {
        
	    ConnectionManager.returnConnection(con,request);
    }

            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermitNo.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.DeceasedPatientID.label", java.lang.String .class,"key"));
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
}
