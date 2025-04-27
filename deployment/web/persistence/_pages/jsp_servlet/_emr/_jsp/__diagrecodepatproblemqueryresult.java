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
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __diagrecodepatproblemqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DiagRecodePatProblemQueryResult.jsp", 1743670596105L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\n      \t<!--<script src=\'../js/rowcolor.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n-->\n</head>\n<script>\n\t\tsrl_no_array = new Array();\n\t\tvar prev=1;\n\t\tvar i=0;\n\t\tvar prev1=0;\n\t\tvar j=0;\n\nfunction refer(ro,numofcols)\n{\n\t\n\t\tprev1\t=ro.rowIndex\n\t\tfor (var i=0;i<numofcols;i++)\n\t\t{\n\t\t\tdocument.forms[0].all.dataTable.rows[prev].cells[i].style.backgroundColor=ro.bgColor;\n\t\t\t\n\t\t}\n\t\tfor (var i=0;i<numofcols;i++)\n\t    {\n\t\tro.cells(i).style.backgroundColor=\"#B2B6D7\";\n\t\t}\n\n\t\tprev\t=ro.rowIndex\n}\n\nasync function ShowSupportingDiag(associate_codes,title)\n{\n\tvar dialogHeight= \"10vh\" ;\n    var dialogWidth = \"35vw\" ;\n\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\n\t//window.showModalDialog(\"../../eCA/jsp/ShowSupportDiagCodeFrames.jsp?associate_codes=\"+escape(associate_codes)+\"&title=\" + title,\"\",features);\n\tawait window.showModalDialog(\"../../eMR/jsp/ShowSupportDiagCodeFrames.jsp?associate_codes=\"+escape(associate_codes)+\"&title=\" + title,\"\",features);\n}\n\n\nfunction rfresh(obj, associate_codes, code_indicator,encounter_clor,trn_srl_no)\n{\t\n\tvar aut=\'\';\n\tvar authorizeButton=parent.PatProblemQueryTools.document.forms[0].authorizeButton.value;\n\tif (authorizeButton==\'N\') aut=\'\';\n\telse  aut= parent.PatProblemQueryTools.document.forms[0].authorize.value;\n\tparent.addModifyPatProblem.document.forms[0].search_button.disabled=false;\n\tparent.addModifyPatProblem.document.forms[0].AddAssociateCodes.disabled=true;\n\tparent.addModifyPatProblem.document.forms[0].trn_srl_no.value=trn_srl_no;\n\tparent.addModifyPatProblem.document.forms[0].Description1.value=\"\";\n\tparent.addModifyPatProblem.document.forms[0].code.readOnly =false;\n\tparent.addModifyPatProblem.document.forms[0].code.value=\"\";\n\tparent.addModifyPatProblem.document.forms[0].remarks.readOnly =false;\n\tparent.addModifyPatProblem.document.forms[0].remarks.value=\"\";\n\t//parent.addModifyPatProblem.document.forms[0].exclamation.style.display=\'none\';\n\tparent.addModifyPatProblem.document.forms[0].exclamation.style.visibility=\'hidden\';\n\tparent.PatProblemQueryTools.document.forms[0].record.disabled=false;\n\t  \n\tvar encounter_id=document.forms[0].Encounter_Id.value;\n\t\n\tvar QueryString =parent.addModifyPatProblem.document.getElementById(\"QueryString\").value;\t\n\n\t\n\tparent.Diagresultframe.location.href=\"../../eMR/jsp/DiagRecodeaddmodify.jsp?Encounter_Id=\"+encounter_id+\"&trn_srl_no=\"+trn_srl_no;\n\t\nif(document.forms[0].modal_yn.value==\'Y\' || document.forms[0].called_from_ip_result.value==\'Y\')\n\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n/*\nelse\n\ttop.content.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n*/\n\n\t\t\n}\n\n\tfunction scrollTitle(){\n\t  var y = parent.PatProblemQueryResult.document.body.scrollTop;\n\n\t  if(y == 0){\n\t\tparent.PatProblemQueryResult.document.getElementById(\"divDataTitle\").style.position = \'static\';\n\t\tparent.PatProblemQueryResult.document.getElementById(\"divDataTitle\").style.posTop  = 0;\n\t  }else{\n\t\tparent.PatProblemQueryResult.document.getElementById(\"divDataTitle\").style.position = \'relative\';\n\t\tparent.PatProblemQueryResult.document.getElementById(\"divDataTitle\").style.posTop  = y-2;\n\t  }\n\n\t}\n\tfunction alignWidth(){\n\t\tvar totalRows =  parent.PatProblemQueryResult.document.getElementById(\"dataTable\").rows.length;\n\t\tvar counter = totalRows-1;\n\t\tvar temp = parent.PatProblemQueryResult.document.getElementById(\"dataTitleTable\").rows(1).cells.length;\n\t\tfor(var i=0;i<temp;i++) {\n\t\t\tparent.PatProblemQueryResult.document.getElementById(\"dataTitleTable\").rows(1).cells(i).width=parent.PatProblemQueryResult.document.getElementById(\"dataTable\").rows(counter).cells(i).offsetWidth;\n\t\t\t\n\t\t}\n\t}\nasync function showEncounterDeatils(Patient_Id,srl_no,diag_code)\n{\n\tvar dialogHeight= \"10vh\" ;\n\tvar dialogWidth = \"37vw\" ;\n\tvar dialogTop = \'100\'\n\tvar dialogHeight = \'20\'\n\tvar status = \"no\";\n\tvar features    = \"dialogHeight:\" + dialogHeight + \";dialogHeight:\"+dialogHeight+\";dialogTop:\"+dialogTop+\"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\tretVal =await  window.showModalDialog(\"DiagRecodePatProblemEncDtlMain.jsp?Patient_Id=\"+Patient_Id+\"&srl_no=\"+srl_no+\"&diag_code=\"+diag_code,arguments,features);\n}\n</script>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  onScroll=\'scrollTitle()\' >\n<form name=\'query_form\' id=\'query_form\'>\n<center>\n<div id=\'divDataTitle\' style=\'postion:relative\'>\n<table border=\'1\' width=\'100%\' id=\'dataTitleTable\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' >\n<tr><th align=\'left\' colspan=\'8\'><font size=1>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</font></th></tr>\n<tr>\n<th align=\'left\'><font size=1>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</font></th>\n<th  align=\'left\'><font size=1>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</font></th>\n</tr>\n</table>\n</div>\n<table border=\'1\' width=\'100%\' id=\'dataTable\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' style=\"border-bottom:#ffffff\">\n ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n                <tr><td class=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>&nbsp</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td><td class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n\t\t\t\t\t<script>\n\t\t\t\t\tsrl_no_array[i] = ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\ti++;\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<tr style=\'visibility:hidden\'>\n\n<th align=\'left\'><font size=1>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</font></th>\n</tr>\n</table>\n</center>\n<input type=\"hidden\" name=\"help_function_id\" id=\"help_function_id\" value=\"RECORD_DIAGNOSIS\">\n<input type=\'hidden\' name=\'modal_yn\' id=\'modal_yn\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<input type=\'hidden\' name=\'called_from_ip_result\' id=\'called_from_ip_result\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\'hidden\' name=\'Encounter_Id\' id=\'Encounter_Id\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'\n\n\n</form>\n</body>\n</html>\n<script>alignWidth();</script>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//String relationship_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String facility_id = (String)session.getAttribute("facility_id");
	//String Sec_Hdg_Code  = request.getParameter("Sec_Hdg_Code");
	//String patient_type			= request.getParameter("patient_type");

    String Patient_Id        = request.getParameter("Patient_Id");
    String Encounter_Id      = request.getParameter("Encounter_Id");	
    //String Practitioner_Id   = request.getParameter("Practitioner_Id");
    //String Locn_Code         = request.getParameter("Locn_Code");
    //String Locn_Type         = request.getParameter("Locn_Type");
    String f_authorize_yn    = request.getParameter("f_authorize_yn");
	String authorize=request.getParameter("authorize")==null?"":request.getParameter("authorize");
	String modal_yn				= request.getParameter("modal_yn")==null?"":request.getParameter("modal_yn");
	//String calledFromDeathReg				= request.getParameter("calledFromDeathReg")==null?"":request.getParameter("calledFromDeathReg");
	//String patLineYN				= request.getParameter("patLineYN")==null?"":request.getParameter("patLineYN");


	if (authorize.equals("Normal Mode"))
	{
		f_authorize_yn="Y";
  	}
	
   // String context = request.getParameter("P_context");
	//String patient_class    = request.getParameter("patient_class");
	
	//String function				= request.getParameter("Function");

    //String stagecode = request.getParameter("stage_code")==null?"":request.getParameter("stage_code");
    //String stagedesc = request.getParameter("stage_desc")==null?"":request.getParameter("stage_desc");
    //String logicalseqno = request.getParameter("Logical_Seq")==null?"":request.getParameter("Logical_Seq");
	String called_from_ip = request.getParameter("called_from_ip")==null?"N":request.getParameter("called_from_ip");

    String scheme       ="";
    String scheme_desc  ="";
	String significant_yn = "";
	significant_yn			=	request.getParameter("significant_yn");
	if(significant_yn==null) significant_yn = "N";
    int k=1;
    int aname=2;
	//string viewname=view;
    String classValue = "";
    String sql_1="select diag_code_scheme scheme,decode(diag_code_scheme,'1','ICD 10','2','ICD 9CM','5','READ')scheme_desc from mr_parameter";
	String diag_type="";

	//String age = request.getParameter("Age")==null?"":request.getParameter("Age");
	//String dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");
	//String sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");

            _bw.write(_wl_block1Bytes, _wl_block1);


String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);


        Connection conn 	= null; //(Connection) session.getValue( "connection" ) ;
        PreparedStatement  pstmt = null;
        PreparedStatement  pstmt_1 = null;
        ResultSet  rs_associatecodes = null;
        ResultSet  rs		= null;
        PreparedStatement  stmt_1	= null;
        ResultSet  rs_1		= null;
		try
        {
		conn = ConnectionManager.getConnection(request);

              stmt_1=conn.prepareStatement(sql_1);
           rs_1=stmt_1.executeQuery();
               if(rs_1.next())
                {
                   scheme      = rs_1.getString("scheme");
                 scheme_desc = rs_1.getString("scheme_desc");
              }

        String sql="select b.srl_no,to_char(b.onset_date,'dd/mm/yyyy') onset_date1,b.sensitive_yn,b.diag_desc,b.diag_code,DECODE (b.diag_code_scheme, '1', 'ICD10', '2', 'ICD9-CM', '5', 'READ' ) diag_code_scheme_desc, b.significant_yn,nvl((select distinct 'Y' from pr_problem_enc_dtl where patient_id = b.patient_id and srl_no = b.srl_no and facility_id = a.curr_facility_id and encounter_id = a.curr_encounter_id ),'N') encounter_clor, decode(b.diag_type,'P','Provisional','D','Differential','F','Final','')  diagtype,nvl(b.primary_yn,'n') primary_diag,b.diag_code || nvl2(b.cause_indicator,'/' || b.cause_indicator,null) diag_code_desc ,(SELECT code_indicator FROM mr_icd_code WHERE diag_code = b.diag_code AND (   b.diag_code_scheme = '1' OR (    b.diag_code_scheme = '2'AND record_type = b.record_type AND NVL (cause_indicator, '*') = NVL (b.cause_indicator, '*') ))) code_indicator,b.ip_diag_stage,nvl((select 'Y' from pr_problem_enc_dtl where patient_id = b.patient_id and srl_no = b.srl_no and cause_of_death_yn='Y' and rownum=1 ),'N') cause_of_death_yn,a.trn_srl_no  from mr_diag_recoding a,pr_problem b where a.patient_id = b.patient_id and a.srl_no = b.srl_no and a.curr_facility_id = ? and a.curr_encounter_id = ? order by diagtype, onset_date desc  ";
		//out.println(sql);
		pstmt	=	conn.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,Encounter_Id);
		//pstmt.setString(3,Patient_Id);
	//	pstmt.setString(4,Patient_Id);
	//	pstmt.setString(4,f_authorize_yn);
	//	pstmt.setString(5,scheme);
		rs = pstmt.executeQuery();
		//System.out.println("encounter_clor---"+encounter_clor);
		
		if(rs == null)
		{
            for (int x=0; x<6 ; x++)
            {
                if ( k%2 == 0 )
                    classValue = "QRYEVEN" ;
                else
                classValue = "QRYODD" ;
				
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);

                k++;
            }
        }
        else
        {
			
			String onset_date = "";
			String diag_desc = "";
			String diag_code = "";
			String prim_diag = "";
			String diag_code_desc = "";
			String diag_code_scheme_desc = "";
			String srl_no = "";
			String sensitive_yn = "";
			StringBuffer associate_codes = new StringBuffer();
			String code_indicator = "";
			String encounter_clor = "";
			String ip_diag_stage	="";
			String ip_diag_stage_display = "";
			String cause_of_death_yn	="";
			String image_disp_yn ="";
			String trn_srl_no="";
			//int i=0;


            while(rs.next())
            {
				
				onset_date	=	rs.getString("onset_date1");
				if(onset_date!=null && !onset_date.equals(""))
					onset_date = DateUtils.convertDate(onset_date,"DMY","en",localeName);
			
                diag_code		=	rs.getString("diag_code");
				diag_code_desc	=	rs.getString("diag_desc");
                //prim_diag		=	rs.getString("primary_diag");
			    diag_type		=	rs.getString("diagtype");
		 	 	if(diag_type == null)	diag_type ="";
                diag_code_scheme_desc=	rs.getString("diag_code_scheme_desc");
                srl_no 			= 	rs.getString("srl_no");
                sensitive_yn		=	rs.getString("sensitive_yn");
				significant_yn	=	rs.getString("significant_yn");
				trn_srl_no=rs.getString("trn_srl_no");
				
				if(sensitive_yn==null)	sensitive_yn  = "N";
				if(significant_yn==null)	significant_yn  = "N";
				if(diag_code==null)			diag_code		=	"";
				code_indicator = rs.getString("code_indicator");
				encounter_clor = rs.getString("encounter_clor");	
				ip_diag_stage	= rs.getString("ip_diag_stage");
				cause_of_death_yn = rs.getString("CAUSE_OF_DEATH_YN");
				if(ip_diag_stage==null)ip_diag_stage="";
				if(ip_diag_stage.equals("A")) 
				{
					ip_diag_stage="Admission";
					ip_diag_stage_display = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels") ; 
				}
				else if(ip_diag_stage.equals("I")) 
				{
					ip_diag_stage="Intermediate";
					ip_diag_stage_display = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels") ; 
				}
				else if(ip_diag_stage.equals("D")) 
				{
					ip_diag_stage="Discharge";
					ip_diag_stage_display = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels") ; 

				}
				else if(ip_diag_stage.equals("")||ip_diag_stage== null)
				{
					ip_diag_stage="Discharge";
					ip_diag_stage_display = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels") ; 

				}
				
				//System.out.println("sensitive_yn"+sensitive_yn);
				//if(sensitive_yn!=null)
				String sql_assosicate_code = "select a.support_diag_code , b.short_desc,b.long_desc, b.code_indicator from pr_problem_detail a, mr_icd_code b where a.patient_id =? and   a.srl_no =? and      a.diag_code = ? and b.diag_code_scheme = ? and b.diag_code = a.support_diag_code" ;

				pstmt_1 = conn.prepareStatement(sql_assosicate_code);
				pstmt_1.setString(1, Patient_Id);
				pstmt_1.setString(2, srl_no);
				pstmt_1.setString(3, diag_code);
				pstmt_1.setString(4, scheme);

				rs_associatecodes = pstmt_1.executeQuery();
				int temp_associate_code = 0;
				
				while(rs_associatecodes.next())
				{
					String temp_supporting_code = java.net.URLEncoder.encode((String)rs_associatecodes.getString("support_diag_code"));
					String temp_short_desc = java.net.URLEncoder.encode((String)rs_associatecodes.getString("short_desc"));
                    String long_desc=java.net.URLEncoder.encode((String)rs_associatecodes.getString("long_desc"));
					//code_indicator = rs_associatecodes.getString("code_indicator");
					
					if(temp_associate_code == 0)
						associate_codes.append(temp_supporting_code + "~" + temp_short_desc+"~"+long_desc);
					else
						associate_codes.append("|" + temp_supporting_code + "~" + temp_short_desc+"~"+long_desc);	
					temp_associate_code++;
				}
                
				
	
			if ( k%2 == 0 )
                classValue = "QRYEVEN" ;
            else
                classValue = "QRYODD" ;
			
			if(sensitive_yn != null)
				{
			 if(sensitive_yn.equals("Y"))
				classValue="PATQRED";
              else if(significant_yn.equals("Y"))
				{
					classValue="SIGNIFICANT";
				}
			}
					//onclick='javascript:changeRowColor(this,4)'


					/*(called_from_ip.equals("Y"))
					{
						out.println("<tr style='background-color:;'>");
						if(encounter_clor.equals("Y"))
							out.println("<td width='2%' class='BLUE'></td>");
						else
							out.println("<td width='2%'></td>");

						out.println("<td class='"+classValue+"'><font size=1>"+onset_date+"</font></td><td class='"+classValue+"'><font size=1>"+aname);
			            out.println(diag_desc+"</font></td><td class='"+classValue+"'><font size=1>");
		
					}
					else
					{*/
						//out.println("<tr style='background-color:;' onclick='javascript:refer(this,7)'>");
						out.println("<tr>");


						if(cause_of_death_yn.equals("Y"))
						{
							image_disp_yn = "<img src='../../eOR/images/Authorization.gif'>";
						}
						else
						{
							image_disp_yn = "";
						}
						
							
						out.println("<td class='"+classValue+"'><font size=1>"); 

						out.println("<input type='hidden' name='onsetdate' id='onsetdate' value='"+onset_date+"'>");
						out.println(onset_date+"</font></td>");
						
						out.println("<td class='"+classValue+"'><font size=1><a name='"+aname+"'  href=\"javascript:rfresh(document.forms[0].srl_no"+k+",'" + java.net.URLEncoder.encode(associate_codes.toString()) + "','" + code_indicator + "','"+encounter_clor+"','"+trn_srl_no+"')\">");

						out.println("<input type='hidden' name='diagcodedesc' id='diagcodedesc' value='"+diag_code_desc+"'>");
			            out.println(diag_code_desc+"</a>&nbsp;"+image_disp_yn+"</font></td>");

					

						out.println("<td class='"+classValue+"'><font size=1>");
						out.println("<input type='hidden' name='diagstage' id='diagstage' value="+ip_diag_stage+">");
						out.println(ip_diag_stage);

						out.println("</font></td>");
						out.println("<td class='"+classValue+"'><font size=1>");
						out.println("<input type='hidden' name='diagcode' id='diagcode' value='"+diag_code+"'>");

						out.println(diag_code);
						  out.println("</font></td>");
						out.println("<td class='"+classValue+"'><font size=1>");

						out.println("<input type='hidden' name='diagscheme' id='diagscheme' value='"+diag_code_scheme_desc+"'>");
						out.println(diag_code_scheme_desc);
					
					
					
					out.println("<input type='hidden' name='srl_no"+k+"' id='srl_no"+k+"' value='"+srl_no+"'>");
                    out.println("</font></td>");
					out.println("<td class='"+classValue+"'><font size=1>");
					out.println("<input type='hidden' name='diagtype' id='diagtype' value='"+diag_type+"'>");

					out.println(diag_type);
					out.println("</font></td>");
					out.println("</font></td>");
					
				
					if(temp_associate_code > 0)
					{
					out.println("<td class='"+classValue+"'><font size=1>");
					
					out.println("<a href=\"javascript: ShowSupportingDiag('"+java.net.URLEncoder.encode(associate_codes.toString())+"','" + diag_desc+"(" + diag_code_desc+")')\" >View</a>");
					out.println("</font></td>");
					}
					else{
					out.println("<td class='"+classValue+"'><font size=1>");
					out.println("&nbsp");
					out.println("</font></td>");
					}
					
					out.println("</tr>");
					
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block17Bytes, _wl_block17);


                    k++;
					associate_codes = new StringBuffer();;
              }
			onset_date = null;
			diag_desc = null;
			diag_code = null;
			prim_diag = null;
			diag_code_desc = null;
			diag_code_scheme_desc = null;
			srl_no = null;
			sensitive_yn = null;

        }
    }catch(Exception e)
	{
		//out.print("ERROR"+e.toString());
		e.printStackTrace();
	}
    finally
            {
                if(rs!=null)    rs.close();
				if(pstmt!=null)  pstmt.close();
				if(pstmt_1!=null)  pstmt_1.close();
				if(rs_1 !=null) rs_1.close();
				if(rs_associatecodes !=null) rs_associatecodes.close();
				if(stmt_1!=null) stmt_1.close();
				ConnectionManager.returnConnection(conn, request);
            }

            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block22Bytes, _wl_block22);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ActiveProblems.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisStage.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DiagnosisCode.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.scheme.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SupportingDiagnosis.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisStage.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.scheme.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.primary.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SupportingDiagnosis.label", java.lang.String .class,"key"));
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
}
