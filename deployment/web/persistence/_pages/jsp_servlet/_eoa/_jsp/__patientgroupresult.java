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
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __patientgroupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/PatientGroupResult.jsp", 1709119252787L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n \n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<!-- Below Style For Fixed Header with scroll.... -->\n<style type=\"text/css\">\n    table.mt {border-width: 1px;border-spacing:0px ;border-collapse: collapse;}\n    table.mt th {border-width: 1px;padding: 1px;;white-space: normal; text-align:left;width:12%;}\n    table.mt td {border-width: 1px;padding: 1px;text-align: left;vertical-align:middle;white-space:normal;word-wrap: break-word; word-break: break-all;width:12%;}\n</style>\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eOA/js/jquery.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eOA/js/PatientGroup.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/tableheaderscroll.js\'></script><!-- Supporting Js File For Fixed Header with scroll.... -->\n\n<script type=\"text/javascript\">\n\twindow.onload = function () { \n\t\tif(document.getElementById(\"dataTable\")!=null){\n\t\t\tfxheaderInit(\'dataTable\',400);\n\t\t}\n\t}\n\t$(\"input[name=\'checkall\']\").live(\'click\',function() {\n\t\tvar checked = $(this).attr(\'checked\');\n\t\tif(checked == \'checked\') {\n\t\t\t$(\"input[name=\'pat_id_chk\']\").attr(\"checked\", true);\n\t\t} else {\n\t\t\t$(\"input[name=\'pat_id_chk\']\").attr(\"checked\", false);\n\t\t}\n\t});\n\nfunction FnDelete(){\n\tvar VarPatIds=FnGetCheckdValues();\n\tvar IsError\t\t\t= 0;\n\tif(VarPatIds==\"\"){\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\", \"common\"));\n\t\tparent.commontoolbarFrame.document.location.reload();\n\t\tIsError\t=1;\n\t}\n\tif(IsError==0){\n\t\t$(\"#HidSelectedPatIds\").val(VarPatIds);\n\t\t$(\"#PatGrpRes\").submit();\n\t}\n}\n\nfunction FnGetCheckedCount(){\n\tvar count\t= 0;\n\t$(\"input[name=\'pat_id_chk\']\").filter(\':checked\').each(function() {\n\t\tcount\t= count + 1;\n\t});\n\treturn parseInt(count);\n}\n\n\nfunction FnGetCheckdValues(){\n\tvar VarPatIds\t= \"\";\n\t$(\"input[name=\'pat_id_chk\']\").filter(\':checked\').each(function() {\n\t\tVarPatIds+=$(this).val()+\"|\";\n\t});\n\tif(VarPatIds!=\'\'){\n\t\tVarPatIds\t= VarPatIds.slice(0,-1);\n\t}\n\treturn VarPatIds;\n}\n\n\n\n\nfunction FnInsert(){\n\tvar VarPatIds\t\t= FnGetCheckdValues();\n\tvar VarPatCount\t\t= FnGetCheckedCount();\n\tvar VarMaxPatient\t= $(\"#max_patient\").val();\n\tvar VarCheckCount\t= parseInt($(\"#Existing_Group_Members\").val())+VarPatCount;\n\tvar IsError\t\t\t= 0;\n\tif(VarPatIds==\"\"){\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\", \"common\"));\n\t\tparent.commontoolbarFrame.document.location.reload();\n\t\tIsError\t= 1;\n\t}else if(VarCheckCount > VarMaxPatient){\n\t\talert(getMessage(\"MAX_PAT_LIMIT_REACHED\", \"OA\"));\n\t\tparent.commontoolbarFrame.document.location.reload();\n\t\tIsError\t= 1;\n\t}\n\tif(IsError==0){\n\t\t$(\"#HidSelectedPatIds\").val(VarPatIds);\n\t\t$(\"#PatGrpRes\").submit();\n\t}\n}\n\n\n\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n</head>\n\n<body OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<form name=\"PatGrpRes\" id=\"PatGrpRes\" id=\"PatGrpRes\" method=\"post\" action=\"../../servlet/eOA.GenerateGroupPatientsServlet\">\n<input type=\"hidden\" name=\"HidSelectedPatIds\" id=\"HidSelectedPatIds\" id=\"HidSelectedPatIds\" value=\"\" >\n<input type=\"hidden\" name=\"max_patient\" id=\"max_patient\" id=\"max_patient\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" >\n<input type=\"hidden\" name=\"GroupId\" id=\"GroupId\" id=\"GroupId\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" >\n<input type=\"hidden\" name=\"Existing_Group_Members\" id=\"Existing_Group_Members\" id=\"Existing_Group_Members\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" >\n<input type=\"hidden\" name=\"mode\" id=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" >\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\n\t<table border=\'1\'  id=\"dataTable\" width=\"100%\" class=\"mt\">\n\t<tr>\n\t<th><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></th>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<th><b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</b></th>\n\t<th><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</b></th>\n\n\t<th><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</b></th>\n\t<th>Select All&nbsp;<input type=\'checkbox\' name=\"checkall\" id=\"checkall\" value=\'N\' ></th>\n\t</tr>\n\t ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t \n\t \t<tr >\n\t \t\t<td  class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"  >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t \t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t \t\t\t<td  class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"   >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t \t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t \t\t<td class=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t \t\t<td class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t \t\t\n\t \t\t<td class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"  ><input name=\"pat_id_chk\" id=\"pat_id_chk\" type=\"checkbox\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" ></td>\n\t \t\t\n\t \t</tr>\n\t ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\n\t</table>\n\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t</form>\n\t\n\t\n</body>\n</html>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)	{
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String locale=(String)session.getAttribute("LOCALE");
String mode	= (request.getParameter("mode")==null)?"":request.getParameter("mode");
String GroupId = (request.getParameter("GroupId")==null)?"":request.getParameter("GroupId");
String Existing_Group_Members = (request.getParameter("Existing_Group_Members")==null)?"":request.getParameter("Existing_Group_Members");
String max_patient = (request.getParameter("max_patient")==null)?"":request.getParameter("max_patient");
String VarWhere	= "";
if(mode.equals("insert")){
	String First_Name = (request.getParameter("First_Name")==null)?"":request.getParameter("First_Name");
	String Second_Name =(request.getParameter("Second_Name")==null)?"": request.getParameter("Second_Name");
	String Third_Name = (request.getParameter("Third_Name")==null)?"":request.getParameter("Third_Name");
	String Family_Name = (request.getParameter("Family_Name")==null)?"":request.getParameter("Family_Name");
	String Dob =(request.getParameter("Dob")==null)?"": request.getParameter("Dob");
	String Sex = (request.getParameter("Sex")==null)?"":request.getParameter("Sex");
	String MobileNo = (request.getParameter("MobileNo")==null)?"":request.getParameter("MobileNo");
	String group_location_id	= (request.getParameter("group_location_id")==null)?"":request.getParameter("group_location_id");
	
	if(!First_Name.equals("")) VarWhere+=" AND A.FIRST_NAME like '%"+First_Name+"%'";
	if(!Second_Name.equals("")) VarWhere+=" AND A.SECOND_NAME like '%"+Second_Name+"%'";
	if(!Third_Name.equals("")) VarWhere+=" AND A.THIRD_NAME like '%"+Third_Name+"%'";
	if(!Family_Name.equals("")) VarWhere+=" AND A.FAMILY_NAME like '%"+Family_Name+"%'";
	if(!Dob.equals("")) VarWhere+=" AND trunc(A.DATE_OF_BIRTH) = to_date('"+Dob+"','dd/mm/yyyy')";
	if(!Sex.equals("") && !Sex.equals("A")) VarWhere+=" AND A.SEX = '"+Sex+"'";
	if(!MobileNo.equals("")) VarWhere+=" AND A.CONTACT1_NO = '"+MobileNo+"'";
	VarWhere+= " AND A.PATIENT_ID not in ( select DISTINCT  C.PATIENT_ID from  OA_GROUP_DTLS C, oa_group_hdr D where C.GROUP_ID=D.GROUP_ID and D.LOCN_CODE='"+group_location_id+"')";
	
}else if(mode.equals("delete")){
	if(!GroupId.equals("")) VarWhere+=" AND B.GROUP_ID = '"+GroupId+"'";
}

VarWhere+=" AND A.DECEASED_YN = 'N'  AND A.SUSPEND_YN = 'N'  AND A.ACTIVE_YN = 'Y' ";


Connection con 		= ConnectionManager.getConnection(request);
Statement newstmt	= null;

ResultSet rset		= null ;
PreparedStatement pstmt	= null;
ResultSet rs		= null ;
String sql			= "";
String classValue	= "";
int noOfRecords		= 0;
int rowcnt=0;

String Family_No_Link_Yn 			= "";
String Family_No_Prompt				= ""; 
String First_Name_Accept_Yn 		= "";
String First_Name_Prompt 			= "";
String Second_Name_Accept_Yn 		= "";
String Second_Name_Prompt 			= "";
String Third_Name_Accept_Yn			= "";
String Third_Name_Prompt 			= "";
String Family_Name_Accept_Yn 		= ""; 
String Family_Name_Prompt			= "";
String gender						= "";
 
 try{
	String Qry_For_Slct_Flds="SELECT param.family_no_link_yn,param.family_no_prompt, param.first_name_accept_yn,param.first_name_order, param.first_name_prompt,param.second_name_accept_yn, param.second_name_order,param.second_name_prompt, param.third_name_accept_yn,param.third_name_order, param.third_name_prompt,param.family_name_accept_yn, param.family_name_order,param.family_name_prompt, first_name_loc_lang_prompt,second_name_loc_lang_prompt, third_name_loc_lang_prompt,family_name_loc_lang_prompt FROM   mp_param_lang_vw param WHERE  param.module_id = 'MP' AND param.language_id = ?";
	 pstmt = con.prepareStatement(Qry_For_Slct_Flds);
	 pstmt.setString(1,locale);
	 rs = pstmt.executeQuery();
     if (rs !=null){
           if (rs.next()){
              
             Family_No_Link_Yn =rs.getString("Family_No_Link_Yn")== null ?  "N" : rs.getString("Family_No_Link_Yn");
             Family_No_Prompt =rs.getString("Family_No_Prompt")== null ? "Head of the Family" : rs.getString("Family_No_Prompt");
          	
             First_Name_Accept_Yn = rs.getString("First_Name_Accept_Yn")==null ? "N" : rs.getString("First_Name_Accept_Yn");
             First_Name_Prompt = rs.getString("First_Name_Prompt")==null ? "First Name" : rs.getString("First_Name_Prompt");
            
             Second_Name_Accept_Yn = rs.getString("Second_Name_Accept_Yn")==null ? "N" : rs.getString("Second_Name_Accept_Yn");
             Second_Name_Prompt = rs.getString("Second_Name_Prompt")==null ? "Second Name" : rs.getString("Second_Name_Prompt");
            
             Third_Name_Accept_Yn = rs.getString("Third_Name_Accept_Yn")==null ? "N" : rs.getString("Third_Name_Accept_Yn");
             Third_Name_Prompt = rs.getString("Third_Name_Prompt")==null ? "Third Name" : rs.getString("Third_Name_Prompt");

        	 Family_Name_Accept_Yn = rs.getString("Family_Name_Accept_Yn")==null ? "N" : rs.getString("Family_Name_Accept_Yn");
      		 Family_Name_Prompt = rs.getString("Family_Name_Prompt")==null ? "Family Name" : rs.getString("Family_Name_Prompt");
           }
       }
   }catch(Exception e) { 
//out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
   finally
   {
       if (pstmt != null) pstmt.close();
       if (rs != null) rs.close();
   }

 if(mode.equals("insert")){
	 
 	sql="select A.PATIENT_ID,A.FIRST_NAME,A.SECOND_NAME,A.THIRD_NAME,A.FAMILY_NAME,to_char(A.DATE_OF_BIRTH,'dd/mm/yyyy')DATE_OF_BIRTH,A.SEX, A.CONTACT1_NO from mp_patient A  where A.PATIENT_ID is not null " +VarWhere ;
 
 }else{
	 sql=" SELECT A.patient_id,B.PATIENT_ID, A.first_name, A.second_name, A.third_name, A.family_name,TO_CHAR (A.date_of_birth, 'dd/mm/yyyy') date_of_birth, A.sex, A.CONTACT1_NO,B.GROUP_ID FROM mp_patient A , oa_group_dtls B where A.patient_id = B.patient_id " +VarWhere;
 }
newstmt= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
rset = newstmt.executeQuery(sql) ;


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(max_patient));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(GroupId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Existing_Group_Members));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block12Bytes, _wl_block12);

while(rset.next()){
noOfRecords = noOfRecords + 1;
	/*if(mode.equals("insert")){
		if(noOfRecords > 100)
			break;
	}*/
}
rset.beforeFirst(); 

if(noOfRecords == 0){	  
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));clearValues('delete','parent');</script>");
}/*else if(noOfRecords > 100 && mode.equals("insert")){
	out.println("<script>alert(getMessage('TOO_MANY_RECORDS_REFINE_SEARCH','OA'))</script>");
}*/else{
	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels") ));
            _bw.write(_wl_block14Bytes, _wl_block14);

	if(First_Name_Accept_Yn.equals("Y")){
		if(!First_Name_Prompt.equals("")){
			out.println("<th><b>"+First_Name_Prompt+"</b></th>");
		}else{
			out.println("<th><b>First Name</b></th>");
		}
	}
	if(Second_Name_Accept_Yn.equals("Y")){
		if(!Second_Name_Prompt.equals("")){
			out.println("<th><b>"+Second_Name_Prompt+"</b></th>");
		}else{
			out.println("<th><b>Second Name</b></th>");
		}
	}
	if(Third_Name_Accept_Yn.equals("Y")){
		if(!Third_Name_Prompt.equals("")){
			out.println("<th><b>"+Third_Name_Prompt+"</b></th>");
		}else{
			out.println("<th><b>Third Name</b></th>");
		}
	}
	if(Family_Name_Accept_Yn.equals("Y")){
		if(!Family_Name_Prompt.equals("")){
			out.println("<th><b>"+Family_Name_Prompt+"</b></th>");
		}else{
			out.println("<th><b>Family Name</b></th>");
		}
	}
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DateofBirth.label","common_labels")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MobileNo.label","common_labels")));
            _bw.write(_wl_block18Bytes, _wl_block18);
while(rset.next()){
	 		if(rowcnt%2==0)
	 			classValue="AR_QRYEVEN wrapword";
			else
				classValue="AR_QRYODD wrapword";
	 		
	 		gender=rset.getString("SEX");
			if(gender.equals("M")){
				gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			}else if(gender.equals("F")){
				gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			}else if(gender.equals("U")){
				gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			}
	 	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((rset.getString("PATIENT_ID")==null)?"&nbsp;":rset.getString("PATIENT_ID")));
            _bw.write(_wl_block21Bytes, _wl_block21);
if(First_Name_Accept_Yn.equals("Y")){
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((rset.getString("FIRST_NAME")==null)?"&nbsp;":rset.getString("FIRST_NAME")));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
if(Second_Name_Accept_Yn.equals("Y")){ 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((rset.getString("SECOND_NAME")==null)?"&nbsp;":rset.getString("SECOND_NAME")));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
if(Third_Name_Accept_Yn.equals("Y")){ 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((rset.getString("THIRD_NAME")==null)?"&nbsp;":rset.getString("THIRD_NAME")));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
if(Family_Name_Accept_Yn.equals("Y")){ 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((rset.getString("FAMILY_NAME")==null)?"&nbsp;":rset.getString("FAMILY_NAME")));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((rset.getString("DATE_OF_BIRTH")==null)?"&nbsp;":rset.getString("DATE_OF_BIRTH")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((rset.getString("CONTACT1_NO")==null)?"&nbsp;":rset.getString("CONTACT1_NO")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rset.getString("PATIENT_ID")));
            _bw.write(_wl_block29Bytes, _wl_block29);

	 rowcnt++;
		 
	 }
            _bw.write(_wl_block30Bytes, _wl_block30);


if(rset != null) rset.close();
if(pstmt != null) pstmt.close();

}
            _bw.write(_wl_block31Bytes, _wl_block31);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
