package eCommon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
//import org.owasp.esapi.ESAPI;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponseWrapper;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.servlet.http.HttpServletResponse;

public final class XSSRequestWrapper extends HttpServletRequestWrapper {
	
	
	    private static Pattern[] patterns = new Pattern[]{
			 // Script fragments
            Pattern.compile("<script>", Pattern.CASE_INSENSITIVE),
			// Pattern.compile("<(no)?script[^>]*>.*?</(no)?script>", Pattern.CASE_INSENSITIVE),
			  Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
			// Style fragments
			  Pattern.compile("<style>(.+?)</style>", Pattern.CASE_INSENSITIVE),
            // Script fragments
            Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // src='...'
            Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
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
			Pattern.compile("(window\\.location|window\\.|\\.location|document\\.cookie|document\\.|alert\\(.*?\\)|window\\.open\\()*", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("<+\\s*\\w*\\s*(oncontrolselect|oncopy|oncut|ondataavailable|ondatasetchanged|ondatasetcomplete|ondblclick|ondeactivate|ondrag|ondragend|ondragenter|ondragleave|ondragover|ondragstart|ondrop|onerror=|onerroupdate|onfilterchange|onfinish|onfocus|onfocusin|onfocusout|onhelp|onkeydown|onkeypress|onkeyup|onlayoutcomplete|onload|onlosecapture|onmousedown|onmouseenter|onmouseleave|onmousemove|onmousout|onmouseover|onmouseup|onmousewheel|onmove|onmoveend|onmovestart|onabort|onactivate|onafterprint|onafterupdate|onbefore|onbeforeactivate|onbeforecopy|onbeforecut|onbeforedeactivate|onbeforeeditocus|onbeforepaste|onbeforeprint|onbeforeunload|onbeforeupdate|onblur|onbounce|oncellchange|onchange|onclick|oncontextmenu|onpaste|onpropertychange|onreadystatechange|onreset|onresize|onresizend|onresizestart|onrowenter|onrowexit|onrowsdelete|onrowsinserted|onscroll|onselect|onselectionchange|onselectstart|onstart|onstop|onsubmit|onunload)+\\s*=+", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL)
    };
	// StatusExposingServletResponse response1 = new StatusExposingServletResponse((HttpServletResponse));		
	
    public XSSRequestWrapper(HttpServletRequest servletRequest) {

        super(servletRequest);
		
    }
    public String[] getParameterValues(String parameter) {
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
     //     value = value.replaceAll("", "");
		//System.err.println("XSSRequestWrapper called sanitizeXSS before ==========: "+value);	
		 for (Pattern scriptPattern : patterns){
				value = scriptPattern.matcher(value).replaceAll("");
            }
       value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	//	value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
	//	value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("script", "");
		value = value.replaceAll("alert", "");
		value = value.replaceAll("iframe", "");
		value = value.replaceAll("style", "");
		value = value.replaceAll("javascript", "");

		//System.out.println("XSSRequestWrapper called sanitizeXSS after ==========: "+value);			
        return value;
    }
	 
/*	 private String stripXSS(String value) {
		 String returnVal="false";
        if (value != null) {
			System.out.println("RequestWrapper called stripXSS before ==========: "+value);		
            // NOTE: It's highly recommended to use the ESAPI library and uncomment the following line to
            // avoid encoded attacks.
            value = ESAPI.encoder().canonicalize(value);
System.out.println("RequestWrapper called stripXSS before =1=========: "+value);		
            // Avoid null characters
            value = value.replaceAll("\0", "");
			 Pattern p = Pattern.compile("");
			 Matcher matcher=p.matcher("");;
System.out.println("RequestWrapper called stripXSS before 2==========: "+value);		
            // Remove all sections that match a pattern
            for (Pattern scriptPattern : patterns) {
             //   value = scriptPattern.matcher(value).replaceAll("");
				  matcher = scriptPattern.matcher(value);
				  boolean matchFound = matcher.find();
				System.out.println(value+" : ============="+matchFound);
				if(matchFound==true)
					{
				//	response1.getStatus();
					 returnVal="true";
						  break;
						
					}
				
            }
			
        }
			System.out.println("RequestWrapper called stripXSS after ==========: "+value);		
        return returnVal;
    } */
}