<%@ page import="java.util.*,model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="headerTitolare.jsp">
	<jsp:param value="" name="" />
</jsp:include>

<div id="layoutSidenav_content">
	<div class="container-fluid">
		<h1 class="mt-4">Tavoli più gettonati</h1>
		<div class="card mb-4">

			<div class="card-body">
				<div class="table-responsive">
					<div id="dataTable_wrapper"
						class="dataTables_wrapper dt-bootstrap4">
						<div class="row">
							<div class="col-sm-12">
								<div id="dataTable_wrapper"
									class="dataTables_wrapper dt-bootstrap4">
									<div class="row">
										<div class="col-sm-12">


											<div id="dataTable_wrapper p-4"
												class="dataTables_wrapper dt-bootstrap4 no-footer">
												<div class="row p-4">
													<div class="col-sm-12">
													<table class="table p-4">
															<thead>
																<tr>
																	<th scope="col">Numero</th>
																	<th scope="col">Numero posti</th>
																	<th scope="col">Numero prenotazioni</th>
																</tr>
															</thead>
															<tbody>
																<%
																HashMap<TavoloBean, Integer> tavoli = (HashMap<TavoloBean, Integer>)request.getAttribute("tavoli");
																for (Map.Entry<TavoloBean, Integer> entry : tavoli.entrySet()) {
																	TavoloBean t = entry.getKey();
																	int np = entry.getValue();%>
																<tr>
																	<td class="sorting_1"><%=t.getNumTavolo() %></td>
																	<td><%=t.getNumPosti()%></td>
																	<td><%=np %></td>
																</tr>
																<%
																	}
																%>
															</tbody>
														</table>
														
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp">
	<jsp:param value="" name="" />
</jsp:include>