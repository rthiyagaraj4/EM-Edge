package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.StringTokenizer;
import java.util.TreeMap;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recordpatientadverseevent10 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecordPatientAdverseEvent10.jsp", 1740388156247L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<head><title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n  <Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\n  <script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n    <!-- <script language=\'javascript\' src=\'../../eMR/js/eMRmessages.js\' ></script> -->\n   <script language=\'javascript\' src=\'../../eCommon/js/dchk.js\' ></script>\n  <script language=\'javascript\' src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n <script language=\'javascript\' src=\"../../eMR/js/RecordPatientAdverseEvent.js\"></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n   <form name = \'view_form\'>\n\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<table cellpadding=\'0\'  border=\'1\' cellspacing=\'0\' width=\'100%\' align=\'left\' >\t\n\t\t<th><div  id=\'head1\' class=\'myClass\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</div></th>\n\t\t<th><div  id=\'head2\' class=\'myClass\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</div></th>\n\t\t<th><div  id=\'head3\' class=\'myClass\' nowrap  width=\'25%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<input type=\'checkbox\' name=\'selectall\' id=\'selectall\' onClick=\'selectAll_S(this);\' /></div></th>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'left\' class=\'label\' nowrap >&nbsp;";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp</td>\n\t\t\t\t\t<td align=\'left\' class=\'label\' nowrap >&nbsp;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;</td>\n\t\t\t\t\t<td align=\'center\' class=\'label\' nowrap ><input type=checkbox name=\'checkBox";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' id=\'checkBox";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' value=\'\' onClick=\"javascript:react_chkbox(this,\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\');\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">\n\t\t\t\t\t<input type=\'hidden\' name=\'reaction_code_index";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' id=\'reaction_code_index";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'ret_value\' id=\'ret_value\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'reaction_code";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'reaction_code";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\t&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<script>\n\t\t\t\tvar error=getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\");\n\t\t\t\talert(error);\n\t\t\t\tif(parent.frames[0].document.forms[0])\n\t\t\t\t{\n\t\t\t\t\tif(parent.frames[0].document.forms[0].search_text.value != \"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[0].document.forms[0].search_text.value = \"\";\n\t\t\t\t\t\tvaltextReaction(parent.frames[0].document.forms[0].search_text.value);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<input type=\'hidden\' name=\'count_reac\' id=\'count_reac\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t\t<input type=\'hidden\' name=\'finalval\' id=\'finalval\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'react_val\' id=\'react_val\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t<input type=\'hidden\' name=\'event_done\' id=\'event_done\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n  </form>\n</body>\n<script>if(parent.frames[0].document.forms[0])\n{\n\tparent.frames[0].document.forms[0].Search.disabled=false;\n}\n</script>\n</html>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

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
            webbeans.eCommon.RecordSet adverseReaction1= null;synchronized(session){
                adverseReaction1=(webbeans.eCommon.RecordSet)pageContext.getAttribute("adverseReaction1",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(adverseReaction1==null){
                    adverseReaction1=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("adverseReaction1",adverseReaction1,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	  
	  Connection con = ConnectionManager.getConnection(request);
	  ResultSet rs   = null;
	  Statement stmt = null;
	  HashSet tabdata;	
	  HashSet tabdata1;	
	  String adv_reac_code="";
	  String adv_reac_code1="";
	  String long_desc = "";
	  String reac_val="";
	 // String react_val1="";
	  String react_val2="";
	  String dsib="";
		boolean first_time			= true;
		String allergenCode = "";
		StringBuffer allergenCodelist = new StringBuffer();
		StringBuffer allergenCodelist1 = new StringBuffer();
		StringBuffer reac_caused = new StringBuffer();
	  ArrayList a= new ArrayList();
	  a= adverseReaction1.getRecordSetHandle();
	  int size=0;
	  size=a.size();
	  String locale = (String)session.getAttribute("LOCALE");
	   String react_val=request.getParameter("react_val")==null?"":request.getParameter("react_val");
	   String allergen=request.getParameter("allergen")==null?"":request.getParameter("allergen");
	   String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	   	String flag=request.getParameter("flag")==null?"":request.getParameter("flag");
	   	String search_text=request.getParameter("search_text")==null?"":request.getParameter("search_text");
		String event_done=request.getParameter("event_done")==null?"":request.getParameter("event_done");
		//String errorMsg=request.getParameter("errorMsg")==null?"":request.getParameter("errorMsg");
		String checkedRec=request.getParameter("checkedRec")==null?"":request.getParameter("checkedRec");
		String onblurRec=request.getParameter("onblurRec")==null?"N":request.getParameter("onblurRec");

	   //	String adv_event_ind=request.getParameter("adv_event_ind")==null?"":request.getParameter("adv_event_ind");
	   //	String adv_event_type=request.getParameter("adv_event_type")==null?"":request.getParameter("adv_event_type");
	   //	String patientId=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");


	try 
	{
	
		
	
            _bw.write(_wl_block9Bytes, _wl_block9);

		//stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt=con.createStatement();
		tabdata = new HashSet();
		tabdata1 = new HashSet();
		if(mode.equals("record"))
		{
			 for(int j=0;j<size;j++)
				{
					react_val2=a.get(j).toString();
					if(!react_val2.equals(""))
					{
						StringTokenizer token=new StringTokenizer(react_val2,"@");
						while(token.hasMoreTokens()){
							reac_val=token.nextToken();
							tabdata1.add(reac_val);
						}
					}
				}
		}
		 if(mode.equals("record") )
		{
			 if(react_val.equals(""))
			 {
				 for(int i=0;i<size;i++)
				{
					 
					react_val2=a.get(i).toString();
					if(!react_val2.equals(""))
					{
						StringTokenizer token=new StringTokenizer(react_val2,"@");
						while(token.hasMoreTokens()){
							reac_val=token.nextToken();
							tabdata.add(reac_val);
						}
					}
				}
			 }else
			{
				StringTokenizer token=new StringTokenizer(react_val,"@");
				while(token.hasMoreTokens()){
				reac_val=token.nextToken();
				
				tabdata.add(reac_val);
			}
			}
			allergenCodelist1.setLength(0);
			if(!react_val.equals(""))
			{
				StringTokenizer token=new StringTokenizer(react_val,"@");
				while(token.hasMoreTokens()){
					reac_val=token.nextToken();
					tabdata.add(reac_val);
					if(first_time){
					allergenCode="'"+reac_val+"',";
								}else{
					allergenCode=allergenCode+"'"+reac_val+"',";
					}
				first_time = false;
				}
				if(allergenCode!=""){
				allergenCode =allergenCode.substring(0,allergenCode.length()-1);
				}
				allergenCodelist1.append(allergenCode) ;
			}
			allergenCodelist.setLength(0);
			if(!checkedRec.equals(""))
			{
				StringTokenizer token=new StringTokenizer(checkedRec,"@");
				while(token.hasMoreTokens()){
				reac_val=token.nextToken();
				tabdata.add(reac_val);
				if(first_time){
					allergenCode="'"+reac_val+"',";
								}else{
					allergenCode=allergenCode+"'"+reac_val+"',";
					}
				first_time = false;
				
				}
				if(allergenCode!=""){
				allergenCode =allergenCode.substring(0,allergenCode.length()-1);
				}
				allergenCodelist.append(allergenCode) ;
			}
		}else 
		{
			allergenCodelist1.setLength(0);
			if(!react_val.equals(""))
			{
				StringTokenizer token=new StringTokenizer(react_val,"@");
				while(token.hasMoreTokens()){
					reac_val=token.nextToken();
					tabdata.add(reac_val);
					if(first_time){
					allergenCode="'"+reac_val+"',";
								}else{
					allergenCode=allergenCode+"'"+reac_val+"',";
					}
				first_time = false;
				}
				if(allergenCode!=""){
				allergenCode =allergenCode.substring(0,allergenCode.length()-1);
				}
				allergenCodelist1.append(allergenCode) ;
			}
			allergenCodelist.setLength(0);
			if(!checkedRec.equals(""))
			{
				StringTokenizer token=new StringTokenizer(checkedRec,"@");
				while(token.hasMoreTokens()){
				reac_val=token.nextToken();
				tabdata.add(reac_val);
				if(first_time){
					allergenCode="'"+reac_val+"',";
								}else{
					allergenCode=allergenCode+"'"+reac_val+"',";
					}
				first_time = false;
				
				}
				if(allergenCode!=""){
				allergenCode =allergenCode.substring(0,allergenCode.length()-1);
				}
				allergenCodelist.append(allergenCode) ;
			}
		}
		
		String checkBoxAttribute1="";
		int maxRecord=0;
		int maxRecordCnt=0;
		int i=0;
		int rowcolor=0;
		if(rs !=null) rs.close();
			reac_caused.setLength(0);
			reac_caused.append("select count(1)  from (select '#'ORD,REACTION_CODE REACTION_CODE ,LONG_DESC  LONG_DESC from  AM_REACTION_LANG_VW Where REACTION_CODE LIKE 'UNKN%' and language_id='"+locale+"' and EFF_STATUS='E' UNION select '$' ORD,a.REACTION_CODE REACTION_CODE,a.LONG_DESC  LONG_DESC from  AM_REACTION_LANG_VW a, MR_ADV_REA_CAUSE_AGENT b where a.REACTION_CODE=b.ADV_REAC_CODE AND UPPER(a.LONG_DESC) like upper('"+search_text+"%') and a.language_id='"+locale+"' ");
			if(!allergen.equals("Oth"))//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
				reac_caused.append(" and b.ALLERGEN_CODE='"+allergen+"' ");
			reac_caused.append(" and a.EFF_STATUS='E') ORDER BY reaction_code ");

			rs=stmt.executeQuery(reac_caused.toString());
			if(rs !=null && rs.next())
					maxRecordCnt = rs.getInt(1);
			if(maxRecordCnt > 0)
			{
			reac_caused.setLength(0);
			if(!checkedRec.equals(""))
			{
				reac_caused.append("select REACTION_CODE ,LONG_DESC   from (select '#'ORD,REACTION_CODE REACTION_CODE ,LONG_DESC  LONG_DESC from  AM_REACTION_LANG_VW Where ");
				if(search_text.equals(""))
					reac_caused.append(" REACTION_CODE LIKE 'UNKN%' ");
				else
					reac_caused.append(" ( REACTION_CODE LIKE 'UNKN%' or reaction_code in ("+allergenCodelist+")) ");
				reac_caused.append(" and language_id='"+locale+"' and EFF_STATUS='E' UNION select '$' ORD,a.REACTION_CODE REACTION_CODE,a.LONG_DESC  LONG_DESC from  AM_REACTION_LANG_VW a, MR_ADV_REA_CAUSE_AGENT b where (a.REACTION_CODE=b.ADV_REAC_CODE) ");
				reac_caused.append(" AND UPPER(a.LONG_DESC) like upper('"+search_text+"%') ");
				reac_caused.append(" and a.language_id='"+locale+"' ");
				if(!allergen.equals("Oth"))//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
					reac_caused.append(" and  b.ALLERGEN_CODE='"+allergen+"' ");
				reac_caused.append(" and a.EFF_STATUS='E' ");
				if(onblurRec.equals("Y"))
					reac_caused.append(" and a.reaction_code not in (SELECT reaction_code  FROM am_reaction_lang_vw WHERE (reaction_code LIKE 'UNKN%' OR reaction_code IN ("+allergenCodelist+")) AND language_id = '"+locale+"'     AND eff_status = 'E') ");
				reac_caused.append(" ) ORDER BY reaction_code ");
			}else if(!react_val.equals("")){
				reac_caused.append("select REACTION_CODE ,LONG_DESC   from (select '#'ORD,REACTION_CODE REACTION_CODE ,LONG_DESC  LONG_DESC from  AM_REACTION_LANG_VW Where ");
				if(search_text.equals(""))
					reac_caused.append(" REACTION_CODE LIKE 'UNKN%' ");
				else
					reac_caused.append(" ( REACTION_CODE LIKE 'UNKN%' or reaction_code in ("+allergenCodelist1+")) ");
				reac_caused.append(" and language_id='"+locale+"' and EFF_STATUS='E' UNION select '$' ORD,a.REACTION_CODE REACTION_CODE,a.LONG_DESC  LONG_DESC from  AM_REACTION_LANG_VW a, MR_ADV_REA_CAUSE_AGENT b where (a.REACTION_CODE=b.ADV_REAC_CODE) ");
				reac_caused.append(" AND UPPER(a.LONG_DESC) like upper('"+search_text+"%') ");
				reac_caused.append(" and a.language_id='"+locale+"' ");
				if(!allergen.equals("Oth"))//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
					reac_caused.append(" and  b.ALLERGEN_CODE='"+allergen+"' ");
				reac_caused.append(" and a.EFF_STATUS='E' ");
				if(onblurRec.equals("Y"))
					reac_caused.append(" and a.reaction_code not in (SELECT reaction_code  FROM am_reaction_lang_vw WHERE (reaction_code LIKE 'UNKN%' OR reaction_code IN ("+allergenCodelist1+")) AND language_id = '"+locale+"'     AND eff_status = 'E') ");
				reac_caused.append(" ) ORDER BY reaction_code ");
			}
			else
			{
				reac_caused.append(" select REACTION_CODE ,LONG_DESC   from (select '#'ORD,REACTION_CODE REACTION_CODE ,LONG_DESC  LONG_DESC from  AM_REACTION_LANG_VW Where REACTION_CODE LIKE 'UNKN%' and language_id='"+locale+"' and EFF_STATUS='E' UNION select '$' ORD,a.REACTION_CODE REACTION_CODE,a.LONG_DESC  LONG_DESC from  AM_REACTION_LANG_VW a, MR_ADV_REA_CAUSE_AGENT b where a.REACTION_CODE=b.ADV_REAC_CODE AND UPPER(a.LONG_DESC) like upper('"+search_text+"%') and a.language_id='"+locale+"' ");
				if(!allergen.equals("Oth"))//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
					reac_caused.append(" and  b.ALLERGEN_CODE='"+allergen+"' ");
				reac_caused.append(" and a.EFF_STATUS='E') ORDER BY reaction_code");
			}
			//if(rs !=null) rs.close();
			//if(stmt !=null) stmt.close();
			rs=stmt.executeQuery(reac_caused.toString());
			/*rs.last();
			count = rs.getRow();
			rs.beforeFirst();
			if(count >0)*/
		if(rs !=null)
		{
			while(rs.next())
			{
			if(maxRecord == 0)
		{	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
		}
		/*if(rs !=null)
		{

			while(rs.next())
			{*/
				long_desc=rs.getString("LONG_DESC");
				adv_reac_code=rs.getString("REACTION_CODE");
				if(flag.equals("N"))
				{
					dsib="disabled";
				}else
				{
					dsib="";
				}
			
				if(!adv_reac_code.equals(adv_reac_code1))
				{
					if(tabdata.contains(adv_reac_code))
					{
						checkBoxAttribute1="CHECKED";
					}else
					{
						checkBoxAttribute1="";
					}

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(adv_reac_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(checkBoxAttribute1));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(dsib));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(adv_reac_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(adv_reac_code));
            _bw.write(_wl_block27Bytes, _wl_block27);

					i=i+1;
					rowcolor++;	
				}
				adv_reac_code1=rs.getString("REACTION_CODE");
				maxRecord++;
			}
			
			}
		}
		//else
		//{
		if(maxRecordCnt == 0)
		{
			
            _bw.write(_wl_block28Bytes, _wl_block28);

		}
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rowcolor));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(react_val));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(event_done));
            _bw.write(_wl_block32Bytes, _wl_block32);

			if(rs !=null) rs.close();
		  if(stmt !=null) stmt.close();
     } catch(Exception e) {
          //out.println(e.toString());
		  e.printStackTrace();
          if(rs !=null) rs.close();
		  if(stmt !=null) stmt.close();
     }
     finally {
    
		  ConnectionManager.returnConnection(con,request);
     }

            _bw.write(_wl_block33Bytes, _wl_block33);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Reaction.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReactionCode.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.reactiondesc.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
