package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __hmismastersresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/HMISMastersResult.jsp", 1709118928892L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\n<script src=\'../../eMR/js/HMISMaster.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\n\n</head>\n<body  onLoad=\'FocusFirstElement()\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t     <form name=\'hmis_form\' id=\'hmis_form\' action=\'../../servlet/eMR.HMISMastersServlet\' method=\'post\' target=\'messageFrame\'>\n\t\t\t\t\t <BR><BR>\n                  <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' width=\'90%\'>\n\t\t\t\t<th colspan=4 align=left><b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th> \n\t\t\t\t <tr>\n\t \t\t      <td class=label>&nbsp;</td>\n                  <td>&nbsp;<td>\n\t\t\t\t </tr>\n\t\t\t\t <tr>\n\t \t\t      <td class=label>&nbsp;</td>\n                  <td>&nbsp;<td>\n\t\t\t\t </tr>\n                 <tr>\n\t\t\t\t <td  width=\'30%\' align=right class=label>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" </td>\n\t\t\t\t <td>&nbsp;\n\t\t\t\t <input type=text size=50 maxlength=100 name=Code value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t <img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img> \n\t\t\t\t <td>\n                   </tr>\n\t\t\t\t\t <tr>\n\t \t\t      <td class=label>&nbsp;</td>\n                  <td>&nbsp;<td>\n\t\t\t\t </tr>\n                 <tr>\n\t\t\t\t <td class=label>&nbsp;</td>\n                  <td>&nbsp;<td>\n\t\t\t\t </tr>\n\t\t\t\t </table>\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"facility\" id=\"facility\" value=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">\n\t\t\t\t <INPUT TYPE=\"hidden\" name=\"func\" id=\"func\" value=\"insert\">\n\t\t\t\t <INPUT TYPE=\"hidden\" name=\"tableId\" id=\"tableId\" value=\"UTL_FILE_DIR\"> \n                 <INPUT TYPE=\"hidden\" name=\"hmis_code\" id=\"hmis_code\" value=\"FILE_PATH\">  \n\t\t\t\t <form>\t  \n\t\t\t     ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" \n\t\t<P>\n\t\t<table align=\'right\'>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t<br><br>\n\t\t</P>\n\n\t\t\n\t\t<form target=\'messageFrame\'>\n        \n\t\t<table border=\"1\" align=\'center\' width=\"95%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t \n        <INPUT TYPE=\"hidden\" name=\"tableId\" id=\"tableId\" value=\"\">   \n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n\t\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null ;
	ResultSet rs4=null ;
	
	
	try
	{
		con = ConnectionManager.getConnection(request);
		String hmisid = request.getParameter("hmisid");
		
		StringTokenizer st =new StringTokenizer(hmisid,"~");
		String from = request.getParameter( "from" ) ;
		
		String to = request.getParameter( "to" ) ;
		
        String strsql1="";
		String code1="";
		String code2="";
		String code3="";
		String code4="";
		String code5="";
		String code6="";
		String code7="";
		String moduledes="";
		String hmisco="";
		String hmisco2="";
		String hmisco3="";
        String hmisco1="";
		String indicator_desc="";
		String mat_ward_yn="";
		String classValue = "" ;
		String sql = "";
        String  longdesc= (request.getParameter("longdesc")==null)?"":request.getParameter("longdesc");
	    longdesc=longdesc.trim();
	   
		if ((longdesc==null) || (longdesc.equals("null"))) longdesc = "";
			
		int maxRecord=0;
		int start = 0 ;
		
		int end = 0 ;
		int i=1;
		if (from == null )
		{
		
		start = 1 ;
		}
		else
		{
        start=Integer.parseInt(from);
		
		}
		if ( to == null )
			end = 10 ;
		else
			end = Integer.parseInt(to) ;
	 
		 if(st.hasMoreTokens())
		{
		    moduledes=st.nextToken().trim();
			
		 if (moduledes.equals("ExternalFileStorageLocation"))
			     {
                    String Facility=request.getParameter("facility")==null ?"":request.getParameter("facility");
					String mysql="SELECT MEDICOM_CODE1 FROM XT_HMIS_LINK WHERE TABLE_ID = 'UTL_FILE_DIR'";
                     String filedet="";
					 pstmt=con.prepareStatement(mysql);
                     rs=pstmt.executeQuery();
					 while (rs.next())
					 {
					 filedet=rs.getString(1);
					 }
                     if(pstmt!=null)pstmt.close();
					 if(rs!=null)rs.close();
                 
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(filedet));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Facility));
            _bw.write(_wl_block12Bytes, _wl_block12);
}
		else
			{
		if(moduledes.equals("IP_NURS_UNIT_FOR_SPECIALTY"))
	 		{    code7="Discipline for Ward";
                  if ( !(longdesc == null || longdesc.equals("")) )
	    			{
					   sql = " and upper(Y.long_desc)  like  upper('"+longdesc+"%') " ;
				     }

				     String mysql = "Select A.FACILITY_ID,A.NURSING_UNIT_CODE,A.SPECIALTY_CODE, B.HOSPITAL_CODE,B.HMIS_CODE1,B.HMIS_CODE2, X.FACILITY_NAME, Y.LONG_DESC WARD_DESC, Z.LONG_DESC SPCL_DESC  from IP_NURS_UNIT_FOR_SPECIALTY A, XT_HMIS_LINK B, SM_FACILITY_PARAM X, IP_NURSING_UNIT Y, AM_SPECIALITY Z Where B.Table_id (+) ='IP_NURS_UNIT_FOR_SPECIALTY' and  A.FACILITY_ID=B.FACILITY_ID (+) and A.NURSING_UNIT_CODE= B.MEDICOM_CODE1 (+) and  A.SPECIALTY_CODE=B.MEDICOM_CODE2 (+) and A.FACILITY_ID = X.FACILITY_ID and A.FACILITY_ID = Y.FACILITY_ID and A.NURSING_UNIT_CODE = Y.NURSING_UNIT_CODE and A.SPECIALTY_CODE = Z.SPECIALITY_CODE"+sql+" ORDER BY 7,8,9" ; 
   			         pstmt=con.prepareStatement(mysql);
			          rs=pstmt.executeQuery();
			 }  
			  else if((moduledes.equals("IP_NURSING_UNIT")))
			    {
				  
				  code1=st.nextToken();
				  code2=st.nextToken();
				  code3=st.nextToken();
				  code4=st.nextToken();
				  code5=st.nextToken();
			      code6=st.nextToken();
                  code7=st.nextToken();
				 
                  if ( !(longdesc == null || longdesc.equals("")) )
				     {
					        sql = " and upper( "+code3+")  like  upper('"+longdesc+"%') " ;
				      }
				 	String mysql = "Select A.FACILITY_ID, A.NURSING_UNIT_CODE, A.LONG_DESC, B.hospital_code, B.HMIS_CODE1, C.FACILITY_NAME,B.EMER_MATERNITY_YN from IP_NURSING_UNIT A, XT_HMIS_LINK B, SM_FACILITY_PARAM C Where A.FACILITY_ID = C.FACILITY_ID and B.Table_id (+) = 'IP_NURSING_UNIT'  and A.FACILITY_ID = B.FACILITY_ID  (+) and A.NURSING_UNIT_CODE  = B.MEDICOM_CODE1 (+) "+sql+"and A.eff_status = 'E' ORDER BY 6,3";
			       	pstmt=con.prepareStatement(mysql);
       				rs=pstmt.executeQuery();
		     }
		   	else if (moduledes.equals("OP_CLINIC"))
			{
                     
				          code7="Emergency Clinic";	 
				      if ( !(longdesc == null || longdesc.equals("")) )
				       {
					      sql = " and upper(A.long_desc)  like  upper('"+longdesc+"%') " ;
				        }
				    	String mysql =  "Select A.FACILITY_ID, A.CLINIC_CODE, A.LONG_DESC, B.HOSPITAL_CODE, B.HMIS_CODE1, C.FACILITY_NAME from OP_CLINIC A, XT_HMIS_LINK B, SM_FACILITY_PARAM C Where A.FACILITY_ID = C.FACILITY_ID and B.Table_id (+) = 'OP_CLINIC' and A.FACILITY_ID = B.FACILITY_ID (+) and A.CLINIC_CODE  = B.MEDICOM_CODE1 (+)" + sql + " AND A.LEVEL_OF_CARE_IND = 'E' AND A.EFF_STATUS = 'E' ORDER BY 6,3";
						
			         	pstmt=con.prepareStatement(mysql);
               	        rs=pstmt.executeQuery();
		    }
		   
		   else if((moduledes.equals("IP_DISCHARGE_TYPE")))
			   {
				code1=st.nextToken();
				code2=st.nextToken();
				code3=st.nextToken();
				code4=st.nextToken();
				code7=st.nextToken();		
				
		        	if ( !(longdesc == null || longdesc.equals("")) )
				{
					sql = " and  upper("+code2+")  like  upper('"+longdesc+"%') " ;
				}
				
				String mysql = "Select "+ code1 +"," +code2 +","+ code3 +" , B.INDICATOR, DECODE(B.INDICATOR,'DHM','Home','DTH','Death','ABS','Abscond','AOR','At Own Risk','TOH','Transfer to Other Hospital') indicator_desc from " + moduledes + " A , XT_HMIS_LINK B  Where B.Table_id (+) = ?  and "+code1+"= B.MEDICOM_CODE1 (+) "+sql;

					mysql = mysql + " and A.eff_status = 'E' order by 2,1,3";

				pstmt=con.prepareStatement(mysql);
				pstmt.setString(1,moduledes);
				rs=pstmt.executeQuery();
		   }
		    else if((moduledes.equals("MP_NOD_TYPE")))
			{
				code1=st.nextToken();
				code2=st.nextToken();
				code3=st.nextToken();
				code4=st.nextToken();
				code7=st.nextToken();		
							  if ( !(longdesc == null || longdesc.equals("")) )
				{
					sql = " and upper( "+code2+")  like  upper('"+longdesc+"%') " ;
				}
				
				
				String mysql = "Select "+ code1 +"," +code2 +","+ code3 +" ,B.INDICATOR, DECODE(B.INDICATOR,'NRD','Normal','CSD','Ceasarean','FRD','Forceps','VCD','Vacuum','OTH','Others') indicator_desc from " + moduledes + " A , XT_HMIS_LINK B  Where B.Table_id (+) = ?  and "+code1+"= B.MEDICOM_CODE1 (+) "+sql;

					mysql = mysql + " and A.eff_status = 'E' order by 2,1,3";

				pstmt=con.prepareStatement(mysql);
				pstmt.setString(1,moduledes);
				rs=pstmt.executeQuery();
		   }
		   else if((moduledes.equals("IP_BED_CLASS")))
			{
				code1=st.nextToken();
				code2=st.nextToken();
				code3=st.nextToken();
				code4=st.nextToken();
				code7=st.nextToken();		
				  
		    	if ( !(longdesc == null || longdesc.equals("")) )
				{
					sql = " and upper( "+code2+")  like  upper('"+longdesc+"%') " ;
				}
				
				String mysql = "Select "+ code1 +"," +code2 +","+ code3 +" ,B.INDICATOR, DECODE(B.INDICATOR,'1C','1st Class','2C','2nd Class','3C','3rd Class') indicator_desc  from " + moduledes + " A , XT_HMIS_LINK B  Where B.Table_id (+) = ?  and "+code1+"= B.MEDICOM_CODE1 (+) "+sql;

					mysql = mysql + " and A.eff_status = 'E' order by 2,1,3";
			
				pstmt=con.prepareStatement(mysql);
				pstmt.setString(1,moduledes);
				rs=pstmt.executeQuery();
		   }
		    else
		   {
				String mysql="";
				code1=st.nextToken();
				code2=st.nextToken();
				code3=st.nextToken();
				code4=st.nextToken();
				code7=st.nextToken();		
                
				if ( !(longdesc == null || longdesc.equals("")) )
				{
					sql = " and upper("+code2+")  like  upper('"+longdesc+"%') " ;
				}
                   if(moduledes.equals("MP_REGION"))
		              {
						 mysql = "Select "+ code1 +"," +code2 +","+ code3 +",B.INDICATOR from " + moduledes + " A , XT_HMIS_LINK B  Where B.Table_id (+) = ?  and "+code1+"= B.MEDICOM_CODE1 (+)  "+sql ;

					  }
					  else
			           {
         				 mysql = "Select "+ code1 +"," +code2 +","+ code3 +" from " + moduledes + " A , XT_HMIS_LINK B  Where B.Table_id (+) = ?  and "+code1+"= B.MEDICOM_CODE1 (+)  "+sql ;
	         		   }
				if(!(moduledes.equals("SM_FACILITY_PARAM")))
					mysql = mysql + " and A.eff_status = 'E'  order by 2,1,3";
				else
					mysql = mysql + " order by 2,3";

				pstmt=con.prepareStatement(mysql);
				pstmt.setString(1,moduledes);
				rs=pstmt.executeQuery();
			}
				
			stmt = con.createStatement();
			 
               
			if(moduledes.equals("SM_FACILITY_PARAM"))
			{
			strsql1 = "select count(*) total from "+ moduledes+ " A   where upper(" + code2 +") like  upper('"+longdesc+"%') ";
			}
			else if(moduledes.equals("IP_NURS_UNIT_FOR_SPECIALTY"))
			{	
			 strsql1 = "select count(*) total from IP_NURS_UNIT_FOR_SPECIALTY A, XT_HMIS_LINK B, SM_FACILITY_PARAM X, IP_NURSING_UNIT Y, AM_SPECIALITY Z Where B.Table_id (+) ='IP_NURS_UNIT_FOR_SPECIALTY' and  A.FACILITY_ID=B.FACILITY_ID (+) and A.NURSING_UNIT_CODE= B.MEDICOM_CODE1 (+) and  A.SPECIALTY_CODE=B.MEDICOM_CODE2 (+) and A.FACILITY_ID = X.FACILITY_ID and A.FACILITY_ID = Y.FACILITY_ID and A.NURSING_UNIT_CODE = Y.NURSING_UNIT_CODE and A.SPECIALTY_CODE = Z.SPECIALITY_CODE AND upper(Y.LONG_DESC) like upper('"+longdesc+"%')";
			 
			}
			else if(moduledes.equals("IP_NURSING_UNIT"))
			{ 
				strsql1 = "select count(*) total from IP_NURSING_UNIT where eff_status = 'E' and upper(long_desc) like  upper('"+longdesc+"%') ";
			     
			 
			}
			else if(moduledes.equals("IP_DISCHARGE_TYPE"))
			{ 
			strsql1=	"Select  count(*) total from  IP_DISCHARGE_TYPE  A ,XT_HMIS_LINK B  Where B.Table_id(+) =' IP_DISCHARGE_TYPE ' and " + code1 +"= B.MEDICOM_CODE1(+) and eff_status = 'E' and upper(long_desc) like  upper('"+longdesc+ "%') ";
			
			   

			
			
			}
			else if(moduledes.equals("OP_CLINIC"))
			{	
			strsql1 = "select count(*) total from OP_CLINIC  where eff_status = 'E' and LEVEL_OF_CARE_IND = 'E' and upper(long_desc) like  upper('"+longdesc+"%') ";
			}
			else
			{
					strsql1 = "select count(*) total from "+ moduledes+ " A   where A.eff_status = 'E' and upper("+code2+")  like  upper('"+longdesc+"%') ";	
			
			}
                   
			 rs4 = stmt.executeQuery(strsql1);
			 rs4.next();
			 
			 maxRecord = rs4.getInt("total");
			 
			 
			if(maxRecord == 0)
			{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			out.println("<script>parent.frames[2].location.href ='../../eCommon/html/blank.html ';</script>");
			
			}
		
		
		
            _bw.write(_wl_block13Bytes, _wl_block13);

			if ( !(start <= 1) )
			out.println("<A HREF='../../eMR/jsp/HMISMastersResult.jsp?from="+(start-10)+"&to="+(end-10)+"&hmisid= "+java.net.URLEncoder.encode(hmisid)+"&longdesc="+java.net.URLEncoder.encode(longdesc)+"'"+"text-decoration='none' onClick='refresh();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+10) > maxRecord ) )
		out.println("<A HREF='../../eMR/jsp/HMISMastersResult.jsp?from="+(start+10)+"&to="+(end+10)+"&hmisid= "+java.net.URLEncoder.encode(hmisid)+"&longdesc= "+java.net.URLEncoder.encode(longdesc)+"'" +"text-decoration='none' onClick='refresh();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			
            _bw.write(_wl_block14Bytes, _wl_block14);

		
		
		if ( start != 1 )
				 for( int j=1; j<start;i++,j++ )
				{
				   rs.next() ;
				}
											
				if(moduledes.equals("IP_NURS_UNIT_FOR_SPECIALTY"))
				{
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels")+"</th>");
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"</th>" );
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</th>");  
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.HospitalCode.label","mr_labels")+"</th>");
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.WardCode.label","mr_labels")+"</th>");
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DisciplineCode.label","mr_labels")+"</th>");
				}
				else if (moduledes.equals("OP_CLINIC"))
				{
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels")+"</th>");
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicCode.label","common_labels")+"</th>" );
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")+"</th>");  
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.HospitalCode.label","mr_labels")+"</th>");
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ExternalMasterCode.label","mr_labels")+"</th>");
					
				}
				else if (moduledes.equals("IP_NURSING_UNIT"))
				{
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels")+"</th>");
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NursingUnitCode.label","common_labels")+"</th>" );
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")+"</th>");  
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.HospitalCode.label","mr_labels")+"</th>");
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.WardCode.label","mr_labels")+"</th>");
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MaternityWard.label","mr_labels")+"</th>");
				}
				
				else
			    {
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels")+"</th>" );
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")+"</th>");
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ExternalMasterCode.label","mr_labels")+"</th>");

					if (moduledes.equals("IP_DISCHARGE_TYPE"))
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dischargetype.label","common_labels")+"</th>");

					if (moduledes.equals("IP_BED_CLASS"))
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+"</th>");

					if (moduledes.equals("MP_NOD_TYPE"))
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliveryType.label","mp_labels")+"</th>");
				
					if (moduledes.equals("MP_REGION"))
					 out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.HomeState.label","mr_labels")+"</th>");
				
				}
						
				while(rs.next() && i<=end)
				{
					if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;
					
					if(moduledes.equals("IP_NURS_UNIT_FOR_SPECIALTY"))
					{
			            out.println("<tr><td class='" + classValue + "'>");
						out.println("<a href='../../eMR/jsp/HMISMastersframe.jsp?code1="+rs.getString(2)+"&facdesc="+ java.net.URLEncoder.encode(rs.getString(7))+"&warddesc="+ java.net.URLEncoder.encode(rs.getString(8))+"&specdesc="+ java.net.URLEncoder.encode(rs.getString(9))+"&code6="+ moduledes+"&code7="+ code7+"&spec="+ java.net.URLEncoder.encode(rs.getString(3))+"&facility="+ rs.getString(1)+"&code3="+ rs.getString(4)+"&disp="+ rs.getString(6)+"&code4="+ rs.getString(5)+" ' target='HMISFrame3' >");
						out.println( rs.getString(7));
						out.println("</td><td class='" + classValue + "'>");
						out.println(rs.getString(8) );
					    out.println("</td><td class='" + classValue + "'>");
						out.println(rs.getString(9) );
						out.println("</td><td class='" + classValue + "'>");
						hmisco1=(rs.getString(4)==null)?"&nbsp;" :rs.getString(4);
						out.println(hmisco1);
						out.println("</td><td class='" + classValue + "'>");
						hmisco2=(rs.getString(5)==null)?"&nbsp;" :rs.getString(5);
						out.println(hmisco2);
						out.println("</td><td class='" + classValue + "'>");
				        hmisco=(rs.getString(6)==null)?"&nbsp;" :rs.getString(6);
						out.println(hmisco+"</td>");
					}
					else if (moduledes.equals("IP_NURSING_UNIT"))
					{
					    out.println("<tr><td class='" + classValue + "'>");
					    out.println("<a href='../../eMR/jsp/HMISMastersframe.jsp?code1="+rs.getString(2)+"&facility="+ rs.getString(1)+"&code2="+ java.net.URLEncoder.encode(rs.getString(3))+"&code3="+ rs.getString(4)+"&code4="+ rs.getString(5)+"&code7="+ code7+"&descrip="+java.net.URLEncoder.encode(rs.getString(6)) +"&efstat="+ rs.getString(7)+"&code6="+ moduledes+" ' target='HMISFrame3' >");
					    out.println( rs.getString(6));						 
						out.println("</td><td class='" + classValue + "'>");
						out.println("<a href='../../eMR/jsp/HMISMastersframe.jsp?code1="+rs.getString(2)+"&facility="+ rs.getString(1)+"&code2="+ java.net.URLEncoder.encode(rs.getString(3))+"&code3="+ rs.getString(4)+"&code4="+ rs.getString(5)+"&code7="+ code7+"&descrip="+java.net.URLEncoder.encode(rs.getString(6))+"&efstat="+rs.getString(7)+"&code6="+ moduledes+" ' target='HMISFrame3' >");
					    out.println(rs.getString(2) );
						out.println("</td><td class='" + classValue + "'>");
						out.println(rs.getString(3) );
						out.println("</td><td class='" + classValue + "'>");
						hmisco= (rs.getString(4)==null)?"&nbsp;" :rs.getString(4);
						out.println(hmisco);
						out.println("</td><td class='" + classValue + "'>");
						hmisco2=(rs.getString(5)==null)?"&nbsp;" :rs.getString(5);
						out.println(hmisco2);

						hmisco3=(rs.getString(5)==null)?"" :rs.getString(5);

						out.println("</td><td align='center' class='" + classValue + "'>");

						mat_ward_yn=(rs.getString(7)==null)?"" :rs.getString(7);
						if (mat_ward_yn.equals("Y"))
							out.println("<img src='../../eCommon/images/enabled.gif'></img></td>");
						else if (mat_ward_yn.equals("") && (!hmisco3.equals("")))
							out.println("<img src='../../eCommon/images/RRnwd.gif'></img></td>");
						else
						out.println("&nbsp;</td>");
					}
					else if (moduledes.equals("OP_CLINIC"))
					{
					    out.println("<tr><td class='" + classValue + "'>");
						out.println("<a href='../../eMR/jsp/HMISMastersframe.jsp?code1="+rs.getString(2)+"&facility="+ rs.getString(1)+"&code2="+ java.net.URLEncoder.encode(rs.getString(3))+"&code3="+ rs.getString(4)+"&code4="+ rs.getString(5)+"&code7="+ code7+"&descrip="+java.net.URLEncoder.encode(rs.getString(6))+"&code6="+ moduledes+" ' target='HMISFrame3' >");
                       out.println( rs.getString(6));						 
						out.println("</td><td class='" + classValue + "'>");
						out.println("<a href='../../eMR/jsp/HMISMastersframe.jsp?code1="+rs.getString(2)+"&facility="+ rs.getString(1)+"&code2="+ java.net.URLEncoder.encode(rs.getString(3))+"&code3="+ rs.getString(4)+"&code4="+ rs.getString(5)+"&code7="+ code7+"&descrip="+java.net.URLEncoder.encode(rs.getString(6))+"&code6="+ moduledes+" ' target='HMISFrame3' >");
					    out.println(rs.getString(2) );
						out.println("</td><td class='" + classValue + "'>");
						out.println(rs.getString(3) );
						out.println("</td><td class='" + classValue + "'>");
						hmisco= (rs.getString(4)==null)?"&nbsp;" :rs.getString(4);
						out.println(hmisco);
						out.println("</td><td class='" + classValue + "'>");
						hmisco2=(rs.getString(5)==null)?"&nbsp;" :rs.getString(5);
						out.println(hmisco2+"</td>");
					}
					else if (moduledes.equals("IP_BED_CLASS"))
					{
					    out.println("<tr><td class='" + classValue + "'>");
						out.println("<a href='../../eMR/jsp/HMISMastersframe.jsp?code1="+rs.getString(1)+"&code6="+ moduledes+"&code7="+ code7+"&indi="+rs.getString(4)+"&code3="+rs.getString(3)+"&code2="+ java.net.URLEncoder.encode(rs.getString(2))+" ' target='HMISFrame3' >");
						out.println( rs.getString(1));
						out.println("</td><td class='" + classValue + "'>");
						out.println(rs.getString(2) );
						out.println("</td><td class='" + classValue + "'>");
						hmisco=(rs.getString(3)==null)?"&nbsp;" :rs.getString(3);
						out.println(hmisco);
						out.println("</td><td class='" + classValue + "'>");
						indicator_desc=(rs.getString(5)==null)?"&nbsp;":rs.getString(5);
						out.println(indicator_desc+"</td>");
					}
					else if (moduledes.equals("MP_NOD_TYPE"))
					{ 
					    out.println("<tr><td class='" + classValue + "'>");
						out.println("				<a href='../../eMR/jsp/HMISMastersframe.jsp?code1="+java.net.URLEncoder.encode(rs.getString(1))+"&code6="+ moduledes+"&code7="+ code7+"&indi="+rs.getString(4)+"&code3="+rs.getString(3)+"&code2="+							java.net.URLEncoder.encode(rs.getString(2))+" ' target='HMISFrame3' >");
						out.println( rs.getString(1));
						out.println("</td><td class='" + classValue + "'>");
						out.println(rs.getString(2) );
						out.println("</td><td class='" + classValue + "'>");
						hmisco=(rs.getString(3)==null)?"&nbsp;" :rs.getString(3);
						out.println(hmisco);
						out.println("</td><td class='" + classValue + "'>");
						indicator_desc=(rs.getString("indicator_desc")==null)?"&nbsp;" :rs.getString("indicator_desc");
						out.println(indicator_desc+"</td>");
					}
					else if (moduledes.equals("IP_DISCHARGE_TYPE"))
					{
					   out.println("<tr><td class='" + classValue + "'>");
						out.println("<a href='../../eMR/jsp/HMISMastersframe.jsp?code1="+rs.getString(1)+"&code6="+ moduledes+"&code7="+ code7+"&code3="+rs.getString(3)+"&indi="+rs.getString(4)+"&code2="+ java.net.URLEncoder.encode(rs.getString(2))+" ' target='HMISFrame3' >");
						out.println( rs.getString(1));
						out.println("</td><td class='" + classValue + "'>");
						out.println(rs.getString(2) );
						out.println("</td><td class='" + classValue + "'>");
						hmisco=(rs.getString(3)==null)?"&nbsp;" :rs.getString(3);
						out.println(hmisco);
						out.println("</td><td class='" + classValue + "'>");
						indicator_desc=(rs.getString("indicator_desc")==null)?"&nbsp;" :rs.getString("indicator_desc");
						out.println(indicator_desc+"</td>");
					}
					else
					{
						out.println("<tr><td class='" + classValue + "'>");
					   if (moduledes.equals("MP_REGION"))
						{
                    	out.println("<a href='../../eMR/jsp/HMISMastersframe.jsp?code1="+java.net.URLEncoder.encode(rs.getString(1))+"&code6="+ moduledes+"&code7="+ code7+"&indi="+rs.getString(4)+"&code3="+rs.getString(3)+"&code2="+ java.net.URLEncoder.encode(rs.getString(2))+" ' target='HMISFrame3' >");
						}else
						{
						out.println("<a href='../../eMR/jsp/HMISMastersframe.jsp?code1="+java.net.URLEncoder.encode(rs.getString(1))+"&code6="+ moduledes+"&code7="+ code7+"&code3="+rs.getString(3)+"&code2="+ java.net.URLEncoder.encode(rs.getString(2))+" ' target='HMISFrame3' >");
						}
						out.println( rs.getString(1));
						out.println("</td><td class='" + classValue + "'>");
						out.println(rs.getString(2) );
						out.println("</td><td class='" + classValue + "'>");
						hmisco=(rs.getString(3)==null)?"&nbsp;" :rs.getString(3);
						out.println(hmisco+"</td>");
						
			           if (moduledes.equals("MP_REGION"))
						{
                          hmisco3=(rs.getString(3)==null)?"" :rs.getString(3);
                        out.println("</td><td align='center' class='" + classValue + "'>");

						mat_ward_yn=(rs.getString(4)==null)?"" :rs.getString(4);
						if (mat_ward_yn.equals("Y"))
							out.println("<img src='../../eCommon/images/enabled.gif'></img></td>");
						else if (mat_ward_yn.equals("") && (!hmisco3.equals("")))
							out.println("<img src='../../eCommon/images/RRnwd.gif'></img></td>");
						else
						out.println("&nbsp;</td>");



						}

					
					}							
					i++;	 
				}
            _bw.write(_wl_block15Bytes, _wl_block15);
	}
		
		 
		}
	      con.close();
	
	     }
	catch(Exception e)
	{		/* out.println(e); */	e.printStackTrace();	}
	finally
{
try
	{
	if(pstmt != null)pstmt.close();
	if(stmt != null)stmt.close();
	}
	catch(Exception e1)
	{
	}


ConnectionManager.returnConnection(con,request);
	
}
            _bw.write(_wl_block16Bytes, _wl_block16);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ExternalFileStorageLocation.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.FilePath.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
