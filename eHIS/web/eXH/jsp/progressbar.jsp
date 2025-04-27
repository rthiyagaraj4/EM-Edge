<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />		
    <meta charset="utf-8">
    <title>Using with progress bar</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="demonstration of some noty capabilities">

    <link href='http://fonts.googleapis.com/css?family=PT+Sans:regular,italic,bold,bolditalic&amp;subset=latin,latin-ext,cyrillic' rel='stylesheet' type='text/css'>
    <style type="text/css">
        html {
            height: 100%;
            width: 100%;
        }

        body {
            font-family: 'PT Sans', Tahoma, Arial, serif;
            line-height: 13px
        }
    </style>

	<!--

    <link rel="StyleSheet" type="text/css" href="buttons.css"></link>
	<link rel="StyleSheet" type="text/css" href="animate.css"></link>
	<link rel="StyleSheet" type="text/css" href="font-awesome/css/font-awesome.min.css"></link>

	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	
    <script type="text/javascript" src="notification_html.js"></script>	

	-->

	<link rel="StyleSheet" type="text/css" href="../../eXH/js/noty/buttons.css"></link>
<link rel="StyleSheet" type="text/css" href="../../eXH/js/noty/animate.css"></link>
<link rel="StyleSheet" type="text/css" href="../../eXH/js/noty/font-awesome/css/font-awesome.min.css"></link>

<script language="javascript" src="../../eXH/js/noty/jquery-1.8.0.js"></script>
<script type="text/javascript" src="../../eXH/js/noty/notification_html.js"></script>	
<script language="javascript" src="../../eXH/js/noty/packaged/jquery.noty.packaged.js"></script>

    <script type="text/javascript">

        function generate(type, text) {

		/*

           noty({  
			   "text":text,
			   "layout":"bottomRight",
			   "type":type,
			   "animateOpen":{  
				  "height":"toggle"
			   },
			   "animateClose":{  
				  "height":"toggle"
			   },
			   "speed":500,	
			   "timeout": 5000,
			   "closeButton":false,
			   "closeOnSelfClick":true,
			   "closeOnSelfOver":false,
			   "modal":false,
			   "onShow":"",
			   "onClose":""
			}); 

			*/

			var n = noty({
                text        : text,
                type        : type,
                dismissQueue: true,
                progressBar : true,
                timeout     : 5000,
                layout      : 'bottomRight',
                closeWith   : ['click'],
                theme       : 'relax',
                maxVisible  : 10,
                animation   : {
                    open: {height: 'toggle'},
					close: {height: 'toggle'},
                    easing: 'swing',
                    speed : 500
                }
            });

        }

        function generateAll() {
            generate('success', notification_html[0]); 
        }

        $(document).ready(function () {

            setTimeout(function () {
                generateAll();
            }, 500);

        });

    </script>

</head>
<body>

    <div class="container">
        <div id="customContainer"></div>
    </div>	
</body>
</html>

