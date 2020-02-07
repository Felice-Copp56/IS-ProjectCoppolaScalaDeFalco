<%@ page import="java.util.*,model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="headerTitolare.jsp">
	<jsp:param value="" name="" />
</jsp:include>


<div id="layoutSidenav_content">
	<main>
	<div class="container-fluid">
		<h1 class="mt-4">Cerca tavoli</h1>


		<div class="row">
			<div class="col">
				<form method="get" action="PrenotazioniXTitolare">
					<div class="w-100"></div>
					<div class="form-row m-6 mx-auto" method="get"
						onsubmit="/FiltraTavoli">
						<div class="form-group col-md-6 m-3" method="get"
							onsubmit="/FiltraTavoli">
							<label for="inputEmail4">1° Data</label> <input type="date"
								class="form-control" id="Data1" name="Data1" placeholder="Data"
								min="2020-01-01" max="2020-12-31">
						</div>
					</div>
					
					<div class="form-row m-6 mx-auto" method="get"
						onsubmit="/FiltraTavoli">
						<div class="form-group col-md-6 m-3" method="get"
							onsubmit="/FiltraTavoli">
							<label for="inputEmail4">2° Data</label> <input type="date"
								class="form-control" id="Data2" name="Data2" placeholder="Data"
								min="2020-01-01" max="2020-12-31">
						</div>
					</div>
					<div class="w-100"></div>
					<div class="row m-3">
						<div class="col justify-content-center mx-auto">
							<button type="submit"
								class="btn btn-primary justify-content-center">Cerca
								prenotazioni</button>
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
