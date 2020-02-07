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
		
		<div class="row p-3 justify-content-center">
			<%ArrayList<TavoloBean> ts = (ArrayList<TavoloBean>)request.getAttribute("tavoli");
			for(TavoloBean t:ts){%>
			<div class="col-sm-2 ml-2 mr-2">
				<div class="card ">
					<div class="card-header text-center bg-success text-light"><%=t.getNumTavolo() %></div>
					<div class="card-body text-success ">
						<a href="RimuoviTavolo?nt=<%=t.getNumTavolo()%>"><img src="resources/images/table.png" class="card-img-top img-fluid" alt="table"></a>
					</div>
					<div class="card-footer bg-transparent border-success"><%=t.getNumPosti() %> posti</div>
				</div>
			</div>
			<%} %>
		</div>
	</main>

</div>

</div>


