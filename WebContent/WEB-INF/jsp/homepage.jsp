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
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<script src="src/js/jquery.js"></script>
<script src="src/js/jquery-migrate-1.1.1.js"></script>
<script src="src/js/superfish.js"></script>
<script src="src/js/TMGPrototype2.js"></script>
<script src="src/js/jquery.equalheights.js"></script>
<script src="src/js/jquery.easing.1.3.js"></script>

<script src="https://kit.fontawesome.com/812a03be35.js"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<script>
	$(window).load(function() {
		$('#TMGPrototype2').TMGPrototype2({});
	});
</script>
<script>
	$('.page1').ready(function() {
		let searchParams = new URLSearchParams(window.location.search);
		if (searchParams.has('ERRORMSG')) {
			alert(searchParams.get('ERRORMSG'));
		}
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
					<%
						String ERRORMSG = (String) request.getAttribute("ERRORMSG");//
					
					%>
					<ul class="sf-menu">
						<li class="current"><a href=".">EL TANQUE <i
								class="fas fa-wine-glass-alt"></i>
						</a></li>
					</ul>
				</nav>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
		<%
			if (ERRORMSG != null) {
		%>
		<div class="row ">
			<div
				class="col p-1 ml-4 mr-4 alert alert-danger alert-dismissable float-left "
				style="background-color: #b71540 !important; color: white"
				role="alert">
				<h5 class="alert-heading">
					<%=ERRORMSG%>
				</h5>

				<hr>
				<h6>
					<a data-dismiss="alert" class="float-right">Riprova</a>
				</h6>

			</div>
		</div>
		<div class="toast" role="alert" aria-live="polite" aria-atomic="true"
			data-delay="10000">
			<div role="alert" aria-live="assertive" aria-atomic="true">...</div>
		</div>
		<%
			}
		%>
	</header>
	<div id="TMGPrototype2">
		<h1>
			<a href="."><img src="src/images/logo3.png" alt=""></a>
		</h1>
		<ul class='sets'>
			<li data-setName="Cliente">
				<ul>

					<li data-srcPreview="src/images/red1.jpg">
						<div>
							<div class="content">
								<img src="src/images/users.png" alt="">
								<form action="LoginServlet" method="POST">
									<ul>
										<li><span>Username: </span><input type=text
											name="textuser"></li>
										<li><span>Password: </span><input type=password
											name="textpass"></li>
									</ul>
									<div class="alright">
										<button type="submit" class="btn btn-danger">Login</button>
									</div>
								</form>
							</div>
						</div>
					</li>
					<li data-srcPreview="src/images/red1.jpg">
						<div>
							<div class="content">
								<img src="src/images/register1.png" alt="">
								<form action="RegistrationServlet" method="POST">
									<ul>
										<li><span>Nome:</span><input type=text name="textnome"
											id="nomereg"></li>
										<li><span>Cognome:</span><input type=text
											name="textcognome" id="cogreg"></li>
										<li><span>Email: </span> <input type=text
											name="textemail" id="regmail"></li>
										<li><span>Username: </span><input type=text
											name="textuser" id="reguser"></li>
										<li><span>Password: </span><input type=password
											name="textpass" id="regpass"></li>
									</ul>
									<div class="alright">
										<button type="submit" class="btn btn-danger">Registrati</button>
									</div>
								</form>
							</div>
						</div>
					</li>
					<ul class='sets'>
						<li data-setName="Sei dello staff?">
							<ul>
								<li data-srcPreview="src/images/white1.jpg">
									<div>
										<div class="content">
											<img src="src/images/boss1.png" alt="">
											<form action="HomeTitolare" method="POST">
												<h3>Titolare</h3>
												<ul>
													<li><span>Codice titolare:</span> <input
														type="password" name="textitolare"></li>
												</ul>
												<div class="alright">
													<button type="submit" class="btn btn-danger">Login</button>
												</div>
											</form>
										</div>
									</div>

								</li>
								<li data-srcPreview="src/images/white2.jpg">
									<div>
										<div class="content">
											<img src="src/images/tavolo1.png" alt="">
											<form action="HomeGestoreTavoli" method="POST">
												<h3>Gestore Tavoli</h3>
												<ul>
													<li><span>Codice gestore:</span> <input type=password
														name=textgestore></li>
												</ul>
												<div class="alright">
													<button type="submit" class="btn btn-danger">Login</button>
												</div>
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
				<div class="copy">Copyright © ElTanque</div>
			</div>
		</div>
	</footer>
</body>
</html>

