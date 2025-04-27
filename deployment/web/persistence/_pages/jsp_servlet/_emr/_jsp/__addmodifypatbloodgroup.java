package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;

public final class __addmodifypatbloodgroup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AddModifyPatBloodGroup.jsp", 1722863375040L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="   \n    \n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n  <script>\n /* function checkN()\n  {\n    if(document.PatBloodGroup_form.siccn.checked)\n   {\n     document.PatBloodGroup_form.siccp.checked=false;\n     document.PatBloodGroup_form.radioval.value=\'N\';\n   }\n }  \n \n function checkP()\n  {\n   if(document.PatBloodGroup_form.siccp.checked)\n   {\n     document.PatBloodGroup_form.siccn.checked=false;\n     document.PatBloodGroup_form.radioval.value=\'P\';\n  }\n } */\n\n function clearresultPage(){\n\t parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\n }\n\n  </script>\n </head>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<body onload=\'FocusFirstElement();\'  OnMouseDown=\'CodeArrest();\' onKeyDown = \'lockKey()\'>\n<form name=\'PatBloodGroup_form\' id=\'PatBloodGroup_form\' method=\'POST\' action=\'../../servlet/eMR.PatBloodGroupServlet\' target=\'messageFrame\'>\n         <BR><BR><BR><BR><BR><BR><BR><table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'75%\' align=\'center\'>\n            <tr>\n\t\t\t<td colspan=\'2\' class=\'label\'>&nbsp;</td></tr>\n\t\t\t<tr>\n\t\t  \t<td class=\"label\" width=\'50%\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t   \t<td class=\'fields\' width=\'50%\'>\n\t\t  \t\t<select name=\'blood_group\' id=\'blood_group\' ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" ><option value=\'\' >------";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="-------</option>\n\t\t\t\t    ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\t\t  \t\t</select><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t  \t</td>\n\t\t  </tr>\n\t\t    <tr>\n\t\t      <td class=\'label\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t      <td class=\'fields\'>\n\t\t        <select name=\'rf_code\' id=\'rf_code\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="-----</option>\n\t\t          ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t        </select><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t      </td> \n\t\t   </tr>\n          <tr ><td class=\"COLUMNHEADER\" colspan=\'2\'><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</b></td></tr>\n          <tr>  \n               <td class=\"label\" >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t \t   \n\t\t  \t<td class=\'fields\'>\n\t\t  \t\t<select name=\'g6pd_marker\' id=\'g6pd_marker\'>\n\t\t\t\t\t<option value=\"\">------";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="-----</option>\n\t\t\t\t    ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\n\t\t  \t\t</select>\n\t\t  \t</td>\n\t\t  </tr>\n\t\t  <tr>\n\t\t      <td class=\'label\' >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t      <td  class=\'fields\'>\n\t\t \t\t<select name=\'sicc_marker\' id=\'sicc_marker\'>\n\t\t\t\t<option value=\"\">------";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="-----</option>\n \t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t</td> \n\t\t   </tr>\n            <tr>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td  class=\'button\'><input type=\'button\' align=\'right\' name=\'record\' id=\'record\' onclick=\"parent.apply()\" class=\'button\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" class=\'button\'><input type=\'button\' align=\'right\' name=\'clear\' id=\'clear\' onclick=\"parent.clearform()\" class=\'button\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'class=\'button\'><input type=\'button\' align=\'right\' name=\'cancel\' id=\'cancel\' onclick=\"parent.blank()\" class=\'button\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" class=\'button\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td colspan=\'2\' class=\'label\'>&nbsp;</td>\n\t\t</tr>\n\t\n\t</table>\n\t\n      <input type=\'hidden\' name=\'function\' id=\'function\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n      <input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n      <input type=\'hidden\' name=\'patientid\' id=\'patientid\' value=\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" \"> \n      <input type=\'hidden\' name=\'radioval\' id=\'radioval\' value=\'P\'>\n  </form>\n  <script>\n\t\t  clearresultPage();\n\t\t  </script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection con=null;
    PreparedStatement pstmt=null;  
	//Statement stmt=null;
	PreparedStatement stmt=null;
    ResultSet rset=null;
    ResultSet rs=null;
 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	
  String PatientId = request.getParameter("P_Patient_Id");
  String locale    = (String)session.getAttribute("LOCALE"); 
 // String G6pdCol[] = {"--Select--","No Activity","Normal Activity","Partial Activity"};
 // String G6pdVal[] = {"","X","N","P"};
  String funcval="insert";
  String selectAttribute="";
  String selectAttribute1="";
//  String selectAttribute2="";
  String checkboxAttribute2="";
  String patbloodgrp="";
  String RHfactor="";
  String G6PDmarker="";
  String SICCmarker="";
  String sele="";

 
  
//  String sql1="select count(blood_grp) as total from mp_pat_oth_dtls where patient_id='"+PatientId+"'";
	String sql="select blood_grp, rh_factor, g6pd_marker, sicc_marker FROM MP_PAT_OTH_DTLS where patient_id=?";
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	

	try
	{	
		con=ConnectionManager.getConnection(request);
		//stmt=con.createStatement(); 
		stmt = con.prepareStatement(sql);
		stmt.setString(1,PatientId);
		rs=stmt.executeQuery();

		if (rs.next())
		{
			funcval="modify";
			patbloodgrp=rs.getString(1);
			if(patbloodgrp==null) patbloodgrp="";
				RHfactor=rs.getString(2);
			if(RHfactor==null) RHfactor="";
				G6PDmarker=rs.getString(3);
			if(G6PDmarker==null) G6PDmarker="";
				SICCmarker=rs.getString(4);
			if(SICCmarker==null) SICCmarker="";
			//if(SICCmarker.equals("N"))  checkboxAttribute1="checked";
			//if(SICCmarker.equals("P"))  checkboxAttribute2="checked";
		}
		else {
			    checkboxAttribute2="checked";     
	    	 } 
		
		int count = 0;
		String dis_blood_grp = "";
		String sql2="select count(1) from bt_patient_blgrp_rh_ant where patient_id =? ";			
		stmt = con.prepareStatement(sql2);
		stmt.setString(1,PatientId);
		rs=stmt.executeQuery();
		if (rs != null) {
			while(rs.next() ) {
				count = rs.getInt(1);
			}
		} 
		rs.close();								
		if(count > 0)
		dis_blood_grp = "disabled";								

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(dis_blood_grp));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

				     try {
						/*
							Added on 6/14/2010 For PE.
							The execution of the below query was changed to PreparedStatement from Statement. 
						*/
						String BLD_GRP_SQL="SELECT  BLOOD_GRP , SHORT_DESC  FROM MR_BLOOD_GRP_LANG_VW  WHERE EFF_STATUS=? AND LANGUAGE_ID=?" ;
						pstmt = con.prepareStatement(BLD_GRP_SQL);
						pstmt.setString(1,"E");
						pstmt.setString(2,locale);
						//rs = pstmt.executeQuery("select blood_grp,short_desc from mr_blood_grp where eff_status='E'");
						rs = pstmt.executeQuery();
						if (rs != null) {
							while(rs.next() ) {
								String BloodGroup = rs.getString("BLOOD_GRP");
								String ShortDesc = rs.getString("SHORT_DESC");
							if(funcval.equals("modify")){
								if(BloodGroup.equals(patbloodgrp)){
									selectAttribute="selected";
								}else{ 
									selectAttribute="";	
								}
							} 
								out.println("<option value ='"+BloodGroup+"' "+selectAttribute+">"+ShortDesc);
							}
						}
			           	   if(rs != null) rs.close();
   			           	   if(pstmt != null) pstmt.close();
				       }catch(Exception e) {
				              e.printStackTrace();
				       }
				       finally {
						   try{
				                if (rs != null) rs.close();
				                if (pstmt != null) pstmt.close();
						   }catch(Exception e) {}
				       }
				     
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(dis_blood_grp));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

		            try{
						String RHD_SQL="SELECT RHESUS_FACTOR_CODE, SHORT_DESC FROM MR_RHESUS_FACTOR_LANG_VW  WHERE EFF_STATUS=? AND LANGUAGE_ID=?"; 
						pstmt = con.prepareStatement(RHD_SQL);
						pstmt.setString(1,"E");
						pstmt.setString(2,locale);
						rs = pstmt.executeQuery();
						if(rs!= null) {
							while(rs.next()) {
								if(funcval.equals("modify")){
									if(rs.getString("RHESUS_FACTOR_CODE").equals(RHfactor)){
										selectAttribute1="selected";
									}else{ 
										selectAttribute1="";	 
									}
								} 
								out.println("<option value='" + rs.getString("RHESUS_FACTOR_CODE") + "' "+selectAttribute1+">"+ rs.getString("SHORT_DESC"));
							}
						}
		            }catch(Exception e) {
		                   e.printStackTrace();
		            }
		            finally {
						try{
		                     if (rs!= null) rs.close();
		                     if (pstmt != null) pstmt.close();
						}catch(Exception e) {}
		            }
		          
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

  			           	   if(rs != null) rs.close();
   			           	   if(pstmt != null) pstmt.close();
						   String G6PD_SQL="SELECT DISCR_MSR_ID, A.REF_RNG_DESC FROM AM_DISCR_MSR_RF_RNG_LS_LANG_VW A, MR_PARAMETER B WHERE A.DISCR_MSR_ID=B.G6PD_DISCR_MSR_ID AND A.LANGUAGE_ID =? ORDER BY A.SORT_ORDER";
						   pstmt =con.prepareStatement(G6PD_SQL);
						   pstmt.setString(1,locale);
							rs = pstmt.executeQuery();
						  // rs = pstmt.executeQuery("select discr_msr_id, a.ref_rng_desc from am_discr_msr_ref_rng_list a,mr_parameter b where a.discr_msr_id=b.g6pd_discr_msr_id and rownum< 2 order by a.sort_order ");
   				           //rs = pstmt.executeQuery("select ref_rng_desc from am_discr_msr_ref_rng_list a,mr_parameter b where a.discr_msr_id=b.sicc_discr_msr_id order by a.sort_order  ");

						  // rs = pstmt.executeQuery("select discr_msr_id, a.ref_rng_desc from AM_DISCR_MSR_RF_RNG_LS_LANG_VW a, MR_PARAMETER b where a.discr_msr_id=b.g6pd_discr_msr_id and a.language_id = '"+locale+"' and rownum< 2 order by a.sort_order");

						  //modified on 10-06-08 for SPR 3994
//						  rs = pstmt.executeQuery("select discr_msr_id, a.ref_rng_desc from AM_DISCR_MSR_RF_RNG_LS_LANG_VW a, MR_PARAMETER b where a.discr_msr_id=b.g6pd_discr_msr_id and a.language_id = '"+locale+"' order by a.sort_order"); 
								if (rs != null){
									while(rs.next() ){
										sele="";
										String ssp=rs.getString("ref_rng_desc");if(ssp==null)ssp="";
										String g6pd_val=rs.getString("discr_msr_id");if(g6pd_val==null)g6pd_val="";
										/*if(G6PDmarker.equals(g6pd_val))sele="selected";
										out.println("<option "+sele+" value='"+g6pd_val+"'>"+ssp+"</option>");*/
										////modified for SCR #5301  on 9-9-8
										if(funcval.equals("modify")){
											//if(G6PDmarker.equals(g6pd_val))
											if(G6PDmarker.equals(ssp)){
												sele="selected";
											}else{
												sele="";
											}
										}
										out.println("<option "+sele+" value='"+ssp+"'>"+ssp+"</option>");
									}
								}
  			           	   if(rs != null) rs.close();
   			           	   if(pstmt != null) pstmt.close();

				     
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
 	
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					String SICC_SQL="SELECT DISCR_MSR_ID, A.REF_RNG_DESC FROM AM_DISCR_MSR_RF_RNG_LS_LANG_VW A,MR_PARAMETER B WHERE A.DISCR_MSR_ID = B.SICC_DISCR_MSR_ID AND A.LANGUAGE_ID =? ORDER BY A.SORT_ORDER";
					pstmt = con.prepareStatement(SICC_SQL);
					pstmt.setString(1,locale);
					rs = pstmt.executeQuery();
					//rs = pstmt.executeQuery("select discr_msr_id, a.ref_rng_desc from am_discr_msr_ref_rng_list a,mr_parameter b where a.discr_msr_id=b.sicc_discr_msr_id and rownum < 2 order by a.sort_order  ");
					//rs = pstmt.executeQuery(" select discr_msr_id, a.ref_rng_desc from AM_DISCR_MSR_RF_RNG_LS_LANG_VW a,MR_PARAMETER b where a.discr_msr_id = b.sicc_discr_msr_id and a.language_id = '"+locale+"' and rownum < 2 order by a.sort_order");
					//modified on 10-06-08 for SPR 3994
//					rs = pstmt.executeQuery(" select discr_msr_id, a.ref_rng_desc from AM_DISCR_MSR_RF_RNG_LS_LANG_VW a,MR_PARAMETER b where a.discr_msr_id = b.sicc_discr_msr_id and a.language_id = '"+locale+"' order by a.sort_order");
						if (rs != null) {
							while(rs.next()){
							sele="";
							String ssp=rs.getString("ref_rng_desc");if(ssp==null)ssp="";
							String sicc_val=rs.getString("discr_msr_id");if(sicc_val==null)sicc_val="";
							/*if(SICCmarker.equals(sicc_val))sele="selected";
							out.println("<option "+sele+" value='"+sicc_val+"'>"+ssp+"</option>");*/
							//modified for SCR #5301  on 9-9-8
							if(funcval.equals("modify")){
								if(SICCmarker.equals(ssp)){
								sele="selected";
								}else{
									sele="";
								}
							}
							out.println("<option "+sele+" value='"+ssp+"'>"+ssp+"</option>");
							}
						}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(funcval));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(funcval));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( PatientId ));
            _bw.write(_wl_block29Bytes, _wl_block29);

}
   catch(Exception e){/* out.println(e.toString()+" P_Patient_Id "+PatientId); */e.printStackTrace();}
   finally
   {
	   ConnectionManager.returnConnection(con,request);
   }

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bloodgroup.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RHDFactor.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.GeneticMarkers.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.g6pd.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.sicc.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
