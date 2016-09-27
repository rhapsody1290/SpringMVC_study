<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
	<h2>Done</h2>
    <form:form commandName="customer">
        <from:input path="name"/>
        <form:input path="age"/>
    </form:form>
</body>
</html>