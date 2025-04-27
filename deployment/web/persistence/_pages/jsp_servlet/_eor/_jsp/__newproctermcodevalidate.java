package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;

public final class __newproctermcodevalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/NewProcTermCodeValidate.jsp", 1709119752000L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block1 ="\n<html>\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<head>\n<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/common.js\'></Script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/ValidateControl.js\'></Script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/NewProcedureTermCode.js\"></script>\n<SCRIPT LANGUAGE=\"JavaScript\">\n<!--\n\n\n//-->\n</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body OnMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\">\n<form name=\"\" id=\"\"  method =\'post\' action=\'\'>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n</body>\n</html>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

	String replaceString(String sourceString,String str,String replaceWith)
	{
		int index=0;
		StringBuffer sourceBuffer = new StringBuffer(sourceString);
		while((index=sourceBuffer.toString().indexOf(str))!=-1)
		{
			sourceBuffer=sourceBuffer.replace(index,index+1,replaceWith);

		}
		return sourceBuffer.toString();
	}

	


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet TerminologyLookup= null;synchronized(session){
                TerminologyLookup=(webbeans.eCommon.RecordSet)pageContext.getAttribute("TerminologyLookup",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(TerminologyLookup==null){
                    TerminologyLookup=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("TerminologyLookup",TerminologyLookup,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);



String textName				= (String)request.getParameter("textName") == null ? "" : request.getParameter("textName");
System.out.println("==========================textName====="+textName+"====");
//out.println("<script>alert('in textName:--"+textName+"--')</script>");

try
{ 
	//eCP.GCPGeneratePlanBean bean	= (eCP.GCPGeneratePlanBean)session.getAttribute("GCPGenerateBean");	
	//out.println("<script>alert('in the get bean:::"+bean+"')</script>");	
	//bean.clearBean();
	ArrayList Terminology = null;
	HashMap Termcode= null;
	if(TerminologyLookup.getSize()>0){
		
		Terminology = (ArrayList)TerminologyLookup.getObject(0);
		Termcode = (HashMap)Terminology.get(0);
		if(textName.equals("clear_values")){
			String clearValues = (String)request.getParameter("clear_values")==null?"":(String)request.getParameter("clear_values");
			//System.out.println("==============clear_values====="+clearValues+"====");
			if(clearValues.equals("clearValues")){
				Terminology = new ArrayList();
				Termcode = new HashMap();
				System.out.println("==============clear_values====="+clearValues+"====");
			}
		}
	}else{
		Terminology = new ArrayList();
		Termcode = new HashMap();
	}
	if(textName.equals("termgrp_code"))
	{
		String termgrp_code= request.getParameter("termgrp_code")==null ?"":(String)request.getParameter("termgrp_code");
		
		String tmp_grp_id="",chk_val="";
		StringTokenizer tokens = new StringTokenizer(termgrp_code,"::");
		StringTokenizer grp_tokens = null;
		//int cnt_tokens = tokens.countTokens() ;
		//if(Terminology !=null)
		//	Terminology.clear();
		//System.out.println("Termcode===="+Termcode+"====");
		//System.out.println("cnt_tokens===="+cnt_tokens+"====");
		while(tokens.hasMoreTokens()){
			grp_tokens = new StringTokenizer(tokens.nextToken(),"~");
			tmp_grp_id = grp_tokens.nextToken();
			chk_val = grp_tokens.nextToken();
			Termcode.put(tmp_grp_id,chk_val);
			//System.out.println("tmp_grp_id===="+tmp_grp_id+"====");
			//System.out.println("chk_val===="+chk_val+"====");
		}
		//TerminologyLookup.clearAll();
		if(Terminology != null & Terminology.size() > 0){
		Terminology.set(0,Termcode);
		System.out.println("Terminology=in if==="+Terminology+"====");
		}else{
			Terminology.add(0,Termcode);
			System.out.println("Terminology=in else==="+Terminology+"====");
		}
System.out.println("Terminology=after==="+Terminology+"===="+Terminology.size()+"---"+TerminologyLookup.getSize());
		if(TerminologyLookup.getSize()>0){
			TerminologyLookup.setObject(0,Terminology);
		}else
			TerminologyLookup.putObject(Terminology);
		System.out.println("--getSize-termgrp_code-"+TerminologyLookup.getSize()+"==");
	}else if(textName.equals("term_code")){
		String term_code= request.getParameter("term_code")==null ?"":(String)request.getParameter("term_code");
		
		String tmp_grp_id="",chk_val="";
		StringTokenizer tokens = new StringTokenizer(term_code,"::");
		StringTokenizer grp_tokens = null;
		//int cnt_tokens = tokens.countTokens() ;
		//if(Terminology !=null)
		//	Terminology.clear();
		//System.out.println("Termcode===="+Termcode+"====");
		//System.out.println("cnt_tokens===="+cnt_tokens+"====");
		while(tokens.hasMoreTokens()){
			grp_tokens = new StringTokenizer(tokens.nextToken(),"~");
			tmp_grp_id = grp_tokens.nextToken();
			chk_val = grp_tokens.nextToken();
			Termcode.put(tmp_grp_id,chk_val);
			//System.out.println("tmp_grp_id===="+tmp_grp_id+"====");
			//System.out.println("chk_val===="+chk_val+"====");
		}
		//System.out.println("getSize===="+TerminologyLookup.getSize()+"===="+Terminology.size());
		if(Terminology != null & Terminology.size() > 0){
			Terminology.set(0,Termcode);
		}else{
			Terminology.add(0,Termcode);
		}	System.out.println("Terminology=after=TC=="+Terminology+"===="+Terminology.size()+"---"+TerminologyLookup.getSize());	
		if(TerminologyLookup.getSize()>0){
			TerminologyLookup.setObject(0,Terminology);
		}else
			TerminologyLookup.putObject(Terminology);
System.out.println("getSize==term_code=="+TerminologyLookup.getSize()+"===="+Terminology.size());
	}else if(textName.equals("clear_values")){
		TerminologyLookup.clearAll();
	}else if(textName.equals("close_values")){
		if(TerminologyLookup.getSize()>0){
			TerminologyLookup.setObject(0,(ArrayList)TerminologyLookup.getObject(1));
			System.out.println("getSize==B4 Val=="+TerminologyLookup.getSize()+"===="+Terminology);
			TerminologyLookup.removeObject(1);
			System.out.println("getSize==after Val=="+TerminologyLookup.getSize()+"====");
		}
		
	}else if(textName.equals("pre_values")){
		System.out.println("getSize==Prev Val=="+TerminologyLookup.getSize()+"===="+Terminology.size());
		if(TerminologyLookup.getSize() == 1){
			ArrayList tmp_array = Terminology;
			//HashMap tmp_hash = (HashMap)Terminology.get(0);
			TerminologyLookup.clearAll();
			TerminologyLookup.putObject(Terminology);
			System.out.println("getSize==Prev Val=backup of prev ones="+TerminologyLookup.getSize()+"==val=="+TerminologyLookup.getObject(0)+"==="+TerminologyLookup.getRecordSetHandle()+"====");
			TerminologyLookup.putObject(tmp_array);
			System.out.println("getSize==Prev Val=backup of prev ones="+TerminologyLookup.getSize()+"==1=="+TerminologyLookup.getObject(1)+"=="+TerminologyLookup.getRecordSetHandle()+"====");
			//System.out.println("containsObject ones="+TerminologyLookup.containsObject(tmp_array)+"====");
			//System.out.println("getSize==Prev Val=backup of prev ones="+TerminologyLookup.getSize()+"==val=="+TerminologyLookup.getObject(0)+"=="+TerminologyLookup.getObject(1)+"==="+TerminologyLookup.getRecordSetHandle()+"===="+Terminology);
			//System.out.println("getSize==Prev Val=backup of prev ones="+tmp_array+"==val==");
			//TerminologyLookup.setObject(1,Terminology);
		}else{
			String clearValues = (String)request.getParameter("pre_values")==null?"":(String)request.getParameter("pre_values");
			System.out.println("==============pre_values clear====="+clearValues+"====");
			if(clearValues.equals("clearValues")){
				
				Termcode = new HashMap();
				if(Terminology != null & Terminology.size() > 0){
					Terminology.set(0,Termcode);
				}else
					Terminology.add(0,Termcode);
				System.out.println("Terminology=="+Terminology+"===");
				Terminology.add(0,Termcode);
				System.out.println("getSize=1=Prev Val=="+TerminologyLookup.getSize()+"==1=="+TerminologyLookup.getObject(0));
				TerminologyLookup.setObject(0,Terminology);
				System.out.println("getSize=2=Prev Val=="+TerminologyLookup.getSize()+"==2=="+TerminologyLookup.getObject(1));
				//System.out.println("getSize===0==="+(((TerminologyLookup.getObject(0)).get(0)).size()));
			}
			
		}
		
	}


}
catch(Exception ee)
{
	//out.println("Exception in validate terminology"+ee.toString());//COMMON-ICN-0181
	System.out.println("Exception in validate terminology"+ee.toString());
	ee.printStackTrace();
}


            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
