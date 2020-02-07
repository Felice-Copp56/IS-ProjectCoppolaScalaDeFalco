<%@ page import="java.util.*,model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="headerGestoreTavoli.jsp">
	<jsp:param value="" name="" />
</jsp:include>


<div id="layoutSidenav_content">
	<main>
	<div class="container-fluid">
		<h1 class="mt-4">Tavoli</h1>
		<%
			HashMap<TavoloBean, Integer> tavoli = (HashMap<TavoloBean, Integer>) request.getAttribute("map");
		%>
		<div class="row p-3 justify-content-center">
			<%
				for (Map.Entry<TavoloBean, Integer> entry : tavoli.entrySet()) {
					TavoloBean t = entry.getKey();
					int np = entry.getValue();
					if(np==1){
			%>
			<div class="col-sm-2 ml-2 mr-2">
				<div class="card ">
					<div class="card-header text-center bg-success text-light"><%=t.getNumTavolo() %></div>
					<div class="card-body text-success ">
						<a href="#"><img src="resources/images/tableV.png" class="card-img-top img-fluid" alt="table"></a>
					</div>
					<div class="card-footer bg-transparent border-success"><%=t.getNumPosti() %> posti</div>
				</div>
			</div>
			<%}else {%>
			<div class="col-sm-2 ml-2 mr-2">
				<div class="card ">
					<div class="card-header text-center bg-danger text-light"><%=t.getNumTavolo() %></div>
					<div class="card-body text-danger ">
						<a href="#"><img src="resources/images/tableX.png" class="card-img-top img-fluid" alt="table"></a>
					</div>
					<div class="card-footer bg-transparent border-danger"><%=t.getNumPosti() %> posti</div>
				</div>
			</div>
				<%
			}}
				%>
		</div>
	</main>

</div>

</div>


