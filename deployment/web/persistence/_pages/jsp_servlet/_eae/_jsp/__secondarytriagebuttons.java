package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.lang.Math.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __secondarytriagebuttons extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/SecondaryTriageButtons.jsp", 1709113888756L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AESecondaryTriage.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>   \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body onKeyDown = \'lockKey()\'>\n<center>\n<form name=\'SecondaryTriageButtonsForm\' id=\'SecondaryTriageButtonsForm\' method=\'post\'>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' colspan=3 width=\"100%\">\n<tr><td colspan=3 class=label ></td></tr>\n<tr>\n<td colspan=\'3\' class=\"BUTTON\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<!--Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655-->\n\t<input type=\"button\" name=\"allergy_det\" id=\"allergy_det\" class=\"BUTTON\" value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' onClick=\'recAllergyDet();\' ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="> \n\t<input type=\"button\" name=\"visit_24hr\" id=\"visit_24hr\" class=\"BUTTON\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' onClick=\"showLastVisitDetails(\'LastVisit24\');\" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">\n\t<input type=\"button\" name=\"PrevEncounter\" id=\"PrevEncounter\" class=\"BUTTON\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' onClick=\"showPrevEncounter();\"  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" >\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<input type=button name=\'ChiefComplaints\' id=\'ChiefComplaints\' value= \'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'   onClick=\'ChiefComplaints_type()\'  class=\'Button\'  > \n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n<input type=button name=\'Record\' id=\'Record\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'   class=\'Button\'  onClick=\'apply1()\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" >\n<input type=button name=\'Reset\' id=\'Reset\' value= \'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'   onClick=\'resetpage()\'  class=\'Button\'  >  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="   \n      <input type=button name=\'Close\' id=\'Close\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'   onClick=\'close_func()\'  class=\'Button\' disabled>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t<input type=button name=\'Close\' id=\'Close\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'  onClick=\'close_func()\'  class=\'Button\' >\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n</td>\n</tr>\n</table>\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\'hidden\' name=\'query_string\' id=\'query_string\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\'hidden\' name=\'modify_flag\' id=\'modify_flag\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\'hidden\' name=\'called_from_ca\' id=\'called_from_ca\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<!--Added by Ashwini on 10-Apr-2018 for ML-MMOH-CRF-0652-->\n<input type=\'hidden\' name=\'isDiagDtlsSectionAppl\' id=\'isDiagDtlsSectionAppl\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\n</form>\n</center>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

    Connection con				      = null;  
    PreparedStatement pstmt		      = null;
	ResultSet rset				      = null;
	PreparedStatement pstmtEncounter  = null; 
    ResultSet rsetEncounter			  = null;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");


	String strQueryString      = request.getQueryString();
	String facilityId			= (String)session.getValue("facility_id");
	String patient_id = request.getParameter("patient_id");
//	String Dob = request.getParameter("Dob");
	String encounter_id  = request.getParameter("encounter_id");
	String called_from_ca      = request.getParameter("called_from_ca");
	if((called_from_ca==null) || (called_from_ca.equals("null")) || (called_from_ca=="") || (called_from_ca.equals("")))
	called_from_ca= "N";
	String alergyProp = "";
	String disRecord 			= "";
	String ca_install_yn		= "";
	String modify_flag			= request.getParameter("modify_flag")==null?"N":request.getParameter("modify_flag"); 
	if(modify_flag.equals("Y"))
	 {
		 disRecord ="disabled";
	 }
	//String last_encounter_id    = ""; Wednesday, May 05, 2010 venkats PE_EXE
	String EncounterProp        = "";
	String VisitProp            = "";
	
	//Added by Ashwini on 22-May-2017 for ML-MMOH-CRF-0650
	Boolean isReplacePresntngPrblmByChiefComp = true;

	Boolean isChngBtnPositionAppl = false;//Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655

	int countRecEnc             =  0;
	double prev_visit_hrs       = 0d;
	try{
		con = ConnectionManager.getConnection(request);

		  isReplacePresntngPrblmByChiefComp = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","REPLACE_PRE_PROB_BY_CHF_COMPL"); //Added by Ashwini on 22-May-2017 for ML-MMOH-CRF-0650

		  isChngBtnPositionAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","DIAGNOSIS_DTLS_IN_24HRS_VISIT");//Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655
	
		try
		 {
			 pstmt = con.prepareStatement("select install_yn from sm_module where module_id='CA' ");
			 rset = pstmt.executeQuery();
			 while(rset!=null  && rset.next())
			  {
				ca_install_yn		= rset.getString("install_yn");
			  }
			  if(rset!=null) rset.close();
			  if(pstmt!=null) pstmt.close();
		 }catch(Exception e)
		 {
			e.printStackTrace();
		 }
		 if(ca_install_yn.equals("Y"))
				alergyProp = "";
		 else {
				alergyProp = "disabled";
			}

/*
	StringBuffer displLastVisit = new StringBuffer();
	displLastVisit.append(" SELECT ENCOUNTER_ID from PR_ENCOUNTER where  ");
	displLastVisit.append(" VISIT_ADM_DATE_TIME = (SELECT max(visit_adm_date_time) ");
	displLastVisit.append(" from PR_ENCOUNTER where PATIENT_ID = ? and   ");
	displLastVisit.append(" VISIT_STATUS !='99'  and FACILITY_ID = ? and ");
	displLastVisit.append(" patient_class = 'EM' and ae_episode_yn='Y' ) ");
	displLastVisit.append(" and PATIENT_ID = ? and  VISIT_STATUS !='99' ");
	displLastVisit.append(" and FACILITY_ID = ? and patient_class='EM' and ");
	displLastVisit.append(" ae_episode_yn='Y'  ");
    try{
		   pstmt = con.prepareStatement(displLastVisit.toString());
		   pstmt.setString(1,patient_id);
		   pstmt.setString(2,facilityId);
		   pstmt.setString(3,patient_id);
		   pstmt.setString(4,facilityId);
		   rset = pstmt.executeQuery();
		   while(rset!=null && rset.next())
		   {
				last_encounter_id = rset.getString(1);
		   }
		   if(rset!=null) rset.close();
		   if(pstmt!=null) pstmt.close();
		   if((displLastVisit != null) && (displLastVisit.length() > 0))
		   {
				displLastVisit.delete(0,displLastVisit.length());
		   }
	 }catch(Exception e)
     {
        out.println("Exception in CAInstall ="+e);
     }

	 */
	 try
	  {	
	   StringBuffer sqlPr = new StringBuffer();
       sqlPr.append("select count(*) from pr_encounter where ");
	   sqlPr.append("facility_id= ?  and patient_id= ? and encounter_id !=? ");
	   pstmtEncounter = con.prepareStatement(sqlPr.toString());
       pstmtEncounter.setString(1,facilityId );
	   pstmtEncounter.setString(2,patient_id );
	   pstmtEncounter.setString(3,encounter_id );

	   rsetEncounter = pstmtEncounter.executeQuery();
		  while(rsetEncounter!=null && rsetEncounter.next())
				 {
				  countRecEnc=rsetEncounter.getInt(1);
				 }
		  if(rsetEncounter!=null) rsetEncounter.close();
		  if(pstmtEncounter!=null) pstmtEncounter.close();
		  if((sqlPr != null) && (sqlPr.length() > 0))
		  {
			sqlPr.delete(0,sqlPr.length());
		  }
		  if (countRecEnc==0)
		  {
			  EncounterProp = "disabled";
		  }else
		  {
			  EncounterProp ="";
		  }
	  }catch(Exception e) {e.printStackTrace();}

	   try
	  {	
	   StringBuffer prevEnc = new StringBuffer();
	   prevEnc.append("SELECT (SYSDATE - MAX (VISIT_STATUS_SET_ON_DATE)) ");
	   prevEnc.append(" * 24  PREV_VISIT_HRS FROM PR_ENCOUNTER WHERE  ");
	   prevEnc.append(" facility_id = ?  AND patient_id = ?  ");
	   prevEnc.append(" AND VISIT_STATUS in ('07', '09')   ");
	   pstmtEncounter = con.prepareStatement(prevEnc.toString());
       pstmtEncounter.setString(1, facilityId);
	   pstmtEncounter.setString(2, patient_id);

	   rsetEncounter = pstmtEncounter.executeQuery();
			  while(rsetEncounter!=null && rsetEncounter.next())
				 {
				  prev_visit_hrs = rsetEncounter.getDouble(1);
				 }
		  if(rsetEncounter!=null) rsetEncounter.close();
		  if(pstmtEncounter!=null) pstmtEncounter.close();
		  if((prevEnc != null) && (prevEnc.length() > 0))
		  {
			prevEnc.delete(0,prevEnc.length());
		  }
		  if(prev_visit_hrs > 24 || prev_visit_hrs == 0) {
			  VisitProp = "disabled";
		  }else if(prev_visit_hrs > 0 && prev_visit_hrs <= 24)
		  {
			  VisitProp ="";
		  }
	  }catch(Exception e) {e.printStackTrace();}

	}catch(Exception e){e.printStackTrace();}
	finally
     {
		ConnectionManager.returnConnection(con,request);
    }
	  
	 

            _bw.write(_wl_block8Bytes, _wl_block8);
 if(!isChngBtnPositionAppl){ 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllergyDetails.label","common_labels")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(alergyProp));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(VisitProp));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(EncounterProp));
            _bw.write(_wl_block15Bytes, _wl_block15);
 } 
            _bw.write(_wl_block1Bytes, _wl_block1);
if(!isReplacePresntngPrblmByChiefComp){ 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChiefComplaints.label","ca_labels")));
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(disRecord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);
 if(called_from_ca .equals("Y")) {
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block23Bytes, _wl_block23);
}else{
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strQueryString));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(modify_flag));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(called_from_ca));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(isChngBtnPositionAppl));
            _bw.write(_wl_block32Bytes, _wl_block32);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
