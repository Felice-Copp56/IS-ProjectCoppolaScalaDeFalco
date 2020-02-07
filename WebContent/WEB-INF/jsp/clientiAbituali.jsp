<%@ page import="java.util.*,model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="headerTitolare.jsp">
	<jsp:param value="" name="" />
</jsp:include>

<div id="layoutSidenav_content">
	<div class="container-fluid">
		<h1 class="mt-4">Clienti abituali</h1>
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
											<div id="dataTable_wrapper"
												class="dataTables_wrapper dt-bootstrap4 no-footer">
												<div class="row p-4">
													<div class="col-sm-12">
														<table class="table">
															<thead>
																<tr>
																	<th scope="col">Nome</th>
																	<th scope="col">Cognome</th>
																	<th scope="col">Username</th>
																</tr>
															</thead>
															<tbody>
																<%
																	ArrayList<ClienteBean> clientiA = (ArrayList<ClienteBean>) request.getAttribute("clientiA");
																	for (ClienteBean c : clientiA) {
																%>
																<tr>
																	<td><%=c.getNome()%></td>
																	<td><%=c.getCognome()%></td>
																	<td><%=c.getUsername()%></td>
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