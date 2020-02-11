<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
<html lang="en">
<head>
<title>ElTanqueWineBar</title>
<meta charset="utf-8">
<link rel="icon" href="src/images/logoicona.ico">
<link rel="shortcut icon" href="src/images/logoicona.ico">
<link rel="stylesheet" href="src/scss/style.css">
<link rel="stylesheet" href="src/scss/TMGPrototype2.css">
<script src="src/js/jquery.js"></script>
<script src="src/js/jquery-migrate-1.1.1.js"></script>
<script src="src/js/superfish.js"></script>
<script src="src/js/TMGPrototype2.js"></script>
<script src="src/js/jquery.equalheights.js"></script>
<script src="src/js/jquery.easing.1.3.js"></script>
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
<script>
$(window).load(function () {
    $('#TMGPrototype2').TMGPrototype2({});
});
</script>
<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<link rel="stylesheet" media="screen" href="css/ie.css">
<![endif]-->
</head>
<body class="page1">
<!-- Commento a caso per committare -->
<header>
  <div class="menu_block">
    <div class="container_12">
      
        <nav>
          <ul class="sf-menu">
            <li><a class="navbar-brand"
			href="file:///C:/Users/Computer/Desktop/startbootstrap-sb-admin-gh-pages/dist/index.html">EL
			TANQUE <i class="fas fa-glass-cheers"></i>
		</a></li>
            
            
          </ul>
        </nav>
        <div class="clear"></div>
      </div>
      <div class="clear"></div>
    </div>
</header>
<div id="TMGPrototype2">
  <h1><a href="."><img src="src/images/logo3.png" alt=""></a></h1>
  <ul class='sets'>
    <li data-setName="Cliente">
      <ul>
      
        <li data-srcPreview="src/images/red1.jpg">
          <div>
            <div class="content"> <img src="src/images/users.png" alt="">
            <form action="LoginServlet" method="POST">
              <ul>
                <li><span>Username: </span><input type=text name="textuser"></li>
                <li><span>Password: </span><input type=password name="textpass"></li>
              </ul>
               <div class="alright"><button type="submit" class="btn">Login</button></div>
            </form>
            </div>
          </div>
        </li>
          <li data-srcPreview="src/images/red1.jpg">
          <div>
            <div class="content"> <img src="src/images/register1.png" alt="">
            <form action="RegistrationServlet" method="POST">
              <ul>
                <li><span>Nome:</span><input type=text name="textnome" id="nomereg"></li>
                <li><span>Cognome:</span><input type=text name="textcognome" id="cogreg"></li>
                <li><span>Email: </span> <input type=email name="textemail" id="regmail"></li>
                <li><span>Username: </span><input type=text name="textuser" id = "reguser"></li>
                <li><span>Password: </span><input type=password name="textpass" id="regpass"></li>
              </ul>
                <div class="alright"><button type="submit" class="btn">Registrati</button></div>
                </form>
            </div>
          </div>
        </li>
    <ul class='sets'>
    <li data-setName="Sei dello staff?">
      <ul>
        <li data-srcPreview="src/images/white1.jpg">
          <div>
            <div class="content"> <img src="src/images/boss1.png" alt="">
            <form action="HomeTitolare" method="POST">
              <h3>Titolare</h3>
              <ul>
                <li><span>Codice titolare:</span> <input type="password" name="textitolare"></li>
              </ul>
                 <div class="alright"><button type="submit" class="btn">Login</button></div>
                </form>
            </div>
          </div>
          
        </li>
        <li data-srcPreview="src/images/white2.jpg">
          <div>
            <div class="content"> <img src="src/images/tavolo1.png" alt="">
            <form action="HomeGestoreTavoli" method="POST">
              <h3>Gestore Tavoli</h3>
              <ul>
                <li><span>Codice gestore:</span> <input type=password name=textgestore></li>
              </ul>
                 <div class="alright"><button type="submit" class="btn">Login</button></div>
                </form>
            </div>
          </div>
        </li>
        </ul>
      
        </li>
          </ul>
        </ul>
      </li>
    </ul>
    </div>
    <footer>
  <div class="container_12">
    <div class="grid_12">
      <div class="copy"> Copyright © ElTanque </div>
    </div>
  </div>
</footer>
</body>
</html>