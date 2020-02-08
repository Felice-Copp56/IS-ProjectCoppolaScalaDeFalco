<%@ page import="java.util.*,model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="headerGestoreTavoli.jsp">
	<jsp:param value="" name="" />
</jsp:include>


<div id="layoutSidenav_content">
	<main>
	<div class="container-fluid">
		<h1 class="mt-4">Cerca tavoli</h1>


		<div class="row">
			<div class="col">
				<form method="get" action="FiltraTavoliXGT">
					<div class="w-100"></div>
					<div class="form-row m-6 mx-auto" method="get"
						onsubmit="/FiltraTavoli">
						<div class="form-group col-md-6 m-3" method="get"
							onsubmit="/FiltraTavoli">
							<label for="inputEmail4">Data</label> <input type="date"
								class="form-control" id="Data" name="Data" placeholder="Data"
								min="2020-01-01" max="2020-12-31">
						</div>
					</div>
					<div class="w-100"></div>
					<div class="form-row m-3">
						<div class="form-group col-md-3">
							<label for="inputEmail4">Fascia oraria</label> <select
								id="fasciaOraria" name="fasciaOraria" class="form-control">
								<option selected>Scegli...</option>
								<option>18:00/19:00</option>
								<option>19:00/20:00</option>
								<option>20:00/21:00</option>
								<option>21:00/22:00</option>
								<option>22:00/23:00</option>
								<option>23:00/24:00</option>
							</select>
						</div>
					</div>
					<div class="w-100"></div>
					<div class="row m-3">
						<div class="col justify-content-center mx-auto">
							<button type="submit"
								class="btn btn-primary justify-content-center">Cerca
								tavoli</button>
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
