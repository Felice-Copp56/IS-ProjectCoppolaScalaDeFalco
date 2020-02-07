<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="headerUtente.jsp">
	<jsp:param value="" name="" />
</jsp:include>

	<!-- inserire sidebar e content-->
	<div id="layoutSidenav">
		<!--navbar di sinistra-->
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading text-light">Prenotazioni</div>
						<a class="nav-link" href="HomeCliente">
							<div class="sb-nav-link-icon">
								<i class="material-icons"> table_chart </i>
								<!-- <i class="fas fa-chart-area"></i> -->
							</div> Cerca tavoli
						</a> <a class="nav-link" href="ListaPrenotazioniUtente">
							<div class="sb-nav-link-icon">
								<i class="material-icons"> menu_book </i>
								<!-- <i class="fas fa-chart-area"></i> -->
							</div> Le mie prenotazioni
						</a>
						<div class="sb-sidenav-menu-heading text-light">Account</div>
						<a class="nav-link" href="StartModificaInfoPersonali">
							<div class="sb-nav-link-icon">
								<i class="material-icons text-light"> person </i>
							</div> Informazioni personali

						</a> <a class="nav-link " href="StartModificaDatiAccesso"
							data-toggle="collapse" data-target="#collapsePages"
							aria-expanded="false" aria-controls="collapsePages">
							<div class="sb-nav-link-icon">
								<i class="material-icons"> arrow_forward </i>
								<!-- <i class="fas fa-book-open"></i> -->
							</div> Dati di accesso

						</a> <a class="nav-link"
							href="LogoutServlet">
							<div class="sb-nav-link-icon">
								<i class="material-icons"> arrow_back </i>
								<!-- <i class="fas fa-chart-area"></i> -->
							</div> Esci
						</a> <a class="nav-link"
							href="file:///C:/Users/Computer/Desktop/startbootstrap-sb-admin-gh-pages/dist/charts.html">

						</a>

					</div>
				</div>

			</nav>
		</div>

		<!-- inizio content principale-->
		<div id="layoutSidenav_content">
		<form action="ModificaDatiAccesso" method="post">
			<form class="p-5">
				<h1>Modifica informazioni di accesso</h1>
				<div class="form-row mt-4">
					<div class="col-md-4 mb-3">
						<label for="validationServer01">Username</label> <input
							type="text" class="form-control " name="username" id="username"
							placeholder="Username" value="" required>
					</div>
					<div class="col-md-4 mb-3">
						<label for="validationServer02">Email</label> <input type="email" name="email"
							class="form-control " id="email" placeholder="Email"
							value="" required>
					</div>
				</div>
				<div class="form-row mt-4">
					<div class="col-md-4 mb-3">
						<label for="validationServer02">Password</label> <input
							type="password" class="form-control " name="password" id="password" 
							placeholder="Password" value="" required>
					</div>

				</div>
				<button class="btn btn-primary is-valid" type="submit">Modifica</button>
				</form>
			</form>
		</div>
		<jsp:include page="footer.jsp">
	<jsp:param value="" name="" />
</jsp:include>
		