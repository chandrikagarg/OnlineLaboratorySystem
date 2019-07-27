<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Footer with CSS</title>
<style type="text/css">
    /* Add some padding on document's body to prevent the content
    to go underneath the header and footer */
    body{        
        padding-top: 60px;
        padding-bottom: 40px;
    }
    .container{
        width: 80%;
        margin: 0 auto; /* Center the DIV horizontally */
    }
    .fixed-header, .fixed-footer{
        width: 350%;
        position: fixed;        
        background: red;
        padding: 20px;
        color:#fff;
    }
    .fixed-header{
        top: 0;
        left:0;
        width:300px;
    }
    .fixed-footer{
        bottom: 0;
        
    }    
    /* Some more styles to beutify this example */
    nav a{
        color: orange;
        text-decoration: center;
        padding: 7px 25px;
        display: inline-white;
    }
    .container p{
        line-height: 200px; /* Create scrollbar to test positioning */
    }
</style>
</head>
<body>
    <div class="fixed-header">
       
           
        <div class="container" align="center">WELCOME TO LABORATORY SERVICES</div>        
    </div>
        </div>
    
      
    
</body>
</html>                            