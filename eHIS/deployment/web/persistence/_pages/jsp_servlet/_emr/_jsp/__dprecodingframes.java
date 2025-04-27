package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.StringTokenizer;
import java.util.TreeMap;
import eCommon.XSSRequestWrapper;

public final class __dprecodingframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DPRecodingFrames.jsp", 1737633458200L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eMR/js/DPRecoding.js\'></script>\n \n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script>alert(getMessage(\"NO_SELECTION\",\"MR\")); \n\t\t\twindow.close();\n\t\t\t\n\t\t</script>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<html>\n\t<head>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"></link>\n\t</head>\n\t<title>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</title>\n\t<body  class=\"relativePosition\" >\n\t<form name =\'DiagProcRecoding\' method=\'post\'>\n <!--In Below frames speciality added by venkatesh.s against HAS-CRF-300 -->\n\t<!--<frameset rows=\"7%,*,5%,0%\">-->\n\t\t<iframe name=\'PLINE\' id=\'PLINE\' src=\'../../eCommon/jsp/pline.jsp?Facility_Id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&EncounterId=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' noresize  frameborder=0 scrolling=\'no\' style=\'height:8vh;width:100vw\'></iframe>\n\n\t\t<!--<frameset cols=\"22%,*\">-->\n\t\t\t<iframe name=\"DiagProcRecodingPatDetail\" id=\"DiagProcRecodingPatDetail\" frameborder=\"no\" scrolling=\"auto\" noresize src=\'../../eMR/jsp/DPRecodingPatDetail.jsp?stage_no=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&enc_val=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&finalSelect1=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&dflt_termset=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&Patient_Class=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&curr_level=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&L1_hdr_status=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&L2_hdr_status=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&L3_hdr_status=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&hdr_modified_dt=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&specialty_code=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' style=\'height:32vh;width:20vw\'>\n\t\t\t</iframe>\n\n<!-- \t\t\t<frameset rows=\"47%,47%,5%,0%\" name=\"RecodeScreen\"> -->\t\t\t\t\n\t\t\t\t<!--<frameset rows=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" name=\"RecodeScreen\">\t-->\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t<iframe name=\"RecDiagnosisDiag\" id=\"RecDiagnosisDiag\" frameborder=\"no\" scrolling=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" noresize src=\"../../eMR/jsp/DPRecodingDiag1.jsp?stage_no=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&Pat_id=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&mode=Y&dflt_termset=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" style=\'height:37vh;width:77vw\'>\n\t\t\t\t\t</iframe>\n\n\t\t\t\t\t<iframe name=\"RecDiagnosisProc\"  id=\"RecDiagnosisProc\" frameborder=\"no\" scrolling=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" noresize src=\"../../eMR/jsp/DPRecodingProc1.jsp?stage_no=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" style=\'height:41vh;width:85vw ;margin-left: 232px\'>\n\t\t\t\t\t</iframe>\n\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="  noresize src=\"../../eMR/jsp/DPRecodingProc1.jsp?stage_no=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" style=\'height:41vh;width:85vw;margin-left: 232px\'>\n\t\t\t\t\t</iframe>\n\n\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\t\n\t\t\t\t\t<iframe name=\"RecDiagnosisDiag\"  id=\"RecDiagnosisDiag\" frameborder=\"no\" scrolling=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" style=\'height:37vh;width:77vw\'></iframe>\n\n\t\t\t\t\t<iframe name=\"RecDiagnosisProc\" id=\"RecDiagnosisProc\" frameborder=\"no\" scrolling=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t<iframe name=\"RecDiagnosisButton\" id=\"RecDiagnosisButton\" frameborder=\"no\" scrolling=\"auto\" noresize src=\"../../eMR/jsp/DPRecodingButton.jsp?confirm_appl=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&pat_class=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&stage_no=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&hdr_modified_dt_qr=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&execute_hdr_qry=N\" style=\'height:4vh;width:99vw\'></iframe>\n\t\t\t\t<iframe src=\'../../eCommon/html/blank.html\' name=\'DiagProcTrans\' id=\'DiagProcTrans\' noresize frameborder=\"no\" scrolling=\'auto\'  style=\'display:none;height:20vh;width:79vw; margin-left: 232px;\'></iframe>\n\n\t\t\t<!--</frameset>-->\n\t\t<!--</frameset>-->\n\t\t\t<iframe src=\'../../eCommon/jsp/error.jsp\' name=\'messageFrame\' id=\'messageFrame\' noresize frameborder=0 scrolling=\'auto\' style=\'height:6vh;width:100vw\'></iframe>\n\t\t\t<iframe src=\'../../eCommon/jsp/error.jsp\' name=\'submitFrame\' id=\'submitFrame\' noresize frameborder=0 scrolling=\'auto\' style=\'height:0vh;width:100vw\'></iframe>\n\t<!--</frameset>-->\n\t</form>\n\t</body>\n\n\t</html>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

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
 String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
            _bw.write(_wl_block6Bytes, _wl_block6);
 
getServletConfig().getServletContext().removeAttribute("blocked");
ArrayList encounterLIst=null;
ArrayList patientLIst=null;
Connection conn = ConnectionManager.getConnection(request);	 
PreparedStatement pstmt		= null;
ResultSet rs				= null;
 
try{ 
	
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facilityId		= (String)session.getValue("facility_id");
	String loginUser		= (String) session.getValue( "login_user" );
/* In Below line specialty_code added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/	
	String specialty_code     =""; 


	


	RecordSet	MedicalReportReq	=	null;
	String	from	=	"",	to		=	"";
	//String checkedOnes = "";
	from		=	(request.getParameter("from")==null)	?	"0"	:	request.getParameter("from");
	to			=	(request.getParameter("to")==null)		?	"0"	:	request.getParameter("to");
	//String fetchrecord=	(request.getParameter("fetchrecord")==null)		?	""	:	request.getParameter("fetchrecord");


	MedicalReportReq	=	(webbeans.eCommon.RecordSet)	session.getAttribute("MedicalReportReq");
	encounterLIst=new ArrayList();
	patientLIst=new ArrayList();
	String str = "";

	StringBuffer finalvals=new StringBuffer();

	for(int y=0;y<MedicalReportReq.getSize();y++){
		finalvals.append((String)MedicalReportReq.getObject(y)+"~");
	}
	
	StringTokenizer st_final = new StringTokenizer(finalvals.toString(),"~");
	while(st_final.hasMoreTokens()){
		str = st_final.nextToken();
		StringTokenizer st1 = new StringTokenizer(str,"`");
		String nxt_tkn="";
		while(st1.hasMoreTokens()){
			nxt_tkn=st1.nextToken();
			patientLIst.add( nxt_tkn);
			nxt_tkn=st1.nextToken();
			encounterLIst.add(nxt_tkn);
			


		}	
	}

	String enc_val = "";
	String enc_temp1 = "";
	String enc_temp = "";
	String pat_temp = "";
	String pat_temp1 = "";
	String finalSelect1 = "";
	String enc1 = "";
	String objName = "";
	String pat_line = "";
	String dflt_termset = "";
	String pid = "";
	String pat_class = "";
	int Stage_no = 0;
	String confirm_appl = ""; // added by mujafar for ML-MMOH-CRF-0878
	enc_val= request.getParameter("enc_val");
	enc_temp1= request.getParameter("enc_temp");
	pat_temp1= request.getParameter("pat_temp");
	finalSelect1= request.getParameter("finalSelect1");
	String allow_recode_diag_yn = "";
	String allow_recode_proc_yn = "";
	String allow_ot_proc_recode_yn = "";
	String allow_non_ot_proc_recode_yn = "";
	String drg_calculation_yn = "";//Added On 4/21/2010 For PE Tuning This value wil pass to all the Recodingpages

	if(enc_temp1.equals("") &&  pat_temp1.equals("") && MedicalReportReq.getSize()== 0){
            _bw.write(_wl_block7Bytes, _wl_block7);
}

	//out.println("<script>alert(\"in new pat_temp :"+pat_temp+"\");</script>");
	
	String sql2="SELECT   ALLOW_RECODE_DIAG_YN ,ALLOW_RECODE_PROC_YN , ALLOW_OT_PROC_RECODE_YN, ALLOW_NON_OT_PROC_RECODE_YN,nvl(DRG_CALCULATION_YN,'N') DRG_CALCULATION_YN FROM MR_PARAMETER";
	pstmt = conn.prepareStatement(sql2);
	rs = pstmt.executeQuery();	
		
	while(rs.next()){
		allow_recode_diag_yn					= rs.getString("ALLOW_RECODE_DIAG_YN");
		allow_recode_proc_yn					= rs.getString("ALLOW_RECODE_PROC_YN");
		allow_ot_proc_recode_yn			= rs.getString("ALLOW_OT_PROC_RECODE_YN");
		allow_non_ot_proc_recode_yn	= rs.getString("ALLOW_NON_OT_PROC_RECODE_YN");
		drg_calculation_yn						= rs.getString("DRG_CALCULATION_YN");
	}
		
		
	
	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();

	
	//String sql20="SELECT STAGE_NO FROM MR_RECODE_PRIVI_SETUP_DTL WHERE APPL_USER_ID='"+loginUser+"' AND FACILITY_ID='"+facilityId+"'";
	String sql20="SELECT CONFIRM_APPL,stage_no from MR_RECODE_PRIVI_SETUP where stage_no in ((select STAGE_NO FROM MR_RECODE_PRIVI_SETUP_DTL WHERE APPL_USER_ID=? AND FACILITY_ID=?))" ;
		//  added by mujafar for ML-MMOH-CRF-0878
		pstmt = conn.prepareStatement(sql20);
		pstmt.setString(1,loginUser);
		pstmt.setString(2,facilityId);
		rs = pstmt.executeQuery();	
	
	while(rs.next()){
		Stage_no = rs.getInt("STAGE_NO");
		confirm_appl=rs.getString("CONFIRM_APPL"); // added by mujafar for ML-MMOH-CRF-0878
	}
		
		
	
	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();

	if(Stage_no == 0){
		
		String sql_st="SELECT STAGE_NO FROM MR_RECODE_PRIVI_SETUP WHERE SPECIFIC_IND='*ALL' ORDER BY  STAGE_NO DESC";
		pstmt = conn.prepareStatement(sql_st);

		rs = pstmt.executeQuery();	
			
		if(rs.next()){
			Stage_no = rs.getInt("STAGE_NO");

		}
			
			
		
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();

	}


	
	String sql3="SELECT  TERM_SET_ID FROM mr_term_set WHERE RECODERS_APPL_YN='Y' AND ADDED_FACILITY_ID=?";
		pstmt = conn.prepareStatement(sql3);
		pstmt.setString(1,facilityId);
		rs = pstmt.executeQuery();	
	
	while(rs.next()){
		dflt_termset = rs.getString("TERM_SET_ID");
	}
	

	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();
		
	
	
				

	StringTokenizer st=new StringTokenizer(enc_val,"~");
	int temp=st.countTokens();

	for(int u2=0;u2<temp;u2++){

		String st2=st.nextToken();
		StringTokenizer st1=new StringTokenizer(st2,"$");

		enc1=st1.nextToken();

		objName=st1.nextToken();

		if(u2 == 0)
			pat_line=enc1;


	}


	String eval1="";
	String eval2="";
	int r= 0;




	StringTokenizer e1=new StringTokenizer(enc_temp1,",");
	int temp1=e1.countTokens();
	for(int v2=0;v2<temp1;v2++){

		String st2=e1.nextToken();
		StringTokenizer st1=new StringTokenizer(st2,"$");
		eval1=st1.nextToken();
		eval2=st1.nextToken();

		if(eval2.equals("E")){
			if(r == 0){
				enc_temp=eval1;
			}else{
				enc_temp=enc_temp+","+eval1;
			}
		
		}
		r++;
	
	}


	String etemp = "";
	int t=0;
	if(encounterLIst.size() != 0){
		//for (Iterator iter = encounterLIst.iterator();    iter.hasNext(); ) {
		int jj=encounterLIst.size()-1;
		for( int j=jj;j>=0;j--){

			if(!enc_temp.equals("")){
				//etemp=",";
				etemp="";
			}

			//String nxt_itr_enc=(String)iter.next();
			String nxt_itr_enc=(String)encounterLIst.get(j);
			if(j==0){
				pat_line=nxt_itr_enc;
			}
			etemp=etemp+"'"+nxt_itr_enc+"',";
			//enc_temp=enc_temp+etemp;
			enc_temp=etemp+enc_temp;
	
			if(t != 0){
				enc_temp=enc_temp+",";
			}
		}
		  if(enc_temp.endsWith(",")){
				enc_temp=enc_temp.substring(0,enc_temp.lastIndexOf(','));//Modified on 10/7/2009;
		  }
//		enc_temp=enc_temp.substring(0,enc_temp.lastIndexOf(','));//Modified on 10/7/2009;

	}
	
	/*String sql4="SELECT PATIENT_ID,PATIENT_CLASS FROM PR_ENCOUNTER WHERE ENCOUNTER_ID='"+pat_line+"' AND FACILITY_ID='"+facilityId+"'";
		pstmt = conn.prepareStatement(sql4);
		rs = pstmt.executeQuery();	
	
	while(rs.next()){
		pid = rs.getString("PATIENT_ID");
		pat_class = rs.getString("PATIENT_CLASS");
	}
	
	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();*/

		
	
		


	String pat1="";
	String pat2="";
	int r1= 0;

	StringTokenizer p1=new StringTokenizer(pat_temp1,",");
	int temp2=p1.countTokens();
	for(int v2=0;v2<temp2;v2++) {
		String st2=p1.nextToken();

		StringTokenizer st1=new StringTokenizer(st2,"$");
		pat1=st1.nextToken();
		pat2=st1.nextToken();
		if(pat2.equals("E")){
			if(r1 == 0){
				pat_temp=pat1;
			}else{
				pat_temp=pat_temp+","+pat1;
			}
			
		}
		r1++;
	
	}
		String ptemp = "";
		int u=0;
		if(patientLIst.size() != 0)	{
			//for (Iterator iter = patientLIst.iterator();    iter.hasNext(); ) {
			int kk=patientLIst.size()-1;
			for( int k=kk;k>=0;k--){
				if(!pat_temp.equals("")){
					//ptemp=",";
					ptemp="";
				}
				//String nxt_itr_pat=(String)iter.next();
				String nxt_itr_pat=(String)patientLIst.get(k);
				//ptemp=ptemp+"'"+nxt_itr_pat+"'"; 
				ptemp=ptemp+"'"+nxt_itr_pat+"',"; 
				//pat_temp=pat_temp+ptemp;
				pat_temp=ptemp+pat_temp;
				if(u != 0){
					pat_temp=pat_temp+",";
				}
			}
//			pat_temp=pat_temp.substring(0,pat_temp.lastIndexOf(','));//Modified on 10/7/2009;
		}

		String ENC_PAT_SQL="SELECT PATIENT_ID,ENCOUNTER_ID FROM PR_ENCOUNTER WHERE ENCOUNTER_ID IN ("+enc_temp+") AND FACILITY_ID=? ORDER BY VISIT_ADM_DATE_TIME asc";
		pstmt = conn.prepareStatement(ENC_PAT_SQL);
		//pstmt.setString(1,enc_temp);
		pstmt.setString(1,facilityId);
		rs = pstmt.executeQuery();
		int cc=0;
		String rec_pat_temp="";
		String rec_enc_temp="";
		String enc_temp_ses="";
		String pat_temp_ses="";
		while(rs.next()){
			rec_pat_temp = rs.getString("PATIENT_ID");
			rec_enc_temp = rs.getString("ENCOUNTER_ID");
			if(cc==0){
				pat_line =rec_enc_temp;
			}
			pat_temp_ses=pat_temp_ses+"'"+rec_pat_temp+"'"+",";
			enc_temp_ses=enc_temp_ses+"'"+rec_enc_temp+"'"+",";
			cc++;
		}
		enc_temp_ses=enc_temp_ses.substring(0,enc_temp_ses.length()-1);
		pat_temp_ses=pat_temp_ses.substring(0,pat_temp_ses.length()-1);
		session.setAttribute("patientList",pat_temp_ses);
		session.setAttribute("encountertList",enc_temp_ses);

	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();

/* In Below line specialty_code added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/	
	String sql4="SELECT PATIENT_ID,PATIENT_CLASS,SPECIALTY_CODE FROM PR_ENCOUNTER WHERE ENCOUNTER_ID=? AND FACILITY_ID=?";
	   
	    
		pstmt = conn.prepareStatement(sql4);
		pstmt.setString(1,pat_line);
		pstmt.setString(2,facilityId);
		rs = pstmt.executeQuery();	
	
	while(rs.next()){
		pid = rs.getString("PATIENT_ID"); 
		pat_class = rs.getString("PATIENT_CLASS"); 
		specialty_code	= rs.getString("SPECIALTY_CODE");
	}

	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();
/*The Query Was added on 4/26/2010 for PE*/
	String L1_hdr_status ="";
	String L2_hdr_status ="";
	String L3_hdr_status ="";
	String curr_level ="";
	String hdr_modified_dt ="";

	String sql_hdr_sts="SELECT CURR_LEVEL, nvl(LEVEL1_STATUS,'P') LEVEL1_STATUS,nvl(LEVEL2_STATUS,'P') LEVEL2_STATUS,nvl(LEVEL3_STATUS,'P') LEVEL3_STATUS,to_char(modified_date,'dd/mm/yyyy hh24:mi:sssss') MODIFIED_DATE FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID=? AND ENCOUNTER_ID=?";
	pstmt = conn.prepareStatement(sql_hdr_sts);
	pstmt.setString(1,facilityId);
	pstmt.setString(2,pat_line);
	rs = pstmt.executeQuery();	
	while(rs.next()){
		L1_hdr_status=rs.getString("LEVEL1_STATUS");
		L2_hdr_status=rs.getString("LEVEL2_STATUS");
		L3_hdr_status=rs.getString("LEVEL3_STATUS");
		curr_level		  =rs.getString("CURR_LEVEL");
		hdr_modified_dt=rs.getString("MODIFIED_DATE");
	}
	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();

String FrameSettings	="";
String DiagFrameScroll	 	="NO";
String ProcFrameScroll	 	="NO";
/*Based up on the Parameter SetUp frame Setting will Change*/
if(allow_recode_diag_yn.equals("Y")&& allow_recode_proc_yn.equals("Y")){
	FrameSettings	="48%,48%,4%,0%";
	DiagFrameScroll		="AUTO";
	ProcFrameScroll		="AUTO";
}else if(allow_recode_diag_yn.equals("Y")){
	FrameSettings	="95%,0%,5%,0";
	DiagFrameScroll		="AUTO";
}else if(allow_recode_proc_yn.equals("Y")){
	FrameSettings	="10%,85%,5%,0";
	ProcFrameScroll		="AUTO";
}
session.setAttribute("allow_recode_diag_yn",allow_recode_diag_yn);
session.setAttribute("allow_recode_proc_yn",allow_recode_proc_yn);
session.setAttribute("allow_ot_proc_recode_yn",allow_ot_proc_recode_yn);
session.setAttribute("allow_non_ot_proc_recode_yn",allow_non_ot_proc_recode_yn);
session.setAttribute("drg_calculation_yn",drg_calculation_yn);
/**Ends**/



            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pat_line));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Stage_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(enc_val));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(finalSelect1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dflt_termset));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(curr_level));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(L1_hdr_status));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(L2_hdr_status));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(L3_hdr_status));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(hdr_modified_dt));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(FrameSettings));
            _bw.write(_wl_block24Bytes, _wl_block24);

		
				if(Stage_no == 1){
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(DiagFrameScroll));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(Stage_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(pid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pat_line));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dflt_termset));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(curr_level));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(L1_hdr_status));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(L2_hdr_status));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(L3_hdr_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ProcFrameScroll));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Stage_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(pid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pat_line));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dflt_termset));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(curr_level));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(L1_hdr_status));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(L2_hdr_status));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(L3_hdr_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
}else if(Stage_no == 2){
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(DiagFrameScroll));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(Stage_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(pid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pat_line));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dflt_termset));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(curr_level));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(L1_hdr_status));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(L2_hdr_status));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(L3_hdr_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ProcFrameScroll));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(Stage_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(pid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pat_line));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dflt_termset));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(curr_level));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(L1_hdr_status));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(L2_hdr_status));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(L3_hdr_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
}else if(Stage_no == 3){
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(DiagFrameScroll));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(Stage_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(pid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pat_line));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dflt_termset));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(curr_level));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(L1_hdr_status));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(L2_hdr_status));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(L3_hdr_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(ProcFrameScroll));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Stage_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(pid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pat_line));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dflt_termset));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(curr_level));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(L1_hdr_status));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(L2_hdr_status));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(L3_hdr_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(confirm_appl));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(Stage_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(pid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pat_line));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(curr_level));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(L1_hdr_status));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(L2_hdr_status));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(L3_hdr_status));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(hdr_modified_dt));
            _bw.write(_wl_block40Bytes, _wl_block40);

}catch(Exception e){
	//out.println(e.toString());
	e.printStackTrace();
}finally{
	encounterLIst.clear(); 
	patientLIst.clear(); 
	if(conn != null) ConnectionManager.returnConnection(conn,request);

}


	
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisProcedureCode.label", java.lang.String .class,"key"));
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
}
