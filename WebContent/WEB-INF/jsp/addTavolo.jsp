<%@ page import="java.util.*,model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="headerGestoreTavoli.jsp">
	<jsp:param value="" name="" />
</jsp:include>

<%
	String error = (String) request.getAttribute("ERRORMSG");
%>
<div id="layoutSidenav_content">
	<main>
	<div class="container-fluid">
	
		<h1 class="mt-4">Aggiungi tavolo</h1>
<%
				if (error != null) {
			%>

		<div class="row">
			
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
			<div class="col">
				<form method="get" action="AggiungiTavolo">
					<div class="w-100"></div>
					<div class="form-row m-6 mx-auto" method="get" onsubmit="">
						<div class="form-group col-md-6 m-3" method="get"
							onsubmit="/FiltraTavoli">

							<label for="inputEmail4">Numero</label> <input type="number"
								class="form-control" id="numeroT" name="numeroT"
								placeholder="# tavolo">
						</div>
					</div>
					<div class="w-100"></div>
					<div class="form-row m-3">
						<div class="form-group col-md-3">
							<label for="inputEmail4">Numero posti</label> <input
								type="number" class="form-control" id="numeroP" name="numeroP"
								placeholder="# posti" min="1">
						</div>
					</div>
					<div class="w-100"></div>
					<div class="row m-3">
						<div class="col justify-content-center mx-auto">
							<button type="submit"
								class="btn btn-primary justify-content-center">Aggiungi</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</main>

</div>

</div>

<jsp:include page="footer.jsp">
	<jsp:param value="" name="" />
</jsp:include>
