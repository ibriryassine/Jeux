<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <link rel="stylesheet" href="resource/css/bootstrap.min.css">
   	<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
		<!-- Website CSS style -->
		<link rel="stylesheet" type="text/css" href="assets/css/main.css">
		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
<title>Snake</title>
</head>
<body>
	
	 <%-- L'inclusion dynamique de l'entete de la page : --%>
	<jsp:include page="header.jsp" />
	
	<br><br><br>
  <div class="container   ">
       <div class="panel panel-info  col-lg-9">
            <br>
             <div class="panel-heading"><h1>Inscription</h1></div>
             <div class="panel-body">
				<div class="row main " >
					 
					<div class="main-login main-center">
						<form class="form-horizontal  col-md-12" method="post" action="inscription">
						  <div class="form-group">
								<label for="email" class="cols-sm-2 control-label">Email</label>
								<div class="cols-sm-6">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
										<input type="text" class="form-control" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="100"  placeholder="Enter votre Email"/>
					            	</div>
								</div>
								<span class="erreur" style="color:red">${form.erreur['email']}</span>
							</div>
	
							<div class="form-group">
								<label for="username" class="cols-sm-2 control-label">Username</label>
								<div class="cols-sm-6">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
										<input type="text" class="form-control" id="nomutilisateur" name="nomutilisateur" value="<c:out value="${utilisateur.nomutilisateur}"/>" size="20" maxlength="20"  placeholder="Enter votre Username"/>
									</div>
								</div>
								<span class="erreur" style="color:red">${form.erreur['nomutilisateur']}</span>
							</div>
	
							<div class="form-group">
								<label for="password" class="cols-sm-2 control-label">Mot de passe </label>
								<div class="cols-sm-6">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
										<input type="password" class="form-control" id="motdepasse" name="motdepasse" value="${utilisateur.motDePasse}" size="20" maxlength="20"  placeholder="Enter votre mote de passe"/>
									</div>
								</div>
							    <span class="erreur" style="color:red">${form.erreur['motdepasse']}</span>
							</div>
	
							<div class="form-group">
								<label for="confirm" class="cols-sm-2 control-label">Confirmation du mot de passe</label>
								<div class="cols-sm-6">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
										<input type="password" class="form-control" id="confirmation" name="confirmation" value="${confirmation}" size="20" maxlength="20" placeholder="Confirmer votre mote de passe"/>
						            </div>
								</div>
								<span class="erreur" style="color:red">${form.erreur['confirmation']}</span>
							</div>
	                        <br>
							<div class="form-group ">
								<button type="submit" class="btn btn-primary btn-lg btn-block login-button"  >Créer un compte</button>
							
							</div>
						</form>
					</div>
				</div>
			</div>	
		</div>
	</div>
		
   
</body>
</html>