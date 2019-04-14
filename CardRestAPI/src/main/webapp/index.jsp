<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script src="resources/js/rest.js"></script>
<%@ page contentType="text/html; charset=UTF-8" %>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css" />
	
<script type="text/javascript">
	document.getElementById("defaultOpen").click();
</script>

<script type="text/javascript">
	function openTab(evt, action) {
		// Declare all variables
		var i, tabcontent, tablinks;

		// Get all elements with class="tabcontent" and hide them
		tabcontent = document.getElementsByClassName("tabcontent");
		for (i = 0; i < tabcontent.length; i++) {
			tabcontent[i].style.display = "none";
		}

		// Get all elements with class="tablinks" and remove the class "active"
		tablinks = document.getElementsByClassName("tablinks");
		for (i = 0; i < tablinks.length; i++) {
			tablinks[i].className = tablinks[i].className
					.replace(" active", "");
		}

		// Show the current tab, and add an "active" class to the button that opened the tab
		document.getElementById(action).style.display = "block";
		evt.currentTarget.className += " active";
	}
</script>
</head>
<body>
	<h2>Welcome to TIETO Assesment</h2>
	<div class="tab">
		<button class="tablinks" onclick="openTab(event, 'GetAllCards')">Get
			All Cards</button>
		<button class="tablinks" onclick="openTab(event, 'CreateCard')">Create
			Card</button>
		<button class="tablinks" onclick="openTab(event, 'UpdateCard')">Update
			Card</button>
		<button class="tablinks" onclick="openTab(event, 'DeleteCard')">Delete Card</button>
	</div>

	<!-- Tab content -->
	<div id="GetAllCards" class="tabcontent">
		<h3>GetAllCards</h3>
		<div style="padding-left: 50px; font-family: monospace;">
			</br> </br> <a href="${pageContext.request.contextPath}/rest/cards"><div
					style="color: saffron">View All Cards</div></a></br> </br>
		</div>
	</div>

	<div id="CreateCard" class="tabcontent">
		<h3>Create Card</h3>
		<form action="rest/cards/create" method="POST">
			<div style="width: 200px; text-align: left;">
				<div style="padding: 10px;">
					Card No: <input name="cardNo" />
				</div>
				<div style="padding: 10px;">
					Name: <input name="name" />
				</div>
				<div style="padding: 10px;">
					Type: <input name="type" />
				</div>
				<div style="padding: 10px; text-align: center">
					<input type="submit" value="Submit" />
				</div>
			</div>
		</form>
	</div>
	<div id="UpdateCard" class="tabcontent">
		<h3>Update Card</h3>
		<form id="updateForm">
			<div style="width: 200px; text-align: left;">
				<div style="padding: 10px;">
					Card No: <input name="cardNo" />
				</div>
				<div style="padding: 10px;">
					Name: <input name="name" />
				</div>
				<div style="padding: 10px;">
					Type: <input name="type" />
				</div>
				<div style="padding: 10px; text-align: center">
					<input type="submit" value="Submit" />
				</div>
			</div>
		</form>
	</div>
	<div id="DeleteCard" class="tabcontent">
		<h3>Delete Card</h3>
		<form id="deleteForm">
			Card No: <input name="cardNo" /> <input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>
