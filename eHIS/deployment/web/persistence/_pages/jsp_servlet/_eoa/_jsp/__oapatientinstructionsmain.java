package jsp_servlet._eoa._jsp;

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
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __oapatientinstructionsmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/OAPatientInstructionsMain.jsp", 1734690051334L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<title>\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t</title>\n\t\t<script src=\'../../eOA/js/OAPatientInstructions.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t</head>\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<!-- Passing Radiology Appt for PMG20089-CRF-0885.3-->\n\t<!--<frameset name=\'patinsmain\' id=\'patinsmainID\' rows=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>  -->\n\t\t<iframe name=\'patinstabframe\' id=\'patinstabframe\' style=\'height:";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =";width:100vw\' src=\'../../eOA/jsp/OAPatientInstructionsTabs.jsp?patInsTabYN=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&procInsTabYN=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&rd_appt_yn=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' frameborder=0 noresize scrolling=\'no\' marginheight=\'0\' marginwidth=\'0\'></iframe>\n\t\t<iframe name=\'patinsframe\' id=\'patinsframe\' style=\'height:";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =";width:100vw\' src=\'../../eOA/jsp/OAPatientInstructions.jsp?from_page=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&clinic_code=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&or_catalogue_code=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&pending_order_catalog_code=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&order_id=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&order_line_num=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&clinicInsYN=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&orderInsYN=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&orderInsStandardYN=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&patient_id=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&gender=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&date_of_birth=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&appt_refno=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&viewinsdtlsYN=N\' frameborder=0 noresize scrolling=\'auto\' marginheight=\'0\' marginwidth=\'0\'></iframe>\n\t\t<iframe name=\'patinsbuttonframe\' id=\'patinsbuttonframe\' style=\'height:";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =";width:100vw\' src=\'../../eOA/jsp/OAPatientInstructionsButtons.jsp?viewinsdtlsYN=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&from_page=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' frameborder=0 noresize scrolling=\'no\' marginheight=\'0\' marginwidth=\'0\'></iframe>\n\t<!--  </frameset> -->\n<!-- \t<frameset name=\'patinsmain\' id=\'patinsmainID\'>\n\t\t<frame name=\'patientinstructionsframe\' id=\'patientinstructionsframe\' src=\'../../eOA/jsp/OAPatientInstructions.jsp?clinic_code=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' frameborder=0 noresize scrolling=\'no\' marginheight=\'0\' marginwidth=\'0\'>\n\t</frameset> -->\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n</html>\n\n\t\n\n\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String patInsTabYN="";
		String procInsTabYN="";
		Connection connection = null;
		Statement stmt = null;
		ResultSet rset = null;
		PreparedStatement pstmt=null;
		HashMap prcInstructionMap=(java.util.HashMap)session.getAttribute("prcInstructionMap");
		String locale=(String)session.getAttribute("LOCALE");
		String facilityId = (String) session.getValue( "facility_id" ) ;
		String from_page=request.getParameter("from_page")==null?"":request.getParameter("from_page");		
		String clinicInsYN=request.getParameter("clinicInsYN")==null?"":request.getParameter("clinicInsYN");		
		String orderInsYN=request.getParameter("orderInsYN")==null?"N":request.getParameter("orderInsYN");		
		String orderInsStandardYN=request.getParameter("orderInsStandardYN")==null?"N":request.getParameter("orderInsStandardYN");		
		String clinic_code=request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");		
		String viewinsdtlsYN=request.getParameter("viewinsdtlsYN")==null?"N":request.getParameter("viewinsdtlsYN");
		String appt_refno=request.getParameter("appt_refno")==null?"":request.getParameter("appt_refno");
		String or_catalogue_code=request.getParameter("or_catalogue_code")==null?"":request.getParameter("or_catalogue_code");
		String pending_order_catalog_code=request.getParameter("pending_order_catalog_code")==null?"":request.getParameter("pending_order_catalog_code");
		String order_id=request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String order_line_num=request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
		String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String date_of_birth=request.getParameter("date_of_birth")==null?"":request.getParameter("date_of_birth");
		String gender=request.getParameter("gender")==null?"":request.getParameter("gender");
		String rows="";
		String height1="0vh";
		String height2="0vh";
		String height3="0vh";
		String rd_appt_yn = request.getParameter("rd_appt_yn")==null?"":request.getParameter("rd_appt_yn"); // Modified against PMG20089-CRF-0885.3
		try{
			if(from_page.equals("transfer_appt") || from_page.equals("modifyappt")){
				if(clinicInsYN.equals("Y") && orderInsYN.equals("Y")){
					//rows="5%,*,12%"; 
					height1="5vh";
					height2="80vh";
					height3="12vh";
					procInsTabYN="Y";
					patInsTabYN="Y";
				}else{
					//rows="0%,*,12%";
					height1="0vh";
					height2="84vh";
					height3="12vh";
				}
			}else if(from_page.equals("book_appt")){
				connection = ConnectionManager.getConnection(request);
				if(orderInsYN.equals("Y") && orderInsStandardYN.equals("Y")){
				}else if(orderInsYN.equals("Y") && orderInsStandardYN.equals("N")){
					if(orderInsYN.equals("Y") && orderInsStandardYN.equals("N")){
						if(or_catalogue_code!=null && !(or_catalogue_code.equals(""))){
							//String order_catalog_std_ins="select PAT_PREPS_OR_INSTRNS_IND,PAT_PREPS_OR_INSTRNS_TXT,CALC_MIN_AGE_IN_DAYS, CALC_MAX_AGE_IN_DAYS,SEX_SPEC_IND from or_catalog_prep_instrn_lang where ORDER_CATALOG_CODE='"+or_catalogue_code+"' and language_id='"+locale+"' AND sex_spec_ind in ('N','"+gender+"') and PAT_PREPS_OR_INSTRNS_IND ='IM' and trunc(sysdate)-to_date('"+date_of_birth+"','dd/mm/yyyy') between calc_min_age_in_days and calc_max_age_in_days";
							String order_catalog_std_ins="select PAT_PREPS_OR_INSTRNS_IND,PAT_PREPS_OR_INSTRNS_TXT,CALC_MIN_AGE_IN_DAYS, CALC_MAX_AGE_IN_DAYS,SEX_SPEC_IND from or_catalog_prep_instrn_lang where ORDER_CATALOG_CODE=? and language_id=? AND sex_spec_ind in ('N',?) and PAT_PREPS_OR_INSTRNS_IND ='IM' and trunc(sysdate)-to_date(?,'dd/mm/yyyy') between calc_min_age_in_days and calc_max_age_in_days";
							//stmt=connection.createStatement();
							//rset=stmt.executeQuery(order_catalog_std_ins);
							pstmt = connection.prepareStatement(order_catalog_std_ins);
							pstmt.setString(1,or_catalogue_code);
							pstmt.setString(2,locale);
							pstmt.setString(3,gender);
							pstmt.setString(4,date_of_birth);
							rset = pstmt.executeQuery();
							if(rset!=null && rset.next()){
								String pat_preps_or_instrns_txt=rset.getString("PAT_PREPS_OR_INSTRNS_TXT");
								String gender_ind=rset.getString("SEX_SPEC_IND");
								int calc_min_age_in_days=rset.getInt("CALC_MIN_AGE_IN_DAYS");
								int calc_max_age_in_days=rset.getInt("CALC_MAX_AGE_IN_DAYS");
								if(prcInstructionMap.size() > 0){
									int map_min_age=Integer.parseInt((String)(prcInstructionMap.get("min_age")==null?"0":prcInstructionMap.get("min_age")));
									int map_max_age=Integer.parseInt((String)(prcInstructionMap.get("max_age")==null?"0":prcInstructionMap.get("max_age")));
									String map_gender=(String)prcInstructionMap.get("sex_spec_ind");
									if((calc_min_age_in_days==map_min_age) && (calc_max_age_in_days==map_max_age)){
										if(!(gender_ind.equals(map_gender))){
											prcInstructionMap.put("prcIns",pat_preps_or_instrns_txt);
											prcInstructionMap.put("checked","Y");
											prcInstructionMap.put("min_age",(new Integer(calc_min_age_in_days)).toString());
											prcInstructionMap.put("max_age",(new Integer(calc_max_age_in_days)).toString());
											prcInstructionMap.put("sex_spec_ind",gender_ind);
											session.setAttribute("prcInstructionMap", prcInstructionMap);
										}
									}else{
										prcInstructionMap.put("prcIns",pat_preps_or_instrns_txt);
										prcInstructionMap.put("checked","Y");
										prcInstructionMap.put("min_age",(new Integer(calc_min_age_in_days)).toString());
										prcInstructionMap.put("max_age",(new Integer(calc_max_age_in_days)).toString());
										prcInstructionMap.put("sex_spec_ind",gender_ind);
										session.setAttribute("prcInstructionMap", prcInstructionMap);
									}
								}else{
									prcInstructionMap.put("prcIns",pat_preps_or_instrns_txt);
									prcInstructionMap.put("checked","Y");
									prcInstructionMap.put("min_age",(new Integer(calc_min_age_in_days)).toString());
									prcInstructionMap.put("max_age",(new Integer(calc_max_age_in_days)).toString());
									prcInstructionMap.put("sex_spec_ind",gender_ind);
									session.setAttribute("prcInstructionMap", prcInstructionMap);
								}
							}else{
								prcInstructionMap.clear();
								session.setAttribute("prcInstructionMap", prcInstructionMap);
							}
						}
					}
				}else{
					//rows="0%,*,12%";
					height1="0vh";
					height2="84vh";
					height3="12vh";
					procInsTabYN="N";
					patInsTabYN="N";
				}
				//rows="0%,*,12%";
					height1="0vh";
					height2="84vh";
					height3="12vh";
				if(clinicInsYN.equals("Y") && orderInsYN.equals("Y")){
					//rows="5%,*,12%";
					height1="5vh";
					height2="80vh";
					height3="12vh";
					procInsTabYN="Y";
					patInsTabYN="Y";
				}
			}else if(from_page.equals("view_dtls")){
				connection = ConnectionManager.getConnection(request);
				stmt=connection.createStatement();
				HashMap patInstructionsMapResult=new java.util.HashMap();
				HashMap procInstructionsMapResult=new java.util.HashMap();
				String order_stand_ins="";
				//String appt_pat_ins="SELECT instruction_id,instruction_desc FROM oa_appt_pat_instructions WHERE facility_id = '"+facilityId+"' AND appt_ref_no = '"+appt_refno+"' ORDER BY display_order";
				String appt_pat_ins="SELECT instruction_id,instruction_desc FROM oa_appt_pat_instructions WHERE facility_id = ? AND appt_ref_no = ? ORDER BY display_order";
				
				//rset=stmt.executeQuery(appt_pat_ins);
				pstmt = connection.prepareStatement(appt_pat_ins);
				pstmt.setString(1,facilityId);
				pstmt.setString(2,appt_refno);
				rset = pstmt.executeQuery();
				int clinicInstructionsCount=1;
				Integer tempInteger=null;
				while(rset!=null && rset.next()){
						String instructionID=rset.getString("instruction_id");
						String instructionDesc=rset.getString("instruction_desc");
						String valueObject=instructionID+"|~"+instructionDesc+"|~"+"Y";
						tempInteger=new Integer(clinicInstructionsCount);
						patInstructionsMapResult.put(tempInteger.toString(),valueObject);
						clinicInstructionsCount++;
				}
				if(clinicInstructionsCount > 1){
					clinicInsYN="Y";
					session.setAttribute("patInstructionsMap", patInstructionsMapResult);
				}
				//String appt_prc_ins="SELECT INSTRUCTION_DESC FROM oa_appt_proc_instructions WHERE facility_id = '"+facilityId+"' AND appt_ref_no = '"+appt_refno+"'";
				String appt_prc_ins="SELECT INSTRUCTION_DESC FROM oa_appt_proc_instructions WHERE facility_id = ? AND appt_ref_no = ? ";
				int countProcInstructions=1;
				//rset=stmt.executeQuery(appt_prc_ins);
				pstmt = connection.prepareStatement(appt_prc_ins);
				pstmt.setString(1,facilityId);
				pstmt.setString(2,appt_refno);
				rset = pstmt.executeQuery();
				if(rset!=null && rset.next()){
					order_stand_ins=rset.getString("INSTRUCTION_DESC");
					countProcInstructions++;
				}
				if(countProcInstructions>1){
					orderInsYN="Y";
					procInstructionsMapResult.put("prcIns",order_stand_ins);
					procInstructionsMapResult.put("checked","Y");
					session.setAttribute("prcInstructionMap", procInstructionsMapResult);
				}
				//rows="0%,*,12%";
					height1="0vh";
					height2="84vh";
					height3="12vh";
				if(clinicInsYN.equals("Y") && orderInsYN.equals("Y")){
					//rows="5%,*,12%";
					height1="5vh";
					height2="80vh";
					height3="12vh";
					procInsTabYN="Y";
					patInsTabYN="Y";
				}
			}
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(rows));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(height1));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patInsTabYN));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(procInsTabYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(height2));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(pending_order_catalog_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(clinicInsYN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(orderInsYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(orderInsStandardYN));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(appt_refno));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(height3));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(viewinsdtlsYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(clinicInsYN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(orderInsYN));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();
		ConnectionManager.returnConnection(connection,request);
	}

            _bw.write(_wl_block32Bytes, _wl_block32);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.PatInstructions.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
