<%@ page import="java.util.*,model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="headerUtente.jsp">
	<jsp:param value="" name="" />
</jsp:include>


<div id="layoutSidenav_content">
	<main>
	<div class="container-fluid">
		<h1 class="mt-4">Tavoli disponibili</h1>
		<%ArrayList<TavoloBean> tavoli = (ArrayList<TavoloBean>)request.getAttribute("tavoli");%>
		<div class="row p-3 justify-content-center">
		<%for(TavoloBean t:tavoli){ 
		System.out.println(t);%>
			<div class="col-sm-2 ml-2 mr-2">
				<div class="card ">
					<div class="card-header text-center bg-success text-light"><%=t.getNumTavolo() %></div>
					<div class="card-body text-success ">
						<a href="#"><img src="resources/images/tableV.png" class="card-img-top img-fluid" alt="table"></a>
					</div>
				</div>
			</div>
			<%} %>

		</div>
	</div>
	</main>

</div>

</div>

<jsp:include page="footer.jsp">
	<jsp:param value="" name="" />
</jsp:include>
