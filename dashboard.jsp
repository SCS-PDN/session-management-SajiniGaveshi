src/main/webapp/dashboard.jsp

<!-- Add this at the TOP of dashboard.jsp (below <body>) -->
<div style="background: #f0f0f0; padding: 10px; margin-bottom: 20px;">
    <a href="dashboard" style="margin-right: 15px;">Dashboard</a>
    <a href="logout" style="color: red;">Logout</a>
</div>

<h2>Available Courses</h2>
<!-- Rest of your existing code -->

<h2>Available Courses</h2>
<table>
    <c:forEach items="${courses}" var="course">
        <tr>
            <td>${course.id}</td>
            <td>${course.name}</td>
            <td>${course.instructor}</td>
            <td>
                <!-- Add Enroll link with URL Rewriting -->
                <a href="enroll?courseId=${course.id}">Enroll</a>
            </td>
        </tr>
    </c:forEach>
</table>

<!-- Display enrolled courses -->
<c:if test="${not empty enrolledCourses}">
    <h2>Your Enrolled Courses</h2>
    <ul>
        <c:forEach items="${enrolledCourses}" var="course">
            <li>${course.name} (${course.id})</li>
        </c:forEach>
    </ul>
</c:if>
