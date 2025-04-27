<!DOCTYPE html>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<Script src="../../eMP/IRISMyKad/mykad-websocket-client-api.js" language="JavaScript"></Script>
<script src="../../eMP/IRISMyKad/jquery-3.2.1.min.js"></script>
<script src="../../eMP/IRISMyKad/IRISMyKad.js"></script>
<%@ page  contentType="text/html;charset=UTF-8" import= "java.sql.*,java.io.*, java.util.*, java.text.*,webbeans.eCommon.*,java.io.File,java.io.*,java.io.FileInputStream,java.io.FileOutputStream,webbeans.eCommon.*,com.ehis.util.*,java.util.HashMap, java.util.ArrayList" %>
 <%
 	request.setCharacterEncoding("UTF-8");
 String func_name = checkForNull(request.getParameter("func_name")); 
 %>
 <input name="func_name" id="func_name" id="func_name" type="hidden" value="<%=func_name%>">
	<div id="preloader" style="width: 100%; text-align: center;">
		<span id="InProgress"><br>MyKad Reading In Progress...<br></span>
		<img src="../../eCommon/images/LoadingCircle.gif" alt="" style="position: absolute; top: 40%;left: 40%;display: block;" />
	</div>
	<div id="confirm">
		<div class="message">This is a warning message.</div>
		<br>
		<button class="Ok">OK</button>    
		<button class="Cancel">Cancel</button>
	</div>
	<div id="fingerFail">
		<div class="message"></div>
		<br>
		<button class="Ok">OK</button> 
	</div>
	<div id="overwrite">
		<div class="message"></div>
		<br>
		<button class="Ok">OK</button> 
		<button class="Cancel">Cancel</button>
	</div>
	<style>
      #confirm {
         display: none;
         background-color: #F3F5F6;
         color: #000000;
         border: 1px solid #aaa;
         position: fixed;
         width: 320px;
         height: 130px;
         left: 30%;
		 font:150px;
         margin-left: -100px;
         padding: 10px 20px 10px;
         box-sizing: border-box;
         text-align: center;
      }
	   #fingerFail {
         display: none;
         background-color: #F3F5F6;
         color: #000000;
         border: 1px solid #aaa;
         position: fixed;
         width: 320px;
         height: 130px;
         left: 30%;
         margin-left: -100px;
         padding: 10px 20px 10px;
         box-sizing: border-box;
         text-align: center;
      }
	   #overwrite {
         display: none;
         background-color: #F3F5F6;
         color: #000000;
         border: 1px solid #aaa;
         position: fixed;
         width: 320px;
         height: 130px;
         left: 30%;
         margin-left: -100px;
         padding: 10px 20px 10px;
         box-sizing: border-box;
         text-align: center;
      }
      #confirm button {
     /*    background-color: #FFFFFF;*/
         display: inline-block;
      /*   border-radius: 12px;
         border: 4px solid #aaa;*/
         padding: 5px;
         text-align: center;
         width: 60px;
         cursor: pointer;
      }
      #confirm .message {
         text-align: left;
      }
 
</html>
<%!	
			private String checkForNull(String inputString)
			{
				return (inputString==null)	?	""	:	inputString;
			}
			public static String checkForNull(String inputString, String defaultValue)
			{
				return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
			}
		%>

