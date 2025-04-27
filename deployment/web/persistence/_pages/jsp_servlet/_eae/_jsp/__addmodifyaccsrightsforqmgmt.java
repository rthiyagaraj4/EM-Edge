package jsp_servlet._eae._jsp;

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

public final class __addmodifyaccsrightsforqmgmt extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AddModifyAccsRightsforQMgmt.jsp", 1709113823147L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n \n  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n  <script language=\'javascript\' src=\'../../eAE/js/AccsRightsforQMgmt.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script>\n\n\n \n</head>   \n  ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t  <SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\tvar error=getMessage(\"NO_AE_USER_RIGHTS\",\"AE\");\t\t\t\n\t\t    alert(error);\n\t\t\t\t\t\t\n\t\t </SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t        <form name=\"AddModifyAccsRightsforQMgmt\" id=\"AddModifyAccsRightsforQMgmt\" action=\"../../servlet/eAE.AccsRightsforMgmtservlet\" method=\"post\" target=\"messageFrame\">\n             <table border=\"1\" width=\"60%\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\'>                  \n\t\t\t\t   <td class= \'COLUMNHEADER\' > ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" </td>\n\t\t\t\t   <td class= \'COLUMNHEADER\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </td> \n\t\t\t\t   <td class= \'COLUMNHEADER\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td> \n\t\t\t\t ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" <td class= \'COLUMNHEADER\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td> ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Starts-->\n\t\t\t\t ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t  <td class= \'COLUMNHEADER\' >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t  <td class= \'COLUMNHEADER\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t  ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t   <!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Ends-->\n    ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n \n\t\t\t<tr>\n            <input type=\'hidden\' class=\'fields\'  name=\'practitioner_code";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'practitioner_code";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t\t<td width=\'15%\' class=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t<td  width=\'15%\' class=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" ><input type=\'checkbox\' class=\'fields\'  name=\'second_triage_yn";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'second_triage_yn";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' onclick=\'Enable_counsl(this,";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =");\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="></td>\n\t\t\t<td width=\'15%\' class=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="><input type=\'checkbox\' class=\'fields\'  name=\'counsulation_yn";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'counsulation_yn";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' onclick=\'CounslationCheck(this);\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" ></td>\n\t\t\t ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t <td width=\'15%\' class=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="><input type=\'checkbox\' class=\'fields\'  name=\'reg_new_born_yn";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'reg_new_born_yn";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" ></td> \n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\n\t\t\t <!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Starts-->\n\t\t\t ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t <td  width=\'10%\' class=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" ><input type=\'checkbox\' class=\'fields\'  name=\'for_admission";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'for_admission";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'        id=\'for_admission";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'          onclick=\'Checkboxcheck(\"for_admission\",";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =");\'         value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="></td>\n\t\t\t <td  width=\'15%\' class=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" ><input type=\'checkbox\' class=\'fields\'  name=\'cancel_for_admission";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'cancel_for_admission";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'   onclick=\'Checkboxcheck(\"cancel_for_admission\",";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =");\'  value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" ><input type=\'checkbox\' class=\'fields\'  name=\'Modify_referral";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'Modify_referral";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'       id=\'Modify_referral";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'         onclick=\'Checkboxcheck(\"Modify_referral\",";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =");\'        value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="></td>\n\t\t\t ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t <!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Ends-->\n\t\t\t</tr>\n\t\t\t\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n<input type=\'hidden\' name=\'noOfRecords\' id=\'noOfRecords\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t</table> \n    </form>\n\t</body>\n\t\n \n  \n\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t</html>\n\n\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

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
//String locale = (String)session.getAttribute("LOCALE");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
     Connection con 					= null;
	 java.sql.Statement stmt			= null; 
	 ResultSet reslt			        = null;  
	 ResultSet reslt1			        = null;  
	 ResultSet reslt2			        = null;  
	 PreparedStatement pstmt			= null;
	 String mode						= "";
	 String	facilityId 					= (String) session.getValue( "facility_id" ) ;



try
  {
     con	= ConnectionManager.getConnection(request);
  
	 String enable_rights = "";
	 int noOfRecords = 0;
	 int counter= 0;
	 String classValue= "";
	 String insert_disable   = "";
	 String cons_yn_check     = "";
	 String sec_triag_yn_check   = "";
	 String sec_triag_yn   = "";
	 
	 //<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
	 boolean isPendingForAdmissionAppl=false;
	 isPendingForAdmissionAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");
			 
	 String Modify_referral_yn="";
	 String cancel_for_admission_yn="";
	 String for_admission_yn="";
	 
	 String Modify_referral_yn_chk="";
	 String cancel_for_admission_yn_chk="";
	 String for_admission_yn_chk="";
	 //<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Ends-->
	 
	 String cons_yn   = "";
	 String desc_sysdef ="";
	 String pract_type ="";
	 String update_disable ="";
	 /*Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
	 String reg_new_born_yn_chk   = "";
	 String reg_new_born_yn		 = "";
	 String inv_reg_new_born_yn		 = "N";
	/*Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/
try
	  {
	      String AcessSql   = "SELECT ENABLE_ACCS_RIGHTS_IN_QUEUE,INV_REG_NEW_BORN_YN FROM AE_PARAM WHERE MODIFIED_FACILITY_ID=? ";
		  pstmt=con.prepareStatement(AcessSql);
		  pstmt.setString(1,facilityId);
		  reslt=pstmt.executeQuery();
		
    if(reslt != null && reslt.next()) 
	{
	  enable_rights	 = (reslt.getString("ENABLE_ACCS_RIGHTS_IN_QUEUE"));
	  inv_reg_new_born_yn	 = (reslt.getString("INV_REG_NEW_BORN_YN"));
	}
		if (enable_rights.equals("N")|| enable_rights.equals("") || enable_rights.equals(null) )
		  {
            _bw.write(_wl_block8Bytes, _wl_block8);
}

		else 
		 {
		String AccessSql0="SELECT COUNT(*) count FROM AE_ACCS_RIGHTS_BY_PRAC_TYPE";
		pstmt = null;
		pstmt=con.prepareStatement(AccessSql0);
		reslt1 =null;
        reslt1=pstmt.executeQuery();
		 reslt1.next();
		if( ((String)reslt1.getString("COUNT")).equals("0"))
		{
   		 String AccessSql1="SELECT PRACT_TYPE, DESC_SYSDEF FROM AM_PRACT_TYPE WHERE EFF_STATUS = 'E' ORDER BY DESC_SYSDEF ";
		 stmt= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 reslt2 = stmt.executeQuery(AccessSql1) ;
    	 mode="INSERT";
	 	}
		
		else 
	    {
		  //REG_NEW_BORN_YN Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148]
		  String AccessSql2="SELECT B.PRACT_TYPE PRACT_TYPE, A.DESC_SYSDEF DESC_SYSDEF,B.SEC_TRIAG_YN SEC_TRIAG_YN ,B.CONS_YN CONS_YN,B.REG_NEW_BORN_YN REG_NEW_BORN_YN,B.FOR_ADMISSION_YN FOR_ADMISSION_YN,B.CANCEL_FOR_ADMISSION_YN CANCEL_FOR_ADMISSION_YN,B.MODIFY_REFERRAL_YN MODIFY_REFERRAL_YN FROM AM_PRACT_TYPE A,AE_ACCS_RIGHTS_BY_PRAC_TYPE B WHERE  B.PRACT_TYPE=A.PRACT_TYPE  ORDER BY DESC_SYSDEF";
		  stmt= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		  reslt2 = stmt.executeQuery(AccessSql2) ;
		  mode= "UPDATE"; 
					
        }

		  while(reslt2.next())
		  noOfRecords = noOfRecords + 1;
          reslt2.beforeFirst();
           
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
if("Y".equals(inv_reg_new_born_yn)) {
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
if(isPendingForAdmissionAppl){ 
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);

		int i = 1;
		while(reslt2.next()) 
		{
		counter++ ;
		if ( counter % 2 == 0 )
		  	classValue = "QRYODD" ;
		else
		  	classValue = "QRYEVEN" ;
		if(mode.equals("INSERT"))
		{
            pract_type=reslt2.getString("PRACT_TYPE");
		    desc_sysdef=reslt2.getString("DESC_SYSDEF");
			insert_disable="disabled";
		}
		
		else if(mode.equals("UPDATE"))
		{  
			sec_triag_yn=reslt2.getString("SEC_TRIAG_YN");
			cons_yn=reslt2.getString("CONS_YN");
			reg_new_born_yn=reslt2.getString("REG_NEW_BORN_YN");
            pract_type=reslt2.getString("PRACT_TYPE");
            desc_sysdef=reslt2.getString("DESC_SYSDEF");
            
          // <!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
	          for_admission_yn=reslt2.getString("FOR_ADMISSION_YN");
	          cancel_for_admission_yn=reslt2.getString("CANCEL_FOR_ADMISSION_YN");
	          Modify_referral_yn=reslt2.getString("MODIFY_REFERRAL_YN");
	         if(for_admission_yn.equals("Y")){for_admission_yn_chk="checked";}
	         else{for_admission_yn_chk="";}
	         
	         if(cancel_for_admission_yn.equals("Y")){ cancel_for_admission_yn_chk="checked";}
	         else{ cancel_for_admission_yn_chk="";}
	         
	         if(Modify_referral_yn.equals("Y")) { Modify_referral_yn_chk="checked"; }
	         else{ Modify_referral_yn_chk="";}
	        // <!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Ends-->
	         

			if(sec_triag_yn.equals("Y")) {
				 sec_triag_yn_check="checked"; 
				 update_disable="";
			} else { 
				update_disable="disabled";
				sec_triag_yn_check="";
			}

			if(cons_yn.equals("Y")) {
				 cons_yn_check="checked"; 
			}else {
				cons_yn_check="";
				
			}

			/*Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
			reg_new_born_yn_chk	 = "";
			if("Y".equals(reg_new_born_yn)){
				reg_new_born_yn_chk = "checked";
			}
			/*Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/


	
		}
 
		
    
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(desc_sysdef));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sec_triag_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sec_triag_yn_check));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(cons_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(cons_yn_check));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(insert_disable));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(update_disable));
            _bw.write(_wl_block36Bytes, _wl_block36);
if("Y".equals(inv_reg_new_born_yn)) {
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(reg_new_born_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(reg_new_born_yn_chk));
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block41Bytes, _wl_block41);
if(isPendingForAdmissionAppl){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(for_admission_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(for_admission_yn_chk));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(cancel_for_admission_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(cancel_for_admission_yn_chk));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(Modify_referral_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Modify_referral_yn_chk));
            _bw.write(_wl_block58Bytes, _wl_block58);
}
            _bw.write(_wl_block59Bytes, _wl_block59);

				i++ ;
	   
				

	   }
			 
	}
					if(pstmt != null) pstmt.close();
					if(reslt != null) reslt.close();
					if(reslt1 != null) reslt1 .close();
					if(reslt2 != null) reslt2 .close();
}
	  
		catch(Exception e) 
			{
					e.printStackTrace();

			}
	  
	   

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(noOfRecords));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block62Bytes, _wl_block62);

  } 

catch(Exception e)
	{ 
	e.printStackTrace();
	}
   finally
    {
    	if(con!=null)
	    ConnectionManager.returnConnection(con,request);
    }
	
            _bw.write(_wl_block63Bytes, _wl_block63);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionertype.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.SecondaryTriage.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Consultation.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.RegisterNewBornForAE.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.ForAdmission.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelForAdmission.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.ModifyReferral.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
