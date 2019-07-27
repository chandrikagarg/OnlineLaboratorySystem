<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Creating Fixed Header and Footer with CSS</title>
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
        width: 100%;
        position: fixed;        
        background:Turquoise;
        padding: 10px 0;
        color: #fff;
    }
    .fixed-header{
        top: 0;       
    }
    .fixed-footer{
        bottom: 0;
        left: 0;
    }    
    /* Some more styles to beutify this example */
    nav a{
        color:orange;
        text-decoration: none;
        padding: 7px 25px;
        display: inline-block;
    }
    .container p{
        line-height: 200px; /* Create scrollbar to test positioning */
    }
</style>
</head>
<body>
   
    <div class="fixed-footer">
        <div class="container" align="center">&copy;TJA178 Group 5</div>        
    </div>
</body>
</html>                            