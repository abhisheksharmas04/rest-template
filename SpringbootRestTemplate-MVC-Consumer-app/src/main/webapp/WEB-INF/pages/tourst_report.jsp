<%@ page isELIgnored="false"%>
<%@ taglib uri- "http://java.sun.com/jsp/jstl/core prefix="c" %>

<c:choose>
    <c:when test = "${!empty listEmps}"></c:when>
    <table>
        <tr><th>Tid</th><th>Tourist Name</th><th>Budget</th><th>package Type</th></tr>
    </table>
</c:choose>