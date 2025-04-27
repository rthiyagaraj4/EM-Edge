package jsp_servlet._eoa._js;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __patientgroupcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/js/PatientGroupCriteria.jsp", 1717415561881L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<html>\n\t<head>\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\t<script language=\'javascript\' src=\'../../eOA/js/PatientGroup.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</head>\n\t<body OnMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey()\'>\n\t<form name=\"GroupSearchCriteria\" id=\"GroupSearchCriteria\" id=\"GroupSearchCriteria\">\n\t<table cellpadding=\'1\' cellspacing=\'1\' width=\'100%\' border=\'0\'>\n\t\t<tr>\n\t\t<td class = \'label\'  width = \'10%\' nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t<td width=\'10%\' class=\'fields\'>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"group_id\" id=\"group_id\" >\n\t\t\t\t\t\t<input type=\"hidden\" name=\"min_patient\" id=\"min_patient\" id=\"min_patient\" >\n\t\t\t\t\t\t<input type=\"hidden\" name=\"max_patient\" id=\"max_patient\" id=\"max_patient\" >\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"Existing_Group_Members\" id=\"Existing_Group_Members\" id=\"Existing_Group_Members\" >\n\t\t\t\t\t\t<input type=\"hidden\" name=\"group_location_id\" id=\"group_location_id\" id=\"group_location_id\" >\n\t\t\t\t\t\t<input type=\"text\" name=\"group_name\" id=\"group_name\"  onblur=\'if(this.value!=\"\"){callgroupname(this,document.forms[0].group_name,\"insert\")}else{clearValues(\"insert\");}\'><input type=\"button\" name=\"group_name_lookup\" id=\"group_name_lookup\" value=\"?\" class=\"button\" onclick=\"callgroupname(this,document.forms[0].group_name,\'insert\')\"><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td>\n\t\t<td width=\'80%\'  id=\"TdLocationResult\"></td>\n\t\t</tr>\n\t\t<tr></tr>\n\t\t<tr></tr>\n\t\t\t\n\t</table>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<div id=\"PatientSearchContainer\" style=\"display:none;\">\n\t\t\t <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n\t              <tr>\n\t              \t<td width=\'100%\' class=\"BORDER\" valign=top>\n\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr style=\"margin-top:5px;\">\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"fields\"><Select name=\"Sex\" id=\"Sex\"><Option value=\"A\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="<Option value=\"M\" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option><Option value=\"F\" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option><option value=\"U\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option></Select></td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" </td>\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"fields\"><input type=\"text\" name=\"Dob\" id=\"Dob\" size=\"11\"  onBlur=\"validDateObj(this,\'DMY\',localeName)\" maxlength=\"10\" ><img style=\"cursor=\'hand\'\" name=\'dobCal\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'Dob\',null,null,true);\" >\n\t\t\t\t\t\t\t\t&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t</tr> \n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t \t<td  class=\'label\' >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n                 \t\t\t   \t<td class=\'fields\'><input type=\'text\' name=\'MobileNo\' id=\'MobileNo\' maxlength=\'20\' size=\'25\'  onblur=\'makeValidString(this);\' ></td>\n\t\t\t\t\t\t\t\t<td class=\'button\' colspan=\'1\' width=\'25%\' align=\"right\" ><input type=\"button\" class=\'button\' name=\"search\" id=\"search\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' onClick=\"callSearchResult()\"><input type=\"button\" class=\'button\' name=\"clear\" id=\"clear\" value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' onClick=\"clearAll()\" sgtyle=\"float:right;!important\"></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t              </tr>\n\t          </table>\n\t          \n\t   \t</div>       \n\t</form> \n\n<script>\n\n\nfunction clearAll(){\n\t/*$(\'[name=\"First_Name\"]\').val(\'\');\n\t$(\'[name=\"Second_Name\"]\').val(\'\');\n\t$(\'[name=\"Third_Name\"]\').val(\'\');\n\t$(\'[name=\"Family_Name\"]\').val(\'\');\n\t$(\'[name=\"Dob\"]\').val(\'\');\n\t$(\'[name=\"Sex\"]\').val(\'\');\n\t$(\'[name=\"MobileNo\"]\').val(\'\');*/\n\tparent.frames[2].location.href =\"../../eCommon/html/blank.html\";\n}\n\nfunction callSearchResult(){\n\tvar First_Name = \"\";\n\tif(document.forms[0].First_Name) First_Name= document.forms[0].First_Name.value;\n\tvar Second_Name = \"\";\n\tif(document.forms[0].Second_Name) Second_Name= document.forms[0].Second_Name.value;\n\tvar Third_Name = \"\";\n\tif(document.forms[0].Third_Name) Third_Name= document.forms[0].Third_Name.value;\n\tvar Family_Name = \"\";\n\tif(document.forms[0].Family_Name) First_Name= document.forms[0].Family_Name.value;\n\n\tvar Dob = document.forms[0].Dob.value;\n\tvar Sex = document.forms[0].Sex.value;\n\tvar MobileNo\t= document.forms[0].MobileNo.value;\n\tvar GroupId\t= document.forms[0].group_id.value;\n\tvar Existing_Group_Members\t= document.forms[0].Existing_Group_Members.value;\n\tvar group_location_id\t= document.forms[0].group_location_id.value;\n\tvar max_patient\t= document.forms[0].max_patient.value;\n\tif(First_Name==\"\" && Second_Name==\"\" && Third_Name==\"\" && Family_Name==\"\" && Dob==\"\" && Sex==\"A\" && MobileNo==\"\"){\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\", \"common\"));\n\t\treturn;\n\t}\n\t\tparent.frames[2].location.href = \"../../eOA/jsp/PatientGroupResult.jsp?First_Name=\"+First_Name+\"&Second_Name=\"+Second_Name+\"&Third_Name=\"+Third_Name+\"&Family_Name=\"+Family_Name+\"&Dob=\"+Dob+\"&Sex=\"+Sex+\"&MobileNo=\"+MobileNo+\"&GroupId=\"+GroupId+\"&Existing_Group_Members=\"+Existing_Group_Members+\"&group_location_id=\"+group_location_id+\"&max_patient=\"+max_patient+\"&mode=insert\";\n}\nfunction ChangeInitCase(obj){\n\t\n  var name=obj.value;\n  var spltval = name.split(\" \") ;\n  var temp_name = \"\"\n for(var i=0;i<spltval.length;i++) {\n  var length= obj.value.length;\n  var letter = spltval[i].substring(0,length-(length-1));\n  var rest = spltval[i].substring(1,length);\n  letter=letter.toUpperCase();\n  rest=rest.toLowerCase();\n  var  namenow= letter.concat(rest);\n  temp_name+= namenow+\" \";\n }\n obj.value= temp_name.substring(0,temp_name.length-1);\n\n}\n</script>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);


	Connection con 				= null;
	PreparedStatement pstmt 	= null;
	ResultSet rs				=null;
	
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	String pat_name_as_multipart_yn	= "";
	String first_name_length 	= "";
	String second_name_length 	= "";
	String third_name_length 	= "";
	String family_name_length 	= "";
	String file_type_appl_yn 	= "";
	String errFlag				= "";

            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

		con = ConnectionManager.getConnection(request);
		String Qry_For_Param="SELECT   pat_name_as_multipart_yn, first_name_length, second_name_length,third_name_length,family_name_length FROM mp_param where module_id='MP'";
		pstmt = con.prepareStatement(Qry_For_Param);
	    rs=pstmt.executeQuery();
	   if(rs.next()){
			pat_name_as_multipart_yn	= checkForNull(rs.getString("pat_name_as_multipart_yn"));
			first_name_length 			= rs.getString("first_name_length");
			second_name_length			= rs.getString("second_name_length");
			third_name_length 			= rs.getString("third_name_length");
			family_name_length 			= rs.getString("family_name_length");
	    }else{
	        errFlag = "Y";
	        out.println("<script>alert(getMessage('MP_PARAM_NOT_FOUND','MP'));</script>");
	        out.println("<script>parent.window.close();</script>");         
	    }
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
		String firstRowElement="";
		String firstRowCompleted ="";
	    String Family_No_Link_Yn 			= "";
	    String Family_No_Prompt				= ""; 
	    String First_Name_Accept_Yn 		= "";
	    int First_Name_Order				= 0;
	    String First_Name_Prompt 			= "";
	    String Second_Name_Accept_Yn 		= "";
	    int Second_Name_Order				= 0;
	    String Second_Name_Prompt 			= "";
	    String Third_Name_Accept_Yn			= "";
	    int Third_Name_Order 				= 0;
	    String Third_Name_Prompt 			= "";
	    String Family_Name_Accept_Yn 		= ""; 
	    int Family_Name_Order 				= 0;
	    String Family_Name_Prompt			= "";
	    int patient_id_length				= 0;
		String Family_Name_loc_lang_Prompt	= "";
		String First_Name_loc_lang_Prompt	= "";
		String Second_Name_loc_lang_Prompt	= "";
		String Third_Name_loc_lang_Prompt	= "";
		
		 
		 
		 
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
	                 First_Name_Order = rs.getInt("First_Name_Order");
	                 First_Name_Prompt = rs.getString("First_Name_Prompt")==null ? "First Name" : rs.getString("First_Name_Prompt");
	                
	                 Second_Name_Accept_Yn = rs.getString("Second_Name_Accept_Yn")==null ? "N" : rs.getString("Second_Name_Accept_Yn");
	                 Second_Name_Order = rs.getInt("Second_Name_Order");
	                 Second_Name_Prompt = rs.getString("Second_Name_Prompt")==null ? "Second Name" : rs.getString("Second_Name_Prompt");
	                
	                 Third_Name_Accept_Yn = rs.getString("Third_Name_Accept_Yn")==null ? "N" : rs.getString("Third_Name_Accept_Yn");
	                 Third_Name_Order = rs.getInt("Third_Name_Order");
	                 Third_Name_Prompt = rs.getString("Third_Name_Prompt")==null ? "Third Name" : rs.getString("Third_Name_Prompt");

					 First_Name_loc_lang_Prompt=checkForNull(rs.getString("First_Name_loc_lang_Prompt"));
					 Second_Name_loc_lang_Prompt=checkForNull(rs.getString("Second_Name_loc_lang_Prompt"));
					 Third_Name_loc_lang_Prompt=checkForNull(rs.getString("Third_Name_loc_lang_Prompt"));
					 Family_Name_loc_lang_Prompt=checkForNull(rs.getString("Family_Name_loc_lang_Prompt"));

                	 Family_Name_Accept_Yn = rs.getString("Family_Name_Accept_Yn")==null ? "N" : rs.getString("Family_Name_Accept_Yn");
                 	 Family_Name_Order = rs.getInt("Family_Name_Order");
              
					 if(pat_name_as_multipart_yn.equals("N")){
						Family_Name_Order = 4;
					 }
					 Family_Name_Prompt = rs.getString("Family_Name_Prompt")==null ? "Family Name" : rs.getString("Family_Name_Prompt");
                   }
               }
           }catch(Exception e) { out.println(e.toString());}
           finally
           {
               if (pstmt != null) pstmt.close();
               if (rs != null) rs.close();
               if(con!=null) ConnectionManager.returnConnection(con,request);
           }

		 
		
	
            _bw.write(_wl_block11Bytes, _wl_block11);

									
						
								if(pat_name_as_multipart_yn.equals("Y")){  
	                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
	                                    	out.println("<td   width='25%' class='label'>" + First_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'></td>");
											firstRowElement="Y";
	                                    }
	                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
	                                        out.println("<td  width='25%' class='label'>" + Second_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields' ><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
											firstRowElement="Y";
	                                    }
	                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 ) {
	                                        out.println("<td   width='25%' class='label'>" + Third_Name_Prompt + "</td>");
	                                        out.println("<td    width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='15' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
											firstRowElement="Y";
	                                    }
	                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
	                                        out.println("<td   width='25%' class='label'>" + Family_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
											firstRowElement="Y";
	                                    }
	                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==0 ) {
	                                    out.println("<input type='hidden' name='First_Name' id='First_Name' >");
	                                }
	                                else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
	                                    out.println("<input type='hidden' name='Second_Name' id='Second_Name' >");
	                                }
	                                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
	                                    out.println("<input type='hidden' name='Third_Name' id='Third_Name' >");
	                                }
	                                else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
	                                    out.println("<input type='hidden' name='Family_Name' id='Family_Name' >");
	                                    }
										 if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
	                                        out.println("<td  width='25%' class='label'>" + First_Name_Prompt + "</td>");
	                                        out.println("<td  width='25%' class='fields' ><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
											if(firstRowElement.equals("Y")){
												firstRowCompleted="Y";
											}else{
												firstRowElement="Y";
											}
	                                    }
	                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
	                                        out.println("<td  width='25%' class='label'>" + Second_Name_Prompt + "</td>");
	                                        out.println("<td  width='25%' class='fields' ><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
											if(firstRowElement.equals("Y")){
												firstRowCompleted="Y";
											}else{
												firstRowElement="Y";
											}
	                                    }
	                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 ) {
	                                        out.println("<td  width='25%' class='label'>" + Third_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
											if(firstRowElement.equals("Y")){
												firstRowCompleted="Y";
											}else{
												firstRowElement="Y";
											}
	                                    }
	                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
	                                        out.println("<td   width='25%' class='label'>" + Family_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
											if(firstRowElement.equals("Y")){
												firstRowCompleted="Y";
											}else{
												firstRowElement="Y";
											}
	                                    }
	                                   
	
										if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
											if(firstRowCompleted.equals("Y")){
												out.println("</tr><tr>");
											}
	                                        out.println("<td   width='25%' class='label'>" + First_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
											if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
												firstRowCompleted="Y";
											}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
												firstRowCompleted="N";
											}
	                                    }
	                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
											if(firstRowCompleted.equals("Y")){
												out.println("</tr><tr>");
											}
	                                        out.println("<td  width='25%'  class='label'>" + Second_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
											if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
												firstRowCompleted="Y";
											}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
												firstRowCompleted="N";
											}
	                                    }
	                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 ) {
											if(firstRowCompleted.equals("Y")){
												out.println("</tr><tr>");
											}
	                                        out.println("<td  width='25%' class='label'>" + Third_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
											if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
												firstRowCompleted="Y";
											}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
												firstRowCompleted="N";
											}
	                                    }
	                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
											if(firstRowCompleted.equals("Y")){
												out.println("</tr><tr>");
											}
	                                        out.println("<td   width='25%' class='label'>" + Family_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
											if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
												firstRowCompleted="Y";
											}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
												firstRowCompleted="N";
											}
	                                    }
	                         
	                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
											if(firstRowCompleted.equals("Y")){
												out.println("</tr><tr>");
											}
	                                        out.println("<td  width='25%' class='label'>" + First_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields' ><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
	                                    }
	                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
											if(firstRowCompleted.equals("Y")){
												out.println("</tr><tr>");
											}
	                                        out.println("<td  width='25%' class='label'>" + Second_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
	                                    }
	                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 ) {
											if(firstRowCompleted.equals("Y")){
												out.println("</tr><tr>");
											}
	                                        out.println("<td  width='25%' class='label'>" + Third_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='"+third_name_length+"'	onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
	                                    }
	                                   else
										  if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4) {
										   if(firstRowCompleted.equals("Y")){
												out.println("</tr><tr>");
											}
	                                        out.println("<td   width='25%' class='label'>" + Family_Name_Prompt + "</td>");
	                                        out.println("<td  width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
											
									   }
									      else {
	                                        out.println("<td   class='label'>&nbsp;</td>");
	                                        out.println("<td   class='label'>&nbsp;</td>");
	                                    }
									}
									
									if (pat_name_as_multipart_yn.equals("N"))	
									{			out.println("<td nowrap  width='25%' class='label'>" + Family_Name_Prompt + "</td>");
												out.println("<td  nowrap class='fields' width='25%'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);EnableSearchBy(this);'     style=\"text-align:left\">");
												String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
												String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
												String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
												out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By'><option value='S'>"+startwith+"</option><option value='C'>"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
										}
											else
											out.println("</td>");
									
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GroupName.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
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
}
