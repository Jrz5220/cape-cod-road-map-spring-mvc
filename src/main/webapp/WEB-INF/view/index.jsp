<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Cape Cod Road Map</title>
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Lato&family=Zen+Antique&display=swap" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<script defer src="https://kit.fontawesome.com/550ddecd5b.js" crossorigin="anonymous"></script>
		<script defer src="js/main.js"></script>
	</head>
	<body>
		<nav class="primary-navbar">
			<div class="navbar-mobile-layout">
				<div class="brand title">
					<i class="fas fa-anchor md-text"></i>
					<span class="cape-cod md-text">CapeCod</span>
				</div>
				<div class="toggle-button-container">
					<button class="toggle-button md-title" type="button" name="toggle-button" aria-expanded="false" aria-label="Toggle navigation">
						<i class="fas fa-bars"></i>
					</button>
				</div>
			</div>
			<div class="navbar-links">
				<ul class="navbar-links-list">
					<li class="nav-item">
						<a class="nav-item-content md-text" href="#set-route">Get Directions</a>
					</li>
					<li class="nav-item">
						<button class="nav-item-content nav-dropdown-button md-text" type="button" name="button">
							Towns <i class="fas fa-chevron-down sm-text"></i>
						</button>
						<ul class="nav-item-dropdown-list">
							<li><a class="dropdown-item-link" href="#">Provincetown</a></li>
							<li><a class="dropdown-item-link" href="#">Truro</a></li>
							<li><a class="dropdown-item-link" href="#">Orleans</a></li>
							<li><a class="dropdown-item-link" href="#">Chatham</a></li>
							<li><a class="dropdown-item-link" href="#">Barnstable</a></li>
							<li><a class="dropdown-item-link" href="#">Hyannis</a></li>
							<li><a class="dropdown-item-link" href="#">Sandwich</a></li>
							<li><a class="dropdown-item-link" href="#">Falmouth</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</nav>
		
		<header class="primary-header">
			<picture class="hero-picture">
				<source srcset="images/cape-cod-sailboat.jpg" media="(min-width: 700px)" type="image/jpeg">
				<img src="images/cape-cod-sailboat-portrait.jpg" alt="Sailboat in Cape Cod">
			</picture>
			<div class="header-container">
				<section class="description">
					<h1 class="description-header title lg-title">Real Time Directions for Cape Cod</h1>
					<hr class="text-break">
					<p class="md-text">
						Calculate directions for a driving route that takes you through popular towns in Cape Cod.
						Only directions for towns within Cape Cod are available.
					</p>
				</section>
			</div>
		</header>
		
		<section class="main-content" role="main">
			<c:if test="${result == true }">
				<div class="view-result md-text floating">
					<a class="view-result-link" href="#directions">
						<span>Results Below</span>
						<i class="fas fa-arrow-circle-down"></i>
					</a>
				</div>
			</c:if>	
			<section class="main-sub-section">
				<div class="calculate-directions">
					<section class="road-map">
						<h2 class="title md-title"><span class="underline-title">Road Map</span></h2>
						<picture>
							<img class="road-map-img" src="images/cape-cod-road-map.jpg" alt="Cape Cod Road Map">
						</picture>
					</section>
					<section id="set-route" class="travel-options">
						<h2 class="title md-title"><span class="underline-title">Select a Route</span></h2>
						<form id="towns" action="${pageContext.request.contextPath}/getDirections" method="get">
							<div class="select-list-container">
								<label class="select-town-label lg-text bold-text" for="origin">Starting Point</label>
								<div class="custom-select-list">
									<select id="destination" class="towns-list md-text" name="origin-town" form="towns" required>
										<option value="provincetown" selected>Provincetown</option>
										<option value="truro">Truro</option>
										<option value="orleans">Orleans</option>
										<option value="chatham">Chatham</option>
										<option value="barnstable">Barnstable</option>
										<option value="hyannis">Hyannis</option>
										<option value="sandwich">Sandwich</option>
										<option value="falmouth">Falmouth</option>
									</select>
									<span class="custom-arrow md-text"><i class="fas fa-sort-down"></i></span>
								</div>
							</div>
							<div class="select-list-container">
								<label class="select-town-label lg-text bold-text" for="destination">Destination</label>
								<div class="custom-select-list">
									<select id="destination" class="towns-list md-text" name="destination-town" form="towns" required>
										<option value="provincetown">Provincetown</option>
										<option value="truro">Truro</option>
		 								<option value="orleans">Orleans</option>
										<option value="chatham">Chatham</option>
										<option value="barnstable">Barnstable</option>
										<option value="hyannis">Hyannis</option>
										<option value="sandwich">Sandwich</option>
										<option value="falmouth" selected>Falmouth</option>
									</select>
									<span class="custom-arrow md-text"><i class="fas fa-sort-down"></i></span>
								</div>
							</div>
							<button type="submit" class="submit-btn lg-text" name="submit-btn"><i class="fas fa-directions"></i> Directions</button>
						</form>
					</section>
				</div>
				<div class="calculate-directions-desc">
					<div class="directions-desc-icons">
						<i class="fas fa-wind fa-icon"></i>
						<i class="fas fa-car-side fa-icon"></i>
					</div>
					<p class="md-text">
						The directions will take you through towns connecting the starting point and final destination.
						If multiple routes to your destination exist, the route with the shortest distance will be used.
						The shortest distance is calculated using the numbers in the road map.
					</p>
				</div>
			</section>
			<c:if test="${result == true}">
				<section id="directions" class="direction-result main-sub-section">
					<h2 class="title md-title result-title"><span class="underline-title">${directionTitle}</span></h2>
					<div class="result-stats md-text">
						<div class="travel-time">
							Travel Time: <span class="bold-text">${tripDuration} minutes</span>
						</div>
						<div class="travel-distance">
							Distance: <span class="bold-text">${tripDistance} miles</span>
						</div>
					</div>
					<ul class="instructions md-text">
						<c:forEach var="step" items="${directions}">
							<li class="step">${step}</li>
						</c:forEach>
					</ul>
				</section>
			</c:if>
			<section id="town-information" class="main-sub-section">
				<div class="accordion">
					<div class="accordion-item">
						<h2 class="accordion-item-header title md-title">
							<button class="accordion-item-button md-text" type="button" name="button">
								Town Information
								<span class="arrow"><i class="fas fa-chevron-down"></i></span>
							</button>
						</h2>
						<div class="accordion-item-body">
							<div class="accordion-item-body-content grid-container">
								<div class="linkbox grid-item provincetown">
									<div class="box-cover"></div>
									<div class="linkbox-content">
										<h3 class="title sm-title linkbox-title"><span>Provincetown</span></h3>
										<a class="town-info-link sm-text" href="#town-information">
					                      Get information
					                      <i class="fas fa-arrow-circle-right"></i>
					                    </a>
									</div>
								</div>
								<div class="linkbox grid-item truro">
									<div class="box-cover"></div>
									<div class="linkbox-content">
										<h3 class="title sm-title linkbox-title"><span>Truro</span></h3>
										<a class="town-info-link sm-text" href="#town-information">
					                      Get information
					                      <i class="fas fa-arrow-circle-right"></i>
					                    </a>
									</div>
								</div>
								<div class="linkbox grid-item orleans">
									<div class="box-cover"></div>
									<div class="linkbox-content">
										<h3 class="title sm-title linkbox-title"><span>Orleans</span></h3>
										<a class="town-info-link sm-text" href="#town-information">
					                      Get information
					                      <i class="fas fa-arrow-circle-right"></i>
					                    </a>
									</div>
								</div>
								<div class="linkbox grid-item chatham">
									<div class="box-cover"></div>
									<div class="linkbox-content">
										<h3 class="title sm-title linkbox-title"><span>Chatham</span></h3>
										<a class="town-info-link sm-text" href="#town-information">
					                      Get information
					                      <i class="fas fa-arrow-circle-right"></i>
					                    </a>
									</div>
								</div>
								<div class="linkbox grid-item barnstable">
									<div class="box-cover"></div>
									<div class="linkbox-content">
										<h3 class="title sm-title linkbox-title"><span>Barnstable</span></h3>
										<a class="town-info-link sm-text" href="#town-information">
					                      Get information
					                      <i class="fas fa-arrow-circle-right"></i>
					                    </a>
									</div>
								</div>
								<div class="linkbox grid-item hyannis">
									<div class="box-cover"></div>
									<div class="linkbox-content">
										<h3 class="title sm-title linkbox-title"><span>Hyannis</span></h3>
										<a class="town-info-link sm-text" href="#town-information">
					                      Get information
					                      <i class="fas fa-arrow-circle-right"></i>
					                    </a>
									</div>
								</div>
								<div class="linkbox grid-item sandwich">
									<div class="box-cover"></div>
									<div class="linkbox-content">
										<h3 class="title sm-title linkbox-title"><span>Sandwich</span></h3>
										<a class="town-info-link sm-text" href="#town-information">
					                      Get information
					                      <i class="fas fa-arrow-circle-right"></i>
					                    </a>
									</div>
								</div>
								<div class="linkbox grid-item falmouth">
									<div class="box-cover"></div>
									<div class="linkbox-content">
										<h3 class="title sm-title linkbox-title"><span>Falmouth</span></h3>
										<a class="town-info-link sm-text" href="#town-information">
					                      Get information
					                      <i class="fas fa-arrow-circle-right"></i>
					                    </a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</section>	<!-- end main-content -->
		
		<footer>
			<div class="footer-content">
				<div class="brand title">
					<a href="#">
						<i class="fas fa-anchor md-text"></i>
						<span class="cape-cod md-text">CapeCod</span>
					</a>
				</div>
				<div class="footer-flexbox">
					<div class="col-1">
						<h3 class="title footer-title">About</h3>
						<div class="about">
							<ul class="footer-list about-links-list sm-text">
								<li><a class="about-link footer-link" href="#">About us</a></li>
								<li><a class="about-link directions-api-link footer-link" href="https://developers.google.com/maps/documentation/directions/overview" target="_blank">Google Maps Directions API</a></li>
							</ul>
						</div>
					</div>
					<div class="col-2">
						<h3 class="title footer-title">Legal</h3>
						<div class="legal">
							<ul class="footer-list legal-links-list sm-text">
								<li><a class="legal-link footer-link" href="#">Terms of Use</a></li>
								<li><a class="legal-link footer-link" href="#">Privacy Policy</a></li>
								<li>Icons made by <a class="footer-link" href="https://www.freepik.com" title="Freepik">Freepik</a> from <a class="footer-link" href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="social">
					<ul class="footer-list social-links-list md-text">
	            		<li><a class="social-link github" href="https://github.com/Jrz5220?tab=repositories" target="_blank"><i class="fab fa-github"></i></a></li>
	            		<li><a class="social-link" href="https://jrz5220.github.io/felixlazo/contact.html" target="_blank"><i class="fas fa-envelope"></i></a></li>
	            		<li><a class="social-link youtube" href="#" target="_self"><i class="fab fa-youtube"></i></a></li>
	            		<li><a class="social-link google" href="#" target="_self"><i class="fab fa-google"></i></a></li>
					</ul>
				</div>
			</div>
		</footer>
	</body>
</html>