package eCommon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
//import org.owasp.esapi.ESAPI;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponseWrapper;
import eCommon.Common.CommonBean;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;

public class XSSPreventionFilter implements Filter {
  class XSSFilterRequestWrapper extends HttpServletRequestWrapper  {
	
	  public XSSFilterRequestWrapper(HttpServletRequest servletRequest) {
       super(servletRequest);
		
    }
	    private  Pattern[] patterns = new Pattern[]{
			 // Script fragments
            Pattern.compile("<script>", Pattern.CASE_INSENSITIVE),
			// Pattern.compile("<(no)?script[^>]*>.*?</(no)?script>", Pattern.CASE_INSENSITIVE),
			  Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
			// Style fragments
			  Pattern.compile("<style>(.+?)</style>", Pattern.CASE_INSENSITIVE),
            // Script fragments
            Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // src='...'
            //Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL), //Commented By Gaurav Against ML-MMOH-SCF-2839
           // Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL), //Commented By Gaurav Against ML-MMOH-SCF-2839
            // lonely script tags
            Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
			 Pattern.compile("(?<=src=\")[^\"]*(?<!\")", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // eval(...)
            Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // expression(...)
            Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // javascript:...
            Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
            // vbscript:...
            Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),
			// Pattern.compile("(javascript:|vbscript:|view-source:)*", Pattern.CASE_INSENSITIVE),
			 // Pattern.compile("<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>", Pattern.CASE_INSENSITIVE),
            // onload(...)=...
            Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			// anchor fragments
			Pattern.compile("(?i)<a([^>]+)>(.+?)</a>", Pattern.CASE_INSENSITIVE),
			  // anchor href fragments
			Pattern.compile("\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))", Pattern.CASE_INSENSITIVE),
			//Pattern.compile("(window\\.location|window\\.|\\.location|document\\.cookie|document\\.|alert\\(.*?\\)|window\\.open\\()*", 
			//Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL), //(commented for location lookup title visible)
			Pattern.compile("<+\\s*\\w*\\s*(oncontrolselect|oncopy|oncut|ondataavailable|ondatasetchanged|ondatasetcomplete|ondblclick|ondeactivate|ondrag|ondragend|ondragenter|ondragleave|ondragover|ondragstart|ondrop|onerror=|onerroupdate|onfilterchange|onfinish|onfocus|onfocusin|onfocusout|onhelp|onkeydown|onkeypress|onkeyup|onlayoutcomplete|onload|onlosecapture|onmousedown|onmouseenter|onmouseleave|onmousemove|onmousout|onmouseover|onmouseup|onmousewheel|onmove|onmoveend|onmovestart|onabort|onactivate|onafterprint|onafterupdate|onbefore|onbeforeactivate|onbeforecopy|onbeforecut|onbeforedeactivate|onbeforeeditocus|onbeforepaste|onbeforeprint|onbeforeunload|onbeforeupdate|onblur|onbounce|oncellchange|onchange|onclick|oncontextmenu|onpaste|onpropertychange|onreadystatechange|onreset|onresize|onresizend|onresizestart|onrowenter|onrowexit|onrowsdelete|onrowsinserted|onscroll|onselect|onselectionchange|onselectstart|onstart|onstop|onsubmit|onunload)+\\s*=+", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL)
    };
	// StatusExposingServletResponse response1 = new StatusExposingServletResponse((HttpServletResponse));		
	
  
    public String[] getParameterValues(String parameter) {
		//	System.err.println("XSSPreventionFilter called =======================");
        String[] values = super.getParameterValues(parameter);
        if (values==null)  {
            return null;
        }
        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = sanitizeXSS(values[i]);
        }
        return encodedValues;
    }
    public String getParameter(String parameter) {
		//	System.out.println("XSSRequestWrapper called parameter : "+parameter);		
        String value = super.getParameter(parameter);
		//System.out.println("XSSRequestWrapper called parameter value : "+value);
        if (value == null) {
            return null;
        }
	//	 return stripXSS(value);
        return sanitizeXSS(value);
    }
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (value == null)
            return null;
        return sanitizeXSS(value);
    }
   public String sanitizeXSS(String value) {
		// Avoid null characters
		// value = value.replaceAll("", "");
		//System.err.println("XSSRequestWrapper called sanitizeXSS before ==========: "+value);	
		for (Pattern scriptPattern : patterns){
		value = scriptPattern.matcher(value).replaceAll("");
		}
		//<root> got affected in BL page -BLZatcaResponseValidation.jsp So it is commented 	
		//    value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		//	value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
		//value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		// Replace script in this common file so it is commented, 
		//	String desc_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
		//Commented below lines since it will have impact in CA and other functions
		//Start
		//   value = value.replaceAll("script", "");  
		//	value = value.replaceAll("alert", "");
		//	value = value.replaceAll("iframe", "");
		//	value = value.replaceAll("style", "");
		//	value = value.replaceAll("javascript", "");
		//End

		//System.out.println("XSSRequestWrapper called sanitizeXSS after ==========: "+value);			
        return value;
    }

}


//@Override
	public void destroy() {
		System.out.println("XSSPreventionFilter: destroy()");
	}

	//@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		XSSFilterRequestWrapper wrapper = new XSSFilterRequestWrapper((HttpServletRequest)request);
		String requestURL = wrapper.getRequestURI();
		Connection con = null;
		

		HttpSession session;
		Properties p;
		String modifiedById;
		String modifiedAtWorkstation;
		try {
			session = wrapper.getSession(true);
			Boolean isUrlAccessAppl = (Boolean) session.getValue("isUrlAccessAppl");
			p = (java.util.Properties) session.getValue("jdbc");
			if(isUrlAccessAppl !=null && isUrlAccessAppl){
				con = ConnectionManager.getConnection(wrapper);
				modifiedById = (p !=null && p.getProperty("login_user")!=null)?p.getProperty("login_user"):"";
				modifiedAtWorkstation = (p !=null && p.getProperty("client_ip_address")!=null)?p.getProperty("client_ip_address"):"";
				insertUrl(wrapper, con, requestURL, modifiedById, modifiedAtWorkstation);
			} else if(isUrlAccessAppl==null) {
				con = ConnectionManager.getConnection(wrapper);
				isUrlAccessAppl = CommonBean.isSiteSpecific(con, "MP","AUDIT_URL_APPL");
				session.setAttribute("isUrlAccessAppl", isUrlAccessAppl);
			}
		} catch (Exception e) {
			e.printStackTrace() ;
		} finally{
			if(con != null)	ConnectionManager.returnConnection(con,wrapper);
		}
		HttpServletResponse httpRes = (HttpServletResponse) response;
        HttpServletResponseWrapper resWrapper = new HttpServletResponseWrapper(httpRes);
//        String[] imgType = {".gif",".bmp",".jpg",".png",".GIF",".BMP",".JPG",".PNG"};
//    	if(!Arrays.asList(imgType).contains(requestURL)){
//		System.out.println("---XSSPreventionFilter.java--------requestURL----->"+requestURL);
        //ML-BRU-SCF2292
        if(!requestURL.contains(".gif") && !requestURL.contains(".bmp") && !requestURL.contains(".jpg") && !requestURL.contains(".png") && !requestURL.contains(".jpeg")  
    			&& !requestURL.contains(".GIF") && !requestURL.contains(".BMP") && !requestURL.contains(".JPG") && !requestURL.contains(".PNG") && !requestURL.contains(".JPEG") 
				&& !requestURL.contains("eSM.SiteParameterServlet") && !requestURL.contains("eSM.ReportServiceServlet")  && !requestURL.contains("eMR.PatientFileServlet") 
				&& !requestURL.contains("report_options_frameset.jsp") && !requestURL.contains("rwservlet") && !requestURL.contains("report_process.jsp")) { //ML-MMOH-SCF-3041
        	resWrapper.addHeader("X-XSS-Protection", "1; mode=block");
        	resWrapper.addHeader("X-Content-Type-Options", "nosniff");
        }
		chain.doFilter(wrapper, response);
	}

	//@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("XSSPreventionFilter: init()");
	}
	
	public void insertUrl(XSSFilterRequestWrapper wrapper, Connection con, String requestURL,String modifiedById, String modifiedAtWorkstation){
		CallableStatement callstmt = null;
		try {
			if(con != null){
				String urlAccess = "{call SM_URL_ACCESS_INSRT (?,?,?)}";
				callstmt = con.prepareCall(urlAccess);
				callstmt.setString(1, requestURL);
				callstmt.setString(2, modifiedById);
				callstmt.setString(3, modifiedAtWorkstation);
				callstmt.execute();
			}
		} catch (Exception e) {
			e.printStackTrace() ;
		} finally {
			if(con != null)	ConnectionManager.returnConnection(con,wrapper);
		}
	}

}