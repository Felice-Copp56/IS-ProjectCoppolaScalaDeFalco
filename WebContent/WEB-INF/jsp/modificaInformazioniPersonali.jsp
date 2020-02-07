<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="headerUtente.jsp">
	<jsp:param value="" name="" />
</jsp:include>


		<!-- inizio content principale-->
		<div id="layoutSidenav_content">
		<form action="ModificaInfoPersonali" method="post" class="p-5">
				<h1>Modifica informazioni personali</h1>
				<div class="form-row mt-4">
					<div class="col-md-4 mb-3">
						<label for="validationServer01">Nome</label> <input type="text" name="nome"
							class="form-control " id="nome" placeholder="Nome"
							value="" required>
					</div>
					<div class="col-md-4 mb-3">
						<label for="validationServer02">Cognome</label> <input type="text" name="cognome"
							class="form-control " id="cognome"
							placeholder="Cognome" value="" required>
					</div>
				</div>
				<button class="btn btn-primary is-valid" type="submit">Modifica</button>

			</form>
		</div>
		<jsp:include page="footer.jsp">
	<jsp:param value="" name="" />
</jsp:include>