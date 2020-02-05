<%@ page import="java.util.*,model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="headerUtente.jsp">
	<jsp:param value="" name="" />
</jsp:include>


	<div id="layoutSidenav_content">
		<main>
		<div class="container-fluid">
			<h1 class="mt-4">Cerca tavoli</h1>


			<div class="row">
				<div class="col">
					<form>
	<div class="w-100"></div>
  <div class="form-row m-6 mx-auto">
  <div class="form-group col-md-6 m-3">
  <label for="inputEmail4">Data</label>
      <input type="date" class="form-control" id="inputEmail4" placeholder="Data" min="2020-01-01" max="2020-12-31">
  </div>
  </div>
  <div class="w-100"></div>
  <div class="form-row m-3">
    <div class="form-group col-md-3">
      <label for="inputEmail4">Fascia oraria</label>
      <select id="inputState" class="form-control">
        <option selected>Scegli...</option>
        <option>18:00/19:00</option>
        <option>19:00/20:00</option>
        <option>20:00/21:00</option>
      </select>
      </div>
    <div class="form-group col-md-3">
      <label for="inputPassword4">Numero persone</label>
      <input type="password" class="form-control" id="inputPassword4" placeholder="Numero persone">
    </div>
  </div>
  <div class="w-100"></div>
  <div class="row m-3">
  <div class="col justify-content-center mx-auto">
   <button type="submit" class="btn btn-primary justify-content-center">Cerca tavoli</button>
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
