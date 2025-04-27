package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import eCommon.Common.*;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __notetypeforspecialitiesdetailform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/NoteTypeForSpecialitiesDetailForm.jsp", 1722238962000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eOT/js/NoteTypeForSpecialities.js\"></script>\n\t<script language=\'javascript\' src=\'../../eOT/js/Hashtable.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n</head>\n<BODY class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"NoteTypeForSpecialityDetailForm\" id=\"NoteTypeForSpecialityDetailForm\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<P>\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</td>\n</tr>\n</table>\n<br><br>\n</p>\n<table class=\'grid\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=3  align=\'center\'>\n<th class=\'columnheadercenter\' nowrap > <!-- changed by yadav -->\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n<th class=\'columnheadercenter\'  nowrap> <!-- changed by yadav -->\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n<th class=\'columnheadercenter\' nowrap> <!-- changed by yadav -->\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</table>\n</center>\n<br><center>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n<input type=\"hidden\" name=\"modified_flag\" id=\"modified_flag\" value=\"false\" >\n<input type=\"hidden\" name=\"execute_flag\" id=\"execute_flag\" value=\"YES\" >\n<input type=\"hidden\" name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" >\n<input type=\"hidden\" name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n<input type=\"hidden\" name=\"sel\" id=\"sel\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n<input type=\"hidden\" name=\"totalSelected\" id=\"totalSelected\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n<input type=\"hidden\" name=\"speciality_code\" id=\"speciality_code\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

  //OnMouseDown='CodeArrest()' onKeyDown="lockKey()"
   
   String from = checkForNull(request.getParameter( "from" )) ;
   String to =   checkForNull(request.getParameter( "to" ) ) ;
   String speciality_code=checkForNull(request.getParameter("speciality_code"));
   String totalSelected= checkForNull(request.getParameter("totalSelected"));
   String resp_id		=	(String)session.getValue("responsibility_id");//Changed against 43896
   //out.println("totalSelected"+totalSelected);
   //Cannonicalization of String 
   String empty = "".intern();
   String select_value="Y";
   String location_type_desc=empty;
   String note_type=empty;
   String note_type_desc=empty;
   String sel=empty;
   String select_checked=empty;
   String classValue= empty;
   String locn_type=empty;
   String select_flag1 = empty;
   String select_flag2 = empty;
   String select_flag3 = empty;
   String select_flag4 = empty;
   String disable_flag=empty;
   String deflt =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
  String holding_area =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.HoldingAreaNotes.Label","ot_labels");
  String surgeon_notes=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SurgeonNotes.Label","ot_labels");
  String recovery_notes=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RecoveryNotes.Label","ot_labels");
  int start = ( from.equals("") )?1:Integer.parseInt(from);
  int end =  ( to.equals("") )?14:Integer.parseInt(to);
  StringBuffer sbr = new StringBuffer();
  StringBuffer code = new StringBuffer();
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rst=null;
/*
String strsql="SELECT DECODE(B.LOCN_TYPE, '10','Holding Area Notes', '30', 'Surgeon Notes', '40', 'Recovery Notes') LOCN_TYPE_DESC, A.NOTE_TYPE, A.NOTE_TYPE_DESC, DECODE (B.NOTE_TYPE, A.NOTE_TYPE,'Y','N') SEL, '1' SEQ FROM CA_NOTE_TYPE_LANG_VW A, OT_NOTE_TYPE_FOR_SPECIALTIES B WHERE A.NOTE_TYPE= B.NOTE_TYPE AND B.SPECIALTY_CODE = ? AND A.LANGUAGE_ID = '"+locale+"' UNION select null LOCN_TYPE_DESC, NOTE_TYPE, NOTE_TYPE_DESC,'N' SEL, '2' SEQ FROM CA_NOTE_TYPE_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' ORDER BY 1,2";

*/
//Modified by DhanasekarV against 36651 on  17/12/2012

//String strsql="SELECT DECODE(B.LOCN_TYPE, '10','Holding Area Notes', '30', 'Surgeon Notes', '40', 'Recovery Notes') LOCN_TYPE_DESC, A.NOTE_TYPE, A.NOTE_TYPE_DESC, DECODE (B.NOTE_TYPE, A.NOTE_TYPE,'Y','N') SEL, '1' SEQ FROM CA_NOTE_TYPE_LANG_VW A, OT_NOTE_TYPE_FOR_SPECIALTIES B WHERE A.NOTE_TYPE= B.NOTE_TYPE AND B.SPECIALTY_CODE = ? AND A.LANGUAGE_ID = '"+locale+"' UNION select null LOCN_TYPE_DESC, A.NOTE_TYPE, A.NOTE_TYPE_DESC,'N' SEL, '2' SEQ   FROM CA_NOTE_TYPE_LANG_VW A, CA_NOTE_GROUP B WHERE LANGUAGE_ID =  '"+locale+"'AND NVL(A.EFF_STATUS,'E') = 'E'  AND  A.NOTE_GROUP_ID  = B.NOTE_GROUP  and  B.APPL_TASK_ID = 'OT_NOTES'  ORDER BY 1,2";  
String strsql="SELECT DECODE(B.LOCN_TYPE, '10','Holding Area Notes', '30', 'Surgeon Notes', '40', 'Recovery Notes') LOCN_TYPE_DESC, A.NOTE_TYPE, A.NOTE_TYPE_DESC, DECODE (B.NOTE_TYPE, A.NOTE_TYPE,'Y','N') SEL, '1' SEQ FROM CA_NOTE_TYPE_LANG_VW A, OT_NOTE_TYPE_FOR_SPECIALTIES B WHERE A.NOTE_TYPE= B.NOTE_TYPE AND B.SPECIALTY_CODE = ? AND A.LANGUAGE_ID = ? UNION  SELECT  null LOCN_TYPE_DESC, a.note_type, c.note_type_desc, 'N' SEL, '2' SEQ  FROM ca_note_type_for_resp a, ca_note_type_lang_vw c WHERE a.resp_id = ? AND a.note_type = c.note_type AND c.language_id = ?  AND a.privilege_type != '5' AND NVL(EFF_STATUS,'E') = 'E' AND c.note_group_id IN (SELECT note_group FROM ca_note_group WHERE appl_task_id = 'OT_NOTES')  ORDER BY 1,2";
  int maxRecord = 0;
  int i=1;
    try{
   		conn  =  ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement(strsql);
		pstmt.setString(1,speciality_code);
		pstmt.setString(2,locale);
		pstmt.setString(3,resp_id);//Changed against 43896
		pstmt.setString(4,locale);
		rst = pstmt.executeQuery();
		int total=0;
		while(rst.next()){
			total++;
		}
        maxRecord = total;
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		pstmt=conn.prepareStatement(strsql);
		pstmt.setString(1,speciality_code);
		pstmt.setString(2,locale);
		pstmt.setString(3,resp_id);//Changed against 43896
		pstmt.setString(4,locale);
		rst = pstmt.executeQuery();

            _bw.write(_wl_block7Bytes, _wl_block7);

	if ( !(start <= 1) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font>");
	if ( !( (start+14) > maxRecord ) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");

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
            _bw.write(_wl_block11Bytes, _wl_block11);

		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		rst.next() ;
		int k=0;
		while ( rst.next() && i<=end  ){

			classValue  = ( i % 2 == 0 )?"gridData":"gridData" ; // changed by yadav
			location_type_desc = checkForNull(rst.getString(1),"D").toUpperCase();
			note_type= checkForNull(rst.getString(2));
			note_type_desc=rst.getString(3);
			sel=rst.getString(4);
			disable_flag = ("Y".equals(sel))?"disabled":"";
			switch(location_type_desc.charAt(0)){
				case 'H' :  locn_type="10";   //Holding Area Notes
							select_flag1="";
							select_flag2="selected"; 
							select_flag3="";
							select_flag4="";
							break;  
				case 'R' :  locn_type="40" ; //Recovery Notes
							select_flag1="";
							select_flag2="";
							select_flag3=""; 
							select_flag4="selected";
							break;   
				case 'S' :  locn_type="30";  //Surgeon Notes
							select_flag1="";
							select_flag2="";
							select_flag3="selected"; 
						    select_flag4=""; 
						    break;   
								
			   default  :  locn_type="";  //default = blank;
						   select_flag1="selected"; 
						   select_flag2="";
						   select_flag3=""; 
						   select_flag4="";
						   break;   
				
			}
			sbr.append("<tr>");
			//constructing a List Item
			sbr.append("<td class='"+classValue+"'>");
			sbr.append("<select name=location_type_desc"+i+" id=location_type_desc"+i+" "+disable_flag+" onChange='valueChanged(this);' >");
			//default select
			sbr.append("<option value='' "+select_flag1+">");
			sbr.append("----------");
			sbr.append(deflt);
			sbr.append("----------");
			//holding Area 
			sbr.append("</option>");
			sbr.append("<option value='10' "+select_flag2+">");
			sbr.append(holding_area);
			sbr.append("</option>");
			//Surgeon Notes
			sbr.append("<option value='30' "+select_flag3+">");
			sbr.append(surgeon_notes);
			sbr.append("</option>");
			sbr.append("<option value='40' "+select_flag4+">");
			//Nursing Notes
			sbr.append(recovery_notes);
			sbr.append("</option>");
			sbr.append("</td>");	

			sbr.append("<td class='"+classValue+"'>"+note_type+"</td>");
		    sbr.append("<td class='"+classValue+"'>"+note_type_desc+"</td>");
   			if(sel.equals("Y")){
				   select_checked="checked";
			       select_value="Y";
				   code.append(locn_type).append("@@");
				   code.append(note_type).append("@@");
				   code.append(select_value);
				   sbr.append("<script>pushChkBox('"+i+"','"+code.toString()+"')</script>");
				   code.setLength(0);
				   k++;
			}else{
				select_checked="";
				select_value="N";
			}
			sbr.append("<td class='" + classValue+"'><input type=checkbox name=chk_select"+i+" id=chk_select"+i+" value="+select_value+" "+select_checked+" location_type_desc='"+locn_type+"' note_type="+note_type+" select_yn='"+select_value+"' onclick='validateCheckBox(this);' >");
//			sbr.append("<script>pushDBValues(chk_select"+i+");</script>");
//			out.println("I=== "+i);
			sbr.append("</td>");
		    sbr.append("</tr>");
			/*if("Y".equals(select_value))
			sbr.append("<script>pushDBValues(chk_select"+i+");</script>");*/

			if(totalSelected.length()>0){
			String tokens[] = totalSelected.split(",");
			
			for(int p = 0;p<tokens.length;p++){
				if(Integer.parseInt(tokens[p])==i)
					sbr.append("<script>assingListItemValue("+tokens[p]+");</script>");
			}
		}
		
   			i++;
		}

		sbr.append("<input type='hidden' name='check_code' id='check_code' value="+code.toString()+">");
		out.println(sbr.toString());

			
	
            _bw.write(_wl_block12Bytes, _wl_block12);
 
   }catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rst!=null)	rst.close();
			if(pstmt!=null)	pstmt.close();
			if(sbr!=null)   sbr.setLength(0);
			if(code!=null)  code.setLength(0);
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){}
	}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(start));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(end));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(select_checked));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(totalSelected));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block20Bytes, _wl_block20);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NoteType.label", java.lang.String .class,"key"));
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
}
