<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="headerUtente.jsp">
	<jsp:param value="" name="" />
</jsp:include>

	<%
	String nome = (String)request.getSession().getAttribute("nome");
	String cognome = (String)request.getSession().getAttribute("cognome");
	String error = (String) request.getAttribute("ERRORMSG");%>
		<!-- inizio content principale-->
		<div id="layoutSidenav_content">
		<form action="ModificaInfoPersonali" method="post" class="p-5">
				<h1>Modifica informazioni personali</h1>
				<%
				if (error != null) {
			%>
				<div class="col-12">
					
				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">
					<strong>ERRORE  </strong> <%=error%>
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</div>
			<%
				}
			%>
				<div class="form-row mt-4">
					<div class="col-md-4 mb-3">
						<label for="validationServer01">Nome</label> <input type="text" name="nome"
							class="form-control " id="nome" placeholder="Nome"
							 value="<%=nome %>">
					</div>
					<div class="col-md-4 mb-3">
						<label for="validationServer02">Cognome</label> <input type="text" name="cognome"
							class="form-control " id="cognome"
							placeholder="Cognome" value="<%=cognome %>" >
					</div>
				</div>
				<button class="btn btn-primary is-valid" type="submit">Modifica</button>

			</form>
		</div>
		<jsp:include page="footer.jsp">
	<jsp:param value="" name="" />
</jsp:include>