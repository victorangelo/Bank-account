<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core">

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Parse Transactions</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
<link rel="stylesheet" href="<c:url value='/css/style.css'/>" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="js/script.js"></script>
</head>
<body class="body_class">
	<div class="upper_div">
		<div>
			<spring:message code="lbl.about" text="About" />
			<br />
			<spring:message code="lbl.aboutText" text="Transactions Scanner." />
			<br /> <br /> <br /> <br />
		</div>
		<form:form id="submitForm" method="post" enctype="multipart/form-data" action="transacts">
			<div>
				<div>
						<input type="file" id="fileToUpload" name="file[]" webkitdirectory directory multiple />
						<button id="upload_btn"><spring:message code="lbl.startProcessing" text="Start Processing" /></button>
					<br/>
				</div>
				<div id="progressbar"></div>
			</div>
			<br/><br/>
			<div class="d_data">
					<spring:message code="lbl.transactVal" text="Transaction Value" />${uploadedTransactions.totalTransactions}
					&nbsp;
					<spring:message code="lbl.date" text="Date" />${uploadedTransactions.uploadedDate}
			</div>
		</form:form>
	</div>
</body>
</html>