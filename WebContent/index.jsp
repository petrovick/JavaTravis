<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<div id="row">
	<div class="col-sm-6">
		<div class="panel panel-success">
<div class="panel-heading">Vendas mensais</div>
<div class="panel-body">
				<div id="vendas" style="min-width: 200px; height: 200px; margin: 0 auto"></div>
			</div>
		</div>
	</div>
	<div class="col-sm-6">
		<div class="panel panel-success">
<div class="panel-heading">Compras mensais</div>
<div class="panel-body">
				<div id="movimentacao" style="min-width: 200px; height: 200px; margin: 0 auto"></div>
			</div>
		</div>
	</div>
</div>
<div id="row">
	<div class="col-sm-12">
		<div id="lista">
		</div>
		
	</div>
</div>