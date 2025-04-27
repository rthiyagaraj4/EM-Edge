package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.eslp.*;
import java.net.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __librarysetupheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/LibrarySetUpHeader.jsp", 1724911766306L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<HTML>\n  <HEAD>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t<SCRIPT language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></SCRIPT>\n\t<SCRIPT language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t<SCRIPT language=\"JavaScript\" src=\"../../eCP/js/LibrarySetUp.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n  </HEAD>\n  ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t  <SCRIPT>unload()</SCRIPT>\n\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n  <BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n<FORM name=\"LibraryHeaderForm\" id=\"LibraryHeaderForm\" method=\"post\" action=\"../../servlet/eCP.LibrarySetUpServlet\" target=\"messageFrame\" >\n<BR>\n<TABLE cellpadding=0 cellspacing=\'5\' width=\"90%\" align=\"center\" border=\"0\">\n\t<TR>\n\t\t<TD align=\"right\"  class=\"label\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</TD>\n\t\t<TD align=\"left\">&nbsp;&nbsp;\n\t\t\t<INPUT type=\"Text\" name=\"library_id\" id=\"library_id\" size=\"20\" maxlength=\"20\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" onblur=\"ChangeUpperCase(this);\"  onKeyPress=\"return CheckForSpecChars(event);\" >\n\t\t\t<IMG src=\"../../eCommon/images/mandatory.gif\"></IMG>\n\t\t</TD>\n\t</TR>\n\t<TR>\n\t\t<TD align=\"right\"  class=\"label\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</TD>\n\t\t<TD align=\"left\">&nbsp;&nbsp;\n\t\t\t<INPUT type=\"Text\" name=\"short_desc_chk\" id=\"short_desc_chk\" size=\"60\"   maxlength=\"60\" onblur=\"CheckMaxLength1(this,\'60\')\" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t<IMG src=\"../../eCommon/images/mandatory.gif\"></IMG>\n\t\t</TD>\n\t</TR>\n\t<TR>\n\t\t<TD align=\"right\"  class=\"label\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</TD>\n\t\t<TD align=\"left\">&nbsp;&nbsp;\n\t\t\t<!-- <TEXTAREA name=\"long_desc\"  rows=\"3\" cols=\"55\" maxlength=\"400\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" onBlur=\'makeValidString(this)\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</TEXTAREA> -->\n\t\t\t<TEXTAREA name=\"long_desc_chk\"  rows=\"2\" cols=\"50\" maxlength=\"400\" onblur=\"CheckMaxLength1(this,\'400\');makeValidString(this)\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</TEXTAREA>\n\t\t\t<IMG src=\"../../eCommon/images/mandatory.gif\"></IMG>\n\t\t</TD>\n\t</TR>\n\t<TR>\n\t\t<TD align=\"right\"  class=\"label\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</TD>\n\t\t<TD align=\"left\">&nbsp;&nbsp;\n\t\t\t<INPUT type=\"checkbox\" name=\"eff_status\" id=\"eff_status\"  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" onclick=\"allowUpdate(this)\">\n\t\t</TD>\n\t</TR>\n\t\n</TABLE>\n\t\t\t<!-- \tVersionDetials hidden variables -->\n\t\t\t<INPUT type=\"hidden\" name=\"version_remarks\" id=\"version_remarks\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t<INPUT type=\"hidden\" name=\"Status\" id=\"Status\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t<INPUT type=\"hidden\" name=\"dependency_level\" id=\"dependency_level\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t<INPUT type=\"hidden\" name=\"libraryBasis\" id=\"libraryBasis\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t<!-- End of version Details variables -->\n\n\t\t\t<!-- Patient Class hidden variables -->\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<INPUT type=\"hidden\" name=\"patientchk_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"patientchk_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" value=\"\">\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\n\t\t\t\t<!-- End of Patient Class variables -->\n\n\n\t\t\t\t<!-- Age Group class variables -->\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<INPUT type=\"hidden\" name=\"AgeGrpChk";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"AgeGrpChk";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" value=\"\">\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t<INPUT type=\"hidden\" name=\"AgeGrpChk";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<INPUT type=\"hidden\" name=\"BAgeGrpChk";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" id=\"BAgeGrpChk";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t<INPUT type=\"hidden\" name=\"ege_grp_len\" id=\"ege_grp_len\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t\t\n\n\t\t\t<!-- Age Group class variables -->\n\n\t\t\t<INPUT type=\"hidden\" name=\"eff_status_yn\" id=\"eff_status_yn\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t<INPUT type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t\t<INPUT type=\"hidden\" name=\"version_no\" id=\"version_no\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t<INPUT type=\"hidden\" name=\"long_desc\" id=\"long_desc\" value=\"\"> \n\t\t\t<INPUT type=\"hidden\" name=\"libraryid\" id=\"libraryid\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t<INPUT type=\"hidden\" name=\"short_desc\" id=\"short_desc\" value=\"\"> \n\t\t\t<INPUT type=\"hidden\" name=\"finalString\" id=\"finalString\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"> \n\t\t\t<INPUT type=\"hidden\" name=\"totPatClsRecords\" id=\"totPatClsRecords\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"> \n\t\t\t<INPUT type=\"hidden\" name=\"totAgeGrpRecords\" id=\"totAgeGrpRecords\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">  <!-- added by IN034470 -->\n\n\n\t\t\t ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t<INPUT type=\"hidden\" name=\"chkAll\" id=\"chkAll\" value=\"Y\"> \n\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t<INPUT type=\"hidden\" name=\"chkAll\" id=\"chkAll\" value=\"\"> \n\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t<INPUT type=\"hidden\" name=\"chkAll\" id=\"chkAll\" value=\"\"> \n\t\t\t\t ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\n\n</FORM>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n<SCRIPT> loadpage()</SCRIPT>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

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
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
05/12/2012	  IN034470 		Karthi L	  		When creating new library setup, age groups not created completely and query back not displaying corresponding stored data
---------------------------------------------------------------------------------------------------------------
*/ 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet LibrarySetupAgeGroup= null;synchronized(session){
                LibrarySetupAgeGroup=(webbeans.eCommon.RecordSet)pageContext.getAttribute("LibrarySetupAgeGroup",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(LibrarySetupAgeGroup==null){
                    LibrarySetupAgeGroup=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("LibrarySetupAgeGroup",LibrarySetupAgeGroup,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

//This file is saved on 19/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		Connection connection 			=		null;
		Statement stmt					=		null;
		PreparedStatement pstmt			=		null;
		ResultSet rs					=		null;

	  String mode						=		request.getParameter("mode");
	  int version_no					=		0;
	   int dependency_level				=		0;
	  String libraryid					=		"";
	  String shortdesc					=		"";
	  String longdesc					=		"";
	  String qstatus					=		"";
	  String eff_status					=		"";
	  String eff_status_checked			=		"Checked";
	  String readonly					=		"";
	  String disabled					=		"";
	  String versionQuery				=		"";
	  String patClassQuery				=		"";
	  String ageGrpQuery				=		"";
	  String patcode					=		"";
	  String agecode					=		"";
  	  String addbyid					=		"";
  	  String versionremarks				=		"";
	  String finalString				=		mode;
	  String status						=		"D";
	  String library_basis				=		"0";
	  String descQuery					=		"";
	  String basepatclassquery			=		"SELECT PATIENT_CLASS, SHORT_DESC FROM AM_PATIENT_CLASS ORDER BY 2";
	  String baseageGrpClassquery		=		"SELECT AGE_GROUP_CODE,SHORT_DESC FROM AM_AGE_GROUP WHERE EFF_STATUS='E' ORDER BY 2";
	  ArrayList basepatclass			=		new ArrayList();
	  ArrayList baseageGrpClass			=		new ArrayList();
	  ArrayList patclass				=		new ArrayList();
	  ArrayList ageGrpClass				=		new ArrayList();

	   // System.err.println("mode "+mode);
	//	System.err.println("in header  "+request.getQueryString());

		try{
			connection		 =		 ConnectionManager.getConnection(request);
			stmt			 =		 connection.createStatement();

			rs=stmt.executeQuery(basepatclassquery);
			if(rs!=null){
				while(rs.next()){
					basepatclass.add(rs.getString("PATIENT_CLASS"));

				}
			}
			//System.err.println("basepatclass  "+basepatclass);
			rs.close();

			rs=stmt.executeQuery(baseageGrpClassquery);
			if(rs!=null){
				while(rs.next()){
					baseageGrpClass.add(rs.getString("AGE_GROUP_CODE"));

				}
			}
			rs.close();
			//System.err.println("baseageGrpClass  "+baseageGrpClass);

			java.util.Collections.sort(baseageGrpClass); // added for IN034470
		}catch(Exception e){
		 // out.println("Error is--->"+e);//COMMON-ICN-0181
                   e.printStackTrace();//COMMON-ICN-0181

		}
	  if(mode.equals("2"))
	  {
		 
		  libraryid		=		request.getParameter("library_id");
		  eff_status	=		request.getParameter("eff_status");
		  version_no	=		Integer.parseInt((String)request.getParameter("version_no"));
		//  System.err.println("version_no "+version_no);
		  try{
			  	//descQuery		=		"SELECT SHORT_DESC,LONG_DESC FROM CP_LIBRARY WHERE LIBRARY_ID='"+libraryid+"' AND VERSION_NO='"+version_no+"'";//common-icn-0180
			  	descQuery		=		"SELECT SHORT_DESC,LONG_DESC FROM CP_LIBRARY WHERE LIBRARY_ID= ? AND VERSION_NO= ?";//common-icn-0180
			  	
			  	pstmt = connection.prepareStatement(descQuery);//common-icn-0180
			  	pstmt.setString(1,libraryid);//common-icn-0180
			  	pstmt.setInt(2,version_no);//common-icn-0180
			  	//rs=stmt.executeQuery(descQuery);//common-icn-0180
			  	rs=pstmt.executeQuery();//common-icn-0180
				if(rs!=null){
					rs.next();
					shortdesc=rs.getString("SHORT_DESC");
					longdesc=rs.getString("LONG_DESC");
				}
				rs.close();
				pstmt.close();//common-icn-0180
				//System.err.println("LONG_DESC "+longdesc);
				//System.err.println("SHORT_DESC "+shortdesc);

		  }catch(Exception e){
			 // out.println("Error is--->"+e);//COMMON-ICN-0181
                          e.printStackTrace();//COMMON-ICN-0181
		  }
		  if(eff_status.equals("E"))
		  eff_status_checked		=	"Checked";
		  else{
			  eff_status_checked	=	"";

		  
            _bw.write(_wl_block9Bytes, _wl_block9);

		  		  disabled				=	"Disabled";
		  }
			  
		  finalString	=	finalString+"||"+version_no;
		  	  readonly	=	"READONLY";
			 try
			{
				 patClassQuery="SELECT 'Y' SELECTED_YN,A.PATIENT_CLASS PATIENT_CLASS,SHORT_DESC PATIEND_CLASS_DESC FROM CP_PAT_CLASS_FOR_LIBRARY A,AM_PATIENT_CLASS B WHERE LIBRARY_ID=? AND VERSION_NO=? AND A.PATIENT_CLASS=B.PATIENT_CLASS UNION SELECT 'N' SELECT_YN,PATIENT_CLASS PATIENT_CLASS,SHORT_DESC PATIENT_CLASS_DESC FROM AM_PATIENT_CLASS A WHERE NOT EXISTS(SELECT ROWID FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=? AND VERSION_NO=? AND PATIENT_CLASS=A.PATIENT_CLASS)";

			    ageGrpQuery="SELECT 'Y' SELECT_YN,A.AGE_GROUP_CODE AGE_GROUP_CODE,SHORT_DESC AGER_GROUP_DESC,DECODE(GENDER,'M','Male','F','Female','All')SEX_SPECIFIC,MIN_AGE||'  '||DECODE(AGE_UNIT,'D','Days','M','Months','Y','Years')AGE_MIN_UNIT,MAX_AGE||' '|| DECODE(NVL(AGE_UNIT_MAX,AGE_UNIT),'D','Days','M','Months','Y','Years')AGE_MAX_UNIT FROM CP_AGE_GRP_FOR_LIBRARY A,AM_AGE_GROUP B WHERE LIBRARY_ID=? AND VERSION_NO=? AND A.AGE_GROUP_CODE=B.AGE_GROUP_CODE UNION SELECT 'N' SELECT_YN,AGE_GROUP_CODE AGE_GROUP_CODE,SHORT_DESC AGER_GROUP_DESC,DECODE(GENDER,'M','Male','F','Female','All')SEX_SPECIFIC,MIN_AGE||' '||DECODE(AGE_UNIT,'D','Days','M','Months','Y','Years')AGE_MIN_UNIT,MAX_AGE||' ' ||DECODE(NVL(AGE_UNIT_MAX,AGE_UNIT),'D','Days','M','Months','Y','Years')AGE_MAX_UNIT FROM AM_AGE_GROUP A WHERE NOT EXISTS(SELECT ROWID FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=? AND VERSION_NO=? AND AGE_GROUP_CODE=A.AGE_GROUP_CODE) ORDER BY 2";

				versionQuery="SELECT VERSION_NO, VERSION_REMARKS, STATUS, DEPENDENCY_LEVEL, LIBRARY_BASIS,ADDED_BY_ID FROM CP_LIBRARY WHERE LIBRARY_ID=? AND VERSION_NO=?";


			
				pstmt			 =		 connection.prepareStatement(patClassQuery);
				pstmt.setString(1,libraryid);
				pstmt.setInt(2,version_no);
				pstmt.setString(3,libraryid);
				pstmt.setInt(4,version_no);
				rs					=		pstmt.executeQuery();
				
				while(rs.next())
				{
					qstatus		=		(String)rs.getString("SELECTED_YN");
					if(qstatus.equals("Y")){
							patcode		=		(String)rs.getString("PATIENT_CLASS");
							patclass.add(patcode);
					}
					
				}
				rs.close();
				pstmt.close();

//				rs			=	null;
				pstmt	=	connection.prepareStatement(ageGrpQuery);
				pstmt.setString(1,libraryid);
				pstmt.setInt(2,version_no);
				pstmt.setString(3,libraryid);
				pstmt.setInt(4,version_no);
				rs			=	pstmt.executeQuery();

				while (rs.next()){
					qstatus	=	(String)rs.getString("SELECT_YN");
					if(qstatus.equals("Y")){
							agecode=(String)rs.getString("AGE_GROUP_CODE");
							ageGrpClass.add(agecode);					
																		
					}
				}
				rs.close();
				pstmt.close();
				java.util.Collections.sort(ageGrpClass); // IN034470

				//rs=null;
				pstmt = connection.prepareStatement(versionQuery);
				pstmt.setString(1,libraryid);
				pstmt.setInt(2,version_no);
				rs=pstmt.executeQuery();
				if(rs.next()){
					addbyid=rs.getString("ADDED_BY_ID");
					versionremarks=rs.getString("VERSION_REMARKS");
					status=rs.getString("STATUS");
					dependency_level=rs.getInt("DEPENDENCY_LEVEL");
					library_basis=rs.getString("LIBRARY_BASIS");
				}
				rs.close();
				pstmt.close();

			  }catch(Exception e){
				  System.err.println(e.toString());
					e.printStackTrace();

				 }
				 finally
				{

					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(stmt!=null)	  stmt.close();
					if(connection != null)
						ConnectionManager.returnConnection(connection,request);					
				}	
			finalString=finalString+"||"+addbyid;
	  }
	   
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(shortdesc));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(longdesc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(longdesc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(eff_status_checked));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(versionremarks));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(status));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dependency_level));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(library_basis));
            _bw.write(_wl_block25Bytes, _wl_block25);
	if(mode.equals("1")){
	//System.err.println("basepatclass  "+basepatclass.size());
		for(int k=0;k<basepatclass.size();k++){
		//	System.err.println("pat K "+k);

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(k+1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(k+1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(basepatclass.get(k)));
            _bw.write(_wl_block29Bytes, _wl_block29);

		}
	}else{
		for(int k=0;k<basepatclass.size();k++){
			if(patclass.contains((String)basepatclass.get(k))){

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(k+1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(k+1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(basepatclass.get(k)));
            _bw.write(_wl_block29Bytes, _wl_block29);

			}else{

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(k+1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(k+1));
            _bw.write(_wl_block30Bytes, _wl_block30);


			}
		}

	}

            _bw.write(_wl_block31Bytes, _wl_block31);
	if(mode.equals("1")){
	//	System.err.println("agegrpclass  "+baseageGrpClass.size());

		for(int k=0;k<baseageGrpClass.size();k++){
		//				System.err.println("Age K "+k);


            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(k+1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(k+1));
            _bw.write(_wl_block34Bytes, _wl_block34);
		}
	}else{
		for(int k=0;k<baseageGrpClass.size();k++){
			if(ageGrpClass.contains((String)baseageGrpClass.get(k))){

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(k+1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(k+1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(baseageGrpClass.get(k)));
            _bw.write(_wl_block29Bytes, _wl_block29);

			}else{

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(k+1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(k+1));
            _bw.write(_wl_block30Bytes, _wl_block30);
			}
		}

	}

	for(int k=0;k<baseageGrpClass.size();k++){
	
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(k+1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(k+1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(baseageGrpClass.get(k)));
            _bw.write(_wl_block38Bytes, _wl_block38);

	}
	
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(baseageGrpClass.size()));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(eff_status));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(version_no));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(finalString));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(basepatclass.size()));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(baseageGrpClass.size()));
            _bw.write(_wl_block47Bytes, _wl_block47);
if(mode.equals("2")){
					if(ageGrpClass.size()==baseageGrpClass.size()){
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
            _bw.write(_wl_block49Bytes, _wl_block49);
}
				 }else if(mode.equals("1")){
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block51Bytes, _wl_block51);

	if(eff_status.equals("") || eff_status.equals("E")){
            _bw.write(_wl_block52Bytes, _wl_block52);
}
            _bw.write(_wl_block53Bytes, _wl_block53);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortdescription.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longdescription.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
}
