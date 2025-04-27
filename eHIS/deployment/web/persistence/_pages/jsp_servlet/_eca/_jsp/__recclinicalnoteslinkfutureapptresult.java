package jsp_servlet._eca._jsp;

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
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnoteslinkfutureapptresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkFutureApptResult.jsp", 1709116150669L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title></title>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCA/js/RecClinicalNotesLinkFutureEvent.js\"></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body onScroll=\"scrollTitle()\" onKeyDown=\"lockKey()\">\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\n\n<form name=\"RecClinicalNotesLinkFutureApptResultForm\" id=\"RecClinicalNotesLinkFutureApptResultForm\">\t\n<div id=\'divDataTitle\' style=\'postion:relative\'>\n<table border=\"1\" id=\"finalDiv\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n<tr >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n</td>\n</tr>\n</table>\n\n<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"  name=\"resultTable\" id=\"resultTable\" id=\"resultTable\" align=\'center\'>\n<tr>\n<td class=\'columnheader\' style=\"font-size:10\"  colspan=4>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<input type=\'checkbox\' name=\'ctrlChkBox\' id=\'ctrlChkBox\' onClick=\"javascript:perform(this);\" ></td>\n</tr>\n</table>\n</div>\n<table class=\"grid\" width=\"100%\"  name=\"resultTable2\" id=\"resultTable2\" id=\"resultTable2\" align=\'center\'>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n                ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n\t\t\t\t\t<tr>\t\t\t\t\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"><input type=\"checkbox\" name=\"chkbox";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" id=\"chkbox";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" onClick=\"Reassaign(this);chkunchk(this)\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">\n\t\t\t\t\t\t<input type=\'hidden\' name=\'chk_value";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' id=\'chk_value";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"></td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'ret_value";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'ret_value";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="~";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="|";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"  >\n\t\t\t\t\t\t\t<font size=2><b>Appointment Ref.no : </b></font>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" ><font size=2><b>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" : </b></font>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"><font size=2><b>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="<font size=2><b> ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" </b></font>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</tr><tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"  ><font size=2><b>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" colspan=3><font size=2><b>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"  colspan=4><font size=2><b>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t<tr>\t\t\t\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="><font size=2><b>Appointment Ref.no : </b></font>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="<input type=\'hidden\' name=\'chk_value";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"></td>\n\t\t\t\t\t<input type=\'hidden\' name=\'ret_value";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'> \n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t\t\t\t<td></td>\n\t\t\t\t</tr>\n\t\t\t\t <tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t</tr> \n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t<script>document.forms[0].ctrlChkBox.checked = true</script> \n\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n        <script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));</script>\n\t\t<script>document.forms[0].ctrlChkBox.disabled = true</script> \n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t<input type=\"hidden\" name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t\n\t\t\t\n</table>\n\n</form>\n</body>\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet EventBean= null;synchronized(session){
                EventBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("EventBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(EventBean==null){
                    EventBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("EventBean",EventBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p1.getProperty("LOCALE");
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			
	/*String from_date_time	=	request.getParameter("from_date_time")==null?"1/1/1900":request.getParameter("from_date_time");
	
	String to_date_time=request.getParameter("to_date_time")==null?"1/1/4000":request.getParameter("to_date_time");*/
  
    String apptdate="";
    String apptrefno="";

 	StringBuffer strsql1 = new StringBuffer(" ");
 	StringBuffer where = new StringBuffer(" ");
    
	String facility_id = (String) session.getValue("facility_id") ;
	String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	//out.println("<script>alert('patient_id"+patient_id+"')</script>");
	
    String link=request.getParameter("link")==null?"":request.getParameter("link");
	String val=request.getParameter("val")==null?"":request.getParameter("val");
	String order=request.getParameter("order")==null?"":request.getParameter("order");
	String nature=request.getParameter("nature")==null?"":request.getParameter("nature");
	if(link.equals("Dat"))
    apptdate=request.getParameter("val")==null?"":request.getParameter("val");
	else if(link.equals("Refno"))
    apptrefno=request.getParameter("val")==null?"":request.getParameter("val");

	
	String from 			= 
	request.getParameter("from");
	//out.println("<script>alert('from"+from+"')</script>");
	String to 	= 
	request.getParameter("to");
	//out.println("<script>alert('to"+to+"')</script>");
	String whereclause= request.getParameter("whereclause")==null?"":request.getParameter("whereclause");

	//String pract_id=(String)session.getValue("ca_practitioner_id");
	//out.println("<script>alert('pract_id"+pract_id+"')</script>");
	
	String rowid="";
	String apptreferno=""; 
	String apptdat="";  
	String fromtime="";  
	String totime= "";   
	String locdesc= "";  
	String visitdesc= "";
	String resname= "";  
	String reason= "";   
	String remarks= "";  
	
	String practionerid= "";  


	String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
	ArrayList  fields			=	new ArrayList();
	String categ_sec_qry ="";
	String field_ref ="";
//	String col_field ="";
	//String col_val ="";
//	int col_span=0;

	PreparedStatement pstmt=null;
	ResultSet rset=null;

	

		
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	int start = 0 ;
	int end = 0 ;
	int i=1;
	int k=0;
	int maxRecord =0;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

   	try
	{
       con =  ConnectionManager.getConnection(request);
      practionerid   = (String) session.getValue("ca_practitioner_id"); 
	  
	  
	  //shaiju new diag starts
	  
	   categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY='APPT' order by ORDER_SEQ_NUM";

		pstmt = con.prepareStatement(categ_sec_qry);
		
		pstmt.setString(1,sec_hdg_code);
		pstmt.setString(2,result_linked_rec_type);
		//pstmt.setString(3,result_linked_rec_type);

		rset = pstmt.executeQuery();

		if(rset.next())
		{
			do
			{
				field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
				fields.add(field_ref);
			}
			while(rset.next());

		}
		else
		{
			 if (rset != null) rset.close();
			 if (pstmt != null) pstmt.close();

			categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY='APPT' order by ORDER_SEQ_NUM";

			pstmt = con.prepareStatement(categ_sec_qry);
			pstmt.setString(1,result_linked_rec_type);
			//pstmt.setString(2,result_linked_rec_type);

			rset = pstmt.executeQuery();

			if(rset.next())
			{
				do
				{
					field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
					fields.add(field_ref);
				}
				while(rset.next());

				if (rset != null) rset.close();
				if(pstmt != null) pstmt.close();

			}
		

		}

			  
	  //shaiju new diag ends
	  
	  
	  /* strsql1.append("select rowid row_id,APPT_REF_NO , TO_CHAR(APPT_DATE,'DD/MM/YYYY') APPT_DATE_STR , TO_CHAR(APPT_SLAB_FROM_TIME,'HH24:MI') FROM_TIME_STR , TO_CHAR(APPT_SLAB_TO_TIME ,'HH24:MI')  TO_TIME_STR , replace(CLINIC_SHORT_DESC,'''','') LOCATION_DESC , replace(VISIT_TYPE_SHORT_DESC,'''','') VISIT_TYPE_SHORT_DESC  , nvl2(    PRACTITIONER_SHORT_NAME,DECODE(RESOURCE_CLASS,'P','Practitioner','R','Room')||'/',null)||Replace(PRACTITIONER_SHORT_NAME,'''','') resource_name  ,replace(CONTACT_REASON,'''','') CONTACT_REASON ,replace(APPT_REMARKS,'''','') APPT_REMARKS from oa_appt_vw where  FACILITY_ID= ? AND PATIENT_ID=?");

	    if ( (whereclause == null || whereclause.equals("")) )
	     {
        
		if (link.equals("Dat"))
		where.append(" AND  APPT_DATE between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') +.9999 ");

		if (link.equals("Refno"))
		where.append(" and APPT_REF_NO=?");
		
	    //out.println("<script>alert('ord_status"+ord_status+"')</script>");
	    //out.println("<script>alert('strsql1"')</script>");
	    if((nature.equals("S")))
		{
        where.append(" and PRACTITIONER_ID = ?");
		}

		if(order.equals("D"))
		where.append(" ORDER BY APPT_DATE, APPT_SLAB_FROM_TIME desc ");
		else
        where.append(" ORDER BY APPT_DATE, APPT_SLAB_FROM_TIME "); 
	
	   
	    strsql1.append(where.toString()); */
//
		//strsql1.append("select rowid row_id,APPT_REF_NO , TO_CHAR(sm_convert_date(APPT_DATE,'"+localeName+"'),'DD/MM/YYYY') APPT_DATE_STR ,TO_CHAR(APPT_SLAB_FROM_TIME,'HH24:MI') FROM_TIME_STR , TO_CHAR(APPT_SLAB_TO_TIME ,'HH24:MI')  TO_TIME_STR , replace((CASE WHEN a.clinic_code IS NOT NULL THEN OP_GET_DESC.OP_CLINIC(a.facility_id,a.clinic_code,?,'1') END),'''','') LOCATION_DESC , replace((CASE WHEN a.appt_type_code IS NOT NULL THEN OP_GET_DESC.OP_VISIT_TYPE(A.FACILITY_ID,A.APPT_TYPE_CODE,?,'1') END ),'''','') VISIT_TYPE_SHORT_DESC, nvl2((CASE WHEN (a.resource_class = 'P' AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'2')  WHEN (a.resource_class = 'R' AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID,A.PRACTITIONER_ID,?,'2') WHEN (( a.resource_class = 'E' OR a.resource_class = 'O' ) AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID,A.PRACTITIONER_ID,?,'2') END ) , RESOURCE_CLASS ||'/',null)||Replace((CASE WHEN (a.resource_class = 'P' AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'2') WHEN (a.resource_class = 'R' AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID,A.PRACTITIONER_ID,?,'2') WHEN (( a.resource_class = 'E' OR a.resource_class = 'O' ) AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID,A.PRACTITIONER_ID,?,'2')END) ,'''','') resource_name  ,replace(CONTACT_REASON,'''','') CONTACT_REASON ,replace(APPT_REMARKS,'''','') APPT_REMARKS from oa_appt_vw A where  FACILITY_ID= ? AND PATIENT_ID=?");//common-icn-0180
	    strsql1.append("select rowid row_id,APPT_REF_NO , TO_CHAR(sm_convert_date(APPT_DATE,?),'DD/MM/YYYY') APPT_DATE_STR ,TO_CHAR(APPT_SLAB_FROM_TIME,'HH24:MI') FROM_TIME_STR , TO_CHAR(APPT_SLAB_TO_TIME ,'HH24:MI')  TO_TIME_STR , replace((CASE WHEN a.clinic_code IS NOT NULL THEN OP_GET_DESC.OP_CLINIC(a.facility_id,a.clinic_code,?,'1') END),'''','') LOCATION_DESC , replace((CASE WHEN a.appt_type_code IS NOT NULL THEN OP_GET_DESC.OP_VISIT_TYPE(A.FACILITY_ID,A.APPT_TYPE_CODE,?,'1') END ),'''','') VISIT_TYPE_SHORT_DESC, nvl2((CASE WHEN (a.resource_class = 'P' AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'2')  WHEN (a.resource_class = 'R' AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID,A.PRACTITIONER_ID,?,'2') WHEN (( a.resource_class = 'E' OR a.resource_class = 'O' ) AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID,A.PRACTITIONER_ID,?,'2') END ) , RESOURCE_CLASS ||'/',null)||Replace((CASE WHEN (a.resource_class = 'P' AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'2') WHEN (a.resource_class = 'R' AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID,A.PRACTITIONER_ID,?,'2') WHEN (( a.resource_class = 'E' OR a.resource_class = 'O' ) AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID,A.PRACTITIONER_ID,?,'2')END) ,'''','') resource_name  ,replace(CONTACT_REASON,'''','') CONTACT_REASON ,replace(APPT_REMARKS,'''','') APPT_REMARKS from oa_appt_vw A where  FACILITY_ID= ? AND PATIENT_ID=?");//common-icn-0180

	    if ( (whereclause == null || whereclause.equals("")) )
	     {
        
		if (link.equals("Dat"))
		where.append(" AND  APPT_DATE between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') +.9999 ");

		if (link.equals("Refno"))
		where.append(" and APPT_REF_NO=?");
		
	    //out.println("<script>alert('ord_status"+ord_status+"')</script>");
	    //out.println("<script>alert('strsql1"')</script>");
	    if((nature.equals("S")))
		{
        where.append(" and PRACTITIONER_ID = ?");
		}

		if(order.equals("D"))
		where.append(" ORDER BY APPT_DATE, APPT_SLAB_FROM_TIME desc ");
		else
        where.append(" ORDER BY APPT_DATE, APPT_SLAB_FROM_TIME "); 
	
	   
	    strsql1.append(where.toString());	
//


	    }
	    else
	    {
		strsql1.append(whereclause);

	    }
		stmt = con.prepareStatement(strsql1.toString());
		int st=0;

		stmt.setString(++st,localeName);//common-icn-0180
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
        stmt.setString(++st,facility_id);
		stmt.setString(++st,patient_id);
		
		if(link.equals("Dat"))
		{
		stmt.setString(++st,apptdate);
		stmt.setString(++st,apptdate);
		}
        else if(link.equals("Refno"))
        stmt.setString(++st,apptrefno);

		 if((nature.equals("S")))
		{
        stmt.setString(++st,practionerid);
		}
	  
		
    	rs = stmt.executeQuery();
	    
	 
            _bw.write(_wl_block8Bytes, _wl_block8);

if ( !(start <= 1) )
		{
out.println("<td width='85%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td width='10%' >");
out.println("<A HREF='../../eCA/jsp/RecClinicalNotesLinkFutureApptResult.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&val="+val+"&link="+link+"&patient_id="+patient_id+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		}
		else
		{
out.println("<td width='100%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td width='10%' >");
		}

//out.println("<script>alert('start"+start+"')</script>");

  if ( !( (start+14) > maxRecord ) )
		{
	out.println("<A HREF='../../eCA/jsp/RecClinicalNotesLinkFutureApptResult.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&val="+val+"&link="+link+"&patient_id="+patient_id+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		}
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
 
	//out.println("<script>alert('start"+start+"')</script>");
	//out.println("<script>alert('end"+end+"')</script>");
	//out.println("<script>alert('i="+i+"')</script>");
      if ( start != 1 )
		{
		    for( int j=1; j<start; i++,j++ )
	           {
	             rs.next() ;
	           }
		}
		//out.println("<script>alert('end"+end+"')</script>");
	//out.println("<script>alert('i="+i+"')</script>");
	//out.println("<script>alert('rs.next()="+rs.next()+"')</script>");

		String classValue="";
		String classValue1="";
		int p=0; 
	 while(rs!=null && rs.next() && i<=end)
		{
		
		 rowid=rs.getString("row_id")==null?" ":rs.getString("row_id");		 
		 apptreferno=rs.getString("APPT_REF_NO")==null?" ":rs.getString("APPT_REF_NO");
		 apptdat=rs.getString("APPT_DATE_STR")==null?" ":rs.getString("APPT_DATE_STR");
		 fromtime=rs.getString("FROM_TIME_STR")==null?" ":rs.getString("FROM_TIME_STR");
		 totime=rs.getString("TO_TIME_STR")==null?" ":rs.getString("TO_TIME_STR");
		 locdesc=rs.getString("LOCATION_DESC")==null?" ":rs.getString("LOCATION_DESC");
		 visitdesc=rs.getString("VISIT_TYPE_SHORT_DESC")==null?" ":rs.getString("VISIT_TYPE_SHORT_DESC");
		 resname=rs.getString("resource_name")==null?" ":rs.getString("resource_name");
		 reason=rs.getString("CONTACT_REASON")==null?" ":rs.getString("CONTACT_REASON");
		 remarks=rs.getString("APPT_REMARKS")==null?" ":rs.getString("APPT_REMARKS");
		
		 	 
		 if ( i % 2 == 0 ){
		 classValue = "CAGROUP" ;
		 classValue1 = "gridData" ;
		 }else{
		 classValue = "CAGROUP" ;
		 classValue1 = "gridData" ;
		 }
	    
		 String beankey="";		
	 	 String checkstatus="";		
         
		for(int m=0;m<EventBean.getSize();m+=2)
				{
					beankey=EventBean.getObject(m).toString();
					
  					if(rowid.equalsIgnoreCase(beankey))
					{
					checkstatus="checked";
                    p++; 
					break;
					}
					
                   

				}
				
			
            _bw.write(_wl_block11Bytes, _wl_block11);

					if(fields.size()>0)
					{
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(k));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(k));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(k));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(checkstatus));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(k));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(k));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(apptreferno));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(apptdat));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(fromtime));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(totime));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(locdesc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(visitdesc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(resname));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block25Bytes, _wl_block25);

						if(fields.contains("APPTREFNO"))
						{
						
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(apptreferno));
            _bw.write(_wl_block28Bytes, _wl_block28);

						}
						if(fields.contains("DATE"))
						{
						
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(apptdat));
            _bw.write(_wl_block28Bytes, _wl_block28);

						}
						if(fields.contains("TIME"))
						{
						
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(fromtime));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(totime));
            _bw.write(_wl_block28Bytes, _wl_block28);

						}
						
            _bw.write(_wl_block34Bytes, _wl_block34);

						if(fields.contains("LOCATION"))
						{
						
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(locdesc));
            _bw.write(_wl_block28Bytes, _wl_block28);

						}
						if(fields.contains("VISITTYPE"))
						{
						
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(visitdesc));
            _bw.write(_wl_block28Bytes, _wl_block28);

						}
						
            _bw.write(_wl_block37Bytes, _wl_block37);

						if(fields.contains("RESOURCE"))
						{
						
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(resname));
            _bw.write(_wl_block40Bytes, _wl_block40);

						}
						if(fields.contains("CONTACTREASON"))
						{
						
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block40Bytes, _wl_block40);

						}
						if(fields.contains("REMARKS"))
						{
						
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block40Bytes, _wl_block40);

						}
										
					}
					else
					{

				
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(k));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(k));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(k));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(checkstatus));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(apptreferno));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(k));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(k));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(k));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(k));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(apptreferno));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(apptdat));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(fromtime));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(totime));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(locdesc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(visitdesc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(resname));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(apptdat));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(fromtime));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(totime));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(locdesc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(visitdesc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(resname));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block50Bytes, _wl_block50);

				}
				i++;
				k++;
		}
		 if((p+1) == i || p == 14)
					{
					
            _bw.write(_wl_block51Bytes, _wl_block51);
}
		if(i == 1)
		{
   		
            _bw.write(_wl_block52Bytes, _wl_block52);
}
				
	if(rs!=null) rs.close();
	if(stmt!=null)stmt.close();		 	
	
	

}
			
			
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception cauight in RecClinicalNotesLinkFutureEventResult.jsp" + e);//COMMON-ICN-0181
}
finally 
{
	
	ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(k));
            _bw.write(_wl_block55Bytes, _wl_block55);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactReason.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactReason.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }
}
